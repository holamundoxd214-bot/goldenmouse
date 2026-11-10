package kotlin.jvm.internal;

import java.util.List;
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
import kotlin.reflect.KVariance;

public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public ReflectionFactory() {
        super();
    }

    public KClass createKotlinClass(Class arg1) {
        return new ClassReference(arg1);
    }

    public KClass createKotlinClass(Class arg1, String arg2) {
        return new ClassReference(arg1);
    }

    public KFunction function(FunctionReference arg1) {
        return arg1;
    }

    public KClass getOrCreateKotlinClass(Class arg1) {
        return new ClassReference(arg1);
    }

    public KClass getOrCreateKotlinClass(Class arg1, String arg2) {
        return new ClassReference(arg1);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class arg1, String arg2) {
        return new PackageReference(arg1, arg2);
    }

    public KType mutableCollectionType(KType arg4) {
        return new TypeReference(arg4.getClassifier(), arg4.getArguments(), arg4.getPlatformTypeUpperBound$kotlin_stdlib(), arg4.getFlags$kotlin_stdlib() | 2);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 arg1) {
        return arg1;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 arg1) {
        return arg1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 arg1) {
        return arg1;
    }

    public KType nothingType(KType arg4) {
        return new TypeReference(arg4.getClassifier(), arg4.getArguments(), arg4.getPlatformTypeUpperBound$kotlin_stdlib(), arg4.getFlags$kotlin_stdlib() | 4);
    }

    public KType platformType(KType arg3, KType arg4) {
        return new TypeReference(arg3.getClassifier(), arg3.getArguments(), arg4, ((TypeReference)arg3).getFlags$kotlin_stdlib());
    }

    public KProperty0 property0(PropertyReference0 arg1) {
        return arg1;
    }

    public KProperty1 property1(PropertyReference1 arg1) {
        return arg1;
    }

    public KProperty2 property2(PropertyReference2 arg1) {
        return arg1;
    }

    public String renderLambdaToString(FunctionBase arg2) {
        String v1 = arg2.getClass().getGenericInterfaces()[0].toString();
        String v2 = "kotlin.jvm.functions.";
        if(v1.startsWith(v2)) {
            v1 = v1.substring(v2.length());
        }

        return v1;
    }

    public String renderLambdaToString(Lambda arg1) {
        return this.renderLambdaToString(((FunctionBase)arg1));
    }

    public void setUpperBounds(KTypeParameter arg1, List arg2) {
        ((TypeParameterReference)arg1).setUpperBounds(arg2);
    }

    public KType typeOf(KClassifier arg1, List arg2, boolean arg3) {
        return new TypeReference(arg1, arg2, arg3);
    }

    public KTypeParameter typeParameter(Object arg1, String arg2, KVariance arg3, boolean arg4) {
        return new TypeParameterReference(arg1, arg2, arg3, arg4);
    }
}

