package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\fHÖ\u0001J\t\u0010\r\u001A\u00020\u000EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0010"}, d2={"Landroidx/compose/ui/text/style/BaselineShift;", "", "multiplier", "", "constructor-impl", "(F)F", "getMultiplier", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class BaselineShift {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\bR\u001E\u0010\u0010\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001A\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/style/BaselineShift$Companion;", "", "<init>", "()V", "Superscript", "Landroidx/compose/ui/text/style/BaselineShift;", "getSuperscript-y9eOQZs$annotations", "getSuperscript-y9eOQZs", "()F", "F", "Subscript", "getSubscript-y9eOQZs$annotations", "getSubscript-y9eOQZs", "None", "getNone-y9eOQZs$annotations", "getNone-y9eOQZs", "Unspecified", "getUnspecified-y9eOQZs$annotations", "getUnspecified-y9eOQZs", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final float getNone-y9eOQZs() {
            return BaselineShift.None;
        }

        public static void getNone-y9eOQZs$annotations() {
        }

        public final float getSubscript-y9eOQZs() {
            return BaselineShift.Subscript;
        }

        public static void getSubscript-y9eOQZs$annotations() {
        }

        public final float getSuperscript-y9eOQZs() {
            return BaselineShift.Superscript;
        }

        public static void getSuperscript-y9eOQZs$annotations() {
        }

        public final float getUnspecified-y9eOQZs() {
            return BaselineShift.Unspecified;
        }

        public static void getUnspecified-y9eOQZs$annotations() {
        }
    }

    public static final Companion Companion;
    private static final float None;
    private static final float Subscript;
    private static final float Superscript;
    private static final float Unspecified;
    private final float multiplier;

    static {
        BaselineShift.Companion = new Companion(null);
        BaselineShift.Superscript = BaselineShift.constructor-impl(0.5f);
        BaselineShift.Subscript = BaselineShift.constructor-impl(-0.5f);
        BaselineShift.None = BaselineShift.constructor-impl(0f);
        BaselineShift.Unspecified = BaselineShift.constructor-impl(NaNf);
    }

    private BaselineShift(float arg1) {
        super();
        this.multiplier = arg1;
    }

    public static final float access$getNone$cp() {
        return BaselineShift.None;
    }

    public static final float access$getSubscript$cp() {
        return BaselineShift.Subscript;
    }

    public static final float access$getSuperscript$cp() {
        return BaselineShift.Superscript;
    }

    public static final float access$getUnspecified$cp() {
        return BaselineShift.Unspecified;
    }

    public static final BaselineShift box-impl(float arg1) {
        return new BaselineShift(arg1);
    }

    public static float constructor-impl(float arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return BaselineShift.equals-impl(this.multiplier, arg1);
    }

    public static boolean equals-impl(float arg2, Object arg3) {
        if(!(arg3 instanceof BaselineShift)) {
            return 0;
        }

        if(Float.compare(arg2, ((BaselineShift)arg3).unbox-impl()) != 0) {
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

    public final float getMultiplier() {
        return this.multiplier;
    }

    public int hashCode() {
        return BaselineShift.hashCode-impl(this.multiplier);
    }

    public static int hashCode-impl(float arg0) {
        return Float.hashCode(arg0);
    }

    public String toString() {
        return BaselineShift.toString-impl(this.multiplier);
    }

    public static String toString-impl(float arg2) {
        return "BaselineShift(multiplier=" + arg2 + ')';
    }

    public final float unbox-impl() {
        return this.multiplier;
    }
}

