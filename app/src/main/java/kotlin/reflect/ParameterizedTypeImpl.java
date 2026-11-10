package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B-\bF\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001A\u00020\u0006H\u0016J\n\u0010\u000E\u001A\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00060\u000BH\u0016¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004J\u0014\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u0012H\u0096\u0080\u0004R\u0013\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u000BX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001A"}, d2={"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "getRawType", "getOwnerType", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class arg2, Type arg3, List arg4) {
        Intrinsics.checkNotNullParameter(arg2, "rawType");
        Intrinsics.checkNotNullParameter(arg4, "typeArguments");
        super();
        this.rawType = arg2;
        this.ownerType = arg3;
        this.typeArguments = ((Collection)arg4).toArray(new Type[0]);
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof ParameterizedType)) && (Intrinsics.areEqual(this.rawType, ((ParameterizedType)arg3).getRawType())) && (Intrinsics.areEqual(this.ownerType, ((ParameterizedType)arg3).getOwnerType())) && (Arrays.equals(this.getActualTypeArguments(), ((ParameterizedType)arg3).getActualTypeArguments()))) {
            return 1;
        }

        return 0;
    }

    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public Type getRawType() {
        return this.rawType;
    }

    public String getTypeName() {
        StringBuilder v0 = new StringBuilder();
        Type v1 = this.ownerType;
        if(v1 != null) {
            v0.append(TypesJVMKt.access$typeToString(v1));
            v0.append("$");
            v0.append(this.rawType.getSimpleName());
        }
        else {
            v0.append(TypesJVMKt.access$typeToString(this.rawType));
        }

        Type[] v2 = this.typeArguments;
        int v12 = v2.length == 0 ? 1 : 0;
        if(v12 == 0) {
            ArraysKt.joinTo$default(((Object[])v2), v0, null, "<", ">", 0, null, ParameterizedTypeImpl$getTypeName$1$1.INSTANCE, 50, null);
        }

        return v0.toString();
    }

    public int hashCode() {
        int v0 = this.rawType.hashCode();
        Type v1 = this.ownerType;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return Arrays.hashCode(this.getActualTypeArguments()) ^ (v0 ^ v1_1);
    }

    public String toString() {
        return this.getTypeName();
    }
}

