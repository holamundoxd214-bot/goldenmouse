package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Dimension {
    public enum Type {
        public static final enum Type FIXED;
        public static final enum Type MATCH_CONSTRAINT;
        public static final enum Type MATCH_PARENT;
        public static final enum Type WRAP;

        static {
            Type v0 = new Type("FIXED", 0);
            Type.FIXED = v0;
            Type v1 = new Type("WRAP", 1);
            Type.WRAP = v1;
            Type v2 = new Type("MATCH_PARENT", 2);
            Type.MATCH_PARENT = v2;
            Type v3 = new Type("MATCH_CONSTRAINT", 3);
            Type.MATCH_CONSTRAINT = v3;
            Type.$VALUES = new Type[]{v0, v1, v2, v3};
        }

        private Type(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Type valueOf(String arg1) {
            return Enum.valueOf(Type.class, arg1);
        }

        public static Type[] values() {
            return Type.$VALUES.clone();
        }
    }

    public static final Object FIXED_DIMENSION;
    public static final Object PARENT_DIMENSION;
    public static final Object PERCENT_DIMENSION;
    public static final Object SPREAD_DIMENSION;
    private final int WRAP_CONTENT;
    public static final Object WRAP_DIMENSION;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    float mRatio;
    int mValue;

    static {
        Dimension.FIXED_DIMENSION = new Object();
        Dimension.WRAP_DIMENSION = new Object();
        Dimension.SPREAD_DIMENSION = new Object();
        Dimension.PARENT_DIMENSION = new Object();
        Dimension.PERCENT_DIMENSION = new Object();
    }

    private Dimension() {
        super();
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = 0x7FFFFFFF;
        this.mPercent = 1f;
        this.mValue = 0;
        this.mRatio = 1f;
        this.mInitialValue = Dimension.WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    private Dimension(Object arg3) {
        super();
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = 0x7FFFFFFF;
        this.mPercent = 1f;
        this.mValue = 0;
        this.mRatio = 1f;
        this.mIsSuggested = false;
        this.mInitialValue = arg3;
    }

    public static Dimension Fixed(Object arg2) {
        Dimension v0 = new Dimension(Dimension.FIXED_DIMENSION);
        v0.fixed(arg2);
        return v0;
    }

    public static Dimension Fixed(int arg2) {
        Dimension v0 = new Dimension(Dimension.FIXED_DIMENSION);
        v0.fixed(arg2);
        return v0;
    }

    public static Dimension Parent() {
        return new Dimension(Dimension.PARENT_DIMENSION);
    }

    public static Dimension Percent(Object arg2, float arg3) {
        Dimension v0 = new Dimension(Dimension.PERCENT_DIMENSION);
        v0.percent(arg2, arg3);
        return v0;
    }

    public static Dimension Spread() {
        return new Dimension(Dimension.SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int arg1) {
        Dimension v0 = new Dimension();
        v0.suggested(arg1);
        return v0;
    }

    public static Dimension Suggested(Object arg1) {
        Dimension v0 = new Dimension();
        v0.suggested(arg1);
        return v0;
    }

    public static Dimension Wrap() {
        return new Dimension(Dimension.WRAP_DIMENSION);
    }

    public void apply(State arg5, ConstraintWidget arg6, int arg7) {
        int v5_2;
        Object v5_1;
        boolean v5 = this.mIsSuggested;
        int v0 = 2;
        int v2 = 0x7FFFFFFF;
        if(arg7 != 0) {
            if(v5) {
                arg6.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
                v5_1 = this.mInitialValue;
                if(v5_1 == Dimension.WRAP_DIMENSION) {
                    v0 = 1;
                }
                else if(v5_1 == Dimension.PERCENT_DIMENSION) {
                }
                else {
                    v0 = 0;
                }

                arg6.setVerticalMatchStyle(v0, this.mMin, this.mMax, this.mPercent);
                return;
            }

            v5_2 = this.mMin;
            if(v5_2 > 0) {
                arg6.setMinHeight(v5_2);
            }

            v5_2 = this.mMax;
            if(v5_2 < v2) {
                arg6.setMaxHeight(v5_2);
            }

            v5_1 = this.mInitialValue;
            if(v5_1 == Dimension.WRAP_DIMENSION) {
                arg6.setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                return;
            }

            if(v5_1 == Dimension.PARENT_DIMENSION) {
                arg6.setVerticalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
                return;
            }

            if(v5_1 != null) {
                return;
            }

            arg6.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            arg6.setHeight(this.mValue);
        }
        else if(v5) {
            arg6.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_CONSTRAINT);
            v5_1 = this.mInitialValue;
            if(v5_1 == Dimension.WRAP_DIMENSION) {
                v0 = 1;
            }
            else if(v5_1 == Dimension.PERCENT_DIMENSION) {
            }
            else {
                v0 = 0;
            }

            arg6.setHorizontalMatchStyle(v0, this.mMin, this.mMax, this.mPercent);
            return;
        }
        else {
            v5_2 = this.mMin;
            if(v5_2 > 0) {
                arg6.setMinWidth(v5_2);
            }

            v5_2 = this.mMax;
            if(v5_2 < v2) {
                arg6.setMaxWidth(v5_2);
            }

            v5_1 = this.mInitialValue;
            if(v5_1 == Dimension.WRAP_DIMENSION) {
                arg6.setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                return;
            }

            if(v5_1 == Dimension.PARENT_DIMENSION) {
                arg6.setHorizontalDimensionBehaviour(DimensionBehaviour.MATCH_PARENT);
                return;
            }

            if(v5_1 != null) {
                return;
            }

            arg6.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
            arg6.setWidth(this.mValue);
            return;
        }
    }

    public Dimension fixed(int arg2) {
        this.mInitialValue = null;
        this.mValue = arg2;
        return this;
    }

    public Dimension fixed(Object arg2) {
        this.mInitialValue = arg2;
        if((arg2 instanceof Integer)) {
            this.mValue = ((Integer)arg2).intValue();
            this.mInitialValue = null;
        }

        return this;
    }

    float getRatio() {
        return this.mRatio;
    }

    int getValue() {
        return this.mValue;
    }

    public Dimension max(int arg2) {
        if(this.mMax >= 0) {
            this.mMax = arg2;
        }

        return this;
    }

    public Dimension max(Object arg2) {
        Object v0 = Dimension.WRAP_DIMENSION;
        if(arg2 == v0 && (this.mIsSuggested)) {
            this.mInitialValue = v0;
            this.mMax = 0x7FFFFFFF;
        }

        return this;
    }

    public Dimension min(int arg1) {
        if(arg1 >= 0) {
            this.mMin = arg1;
        }

        return this;
    }

    public Dimension min(Object arg2) {
        if(arg2 == Dimension.WRAP_DIMENSION) {
            this.mMin = -2;
        }

        return this;
    }

    public Dimension percent(Object arg1, float arg2) {
        this.mPercent = arg2;
        return this;
    }

    public Dimension ratio(float arg1) {
        return this;
    }

    void setRatio(float arg1) {
        this.mRatio = arg1;
    }

    void setValue(int arg2) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = arg2;
    }

    public Dimension suggested(int arg1) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension suggested(Object arg1) {
        this.mInitialValue = arg1;
        this.mIsSuggested = true;
        return this;
    }
}

