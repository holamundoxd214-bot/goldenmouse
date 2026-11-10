package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000B\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalRpcStage;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "ENCODE_REQUEST", "TRANSACT", "READ_EXCEPTION", "DECODE_REPLY", "TRAILING_DATA", "EVIDENCE_BINDING", "COMPLETE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchOriginalRpcStage {
    public static final enum StretchOriginalRpcStage COMPLETE;
    public static final enum StretchOriginalRpcStage DECODE_REPLY;
    public static final enum StretchOriginalRpcStage ENCODE_REQUEST;
    public static final enum StretchOriginalRpcStage EVIDENCE_BINDING;
    public static final enum StretchOriginalRpcStage NOT_STARTED;
    public static final enum StretchOriginalRpcStage READ_EXCEPTION;
    public static final enum StretchOriginalRpcStage TRAILING_DATA;
    public static final enum StretchOriginalRpcStage TRANSACT;

    private static final StretchOriginalRpcStage[] $values() {
        return new StretchOriginalRpcStage[]{StretchOriginalRpcStage.NOT_STARTED, StretchOriginalRpcStage.ENCODE_REQUEST, StretchOriginalRpcStage.TRANSACT, StretchOriginalRpcStage.READ_EXCEPTION, StretchOriginalRpcStage.DECODE_REPLY, StretchOriginalRpcStage.TRAILING_DATA, StretchOriginalRpcStage.EVIDENCE_BINDING, StretchOriginalRpcStage.COMPLETE};
    }

    static {
        StretchOriginalRpcStage.NOT_STARTED = new StretchOriginalRpcStage("NOT_STARTED", 0);
        StretchOriginalRpcStage.ENCODE_REQUEST = new StretchOriginalRpcStage("ENCODE_REQUEST", 1);
        StretchOriginalRpcStage.TRANSACT = new StretchOriginalRpcStage("TRANSACT", 2);
        StretchOriginalRpcStage.READ_EXCEPTION = new StretchOriginalRpcStage("READ_EXCEPTION", 3);
        StretchOriginalRpcStage.DECODE_REPLY = new StretchOriginalRpcStage("DECODE_REPLY", 4);
        StretchOriginalRpcStage.TRAILING_DATA = new StretchOriginalRpcStage("TRAILING_DATA", 5);
        StretchOriginalRpcStage.EVIDENCE_BINDING = new StretchOriginalRpcStage("EVIDENCE_BINDING", 6);
        StretchOriginalRpcStage.COMPLETE = new StretchOriginalRpcStage("COMPLETE", 7);
        StretchOriginalRpcStage[] v0 = StretchOriginalRpcStage.$values();
        StretchOriginalRpcStage.$VALUES = v0;
        StretchOriginalRpcStage.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchOriginalRpcStage(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchOriginalRpcStage.$ENTRIES;
    }

    public static StretchOriginalRpcStage valueOf(String arg1) {
        return Enum.valueOf(StretchOriginalRpcStage.class, arg1);
    }

    public static StretchOriginalRpcStage[] values() {
        return StretchOriginalRpcStage.$VALUES.clone();
    }
}

