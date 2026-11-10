package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachIntrinsicMeasureScope;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 H2\u00020\u0001:\u0002GHB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001A\u00020$H\u0016J\u0017\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\u0016H\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+H\u0016J\u0010\u0010-\u001A\u00020+2\u0006\u0010,\u001A\u00020+H\u0016J\u0010\u0010.\u001A\u00020+2\u0006\u0010/\u001A\u00020+H\u0016J\u0010\u00100\u001A\u00020+2\u0006\u0010/\u001A\u00020+H\u0016J\'\u00101\u001A\u00020$2\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u000207H\u0014¢\u0006\u0004\b8\u00109J:\u00101\u001A\u00020$2\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002052\u0019\u0010:\u001A\u0015\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020$\u0018\u00010;¢\u0006\u0002\b=H\u0014¢\u0006\u0004\b8\u0010>J\b\u0010?\u001A\u00020$H\u0002J\u0010\u0010@\u001A\u00020+2\u0006\u0010A\u001A\u00020BH\u0016J\u001A\u0010C\u001A\u00020$2\u0006\u0010D\u001A\u00020E2\b\u0010F\u001A\u0004\u0018\u000107H\u0016R$\u0010\t\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u001C\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR(\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\b\u001A\u0004\u0018\u00010\u001B@TX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u0010\u0010!\u001A\u0004\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006I"}, d2={"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "value", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui", "(Landroidx/compose/ui/unit/Constraints;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "ensureLookaheadDelegateCreated", "", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "(JFLkotlin/jvm/functions/Function1;)V", "onAfterPlaceAt", "calculateAlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "LookaheadDelegateForLayoutModifierNode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "<init>", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016J\u0010\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016J\u0010\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u000BH\u0016J\u0010\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u000BH\u0016¨\u0006\u0014"}, d2={"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode(LayoutModifierNodeCoordinator arg1) {
            LayoutModifierNodeCoordinator.this = arg1;
            super(((NodeCoordinator)arg1));
        }

        public int calculateAlignmentLine(AlignmentLine arg2) {
            int v0 = LayoutModifierNodeCoordinatorKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, arg2);
            this.getCachedAlignmentLinesMap().set(arg2, v0);
            return v0;
        }

        public int maxIntrinsicHeight(int arg3) {
            LayoutModifierNode v0 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate v1 = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(v1);
            return v0.maxIntrinsicHeight(((IntrinsicMeasureScope)this), ((IntrinsicMeasurable)v1), arg3);
        }

        public int maxIntrinsicWidth(int arg3) {
            LayoutModifierNode v0 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate v1 = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(v1);
            return v0.maxIntrinsicWidth(((IntrinsicMeasureScope)this), ((IntrinsicMeasurable)v1), arg3);
        }

        public Placeable measure-BRTryo0(long arg4) {
            LayoutModifierNodeCoordinator v1 = LayoutModifierNodeCoordinator.this;
            this.setMeasurementConstraints-BRTryo0(arg4);
            v1.setLookaheadConstraints-_Sx5XlM$ui(Constraints.box-impl(arg4));
            LayoutModifierNode v2 = v1.getLayoutModifierNode();
            LookaheadDelegate v1_1 = v1.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(v1_1);
            this.set_measureResult(v2.measure-3p2s80s(((MeasureScope)this), ((Measurable)v1_1), arg4));
            return this;
        }

        public int minIntrinsicHeight(int arg3) {
            LayoutModifierNode v0 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate v1 = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(v1);
            return v0.minIntrinsicHeight(((IntrinsicMeasureScope)this), ((IntrinsicMeasurable)v1), arg3);
        }

        public int minIntrinsicWidth(int arg3) {
            LayoutModifierNode v0 = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate v1 = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(v1);
            return v0.minIntrinsicWidth(((IntrinsicMeasureScope)this), ((IntrinsicMeasurable)v1), arg3);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private ApproachMeasureScopeImpl approachMeasureScope;
    private LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;
    private static final Paint modifierBoundsPaint;

    static {
        LayoutModifierNodeCoordinator.Companion = new Companion(null);
        Paint v0 = AndroidPaint_androidKt.Paint();
        v0.setColor-8_81llA(Color.Companion.getBlue-0d7_KjU());
        v0.setStrokeWidth(1f);
        v0.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        LayoutModifierNodeCoordinator.modifierBoundsPaint = v0;
    }

    public LayoutModifierNodeCoordinator(LayoutNode arg3, LayoutModifierNode arg4) {
        LookaheadDelegate v3_1;
        super(arg3);
        this.layoutModifierNode = arg4;
        ApproachMeasureScopeImpl v0 = null;
        if(arg3.getLookaheadRoot$ui() != null) {
            LookaheadDelegateForLayoutModifierNode v3 = new LookaheadDelegateForLayoutModifierNode(this);
        }
        else {
            v3_1 = ((LookaheadDelegate)v0);
        }

        this.lookaheadDelegate = v3_1;
        if((arg4.getNode().getKindSet$ui() & NodeKind.constructor-impl(0x200)) != 0) {
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            v0 = new ApproachMeasureScopeImpl(this, ((ApproachLayoutModifierNode)arg4));
        }

        this.approachMeasureScope = v0;
    }

    public static final ApproachMeasureScopeImpl access$getApproachMeasureScope$p(LayoutModifierNodeCoordinator arg0) {
        return arg0.approachMeasureScope;
    }

    public static final Paint access$getModifierBoundsPaint$cp() {
        return LayoutModifierNodeCoordinator.modifierBoundsPaint;
    }

    public int calculateAlignmentLine(AlignmentLine arg2) {
        LookaheadDelegate v0 = this.getLookaheadDelegate();
        if(v0 != null) {
            return v0.getCachedAlignmentLine$ui(arg2);
        }

        return LayoutModifierNodeCoordinatorKt.access$calculateAlignmentAndPlaceChildAsNeeded(((LookaheadCapablePlaceable)this), arg2);
    }

    public void ensureLookaheadDelegateCreated() {
        if(this.getLookaheadDelegate() == null) {
            this.setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode(this));
        }
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final Constraints getLookaheadConstraints-DWUhwKw$ui() {
        return this.lookaheadConstraints;
    }

    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator v0 = this.getWrapped$ui();
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public int maxIntrinsicHeight(int arg3) {
        ApproachMeasureScopeImpl v0 = this.approachMeasureScope;
        if(v0 != null) {
            return v0.getApproachNode().maxApproachIntrinsicHeight(((ApproachIntrinsicMeasureScope)v0), this.getWrappedNonNull(), arg3);
        }

        return this.layoutModifierNode.maxIntrinsicHeight(this, this.getWrappedNonNull(), arg3);
    }

    public int maxIntrinsicWidth(int arg3) {
        ApproachMeasureScopeImpl v0 = this.approachMeasureScope;
        if(v0 != null) {
            return v0.getApproachNode().maxApproachIntrinsicWidth(((ApproachIntrinsicMeasureScope)v0), this.getWrappedNonNull(), arg3);
        }

        return this.layoutModifierNode.maxIntrinsicWidth(this, this.getWrappedNonNull(), arg3);
    }

    public Placeable measure-BRTryo0(long arg9) {
        MeasureResult v1_1;
        if(this.getForceMeasureWithLookaheadConstraints$ui()) {
            Constraints v9 = this.lookaheadConstraints;
            if(v9 != null) {
                arg9 = v9.unbox-impl();
            }
            else {
                throw new IllegalArgumentException("Lookahead constraints cannot be null in approach pass.".toString());
            }
        }

        this.setMeasurementConstraints-BRTryo0(arg9);
        ApproachMeasureScopeImpl v0 = this.approachMeasureScope;
        if(v0 != null) {
            ApproachLayoutModifierNode v1 = v0.getApproachNode();
            int v3 = 0;
            boolean v2 = (v1.isMeasurementApproachInProgress-ozmzZPI(v0.getLookaheadSize-YbymL2g())) || !Constraints.equals-impl(arg9, this.getLookaheadConstraints-DWUhwKw$ui()) ? true : false;
            v0.setApproachMeasureRequired$ui(v2);
            if(!v0.getApproachMeasureRequired$ui()) {
                this.getWrappedNonNull().setForceMeasureWithLookaheadConstraints$ui(true);
            }

            v1_1 = v1.approachMeasure-3p2s80s(v0, this.getWrappedNonNull(), arg9);
            this.getWrappedNonNull().setForceMeasureWithLookaheadConstraints$ui(false);
            int v2_1 = v1_1.getWidth();
            LookaheadDelegate v5 = this.getLookaheadDelegate();
            Intrinsics.checkNotNull(v5);
            if(v2_1 == v5.getWidth()) {
                v2_1 = v1_1.getHeight();
                v5 = this.getLookaheadDelegate();
                Intrinsics.checkNotNull(v5);
                if(v2_1 == v5.getHeight()) {
                    v3 = 1;
                }
            }

            if(!v0.getApproachMeasureRequired$ui()) {
                long v4 = this.getWrappedNonNull().getSize-YbymL2g();
                LookaheadDelegate v0_1 = this.getWrappedNonNull().getLookaheadDelegate();
                if(v0_1 != null) {
                    IntSize v0_2 = IntSize.box-impl(v0_1.getSize-YbymL2g$ui());
                }
                else {
                    Object v0_3 = null;
                }

                if(!IntSize.equals-impl(v4, v0_2)) {
                    goto label_66;
                }

                if(v3 != 0) {
                    goto label_66;
                }

                LayoutModifierNodeCoordinator$measure$1$1$1$1 v1_2 = new LayoutModifierNodeCoordinator$measure$1$1$1$1(v1_1, this);
            }

        label_66:
            if(v1_1 != null) {
                goto label_71;
            }

            goto label_67;
        }
        else {
        label_67:
            v1_1 = this.getLayoutModifierNode().measure-3p2s80s(this, this.getWrappedNonNull(), arg9);
        }

    label_71:
        this.setMeasureResult$ui(v1_1);
        this.onMeasured();
        return this;
    }

    public int minIntrinsicHeight(int arg3) {
        ApproachMeasureScopeImpl v0 = this.approachMeasureScope;
        if(v0 != null) {
            return v0.getApproachNode().minApproachIntrinsicHeight(((ApproachIntrinsicMeasureScope)v0), this.getWrappedNonNull(), arg3);
        }

        return this.layoutModifierNode.minIntrinsicHeight(this, this.getWrappedNonNull(), arg3);
    }

    public int minIntrinsicWidth(int arg3) {
        ApproachMeasureScopeImpl v0 = this.approachMeasureScope;
        if(v0 != null) {
            return v0.getApproachNode().minApproachIntrinsicWidth(((ApproachIntrinsicMeasureScope)v0), this.getWrappedNonNull(), arg3);
        }

        return this.layoutModifierNode.minIntrinsicWidth(this, this.getWrappedNonNull(), arg3);
    }

    private final void onAfterPlaceAt() {
        boolean v1_4;
        if(this.isShallowPlacing$ui()) {
            return;
        }

        this.onPlaced();
        NodeCoordinator v0 = this.getWrappedNonNull();
        ApproachMeasureScopeImpl v1 = this.approachMeasureScope;
        if(v1 != null) {
            ApproachLayoutModifierNode v3 = v1.getApproachNode();
            PlacementScope v4 = this.getPlacementScope();
            LookaheadDelegate v5 = this.getLookaheadDelegate();
            Intrinsics.checkNotNull(v5);
            if((v3.isPlacementApproachInProgress(v4, v5.getLookaheadLayoutCoordinates())) || (v1.getApproachMeasureRequired$ui())) {
            label_36:
                v1_4 = false;
            }
            else {
                long v3_1 = this.getSize-YbymL2g();
                LookaheadDelegate v1_1 = this.getLookaheadDelegate();
                Object v5_1 = null;
                if(v1_1 != null) {
                    IntSize v1_2 = IntSize.box-impl(v1_1.getSize-YbymL2g$ui());
                }
                else {
                    Object v1_3 = v5_1;
                }

                if(!IntSize.equals-impl(v3_1, v1_3)) {
                    goto label_36;
                }

                v3_1 = v0.getSize-YbymL2g();
                v1_1 = v0.getLookaheadDelegate();
                if(v1_1 != null) {
                    IntSize v5_2 = IntSize.box-impl(v1_1.getSize-YbymL2g$ui());
                }

                if(!IntSize.equals-impl(v3_1, v5_2)) {
                    goto label_36;
                }

                v1_4 = true;
            }

            v0.setForcePlaceWithLookaheadOffset$ui(v1_4);
        }

        v0.setPlacingForAlignment$ui(this.isPlacingForAlignment$ui());
        this.getMeasureResult$ui().placeChildren();
        v0.setPlacingForAlignment$ui(false);
        v0.setForcePlaceWithLookaheadOffset$ui(false);
    }

    public void performDraw(Canvas arg5, GraphicsLayer arg6) {
        this.getWrappedNonNull().draw(arg5, arg6);
        if(LayoutNodeKt.requireOwner(this.getLayoutNode()).getShowLayoutBounds()) {
            NodeCoordinator v6 = this.getWrapped$ui();
            if(v6 != null) {
                if((IntSize.equals-impl0(this.getSize-YbymL2g(), v6.getSize-YbymL2g())) && (IntOffset.equals-impl0(v6.getPosition-nOcc-ac(), IntOffset.Companion.getZero-nOcc-ac()))) {
                    return;
                }

                this.drawBorder(arg5, LayoutModifierNodeCoordinator.modifierBoundsPaint);
            }
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

    public final void setLayoutModifierNode$ui(LayoutModifierNode arg3) {
        if(!Intrinsics.areEqual(arg3, this.layoutModifierNode)) {
            if((arg3.getNode().getKindSet$ui() & NodeKind.constructor-impl(0x200)) != 0) {
                Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                LayoutModifierNode v0 = arg3;
                ApproachMeasureScopeImpl v1 = this.approachMeasureScope;
                if(v1 != null) {
                    v1.setApproachNode(((ApproachLayoutModifierNode)v0));
                }
                else {
                    v1 = new ApproachMeasureScopeImpl(this, ((ApproachLayoutModifierNode)v0));
                }

                this.approachMeasureScope = v1;
            }
            else {
                this.approachMeasureScope = null;
            }
        }

        this.layoutModifierNode = arg3;
    }

    public final void setLookaheadConstraints-_Sx5XlM$ui(Constraints arg1) {
        this.lookaheadConstraints = arg1;
    }

    protected void setLookaheadDelegate(LookaheadDelegate arg1) {
        this.lookaheadDelegate = arg1;
    }
}

