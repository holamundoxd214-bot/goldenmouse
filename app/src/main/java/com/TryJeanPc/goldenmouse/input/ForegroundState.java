package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/input/ForegroundState;", "", "gameForeground", "", "<init>", "(Ljava/lang/String;ILjava/lang/Boolean;)V", "getGameForeground", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "GAME", "OTHER", "UNKNOWN", "RECOVERING", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum ForegroundState {
    public static final enum ForegroundState GAME;
    public static final enum ForegroundState OTHER;
    public static final enum ForegroundState RECOVERING;
    public static final enum ForegroundState UNKNOWN;
    private final Boolean gameForeground;

    private static final ForegroundState[] $values() {
        return new ForegroundState[]{ForegroundState.GAME, ForegroundState.OTHER, ForegroundState.UNKNOWN, ForegroundState.RECOVERING};
    }

    static {
        ForegroundState.GAME = new ForegroundState("GAME", 0, Boolean.valueOf(true));
        ForegroundState.OTHER = new ForegroundState("OTHER", 1, Boolean.valueOf(false));
        ForegroundState.UNKNOWN = new ForegroundState("UNKNOWN", 2, null);
        ForegroundState.RECOVERING = new ForegroundState("RECOVERING", 3, null);
        ForegroundState[] v0 = ForegroundState.$values();
        ForegroundState.$VALUES = v0;
        ForegroundState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ForegroundState(String arg1, int arg2, Boolean arg3) {
        super(arg1, arg2);
        this.gameForeground = arg3;
    }

    public static EnumEntries getEntries() {
        return ForegroundState.$ENTRIES;
    }

    public final Boolean getGameForeground() {
        return this.gameForeground;
    }

    public static ForegroundState valueOf(String arg1) {
        return Enum.valueOf(ForegroundState.class, arg1);
    }

    public static ForegroundState[] values() {
        return ForegroundState.$VALUES.clone();
    }
}

