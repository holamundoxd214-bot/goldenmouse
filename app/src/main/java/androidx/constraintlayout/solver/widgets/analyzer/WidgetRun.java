package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {
    class androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1 {
        static {
            int[] v0 = new int[Type.values().length];
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = v0;
            try {
                v0[Type.LEFT.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;
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

    enum RunType {
        public static final enum RunType CENTER;
        public static final enum RunType END;
        public static final enum RunType NONE;
        public static final enum RunType START;

        static {
            RunType v0 = new RunType("NONE", 0);
            RunType.NONE = v0;
            RunType v1 = new RunType("START", 1);
            RunType.START = v1;
            RunType v2 = new RunType("END", 2);
            RunType.END = v2;
            RunType v3 = new RunType("CENTER", 3);
            RunType.CENTER = v3;
            RunType.$VALUES = new RunType[]{v0, v1, v2, v3};
        }

        private RunType(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static RunType valueOf(String arg1) {
            return Enum.valueOf(RunType.class, arg1);
        }

        public static RunType[] values() {
            return RunType.$VALUES.clone();
        }
    }

    DimensionDependency dimension;
    protected DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    protected RunType mRunType;
    public int matchConstraintsType;
    public int orientation;
    boolean resolved;
    RunGroup runGroup;
    public DependencyNode start;
    ConstraintWidget widget;

    public WidgetRun(ConstraintWidget arg2) {
        super();
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = arg2;
    }

    protected final void addTarget(DependencyNode arg1, DependencyNode arg2, int arg3) {
        arg1.targets.add(arg2);
        arg1.margin = arg3;
        arg2.dependencies.add(arg1);
    }

    protected final void addTarget(DependencyNode arg2, DependencyNode arg3, int arg4, DimensionDependency arg5) {
        arg2.targets.add(arg3);
        arg2.targets.add(this.dimension);
        arg2.marginFactor = arg4;
        arg2.marginDependency = arg5;
        arg3.dependencies.add(arg2);
        arg5.dependencies.add(arg2);
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    protected final int getLimitedDimension(int arg2, int arg3) {
        int v1;
        ConstraintWidget v0 = this.widget;
        if(arg3 == 0) {
            arg3 = v0.mMatchConstraintMaxWidth;
            v1 = Math.max(this.widget.mMatchConstraintMinWidth, arg2);
            if(arg3 > 0) {
                v1 = Math.min(arg3, arg2);
            }

            if(v1 == arg2) {
                return arg2;
            }

            return v1;
        }
        else {
            arg3 = v0.mMatchConstraintMaxHeight;
            v1 = Math.max(this.widget.mMatchConstraintMinHeight, arg2);
            if(arg3 > 0) {
                v1 = Math.min(arg3, arg2);
            }

            if(v1 == arg2) {
                return arg2;
            }

            return v1;
        }

        return arg2;
    }

    protected final DependencyNode getTarget(ConstraintAnchor arg3) {
        DependencyNode v0 = null;
        if(arg3.mTarget == null) {
            return v0;
        }

        ConstraintWidget v2 = arg3.mTarget.mOwner;
        int v3 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[arg3.mTarget.mType.ordinal()];
        if(v3 != 1) {
            if(v3 != 2) {
                if(v3 != 3) {
                    if(v3 != 4) {
                        if(v3 != 5) {
                            return v0;
                        }

                        return v2.verticalRun.end;
                    }

                    return v2.verticalRun.baseline;
                }

                return v2.verticalRun.start;
            }

            return v2.horizontalRun.end;
        }

        return v2.horizontalRun.start;
    }

    protected final DependencyNode getTarget(ConstraintAnchor arg2, int arg3) {
        HorizontalWidgetRun v1_1;
        DependencyNode v0 = null;
        if(arg2.mTarget == null) {
            return v0;
        }

        ConstraintWidget v1 = arg2.mTarget.mOwner;
        if(arg3 == 0) {
            v1_1 = v1.horizontalRun;
        }
        else {
            VerticalWidgetRun v1_2 = v1.verticalRun;
        }

        int v2 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[arg2.mTarget.mType.ordinal()];
        if(v2 != 1) {
            if(v2 != 2) {
                if(v2 == 3) {
                    goto label_26;
                }
                else if(v2 != 5) {
                    return v0;
                }
            }

            return ((WidgetRun)v1_1).end;
        }

    label_26:
        return ((WidgetRun)v1_1).start;
    }

    public long getWrapDimension() {
        if(this.dimension.resolved) {
            return ((long)this.dimension.value);
        }

        return 0;
    }

    public boolean isCenterConnection() {
        int v0 = this.start.targets.size();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            if(this.start.targets.get(v2).run != this) {
                ++v3;
            }

            ++v2;
        }

        v0 = this.end.targets.size();
        for(v2 = 0; v2 < v0; ++v2) {
            if(this.end.targets.get(v2).run != this) {
                ++v3;
            }
        }

        if(v3 >= 2) {
            return 1;
        }

        return 0;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    abstract void reset();

    private void resolveDimension(int arg5, int arg6) {
        float v0_1;
        HorizontalWidgetRun v6_2;
        VerticalWidgetRun v6_1;
        ConstraintWidget v6;
        int v0 = this.matchConstraintsType;
        if(v0 != 0) {
            if(v0 != 1) {
                float v2 = 0.5f;
                if(v0 != 2) {
                    arg6 = 3;
                    if(v0 != arg6) {
                    }
                    else {
                        if(this.widget.horizontalRun.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && this.widget.horizontalRun.matchConstraintsType == arg6 && this.widget.verticalRun.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && this.widget.verticalRun.matchConstraintsType == arg6) {
                            return;
                        }

                        v6 = this.widget;
                        if(arg5 == 0) {
                            v6_1 = v6.verticalRun;
                        }
                        else {
                            v6_2 = v6.horizontalRun;
                        }

                        if(!((WidgetRun)v6_2).dimension.resolved) {
                            return;
                        }

                        v0_1 = this.widget.getDimensionRatio();
                        arg5 = arg5 == 1 ? ((int)((((float)((WidgetRun)v6_2).dimension.value)) / v0_1 + v2)) : ((int)(v0_1 * (((float)((WidgetRun)v6_2).dimension.value)) + v2));
                        this.dimension.resolve(arg5);
                        return;
                    }
                }
                else {
                    v6 = this.widget.getParent();
                    if(v6 == null) {
                        return;
                    }

                    if(arg5 == 0) {
                        v6_2 = v6.horizontalRun;
                    }
                    else {
                        v6_1 = v6.verticalRun;
                    }

                    if(!((WidgetRun)v6_2).dimension.resolved) {
                        return;
                    }

                    ConstraintWidget v0_2 = this.widget;
                    v0_1 = arg5 == 0 ? v0_2.mMatchConstraintPercentWidth : v0_2.mMatchConstraintPercentHeight;
                    this.dimension.resolve(this.getLimitedDimension(((int)((((float)((WidgetRun)v6_2).dimension.value)) * v0_1 + v2)), arg5));
                }

                return;
            }

            this.dimension.resolve(Math.min(this.getLimitedDimension(this.dimension.wrapValue, arg5), arg6));
            return;
        }

        this.dimension.resolve(this.getLimitedDimension(arg6, arg5));
    }

    abstract boolean supportsWrapComputation();

    public void update(Dependency arg1) {
    }

    protected void updateRunCenter(Dependency arg5, ConstraintAnchor arg6, ConstraintAnchor arg7, int arg8) {
        DependencyNode v5 = this.getTarget(arg6);
        DependencyNode v0 = this.getTarget(arg7);
        if(v5.resolved) {
            if(!v0.resolved) {
            }
            else {
                int v1 = v5.value + arg6.getMargin();
                int v6 = v0.value - arg7.getMargin();
                int v7 = v6 - v1;
                if(!this.dimension.resolved && this.dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.resolveDimension(arg8, v7);
                }

                if(!this.dimension.resolved) {
                    return;
                }

                if(this.dimension.value == v7) {
                    this.start.resolve(v1);
                    this.end.resolve(v6);
                    return;
                }

                ConstraintWidget v7_1 = this.widget;
                float v7_2 = arg8 == 0 ? v7_1.getHorizontalBiasPercent() : v7_1.getVerticalBiasPercent();
                float v8 = 0.5f;
                if(v5 == v0) {
                    v1 = v5.value;
                    v6 = v0.value;
                    v7_2 = v8;
                }

                this.start.resolve(((int)((((float)v1)) + v8 + (((float)(v6 - v1 - this.dimension.value))) * v7_2)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }

    protected void updateRunEnd(Dependency arg1) {
    }

    protected void updateRunStart(Dependency arg1) {
    }

    public long wrapSize(int arg4) {
        if(this.dimension.resolved) {
            long v0 = ((long)this.dimension.value);
            if(this.isCenterConnection()) {
                return v0 + (((long)(this.start.margin - this.end.margin)));
            }

            if(arg4 == 0) {
                return v0 + (((long)this.start.margin));
            }

            return v0 - (((long)this.end.margin));
        }

        return 0;
    }
}

