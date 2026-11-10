package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    class WidgetsList {
        private ConstraintWidget biggest;
        int biggestDimension;
        private ConstraintAnchor mBottom;
        private int mCount;
        private int mHeight;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mNbMatchConstraintsWidgets;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private int mStartIndex;
        private ConstraintAnchor mTop;
        private int mWidth;

        public WidgetsList(Flow arg2, int arg3, ConstraintAnchor arg4, ConstraintAnchor arg5, ConstraintAnchor arg6, ConstraintAnchor arg7, int arg8) {
            Flow.this = arg2;
            super();
            this.biggest = null;
            this.biggestDimension = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
            this.mMax = 0;
            this.mOrientation = arg3;
            this.mLeft = arg4;
            this.mTop = arg5;
            this.mRight = arg6;
            this.mBottom = arg7;
            this.mPaddingLeft = arg2.getPaddingLeft();
            this.mPaddingTop = arg2.getPaddingTop();
            this.mPaddingRight = arg2.getPaddingRight();
            this.mPaddingBottom = arg2.getPaddingBottom();
            this.mMax = arg8;
        }

        static ConstraintWidget access$2000(WidgetsList arg0) {
            return arg0.biggest;
        }

        public void add(ConstraintWidget arg7) {
            int v1_1;
            int v0 = this.mOrientation;
            Flow v1 = Flow.this;
            int v2 = 8;
            int v3 = 0;
            if(v0 == 0) {
                v0 = v1.getWidgetWidth(arg7, this.mMax);
                if(arg7.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++this.mNbMatchConstraintsWidgets;
                    v0 = 0;
                }

                v1_1 = Flow.this.mHorizontalGap;
                if(arg7.getVisibility() == v2) {
                }
                else {
                    v3 = v1_1;
                }

                this.mWidth += v0 + v3;
                v0 = Flow.this.getWidgetHeight(arg7, this.mMax);
                if(this.biggest != null && this.biggestDimension >= v0) {
                    goto label_64;
                }

                this.biggest = arg7;
                this.biggestDimension = v0;
                this.mHeight = v0;
            }
            else {
                v0 = v1.getWidgetWidth(arg7, this.mMax);
                v1_1 = Flow.this.getWidgetHeight(arg7, this.mMax);
                if(arg7.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++this.mNbMatchConstraintsWidgets;
                    v1_1 = 0;
                }

                int v4 = Flow.this.mVerticalGap;
                if(arg7.getVisibility() == v2) {
                }
                else {
                    v3 = v4;
                }

                this.mHeight += v1_1 + v3;
                if(this.biggest != null && this.biggestDimension >= v0) {
                    goto label_64;
                }

                this.biggest = arg7;
                this.biggestDimension = v0;
                this.mWidth = v0;
            }

        label_64:
            ++this.mCount;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean arg18, int arg19, boolean arg20) {
            int v16;
            ConstraintWidget v12_2;
            int v10_2;
            int v11;
            WidgetsList v0 = this;
            int v1 = v0.mCount;
            int v3 = 0;
            while(v3 < v1) {
                if(v0.mStartIndex + v3 >= v0.this$0.mDisplayedWidgetsCount) {
                }
                else {
                    ConstraintWidget v4 = v0.this$0.mDisplayedWidgets[v0.mStartIndex + v3];
                    if(v4 != null) {
                        v4.resetAnchors();
                    }

                    ++v3;
                    continue;
                }

                break;
            }

            if(v1 != 0) {
                if(v0.biggest == null) {
                }
                else {
                    int v4_1 = !arg20 || arg19 != 0 ? 0 : 1;
                    int v5 = -1;
                    int v6 = 0;
                    int v7 = v5;
                    int v8 = v7;
                    while(v6 < v1) {
                        int v9 = arg18 ? v1 - 1 - v6 : v6;
                        if(v0.mStartIndex + v9 >= v0.this$0.mDisplayedWidgetsCount) {
                            break;
                        }

                        if(v0.this$0.mDisplayedWidgets[v0.mStartIndex + v9].getVisibility() == 0) {
                            if(v7 == v5) {
                                v7 = v6;
                            }

                            v8 = v6;
                        }

                        ++v6;
                    }

                    v6 = v0.mOrientation;
                    ConstraintWidget v9_1 = v0.biggest;
                    ConstraintWidget v10 = null;
                    if(v6 != 0) {
                        goto label_237;
                    }

                    v9_1.setVerticalChainStyle(v0.this$0.mVerticalStyle);
                    v6 = v0.mPaddingTop;
                    if(arg19 > 0) {
                        v6 += v0.this$0.mVerticalGap;
                    }

                    v9_1.mTop.connect(v0.mTop, v6);
                    if(arg20) {
                        v9_1.mBottom.connect(v0.mBottom, v0.mPaddingBottom);
                    }

                    if(arg19 > 0) {
                        v0.mTop.mOwner.mBottom.connect(v9_1.mTop, 0);
                    }

                    if(v0.this$0.mVerticalAlign != 3 || (v9_1.hasBaseline())) {
                    label_112:
                        v12_2 = v9_1;
                    }
                    else {
                        v6 = 0;
                        goto label_90;
                    label_237:
                        v9_1.setHorizontalChainStyle(v0.this$0.mHorizontalStyle);
                        v3 = v0.mPaddingLeft;
                        if(arg19 > 0) {
                            v3 += v0.this$0.mHorizontalGap;
                        }

                        if(arg18) {
                            v9_1.mRight.connect(v0.mRight, v3);
                            if(arg20) {
                                v9_1.mLeft.connect(v0.mLeft, v0.mPaddingRight);
                            }

                            if(arg19 <= 0) {
                                goto label_275;
                            }

                            v0.mRight.mOwner.mLeft.connect(v9_1.mRight, 0);
                        }
                        else {
                            v9_1.mLeft.connect(v0.mLeft, v3);
                            if(arg20) {
                                v9_1.mRight.connect(v0.mRight, v0.mPaddingRight);
                            }

                            if(arg19 <= 0) {
                                goto label_275;
                            }

                            v0.mLeft.mOwner.mRight.connect(v9_1.mLeft, 0);
                        }

                    label_275:
                        v3 = 0;
                        while(true) {
                            if(v3 >= v1) {
                                return;
                            }

                            if(v0.mStartIndex + v3 >= v0.this$0.mDisplayedWidgetsCount) {
                                return;
                            }

                            ConstraintWidget v6_1 = v0.this$0.mDisplayedWidgets[v0.mStartIndex + v3];
                            if(v3 == 0) {
                                v6_1.connect(v6_1.mTop, v0.mTop, v0.mPaddingTop);
                                v11 = v0.this$0.mVerticalStyle;
                                float v12 = v0.this$0.mVerticalBias;
                                if(v0.mStartIndex == 0 && v0.this$0.mFirstVerticalStyle != v5) {
                                    v11 = v0.this$0.mFirstVerticalStyle;
                                    v12 = v0.this$0.mFirstVerticalBias;
                                }
                                else if((arg20) && v0.this$0.mLastVerticalStyle != v5) {
                                    v11 = v0.this$0.mLastVerticalStyle;
                                    v12 = v0.this$0.mLastVerticalBias;
                                }

                                v6_1.setVerticalChainStyle(v11);
                                v6_1.setVerticalBiasPercent(v12);
                            }

                            if(v3 == v1 - 1) {
                                v6_1.connect(v6_1.mBottom, v0.mBottom, v0.mPaddingBottom);
                            }

                            if(v10 != null) {
                                v6_1.mTop.connect(v10.mBottom, v0.this$0.mVerticalGap);
                                if(v3 == v7) {
                                    v6_1.mTop.setGoneMargin(v0.mPaddingTop);
                                }

                                v10.mBottom.connect(v6_1.mTop, 0);
                                if(v3 != v8 + 1) {
                                    goto label_342;
                                }

                                v10.mBottom.setGoneMargin(v0.mPaddingBottom);
                            }

                        label_342:
                            if(v6_1 != v9_1) {
                                Flow v10_1 = v0.this$0;
                                v11 = 2;
                                if(arg18) {
                                    v10_2 = v10_1.mHorizontalAlign;
                                    if(v10_2 == 0) {
                                        v6_1.mRight.connect(v9_1.mRight, 0);
                                    }
                                    else if(v10_2 == 1) {
                                        v6_1.mLeft.connect(v9_1.mLeft, 0);
                                    }
                                    else if(v10_2 != v11) {
                                    }
                                    else {
                                        v6_1.mLeft.connect(v9_1.mLeft, 0);
                                        v6_1.mRight.connect(v9_1.mRight, 0);
                                    }
                                }
                                else {
                                    v10_2 = v10_1.mHorizontalAlign;
                                    if(v10_2 == 0) {
                                        v6_1.mLeft.connect(v9_1.mLeft, 0);
                                    }
                                    else if(v10_2 == 1) {
                                        v6_1.mRight.connect(v9_1.mRight, 0);
                                    }
                                    else if(v10_2 != v11) {
                                    }
                                    else if(v4_1 != 0) {
                                        v6_1.mLeft.connect(v0.mLeft, v0.mPaddingLeft);
                                        v6_1.mRight.connect(v0.mRight, v0.mPaddingRight);
                                    }
                                    else {
                                        v6_1.mLeft.connect(v9_1.mLeft, 0);
                                        v6_1.mRight.connect(v9_1.mRight, 0);
                                    }
                                }
                            }

                            ++v3;
                            v10 = v6_1;
                        }

                        while(true) {
                        label_90:
                            if(v6 >= v1) {
                                goto label_112;
                            }

                            int v12_1 = arg18 ? v1 - 1 - v6 : v6;
                            if(v0.mStartIndex + v12_1 >= v0.this$0.mDisplayedWidgetsCount) {
                                goto label_112;
                            }

                            v12_2 = v0.this$0.mDisplayedWidgets[v0.mStartIndex + v12_1];
                            if(v12_2.hasBaseline()) {
                                break;
                            }

                            ++v6;
                        }
                    }

                    v6 = 0;
                    while(v6 < v1) {
                        int v13 = arg18 ? v1 - 1 - v6 : v6;
                        if(v0.mStartIndex + v13 >= v0.this$0.mDisplayedWidgetsCount) {
                            return;
                        }

                        ConstraintWidget v14 = v0.this$0.mDisplayedWidgets[v0.mStartIndex + v13];
                        if(v6 == 0) {
                            v16 = 1;
                            v14.connect(v14.mLeft, v0.mLeft, v0.mPaddingLeft);
                        }
                        else {
                            v16 = 1;
                        }

                        if(v13 == 0) {
                            v3 = v0.this$0.mHorizontalStyle;
                            float v11_1 = v0.this$0.mHorizontalBias;
                            if(v0.mStartIndex == 0 && v0.this$0.mFirstHorizontalStyle != v5) {
                                v3 = v0.this$0.mFirstHorizontalStyle;
                                v11_1 = v0.this$0.mFirstHorizontalBias;
                            }
                            else if((arg20) && v0.this$0.mLastHorizontalStyle != v5) {
                                v3 = v0.this$0.mLastHorizontalStyle;
                                v11_1 = v0.this$0.mLastHorizontalBias;
                            }

                            v14.setHorizontalChainStyle(v3);
                            v14.setHorizontalBiasPercent(v11_1);
                        }

                        if(v6 == v1 - 1) {
                            v14.connect(v14.mRight, v0.mRight, v0.mPaddingRight);
                        }

                        if(v10 != null) {
                            v14.mLeft.connect(v10.mRight, v0.this$0.mHorizontalGap);
                            if(v6 == v7) {
                                v14.mLeft.setGoneMargin(v0.mPaddingLeft);
                            }

                            v10.mRight.connect(v14.mLeft, 0);
                            if(v6 != v8 + 1) {
                                goto label_188;
                            }

                            v10.mRight.setGoneMargin(v0.mPaddingRight);
                        }

                    label_188:
                        if(v14 != v9_1) {
                            if(v0.this$0.mVerticalAlign == 3 && (v12_2.hasBaseline()) && v14 != v12_2 && (v14.hasBaseline())) {
                                v14.mBaseline.connect(v12_2.mBaseline, 0);
                                goto label_233;
                            }

                            v3 = v0.this$0.mVerticalAlign;
                            if(v3 != 0) {
                                if(v3 != v16) {
                                    if(v4_1 != 0) {
                                        v14.mTop.connect(v0.mTop, v0.mPaddingTop);
                                        v14.mBottom.connect(v0.mBottom, v0.mPaddingBottom);
                                        goto label_233;
                                    }

                                    v14.mTop.connect(v9_1.mTop, 0);
                                    v14.mBottom.connect(v9_1.mBottom, 0);
                                    goto label_233;
                                }

                                v14.mBottom.connect(v9_1.mBottom, 0);
                                goto label_233;
                            }

                            v14.mTop.connect(v9_1.mTop, 0);
                        }

                    label_233:
                        ++v6;
                        v10 = v14;
                    }
                }
            }
        }

        public int getHeight() {
            int v0 = this.mOrientation;
            int v1 = this.mHeight;
            if(v0 == 1) {
                v1 -= Flow.this.mVerticalGap;
            }

            return v1;
        }

        public int getWidth() {
            int v0 = this.mOrientation;
            int v1 = this.mWidth;
            if(v0 == 0) {
                v1 -= Flow.this.mHorizontalGap;
            }

            return v1;
        }

        public void measureMatchConstraints(int arg9) {
            int v0 = this.mNbMatchConstraintsWidgets;
            if(v0 == 0) {
                return;
            }

            int v1 = this.mCount;
            int v5 = arg9 / v0;
            arg9 = 0;
            while(arg9 < v1) {
                if(this.mStartIndex + arg9 >= Flow.this.mDisplayedWidgetsCount) {
                }
                else {
                    ConstraintWidget v3 = Flow.this.mDisplayedWidgets[this.mStartIndex + arg9];
                    if(this.mOrientation == 0) {
                        if(v3 != null && v3.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT && v3.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.measure(v3, DimensionBehaviour.FIXED, v5, v3.getVerticalDimensionBehaviour(), v3.getHeight());
                        }
                    }
                    else if(v3 != null && v3.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT && v3.mMatchConstraintDefaultHeight == 0) {
                        Flow.this.measure(v3, v3.getHorizontalDimensionBehaviour(), v3.getWidth(), DimensionBehaviour.FIXED, v5);
                        v5 = v5;
                    }

                    ++arg9;
                    continue;
                }

                break;
            }

            this.recomputeDimensions();
        }

        private void recomputeDimensions() {
            int v6;
            int v4;
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int v1 = this.mCount;
            int v2 = 0;
            while(v2 < v1) {
                if(this.mStartIndex + v2 >= Flow.this.mDisplayedWidgetsCount) {
                }
                else {
                    ConstraintWidget v3 = Flow.this.mDisplayedWidgets[this.mStartIndex + v2];
                    int v5 = 8;
                    if(this.mOrientation == 0) {
                        v4 = v3.getWidth();
                        v6 = Flow.this.mHorizontalGap;
                        if(v3.getVisibility() == v5) {
                            v6 = 0;
                        }

                        this.mWidth += v4 + v6;
                        v4 = Flow.this.getWidgetHeight(v3, this.mMax);
                        if(this.biggest != null && this.biggestDimension >= v4) {
                            goto label_66;
                        }

                        this.biggest = v3;
                        this.biggestDimension = v4;
                        this.mHeight = v4;
                    }
                    else {
                        v4 = Flow.this.getWidgetWidth(v3, this.mMax);
                        v6 = Flow.this.getWidgetHeight(v3, this.mMax);
                        int v7 = Flow.this.mVerticalGap;
                        if(v3.getVisibility() == v5) {
                            v7 = 0;
                        }

                        this.mHeight += v6 + v7;
                        if(this.biggest != null && this.biggestDimension >= v4) {
                            goto label_66;
                        }

                        this.biggest = v3;
                        this.biggestDimension = v4;
                        this.mWidth = v4;
                    }

                label_66:
                    ++v2;
                    continue;
                }

                return;
            }
        }

        public void setStartIndex(int arg1) {
            this.mStartIndex = arg1;
        }

        public void setup(int arg1, ConstraintAnchor arg2, ConstraintAnchor arg3, ConstraintAnchor arg4, ConstraintAnchor arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
            this.mOrientation = arg1;
            this.mLeft = arg2;
            this.mTop = arg3;
            this.mRight = arg4;
            this.mBottom = arg5;
            this.mPaddingLeft = arg6;
            this.mPaddingTop = arg7;
            this.mPaddingRight = arg8;
            this.mPaddingBottom = arg9;
            this.mMax = arg10;
        }
    }

    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE;
    private ConstraintWidget[] mAlignedBiggestElementsInCols;
    private ConstraintWidget[] mAlignedBiggestElementsInRows;
    private int[] mAlignedDimensions;
    private ArrayList mChainList;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount;
    private float mFirstHorizontalBias;
    private int mFirstHorizontalStyle;
    private float mFirstVerticalBias;
    private int mFirstVerticalStyle;
    private int mHorizontalAlign;
    private float mHorizontalBias;
    private int mHorizontalGap;
    private int mHorizontalStyle;
    private float mLastHorizontalBias;
    private int mLastHorizontalStyle;
    private float mLastVerticalBias;
    private int mLastVerticalStyle;
    private int mMaxElementsWrap;
    private int mOrientation;
    private int mVerticalAlign;
    private float mVerticalBias;
    private int mVerticalGap;
    private int mVerticalStyle;
    private int mWrapMode;

    public Flow() {
        super();
        this.mHorizontalStyle = -1;
        this.mVerticalStyle = -1;
        this.mFirstHorizontalStyle = -1;
        this.mFirstVerticalStyle = -1;
        this.mLastHorizontalStyle = -1;
        this.mLastVerticalStyle = -1;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mFirstHorizontalBias = 0.5f;
        this.mFirstVerticalBias = 0.5f;
        this.mLastHorizontalBias = 0.5f;
        this.mLastVerticalBias = 0.5f;
        this.mHorizontalGap = 0;
        this.mVerticalGap = 0;
        this.mHorizontalAlign = 2;
        this.mVerticalAlign = 2;
        this.mWrapMode = 0;
        this.mMaxElementsWrap = -1;
        this.mOrientation = 0;
        this.mChainList = new ArrayList();
        this.mAlignedBiggestElementsInRows = null;
        this.mAlignedBiggestElementsInCols = null;
        this.mAlignedDimensions = null;
        this.mDisplayedWidgetsCount = 0;
    }

    static int access$000(Flow arg0) {
        return arg0.mHorizontalGap;
    }

    static int access$100(Flow arg0) {
        return arg0.mVerticalGap;
    }

    static int access$1000(Flow arg0) {
        return arg0.mFirstHorizontalStyle;
    }

    static float access$1100(Flow arg0) {
        return arg0.mFirstHorizontalBias;
    }

    static int access$1200(Flow arg0) {
        return arg0.mLastHorizontalStyle;
    }

    static float access$1300(Flow arg0) {
        return arg0.mLastHorizontalBias;
    }

    static float access$1400(Flow arg0) {
        return arg0.mVerticalBias;
    }

    static int access$1500(Flow arg0) {
        return arg0.mFirstVerticalStyle;
    }

    static float access$1600(Flow arg0) {
        return arg0.mFirstVerticalBias;
    }

    static int access$1700(Flow arg0) {
        return arg0.mLastVerticalStyle;
    }

    static float access$1800(Flow arg0) {
        return arg0.mLastVerticalBias;
    }

    static int access$1900(Flow arg0) {
        return arg0.mHorizontalAlign;
    }

    static int access$200(Flow arg0, ConstraintWidget arg1, int arg2) {
        return arg0.getWidgetWidth(arg1, arg2);
    }

    static int access$300(Flow arg0, ConstraintWidget arg1, int arg2) {
        return arg0.getWidgetHeight(arg1, arg2);
    }

    static int access$400(Flow arg0) {
        return arg0.mDisplayedWidgetsCount;
    }

    static ConstraintWidget[] access$500(Flow arg0) {
        return arg0.mDisplayedWidgets;
    }

    static int access$600(Flow arg0) {
        return arg0.mVerticalStyle;
    }

    static int access$700(Flow arg0) {
        return arg0.mVerticalAlign;
    }

    static int access$800(Flow arg0) {
        return arg0.mHorizontalStyle;
    }

    static float access$900(Flow arg0) {
        return arg0.mHorizontalBias;
    }

    public void addToSolver(LinearSystem arg7) {
        super.addToSolver(arg7);
        boolean v7 = this.getParent() != null ? this.getParent().isRtl() : false;
        int v1 = this.mWrapMode;
        if(v1 == 0) {
            if(this.mChainList.size() <= 0) {
                goto label_37;
            }

            this.mChainList.get(0).createConstraints(v7, 0, true);
        }
        else if(v1 == 1) {
            v1 = this.mChainList.size();
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                Object v4 = this.mChainList.get(v3);
                boolean v5 = v3 == v1 - 1 ? true : false;
                ((WidgetsList)v4).createConstraints(v7, v3, v5);
            }
        }
        else if(v1 != 2) {
        }
        else {
            this.createAlignedConstraints(v7);
        }

    label_37:
        this.needsCallbackFromSolver(false);
    }

    public void copy(ConstraintWidget arg1, HashMap arg2) {
        super.copy(arg1, arg2);
        this.mHorizontalStyle = ((Flow)arg1).mHorizontalStyle;
        this.mVerticalStyle = ((Flow)arg1).mVerticalStyle;
        this.mFirstHorizontalStyle = ((Flow)arg1).mFirstHorizontalStyle;
        this.mFirstVerticalStyle = ((Flow)arg1).mFirstVerticalStyle;
        this.mLastHorizontalStyle = ((Flow)arg1).mLastHorizontalStyle;
        this.mLastVerticalStyle = ((Flow)arg1).mLastVerticalStyle;
        this.mHorizontalBias = ((Flow)arg1).mHorizontalBias;
        this.mVerticalBias = ((Flow)arg1).mVerticalBias;
        this.mFirstHorizontalBias = ((Flow)arg1).mFirstHorizontalBias;
        this.mFirstVerticalBias = ((Flow)arg1).mFirstVerticalBias;
        this.mLastHorizontalBias = ((Flow)arg1).mLastHorizontalBias;
        this.mLastVerticalBias = ((Flow)arg1).mLastVerticalBias;
        this.mHorizontalGap = ((Flow)arg1).mHorizontalGap;
        this.mVerticalGap = ((Flow)arg1).mVerticalGap;
        this.mHorizontalAlign = ((Flow)arg1).mHorizontalAlign;
        this.mVerticalAlign = ((Flow)arg1).mVerticalAlign;
        this.mWrapMode = ((Flow)arg1).mWrapMode;
        this.mMaxElementsWrap = ((Flow)arg1).mMaxElementsWrap;
        this.mOrientation = ((Flow)arg1).mOrientation;
    }

    private void createAlignedConstraints(boolean arg12) {
        ConstraintWidget v5_1;
        ConstraintWidget v7_1;
        if(this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null) {
            if(this.mAlignedBiggestElementsInRows == null) {
            }
            else {
                int v1;
                for(v1 = 0; v1 < this.mDisplayedWidgetsCount; ++v1) {
                    this.mDisplayedWidgets[v1].resetAnchors();
                }

                int[] v1_1 = this.mAlignedDimensions;
                int v2 = v1_1[0];
                v1 = v1_1[1];
                ConstraintWidget v4 = null;
                int v5;
                for(v5 = 0; true; ++v5) {
                    int v6 = 8;
                    if(v5 >= v2) {
                        break;
                    }

                    int v7 = arg12 ? v2 - v5 - 1 : v5;
                    v7_1 = this.mAlignedBiggestElementsInCols[v7];
                    if(v7_1 != null) {
                        if(v7_1.getVisibility() == v6) {
                        }
                        else {
                            if(v5 == 0) {
                                v7_1.connect(v7_1.mLeft, this.mLeft, this.getPaddingLeft());
                                v7_1.setHorizontalChainStyle(this.mHorizontalStyle);
                                v7_1.setHorizontalBiasPercent(this.mHorizontalBias);
                            }

                            if(v5 == v2 - 1) {
                                v7_1.connect(v7_1.mRight, this.mRight, this.getPaddingRight());
                            }

                            if(v5 > 0) {
                                v7_1.connect(v7_1.mLeft, v4.mRight, this.mHorizontalGap);
                                v4.connect(v4.mRight, v7_1.mLeft, 0);
                            }

                            v4 = v7_1;
                        }
                    }
                }

                int v12;
                for(v12 = 0; v12 < v1; ++v12) {
                    v5_1 = this.mAlignedBiggestElementsInRows[v12];
                    if(v5_1 != null) {
                        if(v5_1.getVisibility() == v6) {
                        }
                        else {
                            if(v12 == 0) {
                                v5_1.connect(v5_1.mTop, this.mTop, this.getPaddingTop());
                                v5_1.setVerticalChainStyle(this.mVerticalStyle);
                                v5_1.setVerticalBiasPercent(this.mVerticalBias);
                            }

                            if(v12 == v1 - 1) {
                                v5_1.connect(v5_1.mBottom, this.mBottom, this.getPaddingBottom());
                            }

                            if(v12 > 0) {
                                v5_1.connect(v5_1.mTop, v4.mBottom, this.mVerticalGap);
                                v4.connect(v4.mBottom, v5_1.mTop, 0);
                            }

                            v4 = v5_1;
                        }
                    }
                }

                for(v12 = 0; v12 < v2; ++v12) {
                    int v4_1;
                    for(v4_1 = 0; v4_1 < v1; ++v4_1) {
                        v5 = v4_1 * v2 + v12;
                        if(this.mOrientation == 1) {
                            v5 = v12 * v1 + v4_1;
                        }

                        ConstraintWidget[] v7_2 = this.mDisplayedWidgets;
                        if(v5 >= v7_2.length) {
                        }
                        else {
                            v5_1 = v7_2[v5];
                            if(v5_1 != null) {
                                if(v5_1.getVisibility() == v6) {
                                }
                                else {
                                    v7_1 = this.mAlignedBiggestElementsInCols[v12];
                                    ConstraintWidget v8 = this.mAlignedBiggestElementsInRows[v4_1];
                                    if(v5_1 != v7_1) {
                                        v5_1.connect(v5_1.mLeft, v7_1.mLeft, 0);
                                        v5_1.connect(v5_1.mRight, v7_1.mRight, 0);
                                    }

                                    if(v5_1 == v8) {
                                        goto label_132;
                                    }

                                    v5_1.connect(v5_1.mTop, v8.mTop, 0);
                                    v5_1.connect(v5_1.mBottom, v8.mBottom, 0);
                                }
                            }
                        }

                    label_132:
                    }
                }
            }
        }
    }

    private final int getWidgetHeight(ConstraintWidget arg8, int arg9) {
        ConstraintWidget v2;
        if(arg8 == null) {
            return 0;
        }

        if(arg8.getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
            v2 = arg8;
        }
        else if(arg8.mMatchConstraintDefaultHeight == 0) {
            return 0;
        }
        else if(arg8.mMatchConstraintDefaultHeight == 2) {
            int v6 = ((int)(arg8.mMatchConstraintPercentHeight * (((float)arg9))));
            if(v6 != arg8.getHeight()) {
                this.measure(arg8, arg8.getHorizontalDimensionBehaviour(), arg8.getWidth(), DimensionBehaviour.FIXED, v6);
            }

            return v6;
        }
        else {
            v2 = arg8;
            if(v2.mMatchConstraintDefaultHeight == 1) {
                return v2.getHeight();
            }

            if(v2.mMatchConstraintDefaultHeight != 3) {
                goto label_43;
            }

            return ((int)((((float)v2.getWidth())) * v2.mDimensionRatio + 0.5f));
        }

    label_43:
        return v2.getHeight();
    }

    private final int getWidgetWidth(ConstraintWidget arg8, int arg9) {
        ConstraintWidget v2;
        if(arg8 == null) {
            return 0;
        }

        if(arg8.getHorizontalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
            v2 = arg8;
        }
        else if(arg8.mMatchConstraintDefaultWidth == 0) {
            return 0;
        }
        else if(arg8.mMatchConstraintDefaultWidth == 2) {
            int v4 = ((int)(arg8.mMatchConstraintPercentWidth * (((float)arg9))));
            if(v4 != arg8.getWidth()) {
                this.measure(arg8, DimensionBehaviour.FIXED, v4, arg8.getVerticalDimensionBehaviour(), arg8.getHeight());
            }

            return v4;
        }
        else {
            v2 = arg8;
            if(v2.mMatchConstraintDefaultWidth == 1) {
                return v2.getWidth();
            }

            if(v2.mMatchConstraintDefaultWidth != 3) {
                goto label_43;
            }

            return ((int)((((float)v2.getHeight())) * v2.mDimensionRatio + 0.5f));
        }

    label_43:
        return v2.getWidth();
    }

    public void measure(int arg20, int arg21, int arg22, int arg23) {
        Flow v0 = this;
        int v6 = arg20;
        int v7 = arg21;
        int v8 = arg22;
        int v9 = arg23;
        if(v0.mWidgetsCount > 0 && !v0.measureChildren()) {
            v0.setMeasure(0, 0);
            v0.needsCallbackFromSolver(false);
            return;
        }

        int v11 = v0.getPaddingLeft();
        int v12 = v0.getPaddingRight();
        int v13 = v0.getPaddingTop();
        int v14 = v0.getPaddingBottom();
        int[] v5 = new int[2];
        int v2 = v7 - v11 - v12;
        int v3 = v0.mOrientation;
        if(v3 == 1) {
            v2 = v9 - v13 - v14;
        }

        int v4 = v2;
        v2 = v0.mHorizontalStyle;
        int v1 = -1;
        if(v3 == 0) {
            if(v2 == v1) {
                v0.mHorizontalStyle = 0;
            }

            if(v0.mVerticalStyle != v1) {
                goto label_41;
            }

            v0.mVerticalStyle = 0;
        }
        else {
            if(v2 == v1) {
                v0.mHorizontalStyle = 0;
            }

            if(v0.mVerticalStyle != v1) {
                goto label_41;
            }

            v0.mVerticalStyle = 0;
        }

    label_41:
        ConstraintWidget[] v1_1 = v0.mWidgets;
        v2 = 0;
        v3 = 0;
        while(true) {
            int v15 = 8;
            if(v2 >= v0.mWidgetsCount) {
                break;
            }

            if(v0.mWidgets[v2].getVisibility() == v15) {
                ++v3;
            }

            ++v2;
        }

        v2 = v0.mWidgetsCount;
        if(v3 > 0) {
            v1_1 = new ConstraintWidget[v0.mWidgetsCount - v3];
            v2 = 0;
            v3 = 0;
            while(v3 < v0.mWidgetsCount) {
                ConstraintWidget v10 = v0.mWidgets[v3];
                ConstraintWidget[] v18 = v1_1;
                if(v10.getVisibility() != v15) {
                    v18[v2] = v10;
                    ++v2;
                }

                ++v3;
                v1_1 = v18;
            }
        }

        v0.mDisplayedWidgets = v1_1;
        v0.mDisplayedWidgetsCount = v2;
        v3 = v0.mWrapMode;
        if(v3 == 0) {
            v0.measureNoWrap(v1_1, v2, v0.mOrientation, v4, v5);
        }
        else if(v3 == 1) {
            v0.measureChainWrap(v1_1, v2, v0.mOrientation, v4, v5);
        }
        else if(v3 != 2) {
        }
        else {
            v0.measureAligned(v1_1, v2, v0.mOrientation, v4, v5);
        }

        v1 = v5[0] + v11 + v12;
        v2 = v5[1] + v13 + v14;
        v3 = 0x80000000;
        v4 = 0x40000000;
        if(v6 == v4) {
            v1 = v7;
        }
        else if(v6 == v3) {
            v1 = Math.min(v1, v7);
        }
        else if(v6 == 0) {
        }
        else {
            v1 = 0;
        }

        if(v8 == v4) {
            v2 = v9;
        }
        else if(v8 == v3) {
            v2 = Math.min(v2, v9);
        }
        else if(v8 == 0) {
        }
        else {
            v2 = 0;
        }

        v0.setMeasure(v1, v2);
        v0.setWidth(v1);
        v0.setHeight(v2);
        boolean v10_1 = v0.mWidgetsCount > 0 ? true : false;
        v0.needsCallbackFromSolver(v10_1);
    }

    private void measureAligned(ConstraintWidget[] arg11, int arg12, int arg13, int arg14, int[] arg15) {
        ConstraintWidget v7_1;
        int v7;
        int v4_1;
        ConstraintWidget v4;
        int v3;
        int v2;
        int v0 = this.mMaxElementsWrap;
        if(arg13 == 0) {
            if(v0 <= 0) {
                v0 = 0;
                v2 = 0;
                v3 = 0;
                goto label_7;
            }

            goto label_21;
        }
        else {
            if(v0 <= 0) {
                v0 = 0;
                v2 = 0;
                v3 = 0;
                while(true) {
                    if(v2 < arg12) {
                        if(v2 > 0) {
                            v3 += this.mVerticalGap;
                        }

                        v4 = arg11[v2];
                        if(v4 == null) {
                        }
                        else {
                            v3 += this.getWidgetHeight(v4, arg14);
                            if(v3 > arg14) {
                                goto label_42;
                            }
                            else {
                                ++v0;
                            }
                        }

                        ++v2;
                        continue;
                    }

                    goto label_42;
                }

                while(true) {
                label_7:
                    if(v2 >= arg12) {
                        goto label_21;
                    }

                    if(v2 > 0) {
                        v3 += this.mHorizontalGap;
                    }

                    v4 = arg11[v2];
                    if(v4 == null) {
                    }
                    else {
                        v3 += this.getWidgetWidth(v4, arg14);
                        if(v3 > arg14) {
                            goto label_21;
                        }
                        else {
                            ++v0;
                        }
                    }

                    ++v2;
                }
            }

        label_42:
            v2 = 0;
            goto label_43;
        label_21:
            v2 = v0;
            v0 = 0;
        }

    label_43:
        if(this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }

        if(v0 != 0 || arg13 != 1) {
            if(v2 != 0 || arg13 != 0) {
                v4_1 = 0;
                goto label_56;
            }

        label_53:
            v4_1 = 1;
        }
        else {
            goto label_53;
        }

    label_56:
        while(v4_1 == 0) {
            if(arg13 == 0) {
                v0 = ((int)Math.ceil(((double)((((float)arg12)) / (((float)v2))))));
            }
            else {
                v2 = ((int)Math.ceil(((double)((((float)arg12)) / (((float)v0))))));
            }

            ConstraintWidget[] v5 = this.mAlignedBiggestElementsInCols;
            Object v6 = null;
            if(v5 == null || v5.length < v2) {
                this.mAlignedBiggestElementsInCols = new ConstraintWidget[v2];
            }
            else {
                Arrays.fill(((Object[])v5), v6);
            }

            v5 = this.mAlignedBiggestElementsInRows;
            if(v5 == null || v5.length < v0) {
                this.mAlignedBiggestElementsInRows = new ConstraintWidget[v0];
            }
            else {
                Arrays.fill(((Object[])v5), v6);
            }

            int v5_1;
            for(v5_1 = 0; v5_1 < v2; ++v5_1) {
                int v6_1;
                for(v6_1 = 0; v6_1 < v0; ++v6_1) {
                    v7 = v6_1 * v2 + v5_1;
                    if(arg13 == 1) {
                        v7 = v5_1 * v0 + v6_1;
                    }

                    if(v7 >= arg11.length) {
                    }
                    else {
                        v7_1 = arg11[v7];
                        if(v7_1 == null) {
                        }
                        else {
                            int v8 = this.getWidgetWidth(v7_1, arg14);
                            ConstraintWidget v9 = this.mAlignedBiggestElementsInCols[v5_1];
                            if(v9 == null || v9.getWidth() < v8) {
                                this.mAlignedBiggestElementsInCols[v5_1] = v7_1;
                            }

                            v8 = this.getWidgetHeight(v7_1, arg14);
                            v9 = this.mAlignedBiggestElementsInRows[v6_1];
                            if(v9 != null && v9.getHeight() >= v8) {
                                goto label_121;
                            }

                            this.mAlignedBiggestElementsInRows[v6_1] = v7_1;
                        }
                    }

                label_121:
                }
            }

            v5_1 = 0;
            v6_1 = 0;
            while(v5_1 < v2) {
                v7_1 = this.mAlignedBiggestElementsInCols[v5_1];
                if(v7_1 != null) {
                    if(v5_1 > 0) {
                        v6_1 += this.mHorizontalGap;
                    }

                    v6_1 += this.getWidgetWidth(v7_1, arg14);
                }

                ++v5_1;
            }

            v5_1 = 0;
            v7 = 0;
            while(v5_1 < v0) {
                ConstraintWidget v8_1 = this.mAlignedBiggestElementsInRows[v5_1];
                if(v8_1 != null) {
                    if(v5_1 > 0) {
                        v7 += this.mVerticalGap;
                    }

                    v7 += this.getWidgetHeight(v8_1, arg14);
                }

                ++v5_1;
            }

            arg15[0] = v6_1;
            arg15[1] = v7;
            if(arg13 == 0) {
                if(v6_1 <= arg14) {
                    goto label_53;
                }

                if(v2 <= 1) {
                    goto label_53;
                }

                --v2;
                continue;
            }

            if(v7 <= arg14) {
                goto label_53;
            }

            if(v0 <= 1) {
                goto label_53;
            }

            --v0;
        }

        int[] v10 = this.mAlignedDimensions;
        v10[0] = v2;
        v10[1] = v0;
    }

    private void measureChainWrap(ConstraintWidget[] arg20, int arg21, int arg22, int arg23, int[] arg24) {
        int v11;
        Flow v15;
        int v4;
        int v14;
        int v13;
        ConstraintWidget v10;
        int v9;
        int v3;
        int v2;
        Flow v1 = this;
        int v8 = arg21;
        if(v8 == 0) {
            return;
        }

        v1.mChainList.clear();
        int v7 = arg23;
        WidgetsList v0 = new WidgetsList(v1, arg22, v1.mLeft, v1.mTop, v1.mRight, v1.mBottom, v7);
        v1.mChainList.add(v0);
        if(arg22 == 0) {
            v2 = 0;
            v3 = 0;
            v9 = 0;
            while(v9 < v8) {
                v10 = arg20[v9];
                v13 = v1.getWidgetWidth(v10, v7);
                if(v10.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++v2;
                }

                v14 = v2;
                if(v3 != v7 && v1.mHorizontalGap + v3 + v13 <= v7) {
                    goto label_37;
                }
                else if(WidgetsList.access$2000(v0) != null) {
                    v2 = 1;
                }
                else {
                label_37:
                    v2 = 0;
                }

                if(v2 == 0 && v9 > 0) {
                    v4 = v1.mMaxElementsWrap;
                    if(v4 > 0 && v9 % v4 == 0) {
                        v2 = 1;
                    }
                }

                if(v2 != 0) {
                    v0 = new WidgetsList(v1, arg22, v1.mLeft, v1.mTop, v1.mRight, v1.mBottom, v7);
                    v0.setStartIndex(v9);
                    v1.mChainList.add(v0);
                    goto label_56;
                }
                else if(v9 > 0) {
                    v3 += v1.mHorizontalGap + v13;
                }
                else {
                label_56:
                    v3 = v13;
                }

                v0.add(v10);
                ++v9;
                v2 = v14;
            }
        }
        else {
            v2 = 0;
            v3 = 0;
            v9 = 0;
            while(v9 < v8) {
                v10 = arg20[v9];
                v13 = v1.getWidgetHeight(v10, v7);
                if(v10.getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                    ++v2;
                }

                v14 = v2;
                if(v3 != v7 && v1.mVerticalGap + v3 + v13 <= v7) {
                    goto label_86;
                }
                else if(WidgetsList.access$2000(v0) != null) {
                    v2 = 1;
                }
                else {
                label_86:
                    v2 = 0;
                }

                if(v2 == 0 && v9 > 0) {
                    v4 = v1.mMaxElementsWrap;
                    if(v4 > 0 && v9 % v4 == 0) {
                        v2 = 1;
                    }
                }

                if(v2 != 0) {
                    v0 = new WidgetsList(v1, arg22, v1.mLeft, v1.mTop, v1.mRight, v1.mBottom, v7);
                    v15 = v1;
                    v0.setStartIndex(v9);
                    v15.mChainList.add(v0);
                    goto label_106;
                }
                else {
                    v15 = v1;
                    if(v9 > 0) {
                        v3 += v15.mVerticalGap + v13;
                    }
                    else {
                    label_106:
                        v3 = v13;
                    }
                }

                v0.add(v10);
                ++v9;
                v7 = arg23;
                v2 = v14;
                v1 = v15;
            }
        }

        v15 = v1;
        v13 = v15.mChainList.size();
        ConstraintAnchor v0_1 = v15.mLeft;
        ConstraintAnchor v1_1 = v15.mTop;
        ConstraintAnchor v3_1 = v15.mRight;
        ConstraintAnchor v4_1 = v15.mBottom;
        int v5 = v15.getPaddingLeft();
        int v6 = v15.getPaddingTop();
        v7 = v15.getPaddingRight();
        v8 = v15.getPaddingBottom();
        v9 = v15.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT || v15.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
        if(v2 > 0 && v9 != 0) {
            for(v2 = 0; v2 < v13; ++v2) {
                Object v9_1 = v15.mChainList.get(v2);
                if(arg22 == 0) {
                    ((WidgetsList)v9_1).measureMatchConstraints(arg23 - ((WidgetsList)v9_1).getWidth());
                }
                else {
                    ((WidgetsList)v9_1).measureMatchConstraints(arg23 - ((WidgetsList)v9_1).getHeight());
                }
            }
        }

        ConstraintAnchor v2_1 = v0_1;
        v9 = v8;
        int v0_2 = 0;
        v14 = 0;
        v8 = v7;
        v7 = v6;
        v6 = v5;
        ConstraintAnchor v5_1 = v4_1;
        v4_1 = v3_1;
        v3_1 = v1_1;
        int v1_2 = 0;
        while(v14 < v13) {
            Object v10_1 = v15.mChainList.get(v14);
            if(arg22 == 0) {
                if(v14 < v13 - 1) {
                    v5_1 = WidgetsList.access$2000(v15.mChainList.get(v14 + 1)).mTop;
                    v9 = 0;
                }
                else {
                    v5_1 = v15.mBottom;
                    v9 = v15.getPaddingBottom();
                }

                ConstraintAnchor v20 = WidgetsList.access$2000(((WidgetsList)v10_1)).mBottom;
                v11 = v1_2;
                v10_1.setup(arg22, v2_1, v3_1, v4_1, v5_1, v6, v7, v8, v9, arg23);
                v1_2 = Math.max(v0_2, v10_1.getWidth());
                v0_2 = v10_1.getHeight() + v11;
                if(v14 > 0) {
                    v0_2 += v15.mVerticalGap;
                }

                v3 = v1_2;
                v1_2 = v0_2;
                v0_2 = v3;
                v3_1 = v20;
                v7 = 0;
            }
            else {
                int v12 = v0_2;
                v11 = v1_2;
                Object v0_3 = v10_1;
                if(v14 < v13 - 1) {
                    v1_1 = WidgetsList.access$2000(v15.mChainList.get(v14 + 1)).mLeft;
                    v8 = 0;
                }
                else {
                    v1_1 = v15.mRight;
                    v8 = v15.getPaddingRight();
                }

                v4_1 = v1_1;
                ConstraintAnchor v18 = WidgetsList.access$2000(((WidgetsList)v0_3)).mRight;
                ((WidgetsList)v0_3).setup(arg22, v2_1, v3_1, v4_1, v5_1, v6, v7, v8, v9, arg23);
                v1_2 = ((WidgetsList)v0_3).getWidth() + v12;
                v0_2 = Math.max(v11, ((WidgetsList)v0_3).getHeight());
                if(v14 > 0) {
                    v1_2 += v15.mHorizontalGap;
                }

                v2 = v1_2;
                v1_2 = v0_2;
                v0_2 = v2;
                v6 = 0;
                v2_1 = v18;
            }

            ++v14;
        }

        arg24[0] = v0_2;
        arg24[1] = v1_2;
    }

    private void measureNoWrap(ConstraintWidget[] arg22, int arg23, int arg24, int arg25, int[] arg26) {
        Object v0_1;
        Flow v1 = this;
        int v8 = arg23;
        if(v8 == 0) {
            return;
        }

        if(v1.mChainList.size() == 0) {
            WidgetsList v0 = new WidgetsList(v1, arg24, v1.mLeft, v1.mTop, v1.mRight, v1.mBottom, arg25);
            v1.mChainList.add(v0);
        }
        else {
            Object v10 = v1.mChainList.get(0);
            ((WidgetsList)v10).clear();
            ((WidgetsList)v10).setup(arg24, v1.mLeft, v1.mTop, v1.mRight, v1.mBottom, v1.getPaddingLeft(), v1.getPaddingTop(), v1.getPaddingRight(), v1.getPaddingBottom(), arg25);
            v0_1 = v10;
        }

        int v1_1;
        for(v1_1 = 0; v1_1 < v8; ++v1_1) {
            ((WidgetsList)v0_1).add(arg22[v1_1]);
        }

        arg26[0] = ((WidgetsList)v0_1).getWidth();
        arg26[1] = ((WidgetsList)v0_1).getHeight();
    }

    public void setFirstHorizontalBias(float arg1) {
        this.mFirstHorizontalBias = arg1;
    }

    public void setFirstHorizontalStyle(int arg1) {
        this.mFirstHorizontalStyle = arg1;
    }

    public void setFirstVerticalBias(float arg1) {
        this.mFirstVerticalBias = arg1;
    }

    public void setFirstVerticalStyle(int arg1) {
        this.mFirstVerticalStyle = arg1;
    }

    public void setHorizontalAlign(int arg1) {
        this.mHorizontalAlign = arg1;
    }

    public void setHorizontalBias(float arg1) {
        this.mHorizontalBias = arg1;
    }

    public void setHorizontalGap(int arg1) {
        this.mHorizontalGap = arg1;
    }

    public void setHorizontalStyle(int arg1) {
        this.mHorizontalStyle = arg1;
    }

    public void setLastHorizontalBias(float arg1) {
        this.mLastHorizontalBias = arg1;
    }

    public void setLastHorizontalStyle(int arg1) {
        this.mLastHorizontalStyle = arg1;
    }

    public void setLastVerticalBias(float arg1) {
        this.mLastVerticalBias = arg1;
    }

    public void setLastVerticalStyle(int arg1) {
        this.mLastVerticalStyle = arg1;
    }

    public void setMaxElementsWrap(int arg1) {
        this.mMaxElementsWrap = arg1;
    }

    public void setOrientation(int arg1) {
        this.mOrientation = arg1;
    }

    public void setVerticalAlign(int arg1) {
        this.mVerticalAlign = arg1;
    }

    public void setVerticalBias(float arg1) {
        this.mVerticalBias = arg1;
    }

    public void setVerticalGap(int arg1) {
        this.mVerticalGap = arg1;
    }

    public void setVerticalStyle(int arg1) {
        this.mVerticalStyle = arg1;
    }

    public void setWrapMode(int arg1) {
        this.mWrapMode = arg1;
    }
}

