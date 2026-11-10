package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0004\b\u001A\u0010\u0018J\u0013\u0010\u001B\u001A\u00020\u00112\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001D\u001A\u00020\u0007HÖ\u0001J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0011\u0010\f\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\r\u0010\tR\u0011\u0010\u000E\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\tR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006!"}, d2={"Landroidx/compose/ui/node/TouchBoundsExpansion;", "", "packedValue", "", "constructor-impl", "(J)J", "start", "", "getStart-impl", "(J)I", "top", "getTop-impl", "end", "getEnd-impl", "bottom", "getBottom-impl", "isLayoutDirectionAware", "", "isLayoutDirectionAware-impl", "(J)Z", "computeLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "computeLeft-impl$ui", "(JLandroidx/compose/ui/unit/LayoutDirection;)I", "computeRight", "computeRight-impl$ui", "equals", "other", "hashCode", "toString", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TouchBoundsExpansion {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\u000B\u0010\fJ5\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0018\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001E\u001A\u00020\u0007H\u0002J\u0018\u0010\u001F\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u0007H\u0002R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0018\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/compose/ui/node/TouchBoundsExpansion$Companion;", "", "<init>", "()V", "Absolute", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "left", "", "top", "right", "bottom", "Absolute-vsh68fg", "(IIII)J", "None", "getNone-RZrCHBk", "()J", "J", "pack", "", "start", "end", "isLayoutDirectionAware", "", "pack$ui", "MASK", "SHIFT", "MAX_VALUE", "IS_LAYOUT_DIRECTION_AWARE", "unpack", "packedValue", "position", "trimAndShift", "int", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long Absolute-vsh68fg(int arg8, int arg9, int arg10, int arg11) {
            int v0 = 1;
            int v1 = 0x8000;
            int v3 = arg8 < 0 || arg8 >= v1 ? 0 : 1;
            if(v3 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Start must be in the range of 0 .. 32767");
            }

            v3 = arg9 < 0 || arg9 >= v1 ? 0 : 1;
            if(v3 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Top must be in the range of 0 .. 32767");
            }

            v3 = arg10 < 0 || arg10 >= v1 ? 0 : 1;
            if(v3 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("End must be in the range of 0 .. 32767");
            }

            if(arg11 < 0 || arg11 >= v1) {
                v0 = 0;
            }
            else {
            }

            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Bottom must be in the range of 0 .. 32767");
            }

            return TouchBoundsExpansion.constructor-impl(this.pack$ui(arg8, arg9, arg10, arg11, false));
        }

        public static long Absolute-vsh68fg$default(Companion arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) {
            return arg1.Absolute-vsh68fg(0, 0, 0, 0);
        }

        public static final int access$unpack(Companion arg0, long arg1, int arg3) {
            return arg0.unpack(arg1, arg3);
        }

        public final long getNone-RZrCHBk() {
            return TouchBoundsExpansion.None;
        }

        public final long pack$ui(int arg3, int arg4, int arg5, int arg6, boolean arg7) {
            long v2 = this.trimAndShift(arg4, 1) | this.trimAndShift(arg3, 0) | this.trimAndShift(arg5, 2) | this.trimAndShift(arg6, 3);
            long v4 = arg7 ? -9223372036854775808L : 0;
            return v2 | v4;
        }

        private final long trimAndShift(int arg1, int arg2) {
            return (((long)(arg1 & 0x7FFF))) << arg2 * 15;
        }

        private final int unpack(long arg1, int arg3) {
            return (((int)(arg1 >> arg3 * 15))) & 0x7FFF;
        }
    }

    public static final Companion Companion = null;
    private static final long IS_LAYOUT_DIRECTION_AWARE = -9223372036854775808L;
    private static final int MASK = 0x7FFF;
    public static final int MAX_VALUE = 0x7FFF;
    private static final long None = 0;
    private static final int SHIFT = 15;
    private final long packedValue;

    static {
        TouchBoundsExpansion.Companion = new Companion(null);
        TouchBoundsExpansion.None = TouchBoundsExpansionKt.TouchBoundsExpansion$default(0, 0, 0, 0, 14, null);
    }

    private TouchBoundsExpansion(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getNone$cp() {
        return TouchBoundsExpansion.None;
    }

    public static final TouchBoundsExpansion box-impl(long arg1) {
        return new TouchBoundsExpansion(arg1);
    }

    public static final int computeLeft-impl$ui(long arg1, LayoutDirection arg3) {
        if(TouchBoundsExpansion.isLayoutDirectionAware-impl(arg1)) {
            if(arg3 == LayoutDirection.Ltr) {
            }
            else {
                return TouchBoundsExpansion.getEnd-impl(arg1);
            }
        }

        return TouchBoundsExpansion.getStart-impl(arg1);
    }

    public static final int computeRight-impl$ui(long arg1, LayoutDirection arg3) {
        if(TouchBoundsExpansion.isLayoutDirectionAware-impl(arg1)) {
            if(arg3 == LayoutDirection.Ltr) {
            }
            else {
                return TouchBoundsExpansion.getStart-impl(arg1);
            }
        }

        return TouchBoundsExpansion.getEnd-impl(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return TouchBoundsExpansion.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof TouchBoundsExpansion)) {
            return 0;
        }

        if(arg4 != ((TouchBoundsExpansion)arg6).unbox-impl()) {
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

    public static final int getBottom-impl(long arg2) {
        return Companion.access$unpack(TouchBoundsExpansion.Companion, arg2, 3);
    }

    public static final int getEnd-impl(long arg2) {
        return Companion.access$unpack(TouchBoundsExpansion.Companion, arg2, 2);
    }

    public static final int getStart-impl(long arg2) {
        return Companion.access$unpack(TouchBoundsExpansion.Companion, arg2, 0);
    }

    public static final int getTop-impl(long arg2) {
        return Companion.access$unpack(TouchBoundsExpansion.Companion, arg2, 1);
    }

    public int hashCode() {
        return TouchBoundsExpansion.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean isLayoutDirectionAware-impl(long arg2) {
        if((arg2 & -9223372036854775808L) != 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return TouchBoundsExpansion.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "TouchBoundsExpansion(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

