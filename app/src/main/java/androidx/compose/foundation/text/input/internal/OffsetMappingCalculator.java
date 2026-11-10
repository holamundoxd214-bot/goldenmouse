package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\bJ\u0015\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001F\u0010\u0015\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002¢\u0006\u0004\b\u001E\u0010\u001FR\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "<init>", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "mapFromSource", "Landroidx/compose/ui/text/TextRange;", "offset", "mapFromSource--jx7JFs", "(I)J", "mapFromDest", "mapFromDest--jx7JFs", "map", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops;
    private int opsSize;

    static {
    }

    public OffsetMappingCalculator() {
        super();
        this.ops = OpArray.constructor-impl(10);
    }

    private final long map-fzxv0v0(int arg13, boolean arg14) {
        OffsetMappingCalculator v2_1;
        int v6;
        int v5;
        int v4;
        int v3;
        int[] v0 = this.ops;
        int v1 = this.opsSize;
        if(v1 >= 0) {
            if(!arg14) {
                --v1;
                v3 = arg13;
                while(-1 < v1) {
                    int v2 = v1 * 3;
                    v4 = v0[v2];
                    v5 = v0[v2 + 1];
                    v6 = v0[v2 + 2];
                    v2_1 = this;
                    long v10 = v2_1.mapStep-C6u-MEY(v3, v4, v5, v6, arg14);
                    long v12 = v2_1.mapStep-C6u-MEY(arg13, v4, v5, v6, arg14);
                    v3 = Math.min(TextRange.getStart-impl(v10), TextRange.getStart-impl(v12));
                    arg13 = Math.max(TextRange.getEnd-impl(v10), TextRange.getEnd-impl(v12));
                    --v1;
                    this = v2_1;
                    arg14 = arg14;
                }
            }
            else {
                v2_1 = this;
                boolean v7 = arg14;
                int v12_1 = 0;
                v3 = arg13;
                while(v12_1 < v1) {
                    int v14 = v12_1 * 3;
                    v4 = v0[v14];
                    v5 = v0[v14 + 1];
                    v6 = v0[v14 + 2];
                    long v8 = v2_1.mapStep-C6u-MEY(v3, v4, v5, v6, v7);
                    long v13 = v2_1.mapStep-C6u-MEY(((int)v13), v4, v5, v6, v7);
                    v3 = Math.min(TextRange.getStart-impl(v8), TextRange.getStart-impl(v13));
                    arg13 = Math.max(TextRange.getEnd-impl(v8), TextRange.getEnd-impl(v13));
                    ++v12_1;
                }
            }

            v5 = arg13;
            arg13 = v3;
        }
        else {
            v5 = arg13;
        }

        return TextRangeKt.TextRange(arg13, v5);
    }

    public final long mapFromDest--jx7JFs(int arg2) {
        return this.map-fzxv0v0(arg2, false);
    }

    public final long mapFromSource--jx7JFs(int arg2) {
        return this.map-fzxv0v0(arg2, true);
    }

    private final long mapStep-C6u-MEY(int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        int v0 = arg5 ? arg3 : arg4;
        if(arg5) {
            arg3 = arg4;
        }

        if(arg1 < arg2) {
            return TextRangeKt.TextRange(arg1);
        }

        if(arg1 == arg2) {
            if(v0 == 0) {
                return TextRangeKt.TextRange(arg2, arg3 + arg2);
            }

            return TextRangeKt.TextRange(arg2);
        }

        if(arg1 < arg2 + v0) {
            if(arg3 == 0) {
                return TextRangeKt.TextRange(arg2);
            }

            return TextRangeKt.TextRange(arg2, arg3 + arg2);
        }

        return TextRangeKt.TextRange(arg1 - v0 + arg3);
    }

    public final void recordEditOperation(int arg5, int arg6, int arg7) {
        int v1 = arg7 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected newLen to be ≥ 0, was " + arg7);
        }

        arg5 = Math.min(arg5, arg6);
        arg6 = Math.max(arg5, arg6) - arg5;
        v1 = 2;
        if(arg6 < v1 && arg6 == arg7) {
            return;
        }

        int v2 = this.opsSize + 1;
        if(v2 > OpArray.getSize-impl(this.ops)) {
            this.ops = OpArray.copyOf-pSmdads(this.ops, Math.max(v2 * 2, OpArray.getSize-impl(this.ops) * v1));
        }

        OpArray.set-impl(this.ops, this.opsSize, arg5, arg6, arg7);
        this.opsSize = v2;
    }
}

