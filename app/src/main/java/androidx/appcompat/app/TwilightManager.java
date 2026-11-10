package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager {
    class TwilightState {
        boolean isNight;
        long nextUpdate;

        TwilightState() {
            super();
        }
    }

    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState;
    private static TwilightManager sInstance;

    TwilightManager(Context arg2, LocationManager arg3) {
        super();
        this.mTwilightState = new TwilightState();
        this.mContext = arg2;
        this.mLocationManager = arg3;
    }

    static TwilightManager getInstance(Context arg2) {
        TwilightManager v0 = TwilightManager.sInstance;
        if(v0 == null) {
            arg2 = arg2.getApplicationContext();
            v0 = new TwilightManager(arg2, arg2.getSystemService("location"));
            TwilightManager.sInstance = v0;
        }

        return v0;
    }

    private Location getLastKnownLocation() {
        Location v1 = null;
        Location v0 = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? this.getLastKnownLocationForProvider("network") : v1;
        if(PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            v1 = this.getLastKnownLocationForProvider("gps");
        }

        if(v1 == null || v0 == null) {
            if(v1 != null) {
                return v1;
            }
        }
        else if(v1.getTime() > v0.getTime()) {
            return v1;
        }

        return v0;
    }

    private Location getLastKnownLocationForProvider(String arg2) {
        try {
            if(!this.mLocationManager.isProviderEnabled(arg2)) {
                return null;
            }

            return this.mLocationManager.getLastKnownLocation(arg2);
        }
        catch(Exception v1) {
            Log.d("TwilightManager", "Failed to get last known location", ((Throwable)v1));
        }

        return null;
    }

    boolean isNight() {
        TwilightState v0 = this.mTwilightState;
        if(this.isStateValid()) {
            return v0.isNight;
        }

        Location v1 = this.getLastKnownLocation();
        if(v1 != null) {
            this.updateState(v1);
            return v0.isNight;
        }

        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int v2 = Calendar.getInstance().get(11);
        if(v2 >= 6) {
            if(v2 >= 22) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isStateValid() {
        if(this.mTwilightState.nextUpdate > System.currentTimeMillis()) {
            return 1;
        }

        return 0;
    }

    static void setInstance(TwilightManager arg0) {
        TwilightManager.sInstance = arg0;
    }

    private void updateState(Location arg18) {
        TwilightState v0 = this.mTwilightState;
        long v2 = System.currentTimeMillis();
        TwilightCalculator v4 = TwilightCalculator.getInstance();
        long v11 = 86400000;
        v4.calculateTwilight(v2 - v11, arg18.getLatitude(), arg18.getLongitude());
        v4.calculateTwilight(v2, arg18.getLatitude(), arg18.getLongitude());
        v4 = v4;
        boolean v5 = true;
        if(v4.state == 1) {
        }
        else {
            v5 = false;
        }

        boolean v1 = v5;
        long v13 = v4.sunrise;
        long v5_1 = v2 + v11;
        v11 = v4.sunset;
        v4.calculateTwilight(v5_1, arg18.getLatitude(), arg18.getLongitude());
        long v4_1 = v4.sunrise;
        long v6 = -1;
        if(v13 == v6 || v11 == v6) {
            v13 = v2 + 43200000;
        }
        else {
            if(v2 > v11) {
                v13 = v4_1;
            }
            else if(v2 > v13) {
                v13 = v11;
            }

            v13 += 60000;
        }

        v0.isNight = v1;
        v0.nextUpdate = v13;
    }
}

