package androidx.compose.ui.draganddrop;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\b\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\t\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "", "onDrop", "", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onStarted", "", "onEntered", "onMoved", "onExited", "onChanged", "onEnded", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface DragAndDropTarget {
    default void onChanged(DragAndDropEvent arg1) {
    }

    boolean onDrop(DragAndDropEvent arg1);

    default void onEnded(DragAndDropEvent arg1) {
    }

    default void onEntered(DragAndDropEvent arg1) {
    }

    default void onExited(DragAndDropEvent arg1) {
    }

    default void onMoved(DragAndDropEvent arg1) {
    }

    default void onStarted(DragAndDropEvent arg1) {
    }
}

