package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/text/selection/CrossStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CROSSED", "NOT_CROSSED", "COLLAPSED", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum CrossStatus {
    public static final enum CrossStatus COLLAPSED;
    public static final enum CrossStatus CROSSED;
    public static final enum CrossStatus NOT_CROSSED;

    private static final CrossStatus[] $values() {
        return new CrossStatus[]{CrossStatus.CROSSED, CrossStatus.NOT_CROSSED, CrossStatus.COLLAPSED};
    }

    static {
        CrossStatus.CROSSED = new CrossStatus("CROSSED", 0);
        CrossStatus.NOT_CROSSED = new CrossStatus("NOT_CROSSED", 1);
        CrossStatus.COLLAPSED = new CrossStatus("COLLAPSED", 2);
        CrossStatus[] v0 = CrossStatus.$values();
        CrossStatus.$VALUES = v0;
        CrossStatus.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CrossStatus(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CrossStatus.$ENTRIES;
    }

    public static CrossStatus valueOf(String arg1) {
        return Enum.valueOf(CrossStatus.class, arg1);
    }

    public static CrossStatus[] values() {
        return CrossStatus.$VALUES.clone();
    }
}

