package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty1;

public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    public PropertyReference1() {
        super();
    }

    public PropertyReference1(Object arg1) {
        super(arg1);
    }

    public PropertyReference1(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    protected KCallable computeReflected() {
        return Reflection.property1(this);
    }

    public Object getDelegate(Object arg1) {
        return this.getReflected().getDelegate(arg1);
    }

    public Getter getGetter() {
        return this.getGetter();
    }

    public kotlin.reflect.KProperty1$Getter getGetter() {
        return this.getReflected().getGetter();
    }

    public Object invoke(Object arg1) {
        return this.get(arg1);
    }
}

