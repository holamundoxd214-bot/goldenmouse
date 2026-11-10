package androidx.window.core;

import android.util.Pair;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\bJ\f\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u0007H\u0002J2\u0010\n\u001A\u00020\u0001\"\b\b\u0000\u0010\u000B*\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FJP\u0010\u0011\u001A\u00020\u0001\"\b\b\u0000\u0010\u000B*\u00020\u0001\"\b\b\u0001\u0010\u0012*\u00020\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00120\r2\u0018\u0010\u000E\u001A\u0014\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u00100\u0015R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/window/core/PredicateAdapter;", "", "loader", "Ljava/lang/ClassLoader;", "<init>", "(Ljava/lang/ClassLoader;)V", "predicateClassOrNull", "Ljava/lang/Class;", "predicateClassOrNull$window_release", "predicateClassOrThrow", "buildPredicate", "T", "clazz", "Lkotlin/reflect/KClass;", "predicate", "Lkotlin/Function1;", "", "buildPairPredicate", "U", "firstClazz", "secondClazz", "Lkotlin/Function2;", "BaseHandler", "PredicateStubHandler", "PairPredicateStubHandler", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PredicateAdapter {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\b\"\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u000B2\u0010\u0010\f\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\rH\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u000F\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001A\u00020\u0010*\u00020\u000B2\u0010\u0010\u0014\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\rH\u0004¢\u0006\u0002\u0010\u0015J#\u0010\u0016\u001A\u00020\u0010*\u00020\u000B2\u0010\u0010\u0014\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\rH\u0004¢\u0006\u0002\u0010\u0015J#\u0010\u0017\u001A\u00020\u0010*\u00020\u000B2\u0010\u0010\u0014\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\rH\u0004¢\u0006\u0002\u0010\u0015J#\u0010\u0018\u001A\u00020\u0010*\u00020\u000B2\u0010\u0010\u0014\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\rH\u0004¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/window/core/PredicateAdapter$BaseHandler;", "T", "", "Ljava/lang/reflect/InvocationHandler;", "clazz", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "invoke", "obj", "method", "Ljava/lang/reflect/Method;", "parameters", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeTest", "", "parameter", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "isEquals", "args", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "isHashCode", "isTest", "isToString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) abstract class BaseHandler implements InvocationHandler {
        private final KClass clazz;

        public BaseHandler(KClass arg2) {
            Intrinsics.checkNotNullParameter(arg2, "clazz");
            super();
            this.clazz = arg2;
        }

        public Object invoke(Object arg4, Method arg5, Object[] arg6) {
            Intrinsics.checkNotNullParameter(arg4, "obj");
            Intrinsics.checkNotNullParameter(arg5, "method");
            Object v1 = null;
            boolean v2 = false;
            if(this.isTest(arg5, arg6)) {
                KClass v5 = this.clazz;
                if(arg6 != null) {
                    v1 = arg6[0];
                }

                return Boolean.valueOf(this.invokeTest(arg4, KClasses.cast(v5, v1)));
            }

            if(this.isEquals(arg5, arg6)) {
                if(arg6 != null) {
                    v1 = arg6[0];
                }

                Intrinsics.checkNotNull(v1);
                if(arg4 == v1) {
                    v2 = true;
                }

                return Boolean.valueOf(v2);
            }

            if(this.isHashCode(arg5, arg6)) {
                return Integer.valueOf(this.hashCode());
            }

            if(this.isToString(arg5, arg6)) {
                return this.toString();
            }

            throw new UnsupportedOperationException("Unexpected method call object:" + arg4 + ", method: " + arg5 + ", args: " + arg6);
        }

        public abstract boolean invokeTest(Object arg1, Object arg2);

        protected final boolean isEquals(Method arg2, Object[] arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            if((Intrinsics.areEqual(arg2.getName(), "equals")) && (arg2.getReturnType().equals(Boolean.TYPE)) && arg3 != null && arg3.length == 1) {
                return 1;
            }

            return 0;
        }

        protected final boolean isHashCode(Method arg2, Object[] arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            if((Intrinsics.areEqual(arg2.getName(), "hashCode")) && (arg2.getReturnType().equals(Integer.TYPE)) && arg3 == null) {
                return 1;
            }

            return 0;
        }

        protected final boolean isTest(Method arg2, Object[] arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            if((Intrinsics.areEqual(arg2.getName(), "test")) && (arg2.getReturnType().equals(Boolean.TYPE)) && arg3 != null && arg3.length == 1) {
                return 1;
            }

            return 0;
        }

        protected final boolean isToString(Method arg2, Object[] arg3) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            if((Intrinsics.areEqual(arg2.getName(), "toString")) && (arg2.getReturnType().equals(String.class)) && arg3 == null) {
                return 1;
            }

            return 0;
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0004B=\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\t\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0004\b\f\u0010\rJ \u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00022\u000E\u0010\u0010\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/window/core/PredicateAdapter$PairPredicateStubHandler;", "T", "", "U", "Landroidx/window/core/PredicateAdapter$BaseHandler;", "Landroid/util/Pair;", "clazzT", "Lkotlin/reflect/KClass;", "clazzU", "predicate", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)V", "invokeTest", "obj", "parameter", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class PairPredicateStubHandler extends BaseHandler {
        private final KClass clazzT;
        private final KClass clazzU;
        private final Function2 predicate;

        public PairPredicateStubHandler(KClass arg2, KClass arg3, Function2 arg4) {
            Intrinsics.checkNotNullParameter(arg2, "clazzT");
            Intrinsics.checkNotNullParameter(arg3, "clazzU");
            Intrinsics.checkNotNullParameter(arg4, "predicate");
            super(Reflection.getOrCreateKotlinClass(Pair.class));
            this.clazzT = arg2;
            this.clazzU = arg3;
            this.predicate = arg4;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public boolean invokeTest(Object arg2, Pair arg3) {
            Intrinsics.checkNotNullParameter(arg2, "obj");
            Intrinsics.checkNotNullParameter(arg3, "parameter");
            return this.predicate.invoke(KClasses.cast(this.clazzT, arg3.first), KClasses.cast(this.clazzU, arg3.second)).booleanValue();
        }

        public boolean invokeTest(Object arg1, Object arg2) {
            return this.invokeTest(arg1, ((Pair)arg2));
        }

        public String toString() {
            return this.predicate.toString();
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000EJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/window/core/PredicateAdapter$PredicateStubHandler;", "T", "", "Landroidx/window/core/PredicateAdapter$BaseHandler;", "clazzT", "Lkotlin/reflect/KClass;", "predicate", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "invokeTest", "obj", "parameter", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class PredicateStubHandler extends BaseHandler {
        private final Function1 predicate;

        public PredicateStubHandler(KClass arg2, Function1 arg3) {
            Intrinsics.checkNotNullParameter(arg2, "clazzT");
            Intrinsics.checkNotNullParameter(arg3, "predicate");
            super(arg2);
            this.predicate = arg3;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public boolean invokeTest(Object arg2, Object arg3) {
            Intrinsics.checkNotNullParameter(arg2, "obj");
            Intrinsics.checkNotNullParameter(arg3, "parameter");
            return this.predicate.invoke(arg3).booleanValue();
        }

        public String toString() {
            return this.predicate.toString();
        }
    }

    private final ClassLoader loader;

    public PredicateAdapter(ClassLoader arg2) {
        Intrinsics.checkNotNullParameter(arg2, "loader");
        super();
        this.loader = arg2;
    }

    public final Object buildPairPredicate(KClass arg2, KClass arg3, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "firstClazz");
        Intrinsics.checkNotNullParameter(arg3, "secondClazz");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Object v1 = Proxy.newProxyInstance(this.loader, new Class[]{this.predicateClassOrThrow()}, new PairPredicateStubHandler(arg2, arg3, arg4));
        Intrinsics.checkNotNullExpressionValue(v1, "newProxyInstance(...)");
        return v1;
    }

    public final Object buildPredicate(KClass arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "clazz");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Object v2 = Proxy.newProxyInstance(this.loader, new Class[]{this.predicateClassOrThrow()}, new PredicateStubHandler(arg3, arg4));
        Intrinsics.checkNotNullExpressionValue(v2, "newProxyInstance(...)");
        return v2;
    }

    public final Class predicateClassOrNull$window_release() {
        try {
            return this.predicateClassOrThrow();
        }
        catch(ClassNotFoundException ) {
            return null;
        }
    }

    private final Class predicateClassOrThrow() {
        Class v1 = this.loader.loadClass("java.util.function.Predicate");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }
}

