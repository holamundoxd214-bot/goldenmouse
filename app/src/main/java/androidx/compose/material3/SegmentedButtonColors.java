package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u0085\u0001\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u0003¢\u0006\u0004\b \u0010!J\u001F\u0010\"\u001A\u00020\u00032\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020$H\u0001¢\u0006\u0004\b&\u0010\'J\u001F\u0010(\u001A\u00020\u00032\u0006\u0010#\u001A\u00020$2\u0006\u0010)\u001A\u00020$H\u0001¢\u0006\u0004\b*\u0010\'J\u001F\u0010+\u001A\u00020\u00032\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020$H\u0001¢\u0006\u0004\b,\u0010\'J\u0013\u0010-\u001A\u00020$2\b\u0010.\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001A\u000200H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0018\u0010\u0012R\u0013\u0010\t\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0019\u0010\u0012R\u0013\u0010\n\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001A\u0010\u0012R\u0013\u0010\u000B\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001B\u0010\u0012R\u0013\u0010\f\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001C\u0010\u0012R\u0013\u0010\r\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001D\u0010\u0012R\u0013\u0010\u000E\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u001E\u0010\u0012¨\u00061"}, d2={"Landroidx/compose/material3/SegmentedButtonColors;", "", "activeContainerColor", "Landroidx/compose/ui/graphics/Color;", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActiveContainerColor-0d7_KjU", "()J", "J", "getActiveContentColor-0d7_KjU", "getActiveBorderColor-0d7_KjU", "getInactiveContainerColor-0d7_KjU", "getInactiveContentColor-0d7_KjU", "getInactiveBorderColor-0d7_KjU", "getDisabledActiveContainerColor-0d7_KjU", "getDisabledActiveContentColor-0d7_KjU", "getDisabledActiveBorderColor-0d7_KjU", "getDisabledInactiveContainerColor-0d7_KjU", "getDisabledInactiveContentColor-0d7_KjU", "getDisabledInactiveBorderColor-0d7_KjU", "copy", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/SegmentedButtonColors;", "borderColor", "enabled", "", "active", "borderColor-WaAFU9c$material3", "(ZZ)J", "contentColor", "checked", "contentColor-WaAFU9c$material3", "containerColor", "containerColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SegmentedButtonColors {
    public static final int $stable;
    private final long activeBorderColor;
    private final long activeContainerColor;
    private final long activeContentColor;
    private final long disabledActiveBorderColor;
    private final long disabledActiveContainerColor;
    private final long disabledActiveContentColor;
    private final long disabledInactiveBorderColor;
    private final long disabledInactiveContainerColor;
    private final long disabledInactiveContentColor;
    private final long inactiveBorderColor;
    private final long inactiveContainerColor;
    private final long inactiveContentColor;

    static {
    }

    private SegmentedButtonColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23) {
        super();
        this.activeContainerColor = arg1;
        this.activeContentColor = arg3;
        this.activeBorderColor = arg5;
        this.inactiveContainerColor = arg7;
        this.inactiveContentColor = arg9;
        this.inactiveBorderColor = arg11;
        this.disabledActiveContainerColor = arg13;
        this.disabledActiveContentColor = arg15;
        this.disabledActiveBorderColor = arg17;
        this.disabledInactiveContainerColor = arg19;
        this.disabledInactiveContentColor = arg21;
        this.disabledInactiveBorderColor = arg23;
    }

    public SegmentedButtonColors(long arg1, long arg3, long arg5, long arg7, long arg9, long arg11, long arg13, long arg15, long arg17, long arg19, long arg21, long arg23, DefaultConstructorMarker arg25) {
        this(arg1, arg3, arg5, arg7, arg9, arg11, arg13, arg15, arg17, arg19, arg21, arg23);
    }

    public final long borderColor-WaAFU9c$material3(boolean arg1, boolean arg2) {
        if((arg1) && (arg2)) {
            return this.activeBorderColor;
        }

        if((arg1) && !arg2) {
            return this.inactiveBorderColor;
        }

        if(!arg1 && (arg2)) {
            return this.disabledActiveBorderColor;
        }

        return this.disabledInactiveBorderColor;
    }

    public final long containerColor-WaAFU9c$material3(boolean arg1, boolean arg2) {
        if((arg1) && (arg2)) {
            return this.activeContainerColor;
        }

        if((arg1) && !arg2) {
            return this.inactiveContainerColor;
        }

        if(!arg1 && (arg2)) {
            return this.disabledActiveContainerColor;
        }

        return this.disabledInactiveContainerColor;
    }

    public final long contentColor-WaAFU9c$material3(boolean arg1, boolean arg2) {
        if((arg1) && (arg2)) {
            return this.activeContentColor;
        }

        if((arg1) && !arg2) {
            return this.inactiveContentColor;
        }

        if(!arg1 && (arg2)) {
            return this.disabledActiveContentColor;
        }

        return this.disabledInactiveContentColor;
    }

    public final SegmentedButtonColors copy-2qZNXz8(long arg32, long arg34, long arg36, long arg38, long arg40, long arg42, long arg44, long arg46, long arg48, long arg50, long arg52, long arg54) {
        SegmentedButtonColors v0 = this;
        long v1 = 16;
        long v6 = arg32 != v1 ? arg32 : v0.activeContainerColor;
        long v8 = arg34 != v1 ? arg34 : v0.activeContentColor;
        long v10 = arg36 != v1 ? arg36 : v0.activeBorderColor;
        long v12 = arg38 != v1 ? arg38 : v0.inactiveContainerColor;
        long v14 = arg40 != v1 ? arg40 : v0.inactiveContentColor;
        long v16 = arg42 != v1 ? arg42 : v0.inactiveBorderColor;
        long v18 = arg44 != v1 ? arg44 : v0.disabledActiveContainerColor;
        long v20 = arg46 != v1 ? arg46 : v0.disabledActiveContentColor;
        long v22 = arg48 != v1 ? arg48 : v0.disabledActiveBorderColor;
        long v24 = arg50 != v1 ? arg50 : v0.disabledInactiveContainerColor;
        long v26 = arg52 != v1 ? arg52 : v0.disabledInactiveContentColor;
        long v28 = arg54 != v1 ? arg54 : v0.disabledInactiveBorderColor;
        return new SegmentedButtonColors(v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v28, null);
    }

    public static SegmentedButtonColors copy-2qZNXz8$default(SegmentedButtonColors arg18, long arg19, long arg21, long arg23, long arg25, long arg27, long arg29, long arg31, long arg33, long arg35, long arg37, long arg39, long arg41, int arg43, Object arg44) {
        long v42;
        long v40;
        SegmentedButtonColors v0 = arg18;
        int v1 = arg43;
        long v2 = (v1 & 1) != 0 ? v0.activeContainerColor : arg19;
        long v4 = (v1 & 2) != 0 ? v0.activeContentColor : arg21;
        long v6 = (v1 & 4) != 0 ? v0.activeBorderColor : arg23;
        long v8 = (v1 & 8) != 0 ? v0.inactiveContainerColor : arg25;
        long v10 = (v1 & 16) != 0 ? v0.inactiveContentColor : arg27;
        long v12 = (v1 & 0x20) != 0 ? v0.inactiveBorderColor : arg29;
        long v14 = (v1 & 0x40) != 0 ? v0.disabledActiveContainerColor : arg31;
        long v16 = v2;
        v2 = (v1 & 0x80) != 0 ? v0.disabledActiveContentColor : arg33;
        arg19 = v2;
        v2 = (v1 & 0x100) != 0 ? v0.disabledActiveBorderColor : arg35;
        arg21 = v2;
        v2 = (v1 & 0x200) != 0 ? v0.disabledInactiveContainerColor : arg37;
        arg23 = v2;
        v2 = (v1 & 0x400) != 0 ? v0.disabledInactiveContentColor : arg39;
        if((v1 & 0x800) != 0) {
            v40 = v2;
            v42 = v0.disabledInactiveBorderColor;
        }
        else {
            v42 = arg41;
            v40 = v2;
        }

        return v0.copy-2qZNXz8(v16, v4, v6, v8, v10, v12, v14, arg19, arg21, arg23, v40, v42);
    }

    public boolean equals(Object arg7) {
        if(this == (((SegmentedButtonColors)arg7))) {
            return 1;
        }

        if(arg7 == null) {
            return 0;
        }

        if(this.getClass() != arg7.getClass()) {
            return 0;
        }

        if(!Color.equals-impl0(this.activeBorderColor, ((SegmentedButtonColors)arg7).activeBorderColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.activeContentColor, ((SegmentedButtonColors)arg7).activeContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.activeContainerColor, ((SegmentedButtonColors)arg7).activeContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.inactiveBorderColor, ((SegmentedButtonColors)arg7).inactiveBorderColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.inactiveContentColor, ((SegmentedButtonColors)arg7).inactiveContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.inactiveContainerColor, ((SegmentedButtonColors)arg7).inactiveContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledActiveBorderColor, ((SegmentedButtonColors)arg7).disabledActiveBorderColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledActiveContentColor, ((SegmentedButtonColors)arg7).disabledActiveContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledActiveContainerColor, ((SegmentedButtonColors)arg7).disabledActiveContainerColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledInactiveBorderColor, ((SegmentedButtonColors)arg7).disabledInactiveBorderColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledInactiveContentColor, ((SegmentedButtonColors)arg7).disabledInactiveContentColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.disabledInactiveContainerColor, ((SegmentedButtonColors)arg7).disabledInactiveContainerColor)) {
            return 0;
        }

        return 1;
    }

    public final long getActiveBorderColor-0d7_KjU() {
        return this.activeBorderColor;
    }

    public final long getActiveContainerColor-0d7_KjU() {
        return this.activeContainerColor;
    }

    public final long getActiveContentColor-0d7_KjU() {
        return this.activeContentColor;
    }

    public final long getDisabledActiveBorderColor-0d7_KjU() {
        return this.disabledActiveBorderColor;
    }

    public final long getDisabledActiveContainerColor-0d7_KjU() {
        return this.disabledActiveContainerColor;
    }

    public final long getDisabledActiveContentColor-0d7_KjU() {
        return this.disabledActiveContentColor;
    }

    public final long getDisabledInactiveBorderColor-0d7_KjU() {
        return this.disabledInactiveBorderColor;
    }

    public final long getDisabledInactiveContainerColor-0d7_KjU() {
        return this.disabledInactiveContainerColor;
    }

    public final long getDisabledInactiveContentColor-0d7_KjU() {
        return this.disabledInactiveContentColor;
    }

    public final long getInactiveBorderColor-0d7_KjU() {
        return this.inactiveBorderColor;
    }

    public final long getInactiveContainerColor-0d7_KjU() {
        return this.inactiveContainerColor;
    }

    public final long getInactiveContentColor-0d7_KjU() {
        return this.inactiveContentColor;
    }

    public int hashCode() {
        return ((((((((((Color.hashCode-impl(this.activeBorderColor) * 0x1F + Color.hashCode-impl(this.activeContentColor)) * 0x1F + Color.hashCode-impl(this.activeContainerColor)) * 0x1F + Color.hashCode-impl(this.inactiveBorderColor)) * 0x1F + Color.hashCode-impl(this.inactiveContentColor)) * 0x1F + Color.hashCode-impl(this.inactiveContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledActiveBorderColor)) * 0x1F + Color.hashCode-impl(this.disabledActiveContentColor)) * 0x1F + Color.hashCode-impl(this.disabledActiveContainerColor)) * 0x1F + Color.hashCode-impl(this.disabledInactiveBorderColor)) * 0x1F + Color.hashCode-impl(this.disabledInactiveContentColor)) * 0x1F + Color.hashCode-impl(this.disabledInactiveContainerColor);
    }
}

