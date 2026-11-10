package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001A\u001E\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003\u001AQ\u0010\u000E\u001A\u00020\u0005*\u00020\u000F2\u001E\u0010\u0010\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\u00050\u00032#\u0010\u0011\u001A\u001F\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00050\u0003H\u0002\u001A\f\u0010\u0012\u001A\u00020\u0013*\u00020\u000FH\u0000\"\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"appendTextContextMenuComponents", "Landroidx/compose/ui/Modifier;", "builder", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "", "Lkotlin/ExtensionFunctionType;", "filterTextContextMenuComponents", "filter", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "", "continueTraversal", "wrongNodeTypeErrorMessage", "", "traverseTextContextMenuDataNodes", "Landroidx/compose/ui/node/DelegatableNode;", "filterBlock", "builderBlock", "collectTextContextMenuData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuModifierKt {
    private static final boolean continueTraversal = true;
    private static final String wrongNodeTypeErrorMessage = "TextContextMenuDataNode.TraverseKey key must only be attached to instances of TextContextMenuDataNode.";

    public static Unit $r8$lambda$LLriK-WEFE_LyCA-YjmXR_goM8k(TextContextMenuBuilderScope arg0, Function1 arg1) {
        return TextContextMenuModifierKt.collectTextContextMenuData$lambda$0$0(arg0, arg1);
    }

    public static final Modifier appendTextContextMenuComponents(Modifier arg1, Function1 arg2) {
        return arg1.then(new AddTextContextMenuDataComponentsElement(arg2));
    }

    public static final TextContextMenuData collectTextContextMenuData(DelegatableNode arg3) {
        TextContextMenuBuilderScope v0 = new TextContextMenuBuilderScope();
        TextContextMenuModifierKt.traverseTextContextMenuDataNodes(arg3, new TextContextMenuModifierKt$collectTextContextMenuData$1$1(v0), new TextContextMenuModifierKt$$ExternalSyntheticLambda1(v0));
        return v0.build$foundation();
    }

    private static final Unit collectTextContextMenuData$lambda$0$0(TextContextMenuBuilderScope arg0, Function1 arg1) {
        arg1.invoke(arg0);
        return Unit.INSTANCE;
    }

    public static final Modifier filterTextContextMenuComponents(Modifier arg1, Function1 arg2) {
        return arg1.then(new FilterTextContextMenuDataComponentsElement(arg2));
    }

    private static final void traverseTextContextMenuDataNodes(DelegatableNode arg2, Function1 arg3, Function1 arg4) {
        TraversableNodeKt.traverseAncestors(arg2, TextContextMenuDataTraverseKey.INSTANCE, new TextContextMenuModifierKt$$ExternalSyntheticLambda0(arg4, arg3));
    }

    static final boolean traverseTextContextMenuDataNodes$lambda$0(Function1 arg1, Function1 arg2, TraversableNode arg3) {
        if((arg3 instanceof AddTextContextMenuDataComponentsNode)) {
            arg1.invoke(((AddTextContextMenuDataComponentsNode)arg3).getBuilder());
        }
        else if((arg3 instanceof FilterTextContextMenuDataComponentsNode)) {
            arg2.invoke(((FilterTextContextMenuDataComponentsNode)arg3).getFilter());
        }
        else {
            goto label_11;
        }

        return 1;
    label_11:
        throw new IllegalStateException("TextContextMenuDataNode.TraverseKey key must only be attached to instances of TextContextMenuDataNode.");
    }
}

