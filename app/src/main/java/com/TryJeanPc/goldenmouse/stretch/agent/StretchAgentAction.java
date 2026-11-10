package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentAction;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "READ_BASELINE", "PREPARE", "REQUEST_SIZE", "REQUEST_PROJECTION", "REQUEST_RESTORE", "CONFIRM", "HEARTBEAT", "STATUS", "CLOSE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchAgentAction {
    public static final enum StretchAgentAction CLOSE;
    public static final enum StretchAgentAction CONFIRM;
    public static final enum StretchAgentAction HEARTBEAT;
    public static final enum StretchAgentAction OPEN;
    public static final enum StretchAgentAction PREPARE;
    public static final enum StretchAgentAction READ_BASELINE;
    public static final enum StretchAgentAction REQUEST_PROJECTION;
    public static final enum StretchAgentAction REQUEST_RESTORE;
    public static final enum StretchAgentAction REQUEST_SIZE;
    public static final enum StretchAgentAction STATUS;

    private static final StretchAgentAction[] $values() {
        return new StretchAgentAction[]{StretchAgentAction.OPEN, StretchAgentAction.READ_BASELINE, StretchAgentAction.PREPARE, StretchAgentAction.REQUEST_SIZE, StretchAgentAction.REQUEST_PROJECTION, StretchAgentAction.REQUEST_RESTORE, StretchAgentAction.CONFIRM, StretchAgentAction.HEARTBEAT, StretchAgentAction.STATUS, StretchAgentAction.CLOSE};
    }

    static {
        StretchAgentAction.OPEN = new StretchAgentAction("OPEN", 0);
        StretchAgentAction.READ_BASELINE = new StretchAgentAction("READ_BASELINE", 1);
        StretchAgentAction.PREPARE = new StretchAgentAction("PREPARE", 2);
        StretchAgentAction.REQUEST_SIZE = new StretchAgentAction("REQUEST_SIZE", 3);
        StretchAgentAction.REQUEST_PROJECTION = new StretchAgentAction("REQUEST_PROJECTION", 4);
        StretchAgentAction.REQUEST_RESTORE = new StretchAgentAction("REQUEST_RESTORE", 5);
        StretchAgentAction.CONFIRM = new StretchAgentAction("CONFIRM", 6);
        StretchAgentAction.HEARTBEAT = new StretchAgentAction("HEARTBEAT", 7);
        StretchAgentAction.STATUS = new StretchAgentAction("STATUS", 8);
        StretchAgentAction.CLOSE = new StretchAgentAction("CLOSE", 9);
        StretchAgentAction[] v0 = StretchAgentAction.$values();
        StretchAgentAction.$VALUES = v0;
        StretchAgentAction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchAgentAction(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchAgentAction.$ENTRIES;
    }

    public static StretchAgentAction valueOf(String arg1) {
        return Enum.valueOf(StretchAgentAction.class, arg1);
    }

    public static StretchAgentAction[] values() {
        return StretchAgentAction.$VALUES.clone();
    }
}

