package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

public class Reflection {
    private static final KClass[] EMPTY_K_CLASS_ARRAY = null;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";
    private static final ReflectionFactory factory;

    static {
        ReflectionFactory v0_1;
        try {
            Object v0 = Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
            goto label_5;
        }
        catch(IllegalAccessException ) {
        label_5:
            if(v0 != null) {
            }
            else {
                v0_1 = new ReflectionFactory();
            }

            Reflection.factory = v0_1;
            Reflection.EMPTY_K_CLASS_ARRAY = new KClass[0];
            return;
        }
    }

    public Reflection() {
        super();
    }

    public static KClass createKotlinClass(Class arg1) {
        return Reflection.factory.createKotlinClass(arg1);
    }

    public static KClass createKotlinClass(Class arg1, String arg2) {
        return Reflection.factory.createKotlinClass(arg1, arg2);
    }

    public static KFunction function(FunctionReference arg1) {
        return Reflection.factory.function(arg1);
    }

    public static KClass getOrCreateKotlinClass(Class arg1) {
        return Reflection.factory.getOrCreateKotlinClass(arg1);
    }

    public static KClass getOrCreateKotlinClass(Class arg1, String arg2) {
        return Reflection.factory.getOrCreateKotlinClass(arg1, arg2);
    }

    public static KClass[] getOrCreateKotlinClasses(Class[] arg4) {
        int v0 = arg4.length;
        if(v0 == 0) {
            return Reflection.EMPTY_K_CLASS_ARRAY;
        }

        KClass[] v1 = new KClass[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = Reflection.getOrCreateKotlinClass(arg4[v2]);
        }

        return v1;
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class arg2) {
        return Reflection.factory.getOrCreateKotlinPackage(arg2, "");
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class arg1, String arg2) {
        return Reflection.factory.getOrCreateKotlinPackage(arg1, arg2);
    }

    public static KType mutableCollectionType(KType arg1) {
        return Reflection.factory.mutableCollectionType(arg1);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 arg1) {
        return Reflection.factory.mutableProperty0(arg1);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 arg1) {
        return Reflection.factory.mutableProperty1(arg1);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 arg1) {
        return Reflection.factory.mutableProperty2(arg1);
    }

    public static KType nothingType(KType arg1) {
        return Reflection.factory.nothingType(arg1);
    }

    public static KType nullableTypeOf(Class arg3) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg3), Collections.emptyList(), true);
    }

    public static KType nullableTypeOf(Class arg2, KTypeProjection arg3) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg2), Collections.singletonList(arg3), true);
    }

    public static KType nullableTypeOf(Class arg3, KTypeProjection arg4, KTypeProjection arg5) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg3), Arrays.asList(new KTypeProjection[]{arg4, arg5}), true);
    }

    public static KType nullableTypeOf(Class arg2, KTypeProjection[] arg3) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg2), ArraysKt.toList(((Object[])arg3)), true);
    }

    public static KType nullableTypeOf(KClassifier arg3) {
        return Reflection.factory.typeOf(arg3, Collections.emptyList(), true);
    }

    public static KType platformType(KType arg1, KType arg2) {
        return Reflection.factory.platformType(arg1, arg2);
    }

    public static KProperty0 property0(PropertyReference0 arg1) {
        return Reflection.factory.property0(arg1);
    }

    public static KProperty1 property1(PropertyReference1 arg1) {
        return Reflection.factory.property1(arg1);
    }

    public static KProperty2 property2(PropertyReference2 arg1) {
        return Reflection.factory.property2(arg1);
    }

    public static String renderLambdaToString(FunctionBase arg1) {
        return Reflection.factory.renderLambdaToString(arg1);
    }

    public static String renderLambdaToString(Lambda arg1) {
        return Reflection.factory.renderLambdaToString(arg1);
    }

    public static void setUpperBounds(KTypeParameter arg1, KType arg2) {
        Reflection.factory.setUpperBounds(arg1, Collections.singletonList(arg2));
    }

    public static void setUpperBounds(KTypeParameter arg1, KType[] arg2) {
        Reflection.factory.setUpperBounds(arg1, ArraysKt.toList(((Object[])arg2)));
    }

    public static KType typeOf(Class arg3) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg3), Collections.emptyList(), false);
    }

    public static KType typeOf(Class arg2, KTypeProjection arg3) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg2), Collections.singletonList(arg3), false);
    }

    public static KType typeOf(Class arg3, KTypeProjection arg4, KTypeProjection arg5) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg3), Arrays.asList(new KTypeProjection[]{arg4, arg5}), false);
    }

    public static KType typeOf(Class arg2, KTypeProjection[] arg3) {
        return Reflection.factory.typeOf(Reflection.getOrCreateKotlinClass(arg2), ArraysKt.toList(((Object[])arg3)), false);
    }

    public static KType typeOf(KClassifier arg3) {
        return Reflection.factory.typeOf(arg3, Collections.emptyList(), false);
    }

    public static KTypeParameter typeParameter(Object arg1, String arg2, KVariance arg3, boolean arg4) {
        return Reflection.factory.typeParameter(arg1, arg2, arg3, arg4);
    }
}

