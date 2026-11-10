package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u0010\n\u0002\b\u0005\u001A#\u0010\u0014\u001A\u00020\u0015\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\t*\u0006\u0012\u0002\b\u00030\u0016H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0017\"1\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038GX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007\"1\u0010\b\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\n\u0010\u0007\"/\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\u0007\"/\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00018GX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F\"*\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\u0002H\u00028Æ\u0002X\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0011\"<\u0010\u0010\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001A\u0004\b\u0013\u0010\u0007\"+\u0010\u0018\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0019*\u0002H\u00028FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B\"<\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001D0\u0001\"\u000E\b\u0000\u0010\u001D*\b\u0012\u0004\u0012\u0002H\u001D0\u001E*\b\u0012\u0004\u0012\u0002H\u001D0\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"¨\u0006#"}, d2={"java", "Ljava/lang/Class;", "T", "Lkotlin/reflect/KClass;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaPrimitiveType", "", "getJavaPrimitiveType", "javaObjectType", "getJavaObjectType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "javaClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "annotationClass", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class JvmClassMappingKt {
    public static final KClass getAnnotationClass(Annotation arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Class v1 = arg1.annotationType();
        Intrinsics.checkNotNullExpressionValue(v1, "annotationType(...)");
        KClass v1_1 = JvmClassMappingKt.getKotlinClass(v1);
        Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return v1_1;
    }

    private static final Class getDeclaringJavaClass(Enum arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Class v1 = arg1.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(v1, "getDeclaringClass(...)");
        return v1;
    }

    public static void getDeclaringJavaClass$annotations(Enum arg0) {
    }

    public static final Class getJavaClass(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Class v1 = ((ClassBasedDeclarationContainer)arg1).getJClass();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return v1;
    }

    public static final Class getJavaClass(Object arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Class v1 = arg1.getClass();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return v1;
    }

    public static void getJavaClass$annotations(KClass arg0) {
    }

    public static final Class getJavaObjectType(KClass arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Class v3 = ((ClassBasedDeclarationContainer)arg3).getJClass();
        String v1 = "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>";
        if(!v3.isPrimitive()) {
            Intrinsics.checkNotNull(v3, v1);
            return v3;
        }

        String v0 = v3.getName();
        if(v0 != null) {
            switch(v0.hashCode()) {
                case -1325958191: {
                    goto label_61;
                }
                case 104431: {
                    goto label_55;
                }
                case 3039496: {
                    goto label_49;
                }
                case 3052374: {
                    goto label_43;
                }
                case 3327612: {
                    goto label_37;
                }
                case 3625364: {
                    goto label_31;
                }
                case 64711720: {
                    goto label_25;
                }
                case 97526364: {
                    goto label_19;
                }
                case 109413500: {
                    goto label_13;
                }
            }

            goto label_66;
        label_49:
            if(!v0.equals("byte")) {
            }
            else {
                v3 = Byte.class;
                goto label_66;
            label_19:
                if(!v0.equals("float")) {
                }
                else {
                    v3 = Float.class;
                    goto label_66;
                label_37:
                    if(!v0.equals("long")) {
                    }
                    else {
                        v3 = Long.class;
                        goto label_66;
                    label_55:
                        if(!v0.equals("int")) {
                        }
                        else {
                            v3 = Integer.class;
                            goto label_66;
                        label_25:
                            if(!v0.equals("boolean")) {
                            }
                            else {
                                v3 = Boolean.class;
                                goto label_66;
                            label_43:
                                if(!v0.equals("char")) {
                                }
                                else {
                                    v3 = Character.class;
                                    goto label_66;
                                label_61:
                                    if(!v0.equals("double")) {
                                    }
                                    else {
                                        v3 = Double.class;
                                        goto label_66;
                                    label_13:
                                        if(!v0.equals("short")) {
                                        }
                                        else {
                                            v3 = Short.class;
                                            goto label_66;
                                        label_31:
                                            if(!v0.equals("void")) {
                                            }
                                            else {
                                                v3 = Void.class;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    label_66:
        Intrinsics.checkNotNull(v3, v1);
        return v3;
    }

    public static final Class getJavaPrimitiveType(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Class v1 = ((ClassBasedDeclarationContainer)arg1).getJClass();
        if(v1.isPrimitive()) {
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return v1;
        }

        String v1_1 = v1.getName();
        if(v1_1 != null) {
            switch(v1_1.hashCode()) {
                case -527879800: {
                    goto label_55;
                }
                case -515992664: {
                    goto label_49;
                }
                case 155276373: {
                    goto label_43;
                }
                case 344809556: {
                    goto label_37;
                }
                case 398507100: {
                    goto label_31;
                }
                case 398795216: {
                    goto label_25;
                }
                case 399092968: {
                    goto label_19;
                }
                case 761287205: {
                    goto label_13;
                }
                case -2056817302: {
                    goto label_61;
                }
            }

            return null;
        label_49:
            if(!v1_1.equals("java.lang.Short")) {
            }
            else {
                return Short.TYPE;
            label_19:
                if(!v1_1.equals("java.lang.Void")) {
                }
                else {
                    return Void.TYPE;
                label_37:
                    if(!v1_1.equals("java.lang.Boolean")) {
                    }
                    else {
                        return Boolean.TYPE;
                    label_55:
                        if(!v1_1.equals("java.lang.Float")) {
                        }
                        else {
                            return Float.TYPE;
                        label_25:
                            if(!v1_1.equals("java.lang.Long")) {
                            }
                            else {
                                return Long.TYPE;
                            label_43:
                                if(!v1_1.equals("java.lang.Character")) {
                                }
                                else {
                                    return Character.TYPE;
                                label_13:
                                    if(!v1_1.equals("java.lang.Double")) {
                                    }
                                    else {
                                        return Double.TYPE;
                                    label_61:
                                        if(!v1_1.equals("java.lang.Integer")) {
                                        }
                                        else {
                                            return Integer.TYPE;
                                        label_31:
                                            if(!v1_1.equals("java.lang.Byte")) {
                                            }
                                            else {
                                                return Byte.TYPE;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public static final KClass getKotlinClass(Class arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Reflection.getOrCreateKotlinClass(arg1);
    }

    public static final Class getRuntimeClassOfKClassInstance(KClass arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Class v1 = arg1.getClass();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return v1;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'java\' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith="<_subannotation>") public static void getRuntimeClassOfKClassInstance$annotations(KClass arg0) {
    }

    public static final boolean isArrayOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(arg2.getClass().getComponentType());
    }
}

