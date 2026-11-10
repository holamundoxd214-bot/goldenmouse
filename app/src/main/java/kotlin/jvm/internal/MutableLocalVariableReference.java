package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.reflect.KDeclarationContainer;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\f\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0096\u0080\u0004J\u0014\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0007H\u0096\u0080\u0004¨\u0006\u000B"}, d2={"Lkotlin/jvm/internal/MutableLocalVariableReference;", "Lkotlin/jvm/internal/MutablePropertyReference0;", "<init>", "()V", "getOwner", "Lkotlin/reflect/KDeclarationContainer;", "get", "", "set", "", "value", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class MutableLocalVariableReference extends MutablePropertyReference0 {
    public MutableLocalVariableReference() {
        super();
    }

    public Object get() {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }

    public KDeclarationContainer getOwner() {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }

    public void set(Object arg1) {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }
}

