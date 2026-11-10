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

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B5\u0012,\u0010\u0003\u001A(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0004\b\n\u0010\u000BJ9\u0010\u000F\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R4\u0010\u0003\u001A(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lkotlinx/serialization/internal/ClassValueParametrizedCache;", "T", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lkotlin/Function2;", "Lkotlin/reflect/KClass;", "", "", "Lkotlin/reflect/KType;", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "classValue", "Lkotlinx/serialization/internal/ClassValueReferences;", "Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lkotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ClassValueParametrizedCache implements ParametrizedSerializerCache {
    private final ClassValueReferences classValue;
    private final Function2 compute;

    public ClassValueParametrizedCache(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "compute");
        super();
        this.compute = arg2;
        this.classValue = new ClassValueReferences();
    }

    public Object get-gIAlu-s(KClass arg6, List arg7) {
        Object v5_1;
        Intrinsics.checkNotNullParameter(arg6, "key");
        Intrinsics.checkNotNullParameter(arg7, "types");
        Object v0 = this.classValue.get(JvmClassMappingKt.getJavaClass(arg6));
        Intrinsics.checkNotNullExpressionValue(v0, "get(...)");
        Object v1 = ((MutableSoftReference)v0).reference.get();
        if(v1 != null) {
        }
        else {
            v1 = ((MutableSoftReference)v0).getOrSetWithLock(new ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1());
        }

        ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arg7, 10));
        Iterator v0_1 = arg7.iterator();
        while(v0_1.hasNext()) {
            ((Collection)v2).add(new KTypeWrapper(v0_1.next()));
        }

        ConcurrentHashMap v0_2 = ParametrizedCacheEntry.access$getSerializers$p(((ParametrizedCacheEntry)v1));
        v1 = ((ConcurrentMap)v0_2).get(v2);
        if(v1 == null) {
            try {
                v5_1 = Result.constructor-impl(this.compute.invoke(arg6, arg7));
            }
            catch(Throwable v5) {
                v5_1 = Result.constructor-impl(ResultKt.createFailure(v5));
            }

            Result v5_2 = Result.box-impl(v5_1);
            Object v6 = ((ConcurrentMap)v0_2).putIfAbsent(v2, v5_2);
            if(v6 == null) {
                Result v1_1 = v5_2;
            }
            else {
                v1 = v6;
            }
        }

        Intrinsics.checkNotNullExpressionValue(v1, "getOrPut(...)");
        return ((Result)v1).unbox-impl();
    }
}

