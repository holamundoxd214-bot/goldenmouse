package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\bB\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007Jw\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2K\u0010\u000F\u001AG\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0010H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2={"Lkotlin/time/LongParser;", "", "overflowLimit", "", "allowSign", "", "<init>", "(JZ)V", "overflowThreshold", "lastDigitMax", "parse", "value", "", "startIndex", "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "endIndex", "sign", "hasOverflow", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class LongParser {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Lkotlin/time/LongParser$Companion;", "", "<init>", "()V", "iso", "Lkotlin/time/LongParser;", "getIso", "()Lkotlin/time/LongParser;", "default", "getDefault", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final LongParser getDefault() {
            return LongParser.default;
        }

        public final LongParser getIso() {
            return LongParser.iso;
        }
    }

    public static final Companion Companion;
    private final boolean allowSign;
    private static final LongParser default;
    private static final LongParser iso;
    private final long lastDigitMax;
    private final long overflowLimit;
    private final long overflowThreshold;

    static {
        LongParser.Companion = new Companion(null);
        LongParser.iso = new LongParser(0x3FFFFFFFFFFFFFFFL, true);
        LongParser.default = new LongParser(0x7FFFFFFFFFFFFFFFL, false);
    }

    private LongParser(long arg5, boolean arg7) {
        super();
        this.overflowLimit = arg5;
        this.allowSign = arg7;
        this.overflowThreshold = arg5 / 10;
        this.lastDigitMax = arg5 % 10;
    }

    public static final boolean access$getAllowSign$p(LongParser arg0) {
        return arg0.allowSign;
    }

    public static final LongParser access$getDefault$cp() {
        return LongParser.default;
    }

    public static final LongParser access$getIso$cp() {
        return LongParser.iso;
    }

    public static final long access$getLastDigitMax$p(LongParser arg2) {
        return arg2.lastDigitMax;
    }

    public static final long access$getOverflowLimit$p(LongParser arg2) {
        return arg2.overflowLimit;
    }

    public static final long access$getOverflowThreshold$p(LongParser arg2) {
        return arg2.overflowThreshold;
    }

    public final long parse(String arg12, int arg13, Function3 arg14) {
        int v2;
        int v0;
        Intrinsics.checkNotNullParameter(arg12, "value");
        Intrinsics.checkNotNullParameter(arg14, "callback");
        if(this.allowSign) {
            v0 = arg12.charAt(arg13);
            if(v0 == 43) {
                ++arg13;
                goto label_17;
            }
            else if(v0 != 45) {
                goto label_17;
            }
            else {
                ++arg13;
                v0 = -1;
            }
        }
        else {
        label_17:
            v0 = 1;
        }

        while(true) {
            int v3 = 0x30;
            if(arg13 < arg12.length() && arg12.charAt(arg13) == v3) {
                ++arg13;
                continue;
            }

            break;
        }

        long v4 = 0;
        while(arg13 < arg12.length()) {
            v2 = arg12.charAt(arg13);
            if(v3 > v2) {
                break;
            }

            int v6 = 58;
            if(v2 >= v6) {
                break;
            }

            v2 += 0xFFFFFFD0;
            if(v4 <= this.overflowThreshold) {
                if(v4 == this.overflowThreshold && (((long)v2)) > this.lastDigitMax) {
                    goto label_49;
                }

                v4 = (((long)v2)) + ((v4 << 3) + (v4 << 1));
                ++arg13;
                continue;
            }

            goto label_49;
        }

        arg14.invoke(Integer.valueOf(arg13), Integer.valueOf(v0), Boolean.valueOf(false));
        return v4;
    label_49:
        while(arg13 < arg12.length()) {
            v2 = arg12.charAt(arg13);
            if(v3 > v2) {
                break;
            }

            if(v2 >= v6) {
                break;
            }

            ++arg13;
        }

        arg14.invoke(Integer.valueOf(arg13), Integer.valueOf(v0), Boolean.valueOf(true));
        return this.overflowLimit;
    }
}

