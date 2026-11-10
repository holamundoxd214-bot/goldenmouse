package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.KTypeParameterBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0018\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\tH\u0083\u0080\u0004\u001A$\u0010\n\u001A\u00020\u00012\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0083\u0080\u0004\u001A\u0012\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0001H\u0082\u0080\u0004\"\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u000F8BX\u0083\u0084\b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0010\u001A\u0004\b\u0005\u0010\u0011¨\u0006\u0015"}, d2={"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "computeJavaType", "forceWrapper", "", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "typeToString", "", "type", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class TypesJVMKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[KVariance.values().length];
            try {
                v0[KVariance.IN.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[KVariance.INVARIANT.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[KVariance.OUT.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final Type access$computeJavaType(KType arg0, boolean arg1) {
        return TypesJVMKt.computeJavaType(arg0, arg1);
    }

    public static final String access$typeToString(Type arg0) {
        return TypesJVMKt.typeToString(arg0);
    }

    private static final Type computeJavaType(KType arg8, boolean arg9) {
        TypeVariable v2_1;
        int v1;
        KClassifier v0 = arg8.getClassifier();
        Object v2 = null;
        int v3 = 0;
        if((v0 instanceof KTypeParameter)) {
            if(!(v0 instanceof KTypeParameterBase)) {
                return new ObsoleteFallbackTypeVariableImpl(((KTypeParameter)v0));
            }

            GenericDeclaration v9 = ((KTypeParameterBase)v0).getJavaContainingDeclaration$kotlin_stdlib();
            if(v9 != null) {
                TypeVariable[] v8 = v9.getTypeParameters();
                Intrinsics.checkNotNullExpressionValue(v8, "getTypeParameters(...)");
                int v9_1 = v8.length;
                v1 = 0;
                while(v3 < v9_1) {
                    TypeVariable v5 = v8[v3];
                    if(Intrinsics.areEqual(v5.getName(), ((KTypeParameterBase)v0).getName())) {
                        if(v1 == 0) {
                            v1 = 1;
                            v2_1 = v5;
                        }
                        else {
                            throw new IllegalArgumentException("Array contains more than one matching element.");
                        }
                    }

                    ++v3;
                }

                if(v1 != 0) {
                    Intrinsics.checkNotNullExpressionValue(v2_1, "single(...)");
                    return ((Type)v2_1);
                }

                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }

            throw new UnsupportedOperationException("javaType is not supported for this type: " + arg8);
        }

        if((v0 instanceof KClass)) {
            Class v9_2 = arg9 ? JvmClassMappingKt.getJavaObjectType(((KClass)v0)) : JvmClassMappingKt.getJavaClass(((KClass)v0));
            List v0_1 = arg8.getArguments();
            if(v0_1.isEmpty()) {
                return ((Type)v9_2);
            }

            if(v9_2.isArray()) {
                if(v9_2.getComponentType().isPrimitive()) {
                    return ((Type)v9_2);
                }

                Object v0_2 = CollectionsKt.singleOrNull(v0_1);
                if(v0_2 != null) {
                    KVariance v8_1 = ((KTypeProjection)v0_2).component1();
                    KType v0_3 = ((KTypeProjection)v0_2).component2();
                    v1 = -1;
                    int v8_2 = v8_1 == null ? v1 : WhenMappings.$EnumSwitchMapping$0[v8_1.ordinal()];
                    if(v8_2 != v1 && v8_2 != 1) {
                        if(v8_2 != 2) {
                            if(v8_2 == 3) {
                            }
                            else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }

                        Intrinsics.checkNotNull(v0_3);
                        Type v8_3 = TypesJVMKt.computeJavaType$default(v0_3, false, 1, v2);
                        if((v8_3 instanceof Class)) {
                            return ((Type)v9_2);
                        }

                        return new GenericArrayTypeImpl(v8_3);
                    }

                    return ((Type)v9_2);
                }

                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + arg8);
            }

            return TypesJVMKt.createPossiblyInnerType(v9_2, v0_1);
        }

        throw new UnsupportedOperationException("Unsupported type classifier: " + arg8);
    }

    static Type computeJavaType$default(KType arg0, boolean arg1, int arg2, Object arg3) {
        return TypesJVMKt.computeJavaType(arg0, false);
    }

    private static final Type createPossiblyInnerType(Class arg4, List arg5) {
        ArrayList v2;
        Iterator v5;
        Class v0 = arg4.getDeclaringClass();
        int v1 = 10;
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg5), v1));
            v5 = ((Iterable)arg5).iterator();
            while(v5.hasNext()) {
                ((Collection)v0_1).add(TypesJVMKt.getJavaType(v5.next()));
            }

            return new ParameterizedTypeImpl(arg4, null, ((List)v0_1));
        }

        if(Modifier.isStatic(arg4.getModifiers())) {
            v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg5), v1));
            v5 = ((Iterable)arg5).iterator();
            while(v5.hasNext()) {
                ((Collection)v2).add(TypesJVMKt.getJavaType(v5.next()));
            }

            return new ParameterizedTypeImpl(arg4, ((Type)v0), ((List)v2));
        }

        int v2_1 = arg4.getTypeParameters().length;
        Type v0_2 = TypesJVMKt.createPossiblyInnerType(v0, arg5.subList(v2_1, arg5.size()));
        arg5 = arg5.subList(0, v2_1);
        v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg5), v1));
        v5 = ((Iterable)arg5).iterator();
        while(v5.hasNext()) {
            ((Collection)v2).add(TypesJVMKt.getJavaType(v5.next()));
        }

        return new ParameterizedTypeImpl(arg4, v0_2, ((List)v2));
    }

    private static final Type getJavaType(KTypeProjection arg4) {
        KVariance v0 = arg4.getVariance();
        if(v0 == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }

        KType v4 = arg4.getType();
        Intrinsics.checkNotNull(v4);
        int v0_1 = WhenMappings.$EnumSwitchMapping$0[v0.ordinal()];
        Type v1 = null;
        if(v0_1 != 1) {
            if(v0_1 != 2) {
                if(v0_1 == 3) {
                    return new WildcardTypeImpl(TypesJVMKt.computeJavaType(v4, true), v1);
                }

                throw new NoWhenBranchMatchedException();
            }

            return TypesJVMKt.computeJavaType(v4, true);
        }

        return new WildcardTypeImpl(v1, TypesJVMKt.computeJavaType(v4, true));
    }

    public static final Type getJavaType(KType arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if((arg3 instanceof KTypeBase)) {
            Type v0 = arg3.getJavaType();
            if(v0 != null) {
                return v0;
            }
        }

        return TypesJVMKt.computeJavaType$default(arg3, false, 1, null);
    }

    public static void getJavaType$annotations(KType arg0) {
    }

    private static void getJavaType$annotations(KTypeProjection arg0) {
    }

    private static final String typeToString(Type arg2) {
        if((arg2 instanceof Class)) {
            Type v0 = arg2;
            if(((Class)v0).isArray()) {
                Sequence v2 = SequencesKt.generateSequence(arg2, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                return SequencesKt.last(v2).getName() + StringsKt.repeat("[]", SequencesKt.count(v2));
            }

            String v2_1 = ((Class)v0).getName();
            Intrinsics.checkNotNullExpressionValue(v2_1, "getName(...)");
            return v2_1;
        }

        return arg2.toString();
    }
}

