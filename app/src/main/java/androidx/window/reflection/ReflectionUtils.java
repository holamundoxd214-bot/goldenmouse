package androidx.window.reflection;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0010\u0010\u0006\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0000¢\u0006\u0002\b\tJ#\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0001¢\u0006\u0002\b\u000EJ\u001D\u0010\u0017\u001A\u00020\u0005*\u00020\u00132\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u0019H\u0000¢\u0006\u0002\b\u001AJ\u001D\u0010\u0017\u001A\u00020\u0005*\u00020\u00132\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\bH\u0000¢\u0006\u0002\b\u001AJ%\u0010\u001B\u001A\u00020\u00052\n\u0010\u001C\u001A\u0006\u0012\u0002\b\u00030\b2\n\u0010\u001D\u001A\u0006\u0012\u0002\b\u00030\bH\u0000¢\u0006\u0002\b\u001ER\u001C\u0010\u000F\u001A\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00108@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000F\u001A\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0014R\u0018\u0010\u000F\u001A\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0016¨\u0006\u001F"}, d2={"Landroidx/window/reflection/ReflectionUtils;", "", "<init>", "()V", "checkIsPresent", "", "classLoader", "Lkotlin/Function0;", "Ljava/lang/Class;", "checkIsPresent$window_release", "validateReflection", "errorMessage", "", "block", "validateReflection$window_release", "isPublic", "Ljava/lang/reflect/Constructor;", "isPublic$window_release", "(Ljava/lang/reflect/Constructor;)Z", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Z", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)Z", "doesReturn", "clazz", "Lkotlin/reflect/KClass;", "doesReturn$window_release", "validateImplementation", "implementation", "requirements", "validateImplementation$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE;

    static {
        ReflectionUtils.INSTANCE = new ReflectionUtils();
    }

    private ReflectionUtils() {
        super();
    }

    public final boolean checkIsPresent$window_release(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "classLoader");
        try {
            arg1.invoke();
            return 1;
        }
        catch(NoClassDefFoundError ) {
            return 0;
        }
    }

    public final boolean doesReturn$window_release(Method arg1, Class arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "clazz");
        return arg1.getReturnType().equals(arg2);
    }

    public final boolean doesReturn$window_release(Method arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "clazz");
        return this.doesReturn$window_release(arg2, JvmClassMappingKt.getJavaClass(arg3));
    }

    public final boolean isPublic$window_release(Method arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Modifier.isPublic(arg1.getModifiers());
    }

    public final boolean isPublic$window_release(Constructor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Modifier.isPublic(arg1.getModifiers());
    }

    public final boolean isPublic$window_release(Field arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Modifier.isPublic(arg1.getModifiers());
    }

    static final boolean validateImplementation$lambda$1$lambda$0(Class arg3, Method arg4) {
        String v0 = arg4.getName();
        Class[] v1 = arg4.getParameterTypes();
        Method v3 = arg3.getMethod(v0, Arrays.copyOf(((Object[])v1), v1.length));
        ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        if(v0_1.isPublic$window_release(v3)) {
            Class v4 = arg4.getReturnType();
            Intrinsics.checkNotNullExpressionValue(v4, "getReturnType(...)");
            if(v0_1.doesReturn$window_release(v3, v4)) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean validateImplementation$window_release(Class arg6, Class arg7) {
        Intrinsics.checkNotNullParameter(arg6, "implementation");
        Intrinsics.checkNotNullParameter(arg7, "requirements");
        Method[] v5 = arg7.getMethods();
        Intrinsics.checkNotNullExpressionValue(v5, "getMethods(...)");
        int v7 = v5.length;
        int v1;
        for(v1 = 0; v1 < v7; ++v1) {
            if(!ReflectionUtils.validateReflection$window_release(arg6.getName() + '#' + v5[v1].getName() + " is not valid", new ReflectionUtils$$ExternalSyntheticLambda0(arg6, v5[v1]))) {
                return 0;
            }
        }

        return 1;
    }

    @JvmStatic public static final boolean validateReflection$window_release(String arg2, Function0 arg3) {
        String v0 = "ReflectionGuard";
        Intrinsics.checkNotNullParameter(arg2, "errorMessage");
        Intrinsics.checkNotNullParameter(arg3, "block");
        try {
            boolean v3 = arg3.invoke().booleanValue();
            if(!v3) {
                Log.e(v0, arg2);
            }

            return v3;
        }
        catch(NoSuchFieldException ) {
            Log.e(v0, "NoSuchField: " + arg2);
        }
        catch(NoSuchMethodException ) {
            Log.e(v0, "NoSuchMethod: " + arg2);
        }
        catch(ClassNotFoundException ) {
            Log.e(v0, "ClassNotFound: " + arg2);
        }

        return 0;
    }
}

