package androidx.compose.runtime.retain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001A\u00020\u00052\u000E\b\u0004\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/retain/RetainedEffectScope;", "", "<init>", "()V", "onRetire", "Landroidx/compose/runtime/retain/RetainedEffectResult;", "onRetiredEffect", "Lkotlin/Function0;", "", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RetainedEffectScope {
    public static final int $stable;

    static {
    }

    public RetainedEffectScope() {
        super();
    }

    public final RetainedEffectResult onRetire(Function0 arg1) {
        return new RetainedEffectScope$onRetire$1(arg1);
    }
}

