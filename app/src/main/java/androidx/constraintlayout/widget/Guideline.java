package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;

public class Guideline extends View {
    public Guideline(Context arg1) {
        super(arg1);
        super.setVisibility(8);
    }

    public Guideline(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        super.setVisibility(8);
    }

    public Guideline(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        super.setVisibility(8);
    }

    public Guideline(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3);
        super.setVisibility(8);
    }

    public void draw(Canvas arg1) {
    }

    protected void onMeasure(int arg1, int arg2) {
        this.setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int arg2) {
        ViewGroup$LayoutParams v0 = this.getLayoutParams();
        ((LayoutParams)v0).guideBegin = arg2;
        this.setLayoutParams(v0);
    }

    public void setGuidelineEnd(int arg2) {
        ViewGroup$LayoutParams v0 = this.getLayoutParams();
        ((LayoutParams)v0).guideEnd = arg2;
        this.setLayoutParams(v0);
    }

    public void setGuidelinePercent(float arg2) {
        ViewGroup$LayoutParams v0 = this.getLayoutParams();
        ((LayoutParams)v0).guidePercent = arg2;
        this.setLayoutParams(v0);
    }

    public void setVisibility(int arg1) {
    }
}

