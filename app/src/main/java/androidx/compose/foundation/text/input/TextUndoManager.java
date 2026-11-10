package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperationKt;
import androidx.compose.foundation.text.input.internal.undo.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB#\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019J\u000E\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u0003J\u0006\u0010\u001D\u001A\u00020\u0017J\b\u0010\u001E\u001A\u00020\u0017H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\t\u001A\u0004\u0018\u00010\u00032\b\u0010\b\u001A\u0004\u0018\u00010\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2={"Landroidx/compose/foundation/text/input/TextUndoManager;", "", "initialStagingUndo", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undoManager", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;Landroidx/compose/foundation/text/input/internal/undo/UndoManager;)V", "<set-?>", "stagingUndo", "getStagingUndo", "()Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "setStagingUndo", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)V", "stagingUndo$delegate", "Landroidx/compose/runtime/MutableState;", "canUndo", "", "getCanUndo", "()Z", "canRedo", "getCanRedo", "undo", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "redo", "record", "op", "clearHistory", "flush", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextUndoManager {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2={"Landroidx/compose/foundation/text/input/TextUndoManager$Companion;", "", "<init>", "()V", "Saver", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001A\u00020\u0003*\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0002H\u0016J\u0012\u0010\f\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u000B\u001A\u00020\u0003H\u0016R \u0010\u0006\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/compose/foundation/text/input/TextUndoManager$Companion$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextUndoManager;", "", "<init>", "()V", "undoManagerSaver", "Landroidx/compose/foundation/text/input/internal/undo/UndoManager;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "value", "restore", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Saver implements androidx.compose.runtime.saveable.Saver {
            public static final int $stable;
            public static final Saver INSTANCE;
            private static final androidx.compose.runtime.saveable.Saver undoManagerSaver;

            static {
                Saver.INSTANCE = new Saver();
                Saver.undoManagerSaver = new TextUndoManager$Companion$Saver$special$$inlined$createSaver$1(TextUndoOperation.Companion.getSaver());
                Saver.$stable = 8;
            }

            private Saver() {
                super();
            }

            public TextUndoManager restore(Object arg2) {
                TextUndoOperation v1_1;
                Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                Object v1 = ((List)arg2).get(0);
                arg2 = ((List)arg2).get(1);
                if(v1 != null) {
                    v1 = TextUndoOperation.Companion.getSaver().restore(v1);
                }
                else {
                    v1_1 = null;
                }

                androidx.compose.runtime.saveable.Saver v0 = Saver.undoManagerSaver;
                Intrinsics.checkNotNull(arg2);
                arg2 = v0.restore(arg2);
                Intrinsics.checkNotNull(arg2);
                return new TextUndoManager(v1_1, ((UndoManager)arg2));
            }

            public Object restore(Object arg1) {
                return this.restore(arg1);
            }

            public Object save(SaverScope arg2, TextUndoManager arg3) {
                TextUndoOperation v1 = arg3.getStagingUndo();
                Object v1_1 = v1 != null ? TextUndoOperation.Companion.getSaver().save(arg2, v1) : null;
                return CollectionsKt.listOf(new Object[]{v1_1, Saver.undoManagerSaver.save(arg2, arg3.undoManager)});
            }

            public Object save(SaverScope arg1, Object arg2) {
                return this.save(arg1, ((TextUndoManager)arg2));
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final MutableState stagingUndo$delegate;
    private final UndoManager undoManager;

    static {
        TextUndoManager.Companion = new Companion(null);
        TextUndoManager.$stable = 8;
    }

    public TextUndoManager(TextUndoOperation arg7, UndoManager arg8, int arg9, DefaultConstructorMarker arg10) {
        if((arg9 & 1) != 0) {
            arg7 = null;
        }

        if((arg9 & 2) != 0) {
            arg8 = new UndoManager(null, null, 100, 3, null);
        }

        this(arg7, arg8);
    }

    public TextUndoManager() {
        this(null, null, 3, null);
    }

    public TextUndoManager(TextUndoOperation arg2, UndoManager arg3) {
        super();
        this.undoManager = arg3;
        this.stagingUndo$delegate = SnapshotStateKt.mutableStateOf$default(arg2, null, 2, null);
    }

    public static final TextUndoOperation access$getStagingUndo(TextUndoManager arg0) {
        return arg0.getStagingUndo();
    }

    public static final UndoManager access$getUndoManager$p(TextUndoManager arg0) {
        return arg0.undoManager;
    }

    public final void clearHistory() {
        this.setStagingUndo(null);
        this.undoManager.clearHistory();
    }

    private final void flush() {
        TextUndoOperation v5;
        androidx.compose.runtime.snapshots.Snapshot$Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        TextUndoOperation v2 = null;
        Function1 v3 = v1 != null ? v1.getReadObserver() : ((Function1)v2);
        Snapshot v4 = v0.makeCurrentNonObservable(v1);
        try {
            v5 = this.getStagingUndo();
        }
        catch(Throwable v6) {
            v0.restoreNonObservable(v1, v4, v3);
            throw v6;
        }

        v0.restoreNonObservable(v1, v4, v3);
        if(v5 != null) {
            this.undoManager.record(v5);
        }

        this.setStagingUndo(v2);
    }

    public final boolean getCanRedo() {
        if((this.undoManager.getCanRedo$foundation()) && this.getStagingUndo() == null) {
            return 1;
        }

        return 0;
    }

    public final boolean getCanUndo() {
        if(!this.undoManager.getCanUndo$foundation()) {
            if(this.getStagingUndo() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final TextUndoOperation getStagingUndo() {
        return this.stagingUndo$delegate.getValue();
    }

    public final void record(TextUndoOperation arg6) {
        TextUndoOperation v4;
        androidx.compose.runtime.snapshots.Snapshot$Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            v4 = this.getStagingUndo();
        }
        catch(Throwable v5) {
            v0.restoreNonObservable(v1, v3, v2);
            throw v5;
        }

        v0.restoreNonObservable(v1, v3, v2);
        if(v4 == null) {
            this.setStagingUndo(arg6);
            return;
        }

        TextUndoOperation v0_1 = TextUndoManagerKt.merge(v4, arg6);
        if(v0_1 != null) {
            this.setStagingUndo(v0_1);
            return;
        }

        this.flush();
        this.setStagingUndo(arg6);
    }

    public final void redo(TextFieldState arg2) {
        if(!this.getCanRedo()) {
            return;
        }

        TextUndoOperationKt.redo(arg2, this.undoManager.redo());
    }

    private final void setStagingUndo(TextUndoOperation arg1) {
        this.stagingUndo$delegate.setValue(arg1);
    }

    public final void undo(TextFieldState arg2) {
        if(!this.getCanUndo()) {
            return;
        }

        this.flush();
        TextUndoOperationKt.undo(arg2, this.undoManager.undo());
    }
}

