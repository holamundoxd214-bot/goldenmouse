package androidx.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u001C\u0010\u0003\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086H¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FullyDrawnReporterKt {
    public static final Object reportWhenComplete(FullyDrawnReporter arg4, Function1 arg5, Continuation arg6) {
        Object v4;
        int v2;
        Continuation v0;
        if((arg6 instanceof FullyDrawnReporterKt$reportWhenComplete$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((FullyDrawnReporterKt$reportWhenComplete$1)v0).label & v2) != 0) {
                ((FullyDrawnReporterKt$reportWhenComplete$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            FullyDrawnReporterKt$reportWhenComplete$1 v0_1 = new FullyDrawnReporterKt$reportWhenComplete$1(arg6);
        }

        Object v6 = ((FullyDrawnReporterKt$reportWhenComplete$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((FullyDrawnReporterKt$reportWhenComplete$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            arg4.addReporter();
            if(arg4.isFullyDrawnReported()) {
                return Unit.INSTANCE;
            }
            else {
                try {
                    ((FullyDrawnReporterKt$reportWhenComplete$1)v0).L$0 = arg4;
                    ((FullyDrawnReporterKt$reportWhenComplete$1)v0).label = 1;
                    if(arg5.invoke(v0) != v1) {
                        goto label_37;
                    }
                }
                catch(Throwable v5) {
                label_41:
                    ((FullyDrawnReporter)v4).removeReporter();
                    throw v5;
                }

                return v1;
            }
        }
        else if(v2 == 1) {
            v4 = ((FullyDrawnReporterKt$reportWhenComplete$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v5) {
                goto label_41;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_37:
        ((FullyDrawnReporter)v4).removeReporter();
        return Unit.INSTANCE;
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter arg1, Function1 arg2, Continuation arg3) {
        arg1.addReporter();
        if(arg1.isFullyDrawnReported()) {
            return Unit.INSTANCE;
        }

        try {
            arg2.invoke(arg3);
        }
        catch(Throwable v2) {
            arg1.removeReporter();
            throw v2;
        }

        arg1.removeReporter();
        return Unit.INSTANCE;
    }
}

