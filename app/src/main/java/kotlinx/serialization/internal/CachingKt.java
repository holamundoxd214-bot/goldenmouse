package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001A4\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u001E\u0010\u0005\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u0006H\u0000\u001AB\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042,\u0010\u0005\u001A(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\r\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u000BH\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"useClassValue", "", "createCache", "Lkotlinx/serialization/internal/SerializerCache;", "T", "factory", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "createParametrizedCache", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "Lkotlin/Function2;", "", "", "Lkotlin/reflect/KType;", "kotlinx-serialization-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CachingKt {
    private static final boolean useClassValue;

    static {
        boolean v0;
        try {
            Class.forName("java.lang.ClassValue");
            v0 = true;
        }
        catch(Throwable ) {
            v0 = false;
        }

        CachingKt.useClassValue = v0;
    }

    public static final SerializerCache createCache(Function1 arg1) {
        ConcurrentHashMapCache v0_1;
        Intrinsics.checkNotNullParameter(arg1, "factory");
        if(CachingKt.useClassValue) {
            ClassValueCache v0 = new ClassValueCache(arg1);
        }
        else {
            v0_1 = new ConcurrentHashMapCache(arg1);
        }

        return ((SerializerCache)v0_1);
    }

    public static final ParametrizedSerializerCache createParametrizedCache(Function2 arg1) {
        ClassValueParametrizedCache v0;
        Intrinsics.checkNotNullParameter(arg1, "factory");
        if(CachingKt.useClassValue) {
            v0 = new ClassValueParametrizedCache(arg1);
        }
        else {
            ConcurrentHashMapParametrizedCache v0_1 = new ConcurrentHashMapParametrizedCache(arg1);
        }

        return ((ParametrizedSerializerCache)v0);
    }
}

