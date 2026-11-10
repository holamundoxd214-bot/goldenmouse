package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u001D\u0010\u0003\u001A\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nR1\u0010\u0003\u001A\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/AddTextContextMenuDataComponentsWithContextNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "builder", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "Landroid/content/Context;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getBuilder", "()Lkotlin/jvm/functions/Function2;", "setBuilder", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AddTextContextMenuDataComponentsWithContextNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    private Function2 builder;

    public AddTextContextMenuDataComponentsWithContextNode(Function2 arg2) {
        super();
        this.builder = arg2;
        this.delegate(new AddTextContextMenuDataComponentsNode(new AddTextContextMenuDataComponentsWithContextNode$$ExternalSyntheticLambda0(this)));
    }

    static final Unit _init_$lambda$0(AddTextContextMenuDataComponentsWithContextNode arg2, TextContextMenuBuilderScope arg3) {
        arg2.builder.invoke(arg3, CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)arg2), AndroidCompositionLocals_androidKt.getLocalContext()));
        return Unit.INSTANCE;
    }

    public final Function2 getBuilder() {
        return this.builder;
    }

    public final void setBuilder(Function2 arg1) {
        this.builder = arg1;
    }
}

