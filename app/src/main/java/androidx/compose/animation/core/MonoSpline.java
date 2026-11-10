package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0011J \u0010\u0014\u001A\u00020\u00172\u0006\u0010\u0002\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u0011J\u0018\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u0002\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u0003H\u0002J \u0010\u001B\u001A\u00020\u00172\u0006\u0010\u0002\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u0011J\u0018\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0011H\u0002R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000E\u0010\u000E\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "<init>", "([F[[FF)V", "timePoints", "values", "[[F", "tangents", "slopeTemp", "makeFloatArray", "a", "", "b", "(II)[[F", "getPos", "t", "j", "", "v", "Landroidx/compose/animation/core/AnimationVector;", "index", "getSlope", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MonoSpline {
    public static final int $stable = 8;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    static {
    }

    public MonoSpline(float[] arg20, float[][] arg21, float arg22) {
        int v16;
        float v11_1;
        MonoSpline v0 = this;
        float[] v1 = arg20;
        float[][] v2 = arg21;
        super();
        int v3 = v1.length;
        int v4 = 0;
        int v5 = v2[0].length;
        v0.slopeTemp = new float[v5];
        int v6 = v3 - 1;
        float[][] v7 = v0.makeFloatArray(v6, v5);
        float[][] v8 = v0.makeFloatArray(v3, v5);
        int v9;
        for(v9 = 0; v9 < v5; ++v9) {
            int v10;
            for(v10 = 0; v10 < v6; v10 = v11) {
                int v11 = v10 + 1;
                float v12 = v1[v11] - v1[v10];
                float[] v13 = v7[v10];
                float v14 = (v2[v11][v9] - v2[v10][v9]) / v12;
                v13[v9] = v14;
                v8[v10][v9] = v10 == 0 ? v14 : (v7[v10 - 1][v9] + v14) * 0.5f;
            }

            v8[v6][v9] = v7[v3 - 2][v9];
        }

        if(!Float.isNaN(arg22)) {
            for(v9 = 0; v9 < v5; ++v9) {
                float[] v10_1 = v7[v3 - 2];
                v11_1 = v10_1[v9] * (1f - arg22);
                float[] v12_1 = v7[0];
                v11_1 += v12_1[v9] * arg22;
                v12_1[v9] = v11_1;
                v10_1[v9] = v11_1;
                v8[v6][v9] = v11_1;
                v8[0][v9] = v11_1;
            }
        }

        v3 = 0;
        while(v3 < v6) {
            v9 = v4;
            while(v9 < v5) {
                float v10_2 = v7[v3][v9];
                if(v10_2 == 0f) {
                    v8[v3][v9] = 0f;
                    v8[v3 + 1][v9] = 0f;
                    v16 = v5;
                }
                else {
                    v11_1 = v8[v3][v9] / v10_2;
                    int v12_2 = v3 + 1;
                    float v13_1 = v8[v12_2][v9] / v10_2;
                    v16 = v5;
                    float v4_1 = ((float)Math.hypot(((double)v11_1), ((double)v13_1)));
                    if((((double)v4_1)) > 9) {
                        float v5_1 = 3f / v4_1;
                        float[] v4_2 = v8[v3];
                        float[] v14_1 = v7[v3];
                        v4_2[v9] = v11_1 * v5_1 * v14_1[v9];
                        v8[v12_2][v9] = v5_1 * v13_1 * v14_1[v9];
                    }
                }

                ++v9;
                v5 = v16;
            }

            ++v3;
            v4 = 0;
        }

        v0.timePoints = v1;
        v0.values = v2;
        v0.tangents = v8;
    }

    public final void getPos(float arg17, AnimationVector arg18, int arg19) {
        float v11;
        float v10;
        int v8;
        int v6;
        MonoSpline v0 = this;
        AnimationVector v1 = arg18;
        float[] v2 = v0.timePoints;
        int v3 = v2.length;
        int v5 = 0;
        int v4 = v0.values[0].length;
        int v7 = -1;
        if(Float.compare(arg17, v2[0]) <= 0) {
            v6 = 0;
        }
        else {
            v6 = v3 - 1;
            if(arg17 >= v2[v6]) {
            }
            else {
                v6 = v7;
            }
        }

        if(v6 != v7) {
            v0.getSlope(v2[v6], v0.slopeTemp);
            while(v5 < v4) {
                v1.set$animation_core(v5, v0.values[v6][v5] + (arg17 - v0.timePoints[v6]) * v0.slopeTemp[v5]);
                ++v5;
            }
        }
        else {
            --v3;
            int v2_1 = arg19;
            while(true) {
                if(v2_1 < v3) {
                    float[] v6_1 = v0.timePoints;
                    float v7_1 = v6_1[v2_1];
                    if(arg17 != v7_1) {
                        v8 = v2_1 + 1;
                        float v6_2 = v6_1[v8];
                        if(arg17 < v6_2) {
                            v10 = v6_2 - v7_1;
                            v11 = (arg17 - v7_1) / v10;
                            break;
                        }
                        else {
                            v2_1 = v8;
                            continue;
                        }
                    }

                    goto label_43;
                }

                return;
            }

            while(true) {
                if(v5 < v4) {
                    v1.set$animation_core(v5, MonoSplineKt.hermiteInterpolate(v10, v11, v0.values[v2_1][v5], v0.values[v8][v5], v0.tangents[v2_1][v5], v0.tangents[v8][v5]));
                    ++v5;
                    continue;
                }
                else {
                    return;
                }
            }

        label_43:
            while(v5 < v4) {
                v1.set$animation_core(v5, v0.values[v2_1][v5]);
                ++v5;
            }
        }
    }

    public final float getPos(float arg17, int arg18) {
        int v7;
        MonoSpline v0 = this;
        int v1 = arg18;
        float[][] v2 = v0.values;
        float[][] v3 = v0.tangents;
        float[] v4 = v0.timePoints;
        int v5 = v4.length;
        int v6 = 0;
        int v8 = -1;
        if(Float.compare(arg17, v4[0]) <= 0) {
            v7 = 0;
        }
        else {
            v7 = v5 - 1;
            if(arg17 >= v4[v7]) {
            }
            else {
                v7 = v8;
            }
        }

        if(v7 != v8) {
            return v2[v7][v1] + (arg17 - v4[v7]) * v0.getSlope(v4[v7], v1);
        }

        --v5;
        while(v6 < v5) {
            v4 = v0.timePoints;
            float v7_1 = v4[v6];
            if(arg17 == v7_1) {
                return v2[v6][v1];
            }

            v8 = v6 + 1;
            float v4_1 = v4[v8];
            if(arg17 < v4_1) {
                float v10 = v4_1 - v7_1;
                return MonoSplineKt.hermiteInterpolate(v10, (arg17 - v7_1) / v10, v2[v6][v1], v2[v8][v1], v3[v6][v1], v3[v8][v1]);
            }

            v6 = v8;
        }

        return 0;
    }

    public static void getPos$default(MonoSpline arg0, float arg1, AnimationVector arg2, int arg3, int arg4, Object arg5) {
        arg0.getPos(arg1, arg2, 0);
    }

    private final float getSlope(float arg13, int arg14) {
        float[] v0 = this.timePoints;
        float[][] v1 = this.values;
        float[][] v12 = this.tangents;
        int v2 = v0.length;
        int v3 = 0;
        float v4 = v0[0];
        --v2;
        float v5 = v0[v2];
        if(arg13 < v4) {
            arg13 = v4;
        }

        if(arg13 > v5) {
        }
        else {
            v5 = arg13;
        }

        while(v3 < v2) {
            int v13 = v3 + 1;
            v4 = v0[v13];
            if(v5 <= v4) {
                float v8 = v1[v3][arg14];
                float v9 = v1[v13][arg14];
                float v10 = v12[v3][arg14];
                float v11 = v12[v13][arg14];
                float v6 = v4 - v0[v3];
                return MonoSplineKt.hermiteDifferential(v6, (v5 - v0[v3]) / v6, v8, v9, v10, v11) / v6;
            }

            v3 = v13;
        }

        return 0;
    }

    private final void getSlope(float arg14, float[] arg15) {
        float v8;
        float v7;
        int v5;
        int v1 = 0;
        int v0 = this.values[0].length;
        float[] v2 = this.timePoints;
        int v3 = v2.length;
        float v4 = v2[0];
        --v3;
        float v2_1 = v2[v3];
        if(arg14 < v4) {
            arg14 = v4;
        }

        if(arg14 > v2_1) {
        }
        else {
            v2_1 = arg14;
        }

        if(arg15.length < v0) {
        }
        else {
            int v14 = 0;
            while(true) {
                if(v14 < v3) {
                    float[] v4_1 = this.timePoints;
                    v5 = v14 + 1;
                    float v6 = v4_1[v5];
                    if(v2_1 <= v6) {
                        v7 = v6 - v4_1[v14];
                        v8 = (v2_1 - v4_1[v14]) / v7;
                        break;
                    }
                    else {
                        v14 = v5;
                        continue;
                    }
                }

                return;
            }

            while(v1 < v0) {
                arg15[v1] = MonoSplineKt.hermiteDifferential(v7, v8, this.values[v14][v1], this.values[v5][v1], this.tangents[v14][v1], this.tangents[v5][v1]) / v7;
                ++v1;
            }
        }
    }

    public final void getSlope(float arg17, AnimationVector arg18, int arg19) {
        float v11;
        float v10;
        int v7;
        AnimationVector v1 = arg18;
        float[] v2 = this.timePoints;
        float[][] v3 = this.values;
        float[][] v0 = this.tangents;
        int v4 = v2.length;
        int v5 = 0;
        int v6 = v3[0].length;
        int v8 = -1;
        if(Float.compare(arg17, v2[0]) <= 0) {
            v7 = 0;
        }
        else {
            v7 = v4 - 1;
            if(arg17 >= v2[v7]) {
            }
            else {
                v7 = v8;
            }
        }

        if(v7 != v8) {
            float[] v0_1 = v0[v7];
            if(v0_1.length < v6) {
                return;
            }

            while(v5 < v6) {
                v1.set$animation_core(v5, v0_1[v5]);
                ++v5;
            }
        }
        else {
            --v4;
            for(v7 = arg19; true; v7 = v8) {
                if(v7 >= v4) {
                    return;
                }

                v8 = v7 + 1;
                float v9 = v2[v8];
                if(arg17 <= v9) {
                    v10 = v9 - v2[v7];
                    v11 = (arg17 - v2[v7]) / v10;
                    break;
                }
            }

            while(v5 < v6) {
                v1.set$animation_core(v5, MonoSplineKt.hermiteDifferential(v10, v11, v3[v7][v5], v3[v8][v5], v0[v7][v5], v0[v8][v5]) / v10);
                ++v5;
            }
        }
    }

    public static void getSlope$default(MonoSpline arg0, float arg1, AnimationVector arg2, int arg3, int arg4, Object arg5) {
        arg0.getSlope(arg1, arg2, 0);
    }

    private final float[][] makeFloatArray(int arg3, int arg4) {
        float[][] v2 = new float[arg3][];
        int v0;
        for(v0 = 0; v0 < arg3; ++v0) {
            v2[v0] = new float[arg4];
        }

        return v2;
    }
}

