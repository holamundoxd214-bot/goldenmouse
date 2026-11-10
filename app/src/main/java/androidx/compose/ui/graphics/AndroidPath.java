package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import android.graphics.Path$FillType;
import android.graphics.Path$Op;
import android.graphics.RectF;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0016J\u0018\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u0018H\u0016J\u0018\u0010\u001D\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0016J\u0018\u0010\u001E\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u0018H\u0016J(\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u00182\u0006\u0010!\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u00182\u0006\u0010#\u001A\u00020\u0018H\u0016J(\u0010$\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u00182\u0006\u0010!\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u00182\u0006\u0010#\u001A\u00020\u0018H\u0016J(\u0010%\u001A\u00020\u00162\u0006\u0010&\u001A\u00020\u00182\u0006\u0010\'\u001A\u00020\u00182\u0006\u0010(\u001A\u00020\u00182\u0006\u0010)\u001A\u00020\u0018H\u0016J(\u0010*\u001A\u00020\u00162\u0006\u0010&\u001A\u00020\u00182\u0006\u0010\'\u001A\u00020\u00182\u0006\u0010(\u001A\u00020\u00182\u0006\u0010)\u001A\u00020\u0018H\u0016J8\u0010+\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u00182\u0006\u0010!\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u00182\u0006\u0010#\u001A\u00020\u00182\u0006\u0010,\u001A\u00020\u00182\u0006\u0010-\u001A\u00020\u0018H\u0016J8\u0010.\u001A\u00020\u00162\u0006\u0010&\u001A\u00020\u00182\u0006\u0010\'\u001A\u00020\u00182\u0006\u0010(\u001A\u00020\u00182\u0006\u0010)\u001A\u00020\u00182\u0006\u0010/\u001A\u00020\u00182\u0006\u00100\u001A\u00020\u0018H\u0016J(\u00101\u001A\u00020\u00162\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u00182\u0006\u00105\u001A\u00020\u00182\u0006\u00106\u001A\u000207H\u0016J\u0010\u00108\u001A\u00020\u00162\u0006\u00102\u001A\u000203H\u0016J\u0018\u00108\u001A\u00020\u00162\u0006\u00102\u001A\u0002032\u0006\u00109\u001A\u00020:H\u0016J\u0010\u0010;\u001A\u00020\u00162\u0006\u0010<\u001A\u000203H\u0016J\u0018\u0010;\u001A\u00020\u00162\u0006\u0010<\u001A\u0002032\u0006\u00109\u001A\u00020:H\u0016J\u0010\u0010=\u001A\u00020\u00162\u0006\u0010>\u001A\u00020?H\u0016J\u0018\u0010=\u001A\u00020\u00162\u0006\u0010>\u001A\u00020?2\u0006\u00109\u001A\u00020:H\u0016J \u0010@\u001A\u00020\u00162\u0006\u0010<\u001A\u0002032\u0006\u0010A\u001A\u00020\u00182\u0006\u0010B\u001A\u00020\u0018H\u0016J \u0010C\u001A\u00020\u00162\u0006\u0010<\u001A\u0002032\u0006\u00104\u001A\u00020\u00182\u0006\u00105\u001A\u00020\u0018H\u0016J\u001F\u0010D\u001A\u00020\u00162\u0006\u0010E\u001A\u00020\u00012\u0006\u0010F\u001A\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\b\u0010J\u001A\u00020\u0016H\u0016J\b\u0010K\u001A\u00020\u0016H\u0016J\b\u0010L\u001A\u00020\u0016H\u0016J\u0017\u0010M\u001A\u00020\u00162\u0006\u0010F\u001A\u00020GH\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001A\u00020\u00162\u0006\u0010Q\u001A\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\b\u0010U\u001A\u000203H\u0016J\'\u0010V\u001A\u0002072\u0006\u0010W\u001A\u00020\u00012\u0006\u0010X\u001A\u00020\u00012\u0006\u0010Y\u001A\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u0010\u0010b\u001A\u00020\u00162\u0006\u00102\u001A\u000203H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000F8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001A\u0010]\u001A\u0002078VX\u0096\u0004¢\u0006\f\u0012\u0004\b^\u0010_\u001A\u0004\b]\u0010`R\u0014\u0010a\u001A\u0002078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\ba\u0010`¨\u0006c"}, d2={"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "<init>", "(Landroid/graphics/Path;)V", "getInternalPath", "()Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "radii", "", "mMatrix", "Landroid/graphics/Matrix;", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "moveTo", "", "x", "", "y", "relativeMoveTo", "dx", "dy", "lineTo", "relativeLineTo", "quadraticBezierTo", "x1", "y1", "x2", "y2", "quadraticTo", "relativeQuadraticBezierTo", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "cubicTo", "x3", "y3", "relativeCubicTo", "dx3", "dy3", "arcTo", "rect", "Landroidx/compose/ui/geometry/Rect;", "startAngleDegrees", "sweepAngleDegrees", "forceMoveTo", "", "addRect", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addOval", "oval", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addArc", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "close", "reset", "rewind", "translate", "translate-k-4lQ0M", "(J)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "getBounds", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "isConvex", "isConvex$annotations", "()V", "()Z", "isEmpty", "validateRectangle", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPath implements Path {
    public static final int $stable = 8;
    private final android.graphics.Path internalPath;
    private Matrix mMatrix;
    private float[] radii;
    private RectF rectF;

    static {
    }

    public AndroidPath() {
        this(null, 1, null);
    }

    public AndroidPath(android.graphics.Path arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new android.graphics.Path();
        }

        this(arg1);
    }

    public AndroidPath(android.graphics.Path arg1) {
        super();
        this.internalPath = arg1;
    }

    public void addArc(Rect arg5, float arg6, float arg7) {
        this.validateRectangle(arg5);
        RectF v0 = this.rectF;
        if(v0 == null) {
            v0 = new RectF();
            this.rectF = v0;
        }

        Intrinsics.checkNotNull(v0);
        v0.set(arg5.getLeft(), arg5.getTop(), arg5.getRight(), arg5.getBottom());
        android.graphics.Path v5 = this.internalPath;
        RectF v4 = this.rectF;
        Intrinsics.checkNotNull(v4);
        v5.addArc(v4, arg6, arg7);
    }

    public void addArcRad(Rect arg1, float arg2, float arg3) {
        this.addArc(arg1, DegreesKt.degrees(arg2), DegreesKt.degrees(arg3));
    }

    public void addOval(Rect arg2) {
        this.addOval(arg2, Direction.CounterClockwise);
    }

    public void addOval(Rect arg5, Direction arg6) {
        RectF v0 = this.rectF;
        if(v0 == null) {
            v0 = new RectF();
            this.rectF = v0;
        }

        Intrinsics.checkNotNull(v0);
        v0.set(arg5.getLeft(), arg5.getTop(), arg5.getRight(), arg5.getBottom());
        android.graphics.Path v5 = this.internalPath;
        RectF v4 = this.rectF;
        Intrinsics.checkNotNull(v4);
        v5.addOval(v4, AndroidPath_androidKt.access$toPlatformPathDirection(arg6));
    }

    public void addPath-Uv8p0NA(Path arg4, long arg5) {
        android.graphics.Path v3 = this.internalPath;
        if((arg4 instanceof AndroidPath)) {
            v3.addPath(((AndroidPath)arg4).getInternalPath(), Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))));
            return;
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public void addRect(Rect arg2) {
        this.addRect(arg2, Direction.CounterClockwise);
    }

    public void addRect(Rect arg5, Direction arg6) {
        this.validateRectangle(arg5);
        RectF v0 = this.rectF;
        if(v0 == null) {
            v0 = new RectF();
            this.rectF = v0;
        }

        Intrinsics.checkNotNull(v0);
        v0.set(arg5.getLeft(), arg5.getTop(), arg5.getRight(), arg5.getBottom());
        android.graphics.Path v5 = this.internalPath;
        RectF v4 = this.rectF;
        Intrinsics.checkNotNull(v4);
        v5.addRect(v4, AndroidPath_androidKt.access$toPlatformPathDirection(arg6));
    }

    public void addRoundRect(RoundRect arg2) {
        this.addRoundRect(arg2, Direction.CounterClockwise);
    }

    public void addRoundRect(RoundRect arg7, Direction arg8) {
        RectF v0 = this.rectF;
        if(v0 == null) {
            v0 = new RectF();
            this.rectF = v0;
        }

        Intrinsics.checkNotNull(v0);
        v0.set(arg7.getLeft(), arg7.getTop(), arg7.getRight(), arg7.getBottom());
        float[] v0_1 = this.radii;
        if(v0_1 == null) {
            v0_1 = new float[8];
            this.radii = v0_1;
        }

        Intrinsics.checkNotNull(v0_1);
        v0_1[0] = Float.intBitsToFloat(((int)(arg7.getTopLeftCornerRadius-kKHJgLs() >> 0x20)));
        v0_1[1] = Float.intBitsToFloat(((int)(arg7.getTopLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
        v0_1[2] = Float.intBitsToFloat(((int)(arg7.getTopRightCornerRadius-kKHJgLs() >> 0x20)));
        v0_1[3] = Float.intBitsToFloat(((int)(arg7.getTopRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
        v0_1[4] = Float.intBitsToFloat(((int)(arg7.getBottomRightCornerRadius-kKHJgLs() >> 0x20)));
        v0_1[5] = Float.intBitsToFloat(((int)(arg7.getBottomRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
        v0_1[6] = Float.intBitsToFloat(((int)(arg7.getBottomLeftCornerRadius-kKHJgLs() >> 0x20)));
        v0_1[7] = Float.intBitsToFloat(((int)(arg7.getBottomLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
        android.graphics.Path v7 = this.internalPath;
        v0 = this.rectF;
        Intrinsics.checkNotNull(v0);
        float[] v6 = this.radii;
        Intrinsics.checkNotNull(v6);
        v7.addRoundRect(v0, v6, AndroidPath_androidKt.access$toPlatformPathDirection(arg8));
    }

    public void arcTo(Rect arg5, float arg6, float arg7, boolean arg8) {
        float v0 = arg5.getLeft();
        float v1 = arg5.getTop();
        float v2 = arg5.getRight();
        float v5 = arg5.getBottom();
        RectF v3 = this.rectF;
        if(v3 == null) {
            v3 = new RectF();
            this.rectF = v3;
        }

        Intrinsics.checkNotNull(v3);
        v3.set(v0, v1, v2, v5);
        android.graphics.Path v5_1 = this.internalPath;
        RectF v4 = this.rectF;
        Intrinsics.checkNotNull(v4);
        v5_1.arcTo(v4, arg6, arg7, arg8);
    }

    public void close() {
        this.internalPath.close();
    }

    public void cubicTo(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
        this.internalPath.cubicTo(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public Rect getBounds() {
        RectF v0 = this.rectF;
        if(v0 == null) {
            v0 = new RectF();
            this.rectF = v0;
        }

        Intrinsics.checkNotNull(v0);
        this.internalPath.computeBounds(v0, true);
        return new Rect(v0.left, v0.top, v0.right, v0.bottom);
    }

    public int getFillType-Rg-k1Os() {
        if(this.internalPath.getFillType() == Path$FillType.EVEN_ODD) {
            return PathFillType.Companion.getEvenOdd-Rg-k1Os();
        }

        return PathFillType.Companion.getNonZero-Rg-k1Os();
    }

    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    public static void isConvex$annotations() {
    }

    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    public void lineTo(float arg1, float arg2) {
        this.internalPath.lineTo(arg1, arg2);
    }

    public void moveTo(float arg1, float arg2) {
        this.internalPath.moveTo(arg1, arg2);
    }

    public boolean op-N5in7k0(Path arg3, Path arg4, int arg5) {
        Path$Op v5;
        if(PathOperation.equals-impl0(arg5, PathOperation.Companion.getDifference-b3I0S0c())) {
            v5 = Path$Op.DIFFERENCE;
        }
        else if(PathOperation.equals-impl0(arg5, PathOperation.Companion.getIntersect-b3I0S0c())) {
            v5 = Path$Op.INTERSECT;
        }
        else if(PathOperation.equals-impl0(arg5, PathOperation.Companion.getReverseDifference-b3I0S0c())) {
            v5 = Path$Op.REVERSE_DIFFERENCE;
        }
        else if(PathOperation.equals-impl0(arg5, PathOperation.Companion.getUnion-b3I0S0c())) {
            v5 = Path$Op.UNION;
        }
        else {
            v5 = Path$Op.XOR;
        }

        android.graphics.Path v2 = this.internalPath;
        String v1 = "Unable to obtain android.graphics.Path";
        if((arg3 instanceof AndroidPath)) {
            android.graphics.Path v3 = ((AndroidPath)arg3).getInternalPath();
            if((arg4 instanceof AndroidPath)) {
                return v2.op(v3, ((AndroidPath)arg4).getInternalPath(), v5);
            }

            throw new UnsupportedOperationException(v1);
        }

        throw new UnsupportedOperationException(v1);
    }

    public void quadraticBezierTo(float arg1, float arg2, float arg3, float arg4) {
        this.internalPath.quadTo(arg1, arg2, arg3, arg4);
    }

    public void quadraticTo(float arg1, float arg2, float arg3, float arg4) {
        this.internalPath.quadTo(arg1, arg2, arg3, arg4);
    }

    public void relativeCubicTo(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
        this.internalPath.rCubicTo(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void relativeLineTo(float arg1, float arg2) {
        this.internalPath.rLineTo(arg1, arg2);
    }

    public void relativeMoveTo(float arg1, float arg2) {
        this.internalPath.rMoveTo(arg1, arg2);
    }

    public void relativeQuadraticBezierTo(float arg1, float arg2, float arg3, float arg4) {
        this.internalPath.rQuadTo(arg1, arg2, arg3, arg4);
    }

    public void relativeQuadraticTo(float arg1, float arg2, float arg3, float arg4) {
        this.internalPath.rQuadTo(arg1, arg2, arg3, arg4);
    }

    public void reset() {
        this.internalPath.reset();
    }

    public void rewind() {
        this.internalPath.rewind();
    }

    public void setFillType-oQ8Xj4U(int arg2) {
        android.graphics.Path v1 = this.internalPath;
        Path$FillType v2 = PathFillType.equals-impl0(arg2, PathFillType.Companion.getEvenOdd-Rg-k1Os()) ? Path$FillType.EVEN_ODD : Path$FillType.WINDING;
        v1.setFillType(v2);
    }

    public void transform-58bKbWc(float[] arg2) {
        Matrix v0 = this.mMatrix;
        if(v0 == null) {
            v0 = new Matrix();
            this.mMatrix = v0;
        }

        Intrinsics.checkNotNull(v0);
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(v0, arg2);
        android.graphics.Path v2 = this.internalPath;
        Matrix v1 = this.mMatrix;
        Intrinsics.checkNotNull(v1);
        v2.transform(v1);
    }

    public void translate-k-4lQ0M(long arg5) {
        Matrix v0 = this.mMatrix;
        if(v0 == null) {
            this.mMatrix = new Matrix();
        }
        else {
            Intrinsics.checkNotNull(v0);
            v0.reset();
        }

        v0 = this.mMatrix;
        Intrinsics.checkNotNull(v0);
        v0.setTranslate(Float.intBitsToFloat(((int)(arg5 >> 0x20))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))));
        android.graphics.Path v5 = this.internalPath;
        Matrix v4 = this.mMatrix;
        Intrinsics.checkNotNull(v4);
        v5.transform(v4);
    }

    private final void validateRectangle(Rect arg1) {
        if(!Float.isNaN(arg1.getLeft()) && !Float.isNaN(arg1.getTop()) && !Float.isNaN(arg1.getRight())) {
            if(Float.isNaN(arg1.getBottom())) {
            }
            else {
                return;
            }
        }

        AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
    }
}

