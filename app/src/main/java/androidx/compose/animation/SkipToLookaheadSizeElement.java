package androidx.compose.animation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\f\u0010\u0011\u001A\u00020\u000F*\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00072\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0096\u0002R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\f¨\u0006\u0018"}, d2={"Landroidx/compose/animation/SkipToLookaheadSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SkipToLookaheadSizeNode;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "()Lkotlin/jvm/functions/Function0;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SkipToLookaheadSizeElement extends ModifierNodeElement {
    public static final int $stable;
    private final Function0 isEnabled;
    private final ScaleToBoundsImpl scaleToBounds;

    static {
    }

    public SkipToLookaheadSizeElement(ScaleToBoundsImpl arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        if((arg3 & 2) != 0) {
            arg2 = SkipToLookaheadSizeNodeKt.access$getDefaultEnabled$p();
        }

        this(arg1, arg2);
    }

    public SkipToLookaheadSizeElement() {
        this(null, null, 3, null);
    }

    public SkipToLookaheadSizeElement(ScaleToBoundsImpl arg1, Function0 arg2) {
        super();
        this.scaleToBounds = arg1;
        this.isEnabled = arg2;
    }

    public SkipToLookaheadSizeNode create() {
        return new SkipToLookaheadSizeNode(this.scaleToBounds, this.isEnabled);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof SkipToLookaheadSizeElement)) && ((SkipToLookaheadSizeElement)arg3).isEnabled == this.isEnabled && (Intrinsics.areEqual(((SkipToLookaheadSizeElement)arg3).scaleToBounds, this.scaleToBounds))) {
            return 1;
        }

        return 0;
    }

    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds;
    }

    public int hashCode() {
        int v0 = this.isEnabled.hashCode() * 0x1F;
        ScaleToBoundsImpl v1 = this.scaleToBounds;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return v0 + v1_1;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("skipToLookahead");
        arg4.getProperties().set("scaleToBounds", this.scaleToBounds);
        arg4.getProperties().set("isEnabled", this.isEnabled);
    }

    public final Function0 isEnabled() {
        return this.isEnabled;
    }

    public void update(SkipToLookaheadSizeNode arg2) {
        arg2.setScaleToBounds(this.scaleToBounds);
        arg2.setEnabled(this.isEnabled);
    }

    public void update(Node arg1) {
        this.update(((SkipToLookaheadSizeNode)arg1));
    }
}

