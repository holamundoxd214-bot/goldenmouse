package androidx.compose.foundation.text.contextmenu.data;

import android.view.textclassifier.TextClassification;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuTextClassificationItem;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "key", "", "textClassification", "Landroid/view/textclassifier/TextClassification;", "index", "", "<init>", "(Ljava/lang/Object;Landroid/view/textclassifier/TextClassification;I)V", "getTextClassification", "()Landroid/view/textclassifier/TextClassification;", "getIndex", "()I", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuTextClassificationItem extends TextContextMenuComponent {
    public static final int $stable = 8;
    private final int index;
    private final TextClassification textClassification;

    static {
    }

    public TextContextMenuTextClassificationItem(Object arg1, TextClassification arg2, int arg3) {
        super(arg1);
        this.textClassification = arg2;
        this.index = arg3;
    }

    public final int getIndex() {
        return this.index;
    }

    public final TextClassification getTextClassification() {
        return this.textClassification;
    }

    public String toString() {
        return "TextContextMenuRemoteActionItem(key=" + this.getKey() + ", textClassification=" + this.textClassification + ", index=" + this.index + ')';
    }
}

