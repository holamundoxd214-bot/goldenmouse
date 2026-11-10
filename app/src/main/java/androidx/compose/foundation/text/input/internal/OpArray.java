package androidx.compose.foundation.text.input.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ-\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016Jo\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u00072\b\b\u0002\u0010\u0019\u001A\u00020\u001A2K\u0010\u001B\u001AG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u000E\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u000F\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u001CH\u0086\b¢\u0006\u0004\b\u001F\u0010 J\u0013\u0010!\u001A\u00020\u001A2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\u0007HÖ\u0001J\t\u0010$\u001A\u00020%HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\t\u0010\n\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006&"}, d2={"Landroidx/compose/foundation/text/input/internal/OpArray;", "", "values", "", "constructor-impl", "([I)[I", "size", "", "(I)[I", "getSize-impl", "([I)I", "set", "", "index", "offset", "srcLen", "destLen", "set-impl", "([IIIII)V", "copyOf", "newSize", "copyOf-pSmdads", "([II)[I", "forEach", "max", "reversed", "", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "forEach-impl", "([IIZLkotlin/jvm/functions/Function3;)V", "equals", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class OpArray {
    private final int[] values;

    private OpArray(int[] arg1) {
        super();
        this.values = arg1;
    }

    public static final OpArray box-impl(int[] arg1) {
        return new OpArray(arg1);
    }

    public static int[] constructor-impl(int arg0) {
        return OpArray.constructor-impl(new int[arg0 * 3]);
    }

    private static int[] constructor-impl(int[] arg0) {
        return arg0;
    }

    public static final int[] copyOf-pSmdads(int[] arg0, int arg1) {
        arg0 = Arrays.copyOf(arg0, arg1 * 3);
        Intrinsics.checkNotNullExpressionValue(arg0, "copyOf(...)");
        return OpArray.constructor-impl(arg0);
    }

    public boolean equals(Object arg1) {
        return OpArray.equals-impl(this.values, arg1);
    }

    public static boolean equals-impl(int[] arg2, Object arg3) {
        if(!(arg3 instanceof OpArray)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((OpArray)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int[] arg0, int[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final void forEach-impl(int[] arg3, int arg4, boolean arg5, Function3 arg6) {
        int v5;
        if(arg4 < 0) {
        }
        else if(arg5) {
            --arg4;
            while(-1 < arg4) {
                v5 = arg4 * 3;
                arg6.invoke(Integer.valueOf(arg3[v5]), Integer.valueOf(arg3[v5 + 1]), Integer.valueOf(arg3[v5 + 2]));
                --arg4;
            }
        }
        else {
            for(v5 = 0; v5 < arg4; ++v5) {
                int v0 = v5 * 3;
                arg6.invoke(Integer.valueOf(arg3[v0]), Integer.valueOf(arg3[v0 + 1]), Integer.valueOf(arg3[v0 + 2]));
            }
        }
    }

    public static void forEach-impl$default(int[] arg1, int arg2, boolean arg3, Function3 arg4, int arg5, Object arg6) {
        int v3;
        int v6 = 0;
        if(arg2 < 0) {
        }
        else {
            if(0 != 0) {
                --arg2;
                while(true) {
                    if(-1 < arg2) {
                        v3 = arg2 * 3;
                        arg4.invoke(Integer.valueOf(arg1[v3]), Integer.valueOf(arg1[v3 + 1]), Integer.valueOf(arg1[v3 + 2]));
                        --arg2;
                        continue;
                    }
                    else {
                        return;
                    }
                }
            }

            while(v6 < arg2) {
                v3 = v6 * 3;
                arg4.invoke(Integer.valueOf(arg1[v3]), Integer.valueOf(arg1[v3 + 1]), Integer.valueOf(arg1[v3 + 2]));
                ++v6;
            }
        }
    }

    public static final int getSize-impl(int[] arg0) {
        return arg0.length / 3;
    }

    public int hashCode() {
        return OpArray.hashCode-impl(this.values);
    }

    public static int hashCode-impl(int[] arg0) {
        return Arrays.hashCode(arg0);
    }

    public static final void set-impl(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
        arg1 *= 3;
        arg0[arg1] = arg2;
        arg0[arg1 + 1] = arg3;
        arg0[arg1 + 2] = arg4;
    }

    public String toString() {
        return OpArray.toString-impl(this.values);
    }

    public static String toString-impl(int[] arg2) {
        return "OpArray(values=" + Arrays.toString(arg2) + ')';
    }

    public final int[] unbox-impl() {
        return this.values;
    }
}

