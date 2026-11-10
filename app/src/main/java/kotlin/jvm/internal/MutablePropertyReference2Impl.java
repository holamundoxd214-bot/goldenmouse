package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(Class arg1, String arg2, String arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public MutablePropertyReference2Impl(KDeclarationContainer arg2, String arg3, String arg4) {
        super(arg2.getJClass(), arg3, arg4, arg2 instanceof KClass ^ 1);
    }

    public Object get(Object arg1, Object arg2) {
        return this.getGetter().call(new Object[]{arg1, arg2});
    }

    public void set(Object arg1, Object arg2, Object arg3) {
        this.getSetter().call(new Object[]{arg1, arg2, arg3});
    }
}

