package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2={"Landroidx/compose/ui/FrameRateCategory;", "", "value", "", "constructor-impl", "(F)F", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class FrameRateCategory {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/FrameRateCategory$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/FrameRateCategory;", "getDefault-NSsRyOo", "()F", "F", "Normal", "getNormal-NSsRyOo", "High", "getHigh-NSsRyOo", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final float getDefault-NSsRyOo() {
            return FrameRateCategory.Default;
        }

        public final float getHigh-NSsRyOo() {
            return FrameRateCategory.High;
        }

        public final float getNormal-NSsRyOo() {
            return FrameRateCategory.Normal;
        }
    }

    public static final Companion Companion;
    private static final float Default;
    private static final float High;
    private static final float Normal;
    private final float value;

    static {
        FrameRateCategory.Companion = new Companion(null);
        FrameRateCategory.Default = FrameRateCategory.constructor-impl(NaNf);
        FrameRateCategory.Normal = FrameRateCategory.constructor-impl(-3f);
        FrameRateCategory.High = FrameRateCategory.constructor-impl(-4f);
    }

    private FrameRateCategory(float arg1) {
        super();
        this.value = arg1;
    }

    public static final float access$getDefault$cp() {
        return FrameRateCategory.Default;
    }

    public static final float access$getHigh$cp() {
        return FrameRateCategory.High;
    }

    public static final float access$getNormal$cp() {
        return FrameRateCategory.Normal;
    }

    public static final FrameRateCategory box-impl(float arg1) {
        return new FrameRateCategory(arg1);
    }

    private static float constructor-impl(float arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return FrameRateCategory.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(float arg2, Object arg3) {
        if(!(arg3 instanceof FrameRateCategory)) {
            return 0;
        }

        if(Float.compare(arg2, ((FrameRateCategory)arg3).unbox-impl()) != 0) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(float arg0, float arg1) {
        if(Float.compare(arg0, arg1) == 0) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return FrameRateCategory.hashCode-impl(this.value);
    }

    public static int hashCode-impl(float arg0) {
        return Float.hashCode(arg0);
    }

    public String toString() {
        return FrameRateCategory.toString-impl(this.value);
    }

    public static String toString-impl(float arg1) {
        if(arg1 == -3f) {
            return "Normal";
        }

        if(arg1 == -4f) {
            return "High";
        }

        return "Default";
    }

    public final float unbox-impl() {
        return this.value;
    }
}

