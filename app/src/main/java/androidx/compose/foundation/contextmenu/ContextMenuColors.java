package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\r\u0010\u000BR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000F\u0010\u000BR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0010\u0010\u000B¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "iconColor", "disabledTextColor", "disabledIconColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getTextColor-0d7_KjU", "getIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledIconColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextMenuColors {
    public static final int $stable;
    private final long backgroundColor;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long iconColor;
    private final long textColor;

    static {
    }

    private ContextMenuColors(long arg1, long arg3, long arg5, long arg7, long arg9) {
        super();
        this.backgroundColor = arg1;
        this.textColor = arg3;
        this.iconColor = arg5;
        this.disabledTextColor = arg7;
        this.disabledIconColor = arg9;
    }

    public ContextMenuColors(long arg1, long arg3, long arg5, long arg7, long arg9, DefaultConstructorMarker arg11) {
        this(arg1, arg3, arg5, arg7, arg9);
    }

    public boolean equals(Object arg7) {
        if(this == (((ContextMenuColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof ContextMenuColors)) {
            }
            else if(!Color.equals-impl0(this.backgroundColor, ((ContextMenuColors)arg7).backgroundColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.textColor, ((ContextMenuColors)arg7).textColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.iconColor, ((ContextMenuColors)arg7).iconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledTextColor, ((ContextMenuColors)arg7).disabledTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledIconColor, ((ContextMenuColors)arg7).disabledIconColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getBackgroundColor-0d7_KjU() {
        return this.backgroundColor;
    }

    public final long getDisabledIconColor-0d7_KjU() {
        return this.disabledIconColor;
    }

    public final long getDisabledTextColor-0d7_KjU() {
        return this.disabledTextColor;
    }

    public final long getIconColor-0d7_KjU() {
        return this.iconColor;
    }

    public final long getTextColor-0d7_KjU() {
        return this.textColor;
    }

    public int hashCode() {
        return (((Color.hashCode-impl(this.backgroundColor) * 0x1F + Color.hashCode-impl(this.textColor)) * 0x1F + Color.hashCode-impl(this.iconColor)) * 0x1F + Color.hashCode-impl(this.disabledTextColor)) * 0x1F + Color.hashCode-impl(this.disabledIconColor);
    }

    public String toString() {
        return "ContextMenuColors(backgroundColor=" + Color.toString-impl(this.backgroundColor) + ", textColor=" + Color.toString-impl(this.textColor) + ", iconColor=" + Color.toString-impl(this.iconColor) + ", disabledTextColor=" + Color.toString-impl(this.disabledTextColor) + ", disabledIconColor=" + Color.toString-impl(this.disabledIconColor) + ')';
    }
}

