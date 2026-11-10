package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/foundation/MutatePriority;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "UserInput", "PreventUserInput", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum MutatePriority {
    public static final enum MutatePriority Default;
    public static final enum MutatePriority PreventUserInput;
    public static final enum MutatePriority UserInput;

    private static final MutatePriority[] $values() {
        return new MutatePriority[]{MutatePriority.Default, MutatePriority.UserInput, MutatePriority.PreventUserInput};
    }

    static {
        MutatePriority.Default = new MutatePriority("Default", 0);
        MutatePriority.UserInput = new MutatePriority("UserInput", 1);
        MutatePriority.PreventUserInput = new MutatePriority("PreventUserInput", 2);
        MutatePriority[] v0 = MutatePriority.$values();
        MutatePriority.$VALUES = v0;
        MutatePriority.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private MutatePriority(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return MutatePriority.$ENTRIES;
    }

    public static MutatePriority valueOf(String arg1) {
        return Enum.valueOf(MutatePriority.class, arg1);
    }

    public static MutatePriority[] values() {
        return MutatePriority.$VALUES.clone();
    }
}

