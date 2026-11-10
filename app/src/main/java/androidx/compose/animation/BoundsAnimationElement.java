package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u00126\u0010\u0007\u001A2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001B\u001A\u00020\u0002H\u0016J\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u0002H\u0016J\f\u0010\u001F\u001A\u00020\u001D*\u00020 H\u0016J\b\u0010!\u001A\u00020\"H\u0016J\u0013\u0010#\u001A\u00020\u00102\b\u0010$\u001A\u0004\u0018\u00010%H\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016RA\u0010\u0007\u001A2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001A¨\u0006&"}, d2={"Landroidx/compose/animation/BoundsAnimationElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/BoundsAnimationModifierNode;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "resolveMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "getResolveMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "getAnimateMotionFrameOfReference", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BoundsAnimationElement extends ModifierNodeElement {
    public static final int $stable;
    private final boolean animateMotionFrameOfReference;
    private final BoundsTransform boundsTransform;
    private final LookaheadScope lookaheadScope;
    private final Function2 resolveMeasureConstraints;

    static {
    }

    public BoundsAnimationElement(LookaheadScope arg1, BoundsTransform arg2, Function2 arg3, boolean arg4) {
        super();
        this.lookaheadScope = arg1;
        this.boundsTransform = arg2;
        this.resolveMeasureConstraints = arg3;
        this.animateMotionFrameOfReference = arg4;
    }

    public BoundsAnimationModifierNode create() {
        return new BoundsAnimationModifierNode(this.lookaheadScope, this.boundsTransform, this.resolveMeasureConstraints, this.animateMotionFrameOfReference);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof BoundsAnimationElement)) && (Intrinsics.areEqual(((BoundsAnimationElement)arg3).lookaheadScope, this.lookaheadScope)) && (Intrinsics.areEqual(((BoundsAnimationElement)arg3).boundsTransform, this.boundsTransform)) && ((BoundsAnimationElement)arg3).resolveMeasureConstraints == this.resolveMeasureConstraints && ((BoundsAnimationElement)arg3).animateMotionFrameOfReference == this.animateMotionFrameOfReference) {
            return 1;
        }

        return 0;
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

    public final Function2 getResolveMeasureConstraints() {
        return this.resolveMeasureConstraints;
    }

    public int hashCode() {
        return ((this.lookaheadScope.hashCode() * 0x1F + this.boundsTransform.hashCode()) * 0x1F + this.resolveMeasureConstraints.hashCode()) * 0x1F + Boolean.hashCode(this.animateMotionFrameOfReference);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("boundsAnimation");
        arg4.getProperties().set("lookaheadScope", this.lookaheadScope);
        arg4.getProperties().set("boundsTransform", this.boundsTransform);
        arg4.getProperties().set("onChooseMeasureConstraints", this.resolveMeasureConstraints);
        arg4.getProperties().set("animateMotionFrameOfReference", Boolean.valueOf(this.animateMotionFrameOfReference));
    }

    public void update(BoundsAnimationModifierNode arg2) {
        arg2.setLookaheadScope(this.lookaheadScope);
        arg2.setBoundsTransform(this.boundsTransform);
        arg2.setOnChooseMeasureConstraints(this.resolveMeasureConstraints);
        arg2.setAnimateMotionFrameOfReference(this.animateMotionFrameOfReference);
    }

    public void update(Node arg1) {
        this.update(((BoundsAnimationModifierNode)arg1));
    }
}

