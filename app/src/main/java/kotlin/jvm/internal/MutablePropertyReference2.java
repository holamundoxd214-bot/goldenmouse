package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty$Getter;

public abstract class MutablePropertyReference2 extends MutablePropertyReference implements KMutableProperty2 {
    public MutablePropertyReference2() {
        super();
    }

    public MutablePropertyReference2(Class arg7, String arg8, String arg9, int arg10) {
        super(MutablePropertyReference2.NO_RECEIVER, arg7, arg8, arg9, arg10);
    }

    protected KCallable computeReflected() {
        return Reflection.mutableProperty2(this);
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

    public Setter getSetter() {
        return this.getSetter();
    }

    public kotlin.reflect.KMutableProperty2$Setter getSetter() {
        return this.getReflected().getSetter();
    }

    public Object invoke(Object arg1, Object arg2) {
        return this.get(arg1, arg2);
    }
}

