package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public final class DynamicColor {
    public final Function background;
    public final ContrastCurve contrastCurve;
    private final HashMap hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function opacity;
    public final Function palette;
    public final Function secondBackground;
    public final Function tone;
    public final Function toneDeltaPair;

    public DynamicColor(String arg2, Function arg3, Function arg4, boolean arg5, Function arg6, Function arg7, ContrastCurve arg8, Function arg9) {
        super();
        this.hctCache = new HashMap();
        this.name = arg2;
        this.palette = arg3;
        this.tone = arg4;
        this.isBackground = arg5;
        this.background = arg6;
        this.secondBackground = arg7;
        this.contrastCurve = arg8;
        this.toneDeltaPair = arg9;
        this.opacity = null;
    }

    public DynamicColor(String arg2, Function arg3, Function arg4, boolean arg5, Function arg6, Function arg7, ContrastCurve arg8, Function arg9, Function arg10) {
        super();
        this.hctCache = new HashMap();
        this.name = arg2;
        this.palette = arg3;
        this.tone = arg4;
        this.isBackground = arg5;
        this.background = arg6;
        this.secondBackground = arg7;
        this.contrastCurve = arg8;
        this.toneDeltaPair = arg9;
        this.opacity = arg10;
    }

    public static double enableLightForeground(double arg1) {
        if((DynamicColor.tonePrefersLightForeground(arg1)) && !DynamicColor.toneAllowsLightForeground(arg1)) {
            arg1 = 49;
        }

        return arg1;
    }

    public static double foregroundTone(double arg10, double arg12) {
        double v0 = Contrast.lighterUnsafe(arg10, arg12);
        double v2 = Contrast.darkerUnsafe(arg10, arg12);
        double v4 = Contrast.ratioOfTones(v0, arg10);
        double v6 = Contrast.ratioOfTones(v2, arg10);
        if(DynamicColor.tonePrefersLightForeground(arg10)) {
            int v10 = Math.abs(v4 - v6) >= 0.1 || v4 >= arg12 || v6 >= arg12 ? 0 : 1;
            if(v4 >= arg12) {
                return v0;
            }

            if(v4 >= v6) {
                return v0;
            }

            if(v10 == 0) {
                return v2;
            }

            return v0;
        }
        else {
            if(v6 >= arg12) {
                return v2;
            }

            if(v6 >= v4) {
                return v2;
            }

            return v0;
        }

        return v2;
    }

    public static DynamicColor fromArgb(String arg2, int arg3) {
        return DynamicColor.fromPalette(arg2, new DynamicColor$$ExternalSyntheticLambda0(TonalPalette.fromInt(arg3)), new DynamicColor$$ExternalSyntheticLambda1(Hct.fromInt(arg3)));
    }

    public static DynamicColor fromPalette(String arg9, Function arg10, Function arg11) {
        return new DynamicColor(arg9, arg10, arg11, false, null, null, null, null);
    }

    public static DynamicColor fromPalette(String arg9, Function arg10, Function arg11, boolean arg12) {
        return new DynamicColor(arg9, arg10, arg11, arg12, null, null, null, null);
    }

    public int getArgb(DynamicScheme arg4) {
        int v0 = this.getHct(arg4).toInt();
        Function v3 = this.opacity;
        if(v3 == null) {
            return v0;
        }

        return MathUtils.clampInt(0, 0xFF, ((int)Math.round(v3.apply(arg4).doubleValue() * 255))) << 24 | 0xFFFFFF & v0;
    }

    public Hct getHct(DynamicScheme arg4) {
        Object v0 = this.hctCache.get(arg4);
        if(v0 != null) {
            return ((Hct)v0);
        }

        Hct v0_1 = this.palette.apply(arg4).getHct(this.getTone(arg4));
        if(this.hctCache.size() > 4) {
            this.hctCache.clear();
        }

        this.hctCache.put(arg4, v0_1);
        return v0_1;
    }

    public double getTone(DynamicScheme arg33) {
        double v1_1;
        double v14;
        double v24;
        double v16_1;
        double v22;
        double v20;
        DynamicColor v0 = this;
        DynamicScheme v1 = arg33;
        double v4 = 0;
        int v3 = 1;
        int v2 = Double.compare(v1.contrastLevel, v4) < 0 ? 1 : 0;
        Function v7 = v0.toneDeltaPair;
        double v12 = 49;
        if(v7 != null) {
            Object v7_1 = v7.apply(v1);
            DynamicColor v16 = ((ToneDeltaPair)v7_1).getRoleA();
            DynamicColor v17 = ((ToneDeltaPair)v7_1).getRoleB();
            double v18 = ((ToneDeltaPair)v7_1).getDelta();
            v20 = v4;
            TonePolarity v4_1 = ((ToneDeltaPair)v7_1).getPolarity();
            boolean v5 = ((ToneDeltaPair)v7_1).getStayTogether();
            v22 = -1;
            double v8 = v0.background.apply(v1).getTone(v1);
            if(v4_1 != TonePolarity.NEARER && (v4_1 != TonePolarity.LIGHTER || (v1.isDark)) && (v4_1 != TonePolarity.DARKER || !v1.isDark)) {
                v3 = 0;
            }

            DynamicColor v4_2 = v3 != 0 ? v16 : v17;
            DynamicColor v3_1 = v3 != 0 ? v17 : v16;
            boolean v0_1 = v0.name.equals(v4_2.name);
            if(v1.isDark) {
                v22 = 1;
            }

            v16_1 = 50;
            double v6 = v4_2.contrastCurve.getContrast(v1.contrastLevel);
            v24 = 60;
            double v10 = v3_1.contrastCurve.getContrast(v1.contrastLevel);
            v14 = v4_2.tone.apply(v1).doubleValue();
            if(Contrast.ratioOfTones(v8, v14) >= v6) {
            }
            else {
                v14 = DynamicColor.foregroundTone(v8, v6);
            }

            double v3_2 = v3_1.tone.apply(v1).doubleValue();
            if(Contrast.ratioOfTones(v8, v3_2) >= v10) {
            }
            else {
                v3_2 = DynamicColor.foregroundTone(v8, v10);
            }

            if(v2 != 0) {
                v14 = DynamicColor.foregroundTone(v8, v6);
                v3_2 = DynamicColor.foregroundTone(v8, v10);
            }

            if((v3_2 - v14) * v22 < v18) {
                v1_1 = v18 * v22;
                v3_2 = MathUtils.clampDouble(0, 100, v14 + v1_1);
                if((v3_2 - v14) * v22 < v18) {
                    v14 = MathUtils.clampDouble(0, 100, v3_2 - v1_1);
                }
            }

            if(v16_1 > v14 || v14 >= v24) {
                if(v16_1 <= v3_2 && v3_2 < v24) {
                    if(v5) {
                        if(v22 > v20) {
                            v12 = Math.max(v3_2, v18 * v22 + v24);
                        label_98:
                            v14 = v24;
                        }
                        else {
                            v1_1 = Math.min(v3_2, v18 * v22 + v12);
                        label_103:
                            v14 = v12;
                            v12 = v1_1;
                        }
                    }
                    else if(v22 > v20) {
                        v12 = v24;
                    }
                    else {
                    }

                    goto label_122;
                }

                v12 = v3_2;
            }
            else if(v22 > v20) {
                v12 = Math.max(v3_2, v18 * v22 + v24);
                goto label_98;
            }
            else {
                v1_1 = Math.min(v3_2, v18 * v22 + v12);
                goto label_103;
            }

        label_122:
            if(v0_1) {
                return v14;
            }

            return v12;
        }

        v20 = v4;
        v16_1 = 50;
        v22 = -1;
        v24 = 60;
        v4 = v0.tone.apply(v1).doubleValue();
        v7 = v0.background;
        if(v7 == null) {
            return v4;
        }

        double v7_2 = v7.apply(v1).getTone(v1);
        double v9 = v0.contrastCurve.getContrast(v1.contrastLevel);
        if(Contrast.ratioOfTones(v7_2, v4) >= v9) {
        }
        else {
            v4 = DynamicColor.foregroundTone(v7_2, v9);
        }

        if(v2 != 0) {
            v4 = DynamicColor.foregroundTone(v7_2, v9);
        }

        if(!v0.isBackground || v16_1 > v4 || v4 >= v24) {
            v12 = v4;
        }
        else if(Contrast.ratioOfTones(v12, v7_2) >= v9) {
        }
        else {
            v12 = v24;
        }

        if(v0.secondBackground != null) {
            v4 = v0.background.apply(v1).getTone(v1);
            double v0_2 = v0.secondBackground.apply(v1).getTone(v1);
            v7_2 = Math.max(v4, v0_2);
            v14 = Math.min(v4, v0_2);
            if(Contrast.ratioOfTones(v7_2, v12) >= v9 && Contrast.ratioOfTones(v14, v12) >= v9) {
                return v12;
            }

            v7_2 = Contrast.lighter(v7_2, v9);
            v9 = Contrast.darker(v14, v9);
            ArrayList v2_1 = new ArrayList();
            int v11 = Double.compare(v7_2, v22);
            if(v11 != 0) {
                v2_1.add(Double.valueOf(v7_2));
            }

            int v12_1 = Double.compare(v9, v22);
            if(v12_1 != 0) {
                v2_1.add(Double.valueOf(v9));
            }

            if(!DynamicColor.tonePrefersLightForeground(v4)) {
                if(DynamicColor.tonePrefersLightForeground(v0_2)) {
                }
                else if(v2_1.size() == 1) {
                    return v2_1.get(0).doubleValue();
                }
                else if(v12_1 == 0) {
                    return v20;
                }
                else {
                    return v9;
                }
            }

            if(v11 == 0) {
                return 100;
            }

            return v7_2;
        }

        return v12;
    }

    static TonalPalette lambda$fromArgb$0(TonalPalette arg0, DynamicScheme arg1) {
        return arg0;
    }

    static Double lambda$fromArgb$1(Hct arg0, DynamicScheme arg1) {
        return Double.valueOf(arg0.getTone());
    }

    public static boolean toneAllowsLightForeground(double arg2) {
        if(Math.round(arg2) <= 49) {
            return 1;
        }

        return 0;
    }

    public static boolean tonePrefersLightForeground(double arg2) {
        if(Math.round(arg2) < 60) {
            return 1;
        }

        return 0;
    }
}

