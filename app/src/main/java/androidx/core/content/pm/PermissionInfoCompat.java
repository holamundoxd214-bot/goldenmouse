package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import android.os.Build$VERSION;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static int getProtection(PermissionInfo arg0) {
            return arg0.getProtection();
        }

        static int getProtectionFlags(PermissionInfo arg0) {
            return arg0.getProtectionFlags();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Protection {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
        super();
    }

    public static int getProtection(PermissionInfo arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getProtection(arg2);
        }

        return arg2.protectionLevel & 15;
    }

    public static int getProtectionFlags(PermissionInfo arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getProtectionFlags(arg2);
        }

        return arg2.protectionLevel & -16;
    }
}

