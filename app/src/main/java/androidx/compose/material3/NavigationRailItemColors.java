package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\n\u0010\u000BJS\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AH\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u001E\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001AH\u0001¢\u0006\u0004\b\u001F\u0010\u001DJ\u0013\u0010\"\u001A\u00020\u001A2\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001A\u00020%H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u000F\u0010\rR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0014\u0010\rR\u0014\u0010 \u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\r¨\u0006&"}, d2={"Landroidx/compose/material3/NavigationRailItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "<init>", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedIconColor-0d7_KjU", "()J", "J", "getSelectedTextColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getDisabledIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "copy", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationRailItemColors;", "iconColor", "selected", "", "enabled", "iconColor-WaAFU9c$material3", "(ZZ)J", "textColor", "textColor-WaAFU9c$material3", "indicatorColor", "getIndicatorColor-0d7_KjU$material3", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationRailItemColors {
    public static final int $stable;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    static {
    }

    private NavigationRailItemColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13) {
        super();
        this.selectedIconColor = arg1;
        this.selectedTextColor = arg3;
        this.selectedIndicatorColor = arg5;
        this.unselectedIconColor = arg7;
        this.unselectedTextColor = arg9;
        this.disabledIconColor = arg11;
        this.disabledTextColor = arg13;
    }

    public NavigationRailItemColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, DefaultConstructorMarker arg15) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13);
    }

    public final NavigationRailItemColors copy-4JmcsL4(long arg22, long arg24, long arg26, long arg28, long arg30, long arg32, long arg34) {
        NavigationRailItemColors v0 = this;
        long v1 = 16;
        long v6 = arg22 != v1 ? arg22 : v0.selectedIconColor;
        long v8 = arg24 != v1 ? arg24 : v0.selectedTextColor;
        long v10 = arg26 != v1 ? arg26 : v0.selectedIndicatorColor;
        long v12 = arg28 != v1 ? arg28 : v0.unselectedIconColor;
        long v14 = arg30 != v1 ? arg30 : v0.unselectedTextColor;
        long v16 = arg32 != v1 ? arg32 : v0.disabledIconColor;
        long v18 = arg34 != v1 ? arg34 : v0.disabledTextColor;
        return new NavigationRailItemColors(v6, v8, v10, v12, v14, v16, v18, null);
    }

    public static NavigationRailItemColors copy-4JmcsL4$default(NavigationRailItemColors arg14, long arg15, long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, int arg29, Object arg30) {
        long v0 = (arg29 & 1) != 0 ? arg14.selectedIconColor : arg15;
        long v2 = (arg29 & 2) != 0 ? arg14.selectedTextColor : arg17;
        long v4 = (arg29 & 4) != 0 ? arg14.selectedIndicatorColor : arg19;
        long v6 = (arg29 & 8) != 0 ? arg14.unselectedIconColor : arg21;
        long v8 = (arg29 & 16) != 0 ? arg14.unselectedTextColor : arg23;
        long v10 = (arg29 & 0x20) != 0 ? arg14.disabledIconColor : arg25;
        long v28 = (arg29 & 0x40) != 0 ? arg14.disabledTextColor : arg27;
        return arg14.copy-4JmcsL4(v0, v2, v4, v6, v8, v10, v28);
    }

    public boolean equals(Object arg7) {
        if(this == (((NavigationRailItemColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof NavigationRailItemColors)) {
            }
            else if(!Color.equals-impl0(this.selectedIconColor, ((NavigationRailItemColors)arg7).selectedIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unselectedIconColor, ((NavigationRailItemColors)arg7).unselectedIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.selectedTextColor, ((NavigationRailItemColors)arg7).selectedTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.unselectedTextColor, ((NavigationRailItemColors)arg7).unselectedTextColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.selectedIndicatorColor, ((NavigationRailItemColors)arg7).selectedIndicatorColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledIconColor, ((NavigationRailItemColors)arg7).disabledIconColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledTextColor, ((NavigationRailItemColors)arg7).disabledTextColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getDisabledIconColor-0d7_KjU() {
        return this.disabledIconColor;
    }

    public final long getDisabledTextColor-0d7_KjU() {
        return this.disabledTextColor;
    }

    public final long getIndicatorColor-0d7_KjU$material3() {
        return this.selectedIndicatorColor;
    }

    public final long getSelectedIconColor-0d7_KjU() {
        return this.selectedIconColor;
    }

    public final long getSelectedIndicatorColor-0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    public final long getSelectedTextColor-0d7_KjU() {
        return this.selectedTextColor;
    }

    public final long getUnselectedIconColor-0d7_KjU() {
        return this.unselectedIconColor;
    }

    public final long getUnselectedTextColor-0d7_KjU() {
        return this.unselectedTextColor;
    }

    public int hashCode() {
        return (((((Color.hashCode-impl(this.selectedIconColor) * 0x1F + Color.hashCode-impl(this.unselectedIconColor)) * 0x1F + Color.hashCode-impl(this.selectedTextColor)) * 0x1F + Color.hashCode-impl(this.unselectedTextColor)) * 0x1F + Color.hashCode-impl(this.selectedIndicatorColor)) * 0x1F + Color.hashCode-impl(this.disabledIconColor)) * 0x1F + Color.hashCode-impl(this.disabledTextColor);
    }

    public final long iconColor-WaAFU9c$material3(boolean arg1, boolean arg2) {
        if(!arg2) {
            return this.disabledIconColor;
        }

        if(arg1) {
            return this.selectedIconColor;
        }

        return this.unselectedIconColor;
    }

    public final long textColor-WaAFU9c$material3(boolean arg1, boolean arg2) {
        if(!arg2) {
            return this.disabledTextColor;
        }

        if(arg1) {
            return this.selectedTextColor;
        }

        return this.unselectedTextColor;
    }
}

