package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9) {
        super();
        this.mHue = arg1;
        this.mChroma = arg2;
        this.mJ = arg3;
        this.mQ = arg4;
        this.mM = arg5;
        this.mS = arg6;
        this.mJstar = arg7;
        this.mAstar = arg8;
        this.mBstar = arg9;
    }

    float distance(CamColor arg4) {
        float v0 = this.getJStar() - arg4.getJStar();
        float v1 = this.getAStar() - arg4.getAStar();
        float v3 = this.getBStar() - arg4.getBStar();
        return ((float)(Math.pow(Math.sqrt(((double)(v0 * v0 + v1 * v1 + v3 * v3))), 0.63) * 1.41));
    }

    private static CamColor findCamByJ(float arg12, float arg13, float arg14) {
        float v1 = 100f;
        float v2 = 1000f;
        float v5 = 0f;
        CamColor v4 = null;
        float v3 = v2;
        while(Math.abs(v5 - v1) > 0.01f) {
            float v6 = (v1 - v5) / 2f + v5;
            int v7 = CamColor.fromJch(v6, arg13, arg12).viewedInSrgb();
            float v8 = CamUtils.lStarFromInt(v7);
            float v9 = Math.abs(arg14 - v8);
            if(v9 < 0.2f) {
                CamColor v7_1 = CamColor.fromColor(v7);
                float v10 = v7_1.distance(CamColor.fromJch(v7_1.getJ(), v7_1.getChroma(), arg12));
                if(v10 <= 1f) {
                    v4 = v7_1;
                    v2 = v9;
                    v3 = v10;
                }
            }

            if(v2 == 0f && v3 == 0f) {
                return v4;
            }

            if(v8 < arg14) {
                v5 = v6;
                continue;
            }

            v1 = v6;
        }

        return v4;
    }

    static CamColor fromColor(int arg14) {
        float[] v0 = new float[7];
        float[] v2 = new float[3];
        CamColor.fromColorInViewingConditions(arg14, ViewingConditions.DEFAULT, v0, v2);
        return new CamColor(v2[0], v2[1], v0[0], v0[1], v0[2], v0[3], v0[4], v0[5], v0[6]);
    }

    static void fromColorInViewingConditions(int arg21, ViewingConditions arg22, float[] arg23, float[] arg24) {
        float[] v1 = arg24;
        CamUtils.xyzFromInt(arg21, v1);
        float[][] v0 = CamUtils.XYZ_TO_CAM16RGB;
        float v3 = v1[0];
        float[] v4 = v0[0];
        float v5 = v4[0] * v3;
        float v7 = v1[1];
        v5 += v4[1] * v7;
        float v9 = v1[2];
        v5 += v4[2] * v9;
        float v10 = v0[1][0] * v3 + v0[1][1] * v7 + v0[1][2] * v9;
        v3 = v3 * v0[2][0] + v7 * v0[2][1] + v9 * v0[2][2];
        float v0_1 = arg22.getRgbD()[0] * v5;
        float v4_1 = arg22.getRgbD()[1] * v10;
        v5 = arg22.getRgbD()[2] * v3;
        double v11 = 100;
        v3 = ((float)Math.pow((((double)(arg22.getFl() * Math.abs(v0_1)))) / v11, 0.42));
        v7 = ((float)Math.pow((((double)(arg22.getFl() * Math.abs(v4_1)))) / v11, 0.42));
        v9 = ((float)Math.pow((((double)(arg22.getFl() * Math.abs(v5)))) / v11, 0.42));
        v0_1 = Math.signum(v0_1) * 400f * v3 / (v3 + 27.129999f);
        v3 = Math.signum(v4_1) * 400f * v7 / (v7 + 27.129999f);
        v4_1 = Math.signum(v5) * 400f * v9 / (v9 + 27.129999f);
        double v5_1 = ((double)v4_1);
        v7 = (((float)((((double)v0_1)) * 11 + (((double)v3)) * -12 + v5_1))) / 11f;
        double v13 = 2;
        v5 = (((float)((((double)(v0_1 + v3))) - v5_1 * v13))) / 9f;
        v3 *= 20f;
        v9 = (v0_1 * 20f + v3 + 21f * v4_1) / 20f;
        v0_1 = (v0_1 * 40f + v3 + v4_1) / 20f;
        int v6 = 2;
        v10 = v9;
        v4_1 = 180f;
        float v8 = 3.141593f;
        v3 = (((float)Math.atan2(((double)v5), ((double)v7)))) * v4_1 / v8;
        float v15 = 360f;
        if(Float.compare(v3, 0f) < 0) {
            v3 += v15;
        }
        else if(v3 >= v15) {
            v3 -= v15;
        }

        v8 = v8 * v3 / v4_1;
        v4_1 = v7;
        int v17 = v6;
        float v16 = v10;
        v0_1 = (((float)Math.pow(((double)(v0_1 * arg22.getNbb() / arg22.getAw())), ((double)(arg22.getC() * arg22.getZ()))))) * 100f;
        float v18 = 4f;
        v7 = 4f / arg22.getC() * (((float)Math.sqrt(((double)(v0_1 / 100f))))) * (arg22.getAw() + v18) * arg22.getFlRoot();
        if((((double)v3)) < 20.14) {
            v15 += v3;
        }
        else {
            v15 = v3;
        }

        v4_1 = (((float)Math.pow(1.64 - Math.pow(0.29, ((double)arg22.getN())), 0.73))) * (((float)Math.pow(((double)((((float)(Math.cos((((double)v15)) * 3.141593 / 180 + v13) + 3.8))) * 0.25f * 3846.153809f * arg22.getNc() * arg22.getNcb() * (((float)Math.sqrt(((double)(v4_1 * v4_1 + v5 * v5))))) / (v16 + 0.305f))), 0.9)));
        v5 = (((float)Math.sqrt((((double)v0_1)) / v11))) * v4_1;
        float v6_1 = arg22.getFlRoot() * v5;
        v4_1 = (((float)Math.sqrt(((double)(v4_1 * arg22.getC() / (arg22.getAw() + v18)))))) * 50f;
        v9 = 1.7f * v0_1 / (0.007f * v0_1 + 1f);
        v10 = (((float)Math.log(((double)(0.0228f * v6_1 + 1f))))) * 43.85965f;
        v11 = ((double)v8);
        v8 = (((float)Math.cos(v11))) * v10;
        v10 *= ((float)Math.sin(v11));
        v1[0] = v3;
        v1[1] = v5;
        if(arg23 != null) {
            arg23[0] = v0_1;
            arg23[1] = v7;
            arg23[v17] = v6_1;
            arg23[3] = v4_1;
            arg23[4] = v9;
            arg23[5] = v8;
            arg23[6] = v10;
        }
    }

    private static CamColor fromJch(float arg1, float arg2, float arg3) {
        return CamColor.fromJchInFrame(arg1, arg2, arg3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float arg12, float arg13, float arg14, ViewingConditions arg15) {
        double v4 = (((double)arg12)) / 100;
        float v0 = 4f / arg15.getC() * (((float)Math.sqrt(v4))) * (arg15.getAw() + 4f) * arg15.getFlRoot();
        float v2 = arg15.getFlRoot() * arg13;
        float v6 = (((float)Math.sqrt(((double)(arg13 / (((float)Math.sqrt(v4))) * arg15.getC() / (arg15.getAw() + 4f)))))) * 50f;
        float v4_1 = (((float)Math.log((((double)v2)) * 0.0228 + 1))) * 43.85965f;
        double v8 = ((double)(3.141593f * arg14 / 180f));
        return new CamColor(arg14, arg13, arg12, v0, v2, v6, 1.7f * arg12 / (0.007f * arg12 + 1f), (((float)Math.cos(v8))) * v4_1, v4_1 * (((float)Math.sin(v8))));
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getHue() {
        return this.mHue;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getM() {
        return this.mM;
    }

    public static void getM3HCTfromColor(int arg2, float[] arg3) {
        CamColor.fromColorInViewingConditions(arg2, ViewingConditions.DEFAULT, null, arg3);
        arg3[2] = CamUtils.lStarFromInt(arg2);
    }

    float getQ() {
        return this.mQ;
    }

    float getS() {
        return this.mS;
    }

    public static int toColor(float arg1, float arg2, float arg3) {
        return CamColor.toColor(arg1, arg2, arg3, ViewingConditions.DEFAULT);
    }

    static int toColor(float arg6, float arg7, float arg8, ViewingConditions arg9) {
        if((((double)arg7)) >= 1 && (((double)Math.round(arg8))) > 0) {
            if((((double)Math.round(arg8))) >= 100) {
            }
            else {
                arg6 = arg6 < 0f ? 0f : Math.min(360f, arg6);
                CamColor v3 = null;
                int v2 = 1;
                float v1 = 0f;
                float v0;
                for(v0 = arg7; Math.abs(v1 - arg7) >= 0.4f; v0 = (arg7 - v1) / v5 + v1) {
                    CamColor v4 = CamColor.findCamByJ(arg6, v0, arg8);
                    float v5 = 2f;
                    if(v2 != 0) {
                        if(v4 != null) {
                            return v4.viewed(arg9);
                        }

                        v0 = (arg7 - v1) / v5 + v1;
                        v2 = 0;
                        continue;
                    }

                    if(v4 == null) {
                        arg7 = v0;
                    }
                    else {
                        v1 = v0;
                        v3 = v4;
                    }
                }

                if(v3 == null) {
                    return CamUtils.intFromLStar(arg8);
                }

                return v3.viewed(arg9);
            }
        }

        return CamUtils.intFromLStar(arg8);
    }

    int viewed(ViewingConditions arg18) {
        double v2 = 0;
        double v4 = 100;
        float v0 = Double.compare(((double)this.getChroma()), v2) == 0 || (((double)this.getJ())) == v2 ? 0f : this.getChroma() / (((float)Math.sqrt((((double)this.getJ())) / v4)));
        v0 = ((float)Math.pow((((double)v0)) / Math.pow(1.64 - Math.pow(0.29, ((double)arg18.getN())), 0.73), 1.111111));
        double v6 = ((double)(this.getHue() * 3.141593f / 180f));
        float v1 = (((float)(Math.cos(2 + v6) + 3.8))) * 0.25f;
        float v8 = arg18.getAw() * (((float)Math.pow((((double)this.getJ())) / v4, 1 / (((double)arg18.getC())) / (((double)arg18.getZ())))));
        v1 = v1 * 3846.153809f * arg18.getNc() * arg18.getNcb();
        v8 /= arg18.getNbb();
        float v4_1 = ((float)Math.sin(v6));
        float v5 = ((float)Math.cos(v6));
        float v6_1 = (0.305f + v8) * 23f * v0 / (v1 * 23f + 11f * v0 * v5 + v0 * 108f * v4_1);
        v5 *= v6_1;
        v6_1 *= v4_1;
        v8 *= 460f;
        v0 = (451f * v5 + v8 + 288f * v6_1) / 1403f;
        v4_1 = (v8 - 891f * v5 - 261f * v6_1) / 1403f;
        v8 = (v8 - v5 * 220f - v6_1 * 6300f) / 1403f;
        v0 = Math.signum(v0) * (100f / arg18.getFl()) * (((float)Math.pow(((double)(((float)Math.max(v2, (((double)Math.abs(v0))) * 27.13 / (400 - (((double)Math.abs(v0)))))))), 2.380952)));
        v4_1 = Math.signum(v4_1) * (100f / arg18.getFl()) * (((float)Math.pow(((double)(((float)Math.max(v2, (((double)Math.abs(v4_1))) * 27.13 / (400 - (((double)Math.abs(v4_1)))))))), 2.380952)));
        float v2_1 = Math.signum(v8) * (100f / arg18.getFl()) * (((float)Math.pow(((double)(((float)Math.max(v2, (((double)Math.abs(v8))) * 27.13 / (400 - (((double)Math.abs(v8)))))))), 2.380952)));
        v0 /= arg18.getRgbD()[0];
        v4_1 /= arg18.getRgbD()[1];
        v2_1 /= arg18.getRgbD()[2];
        return ColorUtils.XYZToColor(((double)(CamUtils.CAM16RGB_TO_XYZ[0][0] * v0 + CamUtils.CAM16RGB_TO_XYZ[0][1] * v4_1 + CamUtils.CAM16RGB_TO_XYZ[0][2] * v2_1)), ((double)(CamUtils.CAM16RGB_TO_XYZ[1][0] * v0 + CamUtils.CAM16RGB_TO_XYZ[1][1] * v4_1 + CamUtils.CAM16RGB_TO_XYZ[1][2] * v2_1)), ((double)(v0 * CamUtils.CAM16RGB_TO_XYZ[2][0] + v4_1 * CamUtils.CAM16RGB_TO_XYZ[2][1] + v2_1 * CamUtils.CAM16RGB_TO_XYZ[2][2])));
    }

    int viewedInSrgb() {
        return this.viewed(ViewingConditions.DEFAULT);
    }
}

