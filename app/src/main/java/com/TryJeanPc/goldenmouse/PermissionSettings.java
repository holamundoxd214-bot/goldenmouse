package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/PermissionSettings;", "", "<init>", "(Ljava/lang/String;I)V", "OVERLAY", "BACKGROUND", "BATTERY", "POWER_SAVER", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum PermissionSettings {
    public static final enum PermissionSettings BACKGROUND;
    public static final enum PermissionSettings BATTERY;
    public static final enum PermissionSettings OVERLAY;
    public static final enum PermissionSettings POWER_SAVER;

    private static final PermissionSettings[] $values() {
        return new PermissionSettings[]{PermissionSettings.OVERLAY, PermissionSettings.BACKGROUND, PermissionSettings.BATTERY, PermissionSettings.POWER_SAVER};
    }

    static {
        PermissionSettings.OVERLAY = new PermissionSettings("OVERLAY", 0);
        PermissionSettings.BACKGROUND = new PermissionSettings("BACKGROUND", 1);
        PermissionSettings.BATTERY = new PermissionSettings("BATTERY", 2);
        PermissionSettings.POWER_SAVER = new PermissionSettings("POWER_SAVER", 3);
        PermissionSettings[] v0 = PermissionSettings.$values();
        PermissionSettings.$VALUES = v0;
        PermissionSettings.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private PermissionSettings(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return PermissionSettings.$ENTRIES;
    }

    public static PermissionSettings valueOf(String arg1) {
        return Enum.valueOf(PermissionSettings.class, arg1);
    }

    public static PermissionSettings[] values() {
        return PermissionSettings.$VALUES.clone();
    }
}

