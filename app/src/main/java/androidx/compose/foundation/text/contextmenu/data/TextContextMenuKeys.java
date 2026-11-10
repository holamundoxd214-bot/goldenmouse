package androidx.compose.foundation.text.contextmenu.data;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000E\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0006R\u0011\u0010\u000B\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u0006¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuKeys;", "", "<init>", "()V", "CutKey", "getCutKey", "()Ljava/lang/Object;", "CopyKey", "getCopyKey", "PasteKey", "getPasteKey", "SelectAllKey", "getSelectAllKey", "AutofillKey", "getAutofillKey", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuKeys {
    public static final int $stable;
    private static final Object AutofillKey;
    private static final Object CopyKey;
    private static final Object CutKey;
    public static final TextContextMenuKeys INSTANCE;
    private static final Object PasteKey;
    private static final Object SelectAllKey;

    static {
        TextContextMenuKeys.INSTANCE = new TextContextMenuKeys();
        TextContextMenuKeys.CutKey = new Object();
        TextContextMenuKeys.CopyKey = new Object();
        TextContextMenuKeys.PasteKey = new Object();
        TextContextMenuKeys.SelectAllKey = new Object();
        TextContextMenuKeys.AutofillKey = new Object();
        TextContextMenuKeys.$stable = 8;
    }

    private TextContextMenuKeys() {
        super();
    }

    public final Object getAutofillKey() {
        return TextContextMenuKeys.AutofillKey;
    }

    public final Object getCopyKey() {
        return TextContextMenuKeys.CopyKey;
    }

    public final Object getCutKey() {
        return TextContextMenuKeys.CutKey;
    }

    public final Object getPasteKey() {
        return TextContextMenuKeys.PasteKey;
    }

    public final Object getSelectAllKey() {
        return TextContextMenuKeys.SelectAllKey;
    }
}

