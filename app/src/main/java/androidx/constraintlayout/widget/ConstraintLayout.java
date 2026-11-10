package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    class androidx.constraintlayout.widget.ConstraintLayout$1 {
        static {
            int[] v0 = new int[DimensionBehaviour.values().length];
            androidx.constraintlayout.widget.ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = v0;
            try {
                v0[DimensionBehaviour.FIXED.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.widget.ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.widget.ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.widget.ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
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

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 0x20;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 0x2F;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 0x30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 0x1F;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED;
            public static final SparseIntArray map;

            static {
                SparseIntArray v0 = new SparseIntArray();
                Table.map = v0;
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                v0.append(styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                v0.append(styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                v0.append(styleable.ConstraintLayout_Layout_android_orientation, 1);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                v0.append(styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                v0.append(styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                v0.append(styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                v0.append(styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                v0.append(styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                v0.append(styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 0x2F);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 0x30);
                v0.append(styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                v0.append(styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 0x1F);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 0x20);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                v0.append(styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }

            private Table() {
                super();
            }
        }

        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;

        public LayoutParams(int arg5, int arg6) {
            super(arg5, arg6);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1f;
            this.verticalWeight = -1f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1f;
            this.matchConstraintPercentHeight = 1f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(ViewGroup$LayoutParams arg6) {
            super(arg6);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1f;
            this.verticalWeight = -1f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1f;
            this.matchConstraintPercentHeight = 1f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(Context arg11, AttributeSet arg12) {
            float v5_2;
            float v4_2;
            super(arg11, arg12);
            int v0 = -1;
            this.guideBegin = v0;
            this.guideEnd = v0;
            this.guidePercent = -1f;
            this.leftToLeft = v0;
            this.leftToRight = v0;
            this.rightToLeft = v0;
            this.rightToRight = v0;
            this.topToTop = v0;
            this.topToBottom = v0;
            this.bottomToTop = v0;
            this.bottomToBottom = v0;
            this.baselineToBaseline = v0;
            this.circleConstraint = v0;
            this.circleRadius = 0;
            this.circleAngle = 0f;
            this.startToEnd = v0;
            this.startToStart = v0;
            this.endToStart = v0;
            this.endToEnd = v0;
            this.goneLeftMargin = v0;
            this.goneTopMargin = v0;
            this.goneRightMargin = v0;
            this.goneBottomMargin = v0;
            this.goneStartMargin = v0;
            this.goneEndMargin = v0;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1f;
            this.verticalWeight = -1f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1f;
            this.matchConstraintPercentHeight = 1f;
            this.editorAbsoluteX = v0;
            this.editorAbsoluteY = v0;
            this.orientation = v0;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = v0;
            this.resolvedLeftToRight = v0;
            this.resolvedRightToLeft = v0;
            this.resolvedRightToRight = v0;
            this.resolveGoneLeftMargin = v0;
            this.resolveGoneRightMargin = v0;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray v11 = arg11.obtainStyledAttributes(arg12, styleable.ConstraintLayout_Layout);
            int v12 = v11.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v12; ++v1) {
                int v4 = v11.getIndex(v1);
                int v5 = Table.map.get(v4);
                String v7 = "ConstraintLayout";
                int v8 = 2;
                int v9 = -2;
                switch(v5) {
                    case 1: {
                        goto label_401;
                    }
                    case 2: {
                        goto label_394;
                    }
                    case 3: {
                        goto label_390;
                    }
                    case 4: {
                        goto label_380;
                    }
                    case 5: {
                        goto label_376;
                    }
                    case 6: {
                        goto label_372;
                    }
                    case 7: {
                        goto label_368;
                    }
                    case 8: {
                        goto label_361;
                    }
                    case 9: {
                        goto label_354;
                    }
                    case 10: {
                        goto label_347;
                    }
                    case 11: {
                        goto label_340;
                    }
                    case 12: {
                        goto label_333;
                    }
                    case 13: {
                        goto label_326;
                    }
                    case 14: {
                        goto label_319;
                    }
                    case 15: {
                        goto label_312;
                    }
                    case 16: {
                        goto label_305;
                    }
                    case 17: {
                        goto label_298;
                    }
                    case 18: {
                        goto label_291;
                    }
                    case 19: {
                        goto label_284;
                    }
                    case 20: {
                        goto label_277;
                    }
                    case 21: {
                        goto label_273;
                    }
                    case 22: {
                        goto label_269;
                    }
                    case 23: {
                        goto label_265;
                    }
                    case 24: {
                        goto label_261;
                    }
                    case 25: {
                        goto label_257;
                    }
                    case 26: {
                        goto label_253;
                    }
                    case 27: {
                        goto label_249;
                    }
                    case 28: {
                        goto label_245;
                    }
                    case 29: {
                        goto label_241;
                    }
                    case 30: {
                        goto label_237;
                    }
                    case 31: {
                        goto label_231;
                    }
                    case 32: {
                        goto label_225;
                    }
                    case 33: {
                        goto label_216;
                    }
                    case 34: {
                        goto label_207;
                    }
                    case 35: {
                        goto label_201;
                    }
                    case 36: {
                        goto label_192;
                    }
                    case 37: {
                        goto label_183;
                    }
                    case 38: {
                        goto label_177;
                    }
                }

                switch(v5) {
                    case 44: {
                        goto label_114;
                    }
                    case 45: {
                        goto label_110;
                    }
                    case 46: {
                        goto label_106;
                    }
                    case 47: {
                        goto label_103;
                    }
                    case 48: {
                        goto label_100;
                    }
                    case 49: {
                        goto label_96;
                    }
                    case 50: {
                        goto label_92;
                    }
                    case 51: {
                        goto label_89;
                    }
                }

                goto label_404;
            label_114:
                String v4_1 = v11.getString(v4);
                this.dimensionRatio = v4_1;
                this.dimensionRatioValue = NaNf;
                this.dimensionRatioSide = v0;
                if(v4_1 == null) {
                    goto label_404;
                }

                v4 = v4_1.length();
                v5 = this.dimensionRatio.indexOf(44);
                if(v5 <= 0 || v5 >= v4 - 1) {
                    v5 = 0;
                }
                else {
                    v7 = this.dimensionRatio.substring(0, v5);
                    if(v7.equalsIgnoreCase("W")) {
                        this.dimensionRatioSide = 0;
                    }
                    else if(v7.equalsIgnoreCase("H")) {
                        this.dimensionRatioSide = 1;
                    }

                    ++v5;
                }

                int v7_1 = this.dimensionRatio.indexOf(58);
                if(v7_1 >= 0 && v7_1 < v4 - 1) {
                    v4_1 = this.dimensionRatio.substring(v5, v7_1);
                    String v5_1 = this.dimensionRatio.substring(v7_1 + 1);
                    if(v4_1.length() <= 0) {
                    }
                    else if(v5_1.length() > 0) {
                        try {
                            v4_2 = Float.parseFloat(v4_1);
                            v5_2 = Float.parseFloat(v5_1);
                            if(v4_2 <= 0f) {
                            }
                            else if(v5_2 <= 0f) {
                            }
                            else if(this.dimensionRatioSide == 1) {
                                this.dimensionRatioValue = Math.abs(v5_2 / v4_2);
                            }
                            else {
                                this.dimensionRatioValue = Math.abs(v4_2 / v5_2);
                            }
                        }
                        catch(NumberFormatException ) {
                        }
                    }
                    else {
                    }

                    goto label_404;
                }

                v4_1 = this.dimensionRatio.substring(v5);
                if(v4_1.length() <= 0) {
                    goto label_404;
                }

                try {
                    this.dimensionRatioValue = Float.parseFloat(v4_1);
                }
                catch(NumberFormatException ) {
                }

                goto label_404;
            label_100:
                this.verticalChainStyle = v11.getInt(v4, 0);
                goto label_404;
            label_103:
                this.horizontalChainStyle = v11.getInt(v4, 0);
                goto label_404;
            label_89:
                this.constraintTag = v11.getString(v4);
                goto label_404;
            label_106:
                this.verticalWeight = v11.getFloat(v4, this.verticalWeight);
                goto label_404;
            label_92:
                this.editorAbsoluteY = v11.getDimensionPixelOffset(v4, this.editorAbsoluteY);
                goto label_404;
            label_110:
                this.horizontalWeight = v11.getFloat(v4, this.horizontalWeight);
                goto label_404;
            label_96:
                this.editorAbsoluteX = v11.getDimensionPixelOffset(v4, this.editorAbsoluteX);
                goto label_404;
            label_225:
                v4 = v11.getInt(v4, 0);
                this.matchConstraintDefaultHeight = v4;
                if(v4 != 1) {
                    goto label_404;
                }

                Log.e(v7, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                goto label_404;
            label_354:
                v5 = v11.getResourceId(v4, this.leftToRight);
                this.leftToRight = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.leftToRight = v11.getInt(v4, v0);
                goto label_404;
            label_291:
                v5 = v11.getResourceId(v4, this.startToStart);
                this.startToStart = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.startToStart = v11.getInt(v4, v0);
                goto label_404;
            label_231:
                v4 = v11.getInt(v4, 0);
                this.matchConstraintDefaultWidth = v4;
                if(v4 != 1) {
                    goto label_404;
                }

                Log.e(v7, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                goto label_404;
            label_361:
                v5 = v11.getResourceId(v4, this.leftToLeft);
                this.leftToLeft = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.leftToLeft = v11.getInt(v4, v0);
                goto label_404;
            label_298:
                v5 = v11.getResourceId(v4, this.startToEnd);
                this.startToEnd = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.startToEnd = v11.getInt(v4, v0);
                goto label_404;
            label_237:
                this.verticalBias = v11.getFloat(v4, this.verticalBias);
                goto label_404;
            label_368:
                this.guidePercent = v11.getFloat(v4, this.guidePercent);
                goto label_404;
            label_305:
                v5 = v11.getResourceId(v4, this.baselineToBaseline);
                this.baselineToBaseline = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.baselineToBaseline = v11.getInt(v4, v0);
                goto label_404;
            label_241:
                this.horizontalBias = v11.getFloat(v4, this.horizontalBias);
                goto label_404;
            label_177:
                this.matchConstraintPercentHeight = Math.max(0f, v11.getFloat(v4, this.matchConstraintPercentHeight));
                this.matchConstraintDefaultHeight = v8;
                goto label_404;
            label_372:
                this.guideEnd = v11.getDimensionPixelOffset(v4, this.guideEnd);
                goto label_404;
            label_245:
                this.constrainedHeight = v11.getBoolean(v4, this.constrainedHeight);
                goto label_404;
                try {
                label_183:
                    this.matchConstraintMaxHeight = v11.getDimensionPixelSize(v4, this.matchConstraintMaxHeight);
                }
                catch(Exception ) {
                    if(v11.getInt(v4, this.matchConstraintMaxHeight) != v9) {
                        goto label_404;
                    }

                    this.matchConstraintMaxHeight = v9;
                }

                goto label_404;
            label_376:
                this.guideBegin = v11.getDimensionPixelOffset(v4, this.guideBegin);
                goto label_404;
            label_312:
                v5 = v11.getResourceId(v4, this.bottomToBottom);
                this.bottomToBottom = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.bottomToBottom = v11.getInt(v4, v0);
                goto label_404;
            label_249:
                this.constrainedWidth = v11.getBoolean(v4, this.constrainedWidth);
                goto label_404;
            label_380:
                v5_2 = 360f;
                v4_2 = v11.getFloat(v4, this.circleAngle) % v5_2;
                this.circleAngle = v4_2;
                if(v4_2 >= 0f) {
                    goto label_404;
                }

                this.circleAngle = (v5_2 - v4_2) % v5_2;
                goto label_404;
            label_253:
                this.goneEndMargin = v11.getDimensionPixelSize(v4, this.goneEndMargin);
                goto label_404;
            label_319:
                v5 = v11.getResourceId(v4, this.bottomToTop);
                this.bottomToTop = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.bottomToTop = v11.getInt(v4, v0);
                goto label_404;
                try {
                label_192:
                    this.matchConstraintMinHeight = v11.getDimensionPixelSize(v4, this.matchConstraintMinHeight);
                }
                catch(Exception ) {
                    if(v11.getInt(v4, this.matchConstraintMinHeight) != v9) {
                        goto label_404;
                    }

                    this.matchConstraintMinHeight = v9;
                }

                goto label_404;
            label_257:
                this.goneStartMargin = v11.getDimensionPixelSize(v4, this.goneStartMargin);
                goto label_404;
            label_261:
                this.goneBottomMargin = v11.getDimensionPixelSize(v4, this.goneBottomMargin);
                goto label_404;
            label_390:
                this.circleRadius = v11.getDimensionPixelSize(v4, this.circleRadius);
                goto label_404;
            label_326:
                v5 = v11.getResourceId(v4, this.topToBottom);
                this.topToBottom = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.topToBottom = v11.getInt(v4, v0);
                goto label_404;
            label_265:
                this.goneRightMargin = v11.getDimensionPixelSize(v4, this.goneRightMargin);
                goto label_404;
            label_201:
                this.matchConstraintPercentWidth = Math.max(0f, v11.getFloat(v4, this.matchConstraintPercentWidth));
                this.matchConstraintDefaultWidth = v8;
                goto label_404;
            label_394:
                v5 = v11.getResourceId(v4, this.circleConstraint);
                this.circleConstraint = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.circleConstraint = v11.getInt(v4, v0);
                goto label_404;
            label_333:
                v5 = v11.getResourceId(v4, this.topToTop);
                this.topToTop = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.topToTop = v11.getInt(v4, v0);
                goto label_404;
            label_269:
                this.goneTopMargin = v11.getDimensionPixelSize(v4, this.goneTopMargin);
                goto label_404;
                try {
                label_207:
                    this.matchConstraintMaxWidth = v11.getDimensionPixelSize(v4, this.matchConstraintMaxWidth);
                }
                catch(Exception ) {
                    if(v11.getInt(v4, this.matchConstraintMaxWidth) != v9) {
                        goto label_404;
                    }

                    this.matchConstraintMaxWidth = v9;
                }

                goto label_404;
            label_401:
                this.orientation = v11.getInt(v4, this.orientation);
                goto label_404;
            label_273:
                this.goneLeftMargin = v11.getDimensionPixelSize(v4, this.goneLeftMargin);
                goto label_404;
            label_340:
                v5 = v11.getResourceId(v4, this.rightToRight);
                this.rightToRight = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.rightToRight = v11.getInt(v4, v0);
                goto label_404;
            label_277:
                v5 = v11.getResourceId(v4, this.endToEnd);
                this.endToEnd = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.endToEnd = v11.getInt(v4, v0);
                goto label_404;
                try {
                label_216:
                    this.matchConstraintMinWidth = v11.getDimensionPixelSize(v4, this.matchConstraintMinWidth);
                }
                catch(Exception ) {
                    if(v11.getInt(v4, this.matchConstraintMinWidth) != v9) {
                        goto label_404;
                    }

                    this.matchConstraintMinWidth = v9;
                }

                goto label_404;
            label_347:
                v5 = v11.getResourceId(v4, this.rightToLeft);
                this.rightToLeft = v5;
                if(v5 != v0) {
                    goto label_404;
                }

                this.rightToLeft = v11.getInt(v4, v0);
                goto label_404;
            label_284:
                v5 = v11.getResourceId(v4, this.endToStart);
                this.endToStart = v5;
                if(v5 == v0) {
                    this.endToStart = v11.getInt(v4, v0);
                }

            label_404:
            }

            v11.recycle();
            this.validate();
        }

        public LayoutParams(LayoutParams arg7) {
            super(((ViewGroup$MarginLayoutParams)arg7));
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1f;
            this.verticalWeight = -1f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1f;
            this.matchConstraintPercentHeight = 1f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = arg7.guideBegin;
            this.guideEnd = arg7.guideEnd;
            this.guidePercent = arg7.guidePercent;
            this.leftToLeft = arg7.leftToLeft;
            this.leftToRight = arg7.leftToRight;
            this.rightToLeft = arg7.rightToLeft;
            this.rightToRight = arg7.rightToRight;
            this.topToTop = arg7.topToTop;
            this.topToBottom = arg7.topToBottom;
            this.bottomToTop = arg7.bottomToTop;
            this.bottomToBottom = arg7.bottomToBottom;
            this.baselineToBaseline = arg7.baselineToBaseline;
            this.circleConstraint = arg7.circleConstraint;
            this.circleRadius = arg7.circleRadius;
            this.circleAngle = arg7.circleAngle;
            this.startToEnd = arg7.startToEnd;
            this.startToStart = arg7.startToStart;
            this.endToStart = arg7.endToStart;
            this.endToEnd = arg7.endToEnd;
            this.goneLeftMargin = arg7.goneLeftMargin;
            this.goneTopMargin = arg7.goneTopMargin;
            this.goneRightMargin = arg7.goneRightMargin;
            this.goneBottomMargin = arg7.goneBottomMargin;
            this.goneStartMargin = arg7.goneStartMargin;
            this.goneEndMargin = arg7.goneEndMargin;
            this.horizontalBias = arg7.horizontalBias;
            this.verticalBias = arg7.verticalBias;
            this.dimensionRatio = arg7.dimensionRatio;
            this.dimensionRatioValue = arg7.dimensionRatioValue;
            this.dimensionRatioSide = arg7.dimensionRatioSide;
            this.horizontalWeight = arg7.horizontalWeight;
            this.verticalWeight = arg7.verticalWeight;
            this.horizontalChainStyle = arg7.horizontalChainStyle;
            this.verticalChainStyle = arg7.verticalChainStyle;
            this.constrainedWidth = arg7.constrainedWidth;
            this.constrainedHeight = arg7.constrainedHeight;
            this.matchConstraintDefaultWidth = arg7.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = arg7.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = arg7.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = arg7.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = arg7.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = arg7.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = arg7.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = arg7.matchConstraintPercentHeight;
            this.editorAbsoluteX = arg7.editorAbsoluteX;
            this.editorAbsoluteY = arg7.editorAbsoluteY;
            this.orientation = arg7.orientation;
            this.horizontalDimensionFixed = arg7.horizontalDimensionFixed;
            this.verticalDimensionFixed = arg7.verticalDimensionFixed;
            this.needsBaseline = arg7.needsBaseline;
            this.isGuideline = arg7.isGuideline;
            this.resolvedLeftToLeft = arg7.resolvedLeftToLeft;
            this.resolvedLeftToRight = arg7.resolvedLeftToRight;
            this.resolvedRightToLeft = arg7.resolvedRightToLeft;
            this.resolvedRightToRight = arg7.resolvedRightToRight;
            this.resolveGoneLeftMargin = arg7.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = arg7.resolveGoneRightMargin;
            this.resolvedHorizontalBias = arg7.resolvedHorizontalBias;
            this.constraintTag = arg7.constraintTag;
            this.widget = arg7.widget;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget v0 = this.widget;
            if(v0 != null) {
                v0.reset();
            }
        }

        public void resolveLayoutDirection(int arg13) {
            int v10;
            int v0 = this.leftMargin;
            int v1 = this.rightMargin;
            super.resolveLayoutDirection(arg13);
            int v2 = 0;
            arg13 = 1 == this.getLayoutDirection() ? 1 : 0;
            int v4 = -1;
            this.resolvedRightToLeft = v4;
            this.resolvedRightToRight = v4;
            this.resolvedLeftToLeft = v4;
            this.resolvedLeftToRight = v4;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float v5 = this.horizontalBias;
            this.resolvedHorizontalBias = v5;
            int v6 = this.guideBegin;
            this.resolvedGuideBegin = v6;
            int v7 = this.guideEnd;
            this.resolvedGuideEnd = v7;
            float v8 = this.guidePercent;
            this.resolvedGuidePercent = v8;
            int v9 = this.startToEnd;
            if(arg13 != 0) {
                if(v9 != v4) {
                    this.resolvedRightToLeft = v9;
                    goto label_31;
                }
                else {
                    arg13 = this.startToStart;
                    if(arg13 != v4) {
                        this.resolvedRightToRight = arg13;
                    label_31:
                        v2 = 1;
                    }
                }

                arg13 = this.endToStart;
                if(arg13 != v4) {
                    this.resolvedLeftToRight = arg13;
                    v2 = 1;
                }

                v10 = this.endToEnd;
                if(v10 != v4) {
                    this.resolvedLeftToLeft = v10;
                    v2 = 1;
                }

                int v11 = this.goneStartMargin;
                if(v11 != v4) {
                    this.resolveGoneRightMargin = v11;
                }

                v11 = this.goneEndMargin;
                if(v11 != v4) {
                    this.resolveGoneLeftMargin = v11;
                }

                float v11_1 = 1f;
                if(v2 != 0) {
                    this.resolvedHorizontalBias = v11_1 - v5;
                }

                if(!this.isGuideline) {
                    goto label_93;
                }

                if(this.orientation != 1) {
                    goto label_93;
                }

                float v2_1 = -1f;
                if(v8 != v2_1) {
                    this.resolvedGuidePercent = v11_1 - v8;
                    this.resolvedGuideBegin = v4;
                    this.resolvedGuideEnd = v4;
                    goto label_93;
                }

                if(v6 != v4) {
                    this.resolvedGuideEnd = v6;
                    this.resolvedGuideBegin = v4;
                    this.resolvedGuidePercent = v2_1;
                    goto label_93;
                }

                if(v7 == v4) {
                    goto label_93;
                }

                this.resolvedGuideBegin = v7;
                this.resolvedGuideEnd = v4;
                this.resolvedGuidePercent = v2_1;
            }
            else {
                if(v9 != v4) {
                    this.resolvedLeftToRight = v9;
                }

                arg13 = this.startToStart;
                if(arg13 != v4) {
                    this.resolvedLeftToLeft = arg13;
                }

                arg13 = this.endToStart;
                if(arg13 != v4) {
                    this.resolvedRightToLeft = arg13;
                }

                v10 = this.endToEnd;
                if(v10 != v4) {
                    this.resolvedRightToRight = v10;
                }

                v2 = this.goneStartMargin;
                if(v2 != v4) {
                    this.resolveGoneLeftMargin = v2;
                }

                v2 = this.goneEndMargin;
                if(v2 == v4) {
                    goto label_93;
                }

                this.resolveGoneRightMargin = v2;
            }

        label_93:
            if(arg13 == v4 && v10 == v4 && this.startToStart == v4 && v9 == v4) {
                arg13 = this.rightToLeft;
                if(arg13 != v4) {
                    this.resolvedRightToLeft = arg13;
                    if(this.rightMargin <= 0 && v1 > 0) {
                        this.rightMargin = v1;
                    }
                }
                else {
                    arg13 = this.rightToRight;
                    if(arg13 != v4) {
                        this.resolvedRightToRight = arg13;
                        if(this.rightMargin <= 0 && v1 > 0) {
                            this.rightMargin = v1;
                        }
                    }
                }

                arg13 = this.leftToLeft;
                if(arg13 != v4) {
                    this.resolvedLeftToLeft = arg13;
                    if(this.leftMargin > 0) {
                        return;
                    }

                    if(v0 <= 0) {
                        return;
                    }

                    this.leftMargin = v0;
                    return;
                }

                arg13 = this.leftToRight;
                if(arg13 == v4) {
                    return;
                }

                this.resolvedLeftToRight = arg13;
                if(this.leftMargin > 0) {
                    return;
                }

                if(v0 <= 0) {
                    return;
                }

                this.leftMargin = v0;
            }
        }

        public void setWidgetDebugName(String arg1) {
            this.widget.setDebugName(arg1);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int v3 = -2;
            if(this.width == v3 && (this.constrainedWidth)) {
                this.horizontalDimensionFixed = false;
                if(this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }

            if(this.height == v3 && (this.constrainedHeight)) {
                this.verticalDimensionFixed = false;
                if(this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }

            int v4 = -1;
            if(this.width == 0 || this.width == v4) {
                this.horizontalDimensionFixed = false;
                if(this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = v3;
                    this.constrainedWidth = true;
                }
            }

            if(this.height == 0 || this.height == v4) {
                this.verticalDimensionFixed = false;
                if(this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = v3;
                    this.constrainedHeight = true;
                }
            }

            if(this.guidePercent == -1f && this.guideBegin == v4) {
                if(this.guideEnd != v4) {
                }
                else {
                    return;
                }
            }

            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if(!(this.widget instanceof Guideline)) {
                this.widget = new Guideline();
            }

            this.widget.setOrientation(this.orientation);
        }
    }

    class Measurer implements androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;

        public Measurer(ConstraintLayout arg1, ConstraintLayout arg2) {
            ConstraintLayout.this = arg1;
            super();
            this.layout = arg2;
        }

        public void captureLayoutInfos(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
            this.paddingTop = arg3;
            this.paddingBottom = arg4;
            this.paddingWidth = arg5;
            this.paddingHeight = arg6;
            this.layoutWidthSpec = arg1;
            this.layoutHeightSpec = arg2;
        }

        public final void didMeasures() {
            ConstraintLayout v3;
            int v0 = this.layout.getChildCount();
            int v1 = 0;
            int v2;
            for(v2 = 0; true; ++v2) {
                v3 = this.layout;
                if(v2 >= v0) {
                    break;
                }

                View v3_1 = v3.getChildAt(v2);
                if((v3_1 instanceof Placeholder)) {
                    ((Placeholder)v3_1).updatePostMeasure(this.layout);
                }
            }

            v0 = v3.mConstraintHelpers.size();
            if(v0 > 0) {
                while(v1 < v0) {
                    this.layout.mConstraintHelpers.get(v1).updatePostMeasure(this.layout);
                    ++v1;
                }
            }
        }

        public final void measure(ConstraintWidget arg20, Measure arg21) {
            int v0_1;
            Measurer v0 = this;
            ConstraintWidget v1 = arg20;
            Measure v2 = arg21;
            if(v1 == null) {
                return;
            }

            if(v1.getVisibility() == 8 && !v1.isInPlaceholder()) {
                v2.measuredWidth = 0;
                v2.measuredHeight = 0;
                v2.measuredBaseline = 0;
                return;
            }

            DimensionBehaviour v3 = v2.horizontalBehavior;
            DimensionBehaviour v4 = v2.verticalBehavior;
            int v6 = v2.horizontalDimension;
            int v7 = v2.verticalDimension;
            int v8 = v0.paddingTop + v0.paddingBottom;
            int v9 = v0.paddingWidth;
            Object v10 = v1.getCompanionWidget();
            int v11 = androidx.constraintlayout.widget.ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[v3.ordinal()];
            int v12 = 4;
            int v14 = -2;
            int v5 = 3;
            int v13 = 2;
            if(v11 != 1) {
                if(v11 == v13) {
                    v6 = ViewGroup.getChildMeasureSpec(v0.layoutWidthSpec, v9, v14);
                    v1.wrapMeasure[v13] = v14;
                }
                else if(v11 == v5) {
                    v6 = ViewGroup.getChildMeasureSpec(v0.layoutWidthSpec, v9 + v1.getHorizontalMargin(), -1);
                    v1.wrapMeasure[v13] = -1;
                    goto label_89;
                }
                else if(v11 != v12) {
                    v6 = 0;
                    v9 = 0;
                    goto label_90;
                }
                else {
                    v6 = ViewGroup.getChildMeasureSpec(v0.layoutWidthSpec, v9, v14);
                    v9 = v1.mMatchConstraintDefaultWidth == 1 ? 1 : 0;
                    v1.wrapMeasure[v13] = 0;
                    if(!v2.useCurrentDimensions) {
                        goto label_82;
                    }

                    v11 = v9 != 0 && v1.wrapMeasure[v5] != 0 && v1.wrapMeasure[0] != v1.getWidth() || ((v10 instanceof Placeholder)) ? 1 : 0;
                    if(v9 != 0 && v11 == 0) {
                        goto label_82;
                    }

                    v6 = View$MeasureSpec.makeMeasureSpec(v1.getWidth(), 0x40000000);
                    goto label_89;
                }

            label_82:
                v9 = 1;
            }
            else {
                v11 = View$MeasureSpec.makeMeasureSpec(v6, 0x40000000);
                v1.wrapMeasure[v13] = v6;
                v6 = v11;
            label_89:
                v9 = 0;
            }

        label_90:
            v11 = androidx.constraintlayout.widget.ConstraintLayout$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[v4.ordinal()];
            if(v11 != 1) {
                if(v11 == v13) {
                    v0_1 = ViewGroup.getChildMeasureSpec(v0.layoutHeightSpec, v8, v14);
                    v1.wrapMeasure[v5] = v14;
                }
                else if(v11 == v5) {
                    v0_1 = ViewGroup.getChildMeasureSpec(v0.layoutHeightSpec, v8 + v1.getVerticalMargin(), -1);
                    v1.wrapMeasure[v5] = -1;
                    goto label_150;
                }
                else if(v11 != 4) {
                    v0_1 = 0;
                    v7 = 0;
                    goto label_151;
                }
                else {
                    v0_1 = ViewGroup.getChildMeasureSpec(v0.layoutHeightSpec, v8, v14);
                    v7 = v1.mMatchConstraintDefaultHeight == 1 ? 1 : 0;
                    v1.wrapMeasure[v5] = 0;
                    if(!v2.useCurrentDimensions) {
                        goto label_143;
                    }

                    v8 = v7 != 0 && v1.wrapMeasure[v13] != 0 && v1.wrapMeasure[1] != v1.getHeight() || ((v10 instanceof Placeholder)) ? 1 : 0;
                    if(v7 != 0 && v8 == 0) {
                        goto label_143;
                    }

                    v0_1 = View$MeasureSpec.makeMeasureSpec(v1.getHeight(), 0x40000000);
                    goto label_150;
                }

            label_143:
                v7 = 1;
            }
            else {
                v8 = View$MeasureSpec.makeMeasureSpec(v7, 0x40000000);
                v1.wrapMeasure[v5] = v7;
                v0_1 = v8;
            label_150:
                v7 = 0;
            }

        label_151:
            v8 = v3 == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
            v11 = v4 == DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
            int v4_1 = v4 == DimensionBehaviour.MATCH_PARENT || v4 == DimensionBehaviour.FIXED ? 1 : 0;
            int v3_1 = v3 == DimensionBehaviour.MATCH_PARENT || v3 == DimensionBehaviour.FIXED ? 1 : 0;
            v14 = v8 == 0 || v1.mDimensionRatio <= 0f ? 0 : 1;
            int v17 = v5;
            v5 = v11 == 0 || v1.mDimensionRatio <= 0f ? 0 : 1;
            ViewGroup$LayoutParams v12_1 = ((View)v10).getLayoutParams();
            int v18 = v13;
            if((v2.useCurrentDimensions) || v8 == 0 || v1.mMatchConstraintDefaultWidth != 0 || v11 == 0 || v1.mMatchConstraintDefaultHeight != 0) {
                if(!(v10 instanceof VirtualLayout) || !(v1 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                    ((View)v10).measure(v6, v0_1);
                }
                else {
                    v10.onMeasure(v1, v6, v0_1);
                }

                v8 = ((View)v10).getMeasuredWidth();
                v11 = ((View)v10).getMeasuredHeight();
                v13 = ((View)v10).getBaseline();
                if(v9 != 0) {
                    v1.wrapMeasure[0] = v8;
                    v1.wrapMeasure[v18] = v11;
                }
                else {
                    v1.wrapMeasure[0] = 0;
                    v1.wrapMeasure[v18] = 0;
                }

                if(v7 != 0) {
                    v1.wrapMeasure[1] = v11;
                    v1.wrapMeasure[v17] = v8;
                }
                else {
                    v1.wrapMeasure[1] = 0;
                    v1.wrapMeasure[v17] = 0;
                }

                v7 = v1.mMatchConstraintMinWidth > 0 ? Math.max(v1.mMatchConstraintMinWidth, v8) : v8;
                if(v1.mMatchConstraintMaxWidth > 0) {
                    v7 = Math.min(v1.mMatchConstraintMaxWidth, v7);
                }

                v9 = v1.mMatchConstraintMinHeight > 0 ? Math.max(v1.mMatchConstraintMinHeight, v11) : v11;
                if(v1.mMatchConstraintMaxHeight > 0) {
                    v9 = Math.min(v1.mMatchConstraintMaxHeight, v9);
                }

                float v15 = 0.5f;
                if(v14 != 0 && v4_1 != 0) {
                    v7 = ((int)((((float)v9)) * v1.mDimensionRatio + v15));
                }
                else if(v5 != 0 && v3_1 != 0) {
                    v9 = ((int)((((float)v7)) / v1.mDimensionRatio + v15));
                }

                if(v8 == v7 && v11 == v9) {
                    goto label_205;
                }

                v3_1 = 0x40000000;
                if(v8 != v7) {
                    v6 = View$MeasureSpec.makeMeasureSpec(v7, v3_1);
                }

                if(v11 != v9) {
                    v0_1 = View$MeasureSpec.makeMeasureSpec(v9, v3_1);
                }

                ((View)v10).measure(v6, v0_1);
                v7 = ((View)v10).getMeasuredWidth();
                v9 = ((View)v10).getMeasuredHeight();
                v13 = ((View)v10).getBaseline();
            }
            else {
                v7 = 0;
                v9 = 0;
                v13 = 0;
            }

        label_205:
            v11 = -1;
            boolean v0_2 = v13 != v11 ? true : false;
            boolean v5_1 = v7 != v2.horizontalDimension || v9 != v2.verticalDimension ? true : false;
            v2.measuredNeedsSolverPass = v5_1;
            if(((LayoutParams)v12_1).needsBaseline) {
                v0_2 = true;
            }

            if((v0_2) && v13 != -1 && v1.getBaselineDistance() != v13) {
                v2.measuredNeedsSolverPass = true;
            }

            v2.measuredWidth = v7;
            v2.measuredHeight = v9;
            v2.measuredHasBaseline = v0_2;
            v2.measuredBaseline = v13;
        }
    }

    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.1";
    SparseArray mChildrenByIds;
    private ArrayList mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray mTempMapIdToWidget;

    public ConstraintLayout(Context arg4) {
        super(arg4);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = 0x7FFFFFFF;
        this.mMaxHeight = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 0x107;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(null, 0, 0);
    }

    public ConstraintLayout(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = 0x7FFFFFFF;
        this.mMaxHeight = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 0x107;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(arg4, 0, 0);
    }

    public ConstraintLayout(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = 0x7FFFFFFF;
        this.mMaxHeight = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 0x107;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(arg4, arg5, 0);
    }

    public ConstraintLayout(Context arg3, AttributeSet arg4, int arg5, int arg6) {
        super(arg3, arg4, arg5, arg6);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = 0x7FFFFFFF;
        this.mMaxHeight = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 0x107;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(arg4, arg5, arg6);
    }

    static ArrayList access$000(ConstraintLayout arg0) {
        return arg0.mConstraintHelpers;
    }

    public void addView(View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        super.addView(arg1, arg2, arg3);
    }

    protected void applyConstraintsFromLayoutParams(boolean arg17, View arg18, ConstraintWidget arg19, LayoutParams arg20, SparseArray arg21) {
        Object v3_2;
        ConstraintWidget v1_2;
        Object v0_2;
        int v2_1;
        int v1_1;
        ConstraintLayout v0 = this;
        View v1 = arg18;
        ConstraintWidget v2 = arg19;
        LayoutParams v7 = arg20;
        SparseArray v8 = arg21;
        v7.validate();
        v7.helped = false;
        v2.setVisibility(v1.getVisibility());
        if(v7.isInPlaceholder) {
            v2.setInPlaceholder(true);
            v2.setVisibility(8);
        }

        v2.setCompanionWidget(v1);
        if((v1 instanceof ConstraintHelper)) {
            ((ConstraintHelper)v1).resolveRtl(v2, v0.mLayoutWidget.isRtl());
        }

        int v11 = -1;
        if(v7.isGuideline) {
            ConstraintWidget v0_1 = v2;
            v1_1 = v7.resolvedGuideBegin;
            v2_1 = v7.resolvedGuideEnd;
            float v3 = v7.resolvedGuidePercent;
            if(v3 != -1f) {
                ((Guideline)v0_1).setGuidePercent(v3);
                return;
            }

            if(v1_1 != v11) {
                ((Guideline)v0_1).setGuideBegin(v1_1);
                return;
            }

            if(v2_1 != v11) {
                ((Guideline)v0_1).setGuideEnd(v2_1);
            }

            return;
        }

        v1_1 = v7.resolvedLeftToLeft;
        int v3_1 = v7.resolvedLeftToRight;
        int v12 = v7.resolvedRightToLeft;
        int v13 = v7.resolvedRightToRight;
        int v6 = v7.resolveGoneLeftMargin;
        int v14 = v7.resolveGoneRightMargin;
        float v15 = v7.resolvedHorizontalBias;
        if(v7.circleConstraint != v11) {
            v0_2 = v8.get(v7.circleConstraint);
            if(v0_2 != null) {
                v2.connectCircularConstraint(((ConstraintWidget)v0_2), v7.circleAngle, v7.circleRadius);
            }

            v1_2 = v2;
        }
        else {
            if(v1_1 != v11) {
                v3_2 = v8.get(v1_1);
                if(v3_2 != null) {
                    arg19.immediateConnect(Type.LEFT, ((ConstraintWidget)v3_2), Type.LEFT, v7.leftMargin, v6);
                }
            }
            else if(v3_1 != v11) {
                v3_2 = v8.get(v3_1);
                if(v3_2 != null) {
                    arg19.immediateConnect(Type.LEFT, ((ConstraintWidget)v3_2), Type.RIGHT, v7.leftMargin, v6);
                }
            }

            if(v12 != v11) {
                v3_2 = v8.get(v12);
                if(v3_2 != null) {
                    arg19.immediateConnect(Type.RIGHT, ((ConstraintWidget)v3_2), Type.LEFT, v7.rightMargin, v14);
                }
            }
            else {
                v6 = v14;
                if(v13 != v11) {
                    v3_2 = v8.get(v13);
                    if(v3_2 != null) {
                        arg19.immediateConnect(Type.RIGHT, ((ConstraintWidget)v3_2), Type.RIGHT, v7.rightMargin, v6);
                    }
                }
            }

            if(v7.topToTop != v11) {
                v3_2 = v8.get(v7.topToTop);
                if(v3_2 != null) {
                    arg19.immediateConnect(Type.TOP, ((ConstraintWidget)v3_2), Type.TOP, v7.topMargin, v7.goneTopMargin);
                }
            }
            else if(v7.topToBottom != v11) {
                v3_2 = v8.get(v7.topToBottom);
                if(v3_2 != null) {
                    arg19.immediateConnect(Type.TOP, ((ConstraintWidget)v3_2), Type.BOTTOM, v7.topMargin, v7.goneTopMargin);
                }
            }

            if(v7.bottomToTop != v11) {
                v3_2 = v8.get(v7.bottomToTop);
                if(v3_2 != null) {
                    arg19.immediateConnect(Type.BOTTOM, ((ConstraintWidget)v3_2), Type.TOP, v7.bottomMargin, v7.goneBottomMargin);
                }
                else {
                }

                goto label_147;
            }
            else if(v7.bottomToBottom != v11) {
                v3_2 = v8.get(v7.bottomToBottom);
                if(v3_2 != null) {
                    v1_2 = arg19;
                    v1_2.immediateConnect(Type.BOTTOM, ((ConstraintWidget)v3_2), Type.BOTTOM, v7.bottomMargin, v7.goneBottomMargin);
                }
                else {
                    goto label_147;
                }
            }
            else {
            label_147:
                v1_2 = arg19;
            }

            if(v7.baselineToBaseline != v11) {
                v0_2 = v0.mChildrenByIds.get(v7.baselineToBaseline);
                Object v2_2 = v8.get(v7.baselineToBaseline);
                if(v2_2 != null && v0_2 != null && ((((View)v0_2).getLayoutParams() instanceof LayoutParams))) {
                    ViewGroup$LayoutParams v0_3 = ((View)v0_2).getLayoutParams();
                    v7.needsBaseline = true;
                    ((LayoutParams)v0_3).needsBaseline = true;
                    v1_2.getAnchor(Type.BASELINE).connect(((ConstraintWidget)v2_2).getAnchor(Type.BASELINE), 0, v11, true);
                    v1_2.setHasBaseline(true);
                    ((LayoutParams)v0_3).widget.setHasBaseline(true);
                    v1_2.getAnchor(Type.TOP).reset();
                    v1_2.getAnchor(Type.BOTTOM).reset();
                }
            }

            if(v15 >= 0f) {
                v1_2.setHorizontalBiasPercent(v15);
            }

            if(v7.verticalBias < 0f) {
                goto label_184;
            }

            v1_2.setVerticalBiasPercent(v7.verticalBias);
        }

    label_184:
        if((arg17) && (v7.editorAbsoluteX != v11 || v7.editorAbsoluteY != v11)) {
            v1_2.setOrigin(v7.editorAbsoluteX, v7.editorAbsoluteY);
        }

        v2_1 = -2;
        if(v7.horizontalDimensionFixed) {
            v1_2.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
            v1_2.setWidth(v7.width);
            if(v7.width != v2_1) {
                goto label_225;
            }

            v1_2.setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
        }
        else if(v7.width == v11) {
            if(v7.constrainedWidth) {
                v1_2.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
            }
            else {
                v1_2.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
            }

            v1_2.getAnchor(Type.LEFT).mMargin = v7.leftMargin;
            v1_2.getAnchor(Type.RIGHT).mMargin = v7.rightMargin;
        }
        else {
            v1_2.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
            v1_2.setWidth(0);
        }

    label_225:
        if(v7.verticalDimensionFixed) {
            v1_2.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            v1_2.setHeight(v7.height);
            if(v7.height != v2_1) {
                goto label_257;
            }

            v1_2.setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
        }
        else if(v7.height == v11) {
            if(v7.constrainedHeight) {
                v1_2.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
            }
            else {
                v1_2.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
            }

            v1_2.getAnchor(Type.TOP).mMargin = v7.topMargin;
            v1_2.getAnchor(Type.BOTTOM).mMargin = v7.bottomMargin;
        }
        else {
            v1_2.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
            v1_2.setHeight(0);
        }

    label_257:
        v1_2.setDimensionRatio(v7.dimensionRatio);
        v1_2.setHorizontalWeight(v7.horizontalWeight);
        v1_2.setVerticalWeight(v7.verticalWeight);
        v1_2.setHorizontalChainStyle(v7.horizontalChainStyle);
        v1_2.setVerticalChainStyle(v7.verticalChainStyle);
        v1_2.setHorizontalMatchStyle(v7.matchConstraintDefaultWidth, v7.matchConstraintMinWidth, v7.matchConstraintMaxWidth, v7.matchConstraintPercentWidth);
        v1_2.setVerticalMatchStyle(v7.matchConstraintDefaultHeight, v7.matchConstraintMinHeight, v7.matchConstraintMaxHeight, v7.matchConstraintPercentHeight);
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    protected void dispatchDraw(Canvas arg18) {
        int v1_1;
        ConstraintLayout v0 = this;
        ArrayList v1 = v0.mConstraintHelpers;
        if(v1 != null) {
            v1_1 = v1.size();
            if(v1_1 > 0) {
                int v3;
                for(v3 = 0; v3 < v1_1; ++v3) {
                    v0.mConstraintHelpers.get(v3).updatePreDraw(v0);
                }
            }
        }

        super.dispatchDraw(arg18);
        if(v0.isInEditMode()) {
            v1_1 = v0.getChildCount();
            float v3_1 = ((float)v0.getWidth());
            float v4 = ((float)v0.getHeight());
            int v5;
            for(v5 = 0; v5 < v1_1; ++v5) {
                View v6 = v0.getChildAt(v5);
                if(v6.getVisibility() == 8) {
                }
                else {
                    Object v6_1 = v6.getTag();
                    if(v6_1 != null && ((v6_1 instanceof String))) {
                        String[] v6_2 = ((String)v6_1).split(",");
                        if(v6_2.length == 4) {
                            int v7 = Integer.parseInt(v6_2[0]);
                            int v8 = Integer.parseInt(v6_2[1]);
                            int v9 = Integer.parseInt(v6_2[2]);
                            v7 = ((int)((((float)v7)) / 1080f * v3_1));
                            v8 = ((int)((((float)v8)) / 1920f * v4));
                            int v6_3 = ((int)((((float)Integer.parseInt(v6_2[3]))) / 1920f * v4));
                            Paint v15 = new Paint();
                            v15.setColor(0xFFFF0000);
                            float v11 = ((float)v7);
                            float v12 = ((float)v8);
                            float v13 = ((float)(v7 + (((int)((((float)v9)) / 1080f * v3_1)))));
                            arg18.drawLine(v11, v12, v13, v12, v15);
                            float v14 = ((float)(v8 + v6_3));
                            arg18.drawLine(v13, v12, v13, v14, v15);
                            arg18.drawLine(v13, v14, v11, v14, v15);
                            arg18.drawLine(v11, v14, v11, v12, v15);
                            v15.setColor(0xFF00FF00);
                            arg18.drawLine(v11, v12, v13, v14, v15);
                            arg18.drawLine(v11, v14, v13, v12, v15);
                        }
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics arg1) {
        this.mMetrics = arg1;
        this.mLayoutWidget.fillMetrics(arg1);
    }

    public void forceLayout() {
        this.markHierarchyDirty();
        super.forceLayout();
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return new LayoutParams(arg1);
    }

    public Object getDesignInformation(int arg1, Object arg2) {
        if(arg1 == 0 && ((arg2 instanceof String))) {
            HashMap v1 = this.mDesignIds;
            if(v1 != null && (v1.containsKey(arg2))) {
                return this.mDesignIds.get(arg2);
            }
        }

        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    private int getPaddingWidth() {
        int v0 = Math.max(0, this.getPaddingLeft()) + Math.max(0, this.getPaddingRight());
        int v2 = Math.max(0, this.getPaddingStart()) + Math.max(0, this.getPaddingEnd());
        if(v2 > 0) {
            return v2;
        }

        return v0;
    }

    private final ConstraintWidget getTargetWidget(int arg2) {
        if(arg2 == 0) {
            return this.mLayoutWidget;
        }

        Object v0 = this.mChildrenByIds.get(arg2);
        if(v0 == null) {
            View v0_1 = this.findViewById(arg2);
            if(v0_1 != null && (((ConstraintLayout)v0_1)) != this && v0_1.getParent() == this) {
                this.onViewAdded(v0_1);
            }
        }

        if((((ConstraintLayout)v0)) == this) {
            return this.mLayoutWidget;
        }

        if(v0 == null) {
            return null;
        }

        return ((View)v0).getLayoutParams().widget;
    }

    public View getViewById(int arg1) {
        return this.mChildrenByIds.get(arg1);
    }

    public final ConstraintWidget getViewWidget(View arg1) {
        if((((ConstraintLayout)arg1)) == this) {
            return this.mLayoutWidget;
        }

        if(arg1 == null) {
            return null;
        }

        return arg1.getLayoutParams().widget;
    }

    private void init(AttributeSet arg6, int arg7, int arg8) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(this.getId(), this);
        ConstraintSet v0 = null;
        this.mConstraintSet = v0;
        if(arg6 != null) {
            TypedArray v6 = this.getContext().obtainStyledAttributes(arg6, styleable.ConstraintLayout_Layout, arg7, arg8);
            arg7 = v6.getIndexCount();
            int v1;
            for(v1 = 0; v1 < arg7; ++v1) {
                int v2 = v6.getIndex(v1);
                if(v2 == styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = v6.getDimensionPixelOffset(v2, this.mMinWidth);
                    goto label_68;
                }

                if(v2 == styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = v6.getDimensionPixelOffset(v2, this.mMinHeight);
                    goto label_68;
                }

                if(v2 == styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = v6.getDimensionPixelOffset(v2, this.mMaxWidth);
                    goto label_68;
                }

                if(v2 == styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = v6.getDimensionPixelOffset(v2, this.mMaxHeight);
                    goto label_68;
                }

                if(v2 == styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = v6.getInt(v2, this.mOptimizationLevel);
                    goto label_68;
                }

                if(v2 == styleable.ConstraintLayout_Layout_layoutDescription) {
                    v2 = v6.getResourceId(v2, 0);
                    if(v2 == 0) {
                        goto label_68;
                    }

                    try {
                        this.parseLayoutDescription(v2);
                    }
                    catch(Resources$NotFoundException ) {
                        this.mConstraintLayoutSpec = ((ConstraintLayoutStates)v0);
                    }

                    goto label_68;
                }

                if(v2 == styleable.ConstraintLayout_Layout_constraintSet) {
                    v2 = v6.getResourceId(v2, 0);
                    try {
                        ConstraintSet v3 = new ConstraintSet();
                        this.mConstraintSet = v3;
                        v3.load(this.getContext(), v2);
                    }
                    catch(Resources$NotFoundException ) {
                        this.mConstraintSet = v0;
                    }

                    this.mConstraintSetId = v2;
                }

            label_68:
            }

            v6.recycle();
        }

        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    protected boolean isRtl() {
        if((this.getContext().getApplicationInfo().flags & 0x400000) != 0 && 1 == this.getLayoutDirection()) {
            return 1;
        }

        return 0;
    }

    public void loadLayoutDescription(int arg4) {
        ConstraintLayoutStates v0 = null;
        if(arg4 != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(this.getContext(), this, arg4);
                return;
            }
            catch(Resources$NotFoundException ) {
                this.mConstraintLayoutSpec = v0;
                return;
            }
        }

        this.mConstraintLayoutSpec = v0;
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    protected void onLayout(boolean arg6, int arg7, int arg8, int arg9, int arg10) {
        int v6 = this.getChildCount();
        boolean v7 = this.isInEditMode();
        arg8 = 0;
        for(arg9 = 0; arg9 < v6; ++arg9) {
            View v10 = this.getChildAt(arg9);
            ViewGroup$LayoutParams v0 = v10.getLayoutParams();
            ConstraintWidget v1 = ((LayoutParams)v0).widget;
            if(v10.getVisibility() == 8 && !((LayoutParams)v0).isGuideline && !((LayoutParams)v0).isHelper && !((LayoutParams)v0).isVirtualGroup && !v7) {
            }
            else if(((LayoutParams)v0).isInPlaceholder) {
            }
            else {
                int v0_1 = v1.getX();
                int v2 = v1.getY();
                int v3 = v1.getWidth() + v0_1;
                int v1_1 = v1.getHeight() + v2;
                v10.layout(v0_1, v2, v3, v1_1);
                if((v10 instanceof Placeholder)) {
                    v10 = ((Placeholder)v10).getContent();
                    if(v10 != null) {
                        v10.setVisibility(0);
                        v10.layout(v0_1, v2, v3, v1_1);
                    }
                }
            }
        }

        v6 = this.mConstraintHelpers.size();
        if(v6 > 0) {
            while(arg8 < v6) {
                this.mConstraintHelpers.get(arg8).updatePostLayout(this);
                ++arg8;
            }
        }
    }

    protected void onMeasure(int arg9, int arg10) {
        this.mOnMeasureWidthMeasureSpec = arg9;
        this.mOnMeasureHeightMeasureSpec = arg10;
        this.mLayoutWidget.setRtl(this.isRtl());
        if(this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if(this.updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }

        this.resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, arg9, arg10);
        this.resolveMeasuredDimension(arg9, arg10, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    public void onViewAdded(View arg4) {
        super.onViewAdded(arg4);
        ConstraintWidget v0 = this.getViewWidget(arg4);
        if(((arg4 instanceof androidx.constraintlayout.widget.Guideline)) && !(v0 instanceof Guideline)) {
            ViewGroup$LayoutParams v0_1 = arg4.getLayoutParams();
            ((LayoutParams)v0_1).widget = new Guideline();
            ((LayoutParams)v0_1).isGuideline = true;
            ((LayoutParams)v0_1).widget.setOrientation(((LayoutParams)v0_1).orientation);
        }

        if((arg4 instanceof ConstraintHelper)) {
            View v0_2 = arg4;
            ((ConstraintHelper)v0_2).validateParams();
            arg4.getLayoutParams().isHelper = true;
            if(!this.mConstraintHelpers.contains(v0_2)) {
                this.mConstraintHelpers.add(v0_2);
            }
        }

        this.mChildrenByIds.put(arg4.getId(), arg4);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View arg3) {
        super.onViewRemoved(arg3);
        this.mChildrenByIds.remove(arg3.getId());
        this.mLayoutWidget.remove(this.getViewWidget(arg3));
        this.mConstraintHelpers.remove(arg3);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int arg3) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(this.getContext(), this, arg3);
    }

    public void removeView(View arg1) {
        super.removeView(arg1);
    }

    public void requestLayout() {
        this.markHierarchyDirty();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int arg3, int arg4, int arg5, int arg6, boolean arg7, boolean arg8) {
        int v0 = this.mMeasurer.paddingHeight;
        arg3 = ConstraintLayout.resolveSizeAndState(arg5 + this.mMeasurer.paddingWidth, arg3, 0);
        arg4 = ConstraintLayout.resolveSizeAndState(arg6 + v0, arg4, 0) & 0xFFFFFF;
        arg3 = Math.min(this.mMaxWidth, arg3 & 0xFFFFFF);
        arg4 = Math.min(this.mMaxHeight, arg4);
        arg5 = 0x1000000;
        if(arg7) {
            arg3 |= arg5;
        }

        if(arg8) {
            arg4 |= arg5;
        }

        this.setMeasuredDimension(arg3, arg4);
        this.mLastMeasureWidth = arg3;
        this.mLastMeasureHeight = arg4;
    }

    protected void resolveSystem(ConstraintWidgetContainer arg14, int arg15, int arg16, int arg17) {
        int v8;
        int v2 = View$MeasureSpec.getMode(arg16);
        int v0 = View$MeasureSpec.getSize(arg16);
        int v4 = View$MeasureSpec.getMode(arg17);
        int v1 = View$MeasureSpec.getSize(arg17);
        int v9 = Math.max(0, this.getPaddingTop());
        int v10 = Math.max(0, this.getPaddingBottom());
        int v12 = v9 + v10;
        int v11 = this.getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(arg16, arg17, v9, v10, v11, v12);
        int v3 = Math.max(0, this.getPaddingStart());
        int v6 = Math.max(0, this.getPaddingEnd());
        if(v3 <= 0 && v6 <= 0) {
            v3 = Math.max(0, this.getPaddingLeft());
            goto label_29;
        }
        else if(this.isRtl()) {
            v8 = v6;
        }
        else {
        label_29:
            v8 = v3;
        }

        v3 = v0 - v11;
        int v5 = v1 - v12;
        this.setSelfDimensionBehaviour(arg14, v2, v3, v4, v5);
        arg14.measure(arg15, v2, v3, v4, v5, this.mLastMeasureWidth, this.mLastMeasureHeight, v8, v9);
    }

    private void setChildrenConstraints() {
        ConstraintLayout v0;
        View v3_2;
        int v7;
        int v3_1;
        ConstraintWidget v3;
        boolean v1 = this.isInEditMode();
        int v6 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v6; ++v2) {
            v3 = this.getViewWidget(this.getChildAt(v2));
            if(v3 == null) {
            }
            else {
                v3.reset();
            }
        }

        v2 = -1;
        if(v1) {
            v3_1 = 0;
            while(v3_1 < v6) {
                View v4 = this.getChildAt(v3_1);
                try {
                    String v5 = this.getResources().getResourceName(v4.getId());
                    this.setDesignInformation(0, v5, Integer.valueOf(v4.getId()));
                    v7 = v5.indexOf(0x2F);
                    if(v7 != v2) {
                        v5 = v5.substring(v7 + 1);
                    }

                    this.getTargetWidget(v4.getId()).setDebugName(v5);
                    goto label_31;
                }
                catch(Resources$NotFoundException ) {
                label_31:
                    ++v3_1;
                    continue;
                }

                break;
            }
        }

        if(this.mConstraintSetId != v2) {
            for(v2 = 0; v2 < v6; ++v2) {
                v3_2 = this.getChildAt(v2);
                if(v3_2.getId() == this.mConstraintSetId && ((v3_2 instanceof Constraints))) {
                    this.mConstraintSet = ((Constraints)v3_2).getConstraintSet();
                }
            }
        }

        ConstraintSet v2_1 = this.mConstraintSet;
        if(v2_1 != null) {
            v2_1.applyToInternal(this, true);
        }

        this.mLayoutWidget.removeAllChildren();
        v2 = this.mConstraintHelpers.size();
        if(v2 > 0) {
            for(v3_1 = 0; v3_1 < v2; ++v3_1) {
                this.mConstraintHelpers.get(v3_1).updatePreLayout(this);
            }
        }

        for(v2 = 0; v2 < v6; ++v2) {
            v3_2 = this.getChildAt(v2);
            if((v3_2 instanceof Placeholder)) {
                ((Placeholder)v3_2).updatePreLayout(this);
            }
        }

        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(this.getId(), this.mLayoutWidget);
        for(v2 = 0; v2 < v6; ++v2) {
            v3_2 = this.getChildAt(v2);
            this.mTempMapIdToWidget.put(v3_2.getId(), this.getViewWidget(v3_2));
        }

        v7 = 0;
        while(v7 < v6) {
            View v2_2 = this.getChildAt(v7);
            v3 = this.getViewWidget(v2_2);
            if(v3 == null) {
                v0 = this;
            }
            else {
                ViewGroup$LayoutParams v4_1 = v2_2.getLayoutParams();
                this.mLayoutWidget.add(v3);
                v0 = this;
                v0.applyConstraintsFromLayoutParams(v1, v2_2, v3, ((LayoutParams)v4_1), this.mTempMapIdToWidget);
            }

            ++v7;
            this = v0;
        }
    }

    public void setConstraintSet(ConstraintSet arg1) {
        this.mConstraintSet = arg1;
    }

    public void setDesignInformation(int arg2, Object arg3, Object arg4) {
        String v3;
        if(arg2 == 0 && ((arg3 instanceof String)) && ((arg4 instanceof Integer))) {
            if(this.mDesignIds == null) {
                this.mDesignIds = new HashMap();
            }

            arg2 = ((String)arg3).indexOf("/");
            if(arg2 != -1) {
                v3 = ((String)arg3).substring(arg2 + 1);
            }

            this.mDesignIds.put(v3, Integer.valueOf(((Integer)arg4).intValue()));
        }
    }

    public void setId(int arg3) {
        this.mChildrenByIds.remove(this.getId());
        super.setId(arg3);
        this.mChildrenByIds.put(this.getId(), this);
    }

    public void setMaxHeight(int arg2) {
        if(arg2 == this.mMaxHeight) {
            return;
        }

        this.mMaxHeight = arg2;
        this.requestLayout();
    }

    public void setMaxWidth(int arg2) {
        if(arg2 == this.mMaxWidth) {
            return;
        }

        this.mMaxWidth = arg2;
        this.requestLayout();
    }

    public void setMinHeight(int arg2) {
        if(arg2 == this.mMinHeight) {
            return;
        }

        this.mMinHeight = arg2;
        this.requestLayout();
    }

    public void setMinWidth(int arg2) {
        if(arg2 == this.mMinWidth) {
            return;
        }

        this.mMinWidth = arg2;
        this.requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener arg1) {
        this.mConstraintsChangedListener = arg1;
        ConstraintLayoutStates v0 = this.mConstraintLayoutSpec;
        if(v0 != null) {
            v0.setOnConstraintsChanged(arg1);
        }
    }

    public void setOptimizationLevel(int arg1) {
        this.mOptimizationLevel = arg1;
        this.mLayoutWidget.setOptimizationLevel(arg1);
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer arg9, int arg10, int arg11, int arg12, int arg13) {
        int v0 = this.mMeasurer.paddingHeight;
        int v1 = this.mMeasurer.paddingWidth;
        DimensionBehaviour v2 = DimensionBehaviour.FIXED;
        DimensionBehaviour v3 = DimensionBehaviour.FIXED;
        int v4 = this.getChildCount();
        int v5 = 0x40000000;
        int v7 = 0x80000000;
        if(arg10 != v7) {
            if(arg10 == 0) {
                v2 = DimensionBehaviour.WRAP_CONTENT;
                if(v4 == 0) {
                    arg11 = Math.max(0, this.mMinWidth);
                    goto label_28;
                }
            }
            else if(arg10 == v5) {
                arg11 = Math.min(this.mMaxWidth - v1, arg11);
                goto label_28;
            }

            arg11 = 0;
        }
        else {
            v2 = DimensionBehaviour.WRAP_CONTENT;
            if(v4 != 0) {
                goto label_28;
            }

            arg11 = Math.max(0, this.mMinWidth);
        }

    label_28:
        if(arg12 != v7) {
            if(arg12 == 0) {
                v3 = DimensionBehaviour.WRAP_CONTENT;
                if(v4 == 0) {
                    arg13 = Math.max(0, this.mMinHeight);
                    goto label_46;
                }
            }
            else if(arg12 == v5) {
                arg13 = Math.min(this.mMaxHeight - v0, arg13);
                goto label_46;
            }

            arg13 = 0;
        }
        else {
            v3 = DimensionBehaviour.WRAP_CONTENT;
            if(v4 != 0) {
                goto label_46;
            }

            arg13 = Math.max(0, this.mMinHeight);
        }

    label_46:
        if(arg11 != arg9.getWidth() || arg13 != arg9.getHeight()) {
            arg9.invalidateMeasures();
        }

        arg9.setX(0);
        arg9.setY(0);
        arg9.setMaxWidth(this.mMaxWidth - v1);
        arg9.setMaxHeight(this.mMaxHeight - v0);
        arg9.setMinWidth(0);
        arg9.setMinHeight(0);
        arg9.setHorizontalDimensionBehaviour(v2);
        arg9.setWidth(arg11);
        arg9.setVerticalDimensionBehaviour(v3);
        arg9.setHeight(arg13);
        arg9.setMinWidth(this.mMinWidth - v1);
        arg9.setMinHeight(this.mMinHeight - v0);
    }

    public void setState(int arg1, int arg2, int arg3) {
        ConstraintLayoutStates v0 = this.mConstraintLayoutSpec;
        if(v0 != null) {
            v0.updateConstraints(arg1, ((float)arg2), ((float)arg3));
        }
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }

    private boolean updateHierarchy() {
        int v0 = this.getChildCount();
        boolean v1 = false;
        int v2 = 0;
        while(v2 < v0) {
            if(this.getChildAt(v2).isLayoutRequested()) {
                v1 = true;
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        if(v1) {
            this.setChildrenConstraints();
        }

        return v1;
    }
}

