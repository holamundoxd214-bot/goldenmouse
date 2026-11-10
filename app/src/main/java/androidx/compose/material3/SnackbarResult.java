package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/material3/SnackbarResult;", "", "<init>", "(Ljava/lang/String;I)V", "Dismissed", "ActionPerformed", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SnackbarResult {
    public static final enum SnackbarResult ActionPerformed;
    public static final enum SnackbarResult Dismissed;

    private static final SnackbarResult[] $values() {
        return new SnackbarResult[]{SnackbarResult.Dismissed, SnackbarResult.ActionPerformed};
    }

    static {
        SnackbarResult.Dismissed = new SnackbarResult("Dismissed", 0);
        SnackbarResult.ActionPerformed = new SnackbarResult("ActionPerformed", 1);
        SnackbarResult[] v0 = SnackbarResult.$values();
        SnackbarResult.$VALUES = v0;
        SnackbarResult.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SnackbarResult(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SnackbarResult.$ENTRIES;
    }

    public static SnackbarResult valueOf(String arg1) {
        return Enum.valueOf(SnackbarResult.class, arg1);
    }

    public static SnackbarResult[] values() {
        return SnackbarResult.$VALUES.clone();
    }
}

