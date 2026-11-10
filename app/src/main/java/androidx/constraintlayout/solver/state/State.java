package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.HashMap;
import java.util.Iterator;

public class State {
    class androidx.constraintlayout.solver.state.State$1 {
        static {
            int[] v0 = new int[Helper.values().length];
            androidx.constraintlayout.solver.state.State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper = v0;
            try {
                v0[Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.solver.state.State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.VERTICAL_CHAIN.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.solver.state.State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.solver.state.State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.ALIGN_VERTICALLY.ordinal()] = 4;
                            goto label_23;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_23:
                                androidx.constraintlayout.solver.state.State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[Helper.BARRIER.ordinal()] = 5;
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

    public enum Chain {
        public static final enum Chain PACKED;
        public static final enum Chain SPREAD;
        public static final enum Chain SPREAD_INSIDE;

        static {
            Chain v0 = new Chain("SPREAD", 0);
            Chain.SPREAD = v0;
            Chain v1 = new Chain("SPREAD_INSIDE", 1);
            Chain.SPREAD_INSIDE = v1;
            Chain v2 = new Chain("PACKED", 2);
            Chain.PACKED = v2;
            Chain.$VALUES = new Chain[]{v0, v1, v2};
        }

        private Chain(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Chain valueOf(String arg1) {
            return Enum.valueOf(Chain.class, arg1);
        }

        public static Chain[] values() {
            return Chain.$VALUES.clone();
        }
    }

    public enum Constraint {
        public static final enum Constraint BASELINE_TO_BASELINE;
        public static final enum Constraint BOTTOM_TO_BOTTOM;
        public static final enum Constraint BOTTOM_TO_TOP;
        public static final enum Constraint CENTER_HORIZONTALLY;
        public static final enum Constraint CENTER_VERTICALLY;
        public static final enum Constraint END_TO_END;
        public static final enum Constraint END_TO_START;
        public static final enum Constraint LEFT_TO_LEFT;
        public static final enum Constraint LEFT_TO_RIGHT;
        public static final enum Constraint RIGHT_TO_LEFT;
        public static final enum Constraint RIGHT_TO_RIGHT;
        public static final enum Constraint START_TO_END;
        public static final enum Constraint START_TO_START;
        public static final enum Constraint TOP_TO_BOTTOM;
        public static final enum Constraint TOP_TO_TOP;

        static {
            Constraint v0 = new Constraint("LEFT_TO_LEFT", 0);
            Constraint.LEFT_TO_LEFT = v0;
            Constraint v1 = new Constraint("LEFT_TO_RIGHT", 1);
            Constraint.LEFT_TO_RIGHT = v1;
            Constraint v2 = new Constraint("RIGHT_TO_LEFT", 2);
            Constraint.RIGHT_TO_LEFT = v2;
            Constraint v3 = new Constraint("RIGHT_TO_RIGHT", 3);
            Constraint.RIGHT_TO_RIGHT = v3;
            Constraint v4 = new Constraint("START_TO_START", 4);
            Constraint.START_TO_START = v4;
            Constraint v5 = new Constraint("START_TO_END", 5);
            Constraint.START_TO_END = v5;
            Constraint v6 = new Constraint("END_TO_START", 6);
            Constraint.END_TO_START = v6;
            Constraint v7 = new Constraint("END_TO_END", 7);
            Constraint.END_TO_END = v7;
            Constraint v8 = new Constraint("TOP_TO_TOP", 8);
            Constraint.TOP_TO_TOP = v8;
            Constraint v9 = new Constraint("TOP_TO_BOTTOM", 9);
            Constraint.TOP_TO_BOTTOM = v9;
            Constraint v10 = new Constraint("BOTTOM_TO_TOP", 10);
            Constraint.BOTTOM_TO_TOP = v10;
            Constraint v11 = new Constraint("BOTTOM_TO_BOTTOM", 11);
            Constraint.BOTTOM_TO_BOTTOM = v11;
            Constraint v12 = new Constraint("BASELINE_TO_BASELINE", 12);
            Constraint.BASELINE_TO_BASELINE = v12;
            Constraint v13 = new Constraint("CENTER_HORIZONTALLY", 13);
            Constraint.CENTER_HORIZONTALLY = v13;
            Constraint v14 = new Constraint("CENTER_VERTICALLY", 14);
            Constraint.CENTER_VERTICALLY = v14;
            Constraint.$VALUES = new Constraint[]{v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14};
        }

        private Constraint(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Constraint valueOf(String arg1) {
            return Enum.valueOf(Constraint.class, arg1);
        }

        public static Constraint[] values() {
            return Constraint.$VALUES.clone();
        }
    }

    public enum Direction {
        public static final enum Direction BOTTOM;
        public static final enum Direction END;
        public static final enum Direction LEFT;
        public static final enum Direction RIGHT;
        public static final enum Direction START;
        public static final enum Direction TOP;

        static {
            Direction v0 = new Direction("LEFT", 0);
            Direction.LEFT = v0;
            Direction v1 = new Direction("RIGHT", 1);
            Direction.RIGHT = v1;
            Direction v2 = new Direction("START", 2);
            Direction.START = v2;
            Direction v3 = new Direction("END", 3);
            Direction.END = v3;
            Direction v4 = new Direction("TOP", 4);
            Direction.TOP = v4;
            Direction v5 = new Direction("BOTTOM", 5);
            Direction.BOTTOM = v5;
            Direction.$VALUES = new Direction[]{v0, v1, v2, v3, v4, v5};
        }

        private Direction(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Direction valueOf(String arg1) {
            return Enum.valueOf(Direction.class, arg1);
        }

        public static Direction[] values() {
            return Direction.$VALUES.clone();
        }
    }

    public enum Helper {
        public static final enum Helper ALIGN_HORIZONTALLY;
        public static final enum Helper ALIGN_VERTICALLY;
        public static final enum Helper BARRIER;
        public static final enum Helper FLOW;
        public static final enum Helper HORIZONTAL_CHAIN;
        public static final enum Helper LAYER;
        public static final enum Helper VERTICAL_CHAIN;

        static {
            Helper v0 = new Helper("HORIZONTAL_CHAIN", 0);
            Helper.HORIZONTAL_CHAIN = v0;
            Helper v1 = new Helper("VERTICAL_CHAIN", 1);
            Helper.VERTICAL_CHAIN = v1;
            Helper v2 = new Helper("ALIGN_HORIZONTALLY", 2);
            Helper.ALIGN_HORIZONTALLY = v2;
            Helper v3 = new Helper("ALIGN_VERTICALLY", 3);
            Helper.ALIGN_VERTICALLY = v3;
            Helper v4 = new Helper("BARRIER", 4);
            Helper.BARRIER = v4;
            Helper v5 = new Helper("LAYER", 5);
            Helper.LAYER = v5;
            Helper v6 = new Helper("FLOW", 6);
            Helper.FLOW = v6;
            Helper.$VALUES = new Helper[]{v0, v1, v2, v3, v4, v5, v6};
        }

        private Helper(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Helper valueOf(String arg1) {
            return Enum.valueOf(Helper.class, arg1);
        }

        public static Helper[] values() {
            return Helper.$VALUES.clone();
        }
    }

    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = null;
    static final int UNKNOWN = -1;
    protected HashMap mHelperReferences;
    public final ConstraintReference mParent;
    protected HashMap mReferences;
    private int numHelpers;

    static {
        State.PARENT = Integer.valueOf(0);
    }

    public State() {
        super();
        this.mReferences = new HashMap();
        this.mHelperReferences = new HashMap();
        ConstraintReference v0 = new ConstraintReference(this);
        this.mParent = v0;
        this.numHelpers = 0;
        this.mReferences.put(State.PARENT, v0);
    }

    public void apply(ConstraintWidgetContainer arg5) {
        Object v0_1;
        Object v1;
        arg5.removeAllChildren();
        this.mParent.getWidth().apply(this, ((ConstraintWidget)arg5), 0);
        this.mParent.getHeight().apply(this, ((ConstraintWidget)arg5), 1);
        Iterator v0 = this.mHelperReferences.keySet().iterator();
        while(v0.hasNext()) {
            v1 = v0.next();
            HelperWidget v2 = this.mHelperReferences.get(v1).getHelperWidget();
            if(v2 == null) {
                continue;
            }

            Object v3 = this.mReferences.get(v1);
            if(v3 == null) {
                ConstraintReference v3_1 = this.constraints(v1);
            }

            ((Reference)v3).setConstraintWidget(((ConstraintWidget)v2));
        }

        v0 = this.mReferences.keySet().iterator();
        while(v0.hasNext()) {
            v1 = this.mReferences.get(v0.next());
            if(v1 != this.mParent) {
                ConstraintWidget v2_1 = ((Reference)v1).getConstraintWidget();
                v2_1.setParent(null);
                if((v1 instanceof GuidelineReference)) {
                    ((Reference)v1).apply();
                }

                arg5.add(v2_1);
                continue;
            }

            ((Reference)v1).setConstraintWidget(((ConstraintWidget)arg5));
        }

        Iterator v5 = this.mHelperReferences.keySet().iterator();
        do {
        label_48:
            if(!v5.hasNext()) {
                goto label_68;
            }

            v0_1 = this.mHelperReferences.get(v5.next());
        }
        while(((HelperReference)v0_1).getHelperWidget() == null);

        Iterator v1_1 = ((HelperReference)v0_1).mReferences.iterator();
        goto label_57;
    label_68:
        v5 = this.mReferences.keySet().iterator();
        goto label_71;
    label_57:
        while(v1_1.hasNext()) {
            ((HelperReference)v0_1).getHelperWidget().add(this.mReferences.get(v1_1.next()).getConstraintWidget());
        }

        ((HelperReference)v0_1).apply();
        goto label_48;
    label_71:
        while(v5.hasNext()) {
            this.mReferences.get(v5.next()).apply();
        }
    }

    public BarrierReference barrier(Object arg2, Direction arg3) {
        HelperReference v1 = this.helper(arg2, Helper.BARRIER);
        ((BarrierReference)v1).setBarrierDirection(arg3);
        return ((BarrierReference)v1);
    }

    public AlignHorizontallyReference centerHorizontally(Object[] arg3) {
        HelperReference v2 = this.helper(null, Helper.ALIGN_HORIZONTALLY);
        ((AlignHorizontallyReference)v2).add(arg3);
        return ((AlignHorizontallyReference)v2);
    }

    public AlignVerticallyReference centerVertically(Object[] arg3) {
        HelperReference v2 = this.helper(null, Helper.ALIGN_VERTICALLY);
        ((AlignVerticallyReference)v2).add(arg3);
        return ((AlignVerticallyReference)v2);
    }

    public ConstraintReference constraints(Object arg2) {
        ConstraintReference v0_1;
        Object v0 = this.mReferences.get(arg2);
        if(v0 == null) {
            v0_1 = this.createConstraintReference(arg2);
            this.mReferences.put(arg2, v0_1);
            ((Reference)v0_1).setKey(arg2);
        }

        if((v0_1 instanceof ConstraintReference)) {
            return v0_1;
        }

        return null;
    }

    public int convertDimension(Object arg1) {
        if((arg1 instanceof Float)) {
            return ((Float)arg1).intValue();
        }

        if((arg1 instanceof Integer)) {
            return ((Integer)arg1).intValue();
        }

        return 0;
    }

    public ConstraintReference createConstraintReference(Object arg1) {
        return new ConstraintReference(this);
    }

    private String createHelperKey() {
        StringBuilder v0 = new StringBuilder("__HELPER_KEY_");
        int v1 = this.numHelpers;
        this.numHelpers = v1 + 1;
        return v0.append(v1).append("__").toString();
    }

    public void directMapping() {
        Iterator v0 = this.mReferences.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            this.constraints(v1).setView(v1);
        }
    }

    public GuidelineReference guideline(Object arg2, int arg3) {
        Object v0 = this.mReferences.get(arg2);
        if(v0 == null) {
            GuidelineReference v0_1 = new GuidelineReference(this);
            v0_1.setOrientation(arg3);
            v0_1.setKey(arg2);
            this.mReferences.put(arg2, v0_1);
        }

        return ((GuidelineReference)v0);
    }

    public State height(Dimension arg1) {
        return this.setHeight(arg1);
    }

    public HelperReference helper(Object arg3, Helper arg4) {
        VerticalChainReference v0_6;
        String v3;
        if(arg3 == null) {
            v3 = this.createHelperKey();
        }

        Object v0 = this.mHelperReferences.get(v3);
        if(v0 == null) {
            int v0_1 = androidx.constraintlayout.solver.state.State$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Helper[arg4.ordinal()];
            if(v0_1 == 1) {
                HorizontalChainReference v0_7 = new HorizontalChainReference(this);
            }
            else if(v0_1 == 2) {
                v0_6 = new VerticalChainReference(this);
            }
            else if(v0_1 == 3) {
                AlignHorizontallyReference v0_5 = new AlignHorizontallyReference(this);
            }
            else if(v0_1 == 4) {
                AlignVerticallyReference v0_4 = new AlignVerticallyReference(this);
            }
            else if(v0_1 != 5) {
                HelperReference v0_2 = new HelperReference(this, arg4);
            }
            else {
                BarrierReference v0_3 = new BarrierReference(this);
            }

            this.mHelperReferences.put(v3, v0_6);
        }

        return ((HelperReference)v0_6);
    }

    public HorizontalChainReference horizontalChain(Object[] arg3) {
        HelperReference v2 = this.helper(null, Helper.HORIZONTAL_CHAIN);
        ((HorizontalChainReference)v2).add(arg3);
        return ((HorizontalChainReference)v2);
    }

    public GuidelineReference horizontalGuideline(Object arg2) {
        return this.guideline(arg2, 0);
    }

    public void map(Object arg1, Object arg2) {
        this.constraints(arg1).setView(arg2);
    }

    Reference reference(Object arg1) {
        return this.mReferences.get(arg1);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State setHeight(Dimension arg2) {
        this.mParent.setHeight(arg2);
        return this;
    }

    public State setWidth(Dimension arg2) {
        this.mParent.setWidth(arg2);
        return this;
    }

    public VerticalChainReference verticalChain(Object[] arg3) {
        HelperReference v2 = this.helper(null, Helper.VERTICAL_CHAIN);
        ((VerticalChainReference)v2).add(arg3);
        return ((VerticalChainReference)v2);
    }

    public GuidelineReference verticalGuideline(Object arg2) {
        return this.guideline(arg2, 1);
    }

    public State width(Dimension arg1) {
        return this.setWidth(arg1);
    }
}

