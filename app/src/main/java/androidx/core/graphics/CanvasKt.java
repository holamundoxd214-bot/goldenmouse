package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001A)\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001A=\u0010\u0006\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001AG\u0010\n\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001AQ\u0010\u000E\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001A=\u0010\u000F\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001A3\u0010\u0010\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0011\u001A\u00020\u00122\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001A1\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00152\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001A1\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00162\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001AI\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u00182\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001AI\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\b2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u001A1\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u001D2\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001E"}, d2={"withSave", "", "Landroid/graphics/Canvas;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "withTranslation", "x", "", "y", "withRotation", "degrees", "pivotX", "pivotY", "withScale", "withSkew", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withClip", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "clipPath", "Landroid/graphics/Path;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CanvasKt {
    public static final void withClip(Canvas arg1, float arg2, float arg3, float arg4, float arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "block");
        int v0 = arg1.save();
        arg1.clipRect(arg2, arg3, arg4, arg5);
        try {
            arg6.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static final void withClip(Canvas arg1, int arg2, int arg3, int arg4, int arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "block");
        int v0 = arg1.save();
        arg1.clipRect(arg2, arg3, arg4, arg5);
        try {
            arg6.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static final void withClip(Canvas arg1, Path arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "clipPath");
        Intrinsics.checkNotNullParameter(arg3, "block");
        int v0 = arg1.save();
        arg1.clipPath(arg2);
        try {
            arg3.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static final void withClip(Canvas arg1, Rect arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "clipRect");
        Intrinsics.checkNotNullParameter(arg3, "block");
        int v0 = arg1.save();
        arg1.clipRect(arg2);
        try {
            arg3.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static final void withClip(Canvas arg1, RectF arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "clipRect");
        Intrinsics.checkNotNullParameter(arg3, "block");
        int v0 = arg1.save();
        arg1.clipRect(arg2);
        try {
            arg3.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static final void withMatrix(Canvas arg1, Matrix arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "matrix");
        Intrinsics.checkNotNullParameter(arg3, "block");
        int v0 = arg1.save();
        arg1.concat(arg2);
        try {
            arg3.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static void withMatrix$default(Canvas arg0, Matrix arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = new Matrix();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "matrix");
        Intrinsics.checkNotNullParameter(arg2, "block");
        arg3 = arg0.save();
        arg0.concat(arg1);
        try {
            arg2.invoke(arg0);
        }
        catch(Throwable v1) {
            arg0.restoreToCount(arg3);
            throw v1;
        }

        arg0.restoreToCount(arg3);
    }

    public static final void withRotation(Canvas arg1, float arg2, float arg3, float arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "block");
        int v0 = arg1.save();
        arg1.rotate(arg2, arg3, arg4);
        try {
            arg5.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static void withRotation$default(Canvas arg1, float arg2, float arg3, float arg4, Function1 arg5, int arg6, Object arg7) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "block");
        arg6 = arg1.save();
        arg1.rotate(0f, 0f, 0f);
        try {
            arg5.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(arg6);
            throw v2;
        }

        arg1.restoreToCount(arg6);
    }

    public static final void withSave(Canvas arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        int v0 = arg1.save();
        try {
            arg2.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static final void withScale(Canvas arg1, float arg2, float arg3, float arg4, float arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "block");
        int v0 = arg1.save();
        arg1.scale(arg2, arg3, arg4, arg5);
        try {
            arg6.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static void withScale$default(Canvas arg1, float arg2, float arg3, float arg4, float arg5, Function1 arg6, int arg7, Object arg8) {
        float v0 = 1f;
        if((arg7 & 1) != 0) {
            arg2 = v0;
        }

        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "block");
        arg7 = arg1.save();
        arg1.scale(arg2, arg3, 0f, 0f);
        try {
            arg6.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(arg7);
            throw v2;
        }

        arg1.restoreToCount(arg7);
    }

    public static final void withSkew(Canvas arg1, float arg2, float arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        int v0 = arg1.save();
        arg1.skew(arg2, arg3);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static void withSkew$default(Canvas arg1, float arg2, float arg3, Function1 arg4, int arg5, Object arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        arg5 = arg1.save();
        arg1.skew(0f, 0f);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(arg5);
            throw v2;
        }

        arg1.restoreToCount(arg5);
    }

    public static final void withTranslation(Canvas arg1, float arg2, float arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        int v0 = arg1.save();
        arg1.translate(arg2, arg3);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(v0);
            throw v2;
        }

        arg1.restoreToCount(v0);
    }

    public static void withTranslation$default(Canvas arg1, float arg2, float arg3, Function1 arg4, int arg5, Object arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        arg5 = arg1.save();
        arg1.translate(0f, 0f);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v2) {
            arg1.restoreToCount(arg5);
            throw v2;
        }

        arg1.restoreToCount(arg5);
    }
}

