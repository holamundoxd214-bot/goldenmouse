package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B(\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0010\u001A\u00020\u0002H\u0016J\u0010\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u0002H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\f\u0010\u0019\u001A\u00020\b*\u00020\u0007H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\"\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/layout/PaddingValuesElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingValuesModifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class PaddingValuesElement extends ModifierNodeElement {
    private final Function1 inspectorInfo;
    private final PaddingValues paddingValues;

    public PaddingValuesElement(PaddingValues arg1, Function1 arg2) {
        super();
        this.paddingValues = arg1;
        this.inspectorInfo = arg2;
    }

    public PaddingValuesModifier create() {
        return new PaddingValuesModifier(this.paddingValues);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        PaddingValuesElement v2;
        if((arg2 instanceof PaddingValuesElement)) {
        }
        else {
            v2 = null;
        }

        if(0 == 0) {
            return 0;
        }

        return Intrinsics.areEqual(this.paddingValues, v2.paddingValues);
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(PaddingValuesModifier arg1) {
        arg1.setPaddingValues(this.paddingValues);
    }

    public void update(Node arg1) {
        this.update(((PaddingValuesModifier)arg1));
    }
}

