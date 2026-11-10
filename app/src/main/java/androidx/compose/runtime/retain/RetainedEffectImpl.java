package androidx.compose.runtime.retain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\u000BH\u0016J\b\u0010\r\u001A\u00020\u000BH\u0016J\b\u0010\u000E\u001A\u00020\u000BH\u0016J\b\u0010\u000F\u001A\u00020\u000BH\u0016R\u001F\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/retain/RetainedEffectImpl;", "Landroidx/compose/runtime/retain/RetainObserver;", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/retain/RetainedEffectScope;", "Landroidx/compose/runtime/retain/RetainedEffectResult;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onRetire", "onRetained", "", "onRetired", "onEnteredComposition", "onExitedComposition", "onUnused", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) final class RetainedEffectImpl implements RetainObserver {
    private final Function1 effect;
    private RetainedEffectResult onRetire;

    public RetainedEffectImpl(Function1 arg1) {
        super();
        this.effect = arg1;
    }

    public void onEnteredComposition() {
    }

    public void onExitedComposition() {
    }

    public void onRetained() {
        this.onRetire = this.effect.invoke(RetainedEffectKt.access$getInternalRetainedEffectScope$p());
    }

    public void onRetired() {
        RetainedEffectResult v0 = this.onRetire;
        if(v0 != null) {
            v0.retire();
        }

        this.onRetire = null;
    }

    public void onUnused() {
    }
}

