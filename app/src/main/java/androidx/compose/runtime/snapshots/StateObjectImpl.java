package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.AtomicInt;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/StateObject;", "<init>", "()V", "readerKind", "Landroidx/compose/runtime/internal/AtomicInt;", "recordReadIn", "", "reader", "Landroidx/compose/runtime/snapshots/ReaderKind;", "recordReadIn-h_f27i8$runtime", "(I)V", "isReadIn", "", "isReadIn-h_f27i8$runtime", "(I)Z", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class StateObjectImpl implements StateObject {
    public static final int $stable = 8;
    private final AtomicInt readerKind;

    static {
    }

    public StateObjectImpl() {
        super();
        this.readerKind = new AtomicInt(0);
    }

    public final boolean isReadIn-h_f27i8$runtime(int arg1) {
        if((ReaderKind.constructor-impl(this.readerKind.get()) & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public final void recordReadIn-h_f27i8$runtime(int arg4) {
        do {
            int v0 = ReaderKind.constructor-impl(this.readerKind.get());
            if((v0 & arg4) != 0) {
                return;
            }
        }
        while(!this.readerKind.compareAndSet(v0, ReaderKind.constructor-impl(v0 | arg4)));
    }
}

