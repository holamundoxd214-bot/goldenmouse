package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits$MultiLine;
import androidx.compose.foundation.text.input.TextFieldLineLimits$SingleLine;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1={"\u0000Ð\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AÛ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u001228\b\u0002\u0010\u0013\u001A2\u0012\u0004\u0012\u00020\u0015\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001A\u00020%H\u0007¢\u0006\u0002\u0010&\u001Añ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u001228\b\u0002\u0010\u0013\u001A2\u0012\u0004\u0012\u00020\u0015\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010(2\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001A\u00020%2\b\b\u0002\u0010)\u001A\u00020\u0007H\u0001¢\u0006\u0002\u0010*\u001A\u001C\u0010+\u001A\u00020\u0005*\u00020\u00052\u0006\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020/H\u0002\u001A\u0015\u00100\u001A\u00020\u00012\u0006\u00101\u001A\u00020-H\u0001¢\u0006\u0002\u00102\u001A\u0015\u00103\u001A\u00020\u00012\u0006\u00101\u001A\u00020-H\u0001¢\u0006\u0002\u00102\u001Aî\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u00108\u001A\u0002092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020=2\b\b\u0002\u0010>\u001A\u00020\u00072\b\b\u0002\u0010?\u001A\u00020@2\b\b\u0002\u0010A\u001A\u00020@2\b\b\u0002\u0010B\u001A\u00020C2\u0014\b\u0002\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F23\b\u0002\u0010D\u001A-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010G\u001Aî\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u00108\u001A\u00020H2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020=2\b\b\u0002\u0010>\u001A\u00020\u00072\b\b\u0002\u0010?\u001A\u00020@2\b\b\u0002\u0010A\u001A\u00020@2\b\b\u0002\u0010B\u001A\u00020C2\u0014\b\u0002\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F23\b\u0002\u0010D\u001A-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010I\u001Aâ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u00108\u001A\u0002092\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020=2\b\b\u0002\u0010>\u001A\u00020\u00072\b\b\u0002\u0010?\u001A\u00020@2\b\b\u0002\u0010B\u001A\u00020C2\u0014\b\u0002\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F23\b\u0002\u0010D\u001A-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010J\u001Aâ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u00108\u001A\u00020H2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020=2\b\b\u0002\u0010>\u001A\u00020\u00072\b\b\u0002\u0010?\u001A\u00020@2\b\b\u0002\u0010B\u001A\u00020C2\u0014\b\u0002\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F23\b\u0002\u0010D\u001A-\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010K\"\u000E\u00104\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00105\u001A\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006L²\u0006\n\u0010M\u001A\u00020NX\u008A\u0084\u0002²\u0006\n\u0010O\u001A\u00020NX\u008A\u0084\u0002²\u0006\n\u0010P\u001A\u00020NX\u008A\u0084\u0002²\u0006\n\u0010Q\u001A\u00020HX\u008A\u008E\u0002²\u0006\n\u0010R\u001A\u000209X\u008A\u008E\u0002"}, d2={"BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "addContextMenuComponents", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "TextFieldCursorHandle", "selectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "DefaultTextFieldDecorator", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "value", "", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator;
    private static final long MinTouchTargetSizeForHandles;

    public static Unit $r8$lambda$4OffnXQehHeNQF7a4CWoqEXZBb0(TextLayoutResult arg0) {
        return BasicTextFieldKt.BasicTextField$lambda$29$0(arg0);
    }

    public static TextFieldHandleState $r8$lambda$QE5yGD7AGhDzH7qt4EgLwKPf624(TextFieldSelectionState arg0) {
        return BasicTextFieldKt.TextFieldCursorHandle$lambda$0$0(arg0);
    }

    public static DisposableEffectResult $r8$lambda$U3W1ex9NSC7WJ2Xpc2ZlyuKPs64(TextFieldSelectionState arg0, DisposableEffectScope arg1) {
        return BasicTextFieldKt.BasicTextField$lambda$12$0(arg0, arg1);
    }

    public static Unit $r8$lambda$U8IU3SJiT6XBfKDptRir9AlF148(TextFieldDecorator arg0, TextFieldLineLimits arg1, TextLayoutState arg2, TextStyle arg3, boolean arg4, boolean arg5, TransformedTextFieldState arg6, TextFieldSelectionState arg7, Brush arg8, boolean arg9, boolean arg10, ScrollState arg11, Orientation arg12, ToolbarRequesterImpl arg13, PlatformSelectionBehaviors arg14, boolean arg15, Function2 arg16, KeyboardOptions arg17, Composer arg18, int arg19) {
        return BasicTextFieldKt.BasicTextField$lambda$14$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    public static Unit $r8$lambda$Yk0kD2PUIEgSCfixLmxO7tSfxaU(TextFieldLineLimits arg0, TextLayoutState arg1, TextStyle arg2, boolean arg3, boolean arg4, TransformedTextFieldState arg5, TextFieldSelectionState arg6, Brush arg7, boolean arg8, boolean arg9, ScrollState arg10, Orientation arg11, ToolbarRequesterImpl arg12, PlatformSelectionBehaviors arg13, boolean arg14, Function2 arg15, KeyboardOptions arg16, Composer arg17, int arg18) {
        return BasicTextFieldKt.BasicTextField$lambda$14$0$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }

    public static Unit $r8$lambda$ZO9CGm9hkYQHI2gmx1U2q5ZcLxc(boolean arg0, MutableSharedFlow arg1) {
        return BasicTextFieldKt.BasicTextField$lambda$13$0(arg0, arg1);
    }

    public static TextFieldHandleState $r8$lambda$et9Dkr-xcui76CDPvS9schFe9QI(TextFieldSelectionState arg0) {
        return BasicTextFieldKt.TextFieldSelectionHandles$lambda$0$0(arg0);
    }

    public static TextFieldHandleState $r8$lambda$hGgC2pun-e4dxFRMXpZ4xVlHvTs(TextFieldSelectionState arg0) {
        return BasicTextFieldKt.TextFieldSelectionHandles$lambda$4$0(arg0);
    }

    public static Unit $r8$lambda$jMgRns3c3lXttTVl8HqxYD_QUQw(TextLayoutResult arg0) {
        return BasicTextFieldKt.BasicTextField$lambda$26$0(arg0);
    }

    public static Unit $r8$lambda$ktEA_pvkn4rL-BawAuIf6VFqpyY(TransformedTextFieldState arg0, InputTransformation arg1, TextFieldSelectionState arg2, HapticFeedback arg3, Clipboard arg4, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 arg5, Density arg6, boolean arg7, boolean arg8, boolean arg9) {
        return BasicTextFieldKt.BasicTextField$lambda$11$0(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static Unit $r8$lambda$sP3qBobxJnfUhJ-6Px9SryIAhVM(TextFieldValue arg0, MutableState arg1) {
        return BasicTextFieldKt.BasicTextField$lambda$20$0(arg0, arg1);
    }

    public static Unit $r8$lambda$uVP83BYWdLdq7NHvOBgopjMkc2c(TextLayoutResult arg0) {
        return BasicTextFieldKt.BasicTextField$lambda$32$0(arg0);
    }

    public static Unit $r8$lambda$vMifF5XGcyVlCJ2x61Z-nONHwyk(Function1 arg0, MutableState arg1, MutableState arg2, TextFieldValue arg3) {
        return BasicTextFieldKt.BasicTextField$lambda$24$0(arg0, arg1, arg2, arg3);
    }

    public static Unit $r8$lambda$yIJACc7JwaXIu_xamQDAorGbK54(TextFieldValue arg0, Function1 arg1, TextFieldValue arg2) {
        return BasicTextFieldKt.BasicTextField$lambda$27$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$ymZgiTMAYKKGKFL7RRS4woUPlmQ(TextLayoutResult arg0) {
        return BasicTextFieldKt.BasicTextField$lambda$16$0(arg0);
    }

    static {
        BasicTextFieldKt.DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
        BasicTextFieldKt.MinTouchTargetSizeForHandles = DpKt.DpSize-YgX7TsA(Dp.constructor-impl(40f), Dp.constructor-impl(40f));
    }

    public static final void BasicTextField(TextFieldState arg57, Modifier arg58, boolean arg59, boolean arg60, InputTransformation arg61, TextStyle arg62, KeyboardOptions arg63, KeyboardActionHandler arg64, TextFieldLineLimits arg65, Function2 arg66, MutableInteractionSource arg67, Brush arg68, CodepointTransformation arg69, OutputTransformation arg70, TextFieldDecorator arg71, ScrollState arg72, boolean arg73, Composer arg74, int arg75, int arg76, int arg77) {
        Function2 v10_3;
        ScrollState v16_2;
        boolean v4_5;
        Brush v12_2;
        TextStyle v6_1;
        TextFieldDecorator v15_4;
        OutputTransformation v14_2;
        CodepointTransformation v13_5;
        MutableInteractionSource v11_1;
        Modifier v2_8;
        InputTransformation v5_1;
        Composer v0_9;
        BasicTextFieldKt$$ExternalSyntheticLambda13 v2_6;
        Object v34;
        BasicTextFieldKt$$ExternalSyntheticLambda10 v2_5;
        boolean v20_3;
        ToolbarRequesterImpl v0_5;
        PlatformSelectionBehaviors v42;
        KeyboardOptions v17_3;
        boolean v3_3;
        CodepointTransformation v9_3;
        MutableSharedFlow v7_6;
        Object v61;
        TextFieldLineLimits v29_1;
        Object v72;
        boolean v32;
        Object v7_5;
        boolean v17_2;
        MutableInteractionSource v52_1;
        MutableInteractionSource v4_2;
        boolean v65;
        KeyboardOptions v0_3;
        int v10_1;
        TextStyle v31_1;
        boolean v38;
        boolean v37;
        boolean v7_2;
        ScrollState v39;
        TextFieldDecorator v28_1;
        OutputTransformation v2_3;
        CodepointTransformation v18_1;
        Brush v36;
        MutableInteractionSource v16_1;
        Function2 v44;
        TextFieldLineLimits v9_1;
        KeyboardActionHandler v8_1;
        ScrollState v21_1;
        SolidColor v20_1;
        boolean v0_2;
        int v19;
        int v18;
        int v31;
        int v30;
        int v29;
        int v28;
        KeyboardOptions v7;
        int v23;
        TextStyle v15;
        int v21;
        InputTransformation v11;
        int v20;
        boolean v14;
        int v16;
        boolean v10;
        int v13;
        Modifier v12;
        int v6;
        TextFieldState v1 = arg57;
        TextFieldDecorator v0 = arg71;
        int v2 = arg75;
        int v3 = arg76;
        int v4 = arg77;
        Composer v5 = arg74.startRestartGroup(0x398702F5);
        ComposerKt.sourceInformation(v5, "C(BasicTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,interactionSource,cursorBrush,codepointTransformation,outputTransformation,decorator,scrollState,isPassword)252@14291L7,253@14346L7,259@14716L25,260@14790L25,264@15134L107,269@15278L846,287@16322L48,294@16698L24,303@17116L35,304@17194L7,306@17244L617,321@17914L7,322@17968L7,325@18014L2260,372@20280L256,379@20553L510,379@20542L521,395@21111L51,395@21069L93,397@21191L35,405@21528L1339,462@24584L3165:BasicTextField.kt#423gt5");
        if((v2 & 6) == 0) {
            v6 = v5.changed(v1) ? 4 : 2;
            v6 |= v2;
        }
        else {
            v6 = v2;
        }

        int v9 = v4 & 2;
        if(v9 != 0) {
            v6 |= 0x30;
            goto label_34;
        }
        else if((v2 & 0x30) == 0) {
            v12 = arg58;
            v13 = v5.changed(v12) ? 0x20 : 16;
            v6 |= v13;
        }
        else {
        label_34:
            v12 = arg58;
        }

        v13 = v4 & 4;
        if(v13 != 0) {
            v6 |= 0x180;
            goto label_49;
        }
        else if((v2 & 0x180) == 0) {
            v10 = arg59;
            v16 = v5.changed(v10) ? 0x100 : 0x80;
            v6 |= v16;
        }
        else {
        label_49:
            v10 = arg59;
        }

        v16 = v4 & 8;
        int v17 = 0x400;
        if(v16 != 0) {
            v6 |= 0xC00;
            goto label_65;
        }
        else if((v2 & 0xC00) == 0) {
            v14 = arg60;
            v20 = v5.changed(v14) ? 0x800 : v17;
            v6 |= v20;
        }
        else {
        label_65:
            v14 = arg60;
        }

        v20 = v4 & 16;
        if(v20 != 0) {
            v6 |= 0x6000;
            goto label_80;
        }
        else if((v2 & 0x6000) == 0) {
            v11 = arg61;
            v21 = v5.changed(v11) ? 0x4000 : 0x2000;
            v6 |= v21;
        }
        else {
        label_80:
            v11 = arg61;
        }

        v21 = v4 & 0x20;
        int v22 = 0x30000;
        if(v21 != 0) {
            v6 |= v22;
            v15 = arg62;
        }
        else {
            v15 = arg62;
            if((v2 & v22) == 0) {
                v23 = v5.changed(v15) ? 0x20000 : 0x10000;
                v6 |= v23;
            }
        }

        v23 = v4 & 0x40;
        int v24 = 0x180000;
        if(v23 != 0) {
            v6 |= v24;
        }
        else {
            v7 = arg63;
            if((v2 & v24) == 0) {
                int v26 = v5.changed(v7) ? 0x100000 : 0x80000;
                v6 |= v26;
            }
        }

        int v8 = v4 & 0x80;
        int v27 = 0xC00000;
        if(v8 != 0) {
            v6 |= v27;
        }
        else {
            v27 &= v2;
            KeyboardActionHandler v2_1 = arg64;
            if(v27 == 0) {
                v27 = v5.changed(v2_1) ? 0x800000 : 0x400000;
                v6 |= v27;
            }
        }

        v2 = v4 & 0x100;
        v27 = 0x6000000;
        if(v2 != 0) {
            v6 |= v27;
            goto label_142;
        }
        else if((arg75 & v27) == 0) {
            v27 = v2;
            v28 = v5.changed(arg65) ? 0x4000000 : 0x2000000;
            v6 |= v28;
        }
        else {
        label_142:
            v27 = v2;
        }

        v2 = v4 & 0x200;
        v28 = 0x30000000;
        if(v2 != 0) {
            v6 |= v28;
            goto label_160;
        }
        else if((arg75 & v28) == 0) {
            v28 = v2;
            v29 = v5.changedInstance(arg66) ? 0x20000000 : 0x10000000;
            v6 |= v29;
        }
        else {
        label_160:
            v28 = v2;
        }

        v2 = v4 & 0x400;
        if(v2 != 0) {
            v30 = v3 | 6;
            v29 = v2;
        }
        else if((v3 & 6) == 0) {
            v29 = v2;
            v30 = v5.changed(arg67) ? 4 : 2;
            v30 |= v3;
        }
        else {
            v29 = v2;
            v30 = v3;
        }

        v2 = v4 & 0x800;
        if(v2 != 0) {
            v30 |= 0x30;
            v31 = v2;
        }
        else if((v3 & 0x30) == 0) {
            v31 = v2;
            v18 = v5.changed(arg68) ? 0x20 : 16;
            v30 |= v18;
        }
        else {
            v31 = v2;
        }

        v2 = v30;
        int v7_1 = v4 & 0x1000;
        if(v7_1 != 0) {
            v2 |= 0x180;
        }
        else {
            v18 = v2;
            if((v3 & 0x180) == 0) {
                v19 = v5.changed(arg69) ? 0x100 : 0x80;
                v18 |= v19;
            }

            v2 = v18;
        }

        v18 = v7_1;
        v7_1 = v4 & 0x2000;
        if(v7_1 != 0) {
            v2 |= 0xC00;
        }
        else {
            v19 = v2;
            if((v3 & 0xC00) == 0) {
                if(v5.changed(arg70)) {
                    v17 = 0x800;
                }

                v2 = v19 | v17;
            }
            else {
                v2 = v19;
            }
        }

        v17 = v7_1;
        v7_1 = v4 & 0x4000;
        v19 = 0x8000;
        if(v7_1 != 0) {
            v2 |= 0x6000;
        }
        else {
            v30 = v2;
            if((v3 & 0x6000) == 0) {
                boolean v2_2 = (v3 & v19) == 0 ? v5.changed(v0) : v5.changedInstance(v0);
                v2 = v2_2 ? 0x4000 : 0x2000;
                v2 |= v30;
            }
            else {
                v2 = v30;
            }
        }

        if((v3 & 0x30000) == 0) {
            ScrollState v0_1 = arg72;
            v30 = (v4 & v19) != 0 || !v5.changed(v0_1) ? 0x10000 : 0x20000;
            v2 |= v30;
        }

        v30 = v4 & 0x10000;
        if(v30 != 0) {
            v2 |= v24;
        }
        else {
            v0_2 = arg73;
            if((v3 & v24) == 0) {
                v24 = v5.changed(v0_2) ? 0x100000 : 0x80000;
                v2 |= v24;
            }
        }

        int v74 = v2;
        v0_2 = (v6 & 306783379) != 306783378 || (v74 & 0x92493) != 0x92492 ? true : false;
        if(v5.shouldExecute(v0_2, v6 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "247@14085L21");
            if((arg75 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v9 != 0) {
                    Companion v12_1 = Modifier.Companion;
                }

                if(v13 != 0) {
                    v10 = true;
                }

                if(v16 != 0) {
                    v14 = false;
                }

                if(v20 != 0) {
                    v11 = null;
                }

                if(v21 != 0) {
                    v15 = TextStyle.Companion.getDefault();
                }

                v0_3 = v23 != 0 ? KeyboardOptions.Companion.getDefault() : arg63;
                v8_1 = v8 != 0 ? null : arg64;
                v9_1 = v27 != 0 ? TextFieldLineLimits.Companion.getDefault() : arg65;
                Function2 v13_1 = v28 != 0 ? null : arg66;
                v16_1 = v29 != 0 ? null : arg67;
                if(v31 != 0) {
                    v20_1 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                }
                else {
                    Brush v20_2 = arg68;
                }

                v18_1 = v18 != 0 ? null : arg69;
                OutputTransformation v17_1 = v17 != 0 ? null : arg70;
                TextFieldDecorator v7_3 = v7_1 != 0 ? null : arg71;
                if((v4 & v19) != 0) {
                    v21_1 = ScrollKt.rememberScrollState(0, v5, 0, 1);
                    v2 = v74 & 0xFFF8FFFF;
                }
                else {
                    v21_1 = arg72;
                    v2 = v74;
                }

                v28_1 = v7_3;
                v37 = v10;
                v44 = v13_1;
                v38 = v14;
                v31_1 = v15;
                SolidColor v36_1 = v20_1;
                v39 = v21_1;
                if(v30 != 0) {
                    v10_1 = v2;
                    v7_2 = false;
                }
                else {
                    v7_2 = arg73;
                    v10_1 = v2;
                }

                v2_3 = v17_1;
            }
            else {
                v5.skipToGroupEnd();
                if((v4 & v19) != 0) {
                    v8_1 = arg64;
                    v9_1 = arg65;
                    v44 = arg66;
                    v16_1 = arg67;
                    v36 = arg68;
                    v18_1 = arg69;
                    v2_3 = arg70;
                    v28_1 = arg71;
                    v39 = arg72;
                    v7_2 = arg73;
                    v37 = v10;
                    v38 = v14;
                    v31_1 = v15;
                    v10_1 = v74 & 0xFFF8FFFF;
                    v0_3 = arg63;
                }
                else {
                    v0_3 = arg63;
                    v8_1 = arg64;
                    v9_1 = arg65;
                    v44 = arg66;
                    v16_1 = arg67;
                    v36 = arg68;
                    v18_1 = arg69;
                    v2_3 = arg70;
                    v28_1 = arg71;
                    v39 = arg72;
                    v7_2 = arg73;
                    v37 = v10;
                    v38 = v14;
                    v31_1 = v15;
                    v10_1 = v74;
                }
            }

            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x398702F5, v6, v10_1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:251)");
            }

            ProvidableCompositionLocal v13_2 = CompositionLocalsKt.getLocalDensity();
            String v15_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, v15_1);
            Object v13_3 = v5.consume(((CompositionLocal)v13_2));
            ComposerKt.sourceInformationMarkerEnd(v5);
            ProvidableCompositionLocal v3_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, v15_1);
            Object v3_2 = v5.consume(((CompositionLocal)v3_1));
            ComposerKt.sourceInformationMarkerEnd(v5);
            boolean v43 = Intrinsics.areEqual(v9_1, SingleLine.INSTANCE);
            String v14_1 = "CC(remember):BasicTextField.kt#9igjgp";
            if(v16_1 == null) {
                v5.startReplaceGroup(-2038132442);
                ComposerKt.sourceInformation(v5, "257@14551L39");
                ComposerKt.sourceInformationMarkerStart(v5, -204293540, v14_1);
                Object v4_1 = v5.rememberedValue();
                v65 = v7_2;
                if(v4_1 == Composer.Companion.getEmpty()) {
                    v4_2 = InteractionSourceKt.MutableInteractionSource();
                    v5.updateRememberedValue(v4_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v5);
                v5.endReplaceGroup();
                Object v52 = v4_2;
            }
            else {
                v65 = v7_2;
                v5.startReplaceGroup(0xF3D2B7D1);
                v5.endReplaceGroup();
                v52_1 = v16_1;
            }

            Orientation v4_3 = v43 ? Orientation.Horizontal : Orientation.Vertical;
            KeyboardActionHandler v71 = v8_1;
            v17_2 = FocusInteractionKt.collectIsFocusedAsState(v52_1, v5, 0).getValue().booleanValue();
            boolean v33 = HoverInteractionKt.collectIsHoveredAsState(v52_1, v5, 0).getValue().booleanValue();
            if(v17_2) {
                v5.startReplaceGroup(-204276540);
                ComposerKt.sourceInformation(v5, "263@15075L7");
                ProvidableCompositionLocal v7_4 = CompositionLocalsKt.getLocalWindowInfo();
                ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, v15_1);
                v7_5 = v5.consume(((CompositionLocal)v7_4));
                ComposerKt.sourceInformationMarkerEnd(v5);
                v7_2 = ((WindowInfo)v7_5).isWindowFocused();
                v5.endReplaceGroup();
                v32 = v7_2;
            }
            else {
                v5.startReplaceGroup(-2037604207);
                v5.endReplaceGroup();
                v32 = false;
            }

            ComposerKt.sourceInformationMarkerStart(v5, 0xF3D30380, v14_1);
            v7_5 = v5.rememberedValue();
            if(v7_5 == Composer.Companion.getEmpty()) {
                v72 = v3_2;
                v29_1 = v9_1;
                v61 = v13_3;
                v7_6 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
                v5.updateRememberedValue(v7_6);
            }
            else {
                v72 = v3_2;
                v29_1 = v9_1;
                v61 = v13_3;
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, -204269469, v14_1);
            v3 = (v6 & 14) == 4 ? 1 : 0;
            v8 = (v10_1 & 0x380) == 0x100 ? 1 : 0;
            v3 |= v8;
            v8 = (v10_1 & 0x1C00) == 0x800 ? 1 : 0;
            v3 |= v8;
            Object v8_2 = v5.rememberedValue();
            if(v3 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                if(v18_1 == null) {
                    SingleLineCodepointTransformation v9_2 = SingleLineCodepointTransformation.INSTANCE;
                    if(v43) {
                    }
                    else {
                        v9_3 = null;
                    }
                }
                else {
                    v9_3 = v18_1;
                }

                TransformedTextFieldState v8_3 = new TransformedTextFieldState(v1, v11, v9_3, v2_3);
                v5.updateRememberedValue(v8_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, -204236859, v14_1);
            v3_3 = v5.changed(v8_2);
            Object v9_4 = v5.rememberedValue();
            if((v3_3) || v9_4 == Composer.Companion.getEmpty()) {
                TextLayoutState v9_5 = new TextLayoutState();
                v5.updateRememberedValue(v9_5);
            }

            Object v30_1 = v9_4;
            ComposerKt.sourceInformationMarkerEnd(v5);
            KeyboardOptions v9_6 = v11 != null ? v11.getKeyboardOptions() : null;
            KeyboardOptions v45 = v0_3.fillUnspecifiedValuesWith$foundation(v9_6);
            ComposerKt.sourceInformationMarkerStart(v5, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v5, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            v3_2 = v5.rememberedValue();
            if(v3_2 == Composer.Companion.getEmpty()) {
                CoroutineScope v3_4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v5);
                v5.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            if(ComposeFoundationFlags.isSmartSelectionEnabled) {
                v5.startReplaceGroup(0x86A7AA10);
                ComposerKt.sourceInformation(v5, "299@16959L85");
                LocaleList v9_7 = v31_1.getLocaleList();
                if(v9_7 == null) {
                    v9_7 = LocaleList.Companion.getCurrent();
                }

                v17_3 = v0_3;
                PlatformSelectionBehaviors v9_8 = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, v9_7, v5, 6);
                v5.endReplaceGroup();
                v42 = v9_8;
            }
            else {
                v17_3 = v0_3;
                v5.startReplaceGroup(0x86AA8A31);
                v5.endReplaceGroup();
                v42 = null;
            }

            ComposerKt.sourceInformationMarkerStart(v5, 0xF3D3FAF8, v14_1);
            Object v0_4 = v5.rememberedValue();
            if(v0_4 == Composer.Companion.getEmpty()) {
                v0_5 = new ToolbarRequesterImpl();
                v5.updateRememberedValue(v0_5);
            }

            Object v41 = v0_5;
            ComposerKt.sourceInformationMarkerEnd(v5);
            ProvidableCompositionLocal v0_6 = CompositionLocalsKt.getLocalClipboard();
            ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, v15_1);
            v0_4 = v5.consume(((CompositionLocal)v0_6));
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, -204206786, v14_1);
            boolean v9_9 = v5.changed(v8_2);
            v13_3 = v5.rememberedValue();
            if((v9_9) || v13_3 == Composer.Companion.getEmpty()) {
                Object v69 = v0_4;
                TextFieldSelectionState v13_4 = new TextFieldSelectionState(v8_2, v30_1, ((Density)v61), v37, v38, v32, v65, v41, v3_2, v42, ((Clipboard)v69));
                v0_4 = v61;
                v20_3 = v65;
                v9_4 = v69;
                v5.updateRememberedValue(v13_4);
            }
            else {
                v20_3 = v65;
                v9_4 = v0_4;
                v0_4 = v61;
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ProvidableCompositionLocal v1_1 = CompositionLocalsKt.getLocalHapticFeedback();
            OutputTransformation v21_2 = v2_3;
            ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, v15_1);
            Object v1_2 = v5.consume(((CompositionLocal)v1_1));
            ComposerKt.sourceInformationMarkerEnd(v5);
            int v25 = v10_1;
            ProvidableCompositionLocal v10_2 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(v5, 0x789C5F52, v15_1);
            Object v2_4 = v5.consume(((CompositionLocal)v10_2));
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, -204180503, v14_1);
            v10_1 = v5.changed(v3_2) | v5.changed(v2_4);
            Object v15_2 = v5.rememberedValue();
            if(v10_1 != 0 || v15_2 == Composer.Companion.getEmpty()) {
                BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 v15_3 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(((TextToolbar)v2_4), ((CoroutineScope)v3_2));
                v5.updateRememberedValue(v15_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            new BasicTextFieldKt$$ExternalSyntheticLambda7(((TextFieldSelectionState)v13_3));
            new BasicTextFieldKt$$ExternalSyntheticLambda8(((TextFieldSelectionState)v13_3));
            new BasicTextFieldKt$$ExternalSyntheticLambda9(((TextFieldSelectionState)v13_3));
            ComposerKt.sourceInformationMarkerStart(v5, 0x47648F82, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, -204101005, v14_1);
            boolean v58 = v5.changed(v8_2);
            v2 = (0xE000 & v6) == 0x4000 ? 1 : 0;
            v2 = (((int)v58)) | v2 | v5.changedInstance(v13_3) | v5.changedInstance(v1_2) | v5.changedInstance(v9_4) | v5.changed(v15_2) | v5.changed(v0_4);
            v61 = v0_4;
            int v0_7 = (v6 & 0x380) == 0x100 ? 1 : 0;
            v0_7 |= v2;
            v2 = (v6 & 0x1C00) == 0x800 ? 1 : 0;
            v0_7 |= v2;
            v2 = (v25 & 0x380000) == 0x100000 ? 1 : 0;
            v0_7 |= v2;
            v2_4 = v5.rememberedValue();
            if(v0_7 != 0 || v2_4 == Composer.Companion.getEmpty()) {
                v2_5 = new BasicTextFieldKt$$ExternalSyntheticLambda10(v8_2, v11, v13_3, v1_2, v9_4, v15_2, v61, v37, v38, v20_3);
                v34 = v8_2;
                v10 = v37;
                v5.updateRememberedValue(v2_5);
            }
            else {
                v34 = v8_2;
                v10 = v37;
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            EffectsKt.SideEffect(((Function0)v2_5), v5, 0);
            ComposerKt.sourceInformationMarkerStart(v5, -204083608, v14_1);
            v0_2 = v5.changedInstance(v13_3);
            v1_2 = v5.rememberedValue();
            if((v0_2) || v1_2 == Composer.Companion.getEmpty()) {
                BasicTextFieldKt$$ExternalSyntheticLambda12 v1_3 = new BasicTextFieldKt$$ExternalSyntheticLambda12(((TextFieldSelectionState)v13_3));
                v5.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            EffectsKt.DisposableEffect(v13_3, ((Function1)v1_2), v5, 0);
            OverscrollEffect v48 = TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(v5, 0);
            v0_2 = (v20_3) || (KeyboardType.equals-impl0(v17_3.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE())) || (KeyboardType.equals-impl0(v17_3.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getNumberPassword-PjHm6EE())) ? false : true;
            ComposerKt.sourceInformationMarkerStart(v5, -204068976, v14_1);
            int v1_4 = v5.changed(v0_2) | v5.changedInstance(v7_6);
            v2_4 = v5.rememberedValue();
            if(v1_4 != 0 || v2_4 == Composer.Companion.getEmpty()) {
                v2_6 = new BasicTextFieldKt$$ExternalSyntheticLambda13(v0_2, v7_6);
                v5.updateRememberedValue(v2_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            v37 = v10;
            KeyboardOptions v1_5 = v45;
            v8_1 = v71;
            Modifier v45_1 = StylusHandwritingKt.stylusHandwriting(v12, v10, v0_2, ((Function0)v2_6)).then(new TextFieldDecoratorModifier(v34, v30_1, v13_3, v11, v10, v38, v45, v71, v43, v52_1, v20_3, v7_6));
            boolean v49 = !v37 || ((TextFieldSelectionState)v13_3).getDirectDragGestureInitiator() != InputType.None ? false : true;
            Orientation v47 = v4_3;
            Modifier v0_8 = BasicTextFieldKt.addContextMenuComponents(PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(v45_1, v39, v47, v48, v49, ScrollableDefaults.INSTANCE.reverseDirection(v72, v4_3, false), null, v52_1, null, 0xA0, null), PointerIcon.Companion.getText(), false, 2, null), ((TextFieldSelectionState)v13_3), ((CoroutineScope)v3_2));
            ComposerKt.sourceInformationMarkerStart(v5, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v2_7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v5, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v5, 0));
            CompositionLocalMap v4_4 = v5.getCurrentCompositionLocalMap();
            v0_8 = ComposedModifierKt.materializeModifier(v5, v0_8);
            Function0 v7_7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v5, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v7_7);
            }
            else {
                v5.useNode();
            }

            Composer v7_8 = Updater.constructor-impl(v5);
            Updater.set-impl(v7_8, v2_7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_8, v4_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v7_8, Integer.valueOf(v3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v7_8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v7_8, v0_8, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v5, 0xA56033A0, "C463@24701L3042,463@24651L3092:BasicTextField.kt#423gt5");
            v10 = v37;
            ContextMenu_androidKt.ContextMenuArea(((TextFieldSelectionState)v13_3), v10, ComposableLambdaKt.rememberComposableLambda(0xD7DF2601, true, new BasicTextFieldKt$$ExternalSyntheticLambda14(v28_1, v29_1, ((TextLayoutState)v30_1), v31_1, v32, v33, ((TransformedTextFieldState)v34), v13_3, v36, v37, v38, v39, v47, ((ToolbarRequesterImpl)v41), v42, v43, v44, v1_5), v5, 54), v5, v6 >> 3 & 0x70 | 0x180);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_9 = v5;
            v3_3 = v10;
            v5_1 = v11;
            v2_8 = v12;
            v11_1 = v16_1;
            v7 = v17_3;
            v13_5 = v18_1;
            v17_2 = v20_3;
            v14_2 = v21_2;
            v15_4 = v28_1;
            v9_1 = v29_1;
            v6_1 = v31_1;
            v12_2 = v36;
            v4_5 = v38;
            v16_2 = v39;
            v10_3 = v44;
        }
        else {
            v5.skipToGroupEnd();
            v7 = arg63;
            v8_1 = arg64;
            v9_1 = arg65;
            v13_5 = arg69;
            v16_2 = arg72;
            v17_2 = arg73;
            v0_9 = v5;
            v3_3 = v10;
            v5_1 = v11;
            v2_8 = v12;
            v4_5 = v14;
            v6_1 = v15;
            v10_3 = arg66;
            v11_1 = arg67;
            v12_2 = arg68;
            v14_2 = arg70;
            v15_4 = arg71;
        }

        ScopeUpdateScope v0_10 = v0_9.endRestartGroup();
        if(v0_10 != null) {
            v0_10.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda15(arg57, v2_8, v3_3, v4_5, v5_1, v6_1, v7, v8_1, v9_1, v10_3, v11_1, v12_2, v13_5, v14_2, v15_4, v16_2, v17_2, arg75, arg76, arg77));
        }
    }

    public static final void BasicTextField(TextFieldState arg36, Modifier arg37, boolean arg38, boolean arg39, InputTransformation arg40, TextStyle arg41, KeyboardOptions arg42, KeyboardActionHandler arg43, TextFieldLineLimits arg44, Function2 arg45, MutableInteractionSource arg46, Brush arg47, OutputTransformation arg48, TextFieldDecorator arg49, ScrollState arg50, Composer arg51, int arg52, int arg53, int arg54) {
        ScrollState v15_2;
        TextFieldDecorator v14_2;
        OutputTransformation v13_3;
        Brush v12_3;
        MutableInteractionSource v11_2;
        Function2 v10_3;
        TextFieldLineLimits v9_2;
        KeyboardActionHandler v8_1;
        KeyboardOptions v7_1;
        TextStyle v6_2;
        InputTransformation v5_2;
        boolean v4_1;
        boolean v3_1;
        Modifier v2_2;
        Composer v22_1;
        KeyboardActionHandler v12_1;
        TextStyle v10_1;
        ScrollState v20_1;
        TextFieldDecorator v19_1;
        OutputTransformation v18_1;
        MutableInteractionSource v17_1;
        Function2 v14_1;
        TextFieldLineLimits v0_2;
        SolidColor v16_3;
        Brush v19_3;
        int v24;
        int v33;
        int v20;
        int v32;
        int v31;
        KeyboardOptions v15;
        int v27;
        TextStyle v12;
        int v25;
        InputTransformation v11;
        int v21;
        boolean v8;
        int v17;
        boolean v7;
        int v14;
        Modifier v13;
        int v9;
        TextFieldState v6;
        TextFieldDecorator v0 = arg49;
        int v1 = arg52;
        int v2 = arg53;
        int v3 = arg54;
        Composer v5 = arg51.startRestartGroup(0x1BFB15B1);
        ComposerKt.sourceInformation(v5, "C(BasicTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,interactionSource,cursorBrush,outputTransformation,decorator,scrollState)202@12315L610:BasicTextField.kt#423gt5");
        if((v1 & 6) == 0) {
            v6 = arg36;
            v9 = v5.changed(v6) ? 4 : 2;
            v9 |= v1;
        }
        else {
            v6 = arg36;
            v9 = v1;
        }

        int v10 = v3 & 2;
        if(v10 != 0) {
            v9 |= 0x30;
            goto label_35;
        }
        else if((v1 & 0x30) == 0) {
            v13 = arg37;
            v14 = v5.changed(v13) ? 0x20 : 16;
            v9 |= v14;
        }
        else {
        label_35:
            v13 = arg37;
        }

        v14 = v3 & 4;
        int v16 = 0x80;
        if(v14 != 0) {
            v9 |= 0x180;
            goto label_51;
        }
        else if((v1 & 0x180) == 0) {
            v7 = arg38;
            v17 = v5.changed(v7) ? 0x100 : v16;
            v9 |= v17;
        }
        else {
        label_51:
            v7 = arg38;
        }

        v17 = v3 & 8;
        int v18 = 0x800;
        int v19 = 0x400;
        if(v17 != 0) {
            v9 |= 0xC00;
            goto label_68;
        }
        else if((v1 & 0xC00) == 0) {
            v8 = arg39;
            v21 = v5.changed(v8) ? v18 : v19;
            v9 |= v21;
        }
        else {
        label_68:
            v8 = arg39;
        }

        v21 = v3 & 16;
        int v22 = 0x2000;
        int v23 = 0x4000;
        if(v21 != 0) {
            v9 |= 0x6000;
            goto label_85;
        }
        else if((v1 & 0x6000) == 0) {
            v11 = arg40;
            v25 = v5.changed(v11) ? v23 : v22;
            v9 |= v25;
        }
        else {
        label_85:
            v11 = arg40;
        }

        v25 = v3 & 0x20;
        int v26 = 0x30000;
        if(v25 != 0) {
            v9 |= v26;
            v12 = arg41;
        }
        else {
            v12 = arg41;
            if((v1 & v26) == 0) {
                v27 = v5.changed(v12) ? 0x20000 : 0x10000;
                v9 |= v27;
            }
        }

        v27 = v3 & 0x40;
        int v28 = 0x180000;
        if(v27 != 0) {
            v9 |= v28;
            v15 = arg42;
        }
        else {
            v15 = arg42;
            if((v1 & v28) == 0) {
                int v29 = v5.changed(v15) ? 0x100000 : 0x80000;
                v9 |= v29;
            }
        }

        int v4 = v3 & 0x80;
        int v30 = 0xC00000;
        if(v4 != 0) {
            v9 |= v30;
        }
        else {
            v30 &= v1;
            KeyboardActionHandler v1_1 = arg43;
            if(v30 == 0) {
                v30 = v5.changed(v1_1) ? 0x800000 : 0x400000;
                v9 |= v30;
            }
        }

        v1 = v3 & 0x100;
        v30 = 0x6000000;
        if(v1 != 0) {
            v9 |= v30;
            goto label_147;
        }
        else if((arg52 & v30) == 0) {
            v30 = v1;
            v31 = v5.changed(arg44) ? 0x4000000 : 0x2000000;
            v9 |= v31;
        }
        else {
        label_147:
            v30 = v1;
        }

        v1 = v3 & 0x200;
        v31 = 0x30000000;
        if(v1 != 0) {
            v9 |= v31;
            goto label_165;
        }
        else if((arg52 & v31) == 0) {
            v31 = v1;
            v32 = v5.changedInstance(arg45) ? 0x20000000 : 0x10000000;
            v9 |= v32;
        }
        else {
        label_165:
            v31 = v1;
        }

        v1 = v3 & 0x400;
        if(v1 != 0) {
            v20 = v2 | 6;
            v32 = v1;
        }
        else if((v2 & 6) == 0) {
            v32 = v1;
            v20 = v5.changed(arg46) ? 4 : 2;
            v20 |= v2;
        }
        else {
            v32 = v1;
            v20 = v2;
        }

        v1 = v3 & 0x800;
        if(v1 != 0) {
            v20 |= 0x30;
            v33 = v1;
        }
        else if((v2 & 0x30) == 0) {
            v33 = v1;
            v24 = v5.changed(arg47) ? 0x20 : 16;
            v20 |= v24;
        }
        else {
            v33 = v1;
        }

        v1 = v20;
        v20 = v4;
        v4 = v3 & 0x1000;
        if(v4 != 0) {
            v1 |= 0x180;
        }
        else {
            v24 = v1;
            if((v2 & 0x180) == 0) {
                if(v5.changed(arg48)) {
                    v16 = 0x100;
                }

                v1 = v24 | v16;
            }
            else {
                v1 = v24;
            }
        }

        v16 = v4;
        v4 = v3 & 0x2000;
        if(v4 != 0) {
            v1 |= 0xC00;
        }
        else {
            v24 = v1;
            if((v2 & 0xC00) == 0) {
                boolean v1_2 = (v2 & 0x1000) == 0 ? v5.changed(v0) : v5.changedInstance(v0);
                if(v1_2) {
                }
                else {
                    v18 = v19;
                }

                v1 = v24 | v18;
            }
            else {
                v1 = v24;
            }
        }

        if((v2 & 0x6000) == 0) {
            if((v3 & 0x4000) == 0 && (v5.changed(arg50))) {
                v22 = v23;
            }

            v1 |= v22;
        }

        v18 = v4;
        boolean v0_1 = (v9 & 306783379) != 306783378 || (v1 & 9363) != 9362 ? true : false;
        if(v5.shouldExecute(v0_1, v9 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "198@12169L21");
            if((arg52 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v10 != 0) {
                    Companion v13_1 = Modifier.Companion;
                }

                if(v14 != 0) {
                    v7 = true;
                }

                if(v17 != 0) {
                    v8 = false;
                }

                v0 = null;
                if(v21 != 0) {
                    v11 = ((InputTransformation)v0);
                }

                TextStyle v2_1 = v25 != 0 ? TextStyle.Companion.getDefault() : v12;
                if(v27 != 0) {
                    v15 = KeyboardOptions.Companion.getDefault();
                }

                KeyboardActionHandler v10_2 = v20 != 0 ? ((KeyboardActionHandler)v0) : arg43;
                TextFieldLineLimits v12_2 = v30 != 0 ? TextFieldLineLimits.Companion.getDefault() : arg44;
                v14_1 = v31 != 0 ? ((Function2)v0) : arg45;
                v17_1 = v32 != 0 ? ((MutableInteractionSource)v0) : arg46;
                if(v33 != 0) {
                    SolidColor v19_2 = BasicTextFieldDefaults.INSTANCE.getCursorBrush();
                }
                else {
                    v19_3 = arg47;
                }

                OutputTransformation v16_2 = v16 != 0 ? ((OutputTransformation)v0) : arg48;
                if(v18 != 0) {
                }
                else {
                    v0 = arg49;
                }

                TextFieldDecorator v37 = v0;
                if((v3 & 0x4000) != 0) {
                    v1 &= 0xFFFF1FFF;
                    v20_1 = ScrollKt.rememberScrollState(0, v5, 0, 1);
                }
                else {
                    v20_1 = arg50;
                }

                v0_2 = v12_2;
                v18_1 = v16_2;
                v16_3 = ((SolidColor)v19_3);
                v19_1 = v37;
                v12_1 = v10_2;
                v10_1 = v2_1;
            }
            else {
                v5.skipToGroupEnd();
                if((v3 & 0x4000) != 0) {
                    v1 &= 0xFFFF1FFF;
                }

                v0_2 = arg44;
                v14_1 = arg45;
                v17_1 = arg46;
                Brush v16_1 = arg47;
                v18_1 = arg48;
                v19_1 = arg49;
                v20_1 = arg50;
                v10_1 = v12;
                v12_1 = arg43;
            }

            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x1BFB15B1, v9, v1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:201)");
            }

            v23 = v9 & 0x7FFFFFFE;
            v2 = v1 & 14 | 0x180 | v1 & 0x70;
            v1 <<= 3;
            InputTransformation v9_1 = v11;
            KeyboardOptions v11_1 = v15;
            MutableInteractionSource v15_1 = v17_1;
            v22_1 = v5;
            TextFieldState v5_1 = v6;
            Modifier v6_1 = v13;
            TextFieldLineLimits v13_2 = v0_2;
            BasicTextFieldKt.BasicTextField(v5_1, v6_1, v7, v8, v9_1, v10_1, v11_1, v12_1, v13_2, v14_1, v15_1, ((Brush)v16_3), null, v18_1, v19_1, v20_1, false, v22_1, v23, v2 | v1 & 0x1C00 | 0xE000 & v1 | v1 & 0x70000, 0x10000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = v6_1;
            v3_1 = v7;
            v4_1 = v8;
            v5_2 = v9_1;
            v6_2 = v10_1;
            v7_1 = v11_1;
            v8_1 = v12_1;
            v9_2 = v13_2;
            v10_3 = v14_1;
            v11_2 = v15_1;
            v12_3 = ((Brush)v16_3);
            v13_3 = v18_1;
            v14_2 = v19_1;
            v15_2 = v20_1;
        }
        else {
            v22_1 = v5;
            v22_1.skipToGroupEnd();
            v9_2 = arg44;
            v10_3 = arg45;
            v14_2 = arg49;
            v3_1 = v7;
            v4_1 = v8;
            v5_2 = v11;
            v6_2 = v12;
            v2_2 = v13;
            v7_1 = v15;
            v8_1 = arg43;
            v11_2 = arg46;
            v12_3 = arg47;
            v13_3 = arg48;
            v15_2 = arg50;
        }

        ScopeUpdateScope v0_3 = v22_1.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda0(arg36, v2_2, v3_1, v4_1, v5_2, v6_2, v7_1, v8_1, v9_2, v10_3, v11_2, v12_3, v13_3, v14_2, v15_2, arg52, arg53, arg54));
        }
    }

    public static final void BasicTextField(TextFieldValue arg37, Function1 arg38, Modifier arg39, boolean arg40, boolean arg41, TextStyle arg42, KeyboardOptions arg43, KeyboardActions arg44, boolean arg45, int arg46, int arg47, VisualTransformation arg48, Function1 arg49, MutableInteractionSource arg50, Brush arg51, Function3 arg52, Composer arg53, int arg54, int arg55, int arg56) {
        Modifier v3_9;
        TextStyle v6_2;
        MutableInteractionSource v14_2;
        Function1 v13_2;
        KeyboardOptions v7_3;
        boolean v4_6;
        Brush v15_3;
        boolean v9_3;
        int v11_3;
        Function3 v16_2;
        KeyboardActions v8_4;
        Composer v17_2;
        Function1 v41;
        Function3 v11_1;
        Function1 v8_1;
        boolean v14_1;
        boolean v13_1;
        MutableInteractionSource v9_1;
        VisualTransformation v7_1;
        KeyboardOptions v4_1;
        TextStyle v39;
        KeyboardActions v12_1;
        boolean v5_1;
        SolidColor v10_2;
        Brush v3_7;
        int v43;
        MutableInteractionSource v42;
        Object v3_3;
        VisualTransformation v12_2;
        int v9_2;
        int v22;
        int v34;
        int v33;
        KeyboardActions v9;
        KeyboardOptions v14;
        int v27;
        TextStyle v13;
        int v23;
        boolean v11;
        int v19;
        boolean v8;
        int v16;
        Modifier v15;
        int v10;
        int v7;
        TextFieldValue v0 = arg37;
        Function1 v1 = arg38;
        int v2 = arg54;
        int v3 = arg55;
        int v4 = arg56;
        Composer v6 = arg53.startRestartGroup(0xC61E058F);
        ComposerKt.sourceInformation(v6, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)909@47938L90,907@47876L741:BasicTextField.kt#423gt5");
        if((v2 & 6) == 0) {
            v7 = v6.changed(v0) ? 4 : 2;
            v7 |= v2;
        }
        else {
            v7 = v2;
        }

        if((v2 & 0x30) == 0) {
            v10 = v6.changedInstance(v1) ? 0x20 : 16;
            v7 |= v10;
        }

        v10 = v4 & 4;
        if(v10 != 0) {
            v7 |= 0x180;
            goto label_42;
        }
        else if((v2 & 0x180) == 0) {
            v15 = arg39;
            v16 = v6.changed(v15) ? 0x100 : 0x80;
            v7 |= v16;
        }
        else {
        label_42:
            v15 = arg39;
        }

        v16 = v4 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v7 |= 0xC00;
            goto label_59;
        }
        else if((v2 & 0xC00) == 0) {
            v8 = arg40;
            v19 = v6.changed(v8) ? v17 : v18;
            v7 |= v19;
        }
        else {
        label_59:
            v8 = arg40;
        }

        v19 = v4 & 16;
        int v20 = 0x4000;
        int v21 = 0x2000;
        if(v19 != 0) {
            v7 |= 0x6000;
            goto label_76;
        }
        else if((v2 & 0x6000) == 0) {
            v11 = arg41;
            v23 = v6.changed(v11) ? v20 : v21;
            v7 |= v23;
        }
        else {
        label_76:
            v11 = arg41;
        }

        v23 = v4 & 0x20;
        int v24 = 0x10000;
        int v25 = 0x30000;
        if(v23 != 0) {
            v7 |= v25;
            v13 = arg42;
        }
        else {
            v13 = arg42;
            if((v2 & v25) == 0) {
                v27 = v6.changed(v13) ? 0x20000 : v24;
                v7 |= v27;
            }
        }

        v27 = v4 & 0x40;
        int v28 = 0x180000;
        if(v27 != 0) {
            v7 |= v28;
            v14 = arg43;
        }
        else {
            v14 = arg43;
            if((v2 & v28) == 0) {
                int v29 = v6.changed(v14) ? 0x100000 : 0x80000;
                v7 |= v29;
            }
        }

        int v12 = v4 & 0x80;
        int v30 = 0xC00000;
        if(v12 != 0) {
            v7 |= v30;
            v9 = arg44;
        }
        else {
            v9 = arg44;
            if((v2 & v30) == 0) {
                int v31 = v6.changed(v9) ? 0x800000 : 0x400000;
                v7 |= v31;
            }
        }

        int v5 = v4 & 0x100;
        int v32 = 0x6000000;
        if(v5 != 0) {
            v7 |= v32;
        }
        else {
            v32 &= v2;
            boolean v2_1 = arg45;
            if(v32 == 0) {
                v32 = v6.changed(v2_1) ? 0x4000000 : 0x2000000;
                v7 |= v32;
            }
        }

        if((arg54 & 0x30000000) == 0) {
            v32 = (v4 & 0x200) != 0 || !v6.changed(arg46) ? 0x10000000 : 0x20000000;
            v7 |= v32;
        }

        v2 = v4 & 0x400;
        if(v2 != 0) {
            v33 = v3 | 6;
            v32 = v2;
        }
        else if((v3 & 6) == 0) {
            v32 = v2;
            v33 = v6.changed(arg47) ? 4 : 2;
            v33 |= v3;
        }
        else {
            v32 = v2;
            v33 = v3;
        }

        v2 = v4 & 0x800;
        if(v2 != 0) {
            v33 |= 0x30;
            v34 = v2;
        }
        else if((v3 & 0x30) == 0) {
            v34 = v2;
            v22 = v6.changed(arg48) ? 0x20 : 16;
            v33 |= v22;
        }
        else {
            v34 = v2;
        }

        v2 = v33;
        v22 = v5;
        v5 = v4 & 0x1000;
        if(v5 != 0) {
            v2 |= 0x180;
        }
        else {
            v33 = v2;
            if((v3 & 0x180) == 0) {
                v28 = v6.changedInstance(arg49) ? 0x100 : 0x80;
                v2 = v33 | v28;
            }
            else {
                v2 = v33;
            }
        }

        int v26 = v5;
        v5 = v4 & 0x2000;
        if(v5 != 0) {
            v2 |= 0xC00;
        }
        else {
            v28 = v2;
            if((v3 & 0xC00) == 0) {
                if(v6.changed(arg50)) {
                }
                else {
                    v17 = v18;
                }

                v2 = v28 | v17;
            }
            else {
                v2 = v28;
            }
        }

        v17 = v5;
        v5 = v4 & 0x4000;
        if(v5 != 0) {
            v18 = v2 | 0x6000;
        }
        else {
            v18 = v2;
            if((v3 & 0x6000) == 0) {
                if(v6.changed(arg51)) {
                }
                else {
                    v20 = v21;
                }

                v18 |= v20;
            }
        }

        v20 = v4 & 0x8000;
        if(v20 != 0) {
            v18 |= v25;
        }
        else {
            Function3 v2_2 = arg52;
            if((v3 & v25) == 0) {
                if(v6.changedInstance(v2_2)) {
                    v24 = 0x20000;
                }

                v18 |= v24;
            }
        }

        v2 = v18;
        v18 = v5;
        v21 = 0;
        boolean v3_1 = (v7 & 306783379) != 306783378 || (74899 & v2) != 74898 ? true : false;
        if(v6.shouldExecute(v3_1, v7 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "901@47615L2");
            if((arg54 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v10 != 0) {
                    Companion v15_1 = Modifier.Companion;
                }

                if(v16 != 0) {
                    v8 = true;
                }

                if(v19 != 0) {
                    v11 = false;
                }

                if(v23 != 0) {
                    v13 = TextStyle.Companion.getDefault();
                }

                if(v27 != 0) {
                    v14 = KeyboardOptions.Companion.getDefault();
                }

                KeyboardActions v3_2 = v12 != 0 ? KeyboardActions.Companion.getDefault() : v9;
                v5_1 = v22 != 0 ? false : arg45;
                if((v4 & 0x200) != 0) {
                    v9_2 = v5_1 ? 1 : 0x7FFFFFFF;
                    v7 &= 0x8FFFFFFF;
                }
                else {
                    v9_2 = arg46;
                }

                v10 = v32 != 0 ? 1 : arg47;
                v12_2 = v34 != 0 ? VisualTransformation.Companion.getNone() : arg48;
                KeyboardActions v39_1 = v3_2;
                if(v26 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v6, 0xB6B32891, "CC(remember):BasicTextField.kt#9igjgp");
                    v3_3 = v6.rememberedValue();
                    if(v3_3 == Composer.Companion.getEmpty()) {
                        BasicTextFieldKt$$ExternalSyntheticLambda11 v3_4 = new BasicTextFieldKt$$ExternalSyntheticLambda11();
                        v6.updateRememberedValue(v3_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v6);
                }
                else {
                    Function1 v3_5 = arg49;
                }

                MutableInteractionSource v4_2 = v17 != 0 ? null : arg50;
                Object v40 = v3_3;
                if(v18 != 0) {
                    v42 = v4_2;
                    arg41 = v5_1;
                    v43 = v7;
                    SolidColor v3_6 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
                }
                else {
                    v42 = v4_2;
                    arg41 = v5_1;
                    v43 = v7;
                    v3_7 = arg51;
                }

                if(v20 != 0) {
                    v5_1 = v11;
                    v11_1 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$486633673$foundation();
                    v4_1 = v14;
                    v14_1 = v5_1;
                    v5_1 = arg41;
                    v22 = v9_2;
                    v23 = v10;
                    v7_1 = v12_2;
                    v12_1 = v39_1;
                    v9_1 = v42;
                    v10_2 = ((SolidColor)v3_7);
                    v39 = v13;
                    v3 = v43;
                }
                else {
                    v5_1 = arg41;
                    v22 = v9_2;
                    v23 = v10;
                    v7_1 = v12_2;
                    v4_1 = v14;
                    v12_1 = v39_1;
                    v9_1 = v42;
                    v10_2 = ((SolidColor)v3_7);
                    v14_1 = v11;
                    v39 = v13;
                    v3 = v43;
                    v11_1 = arg52;
                }

                v13_1 = v8;
                Object v8_2 = v40;
            }
            else {
                v6.skipToGroupEnd();
                if((v4 & 0x200) != 0) {
                    v7 &= 0x8FFFFFFF;
                }

                v5_1 = arg45;
                v22 = arg46;
                v23 = arg47;
                Brush v10_1 = arg51;
                v3 = v7;
                v12_1 = v9;
                v39 = v13;
                v4_1 = v14;
                v7_1 = arg48;
                v9_1 = arg50;
                v13_1 = v8;
                v14_1 = v11;
                v8_1 = arg49;
                v11_1 = arg52;
            }

            v6.endDefaults();
            VisualTransformation v40_1 = v7_1;
            if(ComposerKt.isTraceInProgress()) {
                v41 = v8_1;
                ComposerKt.traceEventStart(0xC61E058F, v3, v2, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:906)");
            }
            else {
                v41 = v8_1;
            }

            v18 = v2;
            Modifier v2_3 = v15;
            Function3 v15_2 = v11_1;
            ImeOptions v11_2 = v4_1.toImeOptions$foundation(v5_1);
            int v8_3 = (((int)v5_1)) ^ 1;
            Brush v7_2 = ((Brush)v10_2);
            v10 = v5_1 ? 1 : v23;
            MutableInteractionSource v16_1 = v9_1;
            v9_2 = v5_1 ? 1 : v22;
            Modifier v42_1 = v2_3;
            KeyboardOptions v17_1 = v4_1;
            ComposerKt.sourceInformationMarkerStart(v6, 0xB6B35149, "CC(remember):BasicTextField.kt#9igjgp");
            v2 = (v3 & 14) == 4 ? 1 : 0;
            v43 = v2;
            if((v3 & 0x70) == 0x20) {
                v21 = 1;
            }

            Object v4_3 = v6.rememberedValue();
            if((v43 | v21) != 0 || v4_3 == Composer.Companion.getEmpty()) {
                BasicTextFieldKt$$ExternalSyntheticLambda18 v4_4 = new BasicTextFieldKt$$ExternalSyntheticLambda18(v0, v1);
                v6.updateRememberedValue(v4_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v2 = v18 << 9;
            v43 = v3 >> 6 & 0x1C00 | v3 & 910 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000;
            v19 = v3 & 0x1C00 | v3 >> 15 & 0x380 | 0xE000 & v3 | v18 & 0x70000;
            KeyboardOptions v0_1 = v17_1;
            v17_2 = v6;
            MutableInteractionSource v6_1 = v16_1;
            TextStyle v3_8 = v39;
            v2_3 = v42_1;
            KeyboardOptions v21_1 = v0_1;
            Object v1_1 = v4_3;
            boolean v24_1 = v5_1;
            VisualTransformation v4_5 = v40_1;
            Function1 v5_2 = v41;
            CoreTextFieldKt.CoreTextField(arg37, ((Function1)v1_1), v2_3, v3_8, v4_5, v5_2, v6_1, v7_2, ((boolean)v8_3), v9_2, v10, v11_2, v12_1, v13_1, v14_1, v15_2, null, v17_2, v43, v19, 0x10000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_4 = v12_1;
            v16_2 = v15_2;
            v10 = v22;
            v11_3 = v23;
            v9_3 = v24_1;
            v12_2 = v4_5;
            v15_3 = v7_2;
            v4_6 = v13_1;
            v7_3 = v21_1;
            v13_2 = v5_2;
            v5_1 = v14_1;
            v14_2 = v6_1;
            v6_2 = v3_8;
            v3_9 = v2_3;
        }
        else {
            v17_2 = v6;
            v17_2.skipToGroupEnd();
            v10 = arg46;
            v12_2 = arg48;
            v16_2 = arg52;
            v4_6 = v8;
            v8_4 = v9;
            v5_1 = v11;
            v6_2 = v13;
            v7_3 = v14;
            v3_9 = v15;
            v9_3 = arg45;
            v11_3 = arg47;
            v13_2 = arg49;
            v14_2 = arg50;
            v15_3 = arg51;
        }

        ScopeUpdateScope v0_2 = v17_2.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda19(arg37, arg38, v3_9, v4_6, v5_1, v6_2, v7_3, v8_4, v9_3, v10, v11_3, v12_2, v13_2, v14_2, v15_3, v16_2, arg54, arg55, arg56));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void BasicTextField(TextFieldValue arg36, Function1 arg37, Modifier arg38, boolean arg39, boolean arg40, TextStyle arg41, KeyboardOptions arg42, KeyboardActions arg43, boolean arg44, int arg45, VisualTransformation arg46, Function1 arg47, MutableInteractionSource arg48, Brush arg49, Function3 arg50, Composer arg51, int arg52, int arg53, int arg54) {
        Brush v14_2;
        MutableInteractionSource v13_2;
        Function1 v12_3;
        Function3 v15_2;
        VisualTransformation v11_2;
        int v10_2;
        boolean v9_1;
        KeyboardActions v8_2;
        KeyboardOptions v7_1;
        TextStyle v6_2;
        boolean v5_1;
        boolean v4_1;
        Companion v3_1;
        SolidColor v18_1;
        Composer v20_1;
        Object v17_1;
        Object v16_1;
        Object v2_1;
        Companion v6;
        int v32;
        int v22;
        int v31;
        KeyboardActions v14;
        int v27;
        KeyboardOptions v11;
        int v25;
        TextStyle v10;
        int v23;
        int v19;
        int v16;
        Modifier v15;
        int v12;
        int v8;
        TextFieldValue v5;
        int v0 = arg52;
        int v1 = arg53;
        int v2 = arg54;
        Composer v4 = arg51.startRestartGroup(0x67DA1112);
        ComposerKt.sourceInformation(v4, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)985@50780L2,986@50834L39,991@51075L580:BasicTextField.kt#423gt5");
        if((v0 & 6) == 0) {
            v5 = arg36;
            v8 = v4.changed(v5) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v5 = arg36;
            v8 = v0;
        }

        if((v0 & 0x30) == 0) {
            v12 = v4.changedInstance(arg37) ? 0x20 : 16;
            v8 |= v12;
        }

        v12 = v2 & 4;
        if(v12 != 0) {
            v8 |= 0x180;
            goto label_45;
        }
        else if((v0 & 0x180) == 0) {
            v15 = arg38;
            v16 = v4.changed(v15) ? 0x100 : 0x80;
            v8 |= v16;
        }
        else {
        label_45:
            v15 = arg38;
        }

        v16 = v2 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v8 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v19 = v4.changed(arg39) ? v17 : v18;
            v8 |= v19;
        }

        v19 = v2 & 16;
        int v20 = 0x4000;
        int v21 = 0x2000;
        if(v19 != 0) {
            v8 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v23 = v4.changed(arg40) ? v20 : v21;
            v8 |= v23;
        }

        v23 = v2 & 0x20;
        int v24 = 0x30000;
        if(v23 != 0) {
            v8 |= v24;
            v10 = arg41;
        }
        else {
            v10 = arg41;
            if((v0 & v24) == 0) {
                v25 = v4.changed(v10) ? 0x20000 : 0x10000;
                v8 |= v25;
            }
        }

        v25 = v2 & 0x40;
        int v26 = 0x180000;
        if(v25 != 0) {
            v8 |= v26;
            v11 = arg42;
        }
        else {
            v11 = arg42;
            if((v0 & v26) == 0) {
                v27 = v4.changed(v11) ? 0x100000 : 0x80000;
                v8 |= v27;
            }
        }

        int v13 = v2 & 0x80;
        int v28 = 0xC00000;
        if(v13 != 0) {
            v8 |= v28;
            v14 = arg43;
        }
        else {
            v14 = arg43;
            if((v0 & v28) == 0) {
                int v29 = v4.changed(v14) ? 0x800000 : 0x400000;
                v8 |= v29;
            }
        }

        int v3 = v2 & 0x100;
        int v30 = 0x6000000;
        if(v3 != 0) {
            v8 |= v30;
        }
        else {
            v30 &= v0;
            boolean v0_1 = arg44;
            if(v30 == 0) {
                v30 = v4.changed(v0_1) ? 0x4000000 : 0x2000000;
                v8 |= v30;
            }
        }

        v0 = v2 & 0x200;
        v30 = 0x30000000;
        if(v0 != 0) {
            v8 |= v30;
            goto label_156;
        }
        else if((arg52 & v30) == 0) {
            v30 = v0;
            v31 = v4.changed(arg45) ? 0x20000000 : 0x10000000;
            v8 |= v31;
        }
        else {
        label_156:
            v30 = v0;
        }

        v0 = v2 & 0x400;
        if(v0 != 0) {
            v22 = v1 | 6;
            v31 = v0;
        }
        else if((v1 & 6) == 0) {
            v31 = v0;
            v22 = v4.changed(arg46) ? 4 : 2;
            v22 |= v1;
        }
        else {
            v31 = v0;
            v22 = v1;
        }

        v0 = v2 & 0x800;
        if(v0 != 0) {
            v22 |= 0x30;
            v32 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v32 = v0;
            v24 = v4.changedInstance(arg47) ? 0x20 : 16;
            v22 |= v24;
        }
        else {
            v32 = v0;
        }

        v0 = v22;
        v22 = v3;
        v3 = v2 & 0x1000;
        if(v3 != 0) {
            v0 |= 0x180;
        }
        else {
            v24 = v0;
            if((v1 & 0x180) == 0) {
                v27 = v4.changed(arg48) ? 0x100 : 0x80;
                v24 |= v27;
            }

            v0 = v24;
        }

        v24 = v3;
        v3 = v2 & 0x2000;
        if(v3 != 0) {
            v0 |= 0xC00;
        }
        else {
            v26 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg49)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v26 | v17;
            }
            else {
                v0 = v26;
            }
        }

        v17 = v3;
        v3 = v2 & 0x4000;
        if(v3 != 0) {
            v0 |= 0x6000;
        }
        else {
            v18 = v0;
            if((v1 & 0x6000) == 0) {
                if(v4.changedInstance(arg50)) {
                }
                else {
                    v20 = v21;
                }

                v18 |= v20;
            }

            v0 = v18;
        }

        boolean v1_1 = (v8 & 306783379) != 306783378 || (v0 & 9363) != 9362 ? true : false;
        if(v4.shouldExecute(v1_1, v8 & 1)) {
            if(v12 != 0) {
                v6 = Modifier.Companion;
            }
            else {
                Modifier v6_1 = v15;
            }

            boolean v7 = v16 != 0 ? true : arg39;
            v1_1 = v19 != 0 ? false : arg40;
            TextStyle v9 = v23 != 0 ? TextStyle.Companion.getDefault() : v10;
            KeyboardOptions v10_1 = v25 != 0 ? KeyboardOptions.Companion.getDefault() : v11;
            KeyboardActions v11_1 = v13 != 0 ? KeyboardActions.Companion.getDefault() : v14;
            boolean v12_1 = v22 != 0 ? false : arg44;
            v13 = v30 != 0 ? 0x7FFFFFFF : arg45;
            VisualTransformation v15_1 = v31 != 0 ? VisualTransformation.Companion.getNone() : arg46;
            if(v32 != 0) {
                ComposerKt.sourceInformationMarkerStart(v4, 0xD99A5994, "CC(remember):BasicTextField.kt#9igjgp");
                v2_1 = v4.rememberedValue();
                if(v2_1 == Composer.Companion.getEmpty()) {
                    BasicTextFieldKt$$ExternalSyntheticLambda25 v2_2 = new BasicTextFieldKt$$ExternalSyntheticLambda25();
                    v4.updateRememberedValue(v2_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v16_1 = v2_1;
            }
            else {
                Function1 v16_2 = arg47;
            }

            if(v24 != 0) {
                ComposerKt.sourceInformationMarkerStart(v4, 0xD99A6079, "CC(remember):BasicTextField.kt#9igjgp");
                v2_1 = v4.rememberedValue();
                if(v2_1 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v2_3 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                int v35 = v17;
                v17_1 = v2_1;
                v2 = v35;
            }
            else {
                v2 = v17;
                MutableInteractionSource v17_2 = arg48;
            }

            if(v2 != 0) {
                v20_1 = v4;
                v18_1 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
                v2 = v3;
            }
            else {
                v20_1 = v4;
                Brush v18_2 = arg49;
                v2 = v3;
            }

            Function3 v19_1 = v2 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$-665310900$foundation() : arg50;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x67DA1112, v8, v0, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:990)");
            }

            v21 = v8 & 0x7FFFFFFE;
            v0 <<= 3;
            boolean v8_1 = v1_1;
            BasicTextFieldKt.BasicTextField(v5, arg37, ((Modifier)v6), v7, v8_1, v9, v10_1, v11_1, v12_1, v13, 1, v15_1, ((Function1)v16_1), ((MutableInteractionSource)v17_1), ((Brush)v18_1), v19_1, v20_1, v21, v0 & 0x70 | 6 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0 | v0 & 0x70000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v6;
            v4_1 = v7;
            v5_1 = v8_1;
            v6_2 = v9;
            v7_1 = v10_1;
            v8_2 = v11_1;
            v9_1 = v12_1;
            v10_2 = v13;
            v11_2 = v15_1;
            Object v12_2 = v16_1;
            Object v13_1 = v17_1;
            SolidColor v14_1 = v18_1;
            v15_2 = v19_1;
        }
        else {
            v20_1 = v4;
            v20_1.skipToGroupEnd();
            v4_1 = arg39;
            v5_1 = arg40;
            v9_1 = arg44;
            v12_3 = arg47;
            v13_2 = arg48;
            v6_2 = v10;
            v7_1 = v11;
            v8_2 = v14;
            Modifier v3_2 = v15;
            v10_2 = arg45;
            v11_2 = arg46;
            v14_2 = arg49;
            v15_2 = arg50;
        }

        ScopeUpdateScope v0_2 = v20_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda1(arg36, arg37, ((Modifier)v3_1), v4_1, v5_1, v6_2, v7_1, v8_2, v9_1, v10_2, v11_2, v12_3, v13_2, v14_2, v15_2, arg52, arg53, arg54));
        }
    }

    public static final void BasicTextField(String arg36, Function1 arg37, Modifier arg38, boolean arg39, boolean arg40, TextStyle arg41, KeyboardOptions arg42, KeyboardActions arg43, boolean arg44, int arg45, int arg46, VisualTransformation arg47, Function1 arg48, MutableInteractionSource arg49, Brush arg50, Function3 arg51, Composer arg52, int arg53, int arg54, int arg55) {
        int v11_3;
        Function1 v13_3;
        VisualTransformation v12_2;
        boolean v9_2;
        Function3 v16_2;
        boolean v4_4;
        Brush v15_4;
        MutableInteractionSource v14_3;
        TextStyle v6_1;
        Modifier v3_4;
        KeyboardOptions v7_1;
        Composer v23_1;
        BasicTextFieldKt$$ExternalSyntheticLambda5 v3_3;
        Modifier v39_1;
        MutableState v14_2;
        MutableInteractionSource v12_1;
        Function1 v11_1;
        Modifier v8_1;
        TextStyle v9_1;
        boolean v20_1;
        KeyboardOptions v1_3;
        boolean v19_1;
        KeyboardActions v4_1;
        Function3 v21_1;
        VisualTransformation v10_1;
        boolean v5_1;
        SolidColor v13_2;
        SolidColor v1_7;
        int v41;
        MutableInteractionSource v40;
        Object v1_5;
        KeyboardActions v38;
        Companion v15_1;
        int v25;
        int v22;
        int v33;
        int v32;
        KeyboardActions v8;
        KeyboardOptions v12;
        int v26;
        TextStyle v14;
        int v23;
        boolean v13;
        int v19;
        boolean v11;
        int v16;
        Modifier v15;
        int v10;
        int v7;
        String v1 = arg36;
        Function1 v2 = arg37;
        int v0 = arg53;
        int v3 = arg54;
        int v4 = arg55;
        Composer v6 = arg52.startRestartGroup(0x78D0D0FC);
        ComposerKt.sourceInformation(v6, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)752@39049L57,758@39402L242,758@39391L253,769@39965L41,773@40083L373,771@40012L1033:BasicTextField.kt#423gt5");
        if((v0 & 6) == 0) {
            v7 = v6.changed(v1) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        if((v0 & 0x30) == 0) {
            v10 = v6.changedInstance(v2) ? 0x20 : 16;
            v7 |= v10;
        }

        v10 = v4 & 4;
        if(v10 != 0) {
            v7 |= 0x180;
            goto label_42;
        }
        else if((v0 & 0x180) == 0) {
            v15 = arg38;
            v16 = v6.changed(v15) ? 0x100 : 0x80;
            v7 |= v16;
        }
        else {
        label_42:
            v15 = arg38;
        }

        v16 = v4 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v7 |= 0xC00;
            goto label_59;
        }
        else if((v0 & 0xC00) == 0) {
            v11 = arg39;
            v19 = v6.changed(v11) ? v17 : v18;
            v7 |= v19;
        }
        else {
        label_59:
            v11 = arg39;
        }

        v19 = v4 & 16;
        int v20 = 0x4000;
        int v21 = 0x2000;
        if(v19 != 0) {
            v7 |= 0x6000;
            goto label_76;
        }
        else if((v0 & 0x6000) == 0) {
            v13 = arg40;
            v23 = v6.changed(v13) ? v20 : v21;
            v7 |= v23;
        }
        else {
        label_76:
            v13 = arg40;
        }

        v23 = v4 & 0x20;
        int v24 = 0x30000;
        if(v23 != 0) {
            v7 |= v24;
            v14 = arg41;
        }
        else {
            v14 = arg41;
            if((v0 & v24) == 0) {
                v26 = v6.changed(v14) ? 0x20000 : 0x10000;
                v7 |= v26;
            }
        }

        v26 = v4 & 0x40;
        int v27 = 0x180000;
        if(v26 != 0) {
            v7 |= v27;
            v12 = arg42;
        }
        else {
            v12 = arg42;
            if((v0 & v27) == 0) {
                int v28 = v6.changed(v12) ? 0x100000 : 0x80000;
                v7 |= v28;
            }
        }

        int v9 = v4 & 0x80;
        int v29 = 0xC00000;
        if(v9 != 0) {
            v7 |= v29;
            v8 = arg43;
        }
        else {
            v8 = arg43;
            if((v0 & v29) == 0) {
                int v30 = v6.changed(v8) ? 0x800000 : 0x400000;
                v7 |= v30;
            }
        }

        int v5 = v4 & 0x100;
        int v31 = 0x6000000;
        if(v5 != 0) {
            v7 |= v31;
        }
        else {
            v31 &= v0;
            boolean v0_1 = arg44;
            if(v31 == 0) {
                v31 = v6.changed(v0_1) ? 0x4000000 : 0x2000000;
                v7 |= v31;
            }
        }

        if((arg53 & 0x30000000) == 0) {
            v31 = (v4 & 0x200) != 0 || !v6.changed(arg45) ? 0x10000000 : 0x20000000;
            v7 |= v31;
        }

        v0 = v4 & 0x400;
        if(v0 != 0) {
            v32 = v3 | 6;
            v31 = v0;
        }
        else if((v3 & 6) == 0) {
            v31 = v0;
            v32 = v6.changed(arg46) ? 4 : 2;
            v32 |= v3;
        }
        else {
            v31 = v0;
            v32 = v3;
        }

        v0 = v4 & 0x800;
        if(v0 != 0) {
            v32 |= 0x30;
            v33 = v0;
        }
        else if((v3 & 0x30) == 0) {
            v33 = v0;
            int v34 = v6.changed(arg47) ? 0x20 : 16;
            v32 |= v34;
        }
        else {
            v33 = v0;
        }

        v0 = v32;
        int v1_1 = v4 & 0x1000;
        if(v1_1 != 0) {
            v0 |= 0x180;
        }
        else {
            v32 = v0;
            if((v3 & 0x180) == 0) {
                v22 = v6.changedInstance(arg48) ? 0x100 : 0x80;
                v0 = v32 | v22;
            }
            else {
                v0 = v32;
            }
        }

        v22 = v1_1;
        v1_1 = v4 & 0x2000;
        if(v1_1 != 0) {
            v0 |= 0xC00;
        }
        else {
            v25 = v0;
            if((v3 & 0xC00) == 0) {
                if(v6.changed(arg49)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v25 | v17;
            }
            else {
                v0 = v25;
            }
        }

        v17 = v1_1;
        v1_1 = v4 & 0x4000;
        if(v1_1 != 0) {
            v18 = v0 | 0x6000;
        }
        else {
            v18 = v0;
            if((v3 & 0x6000) == 0) {
                if(v6.changed(arg50)) {
                }
                else {
                    v20 = v21;
                }

                v18 |= v20;
            }
        }

        v20 = v4 & 0x8000;
        if(v20 != 0) {
            v18 |= v24;
        }
        else {
            Function3 v0_2 = arg51;
            if((v3 & v24) == 0) {
                v21 = v6.changedInstance(v0_2) ? 0x20000 : 0x10000;
                v18 |= v21;
            }
        }

        v0 = v18;
        v21 = v1_1;
        v18 = v5;
        v24 = 1;
        boolean v1_2 = (v7 & 306783379) != 306783378 || (74899 & v0) != 74898 ? true : false;
        if(v6.shouldExecute(v1_2, v7 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "744@38634L2");
            String v3_1 = "CC(remember):BasicTextField.kt#9igjgp";
            if((arg53 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v10 != 0) {
                    v15_1 = Modifier.Companion;
                }

                if(v16 != 0) {
                    v11 = true;
                }

                if(v19 != 0) {
                    v13 = false;
                }

                if(v23 != 0) {
                    v14 = TextStyle.Companion.getDefault();
                }

                if(v26 != 0) {
                    v12 = KeyboardOptions.Companion.getDefault();
                }

                KeyboardActions v1_4 = v9 != 0 ? KeyboardActions.Companion.getDefault() : v8;
                boolean v8_2 = v18 != 0 ? false : arg44;
                if((v4 & 0x200) != 0) {
                    v9 = v8_2 ? 1 : 0x7FFFFFFF;
                    v7 &= 0x8FFFFFFF;
                }
                else {
                    v9 = arg45;
                }

                v10 = v31 != 0 ? 1 : arg46;
                VisualTransformation v16_1 = v33 != 0 ? VisualTransformation.Companion.getNone() : arg47;
                if(v22 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v6, -2015311170, v3_1);
                    Object v5_2 = v6.rememberedValue();
                    v38 = v1_4;
                    if(v5_2 == Composer.Companion.getEmpty()) {
                        BasicTextFieldKt$$ExternalSyntheticLambda3 v5_3 = new BasicTextFieldKt$$ExternalSyntheticLambda3();
                        v6.updateRememberedValue(v5_3);
                    }

                    v1_5 = v5_2;
                    ComposerKt.sourceInformationMarkerEnd(v6);
                }
                else {
                    v38 = v1_4;
                    Function1 v1_6 = arg48;
                }

                MutableInteractionSource v5_4 = v17 != 0 ? null : arg49;
                Object v39 = v1_5;
                if(v21 != 0) {
                    v40 = v5_4;
                    v41 = v7;
                    v1_7 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
                }
                else {
                    v40 = v5_4;
                    v41 = v7;
                    Brush v1_8 = arg50;
                }

                if(v20 != 0) {
                    v7 = v41;
                    v21_1 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$759698998$foundation();
                    v5_1 = v8_2;
                    v31 = v9;
                    v32 = v10;
                    v19_1 = v11;
                    v20_1 = v13;
                    v9_1 = v14;
                    v8_1 = ((Modifier)v15_1);
                    v10_1 = v16_1;
                    v4_1 = v38;
                }
                else {
                    v4_1 = v38;
                    v7 = v41;
                    v21_1 = arg51;
                    v5_1 = v8_2;
                    v31 = v9;
                    v32 = v10;
                    v19_1 = v11;
                    v20_1 = v13;
                    v9_1 = v14;
                    v8_1 = ((Modifier)v15_1);
                    v10_1 = v16_1;
                }

                Object v11_2 = v39;
                v13_2 = v1_7;
                v1_3 = v12;
                v12_1 = v40;
            }
            else {
                v6.skipToGroupEnd();
                if((v4 & 0x200) != 0) {
                    v7 &= 0x8FFFFFFF;
                }

                v5_1 = arg44;
                v31 = arg45;
                v32 = arg46;
                v10_1 = arg47;
                v21_1 = arg51;
                v4_1 = v8;
                v19_1 = v11;
                v1_3 = v12;
                v20_1 = v13;
                v9_1 = v14;
                v8_1 = v15;
                v11_1 = arg48;
                v12_1 = arg49;
                Brush v13_1 = arg50;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x78D0D0FC, v7, v0, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:749)");
            }

            ComposerKt.sourceInformationMarkerStart(v6, 0x87E0FED5, v3_1);
            Object v14_1 = v6.rememberedValue();
            if(v14_1 == Composer.Companion.getEmpty()) {
                v16 = v0;
                v14_2 = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(arg36, 0, null, 6, null), null, 2, null);
                v6.updateRememberedValue(v14_2);
            }
            else {
                v16 = v0;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            TextFieldValue v0_3 = TextFieldValue.copy-3r_uNRQ$default(BasicTextFieldKt.BasicTextField$lambda$18(v14_2), arg36, 0, null, 6, null);
            String v15_2 = arg36;
            v38 = v4_1;
            ComposerKt.sourceInformationMarkerStart(v6, -2015286354, v3_1);
            arg39 = v6.changed(v0_3);
            Object v4_2 = v6.rememberedValue();
            if(!arg39) {
                v39_1 = v8_1;
                if(v4_2 == Composer.Companion.getEmpty()) {
                    goto label_472;
                }
            }
            else {
                v39_1 = v8_1;
            label_472:
                BasicTextFieldKt$$ExternalSyntheticLambda4 v4_3 = new BasicTextFieldKt$$ExternalSyntheticLambda4(v0_3, v14_2);
                v6.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            EffectsKt.SideEffect(((Function0)v4_2), v6, 0);
            ComposerKt.sourceInformationMarkerStart(v6, -2015268539, v3_1);
            v4 = (v7 & 14) == 4 ? 1 : 0;
            Object v8_3 = v6.rememberedValue();
            if(v4 != 0 || v8_3 == Composer.Companion.getEmpty()) {
                MutableState v8_4 = SnapshotStateKt.mutableStateOf$default(v15_2, null, 2, null);
                v6.updateRememberedValue(v8_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            ImeOptions v17_1 = v1_3.toImeOptions$foundation(v5_1);
            v4 = (((int)v5_1)) ^ 1;
            v18 = v16;
            v16 = v5_1 ? 1 : v32;
            int v15_3 = v5_1 ? 1 : v31;
            TextFieldValue v40_1 = v0_3;
            ComposerKt.sourceInformationMarkerStart(v6, 0x87E18151, v3_1);
            boolean v41_1 = v6.changed(v8_3);
            if((v7 & 0x70) == 0x20) {
            }
            else {
                v24 = 0;
            }

            Object v3_2 = v6.rememberedValue();
            if(((((int)v41_1)) | v24) != 0 || v3_2 == Composer.Companion.getEmpty()) {
                v3_3 = new BasicTextFieldKt$$ExternalSyntheticLambda5(v2, v14_2, ((MutableState)v8_3));
                v6.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            int v8_5 = v18 << 9;
            v24 = v7 & 0x380 | v7 >> 6 & 0x1C00 | 0xE000 & v8_5 | 0x70000 & v8_5 | 0x380000 & v8_5 | v8_5 & 0x1C00000;
            v25 = v7 >> 15 & 0x380 | v7 & 0x1C00 | v7 & 0xE000 | v18 & 0x70000;
            KeyboardActions v18_1 = v38;
            v8_1 = v39_1;
            v23_1 = v6;
            CoreTextFieldKt.CoreTextField(v40_1, v3_3, v8_1, v9_1, v10_1, v11_1, v12_1, ((Brush)v13_2), v4, v15_3, v16, v17_1, v18_1, v19_1, v20_1, v21_1, null, v23_1, v24, v25, 0x10000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v1_3;
            v3_4 = v8_1;
            v6_1 = v9_1;
            v14_3 = v12_1;
            v15_4 = ((Brush)v13_2);
            v8 = v18_1;
            v4_4 = v19_1;
            v16_2 = v21_1;
            v9_2 = v5_1;
            v12_2 = v10_1;
            v13_3 = v11_1;
            v5_1 = v20_1;
            v10 = v31;
            v11_3 = v32;
        }
        else {
            v23_1 = v6;
            v23_1.skipToGroupEnd();
            v9_2 = arg44;
            v10 = arg45;
            v16_2 = arg51;
            v4_4 = v11;
            v7_1 = v12;
            v5_1 = v13;
            v6_1 = v14;
            v3_4 = v15;
            v11_3 = arg46;
            v12_2 = arg47;
            v13_3 = arg48;
            v14_3 = arg49;
            v15_4 = arg50;
        }

        ScopeUpdateScope v0_4 = v23_1.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda6(arg36, v2, v3_4, v4_4, v5_1, v6_1, v7_1, v8, v9_2, v10, v11_3, v12_2, v13_3, v14_3, v15_4, v16_2, arg53, arg54, arg55));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void BasicTextField(String arg36, Function1 arg37, Modifier arg38, boolean arg39, boolean arg40, TextStyle arg41, KeyboardOptions arg42, KeyboardActions arg43, boolean arg44, int arg45, VisualTransformation arg46, Function1 arg47, MutableInteractionSource arg48, Brush arg49, Function3 arg50, Composer arg51, int arg52, int arg53, int arg54) {
        Brush v14_2;
        MutableInteractionSource v13_2;
        Function3 v15_2;
        Object v12_2;
        VisualTransformation v11_2;
        int v10_2;
        boolean v9_1;
        KeyboardActions v8_2;
        KeyboardOptions v7_1;
        TextStyle v6_2;
        boolean v5_1;
        boolean v4_1;
        Companion v3_1;
        SolidColor v18_1;
        Composer v20_1;
        MutableInteractionSource v17_2;
        Function1 v16_2;
        Object v2_1;
        Modifier v6_1;
        int v32;
        int v22;
        int v31;
        KeyboardActions v14;
        int v27;
        KeyboardOptions v11;
        int v25;
        TextStyle v10;
        int v23;
        int v19;
        int v16;
        Modifier v15;
        int v12;
        int v8;
        String v5;
        int v0 = arg52;
        int v1 = arg53;
        int v2 = arg54;
        Composer v4 = arg51.startRestartGroup(0x46D9AFF);
        ComposerKt.sourceInformation(v4, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)945@49253L2,946@49307L39,951@49548L580:BasicTextField.kt#423gt5");
        if((v0 & 6) == 0) {
            v5 = arg36;
            v8 = v4.changed(v5) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v5 = arg36;
            v8 = v0;
        }

        if((v0 & 0x30) == 0) {
            v12 = v4.changedInstance(arg37) ? 0x20 : 16;
            v8 |= v12;
        }

        v12 = v2 & 4;
        if(v12 != 0) {
            v8 |= 0x180;
            goto label_45;
        }
        else if((v0 & 0x180) == 0) {
            v15 = arg38;
            v16 = v4.changed(v15) ? 0x100 : 0x80;
            v8 |= v16;
        }
        else {
        label_45:
            v15 = arg38;
        }

        v16 = v2 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v8 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v19 = v4.changed(arg39) ? v17 : v18;
            v8 |= v19;
        }

        v19 = v2 & 16;
        int v20 = 0x4000;
        int v21 = 0x2000;
        if(v19 != 0) {
            v8 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v23 = v4.changed(arg40) ? v20 : v21;
            v8 |= v23;
        }

        v23 = v2 & 0x20;
        int v24 = 0x30000;
        if(v23 != 0) {
            v8 |= v24;
            v10 = arg41;
        }
        else {
            v10 = arg41;
            if((v0 & v24) == 0) {
                v25 = v4.changed(v10) ? 0x20000 : 0x10000;
                v8 |= v25;
            }
        }

        v25 = v2 & 0x40;
        int v26 = 0x180000;
        if(v25 != 0) {
            v8 |= v26;
            v11 = arg42;
        }
        else {
            v11 = arg42;
            if((v0 & v26) == 0) {
                v27 = v4.changed(v11) ? 0x100000 : 0x80000;
                v8 |= v27;
            }
        }

        int v13 = v2 & 0x80;
        int v28 = 0xC00000;
        if(v13 != 0) {
            v8 |= v28;
            v14 = arg43;
        }
        else {
            v14 = arg43;
            if((v0 & v28) == 0) {
                int v29 = v4.changed(v14) ? 0x800000 : 0x400000;
                v8 |= v29;
            }
        }

        int v3 = v2 & 0x100;
        int v30 = 0x6000000;
        if(v3 != 0) {
            v8 |= v30;
        }
        else {
            v30 &= v0;
            boolean v0_1 = arg44;
            if(v30 == 0) {
                v30 = v4.changed(v0_1) ? 0x4000000 : 0x2000000;
                v8 |= v30;
            }
        }

        v0 = v2 & 0x200;
        v30 = 0x30000000;
        if(v0 != 0) {
            v8 |= v30;
            goto label_156;
        }
        else if((arg52 & v30) == 0) {
            v30 = v0;
            v31 = v4.changed(arg45) ? 0x20000000 : 0x10000000;
            v8 |= v31;
        }
        else {
        label_156:
            v30 = v0;
        }

        v0 = v2 & 0x400;
        if(v0 != 0) {
            v22 = v1 | 6;
            v31 = v0;
        }
        else if((v1 & 6) == 0) {
            v31 = v0;
            v22 = v4.changed(arg46) ? 4 : 2;
            v22 |= v1;
        }
        else {
            v31 = v0;
            v22 = v1;
        }

        v0 = v2 & 0x800;
        if(v0 != 0) {
            v22 |= 0x30;
            v32 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v32 = v0;
            v24 = v4.changedInstance(arg47) ? 0x20 : 16;
            v22 |= v24;
        }
        else {
            v32 = v0;
        }

        v0 = v22;
        v22 = v3;
        v3 = v2 & 0x1000;
        if(v3 != 0) {
            v0 |= 0x180;
        }
        else {
            v24 = v0;
            if((v1 & 0x180) == 0) {
                v27 = v4.changed(arg48) ? 0x100 : 0x80;
                v24 |= v27;
            }

            v0 = v24;
        }

        v24 = v3;
        v3 = v2 & 0x2000;
        if(v3 != 0) {
            v0 |= 0xC00;
        }
        else {
            v26 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg49)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v26 | v17;
            }
            else {
                v0 = v26;
            }
        }

        v17 = v3;
        v3 = v2 & 0x4000;
        if(v3 != 0) {
            v0 |= 0x6000;
        }
        else {
            v18 = v0;
            if((v1 & 0x6000) == 0) {
                if(v4.changedInstance(arg50)) {
                }
                else {
                    v20 = v21;
                }

                v18 |= v20;
            }

            v0 = v18;
        }

        boolean v1_1 = (v8 & 306783379) != 306783378 || (v0 & 9363) != 9362 ? true : false;
        if(v4.shouldExecute(v1_1, v8 & 1)) {
            if(v12 != 0) {
                Companion v6 = Modifier.Companion;
            }
            else {
                v6_1 = v15;
            }

            boolean v7 = v16 != 0 ? true : arg39;
            v1_1 = v19 != 0 ? false : arg40;
            TextStyle v9 = v23 != 0 ? TextStyle.Companion.getDefault() : v10;
            KeyboardOptions v10_1 = v25 != 0 ? KeyboardOptions.Companion.getDefault() : v11;
            KeyboardActions v11_1 = v13 != 0 ? KeyboardActions.Companion.getDefault() : v14;
            boolean v12_1 = v22 != 0 ? false : arg44;
            v13 = v30 != 0 ? 0x7FFFFFFF : arg45;
            VisualTransformation v15_1 = v31 != 0 ? VisualTransformation.Companion.getNone() : arg46;
            if(v32 != 0) {
                ComposerKt.sourceInformationMarkerStart(v4, 0x9F731A41, "CC(remember):BasicTextField.kt#9igjgp");
                v2_1 = v4.rememberedValue();
                if(v2_1 == Composer.Companion.getEmpty()) {
                    BasicTextFieldKt$$ExternalSyntheticLambda20 v2_2 = new BasicTextFieldKt$$ExternalSyntheticLambda20();
                    v4.updateRememberedValue(v2_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                Object v16_1 = v2_1;
            }
            else {
                v16_2 = arg47;
            }

            if(v24 != 0) {
                ComposerKt.sourceInformationMarkerStart(v4, 0x9F732126, "CC(remember):BasicTextField.kt#9igjgp");
                v2_1 = v4.rememberedValue();
                if(v2_1 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v2_3 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                int v35 = v17;
                Object v17_1 = v2_1;
                v2 = v35;
            }
            else {
                v2 = v17;
                v17_2 = arg48;
            }

            if(v2 != 0) {
                v20_1 = v4;
                v18_1 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
                v2 = v3;
            }
            else {
                v20_1 = v4;
                Brush v18_2 = arg49;
                v2 = v3;
            }

            Function3 v19_1 = v2 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$444370233$foundation() : arg50;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x46D9AFF, v8, v0, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:950)");
            }

            v21 = v8 & 0x7FFFFFFE;
            v0 <<= 3;
            boolean v8_1 = v1_1;
            BasicTextFieldKt.BasicTextField(v5, arg37, v6_1, v7, v8_1, v9, v10_1, v11_1, v12_1, v13, 1, v15_1, v16_2, v17_2, ((Brush)v18_1), v19_1, v20_1, v21, v0 & 0x70 | 6 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0 | v0 & 0x70000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = ((Companion)v6_1);
            v4_1 = v7;
            v5_1 = v8_1;
            v6_2 = v9;
            v7_1 = v10_1;
            v8_2 = v11_1;
            v9_1 = v12_1;
            v10_2 = v13;
            v11_2 = v15_1;
            v12_2 = v16_2;
            Object v13_1 = v17_2;
            SolidColor v14_1 = v18_1;
            v15_2 = v19_1;
        }
        else {
            v20_1 = v4;
            v20_1.skipToGroupEnd();
            v4_1 = arg39;
            v5_1 = arg40;
            v9_1 = arg44;
            Function1 v12_3 = arg47;
            v13_2 = arg48;
            v6_2 = v10;
            v7_1 = v11;
            v8_2 = v14;
            Modifier v3_2 = v15;
            v10_2 = arg45;
            v11_2 = arg46;
            v14_2 = arg49;
            v15_2 = arg50;
        }

        ScopeUpdateScope v0_2 = v20_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda21(arg36, arg37, ((Modifier)v3_1), v4_1, v5_1, v6_2, v7_1, v8_2, v9_1, v10_2, v11_2, ((Function1)v12_2), v13_2, v14_2, v15_2, arg52, arg53, arg54));
        }
    }

    static final Unit BasicTextField$lambda$0(TextFieldState arg20, Modifier arg21, boolean arg22, boolean arg23, InputTransformation arg24, TextStyle arg25, KeyboardOptions arg26, KeyboardActionHandler arg27, TextFieldLineLimits arg28, Function2 arg29, MutableInteractionSource arg30, Brush arg31, OutputTransformation arg32, TextFieldDecorator arg33, ScrollState arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        BasicTextFieldKt.BasicTextField(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    static final AnnotatedString BasicTextField$lambda$10(TextFieldSelectionState arg0) {
        return arg0.cutWithResult();
    }

    private static final Unit BasicTextField$lambda$11$0(TransformedTextFieldState arg0, InputTransformation arg1, TextFieldSelectionState arg2, HapticFeedback arg3, Clipboard arg4, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 arg5, Density arg6, boolean arg7, boolean arg8, boolean arg9) {
        arg0.update(arg1);
        arg2.update(arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult BasicTextField$lambda$12$0(TextFieldSelectionState arg0, DisposableEffectScope arg1) {
        return new BasicTextFieldKt$BasicTextField$lambda$12$0$$inlined$onDispose$1(arg0);
    }

    private static final Unit BasicTextField$lambda$13$0(boolean arg0, MutableSharedFlow arg1) {
        if(arg0) {
            arg1.tryEmit(Unit.INSTANCE);
        }

        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$14$0(TextFieldDecorator arg23, TextFieldLineLimits arg24, TextLayoutState arg25, TextStyle arg26, boolean arg27, boolean arg28, TransformedTextFieldState arg29, TextFieldSelectionState arg30, Brush arg31, boolean arg32, boolean arg33, ScrollState arg34, Orientation arg35, ToolbarRequesterImpl arg36, PlatformSelectionBehaviors arg37, boolean arg38, Function2 arg39, KeyboardOptions arg40, Composer arg41, int arg42) {
        Composer v0 = arg41;
        int v1 = arg42;
        ComposerKt.sourceInformation(v0, "C465@24817L2916,465@24806L2927:BasicTextField.kt#423gt5");
        boolean v2 = (v1 & 3) != 2 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD7DF2601, v1, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:464)");
            }

            TextFieldDecorator v1_1 = arg23 == null ? BasicTextFieldKt.DefaultTextFieldDecorator : arg23;
            v1_1.Decoration(ComposableLambdaKt.rememberComposableLambda(0x755F253E, true, new BasicTextFieldKt$$ExternalSyntheticLambda2(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40), v0, 54), v0, 6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_53;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0.skipToGroupEnd();
        }

    label_53:
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$14$0$0(TextFieldLineLimits arg16, TextLayoutState arg17, TextStyle arg18, boolean arg19, boolean arg20, TransformedTextFieldState arg21, TextFieldSelectionState arg22, Brush arg23, boolean arg24, boolean arg25, ScrollState arg26, Orientation arg27, ToolbarRequesterImpl arg28, PlatformSelectionBehaviors arg29, boolean arg30, Function2 arg31, KeyboardOptions arg32, Composer arg33, int arg34) {
        int v0_1;
        TextFieldLineLimits v0 = arg16;
        TextStyle v3 = arg18;
        Composer v1 = arg33;
        int v2 = arg34;
        ComposerKt.sourceInformation(v1, "C476@25178L2541:BasicTextField.kt#423gt5");
        int v7 = 2;
        boolean v4 = (v2 & 3) != v7 ? true : false;
        if(v1.shouldExecute(v4, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x755F253E, v2, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:466)");
            }

            if((v0 instanceof MultiLine)) {
                v2 = ((MultiLine)v0).getMinHeightInLines();
                v0_1 = ((MultiLine)v0).getMaxHeightInLines();
            }
            else {
                v0_1 = 1;
                v2 = 1;
            }

            Modifier v0_2 = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, arg17.getMinHeightForSingleLineField-D9Ej5fM(), 0f, v7, null), v3, v2, v0_1), v3));
            boolean v11 = !arg24 || (arg25) ? false : true;
            TextFieldSelectionState v9 = arg22;
            v0_2 = v0_2.then(new TextFieldCoreModifier(arg19, arg20, arg17, arg21, v9, arg23, v11, arg26, arg27, arg28, arg29));
            ComposerKt.sourceInformationMarkerStart(v1, 0x3E277F0A, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy v2_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v1, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v4_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v1, 0));
            CompositionLocalMap v5 = v1.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v1, v0_2);
            Function0 v6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v6);
            }
            else {
                v1.useNode();
            }

            Composer v6_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v6_1, v2_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_1, v5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v6_1, Integer.valueOf(v4_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v6_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v6_1, v0_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v1, 0xCFA390AA, "C503@26688L530:BasicTextField.kt#423gt5");
            Composer v8 = v1;
            BoxKt.Box(new TextFieldTextLayoutModifier(arg17, arg21, v3, arg30, arg31, arg32), v8, 0);
            v0_1 = 0xCE0F1A1E;
            if(!arg24 || !arg19 || !v9.isInTouchMode()) {
                v8.startReplaceGroup(v0_1);
            }
            else {
                v8.startReplaceGroup(-810654004);
                ComposerKt.sourceInformation(v8, "520@27453L67");
                BasicTextFieldKt.TextFieldSelectionHandles(v9, v8, 0);
                if(!arg25) {
                    v8.startReplaceGroup(0xCFB05767);
                    ComposerKt.sourceInformation(v8, "522@27590L63");
                    BasicTextFieldKt.TextFieldCursorHandle(v9, v8, 0);
                }
                else {
                    v8.startReplaceGroup(v0_1);
                }

                v8.endReplaceGroup();
            }

            v8.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_153;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_153:
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$15(TextFieldState arg22, Modifier arg23, boolean arg24, boolean arg25, InputTransformation arg26, TextStyle arg27, KeyboardOptions arg28, KeyboardActionHandler arg29, TextFieldLineLimits arg30, Function2 arg31, MutableInteractionSource arg32, Brush arg33, CodepointTransformation arg34, OutputTransformation arg35, TextFieldDecorator arg36, ScrollState arg37, boolean arg38, int arg39, int arg40, int arg41, Composer arg42, int arg43) {
        BasicTextFieldKt.BasicTextField(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg42, RecomposeScopeImplKt.updateChangedFlags(arg39 | 1), RecomposeScopeImplKt.updateChangedFlags(arg40), arg41);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$16$0(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    private static final TextFieldValue BasicTextField$lambda$18(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void BasicTextField$lambda$19(MutableState arg0, TextFieldValue arg1) {
        arg0.setValue(arg1);
    }

    private static final Unit BasicTextField$lambda$20$0(TextFieldValue arg4, MutableState arg5) {
        if(!TextRange.equals-impl0(arg4.getSelection-d9O1mEE(), BasicTextFieldKt.BasicTextField$lambda$18(arg5).getSelection-d9O1mEE()) || !Intrinsics.areEqual(arg4.getComposition-MzsxiRA(), BasicTextFieldKt.BasicTextField$lambda$18(arg5).getComposition-MzsxiRA())) {
            BasicTextFieldKt.BasicTextField$lambda$19(arg5, arg4);
        }

        return Unit.INSTANCE;
    }

    private static final String BasicTextField$lambda$22(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void BasicTextField$lambda$23(MutableState arg0, String arg1) {
        arg0.setValue(arg1);
    }

    private static final Unit BasicTextField$lambda$24$0(Function1 arg1, MutableState arg2, MutableState arg3, TextFieldValue arg4) {
        BasicTextFieldKt.BasicTextField$lambda$19(arg2, arg4);
        boolean v2 = Intrinsics.areEqual(BasicTextFieldKt.BasicTextField$lambda$22(arg3), arg4.getText());
        BasicTextFieldKt.BasicTextField$lambda$23(arg3, arg4.getText());
        if(!v2) {
            arg1.invoke(arg4.getText());
        }

        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$25(String arg21, Function1 arg22, Modifier arg23, boolean arg24, boolean arg25, TextStyle arg26, KeyboardOptions arg27, KeyboardActions arg28, boolean arg29, int arg30, int arg31, VisualTransformation arg32, Function1 arg33, MutableInteractionSource arg34, Brush arg35, Function3 arg36, int arg37, int arg38, int arg39, Composer arg40, int arg41) {
        BasicTextFieldKt.BasicTextField(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg40, RecomposeScopeImplKt.updateChangedFlags(arg37 | 1), RecomposeScopeImplKt.updateChangedFlags(arg38), arg39);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$26$0(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$27$0(TextFieldValue arg0, Function1 arg1, TextFieldValue arg2) {
        if(!Intrinsics.areEqual(arg0, arg2)) {
            arg1.invoke(arg2);
        }

        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$28(TextFieldValue arg21, Function1 arg22, Modifier arg23, boolean arg24, boolean arg25, TextStyle arg26, KeyboardOptions arg27, KeyboardActions arg28, boolean arg29, int arg30, int arg31, VisualTransformation arg32, Function1 arg33, MutableInteractionSource arg34, Brush arg35, Function3 arg36, int arg37, int arg38, int arg39, Composer arg40, int arg41) {
        BasicTextFieldKt.BasicTextField(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg40, RecomposeScopeImplKt.updateChangedFlags(arg37 | 1), RecomposeScopeImplKt.updateChangedFlags(arg38), arg39);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$29$0(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$31(String arg20, Function1 arg21, Modifier arg22, boolean arg23, boolean arg24, TextStyle arg25, KeyboardOptions arg26, KeyboardActions arg27, boolean arg28, int arg29, VisualTransformation arg30, Function1 arg31, MutableInteractionSource arg32, Brush arg33, Function3 arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        BasicTextFieldKt.BasicTextField(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    private static final Unit BasicTextField$lambda$32$0(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$34(TextFieldValue arg20, Function1 arg21, Modifier arg22, boolean arg23, boolean arg24, TextStyle arg25, KeyboardOptions arg26, KeyboardActions arg27, boolean arg28, int arg29, VisualTransformation arg30, Function1 arg31, MutableInteractionSource arg32, Brush arg33, Function3 arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        BasicTextFieldKt.BasicTextField(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    static final Unit BasicTextField$lambda$8(TextFieldSelectionState arg0, AnnotatedString arg1) {
        arg0.onPasteEvent$foundation(arg1);
        return Unit.INSTANCE;
    }

    static final AnnotatedString BasicTextField$lambda$9(TextFieldSelectionState arg3) {
        return TextFieldSelectionState.copyWithResult$foundation$default(arg3, false, 1, null);
    }

    public static final void TextFieldCursorHandle(TextFieldSelectionState arg8, Composer arg9, int arg10) {
        int v9;
        int v0 = 0x76B52065;
        Composer v5 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(TextFieldCursorHandle)N(selectionState)544@28301L128:BasicTextField.kt#423gt5");
        int v1 = 2;
        if((arg10 & 6) == 0) {
            v9 = v5.changedInstance(arg8) ? 4 : v1;
            v9 |= arg10;
        }
        else {
            v9 = arg10;
        }

        boolean v1_1 = (v9 & 3) != v1 ? true : false;
        if(v5.shouldExecute(v1_1, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:541)");
            }

            String v0_1 = "CC(remember):BasicTextField.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, -1645301467, v0_1);
            boolean v9_1 = v5.changed(arg8);
            Object v1_2 = v5.rememberedValue();
            if((v9_1) || v1_2 == Composer.Companion.getEmpty()) {
                State v1_3 = SnapshotStateKt.derivedStateOf(new BasicTextFieldKt$$ExternalSyntheticLambda16(arg8));
                v5.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            if(BasicTextFieldKt.TextFieldCursorHandle$lambda$1(v1_3).getVisible()) {
                v5.startReplaceGroup(0x1FEA0FCE);
                ComposerKt.sourceInformation(v5, "549@28518L100,553@28697L87,548@28475L383");
                ComposerKt.sourceInformationMarkerStart(v5, 0x9DEECC29, v0_1);
                v9_1 = v5.changedInstance(arg8);
                v1_2 = v5.rememberedValue();
                if((v9_1) || v1_2 == Composer.Companion.getEmpty()) {
                    BasicTextFieldKt$TextFieldCursorHandle$1$1 v1_4 = new BasicTextFieldKt$TextFieldCursorHandle$1$1(arg8);
                    v5.updateRememberedValue(v1_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v5);
                Companion v9_2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v5, 0x9DEEE27C, v0_1);
                boolean v0_2 = v5.changedInstance(arg8);
                Object v2 = v5.rememberedValue();
                if((v0_2) || v2 == Composer.Companion.getEmpty()) {
                    BasicTextFieldKt$TextFieldCursorHandle$2$1 v2_1 = new BasicTextFieldKt$TextFieldCursorHandle$2$1(arg8);
                    v5.updateRememberedValue(v2_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v5);
                AndroidCursorHandle_androidKt.CursorHandle-USBMPiE(((OffsetProvider)v1_2), SuspendingPointerInputFilterKt.pointerInput(((Modifier)v9_2), arg8, ((PointerInputEventHandler)v2)), BasicTextFieldKt.MinTouchTargetSizeForHandles, v5, 0x180, 0);
            }
            else {
                v5.startReplaceGroup(0x1E3AFDBD);
            }

            v5.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_90;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5.skipToGroupEnd();
        }

    label_90:
        ScopeUpdateScope v9_3 = v5.endRestartGroup();
        if(v9_3 != null) {
            v9_3.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda17(arg8, arg10));
        }
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$0$0(TextFieldSelectionState arg1) {
        return arg1.getCursorHandleState$foundation(false);
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$1(State arg0) {
        return arg0.getValue();
    }

    static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionState arg0, int arg1, Composer arg2, int arg3) {
        BasicTextFieldKt.TextFieldCursorHandle(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public static final void TextFieldSelectionHandles(TextFieldSelectionState arg13, Composer arg14, int arg15) {
        BasicTextFieldKt$TextFieldSelectionHandles$4$1 v5_2;
        BasicTextFieldKt$TextFieldSelectionHandles$3$1 v2_2;
        Companion v14_2;
        boolean v4;
        ResolvedTextDirection v3;
        BasicTextFieldKt$TextFieldSelectionHandles$1$1 v2_1;
        Object v2;
        State v1_3;
        int v14;
        int v0 = 0x78B77004;
        Composer v9 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(TextFieldSelectionHandles)N(selectionState)565@29064L240,594@30119L241:BasicTextField.kt#423gt5");
        int v1 = 2;
        if((arg15 & 6) == 0) {
            v14 = v9.changedInstance(arg13) ? 4 : v1;
            v14 |= arg15;
        }
        else {
            v14 = arg15;
        }

        boolean v1_1 = (v14 & 3) != v1 ? true : false;
        if(v9.shouldExecute(v1_1, v14 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v14, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:562)");
            }

            String v0_1 = "CC(remember):BasicTextField.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 681285076, v0_1);
            boolean v14_1 = v9.changed(arg13);
            Object v1_2 = v9.rememberedValue();
            if((v14_1) || v1_2 == Composer.Companion.getEmpty()) {
                v1_3 = SnapshotStateKt.derivedStateOf(new BasicTextFieldKt$$ExternalSyntheticLambda22(arg13));
                v9.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            int v12 = 0xE91F14BE;
            if(BasicTextFieldKt.TextFieldSelectionHandles$lambda$1(((State)v1_2)).getVisible()) {
                v9.startReplaceGroup(-354703320);
                ComposerKt.sourceInformation(v9, "575@29395L167,584@29789L94,574@29349L662");
                ComposerKt.sourceInformationMarkerStart(v9, 0x289BBEEB, v0_1);
                v14_1 = v9.changedInstance(arg13);
                v2 = v9.rememberedValue();
                if((v14_1) || v2 == Composer.Companion.getEmpty()) {
                    v2_1 = new BasicTextFieldKt$TextFieldSelectionHandles$1$1(arg13);
                    v9.updateRememberedValue(v2_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v9);
                v3 = BasicTextFieldKt.TextFieldSelectionHandles$lambda$1(((State)v1_2)).getDirection();
                v4 = BasicTextFieldKt.TextFieldSelectionHandles$lambda$1(((State)v1_2)).getHandlesCrossed();
                v14_2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v9, 681308130, v0_1);
                boolean v5 = v9.changedInstance(arg13);
                Object v6 = v9.rememberedValue();
                if((v5) || v6 == Composer.Companion.getEmpty()) {
                    BasicTextFieldKt$TextFieldSelectionHandles$2$1 v6_1 = new BasicTextFieldKt$TextFieldSelectionHandles$2$1(arg13);
                    v9.updateRememberedValue(v6_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v9);
                AndroidSelectionHandles_androidKt.SelectionHandle-wLIcFTc(v2_1, true, v3, v4, BasicTextFieldKt.MinTouchTargetSizeForHandles, BasicTextFieldKt.TextFieldSelectionHandles$lambda$1(((State)v1_2)).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(((Modifier)v14_2), arg13, ((PointerInputEventHandler)v6)), v9, 0x6030, 0);
            }
            else {
                v9.startReplaceGroup(v12);
            }

            v9.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(v9, 0x289C19B5, v0_1);
            v14_1 = v9.changed(arg13);
            v1_2 = v9.rememberedValue();
            if((v14_1) || v1_2 == Composer.Companion.getEmpty()) {
                v1_3 = SnapshotStateKt.derivedStateOf(new BasicTextFieldKt$$ExternalSyntheticLambda23(arg13));
                v9.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            if(BasicTextFieldKt.TextFieldSelectionHandles$lambda$5(((State)v1_2)).getVisible()) {
                v9.startReplaceGroup(0xEAEB9C0B);
                ComposerKt.sourceInformation(v9, "604@30449L168,613@30841L95,603@30403L659");
                ComposerKt.sourceInformationMarkerStart(v9, 0x289C42AC, v0_1);
                v14_1 = v9.changedInstance(arg13);
                v2 = v9.rememberedValue();
                if((v14_1) || v2 == Composer.Companion.getEmpty()) {
                    v2_2 = new BasicTextFieldKt$TextFieldSelectionHandles$3$1(arg13);
                    v9.updateRememberedValue(v2_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v9);
                v3 = BasicTextFieldKt.TextFieldSelectionHandles$lambda$5(((State)v1_2)).getDirection();
                v4 = BasicTextFieldKt.TextFieldSelectionHandles$lambda$5(((State)v1_2)).getHandlesCrossed();
                v14_2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v9, 0x289C7363, v0_1);
                boolean v0_2 = v9.changedInstance(arg13);
                Object v5_1 = v9.rememberedValue();
                if((v0_2) || v5_1 == Composer.Companion.getEmpty()) {
                    v5_2 = new BasicTextFieldKt$TextFieldSelectionHandles$4$1(arg13);
                    v9.updateRememberedValue(v5_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v9);
                AndroidSelectionHandles_androidKt.SelectionHandle-wLIcFTc(v2_2, false, v3, v4, BasicTextFieldKt.MinTouchTargetSizeForHandles, BasicTextFieldKt.TextFieldSelectionHandles$lambda$5(((State)v1_2)).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(((Modifier)v14_2), arg13, ((PointerInputEventHandler)v5_2)), v9, 0x6030, 0);
            }
            else {
                v9.startReplaceGroup(v12);
            }

            v9.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_161;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9.skipToGroupEnd();
        }

    label_161:
        ScopeUpdateScope v14_3 = v9.endRestartGroup();
        if(v14_3 != null) {
            v14_3.updateScope(new BasicTextFieldKt$$ExternalSyntheticLambda24(arg13, arg15));
        }
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$0$0(TextFieldSelectionState arg2) {
        return arg2.getSelectionHandleState$foundation(true, false);
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$1(State arg0) {
        return arg0.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$4$0(TextFieldSelectionState arg1) {
        return arg1.getSelectionHandleState$foundation(false, false);
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$5(State arg0) {
        return arg0.getValue();
    }

    static final Unit TextFieldSelectionHandles$lambda$8(TextFieldSelectionState arg0, int arg1, Composer arg2, int arg3) {
        BasicTextFieldKt.TextFieldSelectionHandles(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private static final Modifier addContextMenuComponents(Modifier arg1, TextFieldSelectionState arg2, CoroutineScope arg3) {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            arg1 = TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents(arg1, arg2, arg3);
        }

        return arg1;
    }
}

