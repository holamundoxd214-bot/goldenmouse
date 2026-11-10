package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;

    public FunctionReference(int arg8) {
        this(arg8, FunctionReference.NO_RECEIVER, null, null, null, 0);
    }

    public FunctionReference(int arg8, Object arg9, Class arg10, String arg11, String arg12, int arg13) {
        boolean v0 = true;
        if((arg13 & 1) == 1) {
        }
        else {
            v0 = false;
        }

        super(arg9, arg10, arg11, arg12, v0);
        this.arity = arg8;
    }

    public FunctionReference(int arg8, Object arg9) {
        this(arg8, arg9, null, null, null, 0);
    }

    protected KCallable computeReflected() {
        return Reflection.function(this);
    }

    public boolean equals(Object arg5) {
        if((((FunctionReference)arg5)) == this) {
            return 1;
        }

        if((arg5 instanceof FunctionReference)) {
            if((this.getName().equals(((FunctionReference)arg5).getName())) && (this.getSignature().equals(((FunctionReference)arg5).getSignature())) && (Intrinsics.areEqual(this.getBoundReceiver(), ((FunctionReference)arg5).getBoundReceiver())) && (Intrinsics.areEqual(this.getOwner(), ((FunctionReference)arg5).getOwner()))) {
                return 1;
            }

            return 0;
        }

        if((arg5 instanceof KFunction)) {
            return arg5.equals(this.compute());
        }

        return 0;
    }

    public int getArity() {
        return this.arity;
    }

    protected KCallable getReflected() {
        return this.getReflected();
    }

    protected KFunction getReflected() {
        return super.getReflected();
    }

    public int hashCode() {
        int v0 = this.getOwner() == null ? 0 : this.getOwner().hashCode() * 0x1F;
        return (v0 + this.getName().hashCode()) * 0x1F + this.getSignature().hashCode();
    }

    public boolean isExternal() {
        return this.getReflected().isExternal();
    }

    public boolean isInfix() {
        return this.getReflected().isInfix();
    }

    public boolean isInline() {
        return this.getReflected().isInline();
    }

    public boolean isOperator() {
        return this.getReflected().isOperator();
    }

    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }

    public String toString() {
        KCallable v0 = this.compute();
        if((((FunctionReference)v0)) != this) {
            return v0.toString();
        }

        if("<init>".equals(this.getName())) {
            return "constructor (Kotlin reflection is not available)";
        }

        return "function " + this.getName() + " (Kotlin reflection is not available)";
    }
}

