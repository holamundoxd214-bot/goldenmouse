package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropStartTransferScope;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function2;

public final class DragAndDropSourceNode$$ExternalSyntheticLambda0 implements Function2 {
    public DragAndDropSourceNode$$ExternalSyntheticLambda0(DragAndDropSourceNode arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1, Object arg2) {
        return DragAndDropSourceNode.dragAndDropModifierNode$lambda$0(this.f$0, ((DragAndDropStartTransferScope)arg1), ((Offset)arg2));
    }
}

