package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001A\u00020\u0002H\u0016J\f\u0010\n\u001A\u00020\u000B*\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/IndicationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/IndicationModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "indication", "Landroidx/compose/foundation/IndicationNodeFactory;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;)V", "create", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "update", "node", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class IndicationModifierElement extends ModifierNodeElement {
    private final IndicationNodeFactory indication;
    private final InteractionSource interactionSource;

    public IndicationModifierElement(InteractionSource arg1, IndicationNodeFactory arg2) {
        super();
        this.interactionSource = arg1;
        this.indication = arg2;
    }

    public IndicationModifierNode create() {
        return new IndicationModifierNode(this.indication.create(this.interactionSource));
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((IndicationModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof IndicationModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((IndicationModifierElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.indication, ((IndicationModifierElement)arg5).indication)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.interactionSource.hashCode() * 0x1F + this.indication.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg5) {
        arg5.setName("indication");
        arg5.getProperties().set("interactionSource", this.interactionSource);
        arg5.getProperties().set("indication", this.indication);
    }

    public void update(IndicationModifierNode arg2) {
        arg2.update(this.indication.create(this.interactionSource));
    }

    public void update(Node arg1) {
        this.update(((IndicationModifierNode)arg1));
    }
}

