package androidx.compose.ui.draganddrop;

import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.ui.geometry.Offset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\u0010\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0002\"\u0018\u0010\u0006\u001A\u00020\u0007*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"toAndroidDragEvent", "Landroid/view/DragEvent;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "mimeTypes", "", "", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)J", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragAndDrop_androidKt {
    public static final long getPositionInRoot(DragAndDropEvent arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.getDragEvent$ui().getX()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getDragEvent$ui().getY()))) & 0xFFFFFFFFL);
    }

    public static final Set mimeTypes(DragAndDropEvent arg4) {
        ClipDescription v4 = arg4.getDragEvent$ui().getClipDescription();
        if(v4 == null) {
            return SetsKt.emptySet();
        }

        Set v0 = SetsKt.createSetBuilder(v4.getMimeTypeCount());
        int v1 = v4.getMimeTypeCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(v4.getMimeType(v2));
        }

        return SetsKt.build(v0);
    }

    public static final DragEvent toAndroidDragEvent(DragAndDropEvent arg0) {
        return arg0.getDragEvent$ui();
    }
}

