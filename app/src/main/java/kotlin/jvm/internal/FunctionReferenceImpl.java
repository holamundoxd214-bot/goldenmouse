package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int arg1, Object arg2, Class arg3, String arg4, String arg5, int arg6) {
        super(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public FunctionReferenceImpl(int arg8, Class arg9, String arg10, String arg11, int arg12) {
        super(arg8, FunctionReferenceImpl.NO_RECEIVER, arg9, arg10, arg11, arg12);
    }

    public FunctionReferenceImpl(int arg8, KDeclarationContainer arg9, String arg10, String arg11) {
        super(arg8, FunctionReferenceImpl.NO_RECEIVER, arg9.getJClass(), arg10, arg11, arg9 instanceof KClass ^ 1);
    }
}

