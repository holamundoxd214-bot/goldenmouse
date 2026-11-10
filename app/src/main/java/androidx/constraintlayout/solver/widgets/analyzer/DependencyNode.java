package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DependencyNode implements Dependency {
    enum Type {
        public static final enum Type BASELINE;
        public static final enum Type BOTTOM;
        public static final enum Type HORIZONTAL_DIMENSION;
        public static final enum Type LEFT;
        public static final enum Type RIGHT;
        public static final enum Type TOP;
        public static final enum Type UNKNOWN;
        public static final enum Type VERTICAL_DIMENSION;

        static {
            Type v0 = new Type("UNKNOWN", 0);
            Type.UNKNOWN = v0;
            Type v1 = new Type("HORIZONTAL_DIMENSION", 1);
            Type.HORIZONTAL_DIMENSION = v1;
            Type v2 = new Type("VERTICAL_DIMENSION", 2);
            Type.VERTICAL_DIMENSION = v2;
            Type v3 = new Type("LEFT", 3);
            Type.LEFT = v3;
            Type v4 = new Type("RIGHT", 4);
            Type.RIGHT = v4;
            Type v5 = new Type("TOP", 5);
            Type.TOP = v5;
            Type v6 = new Type("BOTTOM", 6);
            Type.BOTTOM = v6;
            Type v7 = new Type("BASELINE", 7);
            Type.BASELINE = v7;
            Type.$VALUES = new Type[]{v0, v1, v2, v3, v4, v5, v6, v7};
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

    public boolean delegateToWidgetRun;
    List dependencies;
    int margin;
    DimensionDependency marginDependency;
    int marginFactor;
    public boolean readyToSolve;
    public boolean resolved;
    WidgetRun run;
    List targets;
    Type type;
    public Dependency updateDelegate;
    public int value;

    public DependencyNode(WidgetRun arg4) {
        super();
        this.updateDelegate = null;
        this.delegateToWidgetRun = false;
        this.readyToSolve = false;
        this.type = Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = new ArrayList();
        this.targets = new ArrayList();
        this.run = arg4;
    }

    public void addDependency(Dependency arg2) {
        this.dependencies.add(arg2);
        if(this.resolved) {
            arg2.update(arg2);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String v0 = this.run.widget.getDebugName();
        v0 = this.type == Type.LEFT || this.type == Type.RIGHT ? v0 + "_HORIZONTAL" : v0 + "_VERTICAL";
        return v0 + ":" + this.type.name();
    }

    public void resolve(int arg2) {
        if(this.resolved) {
        }
        else {
            this.resolved = true;
            this.value = arg2;
            Iterator v1 = this.dependencies.iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                ((Dependency)v2).update(((Dependency)v2));
            }
        }
    }

    public String toString() {
        String v1_1;
        StringBuilder v0 = new StringBuilder().append(this.run.widget.getDebugName()).append(":").append(this.type).append("(");
        if(this.resolved) {
            Integer v1 = Integer.valueOf(this.value);
        }
        else {
            v1_1 = "unresolved";
        }

        return v0.append(v1_1).append(") <t=").append(this.targets.size()).append(":d=").append(this.dependencies.size()).append(">").toString();
    }

    public void update(Dependency arg6) {
        Iterator v6 = this.targets.iterator();
        do {
            if(v6.hasNext()) {
                if(v6.next().resolved) {
                    continue;
                }

                return;
            }
            else {
                goto label_8;
            }
        }
        while(true);

        return;
    label_8:
        this.readyToSolve = true;
        Dependency v0 = this.updateDelegate;
        if(v0 != null) {
            v0.update(((Dependency)this));
        }

        if(this.delegateToWidgetRun) {
            this.run.update(((Dependency)this));
            return;
        }

        Iterator v0_1 = this.targets.iterator();
        Object v1 = null;
        int v2 = 0;
        while(v0_1.hasNext()) {
            Object v3 = v0_1.next();
            if((v3 instanceof DimensionDependency)) {
                continue;
            }

            ++v2;
            v1 = v3;
        }

        if(v1 != null && v2 == 1 && (((DependencyNode)v1).resolved)) {
            DimensionDependency v6_1 = this.marginDependency;
            if(v6_1 != null) {
                if(v6_1.resolved) {
                    this.margin = this.marginFactor * this.marginDependency.value;
                }
                else {
                    return;
                }
            }

            this.resolve(((DependencyNode)v1).value + this.margin);
        }

        arg6 = this.updateDelegate;
        if(arg6 != null) {
            arg6.update(((Dependency)this));
        }
    }
}

