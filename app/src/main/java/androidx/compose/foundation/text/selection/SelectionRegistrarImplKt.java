package androidx.compose.foundation.text.selection;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A/\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"inARow", "", "boxATopLeft", "Landroidx/compose/ui/geometry/Offset;", "boxABottomRight", "boxBTopLeft", "boxBBottomRight", "inARow-zwwh4xc", "(JJJJ)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionRegistrarImplKt {
    public static final boolean inARow-zwwh4xc(long arg8, long arg10, long arg12, long arg14) {
        int v2 = ((int)(arg10 & 0xFFFFFFFFL));
        int v4 = ((int)(arg8 & 0xFFFFFFFFL));
        float v3 = Float.intBitsToFloat(v2) - Float.intBitsToFloat(v4);
        int v10 = ((int)(arg10 >> 0x20));
        int v8 = ((int)(arg8 >> 0x20));
        float v11 = Float.intBitsToFloat(v10) - Float.intBitsToFloat(v8);
        int v9 = ((int)(arg14 & 0xFFFFFFFFL));
        int v0 = ((int)(0xFFFFFFFFL & arg12));
        float v6 = Float.intBitsToFloat(v9) - Float.intBitsToFloat(v0);
        int v14 = ((int)(arg14 >> 0x20));
        int v12 = ((int)(arg12 >> 0x20));
        float v15 = Float.intBitsToFloat(v14) - Float.intBitsToFloat(v12);
        float v9_1 = Math.max(0f, Math.min(Float.intBitsToFloat(v2), Float.intBitsToFloat(v9)) - Math.max(Float.intBitsToFloat(v4), Float.intBitsToFloat(v0)));
        float v8_1 = Math.max(0f, Math.min(Float.intBitsToFloat(v10), Float.intBitsToFloat(v14)) - Math.max(Float.intBitsToFloat(v8), Float.intBitsToFloat(v12)));
        float v10_1 = 0.5f;
        v9 = Float.compare(v9_1, v3 * v10_1) >= 0 || v9_1 >= v6 * v10_1 ? 1 : 0;
        v8 = v8_1 >= v11 * v10_1 || v8_1 >= v15 * v10_1 ? 0 : 1;
        if(v9 != 0 && v8 != 0) {
            return 1;
        }

        return 0;
    }
}

