package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Build$VERSION;
import android.os.IBinder;
import android.system.Os;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u000BH\u0002J\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014R\u001F\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\f\u001A\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchDisplayTokens;", "", "<init>", "()V", "control", "Ljava/lang/Class;", "getControl", "()Ljava/lang/Class;", "control$delegate", "Lkotlin/Lazy;", "composer", "Lkotlin/Pair;", "resolver", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchDisplayTokenResolver;", "getResolver", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchDisplayTokenResolver;", "resolver$delegate", "resolve", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchDisplayToken;", "physicalId", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchDisplayTokens {
    public static final int $stable;
    public static final AndroidStretchDisplayTokens INSTANCE;
    private static final Lazy control$delegate;
    private static final Lazy resolver$delegate;

    static {
        AndroidStretchDisplayTokens.INSTANCE = new AndroidStretchDisplayTokens();
        AndroidStretchDisplayTokens.control$delegate = LazyKt.lazy(new AndroidStretchDisplayTokens$$ExternalSyntheticLambda0());
        AndroidStretchDisplayTokens.resolver$delegate = LazyKt.lazy(new AndroidStretchDisplayTokens$$ExternalSyntheticLambda1());
        AndroidStretchDisplayTokens.$stable = 8;
    }

    private AndroidStretchDisplayTokens() {
        super();
    }

    public static final Pair access$composer(AndroidStretchDisplayTokens arg0) {
        return arg0.composer();
    }

    private final Pair composer() {
        Object v2 = null;
        Object v7 = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(v2, "SurfaceFlingerAIDL");
        if((v7 instanceof IBinder)) {
        }
        else {
            v7 = v2;
        }

        String v1 = "Check failed.";
        if(v7 != null && (((IBinder)v7).isBinderAlive())) {
            String v5 = "android.gui.ISurfaceComposer";
            if(Intrinsics.areEqual(((IBinder)v7).getInterfaceDescriptor(), v5)) {
                Class v4 = Class.forName(v5);
                Object v0 = Class.forName("android.gui.ISurfaceComposer$Stub").getMethod("asInterface", IBinder.class).invoke(v2, v7);
                if((v4.isInstance(v0)) && v4.getMethod("asBinder", new Class[0]).invoke(v0, new Object[0]) == v7) {
                    if(v0 != null) {
                        return TuplesKt.to(v4, v0);
                    }
                    else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }

                throw new IllegalStateException(v1);
            }
        }

        throw new IllegalStateException(v1);
    }

    static final Class control_delegate$lambda$4() {
        String v0 = Os.getenv("SYSTEMSERVERCLASSPATH");
        Object v1 = null;
        List v0_1 = v0 != null ? StringsKt.split$default(v0, new char[]{':'}, false, 0, 6, null) : ((List)v1);
        if(v0_1 == null) {
            v0_1 = CollectionsKt.emptyList();
        }

        int v4 = 6;
        String[] v5 = new String[v4];
        v5[0] = "/system/";
        v5[1] = "/system_ext/";
        int v7 = 2;
        v5[v7] = "/product/";
        int v8 = 3;
        v5[v8] = "/apex/";
        int v9 = 4;
        v5[v9] = "/vendor/";
        int v10 = 5;
        v5[v10] = "/odm/";
        List v5_1 = CollectionsKt.listOf(((Object[])v5));
        if(!v0_1.isEmpty()) {
            List v6 = v0_1;
            if(!(v6 instanceof Collection) || !v6.isEmpty()) {
                Iterator v6_1 = ((Iterable)v6).iterator();
            label_49:
                if(v6_1.hasNext()) {
                    Object v11 = v6_1.next();
                    List v12 = v5_1;
                    if(((v12 instanceof Collection)) && (v12.isEmpty())) {
                        goto label_143;
                    }

                    Iterator v12_1 = ((Iterable)v12).iterator();
                    do {
                        if(!v12_1.hasNext()) {
                            goto label_143;
                        }
                    }
                    while(!StringsKt.startsWith$default(((String)v11), v12_1.next(), false, v7, v1));

                    if(!StringsKt.endsWith$default(((String)v11), ".jar", false, v7, v1)) {
                        goto label_143;
                    }

                    List v11_1 = StringsKt.split$default(v11, new char[]{'/'}, false, 0, 6, null);
                    if(((v11_1 instanceof Collection)) && (v11_1.isEmpty())) {
                        goto label_49;
                    }

                    Iterator v11_2 = ((Iterable)v11_1).iterator();
                    while(true) {
                        if(!v11_2.hasNext()) {
                            goto label_49;
                        }

                        if(Intrinsics.areEqual(v11_2.next(), "..")) {
                            goto label_143;
                        }
                    }
                }
            }
            else {
            }

            Class v5_2 = Class.forName("com.android.internal.os.ClassLoaderFactory");
            Class[] v6_2 = new Class[7];
            Class v11_3 = String.class;
            v6_2[0] = v11_3;
            v6_2[1] = v11_3;
            v6_2[v7] = v11_3;
            v6_2[v8] = ClassLoader.class;
            v6_2[v9] = Integer.TYPE;
            v6_2[v10] = Boolean.TYPE;
            v6_2[v4] = v11_3;
            Object v0_2 = v5_2.getDeclaredMethod("createClassLoader", v6_2).invoke(v1, CollectionsKt.joinToString$default(v0_1, ":", null, null, 0, null, null, 62, null), null, null, ClassLoader.getSystemClassLoader(), Integer.valueOf(0), Boolean.valueOf(true), null);
            Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type java.lang.ClassLoader");
            Class v0_3 = ((ClassLoader)v0_2).loadClass("com.android.server.display.DisplayControl");
            Class v1_1 = Runtime.class;
            Method v1_2 = v1_1.getDeclaredMethod("loadLibrary0", Class.class, v11_3);
            v1_2.setAccessible(true);
            v1_2.invoke(Runtime.getRuntime(), v0_3, "android_servers");
            return v0_3;
        }

    label_143:
        throw new IllegalStateException("DISPLAY_CONTROL_CLASSPATH_UNAVAILABLE".toString());
    }

    private final Class getControl() {
        Object v1 = AndroidStretchDisplayTokens.control$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(v1, "getValue(...)");
        return ((Class)v1);
    }

    private final StretchDisplayTokenResolver getResolver() {
        return AndroidStretchDisplayTokens.resolver$delegate.getValue();
    }

    public final StretchDisplayToken resolve(long arg1) {
        return this.getResolver().resolve(arg1);
    }

    static final StretchDisplayTokenResolver resolver_delegate$lambda$7() {
        return new StretchDisplayTokenResolver(Build$VERSION.SDK_INT, new AndroidStretchDisplayTokens$$ExternalSyntheticLambda2(), new AndroidStretchDisplayTokens$$ExternalSyntheticLambda3(), new AndroidStretchDisplayTokens$resolver$2$3(AndroidStretchDisplayTokens.INSTANCE));
    }

    static final Class resolver_delegate$lambda$7$lambda$5() {
        Class v0 = Class.forName("android.view.SurfaceControl");
        Intrinsics.checkNotNullExpressionValue(v0, "forName(...)");
        return v0;
    }

    static final Class resolver_delegate$lambda$7$lambda$6() {
        return AndroidStretchDisplayTokens.INSTANCE.getControl();
    }
}

