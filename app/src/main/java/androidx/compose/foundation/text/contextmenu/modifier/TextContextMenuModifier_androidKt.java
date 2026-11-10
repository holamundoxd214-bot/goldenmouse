package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A+\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u001D\u0010\u0002\u001A\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007H\u0000¨\u0006\b"}, d2={"addTextContextMenuComponentsWithContext", "Landroidx/compose/ui/Modifier;", "builder", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "Landroid/content/Context;", "", "Lkotlin/ExtensionFunctionType;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuModifier_androidKt {
    public static final Modifier addTextContextMenuComponentsWithContext(Modifier arg1, Function2 arg2) {
        return arg1.then(new AddTextContextMenuDataComponentsWithContextElement(arg2));
    }
}

