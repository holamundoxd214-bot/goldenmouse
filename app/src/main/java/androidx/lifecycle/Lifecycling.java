package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0001H\u0007J \u0010\u0011\u001A\u00020\r2\u000E\u0010\u0012\u001A\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010\u0010\u001A\u00020\u0001H\u0002J\u001E\u0010\u0013\u001A\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\f2\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\tH\u0002J\u0014\u0010\u0015\u001A\u00020\u00052\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\tH\u0002J\u0014\u0010\u0016\u001A\u00020\u00052\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\tH\u0002J\u0016\u0010\u0017\u001A\u00020\u00182\f\u0010\u0014\u001A\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0002J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001E\u0010\u0007\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001A \u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u000B0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/lifecycle/Lifecycling;", "", "<init>", "()V", "REFLECTIVE_CALLBACK", "", "GENERATED_CALLBACK", "callbackCache", "", "Ljava/lang/Class;", "classToAdapters", "", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/GeneratedAdapter;", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "object", "createGeneratedAdapter", "constructor", "generatedConstructor", "klass", "getObserverConstructorType", "resolveObserverCallbackType", "isLifecycleParent", "", "getAdapterName", "", "className", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    public static final Lifecycling INSTANCE = null;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map callbackCache;
    private static final Map classToAdapters;

    static {
        Lifecycling.INSTANCE = new Lifecycling();
        Lifecycling.callbackCache = new HashMap();
        Lifecycling.classToAdapters = new HashMap();
    }

    private Lifecycling() {
        super();
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor arg1, Object arg2) {
        try {
            Object v0_3 = arg1.newInstance(arg2);
            Intrinsics.checkNotNull(v0_3);
            return ((GeneratedAdapter)v0_3);
        }
        catch(InvocationTargetException v0) {
            throw new RuntimeException(((Throwable)v0));
        }
        catch(InstantiationException v0_1) {
            throw new RuntimeException(((Throwable)v0_1));
        }
        catch(IllegalAccessException v0_2) {
            throw new RuntimeException(((Throwable)v0_2));
        }
    }

    private final Constructor generatedConstructor(Class arg4) {
        Constructor v3_4;
        try {
            Package v3_1 = arg4.getPackage();
            String v0 = arg4.getCanonicalName();
            String v3_2 = v3_1 != null ? v3_1.getName() : "";
            Intrinsics.checkNotNull(v3_2);
            if(v3_2.length() == 0) {
            }
            else {
                Intrinsics.checkNotNull(v0);
                v0 = v0.substring(v3_2.length() + 1);
                Intrinsics.checkNotNullExpressionValue(v0, "substring(...)");
            }

            Intrinsics.checkNotNull(v0);
            v0 = Lifecycling.getAdapterName(v0);
            if(v3_2.length() == 0) {
            }
            else {
                v0 = v3_2 + "." + v0;
            }

            Class v3_3 = Class.forName(v0);
            Intrinsics.checkNotNull(v3_3, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            v3_4 = v3_3.getDeclaredConstructor(arg4);
            if(!v3_4.isAccessible()) {
                v3_4.setAccessible(true);
            }
        }
        catch(NoSuchMethodException v3) {
            throw new RuntimeException(((Throwable)v3));
        }
        catch(ClassNotFoundException ) {
            return null;
        }

        return v3_4;
    }

    @JvmStatic public static final String getAdapterName(String arg7) {
        Intrinsics.checkNotNullParameter(arg7, "className");
        return StringsKt.replace$default(arg7, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int getObserverConstructorType(Class arg3) {
        Map v0 = Lifecycling.callbackCache;
        Object v1 = v0.get(arg3);
        if(v1 != null) {
            return ((Integer)v1).intValue();
        }

        int v2 = this.resolveObserverCallbackType(arg3);
        v0.put(arg3, Integer.valueOf(v2));
        return v2;
    }

    private final boolean isLifecycleParent(Class arg1) {
        if(arg1 != null && (LifecycleObserver.class.isAssignableFrom(arg1))) {
            return 1;
        }

        return 0;
    }

    @JvmStatic public static final LifecycleEventObserver lifecycleEventObserver(Object arg6) {
        Intrinsics.checkNotNullParameter(arg6, "object");
        boolean v0 = arg6 instanceof LifecycleEventObserver;
        boolean v1 = arg6 instanceof DefaultLifecycleObserver;
        if((v0) && (v1)) {
            return new DefaultLifecycleObserverAdapter(arg6, ((LifecycleEventObserver)arg6));
        }

        if(v1) {
            return new DefaultLifecycleObserverAdapter(((DefaultLifecycleObserver)arg6), null);
        }

        if(v0) {
            return arg6;
        }

        Class v0_1 = arg6.getClass();
        Lifecycling v1_1 = Lifecycling.INSTANCE;
        if(v1_1.getObserverConstructorType(v0_1) == 2) {
            Object v0_2 = Lifecycling.classToAdapters.get(v0_1);
            Intrinsics.checkNotNull(v0_2);
            int v3 = 0;
            if(((List)v0_2).size() == 1) {
                return new SingleGeneratedAdapterObserver(v1_1.createGeneratedAdapter(((List)v0_2).get(0), arg6));
            }

            int v1_2 = ((List)v0_2).size();
            GeneratedAdapter[] v2 = new GeneratedAdapter[v1_2];
            while(v3 < v1_2) {
                v2[v3] = Lifecycling.INSTANCE.createGeneratedAdapter(((List)v0_2).get(v3), arg6);
                ++v3;
            }

            return new CompositeGeneratedAdaptersObserver(v2);
        }

        return new ReflectiveGenericLifecycleObserver(arg6);
    }

    private final int resolveObserverCallbackType(Class arg9) {
        ArrayList v3;
        if(arg9.getCanonicalName() == null) {
            return 1;
        }

        Constructor v0 = this.generatedConstructor(arg9);
        int v2 = 2;
        if(v0 != null) {
            Lifecycling.classToAdapters.put(arg9, CollectionsKt.listOf(v0));
            return v2;
        }

        if(ClassesInfoCache.sInstance.hasLifecycleMethods(arg9)) {
            return 1;
        }

        Class v0_1 = arg9.getSuperclass();
        if(this.isLifecycleParent(v0_1)) {
            Intrinsics.checkNotNull(v0_1);
            if(this.getObserverConstructorType(v0_1) == 1) {
                return 1;
            }
            else {
                Object v0_2 = Lifecycling.classToAdapters.get(v0_1);
                Intrinsics.checkNotNull(v0_2);
                v3 = new ArrayList(((Collection)v0_2));
            }
        }
        else {
            v3 = null;
        }

        Class[] v0_3 = arg9.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(v0_3, "getInterfaces(...)");
        int v4 = v0_3.length;
        int v5;
        for(v5 = 0; v5 < v4; ++v5) {
            Class v6 = v0_3[v5];
            if(!this.isLifecycleParent(v6)) {
            }
            else {
                Intrinsics.checkNotNull(v6);
                if(this.getObserverConstructorType(v6) == 1) {
                    return 1;
                }
                else {
                    if(v3 == null) {
                        v3 = new ArrayList();
                    }

                    Object v6_1 = Lifecycling.classToAdapters.get(v6);
                    Intrinsics.checkNotNull(v6_1);
                    ((List)v3).addAll(((Collection)v6_1));
                }
            }
        }

        if(v3 != null) {
            Lifecycling.classToAdapters.put(arg9, v3);
            return v2;
        }

        return 1;
    }
}

