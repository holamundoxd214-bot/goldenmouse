package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A-\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A/\u0010\u0006\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2={"cast", "T", "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class KClasses {
    public static final Object cast(KClass arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.isInstance(arg3)) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return arg3;
        }

        throw new ClassCastException("Value cannot be cast to " + arg2.getQualifiedName());
    }

    public static final Object safeCast(KClass arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isInstance(arg2)) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
            return arg2;
        }

        return null;
    }
}

