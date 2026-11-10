package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u001B\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000BJ\u0010\u0010\u0010\u001A\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001A\u0004\u0018\u00010\nH\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u000FJ\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0013\u0010\t\u001A\u0004\u0018\u00010\n8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "", "value", "", "constructor-impl", "(J)J", "cursor", "", "(I)J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "(ILandroidx/compose/foundation/text/input/internal/WedgeAffinity;)J", "getCursor-impl", "(J)I", "getWedgeAffinity-impl", "(J)Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class CursorAndWedgeAffinity {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[WedgeAffinity.values().length];
            try {
                v0[WedgeAffinity.Start.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[WedgeAffinity.End.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    private final long value;

    private CursorAndWedgeAffinity(long arg1) {
        super();
        this.value = arg1;
    }

    public static final CursorAndWedgeAffinity box-impl(long arg1) {
        return new CursorAndWedgeAffinity(arg1);
    }

    public static final int component1-impl(long arg0) {
        return CursorAndWedgeAffinity.getCursor-impl(arg0);
    }

    public static final WedgeAffinity component2-impl(long arg0) {
        return CursorAndWedgeAffinity.getWedgeAffinity-impl(arg0);
    }

    public static long constructor-impl(int arg4) {
        return CursorAndWedgeAffinity.constructor-impl((((long)arg4)) << 0x20 | 0xFFFFFFFFL);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static long constructor-impl(int arg4, WedgeAffinity arg5) {
        int v0 = -1;
        int v5 = arg5 == null ? v0 : WhenMappings.$EnumSwitchMapping$0[arg5.ordinal()];
        if(v5 != v0) {
            v0 = 1;
            if(v5 == 1) {
                v0 = 0;
            }
            else if(v5 == 2) {
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        return CursorAndWedgeAffinity.constructor-impl((((long)arg4)) << 0x20 | (((long)v0)) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return CursorAndWedgeAffinity.equals-impl(this.value, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof CursorAndWedgeAffinity)) {
            return 0;
        }

        if(arg4 != ((CursorAndWedgeAffinity)arg6).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        if(arg0 == arg2) {
            return 1;
        }

        return 0;
    }

    public static final int getCursor-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final WedgeAffinity getWedgeAffinity-impl(long arg2) {
        int v2 = ((int)(arg2 & 0xFFFFFFFFL));
        if(v2 < 0) {
            return null;
        }

        if(v2 == 0) {
            return WedgeAffinity.Start;
        }

        return WedgeAffinity.End;
    }

    public int hashCode() {
        return CursorAndWedgeAffinity.hashCode-impl(this.value);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return CursorAndWedgeAffinity.toString-impl(this.value);
    }

    public static String toString-impl(long arg2) {
        return "CursorAndWedgeAffinity(value=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.value;
    }
}

