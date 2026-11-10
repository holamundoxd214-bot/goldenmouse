package androidx.compose.ui.text.input;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

@Deprecated(message="Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.") @Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u001C\u001A\u00020\u00072\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001EH\u0082\bJ\u0016\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020#J\u0010\u0010$\u001A\u00020\u001F2\u0006\u0010%\u001A\u00020\u001AH\u0002J\b\u0010&\u001A\u00020\u0007H\u0016J\b\u0010\'\u001A\u00020\u0007H\u0002J\b\u0010(\u001A\u00020\u0007H\u0016J\b\u0010)\u001A\u00020\u0007H\u0002J\b\u0010*\u001A\u00020\u001FH\u0016J\u001A\u0010+\u001A\u00020\u00072\b\u0010,\u001A\u0004\u0018\u00010-2\u0006\u0010.\u001A\u00020\u000FH\u0016J\u0018\u0010/\u001A\u00020\u00072\u0006\u00100\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\u000FH\u0016J\u001A\u00102\u001A\u00020\u00072\b\u0010,\u001A\u0004\u0018\u00010-2\u0006\u0010.\u001A\u00020\u000FH\u0016J\u0018\u00103\u001A\u00020\u00072\u0006\u00104\u001A\u00020\u000F2\u0006\u00105\u001A\u00020\u000FH\u0016J\u0018\u00106\u001A\u00020\u00072\u0006\u00104\u001A\u00020\u000F2\u0006\u00105\u001A\u00020\u000FH\u0016J\u0018\u00107\u001A\u00020\u00072\u0006\u00100\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\u000FH\u0016J\b\u00108\u001A\u00020\u0007H\u0016J\u0010\u00109\u001A\u00020\u00072\u0006\u0010:\u001A\u00020;H\u0016J\u0018\u0010<\u001A\u00020-2\u0006\u0010=\u001A\u00020\u000F2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0018\u0010?\u001A\u00020-2\u0006\u0010=\u001A\u00020\u000F2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0012\u0010@\u001A\u0004\u0018\u00010-2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010A\u001A\u00020\u00072\u0006\u0010B\u001A\u00020\u000FH\u0016J\u001A\u0010C\u001A\u00020D2\b\u0010E\u001A\u0004\u0018\u00010F2\u0006\u0010>\u001A\u00020\u000FH\u0016J\u0010\u0010G\u001A\u00020\u00072\u0006\u0010H\u001A\u00020\u000FH\u0016J\u0010\u0010I\u001A\u00020\u001F2\u0006\u0010J\u001A\u00020\u000FH\u0002J\u0010\u0010K\u001A\u00020\u00072\u0006\u0010L\u001A\u00020\u000FH\u0016J\u0012\u0010M\u001A\u00020\u00072\b\u0010,\u001A\u0004\u0018\u00010NH\u0016J\u0012\u0010O\u001A\u00020\u00072\b\u0010P\u001A\u0004\u0018\u00010QH\u0016J\n\u0010R\u001A\u0004\u0018\u00010SH\u0016J\u0010\u0010T\u001A\u00020\u00072\u0006\u0010U\u001A\u00020\u000FH\u0016J\u0010\u0010V\u001A\u00020\u00072\u0006\u0010W\u001A\u00020\u0007H\u0016J\u0010\u0010X\u001A\u00020\u000F2\u0006\u0010Y\u001A\u00020\u000FH\u0016J\u001C\u0010Z\u001A\u00020\u00072\b\u0010[\u001A\u0004\u0018\u00010\\2\b\u0010]\u001A\u0004\u0018\u00010^H\u0016J\"\u0010_\u001A\u00020\u00072\u0006\u0010`\u001A\u00020a2\u0006\u0010>\u001A\u00020\u000F2\b\u0010b\u001A\u0004\u0018\u00010^H\u0016J\u0010\u0010c\u001A\u00020\u001F2\u0006\u0010d\u001A\u00020\\H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0003@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006e"}, d2={"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/ui/text/input/InputEventCallback2;", "autoCorrect", "", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "getAutoCorrect", "()Z", "batchDepth", "", "value", "mTextFieldValue", "getMTextFieldValue$ui", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "currentExtractedTextRequestToken", "extractedTextMonitorMode", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "isActive", "ensureActive", "block", "Lkotlin/Function0;", "", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "endBatchEdit", "endBatchEditInternal", "closeConnection", "commitText", "text", "", "newCursorPosition", "setComposingRegion", "start", "end", "setComposingText", "deleteSurroundingTextInCodePoints", "beforeLength", "afterLength", "deleteSurroundingText", "setSelection", "finishComposingText", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "getTextBeforeCursor", "maxChars", "flags", "getTextAfterCursor", "getSelectedText", "requestCursorUpdates", "cursorUpdateMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "performContextMenuAction", "id", "sendSynthesizedKeyEvent", "code", "performEditorAction", "editorAction", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "getHandler", "Landroid/os/Handler;", "clearMetaKeyStates", "states", "reportFullscreenMode", "enabled", "getCursorCapsMode", "reqModes", "performPrivateCommand", "action", "", "data", "Landroid/os/Bundle;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "opts", "logDebug", "message", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RecordingInputConnection implements InputConnection {
    public static final int $stable = 8;
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final List editCommands;
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive;
    private TextFieldValue mTextFieldValue;

    static {
    }

    public RecordingInputConnection(TextFieldValue arg1, InputEventCallback2 arg2, boolean arg3) {
        super();
        this.eventCallback = arg2;
        this.autoCorrect = arg3;
        this.mTextFieldValue = arg1;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    private final void addEditCommandWithBatch(EditCommand arg2) {
        this.beginBatchEditInternal();
        try {
            this.editCommands.add(arg2);
        }
        catch(Throwable v2) {
            this.endBatchEditInternal();
            throw v2;
        }

        this.endBatchEditInternal();
    }

    public boolean beginBatchEdit() {
        boolean v0 = this.isActive;
        if(v0) {
            return this.beginBatchEditInternal();
        }

        return v0;
    }

    private final boolean beginBatchEditInternal() {
        ++this.batchDepth;
        return 1;
    }

    public boolean clearMetaKeyStates(int arg1) {
        boolean v0 = this.isActive;
        if(v0) {
            v0 = false;
        }

        return v0;
    }

    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    public boolean commitCompletion(CompletionInfo arg1) {
        boolean v0 = this.isActive;
        if(v0) {
            v0 = false;
        }

        return v0;
    }

    public boolean commitContent(InputContentInfo arg1, int arg2, Bundle arg3) {
        boolean v0 = this.isActive;
        if(v0) {
            v0 = false;
        }

        return v0;
    }

    public boolean commitCorrection(CorrectionInfo arg1) {
        boolean v1 = this.isActive;
        if(v1) {
            return this.autoCorrect;
        }

        return v1;
    }

    public boolean commitText(CharSequence arg3, int arg4) {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new CommitTextCommand(String.valueOf(arg3), arg4));
        }

        return v0;
    }

    public boolean deleteSurroundingText(int arg2, int arg3) {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new DeleteSurroundingTextCommand(arg2, arg3));
            return 1;
        }

        return v0;
    }

    public boolean deleteSurroundingTextInCodePoints(int arg2, int arg3) {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(arg2, arg3));
            return 1;
        }

        return v0;
    }

    public boolean endBatchEdit() {
        return this.endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        int v0 = this.batchDepth - 1;
        this.batchDepth = v0;
        if(v0 == 0 && !this.editCommands.isEmpty()) {
            this.eventCallback.onEditCommands(CollectionsKt.toMutableList(this.editCommands));
            this.editCommands.clear();
        }

        if(this.batchDepth > 0) {
            return 1;
        }

        return 0;
    }

    private final boolean ensureActive(Function0 arg1) {
        boolean v0 = this.isActive;
        if(v0) {
            arg1.invoke();
        }

        return v0;
    }

    public boolean finishComposingText() {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new FinishComposingTextCommand());
            return 1;
        }

        return v0;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    public int getCursorCapsMode(int arg4) {
        return TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.getMin-impl(this.mTextFieldValue.getSelection-d9O1mEE()), arg4);
    }

    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest arg3, int arg4) {
        boolean v0 = true;
        int v1 = 0;
        if((arg4 & 1) != 0) {
        }
        else {
            v0 = false;
        }

        this.extractedTextMonitorMode = v0;
        if(v0) {
            if(arg3 != null) {
                v1 = arg3.token;
            }

            this.currentExtractedTextRequestToken = v1;
        }

        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    public Handler getHandler() {
        return null;
    }

    public final TextFieldValue getMTextFieldValue$ui() {
        return this.mTextFieldValue;
    }

    public CharSequence getSelectedText(int arg3) {
        if(TextRange.getCollapsed-impl(this.mTextFieldValue.getSelection-d9O1mEE())) {
            return null;
        }

        return TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
    }

    public CharSequence getTextAfterCursor(int arg1, int arg2) {
        return TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, arg1).toString();
    }

    public CharSequence getTextBeforeCursor(int arg1, int arg2) {
        return TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, arg1).toString();
    }

    private final void logDebug(String arg1) {
    }

    public boolean performContextMenuAction(int arg3) {
        boolean v0 = this.isActive;
        if(v0) {
            v0 = false;
            switch(arg3) {
                case 16908319: {
                    goto label_14;
                }
                case 16908320: {
                    goto label_11;
                }
                case 16908321: {
                    goto label_8;
                }
                case 16908322: {
                    goto label_5;
                }
            }

            return v0;
        label_5:
            this.sendSynthesizedKeyEvent(279);
            return v0;
        label_8:
            this.sendSynthesizedKeyEvent(278);
            return v0;
        label_11:
            this.sendSynthesizedKeyEvent(277);
            return v0;
        label_14:
            this.addEditCommandWithBatch(new SetSelectionCommand(0, this.mTextFieldValue.getText().length()));
        }

        return v0;
    }

    public boolean performEditorAction(int arg3) {
        boolean v0 = this.isActive;
        if(v0) {
            if(arg3 != 0) {
                switch(arg3) {
                    case 2: {
                        goto label_29;
                    }
                    case 3: {
                        goto label_26;
                    }
                    case 4: {
                        goto label_23;
                    }
                    case 5: {
                        goto label_20;
                    }
                    case 6: {
                        goto label_17;
                    }
                    case 7: {
                        goto label_14;
                    }
                }

                Log.w("RecordingIC", "IME sends unsupported Editor Action: " + arg3);
                arg3 = ImeAction.Companion.getDefault-eUduSuo();
                goto label_34;
            label_17:
                arg3 = ImeAction.Companion.getDone-eUduSuo();
                goto label_34;
            label_20:
                arg3 = ImeAction.Companion.getNext-eUduSuo();
                goto label_34;
            label_23:
                arg3 = ImeAction.Companion.getSend-eUduSuo();
                goto label_34;
            label_26:
                arg3 = ImeAction.Companion.getSearch-eUduSuo();
                goto label_34;
            label_29:
                arg3 = ImeAction.Companion.getGo-eUduSuo();
                goto label_34;
            label_14:
                arg3 = ImeAction.Companion.getPrevious-eUduSuo();
            }
            else {
                arg3 = ImeAction.Companion.getDefault-eUduSuo();
            }

        label_34:
            this.eventCallback.onImeAction-KlQnJC8(arg3);
            return 1;
        }

        return v0;
    }

    public boolean performPrivateCommand(String arg1, Bundle arg2) {
        boolean v0 = this.isActive;
        if(v0) {
            v0 = true;
        }

        return v0;
    }

    public boolean reportFullscreenMode(boolean arg1) {
        return 0;
    }

    public boolean requestCursorUpdates(int arg11) {
        boolean v9;
        boolean v8_1;
        boolean v7;
        boolean v6;
        boolean v0 = this.isActive;
        if(v0) {
            boolean v1 = false;
            boolean v4 = (arg11 & 1) != 0 ? true : false;
            boolean v5 = (arg11 & 2) != 0 ? true : false;
            if(Build$VERSION.SDK_INT >= 33) {
                v0 = (arg11 & 16) != 0 ? true : false;
                boolean v3 = (arg11 & 8) != 0 ? true : false;
                v6 = (arg11 & 4) != 0 ? true : false;
                int v8 = 34;
                if(Build$VERSION.SDK_INT >= v8 && (arg11 & 0x20) != 0) {
                    v1 = true;
                }

                if(!v0 && !v3 && !v6 && !v1) {
                    if(Build$VERSION.SDK_INT >= v8) {
                        v6 = true;
                        v7 = true;
                        v8_1 = true;
                        v9 = true;
                    }
                    else {
                        v9 = v1;
                        v6 = true;
                        v7 = true;
                        v8_1 = true;
                    }

                    goto label_63;
                }

                v9 = v1;
                v7 = v3;
                v8_1 = v6;
                v6 = v0;
            }
            else {
                v8_1 = false;
                v9 = false;
                v6 = true;
                v7 = true;
            }

        label_63:
            this.eventCallback.onRequestCursorAnchorInfo(v4, v5, v6, v7, v8_1, v9);
            return 1;
        }

        return v0;
    }

    public boolean sendKeyEvent(KeyEvent arg2) {
        boolean v0 = this.isActive;
        if(v0) {
            this.eventCallback.onKeyEvent(arg2);
            return 1;
        }

        return v0;
    }

    private final void sendSynthesizedKeyEvent(int arg3) {
        this.sendKeyEvent(new KeyEvent(0, arg3));
        this.sendKeyEvent(new KeyEvent(1, arg3));
    }

    public boolean setComposingRegion(int arg3, int arg4) {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new SetComposingRegionCommand(arg3, arg4));
        }

        return v0;
    }

    public boolean setComposingText(CharSequence arg3, int arg4) {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(arg3), arg4));
        }

        return v0;
    }

    public final void setMTextFieldValue$ui(TextFieldValue arg1) {
        this.mTextFieldValue = arg1;
    }

    public boolean setSelection(int arg2, int arg3) {
        boolean v0 = this.isActive;
        if(v0) {
            this.addEditCommandWithBatch(new SetSelectionCommand(arg2, arg3));
            return 1;
        }

        return v0;
    }

    public final void updateInputState(TextFieldValue arg5, InputMethodManager arg6) {
        if(!this.isActive) {
            return;
        }

        this.setMTextFieldValue$ui(arg5);
        if(this.extractedTextMonitorMode) {
            arg6.updateExtractedText(this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(arg5));
        }

        TextRange v4 = arg5.getComposition-MzsxiRA();
        int v0 = -1;
        int v4_1 = v4 != null ? TextRange.getMin-impl(v4.unbox-impl()) : v0;
        TextRange v1 = arg5.getComposition-MzsxiRA();
        if(v1 != null) {
            v0 = TextRange.getMax-impl(v1.unbox-impl());
        }

        arg6.updateSelection(TextRange.getMin-impl(arg5.getSelection-d9O1mEE()), TextRange.getMax-impl(arg5.getSelection-d9O1mEE()), v4_1, v0);
    }
}

