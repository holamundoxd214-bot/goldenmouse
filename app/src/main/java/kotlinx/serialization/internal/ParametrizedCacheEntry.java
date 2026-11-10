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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JE\u0010\u000B\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u000E\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\u000FH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R.\u0010\u0005\u001A\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2={"Lkotlinx/serialization/internal/ParametrizedCacheEntry;", "T", "", "<init>", "()V", "serializers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "computeIfAbsent", "types", "Lkotlin/reflect/KType;", "producer", "Lkotlin/Function0;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) final class ParametrizedCacheEntry {
    private final ConcurrentHashMap serializers;

    public ParametrizedCacheEntry() {
        super();
        this.serializers = new ConcurrentHashMap();
    }

    public static final ConcurrentHashMap access$getSerializers$p(ParametrizedCacheEntry arg0) {
        return arg0.serializers;
    }

    public final Object computeIfAbsent-gIAlu-s(List arg4, Function0 arg5) {
        Result v4_3;
        Intrinsics.checkNotNullParameter(arg4, "types");
        Intrinsics.checkNotNullParameter(arg5, "producer");
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg4), 10));
        Iterator v4 = ((Iterable)arg4).iterator();
        while(v4.hasNext()) {
            ((Collection)v0).add(new KTypeWrapper(v4.next()));
        }

        ConcurrentHashMap v3 = this.serializers;
        Object v4_1 = ((ConcurrentMap)v3).get(v0);
        if(v4_1 == null) {
            try {
                v4_1 = Result.constructor-impl(arg5.invoke());
            }
            catch(Throwable v4_2) {
                v4_1 = Result.constructor-impl(ResultKt.createFailure(v4_2));
            }

            v4_3 = Result.box-impl(v4_1);
            Object v3_1 = ((ConcurrentMap)v3).putIfAbsent(v0, v4_3);
            if(v3_1 == null) {
            }
            else {
                v4_1 = v3_1;
            }
        }

        Intrinsics.checkNotNullExpressionValue(v4_3, "getOrPut(...)");
        return v4_3.unbox-impl();
    }
}

