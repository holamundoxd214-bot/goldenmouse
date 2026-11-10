package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u000BR\u0014\u0010\f\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0014\u0010\u000E\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000Bj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000F"}, d2={"Landroidx/compose/ui/focus/FocusStateImpl;", "Landroidx/compose/ui/focus/FocusState;", "", "<init>", "(Ljava/lang/String;I)V", "Active", "ActiveParent", "Captured", "Inactive", "isFocused", "", "()Z", "hasFocus", "getHasFocus", "isCaptured", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum FocusStateImpl implements FocusState {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[FocusStateImpl.values().length];
            try {
                v0[FocusStateImpl.Captured.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[FocusStateImpl.Active.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[FocusStateImpl.ActiveParent.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[FocusStateImpl.Inactive.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final enum FocusStateImpl Active;
    public static final enum FocusStateImpl ActiveParent;
    public static final enum FocusStateImpl Captured;
    public static final enum FocusStateImpl Inactive;

    private static final FocusStateImpl[] $values() {
        return new FocusStateImpl[]{FocusStateImpl.Active, FocusStateImpl.ActiveParent, FocusStateImpl.Captured, FocusStateImpl.Inactive};
    }

    static {
        FocusStateImpl.Active = new FocusStateImpl("Active", 0);
        FocusStateImpl.ActiveParent = new FocusStateImpl("ActiveParent", 1);
        FocusStateImpl.Captured = new FocusStateImpl("Captured", 2);
        FocusStateImpl.Inactive = new FocusStateImpl("Inactive", 3);
        FocusStateImpl[] v0 = FocusStateImpl.$values();
        FocusStateImpl.$VALUES = v0;
        FocusStateImpl.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private FocusStateImpl(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return FocusStateImpl.$ENTRIES;
    }

    public boolean getHasFocus() {
        int v2 = WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
        if(v2 != 1 && v2 != 2 && v2 != 3) {
            if(v2 == 4) {
                return 0;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        return 1;
    }

    public boolean isCaptured() {
        int v1 = WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
        if(v1 != 1) {
            if(v1 != 2 && v1 != 3) {
                if(v1 == 4) {
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            return 0;
        }

        return 1;
    }

    public boolean isFocused() {
        int v2 = WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
        if(v2 != 1 && v2 != 2) {
            if(v2 != 3) {
                if(v2 == 4) {
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            return 0;
        }

        return 1;
    }

    public static FocusStateImpl valueOf(String arg1) {
        return Enum.valueOf(FocusStateImpl.class, arg1);
    }

    public static FocusStateImpl[] values() {
        return FocusStateImpl.$VALUES.clone();
    }
}

