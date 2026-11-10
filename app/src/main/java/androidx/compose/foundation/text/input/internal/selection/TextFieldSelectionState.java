package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.content.TransferableContent$Source;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0001\u0018\u00002\u00020\u0001:\u0006ã\u0001ä\u0001å\u0001Ba\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\t\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010w\u001A\u00020x2\u0006\u0010y\u001A\u00020\tH\u0000¢\u0006\u0002\bzJ\b\u0010{\u001A\u00020\tH\u0002J\u0006\u0010|\u001A\u00020}J\u0006\u0010~\u001A\u00020}J\u001C\u0010\u007F\u001A\u00020}2\b\u0010\u0080\u0001\u001A\u00030\u0081\u00012\b\u0010\u0082\u0001\u001A\u00030\u0083\u0001H\u0002J\u001D\u0010\u0084\u0001\u001A\u00020}2\b\u0010\u0080\u0001\u001A\u00030\u0081\u00012\b\u0010\u0082\u0001\u001A\u00030\u0083\u0001H\u0002J@\u0010\u0085\u0001\u001A\u0002022\u0006\u0010#\u001A\u00020$2\u0006\u0010\u0013\u001A\u00020\u00142\u0007\u0010\u0086\u0001\u001A\u00020*2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tJ\u0015\u0010\u0087\u0001\u001A\u000202*\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J\u001E\u0010\u008A\u0001\u001A\u000202*\u00030\u0088\u00012\u0007\u0010\u008B\u0001\u001A\u00020\tH\u0086@¢\u0006\u0003\u0010\u008C\u0001J\u0010\u0010\u008D\u0001\u001A\u000202H\u0086@¢\u0006\u0003\u0010\u008E\u0001J\u000F\u0010\u008F\u0001\u001A\u0002022\u0006\u0010]\u001A\u00020\\J\u0007\u0010\u0090\u0001\u001A\u000202J\u0015\u0010\u0091\u0001\u001A\u000202*\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J?\u0010\u0092\u0001\u001A\u000202*\u00030\u0088\u00012\n\u0010\u0093\u0001\u001A\u0005\u0018\u00010\u0094\u00012\r\u0010\u0095\u0001\u001A\b\u0012\u0004\u0012\u000202012\r\u0010\u0096\u0001\u001A\b\u0012\u0004\u0012\u00020201H\u0086@¢\u0006\u0003\u0010\u0097\u0001J\u0019\u0010\u0098\u0001\u001A\u00020\t2\u0007\u0010\u0099\u0001\u001A\u00020;¢\u0006\u0006\b\u009A\u0001\u0010\u009B\u0001J\u0015\u0010\u009C\u0001\u001A\u000202*\u00030\u0088\u0001H\u0082@¢\u0006\u0003\u0010\u0089\u0001J$\u0010\u009D\u0001\u001A\u000202*\u00030\u0088\u00012\r\u0010\u0095\u0001\u001A\b\u0012\u0004\u0012\u00020201H\u0086@¢\u0006\u0003\u0010\u009E\u0001J\u0007\u0010\u009F\u0001\u001A\u000202J\u001E\u0010 \u0001\u001A\u000202*\u00030\u0088\u00012\u0007\u0010\u008B\u0001\u001A\u00020\tH\u0082@¢\u0006\u0003\u0010\u008C\u0001J\u0010\u0010¡\u0001\u001A\u000202H\u0082@¢\u0006\u0003\u0010\u008E\u0001J\u0010\u0010¢\u0001\u001A\u000202H\u0082@¢\u0006\u0003\u0010\u008E\u0001J\t\u0010¨\u0001\u001A\u00020}H\u0002J \u0010©\u0001\u001A\u00020x2\u0007\u0010\u008B\u0001\u001A\u00020\t2\u0006\u0010y\u001A\u00020\tH\u0000¢\u0006\u0003\bª\u0001J\u001B\u0010«\u0001\u001A\u00020;2\u0007\u0010\u008B\u0001\u001A\u00020\tH\u0002¢\u0006\u0006\b¬\u0001\u0010­\u0001J\"\u0010®\u0001\u001A\u0002022\u0007\u0010¯\u0001\u001A\u00020J2\u0007\u0010°\u0001\u001A\u00020;¢\u0006\u0006\b±\u0001\u0010²\u0001J\t\u0010³\u0001\u001A\u000202H\u0002J\u0007\u0010´\u0001\u001A\u000202J\u0007\u0010µ\u0001\u001A\u00020\tJ\n\u0010¶\u0001\u001A\u00020\tH\u0086\bJ\u0010\u0010·\u0001\u001A\u000202H\u0086@¢\u0006\u0003\u0010\u008E\u0001J\n\u0010¸\u0001\u001A\u0005\u0018\u00010¹\u0001J\u0007\u0010º\u0001\u001A\u00020\tJ\n\u0010»\u0001\u001A\u00020\tH\u0086\bJ\u001B\u0010¼\u0001\u001A\u0002022\t\b\u0002\u0010½\u0001\u001A\u00020\tH\u0086@¢\u0006\u0003\u0010¾\u0001J\u001D\u0010¿\u0001\u001A\u0005\u0018\u00010¹\u00012\t\b\u0002\u0010½\u0001\u001A\u00020\tH\u0000¢\u0006\u0003\bÀ\u0001J\u0010\u0010Ã\u0001\u001A\u000202H\u0086@¢\u0006\u0003\u0010\u008E\u0001J\u0007\u0010Ä\u0001\u001A\u00020\tJ\n\u0010Å\u0001\u001A\u00020\tH\u0086\bJ\u0010\u0010Æ\u0001\u001A\u000202H\u0086@¢\u0006\u0003\u0010\u008E\u0001J\u0010\u0010Ç\u0001\u001A\u000202H\u0082@¢\u0006\u0003\u0010\u008E\u0001J\u0018\u0010È\u0001\u001A\u0002022\u0007\u0010 \u001A\u00030¹\u0001H\u0000¢\u0006\u0003\bÉ\u0001J\u0007\u0010Ê\u0001\u001A\u00020\tJ\u0007\u0010Ë\u0001\u001A\u000202J\u0007\u0010Ì\u0001\u001A\u00020\tJ\u0007\u0010Í\u0001\u001A\u000202J\u0019\u0010\u0086\u0001\u001A\u0002022\u0007\u0010Î\u0001\u001A\u00020}H\u0082@¢\u0006\u0003\u0010Ï\u0001J\u0007\u0010Ð\u0001\u001A\u000202J\t\u0010Ñ\u0001\u001A\u000202H\u0002JX\u0010Ò\u0001\u001A\u00030Ó\u00012\b\u0010Ô\u0001\u001A\u00030\u0083\u00012\u0007\u0010Õ\u0001\u001A\u00020p2\u0007\u0010Ö\u0001\u001A\u00020p2\u0007\u0010\u008B\u0001\u001A\u00020\t2\b\u0010×\u0001\u001A\u00030Ø\u00012\t\b\u0002\u0010Ù\u0001\u001A\u00020\t2\t\b\u0002\u0010Ú\u0001\u001A\u00020\tH\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001JD\u0010Ý\u0001\u001A\u00030Ó\u00012\u0007\u0010Þ\u0001\u001A\u00020p2\u0007\u0010ß\u0001\u001A\u00020p2\n\u0010à\u0001\u001A\u0005\u0018\u00010Ó\u00012\u0007\u0010\u008B\u0001\u001A\u00020\t2\b\u0010×\u0001\u001A\u00030Ø\u0001H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u000E\u0010\f\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\b\u001A\u00020\t2\u0006\u0010 \u001A\u00020\t@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001BR\u001E\u0010\n\u001A\u00020\t2\u0006\u0010 \u001A\u00020\t@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u001BR\u001C\u0010#\u001A\u0004\u0018\u00010$X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0010\u0010)\u001A\u0004\u0018\u00010*X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010,\u001A\u00020\t2\u0006\u0010+\u001A\u00020\t8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b,\u0010\u001B\"\u0004\b-\u0010\u001DR\"\u00100\u001A\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001A\f\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u000101X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u00104\"\u0004\b:\u00106R+\u0010<\u001A\u00020;2\u0006\u0010+\u001A\u00020;8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bA\u0010/\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010B\u001A\u00020;8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bC\u0010>R+\u0010D\u001A\u00020;2\u0006\u0010+\u001A\u00020;8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bG\u0010/\u001A\u0004\bE\u0010>\"\u0004\bF\u0010@R\u0011\u0010H\u001A\u00020;8F¢\u0006\u0006\u001A\u0004\bI\u0010>R/\u0010K\u001A\u0004\u0018\u00010J2\b\u0010+\u001A\u0004\u0018\u00010J8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bP\u0010/\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR+\u0010R\u001A\u00020Q2\u0006\u0010+\u001A\u00020Q8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bW\u0010/\u001A\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010X\u001A\u00020\t2\u0006\u0010+\u001A\u00020\t8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b[\u0010/\u001A\u0004\bY\u0010\u001B\"\u0004\bZ\u0010\u001DR+\u0010]\u001A\u00020\\2\u0006\u0010+\u001A\u00020\\8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bb\u0010/\u001A\u0004\b^\u0010_\"\u0004\b`\u0010aR+\u0010c\u001A\u00020\t2\u0006\u0010+\u001A\u00020\t8F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bf\u0010/\u001A\u0004\bd\u0010\u001B\"\u0004\be\u0010\u001DR\u0016\u0010g\u001A\u0004\u0018\u00010h8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bi\u0010jR\u0014\u0010k\u001A\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bl\u0010\u001BR\u0010\u0010m\u001A\u0004\u0018\u00010nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010o\u001A\u00020pX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010q\u001A\u0004\u0018\u00010rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010£\u0001\u001A\u0004\u0018\u00010}8@X\u0080\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001A\u0006\b¤\u0001\u0010¥\u0001R\u0010\u0010Á\u0001\u001A\u00030Â\u0001X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006æ\u0001"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZLandroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;Landroidx/compose/ui/platform/Clipboard;)V", "getTextFieldState$foundation", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextLayoutState$foundation", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "()Z", "setFocused", "(Z)V", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "value", "getEnabled", "getReadOnly", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "textToolbarHandler", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "<set-?>", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestAutofillAction", "Lkotlin/Function0;", "", "getRequestAutofillAction", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction", "(Lkotlin/jvm/functions/Function0;)V", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "setReceiveContentConfiguration", "Landroidx/compose/ui/geometry/Offset;", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "()J", "setStartTextLayoutPositionInWindow-k-4lQ0M", "(J)V", "startTextLayoutPositionInWindow$delegate", "currentTextLayoutPositionInWindow", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "rawHandleDragPosition$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "textToolbarShown", "getTextToolbarShown", "setTextToolbarShown$foundation", "textToolbarShown$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "editable", "getEditable$foundation", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousRawDragOffset", "", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getPressInteraction", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "setPressInteraction", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation", "isCursorHandleInVisibleBounds", "getCursorRect", "Landroidx/compose/ui/geometry/Rect;", "getFocusRect", "calculateCursorRect", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "calculateSelectionRect", "update", "showTextToolbar", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionHandleGestures", "isStartHandle", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startToolbarAndHandlesVisibilityObserver", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTextToolbarState", "dispose", "detectTouchMode", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeCursorAtNearestOffset", "offset", "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "detectCursorHandleDragGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maybeSuggestSelectionRange", "detectSelectionHandleDragGestures", "observeTextChanges", "observeTextToolbarVisibility", "derivedVisibleContentBounds", "getDerivedVisibleContentBounds$foundation", "()Landroidx/compose/ui/geometry/Rect;", "derivedVisibleContentBounds$delegate", "Landroidx/compose/runtime/State;", "getContentRect", "getSelectionHandleState", "getSelectionHandleState$foundation", "getHandlePosition", "getHandlePosition-tuRUvjQ", "(Z)J", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "markStartContentVisibleOffset", "clearHandleDragging", "canShowCutMenuItem", "isCutAllowed", "cut", "cutWithResult", "Landroidx/compose/ui/text/AnnotatedString;", "canShowCopyMenuItem", "isCopyAllowed", "copy", "cancelSelection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyWithResult", "copyWithResult$foundation", "clipboardPasteState", "Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "updateClipboardEntry", "canShowPasteMenuItem", "isPasteAllowed", "paste", "pasteAsPlainText", "onPasteEvent", "onPasteEvent$foundation", "canShowSelectAllMenuItem", "selectAll", "canShowAutofillMenuItem", "autofill", "contentRect", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deselect", "hideTextToolbar", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "textFieldCharSequence", "startOffset", "endOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8$foundation", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "getTextFieldSelection", "rawStartOffset", "rawEndOffset", "previousSelection", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldSelectionState {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum InputType {
        public static final enum InputType Mouse;
        public static final enum InputType None;
        public static final enum InputType Touch;

        private static final InputType[] $values() {
            return new InputType[]{InputType.None, InputType.Touch, InputType.Mouse};
        }

        static {
            InputType.None = new InputType("None", 0);
            InputType.Touch = new InputType("Touch", 1);
            InputType.Mouse = new InputType("Mouse", 2);
            InputType[] v0 = InputType.$values();
            InputType.$VALUES = v0;
            InputType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private InputType(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return InputType.$ENTRIES;
        }

        public static InputType valueOf(String arg1) {
            return Enum.valueOf(InputType.class, arg1);
        }

        public static InputType[] values() {
            return InputType.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\rH\u0002¢\u0006\u0004\b\u001E\u0010\u001FJ\b\u0010 \u001A\u00020\u0004H\u0016J\u0017\u0010!\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\nH\u0016¢\u0006\u0004\b%\u0010#R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "isDoubleOrTripleClickOnly", "", "onStart", "downPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "clickCount", "onStart-9KIMszo", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;I)Z", "onDrag", "dragPosition", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isStartOfSelection", "updateSelection-12glfjA", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/ui/text/TextLayoutResult;Z)J", "onDragDone", "onExtend", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText;
        private long dragBeginPosition;
        private boolean isDoubleOrTripleClickOnly;
        private final Function0 requestFocus;

        public TextFieldMouseSelectionObserver(TextFieldSelectionState arg1, Function0 arg2) {
            TextFieldSelectionState.this = arg1;
            super();
            this.requestFocus = arg2;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
            this.isDoubleOrTripleClickOnly = true;
        }

        public boolean onDrag-3MmeM6k(long arg11, SelectionAdjustment arg13) {
            TextLayoutResult v5 = TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult();
            if((TextFieldSelectionState.this.getEnabled()) && v5 != null) {
                if(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                }
                else {
                    TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda4(arg11));
                    TextFieldMouseSelectionObserver v1 = this;
                    if(!TextRange.equals-impl0(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE(), v1.updateSelection-12glfjA(arg11, arg13, v5, false))) {
                        v1.isDoubleOrTripleClickOnly = false;
                    }

                    return 1;
                }
            }

            return 0;
        }

        public void onDragDone() {
            TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda2());
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
            if(this.isDoubleOrTripleClickOnly) {
                TextFieldSelectionState.this.maybeSuggestSelectionRange();
            }
        }

        static final String onDragDone$lambda$0() {
            return "Mouse.onDragDone";
        }

        static final String onDrag_3MmeM6k$lambda$0(long arg2) {
            return "Mouse.onDrag " + Offset.toString-impl(arg2);
        }

        public boolean onExtend-k-4lQ0M(long arg8) {
            TextLayoutResult v5 = TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult();
            if((TextFieldSelectionState.this.getEnabled()) && v5 != null) {
                if(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                }
                else {
                    TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda1());
                    this.isDoubleOrTripleClickOnly = false;
                    this.requestFocus.invoke();
                    this.updateSelection-12glfjA(arg8, SelectionAdjustment.Companion.getNone(), v5, false);
                    return 1;
                }
            }

            return 0;
        }

        public boolean onExtendDrag-k-4lQ0M(long arg1) {
            TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda0());
            return 1;
        }

        static final String onExtendDrag_k_4lQ0M$lambda$0() {
            return "Mouse.onExtendDrag";
        }

        static final String onExtend_k_4lQ0M$lambda$0() {
            return "Mouse.onExtend";
        }

        public boolean onStart-9KIMszo(long arg9, SelectionAdjustment arg11, int arg12) {
            TextLayoutResult v5 = TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult();
            boolean v1 = false;
            if((TextFieldSelectionState.this.getEnabled()) && v5 != null) {
                if(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                }
                else {
                    if(arg12 >= 2) {
                        v1 = true;
                    }

                    this.isDoubleOrTripleClickOnly = v1;
                    TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda3());
                    TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
                    this.requestFocus.invoke();
                    TextFieldSelectionState.this.previousRawDragOffset = -1;
                    this.dragBeginOffsetInText = -1;
                    this.dragBeginPosition = arg9;
                    this.dragBeginOffsetInText = TextRange.getStart-impl(this.updateSelection-12glfjA(arg9, arg11, v5, true));
                    return 1;
                }
            }

            return 0;
        }

        static final String onStart_9KIMszo$lambda$0() {
            return "Mouse.onStart";
        }

        private final long updateSelection-12glfjA(long arg11, SelectionAdjustment arg13, TextLayoutResult arg14, boolean arg15) {
            int v14 = arg14.getLayoutInput().getText().length();
            int v0 = this.dragBeginOffsetInText;
            if(v0 < 0 || v0 > v14) {
                v0 = TextFieldSelectionState.this.getTextLayoutState$foundation().getOffsetForPosition-3MmeM6k(this.dragBeginPosition, false);
            }
            else {
            }

            arg11 = TextFieldSelectionState.this.updateSelection-SsL-Rf8$foundation(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText(), v0, TextFieldSelectionState.this.getTextLayoutState$foundation().getOffsetForPosition-3MmeM6k(arg11, false), false, arg13, false, arg15);
            if(this.dragBeginOffsetInText == -1 && !TextRange.getCollapsed-impl(arg11)) {
                this.dragBeginOffsetInText = TextRange.getStart-impl(arg11);
            }

            if(TextRange.getReversed-impl(arg11)) {
                arg11 = TextFieldSelectionStateKt.access$reverse-5zc-tL8(arg11);
            }

            TextFieldSelectionState.this.getTextFieldState$foundation().selectCharsIn-5zc-tL8(arg11);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return arg11;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001A\u00020\u0004H\u0002J\u0017\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001A\u00020\u0004H\u0016J\b\u0010\u0019\u001A\u00020\u0004H\u0016J\b\u0010\u001A\u001A\u00020\u0004H\u0016J\u001F\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010 \u001A\u00020\u00042\u0006\u0010!\u001A\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u0017R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000BR\u0010\u0010\f\u001A\u00020\nX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000BR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "isLongPressSelectionOnly", "", "selectionAdjustmentMode", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDragStop", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onUp", "onStop", "onCancel", "onStart", "startPoint", "selectionAdjustment", "onStart-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "onDrag", "delta", "onDrag-k-4lQ0M", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextFieldTextDragObserver implements TextDragObserver {
        private Handle actingHandle;
        private int dragBeginOffsetInText;
        private long dragBeginPosition;
        private long dragTotalDistance;
        private boolean isLongPressSelectionOnly;
        private final Function0 requestFocus;
        private SelectionAdjustment selectionAdjustmentMode;

        public TextFieldTextDragObserver(TextFieldSelectionState arg1, Function0 arg2) {
            TextFieldSelectionState.this = arg1;
            super();
            this.requestFocus = arg2;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
            this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
            this.actingHandle = Handle.SelectionEnd;
            this.isLongPressSelectionOnly = true;
            this.selectionAdjustmentMode = SelectionAdjustment.Companion.getNone();
        }

        public void onCancel() {
            this.onDragStop();
        }

        public void onDown-k-4lQ0M(long arg1) {
        }

        public void onDrag-k-4lQ0M(long arg20) {
            Handle v1_3;
            SelectionAdjustment v4;
            int v3;
            int v1_1;
            TextFieldTextDragObserver v0 = this;
            if((v0.this$0.getEnabled()) && v0.this$0.getTextLayoutState$foundation().getLayoutResult() != null) {
                if(v0.this$0.getTextFieldState$foundation().getVisualText().length() == 0) {
                    return;
                }
                else {
                    long v1 = Offset.plus-MK-Hz9U(v0.dragTotalDistance, arg20);
                    v0.dragTotalDistance = v1;
                    long v6 = Offset.plus-MK-Hz9U(v0.dragBeginPosition, v1);
                    TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldTextDragObserver$$ExternalSyntheticLambda0(v6));
                    if(v0.dragBeginOffsetInText >= 0 || (v0.this$0.getTextLayoutState$foundation().isPositionOnText-k-4lQ0M(v6))) {
                        Integer v1_2 = Integer.valueOf(v0.dragBeginOffsetInText);
                        if(v1_2.intValue() >= 0) {
                        }
                        else {
                            v1_2 = null;
                        }

                        v1_1 = v1_2 != null ? v1_2.intValue() : v0.this$0.getTextLayoutState$foundation().getOffsetForPosition-3MmeM6k(v0.dragBeginPosition, false);
                        v3 = v0.this$0.getTextLayoutState$foundation().getOffsetForPosition-3MmeM6k(v6, false);
                        if(v0.dragBeginOffsetInText < 0 && v1_1 == v3) {
                            return;
                        }

                        v4 = v0.selectionAdjustmentMode;
                        v0.this$0.updateTextToolbarState(TextToolbarState.Selection);
                    }
                    else {
                        v1_1 = TextLayoutState.getOffsetForPosition-3MmeM6k$default(v0.this$0.getTextLayoutState$foundation(), v0.dragBeginPosition, false, 2, null);
                        v3 = TextLayoutState.getOffsetForPosition-3MmeM6k$default(v0.this$0.getTextLayoutState$foundation(), v6, false, 2, null);
                        v4 = v1_1 == v3 ? SelectionAdjustment.Companion.getNone() : v0.selectionAdjustmentMode;
                    }

                    int v11 = v1_1;
                    int v12 = v3;
                    SelectionAdjustment v14 = v4;
                    long v3_1 = v0.this$0.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE();
                    long v8 = TextFieldSelectionState.updateSelection-SsL-Rf8$foundation$default(v0.this$0, v0.this$0.getTextFieldState$foundation().getVisualText(), v11, v12, false, v14, false, false, 0x40, null);
                    if(v0.dragBeginOffsetInText == -1 && !TextRange.getCollapsed-impl(v8)) {
                        v0.dragBeginOffsetInText = TextRange.getStart-impl(v8);
                    }

                    if(TextRange.getReversed-impl(v8)) {
                        v8 = TextFieldSelectionStateKt.access$reverse-5zc-tL8(v8);
                    }

                    if(!TextRange.equals-impl0(v8, v3_1)) {
                        if(TextRange.getStart-impl(v8) == TextRange.getStart-impl(v3_1) || TextRange.getEnd-impl(v8) != TextRange.getEnd-impl(v3_1)) {
                            if(TextRange.getStart-impl(v8) == TextRange.getStart-impl(v3_1) && TextRange.getEnd-impl(v8) != TextRange.getEnd-impl(v3_1)) {
                                v1_3 = Handle.SelectionEnd;
                                goto label_134;
                            }

                            if((((float)(TextRange.getStart-impl(v8) + TextRange.getEnd-impl(v8)))) / 2f > (((float)(TextRange.getStart-impl(v3_1) + TextRange.getEnd-impl(v3_1)))) / 2f) {
                                v1_3 = Handle.SelectionEnd;
                                goto label_134;
                            }

                            v1_3 = Handle.SelectionStart;
                        }
                        else {
                            v1_3 = Handle.SelectionStart;
                        }

                    label_134:
                        v0.actingHandle = v1_3;
                        v0.isLongPressSelectionOnly = false;
                    }

                    if((TextRange.getCollapsed-impl(v3_1)) || !TextRange.getCollapsed-impl(v8)) {
                        v0.this$0.getTextFieldState$foundation().selectCharsIn-5zc-tL8(v8);
                    }

                    v0.this$0.updateHandleDragging-Uv8p0NA(v0.actingHandle, v6);
                }
            }
        }

        private final void onDragStop() {
            if((this.dragBeginPosition & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
                TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldTextDragObserver$$ExternalSyntheticLambda2());
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
                this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                this.selectionAdjustmentMode = SelectionAdjustment.Companion.getNone();
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
                if(this.isLongPressSelectionOnly) {
                    TextFieldSelectionState.this.maybeSuggestSelectionRange();
                }
            }
        }

        static final String onDragStop$lambda$0() {
            return "Touch.onDragStop";
        }

        static final String onDrag_k_4lQ0M$lambda$0(long arg2) {
            return "Touch.onDrag at " + Offset.toString-impl(arg2);
        }

        public void onStart-3MmeM6k(long arg21, SelectionAdjustment arg23) {
            TextFieldTextDragObserver v0 = this;
            long v2 = arg21;
            if(!v0.this$0.getEnabled()) {
            }
            else {
                TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$TextFieldTextDragObserver$$ExternalSyntheticLambda1(v2));
                v0.this$0.updateHandleDragging-Uv8p0NA(v0.actingHandle, v2);
                v0.this$0.setShowCursorHandle(false);
                v0.this$0.setDirectDragGestureInitiator(InputType.Touch);
                v0.dragBeginPosition = v2;
                v0.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
                v0.this$0.previousRawDragOffset = -1;
                v0.isLongPressSelectionOnly = true;
                v0.selectionAdjustmentMode = arg23;
                if(v0.this$0.getTextLayoutState$foundation().getLayoutResult() == null) {
                    return;
                }

                goto label_34;
            }

            return;
        label_34:
            boolean v1 = v0.this$0.getTextLayoutState$foundation().isPositionOnText-k-4lQ0M(v2);
            TextFieldSelectionState v4 = v0.this$0;
            if(!v1) {
                int v1_1 = TextLayoutState.getOffsetForPosition-3MmeM6k$default(v4.getTextLayoutState$foundation(), v2, false, 2, null);
                HapticFeedback v2_1 = v0.this$0.getHapticFeedBack();
                if(v2_1 != null) {
                    v2_1.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                }

                v0.this$0.getTextFieldState$foundation().placeCursorBeforeCharAt(v1_1);
                v0.this$0.setShowCursorHandle(true);
                v0.isLongPressSelectionOnly = false;
                v0.this$0.updateTextToolbarState(TextToolbarState.Cursor);
                return;
            }

            if(v4.getTextFieldState$foundation().getVisualText().length() == 0) {
                return;
            }

            int v9 = TextLayoutState.getOffsetForPosition-3MmeM6k$default(v0.this$0.getTextLayoutState$foundation(), arg21, false, 2, null);
            long v1_2 = TextFieldSelectionState.updateSelection-SsL-Rf8$foundation$default(v0.this$0, new TextFieldCharSequence(v0.this$0.getTextFieldState$foundation().getVisualText(), TextRange.Companion.getZero-d9O1mEE(), null, null, null, null, 60, null), v9, v9, false, v0.selectionAdjustmentMode, false, false, 0x60, null);
            v0.this$0.getTextFieldState$foundation().selectCharsIn-5zc-tL8(v1_2);
            v0.this$0.updateTextToolbarState(TextToolbarState.Selection);
            v0.dragBeginOffsetInText = TextRange.getStart-impl(v1_2);
        }

        static final String onStart_3MmeM6k$lambda$0(long arg2) {
            return "Touch.onDragStart after longPress at " + Offset.toString-impl(arg2);
        }

        public void onStop() {
            this.onDragStop();
        }

        public void onUp() {
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[IndexTransformationType.values().length];
            try {
                v0[IndexTransformationType.Untransformed.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[IndexTransformationType.Deletion.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[IndexTransformationType.Insertion.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[IndexTransformationType.Replacement.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private Clipboard clipboard;
    private ClipboardPasteState clipboardPasteState;
    private final CoroutineScope coroutineScope;
    private Density density;
    private final State derivedVisibleContentBounds$delegate;
    private final MutableState directDragGestureInitiator$delegate;
    private final MutableState draggingHandle$delegate;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate;
    private boolean isPassword;
    private final PlatformSelectionBehaviors platformSelectionBehaviors;
    private Press pressInteraction;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private final MutableState rawHandleDragPosition$delegate;
    private boolean readOnly;
    private Function0 receiveContentConfiguration;
    private Function0 requestAutofillAction;
    private final MutableState showCursorHandle$delegate;
    private final MutableState startTextLayoutPositionInWindow$delegate;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbarHandler textToolbarHandler;
    private final MutableState textToolbarShown$delegate;
    private final MutableState textToolbarState$delegate;
    private final ToolbarRequester toolbarRequester;

    public static boolean $r8$lambda$9_kQI-PFxoiu5o4pm7KsR2mzK70(Rect arg0) {
        return TextFieldSelectionState.observeTextToolbarVisibility$lambda$1$0(arg0);
    }

    static {
    }

    public TextFieldSelectionState(TransformedTextFieldState arg1, TextLayoutState arg2, Density arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, ToolbarRequester arg8, CoroutineScope arg9, PlatformSelectionBehaviors arg10, Clipboard arg11) {
        super();
        this.textFieldState = arg1;
        this.textLayoutState = arg2;
        this.density = arg3;
        this.isFocused = arg6;
        this.isPassword = arg7;
        this.toolbarRequester = arg8;
        this.coroutineScope = arg9;
        this.platformSelectionBehaviors = arg10;
        this.clipboard = arg11;
        this.enabled = arg4;
        this.readOnly = arg5;
        this.isInTouchMode$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
        this.startTextLayoutPositionInWindow$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getUnspecified-F1C5BW0()), null, 2, null);
        this.rawHandleDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getUnspecified-F1C5BW0()), null, 2, null);
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.directDragGestureInitiator$delegate = SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        Boolean v1 = Boolean.valueOf(false);
        this.showCursorHandle$delegate = SnapshotStateKt.mutableStateOf$default(v1, null, 2, null);
        this.textToolbarState$delegate = SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.textToolbarShown$delegate = SnapshotStateKt.mutableStateOf$default(v1, null, 2, null);
        this.previousRawDragOffset = -1;
        this.derivedVisibleContentBounds$delegate = SnapshotStateKt.derivedStateOf(new TextFieldSelectionState$$ExternalSyntheticLambda5(this));
        this.clipboardPasteState = new ClipboardPasteState(this.clipboard);
    }

    public static final Object access$detectCursorHandleDragGestures(TextFieldSelectionState arg0, PointerInputScope arg1, Continuation arg2) {
        return arg0.detectCursorHandleDragGestures(arg1, arg2);
    }

    public static final Object access$detectSelectionHandleDragGestures(TextFieldSelectionState arg0, PointerInputScope arg1, boolean arg2, Continuation arg3) {
        return arg0.detectSelectionHandleDragGestures(arg1, arg2, arg3);
    }

    public static final long access$getHandlePosition-tuRUvjQ(TextFieldSelectionState arg0, boolean arg1) {
        return arg0.getHandlePosition-tuRUvjQ(arg1);
    }

    public static final TextToolbarState access$getTextToolbarState(TextFieldSelectionState arg0) {
        return arg0.getTextToolbarState();
    }

    public static final void access$hideTextToolbar(TextFieldSelectionState arg0) {
        arg0.hideTextToolbar();
    }

    public static final boolean access$isPassword$p(TextFieldSelectionState arg0) {
        return arg0.isPassword;
    }

    public static final void access$markStartContentVisibleOffset(TextFieldSelectionState arg0) {
        arg0.markStartContentVisibleOffset();
    }

    public static final Object access$observeTextChanges(TextFieldSelectionState arg0, Continuation arg1) {
        return arg0.observeTextChanges(arg1);
    }

    public static final Object access$observeTextToolbarVisibility(TextFieldSelectionState arg0, Continuation arg1) {
        return arg0.observeTextToolbarVisibility(arg1);
    }

    public static final Object access$pasteAsPlainText(TextFieldSelectionState arg0, Continuation arg1) {
        return arg0.pasteAsPlainText(arg1);
    }

    public static final void access$setPreviousRawDragOffset$p(TextFieldSelectionState arg0, int arg1) {
        arg0.previousRawDragOffset = arg1;
    }

    public static final void access$setTextToolbarState(TextFieldSelectionState arg0, TextToolbarState arg1) {
        arg0.setTextToolbarState(arg1);
    }

    public static final Object access$showTextToolbar(TextFieldSelectionState arg0, Rect arg1, Continuation arg2) {
        return arg0.showTextToolbar(arg1, arg2);
    }

    public final void autofill() {
        Function0 v0 = this.requestAutofillAction;
        if(v0 != null) {
            v0.invoke();
        }
    }

    private final Rect calculateCursorRect(TextLayoutResult arg6, TextFieldCharSequence arg7) {
        if(!TextRange.getCollapsed-impl(arg7.getSelection-d9O1mEE())) {
            return Rect.Companion.getZero();
        }

        Rect v7 = arg6.getCursorRect(TextRange.getStart-impl(arg7.getSelection-d9O1mEE()));
        float v5 = RangesKt.coerceAtLeast(((float)Math.floor(((double)this.density.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())))), 1f);
        float v2 = 2f;
        float v0 = arg6.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr ? v7.getLeft() + v5 / v2 : v7.getRight() - v5 / v2;
        float v1 = v5 / v2;
        float v6 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(v0, (((float)(((int)(arg6.getSize-YbymL2g() >> 0x20))))) - v1), v1);
        v5 = (((int)v5)) % 2 == 1 ? (((float)Math.floor(((double)v6)))) + 0.5f : ((float)Math.rint(((double)v6)));
        return new Rect(v5 - v1, v7.getTop(), v5 + v1, v7.getBottom());
    }

    private final Rect calculateSelectionRect(TextLayoutResult arg6, TextFieldCharSequence arg7) {
        if(TextRange.getCollapsed-impl(arg7.getSelection-d9O1mEE())) {
            return Rect.Companion.getZero();
        }

        int v5 = arg6.getLineForOffset(TextRange.getStart-impl(arg7.getSelection-d9O1mEE()));
        int v0 = arg6.getLineForOffset(TextRange.getEnd-impl(arg7.getSelection-d9O1mEE()));
        if(v5 == v0) {
            float v1 = arg6.getHorizontalPosition(TextRange.getStart-impl(arg7.getSelection-d9O1mEE()), true);
            float v7 = arg6.getHorizontalPosition(TextRange.getEnd-impl(arg7.getSelection-d9O1mEE()), true);
            return new Rect(Math.min(v1, v7), arg6.getLineTop(v5), Math.max(v1, v7), arg6.getLineBottom(v0));
        }

        return arg6.getPathForRange(TextRange.getMin-impl(arg7.getSelection-d9O1mEE()), TextRange.getMax-impl(arg7.getSelection-d9O1mEE())).getBounds();
    }

    public final boolean canShowAutofillMenuItem() {
        if((this.getEditable$foundation()) && (TextRange.getCollapsed-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE()))) {
            return 1;
        }

        return 0;
    }

    public final boolean canShowCopyMenuItem() {
        if(!TextRange.getCollapsed-impl(this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()) && !this.isPassword && (ClipboardUtils_androidKt.isWriteSupported(this.clipboard))) {
            return 1;
        }

        return 0;
    }

    public final boolean canShowCutMenuItem() {
        if(!TextRange.getCollapsed-impl(this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()) && (this.getEditable$foundation()) && !this.isPassword && (ClipboardUtils_androidKt.isWriteSupported(this.clipboard))) {
            return 1;
        }

        return 0;
    }

    public final boolean canShowPasteMenuItem() {
        if(this.getEditable$foundation()) {
            if(!ClipboardUtils_androidKt.isReadSupported(this.clipboard)) {
            }
            else if(this.clipboardPasteState.getHasText()) {
                return 1;
            }
            else {
                Function0 v0 = this.receiveContentConfiguration;
                Object v0_1 = v0 != null ? v0.invoke() : null;
                if(v0_1 == null) {
                    return 0;
                }

                if(!this.clipboardPasteState.getHasClip()) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final boolean canShowSelectAllMenuItem() {
        if(TextRange.getLength-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE()) != this.textFieldState.getVisualText().length()) {
            return 1;
        }

        return 0;
    }

    public final void clearHandleDragging() {
        this.setDraggingHandle(null);
        this.setRawHandleDragPosition-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
        this.setStartTextLayoutPositionInWindow-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
    }

    public final Object copy(boolean arg1, Continuation arg2) {
        AnnotatedString v1 = this.copyWithResult$foundation(arg1);
        if(v1 == null) {
            return Unit.INSTANCE;
        }

        Object v0 = this.clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(v1), arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public static Object copy$default(TextFieldSelectionState arg0, boolean arg1, Continuation arg2, int arg3, Object arg4) {
        return arg0.copy(true, arg2);
    }

    public final AnnotatedString copyWithResult$foundation(boolean arg5) {
        List v1 = null;
        if(!TextRange.getCollapsed-impl(this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()) && !this.isPassword) {
            AnnotatedString v2 = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(this.textFieldState.getVisualText()).toString(), v1, 2, ((DefaultConstructorMarker)v1));
            if(arg5) {
                this.textFieldState.collapseSelectionToMax();
            }

            return v2;
        }

        return ((AnnotatedString)v1);
    }

    public static AnnotatedString copyWithResult$foundation$default(TextFieldSelectionState arg0, boolean arg1, int arg2, Object arg3) {
        return arg0.copyWithResult$foundation(true);
    }

    public final Object cursorHandleGestures(PointerInputScope arg3, Continuation arg4) {
        Object v2 = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, arg3, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final Object cut(Continuation arg2) {
        AnnotatedString v0 = this.cutWithResult();
        if(v0 == null) {
            return Unit.INSTANCE;
        }

        Object v1 = this.clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(v0), arg2);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    public final AnnotatedString cutWithResult() {
        List v1 = null;
        if(!TextRange.getCollapsed-impl(this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()) && (this.getEditable$foundation()) && !this.isPassword) {
            AnnotatedString v2 = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(this.textFieldState.getVisualText()).toString(), v1, 2, ((DefaultConstructorMarker)v1));
            this.textFieldState.deleteSelectedText();
            return v2;
        }

        return ((AnnotatedString)v1);
    }

    static final Rect derivedVisibleContentBounds_delegate$lambda$0(TextFieldSelectionState arg7) {
        boolean v0 = TextRange.getCollapsed-impl(arg7.textFieldState.getVisualText().getSelection-d9O1mEE());
        Rect v1 = null;
        if(((v0) && arg7.getTextToolbarState() == TextToolbarState.Cursor || !v0 && arg7.getTextToolbarState() == TextToolbarState.Selection) && (arg7.getDraggingHandle() == null && (arg7.isInTouchMode()))) {
            LayoutCoordinates v0_1 = arg7.getTextLayoutCoordinates();
            if(v0_1 == null) {
                return v1;
            }
            else {
                Rect v2 = SelectionManagerKt.visibleBounds(v0_1);
                Rect v0_2 = RectKt.Rect-tz77jQw(v0_1.localToRoot-MK-Hz9U(v2.getTopLeft-F1C5BW0()), v2.getSize-NH-jbRc());
                Rect v7 = arg7.getContentRect();
                if(!v7.overlaps(v0_2)) {
                    return v1;
                }
                else {
                    return v7.intersect(v0_2);
                }
            }
        }

        return v1;
    }

    public final void deselect() {
        if(!TextRange.getCollapsed-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE())) {
            this.textFieldState.collapseSelectionToEnd();
        }

        this.setShowCursorHandle(false);
        this.updateTextToolbarState(TextToolbarState.None);
    }

    private final Object detectCursorHandleDragGestures(PointerInputScope arg9, Continuation arg10) {
        Throwable v10_1;
        LongRef v9_1;
        LongRef v1_2;
        TextFieldSelectionState$detectCursorHandleDragGestures$1 v0_1;
        if((arg10 instanceof TextFieldSelectionState$detectCursorHandleDragGestures$1)) {
            Continuation v0 = arg10;
            int v2 = 0x80000000;
            if((((TextFieldSelectionState$detectCursorHandleDragGestures$1)v0).label & v2) != 0) {
                ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TextFieldSelectionState$detectCursorHandleDragGestures$1(this, arg10);
        }

        Continuation v6 = ((Continuation)v0_1);
        Object v10 = ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v10);
            LongRef v10_2 = new LongRef();
            v10_2.element = Offset.Companion.getUnspecified-F1C5BW0();
            LongRef v7 = new LongRef();
            v7.element = Offset.Companion.getUnspecified-F1C5BW0();
            try {
                TextFieldSelectionState$$ExternalSyntheticLambda7 v2_1 = new TextFieldSelectionState$$ExternalSyntheticLambda7(v10_2, this, v7);
                TextFieldSelectionState$$ExternalSyntheticLambda8 v3 = new TextFieldSelectionState$$ExternalSyntheticLambda8(v10_2, v7, this);
                TextFieldSelectionState$$ExternalSyntheticLambda9 v4 = new TextFieldSelectionState$$ExternalSyntheticLambda9(v10_2, v7, this);
                TextFieldSelectionState$$ExternalSyntheticLambda10 v5 = new TextFieldSelectionState$$ExternalSyntheticLambda10(v7, this, v10_2);
                ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).L$0 = v10_2;
                ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).L$1 = v7;
                ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).label = 1;
                if(DragGestureDetectorKt.detectDragGestures(arg9, ((Function1)v2_1), ((Function0)v3), ((Function0)v4), ((Function2)v5), v6) != v0_2) {
                    goto label_59;
                }

                return v0_2;
            }
            catch(Throwable v0_3) {
                v1_2 = v10_2;
                v10_1 = v0_3;
                v9_1 = v7;
            }

        label_69:
            TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(v1_2, v9_1, this);
            throw v10_1;
            return v0_2;
        label_59:
            v1_2 = v10_2;
            v9_1 = v7;
        }
        else if(v1 == 1) {
            Object v9 = ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).L$1;
            Object v1_1 = ((TextFieldSelectionState$detectCursorHandleDragGestures$1)v6).L$0;
            try {
                ResultKt.throwOnFailure(v10);
            }
            catch(Throwable v0_3) {
                v10_1 = v0_3;
                goto label_69;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(v1_2, v9_1, this);
        return Unit.INSTANCE;
    }

    static final Unit detectCursorHandleDragGestures$lambda$0(LongRef arg2, TextFieldSelectionState arg3, LongRef arg4, Offset arg5) {
        arg2.element = SelectionHandlesKt.getAdjustedCoordinates-k-4lQ0M(arg3.getCursorRect().getBottomCenter-F1C5BW0());
        arg4.element = Offset.Companion.getZero-F1C5BW0();
        arg3.setInTouchMode(true);
        arg3.markStartContentVisibleOffset();
        arg3.updateHandleDragging-Uv8p0NA(Handle.Cursor, arg2.element);
        return Unit.INSTANCE;
    }

    static final Unit detectCursorHandleDragGestures$lambda$1(LongRef arg0, LongRef arg1, TextFieldSelectionState arg2) {
        TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(arg0, arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit detectCursorHandleDragGestures$lambda$2(LongRef arg0, LongRef arg1, TextFieldSelectionState arg2) {
        TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(arg0, arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit detectCursorHandleDragGestures$lambda$3(LongRef arg4, TextFieldSelectionState arg5, LongRef arg6, PointerInputChange arg7, Offset arg8) {
        arg4.element = Offset.plus-MK-Hz9U(arg4.element, arg8.unbox-impl());
        arg5.updateHandleDragging-Uv8p0NA(Handle.Cursor, Offset.plus-MK-Hz9U(arg6.element, arg4.element));
        if(arg5.placeCursorAtNearestOffset-k-4lQ0M(arg5.getHandleDragPosition-F1C5BW0())) {
            arg7.consume();
            HapticFeedback v4 = arg5.hapticFeedBack;
            if(v4 != null) {
                v4.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
            }
        }

        return Unit.INSTANCE;
    }

    private static final void detectCursorHandleDragGestures$onDragStop(LongRef arg4, LongRef arg5, TextFieldSelectionState arg6) {
        if((arg4.element & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            arg4.element = Offset.Companion.getUnspecified-F1C5BW0();
            arg5.element = Offset.Companion.getUnspecified-F1C5BW0();
            arg6.clearHandleDragging();
        }
    }

    private final Object detectSelectionHandleDragGestures(PointerInputScope arg15, boolean arg16, Continuation arg17) {
        Object v2_1;
        Object v15;
        LongRef v1_3;
        boolean v13_1;
        TextFieldSelectionState$$ExternalSyntheticLambda2 v8;
        LongRef v11_2;
        Continuation v1;
        Continuation v0 = arg17;
        if((v0 instanceof TextFieldSelectionState$detectSelectionHandleDragGestures$1)) {
            v1 = v0;
            int v3 = 0x80000000;
            if((((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v1).label & v3) != 0) {
                ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            TextFieldSelectionState$detectSelectionHandleDragGestures$1 v1_1 = new TextFieldSelectionState$detectSelectionHandleDragGestures$1(this, v0);
        }

        Continuation v7 = v1;
        Object v0_1 = ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_1);
            LongRef v12 = new LongRef();
            v12.element = Offset.Companion.getUnspecified-F1C5BW0();
            LongRef v13 = new LongRef();
            v13.element = Offset.Companion.getZero-F1C5BW0();
            Handle v0_3 = arg16 ? Handle.SelectionStart : Handle.SelectionEnd;
            Handle v11 = v0_3;
            TextFieldSelectionState v10 = this;
            LongRef v9 = v12;
            Handle v12_1 = v11;
            boolean v11_1 = arg16;
            try {
                TextFieldSelectionState$$ExternalSyntheticLambda11 v0_4 = new TextFieldSelectionState$$ExternalSyntheticLambda11(v9, v10, v11_1, v12_1, v13);
                v11 = v12_1;
                v12 = v9;
            }
            catch(Throwable v0_2) {
                v11_2 = v12;
                v12 = v9;
                goto label_97;
            }

            try {
                TextFieldSelectionState$$ExternalSyntheticLambda12 v4 = new TextFieldSelectionState$$ExternalSyntheticLambda12(v12, this, v13);
                TextFieldSelectionState$$ExternalSyntheticLambda1 v5 = new TextFieldSelectionState$$ExternalSyntheticLambda1(v12, this, v13);
                v10 = this;
                v8 = null;
                v9 = v13;
                v13_1 = arg16;
            }
            catch(Throwable v0_2) {
                goto label_97;
            }

            try {
                super(v9, v10, v11, v12, v13_1);
                Function2 v6 = ((Function2)v8);
                v13 = v9;
            }
            catch(Throwable v0_2) {
                v13 = v9;
                goto label_97;
            }

            try {
                ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).L$0 = v12;
                ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).L$1 = v13;
                ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).L$2 = v11;
                ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).label = 1;
                if(DragGestureDetectorKt.detectDragGestures(arg15, v0_4, ((Function0)v4), ((Function0)v5), v6, v7) != v1_2) {
                    goto label_78;
                }

                return v1_2;
            }
            catch(Throwable v0_2) {
            }

        label_97:
            Handle v15_1 = ((Handle)v11_2);
            Handle v2_2 = ((Handle)v12);
            v1_3 = v13;
        label_100:
            TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$$ExternalSyntheticLambda3(this, ((Handle)v15)));
            if(this.getDraggingHandle() == v15) {
                TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop(((LongRef)v2_2), this, v1_3);
            }

            throw v0_2;
            return v1_2;
        label_78:
            v15_1 = v11;
            LongRef v2_3 = v12;
            v1_3 = v13;
        }
        else if(v2 == 1) {
            v15 = ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).L$2;
            v1_2 = ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).L$1;
            v2_1 = ((TextFieldSelectionState$detectSelectionHandleDragGestures$1)v7).L$0;
            try {
                ResultKt.throwOnFailure(v0_1);
            }
            catch(Throwable v0_2) {
                goto label_100;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        TextFieldSelectionStateKt.access$logDebug(new TextFieldSelectionState$$ExternalSyntheticLambda3(this, ((Handle)v15)));
        if(this.getDraggingHandle() == v15) {
            TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop(((LongRef)v2_1), this, v1_3);
        }

        return Unit.INSTANCE;
    }

    static final Unit detectSelectionHandleDragGestures$lambda$0(LongRef arg2, TextFieldSelectionState arg3, boolean arg4, Handle arg5, LongRef arg6, Offset arg7) {
        arg2.element = SelectionHandlesKt.getAdjustedCoordinates-k-4lQ0M(arg3.getHandlePosition-tuRUvjQ(arg4));
        arg3.updateHandleDragging-Uv8p0NA(arg5, arg2.element);
        arg6.element = Offset.Companion.getZero-F1C5BW0();
        arg3.previousRawDragOffset = -1;
        return Unit.INSTANCE;
    }

    static final Unit detectSelectionHandleDragGestures$lambda$1(LongRef arg0, TextFieldSelectionState arg1, LongRef arg2) {
        TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop(arg0, arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit detectSelectionHandleDragGestures$lambda$2(LongRef arg0, TextFieldSelectionState arg1, LongRef arg2) {
        TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop(arg0, arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit detectSelectionHandleDragGestures$lambda$3(LongRef arg11, TextFieldSelectionState arg12, Handle arg13, LongRef arg14, boolean arg15, PointerInputChange arg16, Offset arg17) {
        arg11.element = Offset.plus-MK-Hz9U(arg11.element, arg17.unbox-impl());
        TextLayoutResult v0 = arg12.textLayoutState.getLayoutResult();
        if(v0 == null) {
            return Unit.INSTANCE;
        }

        arg12.updateHandleDragging-Uv8p0NA(arg13, Offset.plus-MK-Hz9U(arg14.element, arg11.element));
        int v11 = arg15 ? v0.getOffsetForPosition-k-4lQ0M(arg12.getHandleDragPosition-F1C5BW0()) : TextRange.getStart-impl(arg12.textFieldState.getVisualText().getSelection-d9O1mEE());
        int v3 = v11;
        v11 = arg15 ? TextRange.getEnd-impl(arg12.textFieldState.getVisualText().getSelection-d9O1mEE()) : v0.getOffsetForPosition-k-4lQ0M(arg12.getHandleDragPosition-F1C5BW0());
        long v13 = arg12.textFieldState.getVisualText().getSelection-d9O1mEE();
        long v2 = TextFieldSelectionState.updateSelection-SsL-Rf8$foundation$default(arg12, arg12.textFieldState.getVisualText(), v3, v11, arg15, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), false, false, 0x60, null);
        if((TextRange.getCollapsed-impl(v13)) || !TextRange.getCollapsed-impl(v2)) {
            arg12.textFieldState.selectCharsIn-5zc-tL8(v2);
        }

        return Unit.INSTANCE;
    }

    static final String detectSelectionHandleDragGestures$lambda$4(TextFieldSelectionState arg2, Handle arg3) {
        return "Selection Handle drag cancelled for draggingHandle: " + arg2.getDraggingHandle() + " definedOn: " + arg3;
    }

    private static final void detectSelectionHandleDragGestures$onDragStop(LongRef arg4, TextFieldSelectionState arg5, LongRef arg6) {
        if((arg4.element & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            arg5.clearHandleDragging();
            arg4.element = Offset.Companion.getUnspecified-F1C5BW0();
            arg6.element = Offset.Companion.getZero-F1C5BW0();
            arg5.previousRawDragOffset = -1;
        }
    }

    public final Object detectTextFieldTapGestures(PointerInputScope arg1, MutableInteractionSource arg2, Function0 arg3, Function0 arg4, Continuation arg5) {
        Object v0 = TextFieldSelectionState_androidKt.detectTextFieldTapGestures(this, arg1, arg2, arg3, arg4, arg5);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public final Object detectTouchMode(PointerInputScope arg3, Continuation arg4) {
        Object v2 = arg3.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final void dispose() {
        this.hideTextToolbar();
        this.hapticFeedBack = null;
    }

    private final Rect getContentRect() {
        LayoutCoordinates v1 = this.getTextLayoutCoordinates();
        if(v1 != null) {
            TextFieldCharSequence v2 = this.textFieldState.getVisualText();
            if(TextRange.getCollapsed-impl(v2.getSelection-d9O1mEE())) {
                Rect v0 = this.getCursorRect();
                return RectKt.Rect-tz77jQw(v1.localToRoot-MK-Hz9U(v0.getTopLeft-F1C5BW0()), v0.getSize-NH-jbRc());
            }

            long v3 = v1.localToRoot-MK-Hz9U(this.getHandlePosition-tuRUvjQ(true));
            long v5 = v1.localToRoot-MK-Hz9U(this.getHandlePosition-tuRUvjQ(false));
            TextLayoutResult v0_1 = this.textLayoutState.getLayoutResult();
            if(v0_1 == null) {
                return Rect.Companion.getZero();
            }

            float v9 = Float.intBitsToFloat(((int)(v1.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(v0_1.getCursorRect(TextRange.getStart-impl(v2.getSelection-d9O1mEE())).getTop()))) & 0xFFFFFFFFL)) & 0xFFFFFFFFL)));
            float v0_2 = Float.intBitsToFloat(((int)(v1.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v0_1.getCursorRect(TextRange.getEnd-impl(v2.getSelection-d9O1mEE())).getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(0f))) << 0x20)) & 0xFFFFFFFFL)));
            int v1_1 = ((int)(v3 >> 0x20));
            int v7 = ((int)(v5 >> 0x20));
            return new Rect(Math.min(Float.intBitsToFloat(v1_1), Float.intBitsToFloat(v7)), Math.min(v9, v0_2), Math.max(Float.intBitsToFloat(v1_1), Float.intBitsToFloat(v7)), Math.max(Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL)))));
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("textLayoutCoordinates should not be null.");
        throw new KotlinNothingValueException();
    }

    private final long getCurrentTextLayoutPositionInWindow-F1C5BW0() {
        LayoutCoordinates v2 = this.getTextLayoutCoordinates();
        if(v2 != null) {
            return LayoutCoordinatesKt.positionInWindow(v2);
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public final TextFieldHandleState getCursorHandleState$foundation(boolean arg10) {
        TextFieldCharSequence v0 = this.textFieldState.getVisualText();
        boolean v1 = this.getShowCursorHandle();
        int v2 = this.getDirectDragGestureInitiator() == InputType.None ? 1 : 0;
        Handle v3 = this.getDraggingHandle();
        if((v1) && v2 != 0 && (TextRange.getCollapsed-impl(v0.getSelection-d9O1mEE())) && (v0.shouldShowSelection()) && ((CharSequence)v0).length() > 0 && (v3 == Handle.Cursor || (this.isCursorHandleInVisibleBounds()))) {
            long v9 = arg10 ? this.getCursorRect().getBottomCenter-F1C5BW0() : Offset.Companion.getUnspecified-F1C5BW0();
            return new TextFieldHandleState(true, v9, 0f, ResolvedTextDirection.Ltr, false, null);
        }

        return TextFieldHandleState.Companion.getHidden();
    }

    public final Rect getCursorRect() {
        TextLayoutResult v0 = this.textLayoutState.getLayoutResult();
        if(v0 == null) {
            return Rect.Companion.getZero();
        }

        return this.calculateCursorRect(v0, this.textFieldState.getVisualText());
    }

    public final Rect getDerivedVisibleContentBounds$foundation() {
        return this.derivedVisibleContentBounds$delegate.getValue();
    }

    public final InputType getDirectDragGestureInitiator() {
        return this.directDragGestureInitiator$delegate.getValue();
    }

    public final Handle getDraggingHandle() {
        return this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable$foundation() {
        if((this.enabled) && !this.readOnly) {
            return 1;
        }

        return 0;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Rect getFocusRect() {
        TextLayoutResult v0 = this.textLayoutState.getLayoutResult();
        if(v0 == null) {
            return Rect.Companion.getZero();
        }

        if(!this.isFocused) {
            return FocusProperties.Companion.getUnsetFocusRect();
        }

        TextFieldCharSequence v1 = this.textFieldState.getVisualText();
        Rect v0_1 = TextRange.getCollapsed-impl(v1.getSelection-d9O1mEE()) ? this.calculateCursorRect(v0, v1) : this.calculateSelectionRect(v0, v1);
        return TextLayoutStateKt.fromTextLayoutToDecoration(this.textLayoutState, v0_1);
    }

    public final long getHandleDragPosition-F1C5BW0() {
        long v2 = 0x7FFFFFFF7FFFFFFFL;
        long v4 = 0x7FC000007FC00000L;
        if((this.getRawHandleDragPosition-F1C5BW0() & v2) == v4) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        if((this.getStartTextLayoutPositionInWindow-F1C5BW0() & v2) == v4) {
            return TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(this.textLayoutState, this.getRawHandleDragPosition-F1C5BW0());
        }

        return Offset.plus-MK-Hz9U(this.getRawHandleDragPosition-F1C5BW0(), Offset.minus-MK-Hz9U(this.getStartTextLayoutPositionInWindow-F1C5BW0(), this.getCurrentTextLayoutPositionInWindow-F1C5BW0()));
    }

    private final long getHandlePosition-tuRUvjQ(boolean arg4) {
        TextLayoutResult v0 = this.textLayoutState.getLayoutResult();
        if(v0 == null) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        long v1 = this.textFieldState.getVisualText().getSelection-d9O1mEE();
        int v3 = arg4 ? TextRange.getStart-impl(v1) : TextRange.getEnd-impl(v1);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(v0, v3, arg4, TextRange.getReversed-impl(v1));
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation() {
        return this.platformSelectionBehaviors;
    }

    public final Press getPressInteraction() {
        return this.pressInteraction;
    }

    private final long getRawHandleDragPosition-F1C5BW0() {
        return this.rawHandleDragPosition$delegate.getValue().unbox-impl();
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final Function0 getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final Function0 getRequestAutofillAction() {
        return this.requestAutofillAction;
    }

    public final TextFieldHandleState getSelectionHandleState$foundation(boolean arg15, boolean arg16) {
        boolean v0_3;
        Handle v0 = arg15 ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult v1 = this.textLayoutState.getLayoutResult();
        if(v1 == null) {
            return TextFieldHandleState.Companion.getHidden();
        }

        long v2 = this.textFieldState.getVisualText().getSelection-d9O1mEE();
        if(TextRange.getCollapsed-impl(v2)) {
            return TextFieldHandleState.Companion.getHidden();
        }

        long v4 = this.getHandlePosition-tuRUvjQ(arg15);
        if(this.getDirectDragGestureInitiator() == InputType.None) {
            if(this.getDraggingHandle() != v0) {
                LayoutCoordinates v0_1 = this.getTextLayoutCoordinates();
                if(v0_1 != null) {
                    Rect v0_2 = SelectionManagerKt.visibleBounds(v0_1);
                    if(v0_2 != null) {
                        v0_3 = SelectionManagerKt.containsInclusive-Uv8p0NA(v0_2, v4);
                    }
                    else {
                        goto label_31;
                    }
                }
                else {
                label_31:
                    v0_3 = false;
                }

                if(!v0_3) {
                    goto label_68;
                }
            }

            if(!this.textFieldState.getVisualText().shouldShowSelection()) {
                return TextFieldHandleState.Companion.getHidden();
            }

            int v0_4 = arg15 ? TextRange.getStart-impl(v2) : Math.max(TextRange.getEnd-impl(v2) - 1, 0);
            ResolvedTextDirection v11 = v1.getBidiRunDirection(v0_4);
            boolean v12 = TextRange.getReversed-impl(v2);
            if(arg16) {
                LayoutCoordinates v14 = this.getTextLayoutCoordinates();
                if(v14 != null) {
                    Rect v14_1 = SelectionManagerKt.visibleBounds(v14);
                    if(v14_1 != null) {
                        v4 = TextLayoutStateKt.coerceIn-3MmeM6k(v4, v14_1);
                    }
                }
            }
            else {
                v4 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            long v8 = v4;
            int v14_2 = arg15 ? TextRange.getStart-impl(v2) : TextRange.getEnd-impl(v2);
            return new TextFieldHandleState(true, v8, TextLayoutHelperKt.getLineHeight(v1, v14_2), v11, v12, null);
        }

    label_68:
        return TextFieldHandleState.Companion.getHidden();
    }

    public final boolean getShowCursorHandle() {
        return this.showCursorHandle$delegate.getValue().booleanValue();
    }

    private final long getStartTextLayoutPositionInWindow-F1C5BW0() {
        return this.startTextLayoutPositionInWindow$delegate.getValue().unbox-impl();
    }

    private final long getTextFieldSelection-qeG_v_k(int arg10, int arg11, TextRange arg12, boolean arg13, SelectionAdjustment arg14) {
        TextLayoutResult v1 = this.textLayoutState.getLayoutResult();
        if(v1 == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        if(arg12 == null && (Intrinsics.areEqual(arg14, SelectionAdjustment.Companion.getCharacter()))) {
            return TextRangeKt.TextRange(arg10, arg11);
        }

        int v4 = this.previousRawDragOffset;
        long v2 = arg12 != null ? arg12.unbox-impl() : TextRange.Companion.getZero-d9O1mEE();
        long v5 = v2;
        boolean v0 = arg12 == null ? true : false;
        int v2_1 = arg10;
        int v3 = arg11;
        boolean v8 = arg13;
        SelectionLayout v10 = SelectionLayoutKt.getTextFieldSelectionLayout-RcvT-LA(v1, v2_1, v3, v4, v5, v0, v8);
        if(arg12 != null && !v10.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return arg12.unbox-impl();
        }

        long v11 = arg14.adjust(v10).toTextRange-d9O1mEE();
        this.previousSelectionLayout = v10;
        arg10 = v8 ? v2_1 : v3;
        this.previousRawDragOffset = arg10;
        return v11;
    }

    public final TransformedTextFieldState getTextFieldState$foundation() {
        return this.textFieldState;
    }

    private final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates v2 = this.textLayoutState.getTextLayoutNodeCoordinates();
        LayoutCoordinates v0 = null;
        if(v2 != null && (v2.isAttached())) {
            return v2;
        }

        return v0;
    }

    public final TextLayoutState getTextLayoutState$foundation() {
        return this.textLayoutState;
    }

    public final boolean getTextToolbarShown() {
        return this.textToolbarShown$delegate.getValue().booleanValue();
    }

    private final TextToolbarState getTextToolbarState() {
        return this.textToolbarState$delegate.getValue();
    }

    private final void hideTextToolbar() {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }

        TextToolbarHandler v1 = this.textToolbarHandler;
        if(v1 != null) {
            v1.hideTextToolbar();
        }
    }

    public final boolean isCopyAllowed() {
        if(!TextRange.getCollapsed-impl(this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()) && !this.isPassword) {
            return 1;
        }

        return 0;
    }

    private final boolean isCursorHandleInVisibleBounds() {
        long v4;
        Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            v4 = this.getCursorRect().getBottomCenter-F1C5BW0();
        }
        catch(Throwable v6) {
            v0.restoreNonObservable(v1, v3, v2);
            throw v6;
        }

        v0.restoreNonObservable(v1, v3, v2);
        LayoutCoordinates v6_1 = this.getTextLayoutCoordinates();
        if(v6_1 != null) {
            Rect v6_2 = SelectionManagerKt.visibleBounds(v6_1);
            if(v6_2 != null) {
                return SelectionManagerKt.containsInclusive-Uv8p0NA(v6_2, v4);
            }
        }

        return 0;
    }

    public final boolean isCutAllowed() {
        if(!TextRange.getCollapsed-impl(this.getTextFieldState$foundation().getVisualText().getSelection-d9O1mEE()) && (this.getEditable$foundation()) && !this.isPassword) {
            return 1;
        }

        return 0;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final boolean isInTouchMode() {
        return this.isInTouchMode$delegate.getValue().booleanValue();
    }

    public final boolean isPasteAllowed() {
        return this.getEditable$foundation();
    }

    private final void markStartContentVisibleOffset() {
        this.setStartTextLayoutPositionInWindow-k-4lQ0M(this.getCurrentTextLayoutPositionInWindow-F1C5BW0());
    }

    public final void maybeSuggestSelectionRange() {
        PlatformSelectionBehaviors v1 = this.platformSelectionBehaviors;
        if(v1 == null) {
        }
        else {
            CharSequence v2 = this.textFieldState.getVisualText().getText();
            long v3 = this.textFieldState.getVisualText().getSelection-d9O1mEE();
            if(v2.length() > 0 && !TextRange.getCollapsed-impl(v3)) {
                BuildersKt.launch$default(this.coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionState$maybeSuggestSelectionRange$1(v1, v2, v3, this, null), 1, null);
            }
        }
    }

    private final Object observeTextChanges(Continuation arg3) {
        Object v2 = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new TextFieldSelectionState$$ExternalSyntheticLambda6(this)), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new TextFieldSelectionState$observeTextChanges$4(this), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final TextFieldCharSequence observeTextChanges$lambda$0(TextFieldSelectionState arg0) {
        return arg0.textFieldState.getVisualText();
    }

    private final Object observeTextToolbarVisibility(Continuation arg3) {
        Flow v0 = SnapshotStateKt.snapshotFlow(new TextFieldSelectionState$$ExternalSyntheticLambda0(this));
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            v0 = FlowKt.distinctUntilChangedBy(v0, new TextFieldSelectionState$$ExternalSyntheticLambda4());
        }

        Object v2 = v0.collect(new TextFieldSelectionState$observeTextToolbarVisibility$4(this), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final Rect observeTextToolbarVisibility$lambda$0(TextFieldSelectionState arg0) {
        return arg0.getDerivedVisibleContentBounds$foundation();
    }

    private static final boolean observeTextToolbarVisibility$lambda$1$0(Rect arg0) {
        if(arg0 == null) {
            return 1;
        }

        return 0;
    }

    public final void onPasteEvent$foundation(AnnotatedString arg9) {
        if(!this.getEditable$foundation()) {
            return;
        }

        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, arg9.getText(), false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
    }

    public final Object paste(Continuation arg12) {
        Object v2_1;
        int v2;
        Continuation v0;
        if((arg12 instanceof TextFieldSelectionState$paste$1)) {
            v0 = arg12;
            v2 = 0x80000000;
            if((((TextFieldSelectionState$paste$1)v0).label & v2) != 0) {
                ((TextFieldSelectionState$paste$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TextFieldSelectionState$paste$1 v0_1 = new TextFieldSelectionState$paste$1(this, arg12);
        }

        Object v12 = ((TextFieldSelectionState$paste$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TextFieldSelectionState$paste$1)v0).label;
        int v3 = 3;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v12);
            Function0 v12_1 = this.receiveContentConfiguration;
            if(v12_1 != null) {
                v2_1 = v12_1.invoke();
                if(v2_1 == null) {
                }
                else {
                    Clipboard v12_2 = this.clipboard;
                    ((TextFieldSelectionState$paste$1)v0).L$0 = v2_1;
                    ((TextFieldSelectionState$paste$1)v0).label = v4;
                    v12 = v12_2.getClipEntry(v0);
                    if(v12 == v1) {
                        return v1;
                    }
                    else {
                    label_47:
                        Object v5 = v12;
                        if(v5 == null) {
                            ((TextFieldSelectionState$paste$1)v0).L$0 = null;
                            ((TextFieldSelectionState$paste$1)v0).label = v3;
                            if(this.pasteAsPlainText(v0) == v1) {
                                return v1;
                            }
                            else {
                            label_55:
                                return Unit.INSTANCE;
                            }
                        }
                        else {
                            TransferableContent v12_3 = ((ReceiveContentConfiguration)v2_1).getReceiveContentListener().onReceive(new TransferableContent(((ClipEntry)v5), ((ClipEntry)v5).getClipMetadata(), Source.Companion.getClipboard-kB6V9T0(), null, 8, null));
                            if(v12_3 != null) {
                                ClipEntry v12_4 = v12_3.getClipEntry();
                                if(v12_4 != null) {
                                    String v12_5 = TransferableContent_androidKt.readPlainText(v12_4);
                                    if(v12_5 != null) {
                                        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, v12_5, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                                    }
                                }
                            }

                            return Unit.INSTANCE;
                        }
                    }
                }
            }

            ((TextFieldSelectionState$paste$1)v0).label = 1;
            if(this.pasteAsPlainText(v0) != v1) {
                goto label_86;
            }

            return v1;
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v12);
        }
        else if(v2 == v4) {
            v2_1 = ((TextFieldSelectionState$paste$1)v0).L$0;
            ResultKt.throwOnFailure(v12);
            goto label_47;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v12);
            goto label_55;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_86:
        return Unit.INSTANCE;
    }

    private final Object pasteAsPlainText(Continuation arg8) {
        TextFieldSelectionState$pasteAsPlainText$1 v0_1;
        int v2;
        if((arg8 instanceof TextFieldSelectionState$pasteAsPlainText$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((TextFieldSelectionState$pasteAsPlainText$1)v0).label & v2) != 0) {
                ((TextFieldSelectionState$pasteAsPlainText$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new TextFieldSelectionState$pasteAsPlainText$1(this, arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            Clipboard v8_1 = this.clipboard;
            v0_1.label = 1;
            v8 = v8_1.getClipEntry(((Continuation)v0_1));
            if(v8 == v1) {
                return v1;
            }
            else {
            label_35:
                if(v8 != null) {
                    v0_1.label = v3;
                    v8 = ClipboardUtils_androidKt.readText(((ClipEntry)v8), ((Continuation)v0_1));
                    if(v8 == v1) {
                        return v1;
                    }
                    else {
                    label_40:
                        if(v8 == null) {
                        }
                        else {
                            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, v8, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v8);
            goto label_35;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v8);
            goto label_40;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public final boolean placeCursorAtNearestOffset-k-4lQ0M(long arg11) {
        int v11;
        IndexTransformationType v6;
        TextLayoutResult v0 = this.textLayoutState.getLayoutResult();
        if(v0 == null) {
            return 0;
        }

        int v2 = v0.getOffsetForPosition-k-4lQ0M(arg11);
        if(v2 == -1) {
            return 0;
        }

        TransformedTextFieldState v3 = this.textFieldState;
        long v4 = v3.mapFromTransformed--jx7JFs(v2);
        long v2_1 = v3.mapToTransformed-GEjPoXI(v4);
        if(!TextRange.getCollapsed-impl(v4) || !TextRange.getCollapsed-impl(v2_1)) {
            if(!TextRange.getCollapsed-impl(v4) && !TextRange.getCollapsed-impl(v2_1)) {
                v6 = IndexTransformationType.Replacement;
                goto label_31;
            }

            if((TextRange.getCollapsed-impl(v4)) && !TextRange.getCollapsed-impl(v2_1)) {
                v6 = IndexTransformationType.Insertion;
                goto label_31;
            }

            v6 = IndexTransformationType.Deletion;
        }
        else {
            v6 = IndexTransformationType.Untransformed;
        }

    label_31:
        int v6_1 = WhenMappings.$EnumSwitchMapping$0[v6.ordinal()];
        SelectionWedgeAffinity v8 = null;
        if(v6_1 == 1) {
            v11 = TextRange.getStart-impl(v4);
        }
        else if(v6_1 == 2) {
            v11 = TextRange.getStart-impl(v4);
        }
        else if(v6_1 == 3) {
            SelectionWedgeAffinity v11_1 = MathUtilsKt.findClosestRect-9KIMszo(arg11, v0.getCursorRect(TextRange.getStart-impl(v2_1)), v0.getCursorRect(TextRange.getEnd-impl(v2_1))) < 0 ? new SelectionWedgeAffinity(WedgeAffinity.Start) : new SelectionWedgeAffinity(WedgeAffinity.End);
            v8 = v11_1;
            v11 = TextRange.getStart-impl(v4);
        }
        else if(v6_1 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        else if(MathUtilsKt.findClosestRect-9KIMszo(arg11, v0.getCursorRect(TextRange.getStart-impl(v2_1)), v0.getCursorRect(TextRange.getEnd-impl(v2_1))) < 0) {
            v11 = TextRange.getStart-impl(v4);
        }
        else {
            v11 = TextRange.getEnd-impl(v4);
        }

        arg11 = TextRangeKt.TextRange(v11);
        if((TextRange.equals-impl0(arg11, this.textFieldState.getUntransformedText().getSelection-d9O1mEE())) && (v8 == null || (Intrinsics.areEqual(v8, this.textFieldState.getSelectionWedgeAffinity())))) {
            return 0;
        }

        this.textFieldState.selectUntransformedCharsIn-5zc-tL8(arg11);
        if(v8 != null) {
            this.textFieldState.setSelectionWedgeAffinity(v8);
        }

        return 1;
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final Object selectionHandleGestures(PointerInputScope arg3, boolean arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final void setDirectDragGestureInitiator(InputType arg1) {
        this.directDragGestureInitiator$delegate.setValue(arg1);
    }

    public final void setDraggingHandle(Handle arg1) {
        this.draggingHandle$delegate.setValue(arg1);
    }

    public final void setFocused(boolean arg1) {
        this.isFocused = arg1;
    }

    public final void setHapticFeedBack(HapticFeedback arg1) {
        this.hapticFeedBack = arg1;
    }

    public final void setInTouchMode(boolean arg1) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setPressInteraction(Press arg1) {
        this.pressInteraction = arg1;
    }

    private final void setRawHandleDragPosition-k-4lQ0M(long arg1) {
        this.rawHandleDragPosition$delegate.setValue(Offset.box-impl(arg1));
    }

    public final void setReceiveContentConfiguration(Function0 arg1) {
        this.receiveContentConfiguration = arg1;
    }

    public final void setRequestAutofillAction(Function0 arg1) {
        this.requestAutofillAction = arg1;
    }

    public final void setShowCursorHandle(boolean arg1) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setStartTextLayoutPositionInWindow-k-4lQ0M(long arg1) {
        this.startTextLayoutPositionInWindow$delegate.setValue(Offset.box-impl(arg1));
    }

    public final void setTextToolbarShown$foundation(boolean arg1) {
        this.textToolbarShown$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setTextToolbarState(TextToolbarState arg1) {
        this.textToolbarState$delegate.setValue(arg1);
    }

    private final Object showTextToolbar(Rect arg2, Continuation arg3) {
        if(ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.show();
        }
        else {
            TextToolbarHandler v0 = this.textToolbarHandler;
            if(v0 != null) {
                Object v1 = v0.showTextToolbar(this, arg2, arg3);
                if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v1;
                }
                else {
                    return Unit.INSTANCE;
                }
            }
        }

        return Unit.INSTANCE;
    }

    public final Object startToolbarAndHandlesVisibilityObserver(Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1)v0).label & v2) != 0) {
                ((TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 v0_1 = new TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1(this, arg6);
        }

        Object v6 = ((TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            try {
                TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2 v6_2 = new TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2(this, null);
                ((TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1)v0).label = 1;
                if(CoroutineScopeKt.coroutineScope(((Function2)v6_2), v0) == v1) {
                    return v1;
                }

            label_36:
                this.setShowCursorHandle(false);
                goto label_37;
            }
            catch(Throwable v6_1) {
            label_43:
                this.setShowCursorHandle(false);
                if(this.getTextToolbarState() != TextToolbarState.None) {
                    this.hideTextToolbar();
                }

                throw v6_1;
            }
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v6);
                goto label_36;
            }
            catch(Throwable v6_1) {
                goto label_43;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_36;
    label_37:
        if(this.getTextToolbarState() != TextToolbarState.None) {
            this.hideTextToolbar();
        }

        return Unit.INSTANCE;
    }

    public final Object textFieldSelectionGestures(PointerInputScope arg3, Function0 arg4, Continuation arg5) {
        Object v2 = TextFieldSelectionState_androidKt.textFieldSelectionGestures(this, arg3, new TextFieldMouseSelectionObserver(this, arg4), new TextFieldTextDragObserver(this, arg4), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public final void update(HapticFeedback arg1, Clipboard arg2, TextToolbarHandler arg3, Density arg4, boolean arg5, boolean arg6, boolean arg7) {
        if(!arg5) {
            this.hideTextToolbar();
        }

        this.hapticFeedBack = arg1;
        this.clipboard = arg2;
        this.textToolbarHandler = arg3;
        this.density = arg4;
        this.enabled = arg5;
        this.readOnly = arg6;
        this.isPassword = arg7;
    }

    public final Object updateClipboardEntry(Continuation arg1) {
        Object v0 = this.clipboardPasteState.update(arg1);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public final void updateHandleDragging-Uv8p0NA(Handle arg1, long arg2) {
        this.setDraggingHandle(arg1);
        this.setRawHandleDragPosition-k-4lQ0M(arg2);
    }

    public final long updateSelection-SsL-Rf8$foundation(TextFieldCharSequence arg4, int arg5, int arg6, boolean arg7, SelectionAdjustment arg8, boolean arg9, boolean arg10) {
        TextRange v0 = TextRange.box-impl(arg4.getSelection-d9O1mEE());
        long v1 = v0.unbox-impl();
        if(arg10) {
        label_8:
            v0 = null;
        }
        else if(!arg9) {
            if(!TextRange.getCollapsed-impl(v1)) {
            }
            else {
                goto label_8;
            }
        }

        arg9 = arg7;
        int v7 = arg6;
        arg6 = arg5;
        TextFieldSelectionState v5 = this;
        long v6 = v5.getTextFieldSelection-qeG_v_k(arg6, v7, v0, arg9, arg8);
        if(TextRange.equals-impl0(v6, arg4.getSelection-d9O1mEE())) {
        }
        else {
            int v3 = TextRange.getReversed-impl(v6) == TextRange.getReversed-impl(arg4.getSelection-d9O1mEE()) || !TextRange.equals-impl0(TextRangeKt.TextRange(TextRange.getEnd-impl(v6), TextRange.getStart-impl(v6)), arg4.getSelection-d9O1mEE()) ? 0 : 1;
            if(!v5.isInTouchMode()) {
                return v6;
            }

            if(v3 != 0) {
                return v6;
            }

            HapticFeedback v3_1 = v5.hapticFeedBack;
            if(v3_1 == null) {
                return v6;
            }

            v3_1.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
        }

        return v6;
    }

    public static long updateSelection-SsL-Rf8$foundation$default(TextFieldSelectionState arg1, TextFieldCharSequence arg2, int arg3, int arg4, boolean arg5, SelectionAdjustment arg6, boolean arg7, boolean arg8, int arg9, Object arg10) {
        return arg1.updateSelection-SsL-Rf8$foundation(arg2, arg3, arg4, arg5, arg6, false, false);
    }

    public final void updateTextToolbarState(TextToolbarState arg1) {
        this.setTextToolbarState(arg1);
    }
}

