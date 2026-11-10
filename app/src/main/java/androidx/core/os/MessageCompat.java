package androidx.core.os;

import android.os.Message;

public final class MessageCompat {
    private MessageCompat() {
        super();
    }

    public static boolean isAsynchronous(Message arg0) {
        return arg0.isAsynchronous();
    }

    public static void setAsynchronous(Message arg0, boolean arg1) {
        arg0.setAsynchronous(arg1);
    }
}

