package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    public class Constraint {
        public final Layout layout;
        public HashMap mCustomConstraints;
        int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        public Constraint() {
            super();
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap();
        }

        static void access$000(Constraint arg0, int arg1, LayoutParams arg2) {
            arg0.fillFrom(arg1, arg2);
        }

        static void access$300(Constraint arg0, ConstraintHelper arg1, int arg2, androidx.constraintlayout.widget.Constraints$LayoutParams arg3) {
            arg0.fillFromConstraints(arg1, arg2, arg3);
        }

        static void access$400(Constraint arg0, int arg1, androidx.constraintlayout.widget.Constraints$LayoutParams arg2) {
            arg0.fillFromConstraints(arg1, arg2);
        }

        static void access$500(Constraint arg0, String arg1, int arg2) {
            arg0.setIntValue(arg1, arg2);
        }

        static void access$600(Constraint arg0, String arg1, int arg2) {
            arg0.setColorValue(arg1, arg2);
        }

        static void access$700(Constraint arg0, String arg1, float arg2) {
            arg0.setFloatValue(arg1, arg2);
        }

        static void access$800(Constraint arg0, String arg1, String arg2) {
            arg0.setStringValue(arg1, arg2);
        }

        public void applyTo(LayoutParams arg2) {
            arg2.leftToLeft = this.layout.leftToLeft;
            arg2.leftToRight = this.layout.leftToRight;
            arg2.rightToLeft = this.layout.rightToLeft;
            arg2.rightToRight = this.layout.rightToRight;
            arg2.topToTop = this.layout.topToTop;
            arg2.topToBottom = this.layout.topToBottom;
            arg2.bottomToTop = this.layout.bottomToTop;
            arg2.bottomToBottom = this.layout.bottomToBottom;
            arg2.baselineToBaseline = this.layout.baselineToBaseline;
            arg2.startToEnd = this.layout.startToEnd;
            arg2.startToStart = this.layout.startToStart;
            arg2.endToStart = this.layout.endToStart;
            arg2.endToEnd = this.layout.endToEnd;
            arg2.leftMargin = this.layout.leftMargin;
            arg2.rightMargin = this.layout.rightMargin;
            arg2.topMargin = this.layout.topMargin;
            arg2.bottomMargin = this.layout.bottomMargin;
            arg2.goneStartMargin = this.layout.goneStartMargin;
            arg2.goneEndMargin = this.layout.goneEndMargin;
            arg2.goneTopMargin = this.layout.goneTopMargin;
            arg2.goneBottomMargin = this.layout.goneBottomMargin;
            arg2.horizontalBias = this.layout.horizontalBias;
            arg2.verticalBias = this.layout.verticalBias;
            arg2.circleConstraint = this.layout.circleConstraint;
            arg2.circleRadius = this.layout.circleRadius;
            arg2.circleAngle = this.layout.circleAngle;
            arg2.dimensionRatio = this.layout.dimensionRatio;
            arg2.editorAbsoluteX = this.layout.editorAbsoluteX;
            arg2.editorAbsoluteY = this.layout.editorAbsoluteY;
            arg2.verticalWeight = this.layout.verticalWeight;
            arg2.horizontalWeight = this.layout.horizontalWeight;
            arg2.verticalChainStyle = this.layout.verticalChainStyle;
            arg2.horizontalChainStyle = this.layout.horizontalChainStyle;
            arg2.constrainedWidth = this.layout.constrainedWidth;
            arg2.constrainedHeight = this.layout.constrainedHeight;
            arg2.matchConstraintDefaultWidth = this.layout.widthDefault;
            arg2.matchConstraintDefaultHeight = this.layout.heightDefault;
            arg2.matchConstraintMaxWidth = this.layout.widthMax;
            arg2.matchConstraintMaxHeight = this.layout.heightMax;
            arg2.matchConstraintMinWidth = this.layout.widthMin;
            arg2.matchConstraintMinHeight = this.layout.heightMin;
            arg2.matchConstraintPercentWidth = this.layout.widthPercent;
            arg2.matchConstraintPercentHeight = this.layout.heightPercent;
            arg2.orientation = this.layout.orientation;
            arg2.guidePercent = this.layout.guidePercent;
            arg2.guideBegin = this.layout.guideBegin;
            arg2.guideEnd = this.layout.guideEnd;
            arg2.width = this.layout.mWidth;
            arg2.height = this.layout.mHeight;
            if(this.layout.mConstraintTag != null) {
                arg2.constraintTag = this.layout.mConstraintTag;
            }

            arg2.setMarginStart(this.layout.startMargin);
            arg2.setMarginEnd(this.layout.endMargin);
            arg2.validate();
        }

        public Constraint clone() {
            Constraint v0 = new Constraint();
            v0.layout.copyFrom(this.layout);
            v0.motion.copyFrom(this.motion);
            v0.propertySet.copyFrom(this.propertySet);
            v0.transform.copyFrom(this.transform);
            v0.mViewId = this.mViewId;
            return v0;
        }

        public Object clone() throws CloneNotSupportedException {
            return this.clone();
        }

        private void fillFrom(int arg2, LayoutParams arg3) {
            this.mViewId = arg2;
            this.layout.leftToLeft = arg3.leftToLeft;
            this.layout.leftToRight = arg3.leftToRight;
            this.layout.rightToLeft = arg3.rightToLeft;
            this.layout.rightToRight = arg3.rightToRight;
            this.layout.topToTop = arg3.topToTop;
            this.layout.topToBottom = arg3.topToBottom;
            this.layout.bottomToTop = arg3.bottomToTop;
            this.layout.bottomToBottom = arg3.bottomToBottom;
            this.layout.baselineToBaseline = arg3.baselineToBaseline;
            this.layout.startToEnd = arg3.startToEnd;
            this.layout.startToStart = arg3.startToStart;
            this.layout.endToStart = arg3.endToStart;
            this.layout.endToEnd = arg3.endToEnd;
            this.layout.horizontalBias = arg3.horizontalBias;
            this.layout.verticalBias = arg3.verticalBias;
            this.layout.dimensionRatio = arg3.dimensionRatio;
            this.layout.circleConstraint = arg3.circleConstraint;
            this.layout.circleRadius = arg3.circleRadius;
            this.layout.circleAngle = arg3.circleAngle;
            this.layout.editorAbsoluteX = arg3.editorAbsoluteX;
            this.layout.editorAbsoluteY = arg3.editorAbsoluteY;
            this.layout.orientation = arg3.orientation;
            this.layout.guidePercent = arg3.guidePercent;
            this.layout.guideBegin = arg3.guideBegin;
            this.layout.guideEnd = arg3.guideEnd;
            this.layout.mWidth = arg3.width;
            this.layout.mHeight = arg3.height;
            this.layout.leftMargin = arg3.leftMargin;
            this.layout.rightMargin = arg3.rightMargin;
            this.layout.topMargin = arg3.topMargin;
            this.layout.bottomMargin = arg3.bottomMargin;
            this.layout.verticalWeight = arg3.verticalWeight;
            this.layout.horizontalWeight = arg3.horizontalWeight;
            this.layout.verticalChainStyle = arg3.verticalChainStyle;
            this.layout.horizontalChainStyle = arg3.horizontalChainStyle;
            this.layout.constrainedWidth = arg3.constrainedWidth;
            this.layout.constrainedHeight = arg3.constrainedHeight;
            this.layout.widthDefault = arg3.matchConstraintDefaultWidth;
            this.layout.heightDefault = arg3.matchConstraintDefaultHeight;
            this.layout.widthMax = arg3.matchConstraintMaxWidth;
            this.layout.heightMax = arg3.matchConstraintMaxHeight;
            this.layout.widthMin = arg3.matchConstraintMinWidth;
            this.layout.heightMin = arg3.matchConstraintMinHeight;
            this.layout.widthPercent = arg3.matchConstraintPercentWidth;
            this.layout.heightPercent = arg3.matchConstraintPercentHeight;
            this.layout.mConstraintTag = arg3.constraintTag;
            this.layout.goneTopMargin = arg3.goneTopMargin;
            this.layout.goneBottomMargin = arg3.goneBottomMargin;
            this.layout.goneLeftMargin = arg3.goneLeftMargin;
            this.layout.goneRightMargin = arg3.goneRightMargin;
            this.layout.goneStartMargin = arg3.goneStartMargin;
            this.layout.goneEndMargin = arg3.goneEndMargin;
            this.layout.endMargin = arg3.getMarginEnd();
            this.layout.startMargin = arg3.getMarginStart();
        }

        private void fillFromConstraints(ConstraintHelper arg1, int arg2, androidx.constraintlayout.widget.Constraints$LayoutParams arg3) {
            this.fillFromConstraints(arg2, arg3);
            if((arg1 instanceof Barrier)) {
                this.layout.mHelperType = 1;
                this.layout.mBarrierDirection = ((Barrier)arg1).getType();
                this.layout.mReferenceIds = ((Barrier)arg1).getReferencedIds();
                this.layout.mBarrierMargin = ((Barrier)arg1).getMargin();
            }
        }

        private void fillFromConstraints(int arg2, androidx.constraintlayout.widget.Constraints$LayoutParams arg3) {
            this.fillFrom(arg2, ((LayoutParams)arg3));
            this.propertySet.alpha = arg3.alpha;
            this.transform.rotation = arg3.rotation;
            this.transform.rotationX = arg3.rotationX;
            this.transform.rotationY = arg3.rotationY;
            this.transform.scaleX = arg3.scaleX;
            this.transform.scaleY = arg3.scaleY;
            this.transform.transformPivotX = arg3.transformPivotX;
            this.transform.transformPivotY = arg3.transformPivotY;
            this.transform.translationX = arg3.translationX;
            this.transform.translationY = arg3.translationY;
            this.transform.translationZ = arg3.translationZ;
            this.transform.elevation = arg3.elevation;
            this.transform.applyElevation = arg3.applyElevation;
        }

        private ConstraintAttribute get(String arg2, AttributeType arg3) {
            if(this.mCustomConstraints.containsKey(arg2)) {
                Object v1 = this.mCustomConstraints.get(arg2);
                if(((ConstraintAttribute)v1).getType() == arg3) {
                    return ((ConstraintAttribute)v1);
                }

                throw new IllegalArgumentException("ConstraintAttribute is already a " + ((ConstraintAttribute)v1).getType().name());
            }

            ConstraintAttribute v0 = new ConstraintAttribute(arg2, arg3);
            this.mCustomConstraints.put(arg2, v0);
            return v0;
        }

        private void setColorValue(String arg2, int arg3) {
            this.get(arg2, AttributeType.COLOR_TYPE).setColorValue(arg3);
        }

        private void setFloatValue(String arg2, float arg3) {
            this.get(arg2, AttributeType.FLOAT_TYPE).setFloatValue(arg3);
        }

        private void setIntValue(String arg2, int arg3) {
            this.get(arg2, AttributeType.INT_TYPE).setIntValue(arg3);
        }

        private void setStringValue(String arg2, String arg3) {
            this.get(arg2, AttributeType.STRING_TYPE).setStringValue(arg3);
        }
    }

    public class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 0x3F;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 0x1F;
        private static final int START_TO_START = 0x20;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
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
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mApply;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        private static SparseIntArray mapToConstant;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Layout.mapToConstant = v0;
            v0.append(styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintLeft_toRightOf, 25);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintRight_toLeftOf, 28);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintRight_toRightOf, 29);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintTop_toTopOf, 35);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintTop_toBottomOf, 34);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintBottom_toTopOf, 4);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            Layout.mapToConstant.append(styleable.Layout_layout_editor_absoluteX, 6);
            Layout.mapToConstant.append(styleable.Layout_layout_editor_absoluteY, 7);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintGuide_begin, 17);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintGuide_end, 18);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintGuide_percent, 19);
            Layout.mapToConstant.append(styleable.Layout_android_orientation, 26);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintStart_toEndOf, 0x1F);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintStart_toStartOf, 0x20);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintEnd_toStartOf, 10);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintEnd_toEndOf, 9);
            Layout.mapToConstant.append(styleable.Layout_layout_goneMarginLeft, 13);
            Layout.mapToConstant.append(styleable.Layout_layout_goneMarginTop, 16);
            Layout.mapToConstant.append(styleable.Layout_layout_goneMarginRight, 14);
            Layout.mapToConstant.append(styleable.Layout_layout_goneMarginBottom, 11);
            Layout.mapToConstant.append(styleable.Layout_layout_goneMarginStart, 15);
            Layout.mapToConstant.append(styleable.Layout_layout_goneMarginEnd, 12);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintVertical_weight, 38);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintHorizontal_weight, 37);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintVertical_chainStyle, 40);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintHorizontal_bias, 20);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintVertical_bias, 36);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintDimensionRatio, 5);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintLeft_creator, 76);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintTop_creator, 76);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintRight_creator, 76);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintBottom_creator, 76);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintBaseline_creator, 76);
            Layout.mapToConstant.append(styleable.Layout_android_layout_marginLeft, 23);
            Layout.mapToConstant.append(styleable.Layout_android_layout_marginRight, 27);
            Layout.mapToConstant.append(styleable.Layout_android_layout_marginStart, 30);
            Layout.mapToConstant.append(styleable.Layout_android_layout_marginEnd, 8);
            Layout.mapToConstant.append(styleable.Layout_android_layout_marginTop, 33);
            Layout.mapToConstant.append(styleable.Layout_android_layout_marginBottom, 2);
            Layout.mapToConstant.append(styleable.Layout_android_layout_width, 22);
            Layout.mapToConstant.append(styleable.Layout_android_layout_height, 21);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintCircle, 61);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintCircleRadius, 62);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintCircleAngle, 0x3F);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintWidth_percent, 69);
            Layout.mapToConstant.append(styleable.Layout_layout_constraintHeight_percent, 70);
            Layout.mapToConstant.append(styleable.Layout_chainUseRtl, 71);
            Layout.mapToConstant.append(styleable.Layout_barrierDirection, 72);
            Layout.mapToConstant.append(styleable.Layout_barrierMargin, 73);
            Layout.mapToConstant.append(styleable.Layout_constraint_referenced_ids, 74);
            Layout.mapToConstant.append(styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public Layout() {
            super();
            this.mIsGuideline = false;
            this.mApply = false;
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
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.endMargin = -1;
            this.startMargin = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneEndMargin = -1;
            this.goneStartMargin = -1;
            this.verticalWeight = -1f;
            this.horizontalWeight = -1f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = -1;
            this.heightMax = -1;
            this.widthMin = -1;
            this.heightMin = -1;
            this.widthPercent = 1f;
            this.heightPercent = 1f;
            this.mBarrierDirection = -1;
            this.mBarrierMargin = 0;
            this.mHelperType = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.mBarrierAllowsGoneWidgets = true;
        }

        public void copyFrom(Layout arg3) {
            this.mIsGuideline = arg3.mIsGuideline;
            this.mWidth = arg3.mWidth;
            this.mApply = arg3.mApply;
            this.mHeight = arg3.mHeight;
            this.guideBegin = arg3.guideBegin;
            this.guideEnd = arg3.guideEnd;
            this.guidePercent = arg3.guidePercent;
            this.leftToLeft = arg3.leftToLeft;
            this.leftToRight = arg3.leftToRight;
            this.rightToLeft = arg3.rightToLeft;
            this.rightToRight = arg3.rightToRight;
            this.topToTop = arg3.topToTop;
            this.topToBottom = arg3.topToBottom;
            this.bottomToTop = arg3.bottomToTop;
            this.bottomToBottom = arg3.bottomToBottom;
            this.baselineToBaseline = arg3.baselineToBaseline;
            this.startToEnd = arg3.startToEnd;
            this.startToStart = arg3.startToStart;
            this.endToStart = arg3.endToStart;
            this.endToEnd = arg3.endToEnd;
            this.horizontalBias = arg3.horizontalBias;
            this.verticalBias = arg3.verticalBias;
            this.dimensionRatio = arg3.dimensionRatio;
            this.circleConstraint = arg3.circleConstraint;
            this.circleRadius = arg3.circleRadius;
            this.circleAngle = arg3.circleAngle;
            this.editorAbsoluteX = arg3.editorAbsoluteX;
            this.editorAbsoluteY = arg3.editorAbsoluteY;
            this.orientation = arg3.orientation;
            this.leftMargin = arg3.leftMargin;
            this.rightMargin = arg3.rightMargin;
            this.topMargin = arg3.topMargin;
            this.bottomMargin = arg3.bottomMargin;
            this.endMargin = arg3.endMargin;
            this.startMargin = arg3.startMargin;
            this.goneLeftMargin = arg3.goneLeftMargin;
            this.goneTopMargin = arg3.goneTopMargin;
            this.goneRightMargin = arg3.goneRightMargin;
            this.goneBottomMargin = arg3.goneBottomMargin;
            this.goneEndMargin = arg3.goneEndMargin;
            this.goneStartMargin = arg3.goneStartMargin;
            this.verticalWeight = arg3.verticalWeight;
            this.horizontalWeight = arg3.horizontalWeight;
            this.horizontalChainStyle = arg3.horizontalChainStyle;
            this.verticalChainStyle = arg3.verticalChainStyle;
            this.widthDefault = arg3.widthDefault;
            this.heightDefault = arg3.heightDefault;
            this.widthMax = arg3.widthMax;
            this.heightMax = arg3.heightMax;
            this.widthMin = arg3.widthMin;
            this.heightMin = arg3.heightMin;
            this.widthPercent = arg3.widthPercent;
            this.heightPercent = arg3.heightPercent;
            this.mBarrierDirection = arg3.mBarrierDirection;
            this.mBarrierMargin = arg3.mBarrierMargin;
            this.mHelperType = arg3.mHelperType;
            this.mConstraintTag = arg3.mConstraintTag;
            int[] v0 = arg3.mReferenceIds;
            this.mReferenceIds = v0 != null ? Arrays.copyOf(v0, v0.length) : null;
            this.mReferenceIdString = arg3.mReferenceIdString;
            this.constrainedWidth = arg3.constrainedWidth;
            this.constrainedHeight = arg3.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = arg3.mBarrierAllowsGoneWidgets;
        }

        public void dump(MotionScene arg10, StringBuilder arg11) {
            Object v4;
            Field[] v0 = this.getClass().getDeclaredFields();
            arg11.append("\n");
            int v1;
            for(v1 = 0; v1 < v0.length; ++v1) {
                Field v2 = v0[v1];
                String v3 = v2.getName();
                if(!Modifier.isStatic(v2.getModifiers())) {
                    try {
                        v4 = v2.get(this);
                        Class v2_2 = v2.getType();
                        Class v5 = Integer.TYPE;
                    }
                    catch(IllegalAccessException v2_1) {
                        goto label_46;
                    }

                    String v6 = "\"\n";
                    String v7 = " = \"";
                    String v8 = "    ";
                    if(v2_2 != v5) {
                        goto label_34;
                    }

                    try {
                        if(((Integer)v4).intValue() == -1) {
                            goto label_47;
                        }

                        String v2_3 = arg10.lookUpConstraintName(((Integer)v4).intValue());
                        arg11.append(v8);
                        arg11.append(v3);
                        arg11.append(v7);
                        if(v2_3 == null) {
                        }
                        else {
                            String v4_1 = v2_3;
                        }

                        arg11.append(v4);
                        arg11.append(v6);
                        goto label_47;
                    label_34:
                        if(v2_2 != Float.TYPE) {
                            goto label_47;
                        }

                        if(((Float)v4).floatValue() == -1f) {
                            goto label_47;
                        }

                        arg11.append(v8);
                        arg11.append(v3);
                        arg11.append(v7);
                        arg11.append(v4);
                        arg11.append(v6);
                    }
                    catch(IllegalAccessException v2_1) {
                    label_46:
                        v2_1.printStackTrace();
                    }
                }

            label_47:
            }
        }

        void fillFromAttributeList(Context arg7, AttributeSet arg8) {
            TypedArray v7 = arg7.obtainStyledAttributes(arg8, styleable.Layout);
            this.mApply = true;
            int v8 = v7.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v8; ++v0) {
                int v1 = v7.getIndex(v0);
                int v2 = Layout.mapToConstant.get(v1);
                if(v2 == 80) {
                    this.constrainedWidth = v7.getBoolean(v1, this.constrainedWidth);
                }
                else if(v2 != 81) {
                    switch(v2) {
                        case 1: {
                            goto label_263;
                        }
                        case 2: {
                            goto label_259;
                        }
                        case 3: {
                            goto label_255;
                        }
                        case 4: {
                            goto label_251;
                        }
                        case 5: {
                            goto label_248;
                        }
                        case 6: {
                            goto label_244;
                        }
                        case 7: {
                            goto label_240;
                        }
                        case 8: {
                            goto label_236;
                        }
                        case 9: {
                            goto label_232;
                        }
                        case 10: {
                            goto label_228;
                        }
                        case 11: {
                            goto label_224;
                        }
                        case 12: {
                            goto label_220;
                        }
                        case 13: {
                            goto label_216;
                        }
                        case 14: {
                            goto label_212;
                        }
                        case 15: {
                            goto label_208;
                        }
                        case 16: {
                            goto label_204;
                        }
                        case 17: {
                            goto label_200;
                        }
                        case 18: {
                            goto label_196;
                        }
                        case 19: {
                            goto label_192;
                        }
                        case 20: {
                            goto label_188;
                        }
                        case 21: {
                            goto label_184;
                        }
                        case 22: {
                            goto label_180;
                        }
                        case 23: {
                            goto label_176;
                        }
                        case 24: {
                            goto label_172;
                        }
                        case 25: {
                            goto label_168;
                        }
                        case 26: {
                            goto label_164;
                        }
                        case 27: {
                            goto label_160;
                        }
                        case 28: {
                            goto label_156;
                        }
                        case 29: {
                            goto label_152;
                        }
                        case 30: {
                            goto label_148;
                        }
                        case 31: {
                            goto label_144;
                        }
                        case 32: {
                            goto label_140;
                        }
                        case 33: {
                            goto label_136;
                        }
                        case 34: {
                            goto label_132;
                        }
                        case 35: {
                            goto label_128;
                        }
                        case 36: {
                            goto label_124;
                        }
                        case 37: {
                            goto label_120;
                        }
                        case 38: {
                            goto label_116;
                        }
                        case 39: {
                            goto label_112;
                        }
                        case 40: {
                            goto label_108;
                        }
                    }

                    switch(v2) {
                        case 54: {
                            goto label_104;
                        }
                        case 55: {
                            goto label_100;
                        }
                        case 56: {
                            goto label_96;
                        }
                        case 57: {
                            goto label_92;
                        }
                        case 58: {
                            goto label_88;
                        }
                        case 59: {
                            goto label_84;
                        }
                    }

                    switch(v2) {
                        case 61: {
                            goto label_80;
                        }
                        case 62: {
                            goto label_76;
                        }
                        case 63: {
                            goto label_72;
                        }
                    }

                    float v3 = 1f;
                    String v4 = "   ";
                    String v5 = "ConstraintSet";
                    switch(v2) {
                        case 69: {
                            goto label_69;
                        }
                        case 70: {
                            goto label_66;
                        }
                        case 71: {
                            goto label_63;
                        }
                        case 72: {
                            goto label_59;
                        }
                        case 73: {
                            goto label_55;
                        }
                        case 74: {
                            goto label_52;
                        }
                        case 75: {
                            goto label_48;
                        }
                        case 76: {
                            goto label_36;
                        }
                        case 77: {
                            goto label_33;
                        }
                    }

                    Log.w(v5, "Unknown attribute 0x" + Integer.toHexString(v1) + v4 + Layout.mapToConstant.get(v1));
                    goto label_274;
                label_33:
                    this.mConstraintTag = v7.getString(v1);
                    goto label_274;
                label_66:
                    this.heightPercent = v7.getFloat(v1, v3);
                    goto label_274;
                label_52:
                    this.mReferenceIdString = v7.getString(v1);
                    goto label_274;
                label_36:
                    Log.w(v5, "unused attribute 0x" + Integer.toHexString(v1) + v4 + Layout.mapToConstant.get(v1));
                    goto label_274;
                label_69:
                    this.widthPercent = v7.getFloat(v1, v3);
                    goto label_274;
                label_55:
                    this.mBarrierMargin = v7.getDimensionPixelSize(v1, this.mBarrierMargin);
                    goto label_274;
                label_59:
                    this.mBarrierDirection = v7.getInt(v1, this.mBarrierDirection);
                    goto label_274;
                label_63:
                    Log.e(v5, "CURRENTLY UNSUPPORTED");
                    goto label_274;
                label_48:
                    this.mBarrierAllowsGoneWidgets = v7.getBoolean(v1, this.mBarrierAllowsGoneWidgets);
                    goto label_274;
                label_72:
                    this.circleAngle = v7.getFloat(v1, this.circleAngle);
                    goto label_274;
                label_76:
                    this.circleRadius = v7.getDimensionPixelSize(v1, this.circleRadius);
                    goto label_274;
                label_80:
                    this.circleConstraint = ConstraintSet.lookupID(v7, v1, this.circleConstraint);
                    goto label_274;
                label_100:
                    this.heightDefault = v7.getInt(v1, this.heightDefault);
                    goto label_274;
                label_84:
                    this.heightMin = v7.getDimensionPixelSize(v1, this.heightMin);
                    goto label_274;
                label_104:
                    this.widthDefault = v7.getInt(v1, this.widthDefault);
                    goto label_274;
                label_88:
                    this.widthMin = v7.getDimensionPixelSize(v1, this.widthMin);
                    goto label_274;
                label_92:
                    this.heightMax = v7.getDimensionPixelSize(v1, this.heightMax);
                    goto label_274;
                label_96:
                    this.widthMax = v7.getDimensionPixelSize(v1, this.widthMax);
                    goto label_274;
                label_228:
                    this.endToStart = ConstraintSet.lookupID(v7, v1, this.endToStart);
                    goto label_274;
                label_164:
                    this.orientation = v7.getInt(v1, this.orientation);
                    goto label_274;
                label_232:
                    this.endToEnd = ConstraintSet.lookupID(v7, v1, this.endToEnd);
                    goto label_274;
                label_168:
                    this.leftToRight = ConstraintSet.lookupID(v7, v1, this.leftToRight);
                    goto label_274;
                label_236:
                    this.endMargin = v7.getDimensionPixelSize(v1, this.endMargin);
                    goto label_274;
                label_172:
                    this.leftToLeft = ConstraintSet.lookupID(v7, v1, this.leftToLeft);
                    goto label_274;
                label_108:
                    this.verticalChainStyle = v7.getInt(v1, this.verticalChainStyle);
                    goto label_274;
                label_240:
                    this.editorAbsoluteY = v7.getDimensionPixelOffset(v1, this.editorAbsoluteY);
                    goto label_274;
                label_176:
                    this.leftMargin = v7.getDimensionPixelSize(v1, this.leftMargin);
                    goto label_274;
                label_112:
                    this.horizontalChainStyle = v7.getInt(v1, this.horizontalChainStyle);
                    goto label_274;
                label_244:
                    this.editorAbsoluteX = v7.getDimensionPixelOffset(v1, this.editorAbsoluteX);
                    goto label_274;
                label_180:
                    this.mWidth = v7.getLayoutDimension(v1, this.mWidth);
                    goto label_274;
                label_116:
                    this.verticalWeight = v7.getFloat(v1, this.verticalWeight);
                    goto label_274;
                label_248:
                    this.dimensionRatio = v7.getString(v1);
                    goto label_274;
                label_184:
                    this.mHeight = v7.getLayoutDimension(v1, this.mHeight);
                    goto label_274;
                label_120:
                    this.horizontalWeight = v7.getFloat(v1, this.horizontalWeight);
                    goto label_274;
                label_251:
                    this.bottomToTop = ConstraintSet.lookupID(v7, v1, this.bottomToTop);
                    goto label_274;
                label_188:
                    this.horizontalBias = v7.getFloat(v1, this.horizontalBias);
                    goto label_274;
                label_124:
                    this.verticalBias = v7.getFloat(v1, this.verticalBias);
                    goto label_274;
                label_255:
                    this.bottomToBottom = ConstraintSet.lookupID(v7, v1, this.bottomToBottom);
                    goto label_274;
                label_192:
                    this.guidePercent = v7.getFloat(v1, this.guidePercent);
                    goto label_274;
                label_128:
                    this.topToTop = ConstraintSet.lookupID(v7, v1, this.topToTop);
                    goto label_274;
                label_259:
                    this.bottomMargin = v7.getDimensionPixelSize(v1, this.bottomMargin);
                    goto label_274;
                label_196:
                    this.guideEnd = v7.getDimensionPixelOffset(v1, this.guideEnd);
                    goto label_274;
                label_132:
                    this.topToBottom = ConstraintSet.lookupID(v7, v1, this.topToBottom);
                    goto label_274;
                label_263:
                    this.baselineToBaseline = ConstraintSet.lookupID(v7, v1, this.baselineToBaseline);
                    goto label_274;
                label_200:
                    this.guideBegin = v7.getDimensionPixelOffset(v1, this.guideBegin);
                    goto label_274;
                label_136:
                    this.topMargin = v7.getDimensionPixelSize(v1, this.topMargin);
                    goto label_274;
                label_204:
                    this.goneTopMargin = v7.getDimensionPixelSize(v1, this.goneTopMargin);
                    goto label_274;
                label_140:
                    this.startToStart = ConstraintSet.lookupID(v7, v1, this.startToStart);
                    goto label_274;
                label_208:
                    this.goneStartMargin = v7.getDimensionPixelSize(v1, this.goneStartMargin);
                    goto label_274;
                label_144:
                    this.startToEnd = ConstraintSet.lookupID(v7, v1, this.startToEnd);
                    goto label_274;
                label_212:
                    this.goneRightMargin = v7.getDimensionPixelSize(v1, this.goneRightMargin);
                    goto label_274;
                label_148:
                    this.startMargin = v7.getDimensionPixelSize(v1, this.startMargin);
                    goto label_274;
                label_216:
                    this.goneLeftMargin = v7.getDimensionPixelSize(v1, this.goneLeftMargin);
                    goto label_274;
                label_152:
                    this.rightToRight = ConstraintSet.lookupID(v7, v1, this.rightToRight);
                    goto label_274;
                label_220:
                    this.goneEndMargin = v7.getDimensionPixelSize(v1, this.goneEndMargin);
                    goto label_274;
                label_156:
                    this.rightToLeft = ConstraintSet.lookupID(v7, v1, this.rightToLeft);
                    goto label_274;
                label_224:
                    this.goneBottomMargin = v7.getDimensionPixelSize(v1, this.goneBottomMargin);
                    goto label_274;
                label_160:
                    this.rightMargin = v7.getDimensionPixelSize(v1, this.rightMargin);
                }
                else {
                    this.constrainedHeight = v7.getBoolean(v1, this.constrainedHeight);
                }

            label_274:
            }

            v7.recycle();
        }
    }

    public class Motion {
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 6;
        private static final int PATH_MOTION_ARC = 2;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        public int mAnimateRelativeTo;
        public boolean mApply;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public String mTransitionEasing;
        private static SparseIntArray mapToConstant;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Motion.mapToConstant = v0;
            v0.append(styleable.Motion_motionPathRotate, 1);
            Motion.mapToConstant.append(styleable.Motion_pathMotionArc, 2);
            Motion.mapToConstant.append(styleable.Motion_transitionEasing, 3);
            Motion.mapToConstant.append(styleable.Motion_drawPath, 4);
            Motion.mapToConstant.append(styleable.Motion_animate_relativeTo, 5);
            Motion.mapToConstant.append(styleable.Motion_motionStagger, 6);
        }

        public Motion() {
            super();
            this.mApply = false;
            this.mAnimateRelativeTo = -1;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = NaNf;
            this.mPathRotate = NaNf;
        }

        public void copyFrom(Motion arg2) {
            this.mApply = arg2.mApply;
            this.mAnimateRelativeTo = arg2.mAnimateRelativeTo;
            this.mTransitionEasing = arg2.mTransitionEasing;
            this.mPathMotionArc = arg2.mPathMotionArc;
            this.mDrawPath = arg2.mDrawPath;
            this.mPathRotate = arg2.mPathRotate;
            this.mMotionStagger = arg2.mMotionStagger;
        }

        void fillFromAttributeList(Context arg6, AttributeSet arg7) {
            TypedArray v6 = arg6.obtainStyledAttributes(arg7, styleable.Motion);
            this.mApply = true;
            int v7 = v6.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v7; ++v1) {
                int v2 = v6.getIndex(v1);
                switch(Motion.mapToConstant.get(v2)) {
                    case 1: {
                        this.mPathRotate = v6.getFloat(v2, this.mPathRotate);
                        break;
                    }
                    case 2: {
                        this.mPathMotionArc = v6.getInt(v2, this.mPathMotionArc);
                        break;
                    }
                    case 3: {
                        if(v6.peekValue(v2).type == 3) {
                            this.mTransitionEasing = v6.getString(v2);
                            goto label_43;
                        }

                        this.mTransitionEasing = Easing.NAMED_EASING[v6.getInteger(v2, 0)];
                        break;
                    }
                    case 4: {
                        this.mDrawPath = v6.getInt(v2, 0);
                        break;
                    }
                    case 5: {
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(v6, v2, this.mAnimateRelativeTo);
                        break;
                    }
                    case 6: {
                        this.mMotionStagger = v6.getFloat(v2, this.mMotionStagger);
                        break;
                    }
                    default: {
                        break;
                    }
                }

            label_43:
            }

            v6.recycle();
        }
    }

    public class PropertySet {
        public float alpha;
        public boolean mApply;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
            super();
            this.mApply = false;
            this.visibility = 0;
            this.mVisibilityMode = 0;
            this.alpha = 1f;
            this.mProgress = NaNf;
        }

        public void copyFrom(PropertySet arg2) {
            this.mApply = arg2.mApply;
            this.visibility = arg2.visibility;
            this.alpha = arg2.alpha;
            this.mProgress = arg2.mProgress;
            this.mVisibilityMode = arg2.mVisibilityMode;
        }

        void fillFromAttributeList(Context arg4, AttributeSet arg5) {
            TypedArray v4 = arg4.obtainStyledAttributes(arg5, styleable.PropertySet);
            this.mApply = true;
            int v5 = v4.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v5; ++v0) {
                int v1 = v4.getIndex(v0);
                if(v1 == styleable.PropertySet_android_alpha) {
                    this.alpha = v4.getFloat(v1, this.alpha);
                }
                else if(v1 == styleable.PropertySet_android_visibility) {
                    this.visibility = v4.getInt(v1, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                }
                else if(v1 == styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = v4.getInt(v1, this.mVisibilityMode);
                }
                else if(v1 == styleable.PropertySet_motionProgress) {
                    this.mProgress = v4.getFloat(v1, this.mProgress);
                }
            }

            v4.recycle();
        }
    }

    public class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        public boolean applyElevation;
        public float elevation;
        public boolean mApply;
        private static SparseIntArray mapToConstant;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Transform.mapToConstant = v0;
            v0.append(styleable.Transform_android_rotation, 1);
            Transform.mapToConstant.append(styleable.Transform_android_rotationX, 2);
            Transform.mapToConstant.append(styleable.Transform_android_rotationY, 3);
            Transform.mapToConstant.append(styleable.Transform_android_scaleX, 4);
            Transform.mapToConstant.append(styleable.Transform_android_scaleY, 5);
            Transform.mapToConstant.append(styleable.Transform_android_transformPivotX, 6);
            Transform.mapToConstant.append(styleable.Transform_android_transformPivotY, 7);
            Transform.mapToConstant.append(styleable.Transform_android_translationX, 8);
            Transform.mapToConstant.append(styleable.Transform_android_translationY, 9);
            Transform.mapToConstant.append(styleable.Transform_android_translationZ, 10);
            Transform.mapToConstant.append(styleable.Transform_android_elevation, 11);
        }

        public Transform() {
            super();
            this.mApply = false;
            this.rotation = 0f;
            this.rotationX = 0f;
            this.rotationY = 0f;
            this.scaleX = 1f;
            this.scaleY = 1f;
            this.transformPivotX = NaNf;
            this.transformPivotY = NaNf;
            this.translationX = 0f;
            this.translationY = 0f;
            this.translationZ = 0f;
            this.applyElevation = false;
            this.elevation = 0f;
        }

        public void copyFrom(Transform arg2) {
            this.mApply = arg2.mApply;
            this.rotation = arg2.rotation;
            this.rotationX = arg2.rotationX;
            this.rotationY = arg2.rotationY;
            this.scaleX = arg2.scaleX;
            this.scaleY = arg2.scaleY;
            this.transformPivotX = arg2.transformPivotX;
            this.transformPivotY = arg2.transformPivotY;
            this.translationX = arg2.translationX;
            this.translationY = arg2.translationY;
            this.translationZ = arg2.translationZ;
            this.applyElevation = arg2.applyElevation;
            this.elevation = arg2.elevation;
        }

        void fillFromAttributeList(Context arg5, AttributeSet arg6) {
            TypedArray v5 = arg5.obtainStyledAttributes(arg6, styleable.Transform);
            this.mApply = true;
            int v0 = v5.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v5.getIndex(v1);
                switch(Transform.mapToConstant.get(v2)) {
                    case 1: {
                        this.rotation = v5.getFloat(v2, this.rotation);
                        break;
                    }
                    case 2: {
                        this.rotationX = v5.getFloat(v2, this.rotationX);
                        break;
                    }
                    case 3: {
                        this.rotationY = v5.getFloat(v2, this.rotationY);
                        break;
                    }
                    case 4: {
                        this.scaleX = v5.getFloat(v2, this.scaleX);
                        break;
                    }
                    case 5: {
                        this.scaleY = v5.getFloat(v2, this.scaleY);
                        break;
                    }
                    case 6: {
                        this.transformPivotX = v5.getDimension(v2, this.transformPivotX);
                        break;
                    }
                    case 7: {
                        this.transformPivotY = v5.getDimension(v2, this.transformPivotY);
                        break;
                    }
                    case 8: {
                        this.translationX = v5.getDimension(v2, this.translationX);
                        break;
                    }
                    case 9: {
                        this.translationY = v5.getDimension(v2, this.translationY);
                        break;
                    }
                    case 10: {
                        this.translationZ = v5.getDimension(v2, this.translationZ);
                        break;
                    }
                    case 11: {
                        this.applyElevation = true;
                        this.elevation = v5.getDimension(v2, this.elevation);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }

            v5.recycle();
        }
    }

    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 0x40;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 0x3F;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 0x4F;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 0x2F;
    private static final int SCALE_Y = 0x30;
    public static final int START = 6;
    private static final int START_MARGIN = 0x1F;
    private static final int START_TO_END = 0x20;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = null;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private HashMap mConstraints;
    private boolean mForceId;
    private HashMap mSavedAttributes;
    private boolean mValidate;
    private static SparseIntArray mapToConstant;

    static {
        ConstraintSet.VISIBILITY_FLAGS = new int[]{0, 4, 8};
        SparseIntArray v0 = new SparseIntArray();
        ConstraintSet.mapToConstant = v0;
        v0.append(styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintRight_toRightOf, 30);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintTop_toTopOf, 36);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_editor_absoluteX, 6);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_editor_absoluteY, 7);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintGuide_begin, 17);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintGuide_end, 18);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintGuide_percent, 19);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_orientation, 27);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintStart_toEndOf, 0x20);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintStart_toStartOf, 33);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_goneMarginLeft, 13);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_goneMarginTop, 16);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_goneMarginRight, 14);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_goneMarginBottom, 11);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_goneMarginStart, 15);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_goneMarginEnd, 12);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintVertical_weight, 40);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHorizontal_weight, 39);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHorizontal_bias, 20);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintVertical_bias, 37);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintDimensionRatio, 5);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintLeft_creator, 82);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintTop_creator, 82);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintRight_creator, 82);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintBottom_creator, 82);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintBaseline_creator, 82);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_marginLeft, 24);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_marginRight, 28);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_marginStart, 0x1F);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_marginEnd, 8);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_marginTop, 34);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_marginBottom, 2);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_width, 23);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_layout_height, 21);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_visibility, 22);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_alpha, 43);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_elevation, 44);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_rotationX, 45);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_rotationY, 46);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_rotation, 60);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_scaleX, 0x2F);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_scaleY, 0x30);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_transformPivotX, 49);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_transformPivotY, 50);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_translationX, 51);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_translationY, 52);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_translationZ, 53);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintWidth_default, 54);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHeight_default, 55);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintWidth_max, 56);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHeight_max, 57);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintWidth_min, 58);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHeight_min, 59);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintCircle, 61);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintCircleRadius, 62);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintCircleAngle, 0x3F);
        ConstraintSet.mapToConstant.append(styleable.Constraint_animate_relativeTo, 0x40);
        ConstraintSet.mapToConstant.append(styleable.Constraint_transitionEasing, 65);
        ConstraintSet.mapToConstant.append(styleable.Constraint_drawPath, 66);
        ConstraintSet.mapToConstant.append(styleable.Constraint_transitionPathRotate, 67);
        ConstraintSet.mapToConstant.append(styleable.Constraint_motionStagger, 0x4F);
        ConstraintSet.mapToConstant.append(styleable.Constraint_android_id, 38);
        ConstraintSet.mapToConstant.append(styleable.Constraint_motionProgress, 68);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintWidth_percent, 69);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintHeight_percent, 70);
        ConstraintSet.mapToConstant.append(styleable.Constraint_chainUseRtl, 71);
        ConstraintSet.mapToConstant.append(styleable.Constraint_barrierDirection, 72);
        ConstraintSet.mapToConstant.append(styleable.Constraint_barrierMargin, 73);
        ConstraintSet.mapToConstant.append(styleable.Constraint_constraint_referenced_ids, 74);
        ConstraintSet.mapToConstant.append(styleable.Constraint_barrierAllowsGoneWidgets, 75);
        ConstraintSet.mapToConstant.append(styleable.Constraint_pathMotionArc, 76);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constraintTag, 77);
        ConstraintSet.mapToConstant.append(styleable.Constraint_visibilityMode, 78);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constrainedWidth, 80);
        ConstraintSet.mapToConstant.append(styleable.Constraint_layout_constrainedHeight, 81);
    }

    public ConstraintSet() {
        super();
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    static int access$100(TypedArray arg0, int arg1, int arg2) {
        return ConstraintSet.lookupID(arg0, arg1, arg2);
    }

    static int[] access$200() {
        return ConstraintSet.VISIBILITY_FLAGS;
    }

    private void addAttributes(AttributeType arg5, String[] arg6) {
        int v0;
        for(v0 = 0; v0 < arg6.length; ++v0) {
            if(this.mSavedAttributes.containsKey(arg6[v0])) {
                Object v1 = this.mSavedAttributes.get(arg6[v0]);
                if(((ConstraintAttribute)v1).getType() == arg5) {
                }
                else {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + ((ConstraintAttribute)v1).getType().name());
                }
            }
            else {
                this.mSavedAttributes.put(arg6[v0], new ConstraintAttribute(arg6[v0], arg5));
            }
        }
    }

    public void addColorAttributes(String[] arg2) {
        this.addAttributes(AttributeType.COLOR_TYPE, arg2);
    }

    public void addFloatAttributes(String[] arg2) {
        this.addAttributes(AttributeType.FLOAT_TYPE, arg2);
    }

    public void addIntAttributes(String[] arg2) {
        this.addAttributes(AttributeType.INT_TYPE, arg2);
    }

    public void addStringAttributes(String[] arg2) {
        this.addAttributes(AttributeType.STRING_TYPE, arg2);
    }

    public void addToHorizontalChain(int arg15, int arg16, int arg17) {
        int v1 = 2;
        int v6 = arg16 == 0 ? 1 : v1;
        this.connect(arg15, 1, arg16, v6, 0);
        int v12 = arg17 == 0 ? v1 : 1;
        this.connect(arg15, 2, arg17, v12, 0);
        if(arg16 != 0) {
            this.connect(arg16, 2, arg15, 1, 0);
        }

        if(arg17 != 0) {
            this.connect(arg17, 1, arg15, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int arg15, int arg16, int arg17) {
        int v0 = 6;
        int v1 = 7;
        int v6 = arg16 == 0 ? v0 : v1;
        this.connect(arg15, 6, arg16, v6, 0);
        int v12 = arg17 == 0 ? v1 : v0;
        this.connect(arg15, 7, arg17, v12, 0);
        if(arg16 != 0) {
            this.connect(arg16, 7, arg15, 6, 0);
        }

        if(arg17 != 0) {
            this.connect(arg17, 6, arg15, 7, 0);
        }
    }

    public void addToVerticalChain(int arg15, int arg16, int arg17) {
        int v0 = 3;
        int v1 = 4;
        int v6 = arg16 == 0 ? v0 : v1;
        this.connect(arg15, 3, arg16, v6, 0);
        int v12 = arg17 == 0 ? v1 : v0;
        this.connect(arg15, 4, arg17, v12, 0);
        if(arg16 != 0) {
            this.connect(arg16, 4, arg15, 3, 0);
        }

        if(arg17 != 0) {
            this.connect(arg17, 3, arg15, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout arg7) {
        int v0 = arg7.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg7.getChildAt(v1);
            int v3 = v2.getId();
            if(!this.mConstraints.containsKey(Integer.valueOf(v3))) {
                Log.v("ConstraintSet", "id unknown " + Debug.getName(v2));
            }
            else {
                if(this.mForceId) {
                    if(v3 != -1) {
                    }
                    else {
                        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                    }
                }

                if(!this.mConstraints.containsKey(Integer.valueOf(v3))) {
                    goto label_36;
                }

                ConstraintAttribute.setAttributes(v2, this.mConstraints.get(Integer.valueOf(v3)).mCustomConstraints);
            }

        label_36:
        }
    }

    public void applyTo(ConstraintLayout arg2) {
        this.applyToInternal(arg2, true);
        arg2.setConstraintSet(null);
        arg2.requestLayout();
    }

    public void applyToHelper(ConstraintHelper arg4, ConstraintWidget arg5, LayoutParams arg6, SparseArray arg7) {
        int v0 = arg4.getId();
        if(this.mConstraints.containsKey(Integer.valueOf(v0))) {
            Object v3 = this.mConstraints.get(Integer.valueOf(v0));
            if((arg5 instanceof HelperWidget)) {
                arg4.loadParameters(((Constraint)v3), ((HelperWidget)arg5), arg6, arg7);
            }
        }
    }

    void applyToInternal(ConstraintLayout arg11, boolean arg12) {
        int v0 = arg11.getChildCount();
        HashSet v1 = new HashSet(this.mConstraints.keySet());
        int v2;
        for(v2 = 0; true; ++v2) {
            int v4 = -1;
            if(v2 >= v0) {
                break;
            }

            View v5 = arg11.getChildAt(v2);
            int v6 = v5.getId();
            String v8 = "ConstraintSet";
            if(!this.mConstraints.containsKey(Integer.valueOf(v6))) {
                Log.w(v8, "id unknown " + Debug.getName(v5));
            }
            else {
                if(this.mForceId) {
                    if(v6 != v4) {
                    }
                    else {
                        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                    }
                }

                if(v6 == v4) {
                    goto label_150;
                }

                if(this.mConstraints.containsKey(Integer.valueOf(v6))) {
                    v1.remove(Integer.valueOf(v6));
                    Object v7 = this.mConstraints.get(Integer.valueOf(v6));
                    if((v5 instanceof Barrier)) {
                        ((Constraint)v7).layout.mHelperType = 1;
                    }

                    if(((Constraint)v7).layout.mHelperType != v4) {
                        if(((Constraint)v7).layout.mHelperType != 1) {
                        }
                        else {
                            View v3 = v5;
                            ((Barrier)v3).setId(v6);
                            ((Barrier)v3).setType(((Constraint)v7).layout.mBarrierDirection);
                            ((Barrier)v3).setMargin(((Constraint)v7).layout.mBarrierMargin);
                            ((Barrier)v3).setAllowsGoneWidget(((Constraint)v7).layout.mBarrierAllowsGoneWidgets);
                            if(((Constraint)v7).layout.mReferenceIds != null) {
                                ((Barrier)v3).setReferencedIds(((Constraint)v7).layout.mReferenceIds);
                            }
                            else if(((Constraint)v7).layout.mReferenceIdString != null) {
                                ((Constraint)v7).layout.mReferenceIds = this.convertReferenceString(v3, ((Constraint)v7).layout.mReferenceIdString);
                                ((Barrier)v3).setReferencedIds(((Constraint)v7).layout.mReferenceIds);
                            }
                        }
                    }

                    ViewGroup$LayoutParams v3_1 = v5.getLayoutParams();
                    ((LayoutParams)v3_1).validate();
                    ((Constraint)v7).applyTo(((LayoutParams)v3_1));
                    if(arg12) {
                        ConstraintAttribute.setAttributes(v5, ((Constraint)v7).mCustomConstraints);
                    }

                    v5.setLayoutParams(v3_1);
                    if(((Constraint)v7).propertySet.mVisibilityMode == 0) {
                        v5.setVisibility(((Constraint)v7).propertySet.visibility);
                    }

                    v5.setAlpha(((Constraint)v7).propertySet.alpha);
                    v5.setRotation(((Constraint)v7).transform.rotation);
                    v5.setRotationX(((Constraint)v7).transform.rotationX);
                    v5.setRotationY(((Constraint)v7).transform.rotationY);
                    v5.setScaleX(((Constraint)v7).transform.scaleX);
                    v5.setScaleY(((Constraint)v7).transform.scaleY);
                    if(!Float.isNaN(((Constraint)v7).transform.transformPivotX)) {
                        v5.setPivotX(((Constraint)v7).transform.transformPivotX);
                    }

                    if(!Float.isNaN(((Constraint)v7).transform.transformPivotY)) {
                        v5.setPivotY(((Constraint)v7).transform.transformPivotY);
                    }

                    v5.setTranslationX(((Constraint)v7).transform.translationX);
                    v5.setTranslationY(((Constraint)v7).transform.translationY);
                    v5.setTranslationZ(((Constraint)v7).transform.translationZ);
                    if(!((Constraint)v7).transform.applyElevation) {
                        goto label_150;
                    }

                    v5.setElevation(((Constraint)v7).transform.elevation);
                    goto label_150;
                }

                Log.v(v8, "WARNING NO CONSTRAINTS for view " + v6);
            }

        label_150:
        }

        Iterator v12 = v1.iterator();
        while(v12.hasNext()) {
            Object v0_1 = v12.next();
            Object v1_1 = this.mConstraints.get(v0_1);
            if(((Constraint)v1_1).layout.mHelperType != v4) {
                if(((Constraint)v1_1).layout.mHelperType != 1) {
                }
                else {
                    Barrier v2_1 = new Barrier(arg11.getContext());
                    v2_1.setId(((Integer)v0_1).intValue());
                    if(((Constraint)v1_1).layout.mReferenceIds != null) {
                        v2_1.setReferencedIds(((Constraint)v1_1).layout.mReferenceIds);
                    }
                    else if(((Constraint)v1_1).layout.mReferenceIdString != null) {
                        ((Constraint)v1_1).layout.mReferenceIds = this.convertReferenceString(((View)v2_1), ((Constraint)v1_1).layout.mReferenceIdString);
                        v2_1.setReferencedIds(((Constraint)v1_1).layout.mReferenceIds);
                    }

                    v2_1.setType(((Constraint)v1_1).layout.mBarrierDirection);
                    v2_1.setMargin(((Constraint)v1_1).layout.mBarrierMargin);
                    LayoutParams v5_1 = arg11.generateDefaultLayoutParams();
                    v2_1.validateParams();
                    ((Constraint)v1_1).applyTo(v5_1);
                    arg11.addView(((View)v2_1), ((ViewGroup$LayoutParams)v5_1));
                }
            }

            if(!((Constraint)v1_1).layout.mIsGuideline) {
                continue;
            }

            Guideline v2_2 = new Guideline(arg11.getContext());
            v2_2.setId(((Integer)v0_1).intValue());
            LayoutParams v0_2 = arg11.generateDefaultLayoutParams();
            ((Constraint)v1_1).applyTo(v0_2);
            arg11.addView(((View)v2_2), ((ViewGroup$LayoutParams)v0_2));
        }
    }

    public void applyToLayoutParams(int arg3, LayoutParams arg4) {
        if(this.mConstraints.containsKey(Integer.valueOf(arg3))) {
            this.mConstraints.get(Integer.valueOf(arg3)).applyTo(arg4);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout arg2) {
        this.applyToInternal(arg2, false);
        arg2.setConstraintSet(null);
    }

    public void center(int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, float arg15) {
        String v0 = "margin must be > 0";
        if(arg11 >= 0) {
            if(arg14 >= 0) {
                if(arg15 > 0f && arg15 <= 1f) {
                    if(arg10 != 1) {
                        if(arg10 == 2) {
                        }
                        else {
                            if(arg10 != 6) {
                                if(arg10 == 7) {
                                }
                                else {
                                    this.connect(arg8, 3, arg9, arg10, arg11);
                                    this.connect(arg8, 4, arg12, arg13, arg14);
                                    this.mConstraints.get(Integer.valueOf(arg8)).layout.verticalBias = arg15;
                                    return;
                                }
                            }

                            this.connect(arg8, 6, arg9, arg10, arg11);
                            this.connect(arg8, 7, arg12, arg13, arg14);
                            this.mConstraints.get(Integer.valueOf(arg8)).layout.horizontalBias = arg15;
                            return;
                        }
                    }

                    this.connect(arg8, 1, arg9, arg10, arg11);
                    this.connect(arg8, 2, arg12, arg13, arg14);
                    this.mConstraints.get(Integer.valueOf(arg8)).layout.horizontalBias = arg15;
                    return;
                }

                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }

            throw new IllegalArgumentException(v0);
        }

        throw new IllegalArgumentException(v0);
    }

    public void centerHorizontally(int arg19, int arg20) {
        if(arg20 == 0) {
            this.center(arg19, 0, 1, 0, 0, 2, 0, 0.5f);
            return;
        }

        this.center(arg19, arg20, 2, 0, arg20, 1, 0, 0.5f);
    }

    public void centerHorizontally(int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, float arg14) {
        this.connect(arg7, 1, arg8, arg9, arg10);
        this.connect(arg7, 2, arg11, arg12, arg13);
        this.mConstraints.get(Integer.valueOf(arg7)).layout.horizontalBias = arg14;
    }

    public void centerHorizontallyRtl(int arg19, int arg20) {
        if(arg20 == 0) {
            this.center(arg19, 0, 6, 0, 0, 7, 0, 0.5f);
            return;
        }

        this.center(arg19, arg20, 7, 0, arg20, 6, 0, 0.5f);
    }

    public void centerHorizontallyRtl(int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, float arg14) {
        this.connect(arg7, 6, arg8, arg9, arg10);
        this.connect(arg7, 7, arg11, arg12, arg13);
        this.mConstraints.get(Integer.valueOf(arg7)).layout.horizontalBias = arg14;
    }

    public void centerVertically(int arg19, int arg20) {
        if(arg20 == 0) {
            this.center(arg19, 0, 3, 0, 0, 4, 0, 0.5f);
            return;
        }

        this.center(arg19, arg20, 4, 0, arg20, 3, 0, 0.5f);
    }

    public void centerVertically(int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, float arg14) {
        this.connect(arg7, 3, arg8, arg9, arg10);
        this.connect(arg7, 4, arg11, arg12, arg13);
        this.mConstraints.get(Integer.valueOf(arg7)).layout.verticalBias = arg14;
    }

    public void clear(int arg1) {
        this.mConstraints.remove(Integer.valueOf(arg1));
    }

    public void clear(int arg3, int arg4) {
        if(this.mConstraints.containsKey(Integer.valueOf(arg3))) {
            Object v2 = this.mConstraints.get(Integer.valueOf(arg3));
            arg3 = -1;
            switch(arg4) {
                case 1: {
                    goto label_61;
                }
                case 2: {
                    goto label_52;
                }
                case 3: {
                    goto label_43;
                }
                case 4: {
                    goto label_34;
                }
                case 5: {
                    goto label_31;
                }
                case 6: {
                    goto label_22;
                }
                case 7: {
                    goto label_13;
                }
            }

            throw new IllegalArgumentException("unknown constraint");
        label_34:
            ((Constraint)v2).layout.bottomToTop = arg3;
            ((Constraint)v2).layout.bottomToBottom = arg3;
            ((Constraint)v2).layout.bottomMargin = arg3;
            ((Constraint)v2).layout.goneBottomMargin = arg3;
            return;
        label_52:
            ((Constraint)v2).layout.rightToRight = arg3;
            ((Constraint)v2).layout.rightToLeft = arg3;
            ((Constraint)v2).layout.rightMargin = arg3;
            ((Constraint)v2).layout.goneRightMargin = arg3;
            return;
        label_22:
            ((Constraint)v2).layout.startToEnd = arg3;
            ((Constraint)v2).layout.startToStart = arg3;
            ((Constraint)v2).layout.startMargin = arg3;
            ((Constraint)v2).layout.goneStartMargin = arg3;
            return;
        label_43:
            ((Constraint)v2).layout.topToBottom = arg3;
            ((Constraint)v2).layout.topToTop = arg3;
            ((Constraint)v2).layout.topMargin = arg3;
            ((Constraint)v2).layout.goneTopMargin = arg3;
            return;
        label_61:
            ((Constraint)v2).layout.leftToRight = arg3;
            ((Constraint)v2).layout.leftToLeft = arg3;
            ((Constraint)v2).layout.leftMargin = arg3;
            ((Constraint)v2).layout.goneLeftMargin = arg3;
            return;
        label_13:
            ((Constraint)v2).layout.endToStart = arg3;
            ((Constraint)v2).layout.endToEnd = arg3;
            ((Constraint)v2).layout.endMargin = arg3;
            ((Constraint)v2).layout.goneEndMargin = arg3;
            return;
        label_31:
            ((Constraint)v2).layout.baselineToBaseline = arg3;
            return;
        }
    }

    public void clone(Context arg2, int arg3) {
        this.clone(LayoutInflater.from(arg2).inflate(arg3, null));
    }

    public void clone(ConstraintLayout arg11) {
        int v0 = arg11.getChildCount();
        this.mConstraints.clear();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg11.getChildAt(v1);
            ViewGroup$LayoutParams v3 = v2.getLayoutParams();
            int v4 = v2.getId();
            if(this.mForceId) {
                if(v4 != -1) {
                }
                else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }

            if(!this.mConstraints.containsKey(Integer.valueOf(v4))) {
                this.mConstraints.put(Integer.valueOf(v4), new Constraint());
            }

            Object v5 = this.mConstraints.get(Integer.valueOf(v4));
            ((Constraint)v5).mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, v2);
            Constraint.access$000(((Constraint)v5), v4, ((LayoutParams)v3));
            ((Constraint)v5).propertySet.visibility = v2.getVisibility();
            ((Constraint)v5).propertySet.alpha = v2.getAlpha();
            ((Constraint)v5).transform.rotation = v2.getRotation();
            ((Constraint)v5).transform.rotationX = v2.getRotationX();
            ((Constraint)v5).transform.rotationY = v2.getRotationY();
            ((Constraint)v5).transform.scaleX = v2.getScaleX();
            ((Constraint)v5).transform.scaleY = v2.getScaleY();
            float v3_1 = v2.getPivotX();
            float v4_1 = v2.getPivotY();
            double v8 = 0;
            if((((double)v3_1)) != v8 || (((double)v4_1)) != v8) {
                ((Constraint)v5).transform.transformPivotX = v3_1;
                ((Constraint)v5).transform.transformPivotY = v4_1;
            }

            ((Constraint)v5).transform.translationX = v2.getTranslationX();
            ((Constraint)v5).transform.translationY = v2.getTranslationY();
            ((Constraint)v5).transform.translationZ = v2.getTranslationZ();
            if(((Constraint)v5).transform.applyElevation) {
                ((Constraint)v5).transform.elevation = v2.getElevation();
            }

            if((v2 instanceof Barrier)) {
                ((Constraint)v5).layout.mBarrierAllowsGoneWidgets = ((Barrier)v2).allowsGoneWidget();
                ((Constraint)v5).layout.mReferenceIds = ((Barrier)v2).getReferencedIds();
                ((Constraint)v5).layout.mBarrierDirection = ((Barrier)v2).getType();
                ((Constraint)v5).layout.mBarrierMargin = ((Barrier)v2).getMargin();
            }
        }
    }

    public void clone(ConstraintSet arg5) {
        this.mConstraints.clear();
        Iterator v0 = arg5.mConstraints.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            this.mConstraints.put(v1, arg5.mConstraints.get(v1).clone());
        }
    }

    public void clone(Constraints arg9) {
        int v0 = arg9.getChildCount();
        this.mConstraints.clear();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg9.getChildAt(v1);
            ViewGroup$LayoutParams v3 = v2.getLayoutParams();
            int v4 = v2.getId();
            if(this.mForceId) {
                if(v4 != -1) {
                }
                else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }

            if(!this.mConstraints.containsKey(Integer.valueOf(v4))) {
                this.mConstraints.put(Integer.valueOf(v4), new Constraint());
            }

            Object v5 = this.mConstraints.get(Integer.valueOf(v4));
            if((v2 instanceof ConstraintHelper)) {
                Constraint.access$300(((Constraint)v5), ((ConstraintHelper)v2), v4, ((androidx.constraintlayout.widget.Constraints$LayoutParams)v3));
            }

            Constraint.access$400(((Constraint)v5), v4, ((androidx.constraintlayout.widget.Constraints$LayoutParams)v3));
        }
    }

    public void connect(int arg10, int arg11, int arg12, int arg13, int arg14) {
        if(!this.mConstraints.containsKey(Integer.valueOf(arg10))) {
            this.mConstraints.put(Integer.valueOf(arg10), new Constraint());
        }

        Object v10 = this.mConstraints.get(Integer.valueOf(arg10));
        int v0 = 2;
        int v1 = 7;
        int v2 = 6;
        int v3 = 4;
        int v4 = 3;
        String v6 = "right to ";
        String v7 = " undefined";
        int v8 = -1;
        switch(arg11) {
            case 1: {
                goto label_181;
            }
            case 2: {
                goto label_158;
            }
            case 3: {
                goto label_131;
            }
            case 4: {
                goto label_104;
            }
            case 5: {
                goto label_82;
            }
            case 6: {
                goto label_59;
            }
            case 7: {
                goto label_36;
            }
        }

        throw new IllegalArgumentException(this.sideToString(arg11) + " to " + this.sideToString(arg13) + " unknown");
    label_82:
        if(arg13 == 5) {
            ((Constraint)v10).layout.baselineToBaseline = arg12;
            ((Constraint)v10).layout.bottomToBottom = v8;
            ((Constraint)v10).layout.bottomToTop = v8;
            ((Constraint)v10).layout.topToTop = v8;
            ((Constraint)v10).layout.topToBottom = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_131:
        if(arg13 == v4) {
            ((Constraint)v10).layout.topToTop = arg12;
            ((Constraint)v10).layout.topToBottom = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
        }
        else if(arg13 == v3) {
            ((Constraint)v10).layout.topToBottom = arg12;
            ((Constraint)v10).layout.topToTop = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
        }
        else {
            goto label_149;
        }

        ((Constraint)v10).layout.topMargin = arg14;
        return;
    label_149:
        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_36:
        if(arg13 == v1) {
            ((Constraint)v10).layout.endToEnd = arg12;
            ((Constraint)v10).layout.endToStart = v8;
        }
        else if(arg13 == v2) {
            ((Constraint)v10).layout.endToStart = arg12;
            ((Constraint)v10).layout.endToEnd = v8;
        }
        else {
            goto label_50;
        }

        ((Constraint)v10).layout.endMargin = arg14;
        return;
    label_50:
        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_181:
        if(arg13 == 1) {
            ((Constraint)v10).layout.leftToLeft = arg12;
            ((Constraint)v10).layout.leftToRight = v8;
        }
        else if(arg13 == v0) {
            ((Constraint)v10).layout.leftToRight = arg12;
            ((Constraint)v10).layout.leftToLeft = v8;
        }
        else {
            goto label_195;
        }

        ((Constraint)v10).layout.leftMargin = arg14;
        return;
    label_195:
        throw new IllegalArgumentException("Left to " + this.sideToString(arg13) + v7);
    label_104:
        if(arg13 == v3) {
            ((Constraint)v10).layout.bottomToBottom = arg12;
            ((Constraint)v10).layout.bottomToTop = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
        }
        else if(arg13 == v4) {
            ((Constraint)v10).layout.bottomToTop = arg12;
            ((Constraint)v10).layout.bottomToBottom = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
        }
        else {
            goto label_122;
        }

        ((Constraint)v10).layout.bottomMargin = arg14;
        return;
    label_122:
        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_59:
        if(arg13 == v2) {
            ((Constraint)v10).layout.startToStart = arg12;
            ((Constraint)v10).layout.startToEnd = v8;
        }
        else if(arg13 == v1) {
            ((Constraint)v10).layout.startToEnd = arg12;
            ((Constraint)v10).layout.startToStart = v8;
        }
        else {
            goto label_73;
        }

        ((Constraint)v10).layout.startMargin = arg14;
        return;
    label_73:
        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_158:
        if(arg13 == 1) {
            ((Constraint)v10).layout.rightToLeft = arg12;
            ((Constraint)v10).layout.rightToRight = v8;
        }
        else if(arg13 == v0) {
            ((Constraint)v10).layout.rightToRight = arg12;
            ((Constraint)v10).layout.rightToLeft = v8;
        }
        else {
            goto label_172;
        }

        ((Constraint)v10).layout.rightMargin = arg14;
        return;
    label_172:
        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    }

    public void connect(int arg10, int arg11, int arg12, int arg13) {
        if(!this.mConstraints.containsKey(Integer.valueOf(arg10))) {
            this.mConstraints.put(Integer.valueOf(arg10), new Constraint());
        }

        Object v10 = this.mConstraints.get(Integer.valueOf(arg10));
        int v0 = 2;
        int v1 = 7;
        int v2 = 6;
        int v3 = 4;
        int v4 = 3;
        String v6 = "right to ";
        String v7 = " undefined";
        int v8 = -1;
        switch(arg11) {
            case 1: {
                goto label_171;
            }
            case 2: {
                goto label_150;
            }
            case 3: {
                goto label_125;
            }
            case 4: {
                goto label_100;
            }
            case 5: {
                goto label_78;
            }
            case 6: {
                goto label_57;
            }
            case 7: {
                goto label_36;
            }
        }

        throw new IllegalArgumentException(this.sideToString(arg11) + " to " + this.sideToString(arg13) + " unknown");
    label_100:
        if(arg13 == v3) {
            ((Constraint)v10).layout.bottomToBottom = arg12;
            ((Constraint)v10).layout.bottomToTop = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
            return;
        }

        if(arg13 == v4) {
            ((Constraint)v10).layout.bottomToTop = arg12;
            ((Constraint)v10).layout.bottomToBottom = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_36:
        if(arg13 == v1) {
            ((Constraint)v10).layout.endToEnd = arg12;
            ((Constraint)v10).layout.endToStart = v8;
            return;
        }

        if(arg13 == v2) {
            ((Constraint)v10).layout.endToStart = arg12;
            ((Constraint)v10).layout.endToEnd = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_150:
        if(arg13 == 1) {
            ((Constraint)v10).layout.rightToLeft = arg12;
            ((Constraint)v10).layout.rightToRight = v8;
            return;
        }

        if(arg13 == v0) {
            ((Constraint)v10).layout.rightToRight = arg12;
            ((Constraint)v10).layout.rightToLeft = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_57:
        if(arg13 == v2) {
            ((Constraint)v10).layout.startToStart = arg12;
            ((Constraint)v10).layout.startToEnd = v8;
            return;
        }

        if(arg13 == v1) {
            ((Constraint)v10).layout.startToEnd = arg12;
            ((Constraint)v10).layout.startToStart = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_171:
        if(arg13 == 1) {
            ((Constraint)v10).layout.leftToLeft = arg12;
            ((Constraint)v10).layout.leftToRight = v8;
            return;
        }

        if(arg13 == v0) {
            ((Constraint)v10).layout.leftToRight = arg12;
            ((Constraint)v10).layout.leftToLeft = v8;
            return;
        }

        throw new IllegalArgumentException("left to " + this.sideToString(arg13) + v7);
    label_125:
        if(arg13 == v4) {
            ((Constraint)v10).layout.topToTop = arg12;
            ((Constraint)v10).layout.topToBottom = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
            return;
        }

        if(arg13 == v3) {
            ((Constraint)v10).layout.topToBottom = arg12;
            ((Constraint)v10).layout.topToTop = v8;
            ((Constraint)v10).layout.baselineToBaseline = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    label_78:
        if(arg13 == 5) {
            ((Constraint)v10).layout.baselineToBaseline = arg12;
            ((Constraint)v10).layout.bottomToBottom = v8;
            ((Constraint)v10).layout.bottomToTop = v8;
            ((Constraint)v10).layout.topToTop = v8;
            ((Constraint)v10).layout.topToBottom = v8;
            return;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg13) + v7);
    }

    public void constrainCircle(int arg1, int arg2, int arg3, float arg4) {
        Constraint v0 = this.get(arg1);
        v0.layout.circleConstraint = arg2;
        v0.layout.circleRadius = arg3;
        v0.layout.circleAngle = arg4;
    }

    public void constrainDefaultHeight(int arg1, int arg2) {
        this.get(arg1).layout.heightDefault = arg2;
    }

    public void constrainDefaultWidth(int arg1, int arg2) {
        this.get(arg1).layout.widthDefault = arg2;
    }

    public void constrainHeight(int arg1, int arg2) {
        this.get(arg1).layout.mHeight = arg2;
    }

    public void constrainMaxHeight(int arg1, int arg2) {
        this.get(arg1).layout.heightMax = arg2;
    }

    public void constrainMaxWidth(int arg1, int arg2) {
        this.get(arg1).layout.widthMax = arg2;
    }

    public void constrainMinHeight(int arg1, int arg2) {
        this.get(arg1).layout.heightMin = arg2;
    }

    public void constrainMinWidth(int arg1, int arg2) {
        this.get(arg1).layout.widthMin = arg2;
    }

    public void constrainPercentHeight(int arg1, float arg2) {
        this.get(arg1).layout.heightPercent = arg2;
    }

    public void constrainPercentWidth(int arg1, float arg2) {
        this.get(arg1).layout.widthPercent = arg2;
    }

    public void constrainWidth(int arg1, int arg2) {
        this.get(arg1).layout.mWidth = arg2;
    }

    public void constrainedHeight(int arg1, boolean arg2) {
        this.get(arg1).layout.constrainedHeight = arg2;
    }

    public void constrainedWidth(int arg1, boolean arg2) {
        this.get(arg1).layout.constrainedWidth = arg2;
    }

    private int[] convertReferenceString(View arg9, String arg10) {
        int v5;
        String[] v8 = arg10.split(",");
        Context v10 = arg9.getContext();
        int[] v0 = new int[v8.length];
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v8.length; ++v3) {
            String v4 = v8[v2].trim();
            try {
                v5 = id.class.getField(v4).getInt(null);
            }
            catch(Exception ) {
                v5 = 0;
            }

            if(v5 == 0) {
                v5 = v10.getResources().getIdentifier(v4, "id", v10.getPackageName());
            }

            if(v5 == 0 && (arg9.isInEditMode()) && ((arg9.getParent() instanceof ConstraintLayout))) {
                Object v4_1 = arg9.getParent().getDesignInformation(0, v4);
                if(v4_1 != null && ((v4_1 instanceof Integer))) {
                    v5 = ((Integer)v4_1).intValue();
                }
            }

            v0[v3] = v5;
            ++v2;
        }

        if(v3 != v8.length) {
            v0 = Arrays.copyOf(v0, v3);
        }

        return v0;
    }

    public void create(int arg2, int arg3) {
        Constraint v1 = this.get(arg2);
        v1.layout.mIsGuideline = true;
        v1.layout.orientation = arg3;
    }

    public void createBarrier(int arg2, int arg3, int arg4, int[] arg5) {
        Constraint v1 = this.get(arg2);
        v1.layout.mHelperType = 1;
        v1.layout.mBarrierDirection = arg3;
        v1.layout.mBarrierMargin = arg4;
        v1.layout.mIsGuideline = false;
        v1.layout.mReferenceIds = arg5;
    }

    private void createHorizontalChain(int arg12, int arg13, int arg14, int arg15, int[] arg16, float[] arg17, int arg18, int arg19, int arg20) {
        int[] v6 = arg16;
        float[] v7 = arg17;
        String v3 = "must have 2 or more widgets in a chain";
        if(v6.length >= 2) {
            if(v7 != null) {
                if(v7.length == v6.length) {
                }
                else {
                    throw new IllegalArgumentException(v3);
                }
            }

            if(v7 != null) {
                this.get(v6[0]).layout.horizontalWeight = v7[0];
            }

            this.get(v6[0]).layout.horizontalChainStyle = arg18;
            this.connect(v6[0], arg19, arg12, arg13, -1);
            int v9;
            for(v9 = 1; v9 < v6.length; ++v9) {
                int v10 = v9 - 1;
                this.connect(v6[v9], arg19, v6[v10], arg20, -1);
                this.connect(v6[v10], arg20, v6[v9], arg19, -1);
                if(v7 != null) {
                    this.get(v6[v9]).layout.horizontalWeight = v7[v9];
                }
            }

            this.connect(v6[v6.length - 1], arg20, arg14, arg15, -1);
            return;
        }

        throw new IllegalArgumentException(v3);
    }

    public void createHorizontalChain(int arg11, int arg12, int arg13, int arg14, int[] arg15, float[] arg16, int arg17) {
        this.createHorizontalChain(arg11, arg12, arg13, arg14, arg15, arg16, arg17, 1, 2);
    }

    public void createHorizontalChainRtl(int arg11, int arg12, int arg13, int arg14, int[] arg15, float[] arg16, int arg17) {
        this.createHorizontalChain(arg11, arg12, arg13, arg14, arg15, arg16, arg17, 6, 7);
    }

    public void createVerticalChain(int arg12, int arg13, int arg14, int arg15, int[] arg16, float[] arg17, int arg18) {
        int[] v6 = arg16;
        float[] v7 = arg17;
        String v3 = "must have 2 or more widgets in a chain";
        if(v6.length >= 2) {
            if(v7 != null) {
                if(v7.length == v6.length) {
                }
                else {
                    throw new IllegalArgumentException(v3);
                }
            }

            if(v7 != null) {
                this.get(v6[0]).layout.verticalWeight = v7[0];
            }

            this.get(v6[0]).layout.verticalChainStyle = arg18;
            this.connect(v6[0], 3, arg12, arg13, 0);
            int v9;
            for(v9 = 1; v9 < v6.length; ++v9) {
                int v10 = v9 - 1;
                this.connect(v6[v9], 3, v6[v10], 4, 0);
                this.connect(v6[v10], 4, v6[v9], 3, 0);
                if(v7 != null) {
                    this.get(v6[v9]).layout.verticalWeight = v7[v9];
                }
            }

            this.connect(v6[v6.length - 1], 4, arg14, arg15, 0);
            return;
        }

        throw new IllegalArgumentException(v3);
    }

    public void dump(MotionScene arg7, int[] arg8) {
        int v1;
        HashSet v0_1;
        Set v0 = this.mConstraints.keySet();
        int v2 = 0;
        if(arg8.length != 0) {
            v0_1 = new HashSet();
            v1 = arg8.length;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                v0_1.add(Integer.valueOf(arg8[v3]));
            }
        }
        else {
            v0_1 = new HashSet(((Collection)v0));
        }

        System.out.println(v0_1.size() + " constraints");
        StringBuilder v8 = new StringBuilder();
        Object[] v0_2 = v0_1.toArray(new Integer[0]);
        v1 = v0_2.length;
        while(v2 < v1) {
            Object v3_1 = v0_2[v2];
            Object v4 = this.mConstraints.get(v3_1);
            v8.append("<Constraint id=");
            v8.append(v3_1);
            v8.append(" \n");
            ((Constraint)v4).layout.dump(arg7, v8);
            v8.append("/>\n");
            ++v2;
        }

        System.out.println(v8.toString());
    }

    private Constraint fillFromAttributeList(Context arg3, AttributeSet arg4) {
        Constraint v0 = new Constraint();
        TypedArray v4 = arg3.obtainStyledAttributes(arg4, styleable.Constraint);
        this.populateConstraint(arg3, v0, v4);
        v4.recycle();
        return v0;
    }

    private Constraint get(int arg4) {
        if(!this.mConstraints.containsKey(Integer.valueOf(arg4))) {
            this.mConstraints.put(Integer.valueOf(arg4), new Constraint());
        }

        return this.mConstraints.get(Integer.valueOf(arg4));
    }

    public boolean getApplyElevation(int arg1) {
        return this.get(arg1).transform.applyElevation;
    }

    public Constraint getConstraint(int arg3) {
        if(this.mConstraints.containsKey(Integer.valueOf(arg3))) {
            return this.mConstraints.get(Integer.valueOf(arg3));
        }

        return null;
    }

    public HashMap getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int arg1) {
        return this.get(arg1).layout.mHeight;
    }

    public int[] getKnownIds() {
        int v0 = 0;
        Object[] v4 = this.mConstraints.keySet().toArray(new Integer[0]);
        int v1 = v4.length;
        int[] v2 = new int[v1];
        while(v0 < v1) {
            v2[v0] = v4[v0].intValue();
            ++v0;
        }

        return v2;
    }

    public Constraint getParameters(int arg1) {
        return this.get(arg1);
    }

    public int[] getReferencedIds(int arg1) {
        Constraint v0 = this.get(arg1);
        if(v0.layout.mReferenceIds == null) {
            return new int[0];
        }

        return Arrays.copyOf(v0.layout.mReferenceIds, v0.layout.mReferenceIds.length);
    }

    public int getVisibility(int arg1) {
        return this.get(arg1).propertySet.visibility;
    }

    public int getVisibilityMode(int arg1) {
        return this.get(arg1).propertySet.mVisibilityMode;
    }

    public int getWidth(int arg1) {
        return this.get(arg1).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context arg5, int arg6) {
        XmlResourceParser v6 = arg5.getResources().getXml(arg6);
        try {
            int v0;
            for(v0 = ((XmlPullParser)v6).getEventType(); v0 != 1; v0 = ((XmlPullParser)v6).next()) {
                if(v0 == 0) {
                    ((XmlPullParser)v6).getName();
                }
                else if(v0 != 2) {
                }
                else {
                    String v0_1 = ((XmlPullParser)v6).getName();
                    Constraint v2 = this.fillFromAttributeList(arg5, Xml.asAttributeSet(((XmlPullParser)v6)));
                    if(v0_1.equalsIgnoreCase("Guideline")) {
                        v2.layout.mIsGuideline = true;
                    }

                    this.mConstraints.put(Integer.valueOf(v2.mViewId), v2);
                }
            }
        }
        catch(IOException v4) {
            v4.printStackTrace();
        }
        catch(XmlPullParserException v4_1) {
            v4_1.printStackTrace();
        }
    }

    public void load(Context arg8, XmlPullParser arg9) {
        Constraint v2;
        Constraint v1;
        int v0;
        try {
            v0 = arg9.getEventType();
            v1 = null;
            v2 = v1;
        }
        catch(XmlPullParserException v7) {
            goto label_145;
        }
        catch(IOException v7_1) {
            goto label_142;
        }

        while(v0 != 1) {
            if(v0 != 0) {
                String v5 = "Constraint";
                if(v0 == 2) {
                    goto label_25;
                label_27:
                    String v6 = "XML parser error must be within a Constraint ";
                    switch(v4) {
                        case 1331510167: {
                            goto label_52;
                        }
                        case 1791837707: {
                            goto label_36;
                        }
                        case 1803088381: {
                            goto label_30;
                        }
                        case -2025855158: {
                            goto label_121;
                        }
                        case -1984451626: {
                            goto label_104;
                        }
                        case -1269513683: {
                            goto label_87;
                        }
                        case -1238332596: {
                            goto label_70;
                        }
                        case -71750448: {
                            goto label_60;
                        }
                    }

                    goto label_139;
                    try {
                    label_36:
                        if(v0_1.equals("CustomAttribute")) {
                            if(v2 != null) {
                                ConstraintAttribute.parse(arg8, arg9, v2.mCustomConstraints);
                            }
                            else {
                                throw new RuntimeException(v6 + arg9.getLineNumber());
                            label_52:
                                if(v0_1.equals("Barrier")) {
                                    Constraint v0_2 = this.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                    v0_2.layout.mHelperType = 1;
                                    goto label_34;
                                label_70:
                                    if(v0_1.equals("Transform")) {
                                        if(v2 != null) {
                                            v2.transform.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                        }
                                        else {
                                            throw new RuntimeException(v6 + arg9.getLineNumber());
                                        label_87:
                                            if(v0_1.equals("PropertySet")) {
                                                if(v2 != null) {
                                                    v2.propertySet.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                                }
                                                else {
                                                    throw new RuntimeException(v6 + arg9.getLineNumber());
                                                label_104:
                                                    if(v0_1.equals("Motion")) {
                                                        if(v2 != null) {
                                                            v2.motion.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                                        }
                                                        else {
                                                            throw new RuntimeException(v6 + arg9.getLineNumber());
                                                        label_121:
                                                            if(v0_1.equals("Layout")) {
                                                                if(v2 != null) {
                                                                    v2.layout.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                                                }
                                                                else {
                                                                    throw new RuntimeException(v6 + arg9.getLineNumber());
                                                                label_60:
                                                                    if(v0_1.equals("Guideline")) {
                                                                        v0_2 = this.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                                                        v0_2.layout.mIsGuideline = true;
                                                                        v0_2.layout.mApply = true;
                                                                        goto label_34;
                                                                    label_30:
                                                                        if(v0_1.equals(v5)) {
                                                                            v0_2 = this.fillFromAttributeList(arg8, Xml.asAttributeSet(arg9));
                                                                        label_34:
                                                                            v2 = v0_2;
                                                                            goto label_139;
                                                                        label_138:
                                                                            arg9.getName();
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

                    label_139:
                        v0 = arg9.next();
                        continue;
                    }
                    catch(IOException v7_1) {
                    label_142:
                        v7_1.printStackTrace();
                        return;
                    }
                    catch(XmlPullParserException v7) {
                    label_145:
                        v7.printStackTrace();
                        return;
                    }
                }
                else if(v0 != 3) {
                }
                else {
                    try {
                        String v0_1 = arg9.getName();
                        if("ConstraintSet".equals(v0_1)) {
                            return;
                        }
                        else if(v0_1.equalsIgnoreCase(v5)) {
                            this.mConstraints.put(Integer.valueOf(v2.mViewId), v2);
                            v2 = v1;
                            goto label_139;
                        label_25:
                            v0_1 = arg9.getName();
                            int v4 = v0_1.hashCode();
                            goto label_27;
                        }

                        goto label_139;
                    }
                    catch(XmlPullParserException v7) {
                        goto label_145;
                    }
                    catch(IOException v7_1) {
                        goto label_142;
                    }
                }
            }
            else {
                goto label_138;
            }

            goto label_139;
        }
    }

    private static int lookupID(TypedArray arg1, int arg2, int arg3) {
        arg3 = arg1.getResourceId(arg2, arg3);
        int v0 = -1;
        if(arg3 == v0) {
            return arg1.getInt(arg2, v0);
        }

        return arg3;
    }

    public void parseColorAttributes(Constraint arg5, String arg6) {
        String[] v4 = arg6.split(",");
        int v0;
        for(v0 = 0; v0 < v4.length; ++v0) {
            String[] v1 = v4[v0].split("=");
            if(v1.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + v4[v0]);
            }
            else {
                Constraint.access$600(arg5, v1[0], Color.parseColor(v1[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint arg5, String arg6) {
        String[] v4 = arg6.split(",");
        int v0;
        for(v0 = 0; v0 < v4.length; ++v0) {
            String[] v1 = v4[v0].split("=");
            if(v1.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + v4[v0]);
            }
            else {
                Constraint.access$700(arg5, v1[0], Float.parseFloat(v1[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint arg5, String arg6) {
        String[] v4 = arg6.split(",");
        int v0;
        for(v0 = 0; v0 < v4.length; ++v0) {
            String[] v1 = v4[v0].split("=");
            if(v1.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + v4[v0]);
            }
            else {
                Constraint.access$700(arg5, v1[0], ((float)Integer.decode(v1[1]).intValue()));
            }
        }
    }

    public void parseStringAttributes(Constraint arg5, String arg6) {
        String[] v4 = ConstraintSet.splitString(arg6);
        int v0;
        for(v0 = 0; v0 < v4.length; ++v0) {
            String[] v1 = v4[v0].split("=");
            Log.w("ConstraintSet", " Unable to parse " + v4[v0]);
            Constraint.access$800(arg5, v1[0], v1[1]);
        }
    }

    private void populateConstraint(Context arg8, Constraint arg9, TypedArray arg10) {
        int v7 = arg10.getIndexCount();
        int v0;
        for(v0 = 0; v0 < v7; ++v0) {
            int v1 = arg10.getIndex(v0);
            if(v1 != styleable.Constraint_android_id && styleable.Constraint_android_layout_marginStart != v1 && styleable.Constraint_android_layout_marginEnd != v1) {
                arg9.motion.mApply = true;
                arg9.layout.mApply = true;
                arg9.propertySet.mApply = true;
                arg9.transform.mApply = true;
            }

            String v4 = "   ";
            float v5 = 1f;
            String v6 = "ConstraintSet";
            switch(ConstraintSet.mapToConstant.get(v1)) {
                case 1: {
                    arg9.layout.baselineToBaseline = ConstraintSet.lookupID(arg10, v1, arg9.layout.baselineToBaseline);
                    break;
                }
                case 2: {
                    arg9.layout.bottomMargin = arg10.getDimensionPixelSize(v1, arg9.layout.bottomMargin);
                    break;
                }
                case 3: {
                    arg9.layout.bottomToBottom = ConstraintSet.lookupID(arg10, v1, arg9.layout.bottomToBottom);
                    break;
                }
                case 4: {
                    arg9.layout.bottomToTop = ConstraintSet.lookupID(arg10, v1, arg9.layout.bottomToTop);
                    break;
                }
                case 5: {
                    arg9.layout.dimensionRatio = arg10.getString(v1);
                    break;
                }
                case 6: {
                    arg9.layout.editorAbsoluteX = arg10.getDimensionPixelOffset(v1, arg9.layout.editorAbsoluteX);
                    break;
                }
                case 7: {
                    arg9.layout.editorAbsoluteY = arg10.getDimensionPixelOffset(v1, arg9.layout.editorAbsoluteY);
                    break;
                }
                case 8: {
                    arg9.layout.endMargin = arg10.getDimensionPixelSize(v1, arg9.layout.endMargin);
                    break;
                }
                case 9: {
                    arg9.layout.endToEnd = ConstraintSet.lookupID(arg10, v1, arg9.layout.endToEnd);
                    break;
                }
                case 10: {
                    arg9.layout.endToStart = ConstraintSet.lookupID(arg10, v1, arg9.layout.endToStart);
                    break;
                }
                case 11: {
                    arg9.layout.goneBottomMargin = arg10.getDimensionPixelSize(v1, arg9.layout.goneBottomMargin);
                    break;
                }
                case 12: {
                    arg9.layout.goneEndMargin = arg10.getDimensionPixelSize(v1, arg9.layout.goneEndMargin);
                    break;
                }
                case 13: {
                    arg9.layout.goneLeftMargin = arg10.getDimensionPixelSize(v1, arg9.layout.goneLeftMargin);
                    break;
                }
                case 14: {
                    arg9.layout.goneRightMargin = arg10.getDimensionPixelSize(v1, arg9.layout.goneRightMargin);
                    break;
                }
                case 15: {
                    arg9.layout.goneStartMargin = arg10.getDimensionPixelSize(v1, arg9.layout.goneStartMargin);
                    break;
                }
                case 16: {
                    arg9.layout.goneTopMargin = arg10.getDimensionPixelSize(v1, arg9.layout.goneTopMargin);
                    break;
                }
                case 17: {
                    arg9.layout.guideBegin = arg10.getDimensionPixelOffset(v1, arg9.layout.guideBegin);
                    break;
                }
                case 18: {
                    arg9.layout.guideEnd = arg10.getDimensionPixelOffset(v1, arg9.layout.guideEnd);
                    break;
                }
                case 19: {
                    arg9.layout.guidePercent = arg10.getFloat(v1, arg9.layout.guidePercent);
                    break;
                }
                case 20: {
                    arg9.layout.horizontalBias = arg10.getFloat(v1, arg9.layout.horizontalBias);
                    break;
                }
                case 21: {
                    arg9.layout.mHeight = arg10.getLayoutDimension(v1, arg9.layout.mHeight);
                    break;
                }
                case 22: {
                    arg9.propertySet.visibility = arg10.getInt(v1, arg9.propertySet.visibility);
                    arg9.propertySet.visibility = ConstraintSet.VISIBILITY_FLAGS[arg9.propertySet.visibility];
                    break;
                }
                case 23: {
                    arg9.layout.mWidth = arg10.getLayoutDimension(v1, arg9.layout.mWidth);
                    break;
                }
                case 24: {
                    arg9.layout.leftMargin = arg10.getDimensionPixelSize(v1, arg9.layout.leftMargin);
                    break;
                }
                case 25: {
                    arg9.layout.leftToLeft = ConstraintSet.lookupID(arg10, v1, arg9.layout.leftToLeft);
                    break;
                }
                case 26: {
                    arg9.layout.leftToRight = ConstraintSet.lookupID(arg10, v1, arg9.layout.leftToRight);
                    break;
                }
                case 27: {
                    arg9.layout.orientation = arg10.getInt(v1, arg9.layout.orientation);
                    break;
                }
                case 28: {
                    arg9.layout.rightMargin = arg10.getDimensionPixelSize(v1, arg9.layout.rightMargin);
                    break;
                }
                case 29: {
                    arg9.layout.rightToLeft = ConstraintSet.lookupID(arg10, v1, arg9.layout.rightToLeft);
                    break;
                }
                case 30: {
                    arg9.layout.rightToRight = ConstraintSet.lookupID(arg10, v1, arg9.layout.rightToRight);
                    break;
                }
                case 31: {
                    arg9.layout.startMargin = arg10.getDimensionPixelSize(v1, arg9.layout.startMargin);
                    break;
                }
                case 32: {
                    arg9.layout.startToEnd = ConstraintSet.lookupID(arg10, v1, arg9.layout.startToEnd);
                    break;
                }
                case 33: {
                    arg9.layout.startToStart = ConstraintSet.lookupID(arg10, v1, arg9.layout.startToStart);
                    break;
                }
                case 34: {
                    arg9.layout.topMargin = arg10.getDimensionPixelSize(v1, arg9.layout.topMargin);
                    break;
                }
                case 35: {
                    arg9.layout.topToBottom = ConstraintSet.lookupID(arg10, v1, arg9.layout.topToBottom);
                    break;
                }
                case 36: {
                    arg9.layout.topToTop = ConstraintSet.lookupID(arg10, v1, arg9.layout.topToTop);
                    break;
                }
                case 37: {
                    arg9.layout.verticalBias = arg10.getFloat(v1, arg9.layout.verticalBias);
                    break;
                }
                case 38: {
                    arg9.mViewId = arg10.getResourceId(v1, arg9.mViewId);
                    break;
                }
                case 39: {
                    arg9.layout.horizontalWeight = arg10.getFloat(v1, arg9.layout.horizontalWeight);
                    break;
                }
                case 40: {
                    arg9.layout.verticalWeight = arg10.getFloat(v1, arg9.layout.verticalWeight);
                    break;
                }
                case 41: {
                    arg9.layout.horizontalChainStyle = arg10.getInt(v1, arg9.layout.horizontalChainStyle);
                    break;
                }
                case 42: {
                    arg9.layout.verticalChainStyle = arg10.getInt(v1, arg9.layout.verticalChainStyle);
                    break;
                }
                case 43: {
                    arg9.propertySet.alpha = arg10.getFloat(v1, arg9.propertySet.alpha);
                    break;
                }
                case 44: {
                    arg9.transform.applyElevation = true;
                    arg9.transform.elevation = arg10.getDimension(v1, arg9.transform.elevation);
                    break;
                }
                case 45: {
                    arg9.transform.rotationX = arg10.getFloat(v1, arg9.transform.rotationX);
                    break;
                }
                case 46: {
                    arg9.transform.rotationY = arg10.getFloat(v1, arg9.transform.rotationY);
                    break;
                }
                case 47: {
                    arg9.transform.scaleX = arg10.getFloat(v1, arg9.transform.scaleX);
                    break;
                }
                case 48: {
                    arg9.transform.scaleY = arg10.getFloat(v1, arg9.transform.scaleY);
                    break;
                }
                case 49: {
                    arg9.transform.transformPivotX = arg10.getDimension(v1, arg9.transform.transformPivotX);
                    break;
                }
                case 50: {
                    arg9.transform.transformPivotY = arg10.getDimension(v1, arg9.transform.transformPivotY);
                    break;
                }
                case 51: {
                    arg9.transform.translationX = arg10.getDimension(v1, arg9.transform.translationX);
                    break;
                }
                case 52: {
                    arg9.transform.translationY = arg10.getDimension(v1, arg9.transform.translationY);
                    break;
                }
                case 53: {
                    arg9.transform.translationZ = arg10.getDimension(v1, arg9.transform.translationZ);
                    break;
                }
                case 54: {
                    arg9.layout.widthDefault = arg10.getInt(v1, arg9.layout.widthDefault);
                    break;
                }
                case 55: {
                    arg9.layout.heightDefault = arg10.getInt(v1, arg9.layout.heightDefault);
                    break;
                }
                case 56: {
                    arg9.layout.widthMax = arg10.getDimensionPixelSize(v1, arg9.layout.widthMax);
                    break;
                }
                case 57: {
                    arg9.layout.heightMax = arg10.getDimensionPixelSize(v1, arg9.layout.heightMax);
                    break;
                }
                case 58: {
                    arg9.layout.widthMin = arg10.getDimensionPixelSize(v1, arg9.layout.widthMin);
                    break;
                }
                case 59: {
                    arg9.layout.heightMin = arg10.getDimensionPixelSize(v1, arg9.layout.heightMin);
                    break;
                }
                case 60: {
                    arg9.transform.rotation = arg10.getFloat(v1, arg9.transform.rotation);
                    break;
                }
                case 61: {
                    arg9.layout.circleConstraint = ConstraintSet.lookupID(arg10, v1, arg9.layout.circleConstraint);
                    break;
                }
                case 62: {
                    arg9.layout.circleRadius = arg10.getDimensionPixelSize(v1, arg9.layout.circleRadius);
                    break;
                }
                case 63: {
                    arg9.layout.circleAngle = arg10.getFloat(v1, arg9.layout.circleAngle);
                    break;
                }
                case 64: {
                    arg9.motion.mAnimateRelativeTo = ConstraintSet.lookupID(arg10, v1, arg9.motion.mAnimateRelativeTo);
                    break;
                }
                case 65: {
                    if(arg10.peekValue(v1).type == 3) {
                        arg9.motion.mTransitionEasing = arg10.getString(v1);
                        goto label_534;
                    }

                    arg9.motion.mTransitionEasing = Easing.NAMED_EASING[arg10.getInteger(v1, 0)];
                    break;
                }
                case 66: {
                    arg9.motion.mDrawPath = arg10.getInt(v1, 0);
                    break;
                }
                case 67: {
                    arg9.motion.mPathRotate = arg10.getFloat(v1, arg9.motion.mPathRotate);
                    break;
                }
                case 68: {
                    arg9.propertySet.mProgress = arg10.getFloat(v1, arg9.propertySet.mProgress);
                    break;
                }
                case 69: {
                    arg9.layout.widthPercent = arg10.getFloat(v1, v5);
                    break;
                }
                case 70: {
                    arg9.layout.heightPercent = arg10.getFloat(v1, v5);
                    break;
                }
                case 71: {
                    Log.e(v6, "CURRENTLY UNSUPPORTED");
                    break;
                }
                case 72: {
                    arg9.layout.mBarrierDirection = arg10.getInt(v1, arg9.layout.mBarrierDirection);
                    break;
                }
                case 73: {
                    arg9.layout.mBarrierMargin = arg10.getDimensionPixelSize(v1, arg9.layout.mBarrierMargin);
                    break;
                }
                case 74: {
                    arg9.layout.mReferenceIdString = arg10.getString(v1);
                    break;
                }
                case 75: {
                    arg9.layout.mBarrierAllowsGoneWidgets = arg10.getBoolean(v1, arg9.layout.mBarrierAllowsGoneWidgets);
                    break;
                }
                case 76: {
                    arg9.motion.mPathMotionArc = arg10.getInt(v1, arg9.motion.mPathMotionArc);
                    break;
                }
                case 77: {
                    arg9.layout.mConstraintTag = arg10.getString(v1);
                    break;
                }
                case 78: {
                    arg9.propertySet.mVisibilityMode = arg10.getInt(v1, arg9.propertySet.mVisibilityMode);
                    break;
                }
                case 79: {
                    arg9.motion.mMotionStagger = arg10.getFloat(v1, arg9.motion.mMotionStagger);
                    break;
                }
                case 80: {
                    arg9.layout.constrainedWidth = arg10.getBoolean(v1, arg9.layout.constrainedWidth);
                    break;
                }
                case 81: {
                    arg9.layout.constrainedHeight = arg10.getBoolean(v1, arg9.layout.constrainedHeight);
                    break;
                }
                case 82: {
                    Log.w(v6, "unused attribute 0x" + Integer.toHexString(v1) + v4 + ConstraintSet.mapToConstant.get(v1));
                    break;
                }
                default: {
                    Log.w(v6, "Unknown attribute 0x" + Integer.toHexString(v1) + v4 + ConstraintSet.mapToConstant.get(v1));
                    break;
                }
            }

        label_534:
        }
    }

    public void readFallback(ConstraintSet arg8) {
        Iterator v0 = arg8.mConstraints.keySet().iterator();
    label_3:
        if(v0.hasNext()) {
            Object v1 = v0.next();
            int v2 = ((Integer)v1).intValue();
            v1 = arg8.mConstraints.get(v1);
            if(!this.mConstraints.containsKey(Integer.valueOf(v2))) {
                this.mConstraints.put(Integer.valueOf(v2), new Constraint());
            }

            Object v2_1 = this.mConstraints.get(Integer.valueOf(v2));
            if(!((Constraint)v2_1).layout.mApply) {
                ((Constraint)v2_1).layout.copyFrom(((Constraint)v1).layout);
            }

            if(!((Constraint)v2_1).propertySet.mApply) {
                ((Constraint)v2_1).propertySet.copyFrom(((Constraint)v1).propertySet);
            }

            if(!((Constraint)v2_1).transform.mApply) {
                ((Constraint)v2_1).transform.copyFrom(((Constraint)v1).transform);
            }

            if(!((Constraint)v2_1).motion.mApply) {
                ((Constraint)v2_1).motion.copyFrom(((Constraint)v1).motion);
            }

            Iterator v3 = ((Constraint)v1).mCustomConstraints.keySet().iterator();
            while(true) {
                if(!v3.hasNext()) {
                    goto label_3;
                }

                Object v4 = v3.next();
                if(((Constraint)v2_1).mCustomConstraints.containsKey(v4)) {
                    continue;
                }

                ((Constraint)v2_1).mCustomConstraints.put(v4, ((Constraint)v1).mCustomConstraints.get(v4));
            }
        }
    }

    public void readFallback(ConstraintLayout arg11) {
        int v0 = arg11.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg11.getChildAt(v1);
            ViewGroup$LayoutParams v3 = v2.getLayoutParams();
            int v4 = v2.getId();
            if(this.mForceId) {
                if(v4 != -1) {
                }
                else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }

            if(!this.mConstraints.containsKey(Integer.valueOf(v4))) {
                this.mConstraints.put(Integer.valueOf(v4), new Constraint());
            }

            Object v5 = this.mConstraints.get(Integer.valueOf(v4));
            if(!((Constraint)v5).layout.mApply) {
                Constraint.access$000(((Constraint)v5), v4, ((LayoutParams)v3));
                if((v2 instanceof ConstraintHelper)) {
                    ((Constraint)v5).layout.mReferenceIds = v2.getReferencedIds();
                    if((v2 instanceof Barrier)) {
                        ((Constraint)v5).layout.mBarrierAllowsGoneWidgets = v2.allowsGoneWidget();
                        ((Constraint)v5).layout.mBarrierDirection = v2.getType();
                        ((Constraint)v5).layout.mBarrierMargin = v2.getMargin();
                    }
                }

                ((Constraint)v5).layout.mApply = true;
            }

            if(!((Constraint)v5).propertySet.mApply) {
                ((Constraint)v5).propertySet.visibility = v2.getVisibility();
                ((Constraint)v5).propertySet.alpha = v2.getAlpha();
                ((Constraint)v5).propertySet.mApply = true;
            }

            if(!((Constraint)v5).transform.mApply) {
                ((Constraint)v5).transform.mApply = true;
                ((Constraint)v5).transform.rotation = v2.getRotation();
                ((Constraint)v5).transform.rotationX = v2.getRotationX();
                ((Constraint)v5).transform.rotationY = v2.getRotationY();
                ((Constraint)v5).transform.scaleX = v2.getScaleX();
                ((Constraint)v5).transform.scaleY = v2.getScaleY();
                float v3_1 = v2.getPivotX();
                float v4_1 = v2.getPivotY();
                double v8 = 0;
                if((((double)v3_1)) != v8 || (((double)v4_1)) != v8) {
                    ((Constraint)v5).transform.transformPivotX = v3_1;
                    ((Constraint)v5).transform.transformPivotY = v4_1;
                }

                ((Constraint)v5).transform.translationX = v2.getTranslationX();
                ((Constraint)v5).transform.translationY = v2.getTranslationY();
                ((Constraint)v5).transform.translationZ = v2.getTranslationZ();
                if(!((Constraint)v5).transform.applyElevation) {
                    goto label_109;
                }

                ((Constraint)v5).transform.elevation = v2.getElevation();
            }

        label_109:
        }
    }

    public void removeAttribute(String arg1) {
        this.mSavedAttributes.remove(arg1);
    }

    public void removeFromHorizontalChain(int arg14) {
        ConstraintSet v2;
        if(this.mConstraints.containsKey(Integer.valueOf(arg14))) {
            Object v0 = this.mConstraints.get(Integer.valueOf(arg14));
            int v3 = ((Constraint)v0).layout.leftToRight;
            int v5 = ((Constraint)v0).layout.rightToLeft;
            int v1 = -1;
            if(v3 == v1) {
                if(v5 != v1) {
                }
                else {
                    v5 = ((Constraint)v0).layout.startToEnd;
                    int v7 = ((Constraint)v0).layout.endToStart;
                    if(v5 != v1 || v7 != v1) {
                        if(v5 != v1 && v7 != v1) {
                            this.connect(v5, 7, v7, 6, 0);
                            v2 = this;
                            v2.connect(v7, 6, v3, 7, 0);
                            goto label_61;
                        }

                        v2 = this;
                        if(v3 == v1 && v7 == v1) {
                            goto label_61;
                        }

                        if(((Constraint)v0).layout.rightToRight != v1) {
                            v2.connect(v3, 7, ((Constraint)v0).layout.rightToRight, 7, 0);
                            goto label_61;
                        }

                        if(((Constraint)v0).layout.leftToLeft == v1) {
                            goto label_61;
                        }

                        v2.connect(v7, 6, ((Constraint)v0).layout.leftToLeft, 6, 0);
                    }
                    else {
                        v2 = this;
                    }

                label_61:
                    v2.clear(arg14, 6);
                    v2.clear(arg14, 7);
                    return;
                }
            }

            v2 = this;
            if(v3 == v1 || v5 == v1) {
                if(v3 == v1 && v5 == v1) {
                    goto label_102;
                }

                if(((Constraint)v0).layout.rightToRight != v1) {
                    v2.connect(v3, 2, ((Constraint)v0).layout.rightToRight, 2, 0);
                    goto label_102;
                }

                if(((Constraint)v0).layout.leftToLeft == v1) {
                    goto label_102;
                }

                v2.connect(v5, 1, ((Constraint)v0).layout.leftToLeft, 1, 0);
            }
            else {
                v2.connect(v3, 2, v5, 1, 0);
                v2.connect(v5, 1, v3, 2, 0);
            }

        label_102:
            v2.clear(arg14, 1);
            v2.clear(arg14, 2);
        }
    }

    public void removeFromVerticalChain(int arg12) {
        ConstraintSet v2;
        if(this.mConstraints.containsKey(Integer.valueOf(arg12))) {
            Object v0 = this.mConstraints.get(Integer.valueOf(arg12));
            int v3 = ((Constraint)v0).layout.topToBottom;
            int v5 = ((Constraint)v0).layout.bottomToTop;
            int v1 = -1;
            if(v3 == v1 && v5 == v1) {
                goto label_52;
            }

            if(v3 != v1 && v5 != v1) {
                v2 = this;
                v2.connect(v3, 4, v5, 3, 0);
                v2.connect(v5, 3, v3, 4, 0);
                goto label_53;
            }

            v2 = this;
            if(v3 == v1 && v5 == v1) {
                goto label_53;
            }

            if(((Constraint)v0).layout.bottomToBottom != v1) {
                v2.connect(v3, 4, ((Constraint)v0).layout.bottomToBottom, 4, 0);
                goto label_53;
            }

            if(((Constraint)v0).layout.topToTop == v1) {
                goto label_53;
            }

            v2.connect(v5, 3, ((Constraint)v0).layout.topToTop, 3, 0);
        }
        else {
        label_52:
            v2 = this;
        }

    label_53:
        v2.clear(arg12, 3);
        v2.clear(arg12, 4);
    }

    public void setAlpha(int arg1, float arg2) {
        this.get(arg1).propertySet.alpha = arg2;
    }

    public void setApplyElevation(int arg1, boolean arg2) {
        this.get(arg1).transform.applyElevation = arg2;
    }

    public void setBarrierType(int arg1, int arg2) {
        this.get(arg1).layout.mHelperType = arg2;
    }

    public void setColorValue(int arg1, String arg2, int arg3) {
        Constraint.access$600(this.get(arg1), arg2, arg3);
    }

    public void setDimensionRatio(int arg1, String arg2) {
        this.get(arg1).layout.dimensionRatio = arg2;
    }

    public void setEditorAbsoluteX(int arg1, int arg2) {
        this.get(arg1).layout.editorAbsoluteX = arg2;
    }

    public void setEditorAbsoluteY(int arg1, int arg2) {
        this.get(arg1).layout.editorAbsoluteY = arg2;
    }

    public void setElevation(int arg2, float arg3) {
        this.get(arg2).transform.elevation = arg3;
        this.get(arg2).transform.applyElevation = true;
    }

    public void setFloatValue(int arg1, String arg2, float arg3) {
        Constraint.access$700(this.get(arg1), arg2, arg3);
    }

    public void setForceId(boolean arg1) {
        this.mForceId = arg1;
    }

    public void setGoneMargin(int arg1, int arg2, int arg3) {
        Constraint v0 = this.get(arg1);
        switch(arg2) {
            case 1: {
                goto label_25;
            }
            case 2: {
                goto label_22;
            }
            case 3: {
                goto label_19;
            }
            case 4: {
                goto label_16;
            }
            case 5: {
                goto label_12;
            }
            case 6: {
                goto label_9;
            }
            case 7: {
                goto label_6;
            }
        }

        throw new IllegalArgumentException("unknown constraint");
    label_19:
        v0.layout.goneTopMargin = arg3;
        return;
    label_22:
        v0.layout.goneRightMargin = arg3;
        return;
    label_6:
        v0.layout.goneEndMargin = arg3;
        return;
    label_25:
        v0.layout.goneLeftMargin = arg3;
        return;
    label_9:
        v0.layout.goneStartMargin = arg3;
        return;
    label_12:
        throw new IllegalArgumentException("baseline does not support margins");
    label_16:
        v0.layout.goneBottomMargin = arg3;
    }

    public void setGuidelineBegin(int arg2, int arg3) {
        this.get(arg2).layout.guideBegin = arg3;
        this.get(arg2).layout.guideEnd = -1;
        this.get(arg2).layout.guidePercent = -1f;
    }

    public void setGuidelineEnd(int arg2, int arg3) {
        this.get(arg2).layout.guideEnd = arg3;
        this.get(arg2).layout.guideBegin = -1;
        this.get(arg2).layout.guidePercent = -1f;
    }

    public void setGuidelinePercent(int arg2, float arg3) {
        this.get(arg2).layout.guidePercent = arg3;
        this.get(arg2).layout.guideEnd = -1;
        this.get(arg2).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int arg1, float arg2) {
        this.get(arg1).layout.horizontalBias = arg2;
    }

    public void setHorizontalChainStyle(int arg1, int arg2) {
        this.get(arg1).layout.horizontalChainStyle = arg2;
    }

    public void setHorizontalWeight(int arg1, float arg2) {
        this.get(arg1).layout.horizontalWeight = arg2;
    }

    public void setIntValue(int arg1, String arg2, int arg3) {
        Constraint.access$500(this.get(arg1), arg2, arg3);
    }

    public void setMargin(int arg1, int arg2, int arg3) {
        Constraint v0 = this.get(arg1);
        switch(arg2) {
            case 1: {
                goto label_25;
            }
            case 2: {
                goto label_22;
            }
            case 3: {
                goto label_19;
            }
            case 4: {
                goto label_16;
            }
            case 5: {
                goto label_12;
            }
            case 6: {
                goto label_9;
            }
            case 7: {
                goto label_6;
            }
        }

        throw new IllegalArgumentException("unknown constraint");
    label_19:
        v0.layout.topMargin = arg3;
        return;
    label_22:
        v0.layout.rightMargin = arg3;
        return;
    label_6:
        v0.layout.endMargin = arg3;
        return;
    label_25:
        v0.layout.leftMargin = arg3;
        return;
    label_9:
        v0.layout.startMargin = arg3;
        return;
    label_12:
        throw new IllegalArgumentException("baseline does not support margins");
    label_16:
        v0.layout.bottomMargin = arg3;
    }

    public void setReferencedIds(int arg1, int[] arg2) {
        this.get(arg1).layout.mReferenceIds = arg2;
    }

    public void setRotation(int arg1, float arg2) {
        this.get(arg1).transform.rotation = arg2;
    }

    public void setRotationX(int arg1, float arg2) {
        this.get(arg1).transform.rotationX = arg2;
    }

    public void setRotationY(int arg1, float arg2) {
        this.get(arg1).transform.rotationY = arg2;
    }

    public void setScaleX(int arg1, float arg2) {
        this.get(arg1).transform.scaleX = arg2;
    }

    public void setScaleY(int arg1, float arg2) {
        this.get(arg1).transform.scaleY = arg2;
    }

    public void setStringValue(int arg1, String arg2, String arg3) {
        Constraint.access$800(this.get(arg1), arg2, arg3);
    }

    public void setTransformPivot(int arg1, float arg2, float arg3) {
        Constraint v0 = this.get(arg1);
        v0.transform.transformPivotY = arg3;
        v0.transform.transformPivotX = arg2;
    }

    public void setTransformPivotX(int arg1, float arg2) {
        this.get(arg1).transform.transformPivotX = arg2;
    }

    public void setTransformPivotY(int arg1, float arg2) {
        this.get(arg1).transform.transformPivotY = arg2;
    }

    public void setTranslation(int arg1, float arg2, float arg3) {
        Constraint v0 = this.get(arg1);
        v0.transform.translationX = arg2;
        v0.transform.translationY = arg3;
    }

    public void setTranslationX(int arg1, float arg2) {
        this.get(arg1).transform.translationX = arg2;
    }

    public void setTranslationY(int arg1, float arg2) {
        this.get(arg1).transform.translationY = arg2;
    }

    public void setTranslationZ(int arg1, float arg2) {
        this.get(arg1).transform.translationZ = arg2;
    }

    public void setValidateOnParse(boolean arg1) {
        this.mValidate = arg1;
    }

    public void setVerticalBias(int arg1, float arg2) {
        this.get(arg1).layout.verticalBias = arg2;
    }

    public void setVerticalChainStyle(int arg1, int arg2) {
        this.get(arg1).layout.verticalChainStyle = arg2;
    }

    public void setVerticalWeight(int arg1, float arg2) {
        this.get(arg1).layout.verticalWeight = arg2;
    }

    public void setVisibility(int arg1, int arg2) {
        this.get(arg1).propertySet.visibility = arg2;
    }

    public void setVisibilityMode(int arg1, int arg2) {
        this.get(arg1).propertySet.mVisibilityMode = arg2;
    }

    private String sideToString(int arg1) {
        switch(arg1) {
            case 1: {
                return "left";
            }
            case 2: {
                return "right";
            }
            case 3: {
                return "top";
            }
            case 4: {
                return "bottom";
            }
            case 5: {
                return "baseline";
            }
            case 6: {
                return "start";
            }
            case 7: {
                return "end";
            }
        }

        return "undefined";
    }

    private static String[] splitString(String arg6) {
        char[] v6 = arg6.toCharArray();
        ArrayList v0 = new ArrayList();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v1 < v6.length) {
            int v4 = v6[v1];
            if(v4 == 44 && v3 == 0) {
                v0.add(new String(v6, v2, v1 - v2));
                v2 = v1 + 1;
            }
            else if(v4 == 34) {
                v3 ^= 1;
            }

            ++v1;
        }

        v0.add(new String(v6, v2, v6.length - v2));
        return v0.toArray(new String[v0.size()]);
    }
}

