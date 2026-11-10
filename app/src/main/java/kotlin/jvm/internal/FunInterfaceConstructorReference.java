package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class arg2) {
        super(1);
        this.funInterface = arg2;
    }

    public boolean equals(Object arg2) {
        if(this == (((FunInterfaceConstructorReference)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof FunInterfaceConstructorReference)) {
            return 0;
        }

        return this.funInterface.equals(((FunInterfaceConstructorReference)arg2).funInterface);
    }

    protected KCallable getReflected() {
        return this.getReflected();
    }

    protected KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }

    public int hashCode() {
        return this.funInterface.hashCode();
    }

    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }
}

