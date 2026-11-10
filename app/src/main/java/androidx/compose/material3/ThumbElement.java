package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0012\u001A\u00020\u0002H\u0016J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\f\u0010\u0016\u001A\u00020\u0014*\u00020\u0017H\u0016J\t\u0010\u0018\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0006HÆ\u0003J\u000F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J-\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u00062\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EHÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2={"Landroidx/compose/material3/ThumbElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ThumbNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getChecked", "()Z", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ThumbElement extends ModifierNodeElement {
    private final FiniteAnimationSpec animationSpec;
    private final boolean checked;
    private final InteractionSource interactionSource;

    public ThumbElement(InteractionSource arg1, boolean arg2, FiniteAnimationSpec arg3) {
        super();
        this.interactionSource = arg1;
        this.checked = arg2;
        this.animationSpec = arg3;
    }

    public final InteractionSource component1() {
        return this.interactionSource;
    }

    public final boolean component2() {
        return this.checked;
    }

    public final FiniteAnimationSpec component3() {
        return this.animationSpec;
    }

    public final ThumbElement copy(InteractionSource arg1, boolean arg2, FiniteAnimationSpec arg3) {
        return new ThumbElement(arg1, arg2, arg3);
    }

    public static ThumbElement copy$default(ThumbElement arg0, InteractionSource arg1, boolean arg2, FiniteAnimationSpec arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.interactionSource;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.checked;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.animationSpec;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public ThumbNode create() {
        return new ThumbNode(this.interactionSource, this.checked, this.animationSpec);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ThumbElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ThumbElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((ThumbElement)arg5).interactionSource)) {
            return 0;
        }

        if(this.checked != ((ThumbElement)arg5).checked) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animationSpec, ((ThumbElement)arg5).animationSpec)) {
            return 0;
        }

        return 1;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public int hashCode() {
        return (this.interactionSource.hashCode() * 0x1F + Boolean.hashCode(this.checked)) * 0x1F + this.animationSpec.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("switchThumb");
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("checked", Boolean.valueOf(this.checked));
        arg4.getProperties().set("animationSpec", this.animationSpec);
    }

    public String toString() {
        return "ThumbElement(interactionSource=" + this.interactionSource + ", checked=" + this.checked + ", animationSpec=" + this.animationSpec + ')';
    }

    public void update(ThumbNode arg3) {
        arg3.setInteractionSource(this.interactionSource);
        if(arg3.getChecked() != this.checked) {
            LayoutModifierNodeKt.invalidateMeasurement(arg3);
        }

        arg3.setChecked(this.checked);
        arg3.setAnimationSpec(this.animationSpec);
        arg3.update();
    }

    public void update(Node arg1) {
        this.update(((ThumbNode)arg1));
    }
}

