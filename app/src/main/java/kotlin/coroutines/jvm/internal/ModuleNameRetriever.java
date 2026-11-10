package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086\u0080\u0004J\u001A\u0010\u000B\u001A\u00020\u00052\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0082\u0080\u0004R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "<init>", "()V", "notOnJava9", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "cache", "getModuleName", "", "continuation", "Lkotlin/coroutines/Continuation;", "buildCache", "Cache", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ModuleNameRetriever {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\'\bF\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method arg1, Method arg2, Method arg3) {
            super();
            this.getModuleMethod = arg1;
            this.getDescriptorMethod = arg2;
            this.nameMethod = arg3;
        }
    }

    public static final ModuleNameRetriever INSTANCE;
    private static Cache cache;
    private static final Cache notOnJava9;

    static {
        ModuleNameRetriever.INSTANCE = new ModuleNameRetriever();
        ModuleNameRetriever.notOnJava9 = new Cache(null, null, null);
    }

    private ModuleNameRetriever() {
        super();
    }

    private final Cache buildCache(Continuation arg5) {
        try {
            Cache v1 = new Cache(Class.class.getDeclaredMethod("getModule"), arg5.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor"), arg5.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name"));
            ModuleNameRetriever.cache = v1;
            return v1;
        }
        catch(Exception ) {
            Cache v4 = ModuleNameRetriever.notOnJava9;
            ModuleNameRetriever.cache = v4;
            return v4;
        }
    }

    public final String getModuleName(Continuation arg5) {
        Intrinsics.checkNotNullParameter(arg5, "continuation");
        Cache v0 = ModuleNameRetriever.cache;
        if(v0 == null) {
            v0 = this.buildCache(arg5);
        }

        String v1 = null;
        if(v0 == ModuleNameRetriever.notOnJava9) {
            return v1;
        }

        Method v4 = v0.getModuleMethod;
        if(v4 != null) {
            Object v4_1 = v4.invoke(arg5.getClass());
            if(v4_1 == null) {
            }
            else {
                Method v5 = v0.getDescriptorMethod;
                if(v5 != null) {
                    v4_1 = v5.invoke(v4_1);
                    if(v4_1 == null) {
                    }
                    else {
                        v5 = v0.nameMethod;
                        v4_1 = v5 != null ? v5.invoke(v4_1) : v1;
                        if(!(v4_1 instanceof String)) {
                            return v1;
                        }

                        return ((String)v4_1);
                    }
                }
            }
        }

        return v1;
    }
}

