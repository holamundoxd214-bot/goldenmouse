package androidx.core.view;

import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.ReplaceWith;

@Deprecated public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
        super();
    }

    @Deprecated public static int getLayoutDirection(ViewGroup$MarginLayoutParams arg1) {
        int v1 = arg1.getLayoutDirection();
        if(v1 != 0 && v1 != 1) {
            v1 = 0;
        }

        return v1;
    }

    @ReplaceWith(expression="lp.getMarginEnd()") @Deprecated public static int getMarginEnd(ViewGroup$MarginLayoutParams arg0) {
        return arg0.getMarginEnd();
    }

    @ReplaceWith(expression="lp.getMarginStart()") @Deprecated public static int getMarginStart(ViewGroup$MarginLayoutParams arg0) {
        return arg0.getMarginStart();
    }

    @ReplaceWith(expression="lp.isMarginRelative()") @Deprecated public static boolean isMarginRelative(ViewGroup$MarginLayoutParams arg0) {
        return arg0.isMarginRelative();
    }

    @ReplaceWith(expression="lp.resolveLayoutDirection(layoutDirection)") @Deprecated public static void resolveLayoutDirection(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.resolveLayoutDirection(arg1);
    }

    @ReplaceWith(expression="lp.setLayoutDirection(layoutDirection)") @Deprecated public static void setLayoutDirection(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.setLayoutDirection(arg1);
    }

    @ReplaceWith(expression="lp.setMarginEnd(marginEnd)") @Deprecated public static void setMarginEnd(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.setMarginEnd(arg1);
    }

    @ReplaceWith(expression="lp.setMarginStart(marginStart)") @Deprecated public static void setMarginStart(ViewGroup$MarginLayoutParams arg0, int arg1) {
        arg0.setMarginStart(arg1);
    }
}

