package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Lkotlinx/coroutines/channels/TickerMode;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public enum TickerMode {
    public static final enum TickerMode FIXED_DELAY;
    public static final enum TickerMode FIXED_PERIOD;

    private static final TickerMode[] $values() {
        return new TickerMode[]{TickerMode.FIXED_PERIOD, TickerMode.FIXED_DELAY};
    }

    static {
        TickerMode.FIXED_PERIOD = new TickerMode("FIXED_PERIOD", 0);
        TickerMode.FIXED_DELAY = new TickerMode("FIXED_DELAY", 1);
        TickerMode[] v0 = TickerMode.$values();
        TickerMode.$VALUES = v0;
        TickerMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TickerMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TickerMode.$ENTRIES;
    }

    public static TickerMode valueOf(String arg1) {
        return Enum.valueOf(TickerMode.class, arg1);
    }

    public static TickerMode[] values() {
        return TickerMode.$VALUES.clone();
    }
}

