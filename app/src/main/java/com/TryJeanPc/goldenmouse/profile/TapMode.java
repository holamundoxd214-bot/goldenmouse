package com.TryJeanPc.goldenmouse.profile;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/TapMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "REPEATING", "HOLD", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum TapMode {
    public static final enum TapMode HOLD;
    public static final enum TapMode REPEATING;
    public static final enum TapMode SINGLE;

    private static final TapMode[] $values() {
        return new TapMode[]{TapMode.SINGLE, TapMode.REPEATING, TapMode.HOLD};
    }

    static {
        TapMode.SINGLE = new TapMode("SINGLE", 0);
        TapMode.REPEATING = new TapMode("REPEATING", 1);
        TapMode.HOLD = new TapMode("HOLD", 2);
        TapMode[] v0 = TapMode.$values();
        TapMode.$VALUES = v0;
        TapMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TapMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TapMode.$ENTRIES;
    }

    public static TapMode valueOf(String arg1) {
        return Enum.valueOf(TapMode.class, arg1);
    }

    public static TapMode[] values() {
        return TapMode.$VALUES.clone();
    }
}

