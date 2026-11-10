package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001A0\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0005H\u0082\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"dot", "", "m1", "Landroidx/compose/ui/graphics/ColorMatrix;", "row", "", "m2", "column", "dot-Me4OoYI", "([FI[FI)F", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ColorMatrixKt {
    private static final float dot-Me4OoYI(float[] arg3, int arg4, float[] arg5, int arg6) {
        arg4 *= 5;
        return arg3[arg4] * arg5[arg6] + arg3[arg4 + 1] * arg5[5 + arg6] + arg3[arg4 + 2] * arg5[10 + arg6] + arg3[arg4 + 3] * arg5[15 + arg6];
    }
}

