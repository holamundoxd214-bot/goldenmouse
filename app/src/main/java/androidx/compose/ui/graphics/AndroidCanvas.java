package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region$Op;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0010H\u0016J\u0018\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0016J\u0018\u0010\u001B\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u0019H\u0016J\u0010\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u0019H\u0016J\u0018\u0010 \u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u0019H\u0016J\u0017\u0010!\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020#H\u0016¢\u0006\u0004\b$\u0010%J7\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u00192\u0006\u0010*\u001A\u00020\u00192\u0006\u0010+\u001A\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u001F\u0010/\u001A\u00020\u00102\u0006\u00100\u001A\u0002012\u0006\u0010+\u001A\u00020,H\u0016¢\u0006\u0004\b2\u00103J\u0011\u00104\u001A\u000205*\u00020,¢\u0006\u0004\b6\u00107J\'\u00108\u001A\u00020\u00102\u0006\u00109\u001A\u00020:2\u0006\u0010;\u001A\u00020:2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b<\u0010=J0\u0010>\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u00192\u0006\u0010*\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J@\u0010?\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u00192\u0006\u0010*\u001A\u00020\u00192\u0006\u0010@\u001A\u00020\u00192\u0006\u0010A\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J0\u0010B\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u00192\u0006\u0010*\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\'\u0010C\u001A\u00020\u00102\u0006\u0010D\u001A\u00020:2\u0006\u0010E\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\bF\u0010GJH\u0010H\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u00192\u0006\u0010*\u001A\u00020\u00192\u0006\u0010I\u001A\u00020\u00192\u0006\u0010J\u001A\u00020\u00192\u0006\u0010K\u001A\u00020L2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010M\u001A\u00020\u00102\u0006\u00100\u001A\u0002012\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\'\u0010N\u001A\u00020\u00102\u0006\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020:2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\bR\u0010SJ?\u0010T\u001A\u00020\u00102\u0006\u0010O\u001A\u00020P2\u0006\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020X2\u0006\u0010Y\u001A\u00020V2\u0006\u0010Z\u001A\u00020X2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b[\u0010\\J-\u0010]\u001A\u00020\u00102\u0006\u0010^\u001A\u00020_2\f\u0010`\u001A\b\u0012\u0004\u0012\u00020:0a2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\bb\u0010cJ\b\u0010d\u001A\u00020\u0010H\u0016J\b\u0010e\u001A\u00020\u0010H\u0016J\u001E\u0010]\u001A\u00020\u00102\f\u0010`\u001A\b\u0012\u0004\u0012\u00020:0a2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J&\u0010f\u001A\u00020\u00102\f\u0010`\u001A\b\u0012\u0004\u0012\u00020:0a2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010g\u001A\u00020hH\u0002J\'\u0010i\u001A\u00020\u00102\u0006\u0010^\u001A\u00020_2\u0006\u0010`\u001A\u00020j2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\bk\u0010lJ \u0010i\u001A\u00020\u00102\u0006\u0010`\u001A\u00020j2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010g\u001A\u00020hH\u0002J \u0010m\u001A\u00020\u00102\u0006\u0010`\u001A\u00020j2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010g\u001A\u00020hH\u0002J\'\u0010n\u001A\u00020\u00102\u0006\u0010o\u001A\u00020p2\u0006\u0010q\u001A\u00020r2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\bs\u0010tR(\u0010\u0004\u001A\u00060\u0005j\u0002`\u00068\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006u"}, d2={"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "Landroid/graphics/Rect;", "dstRect", "save", "", "restore", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", "left", "top", "right", "bottom", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "drawLines", "stepBy", "", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidCanvas implements Canvas {
    public static final int $stable = 8;
    private Rect dstRect;
    private android.graphics.Canvas internalCanvas;
    private Rect srcRect;

    static {
    }

    public AndroidCanvas() {
        super();
        this.internalCanvas = AndroidCanvas_androidKt.access$getEmptyCanvas$p();
    }

    public void clipPath-mtrdD-E(Path arg3, int arg4) {
        android.graphics.Canvas v0 = this.internalCanvas;
        if((arg3 instanceof AndroidPath)) {
            v0.clipPath(((AndroidPath)arg3).getInternalPath(), this.toRegionOp--7u2Bmg(arg4));
            return;
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public void clipRect-N_I0leg(float arg2, float arg3, float arg4, float arg5, int arg6) {
        this.internalCanvas.clipRect(arg2, arg3, arg4, arg5, this.toRegionOp--7u2Bmg(arg6));
    }

    public void concat-58bKbWc(float[] arg2) {
        if(!MatrixKt.isIdentity-58bKbWc(arg2)) {
            Matrix v0 = new Matrix();
            AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(v0, arg2);
            this.internalCanvas.concat(v0);
        }
    }

    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    public void drawArc(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, boolean arg7, Paint arg8) {
        this.internalCanvas.drawArc(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8.asFrameworkPaint());
    }

    public void drawCircle-9KIMszo(long arg4, float arg6, Paint arg7) {
        this.internalCanvas.drawCircle(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))), arg6, arg7.asFrameworkPaint());
    }

    public void drawImage-d-4ec7I(ImageBitmap arg4, long arg5, Paint arg7) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(arg4), Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))), arg7.asFrameworkPaint());
    }

    public void drawImageRect-HPBpro0(ImageBitmap arg7, long arg8, long arg10, long arg12, long arg14, Paint arg16) {
        if(this.srcRect == null) {
            this.srcRect = new Rect();
            this.dstRect = new Rect();
        }

        android.graphics.Canvas v0 = this.internalCanvas;
        Bitmap v7 = AndroidImageBitmap_androidKt.asAndroidBitmap(arg7);
        Rect v1 = this.srcRect;
        Intrinsics.checkNotNull(v1);
        v1.left = IntOffset.getX-impl(arg8);
        v1.top = IntOffset.getY-impl(arg8);
        v1.right = IntOffset.getX-impl(arg8) + (((int)(arg10 >> 0x20)));
        v1.bottom = IntOffset.getY-impl(arg8) + (((int)(arg10 & 0xFFFFFFFFL)));
        Rect v6 = this.dstRect;
        Intrinsics.checkNotNull(v6);
        v6.left = IntOffset.getX-impl(arg12);
        v6.top = IntOffset.getY-impl(arg12);
        v6.right = IntOffset.getX-impl(arg12) + (((int)(arg14 >> 0x20)));
        v6.bottom = IntOffset.getY-impl(arg12) + (((int)(arg14 & 0xFFFFFFFFL)));
        v0.drawBitmap(v7, v1, v6, arg16.asFrameworkPaint());
    }

    public void drawLine-Wko1d7g(long arg7, long arg9, Paint arg11) {
        this.internalCanvas.drawLine(Float.intBitsToFloat(((int)(arg7 >> 0x20))), Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg9 >> 0x20))), Float.intBitsToFloat(((int)(arg9 & 0xFFFFFFFFL))), arg11.asFrameworkPaint());
    }

    private final void drawLines(List arg13, Paint arg14, int arg15) {
        if(arg13.size() >= 2) {
            android.graphics.Paint v7 = arg14.asFrameworkPaint();
            int v14;
            for(v14 = 0; v14 < arg13.size() - 1; v14 += arg15) {
                long v0 = arg13.get(v14).unbox-impl();
                long v3 = arg13.get(v14 + 1).unbox-impl();
                this.internalCanvas.drawLine(Float.intBitsToFloat(((int)(v0 >> 0x20))), Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v3 >> 0x20))), Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))), v7);
            }
        }
    }

    public void drawOval(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        this.internalCanvas.drawOval(arg1, arg2, arg3, arg4, arg5.asFrameworkPaint());
    }

    public void drawPath(Path arg2, Paint arg3) {
        android.graphics.Canvas v1 = this.internalCanvas;
        if((arg2 instanceof AndroidPath)) {
            v1.drawPath(((AndroidPath)arg2).getInternalPath(), arg3.asFrameworkPaint());
            return;
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    private final void drawPoints(List arg9, Paint arg10) {
        int v0 = arg9.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            long v2 = arg9.get(v1).unbox-impl();
            this.internalCanvas.drawPoint(Float.intBitsToFloat(((int)(v2 >> 0x20))), Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))), arg10.asFrameworkPaint());
        }
    }

    public void drawPoints-O7TthRY(int arg2, List arg3, Paint arg4) {
        if(PointMode.equals-impl0(arg2, PointMode.Companion.getLines-r_lszbg())) {
            this.drawLines(arg3, arg4, 2);
            return;
        }

        if(PointMode.equals-impl0(arg2, PointMode.Companion.getPolygon-r_lszbg())) {
            this.drawLines(arg3, arg4, 1);
            return;
        }

        if(PointMode.equals-impl0(arg2, PointMode.Companion.getPoints-r_lszbg())) {
            this.drawPoints(arg3, arg4);
        }
    }

    private final void drawRawLines(float[] arg8, Paint arg9, int arg10) {
        if(arg8.length >= 4 && arg8.length % 2 == 0) {
            android.graphics.Paint v6 = arg9.asFrameworkPaint();
            int v9;
            for(v9 = 0; v9 < arg8.length - 3; v9 += arg10 * 2) {
                this.internalCanvas.drawLine(arg8[v9], arg8[v9 + 1], arg8[v9 + 2], arg8[v9 + 3], v6);
            }
        }
    }

    private final void drawRawPoints(float[] arg5, Paint arg6, int arg7) {
        if(arg5.length % 2 == 0) {
            android.graphics.Paint v6 = arg6.asFrameworkPaint();
            int v0;
            for(v0 = 0; v0 < arg5.length - 1; v0 += arg7) {
                this.internalCanvas.drawPoint(arg5[v0], arg5[v0 + 1], v6);
            }
        }
    }

    public void drawRawPoints-O7TthRY(int arg3, float[] arg4, Paint arg5) {
        int v1 = 2;
        if(arg4.length % v1 == 0) {
            if(PointMode.equals-impl0(arg3, PointMode.Companion.getLines-r_lszbg())) {
                this.drawRawLines(arg4, arg5, v1);
                return;
            }

            if(PointMode.equals-impl0(arg3, PointMode.Companion.getPolygon-r_lszbg())) {
                this.drawRawLines(arg4, arg5, 1);
                return;
            }

            if(PointMode.equals-impl0(arg3, PointMode.Companion.getPoints-r_lszbg())) {
                this.drawRawPoints(arg4, arg5, v1);
            }

            return;
        }

        throw new IllegalArgumentException("points must have an even number of values");
    }

    public void drawRect(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        this.internalCanvas.drawRect(arg1, arg2, arg3, arg4, arg5.asFrameworkPaint());
    }

    public void drawRoundRect(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, Paint arg7) {
        this.internalCanvas.drawRoundRect(arg1, arg2, arg3, arg4, arg5, arg6, arg7.asFrameworkPaint());
    }

    public void drawVertices-TPEHhCM(Vertices arg14, int arg15, Paint arg16) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.toAndroidVertexMode-JOOmi9M(arg14.getVertexMode-c2xauaI()), arg14.getPositions().length, arg14.getPositions(), 0, arg14.getTextureCoordinates(), 0, arg14.getColors(), 0, arg14.getIndices(), 0, arg14.getIndices().length, arg16.asFrameworkPaint());
    }

    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public static void getInternalCanvas$annotations() {
    }

    public void restore() {
        this.internalCanvas.restore();
    }

    public void rotate(float arg1) {
        this.internalCanvas.rotate(arg1);
    }

    public void save() {
        this.internalCanvas.save();
    }

    public void saveLayer(androidx.compose.ui.geometry.Rect arg8, Paint arg9) {
        this.internalCanvas.saveLayer(arg8.getLeft(), arg8.getTop(), arg8.getRight(), arg8.getBottom(), arg9.asFrameworkPaint(), 0x1F);
    }

    public void scale(float arg1, float arg2) {
        this.internalCanvas.scale(arg1, arg2);
    }

    public final void setInternalCanvas(android.graphics.Canvas arg1) {
        this.internalCanvas = arg1;
    }

    public void skew(float arg1, float arg2) {
        this.internalCanvas.skew(arg1, arg2);
    }

    public final Region$Op toRegionOp--7u2Bmg(int arg1) {
        if(ClipOp.equals-impl0(arg1, ClipOp.Companion.getDifference-rtfAjoo())) {
            return Region$Op.DIFFERENCE;
        }

        return Region$Op.INTERSECT;
    }

    public void translate(float arg1, float arg2) {
        this.internalCanvas.translate(arg1, arg2);
    }
}

