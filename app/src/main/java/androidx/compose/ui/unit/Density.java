package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001A\u00020\u0003*\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r*\u00020\tH\u0017¢\u0006\u0004\b\u000E\u0010\u000FJ\u0013\u0010\b\u001A\u00020\u0003*\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\f\u001A\u00020\r*\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\t*\u00020\rH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001A\u00020\u0010*\u00020\rH\u0017¢\u0006\u0004\b\u0019\u0010\u001AJ\u0013\u0010\u0015\u001A\u00020\t*\u00020\u0003H\u0017¢\u0006\u0004\b\u0016\u0010\u000BJ\u0013\u0010\u0018\u001A\u00020\u0010*\u00020\u0003H\u0017¢\u0006\u0004\b\u0019\u0010\u001BJ\f\u0010\u001C\u001A\u00020\u001D*\u00020\u001EH\u0017J\u0013\u0010\u001F\u001A\u00020 *\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001A\u00020!*\u00020 H\u0017¢\u0006\u0004\b%\u0010#R\u001A\u0010\u0002\u001A\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2={"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "toPx", "Landroidx/compose/ui/unit/Dp;", "toPx-0680j_4", "(F)F", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toDpSize", "toDpSize-k-rfVVM", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Density extends FontScaling {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void getDensity$annotations() {
        }

        @Deprecated public static int roundToPx--R2X_6o(Density arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(Density arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(Density arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(Density arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(Density arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(Density arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(Density arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(Density arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(Density arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(Density arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(Density arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(Density arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(Density arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    static int access$roundToPx--R2X_6o$jd(Density arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(Density arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static float access$toDp-GaN1DYA$jd(Density arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(Density arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(Density arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(Density arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(Density arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(Density arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(Density arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(Density arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(Density arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(Density arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(Density arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    float getDensity();

    default int roundToPx--R2X_6o(long arg1) {
        return Math.round(this.toPx--R2X_6o(arg1));
    }

    default int roundToPx-0680j_4(float arg1) {
        float v0 = this.toPx-0680j_4(arg1);
        if(Float.isInfinite(v0)) {
            return 0x7FFFFFFF;
        }

        return Math.round(v0);
    }

    default float toDp-u2uoSUM(float arg1) {
        return Dp.constructor-impl(arg1 / this.getDensity());
    }

    default float toDp-u2uoSUM(int arg1) {
        return Dp.constructor-impl((((float)arg1)) / this.getDensity());
    }

    default long toDpSize-k-rfVVM(long arg4) {
        if(arg4 != 0x7FC000007FC00000L) {
            return DpKt.DpSize-YgX7TsA(this.toDp-u2uoSUM(Float.intBitsToFloat(((int)(arg4 >> 0x20)))), this.toDp-u2uoSUM(Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL)))));
        }

        return DpSize.Companion.getUnspecified-MYxV2XQ();
    }

    default float toPx--R2X_6o(long arg5) {
        if(!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg5), TextUnitType.Companion.getSp-UIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }

        return this.toPx-0680j_4(this.toDp-GaN1DYA(arg5));
    }

    default float toPx-0680j_4(float arg1) {
        return arg1 * this.getDensity();
    }

    default Rect toRect(DpRect arg5) {
        return new Rect(this.toPx-0680j_4(arg5.getLeft-D9Ej5fM()), this.toPx-0680j_4(arg5.getTop-D9Ej5fM()), this.toPx-0680j_4(arg5.getRight-D9Ej5fM()), this.toPx-0680j_4(arg5.getBottom-D9Ej5fM()));
    }

    default long toSize-XkaWNTQ(long arg5) {
        if(arg5 != 0x7FC000007FC00000L) {
            return Size.constructor-impl((((long)Float.floatToRawIntBits(this.toPx-0680j_4(DpSize.getWidth-D9Ej5fM(arg5))))) << 0x20 | (((long)Float.floatToRawIntBits(this.toPx-0680j_4(DpSize.getHeight-D9Ej5fM(arg5))))) & 0xFFFFFFFFL);
        }

        return Size.Companion.getUnspecified-NH-jbRc();
    }

    default long toSp-kPz2Gy4(float arg1) {
        return this.toSp-0xMU5do(this.toDp-u2uoSUM(arg1));
    }

    default long toSp-kPz2Gy4(int arg1) {
        return this.toSp-0xMU5do(this.toDp-u2uoSUM(arg1));
    }
}

