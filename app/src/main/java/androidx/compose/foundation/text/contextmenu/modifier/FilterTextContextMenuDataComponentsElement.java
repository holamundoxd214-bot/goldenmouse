package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/FilterTextContextMenuDataComponentsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/contextmenu/modifier/FilterTextContextMenuDataComponentsNode;", "filter", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class FilterTextContextMenuDataComponentsElement extends ModifierNodeElement {
    private final Function1 filter;

    public FilterTextContextMenuDataComponentsElement(Function1 arg1) {
        super();
        this.filter = arg1;
    }

    public FilterTextContextMenuDataComponentsNode create() {
        return new FilterTextContextMenuDataComponentsNode(this.filter);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((FilterTextContextMenuDataComponentsElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof FilterTextContextMenuDataComponentsElement)) {
            return 0;
        }

        if(this.filter != ((FilterTextContextMenuDataComponentsElement)arg4).filter) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.filter.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("filterTextContextMenuDataComponents");
        arg2.getProperties().set("filter", this.filter);
    }

    public void update(FilterTextContextMenuDataComponentsNode arg1) {
        arg1.setFilter(this.filter);
    }

    public void update(Node arg1) {
        this.update(((FilterTextContextMenuDataComponentsNode)arg1));
    }
}

