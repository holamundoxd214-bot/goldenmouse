package androidx.window.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/window/core/VerificationMode;", "", "<init>", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public enum VerificationMode {
    public static final enum VerificationMode LOG;
    public static final enum VerificationMode QUIET;
    public static final enum VerificationMode STRICT;

    private static final VerificationMode[] $values() {
        return new VerificationMode[]{VerificationMode.STRICT, VerificationMode.LOG, VerificationMode.QUIET};
    }

    static {
        VerificationMode.STRICT = new VerificationMode("STRICT", 0);
        VerificationMode.LOG = new VerificationMode("LOG", 1);
        VerificationMode.QUIET = new VerificationMode("QUIET", 2);
        VerificationMode[] v0 = VerificationMode.$values();
        VerificationMode.$VALUES = v0;
        VerificationMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private VerificationMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return VerificationMode.$ENTRIES;
    }

    public static VerificationMode valueOf(String arg1) {
        return Enum.valueOf(VerificationMode.class, arg1);
    }

    public static VerificationMode[] values() {
        return VerificationMode.$VALUES.clone();
    }
}

