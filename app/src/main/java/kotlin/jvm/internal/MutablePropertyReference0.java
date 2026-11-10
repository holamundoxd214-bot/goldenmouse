package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty$Getter;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0() {
        super();
    }

    public MutablePropertyReference0(Object arg1) {
        super(arg1);
    }

    public MutablePropertyReference0(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    protected KCallable computeReflected() {
        return Reflection.mutableProperty0(this);
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

    public Setter getSetter() {
        return this.getSetter();
    }

    public kotlin.reflect.KMutableProperty0$Setter getSetter() {
        return this.getReflected().getSetter();
    }

    public Object invoke() {
        return this.get();
    }
}

