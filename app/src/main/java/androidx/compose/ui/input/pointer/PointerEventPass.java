package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/input/pointer/PointerEventPass;", "", "<init>", "(Ljava/lang/String;I)V", "Initial", "Main", "Final", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum PointerEventPass {
    public static final enum PointerEventPass Final;
    public static final enum PointerEventPass Initial;
    public static final enum PointerEventPass Main;

    private static final PointerEventPass[] $values() {
        return new PointerEventPass[]{PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final};
    }

    static {
        PointerEventPass.Initial = new PointerEventPass("Initial", 0);
        PointerEventPass.Main = new PointerEventPass("Main", 1);
        PointerEventPass.Final = new PointerEventPass("Final", 2);
        PointerEventPass[] v0 = PointerEventPass.$values();
        PointerEventPass.$VALUES = v0;
        PointerEventPass.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private PointerEventPass(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return PointerEventPass.$ENTRIES;
    }

    public static PointerEventPass valueOf(String arg1) {
        return Enum.valueOf(PointerEventPass.class, arg1);
    }

    public static PointerEventPass[] values() {
        return PointerEventPass.$VALUES.clone();
    }
}

