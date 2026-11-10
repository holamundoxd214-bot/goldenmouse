package androidx.compose.runtime.retain;

import androidx.compose.runtime.RememberObserver;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B)\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\u0013H\u0016J\b\u0010\u0017\u001A\u00020\u0013H\u0016J\b\u0010\u0018\u001A\u00020\u0013H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u000E\u0010\rR\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/retain/RetainedValueHolder;", "T", "Landroidx/compose/runtime/RememberObserver;", "key", "", "value", "owner", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "isNewlyRetained", "", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/retain/RetainedValuesStore;Z)V", "getKey", "()Ljava/lang/Object;", "getValue", "Ljava/lang/Object;", "getOwner", "()Landroidx/compose/runtime/retain/RetainedValuesStore;", "readoptUnder", "", "newStore", "readoptUnder$runtime_retain", "onRemembered", "onForgotten", "onAbandoned", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RetainedValueHolder implements RememberObserver {
    public static final int $stable = 8;
    private boolean isNewlyRetained;
    private final Object key;
    private RetainedValuesStore owner;
    private final Object value;

    static {
    }

    public RetainedValueHolder(Object arg1, Object arg2, RetainedValuesStore arg3, boolean arg4) {
        super();
        this.key = arg1;
        this.value = arg2;
        this.isNewlyRetained = arg4;
        this.owner = arg3;
        if((arg2 instanceof RememberObserver)) {
            if((arg2 instanceof RetainObserver)) {
            }
            else {
                throw new IllegalArgumentException("Retained a value that implements RememberObserver but not RetainObserver. To receive the correct callbacks, the retained value \'" + arg2 + "\' must also implement RetainObserver.");
            }
        }
    }

    public final Object getKey() {
        return this.key;
    }

    public final RetainedValuesStore getOwner() {
        return this.owner;
    }

    public final Object getValue() {
        return this.value;
    }

    public void onAbandoned() {
        Object v1 = this.value;
        if((v1 instanceof RetainObserver)) {
            ((RetainObserver)v1).onUnused();
        }
    }

    public void onForgotten() {
        Object v0 = this.value;
        if((v0 instanceof RetainObserver)) {
            ((RetainObserver)v0).onExitedComposition();
        }

        this.owner.saveExitingValue(this.key, this.value);
    }

    public void onRemembered() {
        Object v0 = this.value;
        if((v0 instanceof RetainObserver)) {
            if(this.isNewlyRetained) {
                this.isNewlyRetained = false;
                ((RetainObserver)v0).onRetained();
            }

            this.value.onEnteredComposition();
        }
    }

    public final void readoptUnder$runtime_retain(RetainedValuesStore arg1) {
        this.owner = arg1;
    }
}

