package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

public abstract class FloatPropertyCompat {
    final String mPropertyName;

    public FloatPropertyCompat(String arg1) {
        super();
        this.mPropertyName = arg1;
    }

    public static FloatPropertyCompat createFloatPropertyCompat(FloatProperty arg2) {
        return new FloatPropertyCompat(arg2.getName(), arg2) {
            public float getValue(Object arg1) {
                return this.val$property.get(arg1).floatValue();
            }

            public void setValue(Object arg1, float arg2) {
                this.val$property.setValue(arg1, arg2);
            }
        };
    }

    public abstract float getValue(Object arg1);

    public abstract void setValue(Object arg1, float arg2);
}

