package androidx.core.location;

import android.location.GnssMeasurementsEvent$Callback;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus$Callback;
import android.location.GnssStatus;
import android.location.GpsStatus$Listener;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    class Api19Impl {
        private static Class sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
            super();
        }

        static boolean tryRequestLocationUpdates(LocationManager arg7, String arg8, LocationRequestCompat arg9, LocationListenerCompat arg10, Looper arg11) {
            try {
                Class v1 = Api19Impl.sLocationRequestClass;
                if(v1 == null) {
                    v1 = Class.forName("android.location.LocationRequest");
                    Api19Impl.sLocationRequestClass = v1;
                }

                if(Api19Impl.sRequestLocationUpdatesLooperMethod == null) {
                    Method v1_1 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", v1, LocationListener.class, Looper.class);
                    Api19Impl.sRequestLocationUpdatesLooperMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                LocationRequest v8 = arg9.toLocationRequest(arg8);
                if(v8 == null) {
                    return 0;
                }

                Api19Impl.sRequestLocationUpdatesLooperMethod.invoke(arg7, v8, arg10, arg11);
                return 1;
            }
            catch(UnsupportedOperationException ) {
                return 0;
            }
        }

        static boolean tryRequestLocationUpdates(LocationManager arg7, String arg8, LocationRequestCompat arg9, LocationListenerTransport arg10) {
            WeakHashMap v9;
            LocationRequest v8;
            try {
                Class v1 = Api19Impl.sLocationRequestClass;
                if(v1 == null) {
                    v1 = Class.forName("android.location.LocationRequest");
                    Api19Impl.sLocationRequestClass = v1;
                }

                if(Api19Impl.sRequestLocationUpdatesLooperMethod == null) {
                    Method v1_1 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", v1, LocationListener.class, Looper.class);
                    Api19Impl.sRequestLocationUpdatesLooperMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                v8 = arg9.toLocationRequest(arg8);
                if(v8 == null) {
                    return 0;
                }

                v9 = LocationManagerCompat.sLocationListeners;
                __monitor_enter(v9);
            }
            catch(UnsupportedOperationException ) {
                return 0;
            }

            try {
                Api19Impl.sRequestLocationUpdatesLooperMethod.invoke(arg7, v8, arg10, Looper.getMainLooper());
                LocationManagerCompat.registerLocationListenerTransport(arg7, arg10);
                __monitor_exit(v9);
                return 1;
            label_34:
                __monitor_exit(v9);
            }
            catch(Throwable v7) {
                goto label_34;
            }

            try {
                throw v7;
            }
            catch(UnsupportedOperationException ) {
                return 0;
            }
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static boolean registerGnssMeasurementsCallback(LocationManager arg0, GnssMeasurementsEvent$Callback arg1, Handler arg2) {
            return arg0.registerGnssMeasurementsCallback(arg1, arg2);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager arg0, GnssMeasurementsEvent$Callback arg1) {
            return arg0.registerGnssMeasurementsCallback(arg1);
        }

        static boolean registerGnssStatusCallback(LocationManager arg4, Handler arg5, Executor arg6, Callback arg7) {
            boolean v2 = arg5 != null ? true : false;
            Preconditions.checkArgument(v2);
            SimpleArrayMap v2_1 = GnssListenersHolder.sGnssStatusListeners;
            __monitor_enter(v2_1);
            try {
                Object v3 = GnssListenersHolder.sGnssStatusListeners.get(arg7);
                if(v3 == null) {
                    PreRGnssStatusTransport v3_1 = new PreRGnssStatusTransport(arg7);
                }
                else {
                    ((PreRGnssStatusTransport)v3).unregister();
                }

                ((PreRGnssStatusTransport)v3).register(arg6);
                if(arg4.registerGnssStatusCallback(((GnssStatus$Callback)v3), arg5)) {
                    GnssListenersHolder.sGnssStatusListeners.put(arg7, v3);
                    __monitor_exit(v2_1);
                    return 1;
                }

                __monitor_exit(v2_1);
                return 0;
            label_26:
                __monitor_exit(v2_1);
            }
            catch(Throwable v4) {
                goto label_26;
            }

            throw v4;
        }

        static void unregisterGnssMeasurementsCallback(LocationManager arg0, GnssMeasurementsEvent$Callback arg1) {
            arg0.unregisterGnssMeasurementsCallback(arg1);
        }

        static void unregisterGnssStatusCallback(LocationManager arg1, Object arg2) {
            if((arg2 instanceof PreRGnssStatusTransport)) {
                arg2.unregister();
            }

            arg1.unregisterGnssStatusCallback(((GnssStatus$Callback)arg2));
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static String getGnssHardwareModelName(LocationManager arg0) {
            return arg0.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager arg0) {
            return arg0.getGnssYearOfHardware();
        }

        static boolean isLocationEnabled(LocationManager arg0) {
            return arg0.isLocationEnabled();
        }
    }

    class Api30Impl {
        private static Class sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
            super();
        }

        static void getCurrentLocation(LocationManager arg1, String arg2, CancellationSignal arg3, Executor arg4, Consumer arg5) {
            Objects.requireNonNull(arg5);
            arg1.getCurrentLocation(arg2, arg3, arg4, new LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(arg5));
        }

        public static boolean registerGnssStatusCallback(LocationManager arg1, Handler arg2, Executor arg3, Callback arg4) {
            GnssStatusTransport v0_1;
            SimpleArrayMap v2 = GnssListenersHolder.sGnssStatusListeners;
            __monitor_enter(v2);
            try {
                Object v0 = GnssListenersHolder.sGnssStatusListeners.get(arg4);
                if(v0 == null) {
                    v0_1 = new GnssStatusTransport(arg4);
                }

                if(arg1.registerGnssStatusCallback(arg3, ((GnssStatus$Callback)v0_1))) {
                    GnssListenersHolder.sGnssStatusListeners.put(arg4, v0_1);
                    __monitor_exit(v2);
                    return 1;
                }

                __monitor_exit(v2);
                return 0;
            label_18:
                __monitor_exit(v2);
            }
            catch(Throwable v1) {
                goto label_18;
            }

            throw v1;
        }

        public static boolean tryRequestLocationUpdates(LocationManager arg7, String arg8, LocationRequestCompat arg9, Executor arg10, LocationListenerCompat arg11) {
            if(Build$VERSION.SDK_INT >= 30) {
                try {
                    Class v0 = Api30Impl.sLocationRequestClass;
                    if(v0 == null) {
                        v0 = Class.forName("android.location.LocationRequest");
                        Api30Impl.sLocationRequestClass = v0;
                    }

                    if(Api30Impl.sRequestLocationUpdatesExecutorMethod == null) {
                        Method v0_1 = LocationManager.class.getDeclaredMethod("requestLocationUpdates", v0, Executor.class, LocationListener.class);
                        Api30Impl.sRequestLocationUpdatesExecutorMethod = v0_1;
                        v0_1.setAccessible(true);
                    }

                    LocationRequest v8 = arg9.toLocationRequest(arg8);
                    if(v8 == null) {
                        return 0;
                    }

                    Api30Impl.sRequestLocationUpdatesExecutorMethod.invoke(arg7, v8, arg10, arg11);
                    return 1;
                }
                catch(UnsupportedOperationException ) {
                    return 0;
                }
            }

            return 0;
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static boolean hasProvider(LocationManager arg0, String arg1) {
            return arg0.hasProvider(arg1);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager arg0, Executor arg1, GnssMeasurementsEvent$Callback arg2) {
            return arg0.registerGnssMeasurementsCallback(arg1, arg2);
        }

        static void requestLocationUpdates(LocationManager arg0, String arg1, LocationRequest arg2, Executor arg3, LocationListener arg4) {
            arg0.requestLocationUpdates(arg1, arg2, arg3, arg4);
        }
    }

    final class CancellableLocationListener implements LocationListener {
        private Consumer mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        CancellableLocationListener(LocationManager arg1, Executor arg2, Consumer arg3) {
            super();
            this.mLocationManager = arg1;
            this.mExecutor = arg2;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = arg3;
        }

        public void cancel() {
            __monitor_enter(this);
            try {
                if(this.mTriggered) {
                    __monitor_exit(this);
                    return;
                }

                this.mTriggered = true;
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                try {
                label_11:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_11;
                }

                throw v0;
            }

            this.cleanup();
        }

        private void cleanup() {
            Consumer v0 = null;
            this.mConsumer = v0;
            this.mLocationManager.removeUpdates(((LocationListener)this));
            Runnable v1 = this.mTimeoutRunnable;
            if(v1 != null) {
                this.mTimeoutHandler.removeCallbacks(v1);
                this.mTimeoutRunnable = ((Runnable)v0);
            }
        }

        static void lambda$onLocationChanged$1(Consumer arg0, Location arg1) {
            arg0.accept(arg1);
        }

        void lambda$startTimeout$0$androidx-core-location-LocationManagerCompat$CancellableLocationListener() {
            this.mTimeoutRunnable = null;
            this.onLocationChanged(null);
        }

        public void onLocationChanged(Location arg4) {
            __monitor_enter(this);
            try {
                if(this.mTriggered) {
                    __monitor_exit(this);
                    return;
                }

                this.mTriggered = true;
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                try {
                label_16:
                    __monitor_exit(this);
                }
                catch(Throwable v4) {
                    goto label_16;
                }

                throw v4;
            }

            this.mExecutor.execute(new LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1(this.mConsumer, arg4));
            this.cleanup();
        }

        public void onProviderDisabled(String arg2) {
            this.onLocationChanged(null);
        }

        public void onProviderEnabled(String arg1) {
        }

        public void onStatusChanged(String arg1, int arg2, Bundle arg3) {
        }

        public void startTimeout(long arg3) {
            __monitor_enter(this);
            try {
                if(this.mTriggered) {
                    __monitor_exit(this);
                    return;
                }

                LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0 v0 = new LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda0(this);
                this.mTimeoutRunnable = ((Runnable)v0);
                this.mTimeoutHandler.postDelayed(((Runnable)v0), arg3);
                __monitor_exit(this);
                return;
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_13;
            }

            throw v3;
        }
    }

    class GnssListenersHolder {
        static final SimpleArrayMap sGnssMeasurementListeners;
        static final SimpleArrayMap sGnssStatusListeners;

        static {
            GnssListenersHolder.sGnssStatusListeners = new SimpleArrayMap();
            GnssListenersHolder.sGnssMeasurementListeners = new SimpleArrayMap();
        }

        private GnssListenersHolder() {
            super();
        }
    }

    class GnssMeasurementsTransport extends GnssMeasurementsEvent$Callback {
        final GnssMeasurementsEvent$Callback mCallback;
        volatile Executor mExecutor;

        GnssMeasurementsTransport(GnssMeasurementsEvent$Callback arg1, Executor arg2) {
            super();
            this.mCallback = arg1;
            this.mExecutor = arg2;
        }

        void lambda$onGnssMeasurementsReceived$0$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(Executor arg2, GnssMeasurementsEvent arg3) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onGnssMeasurementsReceived(arg3);
        }

        void lambda$onStatusChanged$1$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(Executor arg2, int arg3) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onStatusChanged(arg3);
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent arg3) {
            Executor v0 = this.mExecutor;
            if(v0 == null) {
                return;
            }

            v0.execute(new LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda0(this, v0, arg3));
        }

        public void onStatusChanged(int arg3) {
            Executor v0 = this.mExecutor;
            if(v0 == null) {
                return;
            }

            v0.execute(new LocationManagerCompat$GnssMeasurementsTransport$$ExternalSyntheticLambda1(this, v0, arg3));
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    class GnssStatusTransport extends GnssStatus$Callback {
        final Callback mCallback;

        GnssStatusTransport(Callback arg3) {
            super();
            boolean v0 = arg3 != null ? true : false;
            Preconditions.checkArgument(v0, "invalid null callback");
            this.mCallback = arg3;
        }

        public void onFirstFix(int arg1) {
            this.mCallback.onFirstFix(arg1);
        }

        public void onSatelliteStatusChanged(GnssStatus arg1) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(arg1));
        }

        public void onStarted() {
            this.mCallback.onStarted();
        }

        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    class GpsStatusTransport implements GpsStatus$Listener {
        final Callback mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager arg3, Callback arg4) {
            super();
            boolean v0 = arg4 != null ? true : false;
            Preconditions.checkArgument(v0, "invalid null callback");
            this.mLocationManager = arg3;
            this.mCallback = arg4;
        }

        void lambda$onGpsStatusChanged$0$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor arg2) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onStarted();
        }

        void lambda$onGpsStatusChanged$1$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor arg2) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onStopped();
        }

        void lambda$onGpsStatusChanged$2$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor arg2, int arg3) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onFirstFix(arg3);
        }

        void lambda$onGpsStatusChanged$3$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor arg2, GnssStatusCompat arg3) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onSatelliteStatusChanged(arg3);
        }

        public void onGpsStatusChanged(int arg4) {
            GpsStatus v4;
            Executor v0 = this.mExecutor;
            if(v0 == null) {
            }
            else if(arg4 == 1) {
                goto label_33;
            }
            else if(arg4 != 2) {
                GpsStatus v2 = null;
                if(arg4 == 3) {
                    v4 = this.mLocationManager.getGpsStatus(v2);
                    if(v4 != null) {
                        v0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2(this, v0, v4.getTimeToFirstFix()));
                    }
                }
                else if(arg4 != 4) {
                }
                else {
                    v4 = this.mLocationManager.getGpsStatus(v2);
                    if(v4 != null) {
                        v0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3(this, v0, GnssStatusCompat.wrap(v4)));
                        return;
                    }
                }
            }
            else {
                goto label_29;
            }

            return;
        label_29:
            v0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1(this, v0));
            return;
        label_33:
            v0.execute(new LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0(this, v0));
        }

        public void register(Executor arg2) {
            boolean v0 = this.mExecutor == null ? true : false;
            Preconditions.checkState(v0);
            this.mExecutor = arg2;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(Handler arg1) {
            super();
            this.mHandler = Preconditions.checkNotNull(arg1);
        }

        public void execute(Runnable arg3) {
            if(Looper.myLooper() == this.mHandler.getLooper()) {
                arg3.run();
                return;
            }

            if(this.mHandler.post(Preconditions.checkNotNull(arg3))) {
                return;
            }

            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        LocationListenerKey(String arg2, LocationListenerCompat arg3) {
            super();
            this.mProvider = ObjectsCompat.requireNonNull(arg2, "invalid null provider");
            this.mListener = ObjectsCompat.requireNonNull(arg3, "invalid null listener");
        }

        public boolean equals(Object arg4) {
            if(!(arg4 instanceof LocationListenerKey)) {
                return 0;
            }

            if((this.mProvider.equals(((LocationListenerKey)arg4).mProvider)) && (this.mListener.equals(((LocationListenerKey)arg4).mListener))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mProvider, this.mListener});
        }
    }

    class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;
        volatile LocationListenerKey mKey;

        LocationListenerTransport(LocationListenerKey arg1, Executor arg2) {
            super();
            this.mKey = arg1;
            this.mExecutor = arg2;
        }

        public LocationListenerKey getKey() {
            return ObjectsCompat.requireNonNull(this.mKey);
        }

        void lambda$onFlushComplete$2$androidx-core-location-LocationManagerCompat$LocationListenerTransport(int arg1) {
            LocationListenerKey v0 = this.mKey;
            if(v0 == null) {
                return;
            }

            v0.mListener.onFlushComplete(arg1);
        }

        void lambda$onLocationChanged$0$androidx-core-location-LocationManagerCompat$LocationListenerTransport(Location arg1) {
            LocationListenerKey v0 = this.mKey;
            if(v0 == null) {
                return;
            }

            v0.mListener.onLocationChanged(arg1);
        }

        void lambda$onLocationChanged$1$androidx-core-location-LocationManagerCompat$LocationListenerTransport(List arg1) {
            LocationListenerKey v0 = this.mKey;
            if(v0 == null) {
                return;
            }

            v0.mListener.onLocationChanged(arg1);
        }

        void lambda$onProviderDisabled$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String arg1) {
            LocationListenerKey v0 = this.mKey;
            if(v0 == null) {
                return;
            }

            v0.mListener.onProviderDisabled(arg1);
        }

        void lambda$onProviderEnabled$4$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String arg1) {
            LocationListenerKey v0 = this.mKey;
            if(v0 == null) {
                return;
            }

            v0.mListener.onProviderEnabled(arg1);
        }

        void lambda$onStatusChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String arg1, int arg2, Bundle arg3) {
            LocationListenerKey v0 = this.mKey;
            if(v0 == null) {
                return;
            }

            v0.mListener.onStatusChanged(arg1, arg2, arg3);
        }

        public void onFlushComplete(int arg3) {
            if(this.mKey == null) {
                return;
            }

            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4(this, arg3));
        }

        public void onLocationChanged(Location arg3) {
            if(this.mKey == null) {
                return;
            }

            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3(this, arg3));
        }

        public void onLocationChanged(List arg3) {
            if(this.mKey == null) {
                return;
            }

            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2(this, arg3));
        }

        public void onProviderDisabled(String arg3) {
            if(this.mKey == null) {
                return;
            }

            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1(this, arg3));
        }

        public void onProviderEnabled(String arg3) {
            if(this.mKey == null) {
                return;
            }

            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda0(this, arg3));
        }

        public void onStatusChanged(String arg3, int arg4, Bundle arg5) {
            if(this.mKey == null) {
                return;
            }

            this.mExecutor.execute(new LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5(this, arg3, arg4, arg5));
        }

        public void unregister() {
            this.mKey = null;
        }
    }

    class PreRGnssStatusTransport extends GnssStatus$Callback {
        final Callback mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(Callback arg3) {
            super();
            boolean v0 = arg3 != null ? true : false;
            Preconditions.checkArgument(v0, "invalid null callback");
            this.mCallback = arg3;
        }

        void lambda$onFirstFix$2$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor arg2, int arg3) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onFirstFix(arg3);
        }

        void lambda$onSatelliteStatusChanged$3$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor arg2, GnssStatus arg3) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(arg3));
        }

        void lambda$onStarted$0$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor arg2) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onStarted();
        }

        void lambda$onStopped$1$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor arg2) {
            if(this.mExecutor != arg2) {
                return;
            }

            this.mCallback.onStopped();
        }

        public void onFirstFix(int arg3) {
            Executor v0 = this.mExecutor;
            if(v0 == null) {
                return;
            }

            v0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda0(this, v0, arg3));
        }

        public void onSatelliteStatusChanged(GnssStatus arg3) {
            Executor v0 = this.mExecutor;
            if(v0 == null) {
                return;
            }

            v0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1(this, v0, arg3));
        }

        public void onStarted() {
            Executor v0 = this.mExecutor;
            if(v0 == null) {
                return;
            }

            v0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3(this, v0));
        }

        public void onStopped() {
            Executor v0 = this.mExecutor;
            if(v0 == null) {
                return;
            }

            v0.execute(new LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2(this, v0));
        }

        public void register(Executor arg5) {
            boolean v0 = true;
            boolean v2 = arg5 != null ? true : false;
            Preconditions.checkArgument(v2, "invalid null executor");
            if(this.mExecutor == null) {
            }
            else {
                v0 = false;
            }

            Preconditions.checkState(v0);
            this.mExecutor = arg5;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class sGnssRequestBuilderClass;
    static final WeakHashMap sLocationListeners;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    static {
        LocationManagerCompat.sLocationListeners = new WeakHashMap();
    }

    private LocationManagerCompat() {
        super();
    }

    public static void getCurrentLocation(LocationManager arg8, String arg9, CancellationSignal arg10, Executor arg11, Consumer arg12) {
        if(Build$VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(arg8, arg9, arg10, arg11, arg12);
            return;
        }

        if(arg10 != null) {
            arg10.throwIfCanceled();
        }

        Location v0 = arg8.getLastKnownLocation(arg9);
        if(v0 != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(v0) < 10000) {
            arg11.execute(new LocationManagerCompat$$ExternalSyntheticLambda0(arg12, v0));
            return;
        }

        CancellableLocationListener v6 = new CancellableLocationListener(arg8, arg11, arg12);
        arg8.requestLocationUpdates(arg9, 0, 0f, ((LocationListener)v6), Looper.getMainLooper());
        if(arg10 != null) {
            Objects.requireNonNull(v6);
            arg10.setOnCancelListener(new LocationManagerCompat$$ExternalSyntheticLambda1(v6));
        }

        v6.startTimeout(30000);
    }

    @Deprecated public static void getCurrentLocation(LocationManager arg0, String arg1, androidx.core.os.CancellationSignal arg2, Executor arg3, Consumer arg4) {
        Object v2;
        if(arg2 != null) {
            v2 = arg2.getCancellationSignalObject();
        }
        else {
            CancellationSignal v2_1 = null;
        }

        LocationManagerCompat.getCurrentLocation(arg0, arg1, ((CancellationSignal)v2), arg3, arg4);
    }

    public static String getGnssHardwareModelName(LocationManager arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(arg2);
        }

        return null;
    }

    public static int getGnssYearOfHardware(LocationManager arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(arg2);
        }

        return 0;
    }

    public static boolean hasProvider(LocationManager arg2, String arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.hasProvider(arg2, arg3);
        }

        if(arg2.getAllProviders().contains(arg3)) {
            return 1;
        }

        try {
            if(arg2.getProvider(arg3) == null) {
                return 0;
            }
        }
        catch(SecurityException ) {
            return 0;
        }

        return 1;
    }

    public static boolean isLocationEnabled(LocationManager arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(arg2);
        }

        if(!arg2.isProviderEnabled("network")) {
            if(arg2.isProviderEnabled("gps")) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static void lambda$getCurrentLocation$0(Consumer arg0, Location arg1) {
        arg0.accept(arg1);
    }

    static Boolean lambda$registerGnssStatusCallback$1(LocationManager arg0, GpsStatusTransport arg1) throws Exception {
        return Boolean.valueOf(arg0.addGpsStatusListener(((GpsStatus$Listener)arg1)));
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager arg2, GnssMeasurementsEvent$Callback arg3, Handler arg4) {
        int v1 = 30;
        if(Build$VERSION.SDK_INT > v1) {
            return Api24Impl.registerGnssMeasurementsCallback(arg2, arg3, arg4);
        }

        if(Build$VERSION.SDK_INT == v1) {
            return LocationManagerCompat.registerGnssMeasurementsCallbackOnR(arg2, ExecutorCompat.create(arg4), arg3);
        }

        SimpleArrayMap v0 = GnssListenersHolder.sGnssMeasurementListeners;
        __monitor_enter(v0);
        try {
            LocationManagerCompat.unregisterGnssMeasurementsCallback(arg2, arg3);
            if(Api24Impl.registerGnssMeasurementsCallback(arg2, arg3, arg4)) {
                GnssListenersHolder.sGnssMeasurementListeners.put(arg3, arg3);
                __monitor_exit(v0);
                return 1;
            }

            __monitor_exit(v0);
            return 0;
        label_24:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_24;
        }

        throw v2;
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager arg2, Executor arg3, GnssMeasurementsEvent$Callback arg4) {
        int v1 = 30;
        if(Build$VERSION.SDK_INT > v1) {
            return Api31Impl.registerGnssMeasurementsCallback(arg2, arg3, arg4);
        }

        if(Build$VERSION.SDK_INT == v1) {
            return LocationManagerCompat.registerGnssMeasurementsCallbackOnR(arg2, arg3, arg4);
        }

        SimpleArrayMap v0 = GnssListenersHolder.sGnssMeasurementListeners;
        __monitor_enter(v0);
        try {
            GnssMeasurementsTransport v1_1 = new GnssMeasurementsTransport(arg4, arg3);
            LocationManagerCompat.unregisterGnssMeasurementsCallback(arg2, arg4);
            if(Api24Impl.registerGnssMeasurementsCallback(arg2, ((GnssMeasurementsEvent$Callback)v1_1))) {
                GnssListenersHolder.sGnssMeasurementListeners.put(arg4, v1_1);
                __monitor_exit(v0);
                return 1;
            }

            __monitor_exit(v0);
            return 0;
        label_25:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_25;
        }

        throw v2;
    }

    private static boolean registerGnssMeasurementsCallbackOnR(LocationManager arg7, Executor arg8, GnssMeasurementsEvent$Callback arg9) {
        Method v1_1;
        if(Build$VERSION.SDK_INT == 30) {
            try {
                Class v1 = LocationManagerCompat.sGnssRequestBuilderClass;
                if(v1 == null) {
                    v1 = Class.forName("android.location.GnssRequest$Builder");
                    LocationManagerCompat.sGnssRequestBuilderClass = v1;
                }

                if(LocationManagerCompat.sGnssRequestBuilderBuildMethod == null) {
                    v1_1 = v1.getDeclaredMethod("build");
                    LocationManagerCompat.sGnssRequestBuilderBuildMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                if(LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod == null) {
                    v1_1 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", Class.forName("android.location.GnssRequest"), Executor.class, GnssMeasurementsEvent$Callback.class);
                    LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod = v1_1;
                    v1_1.setAccessible(true);
                }

                Object v7 = LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod.invoke(arg7, LocationManagerCompat.sGnssRequestBuilderBuildMethod.invoke(LocationManagerCompat.sGnssRequestBuilderClass.getDeclaredConstructor().newInstance()), arg8, arg9);
                if(v7 != null && (((Boolean)v7).booleanValue())) {
                    return 1;
                }
            }
            catch(InstantiationException ) {
            }

            return 0;
        }

        throw new IllegalStateException();
    }

    private static boolean registerGnssStatusCallback(LocationManager arg2, Handler arg3, Executor arg4, Callback arg5) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.registerGnssStatusCallback(arg2, arg3, arg4, arg5);
        }

        return Api24Impl.registerGnssStatusCallback(arg2, arg3, arg4, arg5);
    }

    public static boolean registerGnssStatusCallback(LocationManager arg2, Callback arg3, Handler arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(arg2, ExecutorCompat.create(arg4), arg3);
        }

        return LocationManagerCompat.registerGnssStatusCallback(arg2, new InlineHandlerExecutor(arg4), arg3);
    }

    public static boolean registerGnssStatusCallback(LocationManager arg2, Executor arg3, Callback arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(arg2, null, arg3, arg4);
        }

        Looper v0 = Looper.myLooper();
        if(v0 == null) {
            v0 = Looper.getMainLooper();
        }

        return LocationManagerCompat.registerGnssStatusCallback(arg2, new Handler(v0), arg3, arg4);
    }

    static void registerLocationListenerTransport(LocationManager arg3, LocationListenerTransport arg4) {
        Object v4 = LocationManagerCompat.sLocationListeners.put(arg4.getKey(), new WeakReference(arg4));
        v4 = v4 != null ? ((WeakReference)v4).get() : null;
        if(v4 != null) {
            ((LocationListenerTransport)v4).unregister();
            arg3.removeUpdates(((LocationListener)v4));
        }
    }

    public static void removeUpdates(LocationManager arg6, LocationListenerCompat arg7) {
        WeakHashMap v0 = LocationManagerCompat.sLocationListeners;
        __monitor_enter(v0);
        try {
            Iterator v1 = v0.values().iterator();
            ArrayList v2 = null;
            while(v1.hasNext()) {
                Object v3 = v1.next().get();
                if(v3 == null) {
                    continue;
                }

                LocationListenerKey v4 = ((LocationListenerTransport)v3).getKey();
                if(v4.mListener != arg7) {
                    continue;
                }

                if(v2 == null) {
                    v2 = new ArrayList();
                }

                v2.add(v4);
                ((LocationListenerTransport)v3).unregister();
                arg6.removeUpdates(((LocationListener)v3));
            }

            if(v2 != null) {
                v1 = v2.iterator();
                while(v1.hasNext()) {
                    LocationManagerCompat.sLocationListeners.remove(v1.next());
                }
            }

            __monitor_exit(v0);
        }
        catch(Throwable v6) {
            goto label_33;
        }

        arg6.removeUpdates(((LocationListener)arg7));
        return;
        try {
        label_33:
            __monitor_exit(v0);
        }
        catch(Throwable v6) {
            goto label_33;
        }

        throw v6;
    }

    public static void requestLocationUpdates(LocationManager arg8, String arg9, LocationRequestCompat arg10, LocationListenerCompat arg11, Looper arg12) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            Api31Impl.requestLocationUpdates(arg8, arg9, arg10.toLocationRequest(), ExecutorCompat.create(new Handler(arg12)), ((LocationListener)arg11));
            return;
        }

        if(Api19Impl.tryRequestLocationUpdates(arg8, arg9, arg10, arg11, arg12)) {
            return;
        }

        arg8.requestLocationUpdates(arg9, arg10.getIntervalMillis(), arg10.getMinUpdateDistanceMeters(), arg11, arg12);
    }

    public static void requestLocationUpdates(LocationManager arg8, String arg9, LocationRequestCompat arg10, Executor arg11, LocationListenerCompat arg12) {
        Throwable v8;
        LocationListenerTransport v6;
        if(Build$VERSION.SDK_INT >= 0x1F) {
            Api31Impl.requestLocationUpdates(arg8, arg9, arg10.toLocationRequest(), arg11, ((LocationListener)arg12));
            return;
        }

        if(Build$VERSION.SDK_INT < 30 || !Api30Impl.tryRequestLocationUpdates(arg8, arg9, arg10, arg11, arg12)) {
            v6 = new LocationListenerTransport(new LocationListenerKey(arg9, arg12), arg11);
            if(Api19Impl.tryRequestLocationUpdates(arg8, arg9, arg10, v6)) {
                return;
            }

            goto label_19;
        }
        else {
        }

        return;
    label_19:
        WeakHashMap v11 = LocationManagerCompat.sLocationListeners;
        __monitor_enter(v11);
        try {
            arg8.requestLocationUpdates(arg9, arg10.getIntervalMillis(), arg10.getMinUpdateDistanceMeters(), ((LocationListener)v6), Looper.getMainLooper());
            LocationManagerCompat.registerLocationListenerTransport(arg8, v6);
            __monitor_exit(v11);
            return;
        label_31:
            v8 = v0;
            __monitor_exit(v11);
        }
        catch(Throwable v0) {
            goto label_31;
        }

        throw v8;
    }

    public static void unregisterGnssMeasurementsCallback(LocationManager arg2, GnssMeasurementsEvent$Callback arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            Api24Impl.unregisterGnssMeasurementsCallback(arg2, arg3);
            return;
        }

        SimpleArrayMap v0 = GnssListenersHolder.sGnssMeasurementListeners;
        __monitor_enter(v0);
        try {
            Object v3 = GnssListenersHolder.sGnssMeasurementListeners.remove(arg3);
            if(v3 != null) {
                if((v3 instanceof GnssMeasurementsTransport)) {
                    v3.unregister();
                }

                Api24Impl.unregisterGnssMeasurementsCallback(arg2, ((GnssMeasurementsEvent$Callback)v3));
            }

            __monitor_exit(v0);
            return;
        label_18:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_18;
        }

        throw v2;
    }

    public static void unregisterGnssStatusCallback(LocationManager arg2, Callback arg3) {
        SimpleArrayMap v0 = GnssListenersHolder.sGnssStatusListeners;
        __monitor_enter(v0);
        try {
            Object v3 = GnssListenersHolder.sGnssStatusListeners.remove(arg3);
            if(v3 != null) {
                Api24Impl.unregisterGnssStatusCallback(arg2, v3);
            }

            __monitor_exit(v0);
            return;
        label_9:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_9;
        }

        throw v2;
    }
}

