package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback;
import androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

public class FragmentActivity extends ComponentActivity implements OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator {
    class HostCallbacks extends FragmentHostCallback implements OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, FragmentOnAttachListener, ViewModelStoreOwner {
        public HostCallbacks(FragmentActivity arg1) {
            FragmentActivity.this = arg1;
            super(arg1);
        }

        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public void onAttachFragment(FragmentManager arg1, Fragment arg2) {
            FragmentActivity.this.onAttachFragment(arg2);
        }

        public void onDump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
            FragmentActivity.this.dump(arg1, arg2, arg3, arg4);
        }

        public View onFindViewById(int arg1) {
            return FragmentActivity.this.findViewById(arg1);
        }

        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        public Object onGetHost() {
            return this.onGetHost();
        }

        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public int onGetWindowAnimations() {
            Window v0 = FragmentActivity.this.getWindow();
            if(v0 == null) {
                return 0;
            }

            return v0.getAttributes().windowAnimations;
        }

        public boolean onHasView() {
            Window v0 = FragmentActivity.this.getWindow();
            if(v0 != null && v0.peekDecorView() != null) {
                return 1;
            }

            return 0;
        }

        public boolean onHasWindowAnimations() {
            if(FragmentActivity.this.getWindow() != null) {
                return 1;
            }

            return 0;
        }

        public boolean onShouldSaveFragmentState(Fragment arg1) {
            return FragmentActivity.this.isFinishing() ^ 1;
        }

        public boolean onShouldShowRequestPermissionRationale(String arg1) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, arg1);
        }

        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    public FragmentActivity() {
        super();
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(((LifecycleOwner)this));
        this.mStopped = true;
        this.init();
    }

    public FragmentActivity(int arg1) {
        super(arg1);
        this.mFragments = FragmentController.createController(new HostCallbacks(this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(((LifecycleOwner)this));
        this.mStopped = true;
        this.init();
    }

    final View dispatchFragmentsOnCreateView(View arg1, String arg2, Context arg3, AttributeSet arg4) {
        return this.mFragments.onCreateView(arg1, arg2, arg3, arg4);
    }

    public void dump(String arg3, FileDescriptor arg4, PrintWriter arg5, String[] arg6) {
        super.dump(arg3, arg4, arg5, arg6);
        arg5.print(arg3);
        arg5.print("Local FragmentActivity ");
        arg5.print(Integer.toHexString(System.identityHashCode(this)));
        arg5.println(" State:");
        String v0 = arg3 + "  ";
        arg5.print(v0);
        arg5.print("mCreated=");
        arg5.print(this.mCreated);
        arg5.print(" mResumed=");
        arg5.print(this.mResumed);
        arg5.print(" mStopped=");
        arg5.print(this.mStopped);
        if(this.getApplication() != null) {
            LoaderManager.getInstance(((LifecycleOwner)this)).dump(v0, arg4, arg5, arg6);
        }

        this.mFragments.getSupportFragmentManager().dump(arg3, arg4, arg5, arg6);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    @Deprecated public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(((LifecycleOwner)this));
    }

    private void init() {
        this.getSavedStateRegistry().registerSavedStateProvider("android:support:fragments", new SavedStateProvider() {
            public Bundle saveState() {
                Bundle v0 = new Bundle();
                FragmentActivity.this.markFragmentsCreated();
                FragmentActivity.this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_STOP);
                Parcelable v3 = FragmentActivity.this.mFragments.saveAllState();
                if(v3 != null) {
                    v0.putParcelable("android:support:fragments", v3);
                }

                return v0;
            }
        });
        this.addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context arg2) {
                FragmentActivity.this.mFragments.attachHost(null);
                String v0 = "android:support:fragments";
                Bundle v2 = FragmentActivity.this.getSavedStateRegistry().consumeRestoredStateForKey(v0);
                if(v2 != null) {
                    FragmentActivity.this.mFragments.restoreSaveState(v2.getParcelable(v0));
                }
            }
        });
    }

    void markFragmentsCreated() {
        do {
        }
        while(FragmentActivity.markState(this.getSupportFragmentManager(), State.CREATED));
    }

    private static boolean markState(FragmentManager arg5, State arg6) {
        Iterator v5 = arg5.getFragments().iterator();
        int v0;
        for(v0 = 0; v5.hasNext(); v0 = 1) {
            Object v1 = v5.next();
            if(v1 == null) {
                continue;
            }

            if(((Fragment)v1).getHost() != null) {
                v0 |= FragmentActivity.markState(((Fragment)v1).getChildFragmentManager(), arg6);
            }

            if(((Fragment)v1).mViewLifecycleOwner != null && (((Fragment)v1).mViewLifecycleOwner.getLifecycle().getCurrentState().isAtLeast(State.STARTED))) {
                ((Fragment)v1).mViewLifecycleOwner.setCurrentState(arg6);
                v0 = 1;
            }

            if(!((Fragment)v1).mLifecycleRegistry.getCurrentState().isAtLeast(State.STARTED)) {
                continue;
            }

            ((Fragment)v1).mLifecycleRegistry.setCurrentState(arg6);
        }

        return ((boolean)v0);
    }

    protected void onActivityResult(int arg2, int arg3, Intent arg4) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(arg2, arg3, arg4);
    }

    @Deprecated public void onAttachFragment(Fragment arg1) {
    }

    public void onConfigurationChanged(Configuration arg2) {
        this.mFragments.noteStateNotSaved();
        super.onConfigurationChanged(arg2);
        this.mFragments.dispatchConfigurationChanged(arg2);
    }

    protected void onCreate(Bundle arg2) {
        super.onCreate(arg2);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_CREATE);
        this.mFragments.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int arg2, Menu arg3) {
        if(arg2 == 0) {
            return this.mFragments.dispatchCreateOptionsMenu(arg3, this.getMenuInflater()) | super.onCreatePanelMenu(arg2, arg3);
        }

        return super.onCreatePanelMenu(arg2, arg3);
    }

    public View onCreateView(View arg2, String arg3, Context arg4, AttributeSet arg5) {
        View v0 = this.dispatchFragmentsOnCreateView(arg2, arg3, arg4, arg5);
        if(v0 == null) {
            return super.onCreateView(arg2, arg3, arg4, arg5);
        }

        return v0;
    }

    public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
        View v0 = this.dispatchFragmentsOnCreateView(null, arg2, arg3, arg4);
        if(v0 == null) {
            return super.onCreateView(arg2, arg3, arg4);
        }

        return v0;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int arg2, MenuItem arg3) {
        if(super.onMenuItemSelected(arg2, arg3)) {
            return 1;
        }

        if(arg2 != 0) {
            if(arg2 != 6) {
                return 0;
            }

            return this.mFragments.dispatchContextItemSelected(arg3);
        }

        return this.mFragments.dispatchOptionsItemSelected(arg3);
    }

    public void onMultiWindowModeChanged(boolean arg1) {
        this.mFragments.dispatchMultiWindowModeChanged(arg1);
    }

    protected void onNewIntent(Intent arg2) {
        this.mFragments.noteStateNotSaved();
        super.onNewIntent(arg2);
    }

    public void onPanelClosed(int arg2, Menu arg3) {
        if(arg2 == 0) {
            this.mFragments.dispatchOptionsMenuClosed(arg3);
        }

        super.onPanelClosed(arg2, arg3);
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.dispatchPause();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean arg1) {
        this.mFragments.dispatchPictureInPictureModeChanged(arg1);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.onResumeFragments();
    }

    @Deprecated protected boolean onPrepareOptionsPanel(View arg2, Menu arg3) {
        return super.onPreparePanel(0, arg2, arg3);
    }

    public boolean onPreparePanel(int arg1, View arg2, Menu arg3) {
        if(arg1 == 0) {
            return this.mFragments.dispatchPrepareOptionsMenu(arg3) | this.onPrepareOptionsPanel(arg2, arg3);
        }

        return super.onPreparePanel(arg1, arg2, arg3);
    }

    public void onRequestPermissionsResult(int arg2, String[] arg3, int[] arg4) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(arg2, arg3, arg4);
    }

    protected void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_RESUME);
        this.mFragments.dispatchResume();
    }

    protected void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if(!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }

        this.mFragments.execPendingActions();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_START);
        this.mFragments.dispatchStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.markFragmentsCreated();
        this.mFragments.dispatchStop();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback arg1) {
        ActivityCompat.setEnterSharedElementCallback(((Activity)this), arg1);
    }

    public void setExitSharedElementCallback(SharedElementCallback arg1) {
        ActivityCompat.setExitSharedElementCallback(((Activity)this), arg1);
    }

    public void startActivityFromFragment(Fragment arg2, Intent arg3, int arg4) {
        this.startActivityFromFragment(arg2, arg3, arg4, null);
    }

    public void startActivityFromFragment(Fragment arg2, Intent arg3, int arg4, Bundle arg5) {
        int v0 = -1;
        if(arg4 == v0) {
            ActivityCompat.startActivityForResult(((Activity)this), arg3, v0, arg5);
            return;
        }

        arg2.startActivityForResult(arg3, arg4, arg5);
    }

    @Deprecated public void startIntentSenderFromFragment(Fragment arg10, IntentSender arg11, int arg12, Intent arg13, int arg14, int arg15, int arg16, Bundle arg17) throws IntentSender$SendIntentException {
        if(arg12 == -1) {
            ActivityCompat.startIntentSenderForResult(this, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
            return;
        }

        arg10.startIntentSenderForResult(arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(((Activity)this));
    }

    @Deprecated public void supportInvalidateOptionsMenu() {
        this.invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(((Activity)this));
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(((Activity)this));
    }

    @Deprecated public final void validateRequestPermissionsRequestCode(int arg1) {
    }
}

