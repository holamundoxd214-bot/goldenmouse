package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b\u001A\u001B\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001A\u0016\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001A\u00020\u0006\u001A6\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n2\u0006\u0010\u000B\u001A\u00020\fH\u0007\u001A\u0018\u0010\r\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001A\u00020\u0006\u001A\u001A\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006\u001A:\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n2\u0006\u0010\u000B\u001A\u00020\fH\u0007\u001A\u001C\u0010\r\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006\u001A+\u0010\u000E\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\fH\u0002¢\u0006\u0002\b\u0010\u001AG\u0010\u0011\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\t\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u0006\u0010\u000B\u001A\u00020\fH\u0002¢\u0006\u0002\b\u0013\u001A2\u0010\u0014\u001A\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u0018\u00010\n*\u00020\u00032\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000F\u001A\u00020\fH\u0000\u001A\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001A$\u0010\r\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001AB\u0010\u0016\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0019H\u0000\u001A7\u0010\u001B\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\nH\u0002¢\u0006\u0002\b\u001C\u001AG\u0010\u001D\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000E\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0019H\u0002¢\u0006\u0002\b\u001E\u001A1\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010 \u001A\u00020\fH\u0002¢\u0006\u0002\b!\u001A\u0014\u0010\"\u001A\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010#\u001A\u00020$H\u0001\u001A \u0010\"\u001A\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001A\u00020\u00032\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bH\u0001\u001A7\u0010\"\u001A\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001A\u00020\u00032\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0010\u0010&\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\'H\u0001¢\u0006\u0002\u0010(\u001A \u0010)\u001A\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001A\u00020\u00032\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\bH\u0001\u001A7\u0010)\u001A\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001A\u00020\u00032\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\b2\u0010\u0010&\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\'H\u0001¢\u0006\u0002\u0010(¨\u0006*"}, d2={"serializer", "Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/modules/SerializersModule;", "", "type", "Lkotlin/reflect/KType;", "kClass", "Lkotlin/reflect/KClass;", "typeArgumentsSerializers", "", "isNullable", "", "serializerOrNull", "serializerByKTypeImpl", "failOnMissingTypeArgSerializer", "serializerByKTypeImpl$SerializersKt__SerializersKt", "serializerByKClassImpl", "rootClass", "serializerByKClassImpl$SerializersKt__SerializersKt", "serializersForParameters", "typeArguments", "parametrizedSerializerOrNull", "serializers", "elementClassifierIfArray", "Lkotlin/Function0;", "Lkotlin/reflect/KClassifier;", "compiledParametrizedSerializer", "compiledParametrizedSerializer$SerializersKt__SerializersKt", "builtinParametrizedSerializer", "builtinParametrizedSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "nullable$SerializersKt__SerializersKt", "noCompiledSerializer", "forClass", "", "module", "argSerializers", "", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "moduleThenPolymorphic", "kotlinx-serialization-core"}, k=5, mv={2, 0, 0}, xi=0x30, xs="kotlinx/serialization/SerializersKt") final class SerializersKt__SerializersKt {
    public static KClassifier $r8$lambda$kySqFMIAiKMq9XadqaNh2wiOkNo() {
        return SerializersKt__SerializersKt.serializerByKClassImpl$lambda$1$SerializersKt__SerializersKt();
    }

    public static KClassifier $r8$lambda$u_x7BEkvLYF9XQ9RRlbMZi_QcQ0(List arg0) {
        return SerializersKt__SerializersKt.serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(arg0);
    }

    private static final KSerializer builtinParametrizedSerializer$SerializersKt__SerializersKt(KClass arg4, List arg5, Function0 arg6) {
        if(!Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(Collection.class))) {
            Class v0 = List.class;
            if(!Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(v0)) && !Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(v0))) {
                if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(ArrayList.class))) {
                }
                else if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(HashSet.class))) {
                    return new HashSetSerializer(arg5.get(0));
                }
                else {
                    v0 = Set.class;
                    if(!Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(v0)) && !Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(v0))) {
                        if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
                        }
                        else if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(HashMap.class))) {
                            return new HashMapSerializer(arg5.get(0), arg5.get(1));
                        }
                        else {
                            v0 = Map.class;
                            if(!Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(v0)) && !Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(v0))) {
                                if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
                                }
                                else if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(Map$Entry.class))) {
                                    return BuiltinSerializersKt.MapEntrySerializer(arg5.get(0), arg5.get(1));
                                }
                                else if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(Pair.class))) {
                                    return BuiltinSerializersKt.PairSerializer(arg5.get(0), arg5.get(1));
                                }
                                else if(Intrinsics.areEqual(arg4, Reflection.getOrCreateKotlinClass(Triple.class))) {
                                    return BuiltinSerializersKt.TripleSerializer(arg5.get(0), arg5.get(1), arg5.get(2));
                                }
                                else if(PlatformKt.isReferenceArray(arg4)) {
                                    Object v4 = arg6.invoke();
                                    Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                                    return BuiltinSerializersKt.ArraySerializer(((KClass)v4), arg5.get(0));
                                }
                                else {
                                    return null;
                                }
                            }

                            return new LinkedHashMapSerializer(arg5.get(0), arg5.get(1));
                        }
                    }

                    return new LinkedHashSetSerializer(arg5.get(0));
                }
            }
        }

        return new ArrayListSerializer(arg5.get(0));
    }

    private static final KSerializer compiledParametrizedSerializer$SerializersKt__SerializersKt(KClass arg1, List arg2) {
        Object[] v2 = ((Collection)arg2).toArray(new KSerializer[0]);
        return PlatformKt.constructSerializerForGivenTypeArgs(arg1, Arrays.copyOf(v2, v2.length));
    }

    public static final KSerializer moduleThenPolymorphic(SerializersModule arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "module");
        Intrinsics.checkNotNullParameter(arg3, "kClass");
        KSerializer v2 = SerializersModule.getContextual$default(arg2, arg3, null, 2, null);
        if(v2 == null) {
            PolymorphicSerializer v2_1 = new PolymorphicSerializer(arg3);
        }

        return v2;
    }

    public static final KSerializer moduleThenPolymorphic(SerializersModule arg1, KClass arg2, KSerializer[] arg3) {
        PolymorphicSerializer v1_1;
        Intrinsics.checkNotNullParameter(arg1, "module");
        Intrinsics.checkNotNullParameter(arg2, "kClass");
        Intrinsics.checkNotNullParameter(arg3, "argSerializers");
        KSerializer v1 = arg1.getContextual(arg2, ArraysKt.asList(((Object[])arg3)));
        if(v1 == null) {
            v1_1 = new PolymorphicSerializer(arg2);
        }

        return ((KSerializer)v1_1);
    }

    public static final KSerializer noCompiledSerializer(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "forClass");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(arg1));
    }

    public static final KSerializer noCompiledSerializer(SerializersModule arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "module");
        Intrinsics.checkNotNullParameter(arg3, "kClass");
        KSerializer v2 = SerializersModule.getContextual$default(arg2, arg3, null, 2, null);
        if(v2 != null) {
            return v2;
        }

        Platform_commonKt.serializerNotRegistered(arg3);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer noCompiledSerializer(SerializersModule arg1, KClass arg2, KSerializer[] arg3) {
        Intrinsics.checkNotNullParameter(arg1, "module");
        Intrinsics.checkNotNullParameter(arg2, "kClass");
        Intrinsics.checkNotNullParameter(arg3, "argSerializers");
        KSerializer v1 = arg1.getContextual(arg2, ArraysKt.asList(((Object[])arg3)));
        if(v1 != null) {
            return v1;
        }

        Platform_commonKt.serializerNotRegistered(arg2);
        throw new KotlinNothingValueException();
    }

    private static final KSerializer nullable$SerializersKt__SerializersKt(KSerializer arg0, boolean arg1) {
        if(arg1) {
            return BuiltinSerializersKt.getNullable(arg0);
        }

        Intrinsics.checkNotNull(arg0, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return arg0;
    }

    public static final KSerializer parametrizedSerializerOrNull(KClass arg1, List arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "serializers");
        Intrinsics.checkNotNullParameter(arg3, "elementClassifierIfArray");
        KSerializer v3 = SerializersKt__SerializersKt.builtinParametrizedSerializer$SerializersKt__SerializersKt(arg1, arg2, arg3);
        if(v3 == null) {
            return SerializersKt__SerializersKt.compiledParametrizedSerializer$SerializersKt__SerializersKt(arg1, arg2);
        }

        return v3;
    }

    @InternalSerializationApi public static final KSerializer serializer(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        KSerializer v0 = SerializersKt.serializerOrNull(arg1);
        if(v0 != null) {
            return v0;
        }

        Platform_commonKt.serializerNotRegistered(arg1);
        throw new KotlinNothingValueException();
    }

    @ExperimentalSerializationApi public static final KSerializer serializer(KClass arg1, List arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "kClass");
        Intrinsics.checkNotNullParameter(arg2, "typeArgumentsSerializers");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), arg1, arg2, arg3);
    }

    public static final KSerializer serializer(KType arg1) {
        Intrinsics.checkNotNullParameter(arg1, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), arg1);
    }

    @ExperimentalSerializationApi public static final KSerializer serializer(SerializersModule arg1, KClass arg2, List arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "kClass");
        Intrinsics.checkNotNullParameter(arg3, "typeArgumentsSerializers");
        KSerializer v1 = SerializersKt__SerializersKt.serializerByKClassImpl$SerializersKt__SerializersKt(arg1, arg2, arg3, arg4);
        if(v1 != null) {
            return v1;
        }

        PlatformKt.platformSpecificSerializerNotRegistered(arg2);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer serializer(SerializersModule arg1, KType arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "type");
        KSerializer v1 = SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt(arg1, arg2, true);
        if(v1 != null) {
            return v1;
        }

        PlatformKt.platformSpecificSerializerNotRegistered(Platform_commonKt.kclass(arg2));
        throw new KotlinNothingValueException();
    }

    public static final KSerializer serializer() {
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer v0 = SerializersKt.serializer(null);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return v0;
    }

    public static final KSerializer serializer(SerializersModule arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer v2 = SerializersKt.serializer(arg2, null);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return v2;
    }

    private static final KSerializer serializerByKClassImpl$SerializersKt__SerializersKt(SerializersModule arg2, KClass arg3, List arg4, boolean arg5) {
        KSerializer v0;
        KSerializer v4;
        List v1 = null;
        if(arg4.isEmpty()) {
            v4 = SerializersKt.serializerOrNull(arg3);
            if(v4 == null) {
                v4 = SerializersModule.getContextual$default(arg2, arg3, v1, 2, v1);
            }
        }
        else {
            try {
                v0 = SerializersKt.parametrizedSerializerOrNull(arg3, arg4, new SerializersKt__SerializersKt$$ExternalSyntheticLambda0());
                if(v0 == null) {
                    v4 = arg2.getContextual(arg3, arg4);
                }
                else {
                    goto label_15;
                }

                goto label_16;
            }
            catch(IndexOutOfBoundsException v2) {
                throw new SerializationException("Unable to retrieve a serializer, the number of passed type serializers differs from the actual number of generic parameters", ((Throwable)v2));
            }

        label_15:
            v4 = v0;
        }

    label_16:
        if(v4 != null) {
            return SerializersKt__SerializersKt.nullable$SerializersKt__SerializersKt(v4, arg5);
        }

        return ((KSerializer)v1);
    }

    private static final KClassifier serializerByKClassImpl$lambda$1$SerializersKt__SerializersKt() {
        throw new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
    }

    private static final KSerializer serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule arg6, KType arg7, boolean arg8) {
        PolymorphicSerializer v7_4;
        PolymorphicSerializer v6;
        KSerializer v7_2;
        KClass v0 = Platform_commonKt.kclass(arg7);
        boolean v1 = arg7.isMarkedNullable();
        List v7 = arg7.getArguments();
        ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7), 10));
        Iterator v7_1 = ((Iterable)v7).iterator();
        while(v7_1.hasNext()) {
            ((Collection)v2).add(Platform_commonKt.typeOrThrow(v7_1.next()));
        }

        int v3 = 2;
        List v4 = null;
        if(((List)v2).isEmpty()) {
            if((PlatformKt.isInterface(v0)) && SerializersModule.getContextual$default(arg6, v0, v4, v3, v4) != null) {
                goto label_27;
            }

            v7_2 = SerializersCacheKt.findCachedSerializer(v0, v1);
        }
        else {
            if(arg6.getHasInterfaceContextualSerializers$kotlinx_serialization_core()) {
            label_27:
                v7_2 = ((KSerializer)v4);
                goto label_33;
            }

            Object v7_3 = SerializersCacheKt.findParametrizedCachedSerializer(v0, ((List)v2), v1);
            if(!Result.isFailure-impl(v7_3)) {
                goto label_33;
            }

            v7_2 = ((KSerializer)v4);
        }

    label_33:
        if(v7_2 != null) {
            return v7_2;
        }

        if(((List)v2).isEmpty()) {
            v7_2 = SerializersKt.serializerOrNull(v0);
            if(v7_2 == null) {
                v7_2 = SerializersModule.getContextual$default(arg6, v0, v4, v3, v4);
                if(v7_2 == null) {
                    v6 = PlatformKt.isInterface(v0) ? new PolymorphicSerializer(v0) : ((PolymorphicSerializer)v4);
                    v7_4 = v6;
                }
            }
        }
        else {
            v7 = SerializersKt.serializersForParameters(arg6, ((List)v2), arg8);
            if(v7 == null) {
                return ((KSerializer)v4);
            }

            KSerializer v8 = SerializersKt.parametrizedSerializerOrNull(v0, v7, new SerializersKt__SerializersKt$$ExternalSyntheticLambda1(((List)v2)));
            if(v8 == null) {
                v7_2 = arg6.getContextual(v0, v7);
                if(v7_2 != null) {
                    goto label_67;
                }

                v6 = PlatformKt.isInterface(v0) ? new PolymorphicSerializer(v0) : ((PolymorphicSerializer)v4);
                v7_4 = v6;
                goto label_67;
            }

            v7_2 = v8;
        }

    label_67:
        if(v7_2 != null) {
            return SerializersKt__SerializersKt.nullable$SerializersKt__SerializersKt(v7_2, v1);
        }

        return ((KSerializer)v4);
    }

    private static final KClassifier serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(List arg1) {
        return arg1.get(0).getClassifier();
    }

    @InternalSerializationApi public static final KSerializer serializerOrNull(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        KSerializer v0 = PlatformKt.compiledSerializerImpl(arg1);
        if(v0 == null) {
            return PrimitivesKt.builtinSerializerOrNull(arg1);
        }

        return v0;
    }

    public static final KSerializer serializerOrNull(KType arg1) {
        Intrinsics.checkNotNullParameter(arg1, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), arg1);
    }

    public static final KSerializer serializerOrNull(SerializersModule arg1, KType arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "type");
        return SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt(arg1, arg2, false);
    }

    public static final List serializersForParameters(SerializersModule arg1, List arg2, boolean arg3) {
        Iterator v2;
        ArrayList v3;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "typeArguments");
        int v0 = 10;
        if(arg3) {
            v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg2), v0));
            v2 = ((Iterable)arg2).iterator();
            while(v2.hasNext()) {
                ((Collection)v3).add(SerializersKt.serializer(arg1, v2.next()));
            }

            return ((List)v3);
        }

        v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg2), v0));
        v2 = ((Iterable)arg2).iterator();
        while(v2.hasNext()) {
            KSerializer v0_1 = SerializersKt.serializerOrNull(arg1, v2.next());
            if(v0_1 == null) {
                return null;
            }

            ((Collection)v3).add(v0_1);
        }

        return ((List)v3);
    }
}

