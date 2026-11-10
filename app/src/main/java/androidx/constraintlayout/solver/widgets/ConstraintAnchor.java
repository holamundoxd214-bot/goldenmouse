package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {
    class androidx.constraintlayout.solver.widgets.ConstraintAnchor$1 {
        static {
            int[] v0 = new int[Type.values().length];
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = v0;
            try {
                v0[Type.CENTER.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.LEFT.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.RIGHT.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.TOP.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BOTTOM.ordinal()] = 5;
                                goto label_28;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_28:
                                    androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.BASELINE.ordinal()] = 6;
                                    goto label_33;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_33:
                                        androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_X.ordinal()] = 7;
                                        goto label_38;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_38:
                                            androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.CENTER_Y.ordinal()] = 8;
                                            goto label_43;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_43:
                                                androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[Type.NONE.ordinal()] = 9;
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

    public enum Type {
        public static final enum Type BASELINE;
        public static final enum Type BOTTOM;
        public static final enum Type CENTER;
        public static final enum Type CENTER_X;
        public static final enum Type CENTER_Y;
        public static final enum Type LEFT;
        public static final enum Type NONE;
        public static final enum Type RIGHT;
        public static final enum Type TOP;

        static {
            Type v0 = new Type("NONE", 0);
            Type.NONE = v0;
            Type v1 = new Type("LEFT", 1);
            Type.LEFT = v1;
            Type v2 = new Type("TOP", 2);
            Type.TOP = v2;
            Type v3 = new Type("RIGHT", 3);
            Type.RIGHT = v3;
            Type v4 = new Type("BOTTOM", 4);
            Type.BOTTOM = v4;
            Type v5 = new Type("BASELINE", 5);
            Type.BASELINE = v5;
            Type v6 = new Type("CENTER", 6);
            Type.CENTER = v6;
            Type v7 = new Type("CENTER_X", 7);
            Type.CENTER_X = v7;
            Type v8 = new Type("CENTER_Y", 8);
            Type.CENTER_Y = v8;
            Type.$VALUES = new Type[]{v0, v1, v2, v3, v4, v5, v6, v7, v8};
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

    private static final boolean ALLOW_BINARY = false;
    private static final int UNSET_GONE_MARGIN = -1;
    private HashSet mDependents;
    int mGoneMargin;
    public int mMargin;
    public final ConstraintWidget mOwner;
    SolverVariable mSolverVariable;
    public ConstraintAnchor mTarget;
    public final Type mType;

    public ConstraintAnchor(ConstraintWidget arg2, Type arg3) {
        super();
        this.mDependents = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mOwner = arg2;
        this.mType = arg3;
    }

    public boolean connect(ConstraintAnchor arg3, int arg4, int arg5, boolean arg6) {
        if(arg3 == null) {
            this.reset();
            return 1;
        }

        if(!arg6 && !this.isValidConnection(arg3)) {
            return 0;
        }

        this.mTarget = arg3;
        if(arg3.mDependents == null) {
            arg3.mDependents = new HashSet();
        }

        this.mTarget.mDependents.add(this);
        this.mMargin = arg4 > 0 ? arg4 : 0;
        this.mGoneMargin = arg5;
        return 1;
    }

    public boolean connect(ConstraintAnchor arg3, int arg4) {
        return this.connect(arg3, arg4, -1, false);
    }

    public void copyFrom(ConstraintAnchor arg3, HashMap arg4) {
        ConstraintAnchor v0 = this.mTarget;
        if(v0 != null) {
            HashSet v0_1 = v0.mDependents;
            if(v0_1 != null) {
                v0_1.remove(this);
            }
        }

        v0 = arg3.mTarget;
        this.mTarget = v0 != null ? arg4.get(arg3.mTarget.mOwner).getAnchor(v0.getType()) : null;
        ConstraintAnchor v4 = this.mTarget;
        if(v4 != null) {
            if(v4.mDependents == null) {
                v4.mDependents = new HashSet();
            }

            this.mTarget.mDependents.add(this);
        }

        this.mMargin = arg3.mMargin;
        this.mGoneMargin = arg3.mGoneMargin;
    }

    public int getMargin() {
        int v1 = 8;
        if(this.mOwner.getVisibility() == v1) {
            return 0;
        }

        if(this.mGoneMargin > -1) {
            ConstraintAnchor v0 = this.mTarget;
            if(v0 != null && v0.mOwner.getVisibility() == v1) {
                return this.mGoneMargin;
            }
        }

        return this.mMargin;
    }

    public final ConstraintAnchor getOpposite() {
        switch(androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 2: {
                goto label_19;
            }
            case 3: {
                goto label_16;
            }
            case 4: {
                goto label_13;
            }
            case 5: {
                goto label_10;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return null;
            }
        }

        throw new AssertionError(this.mType.name());
    label_19:
        return this.mOwner.mRight;
    label_10:
        return this.mOwner.mTop;
    label_13:
        return this.mOwner.mBottom;
    label_16:
        return this.mOwner.mLeft;
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public Type getType() {
        return this.mType;
    }

    public boolean hasCenteredDependents() {
        HashSet v2 = this.mDependents;
        if(v2 == null) {
            return 0;
        }

        Iterator v2_1 = v2.iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!v2_1.next().getOpposite().isConnected());

        return 1;
    }

    public boolean hasDependents() {
        HashSet v1 = this.mDependents;
        if(v1 == null) {
            return 0;
        }

        if(v1.size() > 0) {
            return 1;
        }

        return 0;
    }

    public boolean isConnected() {
        if(this.mTarget != null) {
            return 1;
        }

        return 0;
    }

    public boolean isConnectionAllowed(ConstraintWidget arg3) {
        if(this.isConnectionToMe(arg3, new HashSet())) {
            return 0;
        }

        ConstraintWidget v2 = this.getOwner().getParent();
        if(v2 == arg3) {
            return 1;
        }

        if(arg3.getParent() == v2) {
            return 1;
        }

        return 0;
    }

    public boolean isConnectionAllowed(ConstraintWidget arg1, ConstraintAnchor arg2) {
        return this.isConnectionAllowed(arg1);
    }

    private boolean isConnectionToMe(ConstraintWidget arg7, HashSet arg8) {
        if(arg8.contains(arg7)) {
            return 0;
        }

        arg8.add(arg7);
        if(arg7 == this.getOwner()) {
            return 1;
        }

        ArrayList v7 = arg7.getAnchors();
        int v0 = v7.size();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            Object v4 = v7.get(v3);
            if((((ConstraintAnchor)v4).isSimilarDimensionConnection(this)) && (((ConstraintAnchor)v4).isConnected()) && (this.isConnectionToMe(((ConstraintAnchor)v4).getTarget().getOwner(), arg8))) {
                return 1;
            }
        }

        return 0;
    }

    public boolean isSideAnchor() {
        switch(androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return 1;
            }
            case 1: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return 0;
            }
        }

        throw new AssertionError(this.mType.name());
        return 1;
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor arg4) {
        Type v4 = arg4.getType();
        if(v4 == this.mType) {
            return 1;
        }

        switch(androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: {
                goto label_37;
            }
            case 2: 
            case 3: 
            case 7: {
                goto label_28;
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: {
                goto label_17;
            }
            case 9: {
                return 0;
            }
        }

        throw new AssertionError(this.mType.name());
    label_17:
        if(v4 != Type.TOP && v4 != Type.BOTTOM && v4 != Type.CENTER_Y) {
            if(v4 == Type.BASELINE) {
            }
            else {
                return 0;
            }
        }

        return 1;
    label_37:
        if(v4 != Type.BASELINE) {
            return 1;
        }

        return 0;
    label_28:
        if(v4 != Type.LEFT && v4 != Type.RIGHT) {
            if(v4 == Type.CENTER_X) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isValidConnection(ConstraintAnchor arg6) {
        if(arg6 == null) {
            return 0;
        }

        Type v1 = arg6.getType();
        Type v2 = this.mType;
        if(v1 == v2) {
            if(v2 == Type.BASELINE && (!arg6.getOwner().hasBaseline() || !this.getOwner().hasBaseline())) {
                return 0;
            }

            return 1;
        }

        switch(androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: {
                goto label_64;
            }
            case 2: 
            case 3: {
                goto label_46;
            }
            case 4: 
            case 5: {
                goto label_28;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return 0;
            }
        }

        throw new AssertionError(this.mType.name());
        return 0;
    label_28:
        boolean v5 = v1 == Type.TOP || v1 == Type.BOTTOM ? true : false;
        if((arg6.getOwner() instanceof Guideline)) {
            if(!v5) {
                if(v1 == Type.CENTER_Y) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        return v5;
    label_46:
        v5 = v1 == Type.LEFT || v1 == Type.RIGHT ? true : false;
        if((arg6.getOwner() instanceof Guideline)) {
            if(!v5) {
                if(v1 == Type.CENTER_X) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        return v5;
    label_64:
        if(v1 != Type.BASELINE && v1 != Type.CENTER_X && v1 != Type.CENTER_Y) {
            return 1;
        }

        return 0;
    }

    public boolean isVerticalAnchor() {
        switch(androidx.constraintlayout.solver.widgets.ConstraintAnchor$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 7: {
                return 0;
            }
            case 4: 
            case 5: 
            case 6: 
            case 8: 
            case 9: {
                return 1;
            }
        }

        throw new AssertionError(this.mType.name());
        return 1;
    }

    public void reset() {
        ConstraintAnchor v0 = this.mTarget;
        if(v0 != null) {
            HashSet v0_1 = v0.mDependents;
            if(v0_1 != null) {
                v0_1.remove(this);
            }
        }

        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
    }

    public void resetSolverVariable(Cache arg3) {
        SolverVariable v3 = this.mSolverVariable;
        if(v3 == null) {
            this.mSolverVariable = new SolverVariable(androidx.constraintlayout.solver.SolverVariable$Type.UNRESTRICTED, null);
            return;
        }

        v3.reset();
    }

    public void setGoneMargin(int arg2) {
        if(this.isConnected()) {
            this.mGoneMargin = arg2;
        }
    }

    public void setMargin(int arg2) {
        if(this.isConnected()) {
            this.mMargin = arg2;
        }
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }
}

