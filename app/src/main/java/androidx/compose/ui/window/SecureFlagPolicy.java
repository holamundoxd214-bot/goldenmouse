package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/window/SecureFlagPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Inherit", "SecureOn", "SecureOff", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum SecureFlagPolicy {
    public static final enum SecureFlagPolicy Inherit;
    public static final enum SecureFlagPolicy SecureOff;
    public static final enum SecureFlagPolicy SecureOn;

    private static final SecureFlagPolicy[] $values() {
        return new SecureFlagPolicy[]{SecureFlagPolicy.Inherit, SecureFlagPolicy.SecureOn, SecureFlagPolicy.SecureOff};
    }

    static {
        SecureFlagPolicy.Inherit = new SecureFlagPolicy("Inherit", 0);
        SecureFlagPolicy.SecureOn = new SecureFlagPolicy("SecureOn", 1);
        SecureFlagPolicy.SecureOff = new SecureFlagPolicy("SecureOff", 2);
        SecureFlagPolicy[] v0 = SecureFlagPolicy.$values();
        SecureFlagPolicy.$VALUES = v0;
        SecureFlagPolicy.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SecureFlagPolicy(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return SecureFlagPolicy.$ENTRIES;
    }

    public static SecureFlagPolicy valueOf(String arg1) {
        return Enum.valueOf(SecureFlagPolicy.class, arg1);
    }

    public static SecureFlagPolicy[] values() {
        return SecureFlagPolicy.$VALUES.clone();
    }
}

