package androidx.compose.ui.platform;

import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000B\u001A\u00020\fJ\u0006\u0010\r\u001A\u00020\fJ\u0006\u0010\u000E\u001A\u00020\fJ\b\u0010\u000F\u001A\u00020\fH\u0016J\b\u0010\u0010\u001A\u00020\fH\u0016J\u001D\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0014\u001A\u0004\u0018\u00010\u0012H\u0096\u0001J\u001B\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0016\u001A\u0004\u0018\u00010\u0012H\u0096\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006\u0017"}, d2={"Landroidx/compose/ui/platform/LifecycleRetainedValuesStore;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "delegate", "Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "<init>", "(Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;)V", "getDelegate", "()Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "isRetainingExitedValues", "", "()Z", "startLifecycleTransition", "", "endLifecycleTransition", "dispose", "onContentEnteredComposition", "onContentExitComposition", "consumeExitedValueOrDefault", "", "key", "defaultValue", "saveExitingValue", "value", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LifecycleRetainedValuesStore implements RetainedValuesStore {
    public static final int $stable;
    private final ManagedRetainedValuesStore delegate;

    static {
        LifecycleRetainedValuesStore.$stable = ManagedRetainedValuesStore.$stable;
    }

    public LifecycleRetainedValuesStore() {
        this(null, 1, null);
    }

    public LifecycleRetainedValuesStore(ManagedRetainedValuesStore arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new ManagedRetainedValuesStore();
        }

        this(arg1);
    }

    public LifecycleRetainedValuesStore(ManagedRetainedValuesStore arg1) {
        super();
        this.delegate = arg1;
        arg1.onContentEnteredComposition();
    }

    public Object consumeExitedValueOrDefault(Object arg1, Object arg2) {
        return this.delegate.consumeExitedValueOrDefault(arg1, arg2);
    }

    public final void dispose() {
        this.delegate.dispose();
    }

    public final void endLifecycleTransition() {
        this.delegate.onContentEnteredComposition();
    }

    public final ManagedRetainedValuesStore getDelegate() {
        return this.delegate;
    }

    public final boolean isRetainingExitedValues() {
        return this.delegate.isRetainingExitedValues();
    }

    public void onContentEnteredComposition() {
    }

    public void onContentExitComposition() {
    }

    public void saveExitingValue(Object arg1, Object arg2) {
        this.delegate.saveExitingValue(arg1, arg2);
    }

    public final void startLifecycleTransition() {
        this.delegate.onContentExitComposition();
    }
}

