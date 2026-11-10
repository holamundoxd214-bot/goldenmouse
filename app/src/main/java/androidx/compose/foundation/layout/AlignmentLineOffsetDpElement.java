package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\f\u0010\u001A\u001A\u00020\u000B*\u00020\nH\u0016J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\b\u0010\u001F\u001A\u00020 H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\"\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2={"Landroidx/compose/foundation/layout/AlignmentLineOffsetDpElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AlignmentLineOffsetDpNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-D9Ej5fM", "()F", "F", "getAfter-D9Ej5fM", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "equals", "", "other", "", "hashCode", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AlignmentLineOffsetDpElement extends ModifierNodeElement {
    private final float after;
    private final AlignmentLine alignmentLine;
    private final float before;
    private final Function1 inspectorInfo;

    public AlignmentLineOffsetDpElement(AlignmentLine arg1, float arg2, float arg3, Function1 arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private AlignmentLineOffsetDpElement(AlignmentLine arg2, float arg3, float arg4, Function1 arg5) {
        super();
        this.alignmentLine = arg2;
        this.before = arg3;
        this.after = arg4;
        this.inspectorInfo = arg5;
        int v5 = 0;
        int v2 = Float.compare(arg3, 0f) >= 0 || (Float.isNaN(arg3)) ? 1 : 0;
        if(arg4 >= 0f || (Float.isNaN(arg4))) {
            v5 = 1;
        }

        if((v2 & v5) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding from alignment line must be a non-negative number");
        }
    }

    public AlignmentLineOffsetDpNode create() {
        return new AlignmentLineOffsetDpNode(this.alignmentLine, this.before, this.after, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((AlignmentLineOffsetDpElement)arg5))) {
            return 1;
        }

        if((arg5 instanceof AlignmentLineOffsetDpElement)) {
        }
        else {
            AlignmentLineOffsetDpElement v5 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Intrinsics.areEqual(this.alignmentLine, v5.alignmentLine)) && (Dp.equals-impl0(this.before, v5.before)) && (Dp.equals-impl0(this.after, v5.after))) {
            return 1;
        }

        return 0;
    }

    public final float getAfter-D9Ej5fM() {
        return this.after;
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    public final float getBefore-D9Ej5fM() {
        return this.before;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public int hashCode() {
        return (this.alignmentLine.hashCode() * 0x1F + Dp.hashCode-impl(this.before)) * 0x1F + Dp.hashCode-impl(this.after);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(AlignmentLineOffsetDpNode arg2) {
        arg2.setAlignmentLine(this.alignmentLine);
        arg2.setBefore-0680j_4(this.before);
        arg2.setAfter-0680j_4(this.after);
    }

    public void update(Node arg1) {
        this.update(((AlignmentLineOffsetDpNode)arg1));
    }
}

