package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

@Metadata(d1={"\u0000`\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A&\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\b¢\u0006\u0002\u0010\u0005\u001A\u0015\u0010\u0000\u001A\u00020\u0006*\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\b\u001A\u001C\u0010\b\u001A\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\nH\u0000\u001A$\u0010\u000B\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\nH\u0000\u001AK\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000E0\u0002\"\b\b\u0000\u0010\u0001*\u00020\t\"\n\b\u0001\u0010\u000E*\u0004\u0018\u0001H\u0001*\u0012\u0012\u0004\u0012\u0002H\u000E0\u000Fj\b\u0012\u0004\u0012\u0002H\u000E`\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00010\nH\u0000¢\u0006\u0002\u0010\u0012\u001A\u0010\u0010\u0013\u001A\u00020\u0014*\u0006\u0012\u0002\b\u00030\nH\u0000\u001A\u0010\u0010\u0015\u001A\u00020\u0014*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001AM\u0010\u0017\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\n2\"\u0010\u0018\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0000¢\u0006\u0002\u0010\u0019\u001AM\u0010\u0017\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0000¢\u0006\u0002\u0010\u001A\u001AM\u0010\u001B\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0002¢\u0006\u0002\u0010\u001A\u001A\u001E\u0010\u001C\u001A\u0004\u0018\u00010\t\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001A\u001C\u0010\u001D\u001A\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001A\u001C\u0010\u001E\u001A\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001AO\u0010\u001F\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t2\n\u0010 \u001A\u0006\u0012\u0002\b\u00030\u00162\"\u0010\u0018\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0002¢\u0006\u0002\u0010\u001A\u001AK\u0010!\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t2\u0006\u0010\"\u001A\u00020\t2\"\u0010\u0018\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0002¢\u0006\u0002\u0010#\u001A\u001A\u0010$\u001A\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010%\u001A\u00020&H\u0002\u001A\"\u0010\'\u001A\b\u0012\u0004\u0012\u0002H\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001A$\u0010(\u001A\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0002\u001A\u0016\u0010)\u001A\u00020\u00062\f\u0010*\u001A\b\u0012\u0004\u0012\u00020\t0\nH\u0000\u001A\u001C\u0010+\u001A\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0,H\u0000\u001A\u0017\u0010-\u001A\u00020.2\f\u0010/\u001A\b\u0012\u0004\u0012\u00020.00H\u0082\b¨\u00061"}, d2={"getChecked", "T", "", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "", "isInterface", "", "Lkotlin/reflect/KClass;", "compiledSerializerImpl", "Lkotlinx/serialization/KSerializer;", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "platformSpecificSerializerNotRegistered", "", "serializerNotRegistered", "Ljava/lang/Class;", "constructSerializerForGivenTypeArgs", "args", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "findInNamedCompanion", "findNamedCompanionByAnnotation", "isNotAnnotated", "isPolymorphicSerializer", "invokeSerializerOnDefaultCompanion", "jClass", "invokeSerializerOnCompanion", "companion", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "companionOrNull", "companionName", "", "createEnumSerializer", "findObjectSerializer", "isReferenceArray", "rootClass", "initBuiltins", "", "loadSafe", "", "block", "Lkotlin/Function0;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformKt {
    private static final Object companionOrNull(Class arg1, String arg2) {
        Object v0 = null;
        try {
            Field v1 = arg1.getDeclaredField(arg2);
            v1.setAccessible(true);
            return v1.get(v0);
        }
        catch(Throwable ) {
            return v0;
        }
    }

    public static final KSerializer compiledSerializerImpl(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return PlatformKt.constructSerializerForGivenTypeArgs(arg1, new KSerializer[0]);
    }

    public static final KSerializer constructSerializerForGivenTypeArgs(Class arg1, KSerializer[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "args");
        if((arg1.isEnum()) && (PlatformKt.isNotAnnotated(arg1))) {
            return PlatformKt.createEnumSerializer(arg1);
        }

        KSerializer v0 = PlatformKt.invokeSerializerOnDefaultCompanion(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        if(v0 != null) {
            return v0;
        }

        v0 = PlatformKt.findObjectSerializer(arg1);
        if(v0 != null) {
            return v0;
        }

        KSerializer v2 = PlatformKt.findInNamedCompanion(arg1, Arrays.copyOf(((Object[])arg2), arg2.length));
        if(v2 != null) {
            return v2;
        }

        if(PlatformKt.isPolymorphicSerializer(arg1)) {
            return new PolymorphicSerializer(JvmClassMappingKt.getKotlinClass(arg1));
        }

        return null;
    }

    public static final KSerializer constructSerializerForGivenTypeArgs(KClass arg1, KSerializer[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "args");
        return PlatformKt.constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass(arg1), Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    private static final KSerializer createEnumSerializer(Class arg3) {
        Object[] v0 = arg3.getEnumConstants();
        String v3 = arg3.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(v3, "getCanonicalName(...)");
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(v3, ((Enum[])v0));
    }

    private static final KSerializer findInNamedCompanion(Class arg7, KSerializer[] arg8) {
        Object v7_2;
        Object v0 = PlatformKt.findNamedCompanionByAnnotation(arg7);
        if(v0 != null) {
            KSerializer v8 = PlatformKt.invokeSerializerOnCompanion(v0, Arrays.copyOf(((Object[])arg8), arg8.length));
            if(v8 != null) {
                return v8;
            }
        }

        Object v8_1 = null;
        try {
            Class[] v7 = arg7.getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(v7, "getDeclaredClasses(...)");
            int v0_1 = v7.length;
            int v1 = 0;
            Class v3 = ((Class)v8_1);
            int v2 = 0;
            while(v1 < v0_1) {
                Class v4 = v7[v1];
                if(Intrinsics.areEqual(v4.getSimpleName(), "$serializer")) {
                    if(v2 != 0) {
                        goto label_29;
                    }
                    else {
                        v2 = 1;
                        v3 = v4;
                    }
                }

                ++v1;
            }

            if(v2 == 0) {
            label_29:
                v3 = ((Class)v8_1);
            }

            if(v3 != null) {
                Field v7_1 = v3.getField("INSTANCE");
                if(v7_1 != null) {
                    v7_2 = v7_1.get(v8_1);
                }
                else {
                    goto label_36;
                }
            }
            else {
            label_36:
                v7_2 = v8_1;
            }

            if(!(v7_2 instanceof KSerializer)) {
                goto label_40;
            }

            return ((KSerializer)v7_2);
        }
        catch(NoSuchFieldException ) {
        label_40:
            return ((KSerializer)v8_1);
        }
    }

    private static final Object findNamedCompanionByAnnotation(Class arg7) {
        Class v4;
        Object v3;
        Class[] v0 = arg7.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(v0, "getDeclaredClasses(...)");
        int v1 = v0.length;
        int v2 = 0;
        while(true) {
            v3 = null;
            if(v2 < v1) {
                v4 = v0[v2];
                if(v4.getAnnotation(NamedCompanion.class) != null) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_16;
        }

        v4 = ((Class)v3);
    label_16:
        if(v4 == null) {
            return v3;
        }

        String v0_1 = v4.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getSimpleName(...)");
        return PlatformKt.companionOrNull(arg7, v0_1);
    }

    private static final KSerializer findObjectSerializer(Class arg12) {
        String v0 = arg12.getCanonicalName();
        Object v1 = null;
        if(v0 != null) {
            int v4 = 2;
            if(!StringsKt.startsWith$default(v0, "java.", false, v4, v1)) {
                if(StringsKt.startsWith$default(v0, "kotlin.", false, v4, v1)) {
                }
                else {
                    Field[] v0_1 = arg12.getDeclaredFields();
                    Intrinsics.checkNotNullExpressionValue(v0_1, "getDeclaredFields(...)");
                    int v2 = v0_1.length;
                    Field v6 = ((Field)v1);
                    v4 = 0;
                    int v5 = 0;
                    while(v4 < v2) {
                        Field v8 = v0_1[v4];
                        Field v9 = v8;
                        if((Intrinsics.areEqual(v9.getName(), "INSTANCE")) && (Intrinsics.areEqual(v9.getType(), arg12)) && (Modifier.isStatic(v9.getModifiers()))) {
                            if(v5 != 0) {
                                goto label_40;
                            }
                            else {
                                v5 = 1;
                                v6 = v8;
                            }
                        }

                        ++v4;
                    }

                    if(v5 == 0) {
                    label_40:
                        v6 = ((Field)v1);
                    }

                    if(v6 == null) {
                        return ((KSerializer)v1);
                    }

                    Object v0_2 = v6.get(v1);
                    Method[] v12 = arg12.getMethods();
                    Intrinsics.checkNotNullExpressionValue(v12, "getMethods(...)");
                    v2 = v12.length;
                    Method v6_1 = ((Method)v1);
                    v4 = 0;
                    v5 = 0;
                    while(v4 < v2) {
                        Method v8_1 = v12[v4];
                        Method v9_1 = v8_1;
                        if(Intrinsics.areEqual(v9_1.getName(), "serializer")) {
                            Class[] v10 = v9_1.getParameterTypes();
                            Intrinsics.checkNotNullExpressionValue(v10, "getParameterTypes(...)");
                            if(v10.length == 0 && (Intrinsics.areEqual(v9_1.getReturnType(), KSerializer.class))) {
                                if(v5 != 0) {
                                    goto label_74;
                                }
                                else {
                                    v5 = 1;
                                    v6_1 = v8_1;
                                }
                            }
                        }

                        ++v4;
                    }

                    if(v5 == 0) {
                    label_74:
                        v6_1 = ((Method)v1);
                    }

                    if(v6_1 == null) {
                        return ((KSerializer)v1);
                    }

                    Object v12_1 = v6_1.invoke(v0_2);
                    if(!(v12_1 instanceof KSerializer)) {
                        goto label_82;
                    }

                    return ((KSerializer)v12_1);
                }
            }
        }

    label_82:
        return ((KSerializer)v1);
    }

    public static final Object getChecked(Object[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1[arg2];
    }

    public static final boolean getChecked(boolean[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1[arg2];
    }

    public static final Map initBuiltins() {
        Map v0 = MapsKt.createMapBuilder();
        v0.put(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(Character.TYPE), BuiltinSerializersKt.serializer(CharCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(char[].class), BuiltinSerializersKt.CharArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(Double.TYPE), BuiltinSerializersKt.serializer(DoubleCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(double[].class), BuiltinSerializersKt.DoubleArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(Float.TYPE), BuiltinSerializersKt.serializer(FloatCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(float[].class), BuiltinSerializersKt.FloatArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(Long.TYPE), BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(long[].class), BuiltinSerializersKt.LongArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(ULong.class), BuiltinSerializersKt.serializer(ULong.Companion));
        v0.put(Reflection.getOrCreateKotlinClass(Integer.TYPE), BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(int[].class), BuiltinSerializersKt.IntArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(UInt.class), BuiltinSerializersKt.serializer(UInt.Companion));
        v0.put(Reflection.getOrCreateKotlinClass(Short.TYPE), BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(short[].class), BuiltinSerializersKt.ShortArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(UShort.class), BuiltinSerializersKt.serializer(UShort.Companion));
        v0.put(Reflection.getOrCreateKotlinClass(Byte.TYPE), BuiltinSerializersKt.serializer(ByteCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(byte[].class), BuiltinSerializersKt.ByteArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(UByte.class), BuiltinSerializersKt.serializer(UByte.Companion));
        v0.put(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer());
        v0.put(Reflection.getOrCreateKotlinClass(Unit.class), BuiltinSerializersKt.serializer(Unit.INSTANCE));
        v0.put(Reflection.getOrCreateKotlinClass(Void.class), BuiltinSerializersKt.NothingSerializer());
        try {
            v0.put(Reflection.getOrCreateKotlinClass(Duration.class), BuiltinSerializersKt.serializer(Duration.Companion));
            goto label_112;
        }
        catch(ClassNotFoundException ) {
            try {
            label_112:
                v0.put(Reflection.getOrCreateKotlinClass(ULongArray.class), BuiltinSerializersKt.ULongArraySerializer());
                goto label_116;
            }
            catch(ClassNotFoundException ) {
                try {
                label_116:
                    v0.put(Reflection.getOrCreateKotlinClass(UIntArray.class), BuiltinSerializersKt.UIntArraySerializer());
                    goto label_120;
                }
                catch(ClassNotFoundException ) {
                    try {
                    label_120:
                        v0.put(Reflection.getOrCreateKotlinClass(UShortArray.class), BuiltinSerializersKt.UShortArraySerializer());
                        goto label_124;
                    }
                    catch(ClassNotFoundException ) {
                        try {
                        label_124:
                            v0.put(Reflection.getOrCreateKotlinClass(UByteArray.class), BuiltinSerializersKt.UByteArraySerializer());
                            goto label_128;
                        }
                        catch(ClassNotFoundException ) {
                            try {
                            label_128:
                                v0.put(Reflection.getOrCreateKotlinClass(Uuid.class), BuiltinSerializersKt.serializer(Uuid.Companion));
                                goto label_133;
                            }
                            catch(ClassNotFoundException ) {
                            label_133:
                                return MapsKt.build(v0);
                            }
                        }
                    }
                }
            }
        }
    }

    private static final KSerializer invokeSerializerOnCompanion(Object arg5, KSerializer[] arg6) {
        Class[] v1;
        KSerializer v0 = null;
        try {
            int v2 = 0;
            if(arg6.length == 0) {
                v1 = new Class[0];
            }
            else {
                int v1_1 = arg6.length;
                Class[] v3 = new Class[v1_1];
                while(v2 < v1_1) {
                    v3[v2] = KSerializer.class;
                    ++v2;
                }

                v1 = v3;
            }

            arg5 = arg5.getClass().getDeclaredMethod("serializer", Arrays.copyOf(((Object[])v1), v1.length)).invoke(arg5, Arrays.copyOf(((Object[])arg6), arg6.length));
            if(!(arg5 instanceof KSerializer)) {
                return v0;
            }

            return ((KSerializer)arg5);
        }
        catch(NoSuchMethodException ) {
            return v0;
        }
        catch(InvocationTargetException v5) {
            goto label_27;
        }

        return v0;
    label_27:
        Throwable v6 = v5.getCause();
        if(v6 != null) {
            String v1_2 = v6.getMessage();
            if(v1_2 == null) {
                v1_2 = v5.getMessage();
            }

            throw new InvocationTargetException(v6, v1_2);
        }

        throw v5;
    }

    private static final KSerializer invokeSerializerOnDefaultCompanion(Class arg1, KSerializer[] arg2) {
        Object v1 = PlatformKt.companionOrNull(arg1, "Companion");
        if(v1 == null) {
            return null;
        }

        return PlatformKt.invokeSerializerOnCompanion(v1, Arrays.copyOf(((Object[])arg2), arg2.length));
    }

    public static final boolean isInterface(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return JvmClassMappingKt.getJavaClass(arg1).isInterface();
    }

    private static final boolean isNotAnnotated(Class arg1) {
        if(arg1.getAnnotation(Serializable.class) == null && arg1.getAnnotation(Polymorphic.class) == null) {
            return 1;
        }

        return 0;
    }

    private static final boolean isPolymorphicSerializer(Class arg2) {
        if(arg2.getAnnotation(Polymorphic.class) != null) {
            return 1;
        }

        Annotation v2 = arg2.getAnnotation(Serializable.class);
        if(v2 != null && (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((Serializable)v2).with()), Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class)))) {
            return 1;
        }

        return 0;
    }

    public static final boolean isReferenceArray(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "rootClass");
        return JvmClassMappingKt.getJavaClass(arg1).isArray();
    }

    private static final void loadSafe(Function0 arg0) {
        try {
            arg0.invoke();
            return;
        }
        catch(ClassNotFoundException ) {
            return;
        }
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Platform_commonKt.serializerNotRegistered(arg1);
        throw new KotlinNothingValueException();
    }

    public static final Void serializerNotRegistered(Class arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(JvmClassMappingKt.getKotlinClass(arg1)));
    }

    public static final Object[] toNativeArrayImpl(ArrayList arg1, KClass arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "eClass");
        Object v2 = Array.newInstance(JvmClassMappingKt.getJavaClass(arg2), arg1.size());
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] v1 = arg1.toArray(((Object[])v2));
        Intrinsics.checkNotNullExpressionValue(v1, "toArray(...)");
        return v1;
    }
}

