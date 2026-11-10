package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public final class PathParser {
    class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
            super();
        }
    }

    public class PathDataNode {
        private final float[] mParams;
        private char mType;

        static float[] -$$Nest$fgetmParams(PathDataNode arg0) {
            return arg0.mParams;
        }

        static char -$$Nest$fgetmType(PathDataNode arg0) {
            return arg0.mType;
        }

        static void -$$Nest$fputmType(PathDataNode arg0, char arg1) {
            arg0.mType = arg1;
        }

        static void -$$Nest$smaddCommand(Path arg0, float[] arg1, char arg2, char arg3, float[] arg4) {
            PathDataNode.addCommand(arg0, arg1, arg2, arg3, arg4);
        }

        PathDataNode(char arg1, float[] arg2) {
            super();
            this.mType = arg1;
            this.mParams = arg2;
        }

        PathDataNode(PathDataNode arg3) {
            super();
            this.mType = arg3.mType;
            this.mParams = PathParser.copyOfRange(arg3.mParams, 0, arg3.mParams.length);
        }

        private static void addCommand(Path arg26, float[] arg27, char arg28, char arg29, float[] arg30) {
            int v21_1;
            boolean v9_1;
            boolean v8_2;
            boolean v22_1;
            float v0_1;
            int v8_1;
            int v3_1;
            int v2_1;
            int v5_1;
            int v24;
            int v23;
            int v22;
            boolean v21;
            Path v0 = arg26;
            int v10 = arg29;
            float[] v11 = arg30;
            int v12 = 0;
            float v1 = arg27[0];
            int v13 = 1;
            float v2 = arg27[1];
            int v14 = 2;
            float v3 = arg27[v14];
            int v15 = 3;
            float v4 = arg27[v15];
            int v16 = 4;
            float v5 = arg27[v16];
            int v17 = 5;
            float v6 = arg27[v17];
            switch(v10) {
                case 65: 
                case 97: {
                    goto label_31;
                }
                case 67: 
                case 99: {
                    goto label_29;
                }
                case 81: 
                case 83: 
                case 113: 
                case 115: {
                    goto label_25;
                }
                case 72: 
                case 86: 
                case 104: 
                case 118: {
                    goto label_27;
                }
                case 90: 
                case 122: {
                    goto label_18;
                }
            }

            goto label_16;
        label_18:
            v0.close();
            v0.moveTo(v5, v6);
            v1 = v5;
            v3 = v1;
            v2 = v6;
            v4 = v2;
        label_16:
            int v18 = v14;
            goto label_33;
        label_25:
            v18 = v16;
            goto label_33;
        label_27:
            v18 = 1;
            goto label_33;
        label_29:
            int v7 = 6;
            goto label_32;
        label_31:
            v7 = 7;
        label_32:
            v18 = v7;
        label_33:
            float v7_1 = v1;
            float v8 = v2;
            float v19 = v5;
            float v20 = v6;
            int v9 = 0;
            int v1_1 = arg28;
            while(v9 < v11.length) {
                if(v10 == 65) {
                    v1 = v7_1;
                    v2 = v8;
                    v21 = ((boolean)v12);
                    v22_1 = ((boolean)v13);
                    v23 = v14;
                    v24 = v15;
                    v14 = v9;
                    v12 = v14 + 5;
                    v3 = v11[v12];
                    v13 = v14 + 6;
                    v4 = v11[v13];
                    v5 = v11[v14];
                    v6 = v11[v14 + 1];
                    v7_1 = v11[v14 + 2];
                    if(v11[v14 + 3] != 0f) {
                        v0_1 = 0f;
                        v8_2 = v22_1;
                    }
                    else {
                        v0_1 = 0f;
                        v8_2 = v21;
                    }

                    v9_1 = v11[v14 + 4] != v0_1 ? v22_1 : v21;
                    PathDataNode.drawArc(arg26, v1, v2, v3, v4, v5, v6, v7_1, v8_2, v9_1);
                    v3 = v11[v12];
                    v7_1 = v3;
                    v4 = v11[v13];
                    v8 = v4;
                }
                else if(v10 == 67) {
                    v21_1 = v12;
                    v22 = v13;
                    v23 = v14;
                    v24 = v15;
                    v14 = v9;
                    v9 = v14 + 2;
                    v7 = v14 + 3;
                    v8_1 = v14 + 4;
                    v12 = v14 + 5;
                    v0.cubicTo(v11[v14], v11[v14 + 1], v11[v9], v11[v7], v11[v8_1], v11[v12]);
                    v0_1 = v11[v8_1];
                    v1 = v11[v12];
                    v2 = v11[v9];
                    v3 = v11[v7];
                    v7_1 = v0_1;
                    v8 = v1;
                    v4 = v3;
                    v3 = v2;
                }
                else if(v10 != 72) {
                    int v6_1 = 81;
                    if(v10 != v6_1) {
                        v21 = ((boolean)v12);
                        if(v10 != 86) {
                            if(v10 != 97) {
                                v12 = 99;
                                if(v10 != v12) {
                                    v22 = v13;
                                    if(v10 != 104) {
                                        v13 = 0x71;
                                        if(v10 != v13) {
                                            v23 = v14;
                                            if(v10 != 0x76) {
                                                if(v10 != 76) {
                                                    if(v10 != 77) {
                                                        v14 = 0x73;
                                                        v24 = v15;
                                                        float v25 = 2f;
                                                        if(v10 != 83) {
                                                            v5_1 = 0x74;
                                                            v15 = 84;
                                                            if(v10 == v15) {
                                                                if(v1_1 == v13 || v1_1 == v5_1 || v1_1 == v6_1 || v1_1 == v15) {
                                                                    v7_1 = v7_1 * v25 - v3;
                                                                    v8 = v8 * v25 - v4;
                                                                }

                                                                v2_1 = v9 + 1;
                                                                v0.quadTo(v7_1, v8, v11[v9], v11[v2_1]);
                                                                v1 = v11[v9];
                                                                v2 = v11[v2_1];
                                                                v3 = v7_1;
                                                                v4 = v8;
                                                                v14 = v9;
                                                                v7_1 = v1;
                                                                goto label_340;
                                                            }
                                                            else if(v10 == 108) {
                                                                v2_1 = v9 + 1;
                                                                v0.rLineTo(v11[v9], v11[v2_1]);
                                                                v7_1 += v11[v9];
                                                                v1 = v11[v2_1];
                                                                goto label_155;
                                                            }
                                                            else if(v10 == 109) {
                                                                v1 = v11[v9];
                                                                v7_1 += v1;
                                                                v2 = v11[v9 + 1];
                                                                v8 += v2;
                                                                if(v9 > 0) {
                                                                    v0.rLineTo(v1, v2);
                                                                    goto label_82;
                                                                }

                                                                v0.rMoveTo(v1, v2);
                                                                v19 = v7_1;
                                                            }
                                                            else if(v10 != v14) {
                                                                if(v10 == v5_1) {
                                                                    if(v1_1 == v13 || v1_1 == v5_1 || v1_1 == v6_1 || v1_1 == v15) {
                                                                        v5 = v7_1 - v3;
                                                                        v1 = v8 - v4;
                                                                    }
                                                                    else {
                                                                        v1 = 0f;
                                                                        v5 = 0f;
                                                                    }

                                                                    v3_1 = v9 + 1;
                                                                    v0.rQuadTo(v5, v1, v11[v9], v11[v3_1]);
                                                                    v5 += v7_1;
                                                                    v1 += v8;
                                                                    v7_1 += v11[v9];
                                                                    v8 += v11[v3_1];
                                                                    v4 = v1;
                                                                    v3 = v5;
                                                                }
                                                                else {
                                                                }

                                                                goto label_82;
                                                            }
                                                            else {
                                                                if(v1_1 == v12 || v1_1 == v14 || v1_1 == 67 || v1_1 == 83) {
                                                                    v2 = v8 - v4;
                                                                    v1 = v7_1 - v3;
                                                                }
                                                                else {
                                                                    v1 = 0f;
                                                                    v2 = 0f;
                                                                }

                                                                v12 = v9 + 1;
                                                                v13 = v9 + 2;
                                                                v14 = v9 + 3;
                                                                v0.rCubicTo(v1, v2, v11[v9], v11[v12], v11[v13], v11[v14]);
                                                                v1 = v11[v9] + v7_1;
                                                                v2 = v11[v12] + v8;
                                                                v7_1 += v11[v13];
                                                                v3 = v11[v14];
                                                                goto label_250;
                                                            }
                                                        }
                                                        else {
                                                            if(v1_1 == v12 || v1_1 == v14 || v1_1 == 67 || v1_1 == 83) {
                                                                v7_1 = v7_1 * v25 - v3;
                                                                v8 = v8 * v25 - v4;
                                                            }

                                                            v1 = v7_1;
                                                            v2 = v8;
                                                            v7 = v9 + 1;
                                                            v8_1 = v9 + 2;
                                                            v12 = v9 + 3;
                                                            v0.cubicTo(v1, v2, v11[v9], v11[v7], v11[v8_1], v11[v12]);
                                                            v1 = v11[v9];
                                                            v2 = v11[v7];
                                                            v7_1 = v11[v8_1];
                                                            v8 = v11[v12];
                                                            v14 = v9;
                                                            goto label_361;
                                                        }
                                                    }
                                                    else {
                                                        v24 = v15;
                                                        v1 = v11[v9];
                                                        v2 = v11[v9 + 1];
                                                        if(v9 > 0) {
                                                            v0.lineTo(v1, v2);
                                                            goto label_224;
                                                        }

                                                        v0.moveTo(v1, v2);
                                                        v7_1 = v1;
                                                        v19 = v7_1;
                                                        v8 = v2;
                                                    }

                                                    v20 = v8;
                                                    goto label_82;
                                                }
                                                else {
                                                    v24 = v15;
                                                    v2_1 = v9 + 1;
                                                    v0.lineTo(v11[v9], v11[v2_1]);
                                                    v1 = v11[v9];
                                                    v2 = v11[v2_1];
                                                }

                                            label_224:
                                                v7_1 = v1;
                                                v8 = v2;
                                                goto label_82;
                                            }
                                            else {
                                                v24 = v15;
                                                v0.rLineTo(0f, v11[v9]);
                                                v1 = v11[v9];
                                            }

                                        label_155:
                                            v8 += v1;
                                            goto label_82;
                                        }
                                        else {
                                            v23 = v14;
                                            v24 = v15;
                                            v2_1 = v9 + 1;
                                            int v4_1 = v9 + 2;
                                            v6_1 = v9 + 3;
                                            v0.rQuadTo(v11[v9], v11[v2_1], v11[v4_1], v11[v6_1]);
                                            v1 = v11[v9] + v7_1;
                                            v2 = v11[v2_1] + v8;
                                            v7_1 += v11[v4_1];
                                            v3 = v11[v6_1];
                                        }

                                    label_250:
                                        v8 += v3;
                                        v3 = v1;
                                        v4 = v2;
                                    }
                                    else {
                                        v23 = v14;
                                        v24 = v15;
                                        v0.rLineTo(v11[v9], 0f);
                                        v7_1 += v11[v9];
                                    }
                                }
                                else {
                                    v22 = v13;
                                    v23 = v14;
                                    v24 = v15;
                                    v12 = v9 + 2;
                                    v13 = v9 + 3;
                                    v14 = v9 + 4;
                                    v15 = v9 + 5;
                                    v0.rCubicTo(v11[v9], v11[v9 + 1], v11[v12], v11[v13], v11[v14], v11[v15]);
                                    v0_1 = v11[v12] + v7_1;
                                    v1 = v11[v13] + v8;
                                    v7_1 += v11[v14];
                                    v8 += v11[v15];
                                    v3 = v0_1;
                                    v4 = v1;
                                }

                            label_82:
                                v14 = v9;
                            }
                            else {
                                v22_1 = ((boolean)v13);
                                v23 = v14;
                                v24 = v15;
                                v12 = v9 + 5;
                                v3 = v11[v12] + v7_1;
                                v13 = v9 + 6;
                                v4 = v11[v13] + v8;
                                v5 = v11[v9];
                                v6 = v11[v9 + 1];
                                v0_1 = v11[v9 + 2];
                                if(v11[v9 + 3] != 0f) {
                                    v1 = 0f;
                                    v2 = v8;
                                    v8_2 = v22_1;
                                }
                                else {
                                    v1 = 0f;
                                    v2 = v8;
                                    v8_2 = v21;
                                }

                                v14 = v9;
                                v9_1 = Float.compare(v11[v9 + 4], v1) != 0 ? v22_1 : v21;
                                PathDataNode.drawArc(arg26, v7_1, v2, v3, v4, v5, v6, v0_1, v8_2, v9_1);
                                v7_1 += v11[v12];
                                v8 = v2 + v11[v13];
                                v3 = v7_1;
                                v4 = v8;
                            }

                            goto label_440;
                        }
                        else {
                            v22 = v13;
                            v23 = v14;
                            v24 = v15;
                            v14 = v9;
                            v0.lineTo(v7_1, v11[v14]);
                            v2 = v11[v14];
                        }

                    label_340:
                        v8 = v2;
                        goto label_440;
                    }
                    else {
                        v21_1 = v12;
                        v22 = v13;
                        v23 = v14;
                        v24 = v15;
                        v14 = v9;
                        v9 = v14 + 1;
                        v3_1 = v14 + 2;
                        v5_1 = v14 + 3;
                        v0.quadTo(v11[v14], v11[v9], v11[v3_1], v11[v5_1]);
                        v1 = v11[v14];
                        v2 = v11[v9];
                        v7_1 = v11[v3_1];
                        v8 = v11[v5_1];
                    }

                label_361:
                    v3 = v1;
                    v4 = v2;
                }
                else {
                    v21_1 = v12;
                    v22 = v13;
                    v23 = v14;
                    v24 = v15;
                    v14 = v9;
                    v0.lineTo(v11[v14], v8);
                    v7_1 = v11[v14];
                }

            label_440:
                v9 = v14 + v18;
                v0 = arg26;
                v1_1 = v10;
                v12 = v21_1;
                v13 = v22;
                v14 = v23;
                v15 = v24;
            }

            arg27[v12] = v7_1;
            arg27[v13] = v8;
            arg27[v14] = v3;
            arg27[v15] = v4;
            arg27[v16] = v19;
            arg27[v17] = v20;
        }

        private static void arcToBezier(Path arg46, double arg47, double arg49, double arg51, double arg53, double arg55, double arg57, double arg59, double arg61, double arg63) {
            double v0 = arg51;
            int v4 = ((int)Math.ceil(Math.abs(arg63 * 4 / 3.141593)));
            double v5 = Math.cos(arg59);
            double v7 = Math.sin(arg59);
            double v9 = Math.cos(arg61);
            double v11 = Math.sin(arg61);
            double v13 = -v0;
            double v15 = v13 * v5;
            double v19 = arg53 * v7;
            double v17 = v15 * v11 - v19 * v9;
            v13 *= v7;
            double v21 = arg53 * v5;
            v11 = v11 * v13 + v9 * v21;
            v9 = arg63 / (((double)v4));
            double v29 = 4;
            double v25 = v11;
            double v27 = v17;
            int v2 = 0;
            v11 = arg55;
            v17 = arg57;
            double v23 = arg61;
            while(v2 < v4) {
                double v31 = v23 + v9;
                double v33 = Math.sin(v31);
                double v35 = Math.cos(v31);
                v0 = arg47 + v0 * v5 * v35 - v19 * v33;
                int v53 = v2;
                double v2_1 = arg49 + arg51 * v7 * v35 + v21 * v33;
                double v37 = v15 * v33 - v19 * v35;
                v33 = v33 * v13 + v35 * v21;
                v23 = v31 - v23;
                v35 = Math.tan(v23 / 2);
                v23 = Math.sin(v23) * (Math.sqrt(v35 * 3 * v35 + v29) - 1) / 3;
                arg46.rLineTo(0f, 0f);
                arg46.cubicTo(((float)(v11 + v27 * v23)), ((float)(v17 + v25 * v23)), ((float)(v0 - v23 * v37)), ((float)(v2_1 - v23 * v33)), ((float)v0), ((float)v2_1));
                v7 = v7;
                v9 = v9;
                v11 = v0;
                v13 = v13;
                v23 = v31;
                v25 = v33;
                v5 = v5;
                v0 = arg51;
                v17 = v2_1;
                v2 = v53 + 1;
                v4 = v4;
                v27 = v37;
            }
        }

        private static void drawArc(Path arg43, float arg44, float arg45, float arg46, float arg47, float arg48, float arg49, float arg50, boolean arg51, boolean arg52) {
            float v3 = arg46;
            float v7 = arg50;
            double v19 = Math.toRadians(((double)v7));
            double v4 = Math.cos(v19);
            double v8 = Math.sin(v19);
            double v10 = ((double)arg44);
            float v6 = arg45;
            double v14 = ((double)v6);
            double v12 = v10 * v4 + v14 * v8;
            double v17 = v14;
            double v15 = v10;
            double v13 = v12;
            double v11 = ((double)arg48);
            double v21 = v13 / v11;
            v13 = ((double)arg49);
            double v23 = ((((double)(-arg44))) * v8 + v17 * v4) / v13;
            float v10_1 = arg47;
            double v0 = ((double)v10_1);
            double v25 = ((((double)v3)) * v4 + v0 * v8) / v11;
            v0 = ((((double)(-v3))) * v8 + v0 * v4) / v13;
            double v27 = v21 - v25;
            double v29 = v23 - v0;
            double v31 = (v21 + v25) / 2;
            double v35 = (v23 + v0) / 2;
            double v39 = v0;
            v0 = v27 * v27 + v29 * v29;
            double v33 = 0;
            String v2 = "PathParser";
            if(Double.compare(v0, v33) == 0) {
                Log.w(v2, " Points are coincident");
                return;
            }

            double v37 = 1 / v0 - 0.25;
            if(v37 < v33) {
                Log.w(v2, "Points are too far apart " + v0);
                float v0_1 = ((float)(Math.sqrt(v0) / 1.99999));
                PathDataNode.drawArc(arg43, arg44, v6, v3, v10_1, arg48 * v0_1, v0_1 * arg49, v7, arg51, arg52);
                return;
            }

            boolean v0_2 = arg52;
            double v1 = Math.sqrt(v37);
            v27 *= v1;
            v1 *= v29;
            if(arg51 == v0_2) {
                v31 -= v1;
                v35 += v27;
            }
            else {
                v31 += v1;
                v35 -= v27;
            }

            v21 = Math.atan2(v23 - v35, v21 - v31);
            v1 = Math.atan2(v39 - v35, v25 - v31) - v21;
            int v3_1 = Double.compare(v1, v33);
            boolean v6_1 = v3_1 >= 0 ? true : false;
            if(v0_2 != v6_1) {
                double v6_2 = 6.283185;
                if(v3_1 > 0) {
                    v1 -= v6_2;
                }
                else {
                    v1 += v6_2;
                }
            }

            v31 *= v11;
            v35 *= v13;
            PathDataNode.arcToBezier(arg43, v31 * v4 - v35 * v8, v31 * v8 + v35 * v4, v11, v13, v15, v17, v19, v21, v1);
        }

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(PathDataNode arg5, PathDataNode arg6, float arg7) {
            this.mType = arg5.mType;
            int v0;
            for(v0 = 0; true; ++v0) {
                float[] v1 = arg5.mParams;
                if(v0 >= v1.length) {
                    return;
                }

                this.mParams[v0] = v1[v0] * (1f - arg7) + arg6.mParams[v0] * arg7;
            }
        }

        @Deprecated public static void nodesToPath(PathDataNode[] arg0, Path arg1) {
            PathParser.nodesToPath(arg0, arg1);
        }
    }

    private static final String LOGTAG = "PathParser";

    private PathParser() {
        super();
    }

    private static void addNode(ArrayList arg1, char arg2, float[] arg3) {
        arg1.add(new PathDataNode(arg2, arg3));
    }

    public static boolean canMorph(PathDataNode[] arg4, PathDataNode[] arg5) {
        if(arg4 != null) {
            if(arg5 == null) {
            }
            else if(arg4.length != arg5.length) {
                return 0;
            }
            else {
                int v1 = 0;
                while(true) {
                    if(v1 < arg4.length) {
                        if(PathDataNode.-$$Nest$fgetmType(arg4[v1]) == PathDataNode.-$$Nest$fgetmType(arg5[v1])) {
                            if(PathDataNode.-$$Nest$fgetmParams(arg4[v1]).length != PathDataNode.-$$Nest$fgetmParams(arg5[v1]).length) {
                            }
                            else {
                                ++v1;
                                continue;
                            }
                        }

                        return 0;
                    }
                    else {
                        return 1;
                    }
                }

                return 0;
            }
        }

        return 0;
    }

    static float[] copyOfRange(float[] arg2, int arg3, int arg4) {
        if(arg3 <= arg4) {
            int v0 = arg2.length;
            if(arg3 >= 0 && arg3 <= v0) {
                arg4 -= arg3;
                v0 = Math.min(arg4, v0 - arg3);
                float[] v4 = new float[arg4];
                System.arraycopy(arg2, arg3, v4, 0, v0);
                return v4;
            }

            throw new ArrayIndexOutOfBoundsException();
        }

        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String arg7) {
        ArrayList v0 = new ArrayList();
        int v4 = 0;
        int v3;
        for(v3 = 1; v3 < arg7.length(); ++v3) {
            v3 = PathParser.nextStart(arg7, v3);
            String v4_1 = arg7.substring(v4, v3).trim();
            if(!v4_1.isEmpty()) {
                PathParser.addNode(v0, v4_1.charAt(0), PathParser.getFloats(v4_1));
            }

            v4 = v3;
        }

        if(v3 - v4 == 1 && v4 < arg7.length()) {
            PathParser.addNode(v0, arg7.charAt(v4), new float[0]);
        }

        return v0.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String arg4) {
        Path v0 = new Path();
        PathDataNode[] v1 = PathParser.createNodesFromPathData(arg4);
        try {
            PathDataNode.nodesToPath(v1, v0);
            return v0;
        }
        catch(RuntimeException v0_1) {
            throw new RuntimeException("Error in parsing " + arg4, ((Throwable)v0_1));
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] arg4) {
        PathDataNode[] v0 = new PathDataNode[arg4.length];
        int v1;
        for(v1 = 0; v1 < arg4.length; ++v1) {
            v0[v1] = new PathDataNode(arg4[v1]);
        }

        return v0;
    }

    private static void extract(String arg8, int arg9, ExtractFloatResult arg10) {
        arg10.mEndWithNegOrDot = false;
        int v1 = arg9;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(v1 < arg8.length()) {
            int v5 = arg8.charAt(v1);
            if(v5 != 0x20) {
                if(v5 != 69 && v5 != 101) {
                    switch(v5) {
                        case 44: {
                            goto label_32;
                        }
                        case 45: {
                            goto label_24;
                        }
                        case 46: {
                            goto label_18;
                        }
                    }

                    goto label_28;
                label_18:
                    if(v3 == 0) {
                        v2 = 0;
                        v3 = 1;
                        goto label_34;
                    }
                    else {
                        arg10.mEndWithNegOrDot = true;
                        goto label_32;
                    label_24:
                        if(v1 == arg9 || v2 != 0) {
                        label_28:
                            v2 = 0;
                            goto label_34;
                        }
                        else {
                            arg10.mEndWithNegOrDot = true;
                            goto label_32;
                        }
                    }
                }

                v2 = 1;
            }
            else {
            label_32:
                v2 = 0;
                v4 = 1;
            }

        label_34:
            if(v4 != 0) {
                break;
            }

            ++v1;
        }

        arg10.mEndPosition = v1;
    }

    private static float[] getFloats(String arg8) {
        float[] v8;
        if(arg8.charAt(0) != 0x7A) {
            if(arg8.charAt(0) == 90) {
            }
            else {
                try {
                    float[] v1 = new float[arg8.length()];
                    ExtractFloatResult v2 = new ExtractFloatResult();
                    int v3 = arg8.length();
                    int v4 = 1;
                    int v5 = 0;
                    while(v4 < v3) {
                        PathParser.extract(arg8, v4, v2);
                        int v6 = v2.mEndPosition;
                        if(v4 < v6) {
                            v1[v5] = Float.parseFloat(arg8.substring(v4, v6));
                            ++v5;
                        }

                        if(v2.mEndWithNegOrDot) {
                            v4 = v6;
                            continue;
                        }

                        v4 = v6 + 1;
                    }

                    v8 = PathParser.copyOfRange(v1, 0, v5);
                    return v8;
                }
                catch(NumberFormatException v0) {
                    throw new RuntimeException("error in parsing \"" + (((String)v8)) + "\"", ((Throwable)v0));
                }
            }
        }

        return new float[0];
    }

    public static void interpolatePathDataNodes(PathDataNode[] arg0, float arg1, PathDataNode[] arg2, PathDataNode[] arg3) {
        if(PathParser.interpolatePathDataNodes(arg0, arg2, arg3, arg1)) {
            return;
        }

        throw new IllegalArgumentException("Can\'t interpolate between two incompatible pathData");
    }

    @Deprecated public static boolean interpolatePathDataNodes(PathDataNode[] arg4, PathDataNode[] arg5, PathDataNode[] arg6, float arg7) {
        if(arg4.length == arg5.length && arg5.length == arg6.length) {
            int v1 = 0;
            if(!PathParser.canMorph(arg5, arg6)) {
                return 0;
            }

            while(v1 < arg4.length) {
                arg4[v1].interpolatePathDataNode(arg5[v1], arg6[v1], arg7);
                ++v1;
            }

            return 1;
        }

        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }

    private static int nextStart(String arg3, int arg4) {
        while(arg4 < arg3.length()) {
            int v0 = arg3.charAt(arg4);
            if(((v0 - 65) * (v0 - 90) <= 0 || (v0 - 97) * (v0 - 0x7A) <= 0) && (v0 != 101 && v0 != 69)) {
                return arg4;
            }

            ++arg4;
        }

        return arg4;
    }

    public static void nodesToPath(PathDataNode[] arg7, Path arg8) {
        float[] v0 = new float[6];
        int v1 = arg7.length;
        char v2 = 'm';
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            PathDataNode v4 = arg7[v3];
            PathDataNode.-$$Nest$smaddCommand(arg8, v0, v2, PathDataNode.-$$Nest$fgetmType(v4), PathDataNode.-$$Nest$fgetmParams(v4));
            v2 = PathDataNode.-$$Nest$fgetmType(v4);
        }
    }

    public static void updateNodes(PathDataNode[] arg5, PathDataNode[] arg6) {
        int v1;
        for(v1 = 0; v1 < arg6.length; ++v1) {
            PathDataNode.-$$Nest$fputmType(arg5[v1], PathDataNode.-$$Nest$fgetmType(arg6[v1]));
            int v2;
            for(v2 = 0; v2 < PathDataNode.-$$Nest$fgetmParams(arg6[v1]).length; ++v2) {
                PathDataNode.-$$Nest$fgetmParams(arg5[v1])[v2] = PathDataNode.-$$Nest$fgetmParams(arg6[v1])[v2];
            }
        }
    }
}

