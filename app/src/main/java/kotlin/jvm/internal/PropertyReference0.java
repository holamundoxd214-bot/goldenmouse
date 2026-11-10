package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty0;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0() {
        super();
    }

    public PropertyReference0(Object arg1) {
        super(arg1);
    }

    public PropertyReference0(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    protected KCallable computeReflected() {
        return Reflection.property0(this);
    }

    public Object getDelegate() {
        return this.getReflected().getDelegate();
    }

    public Getter getGetter() {
        return this.getGetter();
    }

    public kotlin.reflect.KProperty0$Getter getGetter() {
        return this.getReflected().getGetter();
    }

    public Object invoke() {
        return this.get();
    }
}

