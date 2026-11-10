package androidx.core.os;

import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class UserHandleCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static UserHandle getUserHandleForUid(int arg0) {
            return UserHandle.getUserHandleForUid(arg0);
        }
    }

    private static Method sGetUserIdMethod;
    private static Constructor sUserHandleConstructor;

    private UserHandleCompat() {
        super();
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        if(UserHandleCompat.sGetUserIdMethod == null) {
            Method v0 = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
            UserHandleCompat.sGetUserIdMethod = v0;
            v0.setAccessible(true);
        }

        return UserHandleCompat.sGetUserIdMethod;
    }

    private static Constructor getUserHandleConstructor() throws NoSuchMethodException {
        if(UserHandleCompat.sUserHandleConstructor == null) {
            Constructor v0 = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
            UserHandleCompat.sUserHandleConstructor = v0;
            v0.setAccessible(true);
        }

        return UserHandleCompat.sUserHandleConstructor;
    }

    public static UserHandle getUserHandleForUid(int arg0) {
        return Api24Impl.getUserHandleForUid(arg0);
    }
}

