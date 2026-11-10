package androidx.compose.foundation.text.input.internal;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.core.view.inputmethod.InputConnectionCompat;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u001BH\u0002J\b\u0010\u001D\u001A\u00020\u001BH\u0016J\b\u0010\u001E\u001A\u00020\u001BH\u0002J\b\u0010\u001F\u001A\u00020\u0012H\u0016J\u001A\u0010 \u001A\u00020\u001B2\b\u0010\n\u001A\u0004\u0018\u00010!2\u0006\u0010\"\u001A\u00020\tH\u0016J\u0018\u0010#\u001A\u00020\u001B2\u0006\u0010$\u001A\u00020\t2\u0006\u0010%\u001A\u00020\tH\u0016J\u001A\u0010&\u001A\u00020\u001B2\b\u0010\n\u001A\u0004\u0018\u00010!2\u0006\u0010\"\u001A\u00020\tH\u0016J\u0018\u0010\'\u001A\u00020\u001B2\u0006\u0010(\u001A\u00020\t2\u0006\u0010)\u001A\u00020\tH\u0016J\u0018\u0010*\u001A\u00020\u001B2\u0006\u0010(\u001A\u00020\t2\u0006\u0010)\u001A\u00020\tH\u0016J\u0018\u0010+\u001A\u00020\u001B2\u0006\u0010$\u001A\u00020\t2\u0006\u0010%\u001A\u00020\tH\u0016J\b\u0010,\u001A\u00020\u001BH\u0016J\u0010\u0010-\u001A\u00020\u001B2\u0006\u0010.\u001A\u00020/H\u0016J\u0018\u00100\u001A\u00020!2\u0006\u00101\u001A\u00020\t2\u0006\u00102\u001A\u00020\tH\u0016J\u0018\u00103\u001A\u00020!2\u0006\u00101\u001A\u00020\t2\u0006\u00102\u001A\u00020\tH\u0016J\u0012\u00104\u001A\u0004\u0018\u00010!2\u0006\u00102\u001A\u00020\tH\u0016J\u0010\u00105\u001A\u00020\u001B2\u0006\u00106\u001A\u00020\tH\u0016J$\u00107\u001A\u00020\u00122\u0006\u00108\u001A\u0002092\b\u0010:\u001A\u0004\u0018\u00010;2\b\u0010<\u001A\u0004\u0018\u00010=H\u0016J\u001A\u0010>\u001A\u00020\u001B2\u0006\u00108\u001A\u00020?2\b\u0010@\u001A\u0004\u0018\u00010AH\u0016J\u001A\u0010B\u001A\u00020C2\b\u0010D\u001A\u0004\u0018\u00010E2\u0006\u00102\u001A\u00020\tH\u0016J\u0010\u0010F\u001A\u00020\t2\u0006\u0010G\u001A\u00020\tH\u0016J\u0010\u0010H\u001A\u00020\u001B2\u0006\u0010I\u001A\u00020\tH\u0016J\u0010\u0010J\u001A\u00020\u00122\u0006\u0010K\u001A\u00020\tH\u0002J\u0010\u0010L\u001A\u00020\u001B2\u0006\u0010M\u001A\u00020\tH\u0016J\u0012\u0010N\u001A\u00020\u001B2\b\u0010\n\u001A\u0004\u0018\u00010OH\u0016J\u0012\u0010P\u001A\u00020\u001B2\b\u0010Q\u001A\u0004\u0018\u00010RH\u0016J\n\u0010S\u001A\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001A\u00020\u001B2\u0006\u0010V\u001A\u00020\tH\u0016J\u0010\u0010W\u001A\u00020\u001B2\u0006\u0010X\u001A\u00020\u001BH\u0016J\u001C\u0010Y\u001A\u00020\u001B2\b\u0010Z\u001A\u0004\u0018\u00010[2\b\u0010\\\u001A\u0004\u0018\u00010]H\u0016J\"\u0010^\u001A\u00020\u001B2\u0006\u0010_\u001A\u00020`2\u0006\u00102\u001A\u00020\t2\b\u0010a\u001A\u0004\u0018\u00010]H\u0016J\u0010\u0010b\u001A\u00020\u00122\u0006\u0010c\u001A\u00020[H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR%\u0010\u000E\u001A\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u00130\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019¨\u0006d"}, d2={"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "beginBatchEdit", "", "beginBatchEditInternal", "endBatchEdit", "endBatchEditInternal", "closeConnection", "commitText", "", "newCursorPosition", "setComposingRegion", "start", "end", "setComposingText", "deleteSurroundingTextInCodePoints", "beforeLength", "afterLength", "deleteSurroundingText", "setSelection", "finishComposingText", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "getTextBeforeCursor", "maxChars", "flags", "getTextAfterCursor", "getSelectedText", "requestCursorUpdates", "cursorUpdateMode", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getCursorCapsMode", "reqModes", "performContextMenuAction", "id", "sendSynthesizedKeyEvent", "code", "performEditorAction", "editorAction", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "getHandler", "Landroid/os/Handler;", "clearMetaKeyStates", "states", "reportFullscreenMode", "enabled", "performPrivateCommand", "action", "", "data", "Landroid/os/Bundle;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "opts", "logDebug", "message", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;
    private final InputConnection commitContentDelegateInputConnection;
    private final MutableVector editCommands;
    private final TextInputSession session;
    private final StatelessInputConnection$terminalInputConnection$1 terminalInputConnection;

    static {
    }

    public StatelessInputConnection(TextInputSession arg3, EditorInfo arg4) {
        super();
        this.session = arg3;
        this.editCommands = new MutableVector(new Function1[16], 0);
        StatelessInputConnection$terminalInputConnection$1 v3 = new StatelessInputConnection$terminalInputConnection$1(this);
        this.terminalInputConnection = v3;
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper(((InputConnection)v3), arg4, new StatelessInputConnection$commitContentDelegateInputConnection$1(this));
    }

    public static final TextInputSession access$getSession$p(StatelessInputConnection arg0) {
        return arg0.session;
    }

    public static final void access$logDebug(StatelessInputConnection arg0, String arg1) {
        arg0.logDebug(arg1);
    }

    public boolean beginBatchEdit() {
        this.logDebug("beginBatchEdit()");
        return this.beginBatchEditInternal();
    }

    private final boolean beginBatchEditInternal() {
        return this.session.beginBatchEdit();
    }

    public boolean clearMetaKeyStates(int arg3) {
        this.logDebug("clearMetaKeyStates(" + arg3 + ')');
        return 0;
    }

    public void closeConnection() {
        this.logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    public boolean commitCompletion(CompletionInfo arg3) {
        Object v3_1;
        StringBuilder v0 = new StringBuilder("commitCompletion(");
        if(arg3 != null) {
            CharSequence v3 = arg3.getText();
        }
        else {
            v3_1 = null;
        }

        this.logDebug(v0.append(v3_1).append(')').toString());
        return 0;
    }

    public boolean commitContent(InputContentInfo arg3, int arg4, Bundle arg5) {
        this.logDebug("commitContent(" + arg3 + ", " + arg4 + ", " + arg5 + ')');
        return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, arg3, arg4, arg5);
    }

    public boolean commitCorrection(CorrectionInfo arg1) {
        return 1;
    }

    public boolean commitText(CharSequence arg3, int arg4) {
        this.logDebug("commitText(\"" + arg3 + "\", " + arg4 + ')');
        if(arg3 == null) {
            return 1;
        }

        ImeEditCommand_androidKt.commitText(this.session, arg3.toString(), arg4);
        return 1;
    }

    public boolean deleteSurroundingText(int arg3, int arg4) {
        this.logDebug("deleteSurroundingText(" + arg3 + ", " + arg4 + ')');
        ImeEditCommand_androidKt.deleteSurroundingText(this.session, arg3, arg4);
        return 1;
    }

    public boolean deleteSurroundingTextInCodePoints(int arg3, int arg4) {
        this.logDebug("deleteSurroundingTextInCodePoints(" + arg3 + ", " + arg4 + ')');
        ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints(this.session, arg3, arg4);
        return 1;
    }

    public boolean endBatchEdit() {
        this.logDebug("endBatchEdit()");
        return this.endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        return this.session.endBatchEdit();
    }

    public boolean finishComposingText() {
        this.logDebug("finishComposingText()");
        ImeEditCommand_androidKt.finishComposingText(this.session);
        return 1;
    }

    private static void getCommitContentDelegateInputConnection$annotations() {
    }

    public int getCursorCapsMode(int arg4) {
        this.logDebug("getCursorCapsMode(" + arg4 + ')');
        return TextUtils.getCapsMode(this.getText(), TextRange.getMin-impl(this.getText().getSelection-d9O1mEE()), arg4);
    }

    public ExtractedText getExtractedText(ExtractedTextRequest arg3, int arg4) {
        this.logDebug("getExtractedText(" + arg3 + ", " + arg4 + ')');
        return StatelessInputConnection_androidKt.access$toExtractedText(this.getText());
    }

    public Handler getHandler() {
        this.logDebug("getHandler()");
        return null;
    }

    public CharSequence getSelectedText(int arg4) {
        String v0_1;
        if(TextRange.getCollapsed-impl(this.getText().getSelection-d9O1mEE())) {
            Object v0 = null;
        }
        else {
            v0_1 = TextFieldCharSequenceKt.getSelectedText(this.getText()).toString();
        }

        this.logDebug("getSelectedText(" + arg4 + "): " + v0_1);
        return ((CharSequence)v0_1);
    }

    private final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    public CharSequence getTextAfterCursor(int arg4, int arg5) {
        String v0 = TextFieldCharSequenceKt.getTextAfterSelection(this.getText(), arg4).toString();
        this.logDebug("getTextAfterCursor(" + arg4 + ", " + arg5 + "): " + v0);
        return ((CharSequence)v0);
    }

    public CharSequence getTextBeforeCursor(int arg4, int arg5) {
        String v0 = TextFieldCharSequenceKt.getTextBeforeSelection(this.getText(), arg4).toString();
        this.logDebug("getTextBeforeCursor(" + arg4 + ", " + arg5 + "): " + v0);
        return ((CharSequence)v0);
    }

    private final void logDebug(String arg1) {
    }

    public boolean performContextMenuAction(int arg3) {
        this.logDebug("performContextMenuAction(" + arg3 + ')');
        switch(arg3) {
            case 16908319: {
                ImeEditCommand_androidKt.setSelection(this.session, 0, this.getText().length());
                break;
            }
            case 16908320: {
                this.sendSynthesizedKeyEvent(277);
                break;
            }
            case 16908321: {
                this.sendSynthesizedKeyEvent(278);
                break;
            }
            case 16908322: {
                this.sendSynthesizedKeyEvent(279);
                break;
            }
            default: {
                break;
            }
        }

        return 0;
    }

    public boolean performEditorAction(int arg3) {
        this.logDebug("performEditorAction(" + arg3 + ')');
        if(arg3 != 0) {
            switch(arg3) {
                case 2: {
                    goto label_34;
                }
                case 3: {
                    goto label_31;
                }
                case 4: {
                    goto label_28;
                }
                case 5: {
                    goto label_25;
                }
                case 6: {
                    goto label_22;
                }
                case 7: {
                    goto label_19;
                }
            }

            this.logDebug("IME sent an unrecognized editor action: " + arg3);
            arg3 = ImeAction.Companion.getDefault-eUduSuo();
            goto label_39;
        label_34:
            arg3 = ImeAction.Companion.getGo-eUduSuo();
            goto label_39;
        label_19:
            arg3 = ImeAction.Companion.getPrevious-eUduSuo();
            goto label_39;
        label_22:
            arg3 = ImeAction.Companion.getDone-eUduSuo();
            goto label_39;
        label_25:
            arg3 = ImeAction.Companion.getNext-eUduSuo();
            goto label_39;
        label_28:
            arg3 = ImeAction.Companion.getSend-eUduSuo();
            goto label_39;
        label_31:
            arg3 = ImeAction.Companion.getSearch-eUduSuo();
        }
        else {
            arg3 = ImeAction.Companion.getDefault-eUduSuo();
        }

    label_39:
        this.session.onImeAction-KlQnJC8(arg3);
        return 1;
    }

    public void performHandwritingGesture(HandwritingGesture arg3, Executor arg4, IntConsumer arg5) {
        this.logDebug("performHandwritingGesture(" + arg3 + ", " + arg4 + ", " + arg5 + ')');
        if(Build$VERSION.SDK_INT < 34) {
            return;
        }

        Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, arg3, arg4, arg5);
    }

    public boolean performPrivateCommand(String arg3, Bundle arg4) {
        this.logDebug("performPrivateCommand(" + arg3 + ", " + arg4 + ')');
        return this.commitContentDelegateInputConnection.performPrivateCommand(arg3, arg4);
    }

    public boolean previewHandwritingGesture(PreviewableHandwritingGesture arg3, CancellationSignal arg4) {
        this.logDebug("previewHandwritingGesture(" + arg3 + ", " + arg4 + ')');
        if(Build$VERSION.SDK_INT < 34) {
            return 0;
        }

        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, arg3, arg4);
    }

    public boolean reportFullscreenMode(boolean arg3) {
        this.logDebug("reportFullscreenMode(" + arg3 + ')');
        return 0;
    }

    public boolean requestCursorUpdates(int arg3) {
        this.logDebug("requestCursorUpdates(" + arg3 + ')');
        this.session.requestCursorUpdates(arg3);
        return 1;
    }

    public boolean sendKeyEvent(KeyEvent arg3) {
        this.logDebug("sendKeyEvent(" + arg3 + ')');
        this.session.sendKeyEvent(arg3);
        return 1;
    }

    private final void sendSynthesizedKeyEvent(int arg3) {
        this.sendKeyEvent(new KeyEvent(0, arg3));
        this.sendKeyEvent(new KeyEvent(1, arg3));
    }

    public boolean setComposingRegion(int arg3, int arg4) {
        this.logDebug("setComposingRegion(" + arg3 + ", " + arg4 + ')');
        ImeEditCommand_androidKt.setComposingRegion(this.session, arg3, arg4);
        return 1;
    }

    public boolean setComposingText(CharSequence arg5, int arg6) {
        this.logDebug("setComposingText(\"" + arg5 + "\", " + arg6 + ')');
        if(arg5 == null) {
            return 1;
        }

        TextInputSession v4 = this.session;
        String v1 = arg5.toString();
        List v3 = null;
        if((arg5 instanceof Spanned)) {
        }
        else {
            arg5 = ((CharSequence)v3);
        }

        if(arg5 != null) {
            v3 = StatelessInputConnection_androidKt.toAnnotationList(((Spanned)arg5));
        }

        ImeEditCommand_androidKt.setComposingText(((ImeEditCommandScope)v4), v1, arg6, v3);
        return 1;
    }

    public boolean setSelection(int arg3, int arg4) {
        this.logDebug("setSelection(" + arg3 + ", " + arg4 + ')');
        ImeEditCommand_androidKt.setSelection(this.session, arg3, arg4);
        this.session.updateTouchMode(false);
        return 1;
    }
}

