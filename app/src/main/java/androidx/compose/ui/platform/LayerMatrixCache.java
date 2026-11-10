package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.MatrixKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u00126\u0010\u0003\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\u0017\u001A\u00020\nJ\u0006\u0010\u0018\u001A\u00020\nJ\u0015\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00028\u0000¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001C\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0007\u001A\u00028\u0000¢\u0006\u0004\b\u001D\u0010\u001BJ\u001B\u0010\u001E\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020 ¢\u0006\u0002\u0010!J\u001B\u0010\"\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020 ¢\u0006\u0002\u0010!J\u001D\u0010\u001E\u001A\u00020#2\u0006\u0010\u0007\u001A\u00028\u00002\u0006\u0010$\u001A\u00020#¢\u0006\u0004\b%\u0010&J\u001D\u0010\"\u001A\u00020#2\u0006\u0010\u0007\u001A\u00028\u00002\u0006\u0010$\u001A\u00020#¢\u0006\u0004\b\'\u0010&R>\u0010\u0003\u001A2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006("}, d2={"Landroidx/compose/ui/platform/LayerMatrixCache;", "T", "", "getMatrix", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "target", "Landroid/graphics/Matrix;", "matrix", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "androidMatrixCache", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "inverseMatrixCache", "isDirty", "", "isInverseDirty", "isInverseValid", "isIdentity", "reset", "invalidate", "calculateMatrix", "calculateMatrix-GrdbGEg", "(Ljava/lang/Object;)[F", "calculateInverseMatrix", "calculateInverseMatrix-bWbORWo", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "(Ljava/lang/Object;Landroidx/compose/ui/geometry/MutableRect;)V", "mapInverse", "Landroidx/compose/ui/geometry/Offset;", "offset", "map-R5De75A", "(Ljava/lang/Object;J)J", "mapInverse-R5De75A", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayerMatrixCache {
    public static final int $stable = 8;
    private Matrix androidMatrixCache;
    private final Function2 getMatrix;
    private float[] inverseMatrixCache;
    private boolean isDirty;
    private boolean isIdentity;
    private boolean isInverseDirty;
    private boolean isInverseValid;
    private float[] matrixCache;

    static {
    }

    public LayerMatrixCache(Function2 arg3) {
        super();
        this.getMatrix = arg3;
        this.matrixCache = androidx.compose.ui.graphics.Matrix.constructor-impl$default(null, 1, null);
        this.inverseMatrixCache = androidx.compose.ui.graphics.Matrix.constructor-impl$default(null, 1, null);
        this.isInverseValid = true;
        this.isIdentity = true;
    }

    public final float[] calculateInverseMatrix-bWbORWo(Object arg3) {
        float[] v0 = this.inverseMatrixCache;
        if(this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.invertTo-JiSxe2E(this.calculateMatrix-GrdbGEg(arg3), v0);
            this.isInverseDirty = false;
        }

        if(this.isInverseValid) {
            return v0;
        }

        return null;
    }

    public final float[] calculateMatrix-GrdbGEg(Object arg4) {
        float[] v0 = this.matrixCache;
        if(!this.isDirty) {
            return v0;
        }

        Matrix v1 = this.androidMatrixCache;
        if(v1 == null) {
            v1 = new Matrix();
            this.androidMatrixCache = v1;
        }

        this.getMatrix.invoke(arg4, v1);
        AndroidMatrixConversions_androidKt.setFrom-tU-YjHk(v0, v1);
        this.isDirty = false;
        this.isIdentity = MatrixKt.isIdentity-58bKbWc(v0);
        return v0;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }

    public final void map(Object arg1, MutableRect arg2) {
        float[] v1 = this.calculateMatrix-GrdbGEg(arg1);
        if(!this.isIdentity) {
            androidx.compose.ui.graphics.Matrix.map-impl(v1, arg2);
        }
    }

    public final long map-R5De75A(Object arg1, long arg2) {
        float[] v1 = this.calculateMatrix-GrdbGEg(arg1);
        if(!this.isIdentity) {
            return androidx.compose.ui.graphics.Matrix.map-MK-Hz9U(v1, arg2);
        }

        return arg2;
    }

    public final void mapInverse(Object arg1, MutableRect arg2) {
        float[] v1 = this.calculateInverseMatrix-bWbORWo(arg1);
        if(v1 == null) {
            arg2.set(0f, 0f, 0f, 0f);
            return;
        }

        if(!this.isIdentity) {
            androidx.compose.ui.graphics.Matrix.map-impl(v1, arg2);
        }
    }

    public final long mapInverse-R5De75A(Object arg1, long arg2) {
        float[] v1 = this.calculateInverseMatrix-bWbORWo(arg1);
        if(v1 == null) {
            return Offset.Companion.getInfinite-F1C5BW0();
        }

        if(!this.isIdentity) {
            return androidx.compose.ui.graphics.Matrix.map-MK-Hz9U(v1, arg2);
        }

        return arg2;
    }

    public final void reset() {
        this.isDirty = false;
        this.isInverseDirty = false;
        this.isIdentity = true;
        this.isInverseValid = true;
        androidx.compose.ui.graphics.Matrix.reset-impl(this.matrixCache);
        androidx.compose.ui.graphics.Matrix.reset-impl(this.inverseMatrixCache);
    }
}

