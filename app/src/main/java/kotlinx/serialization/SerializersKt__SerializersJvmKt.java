package kotlinx.serialization;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u0016\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u0018\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u001A\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0004\u001A+\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\tH\u0002¢\u0006\u0002\b\n\u001A-\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\b\u001A\u00020\tH\u0002¢\u0006\u0002\b\r\u001AG\u0010\u000E\u001A\n\u0012\u0004\u0012\u0002H\u000F\u0018\u00010\u0001\"\b\b\u0000\u0010\u000F*\u00020\u0002*\u00020\u00062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u000F0\f2\u0014\u0010\u0011\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0012H\u0002¢\u0006\u0002\b\u0013\u001A)\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00152\u0006\u0010\b\u001A\u00020\tH\u0002¢\u0006\u0002\b\u0016\u001A\u0015\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\f*\u00020\u0004H\u0002¢\u0006\u0002\b\u0018¨\u0006\u0019"}, d2={"serializer", "Lkotlinx/serialization/KSerializer;", "", "type", "Ljava/lang/reflect/Type;", "serializerOrNull", "Lkotlinx/serialization/modules/SerializersModule;", "serializerByJavaTypeImpl", "failOnMissingTypeArgSerializer", "", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "typeSerializer", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "reflectiveOrContextual", "T", "jClass", "typeArgumentsSerializers", "", "reflectiveOrContextual$SerializersKt__SerializersJvmKt", "genericArraySerializer", "Ljava/lang/reflect/GenericArrayType;", "genericArraySerializer$SerializersKt__SerializersJvmKt", "prettyClass", "prettyClass$SerializersKt__SerializersJvmKt", "kotlinx-serialization-core"}, k=5, mv={2, 0, 0}, xi=0x30, xs="kotlinx/serialization/SerializersKt") final class SerializersKt__SerializersJvmKt {
    private static final KSerializer genericArraySerializer$SerializersKt__SerializersJvmKt(SerializersModule arg1, GenericArrayType arg2, boolean arg3) {
        KClass v2_3;
        KSerializer v1;
        Type v2 = arg2.getGenericComponentType();
        if((v2 instanceof WildcardType)) {
            Type[] v2_1 = ((WildcardType)v2).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(v2_1, "getUpperBounds(...)");
            Object v2_2 = ArraysKt.first(((Object[])v2_1));
        }

        Intrinsics.checkNotNull(v2);
        if(arg3) {
            v1 = SerializersKt.serializer(arg1, v2);
        }
        else {
            v1 = SerializersKt.serializerOrNull(arg1, v2);
            if(v1 == null) {
                return null;
            }
        }

        if((v2 instanceof ParameterizedType)) {
            v2 = ((ParameterizedType)v2).getRawType();
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type java.lang.Class<*>");
            v2_3 = JvmClassMappingKt.getKotlinClass(((Class)v2));
        }
        else {
            if((v2 instanceof KClass)) {
                goto label_24;
            }

            goto label_30;
        }

    label_24:
        Intrinsics.checkNotNull(v2_3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        v1 = BuiltinSerializersKt.ArraySerializer(v2_3, v1);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return v1;
    label_30:
        throw new IllegalStateException("unsupported type in GenericArray: " + Reflection.getOrCreateKotlinClass(v2.getClass()));
    }

    private static final Class prettyClass$SerializersKt__SerializersJvmKt(Type arg3) {
        if((arg3 instanceof Class)) {
            return arg3;
        }

        if((arg3 instanceof ParameterizedType)) {
            arg3 = ((ParameterizedType)arg3).getRawType();
            Intrinsics.checkNotNullExpressionValue(arg3, "getRawType(...)");
            return SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(arg3);
        }

        if((arg3 instanceof WildcardType)) {
            Type[] v3 = ((WildcardType)arg3).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(v3, "getUpperBounds(...)");
            Object v3_1 = ArraysKt.first(((Object[])v3));
            Intrinsics.checkNotNullExpressionValue(v3_1, "first(...)");
            return SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(((Type)v3_1));
        }

        if((arg3 instanceof GenericArrayType)) {
            arg3 = ((GenericArrayType)arg3).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(arg3, "getGenericComponentType(...)");
            return SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(arg3);
        }

        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + arg3 + " has type " + Reflection.getOrCreateKotlinClass(arg3.getClass()));
    }

    private static final KSerializer reflectiveOrContextual$SerializersKt__SerializersJvmKt(SerializersModule arg2, Class arg3, List arg4) {
        Object[] v0 = arg4.toArray(new KSerializer[0]);
        KSerializer v0_1 = PlatformKt.constructSerializerForGivenTypeArgs(arg3, Arrays.copyOf(v0, v0.length));
        if(v0_1 != null) {
            return v0_1;
        }

        KClass v0_2 = JvmClassMappingKt.getKotlinClass(arg3);
        KSerializer v1 = PrimitivesKt.builtinSerializerOrNull(v0_2);
        if(v1 == null) {
            KSerializer v2 = arg2.getContextual(v0_2, arg4);
            if(v2 == null) {
                if(arg3.isInterface()) {
                    return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(arg3));
                }
                else {
                    v2 = null;
                }
            }

            return v2;
        }

        return v1;
    }

    public static final KSerializer serializer(Type arg1) {
        Intrinsics.checkNotNullParameter(arg1, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), arg1);
    }

    public static final KSerializer serializer(SerializersModule arg1, Type arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "type");
        KSerializer v1 = SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(arg1, arg2, true);
        if(v1 != null) {
            return v1;
        }

        PlatformKt.serializerNotRegistered(SerializersKt__SerializersJvmKt.prettyClass$SerializersKt__SerializersJvmKt(arg2));
        throw new KotlinNothingValueException();
    }

    private static final KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(SerializersModule arg7, Type arg8, boolean arg9) {
        KSerializer v7;
        ArrayList v9;
        Type[] v8;
        if((arg8 instanceof GenericArrayType)) {
            return SerializersKt__SerializersJvmKt.genericArraySerializer$SerializersKt__SerializersJvmKt(arg7, ((GenericArrayType)arg8), arg9);
        }

        if((arg8 instanceof Class)) {
            return SerializersKt__SerializersJvmKt.typeSerializer$SerializersKt__SerializersJvmKt(arg7, ((Class)arg8), arg9);
        }

        KSerializer v1 = null;
        int v2 = 2;
        if((arg8 instanceof ParameterizedType)) {
            Type v0 = ((ParameterizedType)arg8).getRawType();
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.lang.Class<*>");
            v8 = ((ParameterizedType)arg8).getActualTypeArguments();
            Intrinsics.checkNotNull(v8);
            if(arg9) {
                v9 = new ArrayList(v8.length);
                int v1_1 = v8.length;
                int v4;
                for(v4 = 0; v4 < v1_1; ++v4) {
                    Type v5 = v8[v4];
                    Intrinsics.checkNotNull(v5);
                    ((Collection)v9).add(SerializersKt.serializer(arg7, v5));
                }
            }
            else {
                v9 = new ArrayList(v8.length);
                v4 = v8.length;
                int v5_1 = 0;
                while(v5_1 < v4) {
                    Type v6 = v8[v5_1];
                    Intrinsics.checkNotNull(v6);
                    KSerializer v6_1 = SerializersKt.serializerOrNull(arg7, v6);
                    if(v6_1 == null) {
                        return v1;
                    }
                    else {
                        ((Collection)v9).add(v6_1);
                        ++v5_1;
                        continue;
                    }

                    break;
                }
            }

            String v1_2 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>";
            if(Set.class.isAssignableFrom(((Class)v0))) {
                v7 = BuiltinSerializersKt.SetSerializer(((List)v9).get(0));
                Intrinsics.checkNotNull(v7, v1_2);
                return v7;
            }

            if(!List.class.isAssignableFrom(((Class)v0))) {
                if(Collection.class.isAssignableFrom(((Class)v0))) {
                }
                else if(Map.class.isAssignableFrom(((Class)v0))) {
                    v7 = BuiltinSerializersKt.MapSerializer(((List)v9).get(0), ((List)v9).get(1));
                    Intrinsics.checkNotNull(v7, v1_2);
                    return v7;
                }
                else if(Map$Entry.class.isAssignableFrom(((Class)v0))) {
                    v7 = BuiltinSerializersKt.MapEntrySerializer(((List)v9).get(0), ((List)v9).get(1));
                    Intrinsics.checkNotNull(v7, v1_2);
                    return v7;
                }
                else if(Pair.class.isAssignableFrom(((Class)v0))) {
                    v7 = BuiltinSerializersKt.PairSerializer(((List)v9).get(0), ((List)v9).get(1));
                    Intrinsics.checkNotNull(v7, v1_2);
                    return v7;
                }
                else if(Triple.class.isAssignableFrom(((Class)v0))) {
                    v7 = BuiltinSerializersKt.TripleSerializer(((List)v9).get(0), ((List)v9).get(1), ((List)v9).get(v2));
                    Intrinsics.checkNotNull(v7, v1_2);
                    return v7;
                }
                else {
                    ArrayList v8_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9), 10));
                    Iterator v9_1 = ((Iterable)v9).iterator();
                    while(v9_1.hasNext()) {
                        Object v1_3 = v9_1.next();
                        Intrinsics.checkNotNull(v1_3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
                        ((Collection)v8_1).add(v1_3);
                    }

                    return SerializersKt__SerializersJvmKt.reflectiveOrContextual$SerializersKt__SerializersJvmKt(arg7, ((Class)v0), ((List)v8_1));
                }
            }

            v7 = BuiltinSerializersKt.ListSerializer(((List)v9).get(0));
            Intrinsics.checkNotNull(v7, v1_2);
            return v7;
        }

        if((arg8 instanceof WildcardType)) {
            v8 = ((WildcardType)arg8).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(v8, "getUpperBounds(...)");
            Object v8_2 = ArraysKt.first(((Object[])v8));
            Intrinsics.checkNotNullExpressionValue(v8_2, "first(...)");
            return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(arg7, ((Type)v8_2), false, v2, v1);
        }

        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + arg8 + " has type " + Reflection.getOrCreateKotlinClass(arg8.getClass()));
    }

    static KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(SerializersModule arg0, Type arg1, boolean arg2, int arg3, Object arg4) {
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(arg0, arg1, true);
    }

    public static final KSerializer serializerOrNull(Type arg1) {
        Intrinsics.checkNotNullParameter(arg1, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), arg1);
    }

    public static final KSerializer serializerOrNull(SerializersModule arg1, Type arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "type");
        return SerializersKt__SerializersJvmKt.serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(arg1, arg2, false);
    }

    private static final KSerializer typeSerializer$SerializersKt__SerializersJvmKt(SerializersModule arg1, Class arg2, boolean arg3) {
        KSerializer v1;
        if((arg2.isArray()) && !arg2.getComponentType().isPrimitive()) {
            arg2 = arg2.getComponentType();
            Intrinsics.checkNotNullExpressionValue(arg2, "getComponentType(...)");
            if(arg3) {
                v1 = SerializersKt.serializer(arg1, arg2);
            }
            else {
                v1 = SerializersKt.serializerOrNull(arg1, arg2);
                if(v1 == null) {
                    return null;
                }
            }

            KClass v2 = JvmClassMappingKt.getKotlinClass(arg2);
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            v1 = BuiltinSerializersKt.ArraySerializer(v2, v1);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            return v1;
        }

        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
        return SerializersKt__SerializersJvmKt.reflectiveOrContextual$SerializersKt__SerializersJvmKt(arg1, arg2, CollectionsKt.emptyList());
    }
}

