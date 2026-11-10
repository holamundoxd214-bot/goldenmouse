package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent$Source;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.AutofillHighlightKt;
import androidx.compose.foundation.text.AutofillHighlight_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.autofill.FillableData_androidKt;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

@Metadata(d1={"\u0000\u008B\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001^\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000B2\u00020\fBs\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0016\u0012\u0006\u0010\u0018\u001A\u00020\u0019\u0012\b\u0010\u001A\u001A\u0004\u0018\u00010\u001B\u0012\u0006\u0010\u001C\u001A\u00020\u0016\u0012\u0006\u0010\u001D\u001A\u00020\u001E\u0012\u0006\u0010\u001F\u001A\u00020\u0016\u0012\u000E\u0010 \u001A\n\u0012\u0004\u0012\u00020\"\u0018\u00010!¢\u0006\u0004\b#\u0010$J\f\u0010m\u001A\u00020\"*\u00020nH\u0016J\u000E\u0010o\u001A\u00020\"H\u0082@¢\u0006\u0002\u0010pJr\u0010q\u001A\u00020\"2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u001C\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u00162\u000E\u0010 \u001A\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\f\u0010t\u001A\u00020\"*\u00020uH\u0016J\b\u0010v\u001A\u00020\"H\u0002J\b\u0010w\u001A\u00020\"H\u0002J\u0010\u0010x\u001A\u00020\"2\u0006\u0010y\u001A\u00020zH\u0016J\b\u0010{\u001A\u00020\"H\u0016J\b\u0010|\u001A\u00020\"H\u0016J\u0010\u0010}\u001A\u00020\"2\u0006\u0010~\u001A\u00020\u007FH\u0016J0\u0010\u0080\u0001\u001A\u00020\"2\b\u0010\u0081\u0001\u001A\u00030\u0082\u00012\b\u0010\u0083\u0001\u001A\u00030\u0084\u00012\b\u0010\u0085\u0001\u001A\u00030\u0086\u0001H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001A\u00020\"H\u0016J\u001C\u0010\u008A\u0001\u001A\u00020\u00162\b\u0010\u008B\u0001\u001A\u00030\u008C\u0001H\u0016¢\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J\u001C\u0010\u008F\u0001\u001A\u00020\u00162\b\u0010\u008B\u0001\u001A\u00030\u008C\u0001H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u008E\u0001J\t\u0010\u0091\u0001\u001A\u00020\"H\u0016J\t\u0010\u0092\u0001\u001A\u00020\"H\u0002J\u0011\u0010\u0093\u0001\u001A\u00020\"2\u0006\u0010~\u001A\u00020\u007FH\u0016J\u001C\u0010\u0094\u0001\u001A\u00020\"2\b\u0010\u0095\u0001\u001A\u00030\u0086\u0001H\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0012\u0010\u0098\u0001\u001A\u00020\"2\u0007\u0010\u0099\u0001\u001A\u00020\u0016H\u0002J\t\u0010\u009A\u0001\u001A\u00020\"H\u0002J\n\u0010\u009B\u0001\u001A\u00030\u009C\u0001H\u0002J\t\u0010\u009D\u0001\u001A\u00020\"H\u0002J\u001C\u0010\u009E\u0001\u001A\u00020\u00162\b\u0010\u009F\u0001\u001A\u00030 \u0001H\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u001C\u0010£\u0001\u001A\u00020\u00162\b\u0010\u009F\u0001\u001A\u00030 \u0001H\u0002¢\u0006\u0006\b¤\u0001\u0010¢\u0001R\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u001A\u0010\u0015\u001A\u00020\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u001A\u0010\u0017\u001A\u00020\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u00106\"\u0004\b:\u00108R\u001A\u0010\u0018\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001C\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001A\u0010\u001C\u001A\u00020\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bC\u00106\"\u0004\bD\u00108R\u001A\u0010\u001D\u001A\u00020\u001EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001A\u0010\u001F\u001A\u00020\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u00106\"\u0004\bI\u00108R\"\u0010 \u001A\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u000E\u0010N\u001A\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010P\u001A\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001A\u0004\u0018\u00010SX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010T\u001A\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001A\u0004\u0018\u00010WX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010X\u001A\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bX\u00106R\u0010\u0010Y\u001A\u0004\u0018\u00010ZX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010[\u001A\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001A\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001A\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u0010\u0010c\u001A\u0004\u0018\u00010ZX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010d\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010f0eX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010h\u001A\u00020\u00162\u0006\u0010g\u001A\u00020\u00168B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bk\u0010l\u001A\u0004\bi\u00106\"\u0004\bj\u00108R\u0014\u0010r\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bs\u00106¨\u0006¥\u0001"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPassword", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlinx/coroutines/flow/MutableSharedFlow;)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getReadOnly", "setReadOnly", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "setKeyboardOptions", "(Landroidx/compose/foundation/text/KeyboardOptions;)V", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "getSingleLine", "setSingleLine", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "setPassword", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "setStylusHandwritingTrigger", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "dragEnterEvent", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "isFocused", "toolbarAndHandlesVisibilityObserverJob", "Lkotlinx/coroutines/Job;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "keyboardActionScope", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "Lkotlin/jvm/functions/Function1;", "inputSessionJob", "receiveContentConfigurationProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "<set-?>", "autofillHighlightOn", "getAutofillHighlightOn", "setAutofillHighlightOn", "autofillHighlightOn$delegate", "Landroidx/compose/runtime/MutableState;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "observeUntransformedTextChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNode", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "requestFocus", "onIsFocusedUpdated", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onPreKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onKeyEvent-ZmokQxo", "onObservedReadsChanged", "updateWindowFocus", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "startInputSession", "fromTap", "disposeInputSession", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "emitDragExitEvent", "onImeActionPerformed", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldDecoratorModifierNode extends DelegatingNode implements FocusPropertiesModifierNode, KeyInputModifierNode, ModifierLocalModifierNode, CompositionLocalConsumerModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, ObserverModifierNode, PointerInputModifierNode, SemanticsModifierNode, PlatformTextInputModifierNode {
    public static final int $stable = 8;
    private final MutableState autofillHighlightOn$delegate;
    private final Function1 clipboardKeyCommandsHandler;
    private final DragAndDropTargetModifierNode dragAndDropNode;
    private Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    private final FocusableNode focusableNode;
    private Job inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isPassword;
    private KeyboardActionHandler keyboardActionHandler;
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean readOnly;
    private final Function0 receiveContentConfigurationProvider;
    private boolean singleLine;
    private MutableSharedFlow stylusHandwritingTrigger;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private Job toolbarAndHandlesVisibilityObserverJob;
    private WindowInfo windowInfo;

    static {
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState arg1, TextLayoutState arg2, TextFieldSelectionState arg3, InputTransformation arg4, boolean arg5, boolean arg6, KeyboardOptions arg7, KeyboardActionHandler arg8, boolean arg9, MutableInteractionSource arg10, boolean arg11, MutableSharedFlow arg12) {
        super();
        this.textFieldState = arg1;
        this.textLayoutState = arg2;
        this.textFieldSelectionState = arg3;
        this.filter = arg4;
        this.enabled = arg5;
        this.readOnly = arg6;
        this.keyboardOptions = arg7;
        this.keyboardActionHandler = arg8;
        this.singleLine = arg9;
        this.interactionSource = arg10;
        this.isPassword = arg11;
        this.stylusHandwritingTrigger = arg12;
        arg3.setRequestAutofillAction(new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda5(this));
        this.focusableNode = new FocusableNode(this.interactionSource, 0, new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda7(this), 2, null);
        this.pointerInputNode = this.delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TextFieldDecoratorModifierNode$pointerInputNode$1(this)));
        this.dragAndDropNode = this.delegate(TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$default(new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda8(this), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda9(this), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda10(this), null, new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda12(this), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda13(this), null, new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda14(this), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda15(this), 72, null));
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.clipboardKeyCommandsHandler = ClipboardKeyCommandsHandler.constructor-impl(new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda16(this));
        this.receiveContentConfigurationProvider = new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda6(this);
        this.autofillHighlightOn$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    static final Unit _init_$lambda$0(TextFieldDecoratorModifierNode arg0) {
        DelegatableNodeKt.requestAutofill(((DelegatableNode)arg0));
        return Unit.INSTANCE;
    }

    public static final boolean access$defaultKeyboardActionWithResult-KlQnJC8(TextFieldDecoratorModifierNode arg0, int arg1) {
        return arg0.defaultKeyboardActionWithResult-KlQnJC8(arg1);
    }

    public static final Job access$getInputSessionJob$p(TextFieldDecoratorModifierNode arg0) {
        return arg0.inputSessionJob;
    }

    public static final Object access$observeUntransformedTextChanges(TextFieldDecoratorModifierNode arg0, Continuation arg1) {
        return arg0.observeUntransformedTextChanges(arg1);
    }

    public static final boolean access$onImeActionPerformed-KlQnJC8(TextFieldDecoratorModifierNode arg0, int arg1) {
        return arg0.onImeActionPerformed-KlQnJC8(arg1);
    }

    public static final void access$requestFocus(TextFieldDecoratorModifierNode arg0) {
        arg0.requestFocus();
    }

    public static final SoftwareKeyboardController access$requireKeyboardController(TextFieldDecoratorModifierNode arg0) {
        return arg0.requireKeyboardController();
    }

    public static final void access$setAutofillHighlightOn(TextFieldDecoratorModifierNode arg0, boolean arg1) {
        arg0.setAutofillHighlightOn(arg1);
    }

    public static final void access$startInputSession(TextFieldDecoratorModifierNode arg0, boolean arg1) {
        arg0.startInputSession(arg1);
    }

    public void applyFocusProperties(FocusProperties arg1) {
        arg1.setFocusRect(this.textFieldSelectionState.getFocusRect());
    }

    public void applySemantics(SemanticsPropertyReceiver arg13) {
        TextFieldCharSequence v0 = this.textFieldState.getOutputText();
        long v1 = v0.getSelection-d9O1mEE();
        List v5 = null;
        SemanticsPropertiesKt.setInputText(arg13, new AnnotatedString(this.textFieldState.getUntransformedText().toString(), v5, 2, ((DefaultConstructorMarker)v5)));
        SemanticsPropertiesKt.setEditableText(arg13, new AnnotatedString(v0.toString(), v5, 2, ((DefaultConstructorMarker)v5)));
        SemanticsPropertiesKt.setTextSelectionRange-FDrldGo(arg13, v1);
        if(!this.enabled) {
            SemanticsPropertiesKt.disabled(arg13);
        }

        if(this.isPassword) {
            SemanticsPropertiesKt.password(arg13);
        }

        boolean v3 = !this.enabled || (this.readOnly) ? false : true;
        SemanticsPropertiesKt.setEditable(arg13, v3);
        SemanticsPropertiesKt.setContentDataType(arg13, ContentDataType.Companion.getText());
        FillableData v0_1 = FillableData_androidKt.createFromText(FillableData.Companion, ((CharSequence)v0));
        if(v0_1 != null) {
            SemanticsPropertiesKt.setFillableData(arg13, v0_1);
        }

        SemanticsPropertiesKt.onFillData$default(arg13, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda11(v3, this), 1, v5);
        int v0_2 = this.keyboardOptions.getKeyboardType-PjHm6EE();
        if(KeyboardType.equals-impl0(v0_2, KeyboardType.Companion.getEmail-PjHm6EE())) {
            SemanticsPropertiesKt.setContentType(arg13, ContentType.Companion.getEmailAddress());
        }
        else if(KeyboardType.equals-impl0(v0_2, KeyboardType.Companion.getPassword-PjHm6EE())) {
            SemanticsPropertiesKt.setContentType(arg13, ContentType.Companion.getPassword());
        }
        else if(KeyboardType.equals-impl0(v0_2, KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
            SemanticsPropertiesKt.setContentType(arg13, ContentType.Companion.getPassword());
        }
        else if(KeyboardType.equals-impl0(v0_2, KeyboardType.Companion.getPhone-PjHm6EE())) {
            SemanticsPropertiesKt.setContentType(arg13, ContentType.Companion.getPhoneNumber());
        }

        SemanticsPropertiesKt.getTextLayoutResult$default(arg13, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda20(this), 1, v5);
        if(v3) {
            SemanticsPropertiesKt.setText$default(arg13, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda21(v3, this), 1, v5);
            SemanticsPropertiesKt.insertTextAtCursor$default(arg13, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda22(v3, this), 1, v5);
        }

        SemanticsPropertiesKt.setSelection$default(arg13, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda23(this), 1, v5);
        int v7 = this.keyboardOptions.getImeActionOrDefault-eUduSuo$foundation();
        SemanticsPropertyReceiver v6 = arg13;
        SemanticsPropertiesKt.onImeAction-9UiTYpY$default(v6, v7, null, new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda24(this, v7), 2, null);
        SemanticsPropertiesKt.onClick$default(v6, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda25(this), 1, v5);
        SemanticsPropertiesKt.onLongClick$default(v6, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda26(this), 1, v5);
        if(!TextRange.getCollapsed-impl(v1) && !this.isPassword) {
            SemanticsPropertiesKt.copyText$default(v6, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda1(this), 1, v5);
            if((this.enabled) && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(v6, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda2(this), 1, v5);
            }
        }

        if(v3) {
            SemanticsPropertiesKt.pasteText$default(v6, ((String)v5), new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda19(this), 1, v5);
        }

        InputTransformation v13 = this.filter;
        if(v13 != null) {
            v13.applySemantics(v6);
        }

        if(this.enabled) {
            this.focusableNode.applySemantics(v6);
        }
    }

    static final boolean applySemantics$lambda$1(boolean arg6, TextFieldDecoratorModifierNode arg7, FillableData arg8) {
        if(!arg6) {
            return 0;
        }

        CharSequence v6 = arg8.getTextValue();
        if(v6 != null) {
            arg7.textFieldState.replaceAll(v6);
        }

        arg7.setAutofillHighlightOn(true);
        BuildersKt.launch$default(arg7.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$2$2(arg7, null), 3, null);
        return 1;
    }

    static final boolean applySemantics$lambda$10(TextFieldDecoratorModifierNode arg6) {
        BuildersKt.launch$default(arg6.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$11$1(arg6, null), 3, null);
        return 1;
    }

    static final boolean applySemantics$lambda$11(TextFieldDecoratorModifierNode arg6) {
        BuildersKt.launch$default(arg6.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$12$1(arg6, null), 3, null);
        return 1;
    }

    static final boolean applySemantics$lambda$2(TextFieldDecoratorModifierNode arg0, List arg1) {
        TextLayoutResult v0 = arg0.textLayoutState.getLayoutResult();
        if(v0 != null) {
            return arg1.add(v0);
        }

        return 0;
    }

    static final boolean applySemantics$lambda$3(boolean arg0, TextFieldDecoratorModifierNode arg1, AnnotatedString arg2) {
        if(!arg0) {
            return 0;
        }

        arg1.textFieldState.replaceAll(((CharSequence)arg2));
        return 1;
    }

    static final boolean applySemantics$lambda$4(boolean arg7, TextFieldDecoratorModifierNode arg8, AnnotatedString arg9) {
        if(!arg7) {
            return 0;
        }

        TransformedTextFieldState.replaceSelectedText$default(arg8.textFieldState, arg9, true, null, false, 12, null);
        return 1;
    }

    static final boolean applySemantics$lambda$5(TextFieldDecoratorModifierNode arg4, int arg5, int arg6, boolean arg7) {
        TextFieldCharSequence v0 = arg7 ? arg4.textFieldState.getUntransformedText() : arg4.textFieldState.getVisualText();
        long v1 = v0.getSelection-d9O1mEE();
        if((arg4.enabled) && Math.min(arg5, arg6) >= 0) {
            if(Math.max(arg5, arg6) > v0.length()) {
            }
            else {
                if(arg5 == TextRange.getStart-impl(v1) && arg6 == TextRange.getEnd-impl(v1)) {
                    return 1;
                }

                long v0_1 = TextRangeKt.TextRange(arg5, arg6);
                if((arg7) || arg5 == arg6) {
                    arg4.textFieldSelectionState.updateTextToolbarState(TextToolbarState.None);
                }
                else {
                    arg4.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
                }

                if(arg7) {
                    arg4.textFieldState.selectUntransformedCharsIn-5zc-tL8(v0_1);
                }
                else {
                    arg4.textFieldState.selectCharsIn-5zc-tL8(v0_1);
                }

                return 1;
            }
        }

        return 0;
    }

    static final boolean applySemantics$lambda$6(TextFieldDecoratorModifierNode arg0, int arg1) {
        arg0.onImeActionPerformed-KlQnJC8(arg1);
        return 1;
    }

    static final boolean applySemantics$lambda$7(TextFieldDecoratorModifierNode arg1) {
        if(!arg1.isFocused()) {
            arg1.requestFocus();
        }
        else if(!arg1.readOnly) {
            arg1.requireKeyboardController().show();
        }

        return 1;
    }

    static final boolean applySemantics$lambda$8(TextFieldDecoratorModifierNode arg1) {
        if(!arg1.isFocused()) {
            arg1.requestFocus();
        }

        arg1.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
        return 1;
    }

    static final boolean applySemantics$lambda$9(TextFieldDecoratorModifierNode arg6) {
        BuildersKt.launch$default(arg6.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$applySemantics$10$1(arg6, null), 3, null);
        return 1;
    }

    static final Unit clipboardKeyCommandsHandler$lambda$0(TextFieldDecoratorModifierNode arg6, KeyCommand arg7) {
        BuildersKt.launch$default(arg6.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(arg7, arg6, null), 1, null);
        return Unit.INSTANCE;
    }

    private final boolean defaultKeyboardActionWithResult-KlQnJC8(int arg3) {
        if(ImeAction.equals-impl0(arg3, ImeAction.Companion.getNext-eUduSuo())) {
            CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), CompositionLocalsKt.getLocalFocusManager()).moveFocus-3ESFkO8(FocusDirection.Companion.getNext-dhqQ-8s());
            return 1;
        }

        if(ImeAction.equals-impl0(arg3, ImeAction.Companion.getPrevious-eUduSuo())) {
            CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), CompositionLocalsKt.getLocalFocusManager()).moveFocus-3ESFkO8(FocusDirection.Companion.getPrevious-dhqQ-8s());
            return 1;
        }

        if(ImeAction.equals-impl0(arg3, ImeAction.Companion.getDone-eUduSuo())) {
            this.requireKeyboardController().hide();
            return 1;
        }

        return 0;
    }

    private final void disposeInputSession() {
        Job v0 = this.inputSessionJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.inputSessionJob = ((Job)v1);
        MutableSharedFlow v3 = this.stylusHandwritingTrigger;
        if(v3 != null) {
            v3.resetReplayCache();
        }
    }

    static final Set dragAndDropNode$lambda$0(TextFieldDecoratorModifierNode arg0) {
        if(ReceiveContentConfigurationKt.getReceiveContentConfiguration(((ModifierLocalModifierNode)arg0)) != null) {
            return TextFieldDecoratorModifierKt.MediaTypesAll;
        }

        return TextFieldDecoratorModifierKt.MediaTypesText;
    }

    static final boolean dragAndDropNode$lambda$1(TextFieldDecoratorModifierNode arg9, ClipEntry arg10, ClipMetadata arg11) {
        String v10_1;
        arg9.emitDragExitEvent();
        arg9.textFieldSelectionState.clearHandleDragging();
        String v0 = TransferableContent_androidKt.readPlainText(arg10);
        ReceiveContentConfiguration v1 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(arg9);
        if(v1 != null) {
            TransferableContent v10 = v1.getReceiveContentListener().onReceive(new TransferableContent(arg10, arg11, Source.Companion.getDragAndDrop-kB6V9T0(), null, 8, null));
            if(v10 != null) {
                arg10 = v10.getClipEntry();
                if(arg10 != null) {
                    v10_1 = TransferableContent_androidKt.readPlainText(arg10);
                }
                else {
                    goto label_23;
                }
            }
            else {
            label_23:
                v10_1 = null;
            }

            v0 = v10_1;
        }

        if(v0 != null) {
            TransformedTextFieldState.replaceSelectedText$default(arg9.textFieldState, v0, false, null, false, 14, null);
        }

        return 1;
    }

    static final Unit dragAndDropNode$lambda$2(TextFieldDecoratorModifierNode arg1, DragAndDropEvent arg2) {
        if(ReceiveContentConfigurationKt.getReceiveContentConfiguration(arg1) != null) {
            DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(((DelegatableNode)arg1), arg2);
        }

        return Unit.INSTANCE;
    }

    static final Unit dragAndDropNode$lambda$3(TextFieldDecoratorModifierNode arg2, DragAndDropEvent arg3) {
        Enter v3 = new Enter();
        arg2.interactionSource.tryEmit(v3);
        arg2.dragEnterEvent = v3;
        ReceiveContentConfiguration v2 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(((ModifierLocalModifierNode)arg2));
        if(v2 != null) {
            ReceiveContentListener v2_1 = v2.getReceiveContentListener();
            if(v2_1 != null) {
                v2_1.onDragEnter();
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit dragAndDropNode$lambda$4(TextFieldDecoratorModifierNode arg9, Offset arg10) {
        long v4 = TextLayoutStateKt.fromWindowToDecoration-Uv8p0NA(arg9.textLayoutState, arg10.unbox-impl());
        int v10 = TextLayoutState.getOffsetForPosition-3MmeM6k$default(arg9.textLayoutState, v4, false, 2, null);
        if(v10 >= 0) {
            arg9.textFieldState.selectCharsIn-5zc-tL8(TextRangeKt.TextRange(v10));
        }

        arg9.textFieldSelectionState.updateHandleDragging-Uv8p0NA(Handle.Cursor, v4);
        return Unit.INSTANCE;
    }

    static final Unit dragAndDropNode$lambda$5(TextFieldDecoratorModifierNode arg0, DragAndDropEvent arg1) {
        arg0.emitDragExitEvent();
        arg0.textFieldSelectionState.clearHandleDragging();
        ReceiveContentConfiguration v0 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(((ModifierLocalModifierNode)arg0));
        if(v0 != null) {
            ReceiveContentListener v0_1 = v0.getReceiveContentListener();
            if(v0_1 != null) {
                v0_1.onDragExit();
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit dragAndDropNode$lambda$6(TextFieldDecoratorModifierNode arg0, DragAndDropEvent arg1) {
        arg0.emitDragExitEvent();
        return Unit.INSTANCE;
    }

    public void draw(ContentDrawScope arg14) {
        arg14.drawContent();
        if(this.getAutofillHighlightOn()) {
            DrawScope.drawRect-AsUm42w$default(arg14, AutofillHighlightKt.resolveAutofillHighlight-WkMS-hQ(CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), AutofillHighlightKt.getLocalAutofillHighlightBrush()), CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), AutofillHighlightKt.getLocalAutofillHighlightColor()).unbox-impl(), AutofillHighlight_androidKt.autofillHighlightColor()), 0, 0, 0f, null, null, 0, 0x7E, null);
        }
    }

    private final void emitDragExitEvent() {
        Enter v0 = this.dragEnterEvent;
        if(v0 != null) {
            this.interactionSource.tryEmit(new Exit(v0));
            this.dragEnterEvent = null;
        }
    }

    static final Unit focusableNode$lambda$0(TextFieldDecoratorModifierNode arg5, boolean arg6) {
        int v0 = !arg5.enabled || (arg5.readOnly) ? 0 : 1;
        if(!arg6) {
            arg5.disposeInputSession();
            TransformedTextFieldState v6 = arg5.textFieldState;
            TextFieldState v0_1 = TransformedTextFieldState.access$getTextFieldState$p(v6);
            InputTransformation v2 = TransformedTextFieldState.access$getInputTransformation$p(v6);
            TextFieldEditUndoBehavior v3 = TextFieldEditUndoBehavior.MergeIfPossible;
            v0_1.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
            TextFieldBuffer v4 = v0_1.getMainBuffer$foundation();
            v4.commitComposition$foundation();
            TransformedTextFieldState.access$updateWedgeAffinity(v6, v4);
            v0_1.commitEditAsUser(v2, true, v3);
            arg5.textFieldState.collapseSelectionToMax();
        }
        else if(v0 != 0) {
            arg5.startInputSession(false);
        }

        arg5.updateWindowFocus();
        return Unit.INSTANCE;
    }

    private final boolean getAutofillHighlightOn() {
        return this.autofillHighlightOn$delegate.getValue().booleanValue();
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final MutableSharedFlow getStylusHandwritingTrigger() {
        return this.stylusHandwritingTrigger;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    private final boolean isFocused() {
        if(this.focusableNode.getFocusState().isFocused()) {
            WindowInfo v1 = this.windowInfo;
            if(v1 != null && (v1.isWindowFocused())) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean isPassword() {
        return this.isPassword;
    }

    private final Object observeUntransformedTextChanges(Continuation arg3) {
        Object v2 = FlowKt.take(FlowKt.drop(SnapshotStateKt.snapshotFlow(new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda0(this)), 1), 1).collect(new TextFieldDecoratorModifierNode$observeUntransformedTextChanges$3(this), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final String observeUntransformedTextChanges$lambda$0(TextFieldDecoratorModifierNode arg0) {
        return arg0.textFieldState.getUntransformedText().toString();
    }

    public void onAttach() {
        this.onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
        if(this.enabled) {
            this.delegate(this.focusableNode);
        }
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    public void onDetach() {
        this.disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration(null);
    }

    public void onGloballyPositioned(LayoutCoordinates arg2) {
        this.textLayoutState.setDecoratorNodeCoordinates(arg2);
        if(this.enabled) {
            this.focusableNode.onGloballyPositioned(arg2);
        }
    }

    private final boolean onImeActionPerformed-KlQnJC8(int arg3) {
        if(!ImeAction.equals-impl0(arg3, ImeAction.Companion.getNone-eUduSuo()) && !ImeAction.equals-impl0(arg3, ImeAction.Companion.getDefault-eUduSuo())) {
            KeyboardActionHandler v0 = this.keyboardActionHandler;
            if(v0 == null) {
            }
            else {
                if(v0 != null) {
                    v0.onKeyboardAction(new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda18(this, arg3));
                }

                return 1;
            }
        }

        return this.defaultKeyboardActionWithResult-KlQnJC8(arg3);
    }

    static final Unit onImeActionPerformed_KlQnJC8$lambda$0(TextFieldDecoratorModifierNode arg0, int arg1) {
        arg0.keyboardActionScope.defaultKeyboardAction-KlQnJC8(arg1);
        return Unit.INSTANCE;
    }

    private final void onIsFocusedUpdated() {
        this.textFieldSelectionState.setFocused(this.isFocused());
        Continuation v1 = null;
        if((this.isFocused()) && this.toolbarAndHandlesVisibilityObserverJob == null) {
            this.toolbarAndHandlesVisibilityObserverJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$onIsFocusedUpdated$1(this, v1), 3, null);
            return;
        }

        if(!this.isFocused()) {
            Job v0 = this.toolbarAndHandlesVisibilityObserverJob;
            if(v0 != null) {
                DefaultImpls.cancel$default(v0, ((CancellationException)v1), 1, v1);
            }

            this.toolbarAndHandlesVisibilityObserverJob = ((Job)v1);
        }
    }

    public boolean onKeyEvent-ZmokQxo(KeyEvent arg11) {
        TextFieldKeyEventHandler v0 = this.textFieldKeyEventHandler;
        TransformedTextFieldState v2 = this.textFieldState;
        TextLayoutState v3 = this.textLayoutState;
        TextFieldSelectionState v4 = this.textFieldSelectionState;
        Function1 v5 = this.clipboardKeyCommandsHandler;
        SoftwareKeyboardController v6 = this.requireKeyboardController();
        boolean v1 = !this.enabled || (this.readOnly) ? false : true;
        return v0.onKeyEvent-8zsqlwg(arg11, v2, v3, v4, v5, v6, v1, this.singleLine, new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda17(this));
    }

    static final boolean onKeyEvent_ZmokQxo$lambda$0(TextFieldDecoratorModifierNode arg1) {
        return arg1.onImeActionPerformed-KlQnJC8(arg1.keyboardOptions.getImeActionOrDefault-eUduSuo$foundation());
    }

    public void onObservedReadsChanged() {
        this.updateWindowFocus();
    }

    public void onPlaced(LayoutCoordinates arg1) {
        this.dragAndDropNode.onPlaced(arg1);
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg1, PointerEventPass arg2, long arg3) {
        this.pointerInputNode.onPointerEvent-H0pRuoY(arg1, arg2, arg3);
    }

    public boolean onPreKeyEvent-ZmokQxo(KeyEvent arg7) {
        return this.textFieldKeyEventHandler.onPreKeyEvent-MyFupTE(arg7, this.textFieldState, this.textFieldSelectionState, CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), this.requireKeyboardController());
    }

    public void onRemeasured-ozmzZPI(long arg1) {
        this.dragAndDropNode.onRemeasured-ozmzZPI(arg1);
    }

    static final ReceiveContentConfiguration receiveContentConfigurationProvider$lambda$0(TextFieldDecoratorModifierNode arg0) {
        return ReceiveContentConfigurationKt.getReceiveContentConfiguration(((ModifierLocalModifierNode)arg0));
    }

    private final void requestFocus() {
        if(this.focusableNode.isAttached()) {
            this.focusableNode.requestFocus();
        }
    }

    private final SoftwareKeyboardController requireKeyboardController() {
        Object v1 = CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if(v1 != null) {
            return ((SoftwareKeyboardController)v1);
        }

        throw new IllegalStateException("No software keyboard controller".toString());
    }

    private final void setAutofillHighlightOn(boolean arg1) {
        this.autofillHighlightOn$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setEnabled(boolean arg1) {
        this.enabled = arg1;
    }

    public final void setFilter(InputTransformation arg1) {
        this.filter = arg1;
    }

    public final void setInteractionSource(MutableInteractionSource arg1) {
        this.interactionSource = arg1;
    }

    public final void setKeyboardActionHandler(KeyboardActionHandler arg1) {
        this.keyboardActionHandler = arg1;
    }

    public final void setKeyboardOptions(KeyboardOptions arg1) {
        this.keyboardOptions = arg1;
    }

    public final void setPassword(boolean arg1) {
        this.isPassword = arg1;
    }

    public final void setReadOnly(boolean arg1) {
        this.readOnly = arg1;
    }

    public final void setSingleLine(boolean arg1) {
        this.singleLine = arg1;
    }

    public final void setStylusHandwritingTrigger(MutableSharedFlow arg1) {
        this.stylusHandwritingTrigger = arg1;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState arg1) {
        this.textFieldSelectionState = arg1;
    }

    public final void setTextFieldState(TransformedTextFieldState arg1) {
        this.textFieldState = arg1;
    }

    public final void setTextLayoutState(TextLayoutState arg1) {
        this.textLayoutState = arg1;
    }

    private final void startInputSession(boolean arg7) {
        if(!arg7 && !this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation()) {
            return;
        }

        this.inputSessionJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$startInputSession$1(this, ReceiveContentConfigurationKt.getReceiveContentConfiguration(this), null), 3, null);
    }

    public final void updateNode(TransformedTextFieldState arg20, TextLayoutState arg21, TextFieldSelectionState arg22, InputTransformation arg23, boolean arg24, boolean arg25, KeyboardOptions arg26, KeyboardActionHandler arg27, boolean arg28, MutableInteractionSource arg29, boolean arg30, MutableSharedFlow arg31) {
        int v15_1;
        TextFieldSelectionState v17;
        TextFieldDecoratorModifierNode v0 = this;
        TransformedTextFieldState v1 = arg20;
        TextFieldSelectionState v2 = arg22;
        boolean v3 = arg24;
        boolean v4 = arg25;
        KeyboardOptions v5 = arg26;
        MutableInteractionSource v6 = arg29;
        boolean v7 = arg30;
        MutableSharedFlow v8 = arg31;
        boolean v9 = v0.enabled;
        int v12 = !v9 || (v0.readOnly) ? 0 : 1;
        TransformedTextFieldState v13 = v0.textFieldState;
        KeyboardOptions v14 = v0.keyboardOptions;
        TextFieldSelectionState v15 = v0.textFieldSelectionState;
        MutableInteractionSource v10 = v0.interactionSource;
        boolean v11 = v0.isPassword;
        MutableInteractionSource v16 = v10;
        MutableSharedFlow v10_1 = v0.stylusHandwritingTrigger;
        if(!v3 || (v4)) {
            v17 = v15;
            v15_1 = 0;
        }
        else {
            v17 = v15;
            v15_1 = 1;
        }

        v0.textFieldState = v1;
        boolean v18 = v11;
        v0.textLayoutState = arg21;
        v0.textFieldSelectionState = v2;
        v0.filter = arg23;
        v0.enabled = v3;
        v0.readOnly = v4;
        v0.keyboardOptions = v5;
        v0.keyboardActionHandler = arg27;
        v0.singleLine = arg28;
        v0.interactionSource = v6;
        v0.isPassword = v7;
        v0.stylusHandwritingTrigger = v8;
        if(v15_1 != v12 || !Intrinsics.areEqual(v1, v13) || !Intrinsics.areEqual(v5, v14) || !Intrinsics.areEqual(v8, v10_1)) {
            if(v15_1 != 0 && ((v0.isFocused()) || v0.inputSessionJob != null)) {
                v0.startInputSession(false);
                goto label_64;
            }

            if(v15_1 != 0) {
                goto label_64;
            }

            v0.disposeInputSession();
        }

    label_64:
        if(v3 != v9 || v15_1 != v12 || !ImeAction.equals-impl0(v5.getImeActionOrDefault-eUduSuo$foundation(), v14.getImeActionOrDefault-eUduSuo$foundation()) || v7 != v18) {
            SemanticsModifierNodeKt.invalidateSemantics(v0);
        }

        if(!Intrinsics.areEqual(v2, v17)) {
            v0.pointerInputNode.resetPointerInputHandler();
            if(v0.isAttached()) {
                v2.setReceiveContentConfiguration(v0.receiveContentConfigurationProvider);
                if(v0.isFocused()) {
                    Job v1_1 = v0.toolbarAndHandlesVisibilityObserverJob;
                    if(v1_1 != null) {
                        CancellationException v4_1 = null;
                        if(v1_1 != null) {
                            DefaultImpls.cancel$default(v1_1, v4_1, 1, v4_1);
                        }

                        v0.toolbarAndHandlesVisibilityObserverJob = BuildersKt.launch$default(v0.getCoroutineScope(), null, null, new TextFieldDecoratorModifierNode$updateNode$1(v2, ((Continuation)v4_1)), 3, null);
                    }
                }
            }

            v2.setRequestAutofillAction(new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda4(v0));
        }

        if(!Intrinsics.areEqual(v6, v16)) {
            v0.pointerInputNode.resetPointerInputHandler();
            if(v0.focusableNode.isAttached()) {
                v0.focusableNode.update(v6);
            }
        }

        if(v3 != v9) {
            FocusableNode v1_2 = v0.focusableNode;
            if(v3) {
                v0.delegate(((DelegatableNode)v1_2));
                v0.focusableNode.update(v6);
                return;
            }
            else {
                v0.undelegate(((DelegatableNode)v1_2));
            }
        }
    }

    static final Unit updateNode$lambda$0(TextFieldDecoratorModifierNode arg0) {
        DelegatableNodeKt.requestAutofill(((DelegatableNode)arg0));
        return Unit.INSTANCE;
    }

    private final void updateWindowFocus() {
        ObserverModifierNodeKt.observeReads(this, new TextFieldDecoratorModifierNode$$ExternalSyntheticLambda3(this));
    }

    static final Unit updateWindowFocus$lambda$0(TextFieldDecoratorModifierNode arg2) {
        arg2.windowInfo = CompositionLocalConsumerModifierNodeKt.currentValueOf(arg2, CompositionLocalsKt.getLocalWindowInfo());
        arg2.onIsFocusedUpdated();
        return Unit.INSTANCE;
    }
}

