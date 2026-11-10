package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nB1\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\u000BJI\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001AJ\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001E\u001A\u00020\u001FH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u000F\u0010\rR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0013\u0010\r¨\u0006 "}, d2={"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getScrolledContainerColor-0d7_KjU", "getNavigationIconContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionIconContentColor-0d7_KjU", "getSubtitleContentColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/TopAppBarColors;", "colorTransitionFraction", "", "containerColor-vNxB06k$material3", "(F)J", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TopAppBarColors {
    public static final int $stable;
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long subtitleContentColor;
    private final long titleContentColor;

    static {
    }

    private TopAppBarColors(long arg15, long arg17, long arg19, long arg21, long arg23) {
        this(arg15, arg17, arg19, arg21, arg23, arg21, null);
    }

    public TopAppBarColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, DefaultConstructorMarker arg13) {
        this(arg1, arg3, arg5, arg7, arg9, arg11);
    }

    private TopAppBarColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11) {
        super();
        this.containerColor = arg1;
        this.scrolledContainerColor = arg3;
        this.navigationIconContentColor = arg5;
        this.titleContentColor = arg7;
        this.actionIconContentColor = arg9;
        this.subtitleContentColor = arg11;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use the TopAppBarColors constructor with subtitleContentColor", replaceWith="<_subannotation>") public TopAppBarColors(long arg1, long arg3, long arg5, long arg7, long arg9, DefaultConstructorMarker arg11) {
        this(arg1, arg3, arg5, arg7, arg9);
    }

    public final long containerColor-vNxB06k$material3(float arg5) {
        return ColorKt.lerp-jxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(arg5));
    }

    public final TopAppBarColors copy-tNS2XkQ(long arg20, long arg22, long arg24, long arg26, long arg28, long arg30) {
        TopAppBarColors v0 = this;
        long v1 = 16;
        long v6 = arg20 != v1 ? arg20 : v0.containerColor;
        long v8 = arg22 != v1 ? arg22 : v0.scrolledContainerColor;
        long v10 = arg24 != v1 ? arg24 : v0.navigationIconContentColor;
        long v12 = arg26 != v1 ? arg26 : v0.titleContentColor;
        long v14 = arg28 != v1 ? arg28 : v0.actionIconContentColor;
        long v16 = arg30 != v1 ? arg30 : v0.subtitleContentColor;
        return new TopAppBarColors(v6, v8, v10, v12, v14, v16, null);
    }

    public static TopAppBarColors copy-tNS2XkQ$default(TopAppBarColors arg13, long arg14, long arg16, long arg18, long arg20, long arg22, long arg24, int arg26, Object arg27) {
        if((arg26 & 1) != 0) {
            arg14 = arg13.containerColor;
        }

        long v1 = arg14;
        long v3 = (arg26 & 2) != 0 ? arg13.scrolledContainerColor : arg16;
        long v5 = (arg26 & 4) != 0 ? arg13.navigationIconContentColor : arg18;
        long v7 = (arg26 & 8) != 0 ? arg13.titleContentColor : arg20;
        long v9 = (arg26 & 16) != 0 ? arg13.actionIconContentColor : arg22;
        long v11 = (arg26 & 0x20) != 0 ? arg13.subtitleContentColor : arg24;
        return arg13.copy-tNS2XkQ(v1, v3, v5, v7, v9, v11);
    }

    public boolean equals(Object arg7) {
        if(this == (((TopAppBarColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof TopAppBarColors)) {
            }
            else if(!Color.equals-impl0(this.containerColor, ((TopAppBarColors)arg7).containerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.scrolledContainerColor, ((TopAppBarColors)arg7).scrolledContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.navigationIconContentColor, ((TopAppBarColors)arg7).navigationIconContentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.titleContentColor, ((TopAppBarColors)arg7).titleContentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.actionIconContentColor, ((TopAppBarColors)arg7).actionIconContentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.subtitleContentColor, ((TopAppBarColors)arg7).subtitleContentColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getActionIconContentColor-0d7_KjU() {
        return this.actionIconContentColor;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getNavigationIconContentColor-0d7_KjU() {
        return this.navigationIconContentColor;
    }

    public final long getScrolledContainerColor-0d7_KjU() {
        return this.scrolledContainerColor;
    }

    public final long getSubtitleContentColor-0d7_KjU() {
        return this.subtitleContentColor;
    }

    public final long getTitleContentColor-0d7_KjU() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return ((((Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.scrolledContainerColor)) * 0x1F + Color.hashCode-impl(this.navigationIconContentColor)) * 0x1F + Color.hashCode-impl(this.titleContentColor)) * 0x1F + Color.hashCode-impl(this.actionIconContentColor)) * 0x1F + Color.hashCode-impl(this.subtitleContentColor);
    }
}

