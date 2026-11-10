package androidx.window.core;

import android.app.Activity;
import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0002\u001F B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\bJ\f\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u0007H\u0002J4\u0010\n\u001A\u00020\u0001\"\b\b\u0000\u0010\u000B*\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FH\u0002JB\u0010\u0011\u001A\u00020\u0010\"\b\b\u0000\u0010\u000B*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0006\u0010\u0013\u001A\u00020\u00142\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FJT\u0010\u0015\u001A\u00020\u0016\"\b\b\u0000\u0010\u000B*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u001A2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FH\u0007JL\u0010\u001B\u001A\u00020\u0016\"\b\b\u0000\u0010\u000B*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00142\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FH\u0007JT\u0010\u0015\u001A\u00020\u0016\"\b\b\u0000\u0010\u000B*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u001C\u001A\u00020\u001D2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FH\u0007JJ\u0010\u001E\u001A\u00020\u0010\"\b\b\u0000\u0010\u000B*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\r2\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u001A2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u00020\u00100\u000FR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/window/core/ConsumerAdapter;", "", "loader", "Ljava/lang/ClassLoader;", "<init>", "(Ljava/lang/ClassLoader;)V", "consumerClassOrNull", "Ljava/lang/Class;", "consumerClassOrNull$window_release", "unsafeConsumerClass", "buildConsumer", "T", "clazz", "Lkotlin/reflect/KClass;", "consumer", "Lkotlin/Function1;", "", "addConsumer", "obj", "methodName", "", "createSubscription", "Landroidx/window/core/ConsumerAdapter$Subscription;", "addMethodName", "removeMethodName", "activity", "Landroid/app/Activity;", "createSubscriptionNoActivity", "context", "Landroid/content/Context;", "createConsumer", "Subscription", "ConsumerHandler", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ConsumerAdapter {
    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u000E2\u0010\u0010\u000F\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00028\u0000¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001A\u00020\u0016*\u00020\u000E2\u0010\u0010\u0017\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0018J#\u0010\u0019\u001A\u00020\u0016*\u00020\u000E2\u0010\u0010\u0017\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0018J#\u0010\u001A\u001A\u00020\u0016*\u00020\u000E2\u0010\u0010\u0017\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0018J#\u0010\u001B\u001A\u00020\u0016*\u00020\u000E2\u0010\u0010\u0017\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/window/core/ConsumerAdapter$ConsumerHandler;", "T", "", "Ljava/lang/reflect/InvocationHandler;", "clazz", "Lkotlin/reflect/KClass;", "consumer", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "invoke", "obj", "method", "Ljava/lang/reflect/Method;", "parameters", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "invokeAccept", "parameter", "(Ljava/lang/Object;)V", "isEquals", "", "args", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "isHashCode", "isAccept", "isToString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class ConsumerHandler implements InvocationHandler {
        private final KClass clazz;
        private final Function1 consumer;

        public ConsumerHandler(KClass arg2, Function1 arg3) {
            Intrinsics.checkNotNullParameter(arg2, "clazz");
            Intrinsics.checkNotNullParameter(arg3, "consumer");
            super();
            this.clazz = arg2;
            this.consumer = arg3;
        }

        public Object invoke(Object arg4, Method arg5, Object[] arg6) {
            Intrinsics.checkNotNullParameter(arg4, "obj");
            Intrinsics.checkNotNullParameter(arg5, "method");
            Object v1 = null;
            boolean v2 = false;
            if(this.isAccept(arg5, arg6)) {
                KClass v4 = this.clazz;
                if(arg6 != null) {
                    v1 = arg6[0];
                }

                this.invokeAccept(KClasses.cast(v4, v1));
                return Unit.INSTANCE;
            }

            if(this.isEquals(arg5, arg6)) {
                if(arg6 != null) {
                    v1 = arg6[0];
                }

                if(arg4 == v1) {
                    v2 = true;
                }

                return Boolean.valueOf(v2);
            }

            if(this.isHashCode(arg5, arg6)) {
                return Integer.valueOf(this.consumer.hashCode());
            }

            if(this.isToString(arg5, arg6)) {
                return this.consumer.toString();
            }

            throw new UnsupportedOperationException("Unexpected method call object:" + arg4 + ", method: " + arg5 + ", args: " + arg6);
        }

        public final void invokeAccept(Object arg2) {
            Intrinsics.checkNotNullParameter(arg2, "parameter");
            this.consumer.invoke(arg2);
        }

        private final boolean isAccept(Method arg1, Object[] arg2) {
            if((Intrinsics.areEqual(arg1.getName(), "accept")) && arg2 != null && arg2.length == 1) {
                return 1;
            }

            return 0;
        }

        private final boolean isEquals(Method arg2, Object[] arg3) {
            if((Intrinsics.areEqual(arg2.getName(), "equals")) && (arg2.getReturnType().equals(Boolean.TYPE)) && arg3 != null && arg3.length == 1) {
                return 1;
            }

            return 0;
        }

        private final boolean isHashCode(Method arg2, Object[] arg3) {
            if((Intrinsics.areEqual(arg2.getName(), "hashCode")) && (arg2.getReturnType().equals(Integer.TYPE)) && arg3 == null) {
                return 1;
            }

            return 0;
        }

        private final boolean isToString(Method arg2, Object[] arg3) {
            if((Intrinsics.areEqual(arg2.getName(), "toString")) && (arg2.getReturnType().equals(String.class)) && arg3 == null) {
                return 1;
            }

            return 0;
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2={"Landroidx/window/core/ConsumerAdapter$Subscription;", "", "dispose", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Subscription {
        void dispose();
    }

    private final ClassLoader loader;

    public ConsumerAdapter(ClassLoader arg2) {
        Intrinsics.checkNotNullParameter(arg2, "loader");
        super();
        this.loader = arg2;
    }

    public final void addConsumer(Object arg5, KClass arg6, String arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg5, "obj");
        Intrinsics.checkNotNullParameter(arg6, "clazz");
        Intrinsics.checkNotNullParameter(arg7, "methodName");
        Intrinsics.checkNotNullParameter(arg8, "consumer");
        arg5.getClass().getMethod(arg7, this.unsafeConsumerClass()).invoke(arg5, this.buildConsumer(arg6, arg8));
    }

    private final Object buildConsumer(KClass arg3, Function1 arg4) {
        Object v2 = Proxy.newProxyInstance(this.loader, new Class[]{this.unsafeConsumerClass()}, new ConsumerHandler(arg3, arg4));
        Intrinsics.checkNotNullExpressionValue(v2, "newProxyInstance(...)");
        return v2;
    }

    public final Class consumerClassOrNull$window_release() {
        try {
            return this.unsafeConsumerClass();
        }
        catch(ClassNotFoundException ) {
            return null;
        }
    }

    public final void createConsumer(Object arg4, KClass arg5, String arg6, Activity arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg4, "obj");
        Intrinsics.checkNotNullParameter(arg5, "clazz");
        Intrinsics.checkNotNullParameter(arg6, "addMethodName");
        Intrinsics.checkNotNullParameter(arg7, "activity");
        Intrinsics.checkNotNullParameter(arg8, "consumer");
        arg4.getClass().getMethod(arg6, Activity.class, this.unsafeConsumerClass()).invoke(arg4, arg7, this.buildConsumer(arg5, arg8));
    }

    public final Subscription createSubscription(Object arg5, KClass arg6, String arg7, String arg8, Activity arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg5, "obj");
        Intrinsics.checkNotNullParameter(arg6, "clazz");
        Intrinsics.checkNotNullParameter(arg7, "addMethodName");
        Intrinsics.checkNotNullParameter(arg8, "removeMethodName");
        Intrinsics.checkNotNullParameter(arg9, "activity");
        Intrinsics.checkNotNullParameter(arg10, "consumer");
        Object v6 = this.buildConsumer(arg6, arg10);
        arg5.getClass().getMethod(arg7, Activity.class, this.unsafeConsumerClass()).invoke(arg5, arg9, v6);
        return new ConsumerAdapter$createSubscription$1(arg5.getClass().getMethod(arg8, this.unsafeConsumerClass()), arg5, v6);
    }

    public final Subscription createSubscription(Object arg5, KClass arg6, String arg7, String arg8, Context arg9, Function1 arg10) {
        Intrinsics.checkNotNullParameter(arg5, "obj");
        Intrinsics.checkNotNullParameter(arg6, "clazz");
        Intrinsics.checkNotNullParameter(arg7, "addMethodName");
        Intrinsics.checkNotNullParameter(arg8, "removeMethodName");
        Intrinsics.checkNotNullParameter(arg9, "context");
        Intrinsics.checkNotNullParameter(arg10, "consumer");
        Object v6 = this.buildConsumer(arg6, arg10);
        arg5.getClass().getMethod(arg7, Context.class, this.unsafeConsumerClass()).invoke(arg5, arg9, v6);
        return new ConsumerAdapter$createSubscription$2(arg5.getClass().getMethod(arg8, this.unsafeConsumerClass()), arg5, v6);
    }

    public final Subscription createSubscriptionNoActivity(Object arg5, KClass arg6, String arg7, String arg8, Function1 arg9) {
        Intrinsics.checkNotNullParameter(arg5, "obj");
        Intrinsics.checkNotNullParameter(arg6, "clazz");
        Intrinsics.checkNotNullParameter(arg7, "addMethodName");
        Intrinsics.checkNotNullParameter(arg8, "removeMethodName");
        Intrinsics.checkNotNullParameter(arg9, "consumer");
        Object v6 = this.buildConsumer(arg6, arg9);
        arg5.getClass().getMethod(arg7, this.unsafeConsumerClass()).invoke(arg5, v6);
        return new ConsumerAdapter$createSubscriptionNoActivity$1(arg5.getClass().getMethod(arg8, this.unsafeConsumerClass()), arg5, v6);
    }

    private final Class unsafeConsumerClass() {
        Class v1 = this.loader.loadClass("java.util.function.Consumer");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }
}

