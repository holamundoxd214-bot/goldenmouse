package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B&\u0012\u001D\u0010\u0003\u001A\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0002H\u0016J\f\u0010\u000E\u001A\u00020\u0007*\u00020\u000FH\u0016J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016R%\u0010\u0003\u001A\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsWithContextElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsWithContextNode;", "builder", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "Landroid/content/Context;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AddTextContextMenuDataComponentsWithContextElement extends ModifierNodeElement {
    private final Function2 builder;

    public AddTextContextMenuDataComponentsWithContextElement(Function2 arg1) {
        super();
        this.builder = arg1;
    }

    public AddTextContextMenuDataComponentsWithContextNode create() {
        return new AddTextContextMenuDataComponentsWithContextNode(this.builder);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((AddTextContextMenuDataComponentsWithContextElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AddTextContextMenuDataComponentsWithContextElement)) {
            return 0;
        }

        if(this.builder != ((AddTextContextMenuDataComponentsWithContextElement)arg4).builder) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("addTextContextMenuDataComponentsWithResources");
        arg2.getProperties().set("builder", this.builder);
    }

    public void update(AddTextContextMenuDataComponentsWithContextNode arg1) {
        arg1.setBuilder(this.builder);
    }

    public void update(Node arg1) {
        this.update(((AddTextContextMenuDataComponentsWithContextNode)arg1));
    }
}

