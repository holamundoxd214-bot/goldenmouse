package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

public class GuidelineReference implements Reference {
    private Object key;
    private int mEnd;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent;
    private int mStart;
    final State mState;

    public GuidelineReference(State arg2) {
        super();
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = 0f;
        this.mState = arg2;
    }

    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int v0 = this.mStart;
        int v1 = -1;
        if(v0 != v1) {
            this.mGuidelineWidget.setGuideBegin(v0);
            return;
        }

        v0 = this.mEnd;
        Guideline v2 = this.mGuidelineWidget;
        if(v0 != v1) {
            v2.setGuideEnd(v0);
            return;
        }

        v2.setGuidePercent(this.mPercent);
    }

    public void end(Object arg2) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(arg2);
        this.mPercent = 0f;
    }

    public ConstraintWidget getConstraintWidget() {
        Guideline v0 = this.mGuidelineWidget;
        if(v0 == null) {
            v0 = new Guideline();
            this.mGuidelineWidget = v0;
        }

        return ((ConstraintWidget)v0);
    }

    public Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void percent(float arg2) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = arg2;
    }

    public void setConstraintWidget(ConstraintWidget arg2) {
        if((arg2 instanceof Guideline)) {
            this.mGuidelineWidget = ((Guideline)arg2);
            return;
        }

        this.mGuidelineWidget = null;
    }

    public void setKey(Object arg1) {
        this.key = arg1;
    }

    public void setOrientation(int arg1) {
        this.mOrientation = arg1;
    }

    public void start(Object arg2) {
        this.mStart = this.mState.convertDimension(arg2);
        this.mEnd = -1;
        this.mPercent = 0f;
    }
}

