package kotlin.jvm.internal;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.KDeclarationContainer;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001A\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\u0080\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0004*\u00020\u0006H\u0082\u0080\u0004\u001A\u001E\u0010\u0007\u001A\u00020\b*\u00060\tj\u0002`\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\fH\u0082\u0080\u0004¨\u0006\r"}, d2={"findMethodBySignature", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/KDeclarationContainer;", "signature", "", "computeMethodSignature", "Ljava/lang/reflect/Method;", "appendClass", "", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "start", "Ljava/lang/Class;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class KotlinGenericDeclarationKt {
    private static final void appendClass(Appendable arg7, Class arg8) {
        while(arg8.isArray()) {
            arg7.append("[");
            arg8 = arg8.getComponentType();
            Intrinsics.checkNotNullExpressionValue(arg8, "getComponentType(...)");
        }

        if(Intrinsics.areEqual(arg8, Void.TYPE)) {
            arg7.append("V");
            return;
        }

        if(Intrinsics.areEqual(arg8, Integer.TYPE)) {
            arg7.append("I");
            return;
        }

        if(Intrinsics.areEqual(arg8, Long.TYPE)) {
            arg7.append("J");
            return;
        }

        if(Intrinsics.areEqual(arg8, Short.TYPE)) {
            arg7.append("S");
            return;
        }

        if(Intrinsics.areEqual(arg8, Byte.TYPE)) {
            arg7.append("B");
            return;
        }

        if(Intrinsics.areEqual(arg8, Boolean.TYPE)) {
            arg7.append("Z");
            return;
        }

        if(Intrinsics.areEqual(arg8, Character.TYPE)) {
            arg7.append("C");
            return;
        }

        if(Intrinsics.areEqual(arg8, Float.TYPE)) {
            arg7.append("F");
            return;
        }

        if(Intrinsics.areEqual(arg8, Double.TYPE)) {
            arg7.append("D");
            return;
        }

        arg7.append("L");
        String v1 = arg8.getName();
        Intrinsics.checkNotNullExpressionValue(v1, "getName(...)");
        arg7.append(StringsKt.replace$default(v1, '.', '/', false, 4, null));
        arg7.append(";");
    }

    private static final String computeMethodSignature(Method arg6) {
        StringBuilder v0 = new StringBuilder();
        v0.append(arg6.getName());
        v0.append("(");
        Class[] v1 = arg6.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(v1, "getParameterTypes(...)");
        int v2 = v1.length;
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Class v4 = v1[v3];
            Intrinsics.checkNotNull(v4);
            KotlinGenericDeclarationKt.appendClass(v0, v4);
        }

        v0.append(")");
        Class v6 = arg6.getReturnType();
        Intrinsics.checkNotNullExpressionValue(v6, "getReturnType(...)");
        KotlinGenericDeclarationKt.appendClass(v0, v6);
        return v0.toString();
    }

    public static final GenericDeclaration findMethodBySignature(KDeclarationContainer arg7, String arg8) {
        Method v1_1;
        Intrinsics.checkNotNullParameter(arg8, "signature");
        GenericDeclaration v1 = null;
        if(!(arg7 instanceof ClassBasedDeclarationContainer)) {
            return v1;
        }

        String v0 = StringsKt.substringBefore$default(arg8, '(', ((String)v1), 2, v1);
        if(!Intrinsics.areEqual(v0, "<init>")) {
            Method[] v7 = ((ClassBasedDeclarationContainer)arg7).getJClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(v7, "getDeclaredMethods(...)");
            int v2 = v7.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                Method v4 = v7[v3];
                Method v5 = v4;
                if(Intrinsics.areEqual(v5.getName(), v0)) {
                    Intrinsics.checkNotNull(v5);
                    if(Intrinsics.areEqual(KotlinGenericDeclarationKt.computeMethodSignature(v5), arg8)) {
                        v1_1 = v4;
                        break;
                    }
                }
            }

            return ((GenericDeclaration)v1_1);
        }

        throw new UnsupportedOperationException("Generic Java constructors are not supported: " + arg7 + '/' + arg8);
    }
}

