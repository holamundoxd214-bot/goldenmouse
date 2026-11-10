package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import androidx.core.util.Preconditions;
import java.util.Iterator;

class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 0x40;
    private static final int GPS_PRN_COUNT = 0x20;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 0xC1;
    private static final int SBAS_PRN_MAX = 0x40;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    private Iterator mCachedIterator;
    private int mCachedIteratorPosition;
    private GpsSatellite mCachedSatellite;
    private int mCachedSatelliteCount;
    private final GpsStatus mWrapped;

    GpsStatusWrapper(GpsStatus arg2) {
        super();
        Object v2 = Preconditions.checkNotNull(arg2);
        this.mWrapped = ((GpsStatus)v2);
        this.mCachedSatelliteCount = -1;
        this.mCachedIterator = ((GpsStatus)v2).getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    public boolean equals(Object arg2) {
        if(this == (((GpsStatusWrapper)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof GpsStatusWrapper)) {
            return 0;
        }

        return this.mWrapped.equals(((GpsStatusWrapper)arg2).mWrapped);
    }

    public float getAzimuthDegrees(int arg1) {
        return this.getSatellite(arg1).getAzimuth();
    }

    public float getBasebandCn0DbHz(int arg1) {
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int arg1) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int arg1) {
        return this.getSatellite(arg1).getSnr();
    }

    private static int getConstellationFromPrn(int arg2) {
        if(arg2 > 0 && arg2 <= 0x20) {
            return 1;
        }

        int v1 = 0x40;
        if(arg2 >= 33 && arg2 <= v1) {
            return 2;
        }

        if(arg2 > v1 && arg2 <= 88) {
            return 3;
        }

        int v0 = 200;
        if(arg2 > v0 && arg2 <= 0xEB) {
            return 5;
        }

        if(arg2 >= 0xC1 && arg2 <= v0) {
            return 4;
        }

        return 0;
    }

    public int getConstellationType(int arg1) {
        return GpsStatusWrapper.getConstellationFromPrn(this.getSatellite(arg1).getPrn());
    }

    public float getElevationDegrees(int arg1) {
        return this.getSatellite(arg1).getElevation();
    }

    private GpsSatellite getSatellite(int arg3) {
        GpsSatellite v2_1;
        GpsStatus v0 = this.mWrapped;
        __monitor_enter(v0);
        try {
            if(arg3 < this.mCachedIteratorPosition) {
                this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                this.mCachedIteratorPosition = -1;
            }

            while(true) {
                int v1 = this.mCachedIteratorPosition;
                if(v1 < arg3) {
                    this.mCachedIteratorPosition = v1 + 1;
                    if(!this.mCachedIterator.hasNext()) {
                        this.mCachedSatellite = null;
                    }
                    else {
                        this.mCachedSatellite = this.mCachedIterator.next();
                        continue;
                    }
                }

                break;
            }

            v2_1 = this.mCachedSatellite;
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_29;
        }

        return Preconditions.checkNotNull(v2_1);
        try {
        label_29:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_29;
        }

        throw v2;
    }

    public int getSatelliteCount() {
        GpsStatus v0 = this.mWrapped;
        __monitor_enter(v0);
        try {
            int v1 = this.mCachedSatelliteCount;
            if(v1 == -1) {
                Iterator v1_1 = this.mWrapped.getSatellites().iterator();
                while(v1_1.hasNext()) {
                    v1_1.next();
                    ++this.mCachedSatelliteCount;
                }

                v1 = this.mCachedSatelliteCount + 1;
                this.mCachedSatelliteCount = v1;
            }

            __monitor_exit(v0);
            return v1;
        label_21:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_21;
        }

        throw v3;
    }

    public int getSvid(int arg1) {
        return GpsStatusWrapper.getSvidFromPrn(this.getSatellite(arg1).getPrn());
    }

    private static int getSvidFromPrn(int arg2) {
        int v0 = GpsStatusWrapper.getConstellationFromPrn(arg2);
        if(v0 != 2) {
            if(v0 != 3) {
                if(v0 != 5) {
                    return arg2;
                }

                return arg2 - 200;
            }

            return arg2 - 0x40;
        }

        return arg2 + 87;
    }

    public boolean hasAlmanacData(int arg1) {
        return this.getSatellite(arg1).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int arg1) {
        return 0;
    }

    public boolean hasCarrierFrequencyHz(int arg1) {
        return 0;
    }

    public boolean hasEphemerisData(int arg1) {
        return this.getSatellite(arg1).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int arg1) {
        return this.getSatellite(arg1).usedInFix();
    }
}

