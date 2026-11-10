package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\f\u0010\u0010\u001A\u00020\u0006*\u00020\u0005H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002R\u001F\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/layout/SystemInsetsPaddingModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SystemInsetsPaddingModifierNode;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsGetter", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "create", "update", "node", "inspectableProperties", "hashCode", "", "equals", "", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class SystemInsetsPaddingModifierElement extends ModifierNodeElement {
    private final Function1 insetsGetter;
    private final Function1 inspectorInfo;

    public SystemInsetsPaddingModifierElement(Function1 arg1, Function1 arg2) {
        super();
        this.inspectorInfo = arg1;
        this.insetsGetter = arg2;
    }

    public SystemInsetsPaddingModifierNode create() {
        return new SystemInsetsPaddingModifierNode(this.insetsGetter);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((SystemInsetsPaddingModifierElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof SystemInsetsPaddingModifierElement)) {
            return 0;
        }

        if(this.insetsGetter == ((SystemInsetsPaddingModifierElement)arg4).insetsGetter) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.insetsGetter.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(SystemInsetsPaddingModifierNode arg1) {
        arg1.update(this.insetsGetter);
    }

    public void update(Node arg1) {
        this.update(((SystemInsetsPaddingModifierNode)arg1));
    }
}

