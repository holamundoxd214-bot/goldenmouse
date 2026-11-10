package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\f\u001A\u00020\r2\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001A\u00020\u00078F¢\u0006\f\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2={"Lkotlinx/coroutines/selects/OnTimeout;", "", "timeMillis", "", "<init>", "(J)V", "selectClause", "Lkotlinx/coroutines/selects/SelectClause0;", "getSelectClause$annotations", "()V", "getSelectClause", "()Lkotlinx/coroutines/selects/SelectClause0;", "register", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long arg1) {
        super();
        this.timeMillis = arg1;
    }

    public static final void access$register(OnTimeout arg0, SelectInstance arg1, Object arg2) {
        arg0.register(arg1, arg2);
    }

    public final SelectClause0 getSelectClause() {
        OnTimeout$selectClause$1 v1 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause0Impl(this, TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3), null, 4, null);
    }

    public static void getSelectClause$annotations() {
    }

    private final void register(SelectInstance arg5, Object arg6) {
        if(this.timeMillis <= 0) {
            arg5.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }

        OnTimeout$$ExternalSyntheticLambda0 v6 = new OnTimeout$$ExternalSyntheticLambda0(arg5, this);
        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        CoroutineContext v0 = ((SelectImplementation)arg5).getContext();
        ((SelectImplementation)arg5).disposeOnCompletion(DelayKt.getDelay(v0).invokeOnTimeout(this.timeMillis, ((Runnable)v6), v0));
    }

    static final void register$lambda$0(SelectInstance arg1, OnTimeout arg2) {
        arg1.trySelect(arg2, Unit.INSTANCE);
    }
}

