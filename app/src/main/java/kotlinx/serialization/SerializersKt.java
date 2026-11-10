package kotlinx.serialization;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1={"kotlinx/serialization/SerializersKt__SerializersJvmKt", "kotlinx/serialization/SerializersKt__SerializersKt"}, k=4, mv={2, 0, 0}, xi=0x30) public final class SerializersKt {
    public static final KSerializer moduleThenPolymorphic(SerializersModule arg0, KClass arg1) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(arg0, arg1);
    }

    public static final KSerializer moduleThenPolymorphic(SerializersModule arg0, KClass arg1, KSerializer[] arg2) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(arg0, arg1, arg2);
    }

    public static final KSerializer noCompiledSerializer(String arg0) {
        return SerializersKt__SerializersKt.noCompiledSerializer(arg0);
    }

    public static final KSerializer noCompiledSerializer(SerializersModule arg0, KClass arg1) {
        return SerializersKt__SerializersKt.noCompiledSerializer(arg0, arg1);
    }

    public static final KSerializer noCompiledSerializer(SerializersModule arg0, KClass arg1, KSerializer[] arg2) {
        return SerializersKt__SerializersKt.noCompiledSerializer(arg0, arg1, arg2);
    }

    public static final KSerializer parametrizedSerializerOrNull(KClass arg0, List arg1, Function0 arg2) {
        return SerializersKt__SerializersKt.parametrizedSerializerOrNull(arg0, arg1, arg2);
    }

    public static final KSerializer serializer(KType arg0) {
        return SerializersKt__SerializersKt.serializer(arg0);
    }

    public static final KSerializer serializer(SerializersModule arg0, KType arg1) {
        return SerializersKt__SerializersKt.serializer(arg0, arg1);
    }

    public static final KSerializer serializer() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return SerializersKt.serializer(null);
    }

    public static final KSerializer serializer(Type arg0) {
        return SerializersKt__SerializersJvmKt.serializer(arg0);
    }

    @InternalSerializationApi public static final KSerializer serializer(KClass arg0) {
        return SerializersKt__SerializersKt.serializer(arg0);
    }

    @ExperimentalSerializationApi public static final KSerializer serializer(KClass arg0, List arg1, boolean arg2) {
        return SerializersKt__SerializersKt.serializer(arg0, arg1, arg2);
    }

    public static final KSerializer serializer(SerializersModule arg2) {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerializersKt.serializer(arg2, null);
    }

    public static final KSerializer serializer(SerializersModule arg0, Type arg1) {
        return SerializersKt__SerializersJvmKt.serializer(arg0, arg1);
    }

    @ExperimentalSerializationApi public static final KSerializer serializer(SerializersModule arg0, KClass arg1, List arg2, boolean arg3) {
        return SerializersKt__SerializersKt.serializer(arg0, arg1, arg2, arg3);
    }

    @InternalSerializationApi public static final KSerializer serializerOrNull(KClass arg0) {
        return SerializersKt__SerializersKt.serializerOrNull(arg0);
    }

    public static final KSerializer serializerOrNull(Type arg0) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(arg0);
    }

    public static final KSerializer serializerOrNull(KType arg0) {
        return SerializersKt__SerializersKt.serializerOrNull(arg0);
    }

    public static final KSerializer serializerOrNull(SerializersModule arg0, Type arg1) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(arg0, arg1);
    }

    public static final KSerializer serializerOrNull(SerializersModule arg0, KType arg1) {
        return SerializersKt__SerializersKt.serializerOrNull(arg0, arg1);
    }

    public static final List serializersForParameters(SerializersModule arg0, List arg1, boolean arg2) {
        return SerializersKt__SerializersKt.serializersForParameters(arg0, arg1, arg2);
    }
}

