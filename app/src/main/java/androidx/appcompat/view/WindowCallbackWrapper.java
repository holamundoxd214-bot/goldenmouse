package androidx.appcompat.view;

import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class WindowCallbackWrapper implements Window$Callback {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static boolean onSearchRequested(Window$Callback arg0, SearchEvent arg1) {
            return arg0.onSearchRequested(arg1);
        }

        static ActionMode onWindowStartingActionMode(Window$Callback arg0, ActionMode$Callback arg1, int arg2) {
            return arg0.onWindowStartingActionMode(arg1, arg2);
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void onProvideKeyboardShortcuts(Window$Callback arg0, List arg1, Menu arg2, int arg3) {
            arg0.onProvideKeyboardShortcuts(arg1, arg2, arg3);
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static void onPointerCaptureChanged(Window$Callback arg0, boolean arg1) {
            arg0.onPointerCaptureChanged(arg1);
        }
    }

    final Window$Callback mWrapped;

    public WindowCallbackWrapper(Window$Callback arg1) {
        super();
        if(arg1 != null) {
            this.mWrapped = arg1;
            return;
        }

        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent arg1) {
        return this.mWrapped.dispatchGenericMotionEvent(arg1);
    }

    public boolean dispatchKeyEvent(KeyEvent arg1) {
        return this.mWrapped.dispatchKeyEvent(arg1);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent arg1) {
        return this.mWrapped.dispatchKeyShortcutEvent(arg1);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg1) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(arg1);
    }

    public boolean dispatchTouchEvent(MotionEvent arg1) {
        return this.mWrapped.dispatchTouchEvent(arg1);
    }

    public boolean dispatchTrackballEvent(MotionEvent arg1) {
        return this.mWrapped.dispatchTrackballEvent(arg1);
    }

    public final Window$Callback getWrapped() {
        return this.mWrapped;
    }

    public void onActionModeFinished(ActionMode arg1) {
        this.mWrapped.onActionModeFinished(arg1);
    }

    public void onActionModeStarted(ActionMode arg1) {
        this.mWrapped.onActionModeStarted(arg1);
    }

    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    public boolean onCreatePanelMenu(int arg1, Menu arg2) {
        return this.mWrapped.onCreatePanelMenu(arg1, arg2);
    }

    public View onCreatePanelView(int arg1) {
        return this.mWrapped.onCreatePanelView(arg1);
    }

    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int arg1, MenuItem arg2) {
        return this.mWrapped.onMenuItemSelected(arg1, arg2);
    }

    public boolean onMenuOpened(int arg1, Menu arg2) {
        return this.mWrapped.onMenuOpened(arg1, arg2);
    }

    public void onPanelClosed(int arg1, Menu arg2) {
        this.mWrapped.onPanelClosed(arg1, arg2);
    }

    public void onPointerCaptureChanged(boolean arg1) {
        Api26Impl.onPointerCaptureChanged(this.mWrapped, arg1);
    }

    public boolean onPreparePanel(int arg1, View arg2, Menu arg3) {
        return this.mWrapped.onPreparePanel(arg1, arg2, arg3);
    }

    public void onProvideKeyboardShortcuts(List arg1, Menu arg2, int arg3) {
        Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, arg1, arg2, arg3);
    }

    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent arg1) {
        return Api23Impl.onSearchRequested(this.mWrapped, arg1);
    }

    public void onWindowAttributesChanged(WindowManager$LayoutParams arg1) {
        this.mWrapped.onWindowAttributesChanged(arg1);
    }

    public void onWindowFocusChanged(boolean arg1) {
        this.mWrapped.onWindowFocusChanged(arg1);
    }

    public ActionMode onWindowStartingActionMode(ActionMode$Callback arg1) {
        return this.mWrapped.onWindowStartingActionMode(arg1);
    }

    public ActionMode onWindowStartingActionMode(ActionMode$Callback arg1, int arg2) {
        return Api23Impl.onWindowStartingActionMode(this.mWrapped, arg1, arg2);
    }
}

