package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&J\u0018\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&J\u0018\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH&J\u001A\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\f2\b\b\u0002\u0010\u0010\u001A\u00020\fH&J\u0010\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\fH&J\u0018\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH&J\u0018\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0016J\u0017\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0019H&¢\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00072\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0016¢\u0006\u0004\b \u0010!J9\u0010\u001C\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\f2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH&¢\u0006\u0004\b&\u0010\'J!\u0010(\u001A\u00020\u00032\u0006\u0010)\u001A\u00020*2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH&¢\u0006\u0004\b+\u0010,J\'\u0010-\u001A\u00020\u00032\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020/2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b1\u00102J\u0018\u00103\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J0\u00103\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\tH&J@\u00104\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\f2\u0006\u00105\u001A\u00020\f2\u0006\u00106\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\tH&J\u0018\u00107\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J0\u00107\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\tH&J\'\u00108\u001A\u00020\u00032\u0006\u00109\u001A\u00020/2\u0006\u0010:\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b;\u0010<J0\u0010=\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010>\u001A\u00020\f2\u0006\u0010?\u001A\u00020\f2\u0006\u0010@\u001A\u00020A2\u0006\u0010\b\u001A\u00020\tH\u0016JH\u0010=\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\f2\u0006\u0010>\u001A\u00020\f2\u0006\u0010?\u001A\u00020\f2\u0006\u0010@\u001A\u00020A2\u0006\u0010\b\u001A\u00020\tH&J0\u0010B\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010C\u001A\u00020\f2\u0006\u0010D\u001A\u00020\f2\u0006\u0010@\u001A\u00020A2\u0006\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010E\u001A\u00020\u00032\u0006\u0010)\u001A\u00020*2\u0006\u0010\b\u001A\u00020\tH&J\'\u0010F\u001A\u00020\u00032\u0006\u0010G\u001A\u00020H2\u0006\u0010I\u001A\u00020/2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\bJ\u0010KJG\u0010L\u001A\u00020\u00032\u0006\u0010G\u001A\u00020H2\b\b\u0002\u0010M\u001A\u00020N2\b\b\u0002\u0010O\u001A\u00020P2\b\b\u0002\u0010Q\u001A\u00020N2\b\b\u0002\u0010R\u001A\u00020P2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\bS\u0010TJ-\u0010U\u001A\u00020\u00032\u0006\u0010V\u001A\u00020W2\f\u0010X\u001A\b\u0012\u0004\u0012\u00020/0Y2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\bZ\u0010[J\'\u0010\\\u001A\u00020\u00032\u0006\u0010V\u001A\u00020W2\u0006\u0010X\u001A\u00020]2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b^\u0010_J\'\u0010`\u001A\u00020\u00032\u0006\u0010a\u001A\u00020b2\u0006\u0010c\u001A\u00020d2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\be\u0010fJ\b\u0010g\u001A\u00020\u0003H&J\b\u0010h\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006iÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/Canvas;", "", "save", "", "restore", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "skewRad", "sxRad", "syRad", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", "rect", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "left", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawArcRad", "startAngleRad", "sweepAngleRad", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Canvas {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void clipPath-mtrdD-E$default(Canvas arg0, Path arg1, int arg2, int arg3, Object arg4) {
            Canvas.clipPath-mtrdD-E$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static void clipRect-N_I0leg$default(Canvas arg0, float arg1, float arg2, float arg3, float arg4, int arg5, int arg6, Object arg7) {
            Canvas.clipRect-N_I0leg$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        @Deprecated public static void clipRect-mtrdD-E(Canvas arg0, Rect arg1, int arg2) {
            arg0.clipRect-mtrdD-E(arg1, arg2);
        }

        public static void clipRect-mtrdD-E$default(Canvas arg0, Rect arg1, int arg2, int arg3, Object arg4) {
            Canvas.clipRect-mtrdD-E$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static void drawArc(Canvas arg0, Rect arg1, float arg2, float arg3, boolean arg4, Paint arg5) {
            arg0.drawArc(arg1, arg2, arg3, arg4, arg5);
        }

        @Deprecated public static void drawArcRad(Canvas arg0, Rect arg1, float arg2, float arg3, boolean arg4, Paint arg5) {
            arg0.drawArcRad(arg1, arg2, arg3, arg4, arg5);
        }

        public static void drawImageRect-HPBpro0$default(Canvas arg0, ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, Paint arg10, int arg11, Object arg12) {
            Canvas.drawImageRect-HPBpro0$default(arg0, arg1, arg2, arg4, arg6, arg8, arg10, arg11, arg12);
        }

        @Deprecated public static void drawOval(Canvas arg0, Rect arg1, Paint arg2) {
            arg0.drawOval(arg1, arg2);
        }

        @Deprecated public static void drawRect(Canvas arg0, Rect arg1, Paint arg2) {
            arg0.drawRect(arg1, arg2);
        }

        public static void scale$default(Canvas arg0, float arg1, float arg2, int arg3, Object arg4) {
            Canvas.scale$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static void skewRad(Canvas arg0, float arg1, float arg2) {
            arg0.skewRad(arg1, arg2);
        }
    }

    static void access$clipRect-mtrdD-E$jd(Canvas arg0, Rect arg1, int arg2) {
        super.clipRect-mtrdD-E(arg1, arg2);
    }

    static void access$drawArc$jd(Canvas arg0, Rect arg1, float arg2, float arg3, boolean arg4, Paint arg5) {
        super.drawArc(arg1, arg2, arg3, arg4, arg5);
    }

    static void access$drawArcRad$jd(Canvas arg0, Rect arg1, float arg2, float arg3, boolean arg4, Paint arg5) {
        super.drawArcRad(arg1, arg2, arg3, arg4, arg5);
    }

    static void access$drawOval$jd(Canvas arg0, Rect arg1, Paint arg2) {
        super.drawOval(arg1, arg2);
    }

    static void access$drawRect$jd(Canvas arg0, Rect arg1, Paint arg2) {
        super.drawRect(arg1, arg2);
    }

    static void access$skewRad$jd(Canvas arg0, float arg1, float arg2) {
        super.skewRad(arg1, arg2);
    }

    void clipPath-mtrdD-E(Path arg1, int arg2);

    static void clipPath-mtrdD-E$default(Canvas arg0, Path arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = ClipOp.Companion.getIntersect-rtfAjoo();
            }

            arg0.clipPath-mtrdD-E(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
    }

    void clipRect-N_I0leg(float arg1, float arg2, float arg3, float arg4, int arg5);

    static void clipRect-N_I0leg$default(Canvas arg6, float arg7, float arg8, float arg9, float arg10, int arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            if((arg12 & 16) != 0) {
                arg11 = ClipOp.Companion.getIntersect-rtfAjoo();
            }

            arg6.clipRect-N_I0leg(arg7, arg8, arg9, arg10, arg11);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
    }

    default void clipRect-mtrdD-E(Rect arg7, int arg8) {
        this.clipRect-N_I0leg(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom(), arg8);
    }

    static void clipRect-mtrdD-E$default(Canvas arg0, Rect arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = ClipOp.Companion.getIntersect-rtfAjoo();
            }

            arg0.clipRect-mtrdD-E(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
    }

    void concat-58bKbWc(float[] arg1);

    void disableZ();

    default void drawArc(Rect arg10, float arg11, float arg12, boolean arg13, Paint arg14) {
        this.drawArc(arg10.getLeft(), arg10.getTop(), arg10.getRight(), arg10.getBottom(), arg11, arg12, arg13, arg14);
    }

    void drawArc(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, boolean arg7, Paint arg8);

    default void drawArcRad(Rect arg1, float arg2, float arg3, boolean arg4, Paint arg5) {
        this.drawArc(arg1, DegreesKt.degrees(arg2), DegreesKt.degrees(arg3), arg4, arg5);
    }

    void drawCircle-9KIMszo(long arg1, float arg2, Paint arg3);

    void drawImage-d-4ec7I(ImageBitmap arg1, long arg2, Paint arg3);

    void drawImageRect-HPBpro0(ImageBitmap arg1, long arg2, long arg3, long arg4, long arg5, Paint arg6);

    static void drawImageRect-HPBpro0$default(Canvas arg13, ImageBitmap arg14, long arg15, long arg17, long arg19, long arg21, Paint arg23, int arg24, Object arg25) {
        if(arg25 == null) {
            long v4 = (arg24 & 2) != 0 ? IntOffset.Companion.getZero-nOcc-ac() : arg15;
            long v6 = (arg24 & 4) != 0 ? IntSize.constructor-impl((((long)arg14.getHeight())) & 0xFFFFFFFFL | (((long)arg14.getWidth())) << 0x20) : arg17;
            long v8 = (arg24 & 8) != 0 ? IntOffset.Companion.getZero-nOcc-ac() : arg19;
            long v10 = (arg24 & 16) != 0 ? v6 : arg21;
            arg13.drawImageRect-HPBpro0(arg14, v4, v6, v8, v10, arg23);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
    }

    void drawLine-Wko1d7g(long arg1, long arg2, Paint arg3);

    default void drawOval(Rect arg7, Paint arg8) {
        this.drawOval(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom(), arg8);
    }

    void drawOval(float arg1, float arg2, float arg3, float arg4, Paint arg5);

    void drawPath(Path arg1, Paint arg2);

    void drawPoints-O7TthRY(int arg1, List arg2, Paint arg3);

    void drawRawPoints-O7TthRY(int arg1, float[] arg2, Paint arg3);

    default void drawRect(Rect arg7, Paint arg8) {
        this.drawRect(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom(), arg8);
    }

    void drawRect(float arg1, float arg2, float arg3, float arg4, Paint arg5);

    void drawRoundRect(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, Paint arg7);

    void drawVertices-TPEHhCM(Vertices arg1, int arg2, Paint arg3);

    void enableZ();

    void restore();

    void rotate(float arg1);

    void save();

    void saveLayer(Rect arg1, Paint arg2);

    void scale(float arg1, float arg2);

    static void scale$default(Canvas arg0, float arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = arg1;
            }

            arg0.scale(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
    }

    void skew(float arg1, float arg2);

    default void skewRad(float arg1, float arg2) {
        this.skew(DegreesKt.degrees(arg1), DegreesKt.degrees(arg2));
    }

    void translate(float arg1, float arg2);
}

