package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0004H\u0016J\n\u0010\b\u001A\u00020\tH\u0096\u0080\u0004J\u0014\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0096\u0082\u0004J\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004J\n\u0010\u0010\u001A\u00020\tH\u0096\u0080\u0004R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "elementType", "Ljava/lang/reflect/Type;", "<init>", "(Ljava/lang/reflect/Type;)V", "getGenericComponentType", "getTypeName", "", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {
    private final Type elementType;

    public GenericArrayTypeImpl(Type arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elementType");
        super();
        this.elementType = arg2;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof GenericArrayType)) && (Intrinsics.areEqual(this.getGenericComponentType(), ((GenericArrayType)arg2).getGenericComponentType()))) {
            return 1;
        }

        return 0;
    }

    public Type getGenericComponentType() {
        return this.elementType;
    }

    public String getTypeName() {
        return TypesJVMKt.access$typeToString(this.elementType) + "[]";
    }

    public int hashCode() {
        return this.getGenericComponentType().hashCode();
    }

    public String toString() {
        return this.getTypeName();
    }
}

