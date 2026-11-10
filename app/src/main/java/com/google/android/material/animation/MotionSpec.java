package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap propertyValues;
    private final SimpleArrayMap timings;

    public MotionSpec() {
        super();
        this.timings = new SimpleArrayMap();
        this.propertyValues = new SimpleArrayMap();
    }

    private static void addInfoFromAnimator(MotionSpec arg2, Animator arg3) {
        if((arg3 instanceof ObjectAnimator)) {
            arg2.setPropertyValues(((ObjectAnimator)arg3).getPropertyName(), ((ObjectAnimator)arg3).getValues());
            arg2.setTiming(((ObjectAnimator)arg3).getPropertyName(), MotionTiming.createFromAnimator(((ValueAnimator)arg3)));
            return;
        }

        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + arg3);
    }

    private PropertyValuesHolder[] clonePropertyValuesHolder(PropertyValuesHolder[] arg3) {
        PropertyValuesHolder[] v2 = new PropertyValuesHolder[arg3.length];
        int v0;
        for(v0 = 0; v0 < arg3.length; ++v0) {
            v2[v0] = arg3[v0].clone();
        }

        return v2;
    }

    public static MotionSpec createFromAttribute(Context arg1, TypedArray arg2, int arg3) {
        if(arg2.hasValue(arg3)) {
            int v2 = arg2.getResourceId(arg3, 0);
            if(v2 != 0) {
                return MotionSpec.createFromResource(arg1, v2);
            }
        }

        return null;
    }

    public static MotionSpec createFromResource(Context arg3, int arg4) {
        MotionSpec v0 = null;
        try {
            Animator v3_1 = AnimatorInflater.loadAnimator(arg3, arg4);
            if((v3_1 instanceof AnimatorSet)) {
                return MotionSpec.createSpecFromAnimators(((AnimatorSet)v3_1).getChildAnimations());
            }

            if(v3_1 == null) {
                return v0;
            }

            ArrayList v1 = new ArrayList();
            ((List)v1).add(v3_1);
            return MotionSpec.createSpecFromAnimators(((List)v1));
        }
        catch(Exception v3) {
            Log.w("MotionSpec", "Can\'t load animation resource ID #0x" + Integer.toHexString(arg4), ((Throwable)v3));
            return v0;
        }

        return v0;
    }

    private static MotionSpec createSpecFromAnimators(List arg4) {
        MotionSpec v0 = new MotionSpec();
        int v1 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            MotionSpec.addInfoFromAnimator(v0, arg4.get(v2));
        }

        return v0;
    }

    public boolean equals(Object arg2) {
        if(this == (((MotionSpec)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof MotionSpec)) {
            return 0;
        }

        return this.timings.equals(((MotionSpec)arg2).timings);
    }

    public ObjectAnimator getAnimator(String arg2, Object arg3, Property arg4) {
        ObjectAnimator v3 = ObjectAnimator.ofPropertyValuesHolder(arg3, this.getPropertyValues(arg2));
        v3.setProperty(arg4);
        this.getTiming(arg2).apply(((Animator)v3));
        return v3;
    }

    public PropertyValuesHolder[] getPropertyValues(String arg2) {
        if(this.hasPropertyValues(arg2)) {
            return this.clonePropertyValuesHolder(this.propertyValues.get(arg2));
        }

        throw new IllegalArgumentException();
    }

    public MotionTiming getTiming(String arg2) {
        if(this.hasTiming(arg2)) {
            return this.timings.get(arg2);
        }

        throw new IllegalArgumentException();
    }

    public long getTotalDuration() {
        int v0 = this.timings.size();
        long v1 = 0;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            Object v4 = this.timings.valueAt(v3);
            v1 = Math.max(v1, ((MotionTiming)v4).getDelay() + ((MotionTiming)v4).getDuration());
        }

        return v1;
    }

    public boolean hasPropertyValues(String arg1) {
        if(this.propertyValues.get(arg1) != null) {
            return 1;
        }

        return 0;
    }

    public boolean hasTiming(String arg1) {
        if(this.timings.get(arg1) != null) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setPropertyValues(String arg1, PropertyValuesHolder[] arg2) {
        this.propertyValues.put(arg1, arg2);
    }

    public void setTiming(String arg1, MotionTiming arg2) {
        this.timings.put(arg1, arg2);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("\n");
        v0.append(this.getClass().getName());
        v0.append('{');
        v0.append(Integer.toHexString(System.identityHashCode(this)));
        v0.append(" timings: ");
        v0.append(this.timings);
        v0.append("}\n");
        return v0.toString();
    }
}

