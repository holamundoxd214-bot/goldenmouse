package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.HashMap;

public class Guideline extends ConstraintWidget {
    class androidx.constraintlayout.solver.widgets.Guideline$1 {
        static {
            int[] v0 = new int[Type.values().length];
            androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = v0;
            try {
                v0[Type.LEFT.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 5;
                                goto label_28;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_28:
                                    androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER.ordinal()] = 6;
                                    goto label_33;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_33:
                                        androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;
                                        goto label_38;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_38:
                                            androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;
                                            goto label_43;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_43:
                                                androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;
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

    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor;
    private int mMinimumPosition;
    private int mOrientation;
    protected int mRelativeBegin;
    protected int mRelativeEnd;
    protected float mRelativePercent;

    public Guideline() {
        super();
        this.mRelativePercent = -1f;
        this.mRelativeBegin = -1;
        this.mRelativeEnd = -1;
        this.mAnchor = this.mTop;
        int v0 = 0;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        this.mAnchors.add(this.mAnchor);
        int v1 = this.mListAnchors.length;
        while(v0 < v1) {
            this.mListAnchors[v0] = this.mAnchor;
            ++v0;
        }
    }

    public void addToSolver(LinearSystem arg9) {
        SolverVariable v0_1;
        ConstraintWidget v0 = this.getParent();
        if(v0 == null) {
        }
        else {
            ConstraintAnchor v1 = ((ConstraintWidgetContainer)v0).getAnchor(Type.LEFT);
            ConstraintAnchor v2 = ((ConstraintWidgetContainer)v0).getAnchor(Type.RIGHT);
            int v4 = 1;
            int v3 = this.mParent == null || this.mParent.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT ? 0 : 1;
            if(this.mOrientation == 0) {
                v1 = ((ConstraintWidgetContainer)v0).getAnchor(Type.TOP);
                v2 = ((ConstraintWidgetContainer)v0).getAnchor(Type.BOTTOM);
                if(this.mParent == null || this.mParent.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT) {
                    v4 = 0;
                }
                else {
                }

                v3 = v4;
            }

            v4 = 8;
            int v6 = -1;
            int v7 = 5;
            if(this.mRelativeBegin != v6) {
                v0_1 = arg9.createObjectVariable(this.mAnchor);
                arg9.addEquality(v0_1, arg9.createObjectVariable(v1), this.mRelativeBegin, v4);
                if(v3 == 0) {
                    return;
                }

                arg9.addGreaterThan(arg9.createObjectVariable(v2), v0_1, 0, v7);
                return;
            }

            if(this.mRelativeEnd != v6) {
                v0_1 = arg9.createObjectVariable(this.mAnchor);
                SolverVariable v2_1 = arg9.createObjectVariable(v2);
                arg9.addEquality(v0_1, v2_1, -this.mRelativeEnd, v4);
                if(v3 == 0) {
                    return;
                }

                arg9.addGreaterThan(v0_1, arg9.createObjectVariable(v1), 0, v7);
                arg9.addGreaterThan(v2_1, v0_1, 0, v7);
                return;
            }

            if(this.mRelativePercent == -1f) {
                return;
            }

            arg9.addConstraint(LinearSystem.createRowDimensionPercent(arg9, arg9.createObjectVariable(this.mAnchor), arg9.createObjectVariable(v2), this.mRelativePercent));
        }
    }

    public boolean allowedInBarrier() {
        return 1;
    }

    public void copy(ConstraintWidget arg1, HashMap arg2) {
        super.copy(arg1, arg2);
        this.mRelativePercent = ((Guideline)arg1).mRelativePercent;
        this.mRelativeBegin = ((Guideline)arg1).mRelativeBegin;
        this.mRelativeEnd = ((Guideline)arg1).mRelativeEnd;
        this.setOrientation(((Guideline)arg1).mOrientation);
    }

    public void cyclePosition() {
        int v1 = -1;
        if(this.mRelativeBegin != v1) {
            this.inferRelativePercentPosition();
            return;
        }

        if(this.mRelativePercent != -1f) {
            this.inferRelativeEndPosition();
            return;
        }

        if(this.mRelativeEnd != v1) {
            this.inferRelativeBeginPosition();
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public ConstraintAnchor getAnchor(Type arg3) {
        switch(androidx.constraintlayout.solver.widgets.Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[arg3.ordinal()]) {
            case 1: 
            case 2: {
                goto label_11;
            }
            case 3: 
            case 4: {
                goto label_7;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return null;
            }
        }

        goto label_16;
        return null;
    label_7:
        if(this.mOrientation != 0) {
            goto label_16;
        }

        return this.mAnchor;
    label_11:
        if(this.mOrientation == 1) {
            return this.mAnchor;
        }

    label_16:
        throw new AssertionError(arg3.name());
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        if(this.mRelativePercent != -1f) {
            return 0;
        }

        int v1 = -1;
        if(this.mRelativeBegin != v1) {
            return 1;
        }

        if(this.mRelativeEnd != v1) {
            return 2;
        }

        return v1;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    public String getType() {
        return "Guideline";
    }

    void inferRelativeBeginPosition() {
        int v0 = this.getX();
        if(this.mOrientation == 0) {
            v0 = this.getY();
        }

        this.setGuideBegin(v0);
    }

    void inferRelativeEndPosition() {
        int v0 = this.getParent().getWidth() - this.getX();
        if(this.mOrientation == 0) {
            v0 = this.getParent().getHeight() - this.getY();
        }

        this.setGuideEnd(v0);
    }

    void inferRelativePercentPosition() {
        float v0 = (((float)this.getX())) / (((float)this.getParent().getWidth()));
        if(this.mOrientation == 0) {
            v0 = (((float)this.getY())) / (((float)this.getParent().getHeight()));
        }

        this.setGuidePercent(v0);
    }

    public boolean isPercent() {
        if(this.mRelativePercent != -1f) {
            int v1 = -1;
            if(this.mRelativeBegin == v1 && this.mRelativeEnd == v1) {
                return 1;
            }
        }

        return 0;
    }

    public void setGuideBegin(int arg3) {
        int v0 = -1;
        if(arg3 > v0) {
            this.mRelativePercent = -1f;
            this.mRelativeBegin = arg3;
            this.mRelativeEnd = v0;
        }
    }

    public void setGuideEnd(int arg3) {
        int v0 = -1;
        if(arg3 > v0) {
            this.mRelativePercent = -1f;
            this.mRelativeBegin = v0;
            this.mRelativeEnd = arg3;
        }
    }

    public void setGuidePercent(float arg2) {
        if(arg2 > -1f) {
            this.mRelativePercent = arg2;
            this.mRelativeBegin = -1;
            this.mRelativeEnd = -1;
        }
    }

    public void setGuidePercent(int arg2) {
        this.setGuidePercent((((float)arg2)) / 100f);
    }

    public void setMinimumPosition(int arg1) {
        this.mMinimumPosition = arg1;
    }

    public void setOrientation(int arg4) {
        if(this.mOrientation == arg4) {
        }
        else {
            this.mOrientation = arg4;
            this.mAnchors.clear();
            this.mAnchor = this.mOrientation == 1 ? this.mLeft : this.mTop;
            this.mAnchors.add(this.mAnchor);
            arg4 = this.mListAnchors.length;
            int v0;
            for(v0 = 0; v0 < arg4; ++v0) {
                this.mListAnchors[v0] = this.mAnchor;
            }
        }
    }

    public void updateFromSolver(LinearSystem arg4) {
        if(this.getParent() == null) {
            return;
        }

        int v4 = arg4.getObjectVariableValue(this.mAnchor);
        if(this.mOrientation == 1) {
            this.setX(v4);
            this.setY(0);
            this.setHeight(this.getParent().getHeight());
            this.setWidth(0);
            return;
        }

        this.setX(0);
        this.setY(v4);
        this.setWidth(this.getParent().getWidth());
        this.setHeight(0);
    }
}

