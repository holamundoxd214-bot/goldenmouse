package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

public class AdaptedFunctionReference implements Serializable, FunctionBase {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int arg8, Class arg9, String arg10, String arg11, int arg12) {
        this(arg8, CallableReference.NO_RECEIVER, arg9, arg10, arg11, arg12);
    }

    public AdaptedFunctionReference(int arg1, Object arg2, Class arg3, String arg4, String arg5, int arg6) {
        super();
        this.receiver = arg2;
        this.owner = arg3;
        this.name = arg4;
        this.signature = arg5;
        boolean v2 = (arg6 & 1) == 1 ? true : false;
        this.isTopLevel = v2;
        this.arity = arg1;
        this.flags = arg6 >> 1;
    }

    public boolean equals(Object arg5) {
        if(this == (((AdaptedFunctionReference)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AdaptedFunctionReference)) {
            return 0;
        }

        if(this.isTopLevel == ((AdaptedFunctionReference)arg5).isTopLevel && this.arity == ((AdaptedFunctionReference)arg5).arity && this.flags == ((AdaptedFunctionReference)arg5).flags && (Intrinsics.areEqual(this.receiver, ((AdaptedFunctionReference)arg5).receiver)) && (Intrinsics.areEqual(this.owner, ((AdaptedFunctionReference)arg5).owner)) && (this.name.equals(((AdaptedFunctionReference)arg5).name)) && (this.signature.equals(((AdaptedFunctionReference)arg5).signature))) {
            return 1;
        }

        return 0;
    }

    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class v0 = this.owner;
        if(v0 == null) {
            return null;
        }

        if(this.isTopLevel) {
            return Reflection.getOrCreateKotlinPackage(v0);
        }

        return Reflection.getOrCreateKotlinClass(v0);
    }

    public int hashCode() {
        Object v0 = this.receiver;
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        v0_1 *= 0x1F;
        Class v2 = this.owner;
        if(v2 != null) {
            v1 = v2.hashCode();
        }

        v0_1 = (((v0_1 + v1) * 0x1F + this.name.hashCode()) * 0x1F + this.signature.hashCode()) * 0x1F;
        v1 = this.isTopLevel ? 0x4CF : 0x4D5;
        return ((v0_1 + v1) * 0x1F + this.arity) * 0x1F + this.flags;
    }

    public String toString() {
        return Reflection.renderLambdaToString(((FunctionBase)this));
    }
}

