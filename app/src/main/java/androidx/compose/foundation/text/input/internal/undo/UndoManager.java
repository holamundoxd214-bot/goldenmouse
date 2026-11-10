package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \u001E*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001EB1\u0012\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u0000¢\u0006\u0002\u0010\u0019J\u000B\u0010\u001A\u001A\u00028\u0000¢\u0006\u0002\u0010\u001BJ\u000B\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010\u001BJ\u0006\u0010\u001D\u001A\u00020\u0017R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u000E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "T", "", "initialUndoStack", "", "initialRedoStack", "capacity", "", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "undoStack", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "redoStack", "canUndo", "", "getCanUndo$foundation", "()Z", "canRedo", "getCanRedo$foundation", "size", "getSize", "()I", "record", "", "undoableAction", "(Ljava/lang/Object;)V", "undo", "()Ljava/lang/Object;", "redo", "clearHistory", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UndoManager {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u00020\u00010\u0005\"\u0006\b\u0001\u0010\u0007\u0018\u00012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/UndoManager$Companion;", "", "<init>", "()V", "createSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "T", "itemSaver", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver createSaver(Saver arg1) {
            Intrinsics.needClassReification();
            return new UndoManager$Companion$createSaver$1(arg1);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final int capacity;
    private SnapshotStateList redoStack;
    private SnapshotStateList undoStack;

    static {
        UndoManager.Companion = new Companion(null);
        UndoManager.$stable = 8;
    }

    public UndoManager(List arg1, List arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = CollectionsKt.emptyList();
        }

        if((arg4 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        if((arg4 & 4) != 0) {
            arg3 = 100;
        }

        this(arg1, arg2, arg3);
    }

    public UndoManager() {
        this(null, null, 0, 7, null);
    }

    public UndoManager(List arg5, List arg6, int arg7) {
        super();
        this.capacity = arg7;
        int v0 = 1;
        int v2 = arg7 >= 0 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Capacity must be a positive integer");
        }

        if(arg6.size() + arg5.size() <= arg7) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Initial list of undo and redo operations have a size greater than the given capacity.");
        }

        SnapshotStateList v7 = new SnapshotStateList();
        v7.addAll(((Collection)arg5));
        this.undoStack = v7;
        SnapshotStateList v5 = new SnapshotStateList();
        v5.addAll(((Collection)arg6));
        this.redoStack = v5;
    }

    public static final int access$getCapacity$p(UndoManager arg0) {
        return arg0.capacity;
    }

    public static final SnapshotStateList access$getRedoStack$p(UndoManager arg0) {
        return arg0.redoStack;
    }

    public static final SnapshotStateList access$getUndoStack$p(UndoManager arg0) {
        return arg0.undoStack;
    }

    public final void clearHistory() {
        this.undoStack.clear();
        this.redoStack.clear();
    }

    public final boolean getCanRedo$foundation() {
        return this.redoStack.isEmpty() ^ 1;
    }

    public final boolean getCanUndo$foundation() {
        return this.undoStack.isEmpty() ^ 1;
    }

    public final int getSize() {
        return this.undoStack.size() + this.redoStack.size();
    }

    public final void record(Object arg4) {
        SnapshotStateList v2;
        this.redoStack.clear();
        while(true) {
            int v0 = this.getSize();
            int v1 = this.capacity - 1;
            v2 = this.undoStack;
            if(v0 <= v1) {
                break;
            }

            CollectionsKt.removeFirst(((List)v2));
        }

        v2.add(arg4);
    }

    public final Object redo() {
        if(!this.getCanRedo$foundation()) {
            InlineClassHelperKt.throwIllegalStateException("It\'s an error to call redo while there is nothing to redo. Please first check `canRedo` value before calling the `redo` function.");
        }

        Object v0 = CollectionsKt.removeLast(this.redoStack);
        this.undoStack.add(v0);
        return v0;
    }

    public final Object undo() {
        if(!this.getCanUndo$foundation()) {
            InlineClassHelperKt.throwIllegalStateException("It\'s an error to call undo while there is nothing to undo. Please first check `canUndo` value before calling the `undo` function.");
        }

        Object v0 = CollectionsKt.removeLast(this.undoStack);
        this.redoStack.add(v0);
        return v0;
    }
}

