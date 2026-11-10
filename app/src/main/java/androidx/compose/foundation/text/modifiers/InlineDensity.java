package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\n¢\u0006\u0004\b\u0004\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\b\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\r\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "packedValue", "", "constructor-impl", "(J)J", "density", "", "fontScale", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "getDensity-impl", "(J)F", "getFontScale-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class InlineDensity {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getUnspecified-L26CHvs() {
            return InlineDensity.Unspecified;
        }
    }

    public static final Companion Companion;
    private static final long Unspecified;
    private final long packedValue;

    static {
        InlineDensity.Companion = new Companion(null);
        InlineDensity.Unspecified = InlineDensity.constructor-impl(NaNf, NaNf);
    }

    private InlineDensity(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getUnspecified$cp() {
        return InlineDensity.Unspecified;
    }

    public static final InlineDensity box-impl(long arg1) {
        return new InlineDensity(arg1);
    }

    public static long constructor-impl(float arg4, float arg5) {
        return InlineDensity.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    private static long constructor-impl(long arg0) {
        return arg0;
    }

    public static long constructor-impl(Density arg2) {
        return InlineDensity.constructor-impl(arg2.getDensity(), arg2.getFontScale());
    }

    public boolean equals(Object arg3) {
        return InlineDensity.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof InlineDensity)) {
            return 0;
        }

        if(arg4 != ((InlineDensity)arg6).unbox-impl()) {
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

    public static final float getDensity-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float getFontScale-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public int hashCode() {
        return InlineDensity.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return InlineDensity.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "InlineDensity(density=" + InlineDensity.getDensity-impl(arg2) + ", fontScale=" + InlineDensity.getFontScale-impl(arg2) + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

