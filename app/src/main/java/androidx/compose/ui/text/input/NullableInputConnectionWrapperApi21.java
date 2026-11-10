package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\f\u001A\u00020\u0006J\u0006\u0010\r\u001A\u00020\u0006J\u001A\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u001A\u0010\u0013\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u00172\b\u0010\u0010\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u0018\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u0018\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u001A\u0010\u001C\u001A\u00020\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u0018\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\b\u0010\u001E\u001A\u00020\u001AH\u0016J\u001A\u0010\u001F\u001A\u00020\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u0012\u0010 \u001A\u00020\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001A\u00020\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u0010\u0010%\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010&\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\'\u001A\u00020\u001AH\u0016J\b\u0010(\u001A\u00020\u001AH\u0016J\u0012\u0010)\u001A\u00020\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010,\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u001AH\u0016J\u001C\u0010-\u001A\u00020\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010.2\b\u0010\u0012\u001A\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\n\u00101\u001A\u0004\u0018\u000102H\u0016J\"\u00103\u001A\u00020\u001A2\u0006\u0010\u0010\u001A\u0002042\u0006\u0010\u0012\u001A\u00020\u00112\b\u00105\u001A\u0004\u0018\u00010/H\u0016J\u0010\u00106\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u0003H\u0014R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\u0010\t\u001A\u0004\u0018\u00010\u0003@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u00067"}, d2={"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi21;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "", "<init>", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function1;)V", "value", "getDelegate", "()Landroid/view/inputmethod/InputConnection;", "disposeDelegate", "closeConnection", "getTextBeforeCursor", "", "p0", "", "p1", "getTextAfterCursor", "getSelectedText", "getCursorCapsMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroid/view/inputmethod/ExtractedTextRequest;", "deleteSurroundingText", "", "deleteSurroundingTextInCodePoints", "setComposingText", "setComposingRegion", "finishComposingText", "commitText", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "Landroid/view/inputmethod/CorrectionInfo;", "setSelection", "performEditorAction", "performContextMenuAction", "beginBatchEdit", "endBatchEdit", "sendKeyEvent", "Landroid/view/KeyEvent;", "clearMetaKeyStates", "reportFullscreenMode", "performPrivateCommand", "", "Landroid/os/Bundle;", "requestCursorUpdates", "getHandler", "Landroid/os/Handler;", "commitContent", "Landroid/view/inputmethod/InputContentInfo;", "p2", "closeDelegate", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) class NullableInputConnectionWrapperApi21 implements NullableInputConnectionWrapper {
    private InputConnection delegate;
    private final Function1 onConnectionClosed;

    public NullableInputConnectionWrapperApi21(InputConnection arg1, Function1 arg2) {
        super();
        this.onConnectionClosed = arg2;
        this.delegate = arg1;
    }

    public boolean beginBatchEdit() {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.beginBatchEdit();
        }

        return 0;
    }

    public boolean clearMetaKeyStates(int arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.clearMetaKeyStates(arg1);
        }

        return 0;
    }

    public final void closeConnection() {
        if(this.delegate != null) {
            this.disposeDelegate();
            this.onConnectionClosed.invoke(this);
        }
    }

    protected void closeDelegate(InputConnection arg1) {
    }

    public boolean commitCompletion(CompletionInfo arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.commitCompletion(arg1);
        }

        return 0;
    }

    public boolean commitContent(InputContentInfo arg1, int arg2, Bundle arg3) {
        return 0;
    }

    public boolean commitCorrection(CorrectionInfo arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.commitCorrection(arg1);
        }

        return 0;
    }

    public boolean commitText(CharSequence arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.commitText(arg1, arg2);
        }

        return 0;
    }

    public boolean deleteSurroundingText(int arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.deleteSurroundingText(arg1, arg2);
        }

        return 0;
    }

    public boolean deleteSurroundingTextInCodePoints(int arg1, int arg2) {
        return 0;
    }

    public final void disposeDelegate() {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            this.closeDelegate(v0);
            this.delegate = null;
        }
    }

    public boolean endBatchEdit() {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.endBatchEdit();
        }

        return 0;
    }

    public boolean finishComposingText() {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.finishComposingText();
        }

        return 0;
    }

    public int getCursorCapsMode(int arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.getCursorCapsMode(arg1);
        }

        return 0;
    }

    protected final InputConnection getDelegate() {
        return this.delegate;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.getExtractedText(arg1, arg2);
        }

        return null;
    }

    public Handler getHandler() {
        return null;
    }

    public CharSequence getSelectedText(int arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.getSelectedText(arg1);
        }

        return null;
    }

    public CharSequence getTextAfterCursor(int arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.getTextAfterCursor(arg1, arg2);
        }

        return null;
    }

    public CharSequence getTextBeforeCursor(int arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.getTextBeforeCursor(arg1, arg2);
        }

        return null;
    }

    public boolean performContextMenuAction(int arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.performContextMenuAction(arg1);
        }

        return 0;
    }

    public boolean performEditorAction(int arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.performEditorAction(arg1);
        }

        return 0;
    }

    public boolean performPrivateCommand(String arg1, Bundle arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.performPrivateCommand(arg1, arg2);
        }

        return 0;
    }

    public boolean reportFullscreenMode(boolean arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.reportFullscreenMode(arg1);
        }

        return 0;
    }

    public boolean requestCursorUpdates(int arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.requestCursorUpdates(arg1);
        }

        return 0;
    }

    public boolean sendKeyEvent(KeyEvent arg1) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.sendKeyEvent(arg1);
        }

        return 0;
    }

    public boolean setComposingRegion(int arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.setComposingRegion(arg1, arg2);
        }

        return 0;
    }

    public boolean setComposingText(CharSequence arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.setComposingText(arg1, arg2);
        }

        return 0;
    }

    public boolean setSelection(int arg1, int arg2) {
        InputConnection v0 = this.delegate;
        if(v0 != null) {
            return v0.setSelection(arg1, arg2);
        }

        return 0;
    }
}

