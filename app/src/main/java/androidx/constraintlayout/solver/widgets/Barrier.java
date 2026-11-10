package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashMap;

public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private boolean mAllowsGoneWidget;
    private int mBarrierType;
    private int mMargin;

    public Barrier() {
        super();
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
    }

    public void addToSolver(LinearSystem arg14) {
        int v9;
        boolean v6_1;
        int v8;
        this.mListAnchors[0] = this.mLeft;
        int v3 = 2;
        this.mListAnchors[v3] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        int v5 = 3;
        this.mListAnchors[v5] = this.mBottom;
        int v0;
        for(v0 = 0; v0 < this.mListAnchors.length; ++v0) {
            this.mListAnchors[v0].mSolverVariable = arg14.createObjectVariable(this.mListAnchors[v0]);
        }

        v0 = this.mBarrierType;
        if(v0 >= 0) {
            int v1 = 4;
            if(v0 < v1) {
                ConstraintAnchor v0_1 = this.mListAnchors[this.mBarrierType];
                int v6;
                for(v6 = 0; v6 < this.mWidgetsCount; ++v6) {
                    ConstraintWidget v7 = this.mWidgets[v6];
                    if((this.mAllowsGoneWidget) || (v7.allowedInBarrier())) {
                        v8 = this.mBarrierType;
                        if(v8 != 0 && v8 != 1 || (v7.getHorizontalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT || v7.mLeft.mTarget == null || v7.mRight.mTarget == null)) {
                            v8 = this.mBarrierType;
                            if(v8 != v3 && v8 != v5) {
                                goto label_72;
                            }

                            if(v7.getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                                goto label_72;
                            }

                            if(v7.mTop.mTarget == null) {
                                goto label_72;
                            }

                            if(v7.mBottom.mTarget == null) {
                                goto label_72;
                            }
                        }

                        v6_1 = true;
                        goto label_75;
                    }
                    else {
                    }

                label_72:
                }

                v6_1 = false;
            label_75:
                int v7_1 = (this.mLeft.hasCenteredDependents()) || (this.mRight.hasCenteredDependents()) ? 1 : 0;
                v8 = (this.mTop.hasCenteredDependents()) || (this.mBottom.hasCenteredDependents()) ? 1 : 0;
                if(!v6_1) {
                    v9 = this.mBarrierType;
                    if((v9 != 0 || v7_1 == 0) && (v9 != v3 || v8 == 0) && (v9 != 1 || v7_1 == 0)) {
                        if(v9 != v5) {
                            goto label_107;
                        }

                        if(v8 == 0) {
                            goto label_107;
                        }
                    }

                    v7_1 = 1;
                }
                else {
                label_107:
                    v7_1 = 0;
                }

                v7_1 = v7_1 == 0 ? v1 : 5;
                for(v8 = 0; v8 < this.mWidgetsCount; ++v8) {
                    ConstraintWidget v9_1 = this.mWidgets[v8];
                    if((this.mAllowsGoneWidget) || (v9_1.allowedInBarrier())) {
                        SolverVariable v10 = arg14.createObjectVariable(v9_1.mListAnchors[this.mBarrierType]);
                        v9_1.mListAnchors[this.mBarrierType].mSolverVariable = v10;
                        v9 = v9_1.mListAnchors[this.mBarrierType].mTarget == null || v9_1.mListAnchors[this.mBarrierType].mTarget.mOwner != this ? 0 : v9_1.mListAnchors[this.mBarrierType].mMargin;
                        int v11 = this.mBarrierType;
                        if(v11 == 0 || v11 == v3) {
                            arg14.addLowerBarrier(v0_1.mSolverVariable, v10, this.mMargin - v9, v6_1);
                        }
                        else {
                            arg14.addGreaterBarrier(v0_1.mSolverVariable, v10, this.mMargin + v9, v6_1);
                        }

                        arg14.addEquality(v0_1.mSolverVariable, v10, this.mMargin + v9, v7_1);
                    }
                    else {
                    }
                }

                v0 = this.mBarrierType;
                v6 = 8;
                if(v0 == 0) {
                    arg14.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, v6);
                    arg14.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, v1);
                    arg14.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
                    return;
                }

                if(v0 == 1) {
                    arg14.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, v6);
                    arg14.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, v1);
                    arg14.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
                    return;
                }

                if(v0 == v3) {
                    arg14.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, v6);
                    arg14.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, v1);
                    arg14.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
                    return;
                }

                if(v0 != v5) {
                    return;
                }

                arg14.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, v6);
                arg14.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, v1);
                arg14.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    public boolean allowedInBarrier() {
        return 1;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void copy(ConstraintWidget arg1, HashMap arg2) {
        super.copy(arg1, arg2);
        this.mBarrierType = ((Barrier)arg1).mBarrierType;
        this.mAllowsGoneWidget = ((Barrier)arg1).mAllowsGoneWidget;
        this.mMargin = ((Barrier)arg1).mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    protected void markWidgets() {
        int v1;
        for(v1 = 0; v1 < this.mWidgetsCount; ++v1) {
            ConstraintWidget v2 = this.mWidgets[v1];
            int v3 = this.mBarrierType;
            if(v3 == 0 || v3 == 1) {
                v2.setInBarrier(0, true);
            }
            else {
                if(v3 != 2 && v3 != 3) {
                    goto label_18;
                }

                v2.setInBarrier(1, true);
            }

        label_18:
        }
    }

    public void setAllowsGoneWidget(boolean arg1) {
        this.mAllowsGoneWidget = arg1;
    }

    public void setBarrierType(int arg1) {
        this.mBarrierType = arg1;
    }

    public void setMargin(int arg1) {
        this.mMargin = arg1;
    }

    public String toString() {
        String v0 = "[Barrier] " + this.getDebugName() + " {";
        int v1;
        for(v1 = 0; v1 < this.mWidgetsCount; ++v1) {
            ConstraintWidget v2 = this.mWidgets[v1];
            if(v1 > 0) {
                v0 = v0 + ", ";
            }

            v0 = v0 + v2.getDebugName();
        }

        return v0 + "}";
    }
}

