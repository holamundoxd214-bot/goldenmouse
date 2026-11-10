package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\\]B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001D\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\"\u0010/\u001A\u0002002\u0017\u00101\u001A\u0013\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0086\bJ\b\u00104\u001A\u00020\u0003H\u0016J\b\u0010:\u001A\u00020\u000FH\u0001J\u0010\u0010;\u001A\u0002002\u0006\u0010<\u001A\u00020\u000FH\u0001J\b\u0010=\u001A\u000200H\u0001JE\u0010>\u001A\u0002002\b\u0010?\u001A\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001A\u00020\u00172\b\b\u0002\u0010B\u001A\u00020C2\u0017\u00101\u001A\u0013\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bDJ\'\u0010E\u001A\u0002002\u0017\u00101\u001A\u0013\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020002¢\u0006\u0002\b3H\u0080\b¢\u0006\u0002\bFJ&\u0010G\u001A\u0002002\b\u0010?\u001A\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001A\u00020\u00172\b\b\u0002\u0010B\u001A\u00020CH\u0002J \u0010H\u001A\u0002002\u0006\u0010I\u001A\u00020\u001E2\u0006\u0010<\u001A\u00020\u001E2\u0006\u0010A\u001A\u00020\u0017H\u0002J(\u0010J\u001A\u0002002\u0006\u0010K\u001A\u00020\u001E2\u0006\u0010L\u001A\u00020\u001E2\u0006\u0010M\u001A\u00020N2\u0006\u0010B\u001A\u00020CH\u0002J\u0015\u0010O\u001A\u0002002\u0006\u0010P\u001A\u00020QH\u0000¢\u0006\u0002\bRJ\u0015\u0010S\u001A\u0002002\u0006\u0010P\u001A\u00020QH\u0000¢\u0006\u0002\bTJ%\u0010U\u001A\u0002002\u0006\u0010V\u001A\u00020\u000F2\u0006\u0010W\u001A\u00020\u00172\u0006\u0010X\u001A\u00020\u0017H\u0001¢\u0006\u0002\bYR\u0014\u0010\u000B\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR$\u0010\u000E\u001A\u00020\u000F8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00178B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR+\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0016\u001A\u00020\u001E8@@BX\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001D\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001A\u00020&8F¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u0011\u0010)\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0013\u0010,\u001A\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001A\u0004\b-\u0010.R\u001C\u00105\u001A\u0002068\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b7\u0010\u0011\u001A\u0004\b8\u00109R\u0014\u0010Z\u001A\b\u0012\u0004\u0012\u00020Q0[X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2={"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "<init>", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "textUndoManager", "getTextUndoManager$foundation", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "mainBuffer", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "getMainBuffer$foundation$annotations", "()V", "getMainBuffer$foundation", "()Landroidx/compose/foundation/text/input/TextFieldBuffer;", "setMainBuffer$foundation", "(Landroidx/compose/foundation/text/input/TextFieldBuffer;)V", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "text", "", "getText", "()Ljava/lang/CharSequence;", "selection", "getSelection-d9O1mEE", "()J", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "edit", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toString", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "startEdit", "commitEdit", "newValue", "finishEditing", "editAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "editAsUser$foundation", "editWithNoSideEffects", "editWithNoSideEffects$foundation", "commitEditAsUser", "updateValueAndNotifyListeners", "oldValue", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "addNotifyImeListener", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "addNotifyImeListener$foundation", "removeNotifyImeListener", "removeNotifyImeListener$foundation", "syncMainBufferToTemporaryBuffer", "temporaryBuffer", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer$foundation", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "NotifyImeListener", "Saver", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldState {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartIme", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface NotifyImeListener {
        void onChange(TextFieldCharSequence arg1, TextFieldCharSequence arg2, boolean arg3);
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0002H\u0016J\u0012\u0010\t\u001A\u0004\u0018\u00010\u00022\u0006\u0010\b\u001A\u00020\u0003H\u0016¨\u0006\n"}, d2={"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "<init>", "()V", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "value", "restore", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Saver implements androidx.compose.runtime.saveable.Saver {
        public static final int $stable;
        public static final Saver INSTANCE;

        static {
            Saver.INSTANCE = new Saver();
        }

        private Saver() {
            super();
        }

        public TextFieldState restore(Object arg10) {
            Intrinsics.checkNotNull(arg10, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Object v9 = ((List)arg10).get(0);
            Object v0 = ((List)arg10).get(1);
            Object v1 = ((List)arg10).get(2);
            arg10 = ((List)arg10).get(3);
            Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type kotlin.String");
            Object v4 = v9;
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Int");
            int v0_1 = ((Integer)v0).intValue();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
            long v5 = TextRangeKt.TextRange(v0_1, ((Integer)v1).intValue());
            androidx.compose.foundation.text.input.TextUndoManager$Companion$Saver v9_1 = androidx.compose.foundation.text.input.TextUndoManager$Companion$Saver.INSTANCE;
            Intrinsics.checkNotNull(arg10);
            TextUndoManager v7 = v9_1.restore(arg10);
            Intrinsics.checkNotNull(v7);
            return new TextFieldState(((String)v4), v5, v7, null);
        }

        public Object restore(Object arg1) {
            return this.restore(arg1);
        }

        public Object save(SaverScope arg4, TextFieldState arg5) {
            return CollectionsKt.listOf(new Object[]{arg5.getText().toString(), Integer.valueOf(TextRange.getStart-impl(arg5.getSelection-d9O1mEE())), Integer.valueOf(TextRange.getEnd-impl(arg5.getSelection-d9O1mEE())), androidx.compose.foundation.text.input.TextUndoManager$Companion$Saver.INSTANCE.save(arg4, arg5.getTextUndoManager$foundation())});
        }

        public Object save(SaverScope arg1, Object arg2) {
            return this.save(arg1, ((TextFieldState)arg2));
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[TextFieldEditUndoBehavior.values().length];
            try {
                v0[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int $stable;
    private final MutableState isEditing$delegate;
    private TextFieldBuffer mainBuffer;
    private final MutableVector notifyImeListeners;
    private final TextUndoManager textUndoManager;
    private final UndoState undoState;
    private final MutableState value$delegate;

    static {
    }

    private TextFieldState(String arg7, long arg8) {
        this(arg7, arg8, new TextUndoManager(null, null, 3, null), null);
    }

    public TextFieldState(String arg1, long arg2, TextUndoManager arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    public TextFieldState(String arg1, long arg2, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = "";
        }

        if((arg4 & 2) != 0) {
            arg2 = TextRangeKt.TextRange(arg1.length());
        }

        this(arg1, arg2, null);
    }

    public TextFieldState(String arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private TextFieldState(String arg17, long arg18, TextUndoManager arg20) {
        super();
        this.textUndoManager = arg20;
        this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(arg17, TextRangeKt.coerceIn-8ffj60Q(arg18, 0, arg17.length()), null, null, null, null, 60, null), null, null, null, 14, null);
        this.isEditing$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(new TextFieldCharSequence(arg17, arg18, null, null, null, null, 60, null), null, 2, null);
        this.undoState = new UndoState(this);
        this.notifyImeListeners = new MutableVector(new NotifyImeListener[16], 0);
    }

    public static final void access$commitEditAsUser(TextFieldState arg0, InputTransformation arg1, boolean arg2, TextFieldEditUndoBehavior arg3) {
        arg0.commitEditAsUser(arg1, arg2, arg3);
    }

    public static final void access$updateValueAndNotifyListeners(TextFieldState arg0, TextFieldCharSequence arg1, TextFieldCharSequence arg2, boolean arg3) {
        arg0.updateValueAndNotifyListeners(arg1, arg2, arg3);
    }

    public final void addNotifyImeListener$foundation(NotifyImeListener arg1) {
        this.notifyImeListeners.add(arg1);
    }

    public final void commitEdit(TextFieldBuffer arg13) {
        TextFieldBuffer v4;
        boolean v0 = arg13.getChanges().getChangeCount() > 0 ? true : false;
        boolean v2 = TextRange.equals-impl0(arg13.getSelection-d9O1mEE(), this.mainBuffer.getSelection-d9O1mEE());
        int v3 = (((int)v2)) ^ 1;
        if(!v0 && (v2)) {
            arg13.setCanCallAddStyle$foundation(true);
        }

        if(v0) {
            v4 = arg13;
            this.recordEditForUndo(this.getValue$foundation(), TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(v4, 0, null, null, null, 15, null), v4.getChanges(), TextFieldEditUndoBehavior.NeverMerge);
        }
        else {
            v4 = arg13;
        }

        this.syncMainBufferToTemporaryBuffer$foundation(v4, v0, ((boolean)v3));
    }

    private final void commitEditAsUser(InputTransformation arg19, boolean arg20, TextFieldEditUndoBehavior arg21) {
        TextFieldState v0 = this;
        InputTransformation v1 = arg19;
        boolean v2 = arg20;
        TextFieldEditUndoBehavior v3 = arg21;
        TextFieldCharSequence v7 = v0.getValue$foundation();
        if(v0.mainBuffer.getChangeTracker$foundation().getChangeCount() == 0 && (TextRange.equals-impl0(v7.getSelection-d9O1mEE(), v0.mainBuffer.getSelection-d9O1mEE()))) {
            if((Intrinsics.areEqual(v7.getComposition-MzsxiRA(), v0.mainBuffer.getComposition-MzsxiRA$foundation())) && (Intrinsics.areEqual(v7.getHighlight(), v0.mainBuffer.getHighlight$foundation()))) {
                if(!Intrinsics.areEqual(v7.getComposingAnnotations(), v0.mainBuffer.getComposingAnnotations$foundation())) {
                }
                else {
                    return;
                }
            }

            v0.updateValueAndNotifyListeners(v0.getValue$foundation(), new TextFieldCharSequence(v0.mainBuffer.toString(), v0.mainBuffer.getSelection-d9O1mEE(), v0.mainBuffer.getComposition-MzsxiRA$foundation(), v0.mainBuffer.getHighlight$foundation(), TextFieldStateKt.access$finalizeComposingAnnotations-itr0ztk(v0.mainBuffer.getComposition-MzsxiRA$foundation(), v0.mainBuffer.getComposingAnnotations$foundation()), null, 0x20, null), v2);
            return;
        }

        boolean v5 = false;
        int v4 = v0.mainBuffer.getChangeTracker$foundation().getChangeCount() != 0 ? 1 : 0;
        TextFieldCharSequence v8 = new TextFieldCharSequence(v0.mainBuffer.toString(), v0.mainBuffer.getSelection-d9O1mEE(), v0.mainBuffer.getComposition-MzsxiRA$foundation(), v0.mainBuffer.getHighlight$foundation(), TextFieldStateKt.access$finalizeComposingAnnotations-itr0ztk(v0.mainBuffer.getComposition-MzsxiRA$foundation(), v0.mainBuffer.getComposingAnnotations$foundation()), null, 0x20, null);
        if(v1 == null) {
            if(v4 != 0 && (v2)) {
                v5 = true;
            }

            v0.updateValueAndNotifyListeners(v7, v8, v5);
            v0.recordEditForUndo(v7, v8, v0.mainBuffer.getChangeTracker$foundation(), v3);
            return;
        }

        TextFieldCharSequence v5_1 = v8;
        TextFieldBuffer v4_1 = new TextFieldBuffer(v5_1, v0.mainBuffer.getChangeTracker$foundation(), v7, null, 8, null);
        v1.transformInput(v4_1);
        boolean v1_1 = StringsKt.contentEquals(v4_1.asCharSequence(), v5_1);
        int v6 = (((int)v1_1)) ^ 1;
        boolean v8_1 = TextRange.equals-impl0(v4_1.getSelection-d9O1mEE(), v5_1.getSelection-d9O1mEE());
        int v9 = (((int)v8_1)) ^ 1;
        if(!v1_1 || !v8_1) {
            v0.syncMainBufferToTemporaryBuffer$foundation(v4_1, ((boolean)v6), ((boolean)v9));
        }
        else {
            v0.updateValueAndNotifyListeners(v7, TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(v4_1, 0, v5_1.getComposition-MzsxiRA(), null, null, 13, null), v2);
        }

        v0.recordEditForUndo(v7, v0.getValue$foundation(), v4_1.getChanges(), v3);
    }

    static void commitEditAsUser$default(TextFieldState arg0, InputTransformation arg1, boolean arg2, TextFieldEditUndoBehavior arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = TextFieldEditUndoBehavior.MergeIfPossible;
        }

        arg0.commitEditAsUser(arg1, true, arg3);
    }

    public final void edit(Function1 arg2) {
        TextFieldBuffer v0 = this.startEdit();
        try {
            arg2.invoke(v0);
            this.commitEdit(v0);
        }
        catch(Throwable v2) {
            this.finishEditing();
            throw v2;
        }

        this.finishEditing();
    }

    public final void editAsUser$foundation(InputTransformation arg2, boolean arg3, TextFieldEditUndoBehavior arg4, Function1 arg5) {
        this.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        arg5.invoke(this.getMainBuffer$foundation());
        this.commitEditAsUser(arg2, arg3, arg4);
    }

    public static void editAsUser$foundation$default(TextFieldState arg0, InputTransformation arg1, boolean arg2, TextFieldEditUndoBehavior arg3, Function1 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = TextFieldEditUndoBehavior.MergeIfPossible;
        }

        arg0.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        arg4.invoke(arg0.getMainBuffer$foundation());
        arg0.commitEditAsUser(arg1, true, arg3);
    }

    public final void editWithNoSideEffects$foundation(Function1 arg10) {
        this.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        arg10.invoke(this.getMainBuffer$foundation());
        this.updateValueAndNotifyListeners(this.getValue$foundation(), TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(this.getMainBuffer$foundation(), 0, null, null, null, 15, null), true);
    }

    public final void finishEditing() {
        this.setEditing(false);
    }

    public final TextRange getComposition-MzsxiRA() {
        return this.getValue$foundation().getComposition-MzsxiRA();
    }

    public final TextFieldBuffer getMainBuffer$foundation() {
        return this.mainBuffer;
    }

    public static void getMainBuffer$foundation$annotations() {
    }

    public final long getSelection-d9O1mEE() {
        return this.getValue$foundation().getSelection-d9O1mEE();
    }

    public final CharSequence getText() {
        return this.getValue$foundation().getText();
    }

    public final TextUndoManager getTextUndoManager$foundation() {
        return this.textUndoManager;
    }

    public final UndoState getUndoState() {
        return this.undoState;
    }

    public static void getUndoState$annotations() {
    }

    public final TextFieldCharSequence getValue$foundation() {
        return this.value$delegate.getValue();
    }

    private final boolean isEditing() {
        return this.isEditing$delegate.getValue().booleanValue();
    }

    private final void recordEditForUndo(TextFieldCharSequence arg3, TextFieldCharSequence arg4, ChangeList arg5, TextFieldEditUndoBehavior arg6) {
        int v6 = WhenMappings.$EnumSwitchMapping$0[arg6.ordinal()];
        if(v6 != 1) {
            if(v6 != 2) {
                if(v6 == 3) {
                    TextUndoManagerKt.recordChanges(this.textUndoManager, arg3, arg4, arg5, false);
                    return;
                }

                throw new NoWhenBranchMatchedException();
            }

            TextUndoManagerKt.recordChanges(this.textUndoManager, arg3, arg4, arg5, true);
            return;
        }

        this.textUndoManager.clearHistory();
    }

    public final void removeNotifyImeListener$foundation(NotifyImeListener arg1) {
        this.notifyImeListeners.remove(arg1);
    }

    private final void setEditing(boolean arg1) {
        this.isEditing$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setMainBuffer$foundation(TextFieldBuffer arg1) {
        this.mainBuffer = arg1;
    }

    private final void setValue(TextFieldCharSequence arg1) {
        this.value$delegate.setValue(arg1);
    }

    public final TextFieldBuffer startEdit() {
        Companion v1 = Snapshot.Companion;
        Snapshot v2 = v1.getCurrentThreadSnapshot();
        Function1 v0 = v2 != null ? v2.getReadObserver() : null;
        Function1 v3 = v0;
        Snapshot v4 = v1.makeCurrentNonObservable(v2);
        try {
            boolean v0_2 = this.isEditing();
        }
        catch(Throwable v0_1) {
            v1.restoreNonObservable(v2, v4, v3);
            throw v0_1;
        }

        v1.restoreNonObservable(v2, v4, v3);
        if(v0_2) {
            InlineClassHelperKt.throwIllegalStateException("TextFieldState does not support concurrent or nested editing.");
        }

        this.setEditing(true);
        return new TextFieldBuffer(this.getValue$foundation(), null, null, null, 14, null);
    }

    public final void syncMainBufferToTemporaryBuffer$foundation(TextFieldBuffer arg13, boolean arg14, boolean arg15) {
        TextFieldCharSequence v0 = TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(this.mainBuffer, 0, null, null, null, 15, null);
        if(arg14) {
            this.mainBuffer = new TextFieldBuffer(new TextFieldCharSequence(arg13.toString(), arg13.getSelection-d9O1mEE(), null, null, null, null, 60, null), null, null, null, 14, null);
        }
        else if(arg15) {
            this.mainBuffer.setSelection-5zc-tL8(TextRangeKt.TextRange(TextRange.getStart-impl(arg13.getSelection-d9O1mEE()), TextRange.getEnd-impl(arg13.getSelection-d9O1mEE())));
        }

        if((arg14) || (arg15) || !Intrinsics.areEqual(v0.getComposition-MzsxiRA(), arg13.getComposition-MzsxiRA$foundation())) {
            this.mainBuffer.commitComposition$foundation();
        }

        this.updateValueAndNotifyListeners(v0, TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(this.mainBuffer, 0, null, null, null, 15, null), true);
    }

    public String toString() {
        String v8_1;
        String v0 = "TextFieldState(selection=";
        Companion v1 = Snapshot.Companion;
        Snapshot v2 = v1.getCurrentThreadSnapshot();
        Function1 v3 = v2 != null ? v2.getReadObserver() : null;
        Snapshot v4 = v1.makeCurrentNonObservable(v2);
        try {
            v8_1 = v0 + TextRange.toString-impl(this.getSelection-d9O1mEE()) + ", text=\"" + this.getText() + "\")";
        }
        catch(Throwable v8) {
            v1.restoreNonObservable(v2, v4, v3);
            throw v8;
        }

        v1.restoreNonObservable(v2, v4, v3);
        return v8_1;
    }

    private final void updateValueAndNotifyListeners(TextFieldCharSequence arg6, TextFieldCharSequence arg7, boolean arg8) {
        this.setValue(arg7);
        this.finishEditing();
        MutableVector v5 = this.notifyImeListeners;
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v2;
        for(v2 = 0; v2 < v5_1; ++v2) {
            Object v3 = v0[v2];
            boolean v4 = !arg8 || (arg6.contentEquals(arg7)) || arg6.getComposition-MzsxiRA() == null ? false : true;
            ((NotifyImeListener)v3).onChange(arg6, arg7, v4);
        }
    }
}

