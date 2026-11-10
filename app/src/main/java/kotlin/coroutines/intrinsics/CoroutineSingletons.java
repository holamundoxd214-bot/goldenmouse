package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "<init>", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum CoroutineSingletons {
    public static final enum CoroutineSingletons COROUTINE_SUSPENDED;
    public static final enum CoroutineSingletons RESUMED;
    public static final enum CoroutineSingletons UNDECIDED;

    private static final CoroutineSingletons[] $values() {
        return new CoroutineSingletons[]{CoroutineSingletons.COROUTINE_SUSPENDED, CoroutineSingletons.UNDECIDED, CoroutineSingletons.RESUMED};
    }

    static {
        CoroutineSingletons.COROUTINE_SUSPENDED = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        CoroutineSingletons.UNDECIDED = new CoroutineSingletons("UNDECIDED", 1);
        CoroutineSingletons.RESUMED = new CoroutineSingletons("RESUMED", 2);
        CoroutineSingletons[] v0 = CoroutineSingletons.$values();
        CoroutineSingletons.$VALUES = v0;
        CoroutineSingletons.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CoroutineSingletons(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CoroutineSingletons.$ENTRIES;
    }

    public static CoroutineSingletons valueOf(String arg1) {
        return Enum.valueOf(CoroutineSingletons.class, arg1);
    }

    public static CoroutineSingletons[] values() {
        return CoroutineSingletons.$VALUES.clone();
    }
}

