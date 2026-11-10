package com.TryJeanPc.goldenmouse.sharksettings;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class CardRelativeLayout extends RelativeLayout {
    private CardLayoutHelp mHelper;

    public CardRelativeLayout(Context arg2) {
        this(arg2, null);
    }

    public CardRelativeLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public CardRelativeLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        CardLayoutHelp v3 = new CardLayoutHelp();
        this.mHelper = v3;
        v3.init(arg1, arg2, ((View)this));
    }

    public void draw(Canvas arg2) {
        this.mHelper.preDraw(arg2);
        this.mHelper.drawPath(arg2);
        super.draw(arg2);
        this.mHelper.drawStroke(arg2);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.mHelper.onSizeChanged(arg1, arg2);
    }

    public void setStrokeColor(int arg1) {
        this.mHelper.setStrokeColor(arg1);
    }

    public void setStrokeWidth(float arg1) {
        this.mHelper.setStrokeWidth(arg1);
    }

    public void setStrokeWidthColor(float arg1, int arg2) {
        this.mHelper.setStrokeWidthColor(arg1, arg2);
    }
}

