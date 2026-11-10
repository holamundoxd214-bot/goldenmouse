package androidx.core.location;

import android.location.Location;
import android.os.Build$VERSION;
import android.os.Bundle;
import androidx.annotation.ReplaceWith;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static float getBearingAccuracyDegrees(Location arg0) {
            return arg0.getBearingAccuracyDegrees();
        }

        static float getSpeedAccuracyMetersPerSecond(Location arg0) {
            return arg0.getSpeedAccuracyMetersPerSecond();
        }

        static float getVerticalAccuracyMeters(Location arg0) {
            return arg0.getVerticalAccuracyMeters();
        }

        static boolean hasBearingAccuracy(Location arg0) {
            return arg0.hasBearingAccuracy();
        }

        static boolean hasSpeedAccuracy(Location arg0) {
            return arg0.hasSpeedAccuracy();
        }

        static boolean hasVerticalAccuracy(Location arg0) {
            return arg0.hasVerticalAccuracy();
        }

        static void removeBearingAccuracy(Location arg2) {
            try {
                LocationCompat.getFieldsMaskField().setByte(arg2, ((byte)(LocationCompat.getFieldsMaskField().getByte(arg2) & ~LocationCompat.getHasBearingAccuracyMask())));
                return;
            }
            catch(IllegalAccessException v2) {
                IllegalAccessError v0_1 = new IllegalAccessError();
                ((Error)v0_1).initCause(((Throwable)v2));
                throw v0_1;
            }
            catch(NoSuchFieldException v2_1) {
                NoSuchFieldError v0 = new NoSuchFieldError();
                ((Error)v0).initCause(((Throwable)v2_1));
                throw v0;
            }
        }

        static void removeSpeedAccuracy(Location arg2) {
            try {
                LocationCompat.getFieldsMaskField().setByte(arg2, ((byte)(LocationCompat.getFieldsMaskField().getByte(arg2) & ~LocationCompat.getHasSpeedAccuracyMask())));
                return;
            }
            catch(IllegalAccessException v2) {
                IllegalAccessError v0_1 = new IllegalAccessError();
                ((Error)v0_1).initCause(((Throwable)v2));
                throw v0_1;
            }
            catch(NoSuchFieldException v2_1) {
                NoSuchFieldError v0 = new NoSuchFieldError();
                ((Error)v0).initCause(((Throwable)v2_1));
                throw v0;
            }
        }

        static void removeVerticalAccuracy(Location arg2) {
            try {
                LocationCompat.getFieldsMaskField().setByte(arg2, ((byte)(LocationCompat.getFieldsMaskField().getByte(arg2) & ~LocationCompat.getHasVerticalAccuracyMask())));
                return;
            }
            catch(IllegalAccessException v2) {
                IllegalAccessError v0 = new IllegalAccessError();
                ((Error)v0).initCause(((Throwable)v2));
                throw v0;
            }
        }

        static void setBearingAccuracyDegrees(Location arg0, float arg1) {
            arg0.setBearingAccuracyDegrees(arg1);
        }

        static void setSpeedAccuracyMetersPerSecond(Location arg0, float arg1) {
            arg0.setSpeedAccuracyMetersPerSecond(arg1);
        }

        static void setVerticalAccuracyMeters(Location arg0, float arg1) {
            arg0.setVerticalAccuracyMeters(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static void removeBearingAccuracy(Location arg24) {
            Location v0 = arg24;
            if(!v0.hasBearingAccuracy()) {
            }
            else {
                String v1 = v0.getProvider();
                long v2 = v0.getTime();
                long v4 = v0.getElapsedRealtimeNanos();
                double v6 = v0.getLatitude();
                double v8 = v0.getLongitude();
                boolean v10 = v0.hasAltitude();
                double v11 = v0.getAltitude();
                boolean v13 = v0.hasSpeed();
                float v14 = v0.getSpeed();
                boolean v15 = v0.hasBearing();
                boolean v16 = v10;
                float v10_1 = v0.getBearing();
                boolean v17 = v0.hasAccuracy();
                boolean v18 = v13;
                float v13_1 = v0.getAccuracy();
                boolean v19 = v0.hasVerticalAccuracy();
                boolean v20 = v15;
                float v15_1 = v0.getVerticalAccuracyMeters();
                boolean v21 = v0.hasSpeedAccuracy();
                float v22 = v15_1;
                float v23 = v0.getSpeedAccuracyMetersPerSecond();
                Bundle v15_2 = v0.getExtras();
                v0.reset();
                v0.setProvider(v1);
                v0.setTime(v2);
                v0.setElapsedRealtimeNanos(v4);
                v0.setLatitude(v6);
                v0.setLongitude(v8);
                if(v16) {
                    v0.setAltitude(v11);
                }

                if(v18) {
                    v0.setSpeed(v14);
                }

                if(v20) {
                    v0.setBearing(v10_1);
                }

                if(v17) {
                    v0.setAccuracy(v13_1);
                }

                if(v19) {
                    v0.setVerticalAccuracyMeters(v22);
                }

                if(v21) {
                    v0.setBearingAccuracyDegrees(v23);
                }

                if(v15_2 == null) {
                    return;
                }

                v0.setExtras(v15_2);
            }
        }

        static void removeSpeedAccuracy(Location arg24) {
            Location v0 = arg24;
            if(!v0.hasSpeedAccuracy()) {
            }
            else {
                String v1 = v0.getProvider();
                long v2 = v0.getTime();
                long v4 = v0.getElapsedRealtimeNanos();
                double v6 = v0.getLatitude();
                double v8 = v0.getLongitude();
                boolean v10 = v0.hasAltitude();
                double v11 = v0.getAltitude();
                boolean v13 = v0.hasSpeed();
                float v14 = v0.getSpeed();
                boolean v15 = v0.hasBearing();
                boolean v16 = v10;
                float v10_1 = v0.getBearing();
                boolean v17 = v0.hasAccuracy();
                boolean v18 = v13;
                float v13_1 = v0.getAccuracy();
                boolean v19 = v0.hasVerticalAccuracy();
                boolean v20 = v15;
                float v15_1 = v0.getVerticalAccuracyMeters();
                boolean v21 = v0.hasBearingAccuracy();
                float v22 = v15_1;
                float v23 = v0.getBearingAccuracyDegrees();
                Bundle v15_2 = v0.getExtras();
                v0.reset();
                v0.setProvider(v1);
                v0.setTime(v2);
                v0.setElapsedRealtimeNanos(v4);
                v0.setLatitude(v6);
                v0.setLongitude(v8);
                if(v16) {
                    v0.setAltitude(v11);
                }

                if(v18) {
                    v0.setSpeed(v14);
                }

                if(v20) {
                    v0.setBearing(v10_1);
                }

                if(v17) {
                    v0.setAccuracy(v13_1);
                }

                if(v19) {
                    v0.setVerticalAccuracyMeters(v22);
                }

                if(v21) {
                    v0.setBearingAccuracyDegrees(v23);
                }

                if(v15_2 == null) {
                    return;
                }

                v0.setExtras(v15_2);
            }
        }

        static void removeVerticalAccuracy(Location arg24) {
            Location v0 = arg24;
            if(!v0.hasVerticalAccuracy()) {
            }
            else {
                String v1 = v0.getProvider();
                long v2 = v0.getTime();
                long v4 = v0.getElapsedRealtimeNanos();
                double v6 = v0.getLatitude();
                double v8 = v0.getLongitude();
                boolean v10 = v0.hasAltitude();
                double v11 = v0.getAltitude();
                boolean v13 = v0.hasSpeed();
                float v14 = v0.getSpeed();
                boolean v15 = v0.hasBearing();
                boolean v16 = v10;
                float v10_1 = v0.getBearing();
                boolean v17 = v0.hasAccuracy();
                boolean v18 = v13;
                float v13_1 = v0.getAccuracy();
                boolean v19 = v0.hasSpeedAccuracy();
                boolean v20 = v15;
                float v15_1 = v0.getSpeedAccuracyMetersPerSecond();
                boolean v21 = v0.hasBearingAccuracy();
                float v22 = v15_1;
                float v23 = v0.getBearingAccuracyDegrees();
                Bundle v15_2 = v0.getExtras();
                v0.reset();
                v0.setProvider(v1);
                v0.setTime(v2);
                v0.setElapsedRealtimeNanos(v4);
                v0.setLatitude(v6);
                v0.setLongitude(v8);
                if(v16) {
                    v0.setAltitude(v11);
                }

                if(v18) {
                    v0.setSpeed(v14);
                }

                if(v20) {
                    v0.setBearing(v10_1);
                }

                if(v17) {
                    v0.setAccuracy(v13_1);
                }

                if(v19) {
                    v0.setSpeedAccuracyMetersPerSecond(v22);
                }

                if(v21) {
                    v0.setBearingAccuracyDegrees(v23);
                }

                if(v15_2 == null) {
                    return;
                }

                v0.setExtras(v15_2);
            }
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void removeBearingAccuracy(Location arg2) {
            if(!arg2.hasBearingAccuracy()) {
                return;
            }

            double v0 = arg2.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeBearingAccuracy(arg2);
            arg2.setElapsedRealtimeUncertaintyNanos(v0);
        }

        static void removeSpeedAccuracy(Location arg2) {
            if(!arg2.hasSpeedAccuracy()) {
                return;
            }

            double v0 = arg2.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeSpeedAccuracy(arg2);
            arg2.setElapsedRealtimeUncertaintyNanos(v0);
        }

        static void removeVerticalAccuracy(Location arg2) {
            if(!arg2.hasVerticalAccuracy()) {
                return;
            }

            double v0 = arg2.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeVerticalAccuracy(arg2);
            arg2.setElapsedRealtimeUncertaintyNanos(v0);
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static boolean isMock(Location arg0) {
            return arg0.isMock();
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static void removeBearingAccuracy(Location arg0) {
            arg0.removeBearingAccuracy();
        }

        static void removeSpeedAccuracy(Location arg0) {
            arg0.removeSpeedAccuracy();
        }

        static void removeVerticalAccuracy(Location arg0) {
            arg0.removeVerticalAccuracy();
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static float getMslAltitudeAccuracyMeters(Location arg0) {
            return arg0.getMslAltitudeAccuracyMeters();
        }

        static double getMslAltitudeMeters(Location arg2) {
            return arg2.getMslAltitudeMeters();
        }

        static boolean hasMslAltitude(Location arg0) {
            return arg0.hasMslAltitude();
        }

        static boolean hasMslAltitudeAccuracy(Location arg0) {
            return arg0.hasMslAltitudeAccuracy();
        }

        static void removeMslAltitude(Location arg0) {
            arg0.removeMslAltitude();
        }

        static void removeMslAltitudeAccuracy(Location arg0) {
            arg0.removeMslAltitudeAccuracy();
        }

        static void setMslAltitudeAccuracyMeters(Location arg0, float arg1) {
            arg0.setMslAltitudeAccuracyMeters(arg1);
        }

        static void setMslAltitudeMeters(Location arg0, double arg1) {
            arg0.setMslAltitudeMeters(arg1);
        }
    }

    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
        super();
    }

    private static boolean containsExtra(Location arg0, String arg1) {
        Bundle v0 = arg0.getExtras();
        if(v0 != null && (v0.containsKey(arg1))) {
            return 1;
        }

        return 0;
    }

    public static float getBearingAccuracyDegrees(Location arg0) {
        return Api26Impl.getBearingAccuracyDegrees(arg0);
    }

    public static long getElapsedRealtimeMillis(Location arg3) {
        return TimeUnit.NANOSECONDS.toMillis(arg3.getElapsedRealtimeNanos());
    }

    @ReplaceWith(expression="location.getElapsedRealtimeNanos()") @Deprecated public static long getElapsedRealtimeNanos(Location arg2) {
        return arg2.getElapsedRealtimeNanos();
    }

    static Field getFieldsMaskField() throws NoSuchFieldException {
        if(LocationCompat.sFieldsMaskField == null) {
            Field v0 = Location.class.getDeclaredField("mFieldsMask");
            LocationCompat.sFieldsMaskField = v0;
            v0.setAccessible(true);
        }

        return LocationCompat.sFieldsMaskField;
    }

    static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        Integer v0 = LocationCompat.sHasBearingAccuracyMask;
        if(v0 == null) {
            Field v0_1 = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            v0_1.setAccessible(true);
            v0 = Integer.valueOf(v0_1.getInt(null));
            LocationCompat.sHasBearingAccuracyMask = v0;
        }

        return v0.intValue();
    }

    static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        Integer v0 = LocationCompat.sHasSpeedAccuracyMask;
        if(v0 == null) {
            Field v0_1 = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            v0_1.setAccessible(true);
            v0 = Integer.valueOf(v0_1.getInt(null));
            LocationCompat.sHasSpeedAccuracyMask = v0;
        }

        return v0.intValue();
    }

    static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        Integer v0 = LocationCompat.sHasVerticalAccuracyMask;
        if(v0 == null) {
            Field v0_1 = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            v0_1.setAccessible(true);
            v0 = Integer.valueOf(v0_1.getInt(null));
            LocationCompat.sHasVerticalAccuracyMask = v0;
        }

        return v0.intValue();
    }

    public static float getMslAltitudeAccuracyMeters(Location arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeAccuracyMeters(arg2);
        }

        return LocationCompat.getOrCreateExtras(arg2).getFloat("androidx.core.location.extra.MSL_ALTITUDE_ACCURACY");
    }

    public static double getMslAltitudeMeters(Location arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeMeters(arg2);
        }

        return LocationCompat.getOrCreateExtras(arg2).getDouble("androidx.core.location.extra.MSL_ALTITUDE");
    }

    private static Bundle getOrCreateExtras(Location arg1) {
        Bundle v0 = arg1.getExtras();
        if(v0 == null) {
            arg1.setExtras(new Bundle());
            return arg1.getExtras();
        }

        return v0;
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if(LocationCompat.sSetIsFromMockProviderMethod == null) {
            Method v0 = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            LocationCompat.sSetIsFromMockProviderMethod = v0;
            v0.setAccessible(true);
        }

        return LocationCompat.sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(Location arg0) {
        return Api26Impl.getSpeedAccuracyMetersPerSecond(arg0);
    }

    public static float getVerticalAccuracyMeters(Location arg0) {
        return Api26Impl.getVerticalAccuracyMeters(arg0);
    }

    public static boolean hasBearingAccuracy(Location arg0) {
        return Api26Impl.hasBearingAccuracy(arg0);
    }

    public static boolean hasMslAltitude(Location arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitude(arg2);
        }

        return LocationCompat.containsExtra(arg2, "androidx.core.location.extra.MSL_ALTITUDE");
    }

    public static boolean hasMslAltitudeAccuracy(Location arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitudeAccuracy(arg2);
        }

        return LocationCompat.containsExtra(arg2, "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY");
    }

    public static boolean hasSpeedAccuracy(Location arg0) {
        return Api26Impl.hasSpeedAccuracy(arg0);
    }

    public static boolean hasVerticalAccuracy(Location arg0) {
        return Api26Impl.hasVerticalAccuracy(arg0);
    }

    public static boolean isMock(Location arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.isMock(arg2);
        }

        return arg2.isFromMockProvider();
    }

    public static void removeBearingAccuracy(Location arg2) {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.removeBearingAccuracy(arg2);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.removeBearingAccuracy(arg2);
            return;
        }

        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.removeBearingAccuracy(arg2);
            return;
        }

        Api26Impl.removeBearingAccuracy(arg2);
    }

    private static void removeExtra(Location arg1, String arg2) {
        Bundle v0 = arg1.getExtras();
        if(v0 != null) {
            v0.remove(arg2);
            if(v0.isEmpty()) {
                arg1.setExtras(null);
            }
        }
    }

    public static void removeMslAltitude(Location arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitude(arg2);
            return;
        }

        LocationCompat.removeExtra(arg2, "androidx.core.location.extra.MSL_ALTITUDE");
    }

    public static void removeMslAltitudeAccuracy(Location arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitudeAccuracy(arg2);
            return;
        }

        LocationCompat.removeExtra(arg2, "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY");
    }

    public static void removeSpeedAccuracy(Location arg2) {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.removeSpeedAccuracy(arg2);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.removeSpeedAccuracy(arg2);
            return;
        }

        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.removeSpeedAccuracy(arg2);
            return;
        }

        Api26Impl.removeSpeedAccuracy(arg2);
    }

    public static void removeVerticalAccuracy(Location arg2) {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.removeVerticalAccuracy(arg2);
            return;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.removeVerticalAccuracy(arg2);
            return;
        }

        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.removeVerticalAccuracy(arg2);
            return;
        }

        Api26Impl.removeVerticalAccuracy(arg2);
    }

    public static void setBearingAccuracyDegrees(Location arg0, float arg1) {
        Api26Impl.setBearingAccuracyDegrees(arg0, arg1);
    }

    public static void setMock(Location arg1, boolean arg2) {
        try {
            LocationCompat.getSetIsFromMockProviderMethod().invoke(arg1, Boolean.valueOf(arg2));
            return;
        }
        catch(InvocationTargetException v1) {
            throw new RuntimeException(((Throwable)v1));
        }
        catch(IllegalAccessException v1_1) {
            IllegalAccessError v2_1 = new IllegalAccessError();
            ((Error)v2_1).initCause(((Throwable)v1_1));
            throw v2_1;
        }
        catch(NoSuchMethodException v1_2) {
            NoSuchMethodError v2 = new NoSuchMethodError();
            ((Error)v2).initCause(((Throwable)v1_2));
            throw v2;
        }
    }

    public static void setMslAltitudeAccuracyMeters(Location arg2, float arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeAccuracyMeters(arg2, arg3);
            return;
        }

        LocationCompat.getOrCreateExtras(arg2).putFloat("androidx.core.location.extra.MSL_ALTITUDE_ACCURACY", arg3);
    }

    public static void setMslAltitudeMeters(Location arg2, double arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeMeters(arg2, arg3);
            return;
        }

        LocationCompat.getOrCreateExtras(arg2).putDouble("androidx.core.location.extra.MSL_ALTITUDE", arg3);
    }

    public static void setSpeedAccuracyMetersPerSecond(Location arg0, float arg1) {
        Api26Impl.setSpeedAccuracyMetersPerSecond(arg0, arg1);
    }

    public static void setVerticalAccuracyMeters(Location arg0, float arg1) {
        Api26Impl.setVerticalAccuracyMeters(arg0, arg1);
    }
}

