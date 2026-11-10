package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u000E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\f\u0010\u000F\u001A\u00020\r*\u00020\u0010H\u0016J\u0011\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÂ\u0003J\u0011\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÂ\u0003J\u0011\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÂ\u0003J?\u0010\u0014\u001A\u00020\u00002\u0010\b\u0002\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0016\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "<init>", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutAnimateItemElement extends ModifierNodeElement {
    public static final int $stable;
    private final FiniteAnimationSpec fadeInSpec;
    private final FiniteAnimationSpec fadeOutSpec;
    private final FiniteAnimationSpec placementSpec;

    static {
    }

    public LazyLayoutAnimateItemElement(FiniteAnimationSpec arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3) {
        super();
        this.fadeInSpec = arg1;
        this.placementSpec = arg2;
        this.fadeOutSpec = arg3;
    }

    private final FiniteAnimationSpec component1() {
        return this.fadeInSpec;
    }

    private final FiniteAnimationSpec component2() {
        return this.placementSpec;
    }

    private final FiniteAnimationSpec component3() {
        return this.fadeOutSpec;
    }

    public final LazyLayoutAnimateItemElement copy(FiniteAnimationSpec arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3) {
        return new LazyLayoutAnimateItemElement(arg1, arg2, arg3);
    }

    public static LazyLayoutAnimateItemElement copy$default(LazyLayoutAnimateItemElement arg0, FiniteAnimationSpec arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.fadeInSpec;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.placementSpec;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.fadeOutSpec;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public LazyLayoutAnimationSpecsNode create() {
        return new LazyLayoutAnimationSpecsNode(this.fadeInSpec, this.placementSpec, this.fadeOutSpec);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((LazyLayoutAnimateItemElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LazyLayoutAnimateItemElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fadeInSpec, ((LazyLayoutAnimateItemElement)arg5).fadeInSpec)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.placementSpec, ((LazyLayoutAnimateItemElement)arg5).placementSpec)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fadeOutSpec, ((LazyLayoutAnimateItemElement)arg5).fadeOutSpec)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        FiniteAnimationSpec v0 = this.fadeInSpec;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        FiniteAnimationSpec v2 = this.placementSpec;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        FiniteAnimationSpec v3 = this.fadeOutSpec;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("animateItem");
        arg4.getProperties().set("fadeInSpec", this.fadeInSpec);
        arg4.getProperties().set("placementSpec", this.placementSpec);
        arg4.getProperties().set("fadeOutSpec", this.fadeOutSpec);
    }

    public String toString() {
        return "LazyLayoutAnimateItemElement(fadeInSpec=" + this.fadeInSpec + ", placementSpec=" + this.placementSpec + ", fadeOutSpec=" + this.fadeOutSpec + ')';
    }

    public void update(LazyLayoutAnimationSpecsNode arg2) {
        arg2.setFadeInSpec(this.fadeInSpec);
        arg2.setPlacementSpec(this.placementSpec);
        arg2.setFadeOutSpec(this.fadeOutSpec);
    }

    public void update(Node arg1) {
        this.update(((LazyLayoutAnimationSpecsNode)arg1));
    }
}

