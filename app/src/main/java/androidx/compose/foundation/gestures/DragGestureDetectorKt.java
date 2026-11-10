package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AV\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u000426\u0010\u0005\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b\r\u0010\u000E\u001A0\u0010\u000F\u001A\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001E\u0010\u0015\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u0080\u0001\u0010\u0018\u001A\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000E\b\u0002\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\f0\u001C2\u000E\b\u0002\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\f0\u001C26\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001F\u001Aè\u0001\u0010\u0018\u001A\u00020\f*\u00020\u00192\b\u0010 \u001A\u0004\u0018\u00010!2M\b\u0002\u0010\u001A\u001AG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f0\"2#\b\u0002\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u00122\u000E\b\u0002\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\f0\u001C2\u000E\b\u0002\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00100\u001C26\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\'\u001A\u0080\u0001\u0010(\u001A\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000E\b\u0002\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\f0\u001C2\u000E\b\u0002\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\f0\u001C26\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001F\u001AV\u0010)\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u000426\u0010\u0005\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b+\u0010\u000E\u001A^\u0010,\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010-\u001A\u00020.26\u0010/\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b0\u00101\u001A0\u00102\u001A\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b3\u0010\u0014\u001A\u001E\u00104\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086@¢\u0006\u0004\b5\u0010\u0017\u001A\u0080\u0001\u00106\u001A\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000E\b\u0002\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\f0\u001C2\u000E\b\u0002\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\f0\u001C26\u00107\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001F\u001AV\u00108\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u000426\u0010\u0005\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b9\u0010\u000E\u001A^\u0010:\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010-\u001A\u00020.26\u0010/\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b;\u00101\u001A0\u0010<\u001A\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b=\u0010\u0014\u001A\u001E\u0010>\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086@¢\u0006\u0004\b?\u0010\u0017\u001A\u0080\u0001\u0010@\u001A\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000E\b\u0002\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\f0\u001C2\u000E\b\u0002\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\f0\u001C26\u0010A\u001A2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001F\u001AP\u0010\u000F\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u00122\b\u0010B\u001A\u0004\u0018\u00010!2\u0012\u0010C\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0080H¢\u0006\u0004\bD\u0010E\u001A2\u0010F\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0012\u0010G\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0082H¢\u0006\u0004\bH\u0010\u0014\u001AT\u0010I\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010-\u001A\u00020.2\b\u0010B\u001A\u0004\u0018\u00010!2\b\b\u0002\u0010J\u001A\u00020\n2\u0018\u0010/\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006H\u0080H¢\u0006\u0004\bK\u0010L\u001A$\u0010M\u001A\u00020\u0010*\u00020\u00022\u0006\u0010J\u001A\u00020\u00012\b\b\u0002\u0010N\u001A\u00020OH\u0080@¢\u0006\u0002\u0010P\u001A\u001E\u0010Q\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086@¢\u0006\u0004\bR\u0010\u0017\u001A\u001B\u0010S\u001A\u00020\u0010*\u00020T2\u0006\u0010\u0003\u001A\u00020\u0004H\u0002¢\u0006\u0004\bU\u0010V\u001A\u001B\u0010\\\u001A\u00020**\u00020]2\u0006\u0010-\u001A\u00020.H\u0000¢\u0006\u0004\b^\u0010_\"\u0010\u0010W\u001A\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Y\"\u0010\u0010Z\u001A\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Y\"\u000E\u0010[\u001A\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2={"awaitTouchSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onTouchSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "Landroidx/compose/ui/geometry/Offset;", "overSlop", "", "awaitTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drag", "", "onDrag", "Lkotlin/Function1;", "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "awaitVerticalTouchSlopOrCancellation", "", "awaitVerticalTouchSlopOrCancellation-jO51t88", "awaitVerticalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verticalDrag", "verticalDrag-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "detectVerticalDragGestures", "onVerticalDrag", "awaitHorizontalTouchSlopOrCancellation", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "awaitHorizontalPointerSlopOrCancellation", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "horizontalDrag", "horizontalDrag-jO51t88", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "detectHorizontalDragGestures", "onHorizontalDrag", "orientation", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "awaitDragOrUp-jO51t88", "awaitPointerSlopOrCancellation", "initialPositionChange", "awaitPointerSlopOrCancellation-6ksA65w", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllPointersUpWithSlopDetection", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float v0 = Dp.constructor-impl(0.125f);
        DragGestureDetectorKt.mouseSlop = v0;
        float v1 = Dp.constructor-impl(18f);
        DragGestureDetectorKt.defaultTouchSlop = v1;
        DragGestureDetectorKt.mouseToTouchSlopRatio = v0 / v1;
    }

    public static final boolean access$isPointerUp-DmW0f2w(PointerEvent arg0, long arg1) {
        return DragGestureDetectorKt.isPointerUp-DmW0f2w(arg0, arg1);
    }

    public static final Object awaitAllPointersUpWithSlopDetection(AwaitPointerEventScope arg17, PointerInputChange arg18, PointerEventPass arg19, Continuation arg20) {
        boolean v4_2;
        Object v13;
        Object v14;
        Object v1_2;
        Continuation v3_2;
        Object v11;
        float v16;
        Object v10;
        Object v9;
        Object v8;
        int v6;
        float v3_1;
        AwaitPointerEventScope v10_1;
        float v6_1;
        int v7_1;
        DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 v1_1;
        int v3;
        Continuation v0 = arg20;
        if((v0 instanceof DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v1).label & v3) != 0) {
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        int v4 = 0;
        int v5 = 1;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            if(ForEachGestureKt.allPointersUp(arg17)) {
                return Boxing.boxBoolean(false);
            }
            else {
                LongRef v0_2 = new LongRef();
                v0_2.element = arg18.getId-J3iCeTQ();
                v3_1 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg17.getViewConfiguration(), arg18.getType-T8wyACA());
                LongRef v9_1 = v0_2;
                v7_1 = 0;
                TouchSlopDetector v8_1 = new TouchSlopDetector(null, 0, 3, null);
                AwaitPointerEventScope v0_3 = arg17;
                v6_1 = v3_1;
                v3_2 = ((Continuation)v1_1);
                PointerEventPass v1_3 = arg19;
            label_63:
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).L$0 = v0_3;
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).L$1 = v1_2;
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).L$2 = v9;
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).L$3 = v8_1;
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).I$0 = v7_1;
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).F$0 = v6_1;
                ((DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1)v3_2).label = v5;
                v10 = v0_3.awaitPointerEvent(((PointerEventPass)v1_2), v3_2);
                if(v10 == v2) {
                    return v2;
                }
                else {
                    v11 = v10;
                    v10_1 = v0_3;
                    v0_1 = v11;
                    v16 = v6_1;
                    v6 = v7_1;
                    TouchSlopDetector v11_1 = v8_1;
                }
            }
        }
        else if(v3 == 1) {
            v3_1 = v1_1.F$0;
            v6 = v1_1.I$0;
            Object v7 = v1_1.L$3;
            v8 = v1_1.L$2;
            v9 = v1_1.L$1;
            v10 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v16 = v3_1;
            v11 = v7;
            v3_2 = ((Continuation)v1_1);
            v1_2 = v9;
            v9 = v8;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v7_2 = ((PointerEvent)v0_1).getChanges();
        int v8_2 = v7_2.size();
        int v12 = v4;
        while(true) {
            if(v12 < v8_2) {
                v14 = v7_2.get(v12);
                Object v18 = v14;
                if(PointerId.equals-impl0(v14.getId-J3iCeTQ(), ((LongRef)v9).element)) {
                    v14 = v18;
                }
                else {
                    ++v12;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_98;
        }

        v14 = null;
    label_98:
        if(v14 == null || (PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v14)))) {
            List v4_1 = ((PointerEvent)v0_1).getChanges();
            v5 = v4_1.size();
            v7_1 = 0;
            while(true) {
                if(v7_1 < v5) {
                    v8 = v4_1.get(v7_1);
                    if(v8.getPressed()) {
                        v13 = v8;
                    }
                    else {
                        ++v7_1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_125;
            }

            v13 = null;
        label_125:
            if(v13 == null) {
                v4_2 = v6 != 0 ? true : false;
                return Boxing.boxBoolean(v4_2);
            }

            ((LongRef)v9).element = ((PointerInputChange)v13).getId-J3iCeTQ();
        label_134:
            v7_1 = v6;
        }
        else if((((TouchSlopDetector)v11).addPositions-akrDWew(((PointerInputChange)v14).getPosition-F1C5BW0(), ((PointerInputChange)v14).getPreviousPosition-F1C5BW0(), v16) & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            v7_1 = 1;
        }
        else {
            goto label_134;
        }

        List v0_4 = ((PointerEvent)v0_1).getChanges();
        v4 = v0_4.size();
        for(v5 = 0; v5 < v4; ++v5) {
            if(v0_4.get(v5).getPressed()) {
                v0_1 = v10_1;
                v8 = v11;
                v6_1 = v16;
                v4 = 0;
                v5 = 1;
                goto label_63;
            }
        }

        v4_2 = v7_1 != 0 ? true : false;
        return Boxing.boxBoolean(v4_2);
    }

    public static Object awaitAllPointersUpWithSlopDetection$default(AwaitPointerEventScope arg0, PointerInputChange arg1, PointerEventPass arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = PointerEventPass.Main;
        }

        return DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(arg0, arg1, arg2, arg3);
    }

    public static final Object awaitDragOrCancellation-rnUCldI(AwaitPointerEventScope arg17, long arg18, Continuation arg20) {
        Object v8_1;
        List v2_3;
        Object v11;
        Object v1;
        DragGestureDetectorKt$awaitDragOrCancellation$1 v3_1;
        int v5;
        long v0 = arg18;
        Continuation v2 = arg20;
        if((v2 instanceof DragGestureDetectorKt$awaitDragOrCancellation$1)) {
            Continuation v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitDragOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitDragOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v3_1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(v2);
        }

        Object v2_1 = v3_1.result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = v3_1.label;
        Object v7 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v0)) {
                return v7;
            }
            else {
                LongRef v2_2 = new LongRef();
                v2_2.element = v0;
                AwaitPointerEventScope v0_2 = arg17;
            label_42:
                v3_1.L$0 = v0_2;
                v3_1.L$1 = v2_2;
                v3_1.label = 1;
                v1 = AwaitPointerEventScope.awaitPointerEvent$default(v0_2, ((PointerEventPass)v7), ((Continuation)v3_1), 1, v7);
                if(v1 == v4) {
                    return v4;
                }
                else {
                    LongRef v16_1 = v2_2;
                    v2_1 = v1;
                    LongRef v1_1 = v16_1;
                }
            }
        }
        else if(v5 == 1) {
            Object v0_1 = v3_1.L$1;
            v1 = v3_1.L$0;
            ResultKt.throwOnFailure(v2_1);
            Object v16 = v1;
            v1 = v0_1;
            v0_1 = v16;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v5_1 = ((PointerEvent)v2_1).getChanges();
        int v8 = v5_1.size();
        int v9 = 0;
        int v10 = 0;
        while(true) {
            if(v10 < v8) {
                v11 = v5_1.get(v10);
                if(PointerId.equals-impl0(v11.getId-J3iCeTQ(), ((LongRef)v1).element)) {
                }
                else {
                    ++v10;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_67;
        }

        v11 = v7;
    label_67:
        if(v11 == null) {
            v11 = v7;
        }
        else {
            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v11))) {
                v2_3 = ((PointerEvent)v2_1).getChanges();
                v5 = v2_3.size();
                goto label_75;
            }
            else {
                if(!PointerEventKt.positionChangedIgnoreConsumed(((PointerInputChange)v11))) {
                    goto label_96;
                }

                goto label_91;
                while(true) {
                label_75:
                    if(v9 < v5) {
                        v8_1 = v2_3.get(v9);
                        if(v8_1.getPressed()) {
                        }
                        else {
                            ++v9;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_84;
                }

                v8_1 = v7;
            label_84:
                if(v8_1 == null) {
                    goto label_91;
                }

                ((LongRef)v1).element = ((PointerInputChange)v8_1).getId-J3iCeTQ();
            }

        label_96:
            v2_1 = v1;
            goto label_42;
        }

    label_91:
        if(v11 != null && !((PointerInputChange)v11).isConsumed()) {
            return v11;
        }

        return v7;
    }

    private static final Object awaitDragOrUp-jO51t88(AwaitPointerEventScope arg10, long arg11, Function1 arg13, Continuation arg14) {
        Object v11_1;
        List v12_1;
        Object v5;
        LongRef v0 = new LongRef();
        v0.element = arg11;
        while(true) {
            PointerEventPass v11 = null;
            Object v12 = AwaitPointerEventScope.awaitPointerEvent$default(arg10, v11, arg14, 1, v11);
            List v1 = ((PointerEvent)v12).getChanges();
            int v2 = v1.size();
            int v3 = 0;
            int v4 = 0;
            while(true) {
                if(v4 < v2) {
                    v5 = v1.get(v4);
                    if(Boolean.valueOf(PointerId.equals-impl0(v5.getId-J3iCeTQ(), v0.element)).booleanValue()) {
                    }
                    else {
                        ++v4;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_25;
            }

            v5 = v11;
        label_25:
            if(v5 == null) {
                return v11;
            }

            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v5))) {
                v12_1 = ((PointerEvent)v12).getChanges();
                int v1_1 = v12_1.size();
                goto label_31;
            }
            else {
                if(!arg13.invoke(v5).booleanValue()) {
                    continue;
                }

                return v5;
            label_31:
                while(v3 < v1_1) {
                    Object v2_1 = v12_1.get(v3);
                    if(Boolean.valueOf(v2_1.getPressed()).booleanValue()) {
                        v11_1 = v2_1;
                    }
                    else {
                        ++v3;
                        continue;
                    }

                    break;
                }

                if(v11_1 == null) {
                    return v5;
                }

                v0.element = ((PointerInputChange)v11_1).getId-J3iCeTQ();
                continue;
            }
        }

        return v5;
    }

    public static final Object awaitHorizontalDragOrCancellation-rnUCldI(AwaitPointerEventScope arg17, long arg18, Continuation arg20) {
        Object v8_1;
        List v2_3;
        Object v11;
        Object v1;
        Object v0_1;
        int v5;
        Continuation v3;
        long v0 = arg18;
        Continuation v2 = arg20;
        if((v2 instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 v3_1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(v2);
        }

        Object v2_1 = ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).label;
        Object v7 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v0)) {
                return v7;
            }
            else {
                LongRef v2_2 = new LongRef();
                v2_2.element = v0;
                AwaitPointerEventScope v0_2 = arg17;
            label_42:
                ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).L$0 = v0_1;
                ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).L$1 = v2_2;
                ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).label = 1;
                v1 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v0_1), ((PointerEventPass)v7), v3, 1, v7);
                if(v1 == v4) {
                    return v4;
                }
                else {
                    LongRef v16_1 = v2_2;
                    v2_1 = v1;
                    LongRef v1_1 = v16_1;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).L$1;
            v1 = ((DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            Object v16 = v1;
            v1 = v0_1;
            v0_1 = v16;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v5_1 = ((PointerEvent)v2_1).getChanges();
        int v8 = v5_1.size();
        int v9 = 0;
        int v10 = 0;
        while(true) {
            if(v10 < v8) {
                v11 = v5_1.get(v10);
                if(PointerId.equals-impl0(v11.getId-J3iCeTQ(), ((LongRef)v1).element)) {
                }
                else {
                    ++v10;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_67;
        }

        v11 = v7;
    label_67:
        if(v11 == null) {
            v11 = v7;
        }
        else {
            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v11))) {
                v2_3 = ((PointerEvent)v2_1).getChanges();
                v5 = v2_3.size();
                goto label_75;
            }
            else {
                if(Float.intBitsToFloat(((int)(PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v11)) >> 0x20))) == 0f) {
                    v9 = 1;
                }

                if(v9 != 0) {
                    goto label_103;
                }

                goto label_98;
                while(true) {
                label_75:
                    if(v9 < v5) {
                        v8_1 = v2_3.get(v9);
                        if(v8_1.getPressed()) {
                        }
                        else {
                            ++v9;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_84;
                }

                v8_1 = v7;
            label_84:
                if(v8_1 == null) {
                    goto label_98;
                }

                ((LongRef)v1).element = ((PointerInputChange)v8_1).getId-J3iCeTQ();
            }

        label_103:
            v2_1 = v1;
            goto label_42;
        }

    label_98:
        if(v11 != null && !((PointerInputChange)v11).isConsumed()) {
            return v11;
        }

        return v7;
    }

    public static final Object awaitHorizontalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope arg17, long arg18, int arg20, Function2 arg21, Continuation arg22) {
        Object v0_2;
        float v6_1;
        int v1_1;
        Object v11;
        Object v10;
        Object v9;
        Object v5_1;
        Object v1;
        float v0_1;
        Object v6_2;
        int v13;
        List v2_4;
        Object v15;
        float v5_2;
        int v5;
        Continuation v3;
        long v0 = arg18;
        Continuation v2 = arg22;
        if((v2 instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 v3_1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(v2);
        }

        Object v2_1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label;
        int v6 = 2;
        int v7 = 1;
        Object v8 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            Orientation v2_2 = Orientation.Horizontal;
            long v9_1 = Offset.Companion.getZero-F1C5BW0();
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v0)) {
                return v8;
            }
            else {
                v5_2 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg17.getViewConfiguration(), arg20);
                LongRef v11_1 = new LongRef();
                v11_1.element = v0;
                Function2 v1_2 = arg21;
                TouchSlopDetector v2_3 = new TouchSlopDetector(v2_2, v9_1, ((DefaultConstructorMarker)v8));
                AwaitPointerEventScope v0_3 = arg17;
            label_70:
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$0 = v1_2;
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$1 = v0_2;
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$2 = v11_1;
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$3 = v2_3;
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$4 = v8;
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$0 = v5_2;
                ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label = v7;
                v9 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v0_2), ((PointerEventPass)v8), v3, v7, v8);
                if(v9 == v4) {
                    return v4;
                }
                else {
                    Function2 v10_1 = v1_2;
                    v1 = v2_3;
                    v2_1 = v9;
                    v9 = v0_2;
                    v0_1 = v5_2;
                    goto label_85;
                    return v4;
                label_85:
                    List v5_3 = ((PointerEvent)v2_1).getChanges();
                    int v12 = v5_3.size();
                    int v14 = 0;
                    while(true) {
                        if(v14 < v12) {
                            v15 = v5_3.get(v14);
                            int v18 = v14;
                            if(PointerId.equals-impl0(v15.getId-J3iCeTQ(), v11_1.element)) {
                            }
                            else {
                                v14 = v18 + 1;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_103;
                    }

                    v15 = v8;
                label_103:
                    v5_1 = v15;
                    if(v5_1 == null) {
                        return v8;
                    }

                    if(((PointerInputChange)v5_1).isConsumed()) {
                        return v8;
                    }

                    if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v5_1))) {
                        v2_4 = ((PointerEvent)v2_1).getChanges();
                        v5 = v2_4.size();
                        v13 = 0;
                        goto label_115;
                    }
                    else {
                        float v22 = v0_1;
                        Object v17 = v1;
                        v0 = ((TouchSlopDetector)v17).addPositions-akrDWew(((PointerInputChange)v5_1).getPosition-F1C5BW0(), ((PointerInputChange)v5_1).getPreviousPosition-F1C5BW0(), v22);
                        v2_1 = v17;
                        v6_1 = v22;
                        if((0x7FFFFFFF7FFFFFFFL & v0) != 0x7FC000007FC00000L) {
                            ((Function2)v10).invoke(v5_1, Boxing.boxFloat(Float.intBitsToFloat(((int)(v0 >> 0x20)))));
                            if(((PointerInputChange)v5_1).isConsumed()) {
                                return v5_1;
                            }
                            else {
                                v7 = 1;
                                TouchSlopDetector.reset-k-4lQ0M$default(((TouchSlopDetector)v2_1), 0, 1, v8);
                            }
                        }
                        else {
                            v7 = 1;
                            PointerEventPass v0_4 = PointerEventPass.Final;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$0 = v10;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$1 = v9;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$2 = v11_1;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$3 = v2_1;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$4 = v5_1;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$0 = v6_1;
                            v1_1 = 2;
                            ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).label = v1_1;
                            if(((AwaitPointerEventScope)v9).awaitPointerEvent(v0_4, v3) == v4) {
                                return v4;
                            }

                            v0_2 = v9;
                            goto label_176;
                            while(true) {
                            label_115:
                                if(v13 < v5) {
                                    v6_2 = v2_4.get(v13);
                                    if(v6_2.getPressed()) {
                                    }
                                    else {
                                        ++v13;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_124;
                            }

                            v6_2 = v8;
                        label_124:
                            if(v6_2 == null) {
                                return v8;
                            }

                            v11_1.element = ((PointerInputChange)v6_2).getId-J3iCeTQ();
                            v6_1 = v0_1;
                            v2_1 = v1;
                            v7 = 1;
                        }
                    }

                    v5_2 = v6_1;
                    v0_2 = v9;
                    v1 = v10;
                    goto label_70;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$3;
            v5_1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$2;
            v9 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$1;
            v10 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v11 = v5_1;
            goto label_85;
        }
        else if(v5 == v6) {
            v0_1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$4;
            v5_1 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$3;
            v9 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$2;
            v10 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$1;
            v11 = ((DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v2_1 = v5_1;
            v5_1 = v1;
            v1_1 = v6;
            v6_1 = v0_1;
            v0_2 = v10;
            v10 = v11;
            v11 = v9;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_176:
        if(((PointerInputChange)v5_1).isConsumed()) {
            return v8;
        }

        v5_2 = v6_1;
        v1 = v10;
        goto label_70;
    }

    public static final Object awaitHorizontalTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope arg19, long arg20, Function2 arg22, Continuation arg23) {
        Object v0_2;
        int v8_1;
        float v2_2;
        Object v3_2;
        Continuation v5_2;
        Object v11;
        Object v10;
        Object v9;
        Object v5_1;
        Object v1;
        float v0_1;
        Object v12;
        float v17;
        Object v6_3;
        List v2_4;
        Object v18;
        Object v14;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 v3_1;
        int v5;
        long v0 = arg20;
        Continuation v2 = arg23;
        if((v2 instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)) {
            Continuation v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v3_1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(v2);
        }

        Object v2_1 = v3_1.result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = v3_1.label;
        int v6 = 2;
        int v7 = 1;
        Object v8 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            int v2_3 = PointerType.Companion.getTouch-T8wyACA();
            Orientation v5_3 = Orientation.Horizontal;
            long v9_1 = Offset.Companion.getZero-F1C5BW0();
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg19.getCurrentEvent(), v0)) {
                return v8;
            }
            else {
                v2_2 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg19.getViewConfiguration(), v2_3);
                LongRef v11_1 = new LongRef();
                v11_1.element = v0;
                TouchSlopDetector v0_3 = new TouchSlopDetector(v5_3, v9_1, ((DefaultConstructorMarker)v8));
                Function2 v1_1 = arg22;
                v5_2 = ((Continuation)v3_1);
                TouchSlopDetector v3_3 = v0_3;
                AwaitPointerEventScope v0_4 = arg19;
            label_77:
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$0 = v1;
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$1 = v0_4;
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$2 = v11_1;
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$3 = v3_2;
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$4 = v8;
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).F$0 = v2_2;
                ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).label = v7;
                v9 = AwaitPointerEventScope.awaitPointerEvent$default(v0_4, ((PointerEventPass)v8), v5_2, v7, v8);
                if(v9 == v4) {
                    return v4;
                }
                else {
                    v17 = v2_2;
                    v12 = v3_2;
                    v2_1 = v9;
                    goto label_90;
                    return v4;
                label_90:
                    List v3_4 = ((PointerEvent)v2_1).getChanges();
                    int v9_2 = v3_4.size();
                    int v10_1 = 0;
                    int v13 = 0;
                    while(true) {
                        if(v13 < v9_2) {
                            v14 = v3_4.get(v13);
                            v18 = v8;
                            int v19 = v9_2;
                            if(PointerId.equals-impl0(v14.getId-J3iCeTQ(), v11_1.element)) {
                            }
                            else {
                                ++v13;
                                v9_2 = v19;
                                v8 = v18;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_113;
                    }

                    v18 = v8;
                    v14 = v18;
                label_113:
                    v3_2 = v14;
                    if(v3_2 == null) {
                        return v18;
                    }

                    if(((PointerInputChange)v3_2).isConsumed()) {
                        return v18;
                    }

                    if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v3_2))) {
                        v2_4 = ((PointerEvent)v2_1).getChanges();
                        int v3_5 = v2_4.size();
                        goto label_124;
                    }
                    else {
                        long v6_1 = ((TouchSlopDetector)v12).addPositions-akrDWew(((PointerInputChange)v3_2).getPosition-F1C5BW0(), ((PointerInputChange)v3_2).getPreviousPosition-F1C5BW0(), v17);
                        v2_2 = v17;
                        if((0x7FFFFFFF7FFFFFFFL & v6_1) != 0x7FC000007FC00000L) {
                            ((Function2)v1).invoke(v3_2, Boxing.boxFloat(Float.intBitsToFloat(((int)(v6_1 >> 0x20)))));
                            if(((PointerInputChange)v3_2).isConsumed()) {
                                return v3_2;
                            }
                            else {
                                v8_1 = 1;
                                TouchSlopDetector.reset-k-4lQ0M$default(((TouchSlopDetector)v12), 0, 1, v18);
                            }
                        }
                        else {
                            v8_1 = 1;
                            PointerEventPass v6_2 = PointerEventPass.Final;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$0 = v1;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$1 = v0_4;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$2 = v11_1;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$3 = v12;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).L$4 = v3_2;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).F$0 = v2_2;
                            v7 = 2;
                            ((DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1)v5_2).label = v7;
                            if(v0_4.awaitPointerEvent(v6_2, v5_2) == v4) {
                                return v4;
                            }

                            v9 = v11_1;
                            v11 = v1;
                            v1 = v3_2;
                            v3_2 = v12;
                            goto label_183;
                            while(true) {
                            label_124:
                                if(v10_1 < v3_5) {
                                    v6_3 = v2_4.get(v10_1);
                                    if(v6_3.getPressed()) {
                                    }
                                    else {
                                        ++v10_1;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_133;
                            }

                            v6_3 = v18;
                        label_133:
                            if(v6_3 == null) {
                                return v18;
                            }

                            v11_1.element = ((PointerInputChange)v6_3).getId-J3iCeTQ();
                            v2_2 = v17;
                            v8_1 = 1;
                        }
                    }

                    v7 = v8_1;
                    v3_2 = v12;
                    v8 = null;
                    goto label_77;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = v3_1.F$0;
            v1 = v3_1.L$3;
            v5_1 = v3_1.L$2;
            v9 = v3_1.L$1;
            v10 = v3_1.L$0;
            ResultKt.throwOnFailure(v2_1);
            v17 = v0_1;
            v12 = v1;
            v11 = v5_1;
            v0_2 = v9;
            v1 = v10;
            v5_2 = ((Continuation)v3_1);
            goto label_90;
        }
        else if(v5 == v6) {
            v0_1 = v3_1.F$0;
            v1 = v3_1.L$4;
            v5_1 = v3_1.L$3;
            v9 = v3_1.L$2;
            v10 = v3_1.L$1;
            v11 = v3_1.L$0;
            ResultKt.throwOnFailure(v2_1);
            v2_1 = v5_1;
            v5_2 = ((Continuation)v3_1);
            v3_2 = v2_1;
            v2_2 = v0_1;
            v8_1 = 1;
            v0_2 = v10;
            v7 = v6;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_183:
        v18 = null;
        if(((PointerInputChange)v1).isConsumed()) {
            return v18;
        }

        v7 = v8_1;
        v1 = v11;
        v8 = v18;
        v11 = v9;
        goto label_77;
    }

    public static final Object awaitLongPressOrCancellation-rnUCldI(AwaitPointerEventScope arg9, long arg10, Continuation arg12) {
        Object v11;
        Object v10;
        Object v9;
        Object v6;
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 v0_1;
        int v2;
        if((arg12 instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1)) {
            Continuation v0 = arg12;
            v2 = 0x80000000;
            if((((DragGestureDetectorKt$awaitLongPressOrCancellation$1)v0).label & v2) != 0) {
                ((DragGestureDetectorKt$awaitLongPressOrCancellation$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(arg12);
        }

        Object v12 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Object v4 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v12);
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg9.getCurrentEvent(), arg10)) {
                return v4;
            }
            else {
                List v12_1 = arg9.getCurrentEvent().getChanges();
                v2 = v12_1.size();
                int v5 = 0;
                while(true) {
                    if(v5 < v2) {
                        v6 = v12_1.get(v5);
                        if(PointerId.equals-impl0(v6.getId-J3iCeTQ(), arg10)) {
                        }
                        else {
                            ++v5;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_49;
                }

                v6 = v4;
            label_49:
                v11 = v6;
                if(v11 == null) {
                    return v4;
                }

                ObjectRef v10_1 = new ObjectRef();
                ObjectRef v12_2 = new ObjectRef();
                v12_2.element = v11;
                long v5_1 = arg9.getViewConfiguration().getLongPressTimeoutMillis();
                try {
                    BooleanRef v2_1 = new BooleanRef();
                    DragGestureDetectorKt$awaitLongPressOrCancellation$2 v7 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(v2_1, v12_2, v10_1, ((Continuation)v4));
                    v0_1.L$0 = v11;
                    v0_1.L$1 = v10_1;
                    v0_1.L$2 = v2_1;
                    v0_1.label = 1;
                    if(arg9.withTimeout(v5_1, ((Function2)v7), ((Continuation)v0_1)) == v1) {
                        return v1;
                    }

                    BooleanRef v9_1 = v2_1;
                label_71:
                    if(!v9_1.element) {
                        return v4;
                    }

                    v9 = ((ObjectRef)v10).element;
                    if(v9 != null) {
                        return v9;
                    }

                    return v11;
                }
                catch(PointerEventTimeoutCancellationException ) {
                    goto label_78;
                }
            }
        }
        else if(v2 == 1) {
            v9 = v0_1.L$2;
            v10 = v0_1.L$1;
            v11 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v12);
                goto label_71;
            }
            catch(PointerEventTimeoutCancellationException ) {
                goto label_78;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_71;
        return v11;
    label_78:
        v9 = ((ObjectRef)v10).element;
        if(v9 == null) {
        }
        else {
            v11 = v9;
        }

        return v11;
    }

    public static final Object awaitPointerSlopOrCancellation-6ksA65w(AwaitPointerEventScope arg18, long arg19, int arg21, Orientation arg22, long arg23, Function2 arg25, Continuation arg26) {
        Object v7_1;
        int v11_1;
        Object v0_2;
        float v2_3;
        Object v3_2;
        Continuation v5_2;
        int v1_1;
        Object v6_1;
        Object v10;
        Object v9;
        Object v5_1;
        Object v1;
        float v0_1;
        Object v17;
        int v13;
        List v2_4;
        Object v15;
        int v5;
        Continuation v3;
        long v0 = arg19;
        Continuation v2 = arg26;
        if((v2 instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 v3_1 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(v2);
        }

        Object v2_1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).label;
        int v6 = 2;
        int v7 = 1;
        Object v8 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg18.getCurrentEvent(), v0)) {
                return v8;
            }
            else {
                v2_3 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg18.getViewConfiguration(), arg21);
                LongRef v5_3 = new LongRef();
                v5_3.element = v0;
                Function2 v1_2 = arg25;
                LongRef v9_1 = v5_3;
                v5_2 = v3;
                TouchSlopDetector v3_3 = new TouchSlopDetector(arg22, arg23, ((DefaultConstructorMarker)v8));
                AwaitPointerEventScope v0_3 = arg18;
                goto label_77;
            label_55:
                v3_2 = v17;
                List v11_2 = ((PointerEvent)v2_1).getChanges();
                int v12 = v11_2.size();
                int v14 = 0;
                while(true) {
                    if(v14 < v12) {
                        v15 = v11_2.get(v14);
                        int v19 = v14;
                        if(PointerId.equals-impl0(v15.getId-J3iCeTQ(), ((LongRef)v3_2).element)) {
                        }
                        else {
                            v14 = v19 + 1;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_113;
                }

                v15 = v8;
            label_113:
                v6_1 = v15;
                if(v6_1 == null) {
                    return v8;
                }

                if(((PointerInputChange)v6_1).isConsumed()) {
                    return v8;
                }

                if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v6_1))) {
                    v2_4 = ((PointerEvent)v2_1).getChanges();
                    v6 = v2_4.size();
                    v13 = 0;
                    goto label_125;
                }
                else {
                    float v23 = v0_1;
                    Object v18 = v1;
                    v0 = ((TouchSlopDetector)v18).addPositions-akrDWew(((PointerInputChange)v6_1).getPosition-F1C5BW0(), ((PointerInputChange)v6_1).getPreviousPosition-F1C5BW0(), v23);
                    v7_1 = v18;
                    v2_3 = v23;
                    if((0x7FFFFFFF7FFFFFFFL & v0) != 0x7FC000007FC00000L) {
                        ((Function2)v9).invoke(v6_1, Offset.box-impl(v0));
                        if(((PointerInputChange)v6_1).isConsumed()) {
                            return v6_1;
                        }
                        else {
                            v11_1 = 1;
                            TouchSlopDetector.reset-k-4lQ0M$default(((TouchSlopDetector)v7_1), 0, 1, v8);
                        }
                    }
                    else {
                        v11_1 = 1;
                        PointerEventPass v0_4 = PointerEventPass.Final;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$0 = v10;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$1 = v9;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$2 = v3_2;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$3 = v7_1;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$4 = v6_1;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).F$0 = v2_3;
                        v1_1 = 2;
                        ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).label = v1_1;
                        if(((AwaitPointerEventScope)v10).awaitPointerEvent(v0_4, v5_2) != v4) {
                            v0_2 = v7_1;
                            v7_1 = v3_2;
                            v3_2 = v0_2;
                            v0_2 = v10;
                            goto label_186;
                            while(true) {
                            label_125:
                                if(v13 < v6) {
                                    v7_1 = v2_4.get(v13);
                                    if(v7_1.getPressed()) {
                                    }
                                    else {
                                        ++v13;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_134;
                            }

                            v7_1 = v8;
                        label_134:
                            if(v7_1 == null) {
                                return v8;
                            }

                            ((LongRef)v3_2).element = ((PointerInputChange)v7_1).getId-J3iCeTQ();
                            v2_3 = v0_1;
                            v7_1 = v1;
                            v11_1 = 1;
                        }
                        else {
                            return v4;
                        }
                    }
                }

                v1 = v9;
                v0_2 = v10;
                v9 = v3_2;
                v3_2 = v7_1;
                goto label_192;
                return v4;
            label_192:
                v7 = v11_1;
            label_77:
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$0 = v0_3;
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$1 = v1_2;
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$2 = v9;
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$3 = v3_2;
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).L$4 = v8;
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).F$0 = v2_3;
                ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v5_2).label = v7;
                v10 = AwaitPointerEventScope.awaitPointerEvent$default(v0_3, ((PointerEventPass)v8), v5_2, v7, v8);
                if(v10 == v4) {
                    return v4;
                }

                v17 = v10;
                v10 = v0_3;
                v0_1 = v2_3;
                v2_1 = v17;
                LongRef v17_1 = ((LongRef)v9);
                Function2 v9_2 = v1_2;
                v1 = v3_2;
                goto label_55;
            }
        }
        else if(v5 == 1) {
            v0_1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$3;
            v5_1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$2;
            v9 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$1;
            v10 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v17 = v5_1;
            v5_2 = v3;
            goto label_55;
        }
        else if(v5 == v6) {
            v0_1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$4;
            v5_1 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$3;
            v9 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$2;
            v10 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$1;
            Object v11 = ((DragGestureDetectorKt$awaitPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            int v2_2 = v6;
            v6_1 = v1;
            v1_1 = v2_2;
            v2_1 = v5_1;
            v5_2 = v3;
            v3_2 = v2_1;
            v2_3 = v0_1;
            v0_2 = v11;
            v11_1 = 1;
            v7_1 = v9;
            v9 = v10;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_186:
        if(((PointerInputChange)v6_1).isConsumed()) {
            return v8;
        }

        v1 = v9;
        v9 = v7_1;
        goto label_192;
    }

    private static final Object awaitPointerSlopOrCancellation-6ksA65w$$forInline(AwaitPointerEventScope arg16, long arg17, int arg19, Orientation arg20, long arg21, Function2 arg23, Continuation arg24) {
        Object v8_1;
        float v1_2;
        TouchSlopDetector v4_1;
        int v10;
        List v2;
        Object v12;
        AwaitPointerEventScope v0 = arg16;
        long v1 = arg17;
        Continuation v3 = arg24;
        Object v5 = null;
        if(DragGestureDetectorKt.isPointerUp-DmW0f2w(v0.getCurrentEvent(), v1)) {
            return v5;
        }

        float v4 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(v0.getViewConfiguration(), arg19);
        LongRef v6 = new LongRef();
        v6.element = v1;
        TouchSlopDetector v1_1;
        for(v1_1 = new TouchSlopDetector(arg20, arg21, ((DefaultConstructorMarker)v5)); true; v1_1 = v15) {
            Object v7 = AwaitPointerEventScope.awaitPointerEvent$default(v0, ((PointerEventPass)v5), v3, 1, v5);
            List v8 = ((PointerEvent)v7).getChanges();
            int v9 = v8.size();
            int v11 = 0;
            while(true) {
                if(v11 < v9) {
                    v12 = v8.get(v11);
                    int v18 = v11;
                    if(Boolean.valueOf(PointerId.equals-impl0(v12.getId-J3iCeTQ(), v6.element)).booleanValue()) {
                    }
                    else {
                        v11 = v18 + 1;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_39;
            }

            v12 = v5;
        label_39:
            if(v12 == null) {
                return v5;
            }

            if(((PointerInputChange)v12).isConsumed()) {
                return v5;
            }

            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v12))) {
                v2 = ((PointerEvent)v7).getChanges();
                int v7_1 = v2.size();
                v10 = 0;
                goto label_49;
            }
            else {
                float v22 = v4;
                long v7_2 = v1_1.addPositions-akrDWew(((PointerInputChange)v12).getPosition-F1C5BW0(), ((PointerInputChange)v12).getPreviousPosition-F1C5BW0(), v22);
                v4_1 = v1_1;
                v1_2 = v22;
                if((0x7FFFFFFF7FFFFFFFL & v7_2) != 0x7FC000007FC00000L) {
                    arg23.invoke(v12, Offset.box-impl(v7_2));
                    if(((PointerInputChange)v12).isConsumed()) {
                        return v12;
                    }
                    else {
                        TouchSlopDetector.reset-k-4lQ0M$default(v4_1, 0, 1, v5);
                    }
                }
                else {
                    v0.awaitPointerEvent(PointerEventPass.Final, v3);
                    if(((PointerInputChange)v12).isConsumed()) {
                        return v5;
                        while(true) {
                        label_49:
                            if(v10 < v7_1) {
                                v8_1 = v2.get(v10);
                                if(Boolean.valueOf(v8_1.getPressed()).booleanValue()) {
                                }
                                else {
                                    ++v10;
                                    continue;
                                }
                            }
                            else {
                                break;
                            }

                            goto label_61;
                        }

                        v8_1 = v5;
                    label_61:
                        if(v8_1 == null) {
                            return v5;
                        }

                        v6.element = ((PointerInputChange)v8_1).getId-J3iCeTQ();
                        float v8_2 = v4;
                        v4_1 = v1_1;
                        v1_2 = v8_2;
                    }
                }
            }

            TouchSlopDetector v15 = v4_1;
            v4 = v1_2;
        }
    }

    public static Object awaitPointerSlopOrCancellation-6ksA65w$default(AwaitPointerEventScope arg16, long arg17, int arg19, Orientation arg20, long arg21, Function2 arg23, Continuation arg24, int arg25, Object arg26) {
        Object v5_1;
        List v2_1;
        Object v13;
        AwaitPointerEventScope v0 = arg16;
        Continuation v1 = arg24;
        long v2 = (arg25 & 8) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg21;
        long v5 = arg17;
        Object v7 = null;
        if(DragGestureDetectorKt.isPointerUp-DmW0f2w(v0.getCurrentEvent(), v5)) {
            return v7;
        }

        float v4 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(v0.getViewConfiguration(), arg19);
        TouchSlopDetector v8 = new TouchSlopDetector(arg20, v2, ((DefaultConstructorMarker)v7));
        while(true) {
            Object v3 = AwaitPointerEventScope.awaitPointerEvent$default(v0, ((PointerEventPass)v7), v1, 1, v7);
            List v9 = ((PointerEvent)v3).getChanges();
            int v10 = v9.size();
            int v11 = 0;
            int v12 = 0;
            while(true) {
                if(v12 < v10) {
                    v13 = v9.get(v12);
                    if(PointerId.equals-impl0(v13.getId-J3iCeTQ(), v5)) {
                    }
                    else {
                        ++v12;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_37;
            }

            v13 = v7;
        label_37:
            if(v13 != null) {
                if(((PointerInputChange)v13).isConsumed()) {
                    return v7;
                }

                if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v13))) {
                    v2_1 = ((PointerEvent)v3).getChanges();
                    int v3_1 = v2_1.size();
                    goto label_46;
                }

                float v22 = v4;
                long v3_2 = v8.addPositions-akrDWew(((PointerInputChange)v13).getPosition-F1C5BW0(), ((PointerInputChange)v13).getPreviousPosition-F1C5BW0(), v22);
                TouchSlopDetector v9_1 = v8;
                float v8_1 = v22;
                if((0x7FFFFFFF7FFFFFFFL & v3_2) != 0x7FC000007FC00000L) {
                    arg23.invoke(v13, Offset.box-impl(v3_2));
                    if(((PointerInputChange)v13).isConsumed()) {
                        return v13;
                    }
                    else {
                        TouchSlopDetector.reset-k-4lQ0M$default(v9_1, 0, 1, v7);
                    }
                }
                else {
                    v0.awaitPointerEvent(PointerEventPass.Final, v1);
                    if(((PointerInputChange)v13).isConsumed()) {
                        return v7;
                    }
                }

                v4 = v8_1;
                v8 = v9_1;
                continue;
            }

            return v7;
            while(true) {
            label_46:
                if(v11 < v3_1) {
                    v5_1 = v2_1.get(v11);
                    if(v5_1.getPressed()) {
                    }
                    else {
                        ++v11;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_55;
            }

            v5_1 = v7;
        label_55:
            if(v5_1 == null) {
                return v7;
            }

            v5 = ((PointerInputChange)v5_1).getId-J3iCeTQ();
        }
    }

    public static final Object awaitTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope arg18, long arg19, Function2 arg21, Continuation arg22) {
        int v10_1;
        Object v0_2;
        float v2_2;
        Object v3_2;
        Continuation v5_2;
        Object v11;
        Object v10;
        Object v9;
        Object v5_1;
        Object v1;
        float v0_1;
        float v16;
        Object v6_3;
        int v12;
        List v2_4;
        Object v14;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 v3_1;
        int v5;
        long v0 = arg19;
        Continuation v2 = arg22;
        if((v2 instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)) {
            Continuation v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v3_1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(v2);
        }

        Object v2_1 = v3_1.result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = v3_1.label;
        int v6 = 2;
        int v7 = 1;
        Object v8 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            int v2_3 = PointerType.Companion.getTouch-T8wyACA();
            long v9_1 = Offset.Companion.getZero-F1C5BW0();
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg18.getCurrentEvent(), v0)) {
                return v8;
            }
            else {
                v2_2 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg18.getViewConfiguration(), v2_3);
                LongRef v5_3 = new LongRef();
                v5_3.element = v0;
                TouchSlopDetector v0_3 = new TouchSlopDetector(((Orientation)v8), v9_1, ((DefaultConstructorMarker)v8));
                Function2 v1_1 = arg21;
                LongRef v9_2 = v5_3;
                v5_2 = ((Continuation)v3_1);
                TouchSlopDetector v3_3 = v0_3;
                AwaitPointerEventScope v0_4 = arg18;
            label_77:
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$0 = v1_1;
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$1 = v0_2;
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$2 = v9_2;
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$3 = v3_3;
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$4 = v8;
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).F$0 = v2_2;
                ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).label = v7;
                v10 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v0_2), ((PointerEventPass)v8), v5_2, v7, v8);
                if(v10 == v4) {
                    return v4;
                }
                else {
                    v16 = v2_2;
                    v11 = v3_3;
                    v2_1 = v10;
                    goto label_90;
                    return v4;
                label_90:
                    List v3_4 = ((PointerEvent)v2_1).getChanges();
                    v10_1 = v3_4.size();
                    int v13 = 0;
                    while(true) {
                        if(v13 < v10_1) {
                            v14 = v3_4.get(v13);
                            int v19 = v13;
                            if(PointerId.equals-impl0(v14.getId-J3iCeTQ(), v9_2.element)) {
                            }
                            else {
                                v13 = v19 + 1;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_108;
                    }

                    v14 = v8;
                label_108:
                    v3_2 = v14;
                    if(v3_2 == null) {
                        return v8;
                    }

                    if(((PointerInputChange)v3_2).isConsumed()) {
                        return v8;
                    }

                    if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v3_2))) {
                        v2_4 = ((PointerEvent)v2_1).getChanges();
                        int v3_5 = v2_4.size();
                        v12 = 0;
                        goto label_120;
                    }
                    else {
                        long v6_1 = ((TouchSlopDetector)v11).addPositions-akrDWew(((PointerInputChange)v3_2).getPosition-F1C5BW0(), ((PointerInputChange)v3_2).getPreviousPosition-F1C5BW0(), v16);
                        v2_2 = v16;
                        if((0x7FFFFFFF7FFFFFFFL & v6_1) != 0x7FC000007FC00000L) {
                            v1_1.invoke(v3_2, Offset.box-impl(v6_1));
                            if(((PointerInputChange)v3_2).isConsumed()) {
                                return v3_2;
                            }
                            else {
                                v10_1 = 1;
                                TouchSlopDetector.reset-k-4lQ0M$default(((TouchSlopDetector)v11), 0, 1, v8);
                            }
                        }
                        else {
                            v10_1 = 1;
                            PointerEventPass v6_2 = PointerEventPass.Final;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$0 = v1_1;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$1 = v0_2;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$2 = v9_2;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$3 = v11;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).L$4 = v3_2;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).F$0 = v2_2;
                            v7 = 2;
                            ((DragGestureDetectorKt$awaitTouchSlopOrCancellation$1)v5_2).label = v7;
                            if(((AwaitPointerEventScope)v0_2).awaitPointerEvent(v6_2, v5_2) == v4) {
                                return v4;
                            }

                            Object v17 = v11;
                            v11 = v1_1;
                            v1 = v3_2;
                            v3_2 = v17;
                            goto label_173;
                            while(true) {
                            label_120:
                                if(v12 < v3_5) {
                                    v6_3 = v2_4.get(v12);
                                    if(v6_3.getPressed()) {
                                    }
                                    else {
                                        ++v12;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_129;
                            }

                            v6_3 = v8;
                        label_129:
                            if(v6_3 == null) {
                                return v8;
                            }

                            v9_2.element = ((PointerInputChange)v6_3).getId-J3iCeTQ();
                            v2_2 = v16;
                            v10_1 = 1;
                        }
                    }

                    v7 = v10_1;
                    v3_2 = v11;
                    goto label_77;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = v3_1.F$0;
            v1 = v3_1.L$3;
            v5_1 = v3_1.L$2;
            v9 = v3_1.L$1;
            v10 = v3_1.L$0;
            ResultKt.throwOnFailure(v2_1);
            v16 = v0_1;
            v11 = v1;
            v0_2 = v9;
            v1 = v10;
            v9 = v5_1;
            v5_2 = ((Continuation)v3_1);
            goto label_90;
        }
        else if(v5 == v6) {
            v0_1 = v3_1.F$0;
            v1 = v3_1.L$4;
            v5_1 = v3_1.L$3;
            v9 = v3_1.L$2;
            v10 = v3_1.L$1;
            v11 = v3_1.L$0;
            ResultKt.throwOnFailure(v2_1);
            v2_1 = v5_1;
            v5_2 = ((Continuation)v3_1);
            v3_2 = v2_1;
            v2_2 = v0_1;
            v0_2 = v10;
            v10_1 = 1;
            v7 = v6;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_173:
        if(((PointerInputChange)v1).isConsumed()) {
            return v8;
        }

        v7 = v10_1;
        v1 = v11;
        goto label_77;
    }

    public static final Object awaitVerticalDragOrCancellation-rnUCldI(AwaitPointerEventScope arg17, long arg18, Continuation arg20) {
        Object v8_1;
        List v2_3;
        Object v11;
        Object v1;
        Object v0_1;
        LongRef v1_1;
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 v3_1;
        int v5;
        long v0 = arg18;
        Continuation v2 = arg20;
        if((v2 instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1)) {
            Continuation v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitVerticalDragOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitVerticalDragOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v3_1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(v2);
        }

        Object v2_1 = v3_1.result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = v3_1.label;
        Object v7 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v0)) {
                return v7;
            }
            else {
                LongRef v2_2 = new LongRef();
                v2_2.element = v0;
                AwaitPointerEventScope v0_2 = arg17;
            label_42:
                v3_1.L$0 = v0_1;
                v3_1.L$1 = v2_2;
                v3_1.label = 1;
                v1 = AwaitPointerEventScope.awaitPointerEvent$default(((AwaitPointerEventScope)v0_1), ((PointerEventPass)v7), ((Continuation)v3_1), 1, v7);
                if(v1 == v4) {
                    return v4;
                }
                else {
                    LongRef v16_1 = v2_2;
                    v2_1 = v1;
                    v1_1 = v16_1;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = v3_1.L$1;
            v1 = v3_1.L$0;
            ResultKt.throwOnFailure(v2_1);
            Object v16 = v1;
            v1 = v0_1;
            v0_1 = v16;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v5_1 = ((PointerEvent)v2_1).getChanges();
        int v8 = v5_1.size();
        int v9 = 0;
        int v10 = 0;
        while(true) {
            if(v10 < v8) {
                v11 = v5_1.get(v10);
                if(PointerId.equals-impl0(v11.getId-J3iCeTQ(), v1_1.element)) {
                }
                else {
                    ++v10;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_67;
        }

        v11 = v7;
    label_67:
        if(v11 == null) {
            v11 = v7;
        }
        else {
            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v11))) {
                v2_3 = ((PointerEvent)v2_1).getChanges();
                v5 = v2_3.size();
                goto label_75;
            }
            else {
                if(Float.intBitsToFloat(((int)(PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v11)) & 0xFFFFFFFFL))) == 0f) {
                    v9 = 1;
                }

                if(v9 != 0) {
                    goto label_103;
                }

                goto label_98;
                while(true) {
                label_75:
                    if(v9 < v5) {
                        v8_1 = v2_3.get(v9);
                        if(v8_1.getPressed()) {
                        }
                        else {
                            ++v9;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_84;
                }

                v8_1 = v7;
            label_84:
                if(v8_1 == null) {
                    goto label_98;
                }

                v1_1.element = ((PointerInputChange)v8_1).getId-J3iCeTQ();
            }

        label_103:
            v2_1 = v1_1;
            goto label_42;
        }

    label_98:
        if(v11 != null && !((PointerInputChange)v11).isConsumed()) {
            return v11;
        }

        return v7;
    }

    public static final Object awaitVerticalPointerSlopOrCancellation-gDDlDlE(AwaitPointerEventScope arg17, long arg18, int arg20, Function2 arg21, Continuation arg22) {
        Object v0_2;
        float v6_1;
        int v1_1;
        Object v11;
        Object v10;
        Object v9;
        Object v5_1;
        Object v1;
        float v0_1;
        Object v6_2;
        int v13;
        List v2_4;
        Object v15;
        float v5_2;
        int v5;
        Continuation v3;
        long v0 = arg18;
        Continuation v2 = arg22;
        if((v2 instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 v3_1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(v2);
        }

        Object v2_1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).label;
        int v6 = 2;
        int v7 = 1;
        Object v8 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            Orientation v2_2 = Orientation.Vertical;
            long v9_1 = Offset.Companion.getZero-F1C5BW0();
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v0)) {
                return v8;
            }
            else {
                v5_2 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg17.getViewConfiguration(), arg20);
                LongRef v11_1 = new LongRef();
                v11_1.element = v0;
                Function2 v1_2 = arg21;
                TouchSlopDetector v2_3 = new TouchSlopDetector(v2_2, v9_1, ((DefaultConstructorMarker)v8));
                AwaitPointerEventScope v0_3 = arg17;
            label_70:
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$0 = v1_2;
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$1 = v0_3;
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$2 = v11_1;
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$3 = v2_3;
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$4 = v8;
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).F$0 = v5_2;
                ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).label = v7;
                v9 = AwaitPointerEventScope.awaitPointerEvent$default(v0_3, ((PointerEventPass)v8), v3, v7, v8);
                if(v9 == v4) {
                    return v4;
                }
                else {
                    Function2 v10_1 = v1_2;
                    v1 = v2_3;
                    v2_1 = v9;
                    v9 = v0_3;
                    v0_1 = v5_2;
                    goto label_85;
                    return v4;
                label_85:
                    List v5_3 = ((PointerEvent)v2_1).getChanges();
                    int v12 = v5_3.size();
                    int v14 = 0;
                    while(true) {
                        if(v14 < v12) {
                            v15 = v5_3.get(v14);
                            int v18 = v14;
                            if(PointerId.equals-impl0(v15.getId-J3iCeTQ(), v11_1.element)) {
                            }
                            else {
                                v14 = v18 + 1;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_103;
                    }

                    v15 = v8;
                label_103:
                    v5_1 = v15;
                    if(v5_1 == null) {
                        return v8;
                    }

                    if(((PointerInputChange)v5_1).isConsumed()) {
                        return v8;
                    }

                    if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v5_1))) {
                        v2_4 = ((PointerEvent)v2_1).getChanges();
                        v5 = v2_4.size();
                        v13 = 0;
                        goto label_115;
                    }
                    else {
                        float v22 = v0_1;
                        Object v17 = v1;
                        v0 = ((TouchSlopDetector)v17).addPositions-akrDWew(((PointerInputChange)v5_1).getPosition-F1C5BW0(), ((PointerInputChange)v5_1).getPreviousPosition-F1C5BW0(), v22);
                        v2_1 = v17;
                        v6_1 = v22;
                        if((0x7FFFFFFF7FFFFFFFL & v0) != 0x7FC000007FC00000L) {
                            ((Function2)v10).invoke(v5_1, Boxing.boxFloat(Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL)))));
                            if(((PointerInputChange)v5_1).isConsumed()) {
                                return v5_1;
                            }
                            else {
                                v7 = 1;
                                TouchSlopDetector.reset-k-4lQ0M$default(((TouchSlopDetector)v2_1), 0, 1, v8);
                            }
                        }
                        else {
                            v7 = 1;
                            PointerEventPass v0_4 = PointerEventPass.Final;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$0 = v10;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$1 = v9;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$2 = v11_1;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$3 = v2_1;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$4 = v5_1;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).F$0 = v6_1;
                            v1_1 = 2;
                            ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).label = v1_1;
                            if(((AwaitPointerEventScope)v9).awaitPointerEvent(v0_4, v3) == v4) {
                                return v4;
                            }

                            v0_2 = v9;
                            goto label_176;
                            while(true) {
                            label_115:
                                if(v13 < v5) {
                                    v6_2 = v2_4.get(v13);
                                    if(v6_2.getPressed()) {
                                    }
                                    else {
                                        ++v13;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_124;
                            }

                            v6_2 = v8;
                        label_124:
                            if(v6_2 == null) {
                                return v8;
                            }

                            v11_1.element = ((PointerInputChange)v6_2).getId-J3iCeTQ();
                            v6_1 = v0_1;
                            v2_1 = v1;
                            v7 = 1;
                        }
                    }

                    v5_2 = v6_1;
                    v0_2 = v9;
                    v1 = v10;
                    goto label_70;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$3;
            v5_1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$2;
            v9 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$1;
            v10 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v11 = v5_1;
            goto label_85;
        }
        else if(v5 == v6) {
            v0_1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$4;
            v5_1 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$3;
            v9 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$2;
            v10 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$1;
            v11 = ((DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v2_1 = v5_1;
            v5_1 = v1;
            v1_1 = v6;
            v6_1 = v0_1;
            v0_2 = v10;
            v10 = v11;
            v11 = v9;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_176:
        if(((PointerInputChange)v5_1).isConsumed()) {
            return v8;
        }

        v5_2 = v6_1;
        v1 = v10;
        goto label_70;
    }

    public static final Object awaitVerticalTouchSlopOrCancellation-jO51t88(AwaitPointerEventScope arg19, long arg20, Function2 arg22, Continuation arg23) {
        Object v0_2;
        int v8_1;
        float v2_2;
        Object v3_2;
        Continuation v5_2;
        Object v11;
        Object v10;
        Object v9;
        Object v5_1;
        Object v1;
        float v0_1;
        Object v12;
        float v17;
        Object v6_3;
        List v2_4;
        Object v18;
        Object v14;
        int v5;
        Continuation v3;
        long v0 = arg20;
        Continuation v2 = arg23;
        if((v2 instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)) {
            v3 = v2;
            v5 = 0x80000000;
            if((((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).label & v5) != 0) {
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).label -= v5;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 v3_1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(v2);
        }

        Object v2_1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).result;
        Object v4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v5 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).label;
        int v6 = 2;
        int v7 = 1;
        Object v8 = null;
        if(v5 == 0) {
            ResultKt.throwOnFailure(v2_1);
            int v2_3 = PointerType.Companion.getTouch-T8wyACA();
            Orientation v5_3 = Orientation.Vertical;
            long v9_1 = Offset.Companion.getZero-F1C5BW0();
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg19.getCurrentEvent(), v0)) {
                return v8;
            }
            else {
                v2_2 = DragGestureDetectorKt.pointerSlop-E8SPZFQ(arg19.getViewConfiguration(), v2_3);
                LongRef v11_1 = new LongRef();
                v11_1.element = v0;
                TouchSlopDetector v0_3 = new TouchSlopDetector(v5_3, v9_1, ((DefaultConstructorMarker)v8));
                Function2 v1_1 = arg22;
                v5_2 = v3;
                TouchSlopDetector v3_3 = v0_3;
                AwaitPointerEventScope v0_4 = arg19;
            label_77:
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$0 = v1;
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$1 = v0_4;
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$2 = v11;
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$3 = v3_3;
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$4 = v8;
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).F$0 = v2_2;
                ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).label = v7;
                v9 = AwaitPointerEventScope.awaitPointerEvent$default(v0_4, ((PointerEventPass)v8), v5_2, v7, v8);
                if(v9 == v4) {
                    return v4;
                }
                else {
                    v17 = v2_2;
                    v12 = v3_3;
                    v2_1 = v9;
                    goto label_90;
                    return v4;
                label_90:
                    List v3_4 = ((PointerEvent)v2_1).getChanges();
                    int v9_2 = v3_4.size();
                    int v10_1 = 0;
                    int v13 = 0;
                    while(true) {
                        if(v13 < v9_2) {
                            v14 = v3_4.get(v13);
                            v18 = v8;
                            int v19 = v9_2;
                            if(PointerId.equals-impl0(v14.getId-J3iCeTQ(), ((LongRef)v11).element)) {
                            }
                            else {
                                ++v13;
                                v9_2 = v19;
                                v8 = v18;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_113;
                    }

                    v18 = v8;
                    v14 = v18;
                label_113:
                    v3_2 = v14;
                    if(v3_2 == null) {
                        return v18;
                    }

                    if(((PointerInputChange)v3_2).isConsumed()) {
                        return v18;
                    }

                    if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v3_2))) {
                        v2_4 = ((PointerEvent)v2_1).getChanges();
                        int v3_5 = v2_4.size();
                        goto label_124;
                    }
                    else {
                        long v6_1 = ((TouchSlopDetector)v12).addPositions-akrDWew(((PointerInputChange)v3_2).getPosition-F1C5BW0(), ((PointerInputChange)v3_2).getPreviousPosition-F1C5BW0(), v17);
                        v2_2 = v17;
                        if((0x7FFFFFFF7FFFFFFFL & v6_1) != 0x7FC000007FC00000L) {
                            ((Function2)v1).invoke(v3_2, Boxing.boxFloat(Float.intBitsToFloat(((int)(v6_1 & 0xFFFFFFFFL)))));
                            if(((PointerInputChange)v3_2).isConsumed()) {
                                return v3_2;
                            }
                            else {
                                v8_1 = 1;
                                TouchSlopDetector.reset-k-4lQ0M$default(((TouchSlopDetector)v12), 0, 1, v18);
                            }
                        }
                        else {
                            v8_1 = 1;
                            PointerEventPass v6_2 = PointerEventPass.Final;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$0 = v1;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$1 = v0_4;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$2 = v11;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$3 = v12;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).L$4 = v3_2;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).F$0 = v2_2;
                            v7 = 2;
                            ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v5_2).label = v7;
                            if(v0_4.awaitPointerEvent(v6_2, v5_2) == v4) {
                                return v4;
                            }

                            v9 = v11;
                            v11 = v1;
                            v1 = v3_2;
                            v3_2 = v12;
                            goto label_183;
                            while(true) {
                            label_124:
                                if(v10_1 < v3_5) {
                                    v6_3 = v2_4.get(v10_1);
                                    if(v6_3.getPressed()) {
                                    }
                                    else {
                                        ++v10_1;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_133;
                            }

                            v6_3 = v18;
                        label_133:
                            if(v6_3 == null) {
                                return v18;
                            }

                            ((LongRef)v11).element = ((PointerInputChange)v6_3).getId-J3iCeTQ();
                            v2_2 = v17;
                            v8_1 = 1;
                        }
                    }

                    v7 = v8_1;
                    v3_2 = v12;
                    v8 = null;
                    goto label_77;
                }
            }
        }
        else if(v5 == 1) {
            v0_1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$3;
            v5_1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$2;
            v9 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$1;
            v10 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v17 = v0_1;
            v12 = v1;
            v11 = v5_1;
            v0_2 = v9;
            v1 = v10;
            v5_2 = v3;
            goto label_90;
        }
        else if(v5 == v6) {
            v0_1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).F$0;
            v1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$4;
            v5_1 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$3;
            v9 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$2;
            v10 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$1;
            v11 = ((DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1)v3).L$0;
            ResultKt.throwOnFailure(v2_1);
            v2_1 = v5_1;
            v5_2 = v3;
            v3_2 = v2_1;
            v2_2 = v0_1;
            v8_1 = 1;
            v0_2 = v10;
            v7 = v6;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_183:
        v18 = null;
        if(((PointerInputChange)v1).isConsumed()) {
            return v18;
        }

        v7 = v8_1;
        v1 = v11;
        v8 = v18;
        v11 = v9;
        goto label_77;
    }

    public static final Object detectDragGestures(PointerInputScope arg9, Orientation arg10, Function3 arg11, Function1 arg12, Function0 arg13, Function0 arg14, Function2 arg15, Continuation arg16) {
        Object v9 = ForEachGestureKt.awaitEachGesture(arg9, new DragGestureDetectorKt$detectDragGestures$13(arg14, new LongRef(), arg10, arg11, arg15, arg13, arg12, null), arg16);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope arg8, Function1 arg9, Function0 arg10, Function0 arg11, Function2 arg12, Continuation arg13) {
        Object v8 = DragGestureDetectorKt.detectDragGestures(arg8, null, new DragGestureDetectorKt$$ExternalSyntheticLambda12(arg9), new DragGestureDetectorKt$$ExternalSyntheticLambda13(arg10), arg11, new DragGestureDetectorKt$$ExternalSyntheticLambda14(), arg12, arg13);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public static Object detectDragGestures$default(PointerInputScope arg8, Orientation arg9, Function3 arg10, Function1 arg11, Function0 arg12, Function0 arg13, Function2 arg14, Continuation arg15, int arg16, Object arg17) {
        DragGestureDetectorKt$$ExternalSyntheticLambda18 v13;
        DragGestureDetectorKt$$ExternalSyntheticLambda17 v12;
        DragGestureDetectorKt$$ExternalSyntheticLambda16 v11;
        DragGestureDetectorKt$$ExternalSyntheticLambda15 v10;
        if((arg16 & 2) != 0) {
            v10 = new DragGestureDetectorKt$$ExternalSyntheticLambda15();
        }

        Function3 v2 = ((Function3)v10);
        if((arg16 & 4) != 0) {
            v11 = new DragGestureDetectorKt$$ExternalSyntheticLambda16();
        }

        Function1 v3 = ((Function1)v11);
        if((arg16 & 8) != 0) {
            v12 = new DragGestureDetectorKt$$ExternalSyntheticLambda17();
        }

        Function0 v4 = ((Function0)v12);
        if((arg16 & 16) != 0) {
            v13 = new DragGestureDetectorKt$$ExternalSyntheticLambda18();
        }

        return DragGestureDetectorKt.detectDragGestures(arg8, arg9, v2, v3, v4, ((Function0)v13), arg14, arg15);
    }

    public static Object detectDragGestures$default(PointerInputScope arg0, Function1 arg1, Function0 arg2, Function0 arg3, Function2 arg4, Continuation arg5, int arg6, Object arg7) {
        DragGestureDetectorKt$$ExternalSyntheticLambda6 v3;
        DragGestureDetectorKt$$ExternalSyntheticLambda5 v2;
        DragGestureDetectorKt$$ExternalSyntheticLambda4 v1;
        if((arg6 & 1) != 0) {
            v1 = new DragGestureDetectorKt$$ExternalSyntheticLambda4();
        }

        if((arg6 & 2) != 0) {
            v2 = new DragGestureDetectorKt$$ExternalSyntheticLambda5();
        }

        if((arg6 & 4) != 0) {
            v3 = new DragGestureDetectorKt$$ExternalSyntheticLambda6();
        }

        return DragGestureDetectorKt.detectDragGestures(arg0, ((Function1)v1), ((Function0)v2), ((Function0)v3), arg4, arg5);
    }

    static final Unit detectDragGestures$lambda$0(Offset arg0) {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$1() {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$2() {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$3(Function1 arg0, PointerInputChange arg1, PointerInputChange arg2, Offset arg3) {
        arg0.invoke(Offset.box-impl(arg2.getPosition-F1C5BW0()));
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$4(Function0 arg0, PointerInputChange arg1) {
        arg0.invoke();
        return Unit.INSTANCE;
    }

    static final boolean detectDragGestures$lambda$5() {
        return 1;
    }

    static final Unit detectDragGestures$lambda$6(PointerInputChange arg0, PointerInputChange arg1, Offset arg2) {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$7(PointerInputChange arg0) {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$8() {
        return Unit.INSTANCE;
    }

    static final boolean detectDragGestures$lambda$9() {
        return 1;
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope arg6, Function1 arg7, Function0 arg8, Function0 arg9, Function2 arg10, Continuation arg11) {
        Object v6 = ForEachGestureKt.awaitEachGesture(arg6, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(arg7, arg8, arg9, arg10, null), arg11);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object detectDragGesturesAfterLongPress$default(PointerInputScope arg0, Function1 arg1, Function0 arg2, Function0 arg3, Function2 arg4, Continuation arg5, int arg6, Object arg7) {
        DragGestureDetectorKt$$ExternalSyntheticLambda3 v3;
        DragGestureDetectorKt$$ExternalSyntheticLambda2 v2;
        DragGestureDetectorKt$$ExternalSyntheticLambda1 v1;
        if((arg6 & 1) != 0) {
            v1 = new DragGestureDetectorKt$$ExternalSyntheticLambda1();
        }

        if((arg6 & 2) != 0) {
            v2 = new DragGestureDetectorKt$$ExternalSyntheticLambda2();
        }

        if((arg6 & 4) != 0) {
            v3 = new DragGestureDetectorKt$$ExternalSyntheticLambda3();
        }

        return DragGestureDetectorKt.detectDragGesturesAfterLongPress(arg0, ((Function1)v1), ((Function0)v2), ((Function0)v3), arg4, arg5);
    }

    static final Unit detectDragGesturesAfterLongPress$lambda$0(Offset arg0) {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGesturesAfterLongPress$lambda$1() {
        return Unit.INSTANCE;
    }

    static final Unit detectDragGesturesAfterLongPress$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope arg6, Function1 arg7, Function0 arg8, Function0 arg9, Function2 arg10, Continuation arg11) {
        Object v6 = ForEachGestureKt.awaitEachGesture(arg6, new DragGestureDetectorKt$detectHorizontalDragGestures$5(arg7, arg10, arg8, arg9, null), arg11);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object detectHorizontalDragGestures$default(PointerInputScope arg0, Function1 arg1, Function0 arg2, Function0 arg3, Function2 arg4, Continuation arg5, int arg6, Object arg7) {
        DragGestureDetectorKt$$ExternalSyntheticLambda11 v3;
        DragGestureDetectorKt$$ExternalSyntheticLambda10 v2;
        DragGestureDetectorKt$$ExternalSyntheticLambda0 v1;
        if((arg6 & 1) != 0) {
            v1 = new DragGestureDetectorKt$$ExternalSyntheticLambda0();
        }

        if((arg6 & 2) != 0) {
            v2 = new DragGestureDetectorKt$$ExternalSyntheticLambda10();
        }

        if((arg6 & 4) != 0) {
            v3 = new DragGestureDetectorKt$$ExternalSyntheticLambda11();
        }

        return DragGestureDetectorKt.detectHorizontalDragGestures(arg0, ((Function1)v1), ((Function0)v2), ((Function0)v3), arg4, arg5);
    }

    static final Unit detectHorizontalDragGestures$lambda$0(Offset arg0) {
        return Unit.INSTANCE;
    }

    static final Unit detectHorizontalDragGestures$lambda$1() {
        return Unit.INSTANCE;
    }

    static final Unit detectHorizontalDragGestures$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final Object detectVerticalDragGestures(PointerInputScope arg6, Function1 arg7, Function0 arg8, Function0 arg9, Function2 arg10, Continuation arg11) {
        Object v6 = ForEachGestureKt.awaitEachGesture(arg6, new DragGestureDetectorKt$detectVerticalDragGestures$5(arg7, arg10, arg8, arg9, null), arg11);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object detectVerticalDragGestures$default(PointerInputScope arg0, Function1 arg1, Function0 arg2, Function0 arg3, Function2 arg4, Continuation arg5, int arg6, Object arg7) {
        DragGestureDetectorKt$$ExternalSyntheticLambda9 v3;
        DragGestureDetectorKt$$ExternalSyntheticLambda8 v2;
        DragGestureDetectorKt$$ExternalSyntheticLambda7 v1;
        if((arg6 & 1) != 0) {
            v1 = new DragGestureDetectorKt$$ExternalSyntheticLambda7();
        }

        if((arg6 & 2) != 0) {
            v2 = new DragGestureDetectorKt$$ExternalSyntheticLambda8();
        }

        if((arg6 & 4) != 0) {
            v3 = new DragGestureDetectorKt$$ExternalSyntheticLambda9();
        }

        return DragGestureDetectorKt.detectVerticalDragGestures(arg0, ((Function1)v1), ((Function0)v2), ((Function0)v3), arg4, arg5);
    }

    static final Unit detectVerticalDragGestures$lambda$0(Offset arg0) {
        return Unit.INSTANCE;
    }

    static final Unit detectVerticalDragGestures$lambda$1() {
        return Unit.INSTANCE;
    }

    static final Unit detectVerticalDragGestures$lambda$2() {
        return Unit.INSTANCE;
    }

    public static final Object drag-VnAYq1g(AwaitPointerEventScope arg19, long arg20, Function1 arg22, Orientation arg23, Function1 arg24, Continuation arg25) {
        PointerEventPass v5_1;
        float v0_4;
        int v13;
        List v0_3;
        Object v17;
        Object v15;
        Object v1_2;
        Continuation v9_1;
        Object v10;
        Object v7;
        LongRef v7_1;
        long v6_1;
        int v3;
        Continuation v1;
        Continuation v0 = arg25;
        if((v0 instanceof DragGestureDetectorKt$drag$2)) {
            v1 = v0;
            v3 = 0x80000000;
            if((((DragGestureDetectorKt$drag$2)v1).label & v3) != 0) {
                ((DragGestureDetectorKt$drag$2)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            DragGestureDetectorKt$drag$2 v1_1 = new DragGestureDetectorKt$drag$2(v0);
        }

        Object v0_1 = ((DragGestureDetectorKt$drag$2)v1).result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = ((DragGestureDetectorKt$drag$2)v1).label;
        int v4 = 1;
        Object v5 = null;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            v6_1 = arg20;
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg19.getCurrentEvent(), v6_1)) {
                return v5;
            }
            else {
                AwaitPointerEventScope v0_2 = arg19;
                Orientation v3_2 = arg23;
                Function1 v8_1 = arg24;
                v9_1 = v1;
                Function1 v1_3 = arg22;
            label_51:
                LongRef v10_1 = new LongRef();
                v10_1.element = v6_1;
                AwaitPointerEventScope v6_2 = v0_2;
            label_55:
                ((DragGestureDetectorKt$drag$2)v9_1).L$0 = v0_2;
                ((DragGestureDetectorKt$drag$2)v9_1).L$1 = v1_2;
                ((DragGestureDetectorKt$drag$2)v9_1).L$2 = v3_2;
                ((DragGestureDetectorKt$drag$2)v9_1).L$3 = v8_1;
                ((DragGestureDetectorKt$drag$2)v9_1).L$4 = v6_2;
                ((DragGestureDetectorKt$drag$2)v9_1).L$5 = v10_1;
                ((DragGestureDetectorKt$drag$2)v9_1).label = v4;
                v7 = AwaitPointerEventScope.awaitPointerEvent$default(v6_2, ((PointerEventPass)v5), v9_1, v4, v5);
                if(v7 == v2) {
                    return v2;
                }
                else {
                    LongRef v18_1 = v10_1;
                    AwaitPointerEventScope v10_2 = v0_2;
                    v0_1 = v7;
                    v7_1 = v18_1;
                }
            }
        }
        else if(v3 == 1) {
            Object v3_1 = ((DragGestureDetectorKt$drag$2)v1).L$5;
            Object v6 = ((DragGestureDetectorKt$drag$2)v1).L$4;
            v7 = ((DragGestureDetectorKt$drag$2)v1).L$3;
            Object v8 = ((DragGestureDetectorKt$drag$2)v1).L$2;
            Object v9 = ((DragGestureDetectorKt$drag$2)v1).L$1;
            v10 = ((DragGestureDetectorKt$drag$2)v1).L$0;
            ResultKt.throwOnFailure(v0_1);
            Object v18 = v9;
            v9_1 = v1;
            v1_2 = v18;
            v18 = v7;
            v7 = v3_1;
            v3_1 = v8;
            v8 = v18;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        List v11 = ((PointerEvent)v0_1).getChanges();
        int v12 = v11.size();
        int v14 = 0;
        while(true) {
            if(v14 < v12) {
                v15 = v11.get(v14);
                v17 = v5;
                int v16 = v14;
                if(PointerId.equals-impl0(v15.getId-J3iCeTQ(), v7_1.element)) {
                }
                else {
                    v14 = v16 + 1;
                    v5 = v17;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_89;
        }

        v17 = v5;
        v15 = v17;
    label_89:
        if(v15 == null) {
            v15 = v17;
        }
        else {
            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v15))) {
                v0_3 = ((PointerEvent)v0_1).getChanges();
                v4 = v0_3.size();
                v13 = 0;
                goto label_98;
            }
            else {
                long v4_1 = PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v15));
                if(v3_2 == null) {
                    v0_4 = Offset.getDistance-impl(v4_1);
                }
                else if(v3_2 == Orientation.Vertical) {
                    v0_4 = Float.intBitsToFloat(((int)(v4_1 & 0xFFFFFFFFL)));
                }
                else {
                    v0_4 = Float.intBitsToFloat(((int)(v4_1 >> 0x20)));
                }

                v13 = v0_4 == 0f ? 1 : 0;
                if(v13 != 0) {
                    goto label_148;
                }

                goto label_133;
                while(true) {
                label_98:
                    if(v13 < v4) {
                        v5 = v0_3.get(v13);
                        if(v5.getPressed()) {
                        }
                        else {
                            ++v13;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_107;
                }

                v5 = v17;
            label_107:
                if(v5 == null) {
                    goto label_133;
                }

                v7_1.element = ((PointerInputChange)v5).getId-J3iCeTQ();
            }

        label_148:
            v0_1 = v10;
            v5_1 = ((PointerEventPass)v17);
            v4 = 1;
            v10 = v7_1;
            goto label_55;
        }

    label_133:
        if(v15 == null) {
            return v17;
        }

        if(v8_1.invoke(v15).booleanValue()) {
            return v17;
        }

        if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v15))) {
            return v15;
        }

        ((Function1)v1_2).invoke(v15);
        v6_1 = ((PointerInputChange)v15).getId-J3iCeTQ();
        v0_1 = v10;
        v5_1 = ((PointerEventPass)v17);
        v4 = 1;
        goto label_51;
    }

    private static final Object drag-VnAYq1g$$forInline(AwaitPointerEventScope arg16, long arg17, Function1 arg19, Orientation arg20, Function1 arg21, Continuation arg22) {
        float v6_3;
        List v2_1;
        Object v7_1;
        Object v11;
        Orientation v0 = arg20;
        long v2 = arg17;
        Object v4 = null;
        if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg16.getCurrentEvent(), v2)) {
            return v4;
        }

        while(true) {
            LongRef v1 = new LongRef();
            v1.element = v2;
            while(true) {
                Object v6 = AwaitPointerEventScope.awaitPointerEvent$default(arg16, ((PointerEventPass)v4), arg22, 1, v4);
                List v7 = ((PointerEvent)v6).getChanges();
                int v8 = v7.size();
                int v9 = 0;
                int v10 = 0;
                while(true) {
                    if(v10 < v8) {
                        v11 = v7.get(v10);
                        if(Boolean.valueOf(PointerId.equals-impl0(v11.getId-J3iCeTQ(), v1.element)).booleanValue()) {
                        }
                        else {
                            ++v10;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_33;
                }

                v11 = v4;
            label_33:
                if(v11 == null) {
                    v11 = v4;
                    break;
                    while(true) {
                    label_39:
                        if(v9 < v6_1) {
                            v7_1 = v2_1.get(v9);
                            if(Boolean.valueOf(v7_1.getPressed()).booleanValue()) {
                            }
                            else {
                                ++v9;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_51;
                    }

                    v7_1 = v4;
                label_51:
                    if(v7_1 == null) {
                        break;
                    }

                    v1.element = ((PointerInputChange)v7_1).getId-J3iCeTQ();
                    continue;
                }
                else if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v11))) {
                    v2_1 = ((PointerEvent)v6).getChanges();
                    int v6_1 = v2_1.size();
                    goto label_39;
                }
                else {
                    long v6_2 = PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v11));
                    if(v0 == null) {
                        v6_3 = Offset.getDistance-impl(v6_2);
                    }
                    else if(v0 == Orientation.Vertical) {
                        v6_3 = Float.intBitsToFloat(((int)(v6_2 & 0xFFFFFFFFL)));
                    }
                    else {
                        v6_3 = Float.intBitsToFloat(((int)(v6_2 >> 0x20)));
                    }

                    if(v6_3 == 0f) {
                        v9 = 1;
                    }

                    if(!Boolean.valueOf(1 ^ v9).booleanValue()) {
                        continue;
                    }
                }

                break;
            }

            if(v11 == null) {
                return v4;
            }

            if(arg21.invoke(v11).booleanValue()) {
                return v4;
            }

            if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v11))) {
                return v11;
            }

            arg19.invoke(v11);
            v2 = ((PointerInputChange)v11).getId-J3iCeTQ();
        }

        return v4;
    }

    public static final Object drag-jO51t88(AwaitPointerEventScope arg4, long arg5, Function1 arg7, Continuation arg8) {
        Object v7;
        Object v4;
        DragGestureDetectorKt$drag$1 v0_1;
        int v2;
        if((arg8 instanceof DragGestureDetectorKt$drag$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((DragGestureDetectorKt$drag$1)v0).label & v2) != 0) {
                ((DragGestureDetectorKt$drag$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new DragGestureDetectorKt$drag$1(arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            goto label_30;
        label_36:
            if(v8 == null) {
                return Boxing.boxBoolean(false);
            }
            else if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v8))) {
                return Boxing.boxBoolean(true);
            }
            else {
                ((Function1)v7).invoke(v8);
                arg5 = ((PointerInputChange)v8).getId-J3iCeTQ();
            }
        }
        else if(v2 == 1) {
            v4 = v0_1.L$1;
            Object v5 = v0_1.L$0;
            ResultKt.throwOnFailure(v8);
            v7 = v4;
            v4 = v5;
            goto label_36;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_30:
        v0_1.L$0 = v4;
        v0_1.L$1 = v7;
        v0_1.label = 1;
        v8 = DragGestureDetectorKt.awaitDragOrCancellation-rnUCldI(((AwaitPointerEventScope)v4), arg5, ((Continuation)v0_1));
        if(v8 != v1) {
            goto label_36;
        }

        return v1;
    }

    public static final Object horizontalDrag-jO51t88(AwaitPointerEventScope arg17, long arg18, Function1 arg20, Continuation arg21) {
        Object v1_2;
        Continuation v10_1;
        Object v10;
        Object v9;
        Object v7;
        Object v3_1;
        Object v6_1;
        float v0_5;
        List v0_4;
        Object v17;
        Object v14;
        DragGestureDetectorKt$horizontalDrag$1 v1_1;
        int v3;
        Continuation v0 = arg21;
        if((v0 instanceof DragGestureDetectorKt$horizontalDrag$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((DragGestureDetectorKt$horizontalDrag$1)v1).label & v3) != 0) {
                ((DragGestureDetectorKt$horizontalDrag$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new DragGestureDetectorKt$horizontalDrag$1(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        int v5 = 1;
        PointerEventPass v6 = null;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            Orientation v0_2 = Orientation.Horizontal;
            long v7_1 = arg18;
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v7_1)) {
            }
            else {
                Orientation v3_2 = v0_2;
                Continuation v9_1 = ((Continuation)v1_1);
                AwaitPointerEventScope v0_3 = arg17;
                Function1 v1_3 = arg20;
            label_46:
                LongRef v10_2 = new LongRef();
                v10_2.element = v7_1;
                AwaitPointerEventScope v7_2 = v0_3;
                Orientation v8_1 = v3_2;
                LongRef v3_3 = v10_2;
            label_52:
                ((DragGestureDetectorKt$horizontalDrag$1)v9_1).L$0 = v1_2;
                ((DragGestureDetectorKt$horizontalDrag$1)v9_1).L$1 = v0_3;
                ((DragGestureDetectorKt$horizontalDrag$1)v9_1).L$2 = v8_1;
                ((DragGestureDetectorKt$horizontalDrag$1)v9_1).L$3 = v7_2;
                ((DragGestureDetectorKt$horizontalDrag$1)v9_1).L$4 = v3_3;
                ((DragGestureDetectorKt$horizontalDrag$1)v9_1).label = v5;
                v10 = AwaitPointerEventScope.awaitPointerEvent$default(v7_2, v6, v9_1, v5, v6);
                if(v10 == v2) {
                    return v2;
                }
                else {
                    Continuation v16_1 = v9_1;
                    AwaitPointerEventScope v9_2 = v0_3;
                    v0_1 = v10;
                    v10_1 = v16_1;
                label_65:
                    List v11 = ((PointerEvent)v0_1).getChanges();
                    int v12 = v11.size();
                    int v13 = 0;
                    while(true) {
                        if(v13 < v12) {
                            v14 = v11.get(v13);
                            v17 = v7_2;
                            if(PointerId.equals-impl0(v14.getId-J3iCeTQ(), v3_3.element)) {
                            }
                            else {
                                ++v13;
                                v7 = v17;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_85;
                    }

                    v17 = v7_2;
                    v14 = null;
                label_85:
                    if(v14 == null) {
                        v14 = null;
                    }
                    else {
                        if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v14))) {
                            v0_4 = ((PointerEvent)v0_1).getChanges();
                            int v4 = v0_4.size();
                            v5 = 0;
                            goto label_94;
                        }
                        else {
                            long v4_1 = PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v14));
                            if(v8_1 == null) {
                                v0_5 = Offset.getDistance-impl(v4_1);
                            }
                            else {
                                if(v8_1 == Orientation.Vertical) {
                                    v4_1 &= 0xFFFFFFFFL;
                                }
                                else {
                                    v4_1 >>= 0x20;
                                }

                                v0_5 = Float.intBitsToFloat(((int)v4_1));
                            }

                            int v0_6 = v0_5 == 0f ? 1 : 0;
                            if(v0_6 != 0) {
                                goto label_152;
                            }

                            goto label_127;
                            while(true) {
                            label_94:
                                if(v5 < v4) {
                                    v6_1 = v0_4.get(v5);
                                    if(v6_1.getPressed()) {
                                    }
                                    else {
                                        ++v5;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_103;
                            }

                            v6_1 = null;
                        label_103:
                            if(v6_1 == null) {
                                goto label_127;
                            }

                            v3_3.element = ((PointerInputChange)v6_1).getId-J3iCeTQ();
                        }

                    label_152:
                        v7 = v17;
                        v0_1 = v9;
                        v9_1 = v10_1;
                        v5 = 1;
                        v6 = null;
                        goto label_52;
                    }

                label_127:
                    if(v14 != null) {
                        if(((PointerInputChange)v14).isConsumed()) {
                        }
                        else if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v14))) {
                            v6_1 = v14;
                            goto label_136;
                        }
                        else {
                            ((Function1)v1_2).invoke(v14);
                            v3_1 = v8_1;
                            v7_1 = ((PointerInputChange)v14).getId-J3iCeTQ();
                            v0_1 = v9;
                            v9_1 = v10_1;
                            v5 = 1;
                            v6 = null;
                            goto label_46;
                        }
                    }

                    v6_1 = null;
                }
            }
        }
        else if(v3 == 1) {
            v3_1 = v1_1.L$4;
            v7 = v1_1.L$3;
            Object v8 = v1_1.L$2;
            v9 = v1_1.L$1;
            v10 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            Object v16 = v10;
            v10_1 = ((Continuation)v1_1);
            v1_2 = v16;
            goto label_65;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_136:
        boolean v4_2 = v6_1 != null ? true : false;
        return Boxing.boxBoolean(v4_2);
    }

    private static final boolean isPointerUp-DmW0f2w(PointerEvent arg6, long arg7) {
        Object v3;
        List v6 = arg6.getChanges();
        int v0 = v6.size();
        int v1 = 0;
        int v2 = 0;
        while(true) {
            if(v2 < v0) {
                v3 = v6.get(v2);
                if(PointerId.equals-impl0(v3.getId-J3iCeTQ(), arg7)) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_15;
        }

        v3 = null;
    label_15:
        if(v3 != null && (((PointerInputChange)v3).getPressed())) {
            v1 = 1;
        }

        return 1 ^ v1;
    }

    public static final float pointerSlop-E8SPZFQ(ViewConfiguration arg1, int arg2) {
        if(PointerType.equals-impl0(arg2, PointerType.Companion.getMouse-T8wyACA())) {
            return arg1.getTouchSlop() * DragGestureDetectorKt.mouseToTouchSlopRatio;
        }

        return arg1.getTouchSlop();
    }

    public static final Object verticalDrag-jO51t88(AwaitPointerEventScope arg17, long arg18, Function1 arg20, Continuation arg21) {
        Object v1_2;
        Continuation v10_1;
        Object v10;
        Object v8;
        Object v7;
        Object v3_1;
        Object v6_1;
        float v0_5;
        List v0_4;
        Object v17;
        Object v14;
        DragGestureDetectorKt$verticalDrag$1 v1_1;
        int v3;
        Continuation v0 = arg21;
        if((v0 instanceof DragGestureDetectorKt$verticalDrag$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((DragGestureDetectorKt$verticalDrag$1)v1).label & v3) != 0) {
                ((DragGestureDetectorKt$verticalDrag$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new DragGestureDetectorKt$verticalDrag$1(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        int v5 = 1;
        PointerEventPass v6 = null;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            Orientation v0_2 = Orientation.Vertical;
            long v7_1 = arg18;
            if(DragGestureDetectorKt.isPointerUp-DmW0f2w(arg17.getCurrentEvent(), v7_1)) {
            }
            else {
                Orientation v3_2 = v0_2;
                Continuation v9_1 = ((Continuation)v1_1);
                AwaitPointerEventScope v0_3 = arg17;
                Function1 v1_3 = arg20;
            label_46:
                LongRef v10_2 = new LongRef();
                v10_2.element = v7_1;
                AwaitPointerEventScope v7_2 = v0_3;
                Orientation v8_1 = v3_2;
                LongRef v3_3 = v10_2;
            label_52:
                ((DragGestureDetectorKt$verticalDrag$1)v9_1).L$0 = v1_2;
                ((DragGestureDetectorKt$verticalDrag$1)v9_1).L$1 = v0_3;
                ((DragGestureDetectorKt$verticalDrag$1)v9_1).L$2 = v8;
                ((DragGestureDetectorKt$verticalDrag$1)v9_1).L$3 = v7_2;
                ((DragGestureDetectorKt$verticalDrag$1)v9_1).L$4 = v3_1;
                ((DragGestureDetectorKt$verticalDrag$1)v9_1).label = v5;
                v10 = AwaitPointerEventScope.awaitPointerEvent$default(v7_2, v6, v9_1, v5, v6);
                if(v10 == v2) {
                    return v2;
                }
                else {
                    Continuation v16_1 = v9_1;
                    AwaitPointerEventScope v9_2 = v0_3;
                    v0_1 = v10;
                    v10_1 = v16_1;
                label_65:
                    List v11 = ((PointerEvent)v0_1).getChanges();
                    int v12 = v11.size();
                    int v13 = 0;
                    while(true) {
                        if(v13 < v12) {
                            v14 = v11.get(v13);
                            v17 = v7_2;
                            if(PointerId.equals-impl0(v14.getId-J3iCeTQ(), ((LongRef)v3_1).element)) {
                            }
                            else {
                                ++v13;
                                v7 = v17;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_85;
                    }

                    v17 = v7_2;
                    v14 = null;
                label_85:
                    if(v14 == null) {
                        v14 = null;
                    }
                    else {
                        if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v14))) {
                            v0_4 = ((PointerEvent)v0_1).getChanges();
                            int v4 = v0_4.size();
                            v5 = 0;
                            goto label_94;
                        }
                        else {
                            long v4_1 = PointerEventKt.positionChangeIgnoreConsumed(((PointerInputChange)v14));
                            if(v8 == null) {
                                v0_5 = Offset.getDistance-impl(v4_1);
                            }
                            else {
                                if(v8 == Orientation.Vertical) {
                                    v4_1 &= 0xFFFFFFFFL;
                                }
                                else {
                                    v4_1 >>= 0x20;
                                }

                                v0_5 = Float.intBitsToFloat(((int)v4_1));
                            }

                            int v0_6 = v0_5 == 0f ? 1 : 0;
                            if(v0_6 != 0) {
                                goto label_152;
                            }

                            goto label_127;
                            while(true) {
                            label_94:
                                if(v5 < v4) {
                                    v6_1 = v0_4.get(v5);
                                    if(v6_1.getPressed()) {
                                    }
                                    else {
                                        ++v5;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                goto label_103;
                            }

                            v6_1 = null;
                        label_103:
                            if(v6_1 == null) {
                                goto label_127;
                            }

                            ((LongRef)v3_1).element = ((PointerInputChange)v6_1).getId-J3iCeTQ();
                        }

                    label_152:
                        v7 = v17;
                        v0_1 = v9_2;
                        v9_1 = v10_1;
                        v5 = 1;
                        v6 = null;
                        goto label_52;
                    }

                label_127:
                    if(v14 != null) {
                        if(((PointerInputChange)v14).isConsumed()) {
                        }
                        else if(PointerEventKt.changedToUpIgnoreConsumed(((PointerInputChange)v14))) {
                            v6_1 = v14;
                            goto label_136;
                        }
                        else {
                            ((Function1)v1_2).invoke(v14);
                            v3_1 = v8;
                            v7_1 = ((PointerInputChange)v14).getId-J3iCeTQ();
                            v0_1 = v9_2;
                            v9_1 = v10_1;
                            v5 = 1;
                            v6 = null;
                            goto label_46;
                        }
                    }

                    v6_1 = null;
                }
            }
        }
        else if(v3 == 1) {
            v3_1 = v1_1.L$4;
            v7 = v1_1.L$3;
            v8 = v1_1.L$2;
            Object v9 = v1_1.L$1;
            v10 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            Object v16 = v10;
            v10_1 = ((Continuation)v1_1);
            v1_2 = v16;
            goto label_65;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_136:
        boolean v4_2 = v6 != null ? true : false;
        return Boxing.boxBoolean(v4_2);
    }
}

