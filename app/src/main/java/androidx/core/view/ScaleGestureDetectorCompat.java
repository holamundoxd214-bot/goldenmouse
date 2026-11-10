package androidx.core.view;

import android.view.ScaleGestureDetector;
import androidx.annotation.ReplaceWith;

public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
        super();
    }

    @ReplaceWith(expression="scaleGestureDetector.isQuickScaleEnabled()") @Deprecated public static boolean isQuickScaleEnabled(ScaleGestureDetector arg0) {
        return arg0.isQuickScaleEnabled();
    }

    @Deprecated public static boolean isQuickScaleEnabled(Object arg0) {
        return ScaleGestureDetectorCompat.isQuickScaleEnabled(((ScaleGestureDetector)arg0));
    }

    @ReplaceWith(expression="scaleGestureDetector.setQuickScaleEnabled(enabled)") @Deprecated public static void setQuickScaleEnabled(ScaleGestureDetector arg0, boolean arg1) {
        arg0.setQuickScaleEnabled(arg1);
    }

    @Deprecated public static void setQuickScaleEnabled(Object arg0, boolean arg1) {
        ScaleGestureDetectorCompat.setQuickScaleEnabled(((ScaleGestureDetector)arg0), arg1);
    }
}

