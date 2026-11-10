package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR;
    private boolean mOverlapAnchor;

    static {
        AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR = false;
    }

    public AppCompatPopupWindow(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.init(arg2, arg3, arg4, 0);
    }

    public AppCompatPopupWindow(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.init(arg1, arg2, arg3, arg4);
    }

    private void init(Context arg2, AttributeSet arg3, int arg4, int arg5) {
        TintTypedArray v2 = TintTypedArray.obtainStyledAttributes(arg2, arg3, styleable.PopupWindow, arg4, arg5);
        if(v2.hasValue(styleable.PopupWindow_overlapAnchor)) {
            this.setSupportOverlapAnchor(v2.getBoolean(styleable.PopupWindow_overlapAnchor, false));
        }

        this.setBackgroundDrawable(v2.getDrawable(styleable.PopupWindow_android_popupBackground));
        v2.recycle();
    }

    private void setSupportOverlapAnchor(boolean arg2) {
        if(AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = arg2;
            return;
        }

        PopupWindowCompat.setOverlapAnchor(((PopupWindow)this), arg2);
    }

    public void showAsDropDown(View arg2, int arg3, int arg4) {
        if((AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR) && (this.mOverlapAnchor)) {
            arg4 -= arg2.getHeight();
        }

        super.showAsDropDown(arg2, arg3, arg4);
    }

    public void showAsDropDown(View arg2, int arg3, int arg4, int arg5) {
        if((AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR) && (this.mOverlapAnchor)) {
            arg4 -= arg2.getHeight();
        }

        super.showAsDropDown(arg2, arg3, arg4, arg5);
    }

    public void update(View arg7, int arg8, int arg9, int arg10, int arg11) {
        if((AppCompatPopupWindow.COMPAT_OVERLAP_ANCHOR) && (this.mOverlapAnchor)) {
            arg9 -= arg7.getHeight();
        }

        super.update(arg7, arg8, arg9, arg10, arg11);
    }
}

