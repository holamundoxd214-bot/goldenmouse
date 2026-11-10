package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "requestDragAndDropTransfer", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "requestDragAndDropTransfer-k-4lQ0M", "(J)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DragAndDropStartDetectorScope extends PointerInputScope {
    void requestDragAndDropTransfer-k-4lQ0M(long arg1);

    static void requestDragAndDropTransfer-k-4lQ0M$default(DragAndDropStartDetectorScope arg0, long arg1, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            arg0.requestDragAndDropTransfer-k-4lQ0M(arg1);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestDragAndDropTransfer-k-4lQ0M");
    }
}

