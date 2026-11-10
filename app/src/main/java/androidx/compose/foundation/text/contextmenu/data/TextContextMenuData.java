package androidx.compose.foundation.text.contextmenu.data;

import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\nH\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "", "components", "", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuComponent;", "<init>", "(Ljava/util/List;)V", "getComponents", "()Ljava/util/List;", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextContextMenuData {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "getEmpty", "()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextContextMenuData getEmpty() {
            return TextContextMenuData.Empty;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TextContextMenuData Empty;
    private final List components;

    static {
        TextContextMenuData.Companion = new Companion(null);
        TextContextMenuData.$stable = 8;
        TextContextMenuData.Empty = new TextContextMenuData(CollectionsKt.emptyList());
    }

    public TextContextMenuData(List arg1) {
        super();
        this.components = arg1;
    }

    public static final TextContextMenuData access$getEmpty$cp() {
        return TextContextMenuData.Empty;
    }

    public final List getComponents() {
        return this.components;
    }

    public String toString() {
        return "TextContextMenuData(components=" + ListUtilsKt.fastJoinToString$default(this.components, "\n\t", "[\n\t", "\n]", 0, null, null, 56, null) + ')';
    }
}

