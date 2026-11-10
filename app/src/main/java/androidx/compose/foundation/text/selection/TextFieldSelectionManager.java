package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\u008C\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0099\u0001\u001A\u00020\u00112\t\u0010\u009A\u0001\u001A\u0004\u0018\u00010hH\u0002¢\u0006\u0003\b\u009B\u0001J\u0019\u0010\u009C\u0001\u001A\u00030\u0092\u00012\u0007\u0010\u009D\u0001\u001A\u00020XH\u0000¢\u0006\u0003\b\u009E\u0001J\u0010\u0010\u009F\u0001\u001A\u00030\u0092\u0001H\u0000¢\u0006\u0003\b \u0001J\u001A\u0010¡\u0001\u001A\u00020\u00112\t\b\u0002\u0010¢\u0001\u001A\u00020XH\u0000¢\u0006\u0003\b£\u0001J\u000F\u0010¤\u0001\u001A\u00020\u0011H\u0000¢\u0006\u0003\b¥\u0001J\u001C\u0010¦\u0001\u001A\u00020\u00112\u000B\b\u0002\u0010§\u0001\u001A\u0004\u0018\u00010eH\u0000¢\u0006\u0003\b¨\u0001J\u001B\u0010©\u0001\u001A\u00020\u00112\u0007\u0010ª\u0001\u001A\u00020hH\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001B\u0010­\u0001\u001A\u00020\u00112\u0007\u0010ª\u0001\u001A\u00020hH\u0000¢\u0006\u0006\b®\u0001\u0010¬\u0001J\u000F\u0010¯\u0001\u001A\u00020\u0011H\u0000¢\u0006\u0003\b°\u0001J\u000F\u0010º\u0001\u001A\u00020XH\u0000¢\u0006\u0003\b»\u0001J\u0010\u0010¼\u0001\u001A\u00020XH\u0080\b¢\u0006\u0003\b½\u0001J\u0013\u0010¾\u0001\u001A\u00020\u0011H\u0080@¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0019\u0010Á\u0001\u001A\u0012\u0012\u0005\u0012\u00030Ã\u0001\u0012\u0004\u0012\u00020h\u0018\u00010Â\u0001H\u0002J\u000F\u0010Ä\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bÅ\u0001J\u0010\u0010Æ\u0001\u001A\u00020XH\u0080\b¢\u0006\u0003\bÇ\u0001J\u000F\u0010È\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bÉ\u0001J\u0010\u0010Ê\u0001\u001A\u00020XH\u0080\b¢\u0006\u0003\bË\u0001J\u000F\u0010Ì\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bÍ\u0001J\u000F\u0010Î\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bÏ\u0001J\u001D\u0010Ð\u0001\u001A\u0005\u0018\u00010Ñ\u00012\t\b\u0002\u0010Ò\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bÓ\u0001J\u001C\u0010Ô\u0001\u001A\u0004\u0018\u00010$2\t\b\u0002\u0010Ò\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bÕ\u0001J\u0012\u0010Ö\u0001\u001A\u0005\u0018\u00010Ñ\u0001H\u0000¢\u0006\u0003\b×\u0001J\u0018\u0010Ö\u0001\u001A\u00020\u00112\u0007\u0010Ø\u0001\u001A\u00020$H\u0000¢\u0006\u0003\b×\u0001J\u0012\u0010Ù\u0001\u001A\u0005\u0018\u00010Ñ\u0001H\u0000¢\u0006\u0003\bÚ\u0001J\u0011\u0010Û\u0001\u001A\u0004\u0018\u00010$H\u0000¢\u0006\u0003\bÜ\u0001J\u000F\u0010Ý\u0001\u001A\u00020\u0011H\u0000¢\u0006\u0003\bÞ\u0001J\u000F\u0010ß\u0001\u001A\u00020\u0011H\u0000¢\u0006\u0003\bà\u0001J\u001B\u0010á\u0001\u001A\u00020e2\u0007\u0010\u009D\u0001\u001A\u00020XH\u0000¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u0019\u0010ä\u0001\u001A\u00030å\u00012\u0007\u0010\u009D\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bæ\u0001J\u001C\u0010ç\u0001\u001A\u00020e2\b\u0010è\u0001\u001A\u00030é\u0001H\u0000¢\u0006\u0006\bê\u0001\u0010ë\u0001J\u0012\u0010ì\u0001\u001A\u00020\u00112\u0007\u0010í\u0001\u001A\u00020XH\u0002J\u000F\u0010î\u0001\u001A\u00020\u0011H\u0000¢\u0006\u0003\bï\u0001J\f\u0010ð\u0001\u001A\u0005\u0018\u00010Ñ\u0001H\u0002J\u000F\u0010ñ\u0001\u001A\u00020\u0011H\u0000¢\u0006\u0003\bò\u0001J\u0019\u0010ó\u0001\u001A\u00020\u00112\u0007\u0010§\u0001\u001A\u00020e¢\u0006\u0006\bô\u0001\u0010¬\u0001J\u000F\u0010õ\u0001\u001A\u00020XH\u0000¢\u0006\u0003\bö\u0001J\n\u0010÷\u0001\u001A\u00030ø\u0001H\u0002JH\u0010ù\u0001\u001A\u00020h2\u0006\u0010\u001E\u001A\u00020\u00102\u0007\u0010ú\u0001\u001A\u00020e2\u0007\u0010û\u0001\u001A\u00020X2\u0007\u0010\u009D\u0001\u001A\u00020X2\b\u0010ü\u0001\u001A\u00030ý\u00012\u0007\u0010þ\u0001\u001A\u00020XH\u0002¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J\u0013\u0010\u0081\u0002\u001A\u00020\u00112\b\u0010\u0082\u0002\u001A\u00030\u0083\u0002H\u0002J$\u0010\u0084\u0002\u001A\u00020\u00102\u0007\u0010\u0085\u0002\u001A\u00020$2\u0007\u0010\u009A\u0001\u001A\u00020hH\u0002¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR&\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00100\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u00108@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001A\u0004\u0018\u00010$8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u001A\u0010\'\u001A\u00020(X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010.X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u00100\"\u0004\b1\u00102R\u001C\u00103\u001A\u0004\u0018\u000104X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u001C\u00109\u001A\u0004\u0018\u00010:X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001C\u0010?\u001A\u0004\u0018\u00010@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001C\u0010E\u001A\u0004\u0018\u00010FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001C\u0010K\u001A\u0004\u0018\u00010LX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001C\u0010Q\u001A\u0004\u0018\u00010RX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010Y\u001A\u00020X2\u0006\u0010W\u001A\u00020X8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010`\u001A\u00020X2\u0006\u0010W\u001A\u00020X8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bc\u0010_\u001A\u0004\ba\u0010[\"\u0004\bb\u0010]R\u0010\u0010d\u001A\u00020eX\u0082\u000E¢\u0006\u0004\n\u0002\u0010fR\u0010\u0010g\u001A\u0004\u0018\u00010hX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010i\u001A\u00020eX\u0082\u000E¢\u0006\u0004\n\u0002\u0010fR/\u0010k\u001A\u0004\u0018\u00010j2\b\u0010W\u001A\u0004\u0018\u00010j8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bp\u0010_\u001A\u0004\bl\u0010m\"\u0004\bn\u0010oR/\u0010q\u001A\u0004\u0018\u00010e2\b\u0010W\u001A\u0004\u0018\u00010e8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bv\u0010_\u001A\u0004\br\u0010s\"\u0004\bt\u0010uR\u000E\u0010w\u001A\u00020xX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010y\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010z\u001A\u0004\u0018\u00010{X\u0082\u000E¢\u0006\u0002\n\u0000R\u001D\u0010|\u001A\u0004\u0018\u00010hX\u0080\u000E¢\u0006\u000F\n\u0000\u001A\u0004\b}\u0010~\"\u0005\b\u007F\u0010\u0080\u0001R/\u0010\u0081\u0001\u001A\u00020X2\u0006\u0010W\u001A\u00020X8B@BX\u0082\u008E\u0002¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010_\u001A\u0005\b\u0082\u0001\u0010[\"\u0005\b\u0083\u0001\u0010]R,\u0010\u0085\u0001\u001A\u00030\u0086\u00018\u0000@\u0000X\u0081\u000E¢\u0006\u001A\n\u0000\u0012\u0006\b\u0087\u0001\u0010\u0088\u0001\u001A\u0006\b\u0089\u0001\u0010\u008A\u0001\"\u0006\b\u008B\u0001\u0010\u008C\u0001R\u0015\u0010\u008D\u0001\u001A\u00030\u008E\u00018F¢\u0006\b\u001A\u0006\b\u008F\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001A\u00030\u0092\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0095\u0001\u001A\u00030\u0096\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001D\u0010±\u0001\u001A\u00020XX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b²\u0001\u0010[\"\u0005\b³\u0001\u0010]R\u001E\u0010´\u0001\u001A\u00020X8@X\u0080\u0004¢\u0006\u000F\u0012\u0006\bµ\u0001\u0010\u0088\u0001\u001A\u0005\b¶\u0001\u0010[R\u0016\u0010·\u0001\u001A\u00020X8BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b·\u0001\u0010[R\u0016\u0010¸\u0001\u001A\u00020X8BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b¹\u0001\u0010[¨\u0006\u0088\u0002"}, d2={"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/UndoManager;)V", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "getOnValueChange$foundation", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "getValue$foundation", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation", "()Landroidx/compose/ui/text/AnnotatedString;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation", "(Lkotlin/jvm/functions/Function0;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "Landroidx/compose/runtime/MutableState;", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragBeginSelection", "Landroidx/compose/ui/text/TextRange;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "previousRawDragOffset", "", "oldValue", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "latestSelection", "getLatestSelection-MzsxiRA$foundation", "()Landroidx/compose/ui/text/TextRange;", "setLatestSelection-OEnZFl4$foundation", "(Landroidx/compose/ui/text/TextRange;)V", "hasAvailableTextToPaste", "getHasAvailableTextToPaste", "setHasAvailableTextToPaste", "hasAvailableTextToPaste$delegate", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation$annotations", "()V", "getToolbarRequester$foundation", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "contextMenuAreaModifier", "Landroidx/compose/ui/Modifier;", "getContextMenuAreaModifier", "()Landroidx/compose/ui/Modifier;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation", "()Landroidx/compose/foundation/text/TextDragObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "maybeSuggestSelection", "selection", "maybeSuggestSelection-OEnZFl4", "handleDragObserver", "isStartHandle", "handleDragObserver$foundation", "cursorDragObserver", "cursorDragObserver$foundation", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation", "exitSelectionMode", "exitSelectionMode$foundation", "deselect", "position", "deselect-_kEHs6E$foundation", "setSelectionPreviewHighlight", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation", "(J)V", "setDeletionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation", "clearPreviewHighlight", "clearPreviewHighlight$foundation", "textToolbarShownViaProvider", "getTextToolbarShownViaProvider$foundation", "setTextToolbarShownViaProvider$foundation", "textToolbarShown", "getTextToolbarShown$foundation$annotations", "getTextToolbarShown$foundation", "isPassword", "hasSelection", "getHasSelection", "canShowCopyMenuItem", "canShowCopyMenuItem$foundation", "isCopyAllowed", "isCopyAllowed$foundation", "updateClipboardEntry", "updateClipboardEntry$foundation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContextTextAndSelection", "Lkotlin/Pair;", "", "canShowPasteMenuItem", "canShowPasteMenuItem$foundation", "isPasteAllowed", "isPasteAllowed$foundation", "canShowCutMenuItem", "canShowCutMenuItem$foundation", "isCutAllowed", "isCutAllowed$foundation", "canShowSelectAllMenuItem", "canShowSelectAllMenuItem$foundation", "canShowAutofillMenuItem", "canShowAutofillMenuItem$foundation", "copy", "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation", "copyWithResult", "copyWithResult$foundation", "paste", "paste$foundation", "text", "cut", "cut$foundation", "cutWithResult", "cutWithResult$foundation", "selectAll", "selectAll$foundation", "autofill", "autofill$foundation", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation", "(Z)J", "getHandleLineHeight", "", "getHandleLineHeight$foundation", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation", "(Landroidx/compose/ui/unit/Density;)J", "updateFloatingToolbar", "show", "showSelectionToolbar", "showSelectionToolbar$foundation", "showSelectionToolbarViaTextToolbar", "hideSelectionToolbar", "hideSelectionToolbar$foundation", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "isTextChanged", "isTextChanged$foundation", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "createTextFieldValue", "annotatedString", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;
    private final MutableState currentDragPosition$delegate;
    private long dragBeginPosition;
    private TextRange dragBeginSelection;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MutableState hasAvailableTextToPaste$delegate;
    private TextRange latestSelection;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1 onValueChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0 requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private boolean textToolbarShownViaProvider;
    private ToolbarRequester toolbarRequester;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState valueState;
    private VisualTransformation visualTransformation;

    static {
    }

    public TextFieldSelectionManager(UndoManager arg10) {
        super();
        this.undoManager = arg10;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new TextFieldSelectionManager$$ExternalSyntheticLambda0();
        this.valueState = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(null, 0, null, 7, null), null, 2, null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        Boolean v0 = Boolean.valueOf(true);
        this.editable$delegate = SnapshotStateKt.mutableStateOf$default(v0, null, 2, null);
        this.enabled$delegate = SnapshotStateKt.mutableStateOf$default(v0, null, 2, null);
        this.dragBeginPosition = Offset.Companion.getZero-F1C5BW0();
        this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue(null, 0, null, 7, null);
        this.hasAvailableTextToPaste$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.touchSelectionObserver = new TextFieldSelectionManager$touchSelectionObserver$1(this);
        this.mouseSelectionObserver = new TextFieldSelectionManager$mouseSelectionObserver$1(this);
    }

    public TextFieldSelectionManager() {
        this(null, 1, null);
    }

    public TextFieldSelectionManager(UndoManager arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    static final Rect _get_contextMenuAreaModifier_$lambda$0(TextFieldSelectionManager arg1, LayoutCoordinates arg2) {
        Rect v0 = arg1.getContentRect();
        LegacyTextFieldState v1 = arg1.state;
        if(v1 != null) {
            LayoutCoordinates v1_1 = v1.getLayoutCoordinates();
            if(v1_1 == null) {
            }
            else {
                return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(v0, v1_1, arg2);
            }
        }

        return null;
    }

    public static final TextFieldValue access$createTextFieldValue-FDrldGo(TextFieldSelectionManager arg0, AnnotatedString arg1, long arg2) {
        return arg0.createTextFieldValue-FDrldGo(arg1, arg2);
    }

    public static final Rect access$getContentRect(TextFieldSelectionManager arg0) {
        return arg0.getContentRect();
    }

    public static final Pair access$getContextTextAndSelection(TextFieldSelectionManager arg0) {
        return arg0.getContextTextAndSelection();
    }

    public static final long access$getDragBeginPosition$p(TextFieldSelectionManager arg2) {
        return arg2.dragBeginPosition;
    }

    public static final TextRange access$getDragBeginSelection$p(TextFieldSelectionManager arg0) {
        return arg0.dragBeginSelection;
    }

    public static final long access$getDragTotalDistance$p(TextFieldSelectionManager arg2) {
        return arg2.dragTotalDistance;
    }

    public static final boolean access$getHasSelection(TextFieldSelectionManager arg0) {
        return arg0.getHasSelection();
    }

    public static final boolean access$isPassword(TextFieldSelectionManager arg0) {
        return arg0.isPassword();
    }

    public static final void access$maybeSuggestSelection-OEnZFl4(TextFieldSelectionManager arg0, TextRange arg1) {
        arg0.maybeSuggestSelection-OEnZFl4(arg1);
    }

    public static final void access$setCurrentDragPosition-_kEHs6E(TextFieldSelectionManager arg0, Offset arg1) {
        arg0.setCurrentDragPosition-_kEHs6E(arg1);
    }

    public static final void access$setDragBeginPosition$p(TextFieldSelectionManager arg0, long arg1) {
        arg0.dragBeginPosition = arg1;
    }

    public static final void access$setDragBeginSelection$p(TextFieldSelectionManager arg0, TextRange arg1) {
        arg0.dragBeginSelection = arg1;
    }

    public static final void access$setDragTotalDistance$p(TextFieldSelectionManager arg0, long arg1) {
        arg0.dragTotalDistance = arg1;
    }

    public static final void access$setDraggingHandle(TextFieldSelectionManager arg0, Handle arg1) {
        arg0.setDraggingHandle(arg1);
    }

    public static final void access$setHandleState(TextFieldSelectionManager arg0, HandleState arg1) {
        arg0.setHandleState(arg1);
    }

    public static final void access$setPreviousRawDragOffset$p(TextFieldSelectionManager arg0, int arg1) {
        arg0.previousRawDragOffset = arg1;
    }

    public static final void access$updateFloatingToolbar(TextFieldSelectionManager arg0, boolean arg1) {
        arg0.updateFloatingToolbar(arg1);
    }

    public static final long access$updateSelection-8UEBfa8(TextFieldSelectionManager arg0, TextFieldValue arg1, long arg2, boolean arg4, boolean arg5, SelectionAdjustment arg6, boolean arg7) {
        return arg0.updateSelection-8UEBfa8(arg1, arg2, arg4, arg5, arg6, arg7);
    }

    public final void autofill$foundation() {
        Function0 v0 = this.requestAutofillAction;
        if(v0 != null) {
            v0.invoke();
        }
    }

    public final boolean canShowAutofillMenuItem$foundation() {
        if((this.getEditable()) && (TextRange.getCollapsed-impl(this.getValue$foundation().getSelection-d9O1mEE()))) {
            return 1;
        }

        return 0;
    }

    public final boolean canShowCopyMenuItem$foundation() {
        if((this.getHasSelection()) && !this.isPassword()) {
            Clipboard v1 = this.clipboard;
            if(v1 != null && (ClipboardUtils_androidKt.isWriteSupported(v1))) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean canShowCutMenuItem$foundation() {
        if((this.getHasSelection()) && (this.getEditable()) && !this.isPassword()) {
            Clipboard v1 = this.clipboard;
            if(v1 != null && (ClipboardUtils_androidKt.isWriteSupported(v1))) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean canShowPasteMenuItem$foundation() {
        if((this.getEditable()) && (this.getHasAvailableTextToPaste())) {
            Clipboard v1 = this.clipboard;
            if(v1 != null && (ClipboardUtils_androidKt.isReadSupported(v1))) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean canShowSelectAllMenuItem$foundation() {
        if(TextRange.getLength-impl(this.getValue$foundation().getSelection-d9O1mEE()) != this.getValue$foundation().getText().length()) {
            return 1;
        }

        return 0;
    }

    public final void clearPreviewHighlight$foundation() {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            v0.setDeletionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }

        LegacyTextFieldState v3 = this.state;
        if(v3 != null) {
            v3.setSelectionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }
    }

    public final Job copy$foundation(boolean arg7) {
        CoroutineScope v0 = this.coroutineScope;
        Continuation v1 = null;
        if(v0 != null) {
            return BuildersKt.launch$default(v0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$copy$1(this, arg7, v1), 1, null);
        }

        return ((Job)v1);
    }

    public static Job copy$foundation$default(TextFieldSelectionManager arg0, boolean arg1, int arg2, Object arg3) {
        return arg0.copy$foundation(true);
    }

    public final AnnotatedString copyWithResult$foundation(boolean arg5) {
        if((this.getHasSelection()) && !this.isPassword()) {
            AnnotatedString v0 = TextFieldValueKt.getSelectedText(this.getValue$foundation());
            if(!arg5) {
                return v0;
            }
            else {
                int v5 = TextRange.getMax-impl(this.getValue$foundation().getSelection-d9O1mEE());
                this.onValueChange.invoke(this.createTextFieldValue-FDrldGo(this.getValue$foundation().getAnnotatedString(), TextRangeKt.TextRange(v5, v5)));
                this.setHandleState(HandleState.None);
                return v0;
            }
        }

        return null;
    }

    public static AnnotatedString copyWithResult$foundation$default(TextFieldSelectionManager arg0, boolean arg1, int arg2, Object arg3) {
        return arg0.copyWithResult$foundation(true);
    }

    private final TextFieldValue createTextFieldValue-FDrldGo(AnnotatedString arg8, long arg9) {
        return new TextFieldValue(arg8, arg9, null, 4, null);
    }

    public final TextDragObserver cursorDragObserver$foundation() {
        return new TextFieldSelectionManager$cursorDragObserver$1(this);
    }

    public final Job cut$foundation() {
        CoroutineScope v0 = this.coroutineScope;
        Continuation v1 = null;
        if(v0 != null) {
            return BuildersKt.launch$default(v0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$cut$1(this, v1), 1, null);
        }

        return ((Job)v1);
    }

    public final AnnotatedString cutWithResult$foundation() {
        if((this.getHasSelection()) && (this.getEditable()) && !this.isPassword()) {
            AnnotatedString v0 = TextFieldValueKt.getSelectedText(this.getValue$foundation());
            AnnotatedString v1 = TextFieldValueKt.getTextBeforeSelection(this.getValue$foundation(), this.getValue$foundation().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(this.getValue$foundation(), this.getValue$foundation().getText().length()));
            int v2 = TextRange.getMin-impl(this.getValue$foundation().getSelection-d9O1mEE());
            this.onValueChange.invoke(this.createTextFieldValue-FDrldGo(v1, TextRangeKt.TextRange(v2, v2)));
            this.setHandleState(HandleState.None);
            UndoManager v4 = this.undoManager;
            if(v4 != null) {
                v4.forceNextSnapshot();
            }

            return v0;
        }

        return null;
    }

    public final void deselect-_kEHs6E$foundation(Offset arg9) {
        if(!TextRange.getCollapsed-impl(this.getValue$foundation().getSelection-d9O1mEE())) {
            LegacyTextFieldState v0 = this.state;
            TextLayoutResultProxy v0_1 = v0 != null ? v0.getLayoutResult() : null;
            TextLayoutResultProxy v1 = v0_1;
            int v0_2 = arg9 == null || v1 == null ? TextRange.getMax-impl(this.getValue$foundation().getSelection-d9O1mEE()) : this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(v1, arg9.unbox-impl(), false, 2, null));
            TextFieldValue v0_3 = TextFieldValue.copy-3r_uNRQ$default(this.getValue$foundation(), null, TextRangeKt.TextRange(v0_2), null, 5, null);
            this.onValueChange.invoke(v0_3);
            this.latestSelection = TextRange.box-impl(v0_3.getSelection-d9O1mEE());
        }

        HandleState v9 = arg9 == null || this.getValue$foundation().getText().length() <= 0 ? HandleState.None : HandleState.Cursor;
        this.setHandleState(v9);
        this.updateFloatingToolbar(false);
    }

    public static void deselect-_kEHs6E$foundation$default(TextFieldSelectionManager arg0, Offset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        arg0.deselect-_kEHs6E$foundation(arg1);
    }

    public final void enterSelectionMode$foundation(boolean arg5) {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null && !v0.getHasFocus()) {
            FocusRequester v0_1 = this.focusRequester;
            if(v0_1 != null) {
                FocusRequester.requestFocus-3ESFkO8$default(v0_1, 0, 1, null);
            }
        }

        this.oldValue = this.getValue$foundation();
        this.updateFloatingToolbar(arg5);
        this.setHandleState(HandleState.Selection);
    }

    public static void enterSelectionMode$foundation$default(TextFieldSelectionManager arg0, boolean arg1, int arg2, Object arg3) {
        arg0.enterSelectionMode$foundation(true);
    }

    public final void exitSelectionMode$foundation() {
        this.updateFloatingToolbar(false);
        this.setHandleState(HandleState.None);
    }

    public final Clipboard getClipboard$foundation() {
        return this.clipboard;
    }

    private final Rect getContentRect() {
        float v3_2;
        long v16;
        int v15;
        float v2_2;
        long v6_2;
        long v4_2;
        TextFieldSelectionManager v0 = this;
        LegacyTextFieldState v1 = v0.state;
        if(v1 != null) {
            if(!v1.isLayoutResultStale()) {
            }
            else {
                v1 = null;
            }

            if(v1 == null) {
                goto label_123;
            }

            int v2 = v0.offsetMapping.originalToTransformed(TextRange.getStart-impl(v0.getValue$foundation().getSelection-d9O1mEE()));
            int v3 = v0.offsetMapping.originalToTransformed(TextRange.getEnd-impl(v0.getValue$foundation().getSelection-d9O1mEE()));
            LegacyTextFieldState v4 = v0.state;
            if(v4 != null) {
                LayoutCoordinates v4_1 = v4.getLayoutCoordinates();
                if(v4_1 != null) {
                    v4_2 = v4_1.localToRoot-MK-Hz9U(v0.getHandlePosition-tuRUvjQ$foundation(true));
                }
                else {
                    goto label_26;
                }
            }
            else {
            label_26:
                v4_2 = Offset.Companion.getZero-F1C5BW0();
            }

            LegacyTextFieldState v6 = v0.state;
            if(v6 != null) {
                LayoutCoordinates v6_1 = v6.getLayoutCoordinates();
                if(v6_1 != null) {
                    v6_2 = v6_1.localToRoot-MK-Hz9U(v0.getHandlePosition-tuRUvjQ$foundation(false));
                }
                else {
                    goto label_36;
                }
            }
            else {
            label_36:
                v6_2 = Offset.Companion.getZero-F1C5BW0();
            }

            LegacyTextFieldState v8 = v0.state;
            float v12 = 0f;
            if(v8 != null) {
                LayoutCoordinates v8_1 = v8.getLayoutCoordinates();
                if(v8_1 != null) {
                    TextLayoutResultProxy v13 = v1.getLayoutResult();
                    if(v13 != null) {
                        TextLayoutResult v13_1 = v13.getValue();
                        if(v13_1 != null) {
                            Rect v2_1 = v13_1.getCursorRect(v2);
                            if(v2_1 != null) {
                                v2_2 = v2_1.getTop();
                            }
                            else {
                                goto label_51;
                            }
                        }
                        else {
                            goto label_51;
                        }
                    }
                    else {
                    label_51:
                        v2_2 = 0f;
                    }

                    v15 = 0x20;
                    v16 = 0xFFFFFFFFL;
                    v2_2 = Float.intBitsToFloat(((int)(v8_1.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v2_2))) & v16 | (((long)Float.floatToRawIntBits(0f))) << v15)) & v16)));
                }
                else {
                    goto label_67;
                }
            }
            else {
            label_67:
                v15 = 0x20;
                v16 = 0xFFFFFFFFL;
                v2_2 = 0f;
            }

            LegacyTextFieldState v0_1 = v0.state;
            if(v0_1 != null) {
                LayoutCoordinates v0_2 = v0_1.getLayoutCoordinates();
                if(v0_2 != null) {
                    TextLayoutResultProxy v8_2 = v1.getLayoutResult();
                    if(v8_2 != null) {
                        TextLayoutResult v8_3 = v8_2.getValue();
                        if(v8_3 != null) {
                            Rect v3_1 = v8_3.getCursorRect(v3);
                            if(v3_1 != null) {
                                v3_2 = v3_1.getTop();
                            }
                            else {
                                goto label_82;
                            }
                        }
                        else {
                            goto label_82;
                        }
                    }
                    else {
                    label_82:
                        v3_2 = 0f;
                    }

                    v12 = Float.intBitsToFloat(((int)(v0_2.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v15 | (((long)Float.floatToRawIntBits(v3_2))) & v16)) & v16)));
                }
            }

            int v0_3 = ((int)(v4_2 >> v15));
            int v8_4 = ((int)(v6_2 >> v15));
            return new Rect(Math.min(Float.intBitsToFloat(v0_3), Float.intBitsToFloat(v8_4)), Math.min(v2_2, v12), Math.max(Float.intBitsToFloat(v0_3), Float.intBitsToFloat(v8_4)), Math.max(Float.intBitsToFloat(((int)(v4_2 & v16))), Float.intBitsToFloat(((int)(v6_2 & v16)))) + Dp.constructor-impl(25f) * v1.getTextDelegate().getDensity().getDensity());
        }

    label_123:
        return Rect.Companion.getZero();
    }

    public final Modifier getContextMenuAreaModifier() {
        if(!this.getEnabled()) {
            return Modifier.Companion;
        }

        return TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler(TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(Modifier.Companion, new TextFieldSelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new TextFieldSelectionManager$contextMenuAreaModifier$2(this, null), new TextFieldSelectionManager$contextMenuAreaModifier$3(this, null), new TextFieldSelectionManager$$ExternalSyntheticLambda1(this));
    }

    private final Pair getContextTextAndSelection() {
        AnnotatedString v0 = this.getTransformedText$foundation();
        Pair v1 = null;
        if(v0 != null) {
            String v0_1 = v0.getText();
            if(v0_1 == null) {
            }
            else {
                TextRange v2 = this.latestSelection;
                if(v2 != null) {
                    long v1_1 = v2.unbox-impl();
                    return new Pair(v0_1, TextRange.box-impl(TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(v1_1)), this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(v1_1)))));
                }
            }
        }

        return v1;
    }

    public final CoroutineScope getCoroutineScope$foundation() {
        return this.coroutineScope;
    }

    public final Offset getCurrentDragPosition-_m7T9-E() {
        return this.currentDragPosition$delegate.getValue();
    }

    public final long getCursorPosition-tuRUvjQ$foundation(Density arg5) {
        Object v4_2;
        int v0 = this.offsetMapping.originalToTransformed(TextRange.getStart-impl(this.getValue$foundation().getSelection-d9O1mEE()));
        LegacyTextFieldState v4 = this.state;
        if(v4 != null) {
            TextLayoutResultProxy v4_1 = v4.getLayoutResult();
        }
        else {
            v4_2 = null;
        }

        Intrinsics.checkNotNull(v4_2);
        TextLayoutResult v4_3 = ((TextLayoutResultProxy)v4_2).getValue();
        Rect v4_4 = v4_3.getCursorRect(RangesKt.coerceIn(v0, 0, v4_3.getLayoutInput().getText().length()));
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v4_4.getBottom()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v4_4.getLeft() + arg5.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2f))) << 0x20);
    }

    public final Handle getDraggingHandle() {
        return this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable() {
        return this.editable$delegate.getValue().booleanValue();
    }

    public final boolean getEnabled() {
        return this.enabled$delegate.getValue().booleanValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final float getHandleLineHeight$foundation(boolean arg3) {
        int v3 = arg3 ? TextRange.getStart-impl(this.getValue$foundation().getSelection-d9O1mEE()) : TextRange.getEnd-impl(this.getValue$foundation().getSelection-d9O1mEE());
        LegacyTextFieldState v2 = this.state;
        if(v2 != null) {
            TextLayoutResultProxy v2_1 = v2.getLayoutResult();
            if(v2_1 != null) {
                TextLayoutResult v2_2 = v2_1.getValue();
                if(v2_2 != null) {
                    return TextLayoutHelperKt.getLineHeight(v2_2, v3);
                }
            }
        }

        return 0;
    }

    public final long getHandlePosition-tuRUvjQ$foundation(boolean arg5) {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            TextLayoutResultProxy v0_1 = v0.getLayoutResult();
            if(v0_1 != null) {
                TextLayoutResult v0_2 = v0_1.getValue();
                if(v0_2 == null) {
                }
                else {
                    AnnotatedString v1 = this.getTransformedText$foundation();
                    if(v1 == null) {
                        return Offset.Companion.getUnspecified-F1C5BW0();
                    }
                    else if(!Intrinsics.areEqual(v1.getText(), v0_2.getLayoutInput().getText().getText())) {
                        return Offset.Companion.getUnspecified-F1C5BW0();
                    }
                    else {
                        long v1_1 = this.getValue$foundation().getSelection-d9O1mEE();
                        int v1_2 = arg5 ? TextRange.getStart-impl(v1_1) : TextRange.getEnd-impl(v1_1);
                        return TextSelectionDelegateKt.getSelectionHandleCoordinates(v0_2, this.offsetMapping.originalToTransformed(v1_2), arg5, TextRange.getReversed-impl(this.getValue$foundation().getSelection-d9O1mEE()));
                    }
                }
            }
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    private final boolean getHasAvailableTextToPaste() {
        return this.hasAvailableTextToPaste$delegate.getValue().booleanValue();
    }

    private final boolean getHasSelection() {
        return TextRange.getCollapsed-impl(this.getValue$foundation().getSelection-d9O1mEE()) ^ 1;
    }

    public final TextRange getLatestSelection-MzsxiRA$foundation() {
        return this.latestSelection;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation() {
        return this.mouseSelectionObserver;
    }

    public final OffsetMapping getOffsetMapping$foundation() {
        return this.offsetMapping;
    }

    public final Function1 getOnValueChange$foundation() {
        return this.onValueChange;
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation() {
        return this.platformSelectionBehaviors;
    }

    public final Function0 getRequestAutofillAction$foundation() {
        return this.requestAutofillAction;
    }

    public final LegacyTextFieldState getState$foundation() {
        return this.state;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final boolean getTextToolbarShown$foundation() {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            return this.textToolbarShownViaProvider;
        }

        TextToolbar v1 = this.textToolbar;
        TextToolbarStatus v1_1 = v1 != null ? v1.getStatus() : null;
        if(v1_1 == TextToolbarStatus.Shown) {
            return 1;
        }

        return 0;
    }

    public static void getTextToolbarShown$foundation$annotations() {
    }

    public final boolean getTextToolbarShownViaProvider$foundation() {
        return this.textToolbarShownViaProvider;
    }

    public final ToolbarRequester getToolbarRequester$foundation() {
        return this.toolbarRequester;
    }

    public static void getToolbarRequester$foundation$annotations() {
    }

    public final TextDragObserver getTouchSelectionObserver$foundation() {
        return this.touchSelectionObserver;
    }

    public final AnnotatedString getTransformedText$foundation() {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            TextDelegate v0_1 = v0.getTextDelegate();
            if(v0_1 != null) {
                return v0_1.getText();
            }
        }

        return null;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue$foundation() {
        return this.valueState.getValue();
    }

    public final VisualTransformation getVisualTransformation$foundation() {
        return this.visualTransformation;
    }

    public final TextDragObserver handleDragObserver$foundation(boolean arg2) {
        return new TextFieldSelectionManager$handleDragObserver$1(this, arg2);
    }

    public final void hideSelectionToolbar$foundation() {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }

        TextToolbar v0 = this.textToolbar;
        TextToolbarStatus v0_1 = v0 != null ? v0.getStatus() : null;
        if(v0_1 == TextToolbarStatus.Shown) {
            TextToolbar v2 = this.textToolbar;
            if(v2 != null) {
                v2.hide();
            }
        }
    }

    public final boolean isCopyAllowed$foundation() {
        if((this.getHasSelection()) && !this.isPassword()) {
            return 1;
        }

        return 0;
    }

    public final boolean isCutAllowed$foundation() {
        if((this.getHasSelection()) && (this.getEditable()) && !this.isPassword()) {
            return 1;
        }

        return 0;
    }

    private final boolean isPassword() {
        return this.visualTransformation instanceof PasswordVisualTransformation;
    }

    public final boolean isPasteAllowed$foundation() {
        return this.getEditable();
    }

    public final boolean isTextChanged$foundation() {
        return Intrinsics.areEqual(this.oldValue.getText(), this.getValue$foundation().getText()) ^ 1;
    }

    private final void maybeSuggestSelection-OEnZFl4(TextRange arg15) {
        if(arg15 == null) {
        }
        else {
            PlatformSelectionBehaviors v1 = this.platformSelectionBehaviors;
            if(v1 == null) {
            }
            else {
                AnnotatedString v0 = this.getTransformedText$foundation();
                if(v0 != null) {
                    String v2 = v0.getText();
                    if(v2 == null) {
                    }
                    else {
                        OffsetMapping v7 = this.offsetMapping;
                        long v3 = TextRangeKt.TextRange(v7.originalToTransformed(TextRange.getStart-impl(arg15.unbox-impl())), v7.originalToTransformed(TextRange.getEnd-impl(arg15.unbox-impl())));
                        if(v2.length() > 0 && !TextRange.getCollapsed-impl(v3)) {
                            CoroutineScope v9 = this.coroutineScope;
                            if(v9 != null) {
                                BuildersKt.launch$default(v9, null, null, new TextFieldSelectionManager$maybeSuggestSelection$1(v1, v2, v3, arg15, this, v7, null), 3, null);
                            }
                        }
                    }
                }
            }
        }
    }

    static final Unit onValueChange$lambda$0(TextFieldValue arg0) {
        return Unit.INSTANCE;
    }

    public final void paste$foundation(AnnotatedString arg4) {
        if(!this.getEditable()) {
        }
        else {
            AnnotatedString v0 = TextFieldValueKt.getTextBeforeSelection(this.getValue$foundation(), this.getValue$foundation().getText().length()).plus(arg4).plus(TextFieldValueKt.getTextAfterSelection(this.getValue$foundation(), this.getValue$foundation().getText().length()));
            int v1 = TextRange.getMin-impl(this.getValue$foundation().getSelection-d9O1mEE()) + arg4.length();
            this.onValueChange.invoke(this.createTextFieldValue-FDrldGo(v0, TextRangeKt.TextRange(v1, v1)));
            this.setHandleState(HandleState.None);
            UndoManager v3 = this.undoManager;
            if(v3 != null) {
                v3.forceNextSnapshot();
            }
        }
    }

    public final Job paste$foundation() {
        CoroutineScope v0 = this.coroutineScope;
        Continuation v1 = null;
        if(v0 != null) {
            return BuildersKt.launch$default(v0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, v1), 1, null);
        }

        return ((Job)v1);
    }

    public final void selectAll$foundation() {
        TextFieldValue v0 = this.createTextFieldValue-FDrldGo(this.getValue$foundation().getAnnotatedString(), TextRangeKt.TextRange(0, this.getValue$foundation().getText().length()));
        this.onValueChange.invoke(v0);
        this.latestSelection = TextRange.box-impl(v0.getSelection-d9O1mEE());
        this.oldValue = TextFieldValue.copy-3r_uNRQ$default(this.oldValue, null, v0.getSelection-d9O1mEE(), null, 5, null);
        this.enterSelectionMode$foundation(true);
    }

    public final void selectWordAtPositionIfNotAlreadySelected-k-4lQ0M(long arg10) {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            TextLayoutResultProxy v0_1 = v0.getLayoutResult();
            if(v0_1 == null) {
            }
            else if(!TextLayoutHelperKt.isPositionInsideSelection-uaM50fQ(v0_1.getValue(), v0_1.translateDecorationToInnerCoordinates-MK-Hz9U$foundation(arg10), TextRange.box-impl(this.getValue$foundation().getSelection-d9O1mEE()))) {
                this.updateSelection-8UEBfa8(this.getValue$foundation(), arg10, true, false, SelectionAdjustment.Companion.getWord(), false);
            }
        }
    }

    public final void setClipboard$foundation(Clipboard arg1) {
        this.clipboard = arg1;
    }

    public final void setCoroutineScope$foundation(CoroutineScope arg1) {
        this.coroutineScope = arg1;
    }

    private final void setCurrentDragPosition-_kEHs6E(Offset arg1) {
        this.currentDragPosition$delegate.setValue(arg1);
    }

    public final void setDeletionPreviewHighlight-5zc-tL8$foundation(long arg4) {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            v0.setDeletionPreviewHighlightRange-5zc-tL8(arg4);
        }

        v0 = this.state;
        if(v0 != null) {
            v0.setSelectionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }

        if(!TextRange.getCollapsed-impl(arg4)) {
            this.exitSelectionMode$foundation();
        }
    }

    private final void setDraggingHandle(Handle arg1) {
        this.draggingHandle$delegate.setValue(arg1);
    }

    public final void setEditable(boolean arg1) {
        this.editable$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setEnabled(boolean arg1) {
        this.enabled$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setFocusRequester(FocusRequester arg1) {
        this.focusRequester = arg1;
    }

    private final void setHandleState(HandleState arg2) {
        LegacyTextFieldState v1 = this.state;
        if(v1 != null) {
            if(v1.getHandleState() == arg2) {
                v1 = null;
            }

            if(v1 == null) {
                return;
            }

            v1.setHandleState(arg2);
        }
    }

    public final void setHapticFeedBack(HapticFeedback arg1) {
        this.hapticFeedBack = arg1;
    }

    private final void setHasAvailableTextToPaste(boolean arg1) {
        this.hasAvailableTextToPaste$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setLatestSelection-OEnZFl4$foundation(TextRange arg1) {
        this.latestSelection = arg1;
    }

    public final void setOffsetMapping$foundation(OffsetMapping arg1) {
        this.offsetMapping = arg1;
    }

    public final void setOnValueChange$foundation(Function1 arg1) {
        this.onValueChange = arg1;
    }

    public final void setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors arg1) {
        this.platformSelectionBehaviors = arg1;
    }

    public final void setRequestAutofillAction$foundation(Function0 arg1) {
        this.requestAutofillAction = arg1;
    }

    public final void setSelectionPreviewHighlight-5zc-tL8$foundation(long arg4) {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            v0.setSelectionPreviewHighlightRange-5zc-tL8(arg4);
        }

        v0 = this.state;
        if(v0 != null) {
            v0.setDeletionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }

        if(!TextRange.getCollapsed-impl(arg4)) {
            this.exitSelectionMode$foundation();
        }
    }

    public final void setState$foundation(LegacyTextFieldState arg1) {
        this.state = arg1;
    }

    public final void setTextToolbar(TextToolbar arg1) {
        this.textToolbar = arg1;
    }

    public final void setTextToolbarShownViaProvider$foundation(boolean arg1) {
        this.textToolbarShownViaProvider = arg1;
    }

    public final void setToolbarRequester$foundation(ToolbarRequester arg1) {
        this.toolbarRequester = arg1;
    }

    public final void setValue$foundation(TextFieldValue arg3) {
        this.valueState.setValue(arg3);
        this.latestSelection = TextRange.box-impl(arg3.getSelection-d9O1mEE());
    }

    public final void setVisualTransformation$foundation(VisualTransformation arg1) {
        this.visualTransformation = arg1;
    }

    public final void showSelectionToolbar$foundation() {
        Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            if(this.getEnabled()) {
                LegacyTextFieldState v4 = this.state;
                if(v4 != null && !v4.isInTouchMode()) {
                    goto label_23;
                }

                goto label_15;
            }

            goto label_23;
        }
        catch(Throwable v5) {
            v0.restoreNonObservable(v1, v3, v2);
            throw v5;
        }

    label_15:
        v0.restoreNonObservable(v1, v3, v2);
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.show();
            return;
        }

        this.showSelectionToolbarViaTextToolbar();
        return;
    label_23:
        v0.restoreNonObservable(v1, v3, v2);
    }

    private final Job showSelectionToolbarViaTextToolbar() {
        CoroutineScope v0 = this.coroutineScope;
        Continuation v1 = null;
        if(v0 != null) {
            return BuildersKt.launch$default(v0, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1(this, v1), 1, null);
        }

        return ((Job)v1);
    }

    public final Object updateClipboardEntry$foundation(Continuation arg5) {
        Object v4;
        TextFieldSelectionManager$updateClipboardEntry$1 v0_1;
        int v2;
        if((arg5 instanceof TextFieldSelectionManager$updateClipboardEntry$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((TextFieldSelectionManager$updateClipboardEntry$1)v0).label & v2) != 0) {
                ((TextFieldSelectionManager$updateClipboardEntry$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            Clipboard v5_1 = this.clipboard;
            if(v5_1 != null && (ClipboardUtils_androidKt.isReadSupported(v5_1))) {
                v0_1.L$0 = this;
                v0_1.label = 1;
                v5 = TextFieldSelectionManager_androidKt.hasAvailableTextToPaste(this, ((Continuation)v0_1));
                if(v5 == v1) {
                    return v1;
                }
                else {
                label_36:
                    ((TextFieldSelectionManager)v4).setHasAvailableTextToPaste(((Boolean)v5).booleanValue());
                }
            }
        }
        else if(v2 == 1) {
            v4 = v0_1.L$0;
            ResultKt.throwOnFailure(v5);
            goto label_36;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    private final void updateFloatingToolbar(boolean arg2) {
        LegacyTextFieldState v0 = this.state;
        if(v0 != null) {
            v0.setShowFloatingToolbar(arg2);
        }

        if(arg2) {
            this.showSelectionToolbar$foundation();
            return;
        }

        this.hideSelectionToolbar$foundation();
    }

    private final long updateSelection-8UEBfa8(TextFieldValue arg14, long arg15, boolean arg17, boolean arg18, SelectionAdjustment arg19, boolean arg20) {
        int v7;
        boolean v0 = arg20;
        LegacyTextFieldState v1 = this.state;
        if(v1 != null) {
            TextLayoutResultProxy v1_1 = v1.getLayoutResult();
            if(v1_1 == null) {
            }
            else {
                long v8 = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(arg14.getSelection-d9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(arg14.getSelection-d9O1mEE())));
                boolean v2 = false;
                int v3 = v1_1.getOffsetForPosition-3MmeM6k(arg15, false);
                int v5 = (arg18) || (arg17) ? v3 : TextRange.getStart-impl(v8);
                int v6 = !arg18 || (arg17) ? v3 : TextRange.getEnd-impl(v8);
                SelectionLayout v12 = this.previousSelectionLayout;
                int v4 = -1;
                if((arg17) || v12 == null) {
                label_38:
                    v7 = v4;
                }
                else {
                    v7 = this.previousRawDragOffset;
                    if(v7 == v4) {
                        goto label_38;
                    }
                }

                SelectionLayout v1_2 = SelectionLayoutKt.getTextFieldSelectionLayout-RcvT-LA(v1_1.getValue(), v5, v6, v7, v8, arg17, arg18);
                if(!v1_2.shouldRecomputeSelection(v12)) {
                    return arg14.getSelection-d9O1mEE();
                }

                this.previousSelectionLayout = v1_2;
                this.previousRawDragOffset = v3;
                Selection v1_3 = arg19.adjust(v1_2);
                long v3_1 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(v1_3.getStart().getOffset()), this.offsetMapping.transformedToOriginal(v1_3.getEnd().getOffset()));
                if(TextRange.equals-impl0(v3_1, arg14.getSelection-d9O1mEE())) {
                    return arg14.getSelection-d9O1mEE();
                }

                int v1_4 = TextRange.getReversed-impl(v3_1) == TextRange.getReversed-impl(arg14.getSelection-d9O1mEE()) || !TextRange.equals-impl0(TextRangeKt.TextRange(TextRange.getEnd-impl(v3_1), TextRange.getStart-impl(v3_1)), arg14.getSelection-d9O1mEE()) ? 0 : 1;
                v5 = !TextRange.getCollapsed-impl(v3_1) || !TextRange.getCollapsed-impl(arg14.getSelection-d9O1mEE()) ? 0 : 1;
                if((v0) && arg14.getText().length() > 0 && v1_4 == 0 && v5 == 0) {
                    HapticFeedback v1_5 = this.hapticFeedBack;
                    if(v1_5 != null) {
                        v1_5.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                    }
                }

                this.onValueChange.invoke(this.createTextFieldValue-FDrldGo(arg14.getAnnotatedString(), v3_1));
                this.latestSelection = TextRange.box-impl(v3_1);
                if(!v0) {
                    this.updateFloatingToolbar(TextRange.getCollapsed-impl(v3_1) ^ 1);
                }

                LegacyTextFieldState v14 = this.state;
                if(v14 != null) {
                    v14.setInTouchMode(v0);
                }

                v14 = this.state;
                if(v14 != null) {
                    v0 = (TextRange.getCollapsed-impl(v3_1)) || !TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this, true) ? false : true;
                    v14.setShowSelectionHandleStart(v0);
                }

                v14 = this.state;
                if(v14 != null) {
                    v0 = (TextRange.getCollapsed-impl(v3_1)) || !TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this, false) ? false : true;
                    v14.setShowSelectionHandleEnd(v0);
                }

                v14 = this.state;
                if(v14 != null) {
                    if((TextRange.getCollapsed-impl(v3_1)) && (TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this, true))) {
                        v2 = true;
                    }

                    v14.setShowCursorHandle(v2);
                }

                return v3_1;
            }
        }

        return TextRange.Companion.getZero-d9O1mEE();
    }
}

