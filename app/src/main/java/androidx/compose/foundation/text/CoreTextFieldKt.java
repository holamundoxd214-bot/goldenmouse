package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u001Aú\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u0014\b\u0002\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u00152\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u00132\b\b\u0002\u0010\u001C\u001A\u00020\u001323\b\u0002\u0010\u001D\u001A-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u001F¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001F2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001A0\u0010&\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\'\u001A\u00020(2\u0011\u0010)\u001A\r\u0012\u0004\u0012\u00020\u00010\u001E¢\u0006\u0002\b\u001FH\u0003¢\u0006\u0002\u0010*\u001A\u001C\u0010+\u001A\u00020\u0007*\u00020\u00072\u0006\u0010,\u001A\u00020-2\u0006\u0010\'\u001A\u00020(H\u0002\u001A \u0010.\u001A\u00020\u00012\u0006\u0010,\u001A\u00020-2\u0006\u0010/\u001A\u0002002\u0006\u00101\u001A\u00020\u0013H\u0000\u001A0\u00102\u001A\u00020\u00012\u0006\u00103\u001A\u0002042\u0006\u0010,\u001A\u00020-2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u00105\u001A\u000206H\u0002\u001A\u0010\u00107\u001A\u00020\u00012\u0006\u0010,\u001A\u00020-H\u0002\u001A2\u00108\u001A\u00020\u0001*\u0002092\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020\r2\u0006\u00105\u001A\u000206H\u0080@¢\u0006\u0002\u0010=\u001A\u001D\u0010>\u001A\u00020\u00012\u0006\u0010\'\u001A\u00020(2\u0006\u0010?\u001A\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001A\u0015\u0010A\u001A\u00020\u00012\u0006\u0010\'\u001A\u00020(H\u0001¢\u0006\u0002\u0010B\u001A \u0010C\u001A\u00020\u00012\u0006\u0010,\u001A\u00020-2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u00105\u001A\u000206H\u0002\u001A\u001C\u0010D\u001A\u00020\u0007*\u00020\u00072\u0006\u0010E\u001A\u00020(2\u0006\u0010F\u001A\u00020GH\u0002¨\u0006H²\u0006\n\u0010I\u001A\u00020\u0013X\u008A\u0084\u0002"}, d2={"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation", "writeable"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CoreTextFieldKt {
    public static Unit $r8$lambda$-MwEYxRehXA6SYObLMKFHlspZ5Y(LegacyTextFieldState arg0, boolean arg1, WindowInfo arg2, TextFieldSelectionManager arg3, TextFieldValue arg4, OffsetMapping arg5, LayoutCoordinates arg6) {
        return CoreTextFieldKt.CoreTextField$lambda$20$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static Unit $r8$lambda$3a8_9X9a_Wtd3joDkkM2xvnrgcU(long arg0, SemanticsPropertyReceiver arg2) {
        return CoreTextFieldKt.TextFieldCursorHandle$lambda$3$0(arg0, arg2);
    }

    public static Unit $r8$lambda$5tmet3tQKrDS-jvOqalpJET0Dlc(boolean arg0, LegacyPlatformTextInputServiceAdapter arg1) {
        return CoreTextFieldKt.CoreTextField$lambda$23$0(arg0, arg1);
    }

    public static Unit $r8$lambda$7OAloknr-h1JGEI8ld11EP-UrMk(TextFieldSelectionManager arg0, LegacyTextFieldState arg1, boolean arg2, boolean arg3, Function1 arg4, TextFieldValue arg5, OffsetMapping arg6, Density arg7, int arg8, Composer arg9, int arg10) {
        return CoreTextFieldKt.CoreTextField$lambda$26$0$1(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static Unit $r8$lambda$9KNCD21yNbw2PIgUYnn3xSauY0M(LegacyTextFieldState arg0, Brush arg1, ContentDrawScope arg2) {
        return CoreTextFieldKt.CoreTextField$lambda$24$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$BLYeOk5ZT4NO3L4OKNAC8YdZd5Q(LegacyTextFieldState arg0, boolean arg1, boolean arg2, TextInputService arg3, TextFieldValue arg4, ImeOptions arg5, OffsetMapping arg6, TextFieldSelectionManager arg7, CoroutineScope arg8, BringIntoViewRequester arg9, FocusState arg10) {
        return CoreTextFieldKt.CoreTextField$lambda$13$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static Unit $r8$lambda$IFGw_bNSuwGPpr48lRtwqkoS8d4(LegacyTextFieldState arg0, TextFieldValue arg1, OffsetMapping arg2, DrawScope arg3) {
        return CoreTextFieldKt.CoreTextField$lambda$19$0(arg0, arg1, arg2, arg3);
    }

    public static TextLayoutResultProxy $r8$lambda$PxQokudtCBjP2bpeNa0J5lij53M(LegacyTextFieldState arg0) {
        return CoreTextFieldKt.CoreTextField$lambda$26$0$0$0(arg0);
    }

    public static DisposableEffectResult $r8$lambda$YVhuVDTeAif0Ph9o_50aQp0Yc8o(LegacyTextFieldState arg0, TextInputService arg1, TextFieldValue arg2, ImeOptions arg3, DisposableEffectScope arg4) {
        return CoreTextFieldKt.CoreTextField$lambda$22$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static TextFieldScrollerPosition $r8$lambda$cJhWOmufcXUg0lK1uAjGEONkXes(Orientation arg0) {
        return CoreTextFieldKt.CoreTextField$lambda$4$0(arg0);
    }

    public static Unit $r8$lambda$ffW9WHqb2geuuqDTncmm6p8a5hk(LegacyTextFieldState arg0, FocusRequester arg1, boolean arg2, boolean arg3, TextFieldSelectionManager arg4, OffsetMapping arg5, Offset arg6) {
        return CoreTextFieldKt.CoreTextField$lambda$17$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static Unit $r8$lambda$g7E_lblAEAAr0bzwn0tT3gQk1lA(LegacyTextFieldState arg0, TextStyle arg1, int arg2, int arg3, TextFieldScrollerPosition arg4, TextFieldValue arg5, VisualTransformation arg6, Modifier arg7, Modifier arg8, Modifier arg9, Modifier arg10, BringIntoViewRequester arg11, TextFieldSelectionManager arg12, boolean arg13, boolean arg14, Function1 arg15, OffsetMapping arg16, Density arg17, Composer arg18, int arg19) {
        return CoreTextFieldKt.CoreTextField$lambda$26$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    public static Unit $r8$lambda$mNB7Y2F4EhHXnDz1jZAW7zeRepk(LegacyTextFieldState arg0, boolean arg1) {
        return CoreTextFieldKt.CoreTextField$lambda$16$0(arg0, arg1);
    }

    public static DisposableEffectResult $r8$lambda$y_oNnRl2n6FTK4XacFW-iA0X8wE(TextFieldSelectionManager arg0, DisposableEffectScope arg1) {
        return CoreTextFieldKt.CoreTextField$lambda$21$0(arg0, arg1);
    }

    public static Unit $r8$lambda$zJVGFnuWYowV4jlV1_vPeN2nSfE(TextLayoutResult arg0) {
        return CoreTextFieldKt.CoreTextField$lambda$0$0(arg0);
    }

    public static final void CoreTextField(TextFieldValue arg49, Function1 arg50, Modifier arg51, TextStyle arg52, VisualTransformation arg53, Function1 arg54, MutableInteractionSource arg55, Brush arg56, boolean arg57, int arg58, int arg59, ImeOptions arg60, KeyboardActions arg61, boolean arg62, boolean arg63, Function3 arg64, TextFieldScrollerPosition arg65, Composer arg66, int arg67, int arg68, int arg69) {
        VisualTransformation v5_10;
        TextStyle v4_2;
        boolean v9_11;
        boolean v14_5;
        Brush v8_10;
        KeyboardActions v13_4;
        TextFieldScrollerPosition v17_3;
        ImeOptions v12_8;
        Function1 v6_4;
        Function3 v16_3;
        Composer v46;
        Modifier v63_1;
        TextFieldValue v8_8;
        CoreTextFieldKt$$ExternalSyntheticLambda8 v8_6;
        Modifier v3_5;
        CoreTextFieldKt$$ExternalSyntheticLambda7 v8_5;
        CoreTextFieldKt$CoreTextField$5$1 v8_4;
        ImeOptions v57;
        OffsetMapping v12_4;
        Object v16_2;
        Object v13_3;
        Object v14_3;
        boolean v42;
        ImeOptions v11_7;
        String v40_1;
        Object v44;
        VisualTransformation v43;
        Object v52_1;
        boolean v15_5;
        TextFieldSelectionManager v7_4;
        Object v38;
        boolean v39;
        TextStyle v41;
        AnnotatedString v40;
        Object v24_1;
        TransformedText v11_4;
        int v10_5;
        Object v0_8;
        Object v37;
        Object v11_1;
        boolean v51_1;
        Object v35;
        FocusRequester v3_2;
        Brush v63;
        ImeOptions v14_1;
        boolean v10_1;
        Modifier v0_5;
        Function1 v17_1;
        TextFieldScrollerPosition v21_1;
        Function3 v18_1;
        boolean v16_1;
        boolean v34;
        KeyboardActions v15_1;
        VisualTransformation v8;
        MutableInteractionSource v7_1;
        Brush v9_1;
        ImeOptions v13_1;
        int v9_2;
        boolean v8_1;
        MutableInteractionSource v51;
        CoreTextFieldKt$$ExternalSyntheticLambda17 v10_3;
        Object v10_2;
        Companion v14_2;
        TextFieldScrollerPosition v0_2;
        int v19;
        int v17;
        int v32;
        int v31;
        int v30;
        int v29;
        Brush v7;
        MutableInteractionSource v9;
        int v24;
        Function1 v10;
        int v21;
        int v18;
        TextStyle v12;
        int v15;
        Modifier v14;
        int v11;
        int v5;
        TextFieldValue v1 = arg49;
        int v0 = arg67;
        int v2 = arg68;
        int v3 = arg69;
        Composer v4 = arg66.startRestartGroup(31062401);
        ComposerKt.sourceInformation(v4, "C(CoreTextField)N(value,onValueChange,modifier,textStyle,visualTransformation,onTextLayout,interactionSource,cursorBrush,softWrap,maxLines,minLines,imeOptions,keyboardActions,enabled,readOnly,decorationBox,textScrollerPosition)213@12062L29,214@12132L58,215@12236L72,220@12366L7,221@12427L7,222@12495L7,223@12560L7,224@12605L7,225@12674L7,246@13516L277,258@14098L21,260@14144L453,289@14997L26,292@15090L24,293@15148L37,295@15205L51,301@15494L7,303@15589L7,304@15646L7,314@16020L206,327@16443L1514,362@18064L42,363@18132L971,363@18111L992,389@19173L28,390@19269L992,412@20352L177,421@20630L577,439@21278L1606,492@23496L48,492@23470L74,494@23579L503,494@23550L532,526@24756L987,545@25860L7,546@25917L7,550@26055L327,559@26411L35,587@27673L5409,587@27620L5462:CoreTextField.kt#423gt5");
        if((v0 & 6) == 0) {
            v5 = v4.changed(v1) ? 4 : 2;
            v5 |= v0;
        }
        else {
            v5 = v0;
        }

        if((v0 & 0x30) == 0) {
            v11 = v4.changedInstance(arg50) ? 0x20 : 16;
            v5 |= v11;
        }

        v11 = v3 & 4;
        if(v11 != 0) {
            v5 |= 0x180;
            goto label_44;
        }
        else if((v0 & 0x180) == 0) {
            v14 = arg51;
            v15 = v4.changed(v14) ? 0x100 : 0x80;
            v5 |= v15;
        }
        else {
        label_44:
            v14 = arg51;
        }

        v15 = v3 & 8;
        int v16 = 0x400;
        if(v15 != 0) {
            v5 |= 0xC00;
            goto label_60;
        }
        else if((v0 & 0xC00) == 0) {
            v12 = arg52;
            v18 = v4.changed(v12) ? 0x800 : v16;
            v5 |= v18;
        }
        else {
        label_60:
            v12 = arg52;
        }

        v18 = v3 & 16;
        if(v18 != 0) {
            v5 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v21 = v4.changed(arg53) ? 0x4000 : 0x2000;
            v5 |= v21;
        }

        v21 = v3 & 0x20;
        int v22 = 0x30000;
        if(v21 != 0) {
            v5 |= v22;
            v10 = arg54;
        }
        else {
            v10 = arg54;
            if((v0 & v22) == 0) {
                v24 = v4.changedInstance(v10) ? 0x20000 : 0x10000;
                v5 |= v24;
            }
        }

        v24 = v3 & 0x40;
        int v25 = 0x180000;
        if(v24 != 0) {
            v5 |= v25;
            v9 = arg55;
        }
        else {
            v9 = arg55;
            if((v0 & v25) == 0) {
                int v27 = v4.changed(v9) ? 0x100000 : 0x80000;
                v5 |= v27;
            }
        }

        int v13 = v3 & 0x80;
        int v28 = 0xC00000;
        if(v13 != 0) {
            v5 |= v28;
            v7 = arg56;
        }
        else {
            v7 = arg56;
            if((v0 & v28) == 0) {
                v29 = v4.changed(v7) ? 0x800000 : 0x400000;
                v5 |= v29;
            }
        }

        v0 = v3 & 0x100;
        v29 = 0x6000000;
        if(v0 != 0) {
            v5 |= v29;
            goto label_137;
        }
        else if((arg67 & v29) == 0) {
            v29 = v0;
            v30 = v4.changed(arg57) ? 0x4000000 : 0x2000000;
            v5 |= v30;
        }
        else {
        label_137:
            v29 = v0;
        }

        v0 = v3 & 0x200;
        v30 = 0x30000000;
        if(v0 != 0) {
            v5 |= v30;
            goto label_155;
        }
        else if((arg67 & v30) == 0) {
            v30 = v0;
            v31 = v4.changed(arg58) ? 0x20000000 : 0x10000000;
            v5 |= v31;
        }
        else {
        label_155:
            v30 = v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v32 = v2 | 6;
            v31 = v0;
        }
        else if((v2 & 6) == 0) {
            v31 = v0;
            v32 = v4.changed(arg59) ? 4 : 2;
            v32 |= v2;
        }
        else {
            v31 = v0;
            v32 = v2;
        }

        if((v2 & 0x30) == 0) {
            int v33 = (v3 & 0x800) != 0 || !v4.changed(arg60) ? 16 : 0x20;
            v32 |= v33;
        }

        v0 = v32;
        int v6 = v3 & 0x1000;
        if(v6 != 0) {
            v0 |= 0x180;
        }
        else {
            v32 = v0;
            if((v2 & 0x180) == 0) {
                v17 = v4.changed(arg61) ? 0x100 : 0x80;
                v0 = v32 | v17;
            }
            else {
                v0 = v32;
            }
        }

        v17 = v6;
        v6 = v3 & 0x2000;
        if(v6 != 0) {
            v0 |= 0xC00;
        }
        else {
            v19 = v0;
            if((v2 & 0xC00) == 0) {
                if(v4.changed(arg62)) {
                    v16 = 0x800;
                }

                v0 = v19 | v16;
            }
            else {
                v0 = v19;
            }
        }

        v16 = v6;
        v6 = v3 & 0x4000;
        if(v6 != 0) {
            v19 = v0 | 0x6000;
        }
        else {
            v19 = v0;
            if((v2 & 0x6000) == 0) {
                v32 = v4.changed(arg63) ? 0x4000 : 0x2000;
                v19 |= v32;
            }
        }

        v32 = v3 & 0x8000;
        if(v32 != 0) {
            v19 |= v22;
        }
        else {
            Function3 v0_1 = arg64;
            if((v2 & v22) == 0) {
                v22 = v4.changedInstance(v0_1) ? 0x20000 : 0x10000;
                v19 |= v22;
            }
        }

        v22 = v3 & 0x10000;
        if(v22 != 0) {
            v19 |= v25;
        }
        else {
            v0_2 = arg65;
            if((v2 & v25) == 0) {
                v25 = v4.changed(v0_2) ? 0x100000 : 0x80000;
                v19 |= v25;
            }
        }

        v25 = v6;
        boolean v0_3 = (v5 & 306783379) != 306783378 || (v19 & 0x92493) != 0x92492 ? true : false;
        if(v4.shouldExecute(v0_3, v5 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "198@11387L2");
            DefaultConstructorMarker v2_1 = null;
            String v6_1 = "CC(remember):CoreTextField.kt#9igjgp";
            if((arg67 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v11 != 0) {
                    v14_2 = Modifier.Companion;
                }

                if(v15 != 0) {
                    v12 = TextStyle.Companion.getDefault();
                }

                VisualTransformation v0_6 = v18 != 0 ? VisualTransformation.Companion.getNone() : arg53;
                if(v21 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v4, 0xF341C223, v6_1);
                    v10_2 = v4.rememberedValue();
                    if(v10_2 == Composer.Companion.getEmpty()) {
                        v10_3 = new CoreTextFieldKt$$ExternalSyntheticLambda17();
                        v4.updateRememberedValue(v10_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v4);
                }

                if(v24 != 0) {
                    v9 = ((MutableInteractionSource)v2_1);
                }

                if(v13 != 0) {
                    v51 = v9;
                    SolidColor v7_2 = new SolidColor(Color.Companion.getUnspecified-0d7_KjU(), v2_1);
                }
                else {
                    v51 = v9;
                }

                v8_1 = v29 != 0 ? true : arg57;
                v9_2 = v30 != 0 ? 0x7FFFFFFF : arg58;
                v11 = v31 != 0 ? 1 : arg59;
                if((v3 & 0x800) != 0) {
                    v13_1 = ImeOptions.Companion.getDefault();
                    v19 &= 0xFFFFFF8F;
                }
                else {
                    v13_1 = arg60;
                }

                v15_1 = v17 != 0 ? KeyboardActions.Companion.getDefault() : arg61;
                v16_1 = v16 != 0 ? true : arg62;
                boolean v17_2 = v25 != 0 ? false : arg63;
                v18_1 = v32 != 0 ? ComposableSingletons$CoreTextFieldKt.INSTANCE.getLambda$559628295$foundation() : arg64;
                v21_1 = v22 != 0 ? ((TextFieldScrollerPosition)v2_1) : arg65;
                v34 = v16_1;
                v16_1 = v17_2;
                v2 = v19;
                v17_1 = ((Function1)v10_3);
                v10_1 = v8_1;
                v8 = v0_6;
                v0_5 = ((Modifier)v14_2);
                v14_1 = v13_1;
                v13 = v11;
                v11 = v9_2;
                v9_1 = v7;
                v7_1 = v51;
            }
            else {
                v4.skipToGroupEnd();
                if((v3 & 0x800) != 0) {
                    v19 &= 0xFFFFFF8F;
                }

                MutableInteractionSource v0_4 = v9;
                v9_1 = v7;
                v7_1 = v0_4;
                v8 = arg53;
                v11 = arg58;
                v13 = arg59;
                v15_1 = arg61;
                v34 = arg62;
                v16_1 = arg63;
                v18_1 = arg64;
                v21_1 = arg65;
                v17_1 = v10;
                v0_5 = v14;
                v2 = v19;
                v10_1 = arg57;
                v14_1 = arg60;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                v63 = v9_1;
                ComposerKt.traceEventStart(31062401, v5, v2, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:212)");
            }
            else {
                v63 = v9_1;
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0xF342169E, v6_1);
            Object v3_1 = v4.rememberedValue();
            if(v3_1 == Composer.Companion.getEmpty()) {
                v3_2 = new FocusRequester();
                v4.updateRememberedValue(v3_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3421F7B, v6_1);
            Object v9_3 = v4.rememberedValue();
            v24 = v5;
            if(v9_3 == Composer.Companion.getEmpty()) {
                LegacyPlatformTextInputServiceAdapter v9_4 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                v4.updateRememberedValue(v9_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerStart(v4, -213767031, v6_1);
            Object v5_1 = v4.rememberedValue();
            boolean v56 = v10_1;
            if(v5_1 == Composer.Companion.getEmpty()) {
                TextInputService v5_2 = new TextInputService(v9_3);
                v4.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ProvidableCompositionLocal v10_4 = CompositionLocalsKt.getLocalDensity();
            TextStyle v53 = v12;
            int v64 = v13;
            String v13_2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v10_2 = v4.consume(((CompositionLocal)v10_4));
            ComposerKt.sourceInformationMarkerEnd(v4);
            Object v58 = v10_2;
            v10_4 = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v10_2 = v4.consume(((CompositionLocal)v10_4));
            ComposerKt.sourceInformationMarkerEnd(v4);
            Object v59 = v10_2;
            v10_4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v10_2 = v4.consume(((CompositionLocal)v10_4));
            ComposerKt.sourceInformationMarkerEnd(v4);
            long v29_1 = ((TextSelectionColors)v10_2).getBackgroundColor-0d7_KjU();
            v10_4 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v10_2 = v4.consume(((CompositionLocal)v10_4));
            ComposerKt.sourceInformationMarkerEnd(v4);
            Object v65 = v10_2;
            v10_4 = CompositionLocalsKt.getLocalWindowInfo();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v10_2 = v4.consume(((CompositionLocal)v10_4));
            ComposerKt.sourceInformationMarkerEnd(v4);
            KeyboardActions v25_1 = v15_1;
            ProvidableCompositionLocal v15_2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            Object v15_3 = v4.consume(((CompositionLocal)v15_2));
            ComposerKt.sourceInformationMarkerEnd(v4);
            Orientation v12_1 = v11 != 1 || (v56) || !v14_1.getSingleLine() ? Orientation.Vertical : Orientation.Horizontal;
            Modifier v31_1 = v0_5;
            if(v21_1 == null) {
                v4.startReplaceGroup(0xF342840E);
                ComposerKt.sourceInformation(v4, "232@13005L70,232@12934L141");
                Object[] v0_7 = new Object[]{v12_1};
                v35 = v9_3;
                Saver v9_5 = TextFieldScrollerPosition.Companion.getSaver();
                v32 = v11;
                ComposerKt.sourceInformationMarkerStart(v4, 0xF3428CA7, v6_1);
                v51_1 = v4.changed(v12_1.ordinal());
                v11_1 = v4.rememberedValue();
                if(!v51_1) {
                    v37 = v10_2;
                    if(v11_1 == Composer.Companion.getEmpty()) {
                        goto label_520;
                    }
                }
                else {
                    v37 = v10_2;
                label_520:
                    CoreTextFieldKt$$ExternalSyntheticLambda2 v11_2 = new CoreTextFieldKt$$ExternalSyntheticLambda2(v12_1);
                    v4.updateRememberedValue(v11_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v0_8 = RememberSaveableKt.rememberSaveable(v0_7, v9_5, ((Function0)v11_1), v4, 0);
                v4.endReplaceGroup();
            }
            else {
                v35 = v9_3;
                v37 = v10_2;
                v32 = v11;
                v4.startReplaceGroup(0xF3427FB2);
                v4.endReplaceGroup();
                v0_2 = v21_1;
            }

            if(v0_2.getOrientation() != v12_1) {
                String v1_1 = v12_1 == Orientation.Vertical ? "only single-line, non-wrap text fields can scroll horizontally" : "single-line, non-wrap text fields can only scroll horizontally";
                throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(v1_1));
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0xF342CD56, v6_1);
            v9_2 = v24 & 14;
            v10_5 = v9_2 == 4 ? 1 : 0;
            v11 = (v24 & 0xE000) == 0x4000 ? 1 : 0;
            v10_5 |= v11;
            v11_1 = v4.rememberedValue();
            if(v10_5 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                TransformedText v10_6 = ValidatingOffsetMappingKt.filterWithValidation(v8, v1.getAnnotatedString());
                TextRange v11_3 = v1.getComposition-MzsxiRA();
                if(v11_3 != null) {
                    v24_1 = v0_2;
                    TransformedText v0_9 = TextFieldDelegate.Companion.applyCompositionDecoration-72CqOWE(v11_3.unbox-impl(), v10_6);
                    if(v0_9 == null) {
                        goto label_584;
                    }
                    else {
                        v11_4 = v0_9;
                    }
                }
                else {
                    v24_1 = v0_2;
                label_584:
                    v11_4 = v10_6;
                }

                v4.updateRememberedValue(v11_4);
            }
            else {
                v24_1 = v0_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            AnnotatedString v0_10 = ((TransformedText)v11_1).getText();
            OffsetMapping v10_7 = ((TransformedText)v11_1).getOffsetMapping();
            AnnotatedString v52 = v0_10;
            RecomposeScope v0_11 = ComposablesKt.getCurrentRecomposeScope(v4, 0);
            ComposerKt.sourceInformationMarkerStart(v4, -213705594, v6_1);
            boolean v12_2 = v4.changed(v15_3);
            Object v36 = v11_1;
            v11_1 = v4.rememberedValue();
            if((v12_2) || v11_1 == Composer.Companion.getEmpty()) {
                v40 = v52;
                v41 = v53;
                v39 = v56;
                v38 = v59;
                LegacyTextFieldState v11_5 = new LegacyTextFieldState(new TextDelegate(v52, v53, 0, 0, v56, 0, ((Density)v58), ((Resolver)v59), null, 300, null), v0_11, ((SoftwareKeyboardController)v15_3));
                v4.updateRememberedValue(v11_5);
            }
            else {
                v40 = v52;
                v41 = v53;
                v39 = v56;
                v38 = v59;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v11_1.update-fnh65Uc(v1.getAnnotatedString(), v40, v41, v39, v58, v38, arg50, v25_1, v65, v29_1);
            Object v12_3 = v11_1;
            v11_1 = v65;
            Object v62 = v58;
            ((LegacyTextFieldState)v12_3).getProcessor().reset(v1, ((LegacyTextFieldState)v12_3).getInputSession());
            ComposerKt.sourceInformationMarkerStart(v4, 0xF343857B, v6_1);
            v0_8 = v4.rememberedValue();
            if(v0_8 == Composer.Companion.getEmpty()) {
                v65 = v11_1;
                UndoManager v0_12 = new UndoManager(0, 1, null);
                v4.updateRememberedValue(v0_12);
            }
            else {
                v65 = v11_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            UndoManager.snapshotIfNeeded$default(v0_8, arg49, 0, 2, null);
            v1 = arg49;
            ComposerKt.sourceInformationMarkerStart(v4, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v4, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            v11_1 = v4.rememberedValue();
            if(v11_1 == Composer.Companion.getEmpty()) {
                CoroutineScope v11_6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v4);
                v4.updateRememberedValue(v11_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3439866, v6_1);
            v15_3 = v4.rememberedValue();
            MutableInteractionSource v30_1 = v7_1;
            if(v15_3 == Composer.Companion.getEmpty()) {
                BringIntoViewRequester v15_4 = BringIntoViewRequesterKt.BringIntoViewRequester();
                v4.updateRememberedValue(v15_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3439F94, v6_1);
            Object v7_3 = v4.rememberedValue();
            Object v61 = v15_3;
            if(v7_3 == Composer.Companion.getEmpty()) {
                v7_4 = new TextFieldSelectionManager(((UndoManager)v0_8));
                v4.updateRememberedValue(v7_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v7_4.setOffsetMapping$foundation(v10_7);
            v7_4.setVisualTransformation$foundation(v8);
            v7_4.setOnValueChange$foundation(((LegacyTextFieldState)v12_3).getOnValueChange());
            v7_4.setState$foundation(((LegacyTextFieldState)v12_3));
            v7_4.setValue$foundation(v1);
            v15_2 = CompositionLocalsKt.getLocalClipboard();
            Object v29_2 = v0_8;
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v15_3 = v4.consume(((CompositionLocal)v15_2));
            ComposerKt.sourceInformationMarkerEnd(v4);
            v7_4.setClipboard$foundation(((Clipboard)v15_3));
            v7_4.setCoroutineScope$foundation(((CoroutineScope)v11_1));
            v15_2 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v15_3 = v4.consume(((CompositionLocal)v15_2));
            ComposerKt.sourceInformationMarkerEnd(v4);
            v7_4.setTextToolbar(((TextToolbar)v15_3));
            v15_2 = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v13_2);
            v0_8 = v4.consume(((CompositionLocal)v15_2));
            ComposerKt.sourceInformationMarkerEnd(v4);
            v7_4.setHapticFeedBack(((HapticFeedback)v0_8));
            v7_4.setFocusRequester(v3_2);
            v7_4.setEditable((((int)v16_1)) ^ 1);
            v7_4.setEnabled(v34);
            boolean v53_1 = v34;
            v0 = 6;
            if(ComposeFoundationFlags.isSmartSelectionEnabled) {
                v4.startReplaceGroup(0x753A5109);
                ComposerKt.sourceInformation(v4, "311@15921L87");
                v7_4.setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, v41.getLocaleList(), v4, v0));
            }
            else {
                v4.startReplaceGroup(1951015297);
            }

            v4.endReplaceGroup();
            ((LegacyTextFieldState)v12_3).getHasFocus();
            new CoreTextFieldKt$$ExternalSyntheticLambda3(v7_4);
            new CoreTextFieldKt$$ExternalSyntheticLambda4(v7_4);
            new CoreTextFieldKt$$ExternalSyntheticLambda5(v7_4);
            ComposerKt.sourceInformationMarkerStart(v4, 0x47648F82, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(v4);
            Companion v1_2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF344400B, v6_1);
            v15_5 = v4.changedInstance(v12_3);
            v0 = v2 & 0x1C00;
            int v38_1 = v2;
            v2 = v0 == 0x800 ? 1 : 0;
            v2 |= ((int)v15_5);
            v15 = v38_1 & 0xE000;
            int v51_2 = v2;
            v2 = v15 == 0x4000 ? 1 : 0;
            v51_2 = v51_2 | v2 | v4.changedInstance(v5_1);
            v2 = v9_2 == 4 ? 1 : 0;
            v51_2 |= v2;
            v2 = v38_1 & 0x70 ^ 0x30;
            Object v55 = v5_1;
            v5 = 0x20;
            if(v2 <= v5 || !v4.changed(v14_1)) {
                v52_1 = v12_3;
                if((v38_1 & 0x30) == v5) {
                label_813:
                    v5 = 1;
                }
                else {
                    v5 = 0;
                }
            }
            else {
                v52_1 = v12_3;
                goto label_813;
            }

            v12_3 = v61;
            v51_2 = v51_2 | v5 | v4.changedInstance(v10_7) | v4.changedInstance(v11_1) | v4.changedInstance(v12_3) | v4.changedInstance(v7_4);
            v5_1 = v4.rememberedValue();
            if(v51_2 == 0) {
                v59 = v7_4;
                if(v5_1 == Composer.Companion.getEmpty()) {
                    goto label_847;
                }
                else {
                    v43 = v8;
                    v44 = v11_1;
                    v40_1 = v13_2;
                    v11_7 = v14_1;
                    v42 = v16_1;
                    v14_3 = v52_1;
                    v8_1 = v53_1;
                    v13_3 = v59;
                    v16_2 = v12_3;
                    v12_4 = v10_7;
                    v10_2 = v55;
                }
            }
            else {
                v59 = v7_4;
            label_847:
                OffsetMapping v58_1 = v10_7;
                Object v60 = v11_1;
                v61 = v12_3;
                v57 = v14_1;
                CoreTextFieldKt$$ExternalSyntheticLambda6 v5_3 = new CoreTextFieldKt$$ExternalSyntheticLambda6(((LegacyTextFieldState)v52_1), v53_1, v16_1, ((TextInputService)v55), arg49, v57, v58_1, ((TextFieldSelectionManager)v59), ((CoroutineScope)v60), ((BringIntoViewRequester)v61));
                v14_3 = v52_1;
                v42 = v16_1;
                v10_2 = v55;
                v11_7 = v57;
                v12_4 = v58_1;
                v44 = v60;
                v16_2 = v61;
                v43 = v8;
                v40_1 = v13_2;
                v8_1 = v53_1;
                v13_3 = v59;
                v4.updateRememberedValue(v5_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v7_1 = v30_1;
            Modifier v1_3 = TextFieldGestureModifiersKt.textFieldFocusModifier(((Modifier)v1_2), v8_1, v3_2, v7_1, ((Function1)v5_1));
            boolean v5_4 = !v8_1 || (v42) ? false : true;
            v61 = v3_2;
            State v5_5 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(v5_4), v4, 0);
            Unit v3_3 = Unit.INSTANCE;
            boolean v30_2 = v8_1;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF345110C, v6_1);
            int v8_2 = v4.changed(v5_5) | v4.changedInstance(v14_3) | v4.changedInstance(v10_2) | v4.changedInstance(v13_3);
            State v53_2 = v5_5;
            v5 = 0x20;
            if(v2 <= v5 || !v4.changed(v11_7)) {
                v51_2 = v8_2;
                if((v38_1 & 0x30) == v5) {
                label_903:
                    v5 = 1;
                }
                else {
                    v5 = 0;
                }
            }
            else {
                v51_2 = v8_2;
                goto label_903;
            }

            Object v8_3 = v4.rememberedValue();
            if((v51_2 | v5) != 0 || v8_3 == Composer.Companion.getEmpty()) {
                v8_4 = new CoreTextFieldKt$CoreTextField$5$1(v14_3, v53_2, v10_2, v13_3, v11_7, null);
                v5_5 = v53_2;
                v4.updateRememberedValue(v8_4);
            }
            else {
                v5_5 = v53_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            State v45 = v5_5;
            EffectsKt.LaunchedEffect(v3_3, ((Function2)v8_4), v4, 6);
            Companion v3_4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3458F7D, v6_1);
            v5_4 = v4.changedInstance(v14_3);
            v8_3 = v4.rememberedValue();
            if((v5_4) || v8_3 == Composer.Companion.getEmpty()) {
                v8_5 = new CoreTextFieldKt$$ExternalSyntheticLambda7(((LegacyTextFieldState)v14_3));
                v4.updateRememberedValue(v8_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v3_5 = SelectionGesturesKt.updateSelectionTouchMode(((Modifier)v3_4), ((Function1)v8_5));
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3459F41, v6_1);
            v5_4 = v4.changedInstance(v14_3);
            v8_2 = v15 == 0x4000 ? 1 : 0;
            v5 = (((int)v5_4)) | v8_2;
            v8_2 = v0 == 0x800 ? 1 : 0;
            v5 = v5 | v8_2 | v4.changedInstance(v12_4) | v4.changedInstance(v13_3);
            v8_3 = v4.rememberedValue();
            if(v5 != 0 || v8_3 == Composer.Companion.getEmpty()) {
                v8_6 = new CoreTextFieldKt$$ExternalSyntheticLambda8(v14_3, v61, v42, v30_2, v13_3, v12_4);
                v5_1 = v61;
                v15_5 = v30_2;
                v4.updateRememberedValue(v8_6);
            }
            else {
                v5_1 = v61;
                v15_5 = v30_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v3_5 = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(v3_5, v7_1, v15_5, ((Function1)v8_6));
            MouseSelectionObserver v8_7 = ((TextFieldSelectionManager)v13_3).getMouseSelectionObserver$foundation();
            v61 = v5_1;
            TextDragObserver v5_6 = ((TextFieldSelectionManager)v13_3).getTouchSelectionObserver$foundation();
            arg60 = v11_7;
            ComposerKt.sourceInformationMarkerStart(v4, -213507214, v6_1);
            v51_1 = v4.changedInstance(v13_3);
            v11_1 = v4.rememberedValue();
            if(!v51_1) {
                v53_1 = v15_5;
                if(v11_1 == Composer.Companion.getEmpty()) {
                    goto label_1006;
                }
            }
            else {
                v53_1 = v15_5;
            label_1006:
                CoreTextFieldKt$CoreTextField$pointerModifier$3$1 v11_8 = new CoreTextFieldKt$CoreTextField$pointerModifier$3$1(((TextFieldSelectionManager)v13_3));
                v4.updateRememberedValue(v11_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v3_5 = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(v3_5, v8_7, v5_6, ((PointerInputEventHandler)v11_1)), PointerIcon.Companion.getText(), false, 2, null);
            Companion v5_7 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF34647C2, v6_1);
            v8_1 = v4.changedInstance(v14_3);
            v11 = v9_2 == 4 ? 1 : 0;
            v8_2 = (((int)v8_1)) | v11 | v4.changedInstance(v12_4);
            v11_1 = v4.rememberedValue();
            if(v8_2 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                v8_8 = arg49;
                CoreTextFieldKt$$ExternalSyntheticLambda9 v11_9 = new CoreTextFieldKt$$ExternalSyntheticLambda9(((LegacyTextFieldState)v14_3), v8_8, v12_4);
                v4.updateRememberedValue(v11_9);
            }
            else {
                v8_8 = arg49;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Modifier v5_8 = DrawModifierKt.drawBehind(((Modifier)v5_7), ((Function1)v11_1));
            Companion v11_10 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3469CC7, v6_1);
            v15_5 = v4.changedInstance(v14_3);
            Modifier v19_1 = v5_8;
            v0 = v0 == 0x800 ? 1 : 0;
            v5_1 = v37;
            v0 = v0 | (((int)v15_5)) | v4.changed(v5_1) | v4.changedInstance(v13_3);
            v15 = v9_2 == 4 ? 1 : 0;
            v0 = v0 | v15 | v4.changedInstance(v12_4);
            v15_3 = v4.rememberedValue();
            if(v0 != 0 || v15_3 == Composer.Companion.getEmpty()) {
                CoreTextFieldKt$$ExternalSyntheticLambda10 v15_6 = new CoreTextFieldKt$$ExternalSyntheticLambda10(v14_3, v53_1, v5_1, v13_3, v8_8, v12_4);
                v30_2 = v53_1;
                v37 = v5_1;
                v4.updateRememberedValue(v15_6);
            }
            else {
                v30_2 = v53_1;
                v37 = v5_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Modifier v11_11 = OnGloballyPositionedModifierKt.onGloballyPositioned(((Modifier)v11_10), ((Function1)v15_3));
            v8 = v43;
            CoreTextFieldSemanticsModifier v15_7 = new CoreTextFieldSemanticsModifier(v36, arg49, v14_3, v42, v30_2, v8 instanceof PasswordVisualTransformation, v12_4, v13_3, arg60, ((FocusRequester)v61));
            v5_4 = v30_2;
            ImeOptions v0_13 = arg60;
            boolean v20 = !v5_4 || (v42) || !((WindowInfo)v37).isWindowFocused() || (((LegacyTextFieldState)v14_3).hasHighlight()) ? false : true;
            OffsetMapping v54 = v12_4;
            v52_1 = v14_3;
            Modifier v12_5 = TextFieldCursorKt.cursor(Modifier.Companion, ((LegacyTextFieldState)v52_1), arg49, v54, v63, v20);
            TextFieldValue v14_4 = arg49;
            OffsetMapping v20_1 = v54;
            Brush v26 = v63;
            v43 = v8;
            Modifier v61_1 = v11_11;
            v8_3 = v52_1;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF347ABF1, v6_1);
            v51_1 = v4.changedInstance(v13_3);
            v11_1 = v4.rememberedValue();
            if(!v51_1) {
                v63_1 = v12_5;
                if(v11_1 == Composer.Companion.getEmpty()) {
                    goto label_1143;
                }
            }
            else {
                v63_1 = v12_5;
            label_1143:
                CoreTextFieldKt$$ExternalSyntheticLambda18 v11_12 = new CoreTextFieldKt$$ExternalSyntheticLambda18(((TextFieldSelectionManager)v13_3));
                v4.updateRememberedValue(v11_12);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            EffectsKt.DisposableEffect(v13_3, ((Function1)v11_1), v4, 0);
            ComposerKt.sourceInformationMarkerStart(v4, -213403624, v6_1);
            v11 = v4.changedInstance(v8_3) | v4.changedInstance(v10_2);
            int v12_6 = v9_2 == 4 ? 1 : 0;
            v9_2 = v11 | v12_6;
            v11 = 0x20;
            v12_6 = v2 > v11 && (v4.changed(v0_13)) || (v38_1 & 0x30) == v11 ? 1 : 0;
            v2 = v9_2 | v12_6;
            v9_3 = v4.rememberedValue();
            if(v2 != 0 || v9_3 == Composer.Companion.getEmpty()) {
                CoreTextFieldKt$$ExternalSyntheticLambda19 v9_6 = new CoreTextFieldKt$$ExternalSyntheticLambda19(((LegacyTextFieldState)v8_3), ((TextInputService)v10_2), v14_4, v0_13);
                v4.updateRememberedValue(v9_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            EffectsKt.DisposableEffect(v0_13, ((Function1)v9_3), v4, v38_1 >> 3 & 14);
            Companion v2_2 = Modifier.Companion;
            Function1 v9_7 = ((LegacyTextFieldState)v8_3).getOnValueChange();
            v10_5 = (((int)v42)) ^ 1;
            v12_6 = v32;
            boolean v23 = v12_6 == 1 ? true : false;
            Modifier v2_3 = TextFieldKeyInputKt.textFieldKeyInput-2WJ9YEU(v2_2, v8_3, v13_3, v14_4, v9_7, v10_5, v23, v20_1, v29_2, v0_13.getImeAction-eUduSuo());
            v14_3 = v8_3;
            v8_1 = (KeyboardType.equals-impl0(v0_13.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE())) || (KeyboardType.equals-impl0(v0_13.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getNumberPassword-PjHm6EE())) ? false : true;
            Companion v9_8 = Modifier.Companion;
            v10_1 = CoreTextFieldKt.CoreTextField$lambda$14(v45);
            ComposerKt.sourceInformationMarkerStart(v4, 0xF3484D1C, v6_1);
            v57 = v0_13;
            v0_8 = v35;
            v51_2 = v4.changed(v8_1) | v4.changedInstance(v0_8);
            v11_1 = v4.rememberedValue();
            if(v51_2 == 0) {
                v32 = v12_6;
                if(v11_1 == Composer.Companion.getEmpty()) {
                    goto label_1235;
                }
            }
            else {
                v32 = v12_6;
            label_1235:
                CoreTextFieldKt$$ExternalSyntheticLambda20 v11_13 = new CoreTextFieldKt$$ExternalSyntheticLambda20(v8_1, ((LegacyPlatformTextInputServiceAdapter)v0_8));
                v4.updateRememberedValue(v11_13);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Modifier v8_9 = StylusHandwritingKt.stylusHandwriting(((Modifier)v9_8), v10_1, v8_1, ((Function0)v11_1));
            ProvidableCompositionLocal v9_9 = AutofillHighlightKt.getLocalAutofillHighlightBrush();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v40_1);
            v9_3 = v4.consume(((CompositionLocal)v9_9));
            ComposerKt.sourceInformationMarkerEnd(v4);
            ProvidableCompositionLocal v12_7 = AutofillHighlightKt.getLocalAutofillHighlightColor();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v40_1);
            v10_2 = v4.consume(((CompositionLocal)v12_7));
            ComposerKt.sourceInformationMarkerEnd(v4);
            Modifier v52_2 = v2_3;
            arg51 = v3_5;
            Brush v2_4 = AutofillHighlightKt.resolveAutofillHighlight-WkMS-hQ(((Brush)v9_3), ((Color)v10_2).unbox-impl(), AutofillHighlight_androidKt.autofillHighlightColor());
            v3_4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v4, 0xF348ECE8, v6_1);
            v6 = v4.changedInstance(v14_3) | v4.changed(v2_4);
            v9_3 = v4.rememberedValue();
            if(v6 != 0 || v9_3 == Composer.Companion.getEmpty()) {
                CoreTextFieldKt$$ExternalSyntheticLambda21 v9_10 = new CoreTextFieldKt$$ExternalSyntheticLambda21(((LegacyTextFieldState)v14_3), v2_4);
                v4.updateRememberedValue(v9_10);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v2_3 = DrawModifierKt.drawWithContent(((Modifier)v3_4), ((Function1)v9_3));
            OverscrollEffect v3_6 = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(v4, 0);
            Modifier v6_2 = v31_1;
            v0_5 = CoreTextFieldKt.previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(v6_2.then(v2_3), ((LegacyPlatformTextInputServiceAdapter)v0_8), ((LegacyTextFieldState)v14_3), ((TextFieldSelectionManager)v13_3)).then(v8_9).then(v1_3), ((LegacyTextFieldState)v14_3), v65), ((LegacyTextFieldState)v14_3), ((TextFieldSelectionManager)v13_3));
            Object v1_4 = v24_1;
            v0_5 = CoreTextFieldKt.addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(v0_5.then(v52_2), ((TextFieldScrollerPosition)v1_4), v7_1, v5_4, v3_6).then(arg51).then(v15_7), new CoreTextFieldKt$$ExternalSyntheticLambda22(((LegacyTextFieldState)v14_3))), ((TextFieldSelectionManager)v13_3), v44);
            v15_5 = !v5_4 || !((LegacyTextFieldState)v14_3).getHasFocus() || !((LegacyTextFieldState)v14_3).isInTouchMode() || !((WindowInfo)v37).isWindowFocused() ? false : true;
            if(v15_5) {
                v2_3 = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.Companion, ((TextFieldSelectionManager)v13_3));
            }
            else {
                v2_2 = Modifier.Companion;
            }

            v46 = v4;
            v30_2 = v5_4;
            v31_1 = v6_2;
            MutableInteractionSource v22_1 = v7_1;
            int v4_1 = v64;
            Object v6_3 = v1_4;
            Function3 v1_5 = v18_1;
            OffsetMapping v18_2 = v20_1;
            ImeOptions v20_2 = v57;
            Composer v5_9 = v46;
            CoreTextFieldKt.CoreTextFieldRootBox(v0_5, v13_3, ComposableLambdaKt.rememberComposableLambda(0xCF72BDF7, true, new CoreTextFieldKt$$ExternalSyntheticLambda23(v1_5, v14_3, v41, v4_1, v32, ((TextFieldScrollerPosition)v6_3), arg49, v43, v63_1, v19_1, v61_1, ((Modifier)v2_2), v16_2, v13_3, v15_5, v42, v17_1, v18_2, v62), v5_9, 54), v5_9, 0x180);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v16_3 = v1_5;
            v11 = v4_1;
            v46 = v5_9;
            v6_4 = v17_1;
            v12_8 = v20_2;
            v17_3 = v21_1;
            v7_1 = v22_1;
            v13_4 = v25_1;
            v8_10 = v26;
            v14_5 = v30_2;
            v3_5 = v31_1;
            v10_5 = v32;
            v9_11 = v39;
            v4_2 = v41;
            v15_5 = v42;
            v5_10 = v43;
        }
        else {
            v4.skipToGroupEnd();
            v11 = arg59;
            v13_4 = arg61;
            v15_5 = arg63;
            v16_3 = arg64;
            v17_3 = arg65;
            v46 = v4;
            v8_10 = v7;
            v7_1 = v9;
            v6_4 = v10;
            v4_2 = v12;
            v3_5 = v14;
            v5_10 = arg53;
            v9_11 = arg57;
            v10_5 = arg58;
            v12_8 = arg60;
            v14_5 = arg62;
        }

        ScopeUpdateScope v0_14 = v46.endRestartGroup();
        if(v0_14 != null) {
            v0_14.updateScope(new CoreTextFieldKt$$ExternalSyntheticLambda1(arg49, arg50, v3_5, v4_2, v5_10, v6_4, v7_1, v8_10, v9_11, v10_5, v11, v12_8, v13_4, v14_5, v15_5, v16_3, v17_3, arg67, arg68, arg69));
        }
    }

    private static final Unit CoreTextField$lambda$0$0(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$10(TextFieldSelectionManager arg0, AnnotatedString arg1) {
        arg0.paste$foundation(arg1);
        return Unit.INSTANCE;
    }

    static final AnnotatedString CoreTextField$lambda$11(TextFieldSelectionManager arg3) {
        return TextFieldSelectionManager.copyWithResult$foundation$default(arg3, false, 1, null);
    }

    static final AnnotatedString CoreTextField$lambda$12(TextFieldSelectionManager arg0) {
        return arg0.cutWithResult$foundation();
    }

    private static final Unit CoreTextField$lambda$13$0(LegacyTextFieldState arg7, boolean arg8, boolean arg9, TextInputService arg10, TextFieldValue arg11, ImeOptions arg12, OffsetMapping arg13, TextFieldSelectionManager arg14, CoroutineScope arg15, BringIntoViewRequester arg16, FocusState arg17) {
        if(arg7.getHasFocus() == arg17.isFocused()) {
            return Unit.INSTANCE;
        }

        arg7.setHasFocus(arg17.isFocused());
        if(!arg7.getHasFocus() || !arg8 || (arg9)) {
            CoreTextFieldKt.endInputSession(arg7);
        }
        else {
            CoreTextFieldKt.startInputSession(arg10, arg7, arg11, arg12, arg13);
        }

        if(arg17.isFocused()) {
            TextLayoutResultProxy v4 = arg7.getLayoutResult();
            if(v4 != null) {
                BuildersKt.launch$default(arg15, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(arg16, arg11, arg7, v4, arg13, null), 3, null);
            }
        }

        if(!arg17.isFocused()) {
            TextFieldSelectionManager.deselect-_kEHs6E$foundation$default(arg14, null, 1, null);
        }

        return Unit.INSTANCE;
    }

    private static final boolean CoreTextField$lambda$14(State arg0) {
        return arg0.getValue().booleanValue();
    }

    private static final Unit CoreTextField$lambda$16$0(LegacyTextFieldState arg0, boolean arg1) {
        arg0.setInTouchMode(arg1);
        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$17$0(LegacyTextFieldState arg7, FocusRequester arg8, boolean arg9, boolean arg10, TextFieldSelectionManager arg11, OffsetMapping arg12, Offset arg13) {
        CoreTextFieldKt.tapToFocus(arg7, arg8, (((int)arg9)) ^ 1);
        if((arg7.getHasFocus()) && (arg10)) {
            if(arg7.getHandleState() != HandleState.Selection) {
                TextLayoutResultProxy v3 = arg7.getLayoutResult();
                if(v3 != null) {
                    TextFieldDelegate.Companion.setCursorOffset-ULxng0E$foundation(arg13.unbox-impl(), v3, arg7.getProcessor(), arg12, arg7.getOnValueChange());
                    if(arg7.getTextDelegate().getText().length() > 0) {
                        arg7.setHandleState(HandleState.Cursor);
                    }
                }
            }
            else {
                arg11.deselect-_kEHs6E$foundation(arg13);
            }
        }

        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$19$0(LegacyTextFieldState arg14, TextFieldValue arg15, OffsetMapping arg16, DrawScope arg17) {
        TextLayoutResultProxy v0 = arg14.getLayoutResult();
        if(v0 != null) {
            TextFieldDelegate.Companion.draw-Q1vqE60$foundation(arg17.getDrawContext().getCanvas(), arg15, arg14.getSelectionPreviewHighlightRange-d9O1mEE(), arg14.getDeletionPreviewHighlightRange-d9O1mEE(), arg16, v0.getValue(), arg14.getHighlightPaint(), arg14.getSelectionBackgroundColor-0d7_KjU());
        }

        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$20$0(LegacyTextFieldState arg1, boolean arg2, WindowInfo arg3, TextFieldSelectionManager arg4, TextFieldValue arg5, OffsetMapping arg6, LayoutCoordinates arg7) {
        arg1.setLayoutCoordinates(arg7);
        TextLayoutResultProxy v0 = arg1.getLayoutResult();
        if(v0 != null) {
            v0.setInnerTextFieldCoordinates(arg7);
        }

        if(arg2) {
            if(arg1.getHandleState() == HandleState.Selection) {
                if(!arg1.getShowFloatingToolbar() || !arg3.isWindowFocused()) {
                    arg4.hideSelectionToolbar$foundation();
                }
                else {
                    arg4.showSelectionToolbar$foundation();
                }

                arg1.setShowSelectionHandleStart(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(arg4, true));
                arg1.setShowSelectionHandleEnd(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(arg4, false));
                arg1.setShowCursorHandle(TextRange.getCollapsed-impl(arg5.getSelection-d9O1mEE()));
            }
            else {
                if(arg1.getHandleState() != HandleState.Cursor) {
                    goto label_30;
                }

                arg1.setShowCursorHandle(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(arg4, true));
            }

        label_30:
            CoreTextFieldKt.notifyFocusedRect(arg1, arg5, arg6);
            TextLayoutResultProxy v2 = arg1.getLayoutResult();
            if(v2 == null) {
                goto label_39;
            }

            TextInputSession v3 = arg1.getInputSession();
            if(v3 == null) {
                goto label_39;
            }

            if(!arg1.getHasFocus()) {
                goto label_39;
            }

            TextFieldDelegate.Companion.updateTextLayoutResult$foundation(v3, arg5, arg6, v2);
        }

    label_39:
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult CoreTextField$lambda$21$0(TextFieldSelectionManager arg0, DisposableEffectScope arg1) {
        return new CoreTextFieldKt$CoreTextField$lambda$21$0$$inlined$onDispose$1(arg0);
    }

    private static final DisposableEffectResult CoreTextField$lambda$22$0(LegacyTextFieldState arg7, TextInputService arg8, TextFieldValue arg9, ImeOptions arg10, DisposableEffectScope arg11) {
        if(arg7.getHasFocus()) {
            arg7.setInputSession(TextFieldDelegate.Companion.restartInput$foundation(arg8, arg9, arg7.getProcessor(), arg10, arg7.getOnValueChange(), arg7.getOnImeActionPerformed()));
        }

        return new CoreTextFieldKt$CoreTextField$lambda$22$0$$inlined$onDispose$1();
    }

    private static final Unit CoreTextField$lambda$23$0(boolean arg0, LegacyPlatformTextInputServiceAdapter arg1) {
        if(arg0) {
            arg1.startStylusHandwriting();
        }

        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$24$0(LegacyTextFieldState arg12, Brush arg13, ContentDrawScope arg14) {
        arg14.drawContent();
        if((arg12.getAutofillHighlightOn()) || (arg12.getJustAutofilled())) {
            DrawScope.drawRect-AsUm42w$default(arg14, arg13, 0, 0, 0f, null, null, 0, 0x7E, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$25(LegacyTextFieldState arg0, LayoutCoordinates arg1) {
        TextLayoutResultProxy v0 = arg0.getLayoutResult();
        if(v0 != null) {
            v0.setDecorationBoxCoordinates(arg1);
        }

        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$26(Function3 arg25, LegacyTextFieldState arg26, TextStyle arg27, int arg28, int arg29, TextFieldScrollerPosition arg30, TextFieldValue arg31, VisualTransformation arg32, Modifier arg33, Modifier arg34, Modifier arg35, Modifier arg36, BringIntoViewRequester arg37, TextFieldSelectionManager arg38, boolean arg39, boolean arg40, Function1 arg41, OffsetMapping arg42, Density arg43, Composer arg44, int arg45) {
        Composer v0 = arg44;
        int v1 = arg45;
        ComposerKt.sourceInformation(v0, "C588@27697L5379,588@27683L5393:CoreTextField.kt#423gt5");
        boolean v2 = (v1 & 3) != 2 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCF72BDF7, v1, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:588)");
            }

            arg25.invoke(ComposableLambdaKt.rememberComposableLambda(0xFD5B53F2, true, new CoreTextFieldKt$$ExternalSyntheticLambda15(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43), v0, 54), v0, Integer.valueOf(6));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_52;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0.skipToGroupEnd();
        }

    label_52:
        return Unit.INSTANCE;
    }

    private static final Unit CoreTextField$lambda$26$0(LegacyTextFieldState arg14, TextStyle arg15, int arg16, int arg17, TextFieldScrollerPosition arg18, TextFieldValue arg19, VisualTransformation arg20, Modifier arg21, Modifier arg22, Modifier arg23, Modifier arg24, BringIntoViewRequester arg25, TextFieldSelectionManager arg26, boolean arg27, boolean arg28, Function1 arg29, OffsetMapping arg30, Density arg31, Composer arg32, int arg33) {
        CoreTextFieldKt$$ExternalSyntheticLambda11 v4_2;
        Composer v10 = arg32;
        int v1 = arg33;
        ComposerKt.sourceInformation(v10, "C602@28548L22,611@28935L4131,611@28899L4167:CoreTextField.kt#423gt5");
        int v4 = 2;
        boolean v3 = (v1 & 3) != v4 ? true : false;
        if(v10.shouldExecute(v3, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xFD5B53F2, v1, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:591)");
            }

            int v9 = arg17;
            Modifier v1_1 = HeightInLinesModifierKt.heightInLines(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, arg14.getMinHeightForSingleLineField-D9Ej5fM(), 0f, v4, null), arg15, arg16, v9);
            ComposerKt.sourceInformationMarkerStart(v10, 0x13D689E8, "CC(remember):CoreTextField.kt#9igjgp");
            v3 = v10.changedInstance(arg14);
            Object v4_1 = v10.rememberedValue();
            if((v3) || v4_1 == Composer.Companion.getEmpty()) {
                v4_2 = new CoreTextFieldKt$$ExternalSyntheticLambda11(arg14);
                v10.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(v1_1, arg18, arg19, arg20, ((Function0)v4_2)).then(arg21).then(arg22), arg15).then(arg23).then(arg24), arg25), ComposableLambdaKt.rememberComposableLambda(0x54340CE8, true, new CoreTextFieldKt$$ExternalSyntheticLambda16(arg26, arg14, arg27, arg28, arg29, arg19, arg30, arg31, v9), v10, 54), v10, 0x30, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_76;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v10.skipToGroupEnd();
        }

    label_76:
        return Unit.INSTANCE;
    }

    private static final TextLayoutResultProxy CoreTextField$lambda$26$0$0$0(LegacyTextFieldState arg0) {
        return arg0.getLayoutResult();
    }

    private static final Unit CoreTextField$lambda$26$0$1(TextFieldSelectionManager arg14, LegacyTextFieldState arg15, boolean arg16, boolean arg17, Function1 arg18, TextFieldValue arg19, OffsetMapping arg20, Density arg21, int arg22, Composer arg23, int arg24) {
        Composer v0 = arg23;
        int v1 = arg24;
        ComposerKt.sourceInformation(v0, "C612@28953L3502,677@32473L359:CoreTextField.kt#423gt5");
        boolean v4 = true;
        boolean v2 = (v1 & 3) != 2 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x54340CE8, v1, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:612)");
            }

            CoreTextFieldKt$CoreTextField$8$1$1$2 v7 = new CoreTextFieldKt$CoreTextField$8$1$1$2(arg15, arg18, arg19, arg20, arg21, arg22);
            ComposerKt.sourceInformationMarkerStart(v0, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            Companion v1_1 = Modifier.Companion;
            int v2_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v0, 0));
            CompositionLocalMap v3 = v0.getCurrentCompositionLocalMap();
            Modifier v1_2 = ComposedModifierKt.materializeModifier(v0, ((Modifier)v1_1));
            Function0 v6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v0, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v0.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v0.startReusableNode();
            if(v0.getInserting()) {
                v0.createNode(v6);
            }
            else {
                v0.useNode();
            }

            Composer v6_1 = Updater.constructor-impl(v0);
            Updater.set-impl(v6_1, v7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_1, v3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v6_1, Integer.valueOf(v2_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v6_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v6_1, v1_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v0, 0x602AAE32, "C:CoreTextField.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(v0);
            v0.endNode();
            ComposerKt.sourceInformationMarkerEnd(v0);
            ComposerKt.sourceInformationMarkerEnd(v0);
            if(arg15.getHandleState() == HandleState.None || arg15.getLayoutCoordinates() == null) {
            label_87:
                v4 = false;
            }
            else {
                LayoutCoordinates v1_3 = arg15.getLayoutCoordinates();
                Intrinsics.checkNotNull(v1_3);
                if(!v1_3.isAttached()) {
                    goto label_87;
                }
                else if(arg16) {
                }
                else {
                    goto label_87;
                }
            }

            CoreTextFieldKt.SelectionToolbarAndHandles(arg14, v4, v0, 0);
            if(arg15.getHandleState() != HandleState.Cursor || (arg17) || !arg16) {
                v0.startReplaceGroup(0xD373EB1A);
            }
            else {
                v0.startReplaceGroup(0xD5670F2A);
                ComposerKt.sourceInformation(v0, "689@32994L40");
                CoreTextFieldKt.TextFieldCursorHandle(arg14, v0, 0);
            }

            v0.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_108;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0.skipToGroupEnd();
        }

    label_108:
        return Unit.INSTANCE;
    }

    static final Unit CoreTextField$lambda$27(TextFieldValue arg22, Function1 arg23, Modifier arg24, TextStyle arg25, VisualTransformation arg26, Function1 arg27, MutableInteractionSource arg28, Brush arg29, boolean arg30, int arg31, int arg32, ImeOptions arg33, KeyboardActions arg34, boolean arg35, boolean arg36, Function3 arg37, TextFieldScrollerPosition arg38, int arg39, int arg40, int arg41, Composer arg42, int arg43) {
        CoreTextFieldKt.CoreTextField(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg42, RecomposeScopeImplKt.updateChangedFlags(arg39 | 1), RecomposeScopeImplKt.updateChangedFlags(arg40), arg41);
        return Unit.INSTANCE;
    }

    private static final TextFieldScrollerPosition CoreTextField$lambda$4$0(Orientation arg4) {
        return new TextFieldScrollerPosition(arg4, 0f, 2, null);
    }

    private static final void CoreTextFieldRootBox(Modifier arg8, TextFieldSelectionManager arg9, Function2 arg10, Composer arg11, int arg12) {
        int v2;
        int v1;
        int v0 = 2036174316;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(CoreTextFieldRootBox)N(modifier,manager,content)702@33241L83:CoreTextField.kt#423gt5");
        if((arg12 & 6) == 0) {
            v1 = arg11.changed(arg8) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v2 = arg11.changedInstance(arg9) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg12 & 0x180) == 0) {
            v2 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:701)");
            }

            ComposerKt.sourceInformationMarkerStart(arg11, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v0_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(arg11, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg11, 0));
            CompositionLocalMap v3 = arg11.getCurrentCompositionLocalMap();
            Modifier v4 = ComposedModifierKt.materializeModifier(arg11, arg8);
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg11, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v5);
            }
            else {
                arg11.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v5_1, v0_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v5_1, Integer.valueOf(v2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v5_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v5_1, v4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(arg11, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(arg11, 0x6B415410, "C702@33289L33:CoreTextField.kt#423gt5");
            ContextMenu_androidKt.ContextMenuArea(arg9, arg10, arg11, v1 >> 3 & 0x7E);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_112;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_112:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new CoreTextFieldKt$$ExternalSyntheticLambda0(arg8, arg9, arg10, arg12));
        }
    }

    static final Unit CoreTextFieldRootBox$lambda$1(Modifier arg0, TextFieldSelectionManager arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        CoreTextFieldKt.CoreTextFieldRootBox(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final void SelectionToolbarAndHandles(TextFieldSelectionManager arg9, boolean arg10, Composer arg11, int arg12) {
        LegacyTextFieldState v0_2;
        int v2;
        int v1;
        int v0 = 626339208;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(SelectionToolbarAndHandles)N(manager,show):CoreTextField.kt#423gt5");
        if((arg12 & 6) == 0) {
            v1 = arg11.changedInstance(arg9) ? 4 : 2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v2 = arg11.changed(arg10) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg11.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1054)");
            }

            if(arg10) {
                v0 = 1530097388;
                arg11.startReplaceGroup(v0);
                String v2_2 = "";
                ComposerKt.sourceInformation(arg11, v2_2);
                LegacyTextFieldState v3 = arg9.getState$foundation();
                TextLayoutResult v6 = null;
                if(v3 != null) {
                    TextLayoutResultProxy v3_1 = v3.getLayoutResult();
                    if(v3_1 != null) {
                        TextLayoutResult v3_2 = v3_1.getValue();
                        if(v3_2 != null) {
                            LegacyTextFieldState v7 = arg9.getState$foundation();
                            boolean v7_1 = v7 != null ? v7.isLayoutResultStale() : true;
                            if(v7_1) {
                                goto label_57;
                            }

                            v6 = v3_2;
                        }
                    }
                }

            label_57:
                if(v6 == null) {
                    arg11.startReplaceGroup(1530097387);
                }
                else {
                    arg11.startReplaceGroup(v0);
                    ComposerKt.sourceInformation(arg11, v2_2);
                    int v3_3 = 2062097806;
                    if(!TextRange.getCollapsed-impl(arg9.getValue$foundation().getSelection-d9O1mEE())) {
                        arg11.startReplaceGroup(2109807302);
                        ComposerKt.sourceInformation(arg11, v2_2);
                        v0 = arg9.getOffsetMapping$foundation().originalToTransformed(TextRange.getStart-impl(arg9.getValue$foundation().getSelection-d9O1mEE()));
                        v2 = arg9.getOffsetMapping$foundation().originalToTransformed(TextRange.getEnd-impl(arg9.getValue$foundation().getSelection-d9O1mEE()));
                        ResolvedTextDirection v0_1 = v6.getBidiRunDirection(v0);
                        ResolvedTextDirection v2_3 = v6.getBidiRunDirection(Math.max(v2 - 1, 0));
                        LegacyTextFieldState v6_1 = arg9.getState$foundation();
                        if(v6_1 == null || !v6_1.getShowSelectionHandleStart()) {
                            arg11.startReplaceGroup(v3_3);
                        }
                        else {
                            arg11.startReplaceGroup(2110225306);
                            ComposerKt.sourceInformation(arg11, "1070@48536L220");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, v0_1, arg9, arg11, v1 << 6 & 0x380 | 6);
                        }

                        arg11.endReplaceGroup();
                        v0_2 = arg9.getState$foundation();
                        if(v0_2 == null || !v0_2.getShowSelectionHandleEnd()) {
                            arg11.startReplaceGroup(v3_3);
                        }
                        else {
                            arg11.startReplaceGroup(0x7DCCCF7B);
                            ComposerKt.sourceInformation(arg11, "1077@48888L219");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, v2_3, arg9, arg11, v1 << 6 & 0x380 | 6);
                        }

                        arg11.endReplaceGroup();
                    }
                    else {
                        arg11.startReplaceGroup(v3_3);
                    }

                    arg11.endReplaceGroup();
                    v0_2 = arg9.getState$foundation();
                    if(v0_2 == null) {
                        goto label_60;
                    }

                    if(arg9.isTextChanged$foundation()) {
                        v0_2.setShowFloatingToolbar(false);
                    }

                    if(!v0_2.getHasFocus()) {
                        goto label_60;
                    }

                    if(v0_2.getShowFloatingToolbar()) {
                        arg9.showSelectionToolbar$foundation();
                        goto label_60;
                    }

                    arg9.hideSelectionToolbar$foundation();
                }

            label_60:
                arg11.endReplaceGroup();
                arg11.endReplaceGroup();
            }
            else {
                arg11.startReplaceGroup(1989076778);
                arg11.endReplaceGroup();
                arg9.hideSelectionToolbar$foundation();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_144;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_144:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new CoreTextFieldKt$$ExternalSyntheticLambda14(arg9, arg10, arg12));
        }
    }

    static final Unit SelectionToolbarAndHandles$lambda$1(TextFieldSelectionManager arg0, boolean arg1, int arg2, Composer arg3, int arg4) {
        CoreTextFieldKt.SelectionToolbarAndHandles(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionManager arg10, Composer arg11, int arg12) {
        CoreTextFieldKt$TextFieldCursorHandle$1$1 v2_1;
        TextDragObserver v1_3;
        int v11;
        int v0 = -1436003720;
        Composer v5 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(TextFieldCursorHandle)N(manager):CoreTextField.kt#423gt5");
        int v1 = 2;
        if((arg12 & 6) == 0) {
            v11 = v5.changedInstance(arg10) ? 4 : v1;
            v11 |= arg12;
        }
        else {
            v11 = arg12;
        }

        boolean v1_1 = (v11 & 3) != v1 ? true : false;
        if(v5.shouldExecute(v1_1, v11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v11, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1101)");
            }

            LegacyTextFieldState v11_1 = arg10.getState$foundation();
            if(v11_1 == null || !v11_1.getShowCursorHandle()) {
            label_112:
                v5.startReplaceGroup(0x7F222FAA);
            }
            else {
                AnnotatedString v11_2 = arg10.getTransformedText$foundation();
                if(v11_2 == null) {
                    goto label_112;
                }
                else if(((CharSequence)v11_2).length() > 0) {
                    v5.startReplaceGroup(0x82181338);
                    ComposerKt.sourceInformation(v5, "1103@50051L50,1104@50164L7,1106@50224L12,1108@50309L645,1120@50986L385,1105@50181L1201");
                    String v0_1 = "CC(remember):CoreTextField.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(v5, -1315066870, v0_1);
                    boolean v11_3 = v5.changed(arg10);
                    Object v1_2 = v5.rememberedValue();
                    if((v11_3) || v1_2 == Composer.Companion.getEmpty()) {
                        v1_3 = arg10.cursorDragObserver$foundation();
                        v5.updateRememberedValue(v1_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v5);
                    ProvidableCompositionLocal v11_4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v11_5 = v5.consume(((CompositionLocal)v11_4));
                    ComposerKt.sourceInformationMarkerEnd(v5);
                    long v6 = arg10.getCursorPosition-tuRUvjQ$foundation(((Density)v11_5));
                    ComposerKt.sourceInformationMarkerStart(v5, -1315061372, v0_1);
                    v11_3 = v5.changed(v6);
                    Object v2 = v5.rememberedValue();
                    if((v11_3) || v2 == Composer.Companion.getEmpty()) {
                        v2_1 = new CoreTextFieldKt$TextFieldCursorHandle$1$1(v6);
                        v5.updateRememberedValue(v2_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v5);
                    Companion v11_6 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(v5, -1315058019, v0_1);
                    int v8 = v5.changedInstance(v1_3) | v5.changedInstance(arg10);
                    Object v9 = v5.rememberedValue();
                    if(v8 != 0 || v9 == Composer.Companion.getEmpty()) {
                        CoreTextFieldKt$TextFieldCursorHandle$2$1 v9_1 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(v1_3, arg10);
                        v5.updateRememberedValue(v9_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v5);
                    Modifier v11_7 = SuspendingPointerInputFilterKt.pointerInput(((Modifier)v11_6), v1_3, ((PointerInputEventHandler)v9));
                    ComposerKt.sourceInformationMarkerStart(v5, -1315036615, v0_1);
                    boolean v0_2 = v5.changed(v6);
                    v1_2 = v5.rememberedValue();
                    if((v0_2) || v1_2 == Composer.Companion.getEmpty()) {
                        CoreTextFieldKt$$ExternalSyntheticLambda12 v1_4 = new CoreTextFieldKt$$ExternalSyntheticLambda12(v6);
                        v5.updateRememberedValue(v1_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v5);
                    AndroidCursorHandle_androidKt.CursorHandle-USBMPiE(v2_1, SemanticsModifierKt.semantics$default(v11_7, false, ((Function1)v1_2), 1, null), 0, v5, 0, 4);
                }
                else {
                    goto label_112;
                }
            }

            v5.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_120;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5.skipToGroupEnd();
        }

    label_120:
        ScopeUpdateScope v11_8 = v5.endRestartGroup();
        if(v11_8 != null) {
            v11_8.updateScope(new CoreTextFieldKt$$ExternalSyntheticLambda13(arg10, arg12));
        }
    }

    private static final Unit TextFieldCursorHandle$lambda$3$0(long arg8, SemanticsPropertyReceiver arg10) {
        arg10.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, arg8, SelectionHandleAnchor.Middle, true, null));
        return Unit.INSTANCE;
    }

    static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionManager arg0, int arg1, Composer arg2, int arg3) {
        CoreTextFieldKt.TextFieldCursorHandle(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public static final boolean access$CoreTextField$lambda$14(State arg0) {
        return CoreTextFieldKt.CoreTextField$lambda$14(arg0);
    }

    public static final void access$endInputSession(LegacyTextFieldState arg0) {
        CoreTextFieldKt.endInputSession(arg0);
    }

    public static final void access$notifyFocusedRect(LegacyTextFieldState arg0, TextFieldValue arg1, OffsetMapping arg2) {
        CoreTextFieldKt.notifyFocusedRect(arg0, arg1, arg2);
    }

    public static final void access$startInputSession(TextInputService arg0, LegacyTextFieldState arg1, TextFieldValue arg2, ImeOptions arg3, OffsetMapping arg4) {
        CoreTextFieldKt.startInputSession(arg0, arg1, arg2, arg3, arg4);
    }

    private static final Modifier addContextMenuComponents(Modifier arg1, TextFieldSelectionManager arg2, CoroutineScope arg3) {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            arg1 = TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(arg1, arg2, arg3);
        }

        return arg1;
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester arg7, TextFieldValue arg8, TextDelegate arg9, TextLayoutResult arg10, OffsetMapping arg11, Continuation arg12) {
        Rect v8_1;
        int v8 = arg11.originalToTransformed(TextRange.getMax-impl(arg8.getSelection-d9O1mEE()));
        if(v8 < arg10.getLayoutInput().getText().length()) {
            v8_1 = arg10.getBoundingBox(v8);
        }
        else if(v8 != 0) {
            v8_1 = arg10.getBoundingBox(v8 - 1);
        }
        else {
            v8_1 = new Rect(0f, 0f, 1f, ((float)(((int)(TextFieldDelegateKt.computeSizeForDefaultText$default(arg9.getStyle(), arg9.getDensity(), arg9.getFontFamilyResolver(), null, 0, 24, null) & 0xFFFFFFFFL)))));
        }

        Object v7 = arg7.bringIntoView(v8_1, arg12);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    private static final void endInputSession(LegacyTextFieldState arg4) {
        TextInputSession v0 = arg4.getInputSession();
        if(v0 != null) {
            TextFieldDelegate.Companion.onBlur$foundation(v0, arg4.getProcessor(), arg4.getOnValueChange());
        }

        arg4.setInputSession(null);
    }

    private static final void notifyFocusedRect(LegacyTextFieldState arg13, TextFieldValue arg14, OffsetMapping arg15) {
        LayoutCoordinates v9;
        TextInputSession v10;
        TextLayoutResultProxy v0_2;
        androidx.compose.runtime.snapshots.Snapshot$Companion v1 = Snapshot.Companion;
        Snapshot v2 = v1.getCurrentThreadSnapshot();
        Function1 v0 = v2 != null ? v2.getReadObserver() : null;
        Function1 v3 = v0;
        Snapshot v4 = v1.makeCurrentNonObservable(v2);
        try {
            v0_2 = arg13.getLayoutResult();
            if(v0_2 != null) {
                goto label_12;
            }
        }
        catch(Throwable v0_1) {
            goto label_32;
        }

        v1.restoreNonObservable(v2, v4, v3);
        return;
        try {
        label_12:
            v10 = arg13.getInputSession();
            if(v10 != null) {
                goto label_16;
            }
        }
        catch(Throwable v0_1) {
            goto label_32;
        }

        v1.restoreNonObservable(v2, v4, v3);
        return;
        try {
        label_16:
            v9 = arg13.getLayoutCoordinates();
            if(v9 != null) {
                goto label_20;
            }
        }
        catch(Throwable v0_1) {
            goto label_32;
        }

        v1.restoreNonObservable(v2, v4, v3);
        return;
        try {
        label_20:
            TextFieldDelegate.Companion.notifyFocusedRect$foundation(arg14, arg13.getTextDelegate(), v0_2.getValue(), v9, v10, arg13.getHasFocus(), arg15);
        }
        catch(Throwable v0_1) {
        label_32:
            v1.restoreNonObservable(v2, v4, v3);
            throw v0_1;
        }

        v1.restoreNonObservable(v2, v4, v3);
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier arg1, LegacyTextFieldState arg2, TextFieldSelectionManager arg3) {
        return KeyInputModifierKt.onPreviewKeyEvent(arg1, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(arg2, arg3));
    }

    private static final void startInputSession(TextInputService arg7, LegacyTextFieldState arg8, TextFieldValue arg9, ImeOptions arg10, OffsetMapping arg11) {
        arg8.setInputSession(TextFieldDelegate.Companion.onFocus$foundation(arg7, arg9, arg8.getProcessor(), arg10, arg8.getOnValueChange(), arg8.getOnImeActionPerformed()));
        CoreTextFieldKt.notifyFocusedRect(arg8, arg9, arg11);
    }

    public static final void tapToFocus(LegacyTextFieldState arg1, FocusRequester arg2, boolean arg3) {
        if(!arg1.getHasFocus()) {
            FocusRequester.requestFocus-3ESFkO8$default(arg2, 0, 1, null);
            return;
        }

        if(arg3) {
            SoftwareKeyboardController v1 = arg1.getKeyboardController();
            if(v1 != null) {
                v1.show();
            }
        }
    }
}

