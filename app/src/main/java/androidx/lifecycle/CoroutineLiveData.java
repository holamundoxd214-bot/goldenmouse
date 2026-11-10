package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BT\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u00127\u0010\u0007\u001A3\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\u000E¢\u0006\u0002\b\r¢\u0006\u0004\b\u000F\u0010\u0010J\u001E\u0010\u0015\u001A\u00020\u00162\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0080@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u000BH\u0080@¢\u0006\u0004\b\u001C\u0010\u001DJ\b\u0010\u001E\u001A\u00020\u000BH\u0014J\b\u0010\u001F\u001A\u00020\u000BH\u0014R\u0016\u0010\u0011\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/lifecycle/Block;", "<init>", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSource", "clearSource$lifecycle_livedata", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CoroutineLiveData extends MediatorLiveData {
    private BlockRunner blockRunner;
    private EmittedSource emittedSource;

    public CoroutineLiveData(CoroutineContext arg8, long arg9, Function2 arg11) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        Intrinsics.checkNotNullParameter(arg11, "block");
        super();
        this.blockRunner = new BlockRunner(this, arg11, arg9, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(arg8).plus(SupervisorKt.SupervisorJob(arg8.get(Job.Key)))), new CoroutineLiveData$$ExternalSyntheticLambda0(this));
    }

    public CoroutineLiveData(CoroutineContext arg1, long arg2, Function2 arg4, int arg5, DefaultConstructorMarker arg6) {
        EmptyCoroutineContext v1;
        if((arg5 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg5 & 2) != 0) {
            arg2 = 5000;
        }

        this(((CoroutineContext)v1), arg2, arg4);
    }

    static final Unit _init_$lambda$0(CoroutineLiveData arg1) {
        arg1.blockRunner = null;
        return Unit.INSTANCE;
    }

    public final Object clearSource$lifecycle_livedata(Continuation arg5) {
        int v2;
        Continuation v0;
        if((arg5 instanceof CoroutineLiveData$clearSource$1)) {
            v0 = arg5;
            v2 = 0x80000000;
            if((((CoroutineLiveData$clearSource$1)v0).label & v2) != 0) {
                ((CoroutineLiveData$clearSource$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            CoroutineLiveData$clearSource$1 v0_1 = new CoroutineLiveData$clearSource$1(this, arg5);
        }

        Object v5 = ((CoroutineLiveData$clearSource$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((CoroutineLiveData$clearSource$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            EmittedSource v5_1 = this.emittedSource;
            if(v5_1 != null) {
                ((CoroutineLiveData$clearSource$1)v0).label = 1;
                if(v5_1.disposeNow(v0) == v1) {
                    return v1;
                }
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v5);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.emittedSource = null;
        return Unit.INSTANCE;
    }

    public final Object emitSource$lifecycle_livedata(LiveData arg6, Continuation arg7) {
        Object v6;
        int v2;
        Continuation v0;
        if((arg7 instanceof CoroutineLiveData$emitSource$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((CoroutineLiveData$emitSource$1)v0).label & v2) != 0) {
                ((CoroutineLiveData$emitSource$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            CoroutineLiveData$emitSource$1 v0_1 = new CoroutineLiveData$emitSource$1(this, arg7);
        }

        Object v7 = ((CoroutineLiveData$emitSource$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((CoroutineLiveData$emitSource$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            ((CoroutineLiveData$emitSource$1)v0).L$0 = arg6;
            ((CoroutineLiveData$emitSource$1)v0).label = 1;
            if(this.clearSource$lifecycle_livedata(v0) == v1) {
                return v1;
            }
            else {
            label_36:
                ((CoroutineLiveData$emitSource$1)v0).L$0 = null;
                ((CoroutineLiveData$emitSource$1)v0).label = v3;
                v7 = CoroutineLiveDataKt.addDisposableSource(this, ((LiveData)v6), v0);
                if(v7 == v1) {
                    return v1;
                }
            }
        }
        else if(v2 == 1) {
            v6 = ((CoroutineLiveData$emitSource$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
            goto label_36;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.emittedSource = ((EmittedSource)v7);
        return v7;
    }

    protected void onActive() {
        super.onActive();
        BlockRunner v0 = this.blockRunner;
        if(v0 != null) {
            v0.maybeRun();
        }
    }

    protected void onInactive() {
        super.onInactive();
        BlockRunner v0 = this.blockRunner;
        if(v0 != null) {
            v0.cancel();
        }
    }
}

