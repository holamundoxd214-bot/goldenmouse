package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(Class arg7, String arg8, String arg9, int arg10) {
        super(MutablePropertyReference1Impl.NO_RECEIVER, arg7, arg8, arg9, arg10);
    }

    public MutablePropertyReference1Impl(Object arg1, Class arg2, String arg3, String arg4, int arg5) {
        super(arg1, arg2, arg3, arg4, arg5);
    }

    public MutablePropertyReference1Impl(KDeclarationContainer arg7, String arg8, String arg9) {
        super(MutablePropertyReference1Impl.NO_RECEIVER, arg7.getJClass(), arg8, arg9, arg7 instanceof KClass ^ 1);
    }

    public Object get(Object arg1) {
        return this.getGetter().call(new Object[]{arg1});
    }

    public void set(Object arg1, Object arg2) {
        this.getSetter().call(new Object[]{arg1, arg2});
    }
}

