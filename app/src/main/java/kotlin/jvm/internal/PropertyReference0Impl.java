package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(Class arg7, String arg8, String arg9, int arg10) {
        super(PropertyReference0Impl.NO_RECEIVER, arg7, arg8, arg9, arg10);
    }

    public PropertyReference0Impl(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    public PropertyReference0Impl(KDeclarationContainer arg7, String arg8, String arg9) {
        super(PropertyReference0Impl.NO_RECEIVER, arg7.getJClass(), arg8, arg9, arg7 instanceof KClass ^ 1);
    }

    public Object get() {
        return this.getGetter().call(new Object[0]);
    }
}

