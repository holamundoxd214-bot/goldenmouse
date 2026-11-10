package androidx.compose.ui.text.input;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Deprecated(message="Use PlatformTextInputModifierNode instead.") @Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JF\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0018\u0010\u0013\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00170\u00142\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u0014H\u0016J\b\u0010\u000E\u001A\u00020\u0017H\u0007J\u0010\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\bH\u0016J\b\u0010\u001A\u001A\u00020\u0017H\u0007J\b\u0010\u001C\u001A\u00020\u0017H\u0007J\b\u0010\u001D\u001A\u00020\u0017H\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000B\u001A\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001E"}, d2={"Landroidx/compose/ui/text/input/TextInputService;", "", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "<init>", "(Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "_currentInputSession", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/text/input/TextInputSession;", "Landroidx/compose/ui/text/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "currentInputSession", "getCurrentInputSession$ui_text", "()Landroidx/compose/ui/text/input/TextInputSession;", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "stopInput", "session", "showSoftwareKeyboard", "hideSoftwareKeyboard", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public class TextInputService {
    public static final int $stable = 8;
    private final AtomicReference _currentInputSession;
    private final PlatformTextInputService platformTextInputService;

    static {
    }

    public TextInputService(PlatformTextInputService arg2) {
        super();
        this.platformTextInputService = arg2;
        this._currentInputSession = new AtomicReference(null);
    }

    public final TextInputSession getCurrentInputSession$ui_text() {
        return this._currentInputSession.get();
    }

    @Deprecated(message="Use SoftwareKeyboardController.hide or TextInputSession.hideSoftwareKeyboard instead.", replaceWith="<_subannotation>") public final void hideSoftwareKeyboard() {
        this.platformTextInputService.hideSoftwareKeyboard();
    }

    @Deprecated(message="Use SoftwareKeyboardController.show or TextInputSession.showSoftwareKeyboard instead.", replaceWith="<_subannotation>") public final void showSoftwareKeyboard() {
        if(this.getCurrentInputSession$ui_text() != null) {
            this.platformTextInputService.showSoftwareKeyboard();
        }
    }

    public TextInputSession startInput(TextFieldValue arg2, ImeOptions arg3, Function1 arg4, Function1 arg5) {
        this.platformTextInputService.startInput(arg2, arg3, arg4, arg5);
        TextInputSession v2 = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(v2);
        return v2;
    }

    public final void startInput() {
        this.platformTextInputService.startInput();
        this._currentInputSession.set(new TextInputSession(this, this.platformTextInputService));
    }

    public final void stopInput() {
        this._currentInputSession.set(null);
        this.platformTextInputService.stopInput();
    }

    public void stopInput(TextInputSession arg3) {
        if(MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this._currentInputSession, arg3, null)) {
            this.platformTextInputService.stopInput();
        }
    }
}

