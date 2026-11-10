package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader$OnLoadCompleteListener;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
    public class LoaderInfo extends MutableLiveData implements OnLoadCompleteListener {
        private final Bundle mArgs;
        private final int mId;
        private LifecycleOwner mLifecycleOwner;
        private final Loader mLoader;
        private LoaderObserver mObserver;
        private Loader mPriorLoader;

        LoaderInfo(int arg1, Bundle arg2, Loader arg3, Loader arg4) {
            super();
            this.mId = arg1;
            this.mArgs = arg2;
            this.mLoader = arg3;
            this.mPriorLoader = arg4;
            arg3.registerListener(arg1, ((OnLoadCompleteListener)this));
        }

        Loader destroy(boolean arg3) {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }

            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver v0 = this.mObserver;
            if(v0 != null) {
                this.removeObserver(((Observer)v0));
                if(arg3) {
                    v0.reset();
                }
            }

            this.mLoader.unregisterListener(((OnLoadCompleteListener)this));
            if(v0 != null && !v0.hasDeliveredData() || (arg3)) {
                this.mLoader.reset();
                return this.mPriorLoader;
            }

            return this.mLoader;
        }

        public void dump(String arg4, FileDescriptor arg5, PrintWriter arg6, String[] arg7) {
            arg6.print(arg4);
            arg6.print("mId=");
            arg6.print(this.mId);
            arg6.print(" mArgs=");
            arg6.println(this.mArgs);
            arg6.print(arg4);
            arg6.print("mLoader=");
            arg6.println(this.mLoader);
            String v2 = "  ";
            this.mLoader.dump(arg4 + v2, arg5, arg6, arg7);
            if(this.mObserver != null) {
                arg6.print(arg4);
                arg6.print("mCallbacks=");
                arg6.println(this.mObserver);
                this.mObserver.dump(arg4 + v2, arg6);
            }

            arg6.print(arg4);
            arg6.print("mData=");
            arg6.println(this.getLoader().dataToString(this.getValue()));
            arg6.print(arg4);
            arg6.print("mStarted=");
            arg6.println(this.hasActiveObservers());
        }

        Loader getLoader() {
            return this.mLoader;
        }

        boolean isCallbackWaitingForData() {
            if(!this.hasActiveObservers()) {
                return 0;
            }

            LoaderObserver v2 = this.mObserver;
            if(v2 != null && !v2.hasDeliveredData()) {
                return 1;
            }

            return 0;
        }

        void markForRedelivery() {
            LifecycleOwner v0 = this.mLifecycleOwner;
            LoaderObserver v1 = this.mObserver;
            if(v0 != null && v1 != null) {
                super.removeObserver(((Observer)v1));
                this.observe(v0, ((Observer)v1));
            }
        }

        protected void onActive() {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Starting: " + this);
            }

            this.mLoader.startLoading();
        }

        protected void onInactive() {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }

            this.mLoader.stopLoading();
        }

        public void onLoadComplete(Loader arg3, Object arg4) {
            String v0 = "LoaderManager";
            if(LoaderManagerImpl.DEBUG) {
                Log.v(v0, "onLoadComplete: " + this);
            }

            if(Looper.myLooper() == Looper.getMainLooper()) {
                this.setValue(arg4);
                return;
            }

            if(LoaderManagerImpl.DEBUG) {
                Log.w(v0, "onLoadComplete was incorrectly called on a background thread");
            }

            this.postValue(arg4);
        }

        public void removeObserver(Observer arg1) {
            super.removeObserver(arg1);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        Loader setCallback(LifecycleOwner arg3, LoaderCallbacks arg4) {
            LoaderObserver v0 = new LoaderObserver(this.mLoader, arg4);
            this.observe(arg3, ((Observer)v0));
            LoaderObserver v4 = this.mObserver;
            if(v4 != null) {
                this.removeObserver(((Observer)v4));
            }

            this.mLifecycleOwner = arg3;
            this.mObserver = v0;
            return this.mLoader;
        }

        public void setValue(Object arg1) {
            super.setValue(arg1);
            Loader v1 = this.mPriorLoader;
            if(v1 != null) {
                v1.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder(0x40);
            v0.append("LoaderInfo{");
            v0.append(Integer.toHexString(System.identityHashCode(this)));
            v0.append(" #");
            v0.append(this.mId);
            v0.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, v0);
            v0.append("}}");
            return v0.toString();
        }
    }

    class LoaderObserver implements Observer {
        private final LoaderCallbacks mCallback;
        private boolean mDeliveredData;
        private final Loader mLoader;

        LoaderObserver(Loader arg2, LoaderCallbacks arg3) {
            super();
            this.mDeliveredData = false;
            this.mLoader = arg2;
            this.mCallback = arg3;
        }

        public void dump(String arg1, PrintWriter arg2) {
            arg2.print(arg1);
            arg2.print("mDeliveredData=");
            arg2.println(this.mDeliveredData);
        }

        boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        public void onChanged(Object arg3) {
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(arg3));
            }

            this.mCallback.onLoadFinished(this.mLoader, arg3);
            this.mDeliveredData = true;
        }

        void reset() {
            if(this.mDeliveredData) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Resetting: " + this.mLoader);
                }

                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    class LoaderViewModel extends ViewModel {
        final class androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1 implements Factory {
            androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1() {
                super();
            }

            public ViewModel create(Class arg1) {
                return new LoaderViewModel();
            }
        }

        private static final Factory FACTORY;
        private boolean mCreatingLoader;
        private SparseArrayCompat mLoaders;

        static {
            LoaderViewModel.FACTORY = new androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1();
        }

        LoaderViewModel() {
            super();
            this.mLoaders = new SparseArrayCompat();
            this.mCreatingLoader = false;
        }

        public void dump(String arg5, FileDescriptor arg6, PrintWriter arg7, String[] arg8) {
            if(this.mLoaders.size() > 0) {
                arg7.print(arg5);
                arg7.println("Loaders:");
                String v0 = arg5 + "    ";
                int v1;
                for(v1 = 0; v1 < this.mLoaders.size(); ++v1) {
                    Object v2 = this.mLoaders.valueAt(v1);
                    arg7.print(arg5);
                    arg7.print("  #");
                    arg7.print(this.mLoaders.keyAt(v1));
                    arg7.print(": ");
                    arg7.println(((LoaderInfo)v2).toString());
                    ((LoaderInfo)v2).dump(v0, arg6, arg7, arg8);
                }
            }
        }

        void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        static LoaderViewModel getInstance(ViewModelStore arg2) {
            return new ViewModelProvider(arg2, LoaderViewModel.FACTORY).get(LoaderViewModel.class);
        }

        LoaderInfo getLoader(int arg1) {
            return this.mLoaders.get(arg1);
        }

        boolean hasRunningLoaders() {
            int v0 = this.mLoaders.size();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                if(this.mLoaders.valueAt(v2).isCallbackWaitingForData()) {
                    return 1;
                }
            }

            return 0;
        }

        boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        void markForRedelivery() {
            int v0 = this.mLoaders.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.mLoaders.valueAt(v1).markForRedelivery();
            }
        }

        protected void onCleared() {
            SparseArrayCompat v2;
            super.onCleared();
            int v0 = this.mLoaders.size();
            int v1;
            for(v1 = 0; true; ++v1) {
                v2 = this.mLoaders;
                if(v1 >= v0) {
                    break;
                }

                v2.valueAt(v1).destroy(true);
            }

            v2.clear();
        }

        void putLoader(int arg1, LoaderInfo arg2) {
            this.mLoaders.put(arg1, arg2);
        }

        void removeLoader(int arg1) {
            this.mLoaders.remove(arg1);
        }

        void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    private final LifecycleOwner mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    static {
    }

    LoaderManagerImpl(LifecycleOwner arg1, ViewModelStore arg2) {
        super();
        this.mLifecycleOwner = arg1;
        this.mLoaderViewModel = LoaderViewModel.getInstance(arg2);
    }

    private Loader createAndInstallLoader(int arg5, Bundle arg6, LoaderCallbacks arg7, Loader arg8) {
        LoaderInfo v0_1;
        String v0 = "Object returned from onCreateLoader must not be a non-static inner member class: ";
        String v1 = "  Created new loader ";
        try {
            this.mLoaderViewModel.startCreatingLoader();
            Loader v2 = arg7.onCreateLoader(arg5, arg6);
            if(v2 == null) {
                goto label_38;
            }

            if(v2.getClass().isMemberClass()) {
                if(Modifier.isStatic(v2.getClass().getModifiers())) {
                }
                else {
                    throw new IllegalArgumentException(v0 + v2);
                }
            }

            v0_1 = new LoaderInfo(arg5, arg6, v2, arg8);
            if(LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", v1 + v0_1);
            }

            this.mLoaderViewModel.putLoader(arg5, v0_1);
        }
        catch(Throwable v5) {
            goto label_44;
        }

        this.mLoaderViewModel.finishCreatingLoader();
        return v0_1.setCallback(this.mLifecycleOwner, arg7);
        try {
        label_38:
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        }
        catch(Throwable v5) {
        label_44:
            this.mLoaderViewModel.finishCreatingLoader();
            throw v5;
        }
    }

    public void destroyLoader(int arg3) {
        if(!this.mLoaderViewModel.isCreatingLoader()) {
            if(Looper.getMainLooper() == Looper.myLooper()) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "destroyLoader in " + this + " of " + arg3);
                }

                LoaderInfo v0 = this.mLoaderViewModel.getLoader(arg3);
                if(v0 != null) {
                    v0.destroy(true);
                    this.mLoaderViewModel.removeLoader(arg3);
                }

                return;
            }

            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }

        throw new IllegalStateException("Called while creating a loader");
    }

    @Deprecated public void dump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
        this.mLoaderViewModel.dump(arg1, arg2, arg3, arg4);
    }

    public Loader getLoader(int arg2) {
        if(!this.mLoaderViewModel.isCreatingLoader()) {
            LoaderInfo v1 = this.mLoaderViewModel.getLoader(arg2);
            if(v1 != null) {
                return v1.getLoader();
            }

            return null;
        }

        throw new IllegalStateException("Called while creating a loader");
    }

    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    public Loader initLoader(int arg5, Bundle arg6, LoaderCallbacks arg7) {
        if(!this.mLoaderViewModel.isCreatingLoader()) {
            if(Looper.getMainLooper() == Looper.myLooper()) {
                LoaderInfo v0 = this.mLoaderViewModel.getLoader(arg5);
                String v2 = "LoaderManager";
                if(LoaderManagerImpl.DEBUG) {
                    Log.v(v2, "initLoader in " + this + ": args=" + arg6);
                }

                if(v0 == null) {
                    return this.createAndInstallLoader(arg5, arg6, arg7, null);
                }

                if(LoaderManagerImpl.DEBUG) {
                    Log.v(v2, "  Re-using existing loader " + v0);
                }

                return v0.setCallback(this.mLifecycleOwner, arg7);
            }

            throw new IllegalStateException("initLoader must be called on the main thread");
        }

        throw new IllegalStateException("Called while creating a loader");
    }

    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    public Loader restartLoader(int arg3, Bundle arg4, LoaderCallbacks arg5) {
        if(!this.mLoaderViewModel.isCreatingLoader()) {
            if(Looper.getMainLooper() == Looper.myLooper()) {
                if(LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "restartLoader in " + this + ": args=" + arg4);
                }

                LoaderInfo v0 = this.mLoaderViewModel.getLoader(arg3);
                Loader v0_1 = v0 != null ? v0.destroy(false) : null;
                return this.createAndInstallLoader(arg3, arg4, arg5, v0_1);
            }

            throw new IllegalStateException("restartLoader must be called on the main thread");
        }

        throw new IllegalStateException("Called while creating a loader");
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder(0x80);
        v0.append("LoaderManager{");
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, v0);
        v0.append("}}");
        return v0.toString();
    }
}

