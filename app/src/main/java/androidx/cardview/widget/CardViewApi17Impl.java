package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewApi17Impl extends CardViewBaseImpl {
    CardViewApi17Impl() {
        super();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectHelper() {
            public void drawRoundRect(Canvas arg1, RectF arg2, float arg3, Paint arg4) {
                arg1.drawRoundRect(arg2, arg3, arg3, arg4);
            }
        };
    }
}

