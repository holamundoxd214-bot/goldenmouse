package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001F\n\u0002\b\u0002\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001A4\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086@¢\u0006\u0002\u0010\n\u001A8\u0010\u000B\u001A\u0002H\f\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u0002H\fH\u0086@¢\u0006\u0002\u0010\u000E¨\u0006\u000F"}, d2={"toList", "", "T", "Lkotlinx/coroutines/flow/Flow;", "destination", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toCollection", "C", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/flow/FlowKt") final class FlowKt__CollectionKt {
    public static final Object toCollection(Flow arg4, Collection arg5, Continuation arg6) {
        FlowKt__CollectionKt$toCollection$1 v0_1;
        int v2;
        if((arg6 instanceof FlowKt__CollectionKt$toCollection$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((FlowKt__CollectionKt$toCollection$1)v0).label & v2) != 0) {
                ((FlowKt__CollectionKt$toCollection$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new FlowKt__CollectionKt$toCollection$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 != 0) {
            if(v2 == 1) {
                Object v4 = v0_1.L$0;
                ResultKt.throwOnFailure(v6);
                return v4;
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v6);
        FlowKt__CollectionKt$toCollection$2 v6_1 = new FlowKt__CollectionKt$toCollection$2(arg5);
        v0_1.L$0 = arg5;
        v0_1.label = 1;
        if(arg4.collect(((FlowCollector)v6_1), ((Continuation)v0_1)) == v1) {
            return v1;
        }

        return arg5;
    }

    public static final Object toList(Flow arg0, List arg1, Continuation arg2) {
        return FlowKt.toCollection(arg0, ((Collection)arg1), arg2);
    }

    public static Object toList$default(Flow arg0, List arg1, Continuation arg2, int arg3, Object arg4) {
        ArrayList v1;
        if((arg3 & 1) != 0) {
            v1 = new ArrayList();
        }

        return FlowKt.toList(arg0, ((List)v1), arg2);
    }

    public static final Object toSet(Flow arg0, Set arg1, Continuation arg2) {
        return FlowKt.toCollection(arg0, ((Collection)arg1), arg2);
    }

    public static Object toSet$default(Flow arg0, Set arg1, Continuation arg2, int arg3, Object arg4) {
        LinkedHashSet v1;
        if((arg3 & 1) != 0) {
            v1 = new LinkedHashSet();
        }

        return FlowKt.toSet(arg0, ((Set)v1), arg2);
    }
}

