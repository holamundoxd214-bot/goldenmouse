package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0017¢\u0006\u0002\u0010\u001BJ\u001B\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0017¢\u0006\u0002\u0010\u001BJ\u001B\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0017¢\u0006\u0002\u0010\u001BJ\u001B\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0017¢\u0006\u0002\u0010\u001BJ\u0013\u0010\u001F\u001A\u00020\u001A2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001A\u00020#H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0010\u0010\u000ER\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0011\u0010\u000ER\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0012\u0010\u000ER\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0013\u0010\u000ER\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0014\u0010\u000ER\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0015\u0010\u000ER\u0013\u0010\n\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0016\u0010\u000E¨\u0006$"}, d2={"Landroidx/compose/material3/DefaultDrawerItemsColor;", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedContainerColor", "unselectedContainerColor", "selectedBadgeColor", "unselectedBadgeColor", "<init>", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedIconColor-0d7_KjU", "()J", "J", "getUnselectedIconColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getSelectedContainerColor-0d7_KjU", "getUnselectedContainerColor-0d7_KjU", "getSelectedBadgeColor-0d7_KjU", "getUnselectedBadgeColor-0d7_KjU", "iconColor", "Landroidx/compose/runtime/State;", "selected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "containerColor", "badgeColor", "equals", "other", "", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultDrawerItemsColor implements NavigationDrawerItemColors {
    private final long selectedBadgeColor;
    private final long selectedContainerColor;
    private final long selectedIconColor;
    private final long selectedTextColor;
    private final long unselectedBadgeColor;
    private final long unselectedContainerColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    private DefaultDrawerItemsColor(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15) {
        super();
        this.selectedIconColor = arg1;
        this.unselectedIconColor = arg3;
        this.selectedTextColor = arg5;
        this.unselectedTextColor = arg7;
        this.selectedContainerColor = arg9;
        this.unselectedContainerColor = arg11;
        this.selectedBadgeColor = arg13;
        this.unselectedBadgeColor = arg15;
    }

    public DefaultDrawerItemsColor(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, DefaultConstructorMarker arg17) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15);
    }

    public State badgeColor(boolean arg4, Composer arg5, int arg6) {
        int v0 = -561675044;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(badgeColor)N(selected)1250@52506L80:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:1249)");
        }

        long v3 = arg4 ? this.selectedBadgeColor : this.unselectedBadgeColor;
        State v3_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return v3_1;
    }

    public State containerColor(boolean arg4, Composer arg5, int arg6) {
        int v0 = -433512770;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(containerColor)N(selected)1243@52294L110:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:1242)");
        }

        long v3 = arg4 ? this.selectedContainerColor : this.unselectedContainerColor;
        State v3_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return v3_1;
    }

    public boolean equals(Object arg7) {
        if(this == (((DefaultDrawerItemsColor)arg7))) {
            return 1;
        }

        if(!(arg7 instanceof DefaultDrawerItemsColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedIconColor, ((DefaultDrawerItemsColor)arg7).selectedIconColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.unselectedIconColor, ((DefaultDrawerItemsColor)arg7).unselectedIconColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedTextColor, ((DefaultDrawerItemsColor)arg7).selectedTextColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.unselectedTextColor, ((DefaultDrawerItemsColor)arg7).unselectedTextColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedContainerColor, ((DefaultDrawerItemsColor)arg7).selectedContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.unselectedContainerColor, ((DefaultDrawerItemsColor)arg7).unselectedContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.selectedBadgeColor, ((DefaultDrawerItemsColor)arg7).selectedBadgeColor)) {
            return 0;
        }

        return Color.equals-impl0(this.unselectedBadgeColor, ((DefaultDrawerItemsColor)arg7).unselectedBadgeColor);
    }

    public final long getSelectedBadgeColor-0d7_KjU() {
        return this.selectedBadgeColor;
    }

    public final long getSelectedContainerColor-0d7_KjU() {
        return this.selectedContainerColor;
    }

    public final long getSelectedIconColor-0d7_KjU() {
        return this.selectedIconColor;
    }

    public final long getSelectedTextColor-0d7_KjU() {
        return this.selectedTextColor;
    }

    public final long getUnselectedBadgeColor-0d7_KjU() {
        return this.unselectedBadgeColor;
    }

    public final long getUnselectedContainerColor-0d7_KjU() {
        return this.unselectedContainerColor;
    }

    public final long getUnselectedIconColor-0d7_KjU() {
        return this.unselectedIconColor;
    }

    public final long getUnselectedTextColor-0d7_KjU() {
        return this.unselectedTextColor;
    }

    public int hashCode() {
        return ((((((Color.hashCode-impl(this.selectedIconColor) * 0x1F + Color.hashCode-impl(this.unselectedIconColor)) * 0x1F + Color.hashCode-impl(this.selectedTextColor)) * 0x1F + Color.hashCode-impl(this.unselectedTextColor)) * 0x1F + Color.hashCode-impl(this.selectedContainerColor)) * 0x1F + Color.hashCode-impl(this.unselectedContainerColor)) * 0x1F + Color.hashCode-impl(this.selectedBadgeColor)) * 0x1F + Color.hashCode-impl(this.unselectedBadgeColor);
    }

    public State iconColor(boolean arg4, Composer arg5, int arg6) {
        int v0 = 0x4407AEEA;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(iconColor)N(selected)1233@51931L78:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:1232)");
        }

        long v3 = arg4 ? this.selectedIconColor : this.unselectedIconColor;
        State v3_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return v3_1;
    }

    public State textColor(boolean arg4, Composer arg5, int arg6) {
        int v0 = 0x4C00A0B6;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(textColor)N(selected)1238@52110L78:NavigationDrawer.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:1237)");
        }

        long v3 = arg4 ? this.selectedTextColor : this.unselectedTextColor;
        State v3_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v3), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return v3_1;
    }
}

