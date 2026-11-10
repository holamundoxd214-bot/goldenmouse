package androidx.core.location;

import android.location.LocationRequest$Builder;
import android.location.LocationRequest;
import android.os.Build$VERSION;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public final class LocationRequestCompat {
    class Api19Impl {
        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;

        private Api19Impl() {
            super();
        }

        public static Object toLocationRequest(LocationRequestCompat arg8, String arg9) {
            Object v9;
            Method v1_1;
            Object v0 = null;
            try {
                Class v1 = Api19Impl.sLocationRequestClass;
                if(v1 == null) {
                    v1 = Class.forName("android.location.LocationRequest");
                    Api19Impl.sLocationRequestClass = v1;
                }

                if(Api19Impl.sCreateFromDeprecatedProviderMethod == null) {
                    v1_1 = v1.getDeclaredMethod("createFromDeprecatedProvider", String.class, Long.TYPE, Float.TYPE, Boolean.TYPE);
                    Api19Impl.sCreateFromDeprecatedProviderMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                v9 = Api19Impl.sCreateFromDeprecatedProviderMethod.invoke(v0, arg9, Long.valueOf(arg8.getIntervalMillis()), Float.valueOf(arg8.getMinUpdateDistanceMeters()), Boolean.valueOf(false));
                if(v9 == null) {
                    return v0;
                }

                if(Api19Impl.sSetQualityMethod == null) {
                    v1_1 = Api19Impl.sLocationRequestClass.getDeclaredMethod("setQuality", Integer.TYPE);
                    Api19Impl.sSetQualityMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                Api19Impl.sSetQualityMethod.invoke(v9, Integer.valueOf(arg8.getQuality()));
                if(Api19Impl.sSetFastestIntervalMethod == null) {
                    v1_1 = Api19Impl.sLocationRequestClass.getDeclaredMethod("setFastestInterval", Long.TYPE);
                    Api19Impl.sSetFastestIntervalMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                Api19Impl.sSetFastestIntervalMethod.invoke(v9, Long.valueOf(arg8.getMinUpdateIntervalMillis()));
                if(arg8.getMaxUpdates() < 0x7FFFFFFF) {
                    if(Api19Impl.sSetNumUpdatesMethod == null) {
                        v1_1 = Api19Impl.sLocationRequestClass.getDeclaredMethod("setNumUpdates", Integer.TYPE);
                        Api19Impl.sSetNumUpdatesMethod = v1_1;
                        v1_1.setAccessible(true);
                    }

                    Api19Impl.sSetNumUpdatesMethod.invoke(v9, Integer.valueOf(arg8.getMaxUpdates()));
                }

                if(arg8.getDurationMillis() < 0x7FFFFFFFFFFFFFFFL) {
                    if(Api19Impl.sSetExpireInMethod == null) {
                        v1_1 = Api19Impl.sLocationRequestClass.getDeclaredMethod("setExpireIn", Long.TYPE);
                        Api19Impl.sSetExpireInMethod = v1_1;
                        v1_1.setAccessible(true);
                    }

                    Api19Impl.sSetExpireInMethod.invoke(v9, Long.valueOf(arg8.getDurationMillis()));
                }
            }
            catch(ClassNotFoundException ) {
                return v0;
            }

            return v9;
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        public static LocationRequest toLocationRequest(LocationRequestCompat arg3) {
            return new LocationRequest$Builder(arg3.getIntervalMillis()).setQuality(arg3.getQuality()).setMinUpdateIntervalMillis(arg3.getMinUpdateIntervalMillis()).setDurationMillis(arg3.getDurationMillis()).setMaxUpdates(arg3.getMaxUpdates()).setMinUpdateDistanceMeters(arg3.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(arg3.getMaxUpdateDelayMillis()).build();
        }
    }

    public final class Builder {
        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;

        public Builder(long arg1) {
            super();
            this.setIntervalMillis(arg1);
            this.mQuality = 102;
            this.mDurationMillis = 0x7FFFFFFFFFFFFFFFL;
            this.mMaxUpdates = 0x7FFFFFFF;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0f;
            this.mMaxUpdateDelayMillis = 0;
        }

        public Builder(LocationRequestCompat arg3) {
            super();
            this.mIntervalMillis = arg3.mIntervalMillis;
            this.mQuality = arg3.mQuality;
            this.mDurationMillis = arg3.mDurationMillis;
            this.mMaxUpdates = arg3.mMaxUpdates;
            this.mMinUpdateIntervalMillis = arg3.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = arg3.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = arg3.mMaxUpdateDelayMillis;
        }

        public LocationRequestCompat build() {
            boolean v0 = this.mIntervalMillis != 0x7FFFFFFFFFFFFFFFL || this.mMinUpdateIntervalMillis != -1 ? true : false;
            Preconditions.checkState(v0, "passive location requests must have an explicit minimum update interval");
            return new LocationRequestCompat(this.mIntervalMillis, this.mQuality, this.mDurationMillis, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, this.mIntervalMillis), this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis);
        }

        public Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        public Builder setDurationMillis(long arg8) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(arg8, 1, 0x7FFFFFFFFFFFFFFFL, "durationMillis");
            return this;
        }

        public Builder setIntervalMillis(long arg8) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(arg8, 0, 0x7FFFFFFFFFFFFFFFL, "intervalMillis");
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long arg8) {
            this.mMaxUpdateDelayMillis = arg8;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(arg8, 0, 0x7FFFFFFFFFFFFFFFL, "maxUpdateDelayMillis");
            return this;
        }

        public Builder setMaxUpdates(int arg4) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(arg4, 1, 0x7FFFFFFF, "maxUpdates");
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float arg4) {
            this.mMinUpdateDistanceMeters = arg4;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(arg4, 0f, 3.402823E+38f, "minUpdateDistanceMeters");
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long arg8) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(arg8, 0, 0x7FFFFFFFFFFFFFFFL, "minUpdateIntervalMillis");
            return this;
        }

        public Builder setQuality(int arg4) {
            boolean v0 = arg4 == 104 || arg4 == 102 || arg4 == 100 ? true : false;
            Preconditions.checkArgument(v0, "quality must be a defined QUALITY constant, not %d", new Object[]{Integer.valueOf(arg4)});
            this.mQuality = arg4;
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Quality {
    }

    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
    public static final long PASSIVE_INTERVAL = 0x7FFFFFFFFFFFFFFFL;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    LocationRequestCompat(long arg1, int arg3, long arg4, int arg6, long arg7, float arg9, long arg10) {
        super();
        this.mIntervalMillis = arg1;
        this.mQuality = arg3;
        this.mMinUpdateIntervalMillis = arg7;
        this.mDurationMillis = arg4;
        this.mMaxUpdates = arg6;
        this.mMinUpdateDistanceMeters = arg9;
        this.mMaxUpdateDelayMillis = arg10;
    }

    public boolean equals(Object arg8) {
        if(this == (((LocationRequestCompat)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof LocationRequestCompat)) {
            return 0;
        }

        if(this.mQuality == ((LocationRequestCompat)arg8).mQuality && this.mIntervalMillis == ((LocationRequestCompat)arg8).mIntervalMillis && this.mMinUpdateIntervalMillis == ((LocationRequestCompat)arg8).mMinUpdateIntervalMillis && this.mDurationMillis == ((LocationRequestCompat)arg8).mDurationMillis && this.mMaxUpdates == ((LocationRequestCompat)arg8).mMaxUpdates && Float.compare(((LocationRequestCompat)arg8).mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) == 0 && this.mMaxUpdateDelayMillis == ((LocationRequestCompat)arg8).mMaxUpdateDelayMillis) {
            return 1;
        }

        return 0;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    public long getMinUpdateIntervalMillis() {
        long v0 = this.mMinUpdateIntervalMillis;
        if(v0 == -1) {
            v0 = this.mIntervalMillis;
        }

        return v0;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        return (this.mQuality * 0x1F + (((int)(this.mIntervalMillis ^ this.mIntervalMillis >>> 0x20)))) * 0x1F + (((int)(this.mMinUpdateIntervalMillis ^ this.mMinUpdateIntervalMillis >>> 0x20)));
    }

    public LocationRequest toLocationRequest() {
        return Api31Impl.toLocationRequest(this);
    }

    public LocationRequest toLocationRequest(String arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return this.toLocationRequest();
        }

        return Api19Impl.toLocationRequest(this, arg3);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        v0.append("Request[");
        long v3 = 0x7FFFFFFFFFFFFFFFL;
        if(this.mIntervalMillis != v3) {
            v0.append("@");
            TimeUtils.formatDuration(this.mIntervalMillis, v0);
            int v1 = this.mQuality;
            if(v1 == 100) {
                v0.append(" HIGH_ACCURACY");
            }
            else if(v1 == 102) {
                v0.append(" BALANCED");
            }
            else if(v1 != 104) {
            }
            else {
                v0.append(" LOW_POWER");
            }
        }
        else {
            v0.append("PASSIVE");
        }

        if(this.mDurationMillis != v3) {
            v0.append(", duration=");
            TimeUtils.formatDuration(this.mDurationMillis, v0);
        }

        if(this.mMaxUpdates != 0x7FFFFFFF) {
            v0.append(", maxUpdates=").append(this.mMaxUpdates);
        }

        long v1_1 = this.mMinUpdateIntervalMillis;
        if(v1_1 != -1 && v1_1 < this.mIntervalMillis) {
            v0.append(", minUpdateInterval=");
            TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, v0);
        }

        if((((double)this.mMinUpdateDistanceMeters)) > 0) {
            v0.append(", minUpdateDistance=").append(this.mMinUpdateDistanceMeters);
        }

        if(this.mMaxUpdateDelayMillis / 2 > this.mIntervalMillis) {
            v0.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, v0);
        }

        v0.append(']');
        return v0.toString();
    }
}

