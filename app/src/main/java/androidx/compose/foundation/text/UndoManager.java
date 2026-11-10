package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001AB\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\rJ\u0006\u0010\u000F\u001A\u00020\u0012J\u000E\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014J\b\u0010\u0017\u001A\u00020\u0012H\u0002J\b\u0010\u0018\u001A\u0004\u0018\u00010\u0014J\b\u0010\u0019\u001A\u0004\u0018\u00010\u0014R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/text/UndoManager;", "", "maxStoredCharacters", "", "<init>", "(I)V", "getMaxStoredCharacters", "()I", "undoStack", "Landroidx/compose/foundation/text/UndoManager$Entry;", "redoStack", "storedCharacters", "lastSnapshot", "", "Ljava/lang/Long;", "forceNextSnapshot", "", "snapshotIfNeeded", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "now", "makeSnapshot", "removeLastUndo", "undo", "redo", "Entry", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UndoManager {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0000X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/text/UndoManager$Entry;", "", "next", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "<init>", "(Landroidx/compose/foundation/text/UndoManager$Entry;Landroidx/compose/ui/text/input/TextFieldValue;)V", "getNext", "()Landroidx/compose/foundation/text/UndoManager$Entry;", "setNext", "(Landroidx/compose/foundation/text/UndoManager$Entry;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Entry {
        private Entry next;
        private TextFieldValue value;

        public Entry(Entry arg1, TextFieldValue arg2) {
            super();
            this.next = arg1;
            this.value = arg2;
        }

        public Entry(Entry arg1, TextFieldValue arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 1) != 0) {
                arg1 = null;
            }

            this(arg1, arg2);
        }

        public final Entry getNext() {
            return this.next;
        }

        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(Entry arg1) {
            this.next = arg1;
        }

        public final void setValue(TextFieldValue arg1) {
            this.value = arg1;
        }
    }

    public static final int $stable = 8;
    private boolean forceNextSnapshot;
    private Long lastSnapshot;
    private final int maxStoredCharacters;
    private Entry redoStack;
    private int storedCharacters;
    private Entry undoStack;

    static {
    }

    public UndoManager(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 100000;
        }

        this(arg1);
    }

    public UndoManager() {
        this(0, 1, null);
    }

    public UndoManager(int arg1) {
        super();
        this.maxStoredCharacters = arg1;
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public final void makeSnapshot(TextFieldValue arg4) {
        Object v2_3;
        this.forceNextSnapshot = false;
        Entry v0 = this.undoStack;
        Entry v1 = null;
        if(v0 != null) {
            TextFieldValue v0_1 = v0.getValue();
        }
        else {
            Object v0_2 = v1;
        }

        if(Intrinsics.areEqual(arg4, v0_1)) {
        }
        else {
            String v0_3 = arg4.getText();
            Entry v2 = this.undoStack;
            if(v2 != null) {
                TextFieldValue v2_1 = v2.getValue();
                if(v2_1 != null) {
                    String v2_2 = v2_1.getText();
                }
                else {
                    goto label_18;
                }
            }
            else {
            label_18:
                v2_3 = v1;
            }

            boolean v0_4 = Intrinsics.areEqual(v0_3, v2_3);
            v2 = this.undoStack;
            if(v0_4) {
                if(v2 == null) {
                    return;
                }

                v2.setValue(arg4);
                return;
            }

            this.undoStack = new Entry(v2, arg4);
            this.redoStack = v1;
            int v0_5 = this.storedCharacters + arg4.getText().length();
            this.storedCharacters = v0_5;
            if(v0_5 <= this.maxStoredCharacters) {
                return;
            }

            this.removeLastUndo();
        }
    }

    public final TextFieldValue redo() {
        Entry v0 = this.redoStack;
        if(v0 != null) {
            this.redoStack = v0.getNext();
            this.undoStack = new Entry(this.undoStack, v0.getValue());
            this.storedCharacters += v0.getValue().getText().length();
            return v0.getValue();
        }

        return null;
    }

    private final void removeLastUndo() {
        Entry v2 = this.undoStack;
        Entry v0 = null;
        Entry v1 = v2 != null ? v2.getNext() : v0;
        if(v1 == null) {
        }
        else {
            while(true) {
                if(v2 != null) {
                    v1 = v2.getNext();
                    if(v1 != null) {
                        v1 = v1.getNext();
                    }
                    else {
                        goto label_13;
                    }
                }
                else {
                label_13:
                    v1 = v0;
                }

                if(v1 == null) {
                    break;
                }

                v2 = v2.getNext();
            }

            if(v2 == null) {
                return;
            }

            v2.setNext(v0);
        }
    }

    public final void snapshotIfNeeded(TextFieldValue arg5, long arg6) {
        if(!this.forceNextSnapshot) {
            Long v0 = this.lastSnapshot;
            long v0_1 = v0 != null ? v0.longValue() : 0;
            if(arg6 > v0_1 + (((long)UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS()))) {
                goto label_13;
            }

            return;
        }

    label_13:
        this.lastSnapshot = Long.valueOf(arg6);
        this.makeSnapshot(arg5);
    }

    public static void snapshotIfNeeded$default(UndoManager arg0, TextFieldValue arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = UndoManager_jvmKt.timeNowMillis();
        }

        arg0.snapshotIfNeeded(arg1, arg2);
    }

    public final TextFieldValue undo() {
        Entry v0 = this.undoStack;
        TextFieldValue v1 = null;
        if(v0 != null) {
            Entry v2 = v0.getNext();
            if(v2 != null) {
                this.undoStack = v2;
                this.storedCharacters -= v0.getValue().getText().length();
                this.redoStack = new Entry(this.redoStack, v0.getValue());
                return v2.getValue();
            }
        }

        return v1;
    }
}

