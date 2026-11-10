package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0004*\u00020\u0001H\u0086\b\u001A\u001A\u0010\u0005\u001A\u00020\u00012\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0007\u001A\u001A\u0010\t\u001A\u00020\u00012\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\u0007\u001A\"\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\u00072\b\b\u0002\u0010\u000F\u001A\u00020\u0007¨\u0006\u0010"}, d2={"times", "Landroid/graphics/Matrix;", "m", "values", "", "translationMatrix", "tx", "", "ty", "scaleMatrix", "sx", "sy", "rotationMatrix", "degrees", "px", "py", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MatrixKt {
    public static final Matrix rotationMatrix(float arg1, float arg2, float arg3) {
        Matrix v0 = new Matrix();
        v0.setRotate(arg1, arg2, arg3);
        return v0;
    }

    public static Matrix rotationMatrix$default(float arg1, float arg2, float arg3, int arg4, Object arg5) {
        return MatrixKt.rotationMatrix(arg1, 0f, 0f);
    }

    public static final Matrix scaleMatrix(float arg1, float arg2) {
        Matrix v0 = new Matrix();
        v0.setScale(arg1, arg2);
        return v0;
    }

    public static Matrix scaleMatrix$default(float arg1, float arg2, int arg3, Object arg4) {
        float v0 = 1f;
        if((arg3 & 1) != 0) {
            arg1 = v0;
        }

        if((arg3 & 2) != 0) {
            arg2 = v0;
        }

        return MatrixKt.scaleMatrix(arg1, arg2);
    }

    public static final Matrix times(Matrix arg1, Matrix arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "m");
        Matrix v0 = new Matrix(arg1);
        v0.preConcat(arg2);
        return v0;
    }

    public static final Matrix translationMatrix(float arg1, float arg2) {
        Matrix v0 = new Matrix();
        v0.setTranslate(arg1, arg2);
        return v0;
    }

    public static Matrix translationMatrix$default(float arg1, float arg2, int arg3, Object arg4) {
        return MatrixKt.translationMatrix(0f, 0f);
    }

    public static final float[] values(Matrix arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        float[] v0 = new float[9];
        arg1.getValues(v0);
        return v0;
    }
}

