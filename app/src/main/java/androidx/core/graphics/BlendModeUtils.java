package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff$Mode;

class BlendModeUtils {
    class androidx.core.graphics.BlendModeUtils$1 {
        static {
            int[] v0 = new int[BlendModeCompat.values().length];
            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat = v0;
            try {
                v0[BlendModeCompat.CLEAR.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_OVER.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_OVER.ordinal()] = 5;
                                goto label_28;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_28:
                                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_IN.ordinal()] = 6;
                                    goto label_33;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_33:
                                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_IN.ordinal()] = 7;
                                        goto label_38;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_38:
                                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_OUT.ordinal()] = 8;
                                            goto label_43;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_43:
                                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_OUT.ordinal()] = 9;
                                                goto label_48;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_48:
                                                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_ATOP.ordinal()] = 10;
                                                    goto label_53;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_53:
                                                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_ATOP.ordinal()] = 11;
                                                        goto label_58;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_58:
                                                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.XOR.ordinal()] = 12;
                                                            goto label_63;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_63:
                                                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.PLUS.ordinal()] = 13;
                                                                goto label_68;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_68:
                                                                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.MODULATE.ordinal()] = 14;
                                                                    goto label_73;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_73:
                                                                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SCREEN.ordinal()] = 15;
                                                                        goto label_78;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                        try {
                                                                        label_78:
                                                                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.OVERLAY.ordinal()] = 16;
                                                                            goto label_83;
                                                                        }
                                                                        catch(NoSuchFieldError ) {
                                                                            try {
                                                                            label_83:
                                                                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DARKEN.ordinal()] = 17;
                                                                                goto label_88;
                                                                            }
                                                                            catch(NoSuchFieldError ) {
                                                                                try {
                                                                                label_88:
                                                                                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.LIGHTEN.ordinal()] = 18;
                                                                                    goto label_93;
                                                                                }
                                                                                catch(NoSuchFieldError ) {
                                                                                    try {
                                                                                    label_93:
                                                                                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR_DODGE.ordinal()] = 19;
                                                                                        goto label_98;
                                                                                    }
                                                                                    catch(NoSuchFieldError ) {
                                                                                        try {
                                                                                        label_98:
                                                                                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR_BURN.ordinal()] = 20;
                                                                                            goto label_103;
                                                                                        }
                                                                                        catch(NoSuchFieldError ) {
                                                                                            try {
                                                                                            label_103:
                                                                                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.HARD_LIGHT.ordinal()] = 21;
                                                                                                goto label_108;
                                                                                            }
                                                                                            catch(NoSuchFieldError ) {
                                                                                                try {
                                                                                                label_108:
                                                                                                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SOFT_LIGHT.ordinal()] = 22;
                                                                                                    goto label_113;
                                                                                                }
                                                                                                catch(NoSuchFieldError ) {
                                                                                                    try {
                                                                                                    label_113:
                                                                                                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DIFFERENCE.ordinal()] = 23;
                                                                                                        goto label_118;
                                                                                                    }
                                                                                                    catch(NoSuchFieldError ) {
                                                                                                        try {
                                                                                                        label_118:
                                                                                                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.EXCLUSION.ordinal()] = 24;
                                                                                                            goto label_123;
                                                                                                        }
                                                                                                        catch(NoSuchFieldError ) {
                                                                                                            try {
                                                                                                            label_123:
                                                                                                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.MULTIPLY.ordinal()] = 25;
                                                                                                                goto label_128;
                                                                                                            }
                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                try {
                                                                                                                label_128:
                                                                                                                    androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.HUE.ordinal()] = 26;
                                                                                                                    goto label_133;
                                                                                                                }
                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                    try {
                                                                                                                    label_133:
                                                                                                                        androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SATURATION.ordinal()] = 27;
                                                                                                                        goto label_138;
                                                                                                                    }
                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                        try {
                                                                                                                        label_138:
                                                                                                                            androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR.ordinal()] = 28;
                                                                                                                            goto label_143;
                                                                                                                        }
                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                            try {
                                                                                                                            label_143:
                                                                                                                                androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.LUMINOSITY.ordinal()] = 29;
                                                                                                                                return;
                                                                                                                            }
                                                                                                                            catch(NoSuchFieldError ) {
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

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static Object obtainBlendModeFromCompat(BlendModeCompat arg1) {
            switch(androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[arg1.ordinal()]) {
                case 1: {
                    goto label_62;
                }
                case 2: {
                    goto label_60;
                }
                case 3: {
                    goto label_58;
                }
                case 4: {
                    goto label_56;
                }
                case 5: {
                    goto label_54;
                }
                case 6: {
                    goto label_52;
                }
                case 7: {
                    goto label_50;
                }
                case 8: {
                    goto label_48;
                }
                case 9: {
                    goto label_46;
                }
                case 10: {
                    goto label_44;
                }
                case 11: {
                    goto label_42;
                }
                case 12: {
                    goto label_40;
                }
                case 13: {
                    goto label_38;
                }
                case 14: {
                    goto label_36;
                }
                case 15: {
                    goto label_34;
                }
                case 16: {
                    goto label_32;
                }
                case 17: {
                    goto label_30;
                }
                case 18: {
                    goto label_28;
                }
                case 19: {
                    goto label_26;
                }
                case 20: {
                    goto label_24;
                }
                case 21: {
                    goto label_22;
                }
                case 22: {
                    goto label_20;
                }
                case 23: {
                    goto label_18;
                }
                case 24: {
                    goto label_16;
                }
                case 25: {
                    goto label_14;
                }
                case 26: {
                    goto label_12;
                }
                case 27: {
                    goto label_10;
                }
                case 28: {
                    goto label_8;
                }
                case 29: {
                    goto label_6;
                }
            }

            return null;
        label_34:
            return BlendMode.SCREEN;
        label_36:
            return BlendMode.MODULATE;
        label_38:
            return BlendMode.PLUS;
        label_40:
            return BlendMode.XOR;
        label_42:
            return BlendMode.DST_ATOP;
        label_44:
            return BlendMode.SRC_ATOP;
        label_46:
            return BlendMode.DST_OUT;
        label_48:
            return BlendMode.SRC_OUT;
        label_50:
            return BlendMode.DST_IN;
        label_52:
            return BlendMode.SRC_IN;
        label_54:
            return BlendMode.DST_OVER;
        label_56:
            return BlendMode.SRC_OVER;
        label_58:
            return BlendMode.DST;
        label_60:
            return BlendMode.SRC;
        label_62:
            return BlendMode.CLEAR;
        label_6:
            return BlendMode.LUMINOSITY;
        label_8:
            return BlendMode.COLOR;
        label_10:
            return BlendMode.SATURATION;
        label_12:
            return BlendMode.HUE;
        label_14:
            return BlendMode.MULTIPLY;
        label_16:
            return BlendMode.EXCLUSION;
        label_18:
            return BlendMode.DIFFERENCE;
        label_20:
            return BlendMode.SOFT_LIGHT;
        label_22:
            return BlendMode.HARD_LIGHT;
        label_24:
            return BlendMode.COLOR_BURN;
        label_26:
            return BlendMode.COLOR_DODGE;
        label_28:
            return BlendMode.LIGHTEN;
        label_30:
            return BlendMode.DARKEN;
        label_32:
            return BlendMode.OVERLAY;
        }
    }

    private BlendModeUtils() {
        super();
    }

    static PorterDuff$Mode obtainPorterDuffFromCompat(BlendModeCompat arg2) {
        PorterDuff$Mode v0 = null;
        if(arg2 == null) {
            return v0;
        }

        switch(androidx.core.graphics.BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat[arg2.ordinal()]) {
            case 1: {
                goto label_42;
            }
            case 2: {
                goto label_40;
            }
            case 3: {
                goto label_38;
            }
            case 4: {
                goto label_36;
            }
            case 5: {
                goto label_34;
            }
            case 6: {
                goto label_32;
            }
            case 7: {
                goto label_30;
            }
            case 8: {
                goto label_28;
            }
            case 9: {
                goto label_26;
            }
            case 10: {
                goto label_24;
            }
            case 11: {
                goto label_22;
            }
            case 12: {
                goto label_20;
            }
            case 13: {
                goto label_18;
            }
            case 14: {
                goto label_16;
            }
            case 15: {
                goto label_14;
            }
            case 16: {
                goto label_12;
            }
            case 17: {
                goto label_10;
            }
            case 18: {
                goto label_8;
            }
        }

        return v0;
    label_34:
        return PorterDuff$Mode.DST_OVER;
    label_36:
        return PorterDuff$Mode.SRC_OVER;
    label_38:
        return PorterDuff$Mode.DST;
    label_40:
        return PorterDuff$Mode.SRC;
    label_8:
        return PorterDuff$Mode.LIGHTEN;
    label_42:
        return PorterDuff$Mode.CLEAR;
    label_10:
        return PorterDuff$Mode.DARKEN;
    label_12:
        return PorterDuff$Mode.OVERLAY;
    label_14:
        return PorterDuff$Mode.SCREEN;
    label_16:
        return PorterDuff$Mode.MULTIPLY;
    label_18:
        return PorterDuff$Mode.ADD;
    label_20:
        return PorterDuff$Mode.XOR;
    label_22:
        return PorterDuff$Mode.DST_ATOP;
    label_24:
        return PorterDuff$Mode.SRC_ATOP;
    label_26:
        return PorterDuff$Mode.DST_OUT;
    label_28:
        return PorterDuff$Mode.SRC_OUT;
    label_30:
        return PorterDuff$Mode.DST_IN;
    label_32:
        return PorterDuff$Mode.SRC_IN;
    }
}

