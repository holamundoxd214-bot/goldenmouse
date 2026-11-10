package androidx.compose.foundation.text.input.internal;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\rH\u0016J\b\u0010\u000F\u001A\u00020\rH\u0016J\u0018\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J(\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0019\u001A\u00020\u0012H\u0016J\u0010\u0010\u001A\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\b\u0010\u001D\u001A\u00020\rH\u0016J\b\u0010\u001E\u001A\u00020\rH\u0016J\b\u0010\u001F\u001A\u00020\rH\u0016J\b\u0010 \u001A\u00020\tH\u0004J\b\u0010!\u001A\u00020\tH\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImpl;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "imm", "Landroid/view/inputmethod/InputMethodManager;", "softwareKeyboardControllerCompat", "Landroidx/core/view/SoftwareKeyboardControllerCompat;", "restartInput", "", "showSoftInput", "hideSoftInput", "updateExtractedText", "token", "", "extractedText", "Landroid/view/inputmethod/ExtractedText;", "updateSelection", "selectionStart", "selectionEnd", "compositionStart", "compositionEnd", "updateCursorAnchorInfo", "info", "Landroid/view/inputmethod/CursorAnchorInfo;", "startStylusHandwriting", "prepareStylusHandwritingDelegation", "acceptStylusHandwritingDelegation", "requireImm", "createImm", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) abstract class ComposeInputMethodManagerImpl implements ComposeInputMethodManager {
    private InputMethodManager imm;
    private final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    private final View view;

    public ComposeInputMethodManagerImpl(View arg2) {
        super();
        this.view = arg2;
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(arg2);
    }

    public void acceptStylusHandwritingDelegation() {
    }

    private final InputMethodManager createImm() {
        Object v1 = this.view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return ((InputMethodManager)v1);
    }

    protected final View getView() {
        return this.view;
    }

    public void hideSoftInput() {
        this.softwareKeyboardControllerCompat.hide();
    }

    public void prepareStylusHandwritingDelegation() {
    }

    protected final InputMethodManager requireImm() {
        InputMethodManager v0 = this.imm;
        if(v0 == null) {
            v0 = this.createImm();
            this.imm = v0;
        }

        return v0;
    }

    public void restartInput() {
        this.requireImm().restartInput(this.view);
    }

    public void showSoftInput() {
        this.softwareKeyboardControllerCompat.show();
    }

    public void startStylusHandwriting() {
    }

    public void updateCursorAnchorInfo(CursorAnchorInfo arg2) {
        this.requireImm().updateCursorAnchorInfo(this.view, arg2);
    }

    public void updateExtractedText(int arg2, ExtractedText arg3) {
        this.requireImm().updateExtractedText(this.view, arg2, arg3);
    }

    public void updateSelection(int arg7, int arg8, int arg9, int arg10) {
        this.requireImm().updateSelection(this.view, arg7, arg8, arg9, arg10);
    }
}

