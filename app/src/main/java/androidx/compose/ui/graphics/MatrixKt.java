package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A0\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0005H\u0082\b¢\u0006\u0004\b\b\u0010\t\u001A\u0011\u0010\n\u001A\u00020\u000B*\u00020\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "isIdentity", "", "isIdentity-58bKbWc", "([F)Z", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MatrixKt {
    private static final float dot-p89u6pk(float[] arg3, int arg4, float[] arg5, int arg6) {
        arg4 *= 4;
        return arg3[arg4] * arg5[arg6] + arg3[arg4 + 1] * arg5[4 + arg6] + arg3[arg4 + 2] * arg5[8 + arg6] + arg3[arg4 + 3] * arg5[12 + arg6];
    }

    public static final boolean isIdentity-58bKbWc(float[] arg5) {
        if(arg5.length < 16) {
            return 0;
        }

        float v1 = 1f;
        if(arg5[0] == v1 && arg5[1] == 0f && arg5[2] == 0f && arg5[3] == 0f && arg5[4] == 0f && arg5[5] == v1 && arg5[6] == 0f && arg5[7] == 0f && arg5[8] == 0f && arg5[9] == 0f && arg5[10] == v1 && arg5[11] == 0f && arg5[12] == 0f && arg5[13] == 0f && arg5[14] == 0f && arg5[15] == v1) {
            return 1;
        }

        return 0;
    }
}

