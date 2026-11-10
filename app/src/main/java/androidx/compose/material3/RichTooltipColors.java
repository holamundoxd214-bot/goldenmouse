package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u000E\u0010\n¨\u0006\u0017"}, d2={"Landroidx/compose/material3/RichTooltipColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "titleContentColor", "actionContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/RichTooltipColors;", "equals", "", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RichTooltipColors {
    public static final int $stable;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    static {
    }

    private RichTooltipColors(long arg1, long arg3, long arg5, long arg7) {
        super();
        this.containerColor = arg1;
        this.contentColor = arg3;
        this.titleContentColor = arg5;
        this.actionContentColor = arg7;
    }

    public RichTooltipColors(long arg1, long arg3, long arg5, long arg7, DefaultConstructorMarker arg9) {
        this(arg1, arg3, arg5, arg7);
    }

    public final RichTooltipColors copy-jRlVdoo(long arg15, long arg17, long arg19, long arg21) {
        long v0 = 16;
        long v5 = arg15 != v0 ? arg15 : this.containerColor;
        long v7 = arg17 != v0 ? arg17 : this.contentColor;
        long v9 = arg19 != v0 ? arg19 : this.titleContentColor;
        long v11 = arg21 != v0 ? arg21 : this.actionContentColor;
        return new RichTooltipColors(v5, v7, v9, v11, null);
    }

    public static RichTooltipColors copy-jRlVdoo$default(RichTooltipColors arg9, long arg10, long arg12, long arg14, long arg16, int arg18, Object arg19) {
        if((arg18 & 1) != 0) {
            arg10 = arg9.containerColor;
        }

        long v1 = arg10;
        if((arg18 & 2) != 0) {
            arg12 = arg9.contentColor;
        }

        long v3 = arg12;
        if((arg18 & 4) != 0) {
            arg14 = arg9.titleContentColor;
        }

        long v5 = arg14;
        long v7 = (arg18 & 8) != 0 ? arg9.actionContentColor : arg16;
        return arg9.copy-jRlVdoo(v1, v3, v5, v7);
    }

    public boolean equals(Object arg8) {
        if(this == (((RichTooltipColors)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RichTooltipColors)) {
            return 0;
        }

        if(!Color.equals-impl0(this.containerColor, ((RichTooltipColors)arg8).containerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.contentColor, ((RichTooltipColors)arg8).contentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.titleContentColor, ((RichTooltipColors)arg8).titleContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.actionContentColor, ((RichTooltipColors)arg8).actionContentColor)) {
            return 0;
        }

        return 1;
    }

    public final long getActionContentColor-0d7_KjU() {
        return this.actionContentColor;
    }

    public final long getContainerColor-0d7_KjU() {
        return this.containerColor;
    }

    public final long getContentColor-0d7_KjU() {
        return this.contentColor;
    }

    public final long getTitleContentColor-0d7_KjU() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return ((Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.contentColor)) * 0x1F + Color.hashCode-impl(this.titleContentColor)) * 0x1F + Color.hashCode-impl(this.actionContentColor);
    }
}

