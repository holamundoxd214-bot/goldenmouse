package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A:\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001E\u0010\u0003\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001A*\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0007H\u0086@¢\u0006\u0002\u0010\b\u001A\"\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0004\"\u00020\fH\u0086@¢\u0006\u0002\u0010\r\u001A\u0018\u0010\t\u001A\u00020\n*\b\u0012\u0004\u0012\u00020\f0\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u000E"}, d2={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class AwaitKt {
    public static final Object awaitAll(Collection arg2, Continuation arg3) {
        if(arg2.isEmpty()) {
            return CollectionsKt.emptyList();
        }

        return new AwaitAll(arg2.toArray(new Deferred[0])).await(arg3);
    }

    public static final Object awaitAll(Deferred[] arg1, Continuation arg2) {
        if(arg1.length == 0) {
            return CollectionsKt.emptyList();
        }

        return new AwaitAll(arg1).await(arg2);
    }

    public static final Object joinAll(Collection arg4, Continuation arg5) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg5 instanceof AwaitKt$joinAll$3)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((AwaitKt$joinAll$3)v0).label & v2) != 0) {
                ((AwaitKt$joinAll$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AwaitKt$joinAll$3 v0_1 = new AwaitKt$joinAll$3(arg5);
        }

        Object v5 = ((AwaitKt$joinAll$3)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AwaitKt$joinAll$3)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            Iterator v4_1 = ((Iterable)arg4).iterator();
        }
        else if(v2 == 1) {
            v4 = ((AwaitKt$joinAll$3)v0).L$0;
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        do {
            if(!((Iterator)v4).hasNext()) {
                goto label_36;
            }

            v5 = ((Iterator)v4).next();
            ((AwaitKt$joinAll$3)v0).L$0 = v4;
            ((AwaitKt$joinAll$3)v0).label = 1;
        }
        while(((Job)v5).join(v0) != v1);

        return v1;
    label_36:
        return Unit.INSTANCE;
    }

    public static final Object joinAll(Job[] arg6, Continuation arg7) {
        int v6;
        Job[] v7_1;
        AwaitKt$joinAll$1 v0_1;
        int v2;
        if((arg7 instanceof AwaitKt$joinAll$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((AwaitKt$joinAll$1)v0).label & v2) != 0) {
                ((AwaitKt$joinAll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AwaitKt$joinAll$1(arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            v2 = 0;
            v7_1 = arg6;
            v6 = arg6.length;
            goto label_35;
        label_44:
            ++v2;
        }
        else if(v2 == 1) {
            v6 = v0_1.I$1;
            v2 = v0_1.I$0;
            Object v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
            v7 = v4;
            goto label_44;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_35:
        if(v2 < v6) {
            Job v4_1 = v7_1[v2];
            v0_1.L$0 = v7_1;
            v0_1.I$0 = v2;
            v0_1.I$1 = v6;
            v0_1.label = 1;
            if(v4_1.join(((Continuation)v0_1)) != v1) {
                goto label_44;
            }

            return v1;
        }

        return Unit.INSTANCE;
    }
}

