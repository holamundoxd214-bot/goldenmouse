package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H\u0002¨\u0006\u0006"}, d2={"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridCellsKt {
    public static final int[] access$calculateCellsCrossAxisSizeImpl(int arg0, int arg1, int arg2) {
        return LazyStaggeredGridCellsKt.calculateCellsCrossAxisSizeImpl(arg0, arg1, arg2);
    }

    private static final int[] calculateCellsCrossAxisSizeImpl(int arg4, int arg5, int arg6) {
        int v3;
        arg4 -= arg6 * (arg5 - 1);
        arg6 = arg4 / arg5;
        arg4 %= arg5;
        int[] v0 = new int[arg5];
        int v2;
        for(v2 = 0; v2 < arg5; ++v2) {
            if(arg6 < 0) {
                v3 = 0;
            }
            else {
                v3 = v2 < arg4 ? 1 : 0;
                v3 += arg6;
            }

            v0[v2] = v3;
        }

        return v0;
    }
}

