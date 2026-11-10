package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets;
    public int mWidgetsCount;

    public HelperWidget() {
        super();
        this.mWidgets = new ConstraintWidget[4];
        this.mWidgetsCount = 0;
    }

    public void add(ConstraintWidget arg4) {
        Object[] v1_1;
        if((((HelperWidget)arg4)) != this) {
            if(arg4 == null) {
            }
            else {
                int v0 = this.mWidgetsCount + 1;
                ConstraintWidget[] v1 = this.mWidgets;
                if(v0 > v1.length) {
                    v1_1 = Arrays.copyOf(((Object[])v1), v1.length * 2);
                    this.mWidgets = ((ConstraintWidget[])v1_1);
                }

                v0 = this.mWidgetsCount;
                ((ConstraintWidget[])v1_1)[v0] = arg4;
                this.mWidgetsCount = v0 + 1;
            }
        }
    }

    public void copy(ConstraintWidget arg4, HashMap arg5) {
        super.copy(arg4, arg5);
        int v0 = 0;
        this.mWidgetsCount = 0;
        int v1 = ((HelperWidget)arg4).mWidgetsCount;
        while(v0 < v1) {
            this.add(arg5.get(((HelperWidget)arg4).mWidgets[v0]));
            ++v0;
        }
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    public void updateConstraints(ConstraintWidgetContainer arg1) {
    }
}

