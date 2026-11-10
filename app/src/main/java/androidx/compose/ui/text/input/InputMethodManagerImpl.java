package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Deprecated(message="Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.") @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0011H\u0016J\b\u0010\u0013\u001A\u00020\u0011H\u0016J\u0018\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0016J(\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u0016H\u0016J\u0010\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020 H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\u0006\u001A\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\b\u0010\tR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/compose/ui/text/input/InputMethodManagerImpl;", "Landroidx/compose/ui/text/input/InputMethodManager;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imm", "Landroid/view/inputmethod/InputMethodManager;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lkotlin/Lazy;", "softwareKeyboardControllerCompat", "Landroidx/core/view/SoftwareKeyboardControllerCompat;", "isActive", "", "restartInput", "", "showSoftInput", "hideSoftInput", "updateExtractedText", "token", "", "extractedText", "Landroid/view/inputmethod/ExtractedText;", "updateSelection", "selectionStart", "selectionEnd", "compositionStart", "compositionEnd", "updateCursorAnchorInfo", "cursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InputMethodManagerImpl implements InputMethodManager {
    public static final int $stable = 8;
    private final Lazy imm$delegate;
    private final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    private final View view;

    static {
    }

    public InputMethodManagerImpl(View arg3) {
        super();
        this.view = arg3;
        this.imm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new InputMethodManagerImpl$imm$2(this));
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(arg3);
    }

    public static final View access$getView$p(InputMethodManagerImpl arg0) {
        return arg0.view;
    }

    private final android.view.inputmethod.InputMethodManager getImm() {
        return this.imm$delegate.getValue();
    }

    public void hideSoftInput() {
        this.softwareKeyboardControllerCompat.hide();
    }

    public boolean isActive() {
        return this.getImm().isActive(this.view);
    }

    public void restartInput() {
        this.getImm().restartInput(this.view);
    }

    public void showSoftInput() {
        this.softwareKeyboardControllerCompat.show();
    }

    public void updateCursorAnchorInfo(CursorAnchorInfo arg2) {
        this.getImm().updateCursorAnchorInfo(this.view, arg2);
    }

    public void updateExtractedText(int arg2, ExtractedText arg3) {
        this.getImm().updateExtractedText(this.view, arg2, arg3);
    }

    public void updateSelection(int arg7, int arg8, int arg9, int arg10) {
        this.getImm().updateSelection(this.view, arg7, arg8, arg9, arg10);
    }
}

