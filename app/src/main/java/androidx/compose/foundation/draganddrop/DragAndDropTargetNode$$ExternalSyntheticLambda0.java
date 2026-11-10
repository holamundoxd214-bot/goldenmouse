package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import kotlin.jvm.functions.Function1;

public final class DragAndDropTargetNode$$ExternalSyntheticLambda0 implements Function1 {
    public DragAndDropTargetNode$$ExternalSyntheticLambda0(DragAndDropTargetNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return Boolean.valueOf(DragAndDropTargetNode.createAndAttachDragAndDropModifierNode$lambda$0(this.f$0, ((DragAndDropEvent)arg1)));
    }
}

