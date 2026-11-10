package androidx.compose.foundation.text;

import androidx.compose.ui.text.Placeholder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR$\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/InlineTextContent;", "", "placeholder", "Landroidx/compose/ui/text/Placeholder;", "children", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "<init>", "(Landroidx/compose/ui/text/Placeholder;Lkotlin/jvm/functions/Function3;)V", "getPlaceholder", "()Landroidx/compose/ui/text/Placeholder;", "getChildren", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InlineTextContent {
    public static final int $stable;
    private final Function3 children;
    private final Placeholder placeholder;

    static {
    }

    public InlineTextContent(Placeholder arg1, Function3 arg2) {
        super();
        this.placeholder = arg1;
        this.children = arg2;
    }

    public final Function3 getChildren() {
        return this.children;
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }
}

