package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty$Getter;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    public MutablePropertyReference1() {
        super();
    }

    public MutablePropertyReference1(Object arg1) {
        super(arg1);
    }

    public MutablePropertyReference1(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    protected KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
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

    public Setter getSetter() {
        return this.getSetter();
    }

    public kotlin.reflect.KMutableProperty1$Setter getSetter() {
        return this.getReflected().getSetter();
    }

    public Object invoke(Object arg1) {
        return this.get(arg1);
    }
}

