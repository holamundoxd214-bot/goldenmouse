package androidx.graphics.path;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00122\b\b\u0002\u0010\u0014\u001A\u00020\u0004J1\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0012H\u0082 J\u0018\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0010\u001A\u00020\r2\b\b\u0002\u0010\u0014\u001A\u00020\u0004R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0006R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/graphics/path/ConicConverter;", "", "()V", "currentQuadratic", "", "getCurrentQuadratic", "()I", "setCurrentQuadratic", "(I)V", "<set-?>", "quadraticCount", "getQuadraticCount", "quadraticData", "", "convert", "", "points", "weight", "", "tolerance", "offset", "internalConicToQuadratics", "conicPoints", "quadraticPoints", "nextQuadratic", "", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public final class ConicConverter {
    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData;

    public ConicConverter() {
        super();
        this.quadraticData = new float[130];
    }

    public final void convert(float[] arg8, float arg9, float arg10, int arg11) {
        Intrinsics.checkNotNullParameter(arg8, "points");
        ConicConverter v1 = this;
        int v7 = v1.internalConicToQuadratics(arg8, arg11, this.quadraticData, arg9, arg10);
        ConicConverter v0 = v1;
        float[] v1_1 = arg8;
        int v2 = arg11;
        float v4 = arg9;
        float v5 = arg10;
        v0.quadraticCount = v7;
        v7 = v7 * 4 + 2;
        if(v7 > v0.quadraticData.length) {
            float[] v3 = new float[v7];
            v0.quadraticData = v3;
            v0.quadraticCount = v0.internalConicToQuadratics(v1_1, v2, v3, v4, v5);
        }

        v0.currentQuadratic = 0;
    }

    public static void convert$default(ConicConverter arg0, float[] arg1, float arg2, float arg3, int arg4, int arg5, Object arg6) {
        arg0.convert(arg1, arg2, arg3, 0);
    }

    public final int getCurrentQuadratic() {
        return this.currentQuadratic;
    }

    public final int getQuadraticCount() {
        return this.quadraticCount;
    }

    private final native int internalConicToQuadratics(float[] arg1, int arg2, float[] arg3, float arg4, float arg5) {
    }

    public final boolean nextQuadratic(float[] arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg6, "points");
        int v0 = this.currentQuadratic;
        if(v0 < this.quadraticCount) {
            int v1 = v0 * 4;
            float[] v2 = this.quadraticData;
            arg6[arg7] = v2[v1];
            arg6[arg7 + 1] = v2[v1 + 1];
            arg6[arg7 + 2] = v2[v1 + 2];
            arg6[arg7 + 3] = v2[v1 + 3];
            arg6[arg7 + 4] = v2[v1 + 4];
            arg6[arg7 + 5] = v2[v1 + 5];
            this.currentQuadratic = v0 + 1;
            return 1;
        }

        return 0;
    }

    public static boolean nextQuadratic$default(ConicConverter arg0, float[] arg1, int arg2, int arg3, Object arg4) {
        return arg0.nextQuadratic(arg1, 0);
    }

    public final void setCurrentQuadratic(int arg1) {
        this.currentQuadratic = arg1;
    }
}

