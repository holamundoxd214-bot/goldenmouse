package androidx.compose.foundation.text.contextmenu.modifier;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0007\u001A\u00020\bHÖ\u0001J\t\u0010\t\u001A\u00020\nHÖ\u0001¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuDataTraverseKey;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextContextMenuDataTraverseKey {
    public static final TextContextMenuDataTraverseKey INSTANCE;

    static {
        TextContextMenuDataTraverseKey.INSTANCE = new TextContextMenuDataTraverseKey();
    }

    private TextContextMenuDataTraverseKey() {
        super();
    }

    public boolean equals(Object arg2) {
        if(this == (((TextContextMenuDataTraverseKey)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof TextContextMenuDataTraverseKey)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return 0xCCD80C72;
    }

    public String toString() {
        return "TextContextMenuDataTraverseKey";
    }
}

