package androidx.compose.runtime;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\tH\u0016J\b\u0010\u000B\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2={"Landroidx/compose/runtime/CompositionScopedCoroutineScopeCanceller;", "Landroidx/compose/runtime/RememberObserver;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onRemembered", "", "onForgotten", "onAbandoned", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;

    static {
    }

    public CompositionScopedCoroutineScopeCanceller(CoroutineScope arg1) {
        super();
        this.coroutineScope = arg1;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public void onAbandoned() {
        CoroutineScope v1 = this.coroutineScope;
        if((v1 instanceof RememberedCoroutineScope)) {
            ((RememberedCoroutineScope)v1).cancelIfCreated();
            return;
        }

        CoroutineScopeKt.cancel(v1, new LeftCompositionCancellationException());
    }

    public void onForgotten() {
        CoroutineScope v1 = this.coroutineScope;
        if((v1 instanceof RememberedCoroutineScope)) {
            ((RememberedCoroutineScope)v1).cancelIfCreated();
            return;
        }

        CoroutineScopeKt.cancel(v1, new LeftCompositionCancellationException());
    }

    public void onRemembered() {
    }
}

