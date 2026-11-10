package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u0012\u001D\u0010\n\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\t¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010\u0010\u001A\u00020\u0002H\u0016J\u0010\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u0002H\u0016J\f\u0010\u0013\u001A\u00020\b*\u00020\u0007H\u0016J\b\u0010\u0014\u001A\u00020\rH\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\n\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000B¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/layout/DerivedHeightModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/DerivedHeightModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "heightCalc", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "create", "update", "node", "inspectableProperties", "hashCode", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class DerivedHeightModifierElement extends ModifierNodeElement {
    private final Function2 heightCalc;
    private final WindowInsets insets;
    private final Function1 inspectorInfo;

    public DerivedHeightModifierElement(WindowInsets arg1, Function1 arg2, Function2 arg3) {
        super();
        this.insets = arg1;
        this.inspectorInfo = arg2;
        this.heightCalc = arg3;
    }

    public DerivedHeightModifierNode create() {
        return new DerivedHeightModifierNode(this.insets, this.heightCalc);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((DerivedHeightModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DerivedHeightModifierElement)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.insets, ((DerivedHeightModifierElement)arg5).insets)) && this.heightCalc == ((DerivedHeightModifierElement)arg5).heightCalc) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.insets.hashCode() * 0x1F + this.heightCalc.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(DerivedHeightModifierNode arg2) {
        arg2.update(this.insets, this.heightCalc);
    }

    public void update(Node arg1) {
        this.update(((DerivedHeightModifierNode)arg1));
    }
}

