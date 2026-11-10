package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CheckableGroup {
    public interface OnCheckedStateChangeListener {
        void onCheckedStateChanged(Set arg1);
    }

    private final Map checkables;
    private final Set checkedIds;
    private OnCheckedStateChangeListener onCheckedStateChangeListener;
    private boolean selectionRequired;
    private boolean singleSelection;

    public CheckableGroup() {
        super();
        this.checkables = new HashMap();
        this.checkedIds = new HashSet();
    }

    static boolean access$000(CheckableGroup arg0, MaterialCheckable arg1) {
        return arg0.checkInternal(arg1);
    }

    static boolean access$100(CheckableGroup arg0) {
        return arg0.selectionRequired;
    }

    static boolean access$200(CheckableGroup arg0, MaterialCheckable arg1, boolean arg2) {
        return arg0.uncheckInternal(arg1, arg2);
    }

    static void access$300(CheckableGroup arg0) {
        arg0.onCheckedStateChanged();
    }

    public void addCheckable(MaterialCheckable arg3) {
        this.checkables.put(Integer.valueOf(arg3.getId()), arg3);
        if(arg3.isChecked()) {
            this.checkInternal(arg3);
        }

        arg3.setInternalOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(MaterialCheckable arg2, boolean arg3) {
                CheckableGroup v0 = CheckableGroup.this;
                if(arg3) {
                    if(v0.checkInternal(arg2)) {
                        goto label_8;
                    }
                }
                else if(v0.uncheckInternal(arg2, v0.selectionRequired)) {
                label_8:
                    CheckableGroup.this.onCheckedStateChanged();
                }
            }

            public void onCheckedChanged(Object arg1, boolean arg2) {
                this.onCheckedChanged(((MaterialCheckable)arg1), arg2);
            }
        });
    }

    public void check(int arg2) {
        Object v2 = this.checkables.get(Integer.valueOf(arg2));
        if(v2 == null) {
        }
        else if(this.checkInternal(((MaterialCheckable)v2))) {
            this.onCheckedStateChanged();
        }
    }

    private boolean checkInternal(MaterialCheckable arg5) {
        int v0 = arg5.getId();
        if(this.checkedIds.contains(Integer.valueOf(v0))) {
            return 0;
        }

        Object v1 = this.checkables.get(Integer.valueOf(this.getSingleCheckedId()));
        if(v1 != null) {
            this.uncheckInternal(((MaterialCheckable)v1), false);
        }

        boolean v4 = this.checkedIds.add(Integer.valueOf(v0));
        if(!arg5.isChecked()) {
            arg5.setChecked(true);
        }

        return v4;
    }

    public void clearCheck() {
        boolean v0 = this.checkedIds.isEmpty();
        Iterator v1 = this.checkables.values().iterator();
        while(v1.hasNext()) {
            this.uncheckInternal(v1.next(), false);
        }

        if(!v0) {
            this.onCheckedStateChanged();
        }
    }

    public Set getCheckedIds() {
        return new HashSet(this.checkedIds);
    }

    public List getCheckedIdsSortedByChildOrder(ViewGroup arg5) {
        Set v4 = this.getCheckedIds();
        ArrayList v0 = new ArrayList();
        int v1;
        for(v1 = 0; v1 < arg5.getChildCount(); ++v1) {
            View v2 = arg5.getChildAt(v1);
            if(((v2 instanceof MaterialCheckable)) && (v4.contains(Integer.valueOf(v2.getId())))) {
                ((List)v0).add(Integer.valueOf(v2.getId()));
            }
        }

        return ((List)v0);
    }

    public int getSingleCheckedId() {
        if((this.singleSelection) && !this.checkedIds.isEmpty()) {
            return this.checkedIds.iterator().next().intValue();
        }

        return -1;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    private void onCheckedStateChanged() {
        OnCheckedStateChangeListener v0 = this.onCheckedStateChangeListener;
        if(v0 != null) {
            v0.onCheckedStateChanged(this.getCheckedIds());
        }
    }

    public void removeCheckable(MaterialCheckable arg3) {
        arg3.setInternalOnCheckedChangeListener(null);
        this.checkables.remove(Integer.valueOf(arg3.getId()));
        this.checkedIds.remove(Integer.valueOf(arg3.getId()));
    }

    public void setOnCheckedStateChangeListener(OnCheckedStateChangeListener arg1) {
        this.onCheckedStateChangeListener = arg1;
    }

    public void setSelectionRequired(boolean arg1) {
        this.selectionRequired = arg1;
    }

    public void setSingleSelection(boolean arg2) {
        if(this.singleSelection != arg2) {
            this.singleSelection = arg2;
            this.clearCheck();
        }
    }

    public void uncheck(int arg2) {
        Object v2 = this.checkables.get(Integer.valueOf(arg2));
        if(v2 == null) {
        }
        else if(this.uncheckInternal(((MaterialCheckable)v2), this.selectionRequired)) {
            this.onCheckedStateChanged();
        }
    }

    private boolean uncheckInternal(MaterialCheckable arg5, boolean arg6) {
        int v0 = arg5.getId();
        if(!this.checkedIds.contains(Integer.valueOf(v0))) {
            return 0;
        }

        if((arg6) && this.checkedIds.size() == 1 && (this.checkedIds.contains(Integer.valueOf(v0)))) {
            arg5.setChecked(true);
            return 0;
        }

        boolean v4 = this.checkedIds.remove(Integer.valueOf(v0));
        if(arg5.isChecked()) {
            arg5.setChecked(false);
        }

        return v4;
    }
}

