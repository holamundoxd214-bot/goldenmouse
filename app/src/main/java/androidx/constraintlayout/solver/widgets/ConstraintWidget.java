package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    class androidx.constraintlayout.solver.widgets.ConstraintWidget$1 {
        static {
            int[] v0 = new int[DimensionBehaviour.values().length];
            androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = v0;
            try {
                v0[DimensionBehaviour.FIXED.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
            label_8:
                int v0_1 = 2;
                try {
                    androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = v0_1;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                label_13:
                    int v2 = 3;
                    try {
                        androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = v2;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                    label_18:
                        int v3 = 4;
                        try {
                            androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = v3;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                        label_23:
                            int[] v4 = new int[Type.values().length];
                            androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = v4;
                            try {
                                v4[Type.LEFT.ordinal()] = 1;
                                goto label_30;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_30:
                                    androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = v0_1;
                                    goto label_34;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_34:
                                        androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = v2;
                                        goto label_38;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_38:
                                            androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = v3;
                                            goto label_42;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_42:
                                                androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 5;
                                                goto label_47;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_47:
                                                    androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER.ordinal()] = 6;
                                                    goto label_52;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_52:
                                                        androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;
                                                        goto label_57;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_57:
                                                            androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;
                                                            goto label_62;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_62:
                                                                androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;
                                                                return;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public enum DimensionBehaviour {
        public static final enum DimensionBehaviour FIXED;
        public static final enum DimensionBehaviour MATCH_CONSTRAINT;
        public static final enum DimensionBehaviour MATCH_PARENT;
        public static final enum DimensionBehaviour WRAP_CONTENT;

        static {
            DimensionBehaviour v0 = new DimensionBehaviour("FIXED", 0);
            DimensionBehaviour.FIXED = v0;
            DimensionBehaviour v1 = new DimensionBehaviour("WRAP_CONTENT", 1);
            DimensionBehaviour.WRAP_CONTENT = v1;
            DimensionBehaviour v2 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            DimensionBehaviour.MATCH_CONSTRAINT = v2;
            DimensionBehaviour v3 = new DimensionBehaviour("MATCH_PARENT", 3);
            DimensionBehaviour.MATCH_PARENT = v3;
            DimensionBehaviour.$VALUES = new DimensionBehaviour[]{v0, v1, v2, v3};
        }

        private DimensionBehaviour(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static DimensionBehaviour valueOf(String arg1) {
            return Enum.valueOf(DimensionBehaviour.class, arg1);
        }

        public static DimensionBehaviour[] values() {
            return DimensionBehaviour.$VALUES.clone();
        }
    }

    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    static {
    }

    public ConstraintWidget() {
        super();
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1f;
        this.mMaxDimension = new int[]{0x7FFFFFFF, 0x7FFFFFFF};
        this.mCircleConstraintAngle = 0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, Type.LEFT);
        this.mTop = new ConstraintAnchor(this, Type.TOP);
        this.mRight = new ConstraintAnchor(this, Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, Type.CENTER_Y);
        ConstraintAnchor v4 = new ConstraintAnchor(this, Type.CENTER);
        this.mCenter = v4;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, v4};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float v2 = ConstraintWidget.DEFAULT_BIAS;
        this.mHorizontalBiasPercent = v2;
        this.mVerticalBiasPercent = v2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1f, -1f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.addAnchors();
    }

    public ConstraintWidget(int arg2, int arg3) {
        this(0, 0, arg2, arg3);
    }

    public ConstraintWidget(int arg10, int arg11, int arg12, int arg13) {
        super();
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1f;
        this.mMaxDimension = new int[]{0x7FFFFFFF, 0x7FFFFFFF};
        this.mCircleConstraintAngle = 0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, Type.LEFT);
        this.mTop = new ConstraintAnchor(this, Type.TOP);
        this.mRight = new ConstraintAnchor(this, Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, Type.CENTER_Y);
        ConstraintAnchor v4 = new ConstraintAnchor(this, Type.CENTER);
        this.mCenter = v4;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, v4};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mDimensionRatio = 0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float v2 = ConstraintWidget.DEFAULT_BIAS;
        this.mHorizontalBiasPercent = v2;
        this.mVerticalBiasPercent = v2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1f, -1f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = arg10;
        this.mY = arg11;
        this.mWidth = arg12;
        this.mHeight = arg13;
        this.addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    boolean addFirst() {
        if(!(this instanceof VirtualLayout)) {
            if((this instanceof Guideline)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void addToSolver(LinearSystem arg43) {
        ConstraintWidget v4_1;
        int v2_2;
        ConstraintWidget v2_1;
        boolean v26_1;
        boolean v17;
        int v8_3;
        SolverVariable v7_2;
        SolverVariable v39;
        SolverVariable v40;
        SolverVariable v41;
        SolverVariable v38;
        boolean v3_1;
        SolverVariable v33;
        int v21_1;
        SolverVariable v32;
        int v22_1;
        boolean v30;
        boolean v5_3;
        int v11_1;
        boolean v4_3;
        int v27;
        int v5_1;
        SolverVariable v23;
        boolean v19;
        boolean v18;
        boolean v13;
        boolean v9;
        boolean v8_2;
        boolean v7_1;
        ConstraintWidget v0 = this;
        LinearSystem v1 = arg43;
        SolverVariable v2 = v1.createObjectVariable(v0.mLeft);
        SolverVariable v3 = v1.createObjectVariable(v0.mRight);
        SolverVariable v4 = v1.createObjectVariable(v0.mTop);
        SolverVariable v5 = v1.createObjectVariable(v0.mBottom);
        SolverVariable v6 = v1.createObjectVariable(v0.mBaseline);
        long v8 = 1;
        if(LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.widgets += v8;
        }

        int v10 = 8;
        if(!v0.horizontalRun.start.resolved || !v0.horizontalRun.end.resolved || !v0.verticalRun.start.resolved || !v0.verticalRun.end.resolved) {
            if(LinearSystem.sMetrics != null) {
                LinearSystem.sMetrics.linearSolved += v8;
            }

            ConstraintWidget v7 = v0.mParent;
            if(v7 != null) {
                v7_1 = v7 == null || v7.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT ? false : true;
                ConstraintWidget v8_1 = v0.mParent;
                v8_2 = v8_1 == null || v8_1.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT ? false : true;
                if(v0.isChainHead(0)) {
                    v0.mParent.addChain(v0, 0);
                    v9 = true;
                }
                else {
                    v9 = v0.isInHorizontalChain();
                }

                if(v0.isChainHead(1)) {
                    v0.mParent.addChain(v0, 1);
                    v13 = true;
                }
                else {
                    v13 = v0.isInVerticalChain();
                }

                if(!v9 && (v7_1) && v0.mVisibility != v10 && v0.mLeft.mTarget == null && v0.mRight.mTarget == null) {
                    v1.addGreaterThan(v1.createObjectVariable(v0.mParent.mRight), v3, 0, 1);
                }

                if(!v13 && (v8_2) && v0.mVisibility != v10 && v0.mTop.mTarget == null && v0.mBottom.mTarget == null && v0.mBaseline == null) {
                    v1.addGreaterThan(v1.createObjectVariable(v0.mParent.mBottom), v5, 0, 1);
                }

                v18 = v9;
                v19 = v13;
            }
            else {
                v7_1 = false;
                v8_2 = false;
                v18 = false;
                v19 = false;
            }

            int v9_1 = v0.mWidth;
            int v13_1 = v0.mMinWidth;
            if(v9_1 < v13_1) {
                v9_1 = v13_1;
            }

            v13_1 = v0.mHeight;
            int v14 = v0.mMinHeight;
            if(v13_1 < v14) {
                v13_1 = v14;
            }

            boolean v14_1 = v0.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT ? true : false;
            boolean v11 = v0.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT ? true : false;
            v0.mResolvedDimensionRatioSide = v0.mDimensionRatioSide;
            float v15 = v0.mDimensionRatio;
            v0.mResolvedDimensionRatio = v15;
            int v12 = v0.mMatchConstraintDefaultWidth;
            v10 = v0.mMatchConstraintDefaultHeight;
            SolverVariable v21 = v4;
            if(Float.compare(v15, 0f) <= 0 || v0.mVisibility == 8) {
                v23 = v5;
                v27 = v13_1;
            label_297:
                v4_3 = false;
            }
            else {
                v23 = v5;
                v5_1 = 3;
                if(v0.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && v12 == 0) {
                    v12 = v5_1;
                }

                if(v0.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && v10 == 0) {
                    v10 = v5_1;
                }

                if(v0.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT || v0.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT || v12 != v5_1 || v10 != v5_1) {
                    v14 = 4;
                    if(v0.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && v12 == v5_1) {
                        v0.mResolvedDimensionRatioSide = 0;
                        v9_1 = ((int)(v0.mResolvedDimensionRatio * (((float)v0.mHeight))));
                        v27 = v13_1;
                        if(v0.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                            v12 = v14;
                            goto label_297;
                        }
                        else {
                            v4_3 = true;
                            goto label_298;
                        }
                    }

                    if(v0.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        goto label_292;
                    }

                    if(v10 != v5_1) {
                        goto label_292;
                    }

                    v0.mResolvedDimensionRatioSide = 1;
                    if(v0.mDimensionRatioSide == -1) {
                        v0.mResolvedDimensionRatio = 1f / v0.mResolvedDimensionRatio;
                    }

                    v13_1 = ((int)(v0.mResolvedDimensionRatio * (((float)v0.mWidth))));
                    if(v0.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                        goto label_292;
                    }

                    v27 = v13_1;
                    v10 = v14;
                    goto label_297;
                }
                else {
                    v0.setupDimensionRatio(v7_1, v8_2, v14_1, v11);
                }

            label_292:
                v27 = v13_1;
                v4_3 = true;
            }

        label_298:
            int[] v5_2 = v0.mResolvedMatchConstraintDefault;
            v5_2[0] = v12;
            v5_2[1] = v10;
            v0.mResolvedHasRatio = v4_3;
            if(v4_3) {
                v5_1 = v0.mResolvedDimensionRatioSide;
                v11_1 = -1;
                if(v5_1 != 0 && v5_1 != v11_1) {
                    goto label_312;
                }

                v5_3 = true;
            }
            else {
            label_312:
                v5_3 = false;
            }

            if(v0.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT || !(v0 instanceof ConstraintWidgetContainer)) {
                v13_1 = v9_1;
                v9 = false;
            }
            else {
                v13_1 = v9_1;
                v9 = true;
            }

            if(v9) {
                v13_1 = 0;
            }

            int v26 = v0.mCenter.isConnected() ^ 1;
            boolean[] v14_2 = v0.mIsInBarrier;
            int v15_1 = 8;
            boolean v20 = v14_2[0];
            boolean v28 = v14_2[1];
            boolean v22 = v4_3;
            SolverVariable v29 = null;
            if(v0.mHorizontalResolution != 2) {
                if(v0.horizontalRun.start.resolved) {
                    if(!v0.horizontalRun.end.resolved) {
                    }
                    else {
                        v1.addEquality(v2, v0.horizontalRun.start.value);
                        v1.addEquality(v3, v0.horizontalRun.end.value);
                        if(v0.mParent == null) {
                        }
                        else if(!v7_1) {
                        }
                        else if(!v0.isTerminalWidget[0]) {
                        }
                        else if(!v0.isInHorizontalChain()) {
                            v1.addGreaterThan(v1.createObjectVariable(v0.mParent.mRight), v3, 0, v15_1);
                        }
                        else {
                        }

                        goto label_429;
                    }
                }

                ConstraintWidget v14_3 = v0.mParent;
                SolverVariable v14_4 = v14_3 != null ? v1.createObjectVariable(v14_3.mRight) : v29;
                v4_1 = v0.mParent;
                v4 = v4_1 != null ? v1.createObjectVariable(v4_1.mLeft) : v29;
                v30 = v22;
                v22_1 = v10;
                v32 = v21;
                v21_1 = v12;
                v33 = v3;
                v3_1 = v7_1;
                v38 = v2;
                v41 = v6;
                v40 = v23;
                v39 = v32;
                v1 = arg43;
                v6 = v4;
                v4_3 = v8_2;
                v0.applyConstraints(v1, true, v3_1, v4_3, v0.isTerminalWidget[0], v6, v14_4, v0.mListDimensionBehaviors[0], v9, v0.mLeft, v0.mRight, v0.mX, v13_1, v0.mMinWidth, v0.mMaxDimension[0], v0.mHorizontalBiasPercent, v5_3, v18, v19, v20, v21_1, v22_1, v0.mMatchConstraintMinWidth, v0.mMatchConstraintMaxWidth, v0.mMatchConstraintPercentWidth, ((boolean)v26));
            }
            else {
            label_429:
                v38 = v2;
                v33 = v3;
                v41 = v6;
                v3_1 = v7_1;
                v4_3 = v8_2;
                v39 = v21;
                v30 = v22;
                v40 = v23;
                v22_1 = v10;
                v21_1 = v12;
            }

            if(!v0.verticalRun.start.resolved || !v0.verticalRun.end.resolved) {
                v5 = v39;
                v6 = v40;
                v7_2 = v41;
                v8_3 = 0;
                v9_1 = 1;
                v15_1 = 8;
                v11_1 = 1;
            }
            else {
                v5 = v39;
                v1.addEquality(v5, v0.verticalRun.start.value);
                v6 = v40;
                v1.addEquality(v6, v0.verticalRun.end.value);
                v7_2 = v41;
                v1.addEquality(v7_2, v0.verticalRun.baseline.value);
                v2_1 = v0.mParent;
                if(v2_1 == null || (v19) || !v4_3) {
                    v8_3 = 0;
                    v9_1 = 1;
                label_480:
                    v15_1 = 8;
                }
                else {
                    v9_1 = 1;
                    if(v0.isTerminalWidget[1]) {
                        v8_3 = 0;
                        v15_1 = 8;
                        v1.addGreaterThan(v1.createObjectVariable(v2_1.mBottom), v6, 0, v15_1);
                    }
                    else {
                        v8_3 = 0;
                        goto label_480;
                    }
                }

                v11_1 = v8_3;
            }

            v12 = v0.mVerticalResolution == 2 ? v8_3 : v11_1;
            if(v12 != 0) {
                v11_1 = v0.mListDimensionBehaviors[v9_1] != DimensionBehaviour.WRAP_CONTENT || !(v0 instanceof ConstraintWidgetContainer) ? v8_3 : v9_1;
                v13_1 = v11_1 != 0 ? v8_3 : v27;
                if(v30) {
                    v2_2 = v0.mResolvedDimensionRatioSide;
                    if(v2_2 != v9_1 && v2_2 != -1) {
                        goto label_517;
                    }

                    v17 = ((boolean)v9_1);
                }
                else {
                label_517:
                    v17 = ((boolean)v8_3);
                }

                v2_1 = v0.mParent;
                v2 = v2_1 != null ? v1.createObjectVariable(v2_1.mBottom) : v29;
                ConstraintWidget v10_1 = v0.mParent;
                if(v10_1 != null) {
                    v29 = v1.createObjectVariable(v10_1.mTop);
                }

                if(v0.mBaselineDistance > 0 || v0.mVisibility == v15_1) {
                    v1.addEquality(v7_2, v5, v0.getBaselineDistance(), v15_1);
                    if(v0.mBaseline.mTarget != null) {
                        v1.addEquality(v7_2, v1.createObjectVariable(v0.mBaseline.mTarget), v8_3, v15_1);
                        if(v4_3) {
                            v1.addGreaterThan(v2, v1.createObjectVariable(v0.mBottom), v8_3, 5);
                        }

                        v26_1 = ((boolean)v8_3);
                    }
                    else {
                        if(v0.mVisibility != v15_1) {
                            goto label_551;
                        }

                        v1.addEquality(v7_2, v5, v8_3, v15_1);
                    }
                }

            label_551:
                v32 = v5;
                v40 = v6;
                v0.applyConstraints(arg43, false, v4_3, v3_1, v0.isTerminalWidget[v9_1], v29, v2, v0.mListDimensionBehaviors[v9_1], ((boolean)v11_1), v0.mTop, v0.mBottom, v0.mY, v13_1, v0.mMinHeight, v0.mMaxDimension[v9_1], v0.mVerticalBiasPercent, v17, v19, v18, v28, v22_1, v21_1, v0.mMatchConstraintMinHeight, v0.mMatchConstraintMaxHeight, v0.mMatchConstraintPercentHeight, v26_1);
            }
            else {
                v32 = v5;
                v40 = v6;
            }

            v7 = v0;
            if(v30) {
                int v0_1 = v7.mResolvedDimensionRatioSide;
                float v5_4 = v7.mResolvedDimensionRatio;
                int v6_1 = 8;
                if(v0_1 == 1) {
                    arg43.addRatio(v40, v32, v33, v38, v5_4, v6_1);
                    goto label_615;
                }
                else {
                    arg43.addRatio(v33, v38, v40, v32, v5_4, v6_1);
                    v1 = arg43;
                }
            }
            else {
            label_615:
                v1 = arg43;
            }

            if(!v7.mCenter.isConnected()) {
                return;
            }

            v1.addCenterPoint(v7, v7.mCenter.getTarget().getOwner(), ((float)Math.toRadians(((double)(v7.mCircleConstraintAngle + 90f)))), v7.mCenter.getMargin());
        }
        else {
            if(LinearSystem.sMetrics != null) {
                LinearSystem.sMetrics.graphSolved += v8;
            }

            v1.addEquality(v2, v0.horizontalRun.start.value);
            v1.addEquality(v3, v0.horizontalRun.end.value);
            v1.addEquality(v4, v0.verticalRun.start.value);
            v1.addEquality(v5, v0.verticalRun.end.value);
            v1.addEquality(v6, v0.verticalRun.baseline.value);
            v2_1 = v0.mParent;
            if(v2_1 == null) {
                return;
            }

            v2_2 = v2_1 == null || v2_1.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT ? 0 : 1;
            v4_1 = v0.mParent;
            int v4_2 = v4_1 == null || v4_1.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT ? 0 : 1;
            if(v2_2 != 0 && (v0.isTerminalWidget[0]) && !v0.isInHorizontalChain()) {
                v1.addGreaterThan(v1.createObjectVariable(v0.mParent.mRight), v3, 0, v10);
            }

            if(v4_2 == 0) {
                return;
            }

            if(!v0.isTerminalWidget[1]) {
                return;
            }

            if(v0.isInVerticalChain()) {
                return;
            }

            v1.addGreaterThan(v1.createObjectVariable(v0.mParent.mBottom), v5, 0, v10);
            return;
        }
    }

    public boolean allowedInBarrier() {
        if(this.mVisibility != 8) {
            return 1;
        }

        return 0;
    }

    private void applyConstraints(LinearSystem arg29, boolean arg30, boolean arg31, boolean arg32, boolean arg33, SolverVariable arg34, SolverVariable arg35, DimensionBehaviour arg36, boolean arg37, ConstraintAnchor arg38, ConstraintAnchor arg39, int arg40, int arg41, int arg42, int arg43, float arg44, boolean arg45, boolean arg46, boolean arg47, boolean arg48, int arg49, int arg50, int arg51, int arg52, float arg53, boolean arg54) {
        int v21;
        int v0_1;
        ConstraintWidget v15_1;
        SolverVariable v3_2;
        ConstraintWidget v12_3;
        ConstraintWidget v14_1;
        SolverVariable v2_2;
        int v27;
        int v26;
        int v1_1;
        int v25;
        int v19_1;
        int v17_1;
        int v13_1;
        SolverVariable v11_2;
        int v37_1;
        SolverVariable v4_1;
        int v23_1;
        boolean v18_1;
        SolverVariable v12_2;
        int v24;
        SolverVariable v5_1;
        int v8_1;
        SolverVariable v23;
        int v12_1;
        int v9_1;
        ConstraintWidget v0 = this;
        LinearSystem v1 = arg29;
        SolverVariable v10 = arg34;
        ConstraintAnchor v13 = arg39;
        int v14 = arg42;
        int v2 = arg43;
        int v4 = arg51;
        int v5 = arg52;
        SolverVariable v6 = v1.createObjectVariable(arg38);
        SolverVariable v7 = v1.createObjectVariable(v13);
        SolverVariable v15 = v1.createObjectVariable(arg38.getTarget());
        SolverVariable v8 = v1.createObjectVariable(v13.getTarget());
        if(LinearSystem.getMetrics() != null) {
            Metrics v9 = LinearSystem.getMetrics();
            ++v9.nonresolvedWidgets;
        }

        boolean v11 = arg38.isConnected();
        boolean v12 = v13.isConnected();
        boolean v16 = v0.mCenter.isConnected();
        if(v12) {
            v9_1 = (((int)v11)) + 1;
        }
        else {
            boolean v9_2 = v11;
        }

        if(v16) {
            ++v9_1;
        }

        boolean v17 = v11;
        int v18 = arg45 ? 3 : arg49;
        int v11_1 = androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[arg36.ordinal()];
        boolean v19 = v12;
        if(v11_1 == 1 || v11_1 == 2 || v11_1 == 3) {
        label_49:
            v11_1 = v18;
        label_50:
            v18 = 0;
        }
        else {
            v12_1 = 4;
            if(v11_1 == v12_1) {
                v11_1 = v18;
                if(v11_1 == v12_1) {
                    goto label_50;
                }
                else {
                    v18 = 1;
                }
            }
            else {
                goto label_49;
            }
        }

        int v3 = 8;
        if(v0.mVisibility == v3) {
            v12_1 = 0;
            v18 = 0;
        }
        else {
            v12_1 = arg41;
        }

        if(arg54) {
            if(!v17 && !v19 && !v16) {
                v1.addEquality(v6, arg40);
            }
            else if((v17) && !v19) {
                v23 = v8;
                v8_1 = 8;
                v1.addEquality(v6, v15, arg38.getMargin(), v8_1);
                goto label_82;
            }

            v23 = v8;
            v8_1 = 8;
        }
        else {
            v23 = v8;
            v8_1 = v3;
        }

    label_82:
        if(v18 == 0) {
            if(arg37) {
                v1.addEquality(v7, v6, 0, 3);
                v8_1 = 8;
                if(v14 > 0) {
                    v1.addGreaterThan(v7, v6, v14, v8_1);
                }

                if(v2 >= 0x7FFFFFFF) {
                    goto label_95;
                }

                v1.addLowerThan(v7, v6, v2, v8_1);
            }
            else {
                v1.addEquality(v7, v6, v12_1, v8_1);
            }

        label_95:
            v3 = v5;
            v5_1 = v7;
            v2 = v9_1;
            v24 = v18;
            v12_2 = v23;
            v18_1 = arg33;
            goto label_101;
        }
        else {
            if(v9_1 != 2 && !arg45 && (v11_1 == 1 || v11_1 == 0)) {
                v2 = Math.max(v4, v12_1);
                if(v5 > 0) {
                    v2 = Math.min(v5, v2);
                }

                v1.addEquality(v7, v6, v2, 8);
                v18_1 = arg33;
                v3 = v5;
                v5_1 = v7;
                v2 = v9_1;
                v12_2 = v23;
                v24 = 0;
            label_101:
                v23_1 = v4;
                goto label_214;
            }

            v2 = -2;
            v3 = v4 == v2 ? v12_1 : v4;
            v2 = v5 == v2 ? v12_1 : v5;
            if(v12_1 > 0 && v11_1 != 1) {
                v12_1 = 0;
            }

            v8_1 = 8;
            if(v3 > 0) {
                v1.addGreaterThan(v7, v6, v3, v8_1);
                v12_1 = Math.max(v12_1, v3);
            }

            if(v2 > 0) {
                if(!arg31 || v11_1 != 1) {
                    v1.addLowerThan(v7, v6, v2, v8_1);
                }
                else {
                }

                v12_1 = Math.min(v12_1, v2);
            }

            if(v11_1 == 1) {
                if(arg31) {
                    v1.addEquality(v7, v6, v12_1, v8_1);
                }
                else if(arg46) {
                    v1.addEquality(v7, v6, v12_1, 5);
                    v1.addLowerThan(v7, v6, v12_1, v8_1);
                }
                else {
                    v1.addEquality(v7, v6, v12_1, 5);
                    v1.addLowerThan(v7, v6, v12_1, v8_1);
                }

                v5_1 = v7;
                v24 = v18;
                v12_2 = v23;
                v18_1 = arg33;
                v23_1 = v3;
                v3 = v2;
                v2 = v9_1;
                goto label_214;
            }

            if(v11_1 == 2) {
                if(arg38.getType() == Type.TOP || arg38.getType() == Type.BOTTOM) {
                    v4_1 = v1.createObjectVariable(v0.mParent.getAnchor(Type.TOP));
                    v5_1 = v1.createObjectVariable(v0.mParent.getAnchor(Type.BOTTOM));
                }
                else {
                    v4_1 = v1.createObjectVariable(v0.mParent.getAnchor(Type.LEFT));
                    v5_1 = v1.createObjectVariable(v0.mParent.getAnchor(Type.RIGHT));
                }

                SolverVariable v37 = v7;
                v7 = v5_1;
                v5_1 = v37;
                v37_1 = v2;
                v2 = v9_1;
                v12_2 = v23;
                v1.addConstraint(v1.createRow().createRowDimensionRatio(v5_1, v6, v7, v4_1, arg53));
                v18_1 = arg33;
                v23_1 = v3;
                v24 = 0;
            }
            else {
                v37_1 = v2;
                v5_1 = v7;
                v2 = v9_1;
                v12_2 = v23;
                v23_1 = v3;
                v24 = v18;
                v18_1 = true;
            }

            v3 = v37_1;
        }

    label_214:
        if(!arg54) {
            v11_2 = arg35;
            v13_1 = 8;
            v12_1 = 2;
        label_510:
            if(v2 >= v12_1) {
                return;
            }

            if(!arg31) {
                return;
            }

            if(!v18_1) {
                return;
            }

            v1.addGreaterThan(v6, v10, 0, v13_1);
            v8_1 = (arg30) || v0.mBaseline.mTarget == null ? 1 : 0;
            if((arg30) || v0.mBaseline.mTarget == null) {
                v12_1 = v8_1;
            }
            else {
                v0 = v0.mBaseline.mTarget.mOwner;
                if(v0.mDimensionRatio != 0f && v0.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && v0.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                    v12_1 = 1;
                    goto label_548;
                }

                v12_1 = 0;
            }

        label_548:
            if(v12_1 == 0) {
                return;
            }

            v1.addGreaterThan(v11_2, v5_1, 0, v13_1);
        }
        else if(arg46) {
            v11_2 = arg35;
            v12_1 = 2;
            v13_1 = 8;
            goto label_510;
        }
        else {
            if((v17) || (v19) || (v16)) {
                if(!v17 || (v19)) {
                    if(!v17 && (v19)) {
                        v1.addEquality(v5_1, v12_2, -v13.getMargin(), 8);
                        if(arg31) {
                            v1.addGreaterThan(v6, v10, 0, 5);
                        }
                        else {
                        }

                        goto label_493;
                    }

                    v4 = 5;
                    if(!v17) {
                        goto label_493;
                    }

                    if(!v19) {
                        goto label_493;
                    }

                    ConstraintAnchor v2_1 = arg38;
                    ConstraintWidget v7_1 = v2_1.mTarget.mOwner;
                    ConstraintWidget v8_2 = v13.mTarget.mOwner;
                    ConstraintWidget v9_3 = v0.getParent();
                    int v16_1 = 6;
                    if(v24 == 0) {
                        v1_1 = v16_1;
                        v3 = 1;
                        v4 = 1;
                    label_357:
                        v17_1 = 4;
                        v19_1 = 5;
                    label_359:
                        v25 = 0;
                    }
                    else if(v11_1 == 0) {
                        if(v3 != 0 || v23_1 != 0) {
                            v3 = v4;
                            v17_1 = v3;
                            v19_1 = 1;
                            v25 = 0;
                        }
                        else {
                            v3 = 8;
                            v17_1 = 8;
                            v19_1 = 0;
                            v25 = 1;
                        }

                        if(((v7_1 instanceof Barrier)) || ((v8_2 instanceof Barrier))) {
                            v1_1 = v16_1;
                            v4 = v19_1;
                            v17_1 = 4;
                        }
                        else {
                            v1_1 = v16_1;
                            v4 = v19_1;
                        }

                        v19_1 = v3;
                        v3 = 0;
                    }
                    else {
                        if(v11_1 == 1) {
                            v1_1 = v16_1;
                            v3 = 1;
                            v4 = 1;
                            v17_1 = 4;
                            v19_1 = 8;
                            goto label_359;
                        }

                        if(v11_1 == 3) {
                            if(v0.mResolvedDimensionRatioSide == -1) {
                                if(!arg47) {
                                    v1_1 = 8;
                                }
                                else if(arg31) {
                                    v1_1 = 5;
                                }
                                else {
                                    v1_1 = 4;
                                }

                                v3 = 1;
                                v4 = 1;
                                v17_1 = 5;
                                v19_1 = 8;
                            }
                            else {
                                if(arg45) {
                                    v1_1 = arg50;
                                    if(v1_1 == 2 || v1_1 == 1) {
                                        v1_1 = 5;
                                        v3 = 4;
                                    }
                                    else {
                                        v1_1 = 8;
                                        v3 = 5;
                                    }

                                    v19_1 = v1_1;
                                    v17_1 = v3;
                                    v1_1 = v16_1;
                                    v3 = 1;
                                    v4 = 1;
                                    goto label_299;
                                }

                                if(v3 > 0) {
                                    v1_1 = v16_1;
                                    v3 = 1;
                                    v4 = 1;
                                    v17_1 = 5;
                                }
                                else {
                                    if(v3 == 0 && v23_1 == 0) {
                                        if(!arg47) {
                                            v1_1 = v16_1;
                                            v3 = 1;
                                            v4 = 1;
                                            v17_1 = 8;
                                            goto label_348;
                                        }
                                        else {
                                            v1_1 = v7_1 == v9_3 || v8_2 == v9_3 ? 5 : 4;
                                            v19_1 = v1_1;
                                            v1_1 = v16_1;
                                            v3 = 1;
                                            v4 = 1;
                                            v17_1 = 4;
                                            goto label_299;
                                        }
                                    }

                                    v1_1 = v16_1;
                                    v3 = 1;
                                    v4 = 1;
                                    v17_1 = 4;
                                }

                            label_348:
                                v19_1 = 5;
                            }

                        label_299:
                            v25 = 1;
                            goto label_360;
                        }

                        v1_1 = v16_1;
                        v3 = 0;
                        v4 = 0;
                        goto label_357;
                    }

                label_360:
                    if(v3 == 0 || v15 != v12_2 || v7_1 == v9_3) {
                        v26 = v3;
                        v27 = 1;
                    }
                    else {
                        v26 = 0;
                        v27 = 0;
                    }

                    if(v4 != 0) {
                        v4 = 8;
                        if(v0.mVisibility == v4) {
                            v1_1 = 4;
                        }

                        int v22 = v4;
                        v4 = v2_1.getMargin();
                        ConstraintWidget v3_1 = v8_2;
                        v8_1 = v13.getMargin();
                        v2_2 = v6;
                        v14_1 = v9_3;
                        v6 = v12_2;
                        v13_1 = v22;
                        v9_1 = v1_1;
                        v12_3 = v3_1;
                        v3_2 = v15;
                        v1 = arg29;
                        v15_1 = v7_1;
                        v7 = v5_1;
                        v1.addCentering(v2_2, v3_2, v4, arg44, v6, v7, v8_1, v9_1);
                        v5_1 = v6;
                        v6 = v2_2;
                        v2_2 = v5_1;
                        v5_1 = v7;
                    }
                    else {
                        v1 = arg29;
                        v14_1 = v9_3;
                        v2_2 = v12_2;
                        v3_2 = v15;
                        v13_1 = 8;
                        v15_1 = v7_1;
                        v12_3 = v8_2;
                    }

                    if(v0.mVisibility == v13_1) {
                        return;
                    }

                    if(v26 != 0) {
                        if(!arg31 || v3_2 == v2_2 || v24 != 0) {
                        label_414:
                            v0_1 = v19_1;
                        }
                        else {
                            if(!(v15_1 instanceof Barrier) && !(v12_3 instanceof Barrier)) {
                                goto label_414;
                            }

                            v0_1 = v16_1;
                        }

                        v1.addGreaterThan(v6, v3_2, arg38.getMargin(), v0_1);
                        v1.addLowerThan(v5_1, v2_2, -arg39.getMargin(), v0_1);
                        v19_1 = v0_1;
                    }

                    if(!arg31 || !arg48 || ((v15_1 instanceof Barrier)) || ((v12_3 instanceof Barrier))) {
                        v0_1 = v17_1;
                        v4 = v19_1;
                        v21 = v27;
                    }
                    else {
                        v0_1 = v16_1;
                        v4 = v0_1;
                        v21 = 1;
                    }

                    if(v21 != 0) {
                        if(v25 != 0 && (!arg47 || (arg32))) {
                            if(v15_1 != v14_1) {
                                if(v12_3 == v14_1) {
                                }
                                else {
                                    v16_1 = v0_1;
                                }
                            }

                            if(((v15_1 instanceof Guideline)) || ((v12_3 instanceof Guideline))) {
                                v16_1 = 5;
                            }

                            if(((v15_1 instanceof Barrier)) || ((v12_3 instanceof Barrier))) {
                                v16_1 = 5;
                            }

                            int v7_2 = arg47 ? 5 : v16_1;
                            v0_1 = Math.max(v7_2, v0_1);
                        }

                        if(arg31) {
                            v0_1 = Math.min(v4, v0_1);
                            if(!arg45) {
                                goto label_465;
                            }
                            else if(!arg47) {
                                if(v15_1 != v14_1 && v12_3 != v14_1) {
                                    goto label_465;
                                }

                                v12_1 = 4;
                            }
                            else {
                                goto label_465;
                            }
                        }
                        else {
                        label_465:
                            v12_1 = v0_1;
                        }

                        v1.addEquality(v6, v3_2, arg38.getMargin(), v12_1);
                        v1.addEquality(v5_1, v2_2, -arg39.getMargin(), v12_1);
                    }

                    if(arg31) {
                        v0_1 = v10 == v3_2 ? arg38.getMargin() : 0;
                        if(v3_2 == v10) {
                            goto label_479;
                        }

                        v1.addGreaterThan(v6, v10, v0_1, 5);
                    }

                label_479:
                    if(!arg31) {
                        goto label_494;
                    }

                    if(v24 == 0) {
                        goto label_494;
                    }

                    if(arg42 != 0) {
                        goto label_494;
                    }

                    if(v23_1 != 0) {
                        goto label_494;
                    }

                    if(v24 != 0 && v11_1 == 3) {
                        v1.addGreaterThan(v5_1, v6, 0, v13_1);
                        goto label_494;
                    }

                    v1.addGreaterThan(v5_1, v6, 0, 5);
                    goto label_494;
                }

            label_493:
                v2_2 = v12_2;
            }
            else {
                goto label_493;
            }

        label_494:
            if(!arg31) {
                return;
            }

            if(!v18_1) {
                return;
            }

            v13 = arg39;
            v12_1 = v13.mTarget != null ? v13.getMargin() : 0;
            v11_2 = arg35;
            if(v2_2 == v11_2) {
                return;
            }

            v1.addGreaterThan(v11_2, v5_1, v12_1, 5);
            return;
        }
    }

    public void connect(Type arg2, ConstraintWidget arg3, Type arg4) {
        this.connect(arg2, arg3, arg4, 0);
    }

    public void connect(Type arg4, ConstraintWidget arg5, Type arg6, int arg7) {
        int v4_1;
        ConstraintAnchor v0;
        ConstraintAnchor v6;
        ConstraintAnchor v4;
        ConstraintAnchor v3;
        ConstraintAnchor v5;
        if(arg4 != Type.CENTER) {
            if(arg4 == Type.CENTER_X && (arg6 == Type.LEFT || arg6 == Type.RIGHT)) {
                v4 = this.getAnchor(Type.LEFT);
                v5 = arg5.getAnchor(arg6);
                v6 = this.getAnchor(Type.RIGHT);
                v4.connect(v5, 0);
                v6.connect(v5, 0);
                this.getAnchor(Type.CENTER_X).connect(v5, 0);
                return;
            }

            if(arg4 == Type.CENTER_Y && (arg6 == Type.TOP || arg6 == Type.BOTTOM)) {
                v4 = arg5.getAnchor(arg6);
                this.getAnchor(Type.TOP).connect(v4, 0);
                this.getAnchor(Type.BOTTOM).connect(v4, 0);
                this.getAnchor(Type.CENTER_Y).connect(v4, 0);
                return;
            }

            if(arg4 == Type.CENTER_X && arg6 == Type.CENTER_X) {
                this.getAnchor(Type.LEFT).connect(arg5.getAnchor(Type.LEFT), 0);
                this.getAnchor(Type.RIGHT).connect(arg5.getAnchor(Type.RIGHT), 0);
                this.getAnchor(Type.CENTER_X).connect(arg5.getAnchor(arg6), 0);
                return;
            }

            if(arg4 == Type.CENTER_Y && arg6 == Type.CENTER_Y) {
                this.getAnchor(Type.TOP).connect(arg5.getAnchor(Type.TOP), 0);
                this.getAnchor(Type.BOTTOM).connect(arg5.getAnchor(Type.BOTTOM), 0);
                this.getAnchor(Type.CENTER_Y).connect(arg5.getAnchor(arg6), 0);
                return;
            }

            v0 = this.getAnchor(arg4);
            v5 = arg5.getAnchor(arg6);
            if(!v0.isValidConnection(v5)) {
                return;
            }

            if(arg4 == Type.BASELINE) {
                v4 = this.getAnchor(Type.TOP);
                v3 = this.getAnchor(Type.BOTTOM);
                if(v4 != null) {
                    v4.reset();
                }

                if(v3 == null) {
                    goto label_220;
                }

                v3.reset();
            }
            else {
                if(arg4 != Type.TOP) {
                    if(arg4 == Type.BOTTOM) {
                    }
                    else {
                        if(arg4 != Type.LEFT && arg4 != Type.RIGHT) {
                            goto label_220;
                        }

                        v6 = this.getAnchor(Type.CENTER);
                        if(v6.getTarget() != v5) {
                            v6.reset();
                        }

                        v4 = this.getAnchor(arg4).getOpposite();
                        v3 = this.getAnchor(Type.CENTER_X);
                        if(!v3.isConnected()) {
                            goto label_220;
                        }

                        v4.reset();
                        v3.reset();
                        goto label_220;
                    }
                }

                v6 = this.getAnchor(Type.BASELINE);
                if(v6 != null) {
                    v6.reset();
                }

                v6 = this.getAnchor(Type.CENTER);
                if(v6.getTarget() != v5) {
                    v6.reset();
                }

                v4 = this.getAnchor(arg4).getOpposite();
                v3 = this.getAnchor(Type.CENTER_Y);
                if(!v3.isConnected()) {
                    goto label_220;
                }

                v4.reset();
                v3.reset();
            }

        label_220:
            v0.connect(v5, 0);
        }
        else if(arg6 == Type.CENTER) {
            v4 = this.getAnchor(Type.LEFT);
            v6 = this.getAnchor(Type.RIGHT);
            ConstraintAnchor v7 = this.getAnchor(Type.TOP);
            v0 = this.getAnchor(Type.BOTTOM);
            int v2 = 1;
            if(v4 == null || !v4.isConnected()) {
                if(v6 != null && (v6.isConnected())) {
                label_20:
                    v4_1 = 0;
                    goto label_29;
                }

                this.connect(Type.LEFT, arg5, Type.LEFT, 0);
                this.connect(Type.RIGHT, arg5, Type.RIGHT, 0);
                v4_1 = 1;
            }
            else {
                goto label_20;
            }

        label_29:
            if(v7 == null || !v7.isConnected()) {
                if(v0 != null && (v0.isConnected())) {
                label_35:
                    v2 = 0;
                    goto label_43;
                }

                this.connect(Type.TOP, arg5, Type.TOP, 0);
                this.connect(Type.BOTTOM, arg5, Type.BOTTOM, 0);
            }
            else {
                goto label_35;
            }

        label_43:
            if(v4_1 != 0 && v2 != 0) {
                this.getAnchor(Type.CENTER).connect(arg5.getAnchor(Type.CENTER), 0);
                return;
            }

            if(v4_1 != 0) {
                this.getAnchor(Type.CENTER_X).connect(arg5.getAnchor(Type.CENTER_X), 0);
                return;
            }

            if(v2 == 0) {
                return;
            }

            this.getAnchor(Type.CENTER_Y).connect(arg5.getAnchor(Type.CENTER_Y), 0);
            return;
        }
        else {
            if(arg6 != Type.LEFT) {
                if(arg6 == Type.RIGHT) {
                }
                else {
                    if(arg6 != Type.TOP && arg6 != Type.BOTTOM) {
                        return;
                    }

                    this.connect(Type.TOP, arg5, arg6, 0);
                    this.connect(Type.BOTTOM, arg5, arg6, 0);
                    this.getAnchor(Type.CENTER).connect(arg5.getAnchor(arg6), 0);
                    return;
                }
            }

            this.connect(Type.LEFT, arg5, arg6, 0);
            this.connect(Type.RIGHT, arg5, arg6, 0);
            this.getAnchor(Type.CENTER).connect(arg5.getAnchor(arg6), 0);
            return;
        }
    }

    public void connect(ConstraintAnchor arg2, ConstraintAnchor arg3, int arg4) {
        if(arg2.getOwner() == this) {
            this.connect(arg2.getType(), arg3.getOwner(), arg3.getType(), arg4);
        }
    }

    public void connectCircularConstraint(ConstraintWidget arg7, float arg8, int arg9) {
        this.immediateConnect(Type.CENTER, arg7, Type.CENTER, arg9, 0);
        this.mCircleConstraintAngle = arg8;
    }

    public void copy(ConstraintWidget arg7, HashMap arg8) {
        Object v0_2;
        ConstraintWidget v0_1;
        this.mHorizontalResolution = arg7.mHorizontalResolution;
        this.mVerticalResolution = arg7.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = arg7.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = arg7.mMatchConstraintDefaultHeight;
        int[] v0 = this.mResolvedMatchConstraintDefault;
        int[] v1 = arg7.mResolvedMatchConstraintDefault;
        v0[0] = v1[0];
        v0[1] = v1[1];
        this.mMatchConstraintMinWidth = arg7.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = arg7.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = arg7.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = arg7.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = arg7.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = arg7.mIsWidthWrapContent;
        this.mIsHeightWrapContent = arg7.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = arg7.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = arg7.mResolvedDimensionRatio;
        this.mMaxDimension = Arrays.copyOf(arg7.mMaxDimension, arg7.mMaxDimension.length);
        this.mCircleConstraintAngle = arg7.mCircleConstraintAngle;
        this.hasBaseline = arg7.hasBaseline;
        this.inPlaceholder = arg7.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget v1_1 = null;
        if(this.mParent == null) {
            v0_1 = v1_1;
        }
        else {
            v0_2 = arg8.get(arg7.mParent);
        }

        this.mParent = v0_1;
        this.mWidth = arg7.mWidth;
        this.mHeight = arg7.mHeight;
        this.mDimensionRatio = arg7.mDimensionRatio;
        this.mDimensionRatioSide = arg7.mDimensionRatioSide;
        this.mX = arg7.mX;
        this.mY = arg7.mY;
        this.mRelX = arg7.mRelX;
        this.mRelY = arg7.mRelY;
        this.mOffsetX = arg7.mOffsetX;
        this.mOffsetY = arg7.mOffsetY;
        this.mBaselineDistance = arg7.mBaselineDistance;
        this.mMinWidth = arg7.mMinWidth;
        this.mMinHeight = arg7.mMinHeight;
        this.mHorizontalBiasPercent = arg7.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = arg7.mVerticalBiasPercent;
        this.mCompanionWidget = arg7.mCompanionWidget;
        this.mContainerItemSkip = arg7.mContainerItemSkip;
        this.mVisibility = arg7.mVisibility;
        this.mDebugName = arg7.mDebugName;
        this.mType = arg7.mType;
        this.mDistToTop = arg7.mDistToTop;
        this.mDistToLeft = arg7.mDistToLeft;
        this.mDistToRight = arg7.mDistToRight;
        this.mDistToBottom = arg7.mDistToBottom;
        this.mLeftHasCentered = arg7.mLeftHasCentered;
        this.mRightHasCentered = arg7.mRightHasCentered;
        this.mTopHasCentered = arg7.mTopHasCentered;
        this.mBottomHasCentered = arg7.mBottomHasCentered;
        this.mHorizontalWrapVisited = arg7.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = arg7.mVerticalWrapVisited;
        this.mOptimizerMeasurable = arg7.mOptimizerMeasurable;
        this.mGroupsToSolver = arg7.mGroupsToSolver;
        this.mHorizontalChainStyle = arg7.mHorizontalChainStyle;
        this.mVerticalChainStyle = arg7.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = arg7.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = arg7.mVerticalChainFixedPosition;
        float[] v0_3 = this.mWeight;
        float[] v4 = arg7.mWeight;
        v0_3[0] = v4[0];
        v0_3[1] = v4[1];
        ConstraintWidget[] v0_4 = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] v4_1 = arg7.mListNextMatchConstraintsWidget;
        v0_4[0] = v4_1[0];
        v0_4[1] = v4_1[1];
        v0_4 = this.mNextChainWidget;
        v4_1 = arg7.mNextChainWidget;
        v0_4[0] = v4_1[0];
        v0_4[1] = v4_1[1];
        v0_1 = arg7.mHorizontalNextWidget;
        if(v0_1 == null) {
            v0_1 = v1_1;
        }
        else {
            v0_2 = arg8.get(v0_1);
        }

        this.mHorizontalNextWidget = v0_1;
        arg7 = arg7.mVerticalNextWidget;
        if(arg7 == null) {
        }
        else {
            Object v1_2 = arg8.get(arg7);
        }

        this.mVerticalNextWidget = v1_1;
    }

    public void createObjectVariables(LinearSystem arg2) {
        arg2.createObjectVariable(this.mLeft);
        arg2.createObjectVariable(this.mTop);
        arg2.createObjectVariable(this.mRight);
        arg2.createObjectVariable(this.mBottom);
        if(this.mBaselineDistance > 0) {
            arg2.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(Type arg3) {
        switch(androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[arg3.ordinal()]) {
            case 1: {
                goto label_24;
            }
            case 2: {
                goto label_22;
            }
            case 3: {
                goto label_20;
            }
            case 4: {
                goto label_18;
            }
            case 5: {
                goto label_16;
            }
            case 6: {
                goto label_14;
            }
            case 7: {
                goto label_12;
            }
            case 8: {
                goto label_10;
            }
            case 9: {
                return null;
            }
        }

        throw new AssertionError(arg3.name());
    label_18:
        return this.mBottom;
    label_20:
        return this.mRight;
    label_22:
        return this.mTop;
    label_24:
        return this.mLeft;
    label_10:
        return this.mCenterY;
    label_12:
        return this.mCenterX;
    label_14:
        return this.mCenter;
    label_16:
        return this.mBaseline;
    }

    public ArrayList getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int arg2) {
        if(arg2 == 0) {
            return this.mHorizontalBiasPercent;
        }

        if(arg2 == 1) {
            return this.mVerticalBiasPercent;
        }

        return -1f;
    }

    public int getBottom() {
        return this.getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int arg2) {
        if(arg2 == 0) {
            return this.getHorizontalDimensionBehaviour();
        }

        if(arg2 == 1) {
            return this.getVerticalDimensionBehaviour();
        }

        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if(this.mVisibility == 8) {
            return 0;
        }

        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget v1 = null;
        if(this.isInHorizontalChain()) {
            ConstraintWidget v2 = this;
            ConstraintWidget v0 = v1;
            while(v0 == null) {
                if(v2 == null) {
                    return v0;
                }

                ConstraintAnchor v3 = v2.getAnchor(Type.LEFT);
                v3 = v3 == null ? ((ConstraintAnchor)v1) : v3.getTarget();
                ConstraintWidget v3_1 = v3 == null ? v1 : v3.getOwner();
                if(v3_1 == this.getParent()) {
                    return v2;
                }

                ConstraintAnchor v4 = v3_1 == null ? ((ConstraintAnchor)v1) : v3_1.getAnchor(Type.RIGHT).getTarget();
                if(v4 != null && v4.getOwner() != v2) {
                    v0 = v2;
                    continue;
                }

                v2 = v3_1;
            }

            return v0;
        }

        return v1;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor v0 = this.mLeft;
        int v0_1 = v0 != null ? v0.mMargin : 0;
        ConstraintAnchor v1 = this.mRight;
        if(v1 != null) {
            v0_1 += v1.mMargin;
        }

        return v0_1;
    }

    public int getLeft() {
        return this.getX();
    }

    public int getLength(int arg2) {
        if(arg2 == 0) {
            return this.getWidth();
        }

        if(arg2 == 1) {
            return this.getHeight();
        }

        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int arg2) {
        ConstraintAnchor v1;
        ConstraintAnchor v2;
        if(arg2 == 0) {
            if(this.mRight.mTarget != null) {
                v2 = this.mRight.mTarget.mTarget;
                v1 = this.mRight;
                if(v2 == v1) {
                    return v1.mTarget.mOwner;
                }
            }
        }
        else if(arg2 == 1 && this.mBottom.mTarget != null) {
            v2 = this.mBottom.mTarget.mTarget;
            v1 = this.mBottom;
            if(v2 == v1) {
                return v1.mTarget.mOwner;
            }
        }

        return null;
    }

    public int getOptimizerWrapHeight() {
        int v0 = this.mHeight;
        if(this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            int v1 = this.mMatchConstraintDefaultHeight;
            int v3 = this.mMatchConstraintMinHeight;
            if(v1 == 1) {
                v3 = Math.max(v3, v0);
            }
            else if(v3 > 0) {
                this.mHeight = v3;
            }
            else {
                v3 = 0;
            }

            int v4 = this.mMatchConstraintMaxHeight;
            if(v4 > 0 && v4 < v3) {
                return v4;
            }

            return v3;
        }

        return v0;
    }

    public int getOptimizerWrapWidth() {
        int v0 = this.mWidth;
        int v2 = 0;
        if(this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            int v1 = this.mMatchConstraintDefaultWidth;
            int v3 = this.mMatchConstraintMinWidth;
            if(v1 == 1) {
                v2 = Math.max(v3, v0);
            }
            else if(v3 > 0) {
                this.mWidth = v3;
                v2 = v3;
            }

            int v5 = this.mMatchConstraintMaxWidth;
            if(v5 > 0 && v5 < v2) {
                return v5;
            }

            return v2;
        }

        return v0;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int arg2) {
        ConstraintAnchor v1;
        ConstraintAnchor v2;
        if(arg2 == 0) {
            if(this.mLeft.mTarget != null) {
                v2 = this.mLeft.mTarget.mTarget;
                v1 = this.mLeft;
                if(v2 == v1) {
                    return v1.mTarget.mOwner;
                }
            }
        }
        else if(arg2 == 1 && this.mTop.mTarget != null) {
            v2 = this.mTop.mTarget.mTarget;
            v1 = this.mTop;
            if(v2 == v1) {
                return v1.mTarget.mOwner;
            }
        }

        return null;
    }

    int getRelativePositioning(int arg2) {
        if(arg2 == 0) {
            return this.mRelX;
        }

        if(arg2 == 1) {
            return this.mRelY;
        }

        return 0;
    }

    public int getRight() {
        return this.getX() + this.mWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int arg2) {
        if(arg2 == 0) {
            return this.horizontalRun;
        }

        if(arg2 == 1) {
            return this.verticalRun;
        }

        return null;
    }

    public int getTop() {
        return this.getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget v1 = null;
        if(this.isInVerticalChain()) {
            ConstraintWidget v2 = this;
            ConstraintWidget v0 = v1;
            while(v0 == null) {
                if(v2 == null) {
                    return v0;
                }

                ConstraintAnchor v3 = v2.getAnchor(Type.TOP);
                v3 = v3 == null ? ((ConstraintAnchor)v1) : v3.getTarget();
                ConstraintWidget v3_1 = v3 == null ? v1 : v3.getOwner();
                if(v3_1 == this.getParent()) {
                    return v2;
                }

                ConstraintAnchor v4 = v3_1 == null ? ((ConstraintAnchor)v1) : v3_1.getAnchor(Type.BOTTOM).getTarget();
                if(v4 != null && v4.getOwner() != v2) {
                    v0 = v2;
                    continue;
                }

                v2 = v3_1;
            }

            return v0;
        }

        return v1;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int v0 = this.mLeft != null ? this.mTop.mMargin : 0;
        if(this.mRight != null) {
            v0 += this.mBottom.mMargin;
        }

        return v0;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if(this.mVisibility == 8) {
            return 0;
        }

        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget v0 = this.mParent;
        if(v0 != null && ((v0 instanceof ConstraintWidgetContainer))) {
            return ((ConstraintWidgetContainer)v0).mPaddingLeft + this.mX;
        }

        return this.mX;
    }

    public int getY() {
        ConstraintWidget v0 = this.mParent;
        if(v0 != null && ((v0 instanceof ConstraintWidgetContainer))) {
            return ((ConstraintWidgetContainer)v0).mPaddingTop + this.mY;
        }

        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public void immediateConnect(Type arg1, ConstraintWidget arg2, Type arg3, int arg4, int arg5) {
        this.getAnchor(arg1).connect(arg2.getAnchor(arg3), arg4, arg5, true);
    }

    private boolean isChainHead(int arg4) {
        arg4 *= 2;
        if(this.mListAnchors[arg4].mTarget != null) {
            ConstraintAnchor v0 = this.mListAnchors[arg4].mTarget.mTarget;
            ConstraintAnchor[] v1 = this.mListAnchors;
            if(v0 != v1[arg4]) {
                ++arg4;
                if(v1[arg4].mTarget != null && this.mListAnchors[arg4].mTarget.mTarget == this.mListAnchors[arg4]) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        if(this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft || this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight) {
            return 1;
        }

        return 0;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        if(this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop || this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom) {
            return 1;
        }

        return 0;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isRoot() {
        if(this.mParent == null) {
            return 1;
        }

        return 0;
    }

    public boolean isSpreadHeight() {
        if(this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return 1;
        }

        return 0;
    }

    public boolean isSpreadWidth() {
        if(this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return 1;
        }

        return 0;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float v3 = ConstraintWidget.DEFAULT_BIAS;
        this.mHorizontalBiasPercent = v3;
        this.mVerticalBiasPercent = v3;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] v0 = this.mWeight;
        v0[0] = -1f;
        v0[1] = -1f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] v0_1 = this.mMaxDimension;
        v0_1[0] = 0x7FFFFFFF;
        v0_1[1] = 0x7FFFFFFF;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1f;
        this.mMatchConstraintPercentHeight = 1f;
        this.mMatchConstraintMaxWidth = 0x7FFFFFFF;
        this.mMatchConstraintMaxHeight = 0x7FFFFFFF;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] v0_2 = this.isTerminalWidget;
        v0_2[0] = true;
        v0_2[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] v6 = this.mIsInBarrier;
        v6[0] = false;
        v6[1] = false;
    }

    public void resetAllConstraints() {
        this.resetAnchors();
        this.setVerticalBiasPercent(ConstraintWidget.DEFAULT_BIAS);
        this.setHorizontalBiasPercent(ConstraintWidget.DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor arg9) {
        if(this.getParent() != null && ((this.getParent() instanceof ConstraintWidgetContainer)) && (this.getParent().handlesInternalConstraints())) {
            return;
        }

        ConstraintAnchor v0 = this.getAnchor(Type.LEFT);
        ConstraintAnchor v1 = this.getAnchor(Type.RIGHT);
        ConstraintAnchor v2 = this.getAnchor(Type.TOP);
        ConstraintAnchor v3 = this.getAnchor(Type.BOTTOM);
        ConstraintAnchor v4 = this.getAnchor(Type.CENTER);
        ConstraintAnchor v5 = this.getAnchor(Type.CENTER_X);
        ConstraintAnchor v6 = this.getAnchor(Type.CENTER_Y);
        float v7 = 0.5f;
        if(arg9 == v4) {
            if((v0.isConnected()) && (v1.isConnected()) && v0.getTarget() == v1.getTarget()) {
                v0.reset();
                v1.reset();
            }

            if((v2.isConnected()) && (v3.isConnected()) && v2.getTarget() == v3.getTarget()) {
                v2.reset();
                v3.reset();
            }

            this.mHorizontalBiasPercent = v7;
            this.mVerticalBiasPercent = v7;
        }
        else {
            if(arg9 == v5) {
                if((v0.isConnected()) && (v1.isConnected()) && v0.getTarget().getOwner() == v1.getTarget().getOwner()) {
                    v0.reset();
                    v1.reset();
                }

                this.mHorizontalBiasPercent = v7;
                goto label_92;
            }

            if(arg9 == v6) {
                if((v2.isConnected()) && (v3.isConnected()) && v2.getTarget().getOwner() == v3.getTarget().getOwner()) {
                    v2.reset();
                    v3.reset();
                }

                this.mVerticalBiasPercent = v7;
                goto label_92;
            }

            if(arg9 != v0) {
                if(arg9 == v1) {
                }
                else {
                    if(arg9 != v2 && arg9 != v3) {
                        goto label_92;
                    }

                    if(!v2.isConnected()) {
                        goto label_92;
                    }

                    if(v2.getTarget() != v3.getTarget()) {
                        goto label_92;
                    }

                    v4.reset();
                    goto label_92;
                }
            }

            if(!v0.isConnected()) {
                goto label_92;
            }

            if(v0.getTarget() != v1.getTarget()) {
                goto label_92;
            }

            v4.reset();
        }

    label_92:
        arg9.reset();
    }

    public void resetAnchors() {
        ConstraintWidget v0 = this.getParent();
        if(v0 == null || !(v0 instanceof ConstraintWidgetContainer) || !this.getParent().handlesInternalConstraints()) {
            int v0_1 = this.mAnchors.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                this.mAnchors.get(v1).reset();
            }
        }
        else {
        }
    }

    public void resetSolverVariables(Cache arg2) {
        this.mLeft.resetSolverVariable(arg2);
        this.mTop.resetSolverVariable(arg2);
        this.mRight.resetSolverVariable(arg2);
        this.mBottom.resetSolverVariable(arg2);
        this.mBaseline.resetSolverVariable(arg2);
        this.mCenter.resetSolverVariable(arg2);
        this.mCenterX.resetSolverVariable(arg2);
        this.mCenterY.resetSolverVariable(arg2);
    }

    public void setBaselineDistance(int arg1) {
        this.mBaselineDistance = arg1;
        boolean v1 = arg1 > 0 ? true : false;
        this.hasBaseline = v1;
    }

    public void setCompanionWidget(Object arg1) {
        this.mCompanionWidget = arg1;
    }

    public void setContainerItemSkip(int arg1) {
        if(arg1 >= 0) {
            this.mContainerItemSkip = arg1;
            return;
        }

        this.mContainerItemSkip = 0;
    }

    public void setDebugName(String arg1) {
        this.mDebugName = arg1;
    }

    public void setDebugSolverName(LinearSystem arg7, String arg8) {
        this.mDebugName = arg8;
        SolverVariable v0 = arg7.createObjectVariable(this.mLeft);
        SolverVariable v1 = arg7.createObjectVariable(this.mTop);
        SolverVariable v2 = arg7.createObjectVariable(this.mRight);
        SolverVariable v3 = arg7.createObjectVariable(this.mBottom);
        v0.setName(arg8 + ".left");
        v1.setName(arg8 + ".top");
        v2.setName(arg8 + ".right");
        v3.setName(arg8 + ".bottom");
        if(this.mBaselineDistance > 0) {
            arg7.createObjectVariable(this.mBaseline).setName(arg8 + ".baseline");
        }
    }

    public void setDimension(int arg2, int arg3) {
        this.mWidth = arg2;
        int v0 = this.mMinWidth;
        if(arg2 < v0) {
            this.mWidth = v0;
        }

        this.mHeight = arg3;
        arg2 = this.mMinHeight;
        if(arg3 < arg2) {
            this.mHeight = arg2;
        }
    }

    public void setDimensionRatio(String arg9) {
        float v9;
        if(arg9 != null) {
            if(arg9.length() == 0) {
            }
            else {
                int v1 = arg9.length();
                int v2 = arg9.indexOf(44);
                int v3 = 0;
                int v5 = -1;
                if(v2 > 0 && v2 < v1 - 1) {
                    String v6 = arg9.substring(0, v2);
                    if(v6.equalsIgnoreCase("W")) {
                    }
                    else if(v6.equalsIgnoreCase("H")) {
                        v3 = 1;
                    }
                    else {
                        v3 = v5;
                    }

                    v5 = v3;
                    v3 = v2 + 1;
                }

                v2 = arg9.indexOf(58);
                if(v2 < 0 || v2 >= v1 - 1) {
                    arg9 = arg9.substring(v3);
                    if(arg9.length() > 0) {
                        try {
                            v9 = Float.parseFloat(arg9);
                        }
                        catch(NumberFormatException ) {
                        label_56:
                            v9 = 0f;
                        }
                    }
                    else {
                        goto label_56;
                    }
                }
                else {
                    String v1_1 = arg9.substring(v3, v2);
                    arg9 = arg9.substring(v2 + 1);
                    if(v1_1.length() <= 0) {
                        goto label_56;
                    }
                    else if(arg9.length() > 0) {
                        try {
                            float v1_2 = Float.parseFloat(v1_1);
                            v9 = Float.parseFloat(arg9);
                            if(v1_2 <= 0f) {
                                goto label_56;
                            }
                            else if(v9 <= 0f) {
                                goto label_56;
                            }
                            else if(v5 == 1) {
                                v9 = Math.abs(v9 / v1_2);
                            }
                            else {
                                v9 = Math.abs(v1_2 / v9);
                            }
                        }
                        catch(NumberFormatException ) {
                            goto label_56;
                        }
                    }
                    else {
                        goto label_56;
                    }
                }

                if(v9 > 0f) {
                    this.mDimensionRatio = v9;
                    this.mDimensionRatioSide = v5;
                }

                return;
            }
        }

        this.mDimensionRatio = 0f;
    }

    public void setDimensionRatio(float arg1, int arg2) {
        this.mDimensionRatio = arg1;
        this.mDimensionRatioSide = arg2;
    }

    public void setFrame(int arg2, int arg3, int arg4) {
        if(arg4 == 0) {
            this.setHorizontalDimension(arg2, arg3);
            return;
        }

        if(arg4 == 1) {
            this.setVerticalDimension(arg2, arg3);
        }
    }

    public void setFrame(int arg2, int arg3, int arg4, int arg5) {
        arg4 -= arg2;
        arg5 -= arg3;
        this.mX = arg2;
        this.mY = arg3;
        if(this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }

        if(this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
            arg2 = this.mWidth;
            if(arg4 < arg2) {
                arg4 = arg2;
            }
        }

        if(this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
            arg2 = this.mHeight;
            if(arg5 < arg2) {
                arg5 = arg2;
            }
        }

        this.mWidth = arg4;
        this.mHeight = arg5;
        arg2 = this.mMinHeight;
        if(arg5 < arg2) {
            this.mHeight = arg2;
        }

        arg2 = this.mMinWidth;
        if(arg4 < arg2) {
            this.mWidth = arg2;
        }
    }

    public void setGoneMargin(Type arg2, int arg3) {
        int v2 = androidx.constraintlayout.solver.widgets.ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 != 3) {
                    if(v2 != 4) {
                        return;
                    }

                    this.mBottom.mGoneMargin = arg3;
                    return;
                }

                this.mRight.mGoneMargin = arg3;
                return;
            }

            this.mTop.mGoneMargin = arg3;
            return;
        }

        this.mLeft.mGoneMargin = arg3;
    }

    public void setHasBaseline(boolean arg1) {
        this.hasBaseline = arg1;
    }

    public void setHeight(int arg2) {
        this.mHeight = arg2;
        int v0 = this.mMinHeight;
        if(arg2 < v0) {
            this.mHeight = v0;
        }
    }

    public void setHeightWrapContent(boolean arg1) {
        this.mIsHeightWrapContent = arg1;
    }

    public void setHorizontalBiasPercent(float arg1) {
        this.mHorizontalBiasPercent = arg1;
    }

    public void setHorizontalChainStyle(int arg1) {
        this.mHorizontalChainStyle = arg1;
    }

    public void setHorizontalDimension(int arg1, int arg2) {
        this.mX = arg1;
        arg2 -= arg1;
        this.mWidth = arg2;
        arg1 = this.mMinWidth;
        if(arg2 < arg1) {
            this.mWidth = arg1;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour arg2) {
        this.mListDimensionBehaviors[0] = arg2;
    }

    public void setHorizontalMatchStyle(int arg1, int arg2, int arg3, float arg4) {
        this.mMatchConstraintDefaultWidth = arg1;
        this.mMatchConstraintMinWidth = arg2;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = arg4;
        if(arg4 > 0f && arg4 < 1f && arg1 == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float arg2) {
        this.mWeight[0] = arg2;
    }

    protected void setInBarrier(int arg1, boolean arg2) {
        this.mIsInBarrier[arg1] = arg2;
    }

    public void setInPlaceholder(boolean arg1) {
        this.inPlaceholder = arg1;
    }

    public void setInVirtualLayout(boolean arg1) {
        this.mInVirtuaLayout = arg1;
    }

    public void setLength(int arg2, int arg3) {
        if(arg3 == 0) {
            this.setWidth(arg2);
            return;
        }

        if(arg3 == 1) {
            this.setHeight(arg2);
        }
    }

    public void setMaxHeight(int arg2) {
        this.mMaxDimension[1] = arg2;
    }

    public void setMaxWidth(int arg2) {
        this.mMaxDimension[0] = arg2;
    }

    public void setMinHeight(int arg1) {
        if(arg1 < 0) {
            this.mMinHeight = 0;
            return;
        }

        this.mMinHeight = arg1;
    }

    public void setMinWidth(int arg1) {
        if(arg1 < 0) {
            this.mMinWidth = 0;
            return;
        }

        this.mMinWidth = arg1;
    }

    public void setOffset(int arg1, int arg2) {
        this.mOffsetX = arg1;
        this.mOffsetY = arg2;
    }

    public void setOrigin(int arg1, int arg2) {
        this.mX = arg1;
        this.mY = arg2;
    }

    public void setParent(ConstraintWidget arg1) {
        this.mParent = arg1;
    }

    void setRelativePositioning(int arg2, int arg3) {
        if(arg3 == 0) {
            this.mRelX = arg2;
            return;
        }

        if(arg3 == 1) {
            this.mRelY = arg2;
        }
    }

    public void setType(String arg1) {
        this.mType = arg1;
    }

    public void setVerticalBiasPercent(float arg1) {
        this.mVerticalBiasPercent = arg1;
    }

    public void setVerticalChainStyle(int arg1) {
        this.mVerticalChainStyle = arg1;
    }

    public void setVerticalDimension(int arg1, int arg2) {
        this.mY = arg1;
        arg2 -= arg1;
        this.mHeight = arg2;
        arg1 = this.mMinHeight;
        if(arg2 < arg1) {
            this.mHeight = arg1;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour arg2) {
        this.mListDimensionBehaviors[1] = arg2;
    }

    public void setVerticalMatchStyle(int arg1, int arg2, int arg3, float arg4) {
        this.mMatchConstraintDefaultHeight = arg1;
        this.mMatchConstraintMinHeight = arg2;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = arg4;
        if(arg4 > 0f && arg4 < 1f && arg1 == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float arg2) {
        this.mWeight[1] = arg2;
    }

    public void setVisibility(int arg1) {
        this.mVisibility = arg1;
    }

    public void setWidth(int arg2) {
        this.mWidth = arg2;
        int v0 = this.mMinWidth;
        if(arg2 < v0) {
            this.mWidth = v0;
        }
    }

    public void setWidthWrapContent(boolean arg1) {
        this.mIsWidthWrapContent = arg1;
    }

    public void setX(int arg1) {
        this.mX = arg1;
    }

    public void setY(int arg1) {
        this.mY = arg1;
    }

    public void setupDimensionRatio(boolean arg4, boolean arg5, boolean arg6, boolean arg7) {
        int v4 = this.mResolvedDimensionRatioSide;
        float v5 = 1f;
        int v2 = -1;
        if(v4 == v2) {
            if((arg6) && !arg7) {
                this.mResolvedDimensionRatioSide = 0;
                v4 = 0;
                goto label_20;
            }

            if(arg6) {
                goto label_20;
            }

            if(!arg7) {
                goto label_20;
            }

            this.mResolvedDimensionRatioSide = 1;
            if(this.mDimensionRatioSide == v2) {
                this.mResolvedDimensionRatio = v5 / this.mResolvedDimensionRatio;
            }

            v4 = 1;
        }

    label_20:
        if(v4 == 0) {
            if((this.mTop.isConnected()) && (this.mBottom.isConnected())) {
                goto label_29;
            }

            this.mResolvedDimensionRatioSide = 1;
        }
        else {
        label_29:
            if(this.mResolvedDimensionRatioSide != 1) {
                goto label_38;
            }

            if((this.mLeft.isConnected()) && (this.mRight.isConnected())) {
                goto label_38;
            }

            this.mResolvedDimensionRatioSide = 0;
        }

    label_38:
        if(this.mResolvedDimensionRatioSide == v2 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if((this.mTop.isConnected()) && (this.mBottom.isConnected())) {
                this.mResolvedDimensionRatioSide = 0;
                goto label_70;
            }

            if(!this.mLeft.isConnected()) {
                goto label_70;
            }

            if(!this.mRight.isConnected()) {
                goto label_70;
            }

            this.mResolvedDimensionRatio = v5 / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }

    label_70:
        if(this.mResolvedDimensionRatioSide == v2) {
            v4 = this.mMatchConstraintMinWidth;
            if(v4 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
                return;
            }

            if(v4 != 0) {
                return;
            }

            if(this.mMatchConstraintMinHeight <= 0) {
                return;
            }

            this.mResolvedDimensionRatio = v5 / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        String v2 = " ";
        String v3 = "";
        String v1 = this.mType != null ? "type: " + this.mType + v2 : v3;
        v0 = v0.append(v1);
        if(this.mDebugName != null) {
            v3 = "id: " + this.mDebugName + v2;
        }

        return v0.append(v3).append("(").append(this.mX).append(", ").append(this.mY).append(") - (").append(this.mWidth).append(" x ").append(this.mHeight).append(")").toString();
    }

    public void updateFromRuns(boolean arg8, boolean arg9) {
        int v8 = (((int)arg8)) & this.horizontalRun.isResolved();
        int v9 = (((int)arg9)) & this.verticalRun.isResolved();
        int v0 = this.horizontalRun.start.value;
        int v1 = this.verticalRun.start.value;
        int v2 = this.horizontalRun.end.value;
        int v3 = this.verticalRun.end.value;
        int v5 = v3 - v1;
        if(v2 - v0 < 0 || v5 < 0) {
        label_33:
            v0 = 0;
            v1 = 0;
            v2 = 0;
            v3 = 0;
        }
        else {
            int v4 = 0x80000000;
            if(v0 != v4) {
                v5 = 0x7FFFFFFF;
                if(v0 == v5) {
                    goto label_33;
                }
                else if(v1 == v4) {
                    goto label_33;
                }
                else if(v1 == v5) {
                    goto label_33;
                }
                else if(v2 == v4) {
                    goto label_33;
                }
                else if(v2 == v5) {
                    goto label_33;
                }
                else if(v3 == v4) {
                    goto label_33;
                }
                else if(v3 == v5) {
                    goto label_33;
                }
            }
            else {
                goto label_33;
            }
        }

        v2 -= v0;
        v3 -= v1;
        if(v8 != 0) {
            this.mX = v0;
        }

        if(v9 != 0) {
            this.mY = v1;
        }

        if(this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }

        if(v8 != 0) {
            if(this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
                v8 = this.mWidth;
                if(v2 < v8) {
                    v2 = v8;
                }
            }

            this.mWidth = v2;
            v8 = this.mMinWidth;
            if(v2 >= v8) {
                goto label_61;
            }

            this.mWidth = v8;
        }

    label_61:
        if(v9 != 0) {
            if(this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
                v8 = this.mHeight;
                if(v3 < v8) {
                    v3 = v8;
                }
            }

            this.mHeight = v3;
            v8 = this.mMinHeight;
            if(v3 >= v8) {
                return;
            }

            this.mHeight = v8;
        }
    }

    public void updateFromSolver(LinearSystem arg6) {
        int v0 = arg6.getObjectVariableValue(this.mLeft);
        int v1 = arg6.getObjectVariableValue(this.mTop);
        int v2 = arg6.getObjectVariableValue(this.mRight);
        int v6 = arg6.getObjectVariableValue(this.mBottom);
        if((this.horizontalRun.start.resolved) && (this.horizontalRun.end.resolved)) {
            v0 = this.horizontalRun.start.value;
            v2 = this.horizontalRun.end.value;
        }

        if((this.verticalRun.start.resolved) && (this.verticalRun.end.resolved)) {
            v1 = this.verticalRun.start.value;
            v6 = this.verticalRun.end.value;
        }

        int v4 = v6 - v1;
        if(v2 - v0 < 0 || v4 < 0) {
        label_50:
            v0 = 0;
            v6 = 0;
            v1 = 0;
            v2 = 0;
        }
        else {
            int v3 = 0x80000000;
            if(v0 != v3) {
                v4 = 0x7FFFFFFF;
                if(v0 == v4) {
                    goto label_50;
                }
                else if(v1 == v3) {
                    goto label_50;
                }
                else if(v1 == v4) {
                    goto label_50;
                }
                else if(v2 == v3) {
                    goto label_50;
                }
                else if(v2 == v4) {
                    goto label_50;
                }
                else if(v6 == v3) {
                    goto label_50;
                }
                else if(v6 == v4) {
                    goto label_50;
                }
            }
            else {
                goto label_50;
            }
        }

        this.setFrame(v0, v1, v2, v6);
    }
}

