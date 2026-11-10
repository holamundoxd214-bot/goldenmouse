package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001MB9\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\u000E\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\"\u001A\u00020\u000F2\u0006\u0010#\u001A\u00020\u000FH\u0016J\b\u0010$\u001A\u00020\fH\u0002J\u001E\u0010%\u001A\u00020&2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000EH\u0096@¢\u0006\u0002\u0010\'J\u0010\u0010(\u001A\u00020&2\b\u0010)\u001A\u0004\u0018\u00010\u0018J\u0017\u0010*\u001A\u00020&2\u0006\u0010+\u001A\u00020\u001CH\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001A\u00020&2\u0006\u0010+\u001A\u00020\u001CH\u0002¢\u0006\u0004\b/\u0010-J\n\u00100\u001A\u0004\u0018\u00010\u000FH\u0002J\u0019\u00101\u001A\u00020&2\b\b\u0002\u00102\u001A\u000203H\u0002¢\u0006\u0004\b4\u0010-J\u001F\u00105\u001A\u0002062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u00102\u001A\u000203H\u0002¢\u0006\u0004\b7\u00108J\n\u00109\u001A\u0004\u0018\u00010\u000FH\u0002J\u0010\u0010:\u001A\u00020\u000F2\u0006\u0010;\u001A\u00020\u000FH\u0002J\'\u0010<\u001A\u00020\n*\u00020\u000F2\b\b\u0002\u0010+\u001A\u00020\u001C2\b\b\u0002\u0010=\u001A\u000203H\u0002¢\u0006\u0004\b>\u0010?J\'\u0010@\u001A\u00020A2\u0006\u0010;\u001A\u00020\u000F2\u0006\u0010B\u001A\u00020\u001C2\u0006\u0010=\u001A\u000203H\u0002¢\u0006\u0004\bC\u0010DJ\u001C\u0010E\u001A\u00020F*\u00020\u001C2\u0006\u0010G\u001A\u00020\u001CH\u0082\u0002¢\u0006\u0004\bH\u0010IJ\u001C\u0010E\u001A\u00020F*\u00020J2\u0006\u0010G\u001A\u00020JH\u0082\u0002¢\u0006\u0004\bK\u0010IJ \u0010L\u001A\u00020&2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\nX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001B\u001A\u00020\u001C@BX\u0080\u000E¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001E\u0010\u001FR\u000E\u0010!\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006N"}, d2={"Landroidx/compose/foundation/gestures/ContentInViewNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "reverseDirection", "", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getFocusedRect", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/ScrollingLogic;ZLandroidx/compose/foundation/gestures/BringIntoViewSpec;Lkotlin/jvm/functions/Function0;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "bringIntoViewRequests", "Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "focusedChild", "Landroidx/compose/ui/layout/LayoutCoordinates;", "trackingFocusedChild", "childWasMaxVisibleBeforeViewportShrunk", "value", "Landroidx/compose/ui/unit/IntSize;", "viewportSize", "getViewportSize-YbymL2g$foundation", "()J", "J", "isAnimationRunning", "calculateRectForParent", "localRect", "requireBringIntoViewSpec", "bringChildIntoView", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocusBoundsChanged", "newBounds", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "onRemeasuredLegacy", "onRemeasuredLegacy-ozmzZPI", "getFocusedChildBounds", "launchAnimation", "viewportAdjustmentForReverseScroll", "Landroidx/compose/ui/unit/IntOffset;", "launchAnimation--gyyYBs", "calculateScrollDelta", "", "calculateScrollDelta-I_oMVgE", "(Landroidx/compose/foundation/gestures/BringIntoViewSpec;J)F", "findBringIntoViewRequest", "computeDestination", "childBounds", "isMaxVisible", "containerOffset", "isMaxVisible--EQwtKw", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "relocationOffset", "Landroidx/compose/ui/geometry/Offset;", "containerSize", "relocationOffset-fbGrOKE", "(Landroidx/compose/ui/geometry/Rect;JJ)J", "compareTo", "", "other", "compareTo-TemP2vQ", "(JJ)I", "Landroidx/compose/ui/geometry/Size;", "compareTo-iLBOSCw", "update", "Request", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContentInViewNode extends Node implements BringIntoViewResponder, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0019\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "", "currentBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CancellableContinuation;)V", "getCurrentBounds", "()Lkotlin/jvm/functions/Function0;", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Request {
        public static final int $stable = 8;
        private final CancellableContinuation continuation;
        private final Function0 currentBounds;

        static {
        }

        public Request(Function0 arg1, CancellableContinuation arg2) {
            super();
            this.currentBounds = arg1;
            this.continuation = arg2;
        }

        public final CancellableContinuation getContinuation() {
            return this.continuation;
        }

        public final Function0 getCurrentBounds() {
            return this.currentBounds;
        }

        public String toString() {
            Element v0 = this.continuation.getContext().get(CoroutineName.Key);
            String v0_1 = v0 != null ? ((CoroutineName)v0).getName() : null;
            StringBuilder v1 = new StringBuilder("Request@");
            String v2 = Integer.toString(this.hashCode(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
            v1 = v1.append(v2);
            if(v0_1 != null) {
                v0_1 = "[" + v0_1 + "](";
                if(v0_1 == null) {
                    goto label_27;
                }
            }
            else {
            label_27:
                v0_1 = "(";
            }

            return v1.append(v0_1).append("currentBounds()=").append(this.currentBounds.invoke()).append(", continuation=").append(this.continuation).append(')').toString();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Orientation.values().length];
            try {
                v0[Orientation.Vertical.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Orientation.Horizontal.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 8;
    private final BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    private BringIntoViewSpec bringIntoViewSpec;
    private boolean childWasMaxVisibleBeforeViewportShrunk;
    private LayoutCoordinates focusedChild;
    private Function0 getFocusedRect;
    private boolean isAnimationRunning;
    private Orientation orientation;
    private boolean reverseDirection;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;
    private boolean trackingFocusedChild;
    private long viewportSize;

    static {
    }

    public ContentInViewNode(Orientation arg1, ScrollingLogic arg2, boolean arg3, BringIntoViewSpec arg4, Function0 arg5) {
        super();
        this.orientation = arg1;
        this.scrollingLogic = arg2;
        this.reverseDirection = arg3;
        this.bringIntoViewSpec = arg4;
        this.getFocusedRect = arg5;
        this.bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
        this.viewportSize = IntSize.Companion.getZero-YbymL2g();
    }

    public static final float access$calculateScrollDelta-I_oMVgE(ContentInViewNode arg0, BringIntoViewSpec arg1, long arg2) {
        return arg0.calculateScrollDelta-I_oMVgE(arg1, arg2);
    }

    public static final BringIntoViewRequestPriorityQueue access$getBringIntoViewRequests$p(ContentInViewNode arg0) {
        return arg0.bringIntoViewRequests;
    }

    public static final Rect access$getFocusedChildBounds(ContentInViewNode arg0) {
        return arg0.getFocusedChildBounds();
    }

    public static final boolean access$getReverseDirection$p(ContentInViewNode arg0) {
        return arg0.reverseDirection;
    }

    public static final ScrollingLogic access$getScrollingLogic$p(ContentInViewNode arg0) {
        return arg0.scrollingLogic;
    }

    public static final boolean access$getTrackingFocusedChild$p(ContentInViewNode arg0) {
        return arg0.trackingFocusedChild;
    }

    public static final boolean access$isAnimationRunning$p(ContentInViewNode arg0) {
        return arg0.isAnimationRunning;
    }

    public static final void access$setAnimationRunning$p(ContentInViewNode arg0, boolean arg1) {
        arg0.isAnimationRunning = arg1;
    }

    public static final void access$setTrackingFocusedChild$p(ContentInViewNode arg0, boolean arg1) {
        arg0.trackingFocusedChild = arg1;
    }

    public Object bringChildIntoView(Function0 arg10, Continuation arg11) {
        Object v2 = arg10.invoke();
        if(v2 != null) {
            ContentInViewNode v1 = this;
            if(!ContentInViewNode.isMaxVisible--EQwtKw$default(v1, ((Rect)v2), 0, 0, 3, null)) {
                CancellableContinuationImpl v9 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg11), 1);
                v9.initCancellability();
                if((v1.bringIntoViewRequests.enqueue(new Request(arg10, v9))) && !v1.isAnimationRunning) {
                    ContentInViewNode.launchAnimation--gyyYBs$default(v1, 0, 1, null);
                }

                Object v9_1 = v9.getResult();
                if(v9_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(arg11);
                }

                if(v9_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v9_1;
                }

                return Unit.INSTANCE;
            }
        }

        return Unit.INSTANCE;
    }

    public Rect calculateRectForParent(Rect arg5) {
        if(IntSize.equals-impl0(this.viewportSize, IntSize.Companion.getZero-YbymL2g())) {
            InlineClassHelperKt.throwIllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.");
        }

        return this.computeDestination(arg5);
    }

    private final float calculateScrollDelta-I_oMVgE(BringIntoViewSpec arg6, long arg7) {
        if(IntSize.equals-impl0(this.viewportSize, IntSize.Companion.getZero-YbymL2g())) {
            return 0;
        }

        Rect v0 = this.findBringIntoViewRequest();
        if(v0 == null) {
            v0 = this.trackingFocusedChild ? this.getFocusedChildBounds() : null;
            if(v0 != null) {
                goto label_16;
            }

            return 0;
        }

    label_16:
        long v1 = IntSizeKt.toSize-ozmzZPI(this.viewportSize);
        int v5 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if(v5 != 1) {
            if(v5 == 2) {
                return arg6.calculateScrollDistance(v0.getLeft() - (((float)IntOffset.getX-impl(arg7))), v0.getRight() - v0.getLeft(), Float.intBitsToFloat(((int)(v1 >> 0x20))));
            }

            throw new NoWhenBranchMatchedException();
        }

        return arg6.calculateScrollDistance(v0.getTop() - (((float)IntOffset.getY-impl(arg7))), v0.getBottom() - v0.getTop(), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))));
    }

    private final int compareTo-TemP2vQ(long arg3, long arg5) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if(v2 != 1) {
            if(v2 == 2) {
                return Intrinsics.compare(((int)(arg3 >> 0x20)), ((int)(arg5 >> 0x20)));
            }

            throw new NoWhenBranchMatchedException();
        }

        return Intrinsics.compare(((int)(arg3 & 0xFFFFFFFFL)), ((int)(arg5 & 0xFFFFFFFFL)));
    }

    private final int compareTo-iLBOSCw(long arg3, long arg5) {
        int v2 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if(v2 != 1) {
            if(v2 == 2) {
                return Float.compare(Float.intBitsToFloat(((int)(arg3 >> 0x20))), Float.intBitsToFloat(((int)(arg5 >> 0x20))));
            }

            throw new NoWhenBranchMatchedException();
        }

        return Float.compare(Float.intBitsToFloat(((int)(arg3 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))));
    }

    private final Rect computeDestination(Rect arg7) {
        return arg7.translate-k-4lQ0M(Offset.constructor-impl(this.relocationOffset-fbGrOKE(arg7, this.viewportSize, IntOffset.Companion.getZero-nOcc-ac()) ^ -9223372034707292160L));
    }

    private final Rect findBringIntoViewRequest() {
        MutableVector v0 = this.bringIntoViewRequests.requests;
        int v1 = v0.getSize() - 1;
        Object[] v0_1 = v0.content;
        Object v3 = null;
        if(v1 < v0_1.length) {
            while(v1 >= 0) {
                Object v2 = v0_1[v1].getCurrentBounds().invoke();
                if(v2 != null) {
                    if(this.compareTo-iLBOSCw(((Rect)v2).getSize-NH-jbRc(), IntSizeKt.toSize-ozmzZPI(this.viewportSize)) <= 0) {
                        v3 = v2;
                    }
                    else if(v3 == null) {
                        return ((Rect)v2);
                    }
                    else {
                        break;
                    }
                }

                --v1;
            }
        }

        return ((Rect)v3);
    }

    private final Rect getFocusedChildBounds() {
        if(ComposeFoundationFlags.isKeepInViewFocusObservationChangeEnabled) {
            return this.getFocusedRect.invoke();
        }

        Rect v1 = null;
        if(!this.isAttached()) {
            return v1;
        }

        LayoutCoordinates v0 = DelegatableNodeKt.requireLayoutCoordinates(this);
        LayoutCoordinates v3 = this.focusedChild;
        if(v3 != null) {
            if(v3.isAttached()) {
            }
            else {
                v3 = ((LayoutCoordinates)v1);
            }

            if(v3 == null) {
                return v1;
            }

            return v0.localBoundingBoxOf(v3, false);
        }

        return v1;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final long getViewportSize-YbymL2g$foundation() {
        return this.viewportSize;
    }

    private final boolean isMaxVisible--EQwtKw(Rect arg1, long arg2, long arg4) {
        long v0 = this.relocationOffset-fbGrOKE(arg1, arg2, arg4);
        float v3 = 0.5f;
        if(Math.abs(Float.intBitsToFloat(((int)(v0 >> 0x20)))) <= v3 && Math.abs(Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL)))) <= v3) {
            return 1;
        }

        return 0;
    }

    static boolean isMaxVisible--EQwtKw$default(ContentInViewNode arg6, Rect arg7, long arg8, long arg10, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg8 = arg6.viewportSize;
        }

        long v2 = arg8;
        if((arg12 & 2) != 0) {
            arg10 = IntOffset.Companion.getZero-nOcc-ac();
        }

        return arg6.isMaxVisible--EQwtKw(arg7, v2, arg10);
    }

    private final void launchAnimation--gyyYBs(long arg11) {
        BringIntoViewSpec v3 = this.requireBringIntoViewSpec();
        if(this.isAnimationRunning) {
            InlineClassHelperKt.throwIllegalStateException("launchAnimation called when previous animation was running");
        }

        BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new ContentInViewNode$launchAnimation$2(this, new UpdatableAnimationState(this.requireBringIntoViewSpec().getScrollAnimationSpec()), v3, arg11, null), 1, null);
    }

    static void launchAnimation--gyyYBs$default(ContentInViewNode arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = IntOffset.Companion.getZero-nOcc-ac();
        }

        arg0.launchAnimation--gyyYBs(arg1);
    }

    public final void onFocusBoundsChanged(LayoutCoordinates arg9) {
        ContentInViewNode v0;
        this.focusedChild = arg9;
        if(this.childWasMaxVisibleBeforeViewportShrunk) {
            Rect v1 = this.getFocusedChildBounds();
            if(v1 != null) {
                v0 = this;
                if(!ContentInViewNode.isMaxVisible--EQwtKw$default(v0, v1, this.viewportSize, 0, 2, null)) {
                    v0.trackingFocusedChild = true;
                    ContentInViewNode.launchAnimation--gyyYBs$default(v0, 0, 1, null);
                }
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v0 = this;
        }

        v0.childWasMaxVisibleBeforeViewportShrunk = false;
    }

    public void onRemeasured-ozmzZPI(long arg14) {
        if(!ComposeFoundationFlags.isKeepInViewFocusObservationChangeEnabled) {
            this.onRemeasuredLegacy-ozmzZPI(arg14);
            return;
        }

        long v3 = this.viewportSize;
        this.viewportSize = arg14;
        if(this.compareTo-TemP2vQ(arg14, v3) >= 0) {
        }
        else {
            if(this.reverseDirection) {
                arg14 = IntOffset.Companion.getZero-nOcc-ac();
            }
            else if(this.orientation == Orientation.Vertical) {
                arg14 = IntOffset.constructor-impl((((long)((((int)(v3 & 0xFFFFFFFFL))) - (((int)(arg14 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
            }
            else {
                arg14 = IntOffset.constructor-impl((((long)((((int)(v3 >> 0x20))) - (((int)(arg14 >> 0x20)))))) << 0x20);
            }

            long v9 = arg14;
            Object v2 = this.getFocusedRect.invoke();
            if(v2 == null) {
                return;
            }

            if(this.isAnimationRunning) {
                return;
            }

            if(this.trackingFocusedChild) {
                return;
            }

            ContentInViewNode v1 = this;
            if(!ContentInViewNode.isMaxVisible--EQwtKw$default(v1, ((Rect)v2), v3, 0, 2, null)) {
                return;
            }

            if(ContentInViewNode.isMaxVisible--EQwtKw$default(v1, v2, 0, v9, 1, null)) {
                return;
            }

            v1.trackingFocusedChild = true;
            v1.launchAnimation--gyyYBs(v9);
        }
    }

    private final void onRemeasuredLegacy-ozmzZPI(long arg9) {
        long v2 = this.viewportSize;
        this.viewportSize = arg9;
        if(this.compareTo-TemP2vQ(arg9, v2) >= 0) {
        }
        else if(!this.isAnimationRunning) {
            if(this.trackingFocusedChild) {
            }
            else {
                Rect v1 = this.getFocusedChildBounds();
                if(v1 == null) {
                }
                else {
                    ContentInViewNode v0 = this;
                    if(ContentInViewNode.isMaxVisible--EQwtKw$default(v0, v1, v2, 0, 2, null)) {
                        v0.childWasMaxVisibleBeforeViewportShrunk = true;
                    }
                }
            }
        }
    }

    private final long relocationOffset-fbGrOKE(Rect arg7, long arg8, long arg10) {
        arg8 = IntSizeKt.toSize-ozmzZPI(arg8);
        int v0 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        int v3 = 0x20;
        long v4 = 0xFFFFFFFFL;
        if(v0 != 1) {
            if(v0 == 2) {
                return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.requireBringIntoViewSpec().calculateScrollDistance(arg7.getLeft() - (((float)IntOffset.getX-impl(arg10))), arg7.getRight() - arg7.getLeft(), Float.intBitsToFloat(((int)(arg8 >> v3))))))) << v3 | (((long)Float.floatToRawIntBits(0f))) & v4);
            }

            throw new NoWhenBranchMatchedException();
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v3 | (((long)Float.floatToRawIntBits(this.requireBringIntoViewSpec().calculateScrollDistance(arg7.getTop() - (((float)IntOffset.getY-impl(arg10))), arg7.getBottom() - arg7.getTop(), Float.intBitsToFloat(((int)(arg8 & v4))))))) & v4);
    }

    private final BringIntoViewSpec requireBringIntoViewSpec() {
        BringIntoViewSpec v0 = this.bringIntoViewSpec;
        if(v0 == null) {
            return CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec());
        }

        return v0;
    }

    public final void update(Orientation arg1, boolean arg2, BringIntoViewSpec arg3) {
        this.orientation = arg1;
        this.reverseDirection = arg2;
        this.bringIntoViewSpec = arg3;
    }
}

