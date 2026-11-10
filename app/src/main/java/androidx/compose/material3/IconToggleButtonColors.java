package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ%\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0001¢\u0006\u0004\b\u001C\u0010\u001BJ\u0013\u0010\u001D\u001A\u00020\u00182\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001F\u001A\u00020 H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\fR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000F\u0010\fR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0012\u0010\f¨\u0006!"}, d2={"Landroidx/compose/material3/IconToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getCheckedContainerColor-0d7_KjU", "getCheckedContentColor-0d7_KjU", "copy", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/IconToggleButtonColors;", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "containerColor$material3", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IconToggleButtonColors {
    public static final int $stable;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    static {
    }

    public IconToggleButtonColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, DefaultConstructorMarker arg13) {
        this(arg1, arg3, arg5, arg7, arg9, arg11);
    }

    private IconToggleButtonColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11) {
        super();
        this.containerColor = arg1;
        this.contentColor = arg3;
        this.disabledContainerColor = arg5;
        this.disabledContentColor = arg7;
        this.checkedContainerColor = arg9;
        this.checkedContentColor = arg11;
    }

    public final State containerColor$material3(boolean arg4, boolean arg5, Composer arg6, int arg7) {
        long v3;
        int v1 = 0x460F18AE;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(containerColor)N(enabled,checked)889@39444L28:IconButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:882)");
        }

        if(!arg4) {
            v3 = this.disabledContainerColor;
        }
        else if(!arg5) {
            v3 = this.containerColor;
        }
        else {
            v3 = this.checkedContainerColor;
        }

        State v3_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3_1;
    }

    public final State contentColor$material3(boolean arg4, boolean arg5, Composer arg6, int arg7) {
        long v3;
        int v1 = 0x4FEBCF26;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(contentColor)N(enabled,checked)906@40014L28:IconButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:899)");
        }

        if(!arg4) {
            v3 = this.disabledContentColor;
        }
        else if(!arg5) {
            v3 = this.contentColor;
        }
        else {
            v3 = this.checkedContentColor;
        }

        State v3_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3_1;
    }

    public final IconToggleButtonColors copy-tNS2XkQ(long arg20, long arg22, long arg24, long arg26, long arg28, long arg30) {
        IconToggleButtonColors v0 = this;
        long v1 = 16;
        long v6 = arg20 != v1 ? arg20 : v0.containerColor;
        long v8 = arg22 != v1 ? arg22 : v0.contentColor;
        long v10 = arg24 != v1 ? arg24 : v0.disabledContainerColor;
        long v12 = arg26 != v1 ? arg26 : v0.disabledContentColor;
        long v14 = arg28 != v1 ? arg28 : v0.checkedContainerColor;
        long v16 = arg30 != v1 ? arg30 : v0.checkedContentColor;
        return new IconToggleButtonColors(v6, v8, v10, v12, v14, v16, null);
    }

    public static IconToggleButtonColors copy-tNS2XkQ$default(IconToggleButtonColors arg13, long arg14, long arg16, long arg18, long arg20, long arg22, long arg24, int arg26, Object arg27) {
        if((arg26 & 1) != 0) {
            arg14 = arg13.containerColor;
        }

        long v1 = arg14;
        long v3 = (arg26 & 2) != 0 ? arg13.contentColor : arg16;
        long v5 = (arg26 & 4) != 0 ? arg13.disabledContainerColor : arg18;
        long v7 = (arg26 & 8) != 0 ? arg13.disabledContentColor : arg20;
        long v9 = (arg26 & 16) != 0 ? arg13.checkedContainerColor : arg22;
        long v11 = (arg26 & 0x20) != 0 ? arg13.checkedContentColor : arg24;
        return arg13.copy-tNS2XkQ(v1, v3, v5, v7, v9, v11);
    }

    public boolean equals(Object arg7) {
        if(this == (((IconToggleButtonColors)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(!(arg7 instanceof IconToggleButtonColors)) {
            }
            else if(!Color.equals-impl0(this.containerColor, ((IconToggleButtonColors)arg7).containerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.contentColor, ((IconToggleButtonColors)arg7).contentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledContainerColor, ((IconToggleButtonColors)arg7).disabledContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.disabledContentColor, ((IconToggleButtonColors)arg7).disabledContentColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.checkedContainerColor, ((IconToggleButtonColors)arg7).checkedContainerColor)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.checkedContentColor, ((IconToggleButtonColors)arg7).checkedContentColor)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final long getCheckedContainerColor-0d7_KjU() {
        return this.checkedContainerColor;
    }

    public final long getCheckedContentColor-0d7_KjU() {
        return this.checkedContentColor;
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
        return ((((Color.hashCode-impl(this.containerColor) * 0x1F + Color.hashCode-impl(this.contentColor)) * 0x1F + Color.hashCode-impl(this.disabledContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledContentColor)) * 0x1F + Color.hashCode-impl(this.checkedContainerColor)) * 0x1F + Color.hashCode-impl(this.checkedContentColor);
    }
}

