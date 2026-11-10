package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START;
    int direction;
    public boolean dual;
    WidgetRun firstRun;
    int groupIndex;
    public static int index;
    WidgetRun lastRun;
    public int position;
    ArrayList runs;

    public RunGroup(WidgetRun arg2, int arg3) {
        super();
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList();
        int v0 = RunGroup.index;
        this.groupIndex = v0;
        RunGroup.index = v0 + 1;
        this.firstRun = arg2;
        this.lastRun = arg2;
        this.direction = arg3;
    }

    public void add(WidgetRun arg2) {
        this.runs.add(arg2);
        this.lastRun = arg2;
    }

    public long computeWrapSize(ConstraintWidgetContainer arg11, int arg12) {
        int v10;
        long v11_3;
        WidgetRun v0 = this.firstRun;
        long v2 = 0;
        if((v0 instanceof ChainRun)) {
            if(((ChainRun)v0).orientation != arg12) {
                return v2;
            }
        }
        else if(arg12 == 0) {
            if(!(v0 instanceof HorizontalWidgetRun)) {
                return v2;
            }
        }
        else if(!(v0 instanceof VerticalWidgetRun)) {
            return v2;
        }

        DependencyNode v0_1 = arg12 == 0 ? arg11.horizontalRun.start : arg11.verticalRun.start;
        DependencyNode v11 = arg12 == 0 ? arg11.horizontalRun.end : arg11.verticalRun.end;
        boolean v0_2 = this.firstRun.start.targets.contains(v0_1);
        boolean v11_1 = this.firstRun.end.targets.contains(v11);
        long v4 = this.firstRun.getWrapDimension();
        if(!v0_2 || !v11_1) {
            if(v0_2) {
                return Math.max(this.traverseStart(this.firstRun.start, ((long)this.firstRun.start.margin)), (((long)this.firstRun.start.margin)) + v4);
            }

            WidgetRun v12_1 = this.firstRun;
            if(v11_1) {
                return Math.max(-this.traverseEnd(v12_1.end, ((long)this.firstRun.end.margin)), (((long)(-this.firstRun.end.margin))) + v4);
            }

            v11_3 = (((long)v12_1.start.margin)) + this.firstRun.getWrapDimension();
            v10 = this.firstRun.end.margin;
        }
        else {
            long v0_3 = this.traverseStart(this.firstRun.start, v2);
            long v6 = this.traverseEnd(this.firstRun.end, v2);
            v0_3 -= v4;
            if(v0_3 >= (((long)(-this.firstRun.end.margin)))) {
                v0_3 += ((long)this.firstRun.end.margin);
            }

            v6 = -v6 - v4 - (((long)this.firstRun.start.margin));
            if(v6 >= (((long)this.firstRun.start.margin))) {
                v6 -= ((long)this.firstRun.start.margin);
            }

            float v11_2 = this.firstRun.widget.getBiasPercent(arg12);
            float v8 = 1f;
            if(Float.compare(v11_2, 0f) > 0) {
                v2 = ((long)((((float)v6)) / v11_2 + (((float)v0_3)) / (v8 - v11_2)));
            }

            float v12 = ((float)v2);
            v11_3 = (((long)this.firstRun.start.margin)) + ((((long)(v12 * v11_2 + 0.5f))) + v4 + (((long)(v12 * (v8 - v11_2) + 0.5f))));
            v10 = this.firstRun.end.margin;
        }

        return v11_3 - (((long)v10));
    }

    private boolean defineTerminalWidget(WidgetRun arg6, int arg7) {
        Iterator v3;
        Object v2;
        if(!arg6.widget.isTerminalWidget[arg7]) {
            return 0;
        }

        Iterator v0 = arg6.start.dependencies.iterator();
        do {
        label_9:
            if(!v0.hasNext()) {
                goto label_38;
            }

            v2 = v0.next();
            if(!(v2 instanceof DependencyNode)) {
                goto label_9;
            }

            if(((DependencyNode)v2).run == arg6) {
                goto label_9;
            }
        }
        while(v2 != ((DependencyNode)v2).run.start);

        if((arg6 instanceof ChainRun)) {
            v3 = arg6.widgets.iterator();
            goto label_25;
        }
        else if(!(arg6 instanceof HelperReferences)) {
            arg6.widget.isTerminalWidget[arg7] = false;
            goto label_35;
        label_38:
            v0 = arg6.end.dependencies.iterator();
            goto label_41;
        label_25:
            while(v3.hasNext()) {
                this.defineTerminalWidget(v3.next(), arg7);
            }
        }

    label_35:
        this.defineTerminalWidget(((DependencyNode)v2).run, arg7);
        goto label_9;
        do {
        label_41:
            if(!v0.hasNext()) {
                return 0;
            }

            v2 = v0.next();
            if(!(v2 instanceof DependencyNode)) {
                goto label_41;
            }

            if(((DependencyNode)v2).run == arg6) {
                goto label_41;
            }
        }
        while(v2 != ((DependencyNode)v2).run.start);

        if((arg6 instanceof ChainRun)) {
            v3 = arg6.widgets.iterator();
            goto label_57;
        }
        else if(!(arg6 instanceof HelperReferences)) {
            arg6.widget.isTerminalWidget[arg7] = false;
            goto label_67;
            return 0;
        label_57:
            while(v3.hasNext()) {
                this.defineTerminalWidget(v3.next(), arg7);
            }
        }

    label_67:
        this.defineTerminalWidget(((DependencyNode)v2).run, arg7);
        goto label_41;
    }

    public void defineTerminalWidgets(boolean arg2, boolean arg3) {
        WidgetRun v2;
        if(arg2) {
            v2 = this.firstRun;
            if((v2 instanceof HorizontalWidgetRun)) {
                this.defineTerminalWidget(v2, 0);
            }
        }

        if(arg3) {
            v2 = this.firstRun;
            if((v2 instanceof VerticalWidgetRun)) {
                this.defineTerminalWidget(v2, 1);
            }
        }
    }

    private long traverseEnd(DependencyNode arg9, long arg10) {
        WidgetRun v0 = arg9.run;
        if((v0 instanceof HelperReferences)) {
            return arg10;
        }

        int v1 = arg9.dependencies.size();
        int v2 = 0;
        long v3 = arg10;
        while(v2 < v1) {
            Object v5 = arg9.dependencies.get(v2);
            if((v5 instanceof DependencyNode)) {
                if(((DependencyNode)v5).run == v0) {
                }
                else {
                    v3 = Math.min(v3, this.traverseEnd(((DependencyNode)v5), (((long)((DependencyNode)v5).margin)) + arg10));
                }
            }

            ++v2;
        }

        if(arg9 == v0.end) {
            arg10 -= v0.getWrapDimension();
            return Math.min(Math.min(v3, this.traverseEnd(v0.start, arg10)), arg10 - (((long)v0.start.margin)));
        }

        return v3;
    }

    private long traverseStart(DependencyNode arg9, long arg10) {
        WidgetRun v0 = arg9.run;
        if((v0 instanceof HelperReferences)) {
            return arg10;
        }

        int v1 = arg9.dependencies.size();
        int v2 = 0;
        long v3 = arg10;
        while(v2 < v1) {
            Object v5 = arg9.dependencies.get(v2);
            if((v5 instanceof DependencyNode)) {
                if(((DependencyNode)v5).run == v0) {
                }
                else {
                    v3 = Math.max(v3, this.traverseStart(((DependencyNode)v5), (((long)((DependencyNode)v5).margin)) + arg10));
                }
            }

            ++v2;
        }

        if(arg9 == v0.start) {
            arg10 += v0.getWrapDimension();
            return Math.max(Math.max(v3, this.traverseStart(v0.end, arg10)), arg10 - (((long)v0.end.margin)));
        }

        return v3;
    }
}

