package com.TryJeanPc.goldenmouse;

import com.TryJeanPc.goldenmouse.activation.ActivationStatus;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B9\u0012\u0012\u0010\u0002\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u001C\u0010\u0006\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\n\u0010\u000BJ4\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u001C\u0010\u0011\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0086@¢\u0006\u0002\u0010\u0013R\u001A\u0010\u0002\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/StartRequirementEvaluator;", "", "readRequirements", "Lkotlin/Function0;", "", "Lcom/TryJeanPc/goldenmouse/EvaluatedRequirement;", "revalidateCore", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/TryJeanPc/goldenmouse/activation/ActivationStatus;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "runIfReady", "Lcom/TryJeanPc/goldenmouse/StartEvaluation;", "gameSelected", "", "onReady", "", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StartRequirementEvaluator {
    public static final int $stable = 8;
    private final Function0 readRequirements;
    private final Function1 revalidateCore;

    static {
    }

    public StartRequirementEvaluator(Function0 arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "readRequirements");
        Intrinsics.checkNotNullParameter(arg3, "revalidateCore");
        super();
        this.readRequirements = arg2;
        this.revalidateCore = arg3;
    }

    public static final Function1 access$getRevalidateCore$p(StartRequirementEvaluator arg0) {
        return arg0.revalidateCore;
    }

    public final Object runIfReady(boolean arg8, Function1 arg9, Continuation arg10) {
        Object v7;
        Object v9;
        StartEvaluation v10_2;
        int v2;
        Continuation v0;
        if((arg10 instanceof StartRequirementEvaluator$runIfReady$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((StartRequirementEvaluator$runIfReady$1)v0).label & v2) != 0) {
                ((StartRequirementEvaluator$runIfReady$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            StartRequirementEvaluator$runIfReady$1 v0_1 = new StartRequirementEvaluator$runIfReady$1(this, arg10);
        }

        Object v10 = ((StartRequirementEvaluator$runIfReady$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((StartRequirementEvaluator$runIfReady$1)v0).label;
        Continuation v3 = null;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            try {
                StartRequirementEvaluator$runIfReady$core$1 v10_1 = new StartRequirementEvaluator$runIfReady$core$1(this, v3);
                ((StartRequirementEvaluator$runIfReady$1)v0).L$0 = arg9;
                ((StartRequirementEvaluator$runIfReady$1)v0).Z$0 = arg8;
                ((StartRequirementEvaluator$runIfReady$1)v0).label = 1;
                v10 = TimeoutKt.withTimeoutOrNull(5000, ((Function2)v10_1), v0);
                if(v10 != v1) {
                    goto label_46;
                }
            }
            catch(Exception ) {
            label_47:
                v10_2 = new StartEvaluation(((ActivationStatus)v3), this.readRequirements.invoke(), arg8);
                JobKt.ensureActive(v0.getContext());
                if(v10_2.getCanStart()) {
                    ((StartRequirementEvaluator$runIfReady$1)v0).L$0 = SpillingKt.nullOutSpilledVariable(v9);
                    ((StartRequirementEvaluator$runIfReady$1)v0).L$1 = SpillingKt.nullOutSpilledVariable(v3);
                    ((StartRequirementEvaluator$runIfReady$1)v0).L$2 = v10_2;
                    ((StartRequirementEvaluator$runIfReady$1)v0).Z$0 = arg8;
                    ((StartRequirementEvaluator$runIfReady$1)v0).label = v4;
                    if(((Function1)v9).invoke(v0) == v1) {
                        return v1;
                    }
                    else {
                        goto label_65;
                    }
                }

                return v10;
            }
            catch(CancellationException v7_1) {
            label_69:
                throw v7_1;
            }

            return v1;
        label_65:
            StartEvaluation v7_2 = v10_2;
        label_66:
            v10 = v7;
        }
        else if(v2 == 1) {
            arg8 = ((StartRequirementEvaluator$runIfReady$1)v0).Z$0;
            v9 = ((StartRequirementEvaluator$runIfReady$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
            label_46:
                Object v3_1 = v10;
                goto label_47;
            }
            catch(CancellationException v7_1) {
                goto label_69;
            }
            catch(Exception ) {
                goto label_47;
            }
        }
        else if(v2 == v4) {
            v7 = ((StartRequirementEvaluator$runIfReady$1)v0).L$2;
            ResultKt.throwOnFailure(v10);
            goto label_66;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return v10;
    }
}

