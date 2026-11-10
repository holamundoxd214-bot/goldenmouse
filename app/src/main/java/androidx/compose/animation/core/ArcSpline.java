package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0005J\u0016\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0005R\u001C\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "<init>", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ArcSpline {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\fJ\u000E\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0005J\u0011\u0010%\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\u0005H\u0082\bJ\t\u0010&\u001A\u00020\u0005H\u0086\bJ\t\u0010\'\u001A\u00020\u0005H\u0086\bJ\u0006\u0010(\u001A\u00020\u0005J\u0006\u0010)\u001A\u00020\u0005J\u000E\u0010*\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\u0005J\u000E\u0010+\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\u0005J\u0010\u0010,\u001A\u00020\u00052\u0006\u0010-\u001A\u00020\u0005H\u0002J-\u0010.\u001A\u00020#2\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005H\u0000¢\u0006\u0002\b/R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u00020\u001B8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u001E\u001A\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u000ER\u0015\u0010 \u001A\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u000E¨\u00060"}, d2={"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "<init>", "(IFFFFFF)V", "getTime1", "()F", "getTime2", "arcDistance", "tmpSinAngle", "tmpCosAngle", "lut", "", "oneOverDeltaTime", "arcVelocity", "vertical", "ellipseA", "ellipseB", "isLinear", "", "ellipseCenterX", "ellipseCenterY", "linearDX", "getLinearDX$animation_core", "linearDY", "getLinearDY$animation_core", "setPoint", "", "time", "calcAngle", "calcX", "calcY", "calcDX", "calcDY", "getLinearX", "getLinearY", "lookup", "v", "buildTable", "buildTable$animation_core", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Arc {
        public static final int $stable = 8;
        private float arcDistance;
        private final float arcVelocity;
        public final float ellipseA;
        public final float ellipseB;
        public final float ellipseCenterX;
        public final float ellipseCenterY;
        public final boolean isLinear;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float vertical;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        static {
        }

        public Arc(int arg8, float arg9, float arg10, float arg11, float arg12, float arg13, float arg14) {
            float v8;
            int v4;
            super();
            this.time1 = arg9;
            this.time2 = arg10;
            this.x1 = arg11;
            this.y1 = arg12;
            this.x2 = arg13;
            this.y2 = arg14;
            float v0 = arg13 - arg11;
            float v1 = arg14 - arg12;
            boolean v2 = false;
            boolean v3 = true;
            if(arg8 != 1) {
                if(arg8 == 4) {
                    if(v1 <= 0f) {
                        goto label_17;
                    }

                    goto label_22;
                }
                else if(arg8 == 5 && v1 < 0f) {
                    goto label_22;
                }

            label_17:
                v4 = 0;
            }
            else {
            label_22:
                v4 = 1;
            }

            float v5 = 1f;
            float v6 = v4 != 0 ? -1f : v5;
            this.vertical = v6;
            v5 /= arg10 - arg9;
            this.oneOverDeltaTime = v5;
            this.lut = new float[101];
            if(arg8 == 3) {
                v2 = true;
            }

            if(!v2) {
                arg9 = 0.001f;
                if(Math.abs(v0) < arg9) {
                    goto label_66;
                }
                else if(Math.abs(v1) < arg9) {
                    goto label_66;
                }
                else {
                    this.ellipseA = v0 * v6;
                    this.ellipseB = v1 * -v6;
                    v8 = v4 != 0 ? arg13 : arg11;
                    this.ellipseCenterX = v8;
                    v8 = v4 != 0 ? arg12 : arg14;
                    this.ellipseCenterY = v8;
                    this.buildTable$animation_core(arg11, arg12, arg13, arg14);
                    this.arcVelocity = this.arcDistance * v5;
                    v3 = v2;
                }
            }
            else {
            label_66:
                v8 = ((float)Math.hypot(((double)v1), ((double)v0)));
                this.arcDistance = v8;
                this.arcVelocity = v8 * v5;
                this.ellipseCenterX = v0 * v5;
                this.ellipseCenterY = v1 * v5;
                this.ellipseA = NaNf;
                this.ellipseB = NaNf;
            }

            this.isLinear = v3;
        }

        public static final float access$getTmpCosAngle$p(Arc arg0) {
            return arg0.tmpCosAngle;
        }

        public static final float access$getTmpSinAngle$p(Arc arg0) {
            return arg0.tmpSinAngle;
        }

        public final void buildTable$animation_core(float arg17, float arg18, float arg19, float arg20) {
            int v0_1;
            float v13;
            float v6;
            int v5;
            Arc v0 = this;
            float v1 = arg19 - arg17;
            float v2 = arg18 - arg20;
            float[] v3 = ArcSplineKt.access$getOurPercentCache$p();
            int v4 = v3.length - 1;
            float v10 = ((float)v4);
            float[] v11 = v0.lut;
            if(1 <= v4) {
                float v8 = v2;
                v5 = 1;
                v6 = 0f;
                float v7 = 0f;
                while(true) {
                    arg17 = 0f;
                    double v12 = ((double)(((float)Math.toRadians((((double)v5)) * 90 / (((double)v4))))));
                    float v14 = (((float)Math.sin(v12))) * v1;
                    float v12_1 = (((float)Math.cos(v12))) * v2;
                    v13 = v10;
                    v6 += ((float)Math.hypot(((double)(v14 - v7)), ((double)(v12_1 - v8))));
                    v3[v5] = v6;
                    if(v5 != v4) {
                        ++v5;
                        v8 = v12_1;
                        v10 = v13;
                        v7 = v14;
                        continue;
                    }

                    break;
                }
            }
            else {
                v13 = v10;
                arg17 = 0f;
                v6 = 0f;
            }

            v0.arcDistance = v6;
            if(1 <= v4) {
                v0_1 = 1;
                while(true) {
                    v3[v0_1] /= v6;
                    if(v0_1 != v4) {
                        ++v0_1;
                        continue;
                    }

                    break;
                }
            }

            v0_1 = v11.length;
            int v1_1;
            for(v1_1 = 0; v1_1 < v0_1; ++v1_1) {
                float v4_1 = (((float)v1_1)) / 100f;
                int v2_1 = ArraysKt.binarySearch$default(v3, v4_1, 0, 0, 6, null);
                if(v2_1 >= 0) {
                    v11[v1_1] = (((float)v2_1)) / v13;
                }
                else if(v2_1 == -1) {
                    v11[v1_1] = arg17;
                }
                else {
                    v2_1 = -v2_1;
                    v5 = v2_1 - 2;
                    v11[v1_1] = ((((float)v5)) + (v4_1 - v3[v5]) / (v3[v2_1 - 1] - v3[v5])) / v13;
                }
            }
        }

        private final float calcAngle(float arg3) {
            float v0 = this.vertical == -1f ? this.time2 - arg3 : arg3 - this.time1;
            return this.lookup(v0 * this.oneOverDeltaTime) * 1.570796f;
        }

        public final float calcDX() {
            float v0 = this.ellipseA * this.tmpCosAngle;
            return v0 * this.vertical * (this.arcVelocity / (((float)Math.hypot(((double)v0), ((double)(-this.ellipseB * this.tmpSinAngle))))));
        }

        public final float calcDY() {
            float v0 = this.ellipseA * this.tmpCosAngle;
            float v1 = -this.ellipseB * this.tmpSinAngle;
            return v1 * this.vertical * (this.arcVelocity / (((float)Math.hypot(((double)v0), ((double)v1)))));
        }

        public final float calcX() {
            return this.ellipseCenterX + this.ellipseA * this.tmpSinAngle;
        }

        public final float calcY() {
            return this.ellipseCenterY + this.ellipseB * this.tmpCosAngle;
        }

        public final float getLinearDX$animation_core() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY$animation_core() {
            return this.ellipseCenterY;
        }

        public final float getLinearX(float arg2) {
            return this.x1 + (arg2 - this.time1) * this.oneOverDeltaTime * (this.x2 - this.x1);
        }

        public final float getLinearY(float arg2) {
            return this.y1 + (arg2 - this.time1) * this.oneOverDeltaTime * (this.y2 - this.y1);
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        private final float lookup(float arg3) {
        }

        public final void setPoint(float arg5) {
            float v0 = this.vertical == -1f ? this.time2 - arg5 : arg5 - this.time1;
            double v0_1 = ((double)(this.lookup(v0 * this.oneOverDeltaTime) * 1.570796f));
            this.tmpSinAngle = ((float)Math.sin(v0_1));
            this.tmpCosAngle = ((float)Math.cos(v0_1));
        }
    }

    public static final int $stable = 8;
    private final Arc[][] arcs;
    private final boolean isExtrapolate;

    static {
    }

    public ArcSpline(int[] arg22, float[] arg23, float[][] arg24) {
        int v13;
        ArcSpline v0 = this;
        float[] v1 = arg23;
        super();
        int v2 = 1;
        v0.isExtrapolate = true;
        int v3 = v1.length - 1;
        Arc[][] v4 = new Arc[v3][];
        int v7 = 1;
        int v8 = 1;
        int v6 = 0;
        while(v6 < v3) {
            int v9 = arg22[v6];
            int v10 = 3;
            int v11 = 2;
            if(v9 != 0) {
                if(v9 != v2) {
                    if(v9 != v11) {
                        if(v9 != v10) {
                            v10 = 4;
                            if(v9 != v10) {
                                v10 = 5;
                                if(v9 != v10) {
                                    v13 = v8;
                                    goto label_33;
                                }
                                else {
                                    goto label_32;
                                }
                            }
                            else {
                                goto label_32;
                            }
                        }
                        else {
                            if(v7 == v2) {
                                goto label_27;
                            }

                            goto label_29;
                        }
                    }

                label_27:
                    v7 = v11;
                }
                else {
                label_29:
                    v7 = v2;
                }

                v13 = v7;
            }
            else {
            label_32:
                v13 = v10;
            }

        label_33:
            float[] v8_1 = arg24[v6];
            v9 = v6 + 1;
            float[] v10_1 = arg24[v9];
            float v14 = v1[v6];
            float v15 = v1[v9];
            v2 = v8_1.length % v11 + v8_1.length / v11;
            Arc[] v11_1 = new Arc[v2];
            int v12;
            for(v12 = 0; v12 < v2; ++v12) {
                int v18 = v12 * 2;
                int v19 = v18 + 1;
                v11_1[v12] = new Arc(v13, v14, v15, v8_1[v18], v8_1[v19], v10_1[v18], v10_1[v19]);
            }

            v4[v6] = v11_1;
            v6 = v9;
            v8 = v13;
            v2 = 1;
        }

        v0.arcs = v4;
    }

    public final void getPos(float arg12, float[] arg13) {
        Arc[][] v0 = this.arcs;
        Arc[][] v1 = v0;
        int v2 = v1.length - 1;
        int v4 = 0;
        float v5 = v0[0][0].getTime1();
        float v6 = v0[v2][0].getTime2();
        int v7 = arg13.length;
        if(this.isExtrapolate) {
            if(arg12 >= v5 && arg12 <= v6) {
                goto label_66;
            }

            if(arg12 > v6) {
                v5 = v6;
            }
            else {
                v2 = 0;
            }

            arg12 -= v5;
            int v11;
            for(v11 = 0; v4 < v7 - 1; ++v11) {
                Arc v1_1 = v0[v2][v11];
                if(v1_1.isLinear) {
                    arg13[v4] = v1_1.getLinearX(v5) + v1_1.ellipseCenterX * arg12;
                    arg13[v4 + 1] = v1_1.getLinearY(v5) + v1_1.ellipseCenterY * arg12;
                }
                else {
                    v1_1.setPoint(v5);
                    arg13[v4] = v1_1.ellipseCenterX + v1_1.ellipseA * Arc.access$getTmpSinAngle$p(v1_1) + v1_1.calcDX() * arg12;
                    arg13[v4 + 1] = v1_1.ellipseCenterY + v1_1.ellipseB * Arc.access$getTmpCosAngle$p(v1_1) + v1_1.calcDY() * arg12;
                }

                v4 += 2;
            }
        }
        else {
            arg12 = Math.min(Math.max(arg12, v5), v6);
        label_66:
            v11 = v1.length;
            int v1_2 = 0;
            v2 = 0;
            while(v1_2 < v11) {
                int v5_1 = 0;
                int v6_1;
                for(v6_1 = 0; v5_1 < v7 - 1; ++v6_1) {
                    Arc v8 = v0[v1_2][v6_1];
                    if(arg12 <= v8.getTime2()) {
                        if(v8.isLinear) {
                            arg13[v5_1] = v8.getLinearX(arg12);
                            arg13[v5_1 + 1] = v8.getLinearY(arg12);
                        }
                        else {
                            v8.setPoint(arg12);
                            arg13[v5_1] = v8.ellipseCenterX + v8.ellipseA * Arc.access$getTmpSinAngle$p(v8);
                            arg13[v5_1 + 1] = v8.ellipseCenterY + v8.ellipseB * Arc.access$getTmpCosAngle$p(v8);
                        }

                        v2 = 1;
                    }

                    v5_1 += 2;
                }

                if(v2 != 0) {
                    return;
                }

                ++v1_2;
            }
        }
    }

    public final void getSlope(float arg11, float[] arg12) {
        Arc[][] v10 = this.arcs;
        float v1 = v10[0][0].getTime1();
        Arc[][] v2 = v10;
        float v3 = v10[v2.length - 1][0].getTime2();
        if(arg11 < v1) {
            arg11 = v1;
        }

        if(arg11 > v3) {
        }
        else {
            v3 = arg11;
        }

        int v11 = arg12.length;
        int v1_1 = v2.length;
        int v2_1 = 0;
        int v5 = 0;
        while(v2_1 < v1_1) {
            int v6 = 0;
            int v7;
            for(v7 = 0; v6 < v11 - 1; ++v7) {
                Arc v8 = v10[v2_1][v7];
                if(v3 <= v8.getTime2()) {
                    if(v8.isLinear) {
                        arg12[v6] = v8.ellipseCenterX;
                        arg12[v6 + 1] = v8.ellipseCenterY;
                    }
                    else {
                        v8.setPoint(v3);
                        arg12[v6] = v8.calcDX();
                        arg12[v6 + 1] = v8.calcDY();
                    }

                    v5 = 1;
                }

                v6 += 2;
            }

            if(v5 != 0) {
                return;
            }

            ++v2_1;
        }
    }
}

