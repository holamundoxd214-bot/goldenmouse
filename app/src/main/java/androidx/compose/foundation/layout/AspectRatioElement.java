package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001A\u00020\u0002H\u0016J\u0010\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0002H\u0016J\f\u0010\u0017\u001A\u00020\n*\u00020\tH\u0016J\u0013\u0010\u0018\u001A\u00020\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/layout/AspectRatioElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AspectRatioNode;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "equals", "other", "", "hashCode", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AspectRatioElement extends ModifierNodeElement {
    private final float aspectRatio;
    private final Function1 inspectorInfo;
    private final boolean matchHeightConstraintsFirst;

    public AspectRatioElement(float arg1, boolean arg2, Function1 arg3) {
        super();
        this.aspectRatio = arg1;
        this.matchHeightConstraintsFirst = arg2;
        this.inspectorInfo = arg3;
        int v0 = arg1 > 0f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("aspectRatio " + arg1 + " must be > 0");
        }
    }

    public AspectRatioNode create() {
        return new AspectRatioNode(this.aspectRatio, this.matchHeightConstraintsFirst);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((AspectRatioElement)arg5))) {
            return 1;
        }

        Object v1 = (arg5 instanceof AspectRatioElement) ? arg5 : null;
        if(v1 == null) {
            return 0;
        }

        if(this.aspectRatio == ((AspectRatioElement)v1).aspectRatio && this.matchHeightConstraintsFirst == ((AspectRatioElement)arg5).matchHeightConstraintsFirst) {
            return 1;
        }

        return 0;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return Float.hashCode(this.aspectRatio) * 0x1F + Boolean.hashCode(this.matchHeightConstraintsFirst);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(AspectRatioNode arg2) {
        arg2.setAspectRatio(this.aspectRatio);
        arg2.setMatchHeightConstraintsFirst(this.matchHeightConstraintsFirst);
    }

    public void update(Node arg1) {
        this.update(((AspectRatioNode)arg1));
    }
}

