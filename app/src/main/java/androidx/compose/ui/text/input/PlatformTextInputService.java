package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Deprecated(message="Use PlatformTextInputModifierNode instead.") @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JF\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0018\u0010\b\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\tH&J\b\u0010\u0002\u001A\u00020\u0003H\u0016J\b\u0010\u000E\u001A\u00020\u0003H&J\b\u0010\u000F\u001A\u00020\u0003H&J\b\u0010\u0010\u001A\u00020\u0003H&J\u001A\u0010\u0011\u001A\u00020\u00032\b\u0010\u0012\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001A\u00020\u0005H&J\u0010\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0016JD\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0012\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u0016H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/input/PlatformTextInputService;", "", "startInput", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "stopInput", "showSoftwareKeyboard", "hideSoftwareKeyboard", "updateState", "oldValue", "newValue", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    default void notifyFocusedRect(Rect arg1) {
    }

    void showSoftwareKeyboard();

    default void startInput() {
    }

    void startInput(TextFieldValue arg1, ImeOptions arg2, Function1 arg3, Function1 arg4);

    void stopInput();

    void updateState(TextFieldValue arg1, TextFieldValue arg2);

    default void updateTextLayoutResult(TextFieldValue arg1, OffsetMapping arg2, TextLayoutResult arg3, Function1 arg4, Rect arg5, Rect arg6) {
    }
}

