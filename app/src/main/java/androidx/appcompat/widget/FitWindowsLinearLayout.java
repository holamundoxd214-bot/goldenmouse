package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private OnFitSystemWindowsListener mListener;

    public FitWindowsLinearLayout(Context arg1) {
        super(arg1);
    }

    public FitWindowsLinearLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    protected boolean fitSystemWindows(Rect arg2) {
        OnFitSystemWindowsListener v0 = this.mListener;
        if(v0 != null) {
            v0.onFitSystemWindows(arg2);
        }

        return super.fitSystemWindows(arg2);
    }

    public void setOnFitSystemWindowsListener(OnFitSystemWindowsListener arg1) {
        this.mListener = arg1;
    }
}

