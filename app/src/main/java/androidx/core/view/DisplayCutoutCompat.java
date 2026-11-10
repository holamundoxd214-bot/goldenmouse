package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.DisplayCutout$Builder;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static DisplayCutout createDisplayCutout(Rect arg1, List arg2) {
            return new DisplayCutout(arg1, arg2);
        }

        static List getBoundingRects(DisplayCutout arg0) {
            return arg0.getBoundingRects();
        }

        static int getSafeInsetBottom(DisplayCutout arg0) {
            return arg0.getSafeInsetBottom();
        }

        static int getSafeInsetLeft(DisplayCutout arg0) {
            return arg0.getSafeInsetLeft();
        }

        static int getSafeInsetRight(DisplayCutout arg0) {
            return arg0.getSafeInsetRight();
        }

        static int getSafeInsetTop(DisplayCutout arg0) {
            return arg0.getSafeInsetTop();
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static DisplayCutout createDisplayCutout(Insets arg6, Rect arg7, Rect arg8, Rect arg9, Rect arg10) {
            return new DisplayCutout(arg6, arg7, arg8, arg9, arg10);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static DisplayCutout createDisplayCutout(Insets arg7, Rect arg8, Rect arg9, Rect arg10, Rect arg11, Insets arg12) {
            return new DisplayCutout(arg7, arg8, arg9, arg10, arg11, arg12);
        }

        static Insets getWaterfallInsets(DisplayCutout arg0) {
            return arg0.getWaterfallInsets();
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static Path getCutoutPath(DisplayCutout arg0) {
            return arg0.getCutoutPath();
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static DisplayCutout createDisplayCutout(Insets arg1, Rect arg2, Rect arg3, Rect arg4, Rect arg5, Insets arg6, Path arg7) {
            DisplayCutout$Builder v1 = new DisplayCutout$Builder().setSafeInsets(arg1).setWaterfallInsets(arg6);
            if(arg2 != null) {
                v1.setBoundingRectLeft(arg2);
            }

            if(arg3 != null) {
                v1.setBoundingRectTop(arg3);
            }

            if(arg4 != null) {
                v1.setBoundingRectRight(arg4);
            }

            if(arg5 != null) {
                v1.setBoundingRectBottom(arg5);
            }

            if(arg7 != null) {
                v1.setCutoutPath(arg7);
            }

            return v1.build();
        }
    }

    private final DisplayCutout mDisplayCutout;

    public DisplayCutoutCompat(Rect arg3, List arg4) {
        DisplayCutout v3 = Build$VERSION.SDK_INT >= 28 ? Api28Impl.createDisplayCutout(arg3, arg4) : null;
        this(v3);
    }

    private DisplayCutoutCompat(DisplayCutout arg1) {
        super();
        this.mDisplayCutout = arg1;
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets arg8, Rect arg9, Rect arg10, Rect arg11, Rect arg12, androidx.core.graphics.Insets arg13) {
        this(DisplayCutoutCompat.constructDisplayCutout(arg8, arg9, arg10, arg11, arg12, arg13, null));
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets arg1, Rect arg2, Rect arg3, Rect arg4, Rect arg5, androidx.core.graphics.Insets arg6, Path arg7) {
        this(DisplayCutoutCompat.constructDisplayCutout(arg1, arg2, arg3, arg4, arg5, arg6, arg7));
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets arg2, Rect arg3, Rect arg4, Rect arg5, Rect arg6, androidx.core.graphics.Insets arg7, Path arg8) {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.createDisplayCutout(arg2.toPlatformInsets(), arg3, arg4, arg5, arg6, arg7.toPlatformInsets(), arg8);
        }

        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.createDisplayCutout(arg2.toPlatformInsets(), arg3, arg4, arg5, arg6, arg7.toPlatformInsets());
        }

        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.createDisplayCutout(arg2.toPlatformInsets(), arg3, arg4, arg5, arg6);
        }

        if(Build$VERSION.SDK_INT >= 28) {
            Rect v7 = new Rect(arg2.left, arg2.top, arg2.right, arg2.bottom);
            ArrayList v2 = new ArrayList();
            if(arg3 != null) {
                v2.add(arg3);
            }

            if(arg4 != null) {
                v2.add(arg4);
            }

            if(arg5 != null) {
                v2.add(arg5);
            }

            if(arg6 != null) {
                v2.add(arg6);
            }

            return Api28Impl.createDisplayCutout(v7, ((List)v2));
        }

        return null;
    }

    public boolean equals(Object arg3) {
        if(this == (((DisplayCutoutCompat)arg3))) {
            return 1;
        }

        if(arg3 != null) {
            if(this.getClass() != arg3.getClass()) {
            }
            else {
                return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat)arg3).mDisplayCutout);
            }
        }

        return 0;
    }

    public List getBoundingRects() {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getBoundingRects(this.mDisplayCutout);
        }

        return Collections.emptyList();
    }

    public Path getCutoutPath() {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.getCutoutPath(this.mDisplayCutout);
        }

        return null;
    }

    public int getSafeInsetBottom() {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
        }

        return 0;
    }

    public int getSafeInsetLeft() {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
        }

        return 0;
    }

    public int getSafeInsetRight() {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
        }

        return 0;
    }

    public int getSafeInsetTop() {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
        }

        return 0;
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        if(Build$VERSION.SDK_INT >= 30) {
            return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
        }

        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        DisplayCutout v0 = this.mDisplayCutout;
        if(v0 == null) {
            return 0;
        }

        return v0.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }

    static DisplayCutoutCompat wrap(DisplayCutout arg1) {
        if(arg1 == null) {
            return null;
        }

        return new DisplayCutoutCompat(arg1);
    }
}

