package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

public final class PointerIconCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static PointerIcon create(Bitmap arg0, float arg1, float arg2) {
            return PointerIcon.create(arg0, arg1, arg2);
        }

        static PointerIcon getSystemIcon(Context arg0, int arg1) {
            return PointerIcon.getSystemIcon(arg0, arg1);
        }

        static PointerIcon load(Resources arg0, int arg1) {
            return PointerIcon.load(arg0, arg1);
        }
    }

    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 0x3F5;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 0x3F3;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 0x3FD;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 0x3F6;
    public static final int TYPE_NO_DROP = 0x3F4;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 0x3F0;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 0x3F9;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 0x3F8;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 0x3F7;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 0x3FA;
    public static final int TYPE_ZOOM_OUT = 0x3FB;
    private final PointerIcon mPointerIcon;

    private PointerIconCompat(PointerIcon arg1) {
        super();
        this.mPointerIcon = arg1;
    }

    public static PointerIconCompat create(Bitmap arg1, float arg2, float arg3) {
        return new PointerIconCompat(Api24Impl.create(arg1, arg2, arg3));
    }

    public Object getPointerIcon() {
        return this.mPointerIcon;
    }

    public static PointerIconCompat getSystemIcon(Context arg1, int arg2) {
        return new PointerIconCompat(Api24Impl.getSystemIcon(arg1, arg2));
    }

    public static PointerIconCompat load(Resources arg1, int arg2) {
        return new PointerIconCompat(Api24Impl.load(arg1, arg2));
    }
}

