package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u001B\u0010\u0004\u001A\u00020\u0005*\u00020\u00012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\b\u001A+\u0010\b\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\b\u001A\"\u0010\r\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F\u001A&\u0010\u0012\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F\u001A,\u0010\u0014\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u000F2\b\b\u0002\u0010\u0016\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F¨\u0006\u0017"}, d2={"Canvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "withSave", "", "block", "Lkotlin/Function0;", "withSaveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "rotate", "degrees", "", "pivotX", "pivotY", "rotateRad", "radians", "scale", "sx", "sy", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CanvasKt {
    public static final Canvas Canvas(ImageBitmap arg0) {
        return AndroidCanvas_androidKt.ActualCanvas(arg0);
    }

    public static final void rotate(Canvas arg1, float arg2, float arg3, float arg4) {
        if(arg2 == 0f) {
            return;
        }

        arg1.translate(arg3, arg4);
        arg1.rotate(arg2);
        arg1.translate(-arg3, -arg4);
    }

    public static final void rotateRad(Canvas arg0, float arg1, float arg2, float arg3) {
        CanvasKt.rotate(arg0, DegreesKt.degrees(arg1), arg2, arg3);
    }

    public static void rotateRad$default(Canvas arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        CanvasKt.rotateRad(arg1, arg2, 0f, 0f);
    }

    public static final void scale(Canvas arg2, float arg3, float arg4, float arg5, float arg6) {
        float v0 = 1f;
        if(arg3 == v0 && arg4 == v0) {
            return;
        }

        arg2.translate(arg5, arg6);
        arg2.scale(arg3, arg4);
        arg2.translate(-arg5, -arg6);
    }

    public static void scale$default(Canvas arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg2 = arg1;
        }

        CanvasKt.scale(arg0, arg1, arg2, arg3, arg4);
    }

    public static final void withSave(Canvas arg0, Function0 arg1) {
        try {
            arg0.save();
            arg1.invoke();
        }
        catch(Throwable v1) {
            arg0.restore();
            throw v1;
        }

        arg0.restore();
    }

    public static final void withSaveLayer(Canvas arg0, Rect arg1, Paint arg2, Function0 arg3) {
        try {
            arg0.saveLayer(arg1, arg2);
            arg3.invoke();
        }
        catch(Throwable v1) {
            arg0.restore();
            throw v1;
        }

        arg0.restore();
    }
}

