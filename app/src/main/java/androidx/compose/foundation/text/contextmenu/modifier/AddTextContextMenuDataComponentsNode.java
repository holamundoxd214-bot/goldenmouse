package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tR+\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "builder", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getBuilder", "()Lkotlin/jvm/functions/Function1;", "setBuilder", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AddTextContextMenuDataComponentsNode extends Node implements TraversableNode {
    public static final int $stable = 8;
    private Function1 builder;

    static {
    }

    public AddTextContextMenuDataComponentsNode(Function1 arg1) {
        super();
        this.builder = arg1;
    }

    public final Function1 getBuilder() {
        return this.builder;
    }

    public Object getTraverseKey() {
        return TextContextMenuDataTraverseKey.INSTANCE;
    }

    public final void setBuilder(Function1 arg1) {
        this.builder = arg1;
    }
}

