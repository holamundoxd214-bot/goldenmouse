package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ConstraintReference implements Reference {
    class androidx.constraintlayout.solver.state.ConstraintReference$1 {
        static {
            int[] v0 = new int[Constraint.values().length];
            androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = v0;
            try {
                v0[Constraint.LEFT_TO_LEFT.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.START_TO_START.ordinal()] = 5;
                                goto label_28;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_28:
                                    androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.START_TO_END.ordinal()] = 6;
                                    goto label_33;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_33:
                                        androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.END_TO_START.ordinal()] = 7;
                                        goto label_38;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_38:
                                            androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.END_TO_END.ordinal()] = 8;
                                            goto label_43;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_43:
                                                androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.TOP_TO_TOP.ordinal()] = 9;
                                                goto label_48;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_48:
                                                    androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
                                                    goto label_53;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_53:
                                                        androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
                                                        goto label_58;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_58:
                                                            androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
                                                            goto label_63;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_63:
                                                                androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.BASELINE_TO_BASELINE.ordinal()] = 13;
                                                                goto label_68;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_68:
                                                                    androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.CENTER_HORIZONTALLY.ordinal()] = 14;
                                                                    goto label_73;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_73:
                                                                        androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[Constraint.CENTER_VERTICALLY.ordinal()] = 15;
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
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State arg1);
    }

    class IncorrectConstraintException extends Exception {
        private final ArrayList mErrors;

        public IncorrectConstraintException(ConstraintReference arg1, ArrayList arg2) {
            ConstraintReference.this = arg1;
            super();
            this.mErrors = arg2;
        }

        public ArrayList getErrors() {
            return this.mErrors;
        }

        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    private Object key;
    Object mBaselineToBaseline;
    Object mBottomToBottom;
    Object mBottomToTop;
    private ConstraintWidget mConstraintWidget;
    Object mEndToEnd;
    Object mEndToStart;
    float mHorizontalBias;
    int mHorizontalChainStyle;
    Dimension mHorizontalDimension;
    Constraint mLast;
    Object mLeftToLeft;
    Object mLeftToRight;
    int mMarginBottom;
    int mMarginBottomGone;
    int mMarginEnd;
    int mMarginEndGone;
    int mMarginLeft;
    int mMarginLeftGone;
    int mMarginRight;
    int mMarginRightGone;
    int mMarginStart;
    int mMarginStartGone;
    int mMarginTop;
    int mMarginTopGone;
    Object mRightToLeft;
    Object mRightToRight;
    Object mStartToEnd;
    Object mStartToStart;
    final State mState;
    Object mTopToBottom;
    Object mTopToTop;
    float mVerticalBias;
    int mVerticalChainStyle;
    Dimension mVerticalDimension;
    private Object mView;

    public ConstraintReference(State arg3) {
        super();
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginStart = 0;
        this.mMarginEnd = 0;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mBaselineToBaseline = null;
        this.mLast = null;
        this.mHorizontalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
        this.mVerticalDimension = Dimension.Fixed(Dimension.WRAP_DIMENSION);
        this.mState = arg3;
    }

    public void apply() {
        ConstraintWidget v0 = this.mConstraintWidget;
        if(v0 == null) {
            return;
        }

        this.mHorizontalDimension.apply(this.mState, v0, 0);
        this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
        this.dereference();
        this.applyConnection(this.mConstraintWidget, this.mLeftToLeft, Constraint.LEFT_TO_LEFT);
        this.applyConnection(this.mConstraintWidget, this.mLeftToRight, Constraint.LEFT_TO_RIGHT);
        this.applyConnection(this.mConstraintWidget, this.mRightToLeft, Constraint.RIGHT_TO_LEFT);
        this.applyConnection(this.mConstraintWidget, this.mRightToRight, Constraint.RIGHT_TO_RIGHT);
        this.applyConnection(this.mConstraintWidget, this.mStartToStart, Constraint.START_TO_START);
        this.applyConnection(this.mConstraintWidget, this.mStartToEnd, Constraint.START_TO_END);
        this.applyConnection(this.mConstraintWidget, this.mEndToStart, Constraint.END_TO_START);
        this.applyConnection(this.mConstraintWidget, this.mEndToEnd, Constraint.END_TO_END);
        this.applyConnection(this.mConstraintWidget, this.mTopToTop, Constraint.TOP_TO_TOP);
        this.applyConnection(this.mConstraintWidget, this.mTopToBottom, Constraint.TOP_TO_BOTTOM);
        this.applyConnection(this.mConstraintWidget, this.mBottomToTop, Constraint.BOTTOM_TO_TOP);
        this.applyConnection(this.mConstraintWidget, this.mBottomToBottom, Constraint.BOTTOM_TO_BOTTOM);
        this.applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, Constraint.BASELINE_TO_BASELINE);
        int v0_1 = this.mHorizontalChainStyle;
        if(v0_1 != 0) {
            this.mConstraintWidget.setHorizontalChainStyle(v0_1);
        }

        v0_1 = this.mVerticalChainStyle;
        if(v0_1 != 0) {
            this.mConstraintWidget.setVerticalChainStyle(v0_1);
        }

        this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
        this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
    }

    private void applyConnection(ConstraintWidget arg7, Object arg8, Constraint arg9) {
        ConstraintWidget v2 = this.getTarget(arg8);
        if(v2 == null) {
        }
        else {
            arg9.ordinal();
            switch(androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[arg9.ordinal()]) {
                case 1: {
                    goto label_118;
                }
                case 2: {
                    goto label_109;
                }
                case 3: {
                    goto label_100;
                }
                case 4: {
                    goto label_91;
                }
                case 5: {
                    goto label_82;
                }
                case 6: {
                    goto label_73;
                }
                case 7: {
                    goto label_64;
                }
                case 8: {
                    goto label_55;
                }
                case 9: {
                    goto label_46;
                }
                case 10: {
                    goto label_37;
                }
                case 11: {
                    goto label_28;
                }
                case 12: {
                    goto label_19;
                }
                case 13: {
                    goto label_12;
                }
            }

            return;
        label_100:
            arg7.getAnchor(Type.RIGHT).connect(v2.getAnchor(Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
            return;
        label_37:
            arg7.getAnchor(Type.TOP).connect(v2.getAnchor(Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
            return;
        label_73:
            arg7.getAnchor(Type.LEFT).connect(v2.getAnchor(Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
            return;
        label_12:
            arg7.immediateConnect(Type.BASELINE, v2, Type.BASELINE, 0, 0);
            return;
        label_109:
            arg7.getAnchor(Type.LEFT).connect(v2.getAnchor(Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
            return;
        label_46:
            arg7.getAnchor(Type.TOP).connect(v2.getAnchor(Type.TOP), this.mMarginTop, this.mMarginTopGone, false);
            return;
        label_82:
            arg7.getAnchor(Type.LEFT).connect(v2.getAnchor(Type.LEFT), this.mMarginStart, this.mMarginStartGone, false);
            return;
        label_19:
            arg7.getAnchor(Type.BOTTOM).connect(v2.getAnchor(Type.BOTTOM), this.mMarginBottom, this.mMarginBottomGone, false);
            return;
        label_118:
            arg7.getAnchor(Type.LEFT).connect(v2.getAnchor(Type.LEFT), this.mMarginLeft, this.mMarginLeftGone, false);
        }

        return;
    label_55:
        arg7.getAnchor(Type.RIGHT).connect(v2.getAnchor(Type.RIGHT), this.mMarginEnd, this.mMarginEndGone, false);
        return;
    label_91:
        arg7.getAnchor(Type.RIGHT).connect(v2.getAnchor(Type.RIGHT), this.mMarginRight, this.mMarginRightGone, false);
        return;
    label_28:
        arg7.getAnchor(Type.BOTTOM).connect(v2.getAnchor(Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
        return;
    label_64:
        arg7.getAnchor(Type.RIGHT).connect(v2.getAnchor(Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
    }

    public ConstraintReference baseline() {
        this.mLast = Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object arg2) {
        this.mLast = Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = arg2;
        return this;
    }

    public ConstraintReference bias(float arg3) {
        if(this.mLast == null) {
        }
        else {
            switch(androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[this.mLast.ordinal()]) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 14: {
                    goto label_11;
                }
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 15: {
                    goto label_9;
                }
            }

            return this;
        label_9:
            this.mVerticalBias = arg3;
            return this;
        label_11:
            this.mHorizontalBias = arg3;
        }

        return this;
    }

    public ConstraintReference bottom() {
        if(this.mBottomToTop != null) {
            this.mLast = Constraint.BOTTOM_TO_TOP;
            return this;
        }

        this.mLast = Constraint.BOTTOM_TO_BOTTOM;
        return this;
    }

    public ConstraintReference bottomToBottom(Object arg2) {
        this.mLast = Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = arg2;
        return this;
    }

    public ConstraintReference bottomToTop(Object arg2) {
        this.mLast = Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = arg2;
        return this;
    }

    public ConstraintReference centerHorizontally(Object arg1) {
        arg1 = this.get(arg1);
        this.mStartToStart = arg1;
        this.mEndToEnd = arg1;
        this.mLast = Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object arg1) {
        arg1 = this.get(arg1);
        this.mTopToTop = arg1;
        this.mBottomToBottom = arg1;
        this.mLast = Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference clear() {
        Object v2 = null;
        if(this.mLast == null) {
            goto label_42;
        }

        switch(androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[this.mLast.ordinal()]) {
            case 1: 
            case 2: {
                goto label_37;
            }
            case 3: 
            case 4: {
                goto label_32;
            }
            case 5: 
            case 6: {
                goto label_27;
            }
            case 7: 
            case 8: {
                goto label_22;
            }
            case 9: 
            case 10: {
                goto label_17;
            }
            case 11: 
            case 12: {
                goto label_12;
            }
            case 13: {
                goto label_10;
            }
        }

        return this;
    label_37:
        this.mLeftToLeft = v2;
        this.mLeftToRight = v2;
        this.mMarginLeft = 0;
        this.mMarginLeftGone = 0;
        return this;
    label_10:
        this.mBaselineToBaseline = v2;
        return this;
    label_12:
        this.mBottomToTop = v2;
        this.mBottomToBottom = v2;
        this.mMarginBottom = 0;
        this.mMarginBottomGone = 0;
        return this;
    label_17:
        this.mTopToTop = v2;
        this.mTopToBottom = v2;
        this.mMarginTop = 0;
        this.mMarginTopGone = 0;
        return this;
    label_22:
        this.mEndToStart = v2;
        this.mEndToEnd = v2;
        this.mMarginEnd = 0;
        this.mMarginEndGone = 0;
        return this;
    label_27:
        this.mStartToStart = v2;
        this.mStartToEnd = v2;
        this.mMarginStart = 0;
        this.mMarginStartGone = 0;
        return this;
    label_32:
        this.mRightToLeft = v2;
        this.mRightToRight = v2;
        this.mMarginRight = 0;
        this.mMarginRightGone = 0;
        return this;
    label_42:
        this.mLeftToLeft = v2;
        this.mLeftToRight = v2;
        this.mMarginLeft = 0;
        this.mRightToLeft = v2;
        this.mRightToRight = v2;
        this.mMarginRight = 0;
        this.mStartToStart = v2;
        this.mStartToEnd = v2;
        this.mMarginStart = 0;
        this.mEndToStart = v2;
        this.mEndToEnd = v2;
        this.mMarginEnd = 0;
        this.mTopToTop = v2;
        this.mTopToBottom = v2;
        this.mMarginTop = 0;
        this.mBottomToTop = v2;
        this.mBottomToBottom = v2;
        this.mMarginBottom = 0;
        this.mBaselineToBaseline = v2;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        return this;
    }

    public ConstraintReference clearHorizontal() {
        this.start().clear();
        this.end().clear();
        this.left().clear();
        this.right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        this.top().clear();
        this.baseline().clear();
        this.bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(this.getWidth().getValue(), this.getHeight().getValue());
    }

    private void dereference() {
        this.mLeftToLeft = this.get(this.mLeftToLeft);
        this.mLeftToRight = this.get(this.mLeftToRight);
        this.mRightToLeft = this.get(this.mRightToLeft);
        this.mRightToRight = this.get(this.mRightToRight);
        this.mStartToStart = this.get(this.mStartToStart);
        this.mStartToEnd = this.get(this.mStartToEnd);
        this.mEndToStart = this.get(this.mEndToStart);
        this.mEndToEnd = this.get(this.mEndToEnd);
        this.mTopToTop = this.get(this.mTopToTop);
        this.mTopToBottom = this.get(this.mTopToBottom);
        this.mBottomToTop = this.get(this.mBottomToTop);
        this.mBottomToBottom = this.get(this.mBottomToBottom);
        this.mBaselineToBaseline = this.get(this.mBaselineToBaseline);
    }

    public ConstraintReference end() {
        if(this.mEndToStart != null) {
            this.mLast = Constraint.END_TO_START;
            return this;
        }

        this.mLast = Constraint.END_TO_END;
        return this;
    }

    public ConstraintReference endToEnd(Object arg2) {
        this.mLast = Constraint.END_TO_END;
        this.mEndToEnd = arg2;
        return this;
    }

    public ConstraintReference endToStart(Object arg2) {
        this.mLast = Constraint.END_TO_START;
        this.mEndToStart = arg2;
        return this;
    }

    private Object get(Object arg2) {
        if(arg2 == null) {
            return null;
        }

        if(!(arg2 instanceof ConstraintReference)) {
            return this.mState.reference(arg2);
        }

        return arg2;
    }

    public ConstraintWidget getConstraintWidget() {
        if(this.mConstraintWidget == null) {
            ConstraintWidget v0 = this.createConstraintWidget();
            this.mConstraintWidget = v0;
            v0.setCompanionWidget(this.mView);
        }

        return this.mConstraintWidget;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public Object getKey() {
        return this.key;
    }

    private ConstraintWidget getTarget(Object arg1) {
        if((arg1 instanceof Reference)) {
            return ((Reference)arg1).getConstraintWidget();
        }

        return null;
    }

    public int getVerticalChainStyle(int arg1) {
        return this.mVerticalChainStyle;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference height(Dimension arg1) {
        return this.setHeight(arg1);
    }

    public ConstraintReference horizontalBias(float arg1) {
        this.mHorizontalBias = arg1;
        return this;
    }

    public ConstraintReference left() {
        if(this.mLeftToLeft != null) {
            this.mLast = Constraint.LEFT_TO_LEFT;
            return this;
        }

        this.mLast = Constraint.LEFT_TO_RIGHT;
        return this;
    }

    public ConstraintReference leftToLeft(Object arg2) {
        this.mLast = Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = arg2;
        return this;
    }

    public ConstraintReference leftToRight(Object arg2) {
        this.mLast = Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = arg2;
        return this;
    }

    public ConstraintReference margin(int arg3) {
        if(this.mLast == null) {
            goto label_20;
        }

        switch(androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[this.mLast.ordinal()]) {
            case 1: 
            case 2: {
                goto label_18;
            }
            case 3: 
            case 4: {
                goto label_16;
            }
            case 5: 
            case 6: {
                goto label_14;
            }
            case 7: 
            case 8: {
                goto label_12;
            }
            case 9: 
            case 10: {
                goto label_10;
            }
            case 11: 
            case 12: {
                goto label_8;
            }
        }

        return this;
    label_8:
        this.mMarginBottom = arg3;
        return this;
    label_10:
        this.mMarginTop = arg3;
        return this;
    label_12:
        this.mMarginEnd = arg3;
        return this;
    label_14:
        this.mMarginStart = arg3;
        return this;
    label_16:
        this.mMarginRight = arg3;
        return this;
    label_18:
        this.mMarginLeft = arg3;
        return this;
    label_20:
        this.mMarginLeft = arg3;
        this.mMarginRight = arg3;
        this.mMarginStart = arg3;
        this.mMarginEnd = arg3;
        this.mMarginTop = arg3;
        this.mMarginBottom = arg3;
        return this;
    }

    public ConstraintReference margin(Object arg2) {
        return this.margin(this.mState.convertDimension(arg2));
    }

    public ConstraintReference marginGone(int arg3) {
        if(this.mLast == null) {
            goto label_20;
        }

        switch(androidx.constraintlayout.solver.state.ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint[this.mLast.ordinal()]) {
            case 1: 
            case 2: {
                goto label_18;
            }
            case 3: 
            case 4: {
                goto label_16;
            }
            case 5: 
            case 6: {
                goto label_14;
            }
            case 7: 
            case 8: {
                goto label_12;
            }
            case 9: 
            case 10: {
                goto label_10;
            }
            case 11: 
            case 12: {
                goto label_8;
            }
        }

        return this;
    label_8:
        this.mMarginBottomGone = arg3;
        return this;
    label_10:
        this.mMarginTopGone = arg3;
        return this;
    label_12:
        this.mMarginEndGone = arg3;
        return this;
    label_14:
        this.mMarginStartGone = arg3;
        return this;
    label_16:
        this.mMarginRightGone = arg3;
        return this;
    label_18:
        this.mMarginLeftGone = arg3;
        return this;
    label_20:
        this.mMarginLeftGone = arg3;
        this.mMarginRightGone = arg3;
        this.mMarginStartGone = arg3;
        this.mMarginEndGone = arg3;
        this.mMarginTopGone = arg3;
        this.mMarginBottomGone = arg3;
        return this;
    }

    public ConstraintReference right() {
        if(this.mRightToLeft != null) {
            this.mLast = Constraint.RIGHT_TO_LEFT;
            return this;
        }

        this.mLast = Constraint.RIGHT_TO_RIGHT;
        return this;
    }

    public ConstraintReference rightToLeft(Object arg2) {
        this.mLast = Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = arg2;
        return this;
    }

    public ConstraintReference rightToRight(Object arg2) {
        this.mLast = Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = arg2;
        return this;
    }

    public void setConstraintWidget(ConstraintWidget arg1) {
        if(arg1 == null) {
            return;
        }

        this.mConstraintWidget = arg1;
        arg1.setCompanionWidget(this.mView);
    }

    public ConstraintReference setHeight(Dimension arg1) {
        this.mVerticalDimension = arg1;
        return this;
    }

    public void setHorizontalChainStyle(int arg1) {
        this.mHorizontalChainStyle = arg1;
    }

    public void setKey(Object arg1) {
        this.key = arg1;
    }

    public void setVerticalChainStyle(int arg1) {
        this.mVerticalChainStyle = arg1;
    }

    public void setView(Object arg1) {
        this.mView = arg1;
        ConstraintWidget v0 = this.mConstraintWidget;
        if(v0 != null) {
            v0.setCompanionWidget(arg1);
        }
    }

    public ConstraintReference setWidth(Dimension arg1) {
        this.mHorizontalDimension = arg1;
        return this;
    }

    public ConstraintReference start() {
        if(this.mStartToStart != null) {
            this.mLast = Constraint.START_TO_START;
            return this;
        }

        this.mLast = Constraint.START_TO_END;
        return this;
    }

    public ConstraintReference startToEnd(Object arg2) {
        this.mLast = Constraint.START_TO_END;
        this.mStartToEnd = arg2;
        return this;
    }

    public ConstraintReference startToStart(Object arg2) {
        this.mLast = Constraint.START_TO_START;
        this.mStartToStart = arg2;
        return this;
    }

    public ConstraintReference top() {
        if(this.mTopToTop != null) {
            this.mLast = Constraint.TOP_TO_TOP;
            return this;
        }

        this.mLast = Constraint.TOP_TO_BOTTOM;
        return this;
    }

    public ConstraintReference topToBottom(Object arg2) {
        this.mLast = Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = arg2;
        return this;
    }

    public ConstraintReference topToTop(Object arg2) {
        this.mLast = Constraint.TOP_TO_TOP;
        this.mTopToTop = arg2;
        return this;
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList v0 = new ArrayList();
        if(this.mLeftToLeft != null && this.mLeftToRight != null) {
            v0.add("LeftToLeft and LeftToRight both defined");
        }

        if(this.mRightToLeft != null && this.mRightToRight != null) {
            v0.add("RightToLeft and RightToRight both defined");
        }

        if(this.mStartToStart != null && this.mStartToEnd != null) {
            v0.add("StartToStart and StartToEnd both defined");
        }

        if(this.mEndToStart != null && this.mEndToEnd != null) {
            v0.add("EndToStart and EndToEnd both defined");
        }

        if((this.mLeftToLeft != null || this.mLeftToRight != null || this.mRightToLeft != null || this.mRightToRight != null) && (this.mStartToStart != null || this.mStartToEnd != null || this.mEndToStart != null || this.mEndToEnd != null)) {
            v0.add("Both left/right and start/end constraints defined");
        }

        if(v0.size() <= 0) {
            return;
        }

        throw new IncorrectConstraintException(this, v0);
    }

    public ConstraintReference verticalBias(float arg1) {
        this.mVerticalBias = arg1;
        return this;
    }

    public ConstraintReference width(Dimension arg1) {
        return this.setWidth(arg1);
    }
}

