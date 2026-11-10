package androidx.compose.ui.draw;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\"\b\u0000\u0012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bR+\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\b¨\u0006\f"}, d2={"Landroidx/compose/ui/draw/DrawResult;", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getBlock$ui", "()Lkotlin/jvm/functions/Function1;", "setBlock$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawResult {
    public static final int $stable = 8;
    private Function1 block;

    static {
    }

    public DrawResult(Function1 arg1) {
        super();
        this.block = arg1;
    }

    public final Function1 getBlock$ui() {
        return this.block;
    }

    public final void setBlock$ui(Function1 arg1) {
        this.block = arg1;
    }
}

