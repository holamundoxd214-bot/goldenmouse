package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {
    public interface LoaderCallbacks {
        Loader onCreateLoader(int arg1, Bundle arg2);

        void onLoadFinished(Loader arg1, Object arg2);

        void onLoaderReset(Loader arg1);
    }

    public LoaderManager() {
        super();
    }

    public abstract void destroyLoader(int arg1);

    @Deprecated public abstract void dump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4);

    public static void enableDebugLogging(boolean arg0) {
        LoaderManagerImpl.DEBUG = arg0;
    }

    public static LoaderManager getInstance(LifecycleOwner arg2) {
        return new LoaderManagerImpl(arg2, arg2.getViewModelStore());
    }

    public abstract Loader getLoader(int arg1);

    public boolean hasRunningLoaders() {
        return 0;
    }

    public abstract Loader initLoader(int arg1, Bundle arg2, LoaderCallbacks arg3);

    public abstract void markForRedelivery();

    public abstract Loader restartLoader(int arg1, Bundle arg2, LoaderCallbacks arg3);
}

