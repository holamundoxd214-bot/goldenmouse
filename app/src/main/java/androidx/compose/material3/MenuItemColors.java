package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0017H\u0001¢\u0006\u0004\b\u001A\u0010\u0019J\u0017\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0017H\u0001¢\u0006\u0004\b\u001B\u0010\u0019J\u0013\u0010\u001C\u001A\u00020\u00172\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001E\u001A\u00020\u001FH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\fR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000F\u0010\fR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0012\u0010\f¨\u0006 "}, d2={"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextColor-0d7_KjU", "()J", "J", "getLeadingIconColor-0d7_KjU", "getTrailingIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/MenuItemColors;", "enabled", "", "textColor-vNxB06k$material3", "(Z)J", "leadingIconColor-vNxB06k$material3", "trailingIconColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MenuItemColors {
    public static final int $stable;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    static {
    }

    public MenuItemColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, DefaultConstructorMarker arg13) {
        this(arg1, arg3, arg5, arg7, arg9, arg11);
    }

    private MenuItemColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11) {
        super();
        this.textColor = arg1;
        this.leadingIconColor = arg3;
        this.trailingIconColor = arg5;
        this.disabledTextColor = arg7;
        this.disabledLeadingIconColor = arg9;
        this.disabledTrailingIconColor = arg11;
    }

    public final MenuItemColors copy-tNS2XkQ(long arg20, long arg22, long arg24, long arg26, long arg28, long arg30) {
        MenuItemColors v0 = this;
        long v1 = 16;
        long v6 = arg20 != v1 ? arg20 : v0.textColor;
        long v8 = arg22 != v1 ? arg22 : v0.leadingIconColor;
        long v10 = arg24 != v1 ? arg24 : v0.trailingIconColor;
        long v12 = arg26 != v1 ? arg26 : v0.disabledTextColor;
        long v14 = arg28 != v1 ? arg28 : v0.disabledLeadingIconColor;
        long v16 = arg30 != v1 ? arg30 : v0.disabledTrailingIconColor;
        return new MenuItemColors(v6, v8, v10, v12, v14, v16, null);
    }

    public static MenuItemColors copy-tNS2XkQ$default(MenuItemColors arg13, long arg14, long arg16, long arg18, long arg20, long arg22, long arg24, int arg26, Object arg27) {
        if((arg26 & 1) != 0) {
            arg14 = arg13.textColor;
        }

        long v1 = arg14;
        long v3 = (arg26 & 2) != 0 ? arg13.leadingIconColor : arg16;
        long v5 = (arg26 & 4) != 0 ? arg13.trailingIconColor : arg18;
        long v7 = (arg26 & 8) != 0 ? arg13.disabledTextColor : arg20;
        long v9 = (arg26 & 16) != 0 ? arg13.disabledLeadingIconColor : arg22;
        long v11 = (arg26 & 0x20) != 0 ? arg13.disabledTrailingIconColor : arg24;
        return arg13.copy-tNS2XkQ(v1, v3, v5, v7, v9, v11);
    }

    public boolean equals(Object arg7) {
        if(this == (((MenuItemColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof MenuItemColors)) {
            }
            else if(!Color.equals-impl0(this.textColor, ((MenuItemColors)arg7).textColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.leadingIconColor, ((MenuItemColors)arg7).leadingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.trailingIconColor, ((MenuItemColors)arg7).trailingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledTextColor, ((MenuItemColors)arg7).disabledTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledLeadingIconColor, ((MenuItemColors)arg7).disabledLeadingIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledTrailingIconColor, ((MenuItemColors)arg7).disabledTrailingIconColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getDisabledLeadingIconColor-0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    public final long getDisabledTextColor-0d7_KjU() {
        return this.disabledTextColor;
    }

    public final long getDisabledTrailingIconColor-0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    public final long getLeadingIconColor-0d7_KjU() {
        return this.leadingIconColor;
    }

    public final long getTextColor-0d7_KjU() {
        return this.textColor;
    }

    public final long getTrailingIconColor-0d7_KjU() {
        return this.trailingIconColor;
    }

    public int hashCode() {
        return ((((Color.hashCode-impl(this.textColor) * 0x1F + Color.hashCode-impl(this.leadingIconColor)) * 0x1F + Color.hashCode-impl(this.trailingIconColor)) * 0x1F + Color.hashCode-impl(this.disabledTextColor)) * 0x1F + Color.hashCode-impl(this.disabledLeadingIconColor)) * 0x1F + Color.hashCode-impl(this.disabledTrailingIconColor);
    }

    public final long leadingIconColor-vNxB06k$material3(boolean arg1) {
        if(arg1) {
            return this.leadingIconColor;
        }

        return this.disabledLeadingIconColor;
    }

    public final long textColor-vNxB06k$material3(boolean arg1) {
        if(arg1) {
            return this.textColor;
        }

        return this.disabledTextColor;
    }

    public final long trailingIconColor-vNxB06k$material3(boolean arg1) {
        if(arg1) {
            return this.trailingIconColor;
        }

        return this.disabledTrailingIconColor;
    }
}

