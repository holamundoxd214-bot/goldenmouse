package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;

public class Group extends ConstraintHelper {
    public Group(Context arg1) {
        super(arg1);
    }

    public Group(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public Group(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
    }

    protected void init(AttributeSet arg1) {
        super.init(arg1);
        this.mUseViewMeasure = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.applyLayoutFeatures();
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        this.applyLayoutFeatures();
    }

    public void setVisibility(int arg1) {
        super.setVisibility(arg1);
        this.applyLayoutFeatures();
    }

    public void updatePostLayout(ConstraintLayout arg2) {
        ViewGroup$LayoutParams v1 = this.getLayoutParams();
        ((LayoutParams)v1).widget.setWidth(0);
        ((LayoutParams)v1).widget.setHeight(0);
    }
}

