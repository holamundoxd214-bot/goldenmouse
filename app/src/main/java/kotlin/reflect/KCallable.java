package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\'\u0010\u0016\u001A\u00028\u00002\u0016\u0010\u0017\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0018\"\u0004\u0018\u00010\u0019H¦\u0080\u0004¢\u0006\u0002\u0010\u001AJ%\u0010\u001B\u001A\u00028\u00002\u0014\u0010\u0017\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001CH¦\u0080\u0004¢\u0006\u0002\u0010\u001DR\u001B\u0010\u0003\u001A\u00020\u00048&X§\u0084\b¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX¦\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0013\u0010\u000E\u001A\u00020\u000FX¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\n8&X§\u0084\b¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001A\u0004\b\u0015\u0010\rR\u001D\u0010\u001E\u001A\u0004\u0018\u00010\u001F8&X§\u0084\b¢\u0006\f\u0012\u0004\b \u0010\u0006\u001A\u0004\b!\u0010\"R\u001B\u0010#\u001A\u00020$8&X§\u0084\b¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001A\u0004\b#\u0010&R\u001B\u0010\'\u001A\u00020$8&X§\u0084\b¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001A\u0004\b\'\u0010&R\u001B\u0010)\u001A\u00020$8&X§\u0084\b¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001A\u0004\b)\u0010&R\u001B\u0010+\u001A\u00020$8&X§\u0084\b¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001A\u0004\b+\u0010&¨\u0006-"}, d2={"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "name", "", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "parameters", "", "Lkotlin/reflect/KParameter;", "getParameters", "()Ljava/util/List;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface KCallable extends KAnnotatedElement {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static void getName$annotations() {
        }

        public static void getTypeParameters$annotations() {
        }

        public static void getVisibility$annotations() {
        }

        public static void isAbstract$annotations() {
        }

        public static void isFinal$annotations() {
        }

        public static void isOpen$annotations() {
        }

        public static void isSuspend$annotations() {
        }
    }

    Object call(Object[] arg1);

    Object callBy(Map arg1);

    String getName();

    List getParameters();

    KType getReturnType();

    List getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}

