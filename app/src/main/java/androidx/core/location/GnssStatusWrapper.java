package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build$VERSION;
import androidx.core.util.Preconditions;

class GnssStatusWrapper extends GnssStatusCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static float getCarrierFrequencyHz(GnssStatus arg0, int arg1) {
            return arg0.getCarrierFrequencyHz(arg1);
        }

        static boolean hasCarrierFrequencyHz(GnssStatus arg0, int arg1) {
            return arg0.hasCarrierFrequencyHz(arg1);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static float getBasebandCn0DbHz(GnssStatus arg0, int arg1) {
            return arg0.getBasebandCn0DbHz(arg1);
        }

        static boolean hasBasebandCn0DbHz(GnssStatus arg0, int arg1) {
            return arg0.hasBasebandCn0DbHz(arg1);
        }
    }

    private final GnssStatus mWrapped;

    GnssStatusWrapper(Object arg1) {
        super();
        this.mWrapped = Preconditions.checkNotNull(arg1);
    }

    public boolean equals(Object arg2) {
        if(this == (((GnssStatusWrapper)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof GnssStatusWrapper)) {
            return 0;
        }

        return this.mWrapped.equals(((GnssStatusWrapper)arg2).mWrapped);
    }

    public float getAzimuthDegrees(int arg1) {
        return this.mWrapped.getAzimuthDegrees(arg1);
    }

    public float getBasebandCn0DbHz(int arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getBasebandCn0DbHz(this.mWrapped, arg3);
        }

        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int arg1) {
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, arg1);
    }

    public float getCn0DbHz(int arg1) {
        return this.mWrapped.getCn0DbHz(arg1);
    }

    public int getConstellationType(int arg1) {
        return this.mWrapped.getConstellationType(arg1);
    }

    public float getElevationDegrees(int arg1) {
        return this.mWrapped.getElevationDegrees(arg1);
    }

    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int getSvid(int arg1) {
        return this.mWrapped.getSvid(arg1);
    }

    public boolean hasAlmanacData(int arg1) {
        return this.mWrapped.hasAlmanacData(arg1);
    }

    public boolean hasBasebandCn0DbHz(int arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, arg3);
        }

        return 0;
    }

    public boolean hasCarrierFrequencyHz(int arg1) {
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, arg1);
    }

    public boolean hasEphemerisData(int arg1) {
        return this.mWrapped.hasEphemerisData(arg1);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int arg1) {
        return this.mWrapped.usedInFix(arg1);
    }
}

