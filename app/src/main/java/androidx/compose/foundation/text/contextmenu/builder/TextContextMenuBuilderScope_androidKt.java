package androidx.compose.foundation.text.contextmenu.builder;

import android.view.textclassifier.TextClassification;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A=\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\b\u0003\u0010\u0007\u001A\u00020\b2\u0017\u0010\t\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f\u001A$\u0010\r\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\bH\u0000¨\u0006\u0011"}, d2={"item", "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "key", "", "label", "", "leadingIcon", "", "onClick", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ExtensionFunctionType;", "textClassificationItem", "textClassification", "Landroid/view/textclassifier/TextClassification;", "index", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuBuilderScope_androidKt {
    public static final void item(TextContextMenuBuilderScope arg1, Object arg2, String arg3, int arg4, Function1 arg5) {
        arg1.addComponent$foundation(new TextContextMenuItem(arg2, arg3, arg4, arg5));
    }

    public static void item$default(TextContextMenuBuilderScope arg0, Object arg1, String arg2, int arg3, Function1 arg4, int arg5, Object arg6) {
        TextContextMenuBuilderScope_androidKt.item(arg0, arg1, arg2, 0, arg4);
    }

    public static final void textClassificationItem(TextContextMenuBuilderScope arg1, Object arg2, TextClassification arg3, int arg4) {
        arg1.addComponent$foundation(new TextContextMenuTextClassificationItem(arg2, arg3, arg4));
    }
}

