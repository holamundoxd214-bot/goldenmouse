package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Vertices;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0005H\u0016J\u0018\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0018\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016J\u0018\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016J\u0010\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u000EH\u0016J\u0018\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016J\u0017\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ7\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u001F\u0010$\u001A\u00020\u00052\u0006\u0010%\u001A\u00020&2\u0006\u0010 \u001A\u00020!H\u0016¢\u0006\u0004\b\'\u0010(J\'\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b-\u0010.J0\u0010/\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000BH\u0016J@\u00100\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000E2\u0006\u00101\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000BH\u0016J0\u00103\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\'\u00104\u001A\u00020\u00052\u0006\u00105\u001A\u00020+2\u0006\u00106\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b7\u00108JH\u00109\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000E2\u0006\u0010:\u001A\u00020\u000E2\u0006\u0010;\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020=2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0018\u0010>\u001A\u00020\u00052\u0006\u0010%\u001A\u00020&2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\'\u0010?\u001A\u00020\u00052\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020+2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\bC\u0010DJ?\u0010E\u001A\u00020\u00052\u0006\u0010@\u001A\u00020A2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020I2\u0006\u0010J\u001A\u00020G2\u0006\u0010K\u001A\u00020I2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\bL\u0010MJ-\u0010N\u001A\u00020\u00052\u0006\u0010O\u001A\u00020P2\f\u0010Q\u001A\b\u0012\u0004\u0012\u00020+0R2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\bS\u0010TJ\'\u0010U\u001A\u00020\u00052\u0006\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020V2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\bW\u0010XJ\'\u0010Y\u001A\u00020\u00052\u0006\u0010Z\u001A\u00020[2\u0006\u0010\\\u001A\u00020]2\u0006\u0010\n\u001A\u00020\u000BH\u0016¢\u0006\u0004\b^\u0010_J\b\u0010`\u001A\u00020\u0005H\u0016J\b\u0010a\u001A\u00020\u0005H\u0016¨\u0006b"}, d2={"Landroidx/compose/ui/graphics/drawscope/EmptyCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", "save", "", "restore", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", "left", "top", "right", "bottom", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmptyCanvas implements Canvas {
    public static final int $stable;
    public static final EmptyCanvas INSTANCE;

    static {
        EmptyCanvas.INSTANCE = new EmptyCanvas();
    }

    private EmptyCanvas() {
        super();
    }

    public void clipPath-mtrdD-E(Path arg1, int arg2) {
        throw new UnsupportedOperationException();
    }

    public void clipRect-N_I0leg(float arg1, float arg2, float arg3, float arg4, int arg5) {
        throw new UnsupportedOperationException();
    }

    public void concat-58bKbWc(float[] arg1) {
        throw new UnsupportedOperationException();
    }

    public void disableZ() {
        throw new UnsupportedOperationException();
    }

    public void drawArc(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, boolean arg7, Paint arg8) {
        throw new UnsupportedOperationException();
    }

    public void drawCircle-9KIMszo(long arg1, float arg3, Paint arg4) {
        throw new UnsupportedOperationException();
    }

    public void drawImage-d-4ec7I(ImageBitmap arg1, long arg2, Paint arg4) {
        throw new UnsupportedOperationException();
    }

    public void drawImageRect-HPBpro0(ImageBitmap arg1, long arg2, long arg4, long arg6, long arg8, Paint arg10) {
        throw new UnsupportedOperationException();
    }

    public void drawLine-Wko1d7g(long arg1, long arg3, Paint arg5) {
        throw new UnsupportedOperationException();
    }

    public void drawOval(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        throw new UnsupportedOperationException();
    }

    public void drawPath(Path arg1, Paint arg2) {
        throw new UnsupportedOperationException();
    }

    public void drawPoints-O7TthRY(int arg1, List arg2, Paint arg3) {
        throw new UnsupportedOperationException();
    }

    public void drawRawPoints-O7TthRY(int arg1, float[] arg2, Paint arg3) {
        throw new UnsupportedOperationException();
    }

    public void drawRect(float arg1, float arg2, float arg3, float arg4, Paint arg5) {
        throw new UnsupportedOperationException();
    }

    public void drawRoundRect(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, Paint arg7) {
        throw new UnsupportedOperationException();
    }

    public void drawVertices-TPEHhCM(Vertices arg1, int arg2, Paint arg3) {
        throw new UnsupportedOperationException();
    }

    public void enableZ() {
        throw new UnsupportedOperationException();
    }

    public void restore() {
        throw new UnsupportedOperationException();
    }

    public void rotate(float arg1) {
        throw new UnsupportedOperationException();
    }

    public void save() {
        throw new UnsupportedOperationException();
    }

    public void saveLayer(Rect arg1, Paint arg2) {
        throw new UnsupportedOperationException();
    }

    public void scale(float arg1, float arg2) {
        throw new UnsupportedOperationException();
    }

    public void skew(float arg1, float arg2) {
        throw new UnsupportedOperationException();
    }

    public void translate(float arg1, float arg2) {
        throw new UnsupportedOperationException();
    }
}

