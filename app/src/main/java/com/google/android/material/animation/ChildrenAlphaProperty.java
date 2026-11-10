package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R$id;

public class ChildrenAlphaProperty extends Property {
    public static final Property CHILDREN_ALPHA;

    static {
        ChildrenAlphaProperty.CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    private ChildrenAlphaProperty(String arg2) {
        super(Float.class, arg2);
    }

    public Float get(ViewGroup arg1) {
        Object v0 = arg1.getTag(id.mtrl_internal_children_alpha_tag);
        if(v0 != null) {
            return ((Float)v0);
        }

        return Float.valueOf(1f);
    }

    public Object get(Object arg1) {
        return this.get(((ViewGroup)arg1));
    }

    public void set(ViewGroup arg3, Float arg4) {
        float v2 = arg4.floatValue();
        arg3.setTag(id.mtrl_internal_children_alpha_tag, Float.valueOf(v2));
        int v4 = arg3.getChildCount();
        int v0;
        for(v0 = 0; v0 < v4; ++v0) {
            arg3.getChildAt(v0).setAlpha(v2);
        }
    }

    public void set(Object arg1, Object arg2) {
        this.set(((ViewGroup)arg1), ((Float)arg2));
    }
}

