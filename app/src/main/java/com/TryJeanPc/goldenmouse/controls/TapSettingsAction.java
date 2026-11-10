package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.profile.TapMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000E¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/TapSettingsAction;", "", "mode", "Lcom/TryJeanPc/goldenmouse/profile/TapMode;", "repeatEnabled", "", "<init>", "(Ljava/lang/String;ILcom/TryJeanPc/goldenmouse/profile/TapMode;Z)V", "getMode", "()Lcom/TryJeanPc/goldenmouse/profile/TapMode;", "getRepeatEnabled", "()Z", "SINGLE", "BURST", "TURBO", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum TapSettingsAction {
    public static final enum TapSettingsAction BURST;
    public static final enum TapSettingsAction SINGLE;
    public static final enum TapSettingsAction TURBO;
    private final TapMode mode;
    private final boolean repeatEnabled;

    private static final TapSettingsAction[] $values() {
        return new TapSettingsAction[]{TapSettingsAction.SINGLE, TapSettingsAction.BURST, TapSettingsAction.TURBO};
    }

    static {
        TapSettingsAction.SINGLE = new TapSettingsAction("SINGLE", 0, TapMode.SINGLE, false);
        TapSettingsAction.BURST = new TapSettingsAction("BURST", 1, TapMode.SINGLE, true);
        TapSettingsAction.TURBO = new TapSettingsAction("TURBO", 2, TapMode.REPEATING, false);
        TapSettingsAction[] v0 = TapSettingsAction.$values();
        TapSettingsAction.$VALUES = v0;
        TapSettingsAction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TapSettingsAction(String arg1, int arg2, TapMode arg3, boolean arg4) {
        super(arg1, arg2);
        this.mode = arg3;
        this.repeatEnabled = arg4;
    }

    public static EnumEntries getEntries() {
        return TapSettingsAction.$ENTRIES;
    }

    public final TapMode getMode() {
        return this.mode;
    }

    public final boolean getRepeatEnabled() {
        return this.repeatEnabled;
    }

    public static TapSettingsAction valueOf(String arg1) {
        return Enum.valueOf(TapSettingsAction.class, arg1);
    }

    public static TapSettingsAction[] values() {
        return TapSettingsAction.$VALUES.clone();
    }
}

