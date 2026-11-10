package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0001\u0018\u0000 D2\u00020\u0001:\u0002CDB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0017\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016J\u0010\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\u0010\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016J\u0010\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\'\u0010 \u001A\u00020\u00122\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&H\u0014¢\u0006\u0004\b\'\u0010(J:\u0010 \u001A\u00020\u00122\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0019\u0010)\u001A\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0012\u0018\u00010*¢\u0006\u0002\b,H\u0014¢\u0006\u0004\b\'\u0010-J\b\u0010.\u001A\u00020\u0012H\u0002J\u0010\u0010/\u001A\u00020\u001A2\u0006\u00100\u001A\u000201H\u0016J\u001A\u00102\u001A\u00020\u00122\u0006\u00103\u001A\u0002042\b\u00105\u001A\u0004\u0018\u00010&H\u0016J7\u00106\u001A\u00020\u00122\u0006\u00107\u001A\u0002082\u0006\u00109\u001A\u00020:2\u0006\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020>2\u0006\u0010?\u001A\u00020@H\u0016¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR(\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u000B@TX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006E"}, d2={"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "tail", "Landroidx/compose/ui/node/TailModifierNode;", "getTail", "()Landroidx/compose/ui/node/TailModifierNode;", "value", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "ensureLookaheadDelegateCreated", "", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "(JFLkotlin/jvm/functions/Function1;)V", "onAfterPlaceAt", "calculateAlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "hitTestChild", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "", "hitTestChild-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "LookaheadDelegateImpl", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InnerNodeCoordinator extends NodeCoordinator {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "<init>", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0014J\u0010\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000BH\u0016J\u0010\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u000BH\u0016J\u0010\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u000BH\u0016J\u0010\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u000BH\u0016¨\u0006\u0016"}, d2={"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/InnerNodeCoordinator;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeChildren", "", "minIntrinsicWidth", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class LookaheadDelegateImpl extends LookaheadDelegate {
        public LookaheadDelegateImpl(InnerNodeCoordinator arg1) {
            InnerNodeCoordinator.this = arg1;
            super(((NodeCoordinator)arg1));
        }

        public int calculateAlignmentLine(AlignmentLine arg2) {
            Object v0 = this.getAlignmentLinesOwner().calculateAlignmentLines().get(arg2);
            int v0_1 = v0 != null ? ((Integer)v0).intValue() : 0x80000000;
            this.getCachedAlignmentLinesMap().set(arg2, v0_1);
            return v0_1;
        }

        public int maxIntrinsicHeight(int arg1) {
            return this.getLayoutNode().maxLookaheadIntrinsicHeight(arg1);
        }

        public int maxIntrinsicWidth(int arg1) {
            return this.getLayoutNode().maxLookaheadIntrinsicWidth(arg1);
        }

        public Placeable measure-BRTryo0(long arg7) {
            LookaheadDelegateImpl v0 = this;
            ((LookaheadDelegate)v0).setMeasurementConstraints-BRTryo0(arg7);
            MutableVector v1 = this.getLayoutNode().get_children$ui();
            Object[] v2 = v1.content;
            int v1_1 = v1.getSize();
            int v3;
            for(v3 = 0; v3 < v1_1; ++v3) {
                LookaheadPassDelegate v4 = v2[v3].getLookaheadPassDelegate$ui();
                Intrinsics.checkNotNull(v4);
                v4.setMeasuredByParent$ui(UsageByParent.NotUsed);
            }

            ((LookaheadDelegate)v0).set_measureResult(this.getLayoutNode().getMeasurePolicy().measure-3p2s80s(this, this.getLayoutNode().getChildLookaheadMeasurables$ui(), arg7));
            return ((Placeable)v0);
        }

        public int minIntrinsicHeight(int arg1) {
            return this.getLayoutNode().minLookaheadIntrinsicHeight(arg1);
        }

        public int minIntrinsicWidth(int arg1) {
            return this.getLayoutNode().minLookaheadIntrinsicWidth(arg1);
        }

        protected void placeChildren() {
            LookaheadPassDelegate v0 = this.getLayoutNode().getLookaheadPassDelegate$ui();
            Intrinsics.checkNotNull(v0);
            v0.onNodePlaced$ui();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Paint innerBoundsPaint;
    private LookaheadDelegate lookaheadDelegate;
    private final TailModifierNode tail;

    static {
        InnerNodeCoordinator.Companion = new Companion(null);
        Paint v0 = AndroidPaint_androidKt.Paint();
        v0.setColor-8_81llA(Color.Companion.getRed-0d7_KjU());
        v0.setStrokeWidth(1f);
        v0.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        InnerNodeCoordinator.innerBoundsPaint = v0;
    }

    public InnerNodeCoordinator(LayoutNode arg3) {
        LookaheadDelegateImpl v3;
        super(arg3);
        this.tail = new TailModifierNode();
        this.getTail().updateCoordinator$ui(this);
        if(arg3.getLookaheadRoot$ui() != null) {
            v3 = new LookaheadDelegateImpl(this);
        }
        else {
            LookaheadDelegate v3_1 = null;
        }

        this.lookaheadDelegate = ((LookaheadDelegate)v3);
    }

    public static final Paint access$getInnerBoundsPaint$cp() {
        return InnerNodeCoordinator.innerBoundsPaint;
    }

    public int calculateAlignmentLine(AlignmentLine arg2) {
        LookaheadDelegate v0 = this.getLookaheadDelegate();
        if(v0 != null) {
            return v0.calculateAlignmentLine(arg2);
        }

        Object v1 = this.getAlignmentLinesOwner().calculateAlignmentLines().get(arg2);
        if(v1 != null) {
            return ((Integer)v1).intValue();
        }

        return 0x80000000;
    }

    public void ensureLookaheadDelegateCreated() {
        if(this.getLookaheadDelegate() == null) {
            this.setLookaheadDelegate(new LookaheadDelegateImpl(this));
        }
    }

    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public TailModifierNode getTail() {
        return this.tail;
    }

    public Node getTail() {
        return this.getTail();
    }

    public void hitTestChild-qzLsGqo(HitTestSource arg7, long arg8, HitTestResult arg10, int arg11, boolean arg12) {
        HitTestSource v6_2;
        int v2 = 0;
        if(arg7.shouldHitTestChildren(this.getLayoutNode())) {
            if(!this.withinLayerBounds-k-4lQ0M(arg8)) {
                if(!PointerType.equals-impl0(arg11, PointerType.Companion.getTouch-T8wyACA())) {
                    goto label_22;
                }
                else if((Float.floatToRawIntBits(this.distanceInMinimumTouchTarget-tz77jQw(arg8, this.getMinimumTouchTargetSize-NH-jbRc())) & 0x7FFFFFFF) < 0x7F800000) {
                }
                else {
                    goto label_22;
                }
            }

            v2 = 1;
        }

    label_22:
        if(v2 != 0) {
            int v0 = arg10.hitDepth;
            MutableVector v6 = this.getLayoutNode().getZSortedChildren();
            Object[] v2_1 = v6.content;
            int v1 = v6.getSize() - 1;
            while(v1 >= 0) {
                Object v6_1 = v2_1[v1];
                if(((LayoutNode)v6_1).isPlaced()) {
                    HitTestSource v5 = arg7;
                    Object v7 = v6_1;
                    v6_2 = v5;
                    v6_2.childHitTest-qzLsGqo(((LayoutNode)v7), arg8, arg10, arg11, false);
                    if(!arg10.hasHit()) {
                    }
                    else if(((LayoutNode)v7).getOuterCoordinator$ui().shouldSharePointerInputWithSiblings()) {
                        arg10.acceptHits();
                    }
                    else {
                        break;
                    }
                }
                else {
                    v6_2 = arg7;
                }

                --v1;
                arg7 = v6_2;
            }

            arg10.hitDepth = v0;
        }
    }

    public int maxIntrinsicHeight(int arg1) {
        return this.getLayoutNode().maxIntrinsicHeight(arg1);
    }

    public int maxIntrinsicWidth(int arg1) {
        return this.getLayoutNode().maxIntrinsicWidth(arg1);
    }

    public Placeable measure-BRTryo0(long arg6) {
        if(this.getForceMeasureWithLookaheadConstraints$ui()) {
            LookaheadDelegate v6 = this.getLookaheadDelegate();
            Intrinsics.checkNotNull(v6);
            arg6 = v6.getConstraints-msEJaDk$ui();
        }

        this.setMeasurementConstraints-BRTryo0(arg6);
        MutableVector v0 = this.getLayoutNode().get_children$ui();
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            v1[v2].getMeasurePassDelegate$ui().setMeasuredByParent$ui(UsageByParent.NotUsed);
        }

        this.setMeasureResult$ui(this.getLayoutNode().getMeasurePolicy().measure-3p2s80s(this, this.getLayoutNode().getChildMeasurables$ui(), arg6));
        this.onMeasured();
        return this;
    }

    public int minIntrinsicHeight(int arg1) {
        return this.getLayoutNode().minIntrinsicHeight(arg1);
    }

    public int minIntrinsicWidth(int arg1) {
        return this.getLayoutNode().minIntrinsicWidth(arg1);
    }

    private final void onAfterPlaceAt() {
        if(this.isShallowPlacing$ui()) {
            return;
        }

        this.getLayoutNode().getMeasurePassDelegate$ui().onNodePlaced$ui();
    }

    public void performDraw(Canvas arg7, GraphicsLayer arg8) {
        Owner v0 = LayoutNodeKt.requireOwner(this.getLayoutNode());
        MutableVector v1 = this.getLayoutNode().getZSortedChildren();
        Object[] v2 = v1.content;
        int v1_1 = v1.getSize();
        int v3;
        for(v3 = 0; v3 < v1_1; ++v3) {
            Object v4 = v2[v3];
            if(((LayoutNode)v4).isPlaced()) {
                ((LayoutNode)v4).draw$ui(arg7, arg8);
            }
        }

        if(v0.getShowLayoutBounds()) {
            this.drawBorder(arg7, InnerNodeCoordinator.innerBoundsPaint);
        }
    }

    protected void placeAt-f8xVGno(long arg1, float arg3, GraphicsLayer arg4) {
        super.placeAt-f8xVGno(arg1, arg3, arg4);
        this.onAfterPlaceAt();
    }

    protected void placeAt-f8xVGno(long arg1, float arg3, Function1 arg4) {
        super.placeAt-f8xVGno(arg1, arg3, arg4);
        this.onAfterPlaceAt();
    }

    protected void setLookaheadDelegate(LookaheadDelegate arg1) {
        this.lookaheadDelegate = arg1;
    }
}

