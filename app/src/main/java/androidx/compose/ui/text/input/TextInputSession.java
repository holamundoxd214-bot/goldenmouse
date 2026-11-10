package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="Use PlatformTextInputModifierNode instead.") @Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000B\u001A\u00020\fJ\u0017\u0010\r\u001A\u00020\t2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\f0\u000FH\u0082\bJ\u000E\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u0012JB\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0012\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\f0\u001B2\u0006\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001E\u001A\u00020\u0012J\u0018\u0010\u001F\u001A\u00020\t2\b\u0010 \u001A\u0004\u0018\u00010\u00152\u0006\u0010!\u001A\u00020\u0015J\u0006\u0010\"\u001A\u00020\tJ\u0006\u0010#\u001A\u00020\tR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006$"}, d2={"Landroidx/compose/ui/text/input/TextInputSession;", "", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "<init>", "(Landroidx/compose/ui/text/input/TextInputService;Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "isOpen", "", "()Z", "dispose", "", "ensureOpenSession", "block", "Lkotlin/Function0;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "updateState", "oldValue", "newValue", "showSoftwareKeyboard", "hideSoftwareKeyboard", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextInputSession {
    public static final int $stable = 8;
    private final PlatformTextInputService platformTextInputService;
    private final TextInputService textInputService;

    static {
    }

    public TextInputSession(TextInputService arg1, PlatformTextInputService arg2) {
        super();
        this.textInputService = arg1;
        this.platformTextInputService = arg2;
    }

    public final void dispose() {
        this.textInputService.stopInput(this);
    }

    private final boolean ensureOpenSession(Function0 arg1) {
        boolean v0 = this.isOpen();
        if(v0) {
            arg1.invoke();
        }

        return v0;
    }

    public final boolean hideSoftwareKeyboard() {
        boolean v0 = this.isOpen();
        if(v0) {
            this.platformTextInputService.hideSoftwareKeyboard();
        }

        return v0;
    }

    public final boolean isOpen() {
        return Intrinsics.areEqual(this.textInputService.getCurrentInputSession$ui_text(), this);
    }

    public final boolean notifyFocusedRect(Rect arg2) {
        boolean v0 = this.isOpen();
        if(v0) {
            this.platformTextInputService.notifyFocusedRect(arg2);
        }

        return v0;
    }

    public final boolean showSoftwareKeyboard() {
        boolean v0 = this.isOpen();
        if(v0) {
            this.platformTextInputService.showSoftwareKeyboard();
        }

        return v0;
    }

    public final boolean updateState(TextFieldValue arg2, TextFieldValue arg3) {
        boolean v0 = this.isOpen();
        if(v0) {
            this.platformTextInputService.updateState(arg2, arg3);
        }

        return v0;
    }

    public final boolean updateTextLayoutResult(TextFieldValue arg2, OffsetMapping arg3, TextLayoutResult arg4, Function1 arg5, Rect arg6, Rect arg7) {
        boolean v0 = this.isOpen();
        if(v0) {
            this.platformTextInputService.updateTextLayoutResult(arg2, arg3, arg4, arg5, arg6, arg7);
        }

        return v0;
    }
}

