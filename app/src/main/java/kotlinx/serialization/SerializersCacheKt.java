package kotlinx.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A(\u0010\u000E\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0000\u001AA\u0010\u0014\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000F0\u00152\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u00112\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0002\u0010\u0019\u001A\u001B\u0010\u001A\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u001B*\u0006\u0012\u0002\b\u00030\u0011H\u0080\b\"$\u0010\u0000\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u001E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0004\"\u001E\u0010\t\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000B\u0010\u0004\"\u001E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0004¨\u0006\u001C"}, d2={"SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/SerializerCache;", "", "getSERIALIZERS_CACHE$annotations", "()V", "getSERIALIZERS_CACHE", "()Lkotlinx/serialization/internal/SerializerCache;", "SERIALIZERS_CACHE_NULLABLE", "getSERIALIZERS_CACHE_NULLABLE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "getPARAMETRIZED_SERIALIZERS_CACHE$annotations", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations", "findCachedSerializer", "Lkotlinx/serialization/KSerializer;", "clazz", "Lkotlin/reflect/KClass;", "isNullable", "", "findParametrizedCachedSerializer", "Lkotlin/Result;", "types", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "polymorphicIfInterface", "Lkotlinx/serialization/PolymorphicSerializer;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SerializersCacheKt {
    private static final ParametrizedSerializerCache PARAMETRIZED_SERIALIZERS_CACHE;
    private static final ParametrizedSerializerCache PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE;
    private static final SerializerCache SERIALIZERS_CACHE;
    private static final SerializerCache SERIALIZERS_CACHE_NULLABLE;

    static {
        SerializersCacheKt.SERIALIZERS_CACHE = CachingKt.createCache(new SerializersCacheKt$$ExternalSyntheticLambda0());
        SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE = CachingKt.createCache(new SerializersCacheKt$$ExternalSyntheticLambda1());
        SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE = CachingKt.createParametrizedCache(new SerializersCacheKt$$ExternalSyntheticLambda2());
        SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = CachingKt.createParametrizedCache(new SerializersCacheKt$$ExternalSyntheticLambda3());
    }

    static final KSerializer PARAMETRIZED_SERIALIZERS_CACHE$lambda$3(KClass arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "clazz");
        Intrinsics.checkNotNullParameter(arg3, "types");
        List v0 = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), arg3, true);
        Intrinsics.checkNotNull(v0);
        return SerializersKt.parametrizedSerializerOrNull(arg2, v0, new SerializersCacheKt$$ExternalSyntheticLambda4(arg3));
    }

    static final KClassifier PARAMETRIZED_SERIALIZERS_CACHE$lambda$3$lambda$2(List arg1) {
        return arg1.get(0).getClassifier();
    }

    static final KSerializer PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5(KClass arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "clazz");
        Intrinsics.checkNotNullParameter(arg3, "types");
        List v0 = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), arg3, true);
        Intrinsics.checkNotNull(v0);
        KSerializer v2 = SerializersKt.parametrizedSerializerOrNull(arg2, v0, new SerializersCacheKt$$ExternalSyntheticLambda5(arg3));
        if(v2 != null) {
            v2 = BuiltinSerializersKt.getNullable(v2);
            if(v2 != null) {
                return v2;
            }
        }

        return null;
    }

    static final KClassifier PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5$lambda$4(List arg1) {
        return arg1.get(0).getClassifier();
    }

    static final KSerializer SERIALIZERS_CACHE$lambda$0(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        KSerializer v0 = SerializersKt.serializerOrNull(arg1);
        if(v0 == null) {
            if(PlatformKt.isInterface(arg1)) {
                PolymorphicSerializer v0_1 = new PolymorphicSerializer(arg1);
            }
            else {
                v0 = null;
            }
        }

        return v0;
    }

    static final KSerializer SERIALIZERS_CACHE_NULLABLE$lambda$1(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        KSerializer v0 = SerializersKt.serializerOrNull(arg2);
        KSerializer v1 = null;
        if(v0 == null) {
            if(PlatformKt.isInterface(arg2)) {
                PolymorphicSerializer v0_1 = new PolymorphicSerializer(arg2);
            }
            else {
                v0 = v1;
            }
        }

        if(v0 != null) {
            KSerializer v2 = BuiltinSerializersKt.getNullable(v0);
            if(v2 != null) {
                return v2;
            }
        }

        return v1;
    }

    public static final KSerializer findCachedSerializer(KClass arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "clazz");
        if(!arg2) {
            KSerializer v1 = SerializersCacheKt.SERIALIZERS_CACHE.get(arg1);
            if(v1 != null) {
                return v1;
            }

            return null;
        }

        return SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE.get(arg1);
    }

    public static final Object findParametrizedCachedSerializer(KClass arg1, List arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "clazz");
        Intrinsics.checkNotNullParameter(arg2, "types");
        if(!arg3) {
            return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE.get-gIAlu-s(arg1, arg2);
        }

        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.get-gIAlu-s(arg1, arg2);
    }

    private static void getPARAMETRIZED_SERIALIZERS_CACHE$annotations() {
    }

    private static void getPARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$annotations() {
    }

    public static final SerializerCache getSERIALIZERS_CACHE() {
        return SerializersCacheKt.SERIALIZERS_CACHE;
    }

    public static void getSERIALIZERS_CACHE$annotations() {
    }

    private static void getSERIALIZERS_CACHE_NULLABLE$annotations() {
    }

    public static final PolymorphicSerializer polymorphicIfInterface(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(PlatformKt.isInterface(arg1)) {
            return new PolymorphicSerializer(arg1);
        }

        return null;
    }
}

