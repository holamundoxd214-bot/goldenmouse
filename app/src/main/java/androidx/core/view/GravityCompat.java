package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

public final class GravityCompat {
    public static final int END = 0x800005;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 0x800007;
    public static final int RELATIVE_LAYOUT_DIRECTION = 0x800000;
    public static final int START = 0x800003;

    private GravityCompat() {
        super();
    }

    public static void apply(int arg0, int arg1, int arg2, Rect arg3, Rect arg4, int arg5) {
        Gravity.apply(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void apply(int arg0, int arg1, int arg2, Rect arg3, int arg4, int arg5, Rect arg6, int arg7) {
        Gravity.apply(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void applyDisplay(int arg0, Rect arg1, Rect arg2, int arg3) {
        Gravity.applyDisplay(arg0, arg1, arg2, arg3);
    }

    public static int getAbsoluteGravity(int arg0, int arg1) {
        return Gravity.getAbsoluteGravity(arg0, arg1);
    }
}

