package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001D\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001C\u0010\u000B\u001A\u00020\f2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0096@¢\u0006\u0002\u0010\u0010J\u000E\u0010\u0011\u001A\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F0\u0014H\u0096\u0003R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0018\u0010\u0015\u001A\u00028\u0000X\u0096\u000F¢\u0006\f\u001A\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/ProduceStateScopeImpl;", "T", "Landroidx/compose/runtime/ProduceStateScope;", "Landroidx/compose/runtime/MutableState;", "state", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/compose/runtime/MutableState;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "awaitDispose", "", "onDispose", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Ljava/lang/Object;", "component2", "Lkotlin/Function1;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class ProduceStateScopeImpl implements MutableState, ProduceStateScope {
    private final CoroutineContext coroutineContext;

    public ProduceStateScopeImpl(MutableState arg1, CoroutineContext arg2) {
        super();
        this.$$delegate_0 = arg1;
        this.coroutineContext = arg2;
    }

    public Object awaitDispose(Function0 arg4, Continuation arg5) {
        Object v4;
        Continuation v0;
        if((arg5 instanceof ProduceStateScopeImpl$awaitDispose$1)) {
            v0 = arg5;
            int v2 = 0x80000000;
            if((((ProduceStateScopeImpl$awaitDispose$1)v0).label & v2) != 0) {
                ((ProduceStateScopeImpl$awaitDispose$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ProduceStateScopeImpl$awaitDispose$1 v0_1 = new ProduceStateScopeImpl$awaitDispose$1(this, arg5);
        }

        Object v3 = ((ProduceStateScopeImpl$awaitDispose$1)v0).result;
        Object v5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((ProduceStateScopeImpl$awaitDispose$1)v0).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v3);
            try {
                ((ProduceStateScopeImpl$awaitDispose$1)v0).L$0 = arg4;
                ((ProduceStateScopeImpl$awaitDispose$1)v0).label = 1;
                CancellableContinuationImpl v1_1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(v0), 1);
                v1_1.initCancellability();
                v3 = v1_1.getResult();
                if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(v0);
                }

                if(v3 == v5) {
                    return v5;
                }

            label_41:
                throw new KotlinNothingValueException();
            }
            catch(Throwable v3_1) {
            label_45:
                ((Function0)v4).invoke();
                throw v3_1;
            }
        }
        else if(v1 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            v4 = ((ProduceStateScopeImpl$awaitDispose$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v3);
                goto label_41;
            }
            catch(Throwable v3_1) {
                goto label_45;
            }
        }

        goto label_41;
    }

    public Object component1() {
        return this.$$delegate_0.component1();
    }

    public Function1 component2() {
        return this.$$delegate_0.component2();
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getValue() {
        return this.$$delegate_0.getValue();
    }

    public void setValue(Object arg1) {
        this.$$delegate_0.setValue(arg1);
    }
}

