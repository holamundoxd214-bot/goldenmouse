package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/focus/CustomDestinationResult;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Cancelled", "Redirected", "RedirectCancelled", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum CustomDestinationResult {
    public static final enum CustomDestinationResult Cancelled;
    public static final enum CustomDestinationResult None;
    public static final enum CustomDestinationResult RedirectCancelled;
    public static final enum CustomDestinationResult Redirected;

    private static final CustomDestinationResult[] $values() {
        return new CustomDestinationResult[]{CustomDestinationResult.None, CustomDestinationResult.Cancelled, CustomDestinationResult.Redirected, CustomDestinationResult.RedirectCancelled};
    }

    static {
        CustomDestinationResult.None = new CustomDestinationResult("None", 0);
        CustomDestinationResult.Cancelled = new CustomDestinationResult("Cancelled", 1);
        CustomDestinationResult.Redirected = new CustomDestinationResult("Redirected", 2);
        CustomDestinationResult.RedirectCancelled = new CustomDestinationResult("RedirectCancelled", 3);
        CustomDestinationResult[] v0 = CustomDestinationResult.$values();
        CustomDestinationResult.$VALUES = v0;
        CustomDestinationResult.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private CustomDestinationResult(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return CustomDestinationResult.$ENTRIES;
    }

    public static CustomDestinationResult valueOf(String arg1) {
        return Enum.valueOf(CustomDestinationResult.class, arg1);
    }

    public static CustomDestinationResult[] values() {
        return CustomDestinationResult.$VALUES.clone();
    }
}

