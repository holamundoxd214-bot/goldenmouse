package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u00128\u0010\b\u001A4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\t¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\f\u0010\u001A\u001A\u00020\u000E*\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014RC\u0010\b\u001A4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Landroidx/compose/animation/SizeAnimationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SizeAnimationModifierNode;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "alignment", "Landroidx/compose/ui/Alignment;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "<init>", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getFinishedListener", "()Lkotlin/jvm/functions/Function2;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeAnimationModifierElement extends ModifierNodeElement {
    private final Alignment alignment;
    private final FiniteAnimationSpec animationSpec;
    private final Function2 finishedListener;

    public SizeAnimationModifierElement(FiniteAnimationSpec arg1, Alignment arg2, Function2 arg3) {
        super();
        this.animationSpec = arg1;
        this.alignment = arg2;
        this.finishedListener = arg3;
    }

    public SizeAnimationModifierNode create() {
        return new SizeAnimationModifierNode(this.animationSpec, this.alignment, this.finishedListener);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof SizeAnimationModifierElement)) && (Intrinsics.areEqual(((SizeAnimationModifierElement)arg3).animationSpec, this.animationSpec)) && ((SizeAnimationModifierElement)arg3).finishedListener == this.finishedListener && (Intrinsics.areEqual(((SizeAnimationModifierElement)arg3).alignment, this.alignment))) {
            return 1;
        }

        return 0;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function2 getFinishedListener() {
        return this.finishedListener;
    }

    public int hashCode() {
        int v0 = (this.animationSpec.hashCode() * 0x1F + this.alignment.hashCode()) * 0x1F;
        Function2 v2 = this.finishedListener;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("animateContentSize");
        arg4.getProperties().set("animationSpec", this.animationSpec);
        arg4.getProperties().set("alignment", this.alignment);
        arg4.getProperties().set("finishedListener", this.finishedListener);
    }

    public void update(SizeAnimationModifierNode arg2) {
        arg2.setAnimationSpec(this.animationSpec);
        arg2.setListener(this.finishedListener);
        arg2.setAlignment(this.alignment);
    }

    public void update(Node arg1) {
        this.update(((SizeAnimationModifierNode)arg1));
    }
}

