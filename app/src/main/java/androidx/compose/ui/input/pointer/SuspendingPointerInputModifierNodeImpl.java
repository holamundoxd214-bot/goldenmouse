package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001_B=\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\b\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rBZ\b\u0017\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0012\u0010\b\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t\u0012\'\u0010\u000E\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000F¢\u0006\u0002\b\u0012¢\u0006\u0004\b\f\u0010\u0013J\b\u0010I\u001A\u00020\u0011H\u0016J\b\u0010J\u001A\u00020\u0011H\u0016J\b\u0010K\u001A\u00020\u0011H\u0016J\b\u0010L\u001A\u00020\u0011H\u0016J?\u0010M\u001A\u00020\u00112\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0012\u0010\b\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BH\u0000¢\u0006\u0004\bN\u0010\rJ-\u0010O\u001A\u00020\u00112\u0006\u0010P\u001A\u00020Q2\u001A\u0010R\u001A\u0016\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u0000\u0012\u0004\u0012\u00020\u00110SH\u0082\bJ\u0018\u0010T\u001A\u00020\u00112\u0006\u0010U\u001A\u0002052\u0006\u0010P\u001A\u00020QH\u0002J\'\u0010V\u001A\u00020\u00112\u0006\u0010U\u001A\u0002052\u0006\u0010P\u001A\u00020Q2\u0006\u0010W\u001A\u00020/H\u0016¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001A\u00020\u0011H\u0016J=\u0010[\u001A\u0002H\\\"\u0004\b\u0000\u0010\\2\'\u0010R\u001A#\b\u0001\u0012\u0004\u0012\u00020]\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\\0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000F¢\u0006\u0002\b\u0012H\u0096@¢\u0006\u0002\u0010^R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0014R3\u0010\u0015\u001A%\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000F¢\u0006\u0002\b\u0012X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000Rl\u0010\u0019\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000F¢\u0006\u0002\b\u00122\'\u0010\u0018\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000F¢\u0006\u0002\b\u00128V@VX\u0097\u000E¢\u0006\u0012\u0012\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR$\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000B8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\'R\u0014\u0010*\u001A\u00020+8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020/8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b0\u00101R\u0010\u00102\u001A\u0004\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u000205X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u00106\u001A\u0010\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u000007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001A\u00060\u0006j\u0002`:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u001C\u0010<\u001A\u0010\u0012\f\u0012\n\u0012\u0002\b\u000308R\u00020\u000007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001A\u0004\u0018\u000105X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010>\u001A\u00020/X\u0082\u000E¢\u0006\u0004\n\u0002\u0010?R\u0014\u0010@\u001A\u00020A8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bB\u00101R\u001A\u0010C\u001A\u00020DX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006`"}, d2={"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "key1", "", "key2", "keys", "", "pointerInputEventHandler", "Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "pointerInputEvent", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "[Ljava/lang/Object;", "_deprecatedPointerInputHandler", "Lkotlin/jvm/functions/Function2;", "_pointerInputEventHandler", "value", "pointerInputHandler", "getPointerInputHandler$annotations", "()V", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "setPointerInputHandler", "(Lkotlin/jvm/functions/Function2;)V", "getPointerInputEventHandler", "()Landroidx/compose/ui/input/pointer/PointerInputEventHandler;", "setPointerInputEventHandler", "(Landroidx/compose/ui/input/pointer/PointerInputEventHandler;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "pointerInputJob", "Lkotlinx/coroutines/Job;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "pointerHandlersLock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "dispatchingPointerHandlers", "lastPointerEvent", "boundsSize", "J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "onDetach", "onDensityChange", "onViewConfigurationChange", "resetPointerInputHandler", "update", "update$ui", "forEachCurrentPointerHandler", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "block", "Lkotlin/Function1;", "dispatchPointerEvent", "pointerEvent", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "awaitPointerEventScope", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PointerEventHandlerCoroutine", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SuspendingPointerInputModifierNodeImpl extends Node implements PointerInputScope, SuspendingPointerInputModifierNode, Density {
    @Metadata(d1={"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\fJ\u0010\u0010\u001F\u001A\u00020\u001C2\b\u0010 \u001A\u0004\u0018\u00010!J\u001B\u0010&\u001A\u00020\u001C2\f\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0002\u0010)J\u0016\u0010*\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\fH\u0096@¢\u0006\u0002\u0010+JG\u0010,\u001A\u0004\u0018\u0001H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001A\u00020/2\'\u00100\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\u0004\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\u0002\b3H\u0096@¢\u0006\u0002\u00104JE\u00105\u001A\u0002H-\"\u0004\b\u0001\u0010-2\u0006\u0010.\u001A\u00020/2\'\u00100\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-0\u0004\u0012\u0006\u0012\u0004\u0018\u00010201¢\u0006\u0002\b3H\u0096@¢\u0006\u0002\u00104J\u0014\u00106\u001A\u000207*\u000208H\u0097\u0001¢\u0006\u0004\b9\u0010:J\u0014\u00106\u001A\u000207*\u00020;H\u0097\u0001¢\u0006\u0004\b<\u0010=J\u0014\u0010>\u001A\u000208*\u000207H\u0097\u0001¢\u0006\u0004\b?\u0010@J\u0014\u0010>\u001A\u000208*\u00020AH\u0097\u0001¢\u0006\u0004\b?\u0010BJ\u0014\u0010>\u001A\u000208*\u00020;H\u0097\u0001¢\u0006\u0004\bC\u0010DJ\u0014\u0010E\u001A\u00020F*\u00020\u0019H\u0097\u0001¢\u0006\u0004\bG\u0010HJ\u0014\u0010I\u001A\u00020A*\u000208H\u0097\u0001¢\u0006\u0004\bJ\u0010BJ\u0014\u0010I\u001A\u00020A*\u00020;H\u0097\u0001¢\u0006\u0004\bK\u0010DJ\r\u0010L\u001A\u00020M*\u00020NH\u0097\u0001J\u0014\u0010O\u001A\u00020\u0019*\u00020FH\u0097\u0001¢\u0006\u0004\bP\u0010HJ\u0014\u0010Q\u001A\u00020;*\u000207H\u0097\u0001¢\u0006\u0004\bR\u0010SJ\u0014\u0010Q\u001A\u00020;*\u00020AH\u0097\u0001¢\u0006\u0004\bR\u0010TJ\u0014\u0010Q\u001A\u00020;*\u000208H\u0097\u0001¢\u0006\u0004\bU\u0010TR\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0013R\u0014\u0010\"\u001A\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0014\u0010V\u001A\u00020A8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bW\u0010XR\u0014\u0010Y\u001A\u00020A8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bZ\u0010X¨\u0006["}, d2={"Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "<init>", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;Lkotlin/coroutines/Continuation;)V", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "currentEvent", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "offerPointerEvent", "", "event", "pass", "cancel", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "awaitPointerEvent", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PointerEventHandlerCoroutine implements AwaitPointerEventScope, Density, Continuation {
        private PointerEventPass awaitPass;
        private final Continuation completion;
        private final CoroutineContext context;
        private CancellableContinuation pointerAwaiter;

        public PointerEventHandlerCoroutine(SuspendingPointerInputModifierNodeImpl arg1, Continuation arg2) {
            SuspendingPointerInputModifierNodeImpl.this = arg1;
            super();
            this.$$delegate_0 = arg1;
            this.completion = arg2;
            this.awaitPass = PointerEventPass.Main;
            this.context = EmptyCoroutineContext.INSTANCE;
        }

        public static final CancellableContinuation access$getPointerAwaiter$p(PointerEventHandlerCoroutine arg0) {
            return arg0.pointerAwaiter;
        }

        public static final void access$setAwaitPass$p(PointerEventHandlerCoroutine arg0, PointerEventPass arg1) {
            arg0.awaitPass = arg1;
        }

        public static final void access$setPointerAwaiter$p(PointerEventHandlerCoroutine arg0, CancellableContinuation arg1) {
            arg0.pointerAwaiter = arg1;
        }

        public Object awaitPointerEvent(PointerEventPass arg4, Continuation arg5) {
            CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
            v0.initCancellability();
            this.awaitPass = arg4;
            this.pointerAwaiter = v0;
            Object v3 = v0.getResult();
            if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg5);
            }

            return v3;
        }

        public final void cancel(Throwable arg2) {
            CancellableContinuation v0 = this.pointerAwaiter;
            if(v0 != null) {
                v0.cancel(arg2);
            }

            this.pointerAwaiter = null;
        }

        public CoroutineContext getContext() {
            return this.context;
        }

        public PointerEvent getCurrentEvent() {
            return SuspendingPointerInputModifierNodeImpl.this.currentEvent;
        }

        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        public long getExtendedTouchPadding-NH-jbRc() {
            return SuspendingPointerInputModifierNodeImpl.this.getExtendedTouchPadding-NH-jbRc();
        }

        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        public long getSize-YbymL2g() {
            return SuspendingPointerInputModifierNodeImpl.this.boundsSize;
        }

        public ViewConfiguration getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        public final void offerPointerEvent(PointerEvent arg2, PointerEventPass arg3) {
            if(arg3 == this.awaitPass) {
                CancellableContinuation v3 = this.pointerAwaiter;
                if(v3 != null) {
                    this.pointerAwaiter = null;
                    ((Continuation)v3).resumeWith(Result.constructor-impl(arg2));
                }
            }
        }

        public void resumeWith(Object arg3) {
            Object v0 = SuspendingPointerInputModifierNodeImpl.this.pointerHandlersLock;
            SuspendingPointerInputModifierNodeImpl v1 = SuspendingPointerInputModifierNodeImpl.this;
            __monitor_enter(v0);
            try {
                v1.pointerHandlers.remove(this);
            }
            catch(Throwable v2) {
                __monitor_exit(v0);
                throw v2;
            }

            __monitor_exit(v0);
            this.completion.resumeWith(arg3);
        }

        public int roundToPx--R2X_6o(long arg1) {
            return this.$$delegate_0.roundToPx--R2X_6o(arg1);
        }

        public int roundToPx-0680j_4(float arg1) {
            return this.$$delegate_0.roundToPx-0680j_4(arg1);
        }

        public float toDp-GaN1DYA(long arg1) {
            return this.$$delegate_0.toDp-GaN1DYA(arg1);
        }

        public float toDp-u2uoSUM(float arg1) {
            return this.$$delegate_0.toDp-u2uoSUM(arg1);
        }

        public float toDp-u2uoSUM(int arg1) {
            return this.$$delegate_0.toDp-u2uoSUM(arg1);
        }

        public long toDpSize-k-rfVVM(long arg1) {
            return this.$$delegate_0.toDpSize-k-rfVVM(arg1);
        }

        public float toPx--R2X_6o(long arg1) {
            return this.$$delegate_0.toPx--R2X_6o(arg1);
        }

        public float toPx-0680j_4(float arg1) {
            return this.$$delegate_0.toPx-0680j_4(arg1);
        }

        public Rect toRect(DpRect arg1) {
            return this.$$delegate_0.toRect(arg1);
        }

        public long toSize-XkaWNTQ(long arg1) {
            return this.$$delegate_0.toSize-XkaWNTQ(arg1);
        }

        public long toSp-0xMU5do(float arg1) {
            return this.$$delegate_0.toSp-0xMU5do(arg1);
        }

        public long toSp-kPz2Gy4(float arg1) {
            return this.$$delegate_0.toSp-kPz2Gy4(arg1);
        }

        public long toSp-kPz2Gy4(int arg1) {
            return this.$$delegate_0.toSp-kPz2Gy4(arg1);
        }

        public Object withTimeout(long arg12, Function2 arg14, Continuation arg15) {
            Throwable v12;
            Job v11_1;
            SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 v0_1;
            int v2;
            if((arg15 instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1)) {
                Continuation v0 = arg15;
                v2 = 0x80000000;
                if((((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1)v0).label & v2) != 0) {
                    ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1)v0).label -= v2;
                }
                else {
                    goto label_11;
                }
            }
            else {
            label_11:
                v0_1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(this, arg15);
            }

            Object v15 = v0_1.result;
            Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            v2 = v0_1.label;
            if(v2 == 0) {
                ResultKt.throwOnFailure(v15);
                if(arg12 <= 0) {
                    CancellableContinuation v15_1 = this.pointerAwaiter;
                    if(v15_1 != null) {
                        ((Continuation)v15_1).resumeWith(Result.constructor-impl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(arg12))));
                    }
                }

                Job v12_1 = BuildersKt.launch$default(SuspendingPointerInputModifierNodeImpl.this.getCoroutineScope(), null, null, new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(arg12, this, null), 3, null);
                try {
                    v0_1.L$0 = v12_1;
                    v0_1.label = 1;
                    v15 = arg14.invoke(this, v0_1);
                    if(v15 != v1) {
                        goto label_56;
                    }

                    return v1;
                }
                catch(Throwable v0_2) {
                    Job v10 = v12_1;
                    v12 = v0_2;
                    v11_1 = v10;
                }

            label_65:
                v11_1.cancel(CancelTimeoutCancellationException.INSTANCE);
                throw v12;
                return v1;
            label_56:
                v11_1 = v12_1;
            }
            else if(v2 == 1) {
                Object v11 = v0_1.L$0;
                try {
                    ResultKt.throwOnFailure(v15);
                }
                catch(Throwable v0_2) {
                    v12 = v0_2;
                    goto label_65;
                }
            }
            else {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }

            v11_1.cancel(CancelTimeoutCancellationException.INSTANCE);
            return v15;
        }

        public Object withTimeoutOrNull(long arg5, Function2 arg7, Continuation arg8) {
            int v2;
            Continuation v0;
            if((arg8 instanceof SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1)) {
                v0 = arg8;
                v2 = 0x80000000;
                if((((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1)v0).label & v2) != 0) {
                    ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1)v0).label -= v2;
                }
                else {
                    goto label_11;
                }
            }
            else {
            label_11:
                SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 v0_1 = new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1(this, arg8);
            }

            Object v8 = ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1)v0).result;
            Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            v2 = ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1)v0).label;
            if(v2 != 0) {
                if(v2 == 1) {
                    try {
                        ResultKt.throwOnFailure(v8);
                        return v8;
                    }
                    catch(PointerEventTimeoutCancellationException ) {
                        return null;
                    }
                }

                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }

            ResultKt.throwOnFailure(v8);
            try {
                ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1)v0).label = 1;
                Object v4 = this.withTimeout(arg5, arg7, v0);
                if(v4 != v1) {
                    return v4;
                }
            }
            catch(PointerEventTimeoutCancellationException ) {
                return null;
            }

            return v1;
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[PointerEventPass.values().length];
            try {
                v0[PointerEventPass.Initial.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[PointerEventPass.Final.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[PointerEventPass.Main.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final int $stable;
    private Function2 _deprecatedPointerInputHandler;
    private PointerInputEventHandler _pointerInputEventHandler;
    private long boundsSize;
    private PointerEvent currentEvent;
    private final MutableVector dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    private Object key1;
    private Object key2;
    private Object[] keys;
    private PointerEvent lastPointerEvent;
    private final MutableVector pointerHandlers;
    private final Object pointerHandlersLock;
    private Job pointerInputJob;

    static {
    }

    public SuspendingPointerInputModifierNodeImpl(Object arg1, Object arg2, Object[] arg3, PointerInputEventHandler arg4) {
        super();
        this.key1 = arg1;
        this.key2 = arg2;
        this.keys = arg3;
        this._pointerInputEventHandler = arg4;
        this.currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        MutableVector v1 = new MutableVector(new PointerEventHandlerCoroutine[16], 0);
        this.pointerHandlers = v1;
        this.pointerHandlersLock = v1;
        this.dispatchingPointerHandlers = new MutableVector(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.getZero-YbymL2g();
    }

    @Deprecated(message="Exists to maintain compatibility with previous API shape") public SuspendingPointerInputModifierNodeImpl(Object arg2, Object arg3, Object[] arg4, Function2 arg5) {
        this(arg2, arg3, arg4, androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$1.INSTANCE);
        this._deprecatedPointerInputHandler = arg5;
    }

    public SuspendingPointerInputModifierNodeImpl(Object arg2, Object arg3, Object[] arg4, PointerInputEventHandler arg5, int arg6, DefaultConstructorMarker arg7) {
        Object v0 = null;
        if((arg6 & 1) != 0) {
            arg2 = v0;
        }

        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = ((Object[])v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public static final long access$getBoundsSize$p(SuspendingPointerInputModifierNodeImpl arg2) {
        return arg2.boundsSize;
    }

    public static final PointerEvent access$getCurrentEvent$p(SuspendingPointerInputModifierNodeImpl arg0) {
        return arg0.currentEvent;
    }

    public static final MutableVector access$getPointerHandlers$p(SuspendingPointerInputModifierNodeImpl arg0) {
        return arg0.pointerHandlers;
    }

    public static final Object access$getPointerHandlersLock$p(SuspendingPointerInputModifierNodeImpl arg0) {
        return arg0.pointerHandlersLock;
    }

    public static final Function2 access$get_deprecatedPointerInputHandler$p(SuspendingPointerInputModifierNodeImpl arg0) {
        return arg0._deprecatedPointerInputHandler;
    }

    public Object awaitPointerEventScope(Function2 arg5, Continuation arg6) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        PointerEventHandlerCoroutine v2 = new PointerEventHandlerCoroutine(this, v1);
        Object v3 = this.pointerHandlersLock;
        __monitor_enter(v3);
        try {
            this.pointerHandlers.add(v2);
            ContinuationKt.createCoroutine(arg5, v2, v2).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        catch(Throwable v4) {
            __monitor_exit(v3);
            throw v4;
        }

        __monitor_exit(v3);
        ((CancellableContinuation)v1).invokeOnCancellation(new SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2(v2));
        Object v4_1 = v0.getResult();
        if(v4_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        return v4_1;
    }

    private final void dispatchPointerEvent(PointerEvent arg5, PointerEventPass arg6) {
        int v2;
        MutableVector v0_2;
        Object v0 = this.pointerHandlersLock;
        __monitor_enter(v0);
        try {
            this.dispatchingPointerHandlers.addAll(this.dispatchingPointerHandlers.getSize(), this.pointerHandlers);
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        try {
            int v0_1 = WhenMappings.$EnumSwitchMapping$0[arg6.ordinal()];
            if(v0_1 == 1 || v0_1 == 2) {
                v0_2 = this.dispatchingPointerHandlers;
                Object[] v1 = v0_2.content;
                v0_1 = v0_2.getSize();
                for(v2 = 0; v2 < v0_1; ++v2) {
                    v1[v2].offerPointerEvent(arg5, arg6);
                }
            }
            else if(v0_1 == 3) {
                v0_2 = this.dispatchingPointerHandlers;
                v2 = v0_2.getSize() - 1;
                Object[] v0_3 = v0_2.content;
                if(v2 >= v0_3.length) {
                    goto label_39;
                }

                while(v2 >= 0) {
                    v0_3[v2].offerPointerEvent(arg5, arg6);
                    --v2;
                }
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        catch(Throwable v5) {
            this.dispatchingPointerHandlers.clear();
            throw v5;
        }

    label_39:
        this.dispatchingPointerHandlers.clear();
    }

    private final void forEachCurrentPointerHandler(PointerEventPass arg5, Function1 arg6) {
        int v1;
        MutableVector v5_2;
        Object v0 = this.pointerHandlersLock;
        __monitor_enter(v0);
        try {
            this.dispatchingPointerHandlers.addAll(this.dispatchingPointerHandlers.getSize(), this.pointerHandlers);
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        try {
            int v5_1 = WhenMappings.$EnumSwitchMapping$0[arg5.ordinal()];
            if(v5_1 == 1 || v5_1 == 2) {
                v5_2 = this.dispatchingPointerHandlers;
                Object[] v0_1 = v5_2.content;
                v5_1 = v5_2.getSize();
                for(v1 = 0; v1 < v5_1; ++v1) {
                    arg6.invoke(v0_1[v1]);
                }
            }
            else if(v5_1 == 3) {
                v5_2 = this.dispatchingPointerHandlers;
                v1 = v5_2.getSize() - 1;
                Object[] v5_3 = v5_2.content;
                if(v1 >= v5_3.length) {
                    goto label_39;
                }

                while(v1 >= 0) {
                    arg6.invoke(v5_3[v1]);
                    --v1;
                }
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        catch(Throwable v5) {
            this.dispatchingPointerHandlers.clear();
            throw v5;
        }

    label_39:
        this.dispatchingPointerHandlers.clear();
    }

    public float getDensity() {
        return DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this)).getDensity().getDensity();
    }

    public long getExtendedTouchPadding-NH-jbRc() {
        long v0 = this.toSize-XkaWNTQ(this.getViewConfiguration().getMinimumTouchTargetSize-MYxV2XQ());
        long v2 = this.getSize-YbymL2g();
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Math.max(0f, Float.intBitsToFloat(((int)(v0 >> 0x20))) - (((float)(((int)(v2 >> 0x20)))))) / 2f))) << 0x20 | (((long)Float.floatToRawIntBits(Math.max(0f, Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL))) - (((float)(((int)(v2 & 0xFFFFFFFFL)))))) / 2f))) & 0xFFFFFFFFL);
    }

    public float getFontScale() {
        return DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this)).getDensity().getFontScale();
    }

    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    public PointerInputEventHandler getPointerInputEventHandler() {
        return this._pointerInputEventHandler;
    }

    public Function2 getPointerInputHandler() {
        SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1 v1_1;
        Function2 v1 = this._deprecatedPointerInputHandler;
        if(v1 == null) {
            v1_1 = new SuspendingPointerInputModifierNodeImpl$pointerInputHandler$1(null);
        }

        return ((Function2)v1_1);
    }

    @Deprecated(message="Super property deprecated") public static void getPointerInputHandler$annotations() {
    }

    public long getSize-YbymL2g() {
        return this.boundsSize;
    }

    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.requireLayoutNode(((DelegatableNode)this)).getViewConfiguration();
    }

    public void onCancelPointerInput() {
        ArrayList v2_1;
        List v1_1;
        SuspendingPointerInputModifierNodeImpl v0 = this;
        PointerEvent v1 = v0.lastPointerEvent;
        if(v1 == null) {
            return;
        }

        List v2 = v1.getChanges();
        int v3 = v2.size();
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            if(v2.get(v5).getPressed()) {
                v1_1 = v1.getChanges();
                v2_1 = new ArrayList(v1_1.size());
                v3 = v1_1.size();
                goto label_19;
            }
        }

        return;
    label_19:
        while(v4 < v3) {
            Object v5_1 = v1_1.get(v4);
            v2_1.add(new PointerInputChange(((PointerInputChange)v5_1).getId-J3iCeTQ(), ((PointerInputChange)v5_1).getUptimeMillis(), ((PointerInputChange)v5_1).getPosition-F1C5BW0(), false, ((PointerInputChange)v5_1).getPressure(), ((PointerInputChange)v5_1).getUptimeMillis(), ((PointerInputChange)v5_1).getPosition-F1C5BW0(), ((PointerInputChange)v5_1).getPressed(), ((PointerInputChange)v5_1).getPressed(), ((PointerInputChange)v5_1).getType-T8wyACA(), 0, 0x400, null));
            ++v4;
        }

        v1 = new PointerEvent(((List)v2_1));
        v0.currentEvent = v1;
        v0.dispatchPointerEvent(v1, PointerEventPass.Initial);
        v0.dispatchPointerEvent(v1, PointerEventPass.Main);
        v0.dispatchPointerEvent(v1, PointerEventPass.Final);
        v0.lastPointerEvent = null;
    }

    public void onDensityChange() {
        this.resetPointerInputHandler();
    }

    public void onDetach() {
        this.resetPointerInputHandler();
        super.onDetach();
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg7, PointerEventPass arg8, long arg9) {
        this.boundsSize = arg9;
        if(arg8 == PointerEventPass.Initial) {
            this.currentEvent = arg7;
        }

        Continuation v10 = null;
        if(this.pointerInputJob == null) {
            this.pointerInputJob = BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, v10), 1, null);
        }

        this.dispatchPointerEvent(arg7, arg8);
        List v8 = arg7.getChanges();
        int v9 = v8.size();
        int v0 = 0;
        int v1 = 0;
        while(true) {
            if(v1 >= v9) {
                break;
            }
            else if(!PointerEventKt.changedToUpIgnoreConsumed(v8.get(v1))) {
            }
            else {
                ++v1;
                continue;
            }

            goto label_31;
        }

        v0 = 1;
    label_31:
        if(v0 == 0) {
        }
        else {
            arg7 = ((PointerEvent)v10);
        }

        this.lastPointerEvent = arg7;
    }

    public void onViewConfigurationChange() {
        this.resetPointerInputHandler();
    }

    public void resetPointerInputHandler() {
        Job v0 = this.pointerInputJob;
        if(v0 != null) {
            v0.cancel(new PointerInputResetException());
            this.pointerInputJob = null;
        }
    }

    public void setInterceptOutOfBoundsChildEvents(boolean arg1) {
        this.interceptOutOfBoundsChildEvents = arg1;
    }

    public void setPointerInputEventHandler(PointerInputEventHandler arg2) {
        this.resetPointerInputHandler();
        this._deprecatedPointerInputHandler = null;
        this._pointerInputEventHandler = arg2;
    }

    public void setPointerInputHandler(Function2 arg1) {
        this.resetPointerInputHandler();
        this._deprecatedPointerInputHandler = arg1;
    }

    public final void update$ui(Object arg3, Object arg4, Object[] arg5, PointerInputEventHandler arg6) {
        int v1 = 1;
        int v0 = Intrinsics.areEqual(this.key1, arg3) ^ 1;
        this.key1 = arg3;
        if(!Intrinsics.areEqual(this.key2, arg4)) {
            v0 = 1;
        }

        this.key2 = arg4;
        Object[] v3 = this.keys;
        if(v3 != null && arg5 == null) {
            v0 = 1;
        }

        if(v3 == null && arg5 != null) {
            v0 = 1;
        }

        if(v3 != null && arg5 != null && !Arrays.equals(arg5, v3)) {
            v0 = 1;
        }

        this.keys = arg5;
        if(this.getPointerInputEventHandler().getClass() != arg6.getClass()) {
        }
        else {
            v1 = v0;
        }

        if(v1 != 0) {
            this.resetPointerInputHandler();
        }

        this._pointerInputEventHandler = arg6;
    }
}

