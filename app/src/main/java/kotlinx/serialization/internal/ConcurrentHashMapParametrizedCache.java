package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B5\u0012,\u0010\u0003\u001A(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0004\b\n\u0010\u000BJ9\u0010\u0010\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R4\u0010\u0003\u001A(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001A\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ConcurrentHashMapParametrizedCache implements ParametrizedSerializerCache {
    private final ConcurrentHashMap cache;
    private final Function2 compute;

    public ConcurrentHashMapParametrizedCache(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "compute");
        super();
        this.compute = arg2;
        this.cache = new ConcurrentHashMap();
    }

    public Object get-gIAlu-s(KClass arg6, List arg7) {
        Object v5_1;
        ParametrizedCacheEntry v2_1;
        Intrinsics.checkNotNullParameter(arg6, "key");
        Intrinsics.checkNotNullParameter(arg7, "types");
        ConcurrentHashMap v0 = this.cache;
        Class v1 = JvmClassMappingKt.getJavaClass(arg6);
        Object v2 = ((ConcurrentMap)v0).get(v1);
        if(v2 == null) {
            v2_1 = new ParametrizedCacheEntry();
            Object v0_1 = ((ConcurrentMap)v0).putIfAbsent(v1, v2_1);
            if(v0_1 == null) {
            }
            else {
                v2 = v0_1;
            }
        }

        ArrayList v1_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arg7, 10));
        Iterator v0_2 = arg7.iterator();
        while(v0_2.hasNext()) {
            ((Collection)v1_1).add(new KTypeWrapper(v0_2.next()));
        }

        v0 = ParametrizedCacheEntry.access$getSerializers$p(v2_1);
        v2 = ((ConcurrentMap)v0).get(v1_1);
        if(v2 == null) {
            try {
                v5_1 = Result.constructor-impl(this.compute.invoke(arg6, arg7));
            }
            catch(Throwable v5) {
                v5_1 = Result.constructor-impl(ResultKt.createFailure(v5));
            }

            Result v5_2 = Result.box-impl(v5_1);
            Object v6 = ((ConcurrentMap)v0).putIfAbsent(v1_1, v5_2);
            if(v6 == null) {
                Result v2_2 = v5_2;
            }
            else {
                v2 = v6;
            }
        }

        Intrinsics.checkNotNullExpressionValue(v2, "getOrPut(...)");
        return ((Result)v2).unbox-impl();
    }
}

