package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.Window$Callback;
import androidx.activity.ComponentDialog;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.KeyEventDispatcher;

public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final Component mKeyDispatcher;

    public AppCompatDialog(Context arg2) {
        this(arg2, 0);
    }

    public AppCompatDialog(Context arg2, int arg3) {
        super(arg2, AppCompatDialog.getThemeResId(arg2, arg3));
        this.mKeyDispatcher = new AppCompatDialog$$ExternalSyntheticLambda0(this);
        AppCompatDelegate v1 = this.getDelegate();
        v1.setTheme(AppCompatDialog.getThemeResId(arg2, arg3));
        v1.onCreate(null);
    }

    protected AppCompatDialog(Context arg1, boolean arg2, DialogInterface$OnCancelListener arg3) {
        super(arg1);
        this.mKeyDispatcher = new AppCompatDialog$$ExternalSyntheticLambda0(this);
        this.setCancelable(arg2);
        this.setOnCancelListener(arg3);
    }

    public void addContentView(View arg1, ViewGroup$LayoutParams arg2) {
        this.getDelegate().addContentView(arg1, arg2);
    }

    public void dismiss() {
        super.dismiss();
        this.getDelegate().onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent arg3) {
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, this.getWindow().getDecorView(), ((Window$Callback)this), arg3);
    }

    public View findViewById(int arg1) {
        return this.getDelegate().findViewById(arg1);
    }

    public AppCompatDelegate getDelegate() {
        AppCompatDelegate v0 = this.mDelegate;
        if(v0 == null) {
            v0 = AppCompatDelegate.create(((Dialog)this), ((AppCompatCallback)this));
            this.mDelegate = v0;
        }

        return v0;
    }

    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }

    private static int getThemeResId(Context arg2, int arg3) {
        if(arg3 == 0) {
            TypedValue v3 = new TypedValue();
            arg2.getTheme().resolveAttribute(attr.dialogTheme, v3, true);
            return v3.resourceId;
        }

        return arg3;
    }

    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    protected void onCreate(Bundle arg2) {
        this.getDelegate().installViewFactory();
        super.onCreate(arg2);
        this.getDelegate().onCreate(arg2);
    }

    protected void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode arg1) {
    }

    public void onSupportActionModeStarted(ActionMode arg1) {
    }

    public ActionMode onWindowStartingSupportActionMode(Callback arg1) {
        return null;
    }

    public void setContentView(int arg1) {
        this.getDelegate().setContentView(arg1);
    }

    public void setContentView(View arg1) {
        this.getDelegate().setContentView(arg1);
    }

    public void setContentView(View arg1, ViewGroup$LayoutParams arg2) {
        this.getDelegate().setContentView(arg1, arg2);
    }

    public void setTitle(int arg2) {
        super.setTitle(arg2);
        this.getDelegate().setTitle(this.getContext().getString(arg2));
    }

    public void setTitle(CharSequence arg1) {
        super.setTitle(arg1);
        this.getDelegate().setTitle(arg1);
    }

    boolean superDispatchKeyEvent(KeyEvent arg1) {
        return super.dispatchKeyEvent(arg1);
    }

    public boolean supportRequestWindowFeature(int arg1) {
        return this.getDelegate().requestWindowFeature(arg1);
    }
}

