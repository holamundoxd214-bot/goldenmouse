package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010J\u0014\u0010\u0011\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0015\u001A\u00020\u0005J \u0010\u0016\u001A\u00020\u00172\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0018\u001A\u0004\u0018\u00010\u0014H\u0002J\f\u0010\u0019\u001A\u00020\u0017*\u00020\u0014H\u0002R\u001E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\t@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u001A"}, d2={"Landroidx/compose/ui/text/input/EditProcessor;", "", "<init>", "()V", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text", "()Landroidx/compose/ui/text/input/TextFieldValue;", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text", "()Landroidx/compose/ui/text/input/EditingBuffer;", "reset", "", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "toTextFieldValue", "generateBatchErrorMessage", "", "failedCommand", "toStringForLog", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EditProcessor {
    public static final int $stable = 8;
    private EditingBuffer mBuffer;
    private TextFieldValue mBufferState;

    public static CharSequence $r8$lambda$tahictpR_RFQlQiXpQeJqGuk8B8(EditCommand arg0, EditProcessor arg1, EditCommand arg2) {
        return EditProcessor.generateBatchErrorMessage$lambda$0$0(arg0, arg1, arg2);
    }

    static {
    }

    public EditProcessor() {
        super();
        this.mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.getZero-d9O1mEE(), null, null);
        this.mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.getSelection-d9O1mEE(), null);
    }

    public final TextFieldValue apply(List arg9) {
        Object v1_2;
        Object v4;
        EditingBuffer v3;
        int v2;
        TextRange v1 = null;
        try {
            int v0_1 = arg9.size();
            v2 = 0;
            v3 = ((EditingBuffer)v1);
        }
        catch(Exception v0) {
            goto label_44;
        }

        while(v2 < v0_1) {
            try {
                v4 = arg9.get(v2);
            }
            catch(Exception v0) {
                goto label_16;
            }

            try {
                v3 = this.mBuffer;
                goto label_8;
            }
            catch(Exception v0) {
            }
            catch(Exception v0) {
            label_16:
                EditingBuffer v1_1 = v3;
                goto label_44;
                try {
                label_8:
                    ((EditCommand)v4).applyTo(v3);
                    ++v2;
                    Object v3_1 = v4;
                    continue;
                }
                catch(Exception v0) {
                    v1_2 = v4;
                    goto label_44;
                }
            }
        }

        AnnotatedString v3_2 = this.mBuffer.toAnnotatedString$ui_text();
        long v4_1 = this.mBuffer.getSelection-d9O1mEE$ui_text();
        TextRange v9 = TextRange.box-impl(v4_1);
        v9.unbox-impl();
        if(!TextRange.getReversed-impl(this.mBufferState.getSelection-d9O1mEE())) {
            v1 = v9;
        }

        long v0_2 = v1 != null ? v1.unbox-impl() : TextRangeKt.TextRange(TextRange.getMax-impl(v4_1), TextRange.getMin-impl(v4_1));
        TextFieldValue v2_1 = new TextFieldValue(v3_2, v0_2, this.mBuffer.getComposition-MzsxiRA$ui_text(), null);
        this.mBufferState = v2_1;
        return v2_1;
    label_44:
        throw new RuntimeException(this.generateBatchErrorMessage(arg9, ((EditCommand)v1_2)), ((Throwable)v0));
    }

    private final String generateBatchErrorMessage(List arg14, EditCommand arg15) {
        StringBuilder v0 = new StringBuilder();
        StringBuilder v1 = v0.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text() + ", composition=" + this.mBuffer.getComposition-MzsxiRA$ui_text() + ", selection=" + TextRange.toString-impl(this.mBuffer.getSelection-d9O1mEE$ui_text()) + "):");
        Intrinsics.checkNotNullExpressionValue(v1, "append(...)");
        Intrinsics.checkNotNullExpressionValue(v1.append('\n'), "append(...)");
        CollectionsKt.joinTo$default(arg14, v0, "\n", null, null, 0, null, new EditProcessor$$ExternalSyntheticLambda0(arg15, this), 60, null);
        String v13 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v13, "toString(...)");
        return v13;
    }

    private static final CharSequence generateBatchErrorMessage$lambda$0$0(EditCommand arg1, EditProcessor arg2, EditCommand arg3) {
        String v1 = arg1 == arg3 ? " > " : "   ";
        return v1 + arg2.toStringForLog(arg3);
    }

    public final EditingBuffer getMBuffer$ui_text() {
        return this.mBuffer;
    }

    public final TextFieldValue getMBufferState$ui_text() {
        return this.mBufferState;
    }

    public final void reset(TextFieldValue arg10, TextInputSession arg11) {
        boolean v0 = Intrinsics.areEqual(arg10.getComposition-MzsxiRA(), this.mBuffer.getComposition-MzsxiRA$ui_text());
        int v2 = 1;
        int v3 = 0;
        if(!Intrinsics.areEqual(this.mBufferState.getAnnotatedString().getText(), arg10.getAnnotatedString().getText())) {
            this.mBuffer = new EditingBuffer(arg10.getAnnotatedString(), arg10.getSelection-d9O1mEE(), null);
        }
        else if(!TextRange.equals-impl0(this.mBufferState.getSelection-d9O1mEE(), arg10.getSelection-d9O1mEE())) {
            this.mBuffer.setSelection$ui_text(TextRange.getMin-impl(arg10.getSelection-d9O1mEE()), TextRange.getMax-impl(arg10.getSelection-d9O1mEE()));
            v3 = 1;
            v2 = 0;
        }
        else {
            v2 = 0;
        }

        if(arg10.getComposition-MzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text();
        }
        else if(!TextRange.getCollapsed-impl(arg10.getComposition-MzsxiRA().unbox-impl())) {
            this.mBuffer.setComposition$ui_text(TextRange.getMin-impl(arg10.getComposition-MzsxiRA().unbox-impl()), TextRange.getMax-impl(arg10.getComposition-MzsxiRA().unbox-impl()));
        }

        if(v2 != 0 || v3 == 0 && !v0) {
            this.mBuffer.commitComposition$ui_text();
            arg10 = TextFieldValue.copy-3r_uNRQ$default(arg10, null, 0, null, 3, null);
        }

        TextFieldValue v0_1 = this.mBufferState;
        this.mBufferState = arg10;
        if(arg11 != null) {
            arg11.updateState(v0_1, arg10);
        }
    }

    private final String toStringForLog(EditCommand arg4) {
        char v0 = ')';
        String v1 = ", newCursorPosition=";
        if((arg4 instanceof CommitTextCommand)) {
            return "CommitTextCommand(text.length=" + ((CommitTextCommand)arg4).getText().length() + v1 + ((CommitTextCommand)arg4).getNewCursorPosition() + v0;
        }

        if((arg4 instanceof SetComposingTextCommand)) {
            return "SetComposingTextCommand(text.length=" + ((SetComposingTextCommand)arg4).getText().length() + v1 + ((SetComposingTextCommand)arg4).getNewCursorPosition() + v0;
        }

        if((arg4 instanceof SetComposingRegionCommand)) {
            return ((SetComposingRegionCommand)arg4).toString();
        }

        if((arg4 instanceof DeleteSurroundingTextCommand)) {
            return ((DeleteSurroundingTextCommand)arg4).toString();
        }

        if((arg4 instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return ((DeleteSurroundingTextInCodePointsCommand)arg4).toString();
        }

        if((arg4 instanceof SetSelectionCommand)) {
            return ((SetSelectionCommand)arg4).toString();
        }

        if((arg4 instanceof FinishComposingTextCommand)) {
            return ((FinishComposingTextCommand)arg4).toString();
        }

        if((arg4 instanceof BackspaceCommand)) {
            return ((BackspaceCommand)arg4).toString();
        }

        if((arg4 instanceof MoveCursorCommand)) {
            return ((MoveCursorCommand)arg4).toString();
        }

        if((arg4 instanceof DeleteAllCommand)) {
            return ((DeleteAllCommand)arg4).toString();
        }

        StringBuilder v3 = new StringBuilder("Unknown EditCommand: ");
        String v4 = Reflection.getOrCreateKotlinClass(arg4.getClass()).getSimpleName();
        if(v4 == null) {
            v4 = "{anonymous EditCommand}";
        }

        return v3.append(v4).toString();
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}

