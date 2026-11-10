package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.IBinder;

public final class AppLocalesMetadataHolderService extends Service {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static int getDisabledComponentFlag() {
            return 0x200;
        }
    }

    public AppLocalesMetadataHolderService() {
        super();
    }

    public static ServiceInfo getServiceInfo(Context arg4) throws PackageManager$NameNotFoundException {
        return arg4.getPackageManager().getServiceInfo(new ComponentName(arg4, AppLocalesMetadataHolderService.class), Api24Impl.getDisabledComponentFlag() | 0x80);
    }

    public IBinder onBind(Intent arg1) {
        throw new UnsupportedOperationException();
    }
}

