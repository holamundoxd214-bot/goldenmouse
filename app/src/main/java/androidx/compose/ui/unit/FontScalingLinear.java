package androidx.compose.ui.unit;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001A\u00020\t*\u00020\nH\u0017¢\u0006\u0004\b\u000B\u0010\fJ\u0013\u0010\r\u001A\u00020\n*\u00020\tH\u0017¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0002\u001A\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2={"Landroidx/compose/ui/unit/FontScalingLinear;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public interface FontScalingLinear {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void getFontScale$annotations() {
        }

        @Deprecated public static float toDp-GaN1DYA(FontScalingLinear arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(FontScalingLinear arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }
    }

    static float access$toDp-GaN1DYA$jd(FontScalingLinear arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static long access$toSp-0xMU5do$jd(FontScalingLinear arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    float getFontScale();

    default float toDp-GaN1DYA(long arg5) {
        if(TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg5), TextUnitType.Companion.getSp-UIouoOA())) {
            return Dp.constructor-impl(TextUnit.getValue-impl(arg5) * this.getFontScale());
        }

        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    default long toSp-0xMU5do(float arg1) {
        return TextUnitKt.getSp(arg1 / this.getFontScale());
    }
}

