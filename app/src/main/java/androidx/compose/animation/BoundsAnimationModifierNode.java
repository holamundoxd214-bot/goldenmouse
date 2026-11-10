package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u00126\u0010\u0007\u001A2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\b\u0010*\u001A\u00020+H\u0016J\u0014\u0010,\u001A\u00020\u0010*\u00020-2\u0006\u0010.\u001A\u00020/H\u0016J#\u00100\u001A\u000201*\u0002022\u0006\u00103\u001A\u0002042\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b5\u00106R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001ARJ\u0010\u0007\u001A2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\r0\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u000E\u0010#\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2={"Landroidx/compose/animation/BoundsAnimationModifierNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "onChooseMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "setLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "getOnChooseMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "setOnChooseMeasureConstraints", "(Lkotlin/jvm/functions/Function2;)V", "getAnimateMotionFrameOfReference", "()Z", "setAnimateMotionFrameOfReference", "(Z)V", "directManipulationParentsDirty", "boundsAnimation", "Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "isMeasurementApproachInProgress", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BoundsAnimationModifierNode extends Node implements ApproachLayoutModifierNode {
    public static final int $stable = 8;
    private boolean animateMotionFrameOfReference;
    private final BoundsTransformDeferredAnimation boundsAnimation;
    private BoundsTransform boundsTransform;
    private boolean directManipulationParentsDirty;
    private LookaheadScope lookaheadScope;
    private Function2 onChooseMeasureConstraints;

    static {
    }

    public BoundsAnimationModifierNode(LookaheadScope arg1, BoundsTransform arg2, Function2 arg3, boolean arg4) {
        super();
        this.lookaheadScope = arg1;
        this.boundsTransform = arg2;
        this.onChooseMeasureConstraints = arg3;
        this.animateMotionFrameOfReference = arg4;
        this.directManipulationParentsDirty = true;
        this.boundsAnimation = new BoundsTransformDeferredAnimation();
    }

    public static final BoundsTransformDeferredAnimation access$getBoundsAnimation$p(BoundsAnimationModifierNode arg0) {
        return arg0.boundsAnimation;
    }

    public MeasureResult approachMeasure-3p2s80s(ApproachMeasureScope arg10, Measurable arg11, long arg12) {
        long v0 = this.boundsAnimation.getCurrentSize-NH-jbRc() == 0x7FC000007FC00000L ? IntSizeKt.toSize-ozmzZPI(arg10.getLookaheadSize-YbymL2g()) : this.boundsAnimation.getCurrentSize-NH-jbRc();
        Rect v2 = this.boundsAnimation.getValue();
        if(v2 != null) {
            v0 = v2.getSize-NH-jbRc();
        }

        v0 = IntSizeKt.roundToIntSize-uvyYCjk(v0);
        arg12 = this.onChooseMeasureConstraints.invoke(IntSize.box-impl(v0), Constraints.box-impl(arg12)).unbox-impl();
        Placeable v11 = arg11.measure-BRTryo0(arg12);
        arg12 = ConstraintsKt.constrain-4WqzIAM(arg12, v0);
        return MeasureScope.layout$default(arg10, ((int)(arg12 >> 0x20)), ((int)(arg12 & 0xFFFFFFFFL)), null, new BoundsAnimationModifierNode$approachMeasure$1(this, v11), 4, null);
    }

    public final boolean getAnimateMotionFrameOfReference() {
        return this.animateMotionFrameOfReference;
    }

    public final BoundsTransform getBoundsTransform() {
        return this.boundsTransform;
    }

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public final Function2 getOnChooseMeasureConstraints() {
        return this.onChooseMeasureConstraints;
    }

    public boolean isMeasurementApproachInProgress-ozmzZPI(long arg2) {
        this.boundsAnimation.updateTargetSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(arg2));
        return this.boundsAnimation.isIdle() ^ 1;
    }

    public boolean isPlacementApproachInProgress(PlacementScope arg8, LayoutCoordinates arg9) {
        this.boundsAnimation.updateTargetOffsetAndAnimate(this.lookaheadScope, arg8, this.getCoroutineScope(), this.directManipulationParentsDirty, this.animateMotionFrameOfReference, this.boundsTransform);
        this.directManipulationParentsDirty = this.animateMotionFrameOfReference;
        return this.boundsAnimation.isIdle() ^ 1;
    }

    public void onAttach() {
        this.directManipulationParentsDirty = true;
    }

    public final void setAnimateMotionFrameOfReference(boolean arg1) {
        this.animateMotionFrameOfReference = arg1;
    }

    public final void setBoundsTransform(BoundsTransform arg1) {
        this.boundsTransform = arg1;
    }

    public final void setLookaheadScope(LookaheadScope arg1) {
        this.lookaheadScope = arg1;
    }

    public final void setOnChooseMeasureConstraints(Function2 arg1) {
        this.onChooseMeasureConstraints = arg1;
    }
}

