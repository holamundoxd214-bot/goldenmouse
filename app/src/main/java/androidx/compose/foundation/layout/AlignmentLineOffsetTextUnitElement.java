package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0017\u001A\u00020\u0002H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\f\u0010\u001E\u001A\u00020\u000B*\u00020\nH\u0016J\u0010\u0010\u001F\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u0002H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\"\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2={"Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AlignmentLineOffsetTextUnitNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/TextUnit;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/layout/AlignmentLine;JJLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-XSAIIZE", "()J", "J", "getAfter-XSAIIZE", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "update", "node", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AlignmentLineOffsetTextUnitElement extends ModifierNodeElement {
    private final long after;
    private final AlignmentLine alignmentLine;
    private final long before;
    private final Function1 inspectorInfo;

    public AlignmentLineOffsetTextUnitElement(AlignmentLine arg1, long arg2, long arg4, Function1 arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg4, arg6);
    }

    private AlignmentLineOffsetTextUnitElement(AlignmentLine arg1, long arg2, long arg4, Function1 arg6) {
        super();
        this.alignmentLine = arg1;
        this.before = arg2;
        this.after = arg4;
        this.inspectorInfo = arg6;
    }

    public AlignmentLineOffsetTextUnitNode create() {
        return new AlignmentLineOffsetTextUnitNode(this.alignmentLine, this.before, this.after, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg7) {
        if(this == (((AlignmentLineOffsetTextUnitElement)arg7))) {
            return 1;
        }

        if((arg7 instanceof AlignmentLineOffsetTextUnitElement)) {
        }
        else {
            AlignmentLineOffsetTextUnitElement v7 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Intrinsics.areEqual(this.alignmentLine, v7.alignmentLine)) && (TextUnit.equals-impl0(this.before, v7.before)) && (TextUnit.equals-impl0(this.after, v7.after))) {
            return 1;
        }

        return 0;
    }

    public final long getAfter-XSAIIZE() {
        return this.after;
    }

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    public final long getBefore-XSAIIZE() {
        return this.before;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public int hashCode() {
        return (this.alignmentLine.hashCode() * 0x1F + TextUnit.hashCode-impl(this.before)) * 0x1F + TextUnit.hashCode-impl(this.after);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(AlignmentLineOffsetTextUnitNode arg3) {
        arg3.setAlignmentLine(this.alignmentLine);
        arg3.setBefore--R2X_6o(this.before);
        arg3.setAfter--R2X_6o(this.after);
    }

    public void update(Node arg1) {
        this.update(((AlignmentLineOffsetTextUnitNode)arg1));
    }
}

