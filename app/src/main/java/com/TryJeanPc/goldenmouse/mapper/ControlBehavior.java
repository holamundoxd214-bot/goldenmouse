package com.TryJeanPc.goldenmouse.mapper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/ControlBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "TAP", "FIRE", "JOYSTICK", "AIM", "MACRO", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum ControlBehavior {
    public static final enum ControlBehavior AIM;
    public static final enum ControlBehavior FIRE;
    public static final enum ControlBehavior JOYSTICK;
    public static final enum ControlBehavior MACRO;
    public static final enum ControlBehavior TAP;

    private static final ControlBehavior[] $values() {
        return new ControlBehavior[]{ControlBehavior.TAP, ControlBehavior.FIRE, ControlBehavior.JOYSTICK, ControlBehavior.AIM, ControlBehavior.MACRO};
    }

    static {
        ControlBehavior.TAP = new ControlBehavior("TAP", 0);
        ControlBehavior.FIRE = new ControlBehavior("FIRE", 1);
        ControlBehavior.JOYSTICK = new ControlBehavior("JOYSTICK", 2);
        ControlBehavior.AIM = new ControlBehavior("AIM", 3);
        ControlBehavior.MACRO = new ControlBehavior("MACRO", 4);
        ControlBehavior[] v0 = ControlBehavior.$values();
        ControlBehavior.$VALUES = v0;
        ControlBehavior.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ControlBehavior(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ControlBehavior.$ENTRIES;
    }

    public static ControlBehavior valueOf(String arg1) {
        return Enum.valueOf(ControlBehavior.class, arg1);
    }

    public static ControlBehavior[] values() {
        return ControlBehavior.$VALUES.clone();
    }
}

