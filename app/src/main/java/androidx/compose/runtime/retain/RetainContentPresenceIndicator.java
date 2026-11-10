package androidx.compose.runtime.retain;

import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0017H\u0016J\b\u0010\u0019\u001A\u00020\u0017H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u0014\u0010\u0015¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/retain/RetainContentPresenceIndicator;", "Landroidx/compose/runtime/RememberObserver;", "store", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "composer", "Landroidx/compose/runtime/Composer;", "<init>", "(Landroidx/compose/runtime/retain/RetainedValuesStore;Landroidx/compose/runtime/Composer;)V", "<set-?>", "getComposer", "()Landroidx/compose/runtime/Composer;", "setComposer", "(Landroidx/compose/runtime/Composer;)V", "composer$delegate", "Landroidx/compose/runtime/MutableState;", "didEnterComposition", "", "value", "Landroidx/compose/runtime/CancellationHandle;", "enterCompositionCancellationHandle", "setEnterCompositionCancellationHandle", "(Landroidx/compose/runtime/CancellationHandle;)V", "onRemembered", "", "onForgotten", "onAbandoned", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) final class RetainContentPresenceIndicator implements RememberObserver {
    private final MutableState composer$delegate;
    private boolean didEnterComposition;
    private CancellationHandle enterCompositionCancellationHandle;
    private final RetainedValuesStore store;

    public RetainContentPresenceIndicator(RetainedValuesStore arg2, Composer arg3) {
        super();
        this.store = arg2;
        this.composer$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
    }

    public final Composer getComposer() {
        return this.composer$delegate.getValue();
    }

    public void onAbandoned() {
        CancellationHandle v0 = this.enterCompositionCancellationHandle;
        if(v0 != null) {
            v0.cancel();
        }
    }

    public void onForgotten() {
        CancellationHandle v0 = this.enterCompositionCancellationHandle;
        if(v0 != null) {
            v0.cancel();
        }

        if(this.didEnterComposition) {
            this.store.onContentExitComposition();
            this.didEnterComposition = false;
        }
    }

    public void onRemembered() {
        this.setEnterCompositionCancellationHandle(this.getComposer().scheduleFrameEndCallback(new RetainContentPresenceIndicator$$ExternalSyntheticLambda0(this)));
    }

    static final Unit onRemembered$lambda$0(RetainContentPresenceIndicator arg1) {
        arg1.didEnterComposition = true;
        arg1.store.onContentEnteredComposition();
        return Unit.INSTANCE;
    }

    public final void setComposer(Composer arg1) {
        this.composer$delegate.setValue(arg1);
    }

    private final void setEnterCompositionCancellationHandle(CancellationHandle arg2) {
        CancellationHandle v0 = this.enterCompositionCancellationHandle;
        if(v0 != null) {
            v0.cancel();
        }

        this.enterCompositionCancellationHandle = arg2;
    }
}

