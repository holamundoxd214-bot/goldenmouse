package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
        super();
    }

    static void applyChainConstraints(ConstraintWidgetContainer arg5, LinearSystem arg6, int arg7) {
        int v3;
        ChainHead[] v2;
        int v1;
        int v0 = 0;
        if(arg7 == 0) {
            v1 = arg5.mHorizontalChainsSize;
            v2 = arg5.mHorizontalChainsArray;
            v3 = 0;
        }
        else {
            v1 = arg5.mVerticalChainsSize;
            v2 = arg5.mVerticalChainsArray;
            v3 = 2;
        }

        while(v0 < v1) {
            ChainHead v4 = v2[v0];
            v4.define();
            Chain.applyChainConstraints(arg5, arg6, arg7, v3, v4);
            ++v0;
        }
    }

    static void applyChainConstraints(ConstraintWidgetContainer arg35, LinearSystem arg36, int arg37, int arg38, ChainHead arg39) {
        SolverVariable v21_1;
        LinearSystem v0_5;
        SolverVariable v13_2;
        SolverVariable v4_4;
        ConstraintWidget v35_1;
        ConstraintWidget v17;
        int v3_3;
        int v7_4;
        SolverVariable v8_1;
        ConstraintAnchor v7_3;
        SolverVariable v3_2;
        ConstraintAnchor v1_1;
        ConstraintWidget v0_4;
        ConstraintWidget v15_2;
        ConstraintWidget v13_1;
        int v16;
        ConstraintAnchor v2_1;
        float v35;
        SolverVariable v0_2;
        SolverVariable v6_2;
        SolverVariable v5_2;
        ArrayList v18_1;
        int v4_3;
        int v25;
        int v24;
        int v8;
        int v23;
        ConstraintAnchor v4_1;
        ConstraintWidget v21;
        float v18;
        int v14;
        int v13;
        ConstraintWidgetContainer v0 = arg35;
        LinearSystem v1 = arg36;
        ChainHead v2 = arg39;
        ConstraintWidget v9 = v2.mFirst;
        ConstraintWidget v10 = v2.mLast;
        ConstraintWidget v11 = v2.mFirstVisibleWidget;
        ConstraintWidget v12 = v2.mLastVisibleWidget;
        ConstraintWidget v3 = v2.mHead;
        float v4 = v2.mTotalWeight;
        int v5 = v0.mListDimensionBehaviors[arg37] == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
        int v6 = 2;
        if(arg37 == 0) {
            v13 = v3.mHorizontalChainStyle == 0 ? 1 : 0;
            v14 = v3.mHorizontalChainStyle == 1 ? 1 : 0;
            if(v3.mHorizontalChainStyle != v6) {
                goto label_48;
            }

            goto label_46;
        }
        else {
            v13 = v3.mVerticalChainStyle == 0 ? 1 : 0;
            v14 = v3.mVerticalChainStyle == 1 ? 1 : 0;
            if(v3.mVerticalChainStyle == v6) {
            label_46:
                v6 = 1;
                goto label_49;
            }

        label_48:
            v6 = 0;
        }

    label_49:
        ConstraintWidget v7 = v9;
        int v15 = 0;
        while(true) {
            v18 = v4;
            v21 = null;
            if(v15 != 0) {
                break;
            }

            v4_1 = v7.mListAnchors[arg38];
            int v19 = v6 != 0 ? 1 : 4;
            int v22 = v4_1.getMargin();
            v23 = v5;
            v5 = v7.mListDimensionBehaviors[arg37] != DimensionBehaviour.MATCH_CONSTRAINT || v7.mResolvedMatchConstraintDefault[arg37] != 0 ? 0 : 1;
            if(v4_1.mTarget != null && v7 != v9) {
                v22 += v4_1.mTarget.getMargin();
            }

            v8 = v22;
            if(v6 != 0 && v7 != v9 && v7 != v11) {
                v19 = 5;
            }

            v22 = v5;
            if(v4_1.mTarget != null) {
                if(v7 == v11) {
                    v24 = v6;
                    v25 = v13;
                    v1.addGreaterThan(v4_1.mSolverVariable, v4_1.mTarget.mSolverVariable, v8, 6);
                }
                else {
                    v24 = v6;
                    v25 = v13;
                    v1.addGreaterThan(v4_1.mSolverVariable, v4_1.mTarget.mSolverVariable, v8, 8);
                }

                v5 = v22 == 0 || v24 != 0 ? v19 : 5;
                v1.addEquality(v4_1.mSolverVariable, v4_1.mTarget.mSolverVariable, v8, v5);
            }
            else {
                v24 = v6;
                v25 = v13;
            }

            if(v23 != 0) {
                if(v7.getVisibility() == 8 || v7.mListDimensionBehaviors[arg37] != DimensionBehaviour.MATCH_CONSTRAINT) {
                    v8 = 0;
                }
                else {
                    v8 = 0;
                    v1.addGreaterThan(v7.mListAnchors[arg38 + 1].mSolverVariable, v7.mListAnchors[arg38].mSolverVariable, 0, 5);
                }

                v1.addGreaterThan(v7.mListAnchors[arg38].mSolverVariable, v0.mListAnchors[arg38].mSolverVariable, v8, 8);
            }

            v4_1 = v7.mListAnchors[arg38 + 1].mTarget;
            if(v4_1 != null) {
                ConstraintWidget v4_2 = v4_1.mOwner;
                if(v4_2.mListAnchors[arg38].mTarget != null) {
                    if(v4_2.mListAnchors[arg38].mTarget.mOwner != v7) {
                    }
                    else {
                        v21 = v4_2;
                    }
                }
            }

            if(v21 != null) {
                v7 = v21;
            }
            else {
                v15 = 1;
            }

            v4 = v18;
            v5 = v23;
            v6 = v24;
            v13 = v25;
        }

        v23 = v5;
        v24 = v6;
        v25 = v13;
        if(v12 != null) {
            v5 = arg38 + 1;
            if(v10.mListAnchors[v5].mTarget != null) {
                v4_1 = v12.mListAnchors[v5];
                if(v12.mListDimensionBehaviors[arg37] == DimensionBehaviour.MATCH_CONSTRAINT && v12.mResolvedMatchConstraintDefault[arg37] == 0 && v24 == 0 && v4_1.mTarget.mOwner == v0) {
                    v1.addEquality(v4_1.mSolverVariable, v4_1.mTarget.mSolverVariable, -v4_1.getMargin(), 5);
                }
                else if(v24 != 0 && v4_1.mTarget.mOwner == v0) {
                    v1.addEquality(v4_1.mSolverVariable, v4_1.mTarget.mSolverVariable, -v4_1.getMargin(), 4);
                }

                v1.addLowerThan(v4_1.mSolverVariable, v10.mListAnchors[v5].mTarget.mSolverVariable, -v4_1.getMargin(), 6);
            }
        }

        if(v23 != 0) {
            v4_3 = arg38 + 1;
            v1.addGreaterThan(v0.mListAnchors[v4_3].mSolverVariable, v10.mListAnchors[v4_3].mSolverVariable, v10.mListAnchors[v4_3].getMargin(), 8);
        }

        ArrayList v0_1 = v2.mWeightedMatchConstraintsWidgets;
        if(v0_1 != null) {
            v4_3 = v0_1.size();
            if(v4_3 > 1) {
                float v28 = !v2.mHasUndefinedWeights || (v2.mHasComplexMatchWeights) ? v18 : ((float)v2.mWidgetsMatchCount);
                float v6_1 = 0f;
                float v27 = 0f;
                Object v7_1 = v21;
                v8 = 0;
                while(v8 < v4_3) {
                    Object v15_1 = v0_1.get(v8);
                    float v5_1 = ((ConstraintWidget)v15_1).mWeight[arg37];
                    if(v5_1 >= v6_1) {
                        v35 = v6_1;
                    label_278:
                        float v29 = v5_1;
                        if(v29 == v35) {
                            v1.addEquality(((ConstraintWidget)v15_1).mListAnchors[arg38 + 1].mSolverVariable, ((ConstraintWidget)v15_1).mListAnchors[arg38].mSolverVariable, 0, 8);
                        label_290:
                            v18_1 = v0_1;
                        }
                        else {
                            if(v7_1 != null) {
                                v5_2 = ((ConstraintWidget)v7_1).mListAnchors[arg38].mSolverVariable;
                                v13 = arg38 + 1;
                                SolverVariable v7_2 = ((ConstraintWidget)v7_1).mListAnchors[v13].mSolverVariable;
                                v6_2 = ((ConstraintWidget)v15_1).mListAnchors[arg38].mSolverVariable;
                                v18_1 = v0_1;
                                v0_2 = ((ConstraintWidget)v15_1).mListAnchors[v13].mSolverVariable;
                                ArrayRow v26 = v1.createRow();
                                v26.createRowEqualMatchDimensions(v27, v28, v29, v5_2, v7_2, v6_2, v0_2);
                                v1.addConstraint(v26);
                            }
                            else {
                                v18_1 = v0_1;
                            }

                            v7_1 = v15_1;
                            v27 = v29;
                        }
                    }
                    else if(v2.mHasComplexMatchWeights) {
                        v35 = v6_1;
                        v1.addEquality(((ConstraintWidget)v15_1).mListAnchors[arg38 + 1].mSolverVariable, ((ConstraintWidget)v15_1).mListAnchors[arg38].mSolverVariable, 0, 4);
                        goto label_290;
                    }
                    else {
                        v35 = v6_1;
                        v5_1 = 1f;
                        goto label_278;
                    }

                    ++v8;
                    v6_1 = v35;
                    v0_1 = v18_1;
                }
            }
        }

        if(v11 != null) {
            if(v11 != v12 && v24 == 0) {
                goto label_372;
            }

            ConstraintAnchor v0_3 = v9.mListAnchors[arg38];
            v4_3 = arg38 + 1;
            v2_1 = v10.mListAnchors[v4_3];
            v0_2 = v0_3.mTarget != null ? v0_3.mTarget.mSolverVariable : ((SolverVariable)v21);
            v5_2 = v2_1.mTarget != null ? v2_1.mTarget.mSolverVariable : ((SolverVariable)v21);
            v2_1 = v11.mListAnchors[arg38];
            v4_1 = v12.mListAnchors[v4_3];
            if(v0_2 == null) {
                goto label_648;
            }

            if(v5_2 == null) {
                goto label_648;
            }

            float v3_1 = arg37 == 0 ? v3.mHorizontalBiasPercent : v3.mVerticalBiasPercent;
            v1.addCentering(v2_1.mSolverVariable, v0_2, v2_1.getMargin(), v3_1, v5_2, v4_1.mSolverVariable, v4_1.getMargin(), 7);
            goto label_648;
        }
        else {
        label_372:
            if(v25 != 0 && v11 != null) {
                v16 = v2.mWidgetsMatchCount <= 0 || v2.mWidgetsCount != v2.mWidgetsMatchCount ? 0 : 1;
                v13_1 = v11;
                v15_2 = v13_1;
                while(true) {
                    if(v13_1 == null) {
                        goto label_648;
                    }

                    v0_4 = v13_1.mNextChainWidget[arg37];
                    while(true) {
                        if(v0_4 != null) {
                            v6 = 8;
                            if(v0_4.getVisibility() == v6) {
                                v0_4 = v0_4.mNextChainWidget[arg37];
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_395;
                    }

                    v6 = 8;
                label_395:
                    if(v0_4 != null || v13_1 == v12) {
                        v1_1 = v13_1.mListAnchors[arg38];
                        SolverVariable v2_2 = v1_1.mSolverVariable;
                        v3_2 = v1_1.mTarget != null ? v1_1.mTarget.mSolverVariable : ((SolverVariable)v21);
                        if(v15_2 != v13_1) {
                            v3_2 = v15_2.mListAnchors[arg38 + 1].mSolverVariable;
                        }
                        else if(v13_1 == v11 && v15_2 == v13_1) {
                            v3_2 = v9.mListAnchors[arg38].mTarget != null ? v9.mListAnchors[arg38].mTarget.mSolverVariable : ((SolverVariable)v21);
                        }

                        int v1_2 = v1_1.getMargin();
                        v5 = arg38 + 1;
                        v4_3 = v13_1.mListAnchors[v5].getMargin();
                        if(v0_4 != null) {
                            v7_3 = v0_4.mListAnchors[arg38];
                            v8_1 = v7_3.mSolverVariable;
                            v6_2 = v13_1.mListAnchors[v5].mSolverVariable;
                        }
                        else {
                            v7_3 = v10.mListAnchors[v5].mTarget;
                            v8_1 = v7_3 != null ? v7_3.mSolverVariable : ((SolverVariable)v21);
                            v6_2 = v13_1.mListAnchors[v5].mSolverVariable;
                        }

                        if(v7_3 != null) {
                            v4_3 += v7_3.getMargin();
                        }

                        if(v15_2 != null) {
                            v1_2 += v15_2.mListAnchors[v5].getMargin();
                        }

                        if(v2_2 != null && v3_2 != null && v8_1 != null && v6_2 != null) {
                            if(v13_1 == v11) {
                                v1_2 = v11.mListAnchors[arg38].getMargin();
                            }

                            if(v13_1 == v12) {
                                v4_3 = v12.mListAnchors[v5].getMargin();
                            }

                            v7_4 = v4_3;
                            v5_2 = v8_1;
                            v8 = v16 != 0 ? 8 : 5;
                            SolverVariable v35_2 = v3_2;
                            v3_3 = v1_2;
                            SolverVariable v1_3 = v2_2;
                            v2_2 = v35_2;
                            v17 = v0_4;
                            v35_1 = v13_1;
                            v13 = 8;
                            arg36.addCentering(v1_3, v2_2, v3_3, 0.5f, v5_2, v6_2, v7_4, v8);
                            goto label_496;
                        }

                        v17 = v0_4;
                        v35_1 = v13_1;
                        v13 = 8;
                    }
                    else {
                        v17 = v0_4;
                        v35_1 = v13_1;
                        v13 = v6;
                    }

                label_496:
                    if(v35_1.getVisibility() != v13) {
                        v15_2 = v35_1;
                    }

                    v13_1 = v17;
                }
            }

            v13 = 8;
            if(v14 != 0 && v11 != null) {
                v16 = v2.mWidgetsMatchCount <= 0 || v2.mWidgetsCount != v2.mWidgetsMatchCount ? 0 : 1;
                v0_4 = v11;
                v15_2 = v0_4;
                while(v15_2 != null) {
                    ConstraintWidget v1_4;
                    for(v1_4 = v15_2.mNextChainWidget[arg37]; v1_4 != null; v1_4 = v1_4.mNextChainWidget[arg37]) {
                        if(v1_4.getVisibility() != v13) {
                            break;
                        }
                    }

                    if(v15_2 == v11 || v15_2 == v12 || v1_4 == null) {
                        v13_1 = v0_4;
                    }
                    else {
                        if(v1_4 == v12) {
                            v1_4 = v21;
                        }

                        v2_1 = v15_2.mListAnchors[arg38];
                        v3_2 = v2_1.mSolverVariable;
                        v5 = arg38 + 1;
                        v4_4 = v0_4.mListAnchors[v5].mSolverVariable;
                        int v2_3 = v2_1.getMargin();
                        v6 = v15_2.mListAnchors[v5].getMargin();
                        if(v1_4 != null) {
                            v7_3 = v1_4.mListAnchors[arg38];
                            v8_1 = v7_3.mSolverVariable;
                            v13_2 = v7_3.mTarget != null ? v7_3.mTarget.mSolverVariable : ((SolverVariable)v21);
                        }
                        else {
                            v7_3 = v12.mListAnchors[arg38];
                            v8_1 = v7_3 != null ? v7_3.mSolverVariable : ((SolverVariable)v21);
                            v13_2 = v15_2.mListAnchors[v5].mSolverVariable;
                        }

                        if(v7_3 != null) {
                            v6 += v7_3.getMargin();
                        }

                        v7_4 = v6;
                        if(v0_4 != null) {
                            v2_3 += v0_4.mListAnchors[v5].getMargin();
                        }

                        v5_2 = v8_1;
                        v8 = v16 != 0 ? 8 : 4;
                        if(v3_2 == null || v4_4 == null || v5_2 == null || v13_2 == null) {
                            v13_1 = v0_4;
                            v17 = v1_4;
                        }
                        else {
                            v17 = v1_4;
                            v6_2 = v13_2;
                            v13_1 = v0_4;
                            arg36.addCentering(v3_2, v4_4, v2_3, 0.5f, v5_2, v6_2, v7_4, v8);
                        }

                        v1_4 = v17;
                    }

                    v6 = 8;
                    if(v15_2.getVisibility() != v6) {
                        v13_1 = v15_2;
                    }

                    v15_2 = v1_4;
                    v0_4 = v13_1;
                    v13 = v6;
                }

                v0_5 = arg36;
                v1_1 = v11.mListAnchors[arg38];
                v2_1 = v9.mListAnchors[arg38].mTarget;
                v4_3 = arg38 + 1;
                ConstraintAnchor v9_1 = v12.mListAnchors[v4_3];
                ConstraintAnchor v13_3 = v10.mListAnchors[v4_3].mTarget;
                v8 = 5;
                if(v2_1 != null) {
                    if(v11 != v12) {
                        v0_5.addEquality(v1_1.mSolverVariable, v2_1.mSolverVariable, v1_1.getMargin(), v8);
                    }
                    else if(v13_3 != null) {
                        v0_5.addCentering(v1_1.mSolverVariable, v2_1.mSolverVariable, v1_1.getMargin(), 0.5f, v9_1.mSolverVariable, v13_3.mSolverVariable, v9_1.getMargin(), v8);
                    }
                }

                if(v13_3 == null) {
                    goto label_649;
                }

                if(v11 == v12) {
                    goto label_649;
                }

                v0_5.addEquality(v9_1.mSolverVariable, v13_3.mSolverVariable, -v9_1.getMargin(), v8);
                goto label_649;
            }

        label_648:
            v0_5 = arg36;
        }

    label_649:
        if((v25 != 0 || v14 != 0) && (v11 != null && v11 != v12)) {
            v1_1 = v11.mListAnchors[arg38];
            v3_3 = arg38 + 1;
            v2_1 = v12.mListAnchors[v3_3];
            v4_4 = v1_1.mTarget != null ? v1_1.mTarget.mSolverVariable : ((SolverVariable)v21);
            v5_2 = v2_1.mTarget != null ? v2_1.mTarget.mSolverVariable : ((SolverVariable)v21);
            if(v10 != v12) {
                ConstraintAnchor v5_3 = v10.mListAnchors[v3_3];
                if(v5_3.mTarget != null) {
                    v21_1 = v5_3.mTarget.mSolverVariable;
                }

                v5_2 = v21_1;
            }

            if(v11 == v12) {
                v1_1 = v11.mListAnchors[arg38];
                v2_1 = v11.mListAnchors[v3_3];
            }

            if(v4_4 == null) {
                return;
            }

            if(v5_2 == null) {
                return;
            }

            v6 = v3_3;
            v3_3 = v1_1.getMargin();
            if(v12 == null) {
            }
            else {
                v10 = v12;
            }

            v0_5.addCentering(v1_1.mSolverVariable, v4_4, v3_3, 0.5f, v5_2, v2_1.mSolverVariable, v10.mListAnchors[v6].getMargin(), 5);
        }
    }
}

