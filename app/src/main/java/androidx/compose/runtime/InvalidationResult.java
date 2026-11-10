package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/runtime/InvalidationResult;", "", "<init>", "(Ljava/lang/String;I)V", "IGNORED", "SCHEDULED", "DEFERRED", "IMMINENT", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public enum InvalidationResult {
    public static final enum InvalidationResult DEFERRED;
    public static final enum InvalidationResult IGNORED;
    public static final enum InvalidationResult IMMINENT;
    public static final enum InvalidationResult SCHEDULED;

    private static final InvalidationResult[] $values() {
        return new InvalidationResult[]{InvalidationResult.IGNORED, InvalidationResult.SCHEDULED, InvalidationResult.DEFERRED, InvalidationResult.IMMINENT};
    }

    static {
        InvalidationResult.IGNORED = new InvalidationResult("IGNORED", 0);
        InvalidationResult.SCHEDULED = new InvalidationResult("SCHEDULED", 1);
        InvalidationResult.DEFERRED = new InvalidationResult("DEFERRED", 2);
        InvalidationResult.IMMINENT = new InvalidationResult("IMMINENT", 3);
        InvalidationResult[] v0 = InvalidationResult.$values();
        InvalidationResult.$VALUES = v0;
        InvalidationResult.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private InvalidationResult(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return InvalidationResult.$ENTRIES;
    }

    public static InvalidationResult valueOf(String arg1) {
        return Enum.valueOf(InvalidationResult.class, arg1);
    }

    public static InvalidationResult[] values() {
        return InvalidationResult.$VALUES.clone();
    }
}

