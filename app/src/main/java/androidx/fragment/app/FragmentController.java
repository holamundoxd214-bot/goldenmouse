package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FragmentController {
    private final FragmentHostCallback mHost;

    private FragmentController(FragmentHostCallback arg1) {
        super();
        this.mHost = arg1;
    }

    public void attachHost(Fragment arg2) {
        this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, arg2);
    }

    public static FragmentController createController(FragmentHostCallback arg2) {
        return new FragmentController(Preconditions.checkNotNull(arg2, "callbacks == null"));
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration arg1) {
        this.mHost.mFragmentManager.dispatchConfigurationChanged(arg1);
    }

    public boolean dispatchContextItemSelected(MenuItem arg1) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(arg1);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu arg1, MenuInflater arg2) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(arg1, arg2);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean arg1) {
        this.mHost.mFragmentManager.dispatchMultiWindowModeChanged(arg1);
    }

    public boolean dispatchOptionsItemSelected(MenuItem arg1) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(arg1);
    }

    public void dispatchOptionsMenuClosed(Menu arg1) {
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(arg1);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean arg1) {
        this.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(arg1);
    }

    public boolean dispatchPrepareOptionsMenu(Menu arg1) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(arg1);
    }

    @Deprecated public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    @Deprecated public void doLoaderDestroy() {
    }

    @Deprecated public void doLoaderRetain() {
    }

    @Deprecated public void doLoaderStart() {
    }

    @Deprecated public void doLoaderStop(boolean arg1) {
    }

    @Deprecated public void dumpLoaders(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions(true);
    }

    public Fragment findFragmentByWho(String arg1) {
        return this.mHost.mFragmentManager.findFragmentByWho(arg1);
    }

    public List getActiveFragments(List arg1) {
        return this.mHost.mFragmentManager.getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.mFragmentManager.getActiveFragmentCount();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.mFragmentManager;
    }

    @Deprecated public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public View onCreateView(View arg1, String arg2, Context arg3, AttributeSet arg4) {
        return this.mHost.mFragmentManager.getLayoutInflaterFactory().onCreateView(arg1, arg2, arg3, arg4);
    }

    @Deprecated public void reportLoaderStart() {
    }

    @Deprecated public void restoreAllState(Parcelable arg1, FragmentManagerNonConfig arg2) {
        this.mHost.mFragmentManager.restoreAllState(arg1, arg2);
    }

    @Deprecated public void restoreAllState(Parcelable arg3, List arg4) {
        this.mHost.mFragmentManager.restoreAllState(arg3, new FragmentManagerNonConfig(((Collection)arg4), null, null));
    }

    @Deprecated public void restoreLoaderNonConfig(SimpleArrayMap arg1) {
    }

    public void restoreSaveState(Parcelable arg2) {
        FragmentHostCallback v1 = this.mHost;
        if((v1 instanceof ViewModelStoreOwner)) {
            v1.mFragmentManager.restoreSaveState(arg2);
            return;
        }

        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you\'re still using retainNestedNonConfig().");
    }

    @Deprecated public SimpleArrayMap retainLoaderNonConfig() {
        return null;
    }

    @Deprecated public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    @Deprecated public List retainNonConfig() {
        FragmentManagerNonConfig v1 = this.mHost.mFragmentManager.retainNonConfig();
        if(v1 != null && v1.getFragments() != null) {
            return new ArrayList(v1.getFragments());
        }

        return null;
    }

    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

