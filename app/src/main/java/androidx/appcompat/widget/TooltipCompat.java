package androidx.appcompat.widget;

import android.view.View;

public class TooltipCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static void setTooltipText(View arg0, CharSequence arg1) {
            arg0.setTooltipText(arg1);
        }
    }

    private TooltipCompat() {
        super();
    }

    public static void setTooltipText(View arg0, CharSequence arg1) {
        Api26Impl.setTooltipText(arg0, arg1);
    }
}

