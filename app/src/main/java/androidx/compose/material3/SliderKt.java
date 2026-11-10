package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.DragGestureDetectorCopyKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R$string;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A}\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\b\b\u0003\u0010\f\u001A\u00020\r2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001A³\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0003\u0010\f\u001A\u00020\r2\u0019\b\u0002\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BH\u0007¢\u0006\u0002\u0010\u0019\u001As\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00162\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\u0019\b\u0002\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001B\u001A}\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00162\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\u0019\b\u0002\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001E\u001A\u007F\u0010\u001F\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0018\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000B\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\b\b\u0003\u0010\f\u001A\u00020\r2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001Aä\u0001\u0010\u001F\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0018\u0010\u0004\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000B\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010!\u001A\u00020\u00132\b\b\u0002\u0010\"\u001A\u00020\u00132\u0019\b\u0002\u0010#\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\b\b\u0003\u0010\f\u001A\u00020\rH\u0007¢\u0006\u0002\u0010&\u001A\u0098\u0001\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020$2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010!\u001A\u00020\u00132\b\b\u0002\u0010\"\u001A\u00020\u00132\u0019\b\u0002\u0010#\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\'\u001A_\u0010(\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00132\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010)\u001A`\u0010*\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\t2\u0014\u0010+\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u000E\u0010,\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000FH\u0002\u001A\u0080\u0001\u0010-\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020$2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010!\u001A\u00020\u00132\u0006\u0010\"\u001A\u00020\u00132\u0017\u0010#\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010%\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001A(\u0010/\u001A\u00020\u00032\u0006\u00100\u001A\u00020\u00032\u0006\u00101\u001A\u0002022\u0006\u00103\u001A\u00020\u00032\u0006\u00104\u001A\u00020\u0003H\u0002\u001A2\u00105\u001A\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0003\u0018\u000106*\u0002082\u0006\u00109\u001A\u00020:2\u0006\u0010;\u001A\u00020<H\u0082@¢\u0006\u0004\b=\u0010>\u001A\u0010\u0010?\u001A\u0002022\u0006\u0010\f\u001A\u00020\rH\u0002\u001A0\u0010@\u001A\u00020\u00032\u0006\u0010A\u001A\u00020\u00032\u0006\u0010B\u001A\u00020\u00032\u0006\u0010C\u001A\u00020\u00032\u0006\u0010D\u001A\u00020\u00032\u0006\u0010E\u001A\u00020\u0003H\u0002\u001A?\u0010@\u001A\u00020F2\u0006\u0010G\u001A\u00020\t2\u0006\u0010A\u001A\u00020\u00032\u0006\u0010B\u001A\u00020\u00032\u0006\u0010H\u001A\u00020F2\u0006\u0010D\u001A\u00020\u00032\u0006\u0010E\u001A\u00020\u0003H\u0002¢\u0006\u0004\bI\u0010J\u001A \u0010K\u001A\u00020\u00032\u0006\u0010L\u001A\u00020\u00032\u0006\u0010M\u001A\u00020\u00032\u0006\u0010N\u001A\u00020\u0003H\u0002\u001A\u001C\u0010O\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\b\u001A\u00020\tH\u0002\u001A\u001C\u0010P\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001A\u001A\u00020$2\u0006\u0010\b\u001A\u00020\tH\u0002\u001A\u001C\u0010Q\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001A\u001A\u00020$2\u0006\u0010\b\u001A\u00020\tH\u0002\u001A\f\u0010R\u001A\u00020S*\u00020\u0003H\u0002\u001A$\u0010T\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\b\u001A\u00020\tH\u0003\u001A,\u0010U\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001A\u001A\u00020$2\u0006\u0010!\u001A\u00020\u00132\u0006\u0010\"\u001A\u00020\u00132\u0006\u0010\b\u001A\u00020\tH\u0003\u001AC\u0010d\u001A\u00020\u00162\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\f\u001A\u00020\r2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000F2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BH\u0007¢\u0006\u0002\u0010e\u001AM\u0010f\u001A\u00020$2\b\b\u0002\u0010g\u001A\u00020\u00032\b\b\u0002\u0010h\u001A\u00020\u00032\b\b\u0003\u0010\f\u001A\u00020\r2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000F2\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BH\u0007¢\u0006\u0002\u0010i\u001A\u001D\u0010j\u001A\u00020F2\u0006\u0010k\u001A\u00020\u00032\u0006\u0010l\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010m\u001A\u001B\u0010j\u001A\u00020F2\f\u0010n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BH\u0001¢\u0006\u0002\u0010o\"\u0016\u0010V\u001A\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001A\u0004\bX\u0010Y\"\u0016\u0010[\u001A\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001A\u0004\b\\\u0010Y\"\u0010\u0010]\u001A\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010^\u001A\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010a\u001A\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010b\u001A\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010c\u001A\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u001E\u0010p\u001A\u00020\t*\u00020F8@X\u0081\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001A\u0004\bs\u0010t\"\u0014\u0010u\u001A\u00020vX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bw\u0010x¨\u0006y"}, d2={"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "thumb", "Landroidx/compose/material3/SliderState;", "Landroidx/compose/runtime/Composable;", "track", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "state", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "VerticalSlider", "reverseDirection", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "startInteractionSource", "endInteractionSource", "startThumb", "Landroidx/compose/material3/RangeSliderState;", "endThumb", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "slideOnKeyEvents", "onValueChangeState", "onValueChangeFinishedState", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "Landroidx/compose/material3/SliderRange;", "isStart", "x", "scale-2geJ7wY", "(ZFFJFF)J", "calcFraction", "a", "b", "pos", "sliderSemantics", "rangeSliderStartThumbSemantics", "rangeSliderEndThumbSemantics", "formatForSemantics", "", "sliderTapModifier", "rangeSliderPressDragModifier", "TrackHeight", "Landroidx/compose/ui/unit/Dp;", "getTrackHeight", "()F", "F", "ThumbWidth", "getThumbWidth", "ThumbHeight", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "VerticalThumbSize", "ThumbTrackGapSize", "TrackInsideCornerSize", "rememberSliderState", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SliderState;", "rememberRangeSliderState", "activeRangeStart", "activeRangeEnd", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RangeSliderState;", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "isSpecified", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "CornerSizeAlignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "getCornerSizeAlignmentLine", "()Landroidx/compose/ui/layout/VerticalAlignmentLine;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SliderKt {
    private static final VerticalAlignmentLine CornerSizeAlignmentLine;
    private static final float ThumbHeight;
    private static final long ThumbSize;
    private static final float ThumbTrackGapSize;
    private static final float ThumbWidth;
    private static final float TrackHeight;
    private static final float TrackInsideCornerSize;
    private static final long VerticalThumbSize;

    static {
        SliderKt.TrackHeight = SliderTokens.INSTANCE.getInactiveTrackHeight-D9Ej5fM();
        float v0 = SliderTokens.INSTANCE.getHandleWidth-D9Ej5fM();
        SliderKt.ThumbWidth = v0;
        float v1 = SliderTokens.INSTANCE.getHandleHeight-D9Ej5fM();
        SliderKt.ThumbHeight = v1;
        SliderKt.ThumbSize = DpKt.DpSize-YgX7TsA(v0, v1);
        SliderKt.VerticalThumbSize = DpKt.DpSize-YgX7TsA(v1, v0);
        SliderKt.ThumbTrackGapSize = SliderTokens.INSTANCE.getActiveHandleLeadingSpace-D9Ej5fM();
        SliderKt.TrackInsideCornerSize = Dp.constructor-impl(2f);
        SliderKt.CornerSizeAlignmentLine = new VerticalAlignmentLine(SliderKt$CornerSizeAlignmentLine$1.INSTANCE);
    }

    public static final void RangeSlider(RangeSliderState arg22, Modifier arg23, boolean arg24, SliderColors arg25, MutableInteractionSource arg26, MutableInteractionSource arg27, Function3 arg28, Function3 arg29, Function3 arg30, Composer arg31, int arg32, int arg33) {
        Function3 v7_2;
        MutableInteractionSource v6_1;
        boolean v3_4;
        Modifier v2_1;
        SliderColors v4;
        Composer v20;
        Function3 v19_1;
        ComposableLambda v18_2;
        ComposableLambda v17_2;
        Object v15_2;
        ComposableLambda v19_2;
        Companion v12_2;
        Function3 v9_2;
        ComposableLambda v9_1;
        Function3 v8_2;
        ComposableLambda v8_1;
        Object v14_2;
        MutableInteractionSource v5_2;
        Companion v0_3;
        int v18;
        int v17;
        int v15;
        MutableInteractionSource v14_1;
        int v12;
        MutableInteractionSource v9;
        int v8;
        SliderColors v7_1;
        boolean v6;
        int v5;
        RangeSliderState v13;
        int v2;
        int v10 = arg32;
        int v11 = arg33;
        Composer v1 = arg31.startRestartGroup(0xD170855D);
        ComposerKt.sourceInformation(v1, "C(RangeSlider)N(state,modifier,enabled,colors,startInteractionSource,endInteractionSource,startThumb,endThumb,track)729@33295L296:Slider.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
            v13 = arg22;
        }
        else {
            v13 = arg22;
            if((v10 & 6) == 0) {
                v2 = v1.changedInstance(v13) ? 4 : 2;
                v2 |= v10;
            }
            else {
                v2 = v10;
            }
        }

        int v3 = v11 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            v5 = v1.changed(arg23) ? 0x20 : 16;
            v2 |= v5;
        }

        v5 = v11 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg24;
            int v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg24;
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 8) == 0) {
                v7_1 = arg25;
                if(v1.changed(v7_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v7_1 = arg25;
            label_63:
                v8 = 0x400;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg25;
        }

        v8 = v11 & 16;
        if(v8 != 0) {
            v2 |= 0x6000;
            goto label_81;
        }
        else if((v10 & 0x6000) == 0) {
            v9 = arg26;
            v12 = v1.changed(v9) ? 0x4000 : 0x2000;
            v2 |= v12;
        }
        else {
        label_81:
            v9 = arg26;
        }

        v12 = v11 & 0x20;
        int v14 = 0x30000;
        if(v12 != 0) {
            v2 |= v14;
            goto label_97;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg27;
            v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_97:
            v14_1 = arg27;
        }

        v15 = v11 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            Function3 v0 = arg28;
            if((v10 & v16) == 0) {
                v17 = v1.changedInstance(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        int v0_1 = v11 & 0x80;
        v17 = 0xC00000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_129;
        }
        else if((v10 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changedInstance(arg29) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_129:
            v17 = v0_1;
        }

        v0_1 = v11 & 0x100;
        v18 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v18;
            goto label_147;
        }
        else if((v10 & v18) == 0) {
            v18 = v0_1;
            int v19 = v1.changedInstance(arg30) ? 0x4000000 : 0x2000000;
            v2 |= v19;
        }
        else {
        label_147:
            v18 = v0_1;
        }

        int v31 = v3;
        boolean v0_2 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "702@32359L8,703@32424L39,704@32518L39,705@32616L163,712@32836L161,719@33051L176");
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v31 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg23;
                }

                if(v5 != 0) {
                    v6 = true;
                }

                if((v11 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                    v7_1 = SliderDefaults.INSTANCE.colors(v1, 6);
                }

                String v3_1 = "CC(remember):Slider.kt#9igjgp";
                if(v8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v1, 929350180, v3_1);
                    Object v5_1 = v1.rememberedValue();
                    if(v5_1 == Composer.Companion.getEmpty()) {
                        v5_2 = InteractionSourceKt.MutableInteractionSource();
                        v1.updateRememberedValue(v5_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v1);
                }
                else {
                    v5_2 = v9;
                }

                if(v12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v1, 0x3764CDE4, v3_1);
                    Object v3_2 = v1.rememberedValue();
                    if(v3_2 == Composer.Companion.getEmpty()) {
                        MutableInteractionSource v3_3 = InteractionSourceKt.MutableInteractionSource();
                        v1.updateRememberedValue(v3_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v1);
                    v14_2 = v3_2;
                }

                v3 = 54;
                if(v15 != 0) {
                    v8_1 = ComposableLambdaKt.rememberComposableLambda(0x5F342E92, true, new SliderKt$RangeSlider$14(v5_2, v7_1, v6), v1, v3);
                }
                else {
                    v8_2 = arg28;
                }

                if(v17 != 0) {
                    v9_1 = ComposableLambdaKt.rememberComposableLambda(0x505935B9, true, new SliderKt$RangeSlider$15(((MutableInteractionSource)v14_2), v7_1, v6), v1, v3);
                }
                else {
                    v9_2 = arg29;
                }

                if(v18 != 0) {
                    v12_2 = v0_3;
                    v19_2 = ComposableLambdaKt.rememberComposableLambda(0xE4FBA9E9, true, new SliderKt$RangeSlider$16(v6, v7_1), v1, v3);
                }
                else {
                    v19_1 = arg30;
                    v12_2 = v0_3;
                }

                v15_2 = v5_2;
                v17_2 = v8_1;
                v18_2 = v9_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                Modifier v12_1 = arg23;
                Function3 v17_1 = arg28;
                Function3 v18_1 = arg29;
                v19_1 = arg30;
                MutableInteractionSource v15_1 = v9;
            }

            MutableInteractionSource v16_1 = ((MutableInteractionSource)v14_2);
            v0_1 = 0xD170855D;
            boolean v14_3 = v6;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.material3.RangeSlider (Slider.kt:726)");
            }

            if(v13.getSteps() >= 0) {
                v0_1 = v2 >> 3;
                v20 = v1;
                SliderKt.RangeSliderImpl(((Modifier)v12_2), v13, v14_3, ((MutableInteractionSource)v15_2), v16_1, ((Function3)v17_2), ((Function3)v18_2), ((Function3)v19_2), v20, v2 & 0x380 | (v0_1 & 14 | v2 << 3 & 0x70) | v0_1 & 0x1C00 | 0xE000 & v0_1 | 0x70000 & v0_1 | 0x380000 & v0_1 | v0_1 & 0x1C00000);
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v4 = v7_1;
                v2_1 = ((Modifier)v12_2);
                v3_4 = v14_3;
                v5_2 = ((MutableInteractionSource)v15_2);
                v6_1 = v16_1;
                v7_2 = ((Function3)v17_2);
                v8_2 = ((Function3)v18_2);
                v9_2 = ((Function3)v19_2);
                goto label_306;
            }

            throw new IllegalArgumentException("steps should be >= 0".toString());
        }
        else {
            v20 = v1;
            v20.skipToGroupEnd();
            v2_1 = arg23;
            v8_2 = arg29;
            v3_4 = v6;
            v4 = v7_1;
            v5_2 = v9;
            v6_1 = v14_1;
            v7_2 = arg28;
            v9_2 = arg30;
        }

    label_306:
        ScopeUpdateScope v12_3 = v20.endRestartGroup();
        if(v12_3 != null) {
            v12_3.updateScope(new SliderKt$$ExternalSyntheticLambda22(arg22, v2_1, v3_4, v4, v5_2, v6_1, v7_2, v8_2, v9_2, v10, v11));
        }
    }

    public static final void RangeSlider(ClosedFloatingPointRange arg28, Function1 arg29, Modifier arg30, boolean arg31, ClosedFloatingPointRange arg32, int arg33, Function0 arg34, SliderColors arg35, Composer arg36, int arg37, int arg38) {
        int v6_1;
        Function0 v7_2;
        ClosedFloatingPointRange v5_4;
        boolean v4_2;
        Modifier v3_1;
        SliderColors v8_1;
        Composer v24;
        MutableInteractionSource v5_3;
        MutableInteractionSource v2_2;
        SliderColors v4_1;
        ClosedFloatingPointRange v15_2;
        Modifier v13_1;
        Function0 v16_1;
        int v23;
        boolean v14_1;
        int v0_1;
        Companion v13_2;
        Modifier v0_3;
        Function0 v15_1;
        int v14;
        int v8;
        ClosedFloatingPointRange v7_1;
        boolean v6;
        int v5;
        Modifier v4;
        int v3;
        Function1 v12;
        ClosedFloatingPointRange v11;
        int v2;
        int v9 = arg37;
        int v10 = arg38;
        Composer v1 = arg36.startRestartGroup(-743091416);
        ComposerKt.sourceInformation(v1, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors)499@23112L39,500@23209L39,512@23627L187,519@23835L185,526@24038L200,502@23254L991:Slider.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v2 = v9 | 6;
            v11 = arg28;
        }
        else {
            v11 = arg28;
            if((v9 & 6) == 0) {
                v2 = v1.changed(v11) ? 4 : 2;
                v2 |= v9;
            }
            else {
                v2 = v9;
            }
        }

        if((v10 & 2) != 0) {
            v2 |= 0x30;
            v12 = arg29;
        }
        else {
            v12 = arg29;
            if((v9 & 0x30) == 0) {
                v3 = v1.changedInstance(v12) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = v10 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v9 & 0x180) == 0) {
            v4 = arg30;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_51:
            v4 = arg30;
        }

        v5 = v10 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v9 & 0xC00) == 0) {
            v6 = arg31;
            int v7 = v1.changed(v6) ? 0x800 : 0x400;
            v2 |= v7;
        }
        else {
        label_66:
            v6 = arg31;
        }

        if((v9 & 0x6000) == 0) {
            if((v10 & 16) == 0) {
                v7_1 = arg32;
                if(v1.changed(v7_1)) {
                    v8 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v7_1 = arg32;
            label_77:
                v8 = 0x2000;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg32;
        }

        v8 = v10 & 0x20;
        int v13 = 0x30000;
        if(v8 != 0) {
            v2 |= v13;
            goto label_96;
        }
        else if((v13 & v9) == 0) {
            v13 = arg33;
            v14 = v1.changed(v13) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_96:
            v13 = arg33;
        }

        v14 = v10 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_112;
        }
        else if((v15 & v9) == 0) {
            v15_1 = arg34;
            int v16 = v1.changedInstance(v15_1) ? 0x100000 : 0x80000;
            v2 |= v16;
        }
        else {
        label_112:
            v15_1 = arg34;
        }

        if((v9 & 0xC00000) == 0) {
            int v17 = (v10 & 0x80) != 0 || !v1.changed(arg35) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v36 = v2;
        int v18 = v3;
        boolean v0 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0, v36 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "497@23039L8");
            v2 = 0xFE3FFFFF;
            int v19 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v18 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = v4;
                }

                if(v5 != 0) {
                    v6 = true;
                }

                if((v10 & 16) != 0) {
                    v5 = v36 & v19;
                    v7_1 = RangesKt.rangeTo(0f, 1f);
                }
                else {
                    v5 = v36;
                }

                if(v8 != 0) {
                    v13 = 0;
                }

                if(v14 != 0) {
                    v15_1 = null;
                }

                if((v10 & 0x80) != 0) {
                    v4_1 = SliderDefaults.INSTANCE.colors(v1, 6);
                    v14_1 = v6;
                    v23 = v13;
                    v16_1 = v15_1;
                    v13_2 = ((Companion)v0_3);
                    v0_1 = v2 & v5;
                    v15_2 = v7_1;
                    v2 = -743091416;
                    goto label_211;
                }

                v4_1 = arg35;
                v14_1 = v6;
                v23 = v13;
                v16_1 = v15_1;
                v2 = -743091416;
                v13_2 = ((Companion)v0_3);
                v0_1 = v5;
                v15_2 = v7_1;
            }
            else {
                v1.skipToGroupEnd();
                v0_1 = (v10 & 16) != 0 ? v36 & v19 : v36;
                if((v10 & 0x80) != 0) {
                    v0_1 &= v2;
                }

                v14_1 = v6;
                v23 = v13;
                v16_1 = v15_1;
                v2 = -743091416;
                v13_1 = v4;
                v15_2 = v7_1;
                v4_1 = arg35;
            }

        label_211:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v0_1, -1, "androidx.compose.material3.RangeSlider (Slider.kt:498)");
            }

            String v5_1 = "CC(remember):Slider.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 0xBBAD67EF, v5_1);
            Object v2_1 = v1.rememberedValue();
            if(v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = InteractionSourceKt.MutableInteractionSource();
                v1.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 0xBBAD740F, v5_1);
            Object v5_2 = v1.rememberedValue();
            if(v5_2 == Composer.Companion.getEmpty()) {
                v5_3 = InteractionSourceKt.MutableInteractionSource();
                v1.updateRememberedValue(v5_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v24 = v1;
            SliderKt.RangeSlider(v11, v12, v13_1, v14_1, v15_2, v16_1, null, v2_2, v5_3, ComposableLambdaKt.rememberComposableLambda(0xCFA03A4B, true, new SliderKt$RangeSlider$1(v2_2, v4_1, v14_1), v1, 54), ComposableLambdaKt.rememberComposableLambda(-1832060001, true, new SliderKt$RangeSlider$2(v5_3, v4_1, v14_1), v1, 54), ComposableLambdaKt.rememberComposableLambda(377064480, true, new SliderKt$RangeSlider$3(v14_1, v4_1), v1, 54), v23, v24, v0_1 & 14 | 0x36C00000 | v0_1 & 0x70 | v0_1 & 0x380 | v0_1 & 0x1C00 | 0xE000 & v0_1 | v0_1 >> 3 & 0x70000, v0_1 >> 9 & 0x380 | 54, 0x40);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_1 = v4_1;
            v3_1 = v13_1;
            v4_2 = v14_1;
            v5_4 = v15_2;
            v7_2 = v16_1;
            v6_1 = v23;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v8_1 = arg35;
            v3_1 = v4;
            v4_2 = v6;
            v5_4 = v7_1;
            v6_1 = v13;
            v7_2 = v15_1;
        }

        ScopeUpdateScope v11_1 = v24.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new SliderKt$$ExternalSyntheticLambda1(arg28, arg29, v3_1, v4_2, v5_4, v6_1, v7_2, v8_1, v9, v10));
        }
    }

    public static final void RangeSlider(ClosedFloatingPointRange arg31, Function1 arg32, Modifier arg33, boolean arg34, ClosedFloatingPointRange arg35, Function0 arg36, SliderColors arg37, MutableInteractionSource arg38, MutableInteractionSource arg39, Function3 arg40, Function3 arg41, Function3 arg42, int arg43, Composer arg44, int arg45, int arg46, int arg47) {
        ClosedFloatingPointRange v5_5;
        Function3 v11_1;
        Function0 v6_4;
        Function3 v12_2;
        MutableInteractionSource v9_1;
        SliderColors v7_4;
        MutableInteractionSource v8_2;
        boolean v4_5;
        Function3 v10_3;
        RangeSliderState v5_4;
        Function3 v7_1;
        MutableInteractionSource v10_1;
        int v6_1;
        ClosedFloatingPointRange v0_2;
        Function3 v16_1;
        Function3 v5;
        boolean v8_1;
        ComposableLambda v16_2;
        Companion v13_2;
        ComposableLambda v36;
        ComposableLambda v35;
        Function3 v0_6;
        ComposableLambda v0_5;
        boolean v6_2;
        ClosedFloatingPointRange v34;
        Companion v33;
        Object v12_1;
        Object v10_2;
        Companion v0_3;
        int v18;
        int v28;
        int v27;
        int v26;
        MutableInteractionSource v12;
        SliderColors v9;
        Function0 v11;
        int v19;
        ClosedFloatingPointRange v6;
        int v17;
        int v16;
        Modifier v13;
        int v8;
        int v7;
        Function1 v2 = arg32;
        int v14 = arg45;
        int v15 = arg46;
        int v0 = arg47;
        Composer v3 = arg44.startRestartGroup(0x72B1D1A2);
        ComposerKt.sourceInformation(v3, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,onValueChangeFinished,colors,startInteractionSource,endInteractionSource,startThumb,endThumb,track,steps)626@28935L238,637@29257L44,641@29394L292:Slider.kt#uh7d8r");
        if((v0 & 1) != 0) {
            v7 = v14 | 6;
        }
        else if((v14 & 6) == 0) {
            v7 = v3.changed(arg31) ? 4 : 2;
            v7 |= v14;
        }
        else {
            v7 = v14;
        }

        if((v0 & 2) != 0) {
            v7 |= 0x30;
        }
        else if((v14 & 0x30) == 0) {
            v8 = v3.changedInstance(v2) ? 0x20 : 16;
            v7 |= v8;
        }

        v8 = v0 & 4;
        if(v8 != 0) {
            v7 |= 0x180;
            goto label_53;
        }
        else if((v14 & 0x180) == 0) {
            v13 = arg33;
            v16 = v3.changed(v13) ? 0x100 : 0x80;
            v7 |= v16;
        }
        else {
        label_53:
            v13 = arg33;
        }

        v16 = v0 & 8;
        if(v16 != 0) {
            v7 |= 0xC00;
        }
        else if((v14 & 0xC00) == 0) {
            v17 = v3.changed(arg34) ? 0x800 : 0x400;
            v7 |= v17;
        }

        if((v14 & 0x6000) == 0) {
            if((v0 & 16) == 0) {
                v6 = arg35;
                if(v3.changed(v6)) {
                    v19 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v6 = arg35;
            label_79:
                v19 = 0x2000;
            }

            v7 |= v19;
        }
        else {
            v6 = arg35;
        }

        v19 = v0 & 0x20;
        int v20 = 0x30000;
        if(v19 != 0) {
            v7 |= v20;
            v11 = arg36;
        }
        else {
            v11 = arg36;
            if((v14 & v20) == 0) {
                int v21 = v3.changedInstance(v11) ? 0x20000 : 0x10000;
                v7 |= v21;
            }
        }

        if((v14 & 0x180000) == 0) {
            v9 = arg37;
            int v22 = (v0 & 0x40) != 0 || !v3.changed(v9) ? 0x80000 : 0x100000;
            v7 |= v22;
        }
        else {
            v9 = arg37;
        }

        int v10 = v0 & 0x80;
        int v23 = 0xC00000;
        if(v10 != 0) {
            v7 |= v23;
            v12 = arg38;
        }
        else {
            v12 = arg38;
            if((v14 & v23) == 0) {
                int v24 = v3.changed(v12) ? 0x800000 : 0x400000;
                v7 |= v24;
            }
        }

        int v1 = v0 & 0x100;
        int v25 = 0x6000000;
        if(v1 != 0) {
            v7 |= v25;
            goto label_143;
        }
        else if((v14 & v25) == 0) {
            v25 = v1;
            v26 = v3.changed(arg39) ? 0x4000000 : 0x2000000;
            v7 |= v26;
        }
        else {
        label_143:
            v25 = v1;
        }

        v1 = v0 & 0x200;
        v26 = 0x30000000;
        if(v1 != 0) {
            v7 |= v26;
            goto label_161;
        }
        else if((v14 & v26) == 0) {
            v26 = v1;
            v27 = v3.changedInstance(arg40) ? 0x20000000 : 0x10000000;
            v7 |= v27;
        }
        else {
        label_161:
            v26 = v1;
        }

        v1 = v0 & 0x400;
        if(v1 != 0) {
            v17 = v15 | 6;
            v27 = v1;
        }
        else if((v15 & 6) == 0) {
            v27 = v1;
            v17 = v3.changedInstance(arg41) ? 4 : 2;
            v17 |= v15;
        }
        else {
            v27 = v1;
            v17 = v15;
        }

        v1 = v0 & 0x800;
        if(v1 != 0) {
            v17 |= 0x30;
            v28 = v1;
        }
        else if((v15 & 0x30) == 0) {
            v28 = v1;
            v18 = v3.changedInstance(arg42) ? 0x20 : 16;
            v17 |= v18;
        }
        else {
            v28 = v1;
        }

        v1 = v17;
        int v4 = v0 & 0x1000;
        if(v4 != 0) {
            v1 |= 0x180;
        }
        else if((v15 & 0x180) == 0) {
            v20 = v3.changed(arg43) ? 0x100 : 0x80;
            v1 |= v20;
        }

        v17 = v4;
        v18 = 0;
        boolean v0_1 = (v7 & 306783379) != 306783378 || (v1 & 0x93) != 0x92 ? true : false;
        if(v3.shouldExecute(v0_1, v7 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "599@27997L8,600@28062L39,601@28156L39,602@28254L163,609@28474L161,616@28689L176");
            String v4_1 = "CC(remember):Slider.kt#9igjgp";
            if((v14 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v8 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = v13;
                }

                v8_1 = v16 != 0 ? true : arg34;
                if((arg47 & 16) != 0) {
                    v6 = RangesKt.rangeTo(0f, 1f);
                    v7 &= 0xFFFF1FFF;
                }

                if(v19 != 0) {
                    v11 = null;
                }

                if((arg47 & 0x40) != 0) {
                    v9 = SliderDefaults.INSTANCE.colors(v3, 6);
                    v7 &= 0xFFC7FFFF;
                }

                if(v10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, -1920718807, v4_1);
                    v10_2 = v3.rememberedValue();
                    if(v10_2 == Composer.Companion.getEmpty()) {
                        v10_1 = InteractionSourceKt.MutableInteractionSource();
                        v3.updateRememberedValue(v10_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                }
                else {
                    v10_1 = v12;
                }

                if(v25 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, -1920715799, v4_1);
                    v12_1 = v3.rememberedValue();
                    if(v12_1 == Composer.Companion.getEmpty()) {
                        v12 = InteractionSourceKt.MutableInteractionSource();
                        v3.updateRememberedValue(v12);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                }
                else {
                    v12 = arg39;
                }

                int v13_1 = 54;
                if(v26 != 0) {
                    v33 = v0_3;
                    v34 = v6;
                    v6_2 = true;
                    v0_5 = ComposableLambdaKt.rememberComposableLambda(-743960051, true, new SliderKt$RangeSlider$7(((MutableInteractionSource)v10_2), v9, v8_1), v3, v13_1);
                }
                else {
                    v33 = v0_3;
                    v34 = v6;
                    v6_2 = true;
                    v0_6 = arg40;
                }

                if(v27 != 0) {
                    v35 = ((ComposableLambda)v0_6);
                    v0_5 = ComposableLambdaKt.rememberComposableLambda(0x4DE370C6, v6_2, new SliderKt$RangeSlider$8(((MutableInteractionSource)v12_1), v9, v8_1), v3, v13_1);
                }
                else {
                    v35 = ((ComposableLambda)v0_6);
                    v0_6 = arg41;
                }

                if(v28 != 0) {
                    v36 = ((ComposableLambda)v0_6);
                    v0_5 = ComposableLambdaKt.rememberComposableLambda(0xB66FD296, v6_2, new SliderKt$RangeSlider$9(v8_1, v9), v3, v13_1);
                }
                else {
                    v36 = ((ComposableLambda)v0_6);
                    v0_6 = arg42;
                }

                v13_2 = v33;
                ComposableLambda v5_1 = v35;
                if(v17 != 0) {
                    v16_2 = ((ComposableLambda)v0_6);
                    v6_1 = v7;
                    v17 = 0;
                }
                else {
                    v17 = arg43;
                    v16_2 = ((ComposableLambda)v0_6);
                    v6_1 = v7;
                }

                v0_2 = v34;
                ComposableLambda v7_2 = v36;
            }
            else {
                v3.skipToGroupEnd();
                if((arg47 & 16) != 0) {
                    v7 &= 0xFFFF1FFF;
                }

                if((arg47 & 0x40) != 0) {
                    v7 &= 0xFFC7FFFF;
                }

                v8_1 = arg34;
                v5 = arg40;
                v16_1 = arg42;
                v17 = arg43;
                v0_2 = v6;
                v6_1 = v7;
                v10_1 = v12;
                v12 = arg39;
                v7_1 = arg41;
            }

            v3.endDefaults();
            Function3 v39 = v5;
            if(ComposerKt.isTraceInProgress()) {
                arg40 = v7_1;
                ComposerKt.traceEventStart(0x72B1D1A2, v6_1, v1, "androidx.compose.material3.RangeSlider (Slider.kt:624)");
            }
            else {
                arg40 = v7_1;
            }

            ComposerKt.sourceInformationMarkerStart(v3, 0x8D849610, v4_1);
            int v5_2 = (v1 & 0x380) == 0x100 ? 1 : 0;
            v19 = v1;
            v1 = 0x4000;
            v1 = (0xE000 & v6_1 ^ 0x6000) > v1 && (v3.changed(v0_2)) || (v6_1 & 0x6000) == v1 ? 1 : 0;
            v1 |= v5_2;
            Object v5_3 = v3.rememberedValue();
            if(v1 != 0 || v5_3 == Composer.Companion.getEmpty()) {
                v5_4 = new RangeSliderState(arg31.getStart().floatValue(), arg31.getEndInclusive().floatValue(), v17, v11, v0_2);
                v1 = v17;
                v3.updateRememberedValue(v5_4);
            }
            else {
                v1 = v17;
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v5_4.setOnValueChangeFinished(v11);
            ComposerKt.sourceInformationMarkerStart(v3, -1920680562, v4_1);
            if((v6_1 & 0x70) == 0x20) {
                v18 = 1;
            }

            Object v4_2 = v3.rememberedValue();
            if(v18 != 0 || v4_2 == Composer.Companion.getEmpty()) {
                SliderKt$$ExternalSyntheticLambda16 v4_3 = new SliderKt$$ExternalSyntheticLambda16(v2);
                v3.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v5_4.setOnValueChange$material3(((Function1)v4_2));
            v5_4.setActiveRangeStart(arg31.getStart().floatValue());
            v5_4.setActiveRangeEnd(arg31.getEndInclusive().floatValue());
            v4 = v6_1 >> 3 & 0x3F0;
            v6_1 >>= 9;
            v4 = v4 | 0xE000 & v6_1 | 0x70000 & v6_1 | v6_1 & 0x380000;
            v6_1 = v19 << 21;
            SliderKt.RangeSlider(v5_4, ((Modifier)v13_2), v8_1, null, ((MutableInteractionSource)v10_2), ((MutableInteractionSource)v12_1), v39, arg40, v16_1, v3, v4 | 0x1C00000 & v6_1 | v6_1 & 0xE000000, 8);
            Function3 v4_4 = v39;
            v5 = arg40;
            Function3 v6_3 = v16_1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            MutableInteractionSource v7_3 = ((MutableInteractionSource)v10_2);
            v10_3 = v4_4;
            v4_5 = v8_1;
            v8_2 = v7_3;
            v7_4 = v9;
            v9_1 = ((MutableInteractionSource)v12_1);
            v12_2 = v6_3;
            v6_4 = v11;
            v11_1 = v5;
            v5_5 = v0_2;
        }
        else {
            v3.skipToGroupEnd();
            v4_5 = arg34;
            v10_3 = arg40;
            v1 = arg43;
            v5_5 = v6;
            v7_4 = v9;
            v6_4 = v11;
            v8_2 = v12;
            v9_1 = arg39;
            v11_1 = arg41;
            v12_2 = arg42;
        }

        ScopeUpdateScope v0_7 = v3.endRestartGroup();
        if(v0_7 != null) {
            v0_7.updateScope(new SliderKt$$ExternalSyntheticLambda17(arg31, v2, ((Modifier)v13_2), v4_5, v5_5, v6_4, v7_4, v8_2, v9_1, v10_3, v11_1, v12_2, v1, v14, v15, arg47));
        }
    }

    static final Unit RangeSlider$lambda$13(ClosedFloatingPointRange arg12, Function1 arg13, Modifier arg14, boolean arg15, ClosedFloatingPointRange arg16, int arg17, Function0 arg18, SliderColors arg19, int arg20, int arg21, Composer arg22, int arg23) {
        SliderKt.RangeSlider(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit RangeSlider$lambda$18$lambda$17(Function1 arg3, SliderRange arg4) {
        arg3.invoke(RangesKt.rangeTo(SliderRange.getStart-impl(arg4.unbox-impl()), SliderRange.getEndInclusive-impl(arg4.unbox-impl())));
        return Unit.INSTANCE;
    }

    static final Unit RangeSlider$lambda$19(ClosedFloatingPointRange arg18, Function1 arg19, Modifier arg20, boolean arg21, ClosedFloatingPointRange arg22, Function0 arg23, SliderColors arg24, MutableInteractionSource arg25, MutableInteractionSource arg26, Function3 arg27, Function3 arg28, Function3 arg29, int arg30, int arg31, int arg32, int arg33, Composer arg34, int arg35) {
        SliderKt.RangeSlider(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg31 | 1), RecomposeScopeImplKt.updateChangedFlags(arg32), arg33);
        return Unit.INSTANCE;
    }

    static final Unit RangeSlider$lambda$23(RangeSliderState arg13, Modifier arg14, boolean arg15, SliderColors arg16, MutableInteractionSource arg17, MutableInteractionSource arg18, Function3 arg19, Function3 arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        SliderKt.RangeSlider(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    private static final void RangeSliderImpl(Modifier arg23, RangeSliderState arg24, boolean arg25, MutableInteractionSource arg26, MutableInteractionSource arg27, Function3 arg28, Function3 arg29, Function3 arg30, Composer arg31, int arg32) {
        Function3 v9_8;
        SliderKt$$ExternalSyntheticLambda5 v11_5;
        SliderKt$RangeSliderImpl$2$1 v9_2;
        int v12;
        int v11;
        Modifier v10;
        RangeSliderState v2 = arg24;
        boolean v3 = arg25;
        MutableInteractionSource v4 = arg26;
        MutableInteractionSource v5 = arg27;
        Function3 v6 = arg28;
        Function3 v7 = arg29;
        Function3 v8 = arg30;
        int v9 = arg32;
        int v0 = 0xEEDD94DA;
        Composer v1 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(RangeSliderImpl)N(modifier,state,enabled,startInteractionSource,endInteractionSource,startThumb,endThumb,track)971@42967L7,981@43221L35,982@43289L33,1025@45118L3284,984@43328L5074:Slider.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v10 = arg23;
            v11 = v1.changed(v10) ? 4 : 2;
            v11 |= v9;
        }
        else {
            v10 = arg23;
            v11 = v9;
        }

        if((v9 & 0x30) == 0) {
            v12 = v1.changedInstance(v2) ? 0x20 : 16;
            v11 |= v12;
        }

        if((v9 & 0x180) == 0) {
            v12 = v1.changed(v3) ? 0x100 : 0x80;
            v11 |= v12;
        }

        if((v9 & 0xC00) == 0) {
            v12 = v1.changed(v4) ? 0x800 : 0x400;
            v11 |= v12;
        }

        if((v9 & 0x6000) == 0) {
            v12 = v1.changed(v5) ? 0x4000 : 0x2000;
            v11 |= v12;
        }

        if((0x30000 & v9) == 0) {
            v12 = v1.changedInstance(v6) ? 0x20000 : 0x10000;
            v11 |= v12;
        }

        if((0x180000 & v9) == 0) {
            v12 = v1.changedInstance(v7) ? 0x100000 : 0x80000;
            v11 |= v12;
        }

        if((0xC00000 & v9) == 0) {
            v12 = v1.changedInstance(v8) ? 0x800000 : 0x400000;
            v11 |= v12;
        }

        boolean v12_1 = (0x492493 & v11) != 4793490 ? true : false;
        if(v1.shouldExecute(v12_1, v11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v11, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:970)");
            }

            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v1.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            boolean v0_3 = v0_2 == LayoutDirection.Rtl ? true : false;
            v2.setRtl$material3(v0_3);
            Modifier v0_4 = SliderKt.rangeSliderPressDragModifier(Modifier.Companion, v2, v4, v5, v3);
            String v12_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.range_start), v1, 0);
            String v13 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.range_end), v1, 0);
            v0_4 = SizeKt.requiredSizeIn-qDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(v10), SliderKt.ThumbWidth, SliderKt.TrackHeight, 0f, 0f, 12, null).then(v0_4);
            String v15 = "CC(remember):Slider.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 0xADCD1B0E, v15);
            boolean v14 = v1.changedInstance(v2);
            Object v9_1 = v1.rememberedValue();
            if((v14) || v9_1 == Composer.Companion.getEmpty()) {
                v9_2 = new SliderKt$RangeSliderImpl$2$1(v2);
                v1.updateRememberedValue(v9_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            String v10_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, v10_1);
            int v18 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v14_1 = v1.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v1, v0_4);
            int v20 = v11;
            Function0 v11_1 = ComposeUiNode.Companion.getConstructor();
            String v7_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, v7_1);
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v11_1);
            }
            else {
                v1.useNode();
            }

            Composer v8_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v8_1, v9_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_1, v14_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v9_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v8_1.getInserting()) || !Intrinsics.areEqual(v8_1.rememberedValue(), Integer.valueOf(v18))) {
                v8_1.updateRememberedValue(Integer.valueOf(v18));
                v8_1.apply(Integer.valueOf(v18), v9_3);
            }

            Updater.set-impl(v8_1, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, -1046432705, "C990@43545L171,995@43849L100,986@43358L723,1006@44279L167,1011@44577L98,1002@44094L709,1018@44816L79:Slider.kt#uh7d8r");
            v0_4 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(v1, 1905911374, v15);
            boolean v11_2 = v1.changedInstance(v2);
            Object v14_2 = v1.rememberedValue();
            if((v11_2) || v14_2 == Composer.Companion.getEmpty()) {
                SliderKt$$ExternalSyntheticLambda3 v14_3 = new SliderKt$$ExternalSyntheticLambda3(v2);
                v1.updateRememberedValue(v14_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0_4 = SliderKt.rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(v0_4, ((Function1)v14_2)), v2, v3);
            ComposerKt.sourceInformationMarkerStart(v1, 0x719A0C07, v15);
            v11_2 = v1.changed(v12_2);
            v14_2 = v1.rememberedValue();
            if((v11_2) || v14_2 == Composer.Companion.getEmpty()) {
                SliderKt$$ExternalSyntheticLambda4 v14_4 = new SliderKt$$ExternalSyntheticLambda4(v12_2);
                v1.updateRememberedValue(v14_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0_4 = FocusableKt.focusable(SemanticsModifierKt.semantics(v0_4, true, ((Function1)v14_2)), v3, v4);
            v12_2 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v1, 0x2BB5B5D7, v12_2);
            MeasurePolicy v14_5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, v10_1);
            int v8_2 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v11_3 = v1.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v1, v0_4);
            Function0 v9_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, v7_1);
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v9_4);
            }
            else {
                v1.useNode();
            }

            Composer v4_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v4_1, v14_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v4_1, v11_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v9_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v4_1.getInserting()) || !Intrinsics.areEqual(v4_1.rememberedValue(), Integer.valueOf(v8_2))) {
                v4_1.updateRememberedValue(Integer.valueOf(v8_2));
                v4_1.apply(Integer.valueOf(v8_2), v9_3);
            }

            Updater.set-impl(v4_1, v0_4, ComposeUiNode.Companion.getSetModifier());
            String v4_2 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v1, 0x800B7D29, v4_2);
            ComposerKt.sourceInformationMarkerStart(v1, 239610549, "C1000@44050L17:Slider.kt#uh7d8r");
            v8_2 = v20 >> 3 & 14;
            v6.invoke(v2, v1, Integer.valueOf(v20 >> 12 & 0x70 | v8_2));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            Modifier v9_5 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(v1, 0x719A420A, v15);
            v0_3 = v1.changedInstance(v2);
            Object v11_4 = v1.rememberedValue();
            if((v0_3) || v11_4 == Composer.Companion.getEmpty()) {
                v11_5 = new SliderKt$$ExternalSyntheticLambda5(v2);
                v1.updateRememberedValue(v11_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0_4 = SliderKt.rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(v9_5, ((Function1)v11_5)), v2, v3);
            ComposerKt.sourceInformationMarkerStart(v1, 0x719A6705, v15);
            boolean v9_6 = v1.changed(v13);
            v11_4 = v1.rememberedValue();
            if((v9_6) || v11_4 == Composer.Companion.getEmpty()) {
                SliderKt$$ExternalSyntheticLambda6 v11_6 = new SliderKt$$ExternalSyntheticLambda6(v13);
                v1.updateRememberedValue(v11_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0_4 = FocusableKt.focusable(SemanticsModifierKt.semantics(v0_4, true, ((Function1)v11_4)), v3, v5);
            ComposerKt.sourceInformationMarkerStart(v1, 0x2BB5B5D7, v12_2);
            MeasurePolicy v9_7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, v10_1);
            v11 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v13_1 = v1.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v1, v0_4);
            Function0 v14_6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, v7_1);
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v14_6);
            }
            else {
                v1.useNode();
            }

            Composer v14_7 = Updater.constructor-impl(v1);
            Updater.set-impl(v14_7, v9_7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v14_7, v13_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v9_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v14_7.getInserting()) || !Intrinsics.areEqual(v14_7.rememberedValue(), Integer.valueOf(v11))) {
                v14_7.updateRememberedValue(Integer.valueOf(v11));
                v14_7.apply(Integer.valueOf(v11), v9_3);
            }

            Updater.set-impl(v14_7, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, 0x800B7D29, v4_2);
            ComposerKt.sourceInformationMarkerStart(v1, 85810862, "C1016@44774L15:Slider.kt#uh7d8r");
            v9_8 = arg29;
            v9_8.invoke(v2, v1, Integer.valueOf(v20 >> 15 & 0x70 | v8_2));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            v0_4 = LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(v1, 0x2BB5B5D7, v12_2);
            MeasurePolicy v11_7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, v10_1);
            int v10_2 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v12_3 = v1.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v1, v0_4);
            Function0 v13_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, v7_1);
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v13_2);
            }
            else {
                v1.useNode();
            }

            Composer v7_2 = Updater.constructor-impl(v1);
            Updater.set-impl(v7_2, v11_7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_2, v12_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v7_2.getInserting()) || !Intrinsics.areEqual(v7_2.rememberedValue(), Integer.valueOf(v10_2))) {
                v7_2.updateRememberedValue(Integer.valueOf(v10_2));
                v7_2.apply(Integer.valueOf(v10_2), v11_8);
            }

            Updater.set-impl(v7_2, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, 0x800B7D29, v4_2);
            ComposerKt.sourceInformationMarkerStart(v1, 0xC5A30412, "C1018@44881L12:Slider.kt#uh7d8r");
            Integer v0_5 = Integer.valueOf(v20 >> 18 & 0x70 | v8_2);
            v8 = arg30;
            v8.invoke(v2, v1, v0_5);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_475;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9_8 = v7;
            v1.skipToGroupEnd();
        }

    label_475:
        ScopeUpdateScope v10_3 = v1.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new SliderKt$$ExternalSyntheticLambda7(arg23, v2, v3, arg26, v5, v6, v9_8, v8, arg32));
        }
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$34$lambda$33(RangeSliderState arg4, IntSize arg5) {
        arg4.setStartThumbWidth$material3(((float)(((int)(arg5.unbox-impl() >> 0x20)))));
        arg4.setStartThumbHeight$material3(((float)(((int)(arg5.unbox-impl() & 0xFFFFFFFFL)))));
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$36$lambda$35(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$39$lambda$38(RangeSliderState arg4, IntSize arg5) {
        arg4.setEndThumbWidth$material3(((float)(((int)(arg5.unbox-impl() >> 0x20)))));
        arg4.setEndThumbHeight$material3(((float)(((int)(arg5.unbox-impl() & 0xFFFFFFFFL)))));
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$44$lambda$41$lambda$40(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit RangeSliderImpl$lambda$46(Modifier arg11, RangeSliderState arg12, boolean arg13, MutableInteractionSource arg14, MutableInteractionSource arg15, Function3 arg16, Function3 arg17, Function3 arg18, int arg19, Composer arg20, int arg21) {
        SliderKt.RangeSliderImpl(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    public static final void Slider(float arg26, Function1 arg27, Modifier arg28, boolean arg29, Function0 arg30, SliderColors arg31, MutableInteractionSource arg32, int arg33, Function3 arg34, Function3 arg35, ClosedFloatingPointRange arg36, Composer arg37, int arg38, int arg39, int arg40) {
        Function0 v5_2;
        SliderColors v6_3;
        MutableInteractionSource v7_3;
        Function3 v10_1;
        boolean v4_3;
        Function3 v9_2;
        ClosedFloatingPointRange v11_1;
        Function3 v4_1;
        ClosedFloatingPointRange v9_1;
        ComposableLambda v7_2;
        Function3 v0_5;
        int v28;
        Object v6_1;
        Companion v8_1;
        int v23;
        int v22;
        int v20;
        int v5;
        MutableInteractionSource v6;
        int v16;
        SliderColors v15_1;
        Function0 v13;
        int v11;
        boolean v10;
        int v9;
        Modifier v8;
        int v7;
        int v4;
        float v1 = arg26;
        Function1 v2 = arg27;
        int v12 = arg38;
        int v14 = arg40;
        Composer v3 = arg37.startRestartGroup(0x3AC3AB6F);
        ComposerKt.sourceInformation(v3, "C(Slider)N(value,onValueChange,modifier,enabled,onValueChangeFinished,colors,interactionSource,steps,thumb,track,valueRange)294@13990L92,299@14208L185:Slider.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v4 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v12;
        }
        else {
            v4 = v12;
        }

        if((v14 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v7 = v3.changedInstance(v2) ? 0x20 : 16;
            v4 |= v7;
        }

        v7 = v14 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_49;
        }
        else if((v12 & 0x180) == 0) {
            v8 = arg28;
            v9 = v3.changed(v8) ? 0x100 : 0x80;
            v4 |= v9;
        }
        else {
        label_49:
            v8 = arg28;
        }

        v9 = v14 & 8;
        if(v9 != 0) {
            v4 |= 0xC00;
            goto label_64;
        }
        else if((v12 & 0xC00) == 0) {
            v10 = arg29;
            v11 = v3.changed(v10) ? 0x800 : 0x400;
            v4 |= v11;
        }
        else {
        label_64:
            v10 = arg29;
        }

        v11 = v14 & 16;
        if(v11 != 0) {
            v4 |= 0x6000;
            goto label_79;
        }
        else if((v12 & 0x6000) == 0) {
            v13 = arg30;
            int v15 = v3.changedInstance(v13) ? 0x4000 : 0x2000;
            v4 |= v15;
        }
        else {
        label_79:
            v13 = arg30;
        }

        if((0x30000 & v12) == 0) {
            if((v14 & 0x20) == 0) {
                v15_1 = arg31;
                if(v3.changed(v15_1)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_91;
                }
            }
            else {
                v15_1 = arg31;
            label_91:
                v16 = 0x10000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg31;
        }

        v16 = v14 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v4 |= v17;
            v6 = arg32;
        }
        else {
            v6 = arg32;
            if((v12 & v17) == 0) {
                v17 = v3.changed(v6) ? 0x100000 : 0x80000;
                v4 |= v17;
            }
        }

        int v0 = v14 & 0x80;
        int v19 = 0xC00000;
        if(v0 != 0) {
            v4 |= v19;
        }
        else {
            v5 = arg33;
            if((v12 & v19) == 0) {
                v20 = v3.changed(v5) ? 0x800000 : 0x400000;
                v4 |= v20;
            }
        }

        v20 = v0;
        v0 = v14 & 0x100;
        int v21 = 0x6000000;
        if(v0 != 0) {
            v4 |= v21;
            goto label_142;
        }
        else if((v12 & v21) == 0) {
            v21 = v0;
            v22 = v3.changedInstance(arg34) ? 0x4000000 : 0x2000000;
            v4 |= v22;
        }
        else {
        label_142:
            v21 = v0;
        }

        v0 = v14 & 0x200;
        v22 = 0x30000000;
        if(v0 != 0) {
            v4 |= v22;
            goto label_160;
        }
        else if((v12 & v22) == 0) {
            v22 = v0;
            v23 = v3.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v4 |= v23;
        }
        else {
        label_160:
            v22 = v0;
        }

        if((arg39 & 6) == 0) {
            v23 = (v14 & 0x400) != 0 || !v3.changed(arg36) ? 2 : 4;
            v23 |= arg39;
        }
        else {
            v23 = arg39;
        }

        int v24 = v4;
        int v25 = 0;
        boolean v0_1 = (v4 & 306783379) != 306783378 || (v23 & 3) != 2 ? true : false;
        if(v3.shouldExecute(v0_1, v24 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "278@13393L8,279@13453L39,281@13581L158,288@13788L114");
            int v18 = 0xFFF8FFFF;
            v4 = 6;
            if((v12 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v7 != 0) {
                    v8_1 = Modifier.Companion;
                }

                if(v9 != 0) {
                    v10 = true;
                }

                if(v11 != 0) {
                    v13 = null;
                }

                if((v14 & 0x20) != 0) {
                    v7 = v24 & v18;
                    v15_1 = SliderDefaults.INSTANCE.colors(v3, v4);
                }
                else {
                    v7 = v24;
                }

                if(v16 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, -1736002634, "CC(remember):Slider.kt#9igjgp");
                    Object v0_2 = v3.rememberedValue();
                    if(v0_2 == Composer.Companion.getEmpty()) {
                        MutableInteractionSource v0_3 = InteractionSourceKt.MutableInteractionSource();
                        v3.updateRememberedValue(v0_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    v6_1 = v0_2;
                }

                v0 = v20 != 0 ? 0 : arg33;
                if(v21 != 0) {
                    ComposableLambda v4_2 = ComposableLambdaKt.rememberComposableLambda(-1689130945, true, new SliderKt$Slider$6(v6, v15_1, v10), v3, 54);
                }
                else {
                    v4_1 = arg34;
                }

                if(v22 != 0) {
                    v28 = v0;
                    ComposableLambda v0_4 = ComposableLambdaKt.rememberComposableLambda(0xEE726334, true, new SliderKt$Slider$7(v10, v15_1), v3, 54);
                }
                else {
                    v28 = v0;
                    v0_5 = arg35;
                }

                if((v14 & 0x400) != 0) {
                    v9_1 = RangesKt.rangeTo(0f, 1f);
                    v23 &= -15;
                }
                else {
                    v9_1 = arg36;
                }

                v5 = v7;
                v11 = v23;
                v7_2 = ((ComposableLambda)v0_5);
                v0 = v28;
            }
            else {
                v3.skipToGroupEnd();
                if((v14 & 0x20) != 0) {
                    v24 &= v18;
                }

                if((v14 & 0x400) != 0) {
                    v23 &= -15;
                }

                v0 = arg33;
                Function3 v7_1 = arg35;
                v9_1 = arg36;
                v11 = v23;
                v5 = v24;
                v4_1 = arg34;
            }

            v3.endDefaults();
            Function3 v33 = v4_1;
            if(ComposerKt.isTraceInProgress()) {
                arg32 = v6;
                ComposerKt.traceEventStart(0x3AC3AB6F, v5, v11, "androidx.compose.material3.Slider (Slider.kt:292)");
            }
            else {
                arg32 = v6;
            }

            ComposerKt.sourceInformationMarkerStart(v3, 0x9886F70B, "CC(remember):Slider.kt#9igjgp");
            v4 = (0x1C00000 & v5) == 0x800000 ? 1 : 0;
            v28 = v4;
            v4 = 4;
            if((v11 & 14 ^ 6) > v4 && (v3.changed(v9_1)) || (v11 & 6) == v4) {
                v25 = 1;
            }

            v6_1 = v3.rememberedValue();
            if((v28 | v25) != 0 || v6_1 == Composer.Companion.getEmpty()) {
                SliderState v6_2 = new SliderState(v1, v0, v13, v9_1);
                v3.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ((SliderState)v6_1).setOnValueChangeFinished(v13);
            ((SliderState)v6_1).setOnValueChange(v2);
            ((SliderState)v6_1).setValue(v1);
            v4 = v5 >> 3 & 0x3F0 | v5 >> 6 & 0xE000;
            v5 >>= 9;
            SliderKt.Slider(v6_1, ((Modifier)v8_1), v10, null, arg32, v33, ((Function3)v7_2), v3, v4 | 0x70000 & v5 | v5 & 0x380000, 8);
            v6 = arg32;
            v4_1 = v33;
            Function3 v5_1 = ((Function3)v7_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v11_1 = v9_1;
            v9_2 = v4_1;
            v4_3 = v10;
            v10_1 = v5_1;
            v7_3 = v6;
            v6_3 = v15_1;
            v5_2 = v13;
        }
        else {
            v3.skipToGroupEnd();
            v0 = arg33;
            v9_2 = arg34;
            v11_1 = arg36;
            v4_3 = v10;
            v10_1 = arg35;
            v7_3 = v6;
            v5_2 = v13;
            v6_3 = v15_1;
        }

        ScopeUpdateScope v15_2 = v3.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new SliderKt$$ExternalSyntheticLambda11(v1, v2, ((Modifier)v8_1), v4_3, v5_2, v6_3, v7_3, v0, v9_2, v10_1, v11_1, v12, arg39, v14));
        }
    }

    public static final void Slider(SliderState arg17, Modifier arg18, boolean arg19, SliderColors arg20, MutableInteractionSource arg21, Function3 arg22, Function3 arg23, Composer arg24, int arg25, int arg26) {
        Function3 v6_2;
        MutableInteractionSource v5_1;
        boolean v3;
        Modifier v2_3;
        SliderColors v4_1;
        MutableInteractionSource v12_2;
        Function3 v13_1;
        boolean v11_1;
        Companion v9_3;
        MutableInteractionSource v2_2;
        Modifier v0_2;
        Function3 v14_1;
        int v13;
        Function3 v12_1;
        int v11;
        MutableInteractionSource v9;
        int v7;
        SliderColors v6_1;
        boolean v5;
        int v4;
        SliderState v10;
        int v1;
        int v8 = arg25;
        Composer v15 = arg24.startRestartGroup(0x186DFF48);
        ComposerKt.sourceInformation(v15, "C(Slider)N(state,modifier,enabled,colors,interactionSource,thumb,track)374@17399L189:Slider.kt#uh7d8r");
        if((arg26 & 1) != 0) {
            v1 = v8 | 6;
            v10 = arg17;
        }
        else {
            v10 = arg17;
            if((v8 & 6) == 0) {
                v1 = v15.changedInstance(v10) ? 4 : 2;
                v1 |= v8;
            }
            else {
                v1 = v8;
            }
        }

        int v2 = arg26 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((v8 & 0x30) == 0) {
            v4 = v15.changed(arg18) ? 0x20 : 16;
            v1 |= v4;
        }

        v4 = arg26 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v5 = arg19;
            int v6 = v15.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_51:
            v5 = arg19;
        }

        if((v8 & 0xC00) == 0) {
            if((arg26 & 8) == 0) {
                v6_1 = arg20;
                if(v15.changed(v6_1)) {
                    v7 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v6_1 = arg20;
            label_62:
                v7 = 0x400;
            }

            v1 |= v7;
        }
        else {
            v6_1 = arg20;
        }

        v7 = arg26 & 16;
        if(v7 != 0) {
            v1 |= 0x6000;
            goto label_80;
        }
        else if((v8 & 0x6000) == 0) {
            v9 = arg21;
            v11 = v15.changed(v9) ? 0x4000 : 0x2000;
            v1 |= v11;
        }
        else {
        label_80:
            v9 = arg21;
        }

        v11 = arg26 & 0x20;
        int v12 = 0x30000;
        if(v11 != 0) {
            v1 |= v12;
            goto label_96;
        }
        else if((v12 & v8) == 0) {
            v12_1 = arg22;
            v13 = v15.changedInstance(v12_1) ? 0x20000 : 0x10000;
            v1 |= v13;
        }
        else {
        label_96:
            v12_1 = arg22;
        }

        v13 = arg26 & 0x40;
        int v14 = 0x180000;
        if(v13 != 0) {
            v1 |= v14;
            goto label_112;
        }
        else if((v14 & v8) == 0) {
            v14_1 = arg23;
            int v16 = v15.changedInstance(v14_1) ? 0x100000 : 0x80000;
            v1 |= v16;
        }
        else {
        label_112:
            v14_1 = arg23;
        }

        int v24 = v2;
        boolean v0 = (v1 & 0x92493) != 0x92492 ? true : false;
        if(v15.shouldExecute(v0, v1 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "359@16862L8,360@16922L39,361@17010L158,368@17217L114");
            if((v8 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v24 != 0) {
                    Companion v0_1 = Modifier.Companion;
                }
                else {
                    v0_2 = arg18;
                }

                if(v4 != 0) {
                    v5 = true;
                }

                if((arg26 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                    v6_1 = SliderDefaults.INSTANCE.colors(v15, 6);
                }

                if(v7 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v15, 0xB4EB6B6F, "CC(remember):Slider.kt#9igjgp");
                    Object v2_1 = v15.rememberedValue();
                    if(v2_1 == Composer.Companion.getEmpty()) {
                        v2_2 = InteractionSourceKt.MutableInteractionSource();
                        v15.updateRememberedValue(v2_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v15);
                    Object v9_2 = v2_2;
                }

                v2 = 54;
                if(v11 != 0) {
                    ComposableLambda v12_3 = ComposableLambdaKt.rememberComposableLambda(-2100927368, true, new SliderKt$Slider$10(v9, v6_1, v5), v15, v2);
                }

                if(v13 != 0) {
                    ComposableLambda v14_2 = ComposableLambdaKt.rememberComposableLambda(0xFB289CA3, true, new SliderKt$Slider$11(v5, v6_1), v15, v2);
                }

                v11_1 = v5;
                v13_1 = v12_1;
                v12_2 = v9;
                v9_3 = ((Companion)v0_2);
            }
            else {
                v15.skipToGroupEnd();
                if((arg26 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                v11_1 = v5;
                v13_1 = v12_1;
                v12_2 = v9;
                Modifier v9_1 = arg18;
            }

            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x186DFF48, v1, -1, "androidx.compose.material3.Slider (Slider.kt:371)");
            }

            if(v10.getSteps() >= 0) {
                int v0_3 = v1 >> 3;
                SliderKt.SliderImpl(((Modifier)v9_3), v10, v11_1, v12_2, v13_1, v14_1, v15, v1 & 0x380 | (v0_3 & 14 | v1 << 3 & 0x70) | v0_3 & 0x1C00 | 0xE000 & v0_3 | v0_3 & 0x70000);
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v4_1 = v6_1;
                v2_3 = ((Modifier)v9_3);
                v3 = v11_1;
                v5_1 = v12_2;
                v6_2 = v13_1;
                goto label_229;
            }

            throw new IllegalArgumentException("steps should be >= 0".toString());
        }
        else {
            v15.skipToGroupEnd();
            v2_3 = arg18;
            v3 = v5;
            v4_1 = v6_1;
            v5_1 = v9;
            v6_2 = v12_1;
        }

    label_229:
        Function3 v7_1 = v14_1;
        ScopeUpdateScope v10_1 = v15.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new SliderKt$$ExternalSyntheticLambda23(arg17, v2_3, v3, v4_1, v5_1, v6_2, v7_1, v8, arg26));
        }
    }

    public static final void Slider(float arg27, Function1 arg28, Modifier arg29, boolean arg30, ClosedFloatingPointRange arg31, int arg32, Function0 arg33, SliderColors arg34, MutableInteractionSource arg35, Composer arg36, int arg37, int arg38) {
        ClosedFloatingPointRange v5_1;
        int v6_1;
        MutableInteractionSource v9_1;
        SliderColors v8_1;
        Function0 v7_2;
        boolean v4_3;
        Modifier v3_1;
        Composer v23;
        SliderColors v0_2;
        int v4_1;
        Function0 v16_1;
        ClosedFloatingPointRange v22;
        Modifier v14_1;
        MutableInteractionSource v2_1;
        Object v2_2;
        int v17;
        Function0 v15_1;
        int v14;
        int v8;
        ClosedFloatingPointRange v7_1;
        boolean v6;
        int v5;
        Modifier v4;
        int v3;
        Function1 v13;
        float v12;
        int v2;
        int v10 = arg37;
        int v11 = arg38;
        Composer v1 = arg36.startRestartGroup(-202044027);
        ComposerKt.sourceInformation(v1, "C(Slider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors,interactionSource)201@9624L182,208@9824L122,192@9332L654:Slider.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
            v12 = arg27;
        }
        else {
            v12 = arg27;
            if((v10 & 6) == 0) {
                v2 = v1.changed(v12) ? 4 : 2;
                v2 |= v10;
            }
            else {
                v2 = v10;
            }
        }

        if((v11 & 2) != 0) {
            v2 |= 0x30;
            v13 = arg28;
        }
        else {
            v13 = arg28;
            if((v10 & 0x30) == 0) {
                v3 = v1.changedInstance(v13) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = v11 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v10 & 0x180) == 0) {
            v4 = arg29;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_51:
            v4 = arg29;
        }

        v5 = v11 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v10 & 0xC00) == 0) {
            v6 = arg30;
            int v7 = v1.changed(v6) ? 0x800 : 0x400;
            v2 |= v7;
        }
        else {
        label_66:
            v6 = arg30;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v7_1 = arg31;
                if(v1.changed(v7_1)) {
                    v8 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v7_1 = arg31;
            label_77:
                v8 = 0x2000;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg31;
        }

        v8 = v11 & 0x20;
        int v9 = 0x30000;
        if(v8 != 0) {
            v2 |= v9;
            goto label_96;
        }
        else if((v9 & v10) == 0) {
            v9 = arg32;
            v14 = v1.changed(v9) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_96:
            v9 = arg32;
        }

        v14 = v11 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_112;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg33;
            int v16 = v1.changedInstance(v15_1) ? 0x100000 : 0x80000;
            v2 |= v16;
        }
        else {
        label_112:
            v15_1 = arg33;
        }

        if((v10 & 0xC00000) == 0) {
            v17 = (v11 & 0x80) != 0 || !v1.changed(arg34) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0 = v11 & 0x100;
        v17 = 0x6000000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_144;
        }
        else if((v10 & v17) == 0) {
            v17 = v0;
            int v18 = v1.changed(arg35) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_144:
            v17 = v0;
        }

        int v36 = v2;
        int v19 = v3;
        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v36 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "189@9223L8,190@9283L39");
            v2 = 0xFE3FFFFF;
            int v20 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v19 != 0) {
                    Companion v4_2 = Modifier.Companion;
                }

                if(v5 != 0) {
                    v6 = true;
                }

                if((v11 & 16) != 0) {
                    v5 = v36 & v20;
                    v7_1 = RangesKt.rangeTo(0f, 1f);
                }
                else {
                    v5 = v36;
                }

                if(v8 != 0) {
                    v9 = 0;
                }

                if(v14 != 0) {
                    v15_1 = null;
                }

                if((v11 & 0x80) != 0) {
                    v0_2 = SliderDefaults.INSTANCE.colors(v1, 6);
                    v5 &= v2;
                }
                else {
                    v0_2 = arg34;
                }

                if(v17 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v1, 0xCAE7F64C, "CC(remember):Slider.kt#9igjgp");
                    v2_2 = v1.rememberedValue();
                    if(v2_2 == Composer.Companion.getEmpty()) {
                        v2_1 = InteractionSourceKt.MutableInteractionSource();
                        v1.updateRememberedValue(v2_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v1);
                }
                else {
                    v2_1 = arg35;
                }

                v14_1 = v4;
                v22 = v7_1;
                v19 = v9;
                v16_1 = v15_1;
                v4_1 = -202044027;
            }
            else {
                v1.skipToGroupEnd();
                v0 = (v11 & 16) != 0 ? v36 & v20 : v36;
                if((v11 & 0x80) != 0) {
                    v0 &= v2;
                }

                v2_1 = arg35;
                v5 = v0;
                v14_1 = v4;
                v22 = v7_1;
                v19 = v9;
                v16_1 = v15_1;
                v4_1 = -202044027;
                v0_2 = arg34;
            }

            boolean v15_2 = v6;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4_1, v5, -1, "androidx.compose.material3.Slider (Slider.kt:191)");
            }

            v4_1 = v5 >> 6;
            SliderColors v17_1 = v0_2;
            v23 = v1;
            MutableInteractionSource v18_1 = ((MutableInteractionSource)v2_2);
            SliderKt.Slider(v12, v13, v14_1, v15_2, v16_1, v17_1, v18_1, v19, ComposableLambdaKt.rememberComposableLambda(308249025, true, new SliderKt$Slider$2(((MutableInteractionSource)v2_2), v0_2, v15_2), v1, 54), ComposableLambdaKt.rememberComposableLambda(-1843234110, true, new SliderKt$Slider$3(v15_2, v0_2), v1, 54), v22, v23, v5 & 14 | 0x36000000 | v5 & 0x70 | v5 & 0x380 | v5 & 0x1C00 | 0xE000 & v4_1 | 0x70000 & v4_1 | v4_1 & 0x380000 | v5 << 6 & 0x1C00000, v5 >> 12 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v14_1;
            v4_3 = v15_2;
            v7_2 = v16_1;
            v8_1 = v17_1;
            v9_1 = v18_1;
            v6_1 = v19;
            v5_1 = v22;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v8_1 = arg34;
            v3_1 = v4;
            v4_3 = v6;
            v5_1 = v7_1;
            v6_1 = v9;
            v7_2 = v15_1;
            v9_1 = arg35;
        }

        ScopeUpdateScope v12_1 = v23.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new SliderKt$$ExternalSyntheticLambda8(arg27, arg28, v3_1, v4_3, v5_1, v6_1, v7_2, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit Slider$lambda$1(float arg13, Function1 arg14, Modifier arg15, boolean arg16, ClosedFloatingPointRange arg17, int arg18, Function0 arg19, SliderColors arg20, MutableInteractionSource arg21, int arg22, int arg23, Composer arg24, int arg25) {
        SliderKt.Slider(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit Slider$lambda$4(float arg16, Function1 arg17, Modifier arg18, boolean arg19, Function0 arg20, SliderColors arg21, MutableInteractionSource arg22, int arg23, Function3 arg24, Function3 arg25, ClosedFloatingPointRange arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        SliderKt.Slider(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit Slider$lambda$7(SliderState arg11, Modifier arg12, boolean arg13, SliderColors arg14, MutableInteractionSource arg15, Function3 arg16, Function3 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        SliderKt.Slider(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    private static final void SliderImpl(Modifier arg26, SliderState arg27, boolean arg28, MutableInteractionSource arg29, Function3 arg30, Function3 arg31, Composer arg32, int arg33) {
        Function3 v10_3;
        SliderKt$$ExternalSyntheticLambda14 v5_7;
        SliderKt$SliderImpl$2$1 v6_2;
        MutableInteractionSource v11_1;
        int v8;
        int v7;
        SliderState v2 = arg27;
        boolean v3 = arg28;
        MutableInteractionSource v4 = arg29;
        Function3 v0 = arg30;
        Function3 v1 = arg31;
        int v14 = arg33;
        int v5 = 0x358907A3;
        Composer v15 = arg32.startRestartGroup(v5);
        ComposerKt.sourceInformation(v15, "C(SliderImpl)N(modifier,state,enabled,interactionSource,thumb,track)751@33925L7,762@34446L28,806@36026L3110,773@34814L4322:Slider.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v7 = v15.changed(arg26) ? 4 : 2;
            v7 |= v14;
        }
        else {
            v7 = v14;
        }

        if((v14 & 0x30) == 0) {
            v8 = v15.changedInstance(v2) ? 0x20 : 16;
            v7 |= v8;
        }

        if((v14 & 0x180) == 0) {
            v8 = v15.changed(v3) ? 0x100 : 0x80;
            v7 |= v8;
        }

        if((v14 & 0xC00) == 0) {
            v8 = v15.changed(v4) ? 0x800 : 0x400;
            v7 |= v8;
        }

        if((v14 & 0x6000) == 0) {
            v8 = v15.changedInstance(v0) ? 0x4000 : 0x2000;
            v7 |= v8;
        }

        if((0x30000 & v14) == 0) {
            v8 = v15.changedInstance(v1) ? 0x20000 : 0x10000;
            v7 |= v8;
        }

        boolean v8_1 = (74899 & v7) != 74898 ? true : false;
        if(v15.shouldExecute(v8_1, v7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5, v7, -1, "androidx.compose.material3.SliderImpl (Slider.kt:750)");
            }

            ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_2 = v15.consume(((CompositionLocal)v5_1));
            ComposerKt.sourceInformationMarkerEnd(v15);
            boolean v5_3 = v5_2 == LayoutDirection.Rtl ? true : false;
            v2.setRtl$material3(v5_3);
            if(v2.getOrientation$material3() != Orientation.Horizontal || !v2.isRtl$material3()) {
                if(v2.getOrientation$material3() == Orientation.Vertical && (v2.getReverseVerticalDirection$material3())) {
                label_103:
                    v8_1 = true;
                    goto label_106;
                }

                v8_1 = false;
            }
            else {
                goto label_103;
            }

        label_106:
            Modifier v5_4 = SliderKt.sliderTapModifier(Modifier.Companion, v2, v4, v3);
            Companion v9 = Modifier.Companion;
            Modifier v10 = v5_4;
            Orientation v5_5 = v2.getOrientation$material3();
            boolean v11 = v8_1;
            v8_1 = v2.isDragging();
            SliderState v4_1 = v2;
            Companion v32 = v9;
            ComposerKt.sourceInformationMarkerStart(v15, -144304801, "CC(remember):Slider.kt#9igjgp");
            boolean v13 = v15.changedInstance(v2);
            Object v12 = v15.rememberedValue();
            String v17 = "CC(remember):Slider.kt#9igjgp";
            Continuation v9_1 = null;
            if((v13) || v12 == Composer.Companion.getEmpty()) {
                SliderKt$SliderImpl$drag$1$1 v12_1 = new SliderKt$SliderImpl$drag$1$1(v2, v9_1);
                v15.updateRememberedValue(v12_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            int v16 = v7;
            Modifier v14_1 = v10;
            Vertical v0_1 = v9_1;
            Modifier v12_2 = DraggableKt.draggable$default(v32, ((DraggableState)v4_1), v5_5, v3, arg29, v8_1, null, v12, v11, 0x20, null);
            v3 = v3;
            v8_1 = v11;
            v11_1 = arg29;
            int v6 = 3;
            Modifier v0_2 = v2.getOrientation$material3() == Orientation.Vertical ? SizeKt.wrapContentHeight$default(LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.THUMB), v0_1, false, v6, v0_1) : SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.THUMB), ((Horizontal)v0_1), false, v6, v0_1);
            Modifier v18 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(arg26);
            float v4_2 = v2.getOrientation$material3() == Orientation.Vertical ? SliderKt.TrackHeight : SliderKt.ThumbWidth;
            float v19 = v4_2;
            v4_2 = v2.getOrientation$material3() == Orientation.Vertical ? SliderKt.ThumbWidth : SliderKt.TrackHeight;
            Modifier v3_1 = SliderKt.slideOnKeyEvents(FocusableKt.focusable(SliderKt.sliderSemantics(SizeKt.requiredSizeIn-qDBjuR0$default(v18, v19, v4_2, 0f, 0f, 12, null), v2, v3), v3, v11_1), v3, v2.getSteps(), v2.getValueRange(), v2.getValue(), v8_1, v2.getOnValueChange(), v2.getOnValueChangeFinished()).then(v14_1).then(v12_2);
            String v5_6 = v17;
            ComposerKt.sourceInformationMarkerStart(v15, 0xF766E6E9, v5_6);
            boolean v4_3 = v15.changedInstance(v2);
            Object v6_1 = v15.rememberedValue();
            if((v4_3) || v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = new SliderKt$SliderImpl$2$1(v2);
                v15.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            int v4_4 = -1323940314;
            String v7_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v15, v4_4, v7_1);
            v8 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            CompositionLocalMap v9_2 = v15.getCurrentCompositionLocalMap();
            v3_1 = ComposedModifierKt.materializeModifier(v15, v3_1);
            Function0 v10_1 = ComposeUiNode.Companion.getConstructor();
            int v12_3 = 0xD6BD0031;
            String v13_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v15, v12_3, v13_1);
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v10_1);
            }
            else {
                v15.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v15);
            Updater.set-impl(v10_2, v6_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v9_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v6_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v8))) {
                v10_2.updateRememberedValue(Integer.valueOf(v8));
                v10_2.apply(Integer.valueOf(v8), v6_3);
            }

            Updater.set-impl(v10_2, v3_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v15, 0x8F9B01A6, "C777@34924L129,775@34844L268,784@35125L74:Slider.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(v15, 0x6FFCC71B, v5_6);
            v3 = v15.changedInstance(v2);
            v5_2 = v15.rememberedValue();
            if((v3) || v5_2 == Composer.Companion.getEmpty()) {
                v5_7 = new SliderKt$$ExternalSyntheticLambda14(v2);
                v15.updateRememberedValue(v5_7);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            v0_2 = OnRemeasuredModifierKt.onSizeChanged(v0_2, ((Function1)v5_7));
            int v3_2 = 0x2BB5B5D7;
            v5_6 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v15, v3_2, v5_6);
            MeasurePolicy v6_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v15, v4_4, v7_1);
            v8 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            v9_2 = v15.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v15, v0_2);
            v10_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v15, v12_3, v13_1);
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v10_1);
            }
            else {
                v15.useNode();
            }

            v10_2 = Updater.constructor-impl(v15);
            Updater.set-impl(v10_2, v6_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v9_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v6_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v8))) {
                v10_2.updateRememberedValue(Integer.valueOf(v8));
                v10_2.apply(Integer.valueOf(v8), v6_3);
            }

            Updater.set-impl(v10_2, v0_2, ComposeUiNode.Companion.getSetModifier());
            int v0_3 = 0x800B7D29;
            String v6_5 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v15, v0_3, v6_5);
            ComposerKt.sourceInformationMarkerStart(v15, -294052009, "C782@35086L12:Slider.kt#uh7d8r");
            v8 = v16 >> 3 & 14;
            v10_3 = arg30;
            v10_3.invoke(v2, v15, Integer.valueOf(v16 >> 9 & 0x70 | v8));
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            Modifier v9_3 = LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(v15, v3_2, v5_6);
            MeasurePolicy v3_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v15, v4_4, v7_1);
            int v1_1 = ComposablesKt.getCurrentCompositeKeyHash(v15, 0);
            CompositionLocalMap v4_5 = v15.getCurrentCompositionLocalMap();
            v5_4 = ComposedModifierKt.materializeModifier(v15, v9_3);
            Function0 v7_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v15, v12_3, v13_1);
            if(!(v15.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v15.startReusableNode();
            if(v15.getInserting()) {
                v15.createNode(v7_2);
            }
            else {
                v15.useNode();
            }

            Composer v7_3 = Updater.constructor-impl(v15);
            Updater.set-impl(v7_3, v3_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_3, v4_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v7_3.getInserting()) || !Intrinsics.areEqual(v7_3.rememberedValue(), Integer.valueOf(v1_1))) {
                v7_3.updateRememberedValue(Integer.valueOf(v1_1));
                v7_3.apply(Integer.valueOf(v1_1), v3_4);
            }

            Updater.set-impl(v7_3, v5_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v15, v0_3, v6_5);
            ComposerKt.sourceInformationMarkerStart(v15, 0xCE274300, "C784@35185L12:Slider.kt#uh7d8r");
            v1 = arg31;
            v1.invoke(v2, v15, Integer.valueOf(v16 >> 12 & 0x70 | v8));
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            v15.endNode();
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_408;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v10_3 = v0;
            v11_1 = v4;
            v15.skipToGroupEnd();
        }

    label_408:
        ScopeUpdateScope v8_2 = v15.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new SliderKt$$ExternalSyntheticLambda15(arg26, v2, arg28, v11_1, v10_3, v1, arg33));
        }
    }

    static final Unit SliderImpl$lambda$29$lambda$26$lambda$25(SliderState arg4, IntSize arg5) {
        arg4.setThumbWidth$material3(((int)(arg5.unbox-impl() >> 0x20)));
        arg4.setThumbHeight$material3(((int)(arg5.unbox-impl() & 0xFFFFFFFFL)));
        return Unit.INSTANCE;
    }

    static final Unit SliderImpl$lambda$31(Modifier arg8, SliderState arg9, boolean arg10, MutableInteractionSource arg11, Function3 arg12, Function3 arg13, int arg14, Composer arg15, int arg16) {
        SliderKt.SliderImpl(arg8, arg9, arg10, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    public static final long SliderRange(float arg4, float arg5) {
        if(!Float.isNaN(arg4) || !Float.isNaN(arg5)) {
            if(arg4 <= arg5) {
                goto label_6;
            }

            goto label_17;
        }
        else {
        }

    label_6:
        return SliderRange.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    label_17:
        throw new IllegalArgumentException("start(" + arg4 + ") must be <= endInclusive(" + arg5 + ')'.toString());
    }

    public static final long SliderRange(ClosedFloatingPointRange arg6) {
        float v0 = arg6.getStart().floatValue();
        float v6 = arg6.getEndInclusive().floatValue();
        if(!Float.isNaN(v0) || !Float.isNaN(v6)) {
            if(v0 <= v6) {
                goto label_10;
            }

            goto label_21;
        }
        else {
        }

    label_10:
        return SliderRange.constructor-impl((((long)Float.floatToRawIntBits(v0))) << 0x20 | (((long)Float.floatToRawIntBits(v6))) & 0xFFFFFFFFL);
    label_21:
        throw new IllegalArgumentException("ClosedFloatingPointRange<Float>.start(" + v0 + ") must be <= ClosedFloatingPoint.endInclusive(" + v6 + ')'.toString());
    }

    public static final void VerticalSlider(SliderState arg21, Modifier arg22, boolean arg23, boolean arg24, SliderColors arg25, MutableInteractionSource arg26, Function3 arg27, Function3 arg28, Composer arg29, int arg30, int arg31) {
        Function3 v7_1;
        boolean v3_1;
        Composer v0_6;
        Function3 v8_1;
        ComposableLambda v8_2;
        int v17;
        Function3 v0;
        int v15;
        MutableInteractionSource v14_1;
        int v13;
        SliderColors v12_1;
        boolean v11;
        int v8;
        boolean v7;
        int v6;
        Modifier v5;
        int v3;
        SliderState v1 = arg21;
        int v9 = arg30;
        int v10 = arg31;
        Composer v2 = arg29.startRestartGroup(-1841025790);
        ComposerKt.sourceInformation(v2, "C(VerticalSlider)N(state,modifier,enabled,reverseDirection,colors,interactionSource,thumb,track)444@20428L189:Slider.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v3 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v3 = v9;
        }

        int v4 = v10 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v9 & 0x30) == 0) {
            v5 = arg22;
            v6 = v2.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_36:
            v5 = arg22;
        }

        v6 = v10 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_51;
        }
        else if((v9 & 0x180) == 0) {
            v7 = arg23;
            v8 = v2.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_51:
            v7 = arg23;
        }

        v8 = v10 & 8;
        if(v8 != 0) {
            v3 |= 0xC00;
            goto label_66;
        }
        else if((v9 & 0xC00) == 0) {
            v11 = arg24;
            int v12 = v2.changed(v11) ? 0x800 : 0x400;
            v3 |= v12;
        }
        else {
        label_66:
            v11 = arg24;
        }

        if((v9 & 0x6000) == 0) {
            if((v10 & 16) == 0) {
                v12_1 = arg25;
                if(v2.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v12_1 = arg25;
            label_77:
                v13 = 0x2000;
            }

            v3 |= v13;
        }
        else {
            v12_1 = arg25;
        }

        v13 = v10 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v3 |= v14;
            goto label_96;
        }
        else if((v14 & v9) == 0) {
            v14_1 = arg26;
            v15 = v2.changed(v14_1) ? 0x20000 : 0x10000;
            v3 |= v15;
        }
        else {
        label_96:
            v14_1 = arg26;
        }

        v15 = v10 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            v0 = arg27;
            if((v9 & v16) == 0) {
                v17 = v2.changedInstance(v0) ? 0x100000 : 0x80000;
                v3 |= v17;
            }
        }

        int v0_1 = v10 & 0x80;
        v17 = 0xC00000;
        if(v0_1 != 0) {
            v3 |= v17;
            goto label_128;
        }
        else if((v9 & v17) == 0) {
            v17 = v0_1;
            int v18 = v2.changedInstance(arg28) ? 0x800000 : 0x400000;
            v3 |= v18;
        }
        else {
        label_128:
            v17 = v0_1;
        }

        int v29 = v3;
        int v19 = v4;
        boolean v0_2 = (v3 & 0x492493) != 4793490 ? true : false;
        if(v2.shouldExecute(v0_2, v29 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "419@19613L8,420@19673L39,421@19761L255,430@20065L207");
            int v20 = 0xFFFF1FFF;
            v3 = 6;
            if((v9 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v19 != 0) {
                    Companion v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7 = true;
                }

                if(v8 != 0) {
                    v11 = false;
                }

                if((v10 & 16) != 0) {
                    v6 = v29 & v20;
                    v12_1 = SliderDefaults.INSTANCE.colors(v2, v3);
                }
                else {
                    v6 = v29;
                }

                if(v13 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v2, 300751721, "CC(remember):Slider.kt#9igjgp");
                    Object v0_3 = v2.rememberedValue();
                    if(v0_3 == Composer.Companion.getEmpty()) {
                        MutableInteractionSource v0_4 = InteractionSourceKt.MutableInteractionSource();
                        v2.updateRememberedValue(v0_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v2);
                    Object v14_2 = v0_3;
                }

                v0_1 = 54;
                if(v15 != 0) {
                    v8_2 = ComposableLambdaKt.rememberComposableLambda(0x710C3232, true, new SliderKt$VerticalSlider$2(v14_1, v12_1, v7), v2, v0_1);
                }
                else {
                    v8_1 = arg27;
                }

                if(v17 != 0) {
                    ComposableLambda v0_5 = ComposableLambdaKt.rememberComposableLambda(-1702448035, true, new SliderKt$VerticalSlider$3(v7, v12_1), v2, v0_1);
                    goto label_206;
                }

            label_160:
                v0 = arg28;
            }
            else {
                v2.skipToGroupEnd();
                if((v10 & 16) != 0) {
                    v8_1 = arg27;
                    v6 = v29 & v20;
                    goto label_160;
                }
                else {
                    v8_1 = arg27;
                    v0 = arg28;
                    v6 = v29;
                }
            }

        label_206:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1841025790, v6, -1, "androidx.compose.material3.VerticalSlider (Slider.kt:438)");
            }

            if(v1.getSteps() >= 0) {
                v1.setOrientation$material3(Orientation.Vertical);
                v1.setReverseVerticalDirection$material3(v11);
                v3 = v6 >> 6;
                SliderKt.SliderImpl(v5, v1, v7, v14_1, ((Function3)v8_2), v0, v2, v3 & 0x70000 | (v6 >> 3 & 14 | v6 << 3 & 0x70 | v6 & 0x380 | v3 & 0x1C00 | 0xE000 & v3));
                Function3 v1_1 = v0;
                v0_6 = v2;
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }

                v3_1 = v7;
                v7_1 = ((Function3)v8_2);
                v8_1 = v1_1;
                goto label_262;
            }

            throw new IllegalArgumentException("steps should be >= 0".toString());
        }
        else {
            v0_6 = v2;
            v0_6.skipToGroupEnd();
            v8_1 = arg28;
            v3_1 = v7;
            v7_1 = arg27;
        }

    label_262:
        Modifier v2_1 = v5;
        boolean v4_1 = v11;
        SliderColors v5_2 = v12_1;
        MutableInteractionSource v6_1 = v14_1;
        ScopeUpdateScope v11_1 = v0_6.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new SliderKt$$ExternalSyntheticLambda12(arg21, v2_1, v3_1, v4_1, v5_2, v6_1, v7_1, v8_1, v9, v10));
        }
    }

    static final Unit VerticalSlider$lambda$10(SliderState arg12, Modifier arg13, boolean arg14, boolean arg15, SliderColors arg16, MutableInteractionSource arg17, Function3 arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        SliderKt.VerticalSlider(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final Object access$awaitSlop-8vUncbI(AwaitPointerEventScope arg0, long arg1, int arg3, Continuation arg4) {
        return SliderKt.awaitSlop-8vUncbI(arg0, arg1, arg3, arg4);
    }

    public static final float access$calcFraction(float arg0, float arg1, float arg2) {
        return SliderKt.calcFraction(arg0, arg1, arg2);
    }

    public static final long access$getThumbSize$p() {
        return SliderKt.ThumbSize;
    }

    public static final float access$getThumbTrackGapSize$p() {
        return SliderKt.ThumbTrackGapSize;
    }

    public static final float access$getTrackInsideCornerSize$p() {
        return SliderKt.TrackInsideCornerSize;
    }

    public static final long access$getVerticalThumbSize$p() {
        return SliderKt.VerticalThumbSize;
    }

    public static final float access$scale(float arg0, float arg1, float arg2, float arg3, float arg4) {
        return SliderKt.scale(arg0, arg1, arg2, arg3, arg4);
    }

    public static final long access$scale-2geJ7wY(boolean arg0, float arg1, float arg2, long arg3, float arg5, float arg6) {
        return SliderKt.scale-2geJ7wY(arg0, arg1, arg2, arg3, arg5, arg6);
    }

    public static final float access$snapValueToTick(float arg0, float[] arg1, float arg2, float arg3) {
        return SliderKt.snapValueToTick(arg0, arg1, arg2, arg3);
    }

    public static final float[] access$stepsToTickFractions(int arg0) {
        return SliderKt.stepsToTickFractions(arg0);
    }

    private static final Object awaitSlop-8vUncbI(AwaitPointerEventScope arg8, long arg9, int arg11, Continuation arg12) {
        Object v8;
        Continuation v0;
        if((arg12 instanceof SliderKt$awaitSlop$1)) {
            v0 = arg12;
            int v2 = 0x80000000;
            if((((SliderKt$awaitSlop$1)v0).label & v2) != 0) {
                ((SliderKt$awaitSlop$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            SliderKt$awaitSlop$1 v0_1 = new SliderKt$awaitSlop$1(arg12);
        }

        Continuation v6 = v0;
        Object v12 = ((SliderKt$awaitSlop$1)v6).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((SliderKt$awaitSlop$1)v6).label;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v12);
            FloatRef v12_1 = new FloatRef();
            SliderKt$$ExternalSyntheticLambda2 v5 = new SliderKt$$ExternalSyntheticLambda2(v12_1);
            ((SliderKt$awaitSlop$1)v6).L$0 = v12_1;
            ((SliderKt$awaitSlop$1)v6).label = 1;
            v8 = DragGestureDetectorCopyKt.awaitHorizontalPointerSlopOrCancellation-gDDlDlE(arg8, arg9, arg11, ((Function2)v5), v6);
            if(v8 == v0_2) {
                return v0_2;
            }
            else {
                FloatRef v7 = v12_1;
                v12 = v8;
                FloatRef v8_1 = v7;
            }
        }
        else if(v1 == 1) {
            v8 = ((SliderKt$awaitSlop$1)v6).L$0;
            ResultKt.throwOnFailure(v12);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        if(v12 != null) {
            return TuplesKt.to(v12, Boxing.boxFloat(((FloatRef)v8).element));
        }

        return null;
    }

    static final Unit awaitSlop_8vUncbI$lambda$49(FloatRef arg0, PointerInputChange arg1, float arg2) {
        arg1.consume();
        arg0.element = arg2;
        return Unit.INSTANCE;
    }

    private static final float calcFraction(float arg2, float arg3, float arg4) {
        arg3 -= arg2;
        arg4 = arg3 == 0f ? 0f : (arg4 - arg2) / arg3;
        return RangesKt.coerceIn(arg4, 0f, 1f);
    }

    private static final String formatForSemantics(float arg1) {
        return String.valueOf((((float)MathKt.roundToInt(arg1 * 100f))) / 100f);
    }

    public static final VerticalAlignmentLine getCornerSizeAlignmentLine() {
        return SliderKt.CornerSizeAlignmentLine;
    }

    public static final float getThumbWidth() {
        return SliderKt.ThumbWidth;
    }

    public static final float getTrackHeight() {
        return SliderKt.TrackHeight;
    }

    public static final boolean isSpecified-If1S1O4(long arg2) {
        if(arg2 != SliderRange.Companion.getUnspecified-FYbKRX4()) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-If1S1O4$annotations(long arg0) {
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier arg4, RangeSliderState arg5, boolean arg6) {
        ClosedFloatingPointRange v0 = RangesKt.rangeTo(arg5.getActiveRangeStart(), arg5.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(arg4, false, new SliderKt$$ExternalSyntheticLambda18(arg6, arg5, v0), 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), arg5.getActiveRangeEnd(), v0, arg5.getEndSteps$material3());
    }

    static final Unit rangeSliderEndThumbSemantics$lambda$58(boolean arg0, RangeSliderState arg1, ClosedFloatingPointRange arg2, SemanticsPropertyReceiver arg3) {
        if(!arg0) {
            SemanticsPropertiesKt.disabled(arg3);
        }

        SemanticsPropertiesKt.setStateDescription(arg3, SliderKt.formatForSemantics(arg1.getActiveRangeEnd()));
        SemanticsPropertiesKt.setProgress$default(arg3, null, new SliderKt$$ExternalSyntheticLambda9(arg2, arg1), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean rangeSliderEndThumbSemantics$lambda$58$lambda$57(ClosedFloatingPointRange arg10, RangeSliderState arg11, float arg12) {
        arg12 = RangesKt.coerceIn(arg12, arg10.getStart().floatValue(), arg10.getEndInclusive().floatValue());
        if(arg11.getEndSteps$material3() > 0) {
            int v0 = arg11.getEndSteps$material3() + 1;
            if(v0 >= 0) {
                float v4 = arg12;
                float v5 = v4;
                int v3;
                for(v3 = 0; true; ++v3) {
                    float v6 = MathHelpersKt.lerp(arg10.getStart().floatValue(), arg10.getEndInclusive().floatValue(), (((float)v3)) / (((float)(arg11.getEndSteps$material3() + 1))));
                    float v7 = v6 - arg12;
                    if(Math.abs(v7) <= v4) {
                        v4 = Math.abs(v7);
                        v5 = v6;
                    }

                    if(v3 == v0) {
                        break;
                    }
                }

                arg12 = v5;
            }
        }

        if(arg12 == arg11.getActiveRangeEnd()) {
            return 0;
        }

        long v0_1 = SliderKt.SliderRange(arg11.getActiveRangeStart(), arg12);
        if(!SliderRange.equals-impl0(v0_1, SliderKt.SliderRange(arg11.getActiveRangeStart(), arg11.getActiveRangeEnd()))) {
            if(arg11.getOnValueChange$material3() != null) {
                Function1 v10 = arg11.getOnValueChange$material3();
                if(v10 != null) {
                    v10.invoke(SliderRange.box-impl(v0_1));
                }
            }
            else {
                arg11.setActiveRangeStart(SliderRange.getStart-impl(v0_1));
                arg11.setActiveRangeEnd(SliderRange.getEndInclusive-impl(v0_1));
            }
        }

        Function0 v10_1 = arg11.getOnValueChangeFinished();
        if(v10_1 != null) {
            v10_1.invoke();
        }

        return 1;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier arg1, RangeSliderState arg2, MutableInteractionSource arg3, MutableInteractionSource arg4, boolean arg5) {
        if(arg5) {
            arg1 = SuspendingPointerInputFilterKt.pointerInput(arg1, new Object[]{arg3, arg4, arg2}, new SliderKt$rangeSliderPressDragModifier$1(arg2, arg3, arg4));
        }

        return arg1;
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier arg4, RangeSliderState arg5, boolean arg6) {
        ClosedFloatingPointRange v0 = RangesKt.rangeTo(arg5.getValueRange().getStart().floatValue(), arg5.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(arg4, false, new SliderKt$$ExternalSyntheticLambda19(arg6, arg5, v0), 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), arg5.getActiveRangeStart(), v0, arg5.getStartSteps$material3());
    }

    static final Unit rangeSliderStartThumbSemantics$lambda$55(boolean arg0, RangeSliderState arg1, ClosedFloatingPointRange arg2, SemanticsPropertyReceiver arg3) {
        if(!arg0) {
            SemanticsPropertiesKt.disabled(arg3);
        }

        SemanticsPropertiesKt.setStateDescription(arg3, SliderKt.formatForSemantics(arg1.getActiveRangeStart()));
        SemanticsPropertiesKt.setProgress$default(arg3, null, new SliderKt$$ExternalSyntheticLambda13(arg2, arg1), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean rangeSliderStartThumbSemantics$lambda$55$lambda$54(ClosedFloatingPointRange arg10, RangeSliderState arg11, float arg12) {
        arg12 = RangesKt.coerceIn(arg12, arg10.getStart().floatValue(), arg10.getEndInclusive().floatValue());
        if(arg11.getStartSteps$material3() > 0) {
            int v0 = arg11.getStartSteps$material3() + 1;
            if(v0 >= 0) {
                float v4 = arg12;
                float v5 = v4;
                int v3;
                for(v3 = 0; true; ++v3) {
                    float v6 = MathHelpersKt.lerp(arg10.getStart().floatValue(), arg10.getEndInclusive().floatValue(), (((float)v3)) / (((float)(arg11.getStartSteps$material3() + 1))));
                    float v7 = v6 - arg12;
                    if(Math.abs(v7) <= v4) {
                        v4 = Math.abs(v7);
                        v5 = v6;
                    }

                    if(v3 == v0) {
                        break;
                    }
                }

                arg12 = v5;
            }
        }

        if(arg12 == arg11.getActiveRangeStart()) {
            return 0;
        }

        long v0_1 = SliderKt.SliderRange(arg12, arg11.getActiveRangeEnd());
        if(!SliderRange.equals-impl0(v0_1, SliderKt.SliderRange(arg11.getActiveRangeStart(), arg11.getActiveRangeEnd()))) {
            if(arg11.getOnValueChange$material3() != null) {
                Function1 v10 = arg11.getOnValueChange$material3();
                if(v10 != null) {
                    v10.invoke(SliderRange.box-impl(v0_1));
                }
            }
            else {
                arg11.setActiveRangeStart(SliderRange.getStart-impl(v0_1));
                arg11.setActiveRangeEnd(SliderRange.getEndInclusive-impl(v0_1));
            }
        }

        Function0 v10_1 = arg11.getOnValueChangeFinished();
        if(v10_1 != null) {
            v10_1.invoke();
        }

        return 1;
    }

    public static final RangeSliderState rememberRangeSliderState(float arg12, float arg13, int arg14, Function0 arg15, ClosedFloatingPointRange arg16, Composer arg17, int arg18, int arg19) {
        Composer v0 = arg17;
        int v1 = arg18;
        int v3 = 756708139;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rememberRangeSliderState)N(activeRangeStart,activeRangeEnd,steps,onValueChangeFinished,valueRange)3126@135179L260,3126@135095L344:Slider.kt#uh7d8r");
        float v6 = (arg19 & 1) != 0 ? 0f : arg12;
        float v2 = 1f;
        float v7 = (arg19 & 2) != 0 ? v2 : arg13;
        int v8 = (arg19 & 4) != 0 ? 0 : arg14;
        Function0 v9 = (arg19 & 8) != 0 ? null : arg15;
        ClosedFloatingPointRange v10 = (arg19 & 16) != 0 ? RangesKt.rangeTo(0f, v2) : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.rememberRangeSliderState (Slider.kt:3125)");
        }

        Object[] v12 = new Object[0];
        Saver v2_1 = RangeSliderState.Companion.Saver(v9, v10);
        ComposerKt.sourceInformationMarkerStart(v0, 0x504A872F, "CC(remember):Slider.kt#9igjgp");
        int v4 = 4;
        int v5 = 1;
        v3 = (v1 & 14 ^ 6) > v4 && (v0.changed(v6)) || (v1 & 6) == v4 ? 1 : 0;
        int v11 = 0x20;
        v4 = (v1 & 0x70 ^ 0x30) > v11 && (v0.changed(v7)) || (v1 & 0x30) == v11 ? 1 : 0;
        v3 |= v4;
        v11 = 0x100;
        v4 = (v1 & 0x380 ^ 0x180) > v11 && (v0.changed(v8)) || (v1 & 0x180) == v11 ? 1 : 0;
        v3 |= v4;
        v11 = 0x800;
        v4 = (v1 & 0x1C00 ^ 0xC00) > v11 && (v0.changed(v9)) || (v1 & 0xC00) == v11 ? 1 : 0;
        v3 |= v4;
        v11 = 0x4000;
        if((0xE000 & v1 ^ 0x6000) <= v11 || !v0.changed(v10)) {
            if((v1 & 0x6000) == v11) {
            }
            else {
                v5 = 0;
            }
        }

        v1 = v3 | v5;
        Object v3_1 = v0.rememberedValue();
        if(v1 != 0 || v3_1 == Composer.Companion.getEmpty()) {
            SliderKt$$ExternalSyntheticLambda20 v5_1 = new SliderKt$$ExternalSyntheticLambda20(v6, v7, v8, v9, v10);
            v0.updateRememberedValue(v5_1);
            SliderKt$$ExternalSyntheticLambda20 v3_2 = v5_1;
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v12_1 = RememberSaveableKt.rememberSaveable(v12, v2_1, ((Function0)v3_1), v0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((RangeSliderState)v12_1);
    }

    static final RangeSliderState rememberRangeSliderState$lambda$62$lambda$61(float arg6, float arg7, int arg8, Function0 arg9, ClosedFloatingPointRange arg10) {
        return new RangeSliderState(arg6, arg7, arg8, arg9, arg10);
    }

    public static final SliderState rememberSliderState(float arg6, int arg7, Function0 arg8, ClosedFloatingPointRange arg9, Composer arg10, int arg11, int arg12) {
        SliderKt$$ExternalSyntheticLambda10 v1_2;
        int v1 = 0x47235A53;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberSliderState)N(value,steps,onValueChangeFinished,valueRange)2912@125235L188,2912@125156L267:Slider.kt#uh7d8r");
        if((arg12 & 4) != 0) {
            arg8 = null;
        }

        if((arg12 & 8) != 0) {
            arg9 = RangesKt.rangeTo(0f, 1f);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.material3.rememberSliderState (Slider.kt:2911)");
        }

        Object[] v12 = new Object[0];
        Saver v0 = SliderState.Companion.Saver(arg8, arg9);
        ComposerKt.sourceInformationMarkerStart(arg10, 0xBB63CCF, "CC(remember):Slider.kt#9igjgp");
        int v2 = 4;
        int v4 = 1;
        v1 = (arg11 & 14 ^ 6) > v2 && (arg10.changed(0f)) || (arg11 & 6) == v2 ? 1 : 0;
        int v5 = 0x20;
        v2 = (arg11 & 0x70 ^ 0x30) > v5 && (arg10.changed(0)) || (arg11 & 0x30) == v5 ? 1 : 0;
        v1 |= v2;
        v5 = 0x100;
        v2 = (arg11 & 0x380 ^ 0x180) > v5 && (arg10.changed(arg8)) || (arg11 & 0x180) == v5 ? 1 : 0;
        v1 |= v2;
        v5 = 0x800;
        if((arg11 & 0x1C00 ^ 0xC00) <= v5 || !arg10.changed(arg9)) {
            if((arg11 & 0xC00) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg11 = v1 | v4;
        Object v1_1 = arg10.rememberedValue();
        if(arg11 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new SliderKt$$ExternalSyntheticLambda10(0f, 0, arg8, arg9);
            arg10.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        Object v6 = RememberSaveableKt.rememberSaveable(v12, v0, ((Function0)v1_2), arg10, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return ((SliderState)v6);
    }

    static final SliderState rememberSliderState$lambda$60$lambda$59(float arg1, int arg2, Function0 arg3, ClosedFloatingPointRange arg4) {
        return new SliderState(arg1, arg2, arg3, arg4);
    }

    private static final float scale(float arg0, float arg1, float arg2, float arg3, float arg4) {
        return MathHelpersKt.lerp(arg3, arg4, SliderKt.calcFraction(arg0, arg1, arg2));
    }

    private static final long scale-2geJ7wY(boolean arg1, float arg2, float arg3, long arg4, float arg6, float arg7) {
        float v0 = SliderKt.scale(arg2, arg3, SliderRange.getStart-impl(arg4), arg6, arg7);
        arg2 = SliderKt.scale(arg2, arg3, SliderRange.getEndInclusive-impl(arg4), arg6, arg7);
        if(arg1) {
            return SliderKt.SliderRange(RangesKt.coerceAtMost(v0, arg2), arg2);
        }

        return SliderKt.SliderRange(v0, RangesKt.coerceAtLeast(arg2, v0));
    }

    private static final Modifier slideOnKeyEvents(Modifier arg8, boolean arg9, int arg10, ClosedFloatingPointRange arg11, float arg12, boolean arg13, Function1 arg14, Function0 arg15) {
        if(arg10 >= 0) {
            return KeyInputModifierKt.onKeyEvent(arg8, new SliderKt$slideOnKeyEvents$2(arg9, arg14, arg11, arg10, arg13, arg12, arg15));
        }

        throw new IllegalArgumentException("steps should be >= 0".toString());
    }

    private static final Modifier sliderSemantics(Modifier arg3, SliderState arg4, boolean arg5) {
        arg3 = SemanticsModifierKt.semantics$default(arg3, false, new SliderKt$$ExternalSyntheticLambda0(arg5, arg4), 1, null);
        Modifier v5 = arg4.getOrientation$material3() == Orientation.Vertical ? AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds() : AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds();
        return ProgressSemanticsKt.progressSemantics(arg3.then(v5), arg4.getValue(), RangesKt.rangeTo(arg4.getValueRange().getStart().floatValue(), arg4.getValueRange().getEndInclusive().floatValue()), arg4.getSteps());
    }

    static final Unit sliderSemantics$lambda$52(boolean arg1, SliderState arg2, SemanticsPropertyReceiver arg3) {
        if(!arg1) {
            SemanticsPropertiesKt.disabled(arg3);
        }

        SemanticsPropertiesKt.setStateDescription(arg3, SliderKt.formatForSemantics(arg2.getValue()));
        SemanticsPropertiesKt.setProgress$default(arg3, null, new SliderKt$$ExternalSyntheticLambda21(arg2), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean sliderSemantics$lambda$52$lambda$51(SliderState arg10, float arg11) {
        arg11 = RangesKt.coerceIn(arg11, arg10.getValueRange().getStart().floatValue(), arg10.getValueRange().getEndInclusive().floatValue());
        if(arg10.getSteps() > 0) {
            int v0 = arg10.getSteps() + 1;
            if(v0 >= 0) {
                float v4 = arg11;
                float v5 = v4;
                int v3;
                for(v3 = 0; true; ++v3) {
                    float v6 = MathHelpersKt.lerp(arg10.getValueRange().getStart().floatValue(), arg10.getValueRange().getEndInclusive().floatValue(), (((float)v3)) / (((float)(arg10.getSteps() + 1))));
                    float v7 = v6 - arg11;
                    if(Math.abs(v7) <= v4) {
                        v4 = Math.abs(v7);
                        v5 = v6;
                    }

                    if(v3 == v0) {
                        break;
                    }
                }

                arg11 = v5;
            }
        }

        if(arg11 == arg10.getValue()) {
            return 0;
        }

        if(arg11 == arg10.getValue()) {
        }
        else if(arg10.getOnValueChange() != null) {
            Function1 v0_1 = arg10.getOnValueChange();
            if(v0_1 != null) {
                v0_1.invoke(Float.valueOf(arg11));
            }
        }
        else {
            arg10.setValue(arg11);
        }

        Function0 v10 = arg10.getOnValueChangeFinished();
        if(v10 != null) {
            v10.invoke();
        }

        return 1;
    }

    private static final Modifier sliderTapModifier(Modifier arg0, SliderState arg1, MutableInteractionSource arg2, boolean arg3) {
        if(arg3) {
            arg0 = SuspendingPointerInputFilterKt.pointerInput(arg0, arg1, arg2, new SliderKt$sliderTapModifier$1(arg1));
        }

        return arg0;
    }

    private static final float snapValueToTick(float arg7, float[] arg8, float arg9, float arg10) {
        Float v8;
        if(arg8.length == 0) {
            v8 = null;
        }
        else {
            float v0 = arg8[0];
            int v1 = ArraysKt.getLastIndex(arg8);
            if(v1 == 0) {
                v8 = Float.valueOf(v0);
            }
            else {
                float v2 = Math.abs(MathHelpersKt.lerp(arg9, arg10, v0) - arg7);
                int v3 = 1;
                if(1 <= v1) {
                    while(true) {
                        float v4 = arg8[v3];
                        float v5 = Math.abs(MathHelpersKt.lerp(arg9, arg10, v4) - arg7);
                        if(Float.compare(v2, v5) > 0) {
                            v0 = v4;
                            v2 = v5;
                        }

                        if(v3 == v1) {
                            break;
                        }

                        ++v3;
                    }
                }

                v8 = Float.valueOf(v0);
            }
        }

        if(v8 != null) {
            arg7 = MathHelpersKt.lerp(arg9, arg10, ((Number)v8).floatValue());
        }

        return arg7;
    }

    private static final float[] stepsToTickFractions(int arg5) {
        int v0 = 0;
        if(arg5 == 0) {
            return new float[0];
        }

        int v1 = arg5 + 2;
        float[] v2 = new float[v1];
        while(v0 < v1) {
            v2[v0] = (((float)v0)) / (((float)(arg5 + 1)));
            ++v0;
        }

        return v2;
    }
}

