package androidx.compose.foundation.content;

import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u0005R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/content/ReceiveContentNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "<init>", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "setReceiveContentListener", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "updateNode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReceiveContentNode extends DelegatingNode implements ModifierLocalModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private final ModifierLocalMap providedValues;
    private final ReceiveContentConfiguration receiveContentConfiguration;
    private ReceiveContentListener receiveContentListener;

    static {
    }

    public ReceiveContentNode(ReceiveContentListener arg2) {
        super();
        this.receiveContentListener = arg2;
        DynamicReceiveContentConfiguration v2 = new DynamicReceiveContentConfiguration(this);
        this.receiveContentConfiguration = ((ReceiveContentConfiguration)v2);
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(ReceiveContentConfigurationKt.getModifierLocalReceiveContent(), v2));
        this.delegate(ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode(((ReceiveContentConfiguration)v2), new ReceiveContentNode$$ExternalSyntheticLambda0(this)));
    }

    static final Unit _init_$lambda$0(ReceiveContentNode arg0, DragAndDropEvent arg1) {
        DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(((DelegatableNode)arg0), arg1);
        return Unit.INSTANCE;
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    public final ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public final void setReceiveContentListener(ReceiveContentListener arg1) {
        this.receiveContentListener = arg1;
    }

    public final void updateNode(ReceiveContentListener arg1) {
        this.receiveContentListener = arg1;
    }
}

