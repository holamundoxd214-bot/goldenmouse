package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000EJM\u0010(\u001A\u00020)2=\u0010*\u001A9\b\u0001\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110,¢\u0006\f\b\u001F\u0012\b\b \u0012\u0004\b\b(-\u0012\u0004\u0012\u00020)0+\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0%\u0012\u0006\u0012\u0004\u0018\u00010&0\u001DH\u0096@¢\u0006\u0002\u0010.J\u0017\u0010/\u001A\u00020)2\u0006\u00100\u001A\u00020$H\u0016¢\u0006\u0004\b1\u00102J\u0010\u00103\u001A\u00020)2\u0006\u00104\u001A\u000205H\u0016J\b\u00106\u001A\u00020\nH\u0016J4\u00107\u001A\u00020)2\u0006\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\fJ\b\u00108\u001A\u00020)H\u0016J\b\u00109\u001A\u00020)H\u0002J\b\u0010:\u001A\u00020)H\u0016J\'\u0010;\u001A\u00020)2\u0006\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020?2\u0006\u0010@\u001A\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\f\u0010D\u001A\u00020)*\u00020EH\u0016J\b\u0010F\u001A\u00020)H\u0002J\b\u0010G\u001A\u00020)H\u0002R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\nX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u001C\u001A4\u0012\u0013\u0012\u00110\u001E¢\u0006\f\b\u001F\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u001E¢\u0006\f\b\u001F\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\n\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R.\u0010#\u001A \b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0%\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\'¨\u0006H"}, d2={"Landroidx/compose/foundation/gestures/Scrollable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "drag", "", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "startDragImmediately", "update", "onAttach", "updateDefaultFlingBehavior", "onDensityChange", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "setScrollSemanticsActions", "clearScrollSemanticsActions", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Scrollable2DNode extends DragGestureNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2 scrollByAction;
    private Function2 scrollByOffsetAction;
    private final ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic2D scrollingLogic;
    private final boolean shouldAutoInvalidate;

    static {
    }

    public Scrollable2DNode(Scrollable2DState arg9, OverscrollEffect arg10, FlingBehavior arg11, boolean arg12, MutableInteractionSource arg13) {
        DefaultFlingBehavior v11;
        super(ScrollableKt.getCanDragCalculation(), arg12, arg13, null);
        this.overscrollEffect = arg10;
        this.flingBehavior = arg11;
        NestedScrollDispatcher v6 = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = v6;
        this.scrollableContainerNode = this.delegate(new ScrollableContainerNode(arg12));
        DefaultFlingBehavior v10 = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.getUnityDensity()), null, 2, null);
        this.defaultFlingBehavior = v10;
        OverscrollEffect v4 = this.overscrollEffect;
        arg11 = this.flingBehavior;
        if(arg11 == null) {
            v11 = v10;
        }

        ScrollingLogic2D v2 = new ScrollingLogic2D(arg9, v4, ((FlingBehavior)v11), v6, new Scrollable2DNode$$ExternalSyntheticLambda1(this));
        this.scrollingLogic = v2;
        ScrollableNestedScrollConnection v9 = new ScrollableNestedScrollConnection(((ScrollLogic)v2), arg12);
        this.nestedScrollConnection = v9;
        this.delegate(NestedScrollNodeKt.nestedScrollModifierNode(((NestedScrollConnection)v9), v6));
    }

    public static final ScrollingLogic2D access$getScrollingLogic$p(Scrollable2DNode arg0) {
        return arg0.scrollingLogic;
    }

    public void applySemantics(SemanticsPropertyReceiver arg4) {
        if((this.getEnabled()) && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            this.setScrollSemanticsActions();
        }

        Function2 v0 = this.scrollByAction;
        if(v0 != null) {
            SemanticsPropertiesKt.scrollBy$default(arg4, null, v0, 1, null);
        }

        Function2 v3 = this.scrollByOffsetAction;
        if(v3 != null) {
            SemanticsPropertiesKt.scrollByOffset(arg4, v3);
        }
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }

    public Object drag(Function2 arg4, Continuation arg5) {
        Object v3 = this.scrollingLogic.scroll(MutatePriority.UserInput, new Scrollable2DNode$drag$2$1(arg4, null), arg5);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onAttach() {
        this.updateDefaultFlingBehavior();
    }

    public void onDensityChange() {
        this.onCancelPointerInput();
        this.updateDefaultFlingBehavior();
    }

    public void onDragStarted-k-4lQ0M(long arg1) {
    }

    public void onDragStopped(DragStopped arg8) {
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new Scrollable2DNode$onDragStopped$1(this, arg8, null), 3, null);
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg6, PointerEventPass arg7, long arg8) {
        List v0 = arg6.getChanges();
        int v1 = v0.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(this.getCanDrag().invoke(PointerType.box-impl(v0.get(v2).getType-T8wyACA())).booleanValue()) {
                super.onPointerEvent-H0pRuoY(arg6, arg7, arg8);
                return;
            }
        }
    }

    static final boolean scrollingLogic$lambda$0(Scrollable2DNode arg0) {
        return arg0.isAttached();
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new Scrollable2DNode$$ExternalSyntheticLambda0(this);
        this.scrollByOffsetAction = new Scrollable2DNode$setScrollSemanticsActions$2(this, null);
    }

    static final boolean setScrollSemanticsActions$lambda$0(Scrollable2DNode arg6, float arg7, float arg8) {
        BuildersKt.launch$default(arg6.getCoroutineScope(), null, null, new Scrollable2DNode$setScrollSemanticsActions$1$1(arg6, arg7, arg8, null), 3, null);
        return 1;
    }

    public boolean startDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(Scrollable2DState arg11, OverscrollEffect arg12, boolean arg13, FlingBehavior arg14, MutableInteractionSource arg15) {
        FlingBehavior v4_2;
        int v4;
        if(this.getEnabled() != arg13) {
            this.nestedScrollConnection.setEnabled(arg13);
            this.scrollableContainerNode.update(arg13);
            v4 = 1;
        }
        else {
            v4 = 0;
        }

        int v9 = v4;
        if(arg14 == null) {
            DefaultFlingBehavior v4_1 = this.defaultFlingBehavior;
        }
        else {
            v4_2 = arg14;
        }

        boolean v6 = this.scrollingLogic.update(arg11, arg12, v4_2, this.nestedScrollDispatcher);
        this.overscrollEffect = arg12;
        this.flingBehavior = arg14;
        DragGestureNode.update$default(this, ScrollableKt.getCanDragCalculation(), arg13, arg15, null, v6, 8, null);
        if(v9 != 0) {
            this.clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    private final void updateDefaultFlingBehavior() {
        if(!this.isAttached()) {
            return;
        }

        this.defaultFlingBehavior.updateDensity(DelegatableNodeKt.requireDensity(this));
    }
}

