package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.PlatformUtils_androidKt;
import androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$1;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A@\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00010\bH\u0080@¢\u0006\u0002\u0010\n\u001A\"\u0010\u000B\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0080@¢\u0006\u0002\u0010\u0010\u001A\u0013\u0010\u0011\u001A\u00020\u0012*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A5\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u000E\b\u0004\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00010\bH\u0080\b\u001A\u0016\u0010\u001E\u001A\u00020\u00012\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001D0\bH\u0002\u001AR\u0010 \u001A\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b#*\u00020\u00022\u0006\u0010$\u001A\u00020%2\f\u0010&\u001A\b\u0012\u0004\u0012\u00020(0\'2\u001D\u0010)\u001A\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0002\b#H\u0000\"\u000E\u0010\u001B\u001A\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001C\u001A\u00020\u001DX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2={"defaultDetectTextFieldTapGestures", "", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "pointerInputScope", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "Lkotlin/Function0;", "showKeyboard", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultTextFieldSelectionGestures", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "menuItem", "enabled", "", "desiredState", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "operation", "DEBUG", "DEBUG_TAG", "", "logDebug", "text", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "onMenuItemClicked", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/TextContextMenuItems;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldSelectionStateKt {
    private static final boolean DEBUG = false;
    private static final String DEBUG_TAG = "TextFieldSelectionState";

    public static String $r8$lambda$mR94iEHvLYyBaaoGuAdILS_n8bA() {
        return TextFieldSelectionStateKt.defaultDetectTextFieldTapGestures$lambda$0$0();
    }

    public static final void access$logDebug(Function0 arg0) {
        TextFieldSelectionStateKt.logDebug(arg0);
    }

    public static final long access$reverse-5zc-tL8(long arg0) {
        return TextFieldSelectionStateKt.reverse-5zc-tL8(arg0);
    }

    public static final Function1 contextMenuBuilder(TextFieldSelectionState arg1, ContextMenuState arg2, State arg3, Function2 arg4) {
        return new TextFieldSelectionStateKt$$ExternalSyntheticLambda1(arg3, arg2, arg4, arg1);
    }

    static final Unit contextMenuBuilder$lambda$0(State arg12, ContextMenuState arg13, Function2 arg14, TextFieldSelectionState arg15, ContextMenuScope arg16) {
        int v12 = arg12.getValue().unbox-impl();
        TextFieldSelectionStateKt.contextMenuBuilder$lambda$0$textFieldItem(arg16, arg13, arg14, arg15, TextContextMenuItems.Cut, MenuItemsAvailability.getCanCut-impl(v12));
        TextFieldSelectionStateKt.contextMenuBuilder$lambda$0$textFieldItem(arg16, arg13, arg14, arg15, TextContextMenuItems.Copy, MenuItemsAvailability.getCanCopy-impl(v12));
        TextFieldSelectionStateKt.contextMenuBuilder$lambda$0$textFieldItem(arg16, arg13, arg14, arg15, TextContextMenuItems.Paste, MenuItemsAvailability.getCanPaste-impl(v12));
        TextFieldSelectionStateKt.contextMenuBuilder$lambda$0$textFieldItem(arg16, arg13, arg14, arg15, TextContextMenuItems.SelectAll, MenuItemsAvailability.getCanSelectAll-impl(v12));
        if(PlatformUtils_androidKt.isAutofillAvailable()) {
            TextFieldSelectionStateKt.contextMenuBuilder$lambda$0$textFieldItem(arg16, arg13, arg14, arg15, TextContextMenuItems.Autofill, MenuItemsAvailability.getCanAutofill-impl(v12));
        }

        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$0$textFieldItem(ContextMenuScope arg8, ContextMenuState arg9, Function2 arg10, TextFieldSelectionState arg11, TextContextMenuItems arg12, boolean arg13) {
        if(arg13) {
            ContextMenuScope.item$default(arg8, new CommonContextMenuAreaKt$TextItem$1(arg12), null, false, null, new TextFieldSelectionStateKt$contextMenuBuilder$lambda$0$textFieldItem$$inlined$TextItem$1(arg9, arg10, arg11, arg12), 14, null);
        }
    }

    public static final Object defaultDetectTextFieldTapGestures(TextFieldSelectionState arg2, PointerInputScope arg3, MutableInteractionSource arg4, Function0 arg5, Function0 arg6, Continuation arg7) {
        Object v2 = TapGestureDetectorKt.detectTapAndPress(arg3, new TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2(arg4, arg2, null), new TextFieldSelectionStateKt$$ExternalSyntheticLambda0(arg5, arg2, arg6), arg7);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final Unit defaultDetectTextFieldTapGestures$lambda$0(Function0 arg1, TextFieldSelectionState arg2, Function0 arg3, Offset arg4) {
        TextFieldSelectionStateKt.logDebug(new TextFieldSelectionStateKt$$ExternalSyntheticLambda2());
        arg1.invoke();
        if((arg2.getEnabled()) && (arg2.isFocused())) {
            if(!arg2.getReadOnly()) {
                arg3.invoke();
                if(arg2.getTextFieldState$foundation().getVisualText().length() > 0) {
                    arg2.setShowCursorHandle(true);
                }
            }

            arg2.updateTextToolbarState(TextToolbarState.None);
            arg2.placeCursorAtNearestOffset-k-4lQ0M(TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(arg2.getTextLayoutState$foundation(), arg2.getTextLayoutState$foundation().coercedInVisibleBoundsOfInputText-MK-Hz9U$foundation(arg4.unbox-impl())));
        }

        return Unit.INSTANCE;
    }

    private static final String defaultDetectTextFieldTapGestures$lambda$0$0() {
        return "onTapTextField";
    }

    public static final Object defaultTextFieldSelectionGestures(PointerInputScope arg0, MouseSelectionObserver arg1, TextDragObserver arg2, Continuation arg3) {
        Object v0 = SelectionGesturesKt.awaitSelectionGestures(arg0, arg1, arg2, arg3);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    private static final void logDebug(Function0 arg0) {
    }

    public static final Function0 menuItem(TextFieldSelectionState arg0, boolean arg1, TextToolbarState arg2, Function0 arg3) {
        if(!arg1) {
            return null;
        }

        return new TextFieldSelectionStateKt$menuItem$1(arg3, arg0, arg2);
    }

    private static final long reverse-5zc-tL8(long arg1) {
        return TextRangeKt.TextRange(TextRange.getEnd-impl(arg1), TextRange.getStart-impl(arg1));
    }
}

