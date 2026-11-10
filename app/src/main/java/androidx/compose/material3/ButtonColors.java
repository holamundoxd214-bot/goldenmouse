package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0015J\u0013\u0010\u0017\u001A\u00020\u00132\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u000E\u0010\n¨\u0006\u001B"}, d2={"Landroidx/compose/material3/ButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/ButtonColors;", "enabled", "", "containerColor-vNxB06k$material3", "(Z)J", "contentColor-vNxB06k$material3", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ButtonColors {
    public static final int $stable;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    static {
    }

    private ButtonColors(long arg1, long arg3, long arg5, long arg7) {
        super();
        this.containerColor = arg1;
        this.contentColor = arg3;
        this.disabledContainerColor = arg5;
        this.disabledContentColor = arg7;
    }

    public ButtonColors(long arg1, long arg3, long arg5, long arg7, DefaultConstructorMarker arg9) {
        this(arg1, arg3, arg5, arg7);
    }

    public final long containerColor-vNxB06k$material3(boolean arg1) {
        if(arg1) {
            return this.containerColor;
        }

        return this.disabledContainerColor;
    }

    public final long contentColor-vNxB06k$material3(boolean arg1) {
        if(arg1) {
            return this.contentColor;
        }

        return this.disabledContentColor;
    }

    public final ButtonColors copy-jRlVdoo(long arg15, long arg17, long arg19, long arg21) {
        long v0 = 16;
        long v5 = arg15 != v0 ? arg15 : this.containerColor;
        long v7 = arg17 != v0 ? arg17 : this.contentColor;
        long v9 = arg19 != v0 ? arg19 : this.disabledContainerColor;
        long v11 = arg21 != v0 ? arg21 : this.disabledContentColor;
        return new ButtonColors(v5, v7, v9, v11, null);
    }

    public static ButtonColors copy-jRlVdoo$default(ButtonColors arg9, long arg10, long arg12, long arg14, long arg16, int arg18, Object arg19) {
        if((arg18 & 1) != 0) {
            arg10 = arg9.containerColor;
        }

        long v1 = arg10;
        if((arg18 & 2) != 0) {
            arg12 = arg9.contentColor;
        }

        long v3 = arg12;
        if((arg18 & 4) != 0) {
            arg14 = arg9.disabledContainerColor;
        }

        long v5 = arg14;
        long v7 = (arg18 & 8) != 0 ? arg9.disabledContentColor : arg16;
        return arg9.copy-jRlVdoo(v1, v3, v5, v7);
    }

    public boolean equals(Object arg7) {
        if(this == (((ButtonColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof ButtonColors)) {
            }
            else if(!Color.equals-impl0(this.containerColor, ((ButtonColors)arg7).containerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.contentColor, ((ButtonColors)arg7).contentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledContainerColor, ((ButtonColors)arg7).disabledContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledContentColor, ((ButtonColors)arg7).disabledContentColor)) {
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

    public final long getDisabledContainerColor-0d7_KjU() {
        return this.disabledContainerColor;
    }

    public final long getDisabledContentColor-0d7_KjU() {
        return this.disabledContentColor;
    }

    public int hashCode() {
        return ((Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.contentColor)) * 0x1F + Color.hashCode-impl(this.disabledContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledContentColor);
    }
}

