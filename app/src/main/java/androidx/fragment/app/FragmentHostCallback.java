package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback extends FragmentContainer {
    private final Activity mActivity;
    private final Context mContext;
    final FragmentManager mFragmentManager;
    private final Handler mHandler;
    private final int mWindowAnimations;

    FragmentHostCallback(Activity arg2, Context arg3, Handler arg4, int arg5) {
        super();
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = arg2;
        this.mContext = Preconditions.checkNotNull(arg3, "context == null");
        this.mHandler = Preconditions.checkNotNull(arg4, "handler == null");
        this.mWindowAnimations = arg5;
    }

    public FragmentHostCallback(Context arg2, Handler arg3, int arg4) {
        Activity v0_1;
        if((arg2 instanceof Activity)) {
            Context v0 = arg2;
        }
        else {
            v0_1 = null;
        }

        this(v0_1, arg2, arg3, arg4);
    }

    FragmentHostCallback(FragmentActivity arg3) {
        this(((Activity)arg3), ((Context)arg3), new Handler(), 0);
    }

    Activity getActivity() {
        return this.mActivity;
    }

    Context getContext() {
        return this.mContext;
    }

    Handler getHandler() {
        return this.mHandler;
    }

    public void onDump(String arg1, FileDescriptor arg2, PrintWriter arg3, String[] arg4) {
    }

    public View onFindViewById(int arg1) {
        return null;
    }

    public abstract Object onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    public boolean onHasView() {
        return 1;
    }

    public boolean onHasWindowAnimations() {
        return 1;
    }

    @Deprecated public void onRequestPermissionsFromFragment(Fragment arg1, String[] arg2, int arg3) {
    }

    public boolean onShouldSaveFragmentState(Fragment arg1) {
        return 1;
    }

    public boolean onShouldShowRequestPermissionRationale(String arg1) {
        return 0;
    }

    public void onStartActivityFromFragment(Fragment arg1, Intent arg2, int arg3, Bundle arg4) {
        if(arg3 == -1) {
            ContextCompat.startActivity(this.mContext, arg2, arg4);
            return;
        }

        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void onStartActivityFromFragment(Fragment arg2, Intent arg3, int arg4) {
        this.onStartActivityFromFragment(arg2, arg3, arg4, null);
    }

    @Deprecated public void onStartIntentSenderFromFragment(Fragment arg9, IntentSender arg10, int arg11, Intent arg12, int arg13, int arg14, int arg15, Bundle arg16) throws IntentSender$SendIntentException {
        if(arg11 == -1) {
            ActivityCompat.startIntentSenderForResult(this.mActivity, arg10, arg11, arg12, arg13, arg14, arg15, arg16);
            return;
        }

        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}

