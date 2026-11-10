package androidx.compose.runtime;

import androidx.compose.runtime.composer.DebugStringFormattable;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H&J.\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\b2\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH&J\b\u0010\u000F\u001A\u00020\u0010H&J\u0006\u0010\u0011\u001A\u00020\u0010¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/Changes;", "Landroidx/compose/runtime/composer/DebugStringFormattable;", "<init>", "()V", "clear", "", "execute", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "applier", "Landroidx/compose/runtime/Applier;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "isEmpty", "", "isNotEmpty", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Changes extends DebugStringFormattable {
    public static final int $stable;

    static {
    }

    public Changes() {
        super();
    }

    public abstract void clear();

    public abstract void execute(SlotStorage arg1, Applier arg2, RememberManager arg3, CompositionErrorContextImpl arg4);

    public abstract boolean isEmpty();

    public final boolean isNotEmpty() {
        return this.isEmpty() ^ 1;
    }
}

