package androidx.compose.ui.platform;

import android.view.View$DragShadowBuilder;
import android.view.View;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007¨\u0006\f"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewStartDragAndDropN;", "", "<init>", "()V", "startDragAndDrop", "", "view", "Landroid/view/View;", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "dragShadowBuilder", "Landroidx/compose/ui/draganddrop/ComposeDragShadowBuilder;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidComposeViewStartDragAndDropN {
    public static final AndroidComposeViewStartDragAndDropN INSTANCE;

    static {
        AndroidComposeViewStartDragAndDropN.INSTANCE = new AndroidComposeViewStartDragAndDropN();
    }

    private AndroidComposeViewStartDragAndDropN() {
        super();
    }

    public final boolean startDragAndDrop(View arg2, DragAndDropTransferData arg3, ComposeDragShadowBuilder arg4) {
        return arg2.startDragAndDrop(arg3.getClipData(), ((View$DragShadowBuilder)arg4), arg3.getLocalState(), arg3.getFlags());
    }
}

