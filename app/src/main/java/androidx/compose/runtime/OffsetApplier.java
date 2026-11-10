package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000FJ\b\u0010\u0010\u001A\u00020\rH\u0016J\u001D\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u001D\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0005H\u0016J \u0010\u0018\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0005H\u0016J\b\u0010\u001B\u001A\u00020\rH\u0016J3\u0010\u001C\u001A\u00020\r2\u001F\u0010\u001D\u001A\u001B\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0012\u0004\u0012\u00020\r0\u001E¢\u0006\u0002\b 2\b\u0010!\u001A\u0004\u0018\u00010\u001FH\u0016J\b\u0010\"\u001A\u00020\rH\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006#"}, d2={"Landroidx/compose/runtime/OffsetApplier;", "N", "Landroidx/compose/runtime/Applier;", "applier", "offset", "", "<init>", "(Landroidx/compose/runtime/Applier;I)V", "nesting", "current", "getCurrent", "()Ljava/lang/Object;", "down", "", "node", "(Ljava/lang/Object;)V", "up", "insertTopDown", "index", "instance", "(ILjava/lang/Object;)V", "insertBottomUp", "remove", "count", "move", "from", "to", "clear", "apply", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "value", "reuse", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OffsetApplier implements Applier {
    public static final int $stable = 8;
    private final Applier applier;
    private int nesting;
    private final int offset;

    static {
    }

    public OffsetApplier(Applier arg1, int arg2) {
        super();
        this.applier = arg1;
        this.offset = arg2;
    }

    public void apply(Function2 arg1, Object arg2) {
        this.applier.apply(arg1, arg2);
    }

    public void clear() {
        ComposerKt.composeImmediateRuntimeError("Clear is not valid on OffsetApplier");
    }

    public void down(Object arg2) {
        ++this.nesting;
        this.applier.down(arg2);
    }

    public Object getCurrent() {
        return this.applier.getCurrent();
    }

    public void insertBottomUp(int arg3, Object arg4) {
        Applier v0 = this.applier;
        int v2 = this.nesting == 0 ? this.offset : 0;
        v0.insertBottomUp(arg3 + v2, arg4);
    }

    public void insertTopDown(int arg3, Object arg4) {
        Applier v0 = this.applier;
        int v2 = this.nesting == 0 ? this.offset : 0;
        v0.insertTopDown(arg3 + v2, arg4);
    }

    public void move(int arg2, int arg3, int arg4) {
        int v0 = this.nesting == 0 ? this.offset : 0;
        this.applier.move(arg2 + v0, arg3 + v0, arg4);
    }

    public void remove(int arg3, int arg4) {
        Applier v0 = this.applier;
        int v2 = this.nesting == 0 ? this.offset : 0;
        v0.remove(arg3 + v2, arg4);
    }

    public void reuse() {
        this.applier.reuse();
    }

    public void up() {
        int v0 = this.nesting > 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("OffsetApplier up called with no corresponding down");
        }

        --this.nesting;
        this.applier.up();
    }
}

