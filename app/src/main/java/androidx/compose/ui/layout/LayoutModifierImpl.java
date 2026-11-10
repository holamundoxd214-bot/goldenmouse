package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B,\u0012#\u0010\u0003\u001A\u001F\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\u000F\u001A\u00020\b*\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001A\u00020\u0015H\u0016R7\u0010\u0003\u001A\u001F\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000B¨\u0006\u0016"}, d2={"Landroidx/compose/ui/layout/LayoutModifierImpl;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock", "measure", "measurable", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutModifierImpl extends Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private Function3 measureBlock;

    static {
    }

    public LayoutModifierImpl(Function3 arg1) {
        super();
        this.measureBlock = arg1;
    }

    public final Function3 getMeasureBlock() {
        return this.measureBlock;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg1, Measurable arg2, long arg3) {
        return this.measureBlock.invoke(arg1, arg2, Constraints.box-impl(arg3));
    }

    public final void setMeasureBlock(Function3 arg1) {
        this.measureBlock = arg1;
    }

    public String toString() {
        return "LayoutModifierImpl(measureBlock=" + this.measureBlock + ')';
    }
}

