package androidx.compose.foundation.content.internal;

import android.view.DragEvent;
import androidx.compose.foundation.content.TransferableContent$Source;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A$\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001A\f\u0010\b\u001A\u00020\t*\u00020\u0006H\u0000¨\u0006\n"}, d2={"ReceiveContentDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ReceiveContentDragAndDropNode_androidKt {
    public static final DragAndDropTargetModifierNode ReceiveContentDragAndDropNode(ReceiveContentConfiguration arg2, Function1 arg3) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new ReceiveContentDragAndDropNode_androidKt$$ExternalSyntheticLambda0(), new ReceiveContentDragAndDropNode_androidKt$ReceiveContentDragAndDropNode$2(arg2, arg3));
    }

    static final boolean ReceiveContentDragAndDropNode$lambda$0(DragAndDropEvent arg0) {
        return 1;
    }

    public static final TransferableContent toTransferableContent(DragAndDropEvent arg7) {
        DragEvent v7 = DragAndDrop_androidKt.toAndroidDragEvent(arg7);
        return new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(v7.getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(v7.getClipDescription()), Source.Companion.getDragAndDrop-kB6V9T0(), null, 8, null);
    }
}

