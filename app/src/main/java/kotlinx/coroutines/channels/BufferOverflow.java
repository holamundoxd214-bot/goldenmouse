package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlinx/coroutines/channels/BufferOverflow;", "", "<init>", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public enum BufferOverflow {
    public static final enum BufferOverflow DROP_LATEST;
    public static final enum BufferOverflow DROP_OLDEST;
    public static final enum BufferOverflow SUSPEND;

    private static final BufferOverflow[] $values() {
        return new BufferOverflow[]{BufferOverflow.SUSPEND, BufferOverflow.DROP_OLDEST, BufferOverflow.DROP_LATEST};
    }

    static {
        BufferOverflow.SUSPEND = new BufferOverflow("SUSPEND", 0);
        BufferOverflow.DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
        BufferOverflow.DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);
        BufferOverflow[] v0 = BufferOverflow.$values();
        BufferOverflow.$VALUES = v0;
        BufferOverflow.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private BufferOverflow(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return BufferOverflow.$ENTRIES;
    }

    public static BufferOverflow valueOf(String arg1) {
        return Enum.valueOf(BufferOverflow.class, arg1);
    }

    public static BufferOverflow[] values() {
        return BufferOverflow.$VALUES.clone();
    }
}

