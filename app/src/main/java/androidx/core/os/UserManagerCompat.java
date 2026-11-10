package androidx.core.os;

import android.content.Context;
import android.os.UserManager;

public class UserManagerCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static boolean isUserUnlocked(Context arg1) {
            return arg1.getSystemService(UserManager.class).isUserUnlocked();
        }
    }

    private UserManagerCompat() {
        super();
    }

    public static boolean isUserUnlocked(Context arg0) {
        return Api24Impl.isUserUnlocked(arg0);
    }
}

