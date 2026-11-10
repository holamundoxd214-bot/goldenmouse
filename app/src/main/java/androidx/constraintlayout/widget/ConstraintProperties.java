package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup$LayoutParams;

public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    LayoutParams mParams;
    View mView;

    public ConstraintProperties(View arg3) {
        super();
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        if((v0 instanceof LayoutParams)) {
            this.mParams = ((LayoutParams)v0);
            this.mView = arg3;
            return;
        }

        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    public ConstraintProperties addToHorizontalChain(int arg6, int arg7) {
        int v0 = 2;
        int v2 = arg6 == 0 ? 1 : v0;
        this.connect(1, arg6, v2, 0);
        v2 = arg7 == 0 ? v0 : 1;
        this.connect(v0, arg7, v2, 0);
        if(arg6 != 0) {
            new ConstraintProperties(this.mView.getParent().findViewById(arg6)).connect(v0, this.mView.getId(), 1, 0);
        }

        if(arg7 != 0) {
            new ConstraintProperties(this.mView.getParent().findViewById(arg7)).connect(1, this.mView.getId(), v0, 0);
        }

        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int arg6, int arg7) {
        int v0 = 7;
        int v1 = 6;
        int v2 = arg6 == 0 ? v1 : v0;
        this.connect(v1, arg6, v2, 0);
        v2 = arg7 == 0 ? v0 : v1;
        this.connect(v0, arg7, v2, 0);
        if(arg6 != 0) {
            new ConstraintProperties(this.mView.getParent().findViewById(arg6)).connect(v0, this.mView.getId(), v1, 0);
        }

        if(arg7 != 0) {
            new ConstraintProperties(this.mView.getParent().findViewById(arg7)).connect(v1, this.mView.getId(), v0, 0);
        }

        return this;
    }

    public ConstraintProperties addToVerticalChain(int arg6, int arg7) {
        int v0 = 4;
        int v1 = 3;
        int v2 = arg6 == 0 ? v1 : v0;
        this.connect(v1, arg6, v2, 0);
        v2 = arg7 == 0 ? v0 : v1;
        this.connect(v0, arg7, v2, 0);
        if(arg6 != 0) {
            new ConstraintProperties(this.mView.getParent().findViewById(arg6)).connect(v0, this.mView.getId(), v1, 0);
        }

        if(arg7 != 0) {
            new ConstraintProperties(this.mView.getParent().findViewById(arg7)).connect(v1, this.mView.getId(), v0, 0);
        }

        return this;
    }

    public ConstraintProperties alpha(float arg2) {
        this.mView.setAlpha(arg2);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, float arg9) {
        String v0 = "margin must be > 0";
        if(arg5 >= 0) {
            if(arg8 >= 0) {
                if(arg9 > 0f && arg9 <= 1f) {
                    int v0_1 = 2;
                    if(arg4 != 1) {
                        if(arg4 == v0_1) {
                        }
                        else {
                            v0_1 = 7;
                            int v1 = 6;
                            if(arg4 != v1) {
                                if(arg4 == v0_1) {
                                }
                                else {
                                    this.connect(3, arg3, arg4, arg5);
                                    this.connect(4, arg6, arg7, arg8);
                                    this.mParams.verticalBias = arg9;
                                    return this;
                                }
                            }

                            this.connect(v1, arg3, arg4, arg5);
                            this.connect(v0_1, arg6, arg7, arg8);
                            this.mParams.horizontalBias = arg9;
                            return this;
                        }
                    }

                    this.connect(1, arg3, arg4, arg5);
                    this.connect(v0_1, arg6, arg7, arg8);
                    this.mParams.horizontalBias = arg9;
                    return this;
                }

                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }

            throw new IllegalArgumentException(v0);
        }

        throw new IllegalArgumentException(v0);
    }

    public ConstraintProperties centerHorizontally(int arg17) {
        if(arg17 == 0) {
            this.center(0, 1, 0, 0, 2, 0, 0.5f);
            return this;
        }

        this.center(arg17, 2, 0, arg17, 1, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontally(int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, float arg8) {
        this.connect(1, arg2, arg3, arg4);
        this.connect(2, arg5, arg6, arg7);
        this.mParams.horizontalBias = arg8;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int arg17) {
        if(arg17 == 0) {
            this.center(0, 6, 0, 0, 7, 0, 0.5f);
            return this;
        }

        this.center(arg17, 7, 0, arg17, 6, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, float arg8) {
        this.connect(6, arg2, arg3, arg4);
        this.connect(7, arg5, arg6, arg7);
        this.mParams.horizontalBias = arg8;
        return this;
    }

    public ConstraintProperties centerVertically(int arg17) {
        if(arg17 == 0) {
            this.center(0, 3, 0, 0, 4, 0, 0.5f);
            return this;
        }

        this.center(arg17, 4, 0, arg17, 3, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerVertically(int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, float arg8) {
        this.connect(3, arg2, arg3, arg4);
        this.connect(4, arg5, arg6, arg7);
        this.mParams.verticalBias = arg8;
        return this;
    }

    public ConstraintProperties connect(int arg10, int arg11, int arg12, int arg13) {
        int v0 = 2;
        int v1 = 7;
        int v2 = 6;
        int v3 = 4;
        int v4 = 3;
        String v6 = "right to ";
        String v7 = " undefined";
        int v8 = -1;
        switch(arg10) {
            case 1: {
                goto label_169;
            }
            case 2: {
                goto label_146;
            }
            case 3: {
                goto label_119;
            }
            case 4: {
                goto label_92;
            }
            case 5: {
                goto label_70;
            }
            case 6: {
                goto label_47;
            }
            case 7: {
                goto label_24;
            }
        }

        throw new IllegalArgumentException(this.sideToString(arg10) + " to " + this.sideToString(arg12) + " unknown");
    label_146:
        if(arg12 == 1) {
            this.mParams.rightToLeft = arg11;
            this.mParams.rightToRight = v8;
        }
        else if(arg12 == v0) {
            this.mParams.rightToRight = arg11;
            this.mParams.rightToLeft = v8;
        }
        else {
            goto label_160;
        }

        this.mParams.rightMargin = arg13;
        return this;
    label_160:
        throw new IllegalArgumentException(v6 + this.sideToString(arg12) + v7);
    label_70:
        if(arg12 == 5) {
            this.mParams.baselineToBaseline = arg11;
            this.mParams.bottomToBottom = v8;
            this.mParams.bottomToTop = v8;
            this.mParams.topToTop = v8;
            this.mParams.topToBottom = v8;
            return this;
        }

        throw new IllegalArgumentException(v6 + this.sideToString(arg12) + v7);
    label_119:
        if(arg12 == v4) {
            this.mParams.topToTop = arg11;
            this.mParams.topToBottom = v8;
            this.mParams.baselineToBaseline = v8;
        }
        else if(arg12 == v3) {
            this.mParams.topToBottom = arg11;
            this.mParams.topToTop = v8;
            this.mParams.baselineToBaseline = v8;
        }
        else {
            goto label_137;
        }

        this.mParams.topMargin = arg13;
        return this;
    label_137:
        throw new IllegalArgumentException(v6 + this.sideToString(arg12) + v7);
    label_24:
        if(arg12 == v1) {
            this.mParams.endToEnd = arg11;
            this.mParams.endToStart = v8;
        }
        else if(arg12 == v2) {
            this.mParams.endToStart = arg11;
            this.mParams.endToEnd = v8;
        }
        else {
            goto label_38;
        }

        this.mParams.setMarginEnd(arg13);
        return this;
    label_38:
        throw new IllegalArgumentException(v6 + this.sideToString(arg12) + v7);
    label_169:
        if(arg12 == 1) {
            this.mParams.leftToLeft = arg11;
            this.mParams.leftToRight = v8;
        }
        else if(arg12 == v0) {
            this.mParams.leftToRight = arg11;
            this.mParams.leftToLeft = v8;
        }
        else {
            goto label_183;
        }

        this.mParams.leftMargin = arg13;
        return this;
    label_183:
        throw new IllegalArgumentException("Left to " + this.sideToString(arg12) + v7);
    label_92:
        if(arg12 == v3) {
            this.mParams.bottomToBottom = arg11;
            this.mParams.bottomToTop = v8;
            this.mParams.baselineToBaseline = v8;
        }
        else if(arg12 == v4) {
            this.mParams.bottomToTop = arg11;
            this.mParams.bottomToBottom = v8;
            this.mParams.baselineToBaseline = v8;
        }
        else {
            goto label_110;
        }

        this.mParams.bottomMargin = arg13;
        return this;
    label_110:
        throw new IllegalArgumentException(v6 + this.sideToString(arg12) + v7);
    label_47:
        if(arg12 == v2) {
            this.mParams.startToStart = arg11;
            this.mParams.startToEnd = v8;
        }
        else if(arg12 == v1) {
            this.mParams.startToEnd = arg11;
            this.mParams.startToStart = v8;
        }
        else {
            goto label_61;
        }

        this.mParams.setMarginStart(arg13);
        return this;
    label_61:
        throw new IllegalArgumentException(v6 + this.sideToString(arg12) + v7);
    }

    public ConstraintProperties constrainDefaultHeight(int arg2) {
        this.mParams.matchConstraintDefaultHeight = arg2;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int arg2) {
        this.mParams.matchConstraintDefaultWidth = arg2;
        return this;
    }

    public ConstraintProperties constrainHeight(int arg2) {
        this.mParams.height = arg2;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int arg2) {
        this.mParams.matchConstraintMaxHeight = arg2;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int arg2) {
        this.mParams.matchConstraintMaxWidth = arg2;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int arg2) {
        this.mParams.matchConstraintMinHeight = arg2;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int arg2) {
        this.mParams.matchConstraintMinWidth = arg2;
        return this;
    }

    public ConstraintProperties constrainWidth(int arg2) {
        this.mParams.width = arg2;
        return this;
    }

    public ConstraintProperties dimensionRatio(String arg2) {
        this.mParams.dimensionRatio = arg2;
        return this;
    }

    public ConstraintProperties elevation(float arg2) {
        this.mView.setElevation(arg2);
        return this;
    }

    public ConstraintProperties goneMargin(int arg1, int arg2) {
        switch(arg1) {
            case 1: {
                goto label_24;
            }
            case 2: {
                goto label_21;
            }
            case 3: {
                goto label_18;
            }
            case 4: {
                goto label_15;
            }
            case 5: {
                goto label_11;
            }
            case 6: {
                goto label_8;
            }
            case 7: {
                goto label_5;
            }
        }

        throw new IllegalArgumentException("unknown constraint");
    label_18:
        this.mParams.goneTopMargin = arg2;
        return this;
    label_21:
        this.mParams.goneRightMargin = arg2;
        return this;
    label_5:
        this.mParams.goneEndMargin = arg2;
        return this;
    label_24:
        this.mParams.goneLeftMargin = arg2;
        return this;
    label_8:
        this.mParams.goneStartMargin = arg2;
        return this;
    label_11:
        throw new IllegalArgumentException("baseline does not support margins");
    label_15:
        this.mParams.goneBottomMargin = arg2;
        return this;
    }

    public ConstraintProperties horizontalBias(float arg2) {
        this.mParams.horizontalBias = arg2;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int arg2) {
        this.mParams.horizontalChainStyle = arg2;
        return this;
    }

    public ConstraintProperties horizontalWeight(float arg2) {
        this.mParams.horizontalWeight = arg2;
        return this;
    }

    public ConstraintProperties margin(int arg1, int arg2) {
        switch(arg1) {
            case 1: {
                goto label_24;
            }
            case 2: {
                goto label_21;
            }
            case 3: {
                goto label_18;
            }
            case 4: {
                goto label_15;
            }
            case 5: {
                goto label_11;
            }
            case 6: {
                goto label_8;
            }
            case 7: {
                goto label_5;
            }
        }

        throw new IllegalArgumentException("unknown constraint");
    label_18:
        this.mParams.topMargin = arg2;
        return this;
    label_21:
        this.mParams.rightMargin = arg2;
        return this;
    label_5:
        this.mParams.setMarginEnd(arg2);
        return this;
    label_24:
        this.mParams.leftMargin = arg2;
        return this;
    label_8:
        this.mParams.setMarginStart(arg2);
        return this;
    label_11:
        throw new IllegalArgumentException("baseline does not support margins");
    label_15:
        this.mParams.bottomMargin = arg2;
        return this;
    }

    public ConstraintProperties removeConstraints(int arg2) {
        int v0 = -1;
        switch(arg2) {
            case 1: {
                goto label_54;
            }
            case 2: {
                goto label_45;
            }
            case 3: {
                goto label_36;
            }
            case 4: {
                goto label_27;
            }
            case 5: {
                goto label_24;
            }
            case 6: {
                goto label_15;
            }
            case 7: {
                goto label_6;
            }
        }

        throw new IllegalArgumentException("unknown constraint");
    label_36:
        this.mParams.topToBottom = v0;
        this.mParams.topToTop = v0;
        this.mParams.topMargin = v0;
        this.mParams.goneTopMargin = v0;
        return this;
    label_54:
        this.mParams.leftToRight = v0;
        this.mParams.leftToLeft = v0;
        this.mParams.leftMargin = v0;
        this.mParams.goneLeftMargin = v0;
        return this;
    label_6:
        this.mParams.endToStart = v0;
        this.mParams.endToEnd = v0;
        this.mParams.setMarginEnd(v0);
        this.mParams.goneEndMargin = v0;
        return this;
    label_24:
        this.mParams.baselineToBaseline = v0;
        return this;
    label_27:
        this.mParams.bottomToTop = v0;
        this.mParams.bottomToBottom = v0;
        this.mParams.bottomMargin = v0;
        this.mParams.goneBottomMargin = v0;
        return this;
    label_45:
        this.mParams.rightToRight = v0;
        this.mParams.rightToLeft = v0;
        this.mParams.rightMargin = v0;
        this.mParams.goneRightMargin = v0;
        return this;
    label_15:
        this.mParams.startToEnd = v0;
        this.mParams.startToStart = v0;
        this.mParams.setMarginStart(v0);
        this.mParams.goneStartMargin = v0;
        return this;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        LayoutParams v1_1;
        int v0 = this.mParams.leftToRight;
        int v1 = this.mParams.rightToLeft;
        LayoutParams v2 = this.mParams;
        int v4 = -1;
        if(v0 == v4) {
            if(v1 != v4) {
            }
            else {
                v1 = v2.startToEnd;
                int v2_1 = this.mParams.endToStart;
                int v5 = 7;
                int v6 = 6;
                if(v1 != v4 || v2_1 != v4) {
                    ConstraintProperties v8 = new ConstraintProperties(this.mView.getParent().findViewById(v1));
                    ConstraintProperties v9 = new ConstraintProperties(this.mView.getParent().findViewById(v2_1));
                    LayoutParams v7 = this.mParams;
                    if(v1 != v4 && v2_1 != v4) {
                        v8.connect(v5, v2_1, v6, 0);
                        v9.connect(v6, v0, v5, 0);
                        goto label_48;
                    }

                    if(v0 == v4 && v2_1 == v4) {
                        goto label_48;
                    }

                    v0 = v7.rightToRight;
                    v1_1 = this.mParams;
                    if(v0 != v4) {
                        v8.connect(v5, v1_1.rightToRight, v5, 0);
                        goto label_48;
                    }

                    v0 = v1_1.leftToLeft;
                    v1_1 = this.mParams;
                    if(v0 == v4) {
                        goto label_48;
                    }

                    v9.connect(v6, v1_1.leftToLeft, v6, 0);
                }

            label_48:
                this.removeConstraints(v6);
                this.removeConstraints(v5);
                return this;
            }
        }

        ConstraintProperties v5_1 = new ConstraintProperties(this.mView.getParent().findViewById(v0));
        ConstraintProperties v6_1 = new ConstraintProperties(this.mView.getParent().findViewById(v1));
        v2 = this.mParams;
        int v8_1 = 2;
        if(v0 == v4 || v1 == v4) {
            if(v0 == v4 && v1 == v4) {
                goto label_84;
            }

            v0 = v2.rightToRight;
            v1_1 = this.mParams;
            if(v0 != v4) {
                v5_1.connect(v8_1, v1_1.rightToRight, v8_1, 0);
                goto label_84;
            }

            v0 = v1_1.leftToLeft;
            v1_1 = this.mParams;
            if(v0 == v4) {
                goto label_84;
            }

            v6_1.connect(1, v1_1.leftToLeft, 1, 0);
        }
        else {
            v5_1.connect(v8_1, v1, 1, 0);
            v6_1.connect(1, v0, v8_1, 0);
        }

    label_84:
        this.removeConstraints(1);
        this.removeConstraints(v8_1);
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        int v0 = this.mParams.topToBottom;
        int v1 = this.mParams.bottomToTop;
        int v2 = 4;
        int v3 = 3;
        int v4 = -1;
        if(v0 != v4 || v1 != v4) {
            ConstraintProperties v6 = new ConstraintProperties(this.mView.getParent().findViewById(v0));
            ConstraintProperties v7 = new ConstraintProperties(this.mView.getParent().findViewById(v1));
            LayoutParams v5 = this.mParams;
            if(v0 != v4 && v1 != v4) {
                v6.connect(v2, v1, v3, 0);
                v7.connect(v3, v0, v2, 0);
                goto label_41;
            }

            if(v0 == v4 && v1 == v4) {
                goto label_41;
            }

            v0 = v5.bottomToBottom;
            LayoutParams v1_1 = this.mParams;
            if(v0 != v4) {
                v6.connect(v2, v1_1.bottomToBottom, v2, 0);
                goto label_41;
            }

            v0 = v1_1.topToTop;
            v1_1 = this.mParams;
            if(v0 == v4) {
                goto label_41;
            }

            v7.connect(v3, v1_1.topToTop, v3, 0);
        }

    label_41:
        this.removeConstraints(v3);
        this.removeConstraints(v2);
        return this;
    }

    public ConstraintProperties rotation(float arg2) {
        this.mView.setRotation(arg2);
        return this;
    }

    public ConstraintProperties rotationX(float arg2) {
        this.mView.setRotationX(arg2);
        return this;
    }

    public ConstraintProperties rotationY(float arg2) {
        this.mView.setRotationY(arg2);
        return this;
    }

    public ConstraintProperties scaleX(float arg2) {
        this.mView.setScaleY(arg2);
        return this;
    }

    public ConstraintProperties scaleY(float arg1) {
        return this;
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

    public ConstraintProperties transformPivot(float arg2, float arg3) {
        this.mView.setPivotX(arg2);
        this.mView.setPivotY(arg3);
        return this;
    }

    public ConstraintProperties transformPivotX(float arg2) {
        this.mView.setPivotX(arg2);
        return this;
    }

    public ConstraintProperties transformPivotY(float arg2) {
        this.mView.setPivotY(arg2);
        return this;
    }

    public ConstraintProperties translation(float arg2, float arg3) {
        this.mView.setTranslationX(arg2);
        this.mView.setTranslationY(arg3);
        return this;
    }

    public ConstraintProperties translationX(float arg2) {
        this.mView.setTranslationX(arg2);
        return this;
    }

    public ConstraintProperties translationY(float arg2) {
        this.mView.setTranslationY(arg2);
        return this;
    }

    public ConstraintProperties translationZ(float arg2) {
        this.mView.setTranslationZ(arg2);
        return this;
    }

    public ConstraintProperties verticalBias(float arg2) {
        this.mParams.verticalBias = arg2;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int arg2) {
        this.mParams.verticalChainStyle = arg2;
        return this;
    }

    public ConstraintProperties verticalWeight(float arg2) {
        this.mParams.verticalWeight = arg2;
        return this;
    }

    public ConstraintProperties visibility(int arg2) {
        this.mView.setVisibility(arg2);
        return this;
    }
}

