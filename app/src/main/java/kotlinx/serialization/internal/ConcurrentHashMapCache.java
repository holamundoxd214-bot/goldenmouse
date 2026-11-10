package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\'\u0012\u001E\u0010\u0003\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001E\u0010\r\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0005H\u0016J\u0014\u0010\u0010\u001A\u00020\u00112\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0016R&\u0010\u0003\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001A\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lkotlinx/serialization/internal/ConcurrentHashMapCache;", "T", "Lkotlinx/serialization/internal/SerializerCache;", "compute", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/CacheEntry;", "get", "key", "", "isStored", "", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ConcurrentHashMapCache implements SerializerCache {
    private final ConcurrentHashMap cache;
    private final Function1 compute;

    public ConcurrentHashMapCache(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "compute");
        super();
        this.compute = arg2;
        this.cache = new ConcurrentHashMap();
    }

    public KSerializer get(KClass arg4) {
        Intrinsics.checkNotNullParameter(arg4, "key");
        ConcurrentHashMap v0 = this.cache;
        Class v1 = JvmClassMappingKt.getJavaClass(arg4);
        Object v2 = ((ConcurrentMap)v0).get(v1);
        if(v2 == null) {
            CacheEntry v2_1 = new CacheEntry(this.compute.invoke(arg4));
            Object v3 = ((ConcurrentMap)v0).putIfAbsent(v1, v2_1);
            if(v3 == null) {
            }
            else {
                v2 = v3;
            }
        }

        return ((CacheEntry)v2).serializer;
    }

    public boolean isStored(KClass arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.cache.containsKey(JvmClassMappingKt.getJavaClass(arg2));
    }
}

