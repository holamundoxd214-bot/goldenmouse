package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\u0007\u0012\u0006\u0010\u000B\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u0013\u0010\u0015\u001A\u00020\u00072\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\n\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0010R\u0011\u0010\u000B\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0010\u0088\u0001\u0002¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/text/MenuItemsAvailability;", "", "value", "", "constructor-impl", "(I)I", "canCopy", "", "canPaste", "canCut", "canSelectAll", "canAutofill", "(ZZZZZ)I", "getValue", "()I", "getCanCopy-impl", "(I)Z", "getCanPaste-impl", "getCanCut-impl", "getCanSelectAll-impl", "getCanAutofill-impl", "equals", "other", "hashCode", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class MenuItemsAvailability {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u000B\u001A\u00020\f¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/MenuItemsAvailability$Companion;", "", "<init>", "()V", "COPY", "", "PASTE", "CUT", "SELECT_ALL", "AUTO_FILL", "NONE", "None", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "getNone-JKCFgKw", "()I", "I", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getNone-JKCFgKw() {
            return MenuItemsAvailability.None;
        }
    }

    private static final int AUTO_FILL = 16;
    private static final int COPY = 1;
    private static final int CUT = 4;
    public static final Companion Companion = null;
    private static final int NONE = 0;
    private static final int None = 0;
    private static final int PASTE = 2;
    private static final int SELECT_ALL = 8;
    private final int value;

    static {
        MenuItemsAvailability.Companion = new Companion(null);
        MenuItemsAvailability.None = MenuItemsAvailability.constructor-impl(0);
    }

    private MenuItemsAvailability(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getNone$cp() {
        return MenuItemsAvailability.None;
    }

    public static final MenuItemsAvailability box-impl(int arg1) {
        return new MenuItemsAvailability(arg1);
    }

    public static int constructor-impl(boolean arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5) {
        int v0 = 0;
        int v2 = arg2 ? 2 : 0;
        int v1 = (((int)arg1)) | v2;
        v2 = arg3 ? 4 : 0;
        v1 |= v2;
        v2 = arg4 ? 8 : 0;
        v1 |= v2;
        if(arg5) {
            v0 = 16;
        }

        return MenuItemsAvailability.constructor-impl(v1 | v0);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return MenuItemsAvailability.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof MenuItemsAvailability)) {
            return 0;
        }

        if(arg2 != ((MenuItemsAvailability)arg3).unbox-impl()) {
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

    public static final boolean getCanAutofill-impl(int arg1) {
        if((arg1 & 16) == 16) {
            return 1;
        }

        return 0;
    }

    public static final boolean getCanCopy-impl(int arg1) {
        if((arg1 & 1) == 1) {
            return 1;
        }

        return 0;
    }

    public static final boolean getCanCut-impl(int arg1) {
        if((arg1 & 4) == 4) {
            return 1;
        }

        return 0;
    }

    public static final boolean getCanPaste-impl(int arg1) {
        if((arg1 & 2) == 2) {
            return 1;
        }

        return 0;
    }

    public static final boolean getCanSelectAll-impl(int arg1) {
        if((arg1 & 8) == 8) {
            return 1;
        }

        return 0;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return MenuItemsAvailability.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return MenuItemsAvailability.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "MenuItemsAvailability(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

