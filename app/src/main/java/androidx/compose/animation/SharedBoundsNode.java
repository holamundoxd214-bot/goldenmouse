package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u000F\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0010\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001A\u00020\fH\u0016J\b\u0010\u001F\u001A\u00020\u0013H\u0002J\b\u00100\u001A\u000201H\u0002J\b\u00102\u001A\u000201H\u0016J\b\u00103\u001A\u000201H\u0016J\b\u00104\u001A\u000201H\u0016J#\u00105\u001A\u000206*\u0002072\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u001C\u0010>\u001A\u000201*\u00020?2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020\fH\u0002J)\u0010C\u001A\u000201*\u00020?2\u0006\u0010@\u001A\u00020A2\u0006\u0010D\u001A\u00020E2\u0006\u0010B\u001A\u00020\fH\u0000¢\u0006\u0002\bFJ\u0014\u0010G\u001A\u000206*\u0002072\u0006\u0010@\u001A\u00020AH\u0002J\u0017\u0010H\u001A\u00020\u00172\u0006\u0010I\u001A\u00020JH\u0016¢\u0006\u0004\bK\u0010LJ#\u0010M\u001A\u000206*\u00020N2\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u00020;H\u0016¢\u0006\u0004\bO\u0010PJ\f\u0010Q\u001A\u000201*\u00020RH\u0016J\b\u0010S\u001A\u000201H\u0016R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0012\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0015R$\u0010\u001B\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\b@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\nR\u0014\u0010 \u001A\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\"\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\u001A\u001A\u0004\u0018\u00010$@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020)8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020-X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/¨\u0006T"}, d2={"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/animation/BoundsProvider;", "state", "Landroidx/compose/animation/SharedElementEntry;", "<init>", "(Landroidx/compose/animation/SharedElementEntry;)V", "boundsBeforeDetached", "Landroidx/compose/ui/geometry/Rect;", "lastBoundsInSharedTransitionScope", "getLastBoundsInSharedTransitionScope", "()Landroidx/compose/ui/geometry/Rect;", "calculateAlternativeTargetBounds", "targetBoundsBeforeDisposed", "approachCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getApproachCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "isPlaced", "", "rootCoords", "getRootCoords", "value", "sharedElementEntry", "getSharedElementEntry", "()Landroidx/compose/animation/SharedElementEntry;", "setSharedElementEntry$animation", "requireLookaheadLayoutCoordinates", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "setup", "", "onAttach", "onDetach", "onReset", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "approachPlaceMatchBeyondTransition", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "currentBounds", "approachPlaceMatchInTransition", "targetData", "Landroidx/compose/animation/TargetData;", "approachPlaceMatchInTransition$animation", "approachPlace", "isMeasurementApproachInProgress", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onObservedReadsChanged", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedBoundsNode extends Node implements BoundsProvider, ApproachLayoutModifierNode, ModifierLocalModifierNode, DrawModifierNode, ObserverModifierNode {
    public static final int $stable = 8;
    private Rect boundsBeforeDetached;
    private boolean isPlaced;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private SharedElementEntry sharedElementEntry;

    static {
    }

    public SharedBoundsNode(SharedElementEntry arg2) {
        super();
        this.sharedElementEntry = arg2;
        this.layer = arg2.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), arg2));
    }

    public static final void access$approachPlaceMatchBeyondTransition(SharedBoundsNode arg0, PlacementScope arg1, Placeable arg2, Rect arg3) {
        arg0.approachPlaceMatchBeyondTransition(arg1, arg2, arg3);
    }

    public static final SharedElement access$getSharedElement(SharedBoundsNode arg0) {
        return arg0.getSharedElement();
    }

    public static final void access$setBoundsBeforeDetached$p(SharedBoundsNode arg0, Rect arg1) {
        arg0.boundsBeforeDetached = arg1;
    }

    public static final void access$setPlaced$p(SharedBoundsNode arg0, boolean arg1) {
        arg0.isPlaced = arg1;
    }

    public MeasureResult approachMeasure-3p2s80s(ApproachMeasureScope arg4, Measurable arg5, long arg6) {
        Rect v0 = this.getBoundsAnimation().getValue();
        if(v0 == null) {
            v0 = this.getSharedElement().tryInitializingCurrentBounds();
        }

        if(v0 != null) {
            arg6 = IntSizeKt.roundToIntSize-uvyYCjk(v0.getSize-NH-jbRc());
            int v0_1 = ((int)(arg6 >> 0x20));
            int v6 = ((int)(arg6 & 0xFFFFFFFFL));
            int v7 = 0x7FFFFFFF;
            if(v0_1 != v7 && v6 != v7) {
                arg6 = Constraints.Companion.fixed-JhjzzOo(RangesKt.coerceAtLeast(v0_1, 0), RangesKt.coerceAtLeast(v6, 0));
                goto label_40;
            }

            throw new IllegalArgumentException("Error: Infinite width/height is invalid. animated bounds: " + this.getBoundsAnimation().getValue() + ", current bounds: " + this.getSharedElement().getState$animation().getCurrentBounds().toString());
        }

    label_40:
        return this.approachPlace(((MeasureScope)arg4), arg5.measure-BRTryo0(arg6));
    }

    private final MeasureResult approachPlace(MeasureScope arg17, Placeable arg18) {
        SharedBoundsNode v0 = this;
        long v2 = 0xFFFFFFFFL;
        int v4 = 0x20;
        long v5 = v0.getSharedElement().getState$animation().getMatchIsOrHasBeenConfigured() ? v0.sharedElementEntry.getPlaceholderSize().calculateSize-JyjRU_E(v0.requireLookaheadLayoutCoordinates().getSize-YbymL2g(), IntSize.constructor-impl((((long)arg18.getHeight())) & v2 | (((long)arg18.getWidth())) << v4)) : IntSize.constructor-impl((((long)arg18.getWidth())) << v4 | (((long)arg18.getHeight())) & v2);
        return MeasureScope.layout$default(arg17, ((int)(v5 >> v4)), ((int)(v5 & v2)), null, new SharedBoundsNode$approachPlace$1(v0, arg18), 4, null);
    }

    private final void approachPlaceMatchBeyondTransition(PlacementScope arg17, Placeable arg18, Rect arg19) {
        if(!this.getBoundsAnimation().getTarget()) {
            LayoutCoordinates v0 = arg17.getCoordinates();
            long v0_1 = v0 != null ? IntOffsetKt.round-k-4lQ0M(Offset.minus-MK-Hz9U(arg19.getTopLeft-F1C5BW0(), this.getRootCoords().localPositionOf-R5De75A(v0, Offset.Companion.getZero-F1C5BW0()))) : IntOffset.Companion.getZero-nOcc-ac();
            PlacementScope.place$default(arg17, arg18, IntOffset.getX-impl(v0_1), IntOffset.getY-impl(v0_1), 0f, 4, null);
            return;
        }

        PlacementScope.place$default(arg17, arg18, 0, 0, 0f, 4, null);
    }

    public final void approachPlaceMatchInTransition$animation(PlacementScope arg16, Placeable arg17, TargetData arg18, Rect arg19) {
        long v0_1;
        LayoutCoordinates v0 = arg16.getCoordinates();
        if(v0 == null) {
            PlacementScope.place$default(arg16, arg17, 0, 0, 0f, 4, null);
            return;
        }

        boolean v1 = this.getSharedElement().getState$animation().getActiveMatchFound();
        long v2 = this.getRootCoords().localPositionOf-R5De75A(v0, Offset.Companion.getZero-F1C5BW0());
        if(!v1) {
            this.getBoundsAnimation().animate(arg19, SharedTransitionStateMachineKt.getTargetBounds(arg18), new SharedBoundsNode$$ExternalSyntheticLambda0());
        }
        else {
            BoundsAnimation.animate$default(this.getBoundsAnimation(), arg19, SharedTransitionStateMachineKt.getTargetBounds(arg18), null, 4, null);
        }

        Rect v4 = this.getBoundsAnimation().getValue();
        Offset v5 = v4 != null ? Offset.box-impl(SharedTransitionStateMachineKt.calculateOffsetFromDirectManipulation(arg18, v4)) : null;
        if((this.getBoundsAnimation().getTarget()) || !v1) {
            long v6 = v5 != null ? v5.unbox-impl() : v2;
            Rect v0_2 = v5 == null ? RectKt.Rect-tz77jQw(v2, IntSizeKt.toSize-ozmzZPI(v0.getSize-YbymL2g())) : RectKt.Rect-tz77jQw(v5.unbox-impl(), v4.getSize-NH-jbRc());
            this.getSharedElement().getState$animation().updateBounds(v0_2);
            v0_1 = v6;
        }
        else if(v5 != null) {
            v0_1 = v5.unbox-impl();
        }
        else {
            v0_1 = arg19.getTopLeft-F1C5BW0();
        }

        v0_1 = Offset.minus-MK-Hz9U(v0_1, v2);
        PlacementScope.place$default(arg16, arg17, Math.round(Float.intBitsToFloat(((int)(v0_1 >> 0x20)))), Math.round(Float.intBitsToFloat(((int)(v0_1 & 0xFFFFFFFFL)))), 0f, 4, null);
    }

    static final FiniteAnimationSpec approachPlaceMatchInTransition$lambda$0(Rect arg2, Rect arg3) {
        return AnimationSpecKt.spring$default(0f, 0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);
    }

    public Rect calculateAlternativeTargetBounds(Rect arg1) {
        return this.sharedElementEntry.calculateTargetBounds(arg1);
    }

    public void draw(ContentDrawScope arg10) {
        Rect v0 = this.getSharedElement().getState$animation().getCurrentBounds();
        SharedElementEntry v1 = this.sharedElementEntry;
        Path v2 = !v1.getShouldRenderInOverlay$animation() || v0 == null ? null : this.sharedElementEntry.getOverlayClip().getClipPath(this.sharedElementEntry.getUserState(), v0, arg10.getLayoutDirection(), DelegatableNodeKt.requireDensity(this));
        v1.setClipPathInOverlay$animation(v2);
        GraphicsLayer v3 = this.sharedElementEntry.getLayer();
        if(v3 != null) {
            ContentDrawScope v2_1 = arg10;
            DrawScope.record-JVtK1S4$default(((DrawScope)v2_1), v3, 0, new SharedBoundsNode$draw$1(v0, this, arg10), 1, null);
            if(this.sharedElementEntry.getShouldRenderInPlace()) {
                GraphicsLayerKt.drawLayer(((DrawScope)v2_1), v3);
            }

            return;
        }

        throw new IllegalArgumentException("Error: Layer is null when accessed for shared bounds/element : " + this.getSharedElement().getKey() + ",target: " + this.sharedElementEntry.getBoundsAnimation().getTarget() + ", is attached: " + this.isAttached().toString());
    }

    private final LayoutCoordinates getApproachCoordinates() {
        return DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)this));
    }

    private final BoundsAnimation getBoundsAnimation() {
        return this.sharedElementEntry.getBoundsAnimation();
    }

    public Rect getLastBoundsInSharedTransitionScope() {
        if(!this.isAttached()) {
            return null;
        }

        if(!this.isPlaced) {
            return this.boundsBeforeDetached;
        }

        return RectKt.Rect-tz77jQw(LayoutCoordinates.localPositionOf-S_NoaFU$default(this.getRootCoords(), this.getApproachCoordinates(), 0, false, 6, null), IntSizeKt.toSize-ozmzZPI(this.getApproachCoordinates().getSize-YbymL2g()));
    }

    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    private final LayoutCoordinates getRootCoords() {
        return this.getSharedElement().getScope().getRoot$animation();
    }

    private final SharedElement getSharedElement() {
        return this.sharedElementEntry.getSharedElement();
    }

    public final SharedElementEntry getSharedElementEntry() {
        return this.sharedElementEntry;
    }

    public boolean isMeasurementApproachInProgress-ozmzZPI(long arg1) {
        if((this.sharedElementEntry.isEnabled()) && (this.getSharedElement().getFoundMatch()) && (this.getSharedElement().getScope().isTransitionActive())) {
            return 1;
        }

        return 0;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new SharedBoundsNode$measure$1(v9, this), 4, null);
    }

    public void onAttach() {
        super.onAttach();
        ObserverModifierNodeKt.observeReads(this, this.getSharedElement().getObservingVisibilityChange$animation());
        this.setup();
        this.sharedElementEntry.setAttached(true);
    }

    public void onDetach() {
        super.onDetach();
        LayoutCoordinates v0 = this.getSharedElement().getScope().getNullableRoot$animation();
        GraphicsLayer v1 = null;
        if(v0 != null) {
            Rect v0_1 = !v0.isAttached() || !this.isPlaced ? ((Rect)v1) : RectKt.Rect-tz77jQw(Offset.minus-MK-Hz9U(LayoutCoordinatesKt.positionInRoot(this.getApproachCoordinates()), LayoutCoordinatesKt.positionInRoot(v0)), IntSizeKt.toSize-ozmzZPI(this.getApproachCoordinates().getSize-YbymL2g()));
            this.boundsBeforeDetached = v0_1;
        }

        this.setLayer(v1);
        this.sharedElementEntry.setParentState(((SharedElementEntry)v1));
        this.sharedElementEntry.setBoundsProvider(((BoundsProvider)v1));
        this.sharedElementEntry.setAttached(false);
        this.isPlaced = false;
    }

    public void onObservedReadsChanged() {
        this.getSharedElement().updateMatch$animation();
        ObserverModifierNodeKt.observeReads(this, this.getSharedElement().getObservingVisibilityChange$animation());
    }

    public void onReset() {
        super.onReset();
        this.boundsBeforeDetached = null;
        GraphicsLayer v0 = this.layer;
        if(v0 != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(v0);
        }

        this.setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
    }

    private final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        return this.sharedElementEntry.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)this)));
    }

    private final void setLayer(GraphicsLayer arg3) {
        if(arg3 == null) {
            GraphicsLayer v0 = this.layer;
            if(v0 != null) {
                DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(v0);
            }
        }
        else {
            this.sharedElementEntry.setLayer(arg3);
        }

        this.layer = arg3;
    }

    public final void setSharedElementEntry$animation(SharedElementEntry arg3) {
        if(!Intrinsics.areEqual(arg3, this.sharedElementEntry)) {
            this.sharedElementEntry.setAttached(false);
            this.sharedElementEntry = arg3;
            arg3.setAttached(this.isAttached());
            if(this.isAttached()) {
                this.setup();
            }
        }
    }

    private final void setup() {
        this.provide(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.sharedElementEntry);
        this.sharedElementEntry.setParentState(this.getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        this.setLayer(DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.isPlaced = false;
        this.sharedElementEntry.setBoundsProvider(((BoundsProvider)this));
    }
}

