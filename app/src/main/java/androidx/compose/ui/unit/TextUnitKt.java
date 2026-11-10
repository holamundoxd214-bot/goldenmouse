package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000F\u001A\u001D\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\f\u001A\"\u0010\u0016\u001A\u00020\u0006*\u00020\u00062\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u001C\u0010)\u001A\u00020\u0006*\u00020\b2\u0006\u0010*\u001A\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010\f\u001A\u001C\u0010)\u001A\u00020\u0006*\u00020#2\u0006\u0010*\u001A\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010,\u001A\u001C\u0010)\u001A\u00020\u0006*\u00020&2\u0006\u0010*\u001A\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010-\u001A\u001D\u0010.\u001A\u00020\u00062\u0006\u0010/\u001A\u00020\u00012\u0006\u00100\u001A\u00020\bH\u0001¢\u0006\u0002\u00101\u001A\u0017\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u0006H\u0001¢\u0006\u0004\b5\u0010\u0010\u001A\u001F\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u00062\u0006\u00106\u001A\u00020\u0006H\u0001¢\u0006\u0004\b7\u00108\u001A\'\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u00062\u0006\u00106\u001A\u00020\u00062\u0006\u00109\u001A\u00020\u0006H\u0001¢\u0006\u0004\b:\u0010;\u001A\'\u0010<\u001A\u00020\u00062\u0006\u0010=\u001A\u00020\u00062\u0006\u0010>\u001A\u00020\u00062\u0006\u0010?\u001A\u00020\bH\u0007¢\u0006\u0004\b@\u0010A\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001F\u0010\r\u001A\u00020\u000E*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u001F\u0010\u0013\u001A\u00020\u000E*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0010\u001A\u0004\b\u0015\u0010\u0012\"\u001E\u0010\u001B\u001A\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"\u001E\u0010 \u001A\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001D\u001A\u0004\b\"\u0010\u001F\"\u001E\u0010\u001B\u001A\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001C\u0010$\u001A\u0004\b\u001E\u0010%\"\u001E\u0010 \u001A\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010$\u001A\u0004\b\"\u0010%\"\u001E\u0010\u001B\u001A\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001C\u0010\'\u001A\u0004\b\u001E\u0010(\"\u001E\u0010 \u001A\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\'\u001A\u0004\b\"\u0010(¨\u0006B"}, d2={"UNIT_MASK", "", "UNIT_TYPE_UNSPECIFIED", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "TextUnit", "Landroidx/compose/ui/unit/TextUnit;", "value", "", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "sp", "getSp$annotations", "(F)V", "getSp", "(F)J", "em", "getEm$annotations", "getEm", "", "(D)V", "(D)J", "", "(I)V", "(I)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "pack", "unitType", "v", "(JF)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextUnitKt {
    private static final long UNIT_MASK = 0xFF00000000L;
    private static final long UNIT_TYPE_EM = 0x200000000L;
    private static final long UNIT_TYPE_SP = 0x100000000L;
    private static final long UNIT_TYPE_UNSPECIFIED;

    public static final long TextUnit-anM5pPY(float arg0, long arg1) {
        return TextUnitKt.pack(arg1, arg0);
    }

    public static final void checkArithmetic--R2X_6o(long arg2) {
        int v2 = TextUnit.getRawType-impl(arg2) == 0 ? 1 : 0;
        if(v2 != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    public static final void checkArithmetic-NB67dxo(long arg4, long arg6) {
        long v2 = 0;
        int v0 = TextUnit.getRawType-impl(arg4) == v2 || TextUnit.getRawType-impl(arg6) == v2 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }

        if(!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg4), TextUnit.getType-UIouoOA(arg6))) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + TextUnitType.toString-impl(TextUnit.getType-UIouoOA(arg4)) + " and " + TextUnitType.toString-impl(TextUnit.getType-UIouoOA(arg6)));
        }
    }

    public static final void checkArithmetic-vU-0ePk(long arg7, long arg9, long arg11) {
        long v2 = 0;
        int v1 = 1;
        int v0 = Long.compare(TextUnit.getRawType-impl(arg7), v2) == 0 || (TextUnit.getRawType-impl(arg9) == v2 || TextUnit.getRawType-impl(arg11) == v2) ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }

        if(!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg7), TextUnit.getType-UIouoOA(arg9)) || !TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg9), TextUnit.getType-UIouoOA(arg11))) {
            v1 = 0;
        }
        else {
        }

        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + TextUnitType.toString-impl(TextUnit.getType-UIouoOA(arg7)) + " and " + TextUnitType.toString-impl(TextUnit.getType-UIouoOA(arg9)));
        }
    }

    public static final long getEm(float arg2) {
        return TextUnitKt.pack(0x200000000L, arg2);
    }

    public static final long getEm(int arg2) {
        return TextUnitKt.pack(0x200000000L, ((float)arg2));
    }

    public static final long getEm(double arg2) {
        return TextUnitKt.pack(0x200000000L, ((float)arg2));
    }

    public static void getEm$annotations(double arg0) {
    }

    public static void getEm$annotations(float arg0) {
    }

    public static void getEm$annotations(int arg0) {
    }

    public static final long getSp(int arg2) {
        return TextUnitKt.pack(0x100000000L, ((float)arg2));
    }

    public static final long getSp(float arg2) {
        return TextUnitKt.pack(0x100000000L, arg2);
    }

    public static final long getSp(double arg2) {
        return TextUnitKt.pack(0x100000000L, ((float)arg2));
    }

    public static void getSp$annotations(double arg0) {
    }

    public static void getSp$annotations(float arg0) {
    }

    public static void getSp$annotations(int arg0) {
    }

    public static final boolean isSpecified--R2X_6o(long arg2) {
        int v2 = Long.compare(TextUnit.getRawType-impl(arg2), 0) == 0 ? 1 : 0;
        return v2 ^ 1;
    }

    public static void isSpecified--R2X_6o$annotations(long arg0) {
    }

    public static final boolean isUnspecified--R2X_6o(long arg2) {
        if(TextUnit.getRawType-impl(arg2) == 0) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified--R2X_6o$annotations(long arg0) {
    }

    public static final long lerp-C3pnCVY(long arg2, long arg4, float arg6) {
        TextUnitKt.checkArithmetic-NB67dxo(arg2, arg4);
        return TextUnitKt.pack(TextUnit.getRawType-impl(arg2), MathHelpersKt.lerp(TextUnit.getValue-impl(arg2), TextUnit.getValue-impl(arg4), arg6));
    }

    public static final long pack(long arg4, float arg6) {
        return TextUnit.constructor-impl(arg4 | (((long)Float.floatToRawIntBits(arg6))) & 0xFFFFFFFFL);
    }

    public static final long takeOrElse-eAf_CNQ(long arg4, Function0 arg6) {
        int v0 = TextUnit.getRawType-impl(arg4) == 0 ? 1 : 0;
        if(v0 == 0) {
            return arg4;
        }

        return arg6.invoke().unbox-impl();
    }

    public static final long times-mpE4wyQ(double arg2, long arg4) {
        TextUnitKt.checkArithmetic--R2X_6o(arg4);
        return TextUnitKt.pack(TextUnit.getRawType-impl(arg4), (((float)arg2)) * TextUnit.getValue-impl(arg4));
    }

    public static final long times-mpE4wyQ(float arg2, long arg3) {
        TextUnitKt.checkArithmetic--R2X_6o(arg3);
        return TextUnitKt.pack(TextUnit.getRawType-impl(arg3), arg2 * TextUnit.getValue-impl(arg3));
    }

    public static final long times-mpE4wyQ(int arg2, long arg3) {
        TextUnitKt.checkArithmetic--R2X_6o(arg3);
        return TextUnitKt.pack(TextUnit.getRawType-impl(arg3), (((float)arg2)) * TextUnit.getValue-impl(arg3));
    }
}

