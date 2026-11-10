package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;

public class VirtualLayout extends HelperWidget {
    protected Measure mMeasure;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    Measurer mMeasurer;
    private boolean mNeedsCallFromSolver;
    private int mPaddingBottom;
    private int mPaddingEnd;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingStart;
    private int mPaddingTop;
    private int mResolvedPaddingLeft;
    private int mResolvedPaddingRight;

    public VirtualLayout() {
        super();
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingStart = 0;
        this.mPaddingEnd = 0;
        this.mResolvedPaddingLeft = 0;
        this.mResolvedPaddingRight = 0;
        this.mNeedsCallFromSolver = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        this.mMeasure = new Measure();
        this.mMeasurer = null;
    }

    public void applyRtl(boolean arg3) {
        int v0 = this.mPaddingStart;
        if(v0 <= 0) {
            if(this.mPaddingEnd > 0) {
            }
            else {
                return;
            }
        }

        if(arg3) {
            this.mResolvedPaddingLeft = this.mPaddingEnd;
            this.mResolvedPaddingRight = v0;
            return;
        }

        this.mResolvedPaddingLeft = v0;
        this.mResolvedPaddingRight = this.mPaddingEnd;
    }

    public void captureWidgets() {
        int v0;
        for(v0 = 0; v0 < this.mWidgetsCount; ++v0) {
            ConstraintWidget v1 = this.mWidgets[v0];
            if(v1 != null) {
                v1.setInVirtualLayout(true);
            }
        }
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int arg1, int arg2, int arg3, int arg4) {
    }

    protected void measure(ConstraintWidget arg2, DimensionBehaviour arg3, int arg4, DimensionBehaviour arg5, int arg6) {
        while(this.mMeasurer == null) {
            if(this.getParent() == null) {
                break;
            }

            this.mMeasurer = this.getParent().getMeasurer();
        }

        this.mMeasure.horizontalBehavior = arg3;
        this.mMeasure.verticalBehavior = arg5;
        this.mMeasure.horizontalDimension = arg4;
        this.mMeasure.verticalDimension = arg6;
        this.mMeasurer.measure(arg2, this.mMeasure);
        arg2.setWidth(this.mMeasure.measuredWidth);
        arg2.setHeight(this.mMeasure.measuredHeight);
        arg2.setHasBaseline(this.mMeasure.measuredHasBaseline);
        arg2.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    protected boolean measureChildren() {
        Measurer v0 = this.mParent != null ? this.mParent.getMeasurer() : null;
        if(v0 == null) {
            return 0;
        }

        int v2;
        for(v2 = 0; v2 < this.mWidgetsCount; ++v2) {
            ConstraintWidget v3 = this.mWidgets[v2];
            if(v3 == null) {
            }
            else if((v3 instanceof Guideline)) {
            }
            else {
                DimensionBehaviour v5 = v3.getDimensionBehaviour(0);
                DimensionBehaviour v6 = v3.getDimensionBehaviour(1);
                if(v5 == DimensionBehaviour.MATCH_CONSTRAINT && v3.mMatchConstraintDefaultWidth != 1 && v6 == DimensionBehaviour.MATCH_CONSTRAINT && v3.mMatchConstraintDefaultHeight != 1) {
                    goto label_58;
                }

                if(v5 == DimensionBehaviour.MATCH_CONSTRAINT) {
                    v5 = DimensionBehaviour.WRAP_CONTENT;
                }

                if(v6 == DimensionBehaviour.MATCH_CONSTRAINT) {
                    v6 = DimensionBehaviour.WRAP_CONTENT;
                }

                this.mMeasure.horizontalBehavior = v5;
                this.mMeasure.verticalBehavior = v6;
                this.mMeasure.horizontalDimension = v3.getWidth();
                this.mMeasure.verticalDimension = v3.getHeight();
                v0.measure(v3, this.mMeasure);
                v3.setWidth(this.mMeasure.measuredWidth);
                v3.setHeight(this.mMeasure.measuredHeight);
                v3.setBaselineDistance(this.mMeasure.measuredBaseline);
            }

        label_58:
        }

        return 1;
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    protected void needsCallbackFromSolver(boolean arg1) {
        this.mNeedsCallFromSolver = arg1;
    }

    public void setMeasure(int arg1, int arg2) {
        this.mMeasuredWidth = arg1;
        this.mMeasuredHeight = arg2;
    }

    public void setPadding(int arg1) {
        this.mPaddingLeft = arg1;
        this.mPaddingTop = arg1;
        this.mPaddingRight = arg1;
        this.mPaddingBottom = arg1;
        this.mPaddingStart = arg1;
        this.mPaddingEnd = arg1;
    }

    public void setPaddingBottom(int arg1) {
        this.mPaddingBottom = arg1;
    }

    public void setPaddingEnd(int arg1) {
        this.mPaddingEnd = arg1;
    }

    public void setPaddingLeft(int arg1) {
        this.mPaddingLeft = arg1;
        this.mResolvedPaddingLeft = arg1;
    }

    public void setPaddingRight(int arg1) {
        this.mPaddingRight = arg1;
        this.mResolvedPaddingRight = arg1;
    }

    public void setPaddingStart(int arg1) {
        this.mPaddingStart = arg1;
        this.mResolvedPaddingLeft = arg1;
        this.mResolvedPaddingRight = arg1;
    }

    public void setPaddingTop(int arg1) {
        this.mPaddingTop = arg1;
    }

    public void updateConstraints(ConstraintWidgetContainer arg1) {
        this.captureWidgets();
    }
}

