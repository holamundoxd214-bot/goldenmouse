package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001A\u0085\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u000E\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000F2\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u00042\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2={"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(RowColumnMeasurePolicy arg29, int arg30, int arg31, int arg32, int arg33, int arg34, MeasureScope arg35, List arg36, Placeable[] arg37, int arg38, int arg39, int[] arg40, int arg41) {
        int v19_2;
        Integer v13_1;
        int v7_1;
        int v22;
        int v1_1;
        RowColumnMeasurePolicy v0_1;
        int v14;
        Integer v7;
        long v26;
        int v25;
        int[] v23_1;
        int v5;
        int v8 = arg32;
        int v9 = arg33;
        int v10 = arg34;
        List v11 = arg36;
        int v12 = arg39;
        long v13 = ((long)v10);
        int v15 = v12 - arg38;
        int[] v0 = new int[v15];
        int v2 = arg38;
        float v19 = 0f;
        int v3 = 0;
        int v4 = 0;
        int v6 = 0;
        int v17 = 0;
        int v18 = 0;
        while(true) {
            v5 = 0x7FFFFFFF;
            int v20 = 1;
            if(v2 >= v12) {
                break;
            }

            Object v1 = v11.get(v2);
            RowColumnParentData v21 = RowColumnImplKt.getRowColumnParentData(v1);
            float v23 = RowColumnImplKt.getWeight(v21);
            if(v6 == 0) {
                if(RowColumnImplKt.isRelative(v21)) {
                }
                else {
                    v20 = 0;
                }
            }

            if(v23 > 0f) {
                v19 += v23;
                ++v17;
                v23_1 = v0;
                v25 = v2;
                v26 = v13;
            }
            else {
                if(v9 == v5 || v21 == null) {
                label_38:
                    v7 = null;
                }
                else {
                    FlowLayoutData v3_1 = v21.getFlowLayoutData();
                    if(v3_1 != null) {
                        v7 = Integer.valueOf(Math.round(v3_1.getFillCrossAxisFraction() * (((float)v9))));
                    }
                    else {
                        goto label_38;
                    }
                }

                int v21_1 = v8 - v18;
                Placeable v3_2 = arg37[v2];
                if(v3_2 == null) {
                    v3 = v7 != null ? v7.intValue() : 0;
                    if(v8 == v5) {
                    }
                    else if(v21_1 < 0) {
                        v5 = 0;
                    }
                    else {
                        v5 = v21_1;
                    }

                    v6 = v7 != null ? v7.intValue() : v9;
                    v25 = v2;
                    v26 = v13;
                    v14 = v4;
                    v23_1 = v0;
                    v0_1 = arg29;
                    v3_2 = v1.measure-BRTryo0(RowColumnMeasurePolicy.createConstraints-xF2OJ5Q$default(v0_1, 0, v3, v5, v6, false, 16, null));
                }
                else {
                    v23_1 = v0;
                    v25 = v2;
                    v26 = v13;
                    v0_1 = arg29;
                    v14 = v4;
                }

                v1_1 = v0_1.mainAxisSize(v3_2);
                v2 = v0_1.crossAxisSize(v3_2);
                v23_1[v25 - arg38] = v1_1;
                v4 = v21_1 - v1_1;
                if(v4 < 0) {
                    v4 = 0;
                }

                v4 = Math.min(v10, v4);
                v18 += v1_1 + v4;
                v1_1 = Math.max(v14, v2);
                arg37[v25] = v3_2;
                v3 = v4;
                v4 = v1_1;
            }

            v2 = v25 + 1;
            v6 = v20;
            v0 = v23_1;
            v13 = v26;
        }

        v23_1 = v0;
        v26 = v13;
        v0_1 = arg29;
        v14 = v4;
        if(v17 == 0) {
            v18 -= v3;
            v1_1 = 0;
            v22 = 0;
        }
        else {
            v1_1 = v8 != v5 ? v8 : arg30;
            long v24 = v26 * (((long)(v17 - 1)));
            long v1_2 = (((long)(v1_1 - v18))) - v24;
            long v3_3 = 0;
            if(v1_2 < v3_3) {
                v1_2 = v3_3;
            }

            float v10_1 = (((float)v1_2)) / v19;
            for(v3 = arg38; v3 < v12; ++v3) {
                v1_2 -= ((long)Math.round(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(v11.get(v3))) * v10_1));
            }

            v8 = arg38;
            v7_1 = 0;
            while(v8 < v12) {
                if(arg37[v8] == null) {
                    Object v3_4 = v11.get(v8);
                    RowColumnParentData v4_1 = RowColumnImplKt.getRowColumnParentData(v3_4);
                    float v17_1 = RowColumnImplKt.getWeight(v4_1);
                    if(v9 == v5 || v4_1 == null) {
                    label_155:
                        v13_1 = null;
                    }
                    else {
                        FlowLayoutData v19_1 = v4_1.getFlowLayoutData();
                        if(v19_1 != null) {
                            v13_1 = Integer.valueOf(Math.round(v19_1.getFillCrossAxisFraction() * (((float)v9))));
                        }
                        else {
                            goto label_155;
                        }
                    }

                    v19_2 = v17_1 > 0f ? 1 : 0;
                    if(v19_2 == 0) {
                        InlineClassHelperKt.throwIllegalStateException("All weights <= 0 should have placeables");
                    }

                    v5 = MathKt.getSign(v1_2);
                    v26 = v1_2 - (((long)v5));
                    v1_1 = 0;
                    int v0_2 = Math.max(0, Math.round(v17_1 * v10_1) + v5);
                    if(RowColumnImplKt.getFill(v4_1)) {
                        v2 = 0x7FFFFFFF;
                        if(v0_2 != v2) {
                            v22 = 0;
                            v1_1 = v0_2;
                        }
                        else {
                            goto label_189;
                        }
                    }
                    else {
                        v2 = 0x7FFFFFFF;
                    label_189:
                        v22 = 0;
                    }

                    if(v13_1 != null) {
                        v19_2 = v2;
                        v2 = v13_1.intValue();
                    }
                    else {
                        v19_2 = v2;
                        v2 = v22;
                    }

                    v4 = v13_1 != null ? v13_1.intValue() : v9;
                    Object v13_2 = v3_4;
                    v3 = v0_2;
                    v0_1 = arg29;
                    Placeable v1_3 = ((Measurable)v13_2).measure-BRTryo0(v0_1.createConstraints-xF2OJ5Q(v1_1, v2, v3, v4, true));
                    v2 = v0_1.mainAxisSize(v1_3);
                    v3 = v0_1.crossAxisSize(v1_3);
                    v23_1[v8 - arg38] = v2;
                    v7_1 += v2;
                    v2 = Math.max(v14, v3);
                    arg37[v8] = v1_3;
                    v14 = v2;
                    v1_2 = v26;
                }
                else {
                    v19_2 = v5;
                }

                ++v8;
                v5 = v19_2;
            }

            v22 = 0;
            v1_1 = ((int)((((long)v7_1)) + v24));
            v2 = arg32 - v18;
            if(v1_1 < 0) {
                v1_1 = 0;
            }

            if(v1_1 <= v2) {
                goto label_116;
            }

            v1_1 = v2;
        }

    label_116:
        v4 = v14;
        if(v6 != 0) {
            v5 = arg38;
            v2 = v22;
            v3 = v2;
            while(v5 < v12) {
                Placeable v6_1 = arg37[v5];
                Intrinsics.checkNotNull(v6_1);
                CrossAxisAlignment v7_2 = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(v6_1));
                v7 = v7_2 != null ? v7_2.calculateAlignmentLinePosition$foundation_layout(v6_1) : null;
                if(v7 != null) {
                    v8 = v7.intValue();
                    v6 = v0_1.crossAxisSize(v6_1);
                    v9 = 0x80000000;
                    v7_1 = v8 != v9 ? v7.intValue() : v22;
                    v2 = Math.max(v2, v7_1);
                    if(v8 != v9) {
                    }
                    else {
                        v8 = v6;
                    }

                    v3 = Math.max(v3, v6 - v8);
                }

                ++v5;
            }

            int v28 = v3;
            v3 = v2;
            v2 = v28;
        }
        else {
            v2 = v22;
            v3 = v2;
        }

        v1_1 = v18 + v1_1;
        if(v1_1 < 0) {
            v1_1 = v22;
        }

        v5 = Math.max(v1_1, arg30);
        v6 = Math.max(v4, Math.max(arg31, v2 + v3));
        int[] v4_2 = new int[v15];
        v0_1.populateMainAxisPositions(v5, v23_1, v4_2, arg35);
        return v0_1.placeHelper(arg37, arg35, v3, v4_2, v5, v6, arg40, arg41, arg38, v12);
    }

    public static MeasureResult measure$default(RowColumnMeasurePolicy arg15, int arg16, int arg17, int arg18, int arg19, int arg20, MeasureScope arg21, List arg22, Placeable[] arg23, int arg24, int arg25, int[] arg26, int arg27, int arg28, Object arg29) {
        int v0 = arg28;
        int[] v13 = (v0 & 0x400) != 0 ? null : arg26;
        int v14 = (v0 & 0x800) != 0 ? 0 : arg27;
        return RowColumnMeasurePolicyKt.measure(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, v13, v14);
    }
}

