package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J]\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u00052\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00050\u001AH\u0016¢\u0006\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "<init>", "()V", "onPreKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 8;

    static {
    }

    public AndroidTextFieldKeyEventHandler() {
        super();
    }

    public boolean onKeyEvent-8zsqlwg(KeyEvent arg3, TransformedTextFieldState arg4, TextLayoutState arg5, TextFieldSelectionState arg6, Function1 arg7, SoftwareKeyboardController arg8, boolean arg9, boolean arg10, Function0 arg11) {
        if((KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg3), KeyEventType.Companion.getKeyDown-CS__XNY())) && (arg3.isFromSource(0x101)) && (!TextFieldKeyEventHandler_androidKt.isFromSoftKeyboard-ZmokQxo(arg3) || !TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(arg3))) {
            arg6.setInTouchMode(false);
        }

        return super.onKeyEvent-8zsqlwg(arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean onPreKeyEvent-MyFupTE(KeyEvent arg2, TransformedTextFieldState arg3, TextFieldSelectionState arg4, FocusManager arg5, SoftwareKeyboardController arg6) {
        boolean v1 = super.onPreKeyEvent-MyFupTE(arg2, arg3, arg4, arg5, arg6);
        if(ComposeFoundationFlags.isTextFieldDpadNavigationEnabled) {
            return v1;
        }

        if(v1) {
            return 1;
        }

        InputDevice v1_1 = arg2.getDevice();
        if(v1_1 == null) {
            return 0;
        }

        if(!v1_1.supportsSource(0x201)) {
            return 0;
        }

        if(v1_1.isVirtual()) {
            return 0;
        }

        if(!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg2), KeyEventType.Companion.getKeyDown-CS__XNY())) {
            return 0;
        }

        if(arg2.getSource() == 0x101) {
            return 0;
        }

        if(TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(arg2, 19)) {
            return arg5.moveFocus-3ESFkO8(FocusDirection.Companion.getUp-dhqQ-8s());
        }

        if(TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(arg2, 20)) {
            return arg5.moveFocus-3ESFkO8(FocusDirection.Companion.getDown-dhqQ-8s());
        }

        if(TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(arg2, 21)) {
            return arg5.moveFocus-3ESFkO8(FocusDirection.Companion.getLeft-dhqQ-8s());
        }

        if(TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(arg2, 22)) {
            return arg5.moveFocus-3ESFkO8(FocusDirection.Companion.getRight-dhqQ-8s());
        }

        if(TextFieldKeyEventHandler_androidKt.access$isKeyCode-YhN2O0w(arg2, 23)) {
            arg6.show();
            return 1;
        }

        return 0;
    }
}

