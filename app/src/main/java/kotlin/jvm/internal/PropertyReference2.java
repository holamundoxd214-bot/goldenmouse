package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty2;

public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public PropertyReference2() {
        super();
    }

    public PropertyReference2(Class arg7, String arg8, String arg9, int arg10) {
        super(PropertyReference2.NO_RECEIVER, arg7, arg8, arg9, arg10);
    }

    protected KCallable computeReflected() {
        return Reflection.property2(this);
    }

    public Object getDelegate(Object arg1, Object arg2) {
        return this.getReflected().getDelegate(arg1, arg2);
    }

    public Getter getGetter() {
        return this.getGetter();
    }

    public kotlin.reflect.KProperty2$Getter getGetter() {
        return this.getReflected().getGetter();
    }

    public Object invoke(Object arg1, Object arg2) {
        return this.get(arg1, arg2);
    }
}

