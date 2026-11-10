package com.TryJeanPc.goldenmouse.zayonvisual;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000ER\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationCheck;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationCheckState;", "status", "Lkotlinx/coroutines/flow/StateFlow;", "getStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "check", "", "kadb", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenActivationCheck extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow state;
    private final StateFlow status;

    static {
    }

    public GoldenActivationCheck() {
        super();
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(new GoldenActivationCheckState(false, null, 3, null));
        this.state = v0;
        this.status = FlowKt.asStateFlow(v0);
    }

    public static final MutableStateFlow access$getState$p(GoldenActivationCheck arg0) {
        return arg0.state;
    }

    public final void check(boolean arg12) {
        if(this.state.getValue().getBusy()) {
            return;
        }

        this.state.setValue(new GoldenActivationCheckState(true, null, 2, null));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GoldenActivationCheck$check$1(arg12, this, null), 3, null);
    }

    public final StateFlow getStatus() {
        return this.status;
    }
}

