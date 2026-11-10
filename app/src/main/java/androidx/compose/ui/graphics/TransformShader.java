package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0005H\u0002J\u0017\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R4\u0010\u0010\u001A\n\u0018\u00010\u000Ej\u0004\u0018\u0001`\u000F2\u000E\u0010\r\u001A\n\u0018\u00010\u000Ej\u0004\u0018\u0001`\u000F@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/TransformShader;", "", "<init>", "()V", "aMatrix", "Landroid/graphics/Matrix;", "obtainMatrix", "transform", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-Q8lPUPs", "([F)V", "value", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransformShader {
    public static final int $stable = 8;
    private Matrix aMatrix;
    private Shader shader;

    static {
    }

    public TransformShader() {
        super();
    }

    public final Shader getShader() {
        return this.shader;
    }

    private final Matrix obtainMatrix() {
        Matrix v0 = this.aMatrix;
        if(v0 == null) {
            v0 = new Matrix();
            this.aMatrix = v0;
        }

        return v0;
    }

    public final void setShader(Shader arg2) {
        Matrix v0 = this.aMatrix;
        if(v0 != null && arg2 != null) {
            arg2.setLocalMatrix(v0);
        }

        this.shader = arg2;
    }

    public final void transform-Q8lPUPs(float[] arg2) {
        Matrix v2;
        if(arg2 == null) {
            v2 = null;
            this.aMatrix = v2;
        }
        else {
            Matrix v0 = this.obtainMatrix();
            AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(v0, arg2);
            v2 = v0;
        }

        Shader v1 = this.shader;
        if(v1 != null) {
            v1.setLocalMatrix(v2);
        }
    }
}

