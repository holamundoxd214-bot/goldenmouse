package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build$VERSION;
import android.service.quicksettings.TileService;

public class TileServiceCompat {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static void startActivityAndCollapse(TileService arg0, Intent arg1) {
            arg0.startActivityAndCollapse(arg1);
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static void startActivityAndCollapse(TileService arg0, PendingIntent arg1) {
            arg0.startActivityAndCollapse(arg1);
        }
    }

    interface TileServiceWrapper {
        void startActivityAndCollapse(PendingIntent arg1);

        void startActivityAndCollapse(Intent arg1);
    }

    private static TileServiceWrapper sTileServiceWrapper;

    private TileServiceCompat() {
        super();
    }

    public static void clearTileServiceWrapper() {
        TileServiceCompat.sTileServiceWrapper = null;
    }

    public static void setTileServiceWrapper(TileServiceWrapper arg0) {
        TileServiceCompat.sTileServiceWrapper = arg0;
    }

    public static void startActivityAndCollapse(TileService arg2, PendingIntentActivityWrapper arg3) {
        TileServiceWrapper v0;
        if(Build$VERSION.SDK_INT >= 34) {
            v0 = TileServiceCompat.sTileServiceWrapper;
            if(v0 != null) {
                v0.startActivityAndCollapse(arg3.getPendingIntent());
                return;
            }

            Api34Impl.startActivityAndCollapse(arg2, arg3.getPendingIntent());
            return;
        }

        v0 = TileServiceCompat.sTileServiceWrapper;
        if(v0 != null) {
            v0.startActivityAndCollapse(arg3.getIntent());
            return;
        }

        Api24Impl.startActivityAndCollapse(arg2, arg3.getIntent());
    }
}

