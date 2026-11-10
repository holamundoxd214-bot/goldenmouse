package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\n\u001A\u001A\u0010\u0004\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001A\u00020\u0005\u001AX\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0015H\u0002\u001AX\u0010\u0017\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\rH\u0002\u001A\r\u0010\u001E\u001A\u00020\r*\u00020\rH\u0082\b\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u001F"}, d2={"EmptyArray", "", "getEmptyArray", "()[F", "toPath", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "target", "drawArc", "", "p", "x0", "", "y0", "x1", "y1", "a", "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "e1x", "e1y", "start", "sweep", "toRadians", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PathParserKt {
    private static final float[] EmptyArray;

    static {
        PathParserKt.EmptyArray = new float[0];
    }

    private static final void arcToBezier(Path arg46, double arg47, double arg49, double arg51, double arg53, double arg55, double arg57, double arg59, double arg61, double arg63) {
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
            v23 = Math.sin(v23) * (Math.sqrt(v29 + v35 * 3 * v35) - 1) / 3;
            arg46.cubicTo(((float)(v11 + v27 * v23)), ((float)(v17 + v25 * v23)), ((float)(v0 - v23 * v37)), ((float)(v2_1 - v23 * v33)), ((float)v0), ((float)v2_1));
            v7 = v7;
            v9 = v9;
            v11 = v0;
            v17 = v2_1;
            v2 = v53 + 1;
            v4 = v4;
            v23 = v31;
            v25 = v33;
            v5 = v5;
            v27 = v37;
            v0 = arg51;
        }
    }

    private static final void drawArc(Path arg33, double arg34, double arg36, double arg38, double arg40, double arg42, double arg44, double arg46, boolean arg48, boolean arg49) {
        double v5 = arg38;
        double v13 = arg46 / 180 * 3.141593;
        double v3 = Math.cos(v13);
        double v7 = Math.sin(v13);
        double v9 = (arg34 * v3 + arg36 * v7) / arg42;
        double v11 = (-arg34 * v7 + arg36 * v3) / arg44;
        double v15 = (v5 * v3 + arg40 * v7) / arg42;
        double v0 = (-v5 * v7 + arg40 * v3) / arg44;
        double v17 = v9 - v15;
        double v19 = v11 - v0;
        double v21 = (v9 + v15) / 2;
        double v25 = (v11 + v0) / 2;
        double v23 = v17 * v17 + v19 * v19;
        double v27 = 0;
        if(v23 == v27) {
            return;
        }

        double v29 = 1 / v23 - 0.25;
        if(v29 < v27) {
            v0 = ((double)(((float)(Math.sqrt(v23) / 1.99999))));
            PathParserKt.drawArc(arg33, arg34, arg36, v5, arg40, arg42 * v0, arg44 * v0, arg46, arg48, arg49);
            return;
        }

        boolean v2 = arg49;
        v5 = Math.sqrt(v29);
        v17 *= v5;
        v5 *= v19;
        v19 = v0;
        if(arg48 == v2) {
            v21 -= v5;
            v25 += v17;
        }
        else {
            v21 += v5;
            v25 -= v17;
        }

        v0 = Math.atan2(v11 - v25, v9 - v21);
        v5 = Math.atan2(v19 - v25, v15 - v21) - v0;
        int v9_1 = Double.compare(v5, v27);
        boolean v10 = v9_1 >= 0 ? true : false;
        if(v2 != v10) {
            double v10_1 = 6.283185;
            if(v9_1 > 0) {
                v5 -= v10_1;
            }
            else {
                v5 += v10_1;
            }
        }

        v21 *= arg42;
        v25 *= arg44;
        PathParserKt.arcToBezier(arg33, v21 * v3 - v25 * v7, v21 * v7 + v25 * v3, arg42, arg44, arg34, arg36, v13, v0, v5);
    }

    public static final float[] getEmptyArray() {
        return PathParserKt.EmptyArray;
    }

    public static final Path toPath(List arg29, Path arg30) {
        float v1_1;
        float v2_3;
        float v5;
        Object v0_1;
        int v20;
        float v24;
        int v21;
        Object v2_2;
        List v0 = arg29;
        Path v1 = arg30;
        int v2 = v1.getFillType-Rg-k1Os();
        v1.rewind();
        v1.setFillType-oQ8Xj4U(v2);
        if(v0.isEmpty()) {
            Close v2_1 = Close.INSTANCE;
        }
        else {
            v2_2 = v0.get(0);
        }

        int v8 = v0.size();
        float v9 = 0f;
        int v10 = 0;
        float v3 = 0f;
        float v4 = 0f;
        float v11 = 0f;
        float v12 = 0f;
        float v18 = 0f;
        float v19 = 0f;
        while(true) {
            if(v10 >= v8) {
                return arg30;
            }

            Object v13 = v0.get(v10);
            if((v13 instanceof Close)) {
                v1.close();
                v21 = v8;
                v24 = v9;
                v20 = v10;
                v0_1 = v13;
                v3 = v18;
                v11 = v3;
                v4 = v19;
                goto label_34;
            }
            else {
                if((v13 instanceof RelativeMoveTo)) {
                    v11 += v13.getDx();
                    v12 += v13.getDy();
                    v1.relativeMoveTo(v13.getDx(), v13.getDy());
                    v21 = v8;
                    v24 = v9;
                    v20 = v10;
                    v18 = v11;
                    v19 = v12;
                }
                else {
                    if((v13 instanceof MoveTo)) {
                        v5 = v13.getX();
                        float v6 = v13.getY();
                        v1.moveTo(v13.getX(), v13.getY());
                        v11 = v5;
                        v18 = v11;
                        v12 = v6;
                        v19 = v12;
                    }
                    else {
                        if((v13 instanceof RelativeLineTo)) {
                            v1.relativeLineTo(v13.getDx(), v13.getDy());
                            v11 += v13.getDx();
                            v2_3 = v13.getDy();
                        }
                        else {
                            if((v13 instanceof LineTo)) {
                                v1.lineTo(v13.getX(), v13.getY());
                                v5 = v13.getX();
                                v2_3 = v13.getY();
                            }
                            else if((v13 instanceof RelativeHorizontalTo)) {
                                v1.relativeLineTo(v13.getDx(), v9);
                                v11 += v13.getDx();
                                goto label_65;
                            }
                            else if((v13 instanceof HorizontalTo)) {
                                v1.lineTo(v13.getX(), v12);
                                v11 = v13.getX();
                                goto label_65;
                            }
                            else if((v13 instanceof RelativeVerticalTo)) {
                                v1.relativeLineTo(v9, v13.getDy());
                                v2_3 = v13.getDy();
                                goto label_78;
                            }
                            else if((v13 instanceof VerticalTo)) {
                                v1.lineTo(v11, v13.getY());
                                v12 = v13.getY();
                                goto label_65;
                            }
                            else {
                                if((v13 instanceof RelativeCurveTo)) {
                                    v1.relativeCubicTo(v13.getDx1(), v13.getDy1(), v13.getDx2(), v13.getDy2(), v13.getDx3(), v13.getDy3());
                                    v1_1 = v13.getDx2() + v11;
                                    v2_3 = v13.getDy2() + v12;
                                    v11 += v13.getDx3();
                                    v3 = v13.getDy3();
                                }
                                else if((v13 instanceof CurveTo)) {
                                    arg30.cubicTo(v13.getX1(), v13.getY1(), v13.getX2(), v13.getY2(), v13.getX3(), v13.getY3());
                                    v1_1 = v13.getX2();
                                    v2_3 = v13.getY2();
                                    v11 = v13.getX3();
                                    v12 = v13.getY3();
                                    v21 = v8;
                                    v24 = v9;
                                    v20 = v10;
                                    v0_1 = v13;
                                    v3 = v1_1;
                                    v4 = v2_3;
                                    goto label_378;
                                }
                                else if((v13 instanceof RelativeReflectiveCurveTo)) {
                                    if(((PathNode)v2_1).isCurve()) {
                                        v1_1 = v11 - v3;
                                        v3 = v12 - v4;
                                        v2_3 = v1_1;
                                    }
                                    else {
                                        v2_3 = v9;
                                        v3 = v2_3;
                                    }

                                    arg30.relativeCubicTo(v2_3, v3, v13.getDx1(), v13.getDy1(), v13.getDx2(), v13.getDy2());
                                    v1_1 = v13.getDx1() + v11;
                                    v2_3 = v13.getDy1() + v12;
                                    v11 += v13.getDx2();
                                    v3 = v13.getDy2();
                                }
                                else {
                                    goto label_193;
                                }

                                v12 += v3;
                                v3 = v1_1;
                                v4 = v2_3;
                                goto label_65;
                            label_193:
                                v5 = 2f;
                                if((v13 instanceof ReflectiveCurveTo)) {
                                    if(((PathNode)v2_1).isCurve()) {
                                        v11 = v11 * v5 - v3;
                                        v12 = v5 * v12 - v4;
                                    }

                                    arg30.cubicTo(v11, v12, v13.getX1(), v13.getY1(), v13.getX2(), v13.getY2());
                                    v2_3 = v13.getX1();
                                    v3 = v13.getY1();
                                    v11 = v13.getX2();
                                    v12 = v13.getY2();
                                    v21 = v8;
                                    v24 = v9;
                                    v20 = v10;
                                    v0_1 = v13;
                                    v4 = v3;
                                }
                                else {
                                    v1 = arg30;
                                    if(!(v13 instanceof RelativeQuadTo)) {
                                        goto label_241;
                                    }

                                    v1.relativeQuadraticTo(v13.getDx1(), v13.getDy1(), v13.getDx2(), v13.getDy2());
                                    v3 = v13.getDx1() + v11;
                                    v4 = v13.getDy1() + v12;
                                    v11 += v13.getDx2();
                                    v2_3 = v13.getDy2();
                                    goto label_78;
                                }

                                goto label_222;
                            }

                            goto label_88;
                        }

                    label_78:
                        v12 += v2_3;
                        goto label_65;
                    label_241:
                        if(!(v13 instanceof QuadTo)) {
                            goto label_254;
                        }

                        v1.quadraticTo(v13.getX1(), v13.getY1(), v13.getX2(), v13.getY2());
                        v3 = v13.getX1();
                        v4 = v13.getY1();
                        v5 = v13.getX2();
                        v2_3 = v13.getY2();
                    label_88:
                        v12 = v2_3;
                        v11 = v5;
                    }

                label_65:
                    v21 = v8;
                    v24 = v9;
                    v20 = v10;
                }

                v0_1 = v13;
                goto label_378;
            label_254:
                if((v13 instanceof RelativeReflectiveQuadTo)) {
                    if(((PathNode)v2_1).isQuad()) {
                        v2_3 = v11 - v3;
                        v3 = v12 - v4;
                    }
                    else {
                        v2_3 = v9;
                        v3 = v2_3;
                    }

                    v1.relativeQuadraticTo(v2_3, v3, v13.getDx(), v13.getDy());
                    v2_3 += v11;
                    v3 += v12;
                    v11 += v13.getDx();
                    v12 += v13.getDy();
                    v4 = v3;
                    v21 = v8;
                    v24 = v9;
                    v20 = v10;
                    v0_1 = v13;
                label_222:
                    v3 = v2_3;
                    goto label_378;
                }

                if((v13 instanceof ReflectiveQuadTo)) {
                    if(((PathNode)v2_1).isQuad()) {
                        v11 = v11 * v5 - v3;
                        v12 = v5 * v12 - v4;
                    }

                    v1.quadraticTo(v11, v12, v13.getX(), v13.getY());
                    float v0_2 = v11;
                    v11 = v13.getX();
                    v3 = v0_2;
                    v21 = v8;
                    v24 = v9;
                    v20 = v10;
                    v4 = v12;
                    v0_1 = v13;
                    v12 = v13.getY();
                    goto label_378;
                }

                if((v13 instanceof RelativeArcTo)) {
                    v3 = v13.getArcStartDx() + v11;
                    v4 = v13.getArcStartDy() + v12;
                    v24 = v9;
                    v0_1 = v13;
                    v21 = v8;
                    v20 = v10;
                    PathParserKt.drawArc(arg30, ((double)v11), ((double)v12), ((double)v3), ((double)v4), ((double)v13.getHorizontalEllipseRadius()), ((double)v13.getVerticalEllipseRadius()), ((double)v13.getTheta()), v13.isMoreThanHalf(), v13.isPositiveArc());
                    v3 = v3;
                    v11 = v3;
                    v4 = v4;
                    goto label_34;
                }

                v21 = v8;
                v24 = v9;
                v20 = v10;
                v0_1 = v13;
                if(!(v0_1 instanceof ArcTo)) {
                    break;
                }

                PathParserKt.drawArc(arg30, ((double)v11), ((double)v12), ((double)v0_1.getArcStartX()), ((double)v0_1.getArcStartY()), ((double)v0_1.getHorizontalEllipseRadius()), ((double)v0_1.getVerticalEllipseRadius()), ((double)v0_1.getTheta()), v0_1.isMoreThanHalf(), v0_1.isPositiveArc());
                v3 = v0_1.getArcStartX();
                v11 = v3;
                v4 = v0_1.getArcStartY();
            label_34:
                v12 = v4;
            }

        label_378:
            v10 = v20 + 1;
            v1 = arg30;
            v2_2 = v0_1;
            v8 = v21;
            v9 = v24;
            v0 = arg29;
        }

        throw new NoWhenBranchMatchedException();
        return arg30;
    }

    public static Path toPath$default(List arg0, Path arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = AndroidPath_androidKt.Path();
        }

        return PathParserKt.toPath(arg0, arg1);
    }

    private static final double toRadians(double arg2) {
        return arg2 / 180 * 3.141593;
    }
}

