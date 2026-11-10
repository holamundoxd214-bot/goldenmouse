package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlinx/coroutines/flow/SharingCommand;", "", "<init>", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public enum SharingCommand {
    public static final enum SharingCommand START;
    public static final enum SharingCommand STOP;
    public static final enum SharingCommand STOP_AND_RESET_REPLAY_CACHE;

    private static final SharingCommand[] $values() {
        return new SharingCommand[]{SharingCommand.START, SharingCommand.STOP, SharingCommand.STOP_AND_RESET_REPLAY_CACHE};
    }

    static {
        SharingCommand.START = new SharingCommand("START", 0);
        SharingCommand.STOP = new SharingCommand("STOP", 1);
        SharingCommand.STOP_AND_RESET_REPLAY_CACHE = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        SharingCommand[] v0 = SharingCommand.$values();
        SharingCommand.$VALUES = v0;
        SharingCommand.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SharingCommand(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SharingCommand.$ENTRIES;
    }

    public static SharingCommand valueOf(String arg1) {
        return Enum.valueOf(SharingCommand.class, arg1);
    }

    public static SharingCommand[] values() {
        return SharingCommand.$VALUES.clone();
    }
}

