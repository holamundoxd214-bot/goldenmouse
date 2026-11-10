package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/SnackbarDuration;", "", "<init>", "(Ljava/lang/String;I)V", "Short", "Long", "Indefinite", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SnackbarDuration {
    public static final enum SnackbarDuration Indefinite;
    public static final enum SnackbarDuration Long;
    public static final enum SnackbarDuration Short;

    private static final SnackbarDuration[] $values() {
        return new SnackbarDuration[]{SnackbarDuration.Short, SnackbarDuration.Long, SnackbarDuration.Indefinite};
    }

    static {
        SnackbarDuration.Short = new SnackbarDuration("Short", 0);
        SnackbarDuration.Long = new SnackbarDuration("Long", 1);
        SnackbarDuration.Indefinite = new SnackbarDuration("Indefinite", 2);
        SnackbarDuration[] v0 = SnackbarDuration.$values();
        SnackbarDuration.$VALUES = v0;
        SnackbarDuration.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SnackbarDuration(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SnackbarDuration.$ENTRIES;
    }

    public static SnackbarDuration valueOf(String arg1) {
        return Enum.valueOf(SnackbarDuration.class, arg1);
    }

    public static SnackbarDuration[] values() {
        return SnackbarDuration.$VALUES.clone();
    }
}

