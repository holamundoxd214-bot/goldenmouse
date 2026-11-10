package kotlin.jvm.internal;

import kotlin.reflect.KMutableProperty;

public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    public MutablePropertyReference() {
        super();
    }

    public MutablePropertyReference(Object arg1) {
        super(arg1);
    }

    public MutablePropertyReference(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }
}

