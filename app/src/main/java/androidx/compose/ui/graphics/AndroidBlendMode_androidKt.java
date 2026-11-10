package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff$Mode;
import android.os.Build$VERSION;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0011\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0013\u0010\u0005\u001A\u00020\u0006*\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A\u0013\u0010\t\u001A\u00020\n*\u00020\u0002H\u0001¢\u0006\u0004\b\u000B\u0010\f\u001A\u0011\u0010\r\u001A\u00020\u0002*\u00020\nH\u0001¢\u0006\u0002\u0010\u000E¨\u0006\u000F"}, d2={"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidBlendMode_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[BlendMode.values().length];
            try {
                v0[BlendMode.CLEAR.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[BlendMode.SRC.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[BlendMode.DST.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[BlendMode.SRC_OVER.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[BlendMode.DST_OVER.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[BlendMode.SRC_IN.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[BlendMode.DST_IN.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[BlendMode.SRC_OUT.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[BlendMode.DST_OUT.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[BlendMode.SRC_ATOP.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_43:
                                                        v0[BlendMode.DST_ATOP.ordinal()] = 11;
                                                        goto label_47;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_47:
                                                            v0[BlendMode.XOR.ordinal()] = 12;
                                                            goto label_51;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_51:
                                                                v0[BlendMode.PLUS.ordinal()] = 13;
                                                                goto label_55;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_55:
                                                                    v0[BlendMode.MODULATE.ordinal()] = 14;
                                                                    goto label_59;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_59:
                                                                        v0[BlendMode.SCREEN.ordinal()] = 15;
                                                                        goto label_63;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                        try {
                                                                        label_63:
                                                                            v0[BlendMode.OVERLAY.ordinal()] = 16;
                                                                            goto label_67;
                                                                        }
                                                                        catch(NoSuchFieldError ) {
                                                                            try {
                                                                            label_67:
                                                                                v0[BlendMode.DARKEN.ordinal()] = 17;
                                                                                goto label_71;
                                                                            }
                                                                            catch(NoSuchFieldError ) {
                                                                                try {
                                                                                label_71:
                                                                                    v0[BlendMode.LIGHTEN.ordinal()] = 18;
                                                                                    goto label_75;
                                                                                }
                                                                                catch(NoSuchFieldError ) {
                                                                                    try {
                                                                                    label_75:
                                                                                        v0[BlendMode.COLOR_DODGE.ordinal()] = 19;
                                                                                        goto label_79;
                                                                                    }
                                                                                    catch(NoSuchFieldError ) {
                                                                                        try {
                                                                                        label_79:
                                                                                            v0[BlendMode.COLOR_BURN.ordinal()] = 20;
                                                                                            goto label_83;
                                                                                        }
                                                                                        catch(NoSuchFieldError ) {
                                                                                            try {
                                                                                            label_83:
                                                                                                v0[BlendMode.HARD_LIGHT.ordinal()] = 21;
                                                                                                goto label_87;
                                                                                            }
                                                                                            catch(NoSuchFieldError ) {
                                                                                                try {
                                                                                                label_87:
                                                                                                    v0[BlendMode.SOFT_LIGHT.ordinal()] = 22;
                                                                                                    goto label_91;
                                                                                                }
                                                                                                catch(NoSuchFieldError ) {
                                                                                                    try {
                                                                                                    label_91:
                                                                                                        v0[BlendMode.DIFFERENCE.ordinal()] = 23;
                                                                                                        goto label_95;
                                                                                                    }
                                                                                                    catch(NoSuchFieldError ) {
                                                                                                        try {
                                                                                                        label_95:
                                                                                                            v0[BlendMode.EXCLUSION.ordinal()] = 24;
                                                                                                            goto label_99;
                                                                                                        }
                                                                                                        catch(NoSuchFieldError ) {
                                                                                                            try {
                                                                                                            label_99:
                                                                                                                v0[BlendMode.MULTIPLY.ordinal()] = 25;
                                                                                                                goto label_103;
                                                                                                            }
                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                try {
                                                                                                                label_103:
                                                                                                                    v0[BlendMode.HUE.ordinal()] = 26;
                                                                                                                    goto label_107;
                                                                                                                }
                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                    try {
                                                                                                                    label_107:
                                                                                                                        v0[BlendMode.SATURATION.ordinal()] = 27;
                                                                                                                        goto label_111;
                                                                                                                    }
                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                        try {
                                                                                                                        label_111:
                                                                                                                            v0[BlendMode.COLOR.ordinal()] = 28;
                                                                                                                            goto label_115;
                                                                                                                        }
                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                            try {
                                                                                                                            label_115:
                                                                                                                                v0[BlendMode.LUMINOSITY.ordinal()] = 29;
                                                                                                                                goto label_119;
                                                                                                                            }
                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                            label_119:
                                                                                                                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final boolean isSupported-s9anfk8(int arg2) {
        if(Build$VERSION.SDK_INT < 29 && !androidx.compose.ui.graphics.BlendMode.equals-impl0(arg2, androidx.compose.ui.graphics.BlendMode.Companion.getSrcOver-0nO6VwU())) {
            if(AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(arg2) != PorterDuff$Mode.SRC_OVER) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final BlendMode toAndroidBlendMode-s9anfk8(int arg1) {
        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getClear-0nO6VwU())) {
            return BlendMode.CLEAR;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrc-0nO6VwU())) {
            return BlendMode.SRC;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDst-0nO6VwU())) {
            return BlendMode.DST;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcOver-0nO6VwU())) {
            return BlendMode.SRC_OVER;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstOver-0nO6VwU())) {
            return BlendMode.DST_OVER;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcIn-0nO6VwU())) {
            return BlendMode.SRC_IN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstIn-0nO6VwU())) {
            return BlendMode.DST_IN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcOut-0nO6VwU())) {
            return BlendMode.SRC_OUT;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstOut-0nO6VwU())) {
            return BlendMode.DST_OUT;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcAtop-0nO6VwU())) {
            return BlendMode.SRC_ATOP;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstAtop-0nO6VwU())) {
            return BlendMode.DST_ATOP;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getXor-0nO6VwU())) {
            return BlendMode.XOR;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getPlus-0nO6VwU())) {
            return BlendMode.PLUS;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getModulate-0nO6VwU())) {
            return BlendMode.MODULATE;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getScreen-0nO6VwU())) {
            return BlendMode.SCREEN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getOverlay-0nO6VwU())) {
            return BlendMode.OVERLAY;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDarken-0nO6VwU())) {
            return BlendMode.DARKEN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getLighten-0nO6VwU())) {
            return BlendMode.LIGHTEN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getColorDodge-0nO6VwU())) {
            return BlendMode.COLOR_DODGE;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getColorBurn-0nO6VwU())) {
            return BlendMode.COLOR_BURN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getHardlight-0nO6VwU())) {
            return BlendMode.HARD_LIGHT;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSoftlight-0nO6VwU())) {
            return BlendMode.SOFT_LIGHT;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDifference-0nO6VwU())) {
            return BlendMode.DIFFERENCE;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getExclusion-0nO6VwU())) {
            return BlendMode.EXCLUSION;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getMultiply-0nO6VwU())) {
            return BlendMode.MULTIPLY;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getHue-0nO6VwU())) {
            return BlendMode.HUE;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSaturation-0nO6VwU())) {
            return BlendMode.SATURATION;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getColor-0nO6VwU())) {
            return BlendMode.COLOR;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getLuminosity-0nO6VwU())) {
            return BlendMode.LUMINOSITY;
        }

        return BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(BlendMode arg1) {
        switch(WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()]) {
            case 1: {
                goto label_91;
            }
            case 2: {
                goto label_88;
            }
            case 3: {
                goto label_85;
            }
            case 4: {
                goto label_82;
            }
            case 5: {
                goto label_79;
            }
            case 6: {
                goto label_76;
            }
            case 7: {
                goto label_73;
            }
            case 8: {
                goto label_70;
            }
            case 9: {
                goto label_67;
            }
            case 10: {
                goto label_64;
            }
            case 11: {
                goto label_61;
            }
            case 12: {
                goto label_58;
            }
            case 13: {
                goto label_55;
            }
            case 14: {
                goto label_52;
            }
            case 15: {
                goto label_49;
            }
            case 16: {
                goto label_46;
            }
            case 17: {
                goto label_43;
            }
            case 18: {
                goto label_40;
            }
            case 19: {
                goto label_37;
            }
            case 20: {
                goto label_34;
            }
            case 21: {
                goto label_31;
            }
            case 22: {
                goto label_28;
            }
            case 23: {
                goto label_25;
            }
            case 24: {
                goto label_22;
            }
            case 25: {
                goto label_19;
            }
            case 26: {
                goto label_16;
            }
            case 27: {
                goto label_13;
            }
            case 28: {
                goto label_10;
            }
            case 29: {
                goto label_7;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_34:
        return androidx.compose.ui.graphics.BlendMode.Companion.getColorBurn-0nO6VwU();
    label_37:
        return androidx.compose.ui.graphics.BlendMode.Companion.getColorDodge-0nO6VwU();
    label_40:
        return androidx.compose.ui.graphics.BlendMode.Companion.getLighten-0nO6VwU();
    label_43:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDarken-0nO6VwU();
    label_46:
        return androidx.compose.ui.graphics.BlendMode.Companion.getOverlay-0nO6VwU();
    label_49:
        return androidx.compose.ui.graphics.BlendMode.Companion.getScreen-0nO6VwU();
    label_52:
        return androidx.compose.ui.graphics.BlendMode.Companion.getModulate-0nO6VwU();
    label_55:
        return androidx.compose.ui.graphics.BlendMode.Companion.getPlus-0nO6VwU();
    label_58:
        return androidx.compose.ui.graphics.BlendMode.Companion.getXor-0nO6VwU();
    label_61:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDstAtop-0nO6VwU();
    label_64:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSrcAtop-0nO6VwU();
    label_67:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDstOut-0nO6VwU();
    label_70:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSrcOut-0nO6VwU();
    label_7:
        return androidx.compose.ui.graphics.BlendMode.Companion.getLuminosity-0nO6VwU();
    label_73:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDstIn-0nO6VwU();
    label_10:
        return androidx.compose.ui.graphics.BlendMode.Companion.getColor-0nO6VwU();
    label_76:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSrcIn-0nO6VwU();
    label_13:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSaturation-0nO6VwU();
    label_79:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDstOver-0nO6VwU();
    label_16:
        return androidx.compose.ui.graphics.BlendMode.Companion.getHue-0nO6VwU();
    label_82:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSrcOver-0nO6VwU();
    label_19:
        return androidx.compose.ui.graphics.BlendMode.Companion.getMultiply-0nO6VwU();
    label_85:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDst-0nO6VwU();
    label_22:
        return androidx.compose.ui.graphics.BlendMode.Companion.getExclusion-0nO6VwU();
    label_88:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSrc-0nO6VwU();
    label_25:
        return androidx.compose.ui.graphics.BlendMode.Companion.getDifference-0nO6VwU();
    label_91:
        return androidx.compose.ui.graphics.BlendMode.Companion.getClear-0nO6VwU();
    label_28:
        return androidx.compose.ui.graphics.BlendMode.Companion.getSoftlight-0nO6VwU();
    label_31:
        return androidx.compose.ui.graphics.BlendMode.Companion.getHardlight-0nO6VwU();
    }

    public static final PorterDuff$Mode toPorterDuffMode-s9anfk8(int arg1) {
        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getClear-0nO6VwU())) {
            return PorterDuff$Mode.CLEAR;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrc-0nO6VwU())) {
            return PorterDuff$Mode.SRC;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDst-0nO6VwU())) {
            return PorterDuff$Mode.DST;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcOver-0nO6VwU())) {
            return PorterDuff$Mode.SRC_OVER;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstOver-0nO6VwU())) {
            return PorterDuff$Mode.DST_OVER;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcIn-0nO6VwU())) {
            return PorterDuff$Mode.SRC_IN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstIn-0nO6VwU())) {
            return PorterDuff$Mode.DST_IN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcOut-0nO6VwU())) {
            return PorterDuff$Mode.SRC_OUT;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstOut-0nO6VwU())) {
            return PorterDuff$Mode.DST_OUT;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getSrcAtop-0nO6VwU())) {
            return PorterDuff$Mode.SRC_ATOP;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDstAtop-0nO6VwU())) {
            return PorterDuff$Mode.DST_ATOP;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getXor-0nO6VwU())) {
            return PorterDuff$Mode.XOR;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getPlus-0nO6VwU())) {
            return PorterDuff$Mode.ADD;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getScreen-0nO6VwU())) {
            return PorterDuff$Mode.SCREEN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getOverlay-0nO6VwU())) {
            return PorterDuff$Mode.OVERLAY;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getDarken-0nO6VwU())) {
            return PorterDuff$Mode.DARKEN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getLighten-0nO6VwU())) {
            return PorterDuff$Mode.LIGHTEN;
        }

        if(androidx.compose.ui.graphics.BlendMode.equals-impl0(arg1, androidx.compose.ui.graphics.BlendMode.Companion.getModulate-0nO6VwU())) {
            return PorterDuff$Mode.MULTIPLY;
        }

        return PorterDuff$Mode.SRC_OVER;
    }
}

