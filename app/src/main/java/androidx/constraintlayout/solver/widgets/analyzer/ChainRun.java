package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList widgets;

    public ChainRun(ConstraintWidget arg1, int arg2) {
        super(arg1);
        this.widgets = new ArrayList();
        this.orientation = arg2;
        this.build();
    }

    void apply() {
        DependencyNode v1_2;
        ConstraintWidget v4;
        ConstraintAnchor v0_3;
        Iterator v0 = this.widgets.iterator();
        while(v0.hasNext()) {
            v0.next().apply();
        }

        int v0_1 = this.widgets.size();
        if(v0_1 < 1) {
            return;
        }

        ConstraintWidget v2 = this.widgets.get(0).widget;
        ConstraintWidget v0_2 = this.widgets.get(v0_1 - 1).widget;
        if(this.orientation == 0) {
            ConstraintAnchor v1 = v2.mLeft;
            v0_3 = v0_2.mRight;
            DependencyNode v2_1 = this.getTarget(v1, 0);
            int v1_1 = v1.getMargin();
            v4 = this.getFirstVisibleWidget();
            if(v4 != null) {
                v1_1 = v4.mLeft.getMargin();
            }

            if(v2_1 != null) {
                this.addTarget(this.start, v2_1, v1_1);
            }

            v1_2 = this.getTarget(v0_3, 0);
            v0_1 = v0_3.getMargin();
            v2 = this.getLastVisibleWidget();
            if(v2 != null) {
                v0_1 = v2.mRight.getMargin();
            }

            if(v1_2 == null) {
                goto label_65;
            }

            this.addTarget(this.end, v1_2, -v0_1);
        }
        else {
            ConstraintAnchor v2_2 = v2.mTop;
            v0_3 = v0_2.mBottom;
            DependencyNode v3 = this.getTarget(v2_2, 1);
            int v2_3 = v2_2.getMargin();
            v4 = this.getFirstVisibleWidget();
            if(v4 != null) {
                v2_3 = v4.mTop.getMargin();
            }

            if(v3 != null) {
                this.addTarget(this.start, v3, v2_3);
            }

            v1_2 = this.getTarget(v0_3, 1);
            v0_1 = v0_3.getMargin();
            v2 = this.getLastVisibleWidget();
            if(v2 != null) {
                v0_1 = v2.mBottom.getMargin();
            }

            if(v1_2 == null) {
                goto label_65;
            }

            this.addTarget(this.end, v1_2, -v0_1);
        }

    label_65:
        this.start.updateDelegate = ((Dependency)this);
        this.end.updateDelegate = ((Dependency)this);
    }

    public void applyToWidget() {
        int v0;
        for(v0 = 0; v0 < this.widgets.size(); ++v0) {
            this.widgets.get(v0).applyToWidget();
        }
    }

    private void build() {
        ArrayList v1_1;
        ConstraintWidget v0 = this.widget;
        ConstraintWidget v1;
        for(v1 = v0.getPreviousChainMember(this.orientation); true; v1 = v0.getPreviousChainMember(this.orientation)) {
            ConstraintWidget v4 = v1;
            v1 = v0;
            v0 = v4;
            if(v0 == null) {
                break;
            }
        }

        this.widget = v1;
        this.widgets.add(v1.getRun(this.orientation));
        for(v0 = v1.getNextChainMember(this.orientation); true; v0 = v0.getNextChainMember(this.orientation)) {
            v1_1 = this.widgets;
            if(v0 == null) {
                break;
            }

            v1_1.add(v0.getRun(this.orientation));
        }

        Iterator v0_1 = v1_1.iterator();
        while(v0_1.hasNext()) {
            Object v1_2 = v0_1.next();
            if(this.orientation == 0) {
                ((WidgetRun)v1_2).widget.horizontalChainRun = this;
                continue;
            }

            if(this.orientation != 1) {
                continue;
            }

            ((WidgetRun)v1_2).widget.verticalChainRun = this;
        }

        if(this.orientation == 0 && (this.widget.getParent().isRtl()) && this.widgets.size() > 1) {
            this.widget = this.widgets.get(this.widgets.size() - 1).widget;
        }

        int v0_2 = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
        this.chainStyle = v0_2;
    }

    void clear() {
        this.runGroup = null;
        Iterator v1 = this.widgets.iterator();
        while(v1.hasNext()) {
            v1.next().clear();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int v0;
        for(v0 = 0; v0 < this.widgets.size(); ++v0) {
            Object v1 = this.widgets.get(v0);
            if(((WidgetRun)v1).widget.getVisibility() != 8) {
                return ((WidgetRun)v1).widget;
            }
        }

        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int v0;
        for(v0 = this.widgets.size() - 1; v0 >= 0; --v0) {
            Object v1 = this.widgets.get(v0);
            if(((WidgetRun)v1).widget.getVisibility() != 8) {
                return ((WidgetRun)v1).widget;
            }
        }

        return null;
    }

    public long getWrapDimension() {
        int v0 = this.widgets.size();
        long v1 = 0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            Object v4 = this.widgets.get(v3);
            v1 = v1 + (((long)((WidgetRun)v4).start.margin)) + ((WidgetRun)v4).getWrapDimension() + (((long)((WidgetRun)v4).end.margin));
        }

        return v1;
    }

    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    boolean supportsWrapComputation() {
        int v0 = this.widgets.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.widgets.get(v2).supportsWrapComputation()) {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        String v0 = this.orientation == 0 ? "horizontal : " : "vertical : ";
        v0 = "ChainRun ".concat(v0);
        Iterator v3 = this.widgets.iterator();
        while(v3.hasNext()) {
            v0 = v0 + "<" + v3.next() + "> ";
        }

        return v0;
    }

    public void update(Dependency arg26) {
        Object v1_3;
        int v10_2;
        int v24;
        float v23;
        int v22;
        int v1_2;
        boolean v21;
        Object v9_2;
        float v19;
        float v10_1;
        float v26;
        float v2_1;
        int v2;
        float v17;
        int v16;
        int v15;
        int v14;
        int v13;
        int v7;
        int v6;
        ChainRun v0 = this;
        if(v0.start.resolved) {
            if(!v0.end.resolved) {
            }
            else {
                ConstraintWidget v1 = v0.widget.getParent();
                boolean v1_1 = v1 == null || !(v1 instanceof ConstraintWidgetContainer) ? false : ((ConstraintWidgetContainer)v1).isRtl();
                int v3 = v0.end.value - v0.start.value;
                int v4 = v0.widgets.size();
                int v5 = 0;
                while(true) {
                    v6 = -1;
                    v7 = 8;
                    if(v5 >= v4) {
                        break;
                    }
                    else if(v0.widgets.get(v5).widget.getVisibility() == v7) {
                        ++v5;
                        continue;
                    }

                    goto label_35;
                }

                v5 = v6;
            label_35:
                int v8 = v4 - 1;
                int v9 = v8;
                while(true) {
                    if(v9 >= 0) {
                        if(v0.widgets.get(v9).widget.getVisibility() == v7) {
                            --v9;
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    goto label_46;
                }

                v6 = v9;
            label_46:
                v9 = 0;
                while(true) {
                    if(v9 < 2) {
                        v13 = 0;
                        v14 = 0;
                        v15 = 0;
                        v16 = 0;
                        v17 = 0f;
                        while(v13 < v4) {
                            Object v10 = v0.widgets.get(v13);
                            if(((WidgetRun)v10).widget.getVisibility() == v7) {
                            }
                            else {
                                ++v16;
                                if(v13 > 0 && v13 >= v5) {
                                    v14 += ((WidgetRun)v10).start.margin;
                                }

                                v2 = ((WidgetRun)v10).dimension.value;
                                v7 = ((WidgetRun)v10).dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                                if(v7 != 0) {
                                    if(v0.orientation == 0 && !((WidgetRun)v10).widget.horizontalRun.dimension.resolved) {
                                        return;
                                    }

                                    if(v0.orientation != 1) {
                                        goto label_105;
                                    }

                                    if(((WidgetRun)v10).widget.verticalRun.dimension.resolved) {
                                        goto label_105;
                                    }

                                    return;
                                }
                                else {
                                    if(((WidgetRun)v10).matchConstraintsType != 1 || v9 != 0) {
                                        if(((WidgetRun)v10).dimension.resolved) {
                                            goto label_104;
                                        }

                                        goto label_105;
                                    }
                                    else {
                                        v2 = ((WidgetRun)v10).dimension.wrapValue;
                                        ++v15;
                                    }

                                label_104:
                                    v7 = 1;
                                }

                            label_105:
                                if(v7 == 0) {
                                    ++v15;
                                    v2_1 = ((WidgetRun)v10).widget.mWeight[v0.orientation];
                                    if(v2_1 >= 0f) {
                                        v17 += v2_1;
                                    }
                                }
                                else {
                                    v14 += v2;
                                }

                                if(v13 >= v8) {
                                    goto label_121;
                                }

                                if(v13 >= v6) {
                                    goto label_121;
                                }

                                v14 += -((WidgetRun)v10).end.margin;
                            }

                        label_121:
                            ++v13;
                            v7 = 8;
                        }

                        v26 = 0f;
                        if(v14 >= v3) {
                            if(v15 == 0) {
                            }
                            else {
                                ++v9;
                                v7 = 8;
                                continue;
                            }
                        }

                        break;
                    }
                    else {
                        goto label_134;
                    }
                }

                v2 = v16;
                goto label_139;
            label_134:
                v26 = 0f;
                v17 = 0f;
                v2 = 0;
                v14 = 0;
                v15 = 0;
            label_139:
                v7 = v0.start.value;
                if(v1_1) {
                    v7 = v0.end.value;
                }

                float v9_1 = 0.5f;
                if(v14 > v3) {
                    v10_1 = 2f;
                    if(v1_1) {
                        v7 += ((int)((((float)(v14 - v3))) / v10_1 + v9_1));
                    }
                    else {
                        v7 -= ((int)((((float)(v14 - v3))) / v10_1 + v9_1));
                    }
                }

                if(v15 > 0) {
                    v10_1 = ((float)(v3 - v14));
                    int v11 = ((int)(v10_1 / (((float)v15)) + v9_1));
                    v13 = 0;
                    v16 = 0;
                    while(v13 < v4) {
                        v19 = v9_1;
                        v9_2 = v0.widgets.get(v13);
                        v21 = v1_1;
                        if(((WidgetRun)v9_2).widget.getVisibility() == 8 || ((WidgetRun)v9_2).dimensionBehavior != DimensionBehaviour.MATCH_CONSTRAINT || (((WidgetRun)v9_2).dimension.resolved)) {
                            v22 = v7;
                            v23 = v10_1;
                            v24 = v11;
                        }
                        else {
                            v1_2 = v17 > v26 ? ((int)(((WidgetRun)v9_2).widget.mWeight[v0.orientation] * v10_1 / v17 + v19)) : v11;
                            if(v0.orientation == 0) {
                                int v12 = ((WidgetRun)v9_2).widget.mMatchConstraintMaxWidth;
                                v22 = v7;
                                v7 = ((WidgetRun)v9_2).widget.mMatchConstraintMinWidth;
                                v23 = v10_1;
                                v24 = v11;
                                v10_2 = ((WidgetRun)v9_2).matchConstraintsType == 1 ? Math.min(v1_2, ((WidgetRun)v9_2).dimension.wrapValue) : v1_2;
                                v7 = Math.max(v7, v10_2);
                                if(v12 > 0) {
                                    v7 = Math.min(v12, v7);
                                }

                                if(v7 == v1_2) {
                                    goto label_242;
                                }

                                ++v16;
                                v1_2 = v7;
                            }
                            else {
                                v22 = v7;
                                v23 = v10_1;
                                v24 = v11;
                                v7 = ((WidgetRun)v9_2).widget.mMatchConstraintMaxHeight;
                                v10_2 = ((WidgetRun)v9_2).widget.mMatchConstraintMinHeight;
                                v11 = ((WidgetRun)v9_2).matchConstraintsType == 1 ? Math.min(v1_2, ((WidgetRun)v9_2).dimension.wrapValue) : v1_2;
                                v10_2 = Math.max(v10_2, v11);
                                if(v7 > 0) {
                                    v10_2 = Math.min(v7, v10_2);
                                }

                                if(v10_2 == v1_2) {
                                    goto label_242;
                                }

                                ++v16;
                                v1_2 = v10_2;
                            }

                        label_242:
                            ((WidgetRun)v9_2).dimension.resolve(v1_2);
                        }

                        ++v13;
                        v9_1 = v19;
                        v1_1 = v21;
                        v7 = v22;
                        v10_1 = v23;
                        v11 = v24;
                    }

                    v21 = v1_1;
                    v22 = v7;
                    v19 = v9_1;
                    if(v16 > 0) {
                        v15 -= v16;
                        v1_2 = 0;
                        v7 = 0;
                        while(v1_2 < v4) {
                            v9_2 = v0.widgets.get(v1_2);
                            if(((WidgetRun)v9_2).widget.getVisibility() == 8) {
                            }
                            else {
                                if(v1_2 > 0 && v1_2 >= v5) {
                                    v7 += ((WidgetRun)v9_2).start.margin;
                                }

                                v7 += ((WidgetRun)v9_2).dimension.value;
                                if(v1_2 >= v8) {
                                    goto label_285;
                                }

                                if(v1_2 >= v6) {
                                    goto label_285;
                                }

                                v7 += -((WidgetRun)v9_2).end.margin;
                            }

                        label_285:
                            ++v1_2;
                        }

                        v14 = v7;
                    }

                    v7 = 2;
                    if(v0.chainStyle == v7 && v16 == 0) {
                        v1_2 = 0;
                        v0.chainStyle = 0;
                        goto label_302;
                    }

                    v1_2 = 0;
                }
                else {
                    v21 = v1_1;
                    v22 = v7;
                    v19 = v9_1;
                    v1_2 = 0;
                    v7 = 2;
                }

            label_302:
                if(v14 > v3) {
                    v0.chainStyle = v7;
                }

                if(v2 > 0 && v15 == 0 && v5 == v6) {
                    v0.chainStyle = v7;
                }

                v7 = v0.chainStyle;
                if(v7 == 1) {
                    if(v2 > 1) {
                        v3 = (v3 - v14) / (v2 - 1);
                    }
                    else if(v2 == 1) {
                        v3 = (v3 - v14) / 2;
                    }
                    else {
                        v3 = v1_2;
                    }

                    if(v15 > 0) {
                        v3 = v1_2;
                    }

                    v2 = v1_2;
                    v7 = v22;
                    while(true) {
                        if(v2 >= v4) {
                            return;
                        }

                        v1_2 = v21 ? v4 - (v2 + 1) : v2;
                        v1_3 = v0.widgets.get(v1_2);
                        if(((WidgetRun)v1_3).widget.getVisibility() == 8) {
                            ((WidgetRun)v1_3).start.resolve(v7);
                            ((WidgetRun)v1_3).end.resolve(v7);
                        }
                        else {
                            if(v2 > 0) {
                                if(v21) {
                                    v7 -= v3;
                                }
                                else {
                                    v7 += v3;
                                }
                            }

                            if(v2 > 0 && v2 >= v5) {
                                if(v21) {
                                    v7 -= ((WidgetRun)v1_3).start.margin;
                                }
                                else {
                                    v7 += ((WidgetRun)v1_3).start.margin;
                                }
                            }

                            if(v21) {
                                ((WidgetRun)v1_3).end.resolve(v7);
                            }
                            else {
                                ((WidgetRun)v1_3).start.resolve(v7);
                            }

                            v9 = ((WidgetRun)v1_3).dimension.value;
                            if(((WidgetRun)v1_3).dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && ((WidgetRun)v1_3).matchConstraintsType == 1) {
                                v9 = ((WidgetRun)v1_3).dimension.wrapValue;
                            }

                            if(v21) {
                                v7 -= v9;
                            }
                            else {
                                v7 += v9;
                            }

                            if(v21) {
                                ((WidgetRun)v1_3).start.resolve(v7);
                            }
                            else {
                                ((WidgetRun)v1_3).end.resolve(v7);
                            }

                            ((WidgetRun)v1_3).resolved = true;
                            if(v2 >= v8) {
                                goto label_398;
                            }

                            if(v2 >= v6) {
                                goto label_398;
                            }

                            if(v21) {
                                v7 -= -((WidgetRun)v1_3).end.margin;
                                goto label_398;
                            }

                            v7 += -((WidgetRun)v1_3).end.margin;
                        }

                    label_398:
                        ++v2;
                    }
                }

                if(v7 == 0) {
                    v3 = (v3 - v14) / (v2 + 1);
                    if(v15 > 0) {
                        v3 = v1_2;
                    }

                    v2 = v1_2;
                    v7 = v22;
                    while(true) {
                        if(v2 >= v4) {
                            return;
                        }

                        v1_2 = v21 ? v4 - (v2 + 1) : v2;
                        v1_3 = v0.widgets.get(v1_2);
                        if(((WidgetRun)v1_3).widget.getVisibility() == 8) {
                            ((WidgetRun)v1_3).start.resolve(v7);
                            ((WidgetRun)v1_3).end.resolve(v7);
                        }
                        else {
                            if(v21) {
                                v7 -= v3;
                            }
                            else {
                                v7 += v3;
                            }

                            if(v2 > 0 && v2 >= v5) {
                                if(v21) {
                                    v7 -= ((WidgetRun)v1_3).start.margin;
                                }
                                else {
                                    v7 += ((WidgetRun)v1_3).start.margin;
                                }
                            }

                            if(v21) {
                                ((WidgetRun)v1_3).end.resolve(v7);
                            }
                            else {
                                ((WidgetRun)v1_3).start.resolve(v7);
                            }

                            v9 = ((WidgetRun)v1_3).dimension.value;
                            if(((WidgetRun)v1_3).dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && ((WidgetRun)v1_3).matchConstraintsType == 1) {
                                v9 = Math.min(v9, ((WidgetRun)v1_3).dimension.wrapValue);
                            }

                            if(v21) {
                                v7 -= v9;
                            }
                            else {
                                v7 += v9;
                            }

                            if(v21) {
                                ((WidgetRun)v1_3).start.resolve(v7);
                            }
                            else {
                                ((WidgetRun)v1_3).end.resolve(v7);
                            }

                            if(v2 >= v8) {
                                goto label_479;
                            }

                            if(v2 >= v6) {
                                goto label_479;
                            }

                            if(v21) {
                                v7 -= -((WidgetRun)v1_3).end.margin;
                                goto label_479;
                            }

                            v7 += -((WidgetRun)v1_3).end.margin;
                        }

                    label_479:
                        ++v2;
                    }
                }

                if(v7 != 2) {
                    return;
                }

                v2_1 = v0.orientation == 0 ? v0.widget.getHorizontalBiasPercent() : v0.widget.getVerticalBiasPercent();
                if(v21) {
                    v2_1 = 1f - v2_1;
                }

                v2 = ((int)((((float)(v3 - v14))) * v2_1 + v19));
                if(v2 < 0 || v15 > 0) {
                    v2 = v1_2;
                }

                v7 = v21 ? v22 - v2 : v22 + v2;
                for(v2 = v1_2; v2 < v4; ++v2) {
                    v1_2 = v21 ? v4 - (v2 + 1) : v2;
                    v1_3 = v0.widgets.get(v1_2);
                    if(((WidgetRun)v1_3).widget.getVisibility() == 8) {
                        ((WidgetRun)v1_3).start.resolve(v7);
                        ((WidgetRun)v1_3).end.resolve(v7);
                    }
                    else {
                        if(v2 > 0 && v2 >= v5) {
                            if(v21) {
                                v7 -= ((WidgetRun)v1_3).start.margin;
                            }
                            else {
                                v7 += ((WidgetRun)v1_3).start.margin;
                            }
                        }

                        if(v21) {
                            ((WidgetRun)v1_3).end.resolve(v7);
                        }
                        else {
                            ((WidgetRun)v1_3).start.resolve(v7);
                        }

                        v3 = ((WidgetRun)v1_3).dimension.value;
                        if(((WidgetRun)v1_3).dimensionBehavior == DimensionBehaviour.MATCH_CONSTRAINT && ((WidgetRun)v1_3).matchConstraintsType == 1) {
                            v3 = ((WidgetRun)v1_3).dimension.wrapValue;
                        }

                        if(v21) {
                            v7 -= v3;
                        }
                        else {
                            v7 += v3;
                        }

                        if(v21) {
                            ((WidgetRun)v1_3).start.resolve(v7);
                        }
                        else {
                            ((WidgetRun)v1_3).end.resolve(v7);
                        }

                        if(v2 >= v8) {
                            goto label_574;
                        }

                        if(v2 >= v6) {
                            goto label_574;
                        }

                        if(v21) {
                            v7 -= -((WidgetRun)v1_3).end.margin;
                            goto label_574;
                        }

                        v7 += -((WidgetRun)v1_3).end.margin;
                    }

                label_574:
                }
            }
        }
    }
}

