package androidx.compose.runtime.retain;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\tH\u0016J\b\u0010\u000B\u001A\u00020\tH\u0016J\b\u0010\f\u001A\u00020\tH\u0016J\b\u0010\r\u001A\u00020\tH\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/retain/RetainManagedRetainedValuesStoreWrapper;", "Landroidx/compose/runtime/retain/RetainObserver;", "<init>", "()V", "retainedValuesStore", "Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "getRetainedValuesStore", "()Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "onRetained", "", "onEnteredComposition", "onExitedComposition", "onRetired", "onUnused", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) final class RetainManagedRetainedValuesStoreWrapper implements RetainObserver {
    private final ManagedRetainedValuesStore retainedValuesStore;

    public RetainManagedRetainedValuesStoreWrapper() {
        super();
        this.retainedValuesStore = new ManagedRetainedValuesStore();
    }

    public final ManagedRetainedValuesStore getRetainedValuesStore() {
        return this.retainedValuesStore;
    }

    public void onEnteredComposition() {
    }

    public void onExitedComposition() {
    }

    public void onRetained() {
    }

    public void onRetired() {
        this.retainedValuesStore.dispose();
    }

    public void onUnused() {
        this.retainedValuesStore.dispose();
    }
}

