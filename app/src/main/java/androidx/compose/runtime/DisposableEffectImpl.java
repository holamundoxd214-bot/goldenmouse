package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\u000BH\u0016J\b\u0010\r\u001A\u00020\u000BH\u0016R\u001F\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/DisposableEffectImpl;", "Landroidx/compose/runtime/RememberObserver;", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectScope;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onDispose", "onRemembered", "", "onForgotten", "onAbandoned", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class DisposableEffectImpl implements RememberObserver {
    private final Function1 effect;
    private DisposableEffectResult onDispose;

    public DisposableEffectImpl(Function1 arg1) {
        super();
        this.effect = arg1;
    }

    public void onAbandoned() {
    }

    public void onForgotten() {
        DisposableEffectResult v0 = this.onDispose;
        if(v0 != null) {
            v0.dispose();
        }

        this.onDispose = null;
    }

    public void onRemembered() {
        this.onDispose = this.effect.invoke(EffectsKt.access$getInternalDisposableEffectScope$p());
    }
}

