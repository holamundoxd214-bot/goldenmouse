package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0001\u001A \u0010\u0000\u001A\u00020\u00012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0001¨\u0006\u0007"}, d2={"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AbstractPolymorphicSerializerKt {
    public static final Void throwSubtypeNotRegistered(String arg4, KClass arg5) {
        Intrinsics.checkNotNullParameter(arg5, "baseClass");
        String v0 = "in the polymorphic scope of \'" + arg5.getSimpleName() + '\'';
        arg4 = arg4 == null ? "Class discriminator was missing and no default serializers were registered " + v0 + '.' : "Serializer for subclass \'" + arg4 + "\' is not found " + v0 + ".\nCheck if class with serial name \'" + arg4 + "\' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class \'" + arg4 + "\' has to be \'@Serializable\', and the base class \'" + arg5.getSimpleName() + "\' has to be sealed and \'@Serializable\'.";
        throw new SerializationException(arg4);
    }

    public static final Void throwSubtypeNotRegistered(KClass arg1, KClass arg2) {
        Intrinsics.checkNotNullParameter(arg1, "subClass");
        Intrinsics.checkNotNullParameter(arg2, "baseClass");
        String v0 = arg1.getSimpleName();
        if(v0 == null) {
            v0 = String.valueOf(arg1);
        }

        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(v0, arg2);
        throw new KotlinNothingValueException();
    }
}

