package androidx.compose.ui.unit;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0013\u001A\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0001H\u0000\u001A\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0001H\u0000\u001A-\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u001F\u001A\u00020\u0001H\u0000¢\u0006\u0002\u0010 \u001A\u0010\u0010!\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u0001H\u0000\u001A\u0011\u0010\"\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u0001H\u0082\b\u001A5\u0010#\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u00012\b\b\u0002\u0010\u001D\u001A\u00020\u00012\b\b\u0002\u0010\u001E\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020\u0001H\u0007¢\u0006\u0002\u0010 \u001A\u0019\u0010$\u001A\u00020\u001B*\u00020\u001B2\u0006\u0010%\u001A\u00020\u001B¢\u0006\u0004\b&\u0010\'\u001A\u001B\u0010$\u001A\u00020(*\u00020\u001B2\u0006\u0010\u0019\u001A\u00020(H\u0007¢\u0006\u0004\b)\u0010\'\u001A\u001B\u0010*\u001A\u00020\u0001*\u00020\u001B2\u0006\u0010+\u001A\u00020\u0001H\u0007¢\u0006\u0004\b,\u0010-\u001A\u001B\u0010.\u001A\u00020\u0001*\u00020\u001B2\u0006\u0010/\u001A\u00020\u0001H\u0007¢\u0006\u0004\b0\u0010-\u001A\u001B\u00101\u001A\u000202*\u00020\u001B2\u0006\u0010\u0019\u001A\u00020(H\u0007¢\u0006\u0004\b3\u00104\u001A\'\u00105\u001A\u00020\u001B*\u00020\u001B2\b\b\u0002\u00106\u001A\u00020\u00012\b\b\u0002\u00107\u001A\u00020\u0001H\u0007¢\u0006\u0004\b8\u00109\u001A\u0019\u0010:\u001A\u00020\u00012\u0006\u0010;\u001A\u00020\u00012\u0006\u0010<\u001A\u00020\u0001H\u0082\b\u001A\u0011\u0010=\u001A\u00020\u00012\u0006\u0010>\u001A\u00020\u0001H\u0082\b\u001A\u0011\u0010?\u001A\u00020\u00012\u0006\u0010@\u001A\u00020\u0001H\u0082\b\u001A\u0011\u0010A\u001A\u00020\u00012\u0006\u0010B\u001A\u00020\u0001H\u0082\b\u001A\u0011\u0010C\u001A\u00020\u00012\u0006\u0010B\u001A\u00020\u0001H\u0082\b\u001A\u0011\u0010D\u001A\u00020\u00012\u0006\u0010B\u001A\u00020\u0001H\u0082\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001A\u00020\u00038\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012¨\u0006E"}, d2={"Infinity", "", "FocusMask", "", "MinFocusBits", "MaxAllowedForMinFocusBits", "MinFocusMask", "MinNonFocusBits", "MaxAllowedForMinNonFocusBits", "MinNonFocusMask", "MaxFocusBits", "MaxAllowedForMaxFocusBits", "MaxFocusMask", "MaxNonFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxNonFocusMask", "MaxDimensionsAndFocusMask", "getMaxDimensionsAndFocusMask$annotations", "()V", "throwInvalidConstraintException", "", "widthVal", "heightVal", "throwInvalidConstraintsSizeException", "", "size", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "bitsNeedForSizeUnchecked", "maxAllowedForSize", "Constraints", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainWidth", "width", "constrainWidth-K40F9xA", "(JI)I", "constrainHeight", "height", "constrainHeight-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "addMaxWithMinimum", "max", "value", "indexToBitOffset", "index", "bitOffsetToIndex", "bits", "minHeightOffsets", "bitOffset", "widthMask", "heightMask", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = 0x7FFFFFFF;
    private static final int MaxAllowedForMaxFocusBits = 0x1FFE;
    private static final int MaxAllowedForMaxNonFocusBits = 0x3FFFE;
    private static final int MaxAllowedForMinFocusBits = 0x7FFE;
    private static final int MaxAllowedForMinNonFocusBits = 0xFFFE;
    public static final long MaxDimensionsAndFocusMask = -8589934589L;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusMask = 0x3FFFF;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 0x1FFF;
    private static final int MinFocusBits = 16;
    private static final int MinFocusMask = 0xFFFF;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 0x7FFF;

    public static final long Constraints(int arg4, int arg5, int arg6, int arg7) {
        int v0 = 1;
        int v2 = arg5 >= arg4 ? 1 : 0;
        int v3 = arg7 >= arg6 ? 1 : 0;
        v2 &= v3;
        v3 = arg4 >= 0 ? 1 : 0;
        v2 &= v3;
        if(arg6 >= 0) {
        }
        else {
            v0 = 0;
        }

        if((v0 & v2) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }

        return ConstraintsKt.createConstraints(arg4, arg5, arg6, arg7);
    }

    public static long Constraints$default(int arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) {
        int v1 = 0x7FFFFFFF;
        if((arg6 & 2) != 0) {
            arg3 = v1;
        }

        if((arg6 & 8) != 0) {
            arg5 = v1;
        }

        return ConstraintsKt.Constraints(0, arg3, 0, arg5);
    }

    private static final int addMaxWithMinimum(int arg1, int arg2) {
        if(arg1 == 0x7FFFFFFF) {
            return arg1;
        }

        arg1 += arg2;
        if(arg1 < 0) {
            arg1 = 0;
        }

        return arg1;
    }

    private static final int bitOffsetToIndex(int arg1) {
        return (arg1 >> 1) + (arg1 & 1);
    }

    public static final int bitsNeedForSizeUnchecked(int arg1) {
        if(arg1 < 0x1FFF) {
            return 13;
        }

        if(arg1 < 0x7FFF) {
            return 15;
        }

        if(arg1 < 0xFFFF) {
            return 16;
        }

        if(arg1 < 0x3FFFF) {
            return 18;
        }

        return 0xFF;
    }

    public static final long constrain-4WqzIAM(long arg5, long arg7) {
        int v0 = 0x20;
        int v1 = ((int)(arg7 >> v0));
        int v2 = Constraints.getMinWidth-impl(arg5);
        int v3 = Constraints.getMaxWidth-impl(arg5);
        if(v1 < v2) {
            v1 = v2;
        }

        if(v1 > v3) {
        }
        else {
            v3 = v1;
        }

        long v1_1 = 0xFFFFFFFFL;
        int v7 = ((int)(arg7 & v1_1));
        int v8 = Constraints.getMinHeight-impl(arg5);
        int v5 = Constraints.getMaxHeight-impl(arg5);
        if(v7 < v8) {
            v7 = v8;
        }

        if(v7 > v5) {
        }
        else {
            v5 = v7;
        }

        return IntSize.constructor-impl((((long)v3)) << v0 | (((long)v5)) & v1_1);
    }

    public static final long constrain-N9IONVI(long arg4, long arg6) {
        int v0 = Constraints.getMinWidth-impl(arg4);
        int v1 = Constraints.getMaxWidth-impl(arg4);
        int v2 = Constraints.getMinHeight-impl(arg4);
        int v4 = Constraints.getMaxHeight-impl(arg4);
        int v5 = Constraints.getMinWidth-impl(arg6);
        if(v5 < v0) {
            v5 = v0;
        }

        if(v5 > v1) {
            v5 = v1;
        }

        int v3 = Constraints.getMaxWidth-impl(arg6);
        if(v3 < v0) {
        }
        else {
            v0 = v3;
        }

        if(v0 > v1) {
        }
        else {
            v1 = v0;
        }

        v0 = Constraints.getMinHeight-impl(arg6);
        if(v0 < v2) {
            v0 = v2;
        }

        if(v0 > v4) {
            v0 = v4;
        }

        int v6 = Constraints.getMaxHeight-impl(arg6);
        if(v6 < v2) {
        }
        else {
            v2 = v6;
        }

        if(v2 > v4) {
        }
        else {
            v4 = v2;
        }

        return ConstraintsKt.Constraints(v5, v1, v0, v4);
    }

    public static final int constrainHeight-K40F9xA(long arg1, int arg3) {
        int v0 = Constraints.getMinHeight-impl(arg1);
        int v1 = Constraints.getMaxHeight-impl(arg1);
        if(arg3 < v0) {
            arg3 = v0;
        }

        if(arg3 > v1) {
            return v1;
        }

        return arg3;
    }

    public static final int constrainWidth-K40F9xA(long arg1, int arg3) {
        int v0 = Constraints.getMinWidth-impl(arg1);
        int v1 = Constraints.getMaxWidth-impl(arg1);
        if(arg3 < v0) {
            arg3 = v0;
        }

        if(arg3 > v1) {
            return v1;
        }

        return arg3;
    }

    public static final long createConstraints(int arg6, int arg7, int arg8, int arg9) {
        int v0 = 0x7FFFFFFF;
        int v1 = arg9 == v0 ? arg8 : arg9;
        int v2 = ConstraintsKt.bitsNeedForSizeUnchecked(v1);
        v0 = arg7 == v0 ? arg6 : arg7;
        int v3 = ConstraintsKt.bitsNeedForSizeUnchecked(v0);
        if(v2 + v3 > 0x1F) {
            ConstraintsKt.throwInvalidConstraintException(v0, v1);
        }

        ++arg7;
        ++arg9;
        v0 = v3 - 13;
        return Constraints.constructor-impl((((long)(arg7 & ~(arg7 >> 0x1F)))) << 33 | ((((long)((v0 >> 1) + (v0 & 1)))) | (((long)arg6)) << 2) | (((long)arg8)) << v3 + 2 | (((long)(arg9 & ~(arg9 >> 0x1F)))) << v3 + 33);
    }

    public static void getMaxDimensionsAndFocusMask$annotations() {
    }

    private static final int heightMask(int arg1) {
        return (1 << 18 - arg1) - 1;
    }

    private static final int indexToBitOffset(int arg1) {
        return ((arg1 & 1) << 1) + ((arg1 & 2) >> 1) * 3;
    }

    public static final boolean isSatisfiedBy-4WqzIAM(long arg4, long arg6) {
        int v0 = Constraints.getMinWidth-impl(arg4);
        int v1 = Constraints.getMaxWidth-impl(arg4);
        int v2 = ((int)(arg6 >> 0x20));
        if(v0 <= v2 && v2 <= v1) {
            v0 = Constraints.getMinHeight-impl(arg4);
            int v4 = Constraints.getMaxHeight-impl(arg4);
            int v5 = ((int)(arg6 & 0xFFFFFFFFL));
            if(v0 <= v5 && v5 <= v4) {
                return 1;
            }
        }

        return 0;
    }

    private static final int maxAllowedForSize(int arg1) {
        if(arg1 < 0x1FFF) {
            return 0x3FFFE;
        }

        if(arg1 < 0x7FFF) {
            return 0xFFFE;
        }

        if(arg1 < 0xFFFF) {
            return 0x7FFE;
        }

        if(arg1 < 0x3FFFF) {
            return 0x1FFE;
        }

        ConstraintsKt.throwInvalidConstraintsSizeException(arg1);
        throw new KotlinNothingValueException();
    }

    private static final int minHeightOffsets(int arg0) {
        return arg0 + 15;
    }

    public static final long offset-NN6Ew-U(long arg4, int arg6, int arg7) {
        int v0 = Constraints.getMinWidth-impl(arg4) + arg6;
        int v1 = 0;
        if(v0 < 0) {
            v0 = 0;
        }

        int v2 = Constraints.getMaxWidth-impl(arg4);
        int v3 = 0x7FFFFFFF;
        if(v2 == v3) {
        }
        else {
            v2 += arg6;
            if(v2 < 0) {
                v2 = 0;
            }
        }

        arg6 = Constraints.getMinHeight-impl(arg4) + arg7;
        if(arg6 < 0) {
            arg6 = 0;
        }

        int v4 = Constraints.getMaxHeight-impl(arg4);
        if(v4 != v3) {
            v4 += arg7;
            if(v4 >= 0) {
                goto label_18;
            }
        }
        else {
        label_18:
            v1 = v4;
        }

        return ConstraintsKt.Constraints(v0, v2, arg6, v1);
    }

    public static long offset-NN6Ew-U$default(long arg1, int arg3, int arg4, int arg5, Object arg6) {
        return ConstraintsKt.offset-NN6Ew-U(arg1, 0, 0);
    }

    public static final void throwInvalidConstraintException(int arg3, int arg4) {
        throw new IllegalArgumentException("Can\'t represent a width of " + arg3 + " and height of " + arg4 + " in Constraints");
    }

    public static final Void throwInvalidConstraintsSizeException(int arg3) {
        throw new IllegalArgumentException("Can\'t represent a size of " + arg3 + " in Constraints");
    }

    private static final int widthMask(int arg1) {
        return (1 << arg1 + 13) - 1;
    }
}

