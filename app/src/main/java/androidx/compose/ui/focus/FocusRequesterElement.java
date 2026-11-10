package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\t\u0010\u000F\u001A\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/ui/focus/FocusRequesterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusRequesterNode;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusRequesterElement extends ModifierNodeElement {
    private final FocusRequester focusRequester;

    public FocusRequesterElement(FocusRequester arg1) {
        super();
        this.focusRequester = arg1;
    }

    public final FocusRequester component1() {
        return this.focusRequester;
    }

    public final FocusRequesterElement copy(FocusRequester arg1) {
        return new FocusRequesterElement(arg1);
    }

    public static FocusRequesterElement copy$default(FocusRequesterElement arg0, FocusRequester arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.focusRequester;
        }

        return arg0.copy(arg1);
    }

    public Node create() {
        return this.create();
    }

    public FocusRequesterNode create() {
        return new FocusRequesterNode(this.focusRequester);
    }

    public boolean equals(Object arg4) {
        if(this == (((FocusRequesterElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FocusRequesterElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.focusRequester, ((FocusRequesterElement)arg4).focusRequester)) {
            return 0;
        }

        return 1;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public int hashCode() {
        return this.focusRequester.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("focusRequester");
        arg2.getProperties().set("focusRequester", this.focusRequester);
    }

    public String toString() {
        return "FocusRequesterElement(focusRequester=" + this.focusRequester + ')';
    }

    public void update(Node arg1) {
        this.update(((FocusRequesterNode)arg1));
    }

    public void update(FocusRequesterNode arg2) {
        arg2.getFocusRequester().getFocusRequesterNodes$ui().remove(arg2);
        arg2.setFocusRequester(this.focusRequester);
        arg2.getFocusRequester().getFocusRequesterNodes$ui().add(arg2);
    }
}

