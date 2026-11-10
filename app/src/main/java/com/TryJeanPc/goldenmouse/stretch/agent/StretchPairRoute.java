package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPairRoute;", "", "<init>", "(Ljava/lang/String;I)V", "CLASSIC_FULL", "PRO_CUSTOM_BASE", "UNAVAILABLE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchPairRoute {
    public static final enum StretchPairRoute CLASSIC_FULL;
    public static final enum StretchPairRoute PRO_CUSTOM_BASE;
    public static final enum StretchPairRoute UNAVAILABLE;

    private static final StretchPairRoute[] $values() {
        return new StretchPairRoute[]{StretchPairRoute.CLASSIC_FULL, StretchPairRoute.PRO_CUSTOM_BASE, StretchPairRoute.UNAVAILABLE};
    }

    static {
        StretchPairRoute.CLASSIC_FULL = new StretchPairRoute("CLASSIC_FULL", 0);
        StretchPairRoute.PRO_CUSTOM_BASE = new StretchPairRoute("PRO_CUSTOM_BASE", 1);
        StretchPairRoute.UNAVAILABLE = new StretchPairRoute("UNAVAILABLE", 2);
        StretchPairRoute[] v0 = StretchPairRoute.$values();
        StretchPairRoute.$VALUES = v0;
        StretchPairRoute.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchPairRoute(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchPairRoute.$ENTRIES;
    }

    public static StretchPairRoute valueOf(String arg1) {
        return Enum.valueOf(StretchPairRoute.class, arg1);
    }

    public static StretchPairRoute[] values() {
        return StretchPairRoute.$VALUES.clone();
    }
}

