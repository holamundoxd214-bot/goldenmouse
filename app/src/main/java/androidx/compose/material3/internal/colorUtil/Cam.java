package androidx.compose.material3.internal.colorUtil;

import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FBG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u000E\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u0000J\u0006\u0010\u001A\u001A\u00020\u001BJ\u000E\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u001A\u0010\b\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u000E\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000ER\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000E¨\u0006 "}, d2={"Landroidx/compose/material3/internal/colorUtil/Cam;", "", "hue", "", "chroma", "j", "m", "s", "jstar", "astar", "bstar", "<init>", "(FFFFFFFF)V", "getHue", "()F", "getChroma", "getJ", "getM", "getS", "getJstar", "setJstar", "(F)V", "getAstar", "getBstar", "distance", "other", "viewedInSrgb", "", "viewed", "frame", "Landroidx/compose/material3/internal/colorUtil/Frame;", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Cam {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u0005J\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\nJ\u0018\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J \u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0005H\u0002J(\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J(\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J\"\u0010\u0019\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u0005H\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/material3/internal/colorUtil/Cam$Companion;", "", "<init>", "()V", "DL_MAX", "", "DE_MAX", "CHROMA_SEARCH_ENDPOINT", "LIGHTNESS_SEARCH_ENDPOINT", "getInt", "", "hue", "chroma", "lstar", "fromInt", "Landroidx/compose/material3/internal/colorUtil/Cam;", "argb", "fromIntInFrame", "frame", "Landroidx/compose/material3/internal/colorUtil/Frame;", "fromJch", "j", "c", "h", "fromJchInFrame", "findCamByJ", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private final Cam findCamByJ(float arg13, float arg14, float arg15) {
            float v1 = 100f;
            float v2 = 1000f;
            float v5 = 0f;
            Cam v4 = null;
            float v3 = v2;
            while(Math.abs(((double)(v5 - v1))) > 0.01) {
                float v6 = (v1 - v5) / 2f + v5;
                int v7 = this.fromJch(v6, arg14, arg13).viewedInSrgb();
                float v8 = CamUtils.INSTANCE.lstarFromInt(v7);
                float v9 = ((float)Math.abs(((double)(arg15 - v8))));
                if(v9 < 0.2f) {
                    Cam v7_1 = this.fromInt(v7);
                    float v10 = v7_1.distance(this.fromJch(v7_1.getJ(), v7_1.getChroma(), arg13));
                    if(v10 <= 1f) {
                        v4 = v7_1;
                        v2 = v9;
                        v3 = v10;
                    }
                }

                if(v2 == 0f && v3 == 0f) {
                    return v4;
                }

                if(v8 < arg15) {
                    v5 = v6;
                    continue;
                }

                v1 = v6;
            }

            return v4;
        }

        public final Cam fromInt(int arg2) {
            return this.fromIntInFrame(arg2, Frame.Companion.getDefault());
        }

        private final Cam fromIntInFrame(int arg21, Frame arg22) {
            float[] v0 = CamUtils.INSTANCE.xyzFromInt(arg21);
            float[][] v1 = CamUtils.INSTANCE.getXYZ_TO_CAM16RGB();
            float v3 = v0[0];
            float[] v4 = v1[0];
            float v5 = v4[0] * v3;
            float v7 = v0[1];
            v5 += v4[1] * v7;
            float v0_1 = v0[2];
            v5 += v4[2] * v0_1;
            float v9 = v1[1][0] * v3 + v1[1][1] * v7 + v1[1][2] * v0_1;
            v3 = v3 * v1[2][0] + v7 * v1[2][1] + v0_1 * v1[2][2];
            v0_1 = arg22.getRgbD()[0] * v5;
            float v1_1 = arg22.getRgbD()[1] * v9;
            float v2 = arg22.getRgbD()[2] * v3;
            float v4_1 = 100f;
            v3 = ((float)Math.pow(((double)(arg22.getFl() * Math.abs(v0_1) / v4_1)), 0.42));
            v5 = ((float)Math.pow(((double)(arg22.getFl() * Math.abs(v1_1) / v4_1)), 0.42));
            float v6 = ((float)Math.pow(((double)(arg22.getFl() * Math.abs(v2) / v4_1)), 0.42));
            v0_1 = Math.signum(v0_1) * 400f * v3 / (v3 + 27.129999f);
            v1_1 = Math.signum(v1_1) * 400f * v5 / (v5 + 27.129999f);
            v2 = Math.signum(v2) * 400f * v6 / (v6 + 27.129999f);
            v5 = (v0_1 * 11f + -12f * v1_1 + v2) / 11f;
            v6 = 2f;
            v3 = (v0_1 + v1_1 - v2 * v6) / 9f;
            v1_1 *= 20f;
            float v8 = (v0_1 * 20f + v1_1 + 21f * v2) / 20f;
            v0_1 = (v0_1 * 40f + v1_1 + v2) / 20f;
            v2 = 180f;
            v7 = 3.141593f;
            v1_1 = (((float)Math.atan2(((double)v3), ((double)v5)))) * v2 / v7;
            float v10 = 360f;
            if(Float.compare(v1_1, 0f) < 0) {
                v1_1 += v10;
            }
            else if(v1_1 >= v10) {
                v1_1 -= v10;
            }

            float v12 = v1_1;
            v1_1 = v12 * v7 / v2;
            float v21 = v2;
            float v20 = v3;
            float v14 = (((float)Math.pow(((double)(v0_1 * arg22.getNbb() / arg22.getAw())), ((double)(arg22.getC() * arg22.getZ()))))) * v4_1;
            if((((double)v12)) < 20.14) {
                v10 += v12;
            }
            else {
                v10 = v12;
            }

            v0_1 = (((float)Math.pow(((double)(((((float)Math.cos(((double)(v10 * v7 / v21 + v6))))) + 3.8f) * 0.25f * 3846.153809f * arg22.getNc() * arg22.getNcb() * (((float)Math.sqrt(((double)(v5 * v5 + v20 * v20))))) / (v8 + 0.305f))), 0.9))) * (((float)Math.pow(((double)(1.64f - (((float)Math.pow(0.29, ((double)arg22.getN())))))), 0.73)));
            float v13 = v0_1 * (((float)Math.sqrt(((double)(v14 / v4_1)))));
            float v15 = v13 * arg22.getFlRoot();
            float v16 = (((float)Math.sqrt(((double)(v0_1 * arg22.getC() / (arg22.getAw() + 4f)))))) * 50f;
            v0_1 = (((float)Math.log(((double)(0.0228f * v15 + 1f))))) * 43.85965f;
            double v1_2 = ((double)v1_1);
            return new Cam(v12, v13, v14, v15, v16, 1.7f * v14 / (0.007f * v14 + 1f), v0_1 * (((float)Math.cos(v1_2))), v0_1 * (((float)Math.sin(v1_2))));
        }

        private final Cam fromJch(float arg2, float arg3, float arg4) {
            return this.fromJchInFrame(arg2, arg3, arg4, Frame.Companion.getDefault());
        }

        private final Cam fromJchInFrame(float arg10, float arg11, float arg12, Frame arg13) {
            float v4 = arg11 * arg13.getFlRoot();
            float v5 = (((float)Math.sqrt(((double)(arg11 / (((float)Math.sqrt((((double)arg10)) / 100))) * arg13.getC() / (arg13.getAw() + 4f)))))) * 50f;
            float v13 = (((float)Math.log((((double)v4)) * 0.0228 + 1))) * 43.85965f;
            double v0 = ((double)(3.141593f * arg12 / 180f));
            return new Cam(arg12, arg11, arg10, v4, v5, 1.7f * arg10 / (0.007f * arg10 + 1f), v13 * (((float)Math.cos(v0))), v13 * (((float)Math.sin(v0))));
        }

        public final int getInt(float arg2, float arg3, float arg4) {
            return this.getInt(arg2, arg3, arg4, Frame.Companion.getDefault());
        }

        private final int getInt(float arg9, float arg10, float arg11, Frame arg12) {
            if(Intrinsics.areEqual(arg12, Frame.Companion.getDefault())) {
                return HctSolver.INSTANCE.solveToInt(((double)arg9), ((double)arg10), ((double)arg11));
            }

            if((((double)arg10)) >= 1 && (((double)Math.round(arg11))) > 0) {
                if((((double)Math.round(arg11))) >= 100) {
                }
                else {
                    arg9 = arg9 < 0f ? 0f : Math.min(360f, arg9);
                    Cam v3 = null;
                    int v2 = 1;
                    float v1 = 0f;
                    float v0;
                    for(v0 = arg10; Math.abs(((double)(v1 - arg10))) >= 0.4; v0 = (arg10 - v1) / v5 + v1) {
                        Cam v4 = this.findCamByJ(arg9, v0, arg11);
                        float v5 = 2f;
                        if(v2 != 0) {
                            if(v4 != null) {
                                return v4.viewed(arg12);
                            }

                            v0 = (arg10 - v1) / v5 + v1;
                            v2 = 0;
                            continue;
                        }

                        if(v4 == null) {
                            arg10 = v0;
                        }
                        else {
                            v1 = v0;
                            v3 = v4;
                        }
                    }

                    if(v3 == null) {
                        return CamUtils.INSTANCE.intFromLstar(arg11);
                    }

                    return v3.viewed(arg12);
                }
            }

            return CamUtils.INSTANCE.intFromLstar(arg11);
        }
    }

    public static final int $stable = 0;
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    public static final Companion Companion = null;
    private static final float DE_MAX = 1f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;
    private final float j;
    private float jstar;
    private final float m;
    private final float s;

    static {
        Cam.Companion = new Companion(null);
        Cam.$stable = 8;
    }

    public Cam(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8) {
        super();
        this.hue = arg1;
        this.chroma = arg2;
        this.j = arg3;
        this.m = arg4;
        this.s = arg5;
        this.jstar = arg6;
        this.astar = arg7;
        this.bstar = arg8;
    }

    public final float distance(Cam arg4) {
        float v0 = this.jstar - arg4.jstar;
        float v1 = this.astar - arg4.astar;
        float v3 = this.bstar - arg4.bstar;
        return ((float)(Math.pow(Math.sqrt(((double)(v0 * v0 + v1 * v1 + v3 * v3))), 0.63) * 1.41));
    }

    public final float getAstar() {
        return this.astar;
    }

    public final float getBstar() {
        return this.bstar;
    }

    public final float getChroma() {
        return this.chroma;
    }

    public final float getHue() {
        return this.hue;
    }

    public final float getJ() {
        return this.j;
    }

    public final float getJstar() {
        return this.jstar;
    }

    public final float getM() {
        return this.m;
    }

    public final float getS() {
        return this.s;
    }

    public final void setJstar(float arg1) {
        this.jstar = arg1;
    }

    public final int viewed(Frame arg13) {
        float v2;
        float v0 = this.chroma;
        float v3 = 100f;
        if(Float.compare(v0, 0f) == 0) {
            goto label_8;
        }
        else {
            v2 = this.j;
            if(v2 == 0f) {
            label_8:
                v0 = 0f;
            }
            else {
                v0 /= ((float)Math.sqrt(((double)(v2 / v3))));
            }
        }

        v0 /= ((float)Math.pow(((double)(1.64f - (((float)Math.pow(((double)(((float)Math.pow(0.29, ((double)arg13.getN()))))), 0.73))))), 1.111111));
        v2 = this.hue * 3.141593f / 180f;
        float v4 = ((((float)Math.cos(((double)(2f + v2))))) + 3.8f) * 0.25f;
        float v5 = arg13.getAw() * (((float)Math.pow(((double)(this.j / v3)), ((double)(1f / arg13.getC() / arg13.getZ())))));
        v4 = v4 * 3846.153809f * arg13.getNc() * arg13.getNcb();
        v5 /= arg13.getNbb();
        double v6 = ((double)v2);
        float v12 = ((float)Math.sin(v6));
        v2 = ((float)Math.cos(v6));
        float v6_1 = (0.305f + v5) * 23f * v0 / (v4 * 23f + 11f * v0 * v2 + v0 * 108f * v12);
        v2 *= v6_1;
        v6_1 *= v12;
        v5 *= 460f;
        v12 = (451f * v2 + v5 + 288f * v6_1) / 1403f;
        v4 = (v5 - 891f * v2 - 261f * v6_1) / 1403f;
        v5 = (v5 - v2 * 220f - v6_1 * 6300f) / 1403f;
        v12 = Math.signum(v12) * (v3 / arg13.getFl()) * (((float)Math.pow(((double)Math.max(0f, Math.abs(v12) * 27.129999f / (400f - Math.abs(v12)))), 2.380952)));
        v4 = Math.signum(v4) * (v3 / arg13.getFl()) * (((float)Math.pow(((double)Math.max(0f, Math.abs(v4) * 27.129999f / (400f - Math.abs(v4)))), 2.380952)));
        float v1 = Math.signum(v5) * (v3 / arg13.getFl()) * (((float)Math.pow(((double)Math.max(0f, Math.abs(v5) * 27.129999f / (400f - Math.abs(v5)))), 2.380952)));
        v12 /= arg13.getRgbD()[0];
        v4 /= arg13.getRgbD()[1];
        v1 /= arg13.getRgbD()[2];
        float[][] v13 = CamUtils.INSTANCE.getCAM16RGB_TO_XYZ();
        return ColorUtils.XYZToColor(((double)(v13[0][0] * v12 + v13[0][1] * v4 + v13[0][2] * v1)), ((double)(v13[1][0] * v12 + v13[1][1] * v4 + v13[1][2] * v1)), ((double)(v12 * v13[2][0] + v4 * v13[2][1] + v1 * v13[2][2])));
    }

    public final int viewedInSrgb() {
        return this.viewed(Frame.Companion.getDefault());
    }
}

