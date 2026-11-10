package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\f\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000BJ\u0010\u0010\u000E\u001A\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000F\u0010\u0005J\u0018\u0010\u0010\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0011\u0010\u000BJ\u0018\u0010\u0010\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0013J\u0018\u0010\u0010\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000BJ\u0018\u0010\u0015\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0016\u0010\u000BJ\u0018\u0010\u0015\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u001BH\u0017¢\u0006\u0004\b\u001C\u0010\u001DJ\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010\t\u001A\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2={"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "plus", "other", "plus-5rwHm24", "(FF)F", "minus", "minus-5rwHm24", "unaryMinus", "unaryMinus-D9Ej5fM", "div", "div-u2uoSUM", "", "(FI)F", "div-0680j_4", "times", "times-u2uoSUM", "compareTo", "compareTo-0680j_4", "(FF)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Dp implements Comparable {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\b¨\u0006\u0010"}, d2={"Landroidx/compose/ui/unit/Dp$Companion;", "", "<init>", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final float getHairline-D9Ej5fM() {
            return Dp.Hairline;
        }

        public static void getHairline-D9Ej5fM$annotations() {
        }

        public final float getInfinity-D9Ej5fM() {
            return Dp.Infinity;
        }

        public static void getInfinity-D9Ej5fM$annotations() {
        }

        public final float getUnspecified-D9Ej5fM() {
            return Dp.Unspecified;
        }

        public static void getUnspecified-D9Ej5fM$annotations() {
        }
    }

    public static final Companion Companion;
    private static final float Hairline;
    private static final float Infinity;
    private static final float Unspecified;
    private final float value;

    static {
        Dp.Companion = new Companion(null);
        Dp.Hairline = Dp.constructor-impl(0f);
        Dp.Infinity = Dp.constructor-impl(Infinityf);
        Dp.Unspecified = Dp.constructor-impl(NaNf);
    }

    private Dp(float arg1) {
        super();
        this.value = arg1;
    }

    public static final float access$getHairline$cp() {
        return Dp.Hairline;
    }

    public static final float access$getInfinity$cp() {
        return Dp.Infinity;
    }

    public static final float access$getUnspecified$cp() {
        return Dp.Unspecified;
    }

    public static final Dp box-impl(float arg1) {
        return new Dp(arg1);
    }

    public int compareTo(Object arg1) {
        return this.compareTo-0680j_4(((Dp)arg1).unbox-impl());
    }

    public static int compareTo-0680j_4(float arg1, float arg2) {
        if(ComposeUiUnitFlags.isDpCompareToChanged) {
            if(!Float.isNaN(arg1)) {
                if(Float.isNaN(arg2)) {
                }
                else {
                    return Float.compare(arg1, arg2);
                }
            }

            return 0;
        }

        return Float.compare(arg1, arg2);
    }

    public int compareTo-0680j_4(float arg1) {
        return Dp.compareTo-0680j_4(this.value, arg1);
    }

    public static float constructor-impl(float arg0) {
        return arg0;
    }

    public static final float div-0680j_4(float arg0, float arg1) {
        return arg0 / arg1;
    }

    public static final float div-u2uoSUM(float arg0, float arg1) {
        return Dp.constructor-impl(arg0 / arg1);
    }

    public static final float div-u2uoSUM(float arg0, int arg1) {
        return Dp.constructor-impl(arg0 / (((float)arg1)));
    }

    public boolean equals(Object arg1) {
        return Dp.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(float arg2, Object arg3) {
        if(!(arg3 instanceof Dp)) {
            return 0;
        }

        if(Float.compare(arg2, ((Dp)arg3).unbox-impl()) != 0) {
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

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Dp.hashCode-impl(this.value);
    }

    public static int hashCode-impl(float arg0) {
        return Float.hashCode(arg0);
    }

    public static final float minus-5rwHm24(float arg0, float arg1) {
        return Dp.constructor-impl(arg0 - arg1);
    }

    public static final float plus-5rwHm24(float arg0, float arg1) {
        return Dp.constructor-impl(arg0 + arg1);
    }

    public static final float times-u2uoSUM(float arg0, float arg1) {
        return Dp.constructor-impl(arg0 * arg1);
    }

    public static final float times-u2uoSUM(float arg0, int arg1) {
        return Dp.constructor-impl(arg0 * (((float)arg1)));
    }

    public String toString() {
        return Dp.toString-impl(this.value);
    }

    public static String toString-impl(float arg1) {
        if(Float.isNaN(arg1)) {
            return "Dp.Unspecified";
        }

        return arg1 + ".dp";
    }

    public static final float unaryMinus-D9Ej5fM(float arg0) {
        return Dp.constructor-impl(-arg0);
    }

    public final float unbox-impl() {
        return this.value;
    }
}

