package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\'\u0012\u001E\u0010\u0003\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001E\u0010\u000E\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J\u0014\u0010\u0011\u001A\u00020\u00122\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016R)\u0010\u0003\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lkotlinx/serialization/internal/ClassValueCache;", "T", "Lkotlinx/serialization/internal/SerializerCache;", "compute", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getCompute", "()Lkotlin/jvm/functions/Function1;", "classValue", "Lkotlinx/serialization/internal/ClassValueReferences;", "Lkotlinx/serialization/internal/CacheEntry;", "get", "key", "", "isStored", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ClassValueCache implements SerializerCache {
    private final ClassValueReferences classValue;
    private final Function1 compute;

    public ClassValueCache(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "compute");
        super();
        this.compute = arg2;
        this.classValue = new ClassValueReferences();
    }

    public KSerializer get(KClass arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Object v0 = this.classValue.get(JvmClassMappingKt.getJavaClass(arg3));
        Intrinsics.checkNotNullExpressionValue(v0, "get(...)");
        Object v1 = ((MutableSoftReference)v0).reference.get();
        if(v1 != null) {
        }
        else {
            v1 = ((MutableSoftReference)v0).getOrSetWithLock(new ClassValueCache$get$$inlined$getOrSet$1(this, arg3));
        }

        return ((CacheEntry)v1).serializer;
    }

    public final Function1 getCompute() {
        return this.compute;
    }

    public boolean isStored(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.classValue.isStored(JvmClassMappingKt.getJavaClass(arg2));
    }
}

