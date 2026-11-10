package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyEvent;", "", "<init>", "(Ljava/lang/String;I)V", "POLL", "UI_LOST", "OWNER_PROCESS_LOST", "AGENT_PROCESS_LOST", "PRIVILEGE_LOST", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum CustodyEvent {
    public static final enum CustodyEvent AGENT_PROCESS_LOST;
    public static final enum CustodyEvent OWNER_PROCESS_LOST;
    public static final enum CustodyEvent POLL;
    public static final enum CustodyEvent PRIVILEGE_LOST;
    public static final enum CustodyEvent UI_LOST;

    private static final CustodyEvent[] $values() {
        return new CustodyEvent[]{CustodyEvent.POLL, CustodyEvent.UI_LOST, CustodyEvent.OWNER_PROCESS_LOST, CustodyEvent.AGENT_PROCESS_LOST, CustodyEvent.PRIVILEGE_LOST};
    }

    static {
        CustodyEvent.POLL = new CustodyEvent("POLL", 0);
        CustodyEvent.UI_LOST = new CustodyEvent("UI_LOST", 1);
        CustodyEvent.OWNER_PROCESS_LOST = new CustodyEvent("OWNER_PROCESS_LOST", 2);
        CustodyEvent.AGENT_PROCESS_LOST = new CustodyEvent("AGENT_PROCESS_LOST", 3);
        CustodyEvent.PRIVILEGE_LOST = new CustodyEvent("PRIVILEGE_LOST", 4);
        CustodyEvent[] v0 = CustodyEvent.$values();
        CustodyEvent.$VALUES = v0;
        CustodyEvent.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CustodyEvent(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CustodyEvent.$ENTRIES;
    }

    public static CustodyEvent valueOf(String arg1) {
        return Enum.valueOf(CustodyEvent.class, arg1);
    }

    public static CustodyEvent[] values() {
        return CustodyEvent.$VALUES.clone();
    }
}

