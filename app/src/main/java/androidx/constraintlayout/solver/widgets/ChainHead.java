package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight;
    int mVisibleWidgets;
    protected ArrayList mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget arg2, int arg3, boolean arg4) {
        super();
        this.mTotalWeight = 0f;
        this.mFirst = arg2;
        this.mOrientation = arg3;
        this.mIsRtl = arg4;
    }

    public void define() {
        if(!this.mDefined) {
            this.defineChainProperties();
        }

        this.mDefined = true;
    }

    private void defineChainProperties() {
        int v1 = 2;
        int v0 = this.mOrientation * v1;
        ConstraintWidget v2 = this.mFirst;
        boolean v3 = true;
        this.mOptimizable = true;
        ConstraintWidget v5 = v2;
        int v6 = 0;
        while(v6 == 0) {
            ++this.mWidgetsCount;
            ConstraintWidget v9 = null;
            v2.mNextChainWidget[this.mOrientation] = v9;
            v2.mListNextMatchConstraintsWidget[this.mOrientation] = v9;
            if(v2.getVisibility() != 8) {
                ++this.mVisibleWidgets;
                if(v2.getDimensionBehaviour(this.mOrientation) != DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mTotalSize += v2.getLength(this.mOrientation);
                }

                int v7 = this.mTotalSize + v2.mListAnchors[v0].getMargin();
                this.mTotalSize = v7;
                int v10 = v0 + 1;
                this.mTotalSize = v7 + v2.mListAnchors[v10].getMargin();
                v7 = this.mTotalMargins + v2.mListAnchors[v0].getMargin();
                this.mTotalMargins = v7;
                this.mTotalMargins = v7 + v2.mListAnchors[v10].getMargin();
                if(this.mFirstVisibleWidget == null) {
                    this.mFirstVisibleWidget = v2;
                }

                this.mLastVisibleWidget = v2;
                if(v2.mListDimensionBehaviors[this.mOrientation] != DimensionBehaviour.MATCH_CONSTRAINT) {
                    goto label_141;
                }

                if(v2.mResolvedMatchConstraintDefault[this.mOrientation] == 0 || v2.mResolvedMatchConstraintDefault[this.mOrientation] == 3 || v2.mResolvedMatchConstraintDefault[this.mOrientation] == v1) {
                    ++this.mWidgetsMatchCount;
                    float[] v7_1 = v2.mWeight;
                    v10 = this.mOrientation;
                    float v7_2 = v7_1[v10];
                    if(v7_2 > 0f) {
                        float v10_1 = this.mTotalWeight;
                        float[] v11 = v2.mWeight;
                        int v12 = this.mOrientation;
                        this.mTotalWeight = v10_1 + v11[v12];
                        v10 = v12;
                    }

                    if(ChainHead.isMatchConstraintEqualityCandidate(v2, v10)) {
                        if(v7_2 < 0f) {
                            this.mHasUndefinedWeights = true;
                        }
                        else {
                            this.mHasDefinedWeights = true;
                        }

                        ArrayList v7_3 = this.mWeightedMatchConstraintsWidgets;
                        if(v7_3 == null) {
                            v7_3 = new ArrayList();
                            this.mWeightedMatchConstraintsWidgets = v7_3;
                        }

                        v7_3.add(v2);
                    }

                    if(this.mFirstMatchConstraintWidget == null) {
                        this.mFirstMatchConstraintWidget = v2;
                    }

                    ConstraintWidget v7_4 = this.mLastMatchConstraintWidget;
                    if(v7_4 != null) {
                        v7_4.mListNextMatchConstraintsWidget[this.mOrientation] = v2;
                    }

                    this.mLastMatchConstraintWidget = v2;
                }

                if(this.mOrientation != 0) {
                    if(v2.mMatchConstraintDefaultHeight != 0) {
                        this.mOptimizable = false;
                        goto label_137;
                    }

                    if(v2.mMatchConstraintMinHeight == 0 && v2.mMatchConstraintMaxHeight == 0) {
                        goto label_137;
                    }

                    this.mOptimizable = false;
                }
                else if(v2.mMatchConstraintDefaultWidth != 0) {
                    this.mOptimizable = false;
                }
                else {
                    if(v2.mMatchConstraintMinWidth == 0 && v2.mMatchConstraintMaxWidth == 0) {
                        goto label_137;
                    }

                    this.mOptimizable = false;
                }

            label_137:
                if(v2.mDimensionRatio == 0f) {
                    goto label_141;
                }

                this.mOptimizable = false;
                this.mHasRatio = true;
            }

        label_141:
            if(v5 != v2) {
                v5.mNextChainWidget[this.mOrientation] = v2;
            }

            ConstraintAnchor v5_1 = v2.mListAnchors[v0 + 1].mTarget;
            if(v5_1 != null) {
                v5 = v5_1.mOwner;
                if(v5.mListAnchors[v0].mTarget != null) {
                    if(v5.mListAnchors[v0].mTarget.mOwner != v2) {
                    }
                    else {
                        v9 = v5;
                    }
                }
            }

            if(v9 != null) {
            }
            else {
                v9 = v2;
                v6 = 1;
            }

            v5 = v2;
            v2 = v9;
        }

        ConstraintWidget v1_1 = this.mFirstVisibleWidget;
        if(v1_1 != null) {
            this.mTotalSize -= v1_1.mListAnchors[v0].getMargin();
        }

        v1_1 = this.mLastVisibleWidget;
        if(v1_1 != null) {
            this.mTotalSize -= v1_1.mListAnchors[v0 + 1].getMargin();
        }

        this.mLast = v2;
        this.mHead = this.mOrientation != 0 || !this.mIsRtl ? this.mFirst : v2;
        if(!this.mHasDefinedWeights || !this.mHasUndefinedWeights) {
            v3 = false;
        }
        else {
        }

        this.mHasComplexMatchWeights = v3;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget arg2, int arg3) {
        if(arg2.getVisibility() != 8 && arg2.mListDimensionBehaviors[arg3] == DimensionBehaviour.MATCH_CONSTRAINT && (arg2.mResolvedMatchConstraintDefault[arg3] == 0 || arg2.mResolvedMatchConstraintDefault[arg3] == 3)) {
            return 1;
        }

        return 0;
    }
}

