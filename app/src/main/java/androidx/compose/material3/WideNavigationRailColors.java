package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ?\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\r\u0010\u000BR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000F\u0010\u000BR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0010\u0010\u000B¨\u0006\u0019"}, d2={"Landroidx/compose/material3/WideNavigationRailColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getModalContainerColor-0d7_KjU", "getModalScrimColor-0d7_KjU", "getModalContentColor-0d7_KjU", "copy", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/WideNavigationRailColors;", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRailColors {
    public static final int $stable;
    private final long containerColor;
    private final long contentColor;
    private final long modalContainerColor;
    private final long modalContentColor;
    private final long modalScrimColor;

    static {
    }

    private WideNavigationRailColors(long arg1, long arg3, long arg5, long arg7, long arg9) {
        super();
        this.containerColor = arg1;
        this.contentColor = arg3;
        this.modalContainerColor = arg5;
        this.modalScrimColor = arg7;
        this.modalContentColor = arg9;
    }

    public WideNavigationRailColors(long arg1, long arg3, long arg5, long arg7, long arg9, DefaultConstructorMarker arg11) {
        this(arg1, arg3, arg5, arg7, arg9);
    }

    public final WideNavigationRailColors copy-t635Npw(long arg18, long arg20, long arg22, long arg24, long arg26) {
        WideNavigationRailColors v0 = this;
        long v1 = 16;
        long v6 = arg18 != v1 ? arg18 : v0.containerColor;
        long v8 = arg20 != v1 ? arg20 : v0.contentColor;
        long v10 = arg22 != v1 ? arg22 : v0.modalContainerColor;
        long v12 = arg24 != v1 ? arg24 : v0.modalScrimColor;
        long v14 = arg26 != v1 ? arg26 : v0.modalContentColor;
        return new WideNavigationRailColors(v6, v8, v10, v12, v14, null);
    }

    public static WideNavigationRailColors copy-t635Npw$default(WideNavigationRailColors arg11, long arg12, long arg14, long arg16, long arg18, long arg20, int arg22, Object arg23) {
        if((arg22 & 1) != 0) {
            arg12 = arg11.containerColor;
        }

        long v1 = arg12;
        if((arg22 & 2) != 0) {
            arg14 = arg11.contentColor;
        }

        long v3 = arg14;
        long v5 = (arg22 & 4) != 0 ? arg11.modalContainerColor : arg16;
        long v7 = (arg22 & 8) != 0 ? arg11.modalScrimColor : arg18;
        long v9 = (arg22 & 16) != 0 ? arg11.modalContentColor : arg20;
        return arg11.copy-t635Npw(v1, v3, v5, v7, v9);
    }

    public boolean equals(Object arg7) {
        if(this == (((WideNavigationRailColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof WideNavigationRailColors)) {
            }
            else if(!Color.equals-impl0(this.containerColor, ((WideNavigationRailColors)arg7).containerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.contentColor, ((WideNavigationRailColors)arg7).contentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.modalContainerColor, ((WideNavigationRailColors)arg7).modalContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.modalScrimColor, ((WideNavigationRailColors)arg7).modalScrimColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getContentColor-0d7_KjU() {
        return this.contentColor;
    }

    public final long getModalContainerColor-0d7_KjU() {
        return this.modalContainerColor;
    }

    public final long getModalContentColor-0d7_KjU() {
        return this.modalContentColor;
    }

    public final long getModalScrimColor-0d7_KjU() {
        return this.modalScrimColor;
    }

    public int hashCode() {
        return (((Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.contentColor)) * 0x1F + Color.hashCode-impl(this.modalContainerColor)) * 0x1F + Color.hashCode-impl(this.modalScrimColor)) * 0x1F + Color.hashCode-impl(this.modalContentColor);
    }
}

