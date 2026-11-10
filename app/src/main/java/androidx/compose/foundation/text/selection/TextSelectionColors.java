package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\n\u0010\b¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/text/selection/TextSelectionColors;", "", "handleColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHandleColor-0d7_KjU", "()J", "J", "getBackgroundColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextSelectionColors {
    public static final int $stable;
    private final long backgroundColor;
    private final long handleColor;

    static {
    }

    private TextSelectionColors(long arg1, long arg3) {
        super();
        this.handleColor = arg1;
        this.backgroundColor = arg3;
    }

    public TextSelectionColors(long arg1, long arg3, DefaultConstructorMarker arg5) {
        this(arg1, arg3);
    }

    public boolean equals(Object arg8) {
        if(this == (((TextSelectionColors)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TextSelectionColors)) {
            return 0;
        }

        if(!Color.equals-impl0(this.handleColor, ((TextSelectionColors)arg8).handleColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.backgroundColor, ((TextSelectionColors)arg8).backgroundColor)) {
            return 0;
        }

        return 1;
    }

    public final long getBackgroundColor-0d7_KjU() {
        return this.backgroundColor;
    }

    public final long getHandleColor-0d7_KjU() {
        return this.handleColor;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.handleColor) * 0x1F + Color.hashCode-impl(this.backgroundColor);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + Color.toString-impl(this.handleColor) + ", selectionBackgroundColor=" + Color.toString-impl(this.backgroundColor) + ')';
    }
}

