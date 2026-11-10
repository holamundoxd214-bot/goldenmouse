package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/material3/internal/InputPhase;", "", "<init>", "(Ljava/lang/String;I)V", "Focused", "UnfocusedEmpty", "UnfocusedNotEmpty", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) enum InputPhase {
    public static final enum InputPhase Focused;
    public static final enum InputPhase UnfocusedEmpty;
    public static final enum InputPhase UnfocusedNotEmpty;

    private static final InputPhase[] $values() {
        return new InputPhase[]{InputPhase.Focused, InputPhase.UnfocusedEmpty, InputPhase.UnfocusedNotEmpty};
    }

    static {
        InputPhase.Focused = new InputPhase("Focused", 0);
        InputPhase.UnfocusedEmpty = new InputPhase("UnfocusedEmpty", 1);
        InputPhase.UnfocusedNotEmpty = new InputPhase("UnfocusedNotEmpty", 2);
        InputPhase[] v0 = InputPhase.$values();
        InputPhase.$VALUES = v0;
        InputPhase.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private InputPhase(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return InputPhase.$ENTRIES;
    }

    public static InputPhase valueOf(String arg1) {
        return Enum.valueOf(InputPhase.class, arg1);
    }

    public static InputPhase[] values() {
        return InputPhase.$VALUES.clone();
    }
}

