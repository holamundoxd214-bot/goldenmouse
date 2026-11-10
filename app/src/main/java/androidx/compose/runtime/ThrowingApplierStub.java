package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\bÁ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001A\u00020\tH\u0016J\u0018\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0016J \u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0016J\b\u0010\u0011\u001A\u00020\tH\u0016J\u001A\u0010\u0012\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002H\u0016J\u001A\u0010\u0014\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0015\u001A\u00020\t2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001A\u00020\tH\u0002R\u0014\u0010\u0005\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/ThrowingApplierStub;", "Landroidx/compose/runtime/Applier;", "", "<init>", "()V", "current", "getCurrent", "()Ljava/lang/Object;", "up", "", "remove", "index", "", "count", "move", "from", "to", "clear", "insertBottomUp", "instance", "insertTopDown", "down", "node", "throwIllegalOperationException", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ThrowingApplierStub implements Applier {
    public static final int $stable;
    public static final ThrowingApplierStub INSTANCE;

    static {
        ThrowingApplierStub.INSTANCE = new ThrowingApplierStub();
    }

    private ThrowingApplierStub() {
        super();
    }

    public void clear() {
        this.throwIllegalOperationException();
    }

    public void down(Object arg1) {
        this.throwIllegalOperationException();
    }

    public Object getCurrent() {
        this.throwIllegalOperationException();
        return Unit.INSTANCE;
    }

    public void insertBottomUp(int arg1, Object arg2) {
        this.throwIllegalOperationException();
    }

    public void insertTopDown(int arg1, Object arg2) {
        this.throwIllegalOperationException();
    }

    public void move(int arg1, int arg2, int arg3) {
        this.throwIllegalOperationException();
    }

    public void remove(int arg1, int arg2) {
        this.throwIllegalOperationException();
    }

    private final void throwIllegalOperationException() {
        ComposerKt.composeImmediateRuntimeError("ChangeList cannot call the Applier when executing pending changes outside of the applier phase.");
    }

    public void up() {
        this.throwIllegalOperationException();
    }
}

