package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString$Builder;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0097\u0001\u001A\u00020\u0017H\u0002J\u001C\u0010\u0098\u0001\u001A\u0005\u0018\u00010\u0099\u00012\b\u0010\u009A\u0001\u001A\u00030\u009B\u0001H\u0000¢\u0006\u0003\b\u009C\u0001J\t\u0010\u009D\u0001\u001A\u00020\u0017H\u0002J\u000F\u0010\u009E\u0001\u001A\u00020PH\u0000¢\u0006\u0003\b\u009F\u0001J:\u0010 \u0001\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000B\u0012\t\u0012\u0004\u0012\u00020\b0¢\u00010¡\u00012\b\u0010£\u0001\u001A\u00030¤\u00012\t\u0010¥\u0001\u001A\u0004\u0018\u00010\bH\u0000¢\u0006\u0003\b¦\u0001J\u000F\u0010§\u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\b¨\u0001J\u000F\u0010©\u0001\u001A\u00020\u0017H\u0000¢\u0006\u0003\bª\u0001J\u000F\u0010«\u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\b¬\u0001J\u000F\u0010­\u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\b®\u0001J\u0011\u0010¯\u0001\u001A\u0004\u0018\u00010$H\u0000¢\u0006\u0003\b°\u0001J\u001F\u0010±\u0001\u001A\u0012\u0012\u0004\u0012\u00020$\u0012\u0005\u0012\u00030²\u0001\u0018\u00010¡\u0001H\u0000¢\u0006\u0003\b³\u0001J\u0083\u0001\u0010´\u0001\u001A\u00020\u00172q\b\u0004\u0010µ\u0001\u001Aj\u0012\u0017\u0012\u00150¤\u0001¢\u0006\u000F\b·\u0001\u0012\n\b¸\u0001\u0012\u0005\b\b(£\u0001\u0012\u0016\u0012\u00140$¢\u0006\u000F\b·\u0001\u0012\n\b¸\u0001\u0012\u0005\b\b(¹\u0001\u0012\u0016\u0012\u00140²\u0001¢\u0006\u000E\b·\u0001\u0012\t\b¸\u0001\u0012\u0004\b\b(\n\u0012\u0016\u0012\u00140\u0010¢\u0006\u000F\b·\u0001\u0012\n\b¸\u0001\u0012\u0005\b\b(º\u0001\u0012\u0004\u0012\u00020\u00100¶\u0001H\u0080\b¢\u0006\u0003\b»\u0001J\u000F\u0010¼\u0001\u001A\u00020\u0017H\u0000¢\u0006\u0003\b½\u0001J\t\u0010Á\u0001\u001A\u00020\u0017H\u0002J\t\u0010Â\u0001\u001A\u00020\u0017H\u0002J\u000F\u0010Ã\u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\bÄ\u0001J\t\u0010Å\u0001\u001A\u00020\u0017H\u0002J\u000B\u0010Æ\u0001\u001A\u0004\u0018\u00010GH\u0002J\u0007\u0010Ç\u0001\u001A\u00020\u0017J\u0011\u0010È\u0001\u001A\u00030É\u00012\u0007\u0010Ê\u0001\u001A\u00020\u0010J\r\u0010Ë\u0001\u001A\u00020C*\u00020CH\u0002J\u001D\u0010Ì\u0001\u001A\u00020C*\u00020C2\u000E\u0010µ\u0001\u001A\t\u0012\u0004\u0012\u00020\u00170Í\u0001H\u0002J$\u0010Î\u0001\u001A\u00020O2\u0007\u0010Ï\u0001\u001A\u00020P2\u0007\u0010Ð\u0001\u001A\u00020OH\u0002¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J.\u0010Ó\u0001\u001A\u00020\u00172\u0007\u0010Ô\u0001\u001A\u00020O2\u0007\u0010Ê\u0001\u001A\u00020\u00102\b\u0010Õ\u0001\u001A\u00030Ö\u0001H\u0002¢\u0006\u0006\b×\u0001\u0010Ø\u0001J8\u0010Ù\u0001\u001A\u00020\u00102\t\u0010Ú\u0001\u001A\u0004\u0018\u00010O2\u0006\u0010N\u001A\u00020O2\u0007\u0010Ê\u0001\u001A\u00020\u00102\b\u0010Õ\u0001\u001A\u00030Ö\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J7\u0010Ù\u0001\u001A\u00020\u00102\u0007\u0010Ô\u0001\u001A\u00020O2\u0007\u0010Ý\u0001\u001A\u00020O2\u0007\u0010Ê\u0001\u001A\u00020\u00102\b\u0010Õ\u0001\u001A\u00030Ö\u0001H\u0000¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J0\u0010à\u0001\u001A\u0005\u0018\u00010\u0084\u00012\u0007\u0010Ô\u0001\u001A\u00020O2\u0007\u0010Ý\u0001\u001A\u00020O2\u0007\u0010Ê\u0001\u001A\u00020\u0010H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001J\u001C\u0010ã\u0001\u001A\u00020\u00172\b\u0010ä\u0001\u001A\u00030\u0084\u00012\u0007\u0010å\u0001\u001A\u00020\bH\u0002J\u000F\u0010æ\u0001\u001A\u00020\u0010H\u0001¢\u0006\u0003\bç\u0001J\u0018\u0010è\u0001\u001A\u00020\u00172\u0007\u0010Ô\u0001\u001A\u00020O¢\u0006\u0005\bé\u0001\u0010`R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\u00108F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R@\u0010\u0018\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00170\u00162\u0014\u0010\u0015\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00170\u0016@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001C\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001A\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u001A\"\u0004\b&\u0010\u001CR\u001C\u0010\'\u001A\u0004\u0018\u00010(X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001A\u00020.8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u001A\u00105\u001A\u000206X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010<\u001A\u00020\u00102\u0006\u0010;\u001A\u00020\u00108F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b?\u0010@\u001A\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u0014\u0010A\u001A\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bA\u0010\u0012R\u0011\u0010B\u001A\u00020C8F¢\u0006\u0006\u001A\u0004\bD\u0010ER\u001D\u0010F\u001A\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001A\u0004\bH\u0010IR\u0011\u0010L\u001A\u00020C8F¢\u0006\u0006\u001A\u0004\bM\u0010ER\u0010\u0010N\u001A\u0004\u0018\u00010OX\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010Q\u001A\u0004\u0018\u00010P2\b\u0010\t\u001A\u0004\u0018\u00010P@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bR\u0010S\"\u0004\bT\u0010UR+\u0010V\u001A\u00020\u00172\u0006\u0010;\u001A\u00020\u00178B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b[\u0010@\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR+\u0010\\\u001A\u00020O2\u0006\u0010;\u001A\u00020O8@@BX\u0080\u008E\u0002¢\u0006\u0012\n\u0004\ba\u0010@\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R+\u0010b\u001A\u00020O2\u0006\u0010;\u001A\u00020O8@@BX\u0080\u008E\u0002¢\u0006\u0012\n\u0004\be\u0010@\u001A\u0004\bc\u0010^\"\u0004\bd\u0010`R/\u0010f\u001A\u0004\u0018\u00010O2\b\u0010;\u001A\u0004\u0018\u00010O8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bk\u0010@\u001A\u0004\bg\u0010h\"\u0004\bi\u0010jR/\u0010l\u001A\u0004\u0018\u00010O2\b\u0010;\u001A\u0004\u0018\u00010O8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bo\u0010@\u001A\u0004\bm\u0010h\"\u0004\bn\u0010jR/\u0010q\u001A\u0004\u0018\u00010p2\b\u0010;\u001A\u0004\u0018\u00010p8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bv\u0010@\u001A\u0004\br\u0010s\"\u0004\bt\u0010uR\u0011\u0010w\u001A\u00020x8F¢\u0006\u0006\u001A\u0004\by\u0010zR\u0011\u0010{\u001A\u00020x8F¢\u0006\u0006\u001A\u0004\b|\u0010zR0\u0010}\u001A\u0004\u0018\u00010O2\b\u0010;\u001A\u0004\u0018\u00010O8F@BX\u0086\u008E\u0002¢\u0006\u0013\n\u0005\b\u0080\u0001\u0010@\u001A\u0004\b~\u0010h\"\u0004\b\u007F\u0010jR\u0016\u0010\u0081\u0001\u001A\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b\u0082\u0001\u0010\u0012R-\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0084\u00018\u0000@\u0000X\u0081\u000E¢\u0006\u0019\n\u0000\u0012\u0005\b\u0085\u0001\u00100\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u000F\u0010\u008A\u0001\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u008B\u0001\u001A\u0005\u0018\u00010\u008C\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u008D\u0001\u0010\u008E\u0001\"\u0006\b\u008F\u0001\u0010\u0090\u0001R\"\u0010\u0091\u0001\u001A\u0005\u0018\u00010\u0092\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\'\u0010¾\u0001\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\u0010@@X\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b¿\u0001\u0010\u0012\"\u0005\bÀ\u0001\u0010\u0014¨\u0006ê\u0001"}, d2={"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "<init>", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "value", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "_isInTouchMode", "", "isInTouchMode", "()Z", "setInTouchMode", "(Z)V", "newOnSelectionChange", "Lkotlin/Function1;", "", "onSelectionChange", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "onCopyHandler", "Landroidx/compose/ui/text/AnnotatedString;", "getOnCopyHandler", "setOnCopyHandler", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation$annotations", "()V", "getToolbarRequester$foundation", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "hasFocus", "getHasFocus", "setHasFocus", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "isDraggingInProgress", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "derivedContentRect", "Landroidx/compose/ui/geometry/Rect;", "getDerivedContentRect", "()Landroidx/compose/ui/geometry/Rect;", "derivedContentRect$delegate", "Landroidx/compose/runtime/State;", "contextMenuAreaModifier", "getContextMenuAreaModifier", "previousPosition", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "positionChangeState", "getPositionChangeState", "()Lkotlin/Unit;", "setPositionChangeState", "(Lkotlin/Unit;)V", "positionChangeState$delegate", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setStartHandlePosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "startHandlePosition$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "startHandleLineHeight", "", "getStartHandleLineHeight", "()F", "endHandleLineHeight", "getEndHandleLineHeight", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "setCurrentDragPosition-_kEHs6E", "currentDragPosition$delegate", "shouldShowMagnifier", "getShouldShowMagnifier", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation$annotations", "getPreviousSelectionLayout$foundation", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "isLongPressOrClickSelection", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "suggestSelectionForLongPressOrDoubleClick", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation", "updateHandleOffsets", "requireContainerCoordinates", "requireContainerCoordinates$foundation", "selectAllInSelectable", "Lkotlin/Pair;", "Landroidx/collection/LongObjectMap;", "selectableId", "", "previousSelection", "selectAllInSelectable$foundation", "isEntireContainerSelected", "isEntireContainerSelected$foundation", "selectAll", "selectAll$foundation", "isTriviallyCollapsedSelection", "isTriviallyCollapsedSelection$foundation", "isNonEmptySelection", "isNonEmptySelection$foundation", "getSelectedText", "getSelectedText$foundation", "getContextTextAndSelection", "Landroidx/compose/ui/text/TextRange;", "getContextTextAndSelection$foundation", "forEachSelectableWithSelection", "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "text", "isLastSelectable", "forEachSelectableWithSelection$foundation", "copy", "copy$foundation", "showToolbar", "getShowToolbar$foundation", "setShowToolbar$foundation", "toolbarCopy", "updateSelectionToolbar", "canCopy", "canCopy$foundation", "updateSelectionTextToolbar", "getContentRect", "onRelease", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "addContextMenuComponents", "onClearSelectionRequested", "Lkotlin/Function0;", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "startSelection", "position", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateSelection", "newPosition", "updateSelection-qNKwrvQ$foundation", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "previousHandlePosition", "updateSelection-jyLRC_s$foundation", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "getSelectionLayout", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectionChanged", "selectionLayout", "newSelection", "shouldPerformHaptics", "shouldPerformHaptics$foundation", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionManager {
    public static final int $stable = 8;
    private final MutableState _isInTouchMode;
    private final MutableState _selection;
    private LayoutCoordinates containerLayoutCoordinates;
    private CoroutineScope coroutineScope;
    private final MutableState currentDragPosition$delegate;
    private final State derivedContentRect$delegate;
    private final MutableState dragBeginPosition$delegate;
    private final MutableState dragTotalDistance$delegate;
    private final MutableState draggingHandle$delegate;
    private final MutableState endHandlePosition$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate;
    private boolean isLongPressOrClickSelection;
    private Function1 onCopyHandler;
    private Function1 onSelectionChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private final MutableState positionChangeState$delegate;
    private Offset previousPosition;
    private SelectionLayout previousSelectionLayout;
    private final SelectionRegistrarImpl selectionRegistrar;
    private boolean showToolbar;
    private final MutableState startHandlePosition$delegate;
    private TextToolbar textToolbar;
    private ToolbarRequester toolbarRequester;

    static {
    }

    public SelectionManager(SelectionRegistrarImpl arg5) {
        super();
        this.selectionRegistrar = arg5;
        this._selection = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._isInTouchMode = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
        this.onSelectionChange = new SelectionManager$$ExternalSyntheticLambda10(this);
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.focusRequester = new FocusRequester();
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.derivedContentRect$delegate = SnapshotStateKt.derivedStateOf(new SelectionManager$$ExternalSyntheticLambda11(this));
        this.positionChangeState$delegate = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.dragBeginPosition$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), null, 2, null);
        this.dragTotalDistance$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), null, 2, null);
        this.startHandlePosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        arg5.setOnPositionChangeCallback$foundation(new SelectionManager$$ExternalSyntheticLambda12(this));
        arg5.setOnSelectionUpdateStartCallback$foundation(new SelectionManager$$ExternalSyntheticLambda13(this));
        arg5.setOnSelectionUpdateSelectAll$foundation(new SelectionManager$$ExternalSyntheticLambda14(this));
        arg5.setOnSelectionUpdateCallback$foundation(new SelectionManager$$ExternalSyntheticLambda1(this));
        arg5.setOnSelectionUpdateEndCallback$foundation(new SelectionManager$$ExternalSyntheticLambda2(this));
        arg5.setOnSelectableChangeCallback$foundation(new SelectionManager$$ExternalSyntheticLambda3(this));
        arg5.setAfterSelectableUnsubscribe$foundation(new SelectionManager$$ExternalSyntheticLambda4(this));
    }

    static final Rect _get_contextMenuAreaModifier_$lambda$0(SelectionManager arg1, LayoutCoordinates arg2) {
        Rect v0 = arg1.getDerivedContentRect();
        if(v0 == null) {
            return null;
        }

        LayoutCoordinates v1 = arg1.containerLayoutCoordinates;
        if(v1 != null) {
            return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(v0, v1, arg2);
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    static final Unit _get_modifier_$lambda$0(SelectionManager arg0) {
        arg0.onRelease();
        return Unit.INSTANCE;
    }

    static final Unit _get_modifier_$lambda$1(SelectionManager arg0, LayoutCoordinates arg1) {
        arg0.setContainerLayoutCoordinates(arg1);
        return Unit.INSTANCE;
    }

    static final Unit _get_modifier_$lambda$2(SelectionManager arg1, FocusState arg2) {
        if(!arg2.getHasFocus() && (arg1.getHasFocus())) {
            arg1.onRelease();
        }

        arg1.setHasFocus(arg2.getHasFocus());
        return Unit.INSTANCE;
    }

    static final Unit _get_modifier_$lambda$3(SelectionManager arg0, boolean arg1) {
        arg0.setInTouchMode(arg1);
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$0(SelectionManager arg1, long arg2) {
        if(arg1.selectionRegistrar.getSubselections().containsKey(arg2)) {
            arg1.setPositionChangeState(Unit.INSTANCE);
            arg1.updateHandleOffsets();
            arg1.updateSelectionToolbar();
        }

        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$1(SelectionManager arg6, boolean arg7, LayoutCoordinates arg8, Offset arg9, SelectionAdjustment arg10) {
        long v0 = arg8.getSize-YbymL2g();
        Rect v2 = new Rect(0f, 0f, ((float)(((int)(v0 >> 0x20)))), ((float)(((int)(v0 & 0xFFFFFFFFL)))));
        v0 = SelectionManagerKt.containsInclusive-Uv8p0NA(v2, arg9.unbox-impl()) ? arg9.unbox-impl() : TextLayoutStateKt.coerceIn-3MmeM6k(arg9.unbox-impl(), v2);
        long v8 = arg6.convertToContainerCoordinates-R5De75A(arg8, v0);
        if((0x7FFFFFFF7FFFFFFFL & v8) != 0x7FC000007FC00000L) {
            arg6.setInTouchMode(arg7);
            arg6.startSelection-9KIMszo(v8, false, arg10);
            FocusRequester.requestFocus-3ESFkO8$default(arg6.focusRequester, 0, 1, null);
            arg6.setShowToolbar$foundation(false);
            arg6.isLongPressOrClickSelection = true;
        }

        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$2(SelectionManager arg1, boolean arg2, long arg3) {
        Pair v3 = arg1.selectAllInSelectable$foundation(arg3, arg1.getSelection());
        Object v4 = v3.component1();
        Object v3_1 = v3.component2();
        if(!Intrinsics.areEqual(v4, arg1.getSelection())) {
            arg1.selectionRegistrar.setSubselections(((LongObjectMap)v3_1));
            arg1.onSelectionChange.invoke(v4);
        }

        arg1.setInTouchMode(arg2);
        FocusRequester.requestFocus-3ESFkO8$default(arg1.focusRequester, 0, 1, null);
        arg1.setShowToolbar$foundation(false);
        return Unit.INSTANCE;
    }

    static final boolean _init_$lambda$3(SelectionManager arg8, boolean arg9, LayoutCoordinates arg10, Offset arg11, Offset arg12, boolean arg13, SelectionAdjustment arg14) {
        long v0 = arg8.convertToContainerCoordinates-R5De75A(arg10, arg11.unbox-impl());
        long v4 = arg8.convertToContainerCoordinates-R5De75A(arg10, arg12.unbox-impl());
        arg8.setInTouchMode(arg9);
        return arg8.updateSelection-qNKwrvQ$foundation(Offset.box-impl(v0), v4, arg13, arg14);
    }

    static final Unit _init_$lambda$4(SelectionManager arg1) {
        arg1.setShowToolbar$foundation(true);
        arg1.setDraggingHandle(null);
        arg1.setCurrentDragPosition-_kEHs6E(null);
        if((arg1.isLongPressOrClickSelection) && (arg1.isNonEmptySelection$foundation())) {
            arg1.suggestSelectionForLongPressOrDoubleClick();
        }

        arg1.isLongPressOrClickSelection = false;
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$5(SelectionManager arg1, long arg2) {
        if(arg1.selectionRegistrar.getSubselections().containsKey(arg2)) {
            arg1.onRelease();
            arg1.setSelection(null);
        }

        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$6(SelectionManager arg4, long arg5) {
        AnchorInfo v0_1;
        Selection v0 = arg4.getSelection();
        Offset v1 = null;
        if(v0 != null) {
            v0_1 = v0.getStart();
            if(v0_1 != null && arg5 == v0_1.getSelectableId()) {
                arg4.setStartHandlePosition-_kEHs6E(v1);
            }
        }

        v0 = arg4.getSelection();
        if(v0 != null) {
            v0_1 = v0.getEnd();
            if(v0_1 != null && arg5 == v0_1.getSelectableId()) {
                arg4.setEndHandlePosition-_kEHs6E(v1);
            }
        }

        if(arg4.selectionRegistrar.getSubselections().containsKey(arg5)) {
            arg4.updateSelectionToolbar();
        }

        return Unit.INSTANCE;
    }

    static final Unit _set_onSelectionChange_$lambda$0(SelectionManager arg0, Function1 arg1, Selection arg2) {
        arg0.setSelection(arg2);
        arg1.invoke(arg2);
        return Unit.INSTANCE;
    }

    public static final SelectionRegistrarImpl access$getSelectionRegistrar$p(SelectionManager arg0) {
        return arg0.selectionRegistrar;
    }

    public static final boolean access$isDraggingInProgress(SelectionManager arg0) {
        return arg0.isDraggingInProgress();
    }

    public static final void access$setCurrentDragPosition-_kEHs6E(SelectionManager arg0, Offset arg1) {
        arg0.setCurrentDragPosition-_kEHs6E(arg1);
    }

    public static final void access$setDragBeginPosition-k-4lQ0M(SelectionManager arg0, long arg1) {
        arg0.setDragBeginPosition-k-4lQ0M(arg1);
    }

    public static final void access$setDragTotalDistance-k-4lQ0M(SelectionManager arg0, long arg1) {
        arg0.setDragTotalDistance-k-4lQ0M(arg1);
    }

    public static final void access$setDraggingHandle(SelectionManager arg0, Handle arg1) {
        arg0.setDraggingHandle(arg1);
    }

    public static final void access$toolbarCopy(SelectionManager arg0) {
        arg0.toolbarCopy();
    }

    private final Modifier addContextMenuComponents(Modifier arg2) {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents(arg2, this);
        }

        return arg2;
    }

    public final boolean canCopy$foundation() {
        if(this.onCopyHandler != null && (this.isNonEmptySelection$foundation())) {
            return 1;
        }

        return 0;
    }

    private final long convertToContainerCoordinates-R5De75A(LayoutCoordinates arg2, long arg3) {
        LayoutCoordinates v0 = this.containerLayoutCoordinates;
        if(v0 != null) {
            if(!v0.isAttached()) {
            }
            else {
                return this.requireContainerCoordinates$foundation().localPositionOf-R5De75A(arg2, arg3);
            }
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public final void copy$foundation() {
        AnnotatedString v0 = this.getSelectedText$foundation();
        if(v0 != null) {
            if(v0.length() > 0) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                return;
            }

            Function1 v2 = this.onCopyHandler;
            if(v2 == null) {
                return;
            }

            v2.invoke(v0);
        }
    }

    static final Rect derivedContentRect_delegate$lambda$0(SelectionManager arg0) {
        return arg0.getContentRect();
    }

    public final void forEachSelectableWithSelection$foundation(Function4 arg13) {
        int v3;
        List v0 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        ListIterator v1 = v0.listIterator(v0.size());
        do {
            v3 = -1;
            if(v1.hasPrevious()) {
                Object v2 = this.selectionRegistrar.getSubselections().get(v1.previous().getSelectableId());
                if(v2 == null) {
                    continue;
                }

                if(((Selection)v2).getStart().getOffset() == ((Selection)v2).getEnd().getOffset()) {
                    continue;
                }

                break;
            }
            else {
                goto label_21;
            }
        }
        while(true);

        int v1_1 = v1.nextIndex();
        goto label_22;
    label_21:
        v1_1 = v3;
    label_22:
        if(v1_1 == v3) {
        }
        else {
            int v2_1 = v0.size();
            int v4;
            for(v4 = 0; v4 < v2_1; ++v4) {
                Object v5 = v0.get(v4);
                Object v6 = this.selectionRegistrar.getSubselections().get(((Selectable)v5).getSelectableId());
                if(v6 != null) {
                    AnnotatedString v7 = ((Selectable)v5).getText();
                    long v8 = TextRangeKt.TextRange(((Selection)v6).getStart().getOffset(), ((Selection)v6).getEnd().getOffset());
                    boolean v6_1 = v4 >= v1_1 ? true : false;
                    if(arg13.invoke(Long.valueOf(((Selectable)v5).getSelectableId()), v7, TextRange.box-impl(v8), Boolean.valueOf(v6_1)).booleanValue()) {
                        goto label_53;
                    }

                    return;
                }

            label_53:
            }
        }
    }

    public final Selectable getAnchorSelectable$foundation(AnchorInfo arg3) {
        return this.selectionRegistrar.getSelectableMap$foundation().get(arg3.getSelectableId());
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    private final Rect getContentRect() {
        this.getPositionChangeState();
        Rect v1 = null;
        if(this.getSelection() == null) {
            return v1;
        }

        LayoutCoordinates v0 = this.containerLayoutCoordinates;
        if(v0 == null) {
            return v1;
        }

        if(!v0.isAttached()) {
            return v1;
        }

        List v2 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        ArrayList v3 = new ArrayList(v2.size());
        int v4 = v2.size();
        int v5;
        for(v5 = 0; v5 < v4; ++v5) {
            Object v6 = v2.get(v5);
            Object v7 = this.selectionRegistrar.getSubselections().get(((Selectable)v6).getSelectableId());
            Pair v6_1 = v7 != null ? TuplesKt.to(v6, v7) : ((Pair)v1);
            if(v6_1 != null) {
                v3.add(v6_1);
            }
        }

        List v10 = SelectionManagerKt.access$firstAndLast(((List)v3));
        if(v10.isEmpty()) {
            return v1;
        }

        Rect v10_1 = SelectionManagerKt.getSelectedRegionRect(v10, v0);
        if(Intrinsics.areEqual(v10_1, SelectionManagerKt.access$getInvertedInfiniteRect$p())) {
            return v1;
        }

        v10_1 = SelectionManagerKt.visibleBounds(v0).intersect(v10_1);
        if(v10_1.getRight() - v10_1.getLeft() >= 0f) {
            if(v10_1.getBottom() - v10_1.getTop() < 0f) {
            }
            else {
                Rect v2_1 = v10_1.translate-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(v0));
                return Rect.copy$default(v2_1, 0f, 0f, 0f, v2_1.getBottom() + SelectionHandlesKt.getHandleHeight() * 4f, 7, null);
            }
        }

        return v1;
    }

    public final Modifier getContextMenuAreaModifier() {
        return TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler$default(TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(Modifier.Companion, new SelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new SelectionManager$contextMenuAreaModifier$2(this, null), null, new SelectionManager$$ExternalSyntheticLambda9(this), 4, null);
    }

    public final Pair getContextTextAndSelection$foundation() {
        DefaultConstructorMarker v17;
        int v11;
        int v10;
        int v9;
        int v8;
        DefaultConstructorMarker v1 = null;
        if(this.getSelection() != null) {
            SelectionManager v0 = this;
            if(v0.selectionRegistrar.getSelectables$foundation().isEmpty()) {
            }
            else {
                Builder v2 = new Builder(0, 1, v1);
                List v5 = v0.selectionRegistrar.sort(v0.requireContainerCoordinates$foundation());
                ListIterator v6 = v5.listIterator(v5.size());
                do {
                    v8 = -1;
                    if(v6.hasPrevious()) {
                        Object v7 = v0.selectionRegistrar.getSubselections().get(v6.previous().getSelectableId());
                        if(v7 == null) {
                            continue;
                        }

                        if(((Selection)v7).getStart().getOffset() == ((Selection)v7).getEnd().getOffset()) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_34;
                    }
                }
                while(true);

                int v6_1 = v6.nextIndex();
                goto label_35;
            label_34:
                v6_1 = v8;
            label_35:
                if(v6_1 != v8) {
                    int v7_1 = v5.size();
                    v9 = 0;
                    v10 = v8;
                    v11 = v10;
                    goto label_41;
                }
                else {
                    v10 = v8;
                    v11 = v10;
                    goto label_82;
                label_41:
                    while(v9 < v7_1) {
                        Object v12 = v5.get(v9);
                        Object v13 = v0.selectionRegistrar.getSubselections().get(((Selectable)v12).getSelectableId());
                        if(v13 != null) {
                            AnnotatedString v14 = ((Selectable)v12).getText();
                            long v15 = TextRangeKt.TextRange(((Selection)v13).getStart().getOffset(), ((Selection)v13).getEnd().getOffset());
                            int v13_1 = v9 >= v6_1 ? 1 : 0;
                            ((Selectable)v12).getSelectableId();
                            if(v10 == v8) {
                                v10 = TextRange.getMin-impl(v15);
                                v2.append(v14, 0, TextRange.getMin-impl(v15));
                            }

                            v17 = v1;
                            v2.append(v14, TextRange.getMin-impl(v15), TextRange.getMax-impl(v15));
                            if(v13_1 == 0) {
                                v2.append('\n');
                                goto label_77;
                            }

                            v11 = v2.getLength();
                            v2.append(v14, TextRange.getMax-impl(v15), v14.length());
                        }
                        else {
                            v17 = v1;
                        }

                    label_77:
                        ++v9;
                        Pair v1_1 = ((Pair)v17);
                    }
                }

            label_82:
                Pair v17_1 = ((Pair)v1);
                AnnotatedString v0_1 = v2.toAnnotatedString();
                if(v10 != v8) {
                    if(v11 == v8) {
                    }
                    else {
                        return new Pair(v0_1, TextRange.box-impl(TextRangeKt.TextRange(v10, v11)));
                    }
                }

                return v17_1;
            }
        }

        return ((Pair)v1);
    }

    public final CoroutineScope getCoroutineScope$foundation() {
        return this.coroutineScope;
    }

    public final Offset getCurrentDragPosition-_m7T9-E() {
        return this.currentDragPosition$delegate.getValue();
    }

    private final Rect getDerivedContentRect() {
        return this.derivedContentRect$delegate.getValue();
    }

    public final long getDragBeginPosition-F1C5BW0$foundation() {
        return this.dragBeginPosition$delegate.getValue().unbox-impl();
    }

    public final long getDragTotalDistance-F1C5BW0$foundation() {
        return this.dragTotalDistance$delegate.getValue().unbox-impl();
    }

    public final Handle getDraggingHandle() {
        return this.draggingHandle$delegate.getValue();
    }

    public final float getEndHandleLineHeight() {
        Selection v0 = this.getSelection();
        if(v0 == null) {
            return 0;
        }

        Selectable v3 = this.getAnchorSelectable$foundation(v0.getEnd());
        if(v3 == null) {
            return 0;
        }

        return v3.getLineHeight(v0.getEnd().getOffset());
    }

    public final Offset getEndHandlePosition-_m7T9-E() {
        return this.endHandlePosition$delegate.getValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final boolean getHasFocus() {
        return this.hasFocus$delegate.getValue().booleanValue();
    }

    public final Modifier getModifier() {
        Companion v1_1;
        Modifier v0 = KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(this.onClearSelectionRequested(Modifier.Companion, new SelectionManager$$ExternalSyntheticLambda0(this)), new SelectionManager$$ExternalSyntheticLambda6(this)), this.focusRequester), new SelectionManager$$ExternalSyntheticLambda7(this)), false, null, 3, null), new SelectionManager$$ExternalSyntheticLambda8(this)), new SelectionManager$modifier$5(this));
        if(this.getShouldShowMagnifier()) {
            Modifier v1 = SelectionManager_androidKt.selectionMagnifier(Modifier.Companion, this);
        }
        else {
            v1_1 = Modifier.Companion;
        }

        return this.addContextMenuComponents(v0.then(((Modifier)v1_1)));
    }

    public final Function1 getOnCopyHandler() {
        return this.onCopyHandler;
    }

    public final Function1 getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation() {
        return this.platformSelectionBehaviors;
    }

    private final Unit getPositionChangeState() {
        this.positionChangeState$delegate.getValue();
        return Unit.INSTANCE;
    }

    public final SelectionLayout getPreviousSelectionLayout$foundation() {
        return this.previousSelectionLayout;
    }

    public static void getPreviousSelectionLayout$foundation$annotations() {
    }

    public final AnnotatedString getSelectedText$foundation() {
        int v6;
        DefaultConstructorMarker v1 = null;
        if(this.getSelection() != null) {
            if(this.selectionRegistrar.getSubselections().isEmpty()) {
            }
            else {
                Builder v0 = new Builder(0, 1, v1);
                List v1_1 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
                ListIterator v4 = v1_1.listIterator(v1_1.size());
                do {
                    v6 = -1;
                    if(v4.hasPrevious()) {
                        Object v5 = this.selectionRegistrar.getSubselections().get(v4.previous().getSelectableId());
                        if(v5 == null) {
                            continue;
                        }

                        if(((Selection)v5).getStart().getOffset() == ((Selection)v5).getEnd().getOffset()) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_33;
                    }
                }
                while(true);

                int v4_1 = v4.nextIndex();
                goto label_34;
            label_33:
                v4_1 = v6;
            label_34:
                if(v4_1 != v6) {
                    int v5_1 = v1_1.size();
                    for(v6 = 0; v6 < v5_1; ++v6) {
                        Object v7 = v1_1.get(v6);
                        Object v8 = this.selectionRegistrar.getSubselections().get(((Selectable)v7).getSelectableId());
                        if(v8 != null) {
                            AnnotatedString v9 = ((Selectable)v7).getText();
                            long v10 = TextRangeKt.TextRange(((Selection)v8).getStart().getOffset(), ((Selection)v8).getEnd().getOffset());
                            int v8_1 = v6 >= v4_1 ? 1 : 0;
                            ((Selectable)v7).getSelectableId();
                            v0.append(v9, TextRange.getMin-impl(v10), TextRange.getMax-impl(v10));
                            if(v8_1 != 0) {
                                goto label_62;
                            }

                            v0.append('\n');
                        }

                    label_62:
                    }
                }

                return v0.toAnnotatedString();
            }
        }

        return ((AnnotatedString)v1);
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    private final SelectionLayout getSelectionLayout-Wko1d7g(long arg14, long arg16, boolean arg18) {
        LayoutCoordinates v5 = this.requireContainerCoordinates$foundation();
        List v10 = this.selectionRegistrar.sort(v5);
        MutableLongIntMap v0 = LongIntMapKt.mutableLongIntMapOf();
        List v11 = v10;
        int v1 = ((Collection)v11).size();
        int v12 = 0;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.set(v10.get(v2).getSelectableId(), v2);
        }

        SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1 v8 = new SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1(v0);
        Selection v13 = (arg16 & 0x7FFFFFFF7FFFFFFFL) == 0x7FC000007FC00000L ? null : this.getSelection();
        SelectionLayoutBuilder v0_1 = new SelectionLayoutBuilder(arg14, arg16, v5, arg18, v13, ((Comparator)v8), null);
        int v13_1 = ((Collection)v11).size();
        while(v12 < v13_1) {
            v10.get(v12).appendSelectableInfoToBuilder(v0_1);
            ++v12;
        }

        return v0_1.build();
    }

    private final boolean getShouldShowMagnifier() {
        if((this.isDraggingInProgress()) && (this.isInTouchMode()) && !this.isTriviallyCollapsedSelection$foundation()) {
            return 1;
        }

        return 0;
    }

    public final boolean getShowToolbar$foundation() {
        return this.showToolbar;
    }

    public final float getStartHandleLineHeight() {
        Selection v0 = this.getSelection();
        if(v0 == null) {
            return 0;
        }

        Selectable v3 = this.getAnchorSelectable$foundation(v0.getStart());
        if(v3 == null) {
            return 0;
        }

        return v3.getLineHeight(v0.getStart().getOffset());
    }

    public final Offset getStartHandlePosition-_m7T9-E() {
        return this.startHandlePosition$delegate.getValue();
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final ToolbarRequester getToolbarRequester$foundation() {
        return this.toolbarRequester;
    }

    public static void getToolbarRequester$foundation$annotations() {
    }

    public final TextDragObserver handleDragObserver(boolean arg2) {
        return new SelectionManager$handleDragObserver$1(arg2, this);
    }

    private final boolean isDraggingInProgress() {
        if(this.getDraggingHandle() != null) {
            return 1;
        }

        return 0;
    }

    public final boolean isEntireContainerSelected$foundation() {
        List v0 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        if(v0.isEmpty()) {
            return 1;
        }

        int v1 = v0.size();
        int v4;
        for(v4 = 0; true; ++v4) {
            if(v4 >= v1) {
                return 1;
            }

            Object v5 = v0.get(v4);
            AnnotatedString v6 = ((Selectable)v5).getText();
            if(v6.length() == 0) {
            }
            else {
                v5 = this.selectionRegistrar.getSubselections().get(((Selectable)v5).getSelectableId());
                if(v5 == null) {
                }
                else if(Math.abs(((Selection)v5).getStart().getOffset() - ((Selection)v5).getEnd().getOffset()) == v6.length()) {
                    goto label_32;
                }

                return 0;
            }

        label_32:
        }

        return 0;
    }

    public final boolean isInTouchMode() {
        return this._isInTouchMode.getValue().booleanValue();
    }

    public final boolean isNonEmptySelection$foundation() {
        Selection v0 = this.getSelection();
        if(v0 == null) {
            return 0;
        }

        if(Intrinsics.areEqual(v0.getStart(), v0.getEnd())) {
            return 0;
        }

        if(Long.compare(v0.getStart().getSelectableId(), v0.getEnd().getSelectableId()) == 0) {
            return 1;
        }

        List v0_1 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        int v3 = v0_1.size();
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            Object v5 = this.selectionRegistrar.getSubselections().get(v0_1.get(v4).getSelectableId());
            if(v5 != null && ((Selection)v5).getStart().getOffset() != ((Selection)v5).getEnd().getOffset()) {
                return 1;
            }
        }

        return 0;
    }

    public final boolean isTriviallyCollapsedSelection$foundation() {
        Selection v1 = this.getSelection();
        if(v1 == null) {
            return 1;
        }

        return Intrinsics.areEqual(v1.getStart(), v1.getEnd());
    }

    private final Modifier onClearSelectionRequested(Modifier arg3, Function0 arg4) {
        return SuspendingPointerInputFilterKt.pointerInput(arg3, Unit.INSTANCE, new SelectionManager$onClearSelectionRequested$1(this, arg4));
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(LongObjectMapKt.emptyLongObjectMap());
        this.setShowToolbar$foundation(false);
        if(this.getSelection() != null) {
            this.onSelectionChange.invoke(null);
            if(this.isInTouchMode()) {
                HapticFeedback v2 = this.hapticFeedBack;
                if(v2 != null) {
                    v2.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                }
            }
        }
    }

    static final Unit onSelectionChange$lambda$0(SelectionManager arg0, Selection arg1) {
        arg0.setSelection(arg1);
        return Unit.INSTANCE;
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation() {
        LayoutCoordinates v1 = this.containerLayoutCoordinates;
        if(v1 != null) {
            if(!v1.isAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("unattached coordinates");
            }

            return v1;
        }

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null coordinates");
        throw new KotlinNothingValueException();
    }

    public final void selectAll$foundation() {
        List v0 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        if(v0.isEmpty()) {
        }
        else {
            MutableLongObjectMap v1 = LongObjectMapKt.mutableLongObjectMapOf();
            int v2 = v0.size();
            SelectionLayout v4 = null;
            int v5 = 0;
            Selection v6 = ((Selection)v4);
            Selection v7 = v6;
            while(v5 < v2) {
                Object v8 = v0.get(v5);
                Selection v9 = ((Selectable)v8).getSelectAllSelection();
                if(v9 == null) {
                }
                else {
                    if(v6 == null) {
                        v6 = v9;
                    }

                    v1.put(((Selectable)v8).getSelectableId(), v9);
                    v7 = v9;
                }

                ++v5;
            }

            if(v1.isEmpty()) {
                return;
            }

            if(v6 == v7) {
            }
            else {
                Intrinsics.checkNotNull(v6);
                AnchorInfo v2_1 = v6.getStart();
                Intrinsics.checkNotNull(v7);
                v6 = new Selection(v2_1, v7.getEnd(), false);
            }

            this.selectionRegistrar.setSubselections(((LongObjectMap)v1));
            this.onSelectionChange.invoke(v6);
            this.previousSelectionLayout = v4;
            return;
        }
    }

    public final Pair selectAllInSelectable$foundation(long arg11, Selection arg13) {
        MutableLongObjectMap v0 = LongObjectMapKt.mutableLongObjectMapOf();
        List v1 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        int v2 = v1.size();
        Selection v3 = null;
        int v4 = 0;
        Selection v5 = v3;
        while(v4 < v2) {
            Object v6 = v1.get(v4);
            Selection v7 = ((Selectable)v6).getSelectableId() == arg11 ? ((Selectable)v6).getSelectAllSelection() : v3;
            if(v7 != null) {
                v0.set(((Selectable)v6).getSelectableId(), v7);
            }

            v5 = SelectionManagerKt.merge(v5, v7);
            ++v4;
        }

        if((this.isInTouchMode()) && !Intrinsics.areEqual(v5, arg13)) {
            HapticFeedback v10 = this.hapticFeedBack;
            if(v10 != null) {
                v10.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
            }
        }

        return new Pair(v5, v0);
    }

    public final void selectWordAtPositionIfNotAlreadySelected-k-4lQ0M(long arg12) {
        TextLayoutResult v5_1;
        long v7_1;
        LayoutCoordinates v0 = this.containerLayoutCoordinates;
        if(v0 == null) {
        }
        else {
            if(!v0.isAttached()) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        List v1 = this.selectionRegistrar.getSelectables$foundation();
        int v2 = v1.size();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v1.get(v4);
            Object v6 = this.selectionRegistrar.getSubselections().get(((Selectable)v5).getSelectableId());
            if(v6 != null) {
                LayoutCoordinates v7 = ((Selectable)v5).getLayoutCoordinates();
                if(v7 == null) {
                    goto label_19;
                }
                else {
                    v7_1 = v7.localPositionOf-R5De75A(v0, arg12);
                    v5_1 = ((Selectable)v5).textLayoutResult();
                    if(v5_1 == null) {
                        goto label_19;
                    }
                    else {
                        goto label_28;
                    }
                }
            }
            else {
            label_19:
                boolean v5_2 = false;
                goto label_31;
            label_28:
                v5_2 = TextLayoutHelperKt.isPositionInsideSelection-uaM50fQ(v5_1, v7_1, TextRange.box-impl(((Selection)v6).toTextRange-d9O1mEE()));
            }

        label_31:
            if(v5_2) {
                return;
            }
        }

        this.startSelection-9KIMszo(arg12, true, SelectionAdjustment.Companion.getWord());
    }

    private final void selectionChanged(SelectionLayout arg3, Selection arg4) {
        if(this.shouldPerformHaptics$foundation()) {
            HapticFeedback v0 = this.hapticFeedBack;
            if(v0 != null) {
                v0.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
            }
        }

        this.selectionRegistrar.setSubselections(arg3.createSubSelections(arg4));
        this.onSelectionChange.invoke(arg4);
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates arg3) {
        Offset v3;
        this.containerLayoutCoordinates = arg3;
        if((this.getHasFocus()) && this.getSelection() != null) {
            if(arg3 != null) {
                v3 = Offset.box-impl(LayoutCoordinatesKt.positionInWindow(arg3));
            }
            else {
                Object v3_1 = null;
            }

            if(Intrinsics.areEqual(this.previousPosition, v3)) {
                return;
            }

            this.previousPosition = v3;
            this.updateHandleOffsets();
            this.updateSelectionToolbar();
        }
    }

    public final void setCoroutineScope$foundation(CoroutineScope arg1) {
        this.coroutineScope = arg1;
    }

    private final void setCurrentDragPosition-_kEHs6E(Offset arg1) {
        this.currentDragPosition$delegate.setValue(arg1);
    }

    private final void setDragBeginPosition-k-4lQ0M(long arg1) {
        this.dragBeginPosition$delegate.setValue(Offset.box-impl(arg1));
    }

    private final void setDragTotalDistance-k-4lQ0M(long arg1) {
        this.dragTotalDistance$delegate.setValue(Offset.box-impl(arg1));
    }

    private final void setDraggingHandle(Handle arg1) {
        this.draggingHandle$delegate.setValue(arg1);
    }

    private final void setEndHandlePosition-_kEHs6E(Offset arg1) {
        this.endHandlePosition$delegate.setValue(arg1);
    }

    public final void setFocusRequester(FocusRequester arg1) {
        this.focusRequester = arg1;
    }

    public final void setHapticFeedBack(HapticFeedback arg1) {
        this.hapticFeedBack = arg1;
    }

    public final void setHasFocus(boolean arg1) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setInTouchMode(boolean arg2) {
        if(this._isInTouchMode.getValue().booleanValue() != arg2) {
            this._isInTouchMode.setValue(Boolean.valueOf(arg2));
            this.updateSelectionToolbar();
        }
    }

    public final void setOnCopyHandler(Function1 arg1) {
        this.onCopyHandler = arg1;
    }

    public final void setOnSelectionChange(Function1 arg2) {
        this.onSelectionChange = new SelectionManager$$ExternalSyntheticLambda5(this, arg2);
    }

    public final void setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors arg1) {
        this.platformSelectionBehaviors = arg1;
    }

    private final void setPositionChangeState(Unit arg1) {
        this.positionChangeState$delegate.setValue(arg1);
    }

    public final void setPreviousSelectionLayout$foundation(SelectionLayout arg1) {
        this.previousSelectionLayout = arg1;
    }

    public final void setSelection(Selection arg2) {
        this._selection.setValue(arg2);
        if(arg2 != null) {
            this.updateHandleOffsets();
        }
    }

    public final void setShowToolbar$foundation(boolean arg1) {
        this.showToolbar = arg1;
        this.updateSelectionToolbar();
    }

    private final void setStartHandlePosition-_kEHs6E(Offset arg1) {
        this.startHandlePosition$delegate.setValue(arg1);
    }

    public final void setTextToolbar(TextToolbar arg1) {
        this.textToolbar = arg1;
    }

    public final void setToolbarRequester$foundation(ToolbarRequester arg1) {
        this.toolbarRequester = arg1;
    }

    public final boolean shouldPerformHaptics$foundation() {
        if(this.isInTouchMode()) {
            List v4 = this.selectionRegistrar.getSelectables$foundation();
            int v0 = v4.size();
            int v2 = 0;
            while(v2 < v0) {
                if(v4.get(v2).getText().length() > 0) {
                    return 1;
                }
                else {
                    ++v2;
                    continue;
                }

                return 0;
            }
        }

        return 0;
    }

    private final void startSelection-9KIMszo(long arg9, boolean arg11, SelectionAdjustment arg12) {
        this.previousSelectionLayout = null;
        this.updateSelection-jyLRC_s$foundation(arg9, Offset.Companion.getUnspecified-F1C5BW0(), arg11, arg12);
    }

    private final void suggestSelectionForLongPressOrDoubleClick() {
        int v6;
        ObjectRef v2 = new ObjectRef();
        ObjectRef v3 = new ObjectRef();
        LongRef v4 = new LongRef();
        List v0 = this.selectionRegistrar.sort(this.requireContainerCoordinates$foundation());
        ListIterator v1 = v0.listIterator(v0.size());
        do {
            v6 = -1;
            if(v1.hasPrevious()) {
                Object v5 = this.selectionRegistrar.getSubselections().get(v1.previous().getSelectableId());
                if(v5 == null) {
                    continue;
                }

                if(((Selection)v5).getStart().getOffset() == ((Selection)v5).getEnd().getOffset()) {
                    continue;
                }

                break;
            }
            else {
                goto label_27;
            }
        }
        while(true);

        int v1_1 = v1.nextIndex();
        goto label_28;
    label_27:
        v1_1 = v6;
    label_28:
        if(v1_1 != v6) {
            int v5_1 = v0.size();
            v6 = 0;
            int v7 = 0;
            while(v7 < v5_1) {
                Object v8 = v0.get(v7);
                Object v9 = this.selectionRegistrar.getSubselections().get(((Selectable)v8).getSelectableId());
                if(v9 != null) {
                    AnnotatedString v0_1 = ((Selectable)v8).getText();
                    long v9_1 = TextRangeKt.TextRange(((Selection)v9).getStart().getOffset(), ((Selection)v9).getEnd().getOffset());
                    if(v7 >= v1_1) {
                        v6 = 1;
                    }

                    long v7_1 = ((Selectable)v8).getSelectableId();
                    if(v6 == 0) {
                        break;
                    }

                    v2.element = v0_1;
                    v3.element = TextRange.box-impl(v9_1);
                    v4.element = v7_1;
                }
                else {
                    ++v7;
                    continue;
                }

                break;
            }
        }

        if(v2.element != null && v3.element != null && v4.element != 0 && v2.element.length() > 0) {
            CoroutineScope v6_1 = this.coroutineScope;
            if(v6_1 != null) {
                BuildersKt.launch$default(v6_1, null, null, new SelectionManager$suggestSelectionForLongPressOrDoubleClick$2(this, v2, v3, v4, null), 3, null);
            }
        }
    }

    private final void toolbarCopy() {
        this.copy$foundation();
        this.onRelease();
    }

    private final void updateHandleOffsets() {
        Offset v4_2;
        Selectable v5_1;
        Selectable v4_1;
        SelectionManager v0 = this;
        Selection v1 = v0.getSelection();
        LayoutCoordinates v2 = v0.containerLayoutCoordinates;
        Offset v3 = null;
        if(v1 != null) {
            AnchorInfo v4 = v1.getStart();
            if(v4 != null) {
                v4_1 = v0.getAnchorSelectable$foundation(v4);
            }
            else {
                goto label_9;
            }
        }
        else {
        label_9:
            v4_1 = ((Selectable)v3);
        }

        if(v1 != null) {
            AnchorInfo v5 = v1.getEnd();
            if(v5 != null) {
                v5_1 = v0.getAnchorSelectable$foundation(v5);
            }
            else {
                goto label_15;
            }
        }
        else {
        label_15:
            v5_1 = ((Selectable)v3);
        }

        LayoutCoordinates v6 = v4_1 != null ? v4_1.getLayoutCoordinates() : ((LayoutCoordinates)v3);
        LayoutCoordinates v7 = v5_1 != null ? v5_1.getLayoutCoordinates() : ((LayoutCoordinates)v3);
        if(v1 != null && v2 != null && (v2.isAttached()) && (v6 != null || v7 != null)) {
            Rect v8 = SelectionManagerKt.visibleBounds(v2);
            long v9 = 0x7FC000007FC00000L;
            long v11 = 0x7FFFFFFF7FFFFFFFL;
            if(v6 != null) {
                long v13 = v4_1.getHandlePosition-dBAh8RU(v1, true);
                if((v13 & v11) == v9) {
                    goto label_49;
                }
                else {
                    v4_2 = Offset.box-impl(v2.localPositionOf-R5De75A(v6, v13));
                    v13 = v4_2.unbox-impl();
                    if(v0.getDraggingHandle() != Handle.SelectionStart) {
                        if(SelectionManagerKt.containsInclusive-Uv8p0NA(v8, v13)) {
                        }
                        else {
                            goto label_49;
                        }
                    }
                }
            }
            else {
            label_49:
                v4_2 = v3;
            }

            v0.setStartHandlePosition-_kEHs6E(v4_2);
            if(v7 != null) {
                long v4_3 = v5_1.getHandlePosition-dBAh8RU(v1, false);
                if((v11 & v4_3) == v9) {
                }
                else {
                    Offset v1_1 = Offset.box-impl(v2.localPositionOf-R5De75A(v7, v4_3));
                    v4_3 = v1_1.unbox-impl();
                    if(v0.getDraggingHandle() != Handle.SelectionEnd && !SelectionManagerKt.containsInclusive-Uv8p0NA(v8, v4_3)) {
                        goto label_66;
                    }

                    v3 = v1_1;
                }
            }

        label_66:
            v0.setEndHandlePosition-_kEHs6E(v3);
            return;
        }

        v0.setStartHandlePosition-_kEHs6E(v3);
        v0.setEndHandlePosition-_kEHs6E(v3);
    }

    public final boolean updateSelection-jyLRC_s$foundation(long arg2, long arg4, boolean arg6, SelectionAdjustment arg7) {
        Handle v0 = arg6 ? Handle.SelectionStart : Handle.SelectionEnd;
        this.setDraggingHandle(v0);
        this.setCurrentDragPosition-_kEHs6E(Offset.box-impl(arg2));
        SelectionLayout v2 = this.getSelectionLayout-Wko1d7g(arg2, arg4, arg6);
        if(v2 == null) {
            return 0;
        }

        if(!v2.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return 0;
        }

        Selection v4 = arg7.adjust(v2);
        if(!Intrinsics.areEqual(v4, this.getSelection())) {
            this.selectionChanged(v2, v4);
            this.isLongPressOrClickSelection = false;
        }

        this.previousSelectionLayout = v2;
        return 1;
    }

    public final boolean updateSelection-qNKwrvQ$foundation(Offset arg8, long arg9, boolean arg11, SelectionAdjustment arg12) {
        if(arg8 == null) {
            return 0;
        }

        return this.updateSelection-jyLRC_s$foundation(arg8.unbox-impl(), arg9, arg11, arg12);
    }

    private final void updateSelectionTextToolbar() {
        SelectionManager$updateSelectionTextToolbar$1 v2;
        TextToolbar v0 = this.textToolbar;
        if(v0 == null) {
        }
        else {
            if((this.showToolbar) && (this.isInTouchMode())) {
                Rect v1 = this.getContentRect();
                if(v1 == null) {
                    return;
                }
                else {
                    SelectionManager$updateSelectionTextToolbar$2 v3 = null;
                    if(this.canCopy$foundation()) {
                        v2 = new SelectionManager$updateSelectionTextToolbar$1(this);
                    }
                    else {
                        Function0 v2_1 = ((Function0)v3);
                    }

                    if(this.isEntireContainerSelected$foundation()) {
                    }
                    else {
                        v3 = new SelectionManager$updateSelectionTextToolbar$2(this);
                    }

                    TextToolbar.showMenu$default(v0, v1, ((Function0)v2), null, null, v3, null, 12, null);
                    return;
                }
            }

            if(v0.getStatus() != TextToolbarStatus.Shown) {
                return;
            }

            v0.hide();
        }
    }

    private final void updateSelectionToolbar() {
        if(!this.getHasFocus()) {
        }
        else if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            if((this.showToolbar) && (this.isInTouchMode())) {
                if(this.getDerivedContentRect() == null) {
                    return;
                }
                else {
                    goto label_12;
                }
            }

            goto label_15;
        }
        else {
            goto label_18;
        }

        return;
    label_12:
        this.toolbarRequester.show();
        return;
    label_15:
        this.toolbarRequester.hide();
        return;
    label_18:
        this.updateSelectionTextToolbar();
    }
}

