package androidx.compose.foundation.content.internal;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.core.view.DragAndDropPermissionsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\f\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0002\u001A\u0012\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0002¨\u0006\f"}, d2={"dragAndDropRequestPermission", "", "Landroidx/compose/ui/node/DelegatableNode;", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "containsContentUri", "", "Landroid/content/ClipData;", "tryGetActivity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragAndDropRequestPermission_androidKt {
    private static final boolean containsContentUri(ClipData arg5) {
        int v0 = arg5.getItemCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            Uri v3 = arg5.getItemAt(v2).getUri();
            if(v3 != null && (Intrinsics.areEqual(v3.getScheme(), "content"))) {
                return 1;
            }
        }

        return 0;
    }

    public static final void dragAndDropRequestPermission(DelegatableNode arg1, DragAndDropEvent arg2) {
        if(!DragAndDropRequestPermission_androidKt.containsContentUri(DragAndDrop_androidKt.toAndroidDragEvent(arg2).getClipData())) {
        }
        else if(arg1.getNode().isAttached()) {
            Activity v1 = DragAndDropRequestPermission_androidKt.tryGetActivity(DelegatableNode_androidKt.requireView(arg1));
            if(v1 == null) {
            }
            else {
                DragAndDropPermissionsCompat.request(v1, DragAndDrop_androidKt.toAndroidDragEvent(arg2));
            }
        }
    }

    private static final Activity tryGetActivity(View arg1) {
        Context v1;
        for(v1 = arg1.getContext(); (v1 instanceof ContextWrapper); v1 = ((ContextWrapper)v1).getBaseContext()) {
            if((v1 instanceof Activity)) {
                return ((Activity)v1);
            }
        }

        return null;
    }
}

