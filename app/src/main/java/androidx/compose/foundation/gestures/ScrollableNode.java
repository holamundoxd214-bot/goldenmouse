package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BO\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u00105\u001A\u0002062\u0006\u00107\u001A\u00020/H\u0016¢\u0006\u0004\b8\u00109JM\u0010:\u001A\u0002062=\u0010;\u001A9\b\u0001\u0012\u001F\u0012\u001D\u0012\u0013\u0012\u00110=¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002060<\u0012\n\u0012\b\u0012\u0004\u0012\u00020600\u0012\u0006\u0012\u0004\u0018\u0001010(H\u0096@¢\u0006\u0002\u0010?J\u0017\u0010@\u001A\u0002062\u0006\u0010A\u001A\u00020/H\u0016¢\u0006\u0004\bB\u00109J\u0010\u0010C\u001A\u0002062\u0006\u0010D\u001A\u00020EH\u0016J\u0017\u0010F\u001A\u0002062\u0006\u0010G\u001A\u00020HH\u0002¢\u0006\u0004\bI\u00109J\b\u0010J\u001A\u00020\u000EH\u0016J\b\u0010K\u001A\u000206H\u0002JN\u0010L\u001A\u0002062\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013J\b\u0010M\u001A\u000206H\u0016J\b\u0010N\u001A\u000206H\u0002J\b\u0010O\u001A\u000206H\u0016J\u0017\u0010P\u001A\u00020\u000E2\u0006\u0010D\u001A\u00020QH\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001A\u00020\u000E2\u0006\u0010D\u001A\u00020QH\u0016¢\u0006\u0004\bU\u0010SJ\'\u0010V\u001A\u0002062\u0006\u0010W\u001A\u00020X2\u0006\u0010Y\u001A\u00020Z2\u0006\u0010[\u001A\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\f\u0010_\u001A\u000206*\u00020`H\u0016J\b\u0010a\u001A\u000206H\u0002J\b\u0010b\u001A\u000206H\u0002R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001A\u00020\u000EX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\'\u001A4\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110)¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000E\u0018\u00010(X\u0082\u000E¢\u0006\u0002\n\u0000R.\u0010.\u001A \b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020/00\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010(X\u0082\u000E¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006c"}, d2={"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/ScrollableDefaultFlingBehavior;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "focusTargetModifierNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "mouseWheelScrollingLogic", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "dispatchScrollDeltaInfo", "", "delta", "dispatchScrollDeltaInfo-k-4lQ0M", "(J)V", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "onDragStopped", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "onWheelScrollStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onWheelScrollStopped-TH1AsA0", "startDragImmediately", "ensureMouseWheelScrollNodeInitialized", "update", "onAttach", "updateDefaultFlingBehavior", "onDensityChange", "onKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "setScrollSemanticsActions", "clearScrollSemanticsActions", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScrollableNode extends DragGestureNode implements OnScrollChangedDispatcher, KeyInputModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private final ContentInViewNode contentInViewNode;
    private final ScrollableDefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final FocusTargetModifierNode focusTargetModifierNode;
    private MouseWheelScrollingLogic mouseWheelScrollingLogic;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2 scrollByAction;
    private Function2 scrollByOffsetAction;
    private final ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;

    static {
    }

    public ScrollableNode(ScrollableState arg12, OverscrollEffect arg13, FlingBehavior arg14, Orientation arg15, boolean arg16, boolean arg17, MutableInteractionSource arg18, BringIntoViewSpec arg19) {
        boolean v0 = arg16;
        Orientation v6 = arg15;
        super(ScrollableKt.getCanDragCalculation(), v0, arg18, arg15);
        this.overscrollEffect = arg13;
        this.flingBehavior = arg14;
        NestedScrollDispatcher v8 = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = v8;
        this.scrollableContainerNode = this.delegate(new ScrollableContainerNode(v0));
        ScrollableDefaultFlingBehavior v1 = Scrollable_androidKt.platformScrollableDefaultFlingBehavior();
        this.defaultFlingBehavior = v1;
        OverscrollEffect v4 = this.overscrollEffect;
        FlingBehavior v2 = this.flingBehavior;
        if(v2 == null) {
            ScrollableDefaultFlingBehavior v2_1 = v1;
        }

        ScrollingLogic v2_2 = new ScrollingLogic(arg12, v4, v2, v6, arg17, v8, this, new ScrollableNode$$ExternalSyntheticLambda0(this));
        this.scrollingLogic = v2_2;
        ScrollableNestedScrollConnection v1_1 = new ScrollableNestedScrollConnection(v2_2, v0);
        this.nestedScrollConnection = v1_1;
        this.focusTargetModifierNode = this.delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode-PYyLHbc$default(Focusability.Companion.getNever-LCbbffg(), null, 2, null));
        DelegatableNode v0_1 = this.delegate(new ContentInViewNode(arg15, v2_2, arg17, arg19, new ScrollableNode$$ExternalSyntheticLambda1(this)));
        this.contentInViewNode = ((ContentInViewNode)v0_1);
        this.delegate(NestedScrollNodeKt.nestedScrollModifierNode(((NestedScrollConnection)v1_1), v8));
        this.delegate(new BringIntoViewResponderNode(((BringIntoViewResponder)v0_1)));
        if(!ComposeFoundationFlags.isKeepInViewFocusObservationChangeEnabled) {
            this.delegate(new FocusedBoundsObserverNode(new ScrollableNode$$ExternalSyntheticLambda2(this)));
        }
    }

    static final Unit _init_$lambda$0(ScrollableNode arg0, LayoutCoordinates arg1) {
        arg0.contentInViewNode.onFocusBoundsChanged(arg1);
        return Unit.INSTANCE;
    }

    public static final Object access$ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped(ScrollableNode arg0, long arg1, Continuation arg3) {
        return ScrollableNode.ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped(arg0, arg1, arg3);
    }

    public static final ScrollingLogic access$getScrollingLogic$p(ScrollableNode arg0) {
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

    static final Rect contentInViewNode$lambda$0(ScrollableNode arg0) {
        return FocusTargetModifierNodeKt.getFocusedRect(arg0.focusTargetModifierNode);
    }

    public void dispatchScrollDeltaInfo-k-4lQ0M(long arg2) {
        if(!this.isAttached()) {
            return;
        }

        DelegatableNodeKt.dispatchOnScrollChanged-Uv8p0NA(((DelegatableNode)this), arg2);
    }

    public Object drag(Function2 arg4, Continuation arg5) {
        Object v3 = this.scrollingLogic.scroll(MutatePriority.UserInput, new ScrollableNode$drag$2$1(arg4, this.scrollingLogic, null), arg5);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    private final void ensureMouseWheelScrollNodeInitialized() {
        MouseWheelScrollingLogic v0 = this.mouseWheelScrollingLogic;
        if(v0 == null) {
            v0 = new MouseWheelScrollingLogic(this.scrollingLogic, AndroidScrollable_androidKt.platformScrollConfig(this), new ScrollableNode$ensureMouseWheelScrollNodeInitialized$1(this), DelegatableNodeKt.requireDensity(this));
            this.mouseWheelScrollingLogic = v0;
        }

        if(v0 != null) {
            v0.startReceivingMouseWheelEvents(this.getCoroutineScope());
        }
    }

    private static final Object ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped(ScrollableNode arg0, long arg1, Continuation arg3) {
        arg0.onWheelScrollStopped-TH1AsA0(arg1);
        return Unit.INSTANCE;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onAttach() {
        this.updateDefaultFlingBehavior();
        MouseWheelScrollingLogic v0 = this.mouseWheelScrollingLogic;
        if(v0 != null) {
            v0.updateDensity(DelegatableNodeKt.requireDensity(((DelegatableNode)this)));
        }
    }

    public void onDensityChange() {
        this.onCancelPointerInput();
        this.updateDefaultFlingBehavior();
        MouseWheelScrollingLogic v0 = this.mouseWheelScrollingLogic;
        if(v0 != null) {
            v0.updateDensity(DelegatableNodeKt.requireDensity(((DelegatableNode)this)));
        }
    }

    public void onDragStarted-k-4lQ0M(long arg1) {
    }

    public void onDragStopped(DragStopped arg8) {
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onDragStopped$1(arg8, this, null), 3, null);
    }

    public boolean onKeyEvent-ZmokQxo(KeyEvent arg11) {
        long v0_2;
        float v11;
        int v0_1;
        if((this.getEnabled()) && ((Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(arg11), Key.Companion.getPageDown-EK5gGoQ())) || (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(arg11), Key.Companion.getPageUp-EK5gGoQ()))) && (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg11), KeyEventType.Companion.getKeyDown-CS__XNY())) && !KeyEvent_androidKt.isCtrlPressed-ZmokQxo(arg11)) {
            boolean v0 = this.scrollingLogic.isVertical();
            ContentInViewNode v1 = this.contentInViewNode;
            long v3 = 0xFFFFFFFFL;
            int v5 = 0x20;
            if(v0) {
                v0_1 = ((int)(v1.getViewportSize-YbymL2g$foundation() & v3));
                v11 = Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(arg11), Key.Companion.getPageUp-EK5gGoQ()) ? ((float)v0_1) : -(((float)v0_1));
                v0_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v5 | (((long)Float.floatToRawIntBits(v11))) & v3);
            }
            else {
                v0_1 = ((int)(v1.getViewportSize-YbymL2g$foundation() >> v5));
                v11 = Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(arg11), Key.Companion.getPageUp-EK5gGoQ()) ? ((float)v0_1) : -(((float)v0_1));
                v0_2 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v11))) << v5 | (((long)Float.floatToRawIntBits(0f))) & v3);
            }

            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, v0_2, null), 3, null);
            return 1;
        }

        return 0;
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg6, PointerEventPass arg7, long arg8) {
        List v0 = arg6.getChanges();
        int v1 = v0.size();
        int v2 = 0;
        while(v2 < v1) {
            if(this.getCanDrag().invoke(PointerType.box-impl(v0.get(v2).getType-T8wyACA())).booleanValue()) {
                super.onPointerEvent-H0pRuoY(arg6, arg7, arg8);
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        if(this.getEnabled()) {
            if(arg7 == PointerEventPass.Initial && (PointerEventType.equals-impl0(arg6.getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk()))) {
                this.ensureMouseWheelScrollNodeInitialized();
            }

            MouseWheelScrollingLogic v5 = this.mouseWheelScrollingLogic;
            if(v5 == null) {
                return;
            }

            v5.onPointerEvent-H0pRuoY(arg6, arg7, arg8);
        }
    }

    public boolean onPreKeyEvent-ZmokQxo(KeyEvent arg1) {
        return 0;
    }

    private final void onWheelScrollStopped-TH1AsA0(long arg8) {
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onWheelScrollStopped$1(this, arg8, null), 3, null);
    }

    static final boolean scrollingLogic$lambda$0(ScrollableNode arg0) {
        return arg0.isAttached();
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new ScrollableNode$$ExternalSyntheticLambda3(this);
        this.scrollByOffsetAction = new ScrollableNode$setScrollSemanticsActions$2(this, null);
    }

    static final boolean setScrollSemanticsActions$lambda$0(ScrollableNode arg6, float arg7, float arg8) {
        BuildersKt.launch$default(arg6.getCoroutineScope(), null, null, new ScrollableNode$setScrollSemanticsActions$1$1(arg6, arg7, arg8, null), 3, null);
        return 1;
    }

    public boolean startDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(ScrollableState arg15, Orientation arg16, OverscrollEffect arg17, boolean arg18, boolean arg19, FlingBehavior arg20, MutableInteractionSource arg21, BringIntoViewSpec arg22) {
        ScrollableDefaultFlingBehavior v12;
        int v1;
        boolean v2 = arg18;
        FlingBehavior v0 = arg20;
        if(this.getEnabled() != v2) {
            this.nestedScrollConnection.setEnabled(v2);
            this.scrollableContainerNode.update(v2);
            v1 = 1;
        }
        else {
            v1 = 0;
        }

        int v6 = v1;
        if(v0 == null) {
            v12 = this.defaultFlingBehavior;
        }
        else {
            FlingBehavior v12_1 = v0;
        }

        boolean v5 = this.scrollingLogic.update(arg15, arg16, arg17, arg19, ((FlingBehavior)v12), this.nestedScrollDispatcher);
        this.contentInViewNode.update(arg16, arg19, arg22);
        this.overscrollEffect = arg17;
        this.flingBehavior = v0;
        Function1 v1_1 = ScrollableKt.getCanDragCalculation();
        Orientation v15 = this.scrollingLogic.isVertical() ? Orientation.Vertical : Orientation.Horizontal;
        this.update(v1_1, v2, arg21, v15, v5);
        if(v6 != 0) {
            this.clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(((SemanticsModifierNode)this));
        }
    }

    private final void updateDefaultFlingBehavior() {
        if(!this.isAttached()) {
            return;
        }

        this.defaultFlingBehavior.updateDensity(DelegatableNodeKt.requireDensity(this));
    }
}

