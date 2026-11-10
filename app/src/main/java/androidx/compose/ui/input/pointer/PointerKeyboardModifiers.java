package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÖ\u0001J\t\u0010\f\u001A\u00020\rHÖ\u0001R\u0014\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006\u000E"}, d2={"Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "", "packedValue", "", "Landroidx/compose/ui/input/pointer/NativePointerKeyboardModifiers;", "constructor-impl", "(I)I", "I", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class PointerKeyboardModifiers {
    private final int packedValue;

    private PointerKeyboardModifiers(int arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final PointerKeyboardModifiers box-impl(int arg1) {
        return new PointerKeyboardModifiers(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return PointerKeyboardModifiers.equals-impl(this.packedValue, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof PointerKeyboardModifiers)) {
            return 0;
        }

        if(arg2 != ((PointerKeyboardModifiers)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return PointerKeyboardModifiers.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return PointerKeyboardModifiers.toString-impl(this.packedValue);
    }

    public static String toString-impl(int arg2) {
        return "PointerKeyboardModifiers(packedValue=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.packedValue;
    }
}

