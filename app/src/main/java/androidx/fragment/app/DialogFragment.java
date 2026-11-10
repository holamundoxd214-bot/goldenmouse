package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class DialogFragment extends Fragment implements DialogInterface$OnCancelListener, DialogInterface$OnDismissListener {
    class androidx.fragment.app.DialogFragment$1 implements Runnable {
        androidx.fragment.app.DialogFragment$1(DialogFragment arg1) {
            DialogFragment.this = arg1;
            super();
        }

        public void run() {
            DialogFragment.this.mOnDismissListener.onDismiss(DialogFragment.this.mDialog);
        }
    }

    class androidx.fragment.app.DialogFragment$2 implements DialogInterface$OnCancelListener {
        androidx.fragment.app.DialogFragment$2(DialogFragment arg1) {
            DialogFragment.this = arg1;
            super();
        }

        public void onCancel(DialogInterface arg1) {
            if(DialogFragment.this.mDialog != null) {
                DialogFragment.this.onCancel(DialogFragment.this.mDialog);
            }
        }
    }

    class androidx.fragment.app.DialogFragment$3 implements DialogInterface$OnDismissListener {
        androidx.fragment.app.DialogFragment$3(DialogFragment arg1) {
            DialogFragment.this = arg1;
            super();
        }

        public void onDismiss(DialogInterface arg1) {
            if(DialogFragment.this.mDialog != null) {
                DialogFragment.this.onDismiss(DialogFragment.this.mDialog);
            }
        }
    }

    class androidx.fragment.app.DialogFragment$4 implements Observer {
        androidx.fragment.app.DialogFragment$4(DialogFragment arg1) {
            DialogFragment.this = arg1;
            super();
        }

        public void onChanged(LifecycleOwner arg3) {
            if(arg3 != null && (DialogFragment.this.mShowsDialog)) {
                View v3 = DialogFragment.this.requireView();
                if(v3.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                else if(DialogFragment.this.mDialog != null) {
                    if(FragmentManager.isLoggingEnabled(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogFragment.this.mDialog);
                    }

                    DialogFragment.this.mDialog.setContentView(v3);
                    return;
                }
            }
        }

        public void onChanged(Object arg1) {
            this.onChanged(((LifecycleOwner)arg1));
        }
    }

    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private Observer mObserver;
    private DialogInterface$OnCancelListener mOnCancelListener;
    private DialogInterface$OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    public DialogFragment() {
        super();
        this.mDismissRunnable = new androidx.fragment.app.DialogFragment$1(this);
        this.mOnCancelListener = new androidx.fragment.app.DialogFragment$2(this);
        this.mOnDismissListener = new androidx.fragment.app.DialogFragment$3(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new androidx.fragment.app.DialogFragment$4(this);
        this.mDialogCreated = false;
    }

    public DialogFragment(int arg2) {
        super(arg2);
        this.mDismissRunnable = new androidx.fragment.app.DialogFragment$1(this);
        this.mOnCancelListener = new androidx.fragment.app.DialogFragment$2(this);
        this.mOnDismissListener = new androidx.fragment.app.DialogFragment$3(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new androidx.fragment.app.DialogFragment$4(this);
        this.mDialogCreated = false;
    }

    static Dialog access$000(DialogFragment arg0) {
        return arg0.mDialog;
    }

    static DialogInterface$OnDismissListener access$100(DialogFragment arg0) {
        return arg0.mOnDismissListener;
    }

    static boolean access$200(DialogFragment arg0) {
        return arg0.mShowsDialog;
    }

    FragmentContainer createFragmentContainer() {
        return new FragmentContainer(super.createFragmentContainer()) {
            public View onFindViewById(int arg2) {
                if(this.val$fragmentContainer.onHasView()) {
                    return this.val$fragmentContainer.onFindViewById(arg2);
                }

                return DialogFragment.this.onFindViewById(arg2);
            }

            public boolean onHasView() {
                if(!this.val$fragmentContainer.onHasView()) {
                    if(DialogFragment.this.onHasView()) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        };
    }

    public void dismiss() {
        this.dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        this.dismissInternal(true, false);
    }

    private void dismissInternal(boolean arg4, boolean arg5) {
        if(this.mDismissed) {
            return;
        }

        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog v1 = this.mDialog;
        if(v1 != null) {
            v1.setOnDismissListener(null);
            this.mDialog.dismiss();
            if(!arg5) {
                if(Looper.myLooper() == this.mHandler.getLooper()) {
                    this.onDismiss(this.mDialog);
                }
                else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }

        this.mViewDestroyed = true;
        if(this.mBackStackId >= 0) {
            this.getParentFragmentManager().popBackStack(this.mBackStackId, 1);
            this.mBackStackId = -1;
            return;
        }

        FragmentTransaction v5 = this.getParentFragmentManager().beginTransaction();
        v5.remove(((Fragment)this));
        if(arg4) {
            v5.commitAllowingStateLoss();
            return;
        }

        v5.commit();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void onAttach(Context arg2) {
        super.onAttach(arg2);
        this.getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if(!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    public void onCancel(DialogInterface arg1) {
    }

    public void onCreate(Bundle arg4) {
        super.onCreate(arg4);
        this.mHandler = new Handler();
        boolean v0 = this.mContainerId == 0 ? true : false;
        this.mShowsDialog = v0;
        if(arg4 != null) {
            this.mStyle = arg4.getInt("android:style", 0);
            this.mTheme = arg4.getInt("android:theme", 0);
            this.mCancelable = arg4.getBoolean("android:cancelable", true);
            this.mShowsDialog = arg4.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = arg4.getInt("android:backStackId", -1);
        }
    }

    public Dialog onCreateDialog(Bundle arg2) {
        if(FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }

        return new Dialog(this.requireContext(), this.getTheme());
    }

    public void onDestroyView() {
        super.onDestroyView();
        Dialog v0 = this.mDialog;
        if(v0 != null) {
            this.mViewDestroyed = true;
            DialogInterface$OnDismissListener v1 = null;
            v0.setOnDismissListener(v1);
            this.mDialog.dismiss();
            if(!this.mDismissed) {
                this.onDismiss(this.mDialog);
            }

            this.mDialog = ((Dialog)v1);
            this.mDialogCreated = false;
        }
    }

    public void onDetach() {
        super.onDetach();
        if(!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }

        this.getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    public void onDismiss(DialogInterface arg2) {
        if(!this.mViewDestroyed) {
            if(FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }

            this.dismissInternal(true, true);
        }
    }

    View onFindViewById(int arg1) {
        Dialog v0 = this.mDialog;
        if(v0 != null) {
            return v0.findViewById(arg1);
        }

        return null;
    }

    public LayoutInflater onGetLayoutInflater(Bundle arg5) {
        LayoutInflater v0 = super.onGetLayoutInflater(arg5);
        int v2 = 2;
        String v3 = "FragmentManager";
        if(!this.mShowsDialog || (this.mCreatingDialog)) {
            if(!FragmentManager.isLoggingEnabled(v2)) {
                return v0;
            }

            String v5 = "getting layout inflater for DialogFragment " + this;
            if(!this.mShowsDialog) {
                Log.d(v3, "mShowsDialog = false: " + v5);
                return v0;
            }

            Log.d(v3, "mCreatingDialog = true: " + v5);
        }
        else {
            this.prepareDialog(arg5);
            if(FragmentManager.isLoggingEnabled(v2)) {
                Log.d(v3, "get layout inflater for DialogFragment " + this + " from dialog context");
            }

            Dialog v4 = this.mDialog;
            if(v4 == null) {
                return v0;
            }

            return v0.cloneInContext(v4.getContext());
        }

        return v0;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    public void onSaveInstanceState(Bundle arg4) {
        super.onSaveInstanceState(arg4);
        Dialog v0 = this.mDialog;
        if(v0 != null) {
            Bundle v0_1 = v0.onSaveInstanceState();
            v0_1.putBoolean("android:dialogShowing", false);
            arg4.putBundle("android:savedDialogState", v0_1);
        }

        int v0_2 = this.mStyle;
        if(v0_2 != 0) {
            arg4.putInt("android:style", v0_2);
        }

        v0_2 = this.mTheme;
        if(v0_2 != 0) {
            arg4.putInt("android:theme", v0_2);
        }

        boolean v0_3 = this.mCancelable;
        if(!v0_3) {
            arg4.putBoolean("android:cancelable", v0_3);
        }

        v0_3 = this.mShowsDialog;
        if(!v0_3) {
            arg4.putBoolean("android:showsDialog", v0_3);
        }

        int v3 = this.mBackStackId;
        if(v3 != -1) {
            arg4.putInt("android:backStackId", v3);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog v0 = this.mDialog;
        if(v0 != null) {
            this.mViewDestroyed = false;
            v0.show();
            View v0_1 = this.mDialog.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set(v0_1, ((LifecycleOwner)this));
            ViewTreeViewModelStoreOwner.set(v0_1, ((ViewModelStoreOwner)this));
            ViewTreeSavedStateRegistryOwner.set(v0_1, ((SavedStateRegistryOwner)this));
        }
    }

    public void onStop() {
        super.onStop();
        Dialog v0 = this.mDialog;
        if(v0 != null) {
            v0.hide();
        }
    }

    public void onViewStateRestored(Bundle arg2) {
        super.onViewStateRestored(arg2);
        if(this.mDialog != null && arg2 != null) {
            arg2 = arg2.getBundle("android:savedDialogState");
            if(arg2 != null) {
                this.mDialog.onRestoreInstanceState(arg2);
            }
        }
    }

    void performCreateView(LayoutInflater arg1, ViewGroup arg2, Bundle arg3) {
        super.performCreateView(arg1, arg2, arg3);
        if(this.mView == null && this.mDialog != null && arg3 != null) {
            Bundle v1 = arg3.getBundle("android:savedDialogState");
            if(v1 != null) {
                this.mDialog.onRestoreInstanceState(v1);
            }
        }
    }

    private void prepareDialog(Bundle arg4) {
        if(!this.mShowsDialog) {
        }
        else if(!this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog v4_1 = this.onCreateDialog(arg4);
                this.mDialog = v4_1;
                if(this.mShowsDialog) {
                    this.setupDialog(v4_1, this.mStyle);
                    Context v4_2 = this.getContext();
                    if((v4_2 instanceof Activity)) {
                        this.mDialog.setOwnerActivity(((Activity)v4_2));
                    }

                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                }
                else {
                    this.mDialog = null;
                }
            }
            catch(Throwable v4) {
                this.mCreatingDialog = false;
                throw v4;
            }

            this.mCreatingDialog = false;
            return;
        }
    }

    public final Dialog requireDialog() {
        Dialog v0 = this.getDialog();
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean arg1) {
        this.mCancelable = arg1;
        Dialog v0 = this.mDialog;
        if(v0 != null) {
            v0.setCancelable(arg1);
        }
    }

    public void setShowsDialog(boolean arg1) {
        this.mShowsDialog = arg1;
    }

    public void setStyle(int arg4, int arg5) {
        int v0 = 2;
        if(FragmentManager.isLoggingEnabled(v0)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + arg4 + ", " + arg5);
        }

        this.mStyle = arg4;
        if(arg4 == v0 || arg4 == 3) {
            this.mTheme = 0x1030059;
        }

        if(arg5 != 0) {
            this.mTheme = arg5;
        }
    }

    public void setupDialog(Dialog arg2, int arg3) {
        if(arg3 != 1 && arg3 != 2) {
            if(arg3 != 3) {
                return;
            }
            else {
                Window v3 = arg2.getWindow();
                if(v3 != null) {
                    v3.addFlags(24);
                }
            }
        }

        arg2.requestWindowFeature(1);
    }

    public int show(FragmentTransaction arg3, String arg4) {
        this.mDismissed = false;
        this.mShownByMe = true;
        arg3.add(((Fragment)this), arg4);
        this.mViewDestroyed = false;
        int v3 = arg3.commit();
        this.mBackStackId = v3;
        return v3;
    }

    public void show(FragmentManager arg2, String arg3) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction v2 = arg2.beginTransaction();
        v2.add(((Fragment)this), arg3);
        v2.commit();
    }

    public void showNow(FragmentManager arg2, String arg3) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction v2 = arg2.beginTransaction();
        v2.add(((Fragment)this), arg3);
        v2.commitNow();
    }
}

