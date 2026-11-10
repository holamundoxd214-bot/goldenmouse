package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService extends Service {
    public NotificationCompatSideChannelService() {
        super();
    }

    public abstract void cancel(String arg1, int arg2, String arg3);

    public abstract void cancelAll(String arg1);

    public abstract void notify(String arg1, int arg2, String arg3, Notification arg4);

    public IBinder onBind(Intent arg1) {
        return null;
    }
}

