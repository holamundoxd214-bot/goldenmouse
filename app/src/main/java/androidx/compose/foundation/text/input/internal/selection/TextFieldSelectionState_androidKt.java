package androidx.compose.foundation.text.input.internal.selection;

import android.content.Context;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A@\u0010\u0006\u001A\u00020\u0007*\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00070\rH\u0080@¢\u0006\u0002\u0010\u000F\u001A*\u0010\u0010\u001A\u00020\u0007*\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0080@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2={"addBasicTextFieldTextContextMenuComponents", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "detectTextFieldTapGestures", "", "pointerInputScope", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "Lkotlin/Function0;", "showKeyboard", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textFieldSelectionGestures", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldSelectionState_androidKt {
    public static boolean $r8$lambda$6BJ4w7nwkNmVQs4tOIxXCQPa3KE(TextFieldSelectionState arg0) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$2$0$0(arg0);
    }

    public static Unit $r8$lambda$BZNkuoe1I482AwWvGucJQItVe5c(TextFieldSelectionState arg0) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$2$0$1(arg0);
    }

    public static Unit $r8$lambda$QjMD9UYeuM0bb8t1s8lbZuYXGq4(TextFieldSelectionState arg0, CoroutineScope arg1, Context arg2, TextContextMenuBuilderScope arg3) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$2(arg0, arg1, arg2, arg3);
    }

    public static Unit $r8$lambda$cGN7QolM-5hM3lJYwCh6vGOeuOQ(TextFieldSelectionState arg0) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$2$0$2(arg0);
    }

    public static Unit $r8$lambda$cTsbEQwvVih0Y0hC5nt3eMrKRbY(CoroutineScope arg0, Function1 arg1) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem$1(arg0, arg1);
    }

    public static Unit $r8$lambda$sBcQ4L6CkbdBQQ6OzyyueGe1uiA(Function0 arg0, Function0 arg1, TextFieldSelectionState arg2, TextToolbarState arg3, TextContextMenuSession arg4) {
        return TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Modifier addBasicTextFieldTextContextMenuComponents(Modifier arg1, TextFieldSelectionState arg2, CoroutineScope arg3) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(arg1, new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda3(arg2, arg3));
    }

    static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0(TextFieldSelectionState arg7, CoroutineScope arg8, TextContextMenuBuilderScope arg9, Context arg10) {
        PlatformSelectionBehaviors_androidKt.addPlatformTextContextMenuItems-71BSaZU(arg9, arg10, arg7.getEditable$foundation(), arg7.getTextFieldState$foundation().getVisualText().getText(), TextRange.box-impl(arg7.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()), arg7.getPlatformSelectionBehaviors$foundation(), new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda6(arg7, arg8, arg10));
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$2(TextFieldSelectionState arg10, CoroutineScope arg11, Context arg12, TextContextMenuBuilderScope arg13) {
        arg13.separator();
        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(arg13, arg11, arg12, arg10, TextContextMenuItems.Cut, arg10.canShowCutMenuItem(), new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$1$1$1(arg10, null));
        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(arg13, arg11, arg12, arg10, TextContextMenuItems.Copy, arg10.canShowCopyMenuItem(), new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$1$1$2(arg10, null));
        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(arg13, arg11, arg12, arg10, TextContextMenuItems.Paste, arg10.canShowPasteMenuItem(), new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$1$1$3(arg10, null));
        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem(arg13, arg12, arg10, TextContextMenuItems.SelectAll, arg10.canShowSelectAllMenuItem(), TextToolbarState.Selection, new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda0(arg10), new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda1(arg10));
        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$default(arg13, arg12, arg10, TextContextMenuItems.Autofill, arg10.canShowAutofillMenuItem(), null, null, new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda2(arg10), 0x30, null);
        arg13.separator();
        return Unit.INSTANCE;
    }

    private static final boolean addBasicTextFieldTextContextMenuComponents$lambda$0$2$0$0(TextFieldSelectionState arg0) {
        return arg0.getTextToolbarShown() ^ 1;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$2$0$1(TextFieldSelectionState arg0) {
        arg0.selectAll();
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$2$0$2(TextFieldSelectionState arg0) {
        arg0.autofill();
        return Unit.INSTANCE;
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem(TextContextMenuBuilderScope arg1, Context arg2, TextFieldSelectionState arg3, TextContextMenuItems arg4, boolean arg5, TextToolbarState arg6, Function0 arg7, Function0 arg8) {
        ContextMenu_androidKt.textItem(arg1, arg2.getResources(), arg4, arg5, new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda5(arg8, arg7, arg3, arg6));
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$0(Function0 arg0, Function0 arg1, TextFieldSelectionState arg2, TextToolbarState arg3, TextContextMenuSession arg4) {
        arg0.invoke();
        boolean v0 = arg1 != null ? arg1.invoke().booleanValue() : true;
        if(v0) {
            arg4.close();
        }

        arg2.updateTextToolbarState(arg3);
        return Unit.INSTANCE;
    }

    static void addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$default(TextContextMenuBuilderScope arg8, Context arg9, TextFieldSelectionState arg10, TextContextMenuItems arg11, boolean arg12, TextToolbarState arg13, Function0 arg14, Function0 arg15, int arg16, Object arg17) {
        if((arg16 & 16) != 0) {
            arg13 = TextToolbarState.None;
        }

        TextToolbarState v5 = arg13;
        if((arg16 & 0x20) != 0) {
            arg14 = null;
        }

        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem(arg8, arg9, arg10, arg11, arg12, v5, arg14, arg15);
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(TextContextMenuBuilderScope arg10, CoroutineScope arg11, Context arg12, TextFieldSelectionState arg13, TextContextMenuItems arg14, boolean arg15, Function1 arg16) {
        TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$default(arg10, arg12, arg13, arg14, arg15, null, null, new TextFieldSelectionState_androidKt$$ExternalSyntheticLambda4(arg11, arg16), 0x30, null);
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem$1(CoroutineScope arg6, Function1 arg7) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionState_androidKt$addBasicTextFieldTextContextMenuComponents$1$textFieldSuspendItem$1$1(arg7, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final Object detectTextFieldTapGestures(TextFieldSelectionState arg0, PointerInputScope arg1, MutableInteractionSource arg2, Function0 arg3, Function0 arg4, Continuation arg5) {
        Object v0 = TextFieldSelectionStateKt.defaultDetectTextFieldTapGestures(arg0, arg1, arg2, arg3, arg4, arg5);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public static final Object textFieldSelectionGestures(TextFieldSelectionState arg0, PointerInputScope arg1, MouseSelectionObserver arg2, TextDragObserver arg3, Continuation arg4) {
        Object v0 = TextFieldSelectionStateKt.defaultTextFieldSelectionGestures(arg1, arg2, arg3, arg4);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

