package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper {
    private boolean expanded;
    private int expandedComponentIdHint;
    private final View widget;

    public ExpandableWidgetHelper(ExpandableWidget arg2) {
        super();
        this.expanded = false;
        this.expandedComponentIdHint = 0;
        this.widget = ((View)arg2);
    }

    private void dispatchExpandedStateChanged() {
        ViewParent v0 = this.widget.getParent();
        if((v0 instanceof CoordinatorLayout)) {
            ((CoordinatorLayout)v0).dispatchDependentViewsChanged(this.widget);
        }
    }

    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onRestoreInstanceState(Bundle arg3) {
        this.expanded = arg3.getBoolean("expanded", false);
        this.expandedComponentIdHint = arg3.getInt("expandedComponentIdHint", 0);
        if(this.expanded) {
            this.dispatchExpandedStateChanged();
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle v0 = new Bundle();
        v0.putBoolean("expanded", this.expanded);
        v0.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return v0;
    }

    public boolean setExpanded(boolean arg2) {
        if(this.expanded != arg2) {
            this.expanded = arg2;
            this.dispatchExpandedStateChanged();
            return 1;
        }

        return 0;
    }

    public void setExpandedComponentIdHint(int arg1) {
        this.expandedComponentIdHint = arg1;
    }
}

