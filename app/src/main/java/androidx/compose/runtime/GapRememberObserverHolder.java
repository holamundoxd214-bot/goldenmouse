package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\u0002\u001A\u00020\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/GapRememberObserverHolder;", "Landroidx/compose/runtime/RememberObserverHolder;", "wrapped", "Landroidx/compose/runtime/RememberObserver;", "afterGroupIndex", "", "<init>", "(Landroidx/compose/runtime/RememberObserver;I)V", "getWrapped", "()Landroidx/compose/runtime/RememberObserver;", "setWrapped", "(Landroidx/compose/runtime/RememberObserver;)V", "getAfterGroupIndex", "()I", "setAfterGroupIndex", "(I)V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class GapRememberObserverHolder implements RememberObserverHolder {
    public static final int $stable = 8;
    private int afterGroupIndex;
    private RememberObserver wrapped;

    static {
    }

    public GapRememberObserverHolder(RememberObserver arg1, int arg2) {
        super();
        this.wrapped = arg1;
        this.afterGroupIndex = arg2;
    }

    public final int getAfterGroupIndex() {
        return this.afterGroupIndex;
    }

    public RememberObserver getWrapped() {
        return this.wrapped;
    }

    public final void setAfterGroupIndex(int arg1) {
        this.afterGroupIndex = arg1;
    }

    public void setWrapped(RememberObserver arg1) {
        this.wrapped = arg1;
    }
}

