package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000B\u001A\u00020\u0006J\f\u0010\f\u001A\u00020\u0006*\u00020\rH&R(\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0001\u0003\u000E\u000F\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/graphics/vector/VNode;", "", "<init>", "()V", "invalidateListener", "Lkotlin/Function1;", "", "getInvalidateListener$ui", "()Lkotlin/jvm/functions/Function1;", "setInvalidateListener$ui", "(Lkotlin/jvm/functions/Function1;)V", "invalidate", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class VNode {
    public static final int $stable = 8;
    private Function1 invalidateListener;

    static {
    }

    private VNode() {
        super();
    }

    public VNode(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract void draw(DrawScope arg1);

    public Function1 getInvalidateListener$ui() {
        return this.invalidateListener;
    }

    public final void invalidate() {
        Function1 v0 = this.getInvalidateListener$ui();
        if(v0 != null) {
            v0.invoke(this);
        }
    }

    public void setInvalidateListener$ui(Function1 arg1) {
        this.invalidateListener = arg1;
    }
}

