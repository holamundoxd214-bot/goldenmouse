package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.DeprecationLevel;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;

@Deprecated @kotlin.Deprecated(level=DeprecationLevel.ERROR, message="This class is no longer supported, do not use it.") public abstract class FunctionImpl implements Serializable, Function, Function0, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function1, Function20, Function21, Function22, Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9 {
    public FunctionImpl() {
        super();
    }

    private void checkArity(int arg2) {
        if(this.getArity() != arg2) {
            this.throwWrongArity(arg2);
        }
    }

    public abstract int getArity();

    public Object invoke() {
        this.checkArity(0);
        return this.invokeVararg(new Object[0]);
    }

    public Object invoke(Object arg2) {
        this.checkArity(1);
        return this.invokeVararg(new Object[]{arg2});
    }

    public Object invoke(Object arg2, Object arg3) {
        this.checkArity(2);
        return this.invokeVararg(new Object[]{arg2, arg3});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4) {
        this.checkArity(3);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5) {
        this.checkArity(4);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
        this.checkArity(5);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
        this.checkArity(6);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8) {
        this.checkArity(7);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9) {
        this.checkArity(8);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10) {
        this.checkArity(9);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11) {
        this.checkArity(10);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12) {
        this.checkArity(11);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13) {
        this.checkArity(12);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14) {
        this.checkArity(13);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15) {
        this.checkArity(14);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16) {
        this.checkArity(15);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17) {
        this.checkArity(16);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18) {
        this.checkArity(17);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19) {
        this.checkArity(18);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20) {
        this.checkArity(19);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21) {
        this.checkArity(20);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22) {
        this.checkArity(21);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22});
    }

    public Object invoke(Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23) {
        this.checkArity(22);
        return this.invokeVararg(new Object[]{arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23});
    }

    public Object invokeVararg(Object[] arg1) {
        throw new UnsupportedOperationException();
    }

    private void throwWrongArity(int arg4) {
        throw new IllegalStateException("Wrong function arity, expected: " + arg4 + ", actual: " + this.getArity());
    }
}

