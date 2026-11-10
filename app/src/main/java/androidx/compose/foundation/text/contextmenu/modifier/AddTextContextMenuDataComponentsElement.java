package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001A\u00020\u0002H\u0016J\u0010\u0010\u000B\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u0006*\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u001F\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsNode;", "builder", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AddTextContextMenuDataComponentsElement extends ModifierNodeElement {
    private final Function1 builder;

    public AddTextContextMenuDataComponentsElement(Function1 arg1) {
        super();
        this.builder = arg1;
    }

    public AddTextContextMenuDataComponentsNode create() {
        return new AddTextContextMenuDataComponentsNode(this.builder);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((AddTextContextMenuDataComponentsElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AddTextContextMenuDataComponentsElement)) {
            return 0;
        }

        if(this.builder != ((AddTextContextMenuDataComponentsElement)arg4).builder) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("addTextContextMenuDataComponents");
        arg2.getProperties().set("builder", this.builder);
    }

    public void update(AddTextContextMenuDataComponentsNode arg1) {
        arg1.setBuilder(this.builder);
    }

    public void update(Node arg1) {
        this.update(((AddTextContextMenuDataComponentsNode)arg1));
    }
}

