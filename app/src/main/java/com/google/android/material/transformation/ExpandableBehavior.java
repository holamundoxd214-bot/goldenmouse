package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated public abstract class ExpandableBehavior extends Behavior {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED;
    private int currentState;

    public ExpandableBehavior() {
        super();
        this.currentState = 0;
    }

    public ExpandableBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.currentState = 0;
    }

    static int access$000(ExpandableBehavior arg0) {
        return arg0.currentState;
    }

    private boolean didStateChange(boolean arg3) {
        int v2 = this.currentState;
        if(arg3) {
            if(v2 != 0) {
                if(v2 == 2) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        if(v2 == 1) {
            return 1;
        }

        return 0;
    }

    protected ExpandableWidget findExpandableWidget(CoordinatorLayout arg6, View arg7) {
        List v0 = arg6.getDependencies(arg7);
        int v1 = v0.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = v0.get(v2);
            if(this.layoutDependsOn(arg6, arg7, ((View)v3))) {
                return ((ExpandableWidget)v3);
            }
        }

        return null;
    }

    public static ExpandableBehavior from(View arg1, Class arg2) {
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof LayoutParams)) {
            Behavior v1_1 = ((LayoutParams)v1).getBehavior();
            if((v1_1 instanceof ExpandableBehavior)) {
                return arg2.cast(v1_1);
            }

            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }

        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public abstract boolean layoutDependsOn(CoordinatorLayout arg1, View arg2, View arg3);

    public boolean onDependentViewChanged(CoordinatorLayout arg2, View arg3, View arg4) {
        if(this.didStateChange(((ExpandableWidget)arg4).isExpanded())) {
            int v2 = ((ExpandableWidget)arg4).isExpanded() ? 1 : 2;
            this.currentState = v2;
            return this.onExpandedStateChange(arg4, arg3, ((ExpandableWidget)arg4).isExpanded(), true);
        }

        return 0;
    }

    protected abstract boolean onExpandedStateChange(View arg1, View arg2, boolean arg3, boolean arg4);

    public boolean onLayoutChild(CoordinatorLayout arg3, View arg4, int arg5) {
        if(!ViewCompat.isLaidOut(arg4)) {
            ExpandableWidget v3 = this.findExpandableWidget(arg3, arg4);
            if(v3 != null && (this.didStateChange(v3.isExpanded()))) {
                arg5 = v3.isExpanded() ? 1 : 2;
                this.currentState = arg5;
                arg4.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListener(arg4, arg5, v3) {
                    public boolean onPreDraw() {
                        this.val$child.getViewTreeObserver().removeOnPreDrawListener(((ViewTreeObserver$OnPreDrawListener)this));
                        if(ExpandableBehavior.this.currentState == this.val$expectedState) {
                            ExpandableBehavior.this.onExpandedStateChange(this.val$dep, this.val$child, this.val$dep.isExpanded(), false);
                        }

                        return 0;
                    }
                });
            }
        }

        return 0;
    }
}

