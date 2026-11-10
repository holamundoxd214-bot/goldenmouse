package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u0012#\u0010\n\u001A\u001F\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\u000B¢\u0006\u0002\b\t¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0002H\u0016J\f\u0010\u0014\u001A\u00020\b*\u00020\u0007H\u0016J\b\u0010\u0015\u001A\u00020\u000EH\u0016J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001A\u001F\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\u000B¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/layout/DerivedWidthModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/DerivedWidthModifierNode;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "widthCalc", "Lkotlin/Function3;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "create", "update", "node", "inspectableProperties", "hashCode", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class DerivedWidthModifierElement extends ModifierNodeElement {
    private final WindowInsets insets;
    private final Function1 inspectorInfo;
    private final Function3 widthCalc;

    public DerivedWidthModifierElement(WindowInsets arg1, Function1 arg2, Function3 arg3) {
        super();
        this.insets = arg1;
        this.inspectorInfo = arg2;
        this.widthCalc = arg3;
    }

    public DerivedWidthModifierNode create() {
        return new DerivedWidthModifierNode(this.insets, this.widthCalc);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((DerivedWidthModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DerivedWidthModifierElement)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.insets, ((DerivedWidthModifierElement)arg5).insets)) && this.widthCalc == ((DerivedWidthModifierElement)arg5).widthCalc) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.insets.hashCode() * 0x1F + this.widthCalc.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(DerivedWidthModifierNode arg2) {
        arg2.update(this.insets, this.widthCalc);
    }

    public void update(Node arg1) {
        this.update(((DerivedWidthModifierNode)arg1));
    }
}

