package androidx.core.view;

import android.os.Build$VERSION;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class VelocityTrackerCompat {
    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static float getAxisVelocity(VelocityTracker arg0, int arg1) {
            return arg0.getAxisVelocity(arg1);
        }

        static float getAxisVelocity(VelocityTracker arg0, int arg1, int arg2) {
            return arg0.getAxisVelocity(arg1, arg2);
        }

        static boolean isAxisSupported(VelocityTracker arg0, int arg1) {
            return arg0.isAxisSupported(arg1);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface VelocityTrackableMotionEventAxis {
    }

    private static Map sFallbackTrackers;

    static {
        VelocityTrackerCompat.sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());
    }

    private VelocityTrackerCompat() {
        super();
    }

    public static void addMovement(VelocityTracker arg2, MotionEvent arg3) {
        arg2.addMovement(arg3);
        if(Build$VERSION.SDK_INT >= 34) {
        }
        else if(arg3.getSource() == 0x400000) {
            if(!VelocityTrackerCompat.sFallbackTrackers.containsKey(arg2)) {
                VelocityTrackerCompat.sFallbackTrackers.put(arg2, new VelocityTrackerFallback());
            }

            VelocityTrackerCompat.sFallbackTrackers.get(arg2).addMovement(arg3);
        }
    }

    public static void clear(VelocityTracker arg0) {
        arg0.clear();
        VelocityTrackerCompat.removeFallbackForTracker(arg0);
    }

    public static void computeCurrentVelocity(VelocityTracker arg1, int arg2) {
        VelocityTrackerCompat.computeCurrentVelocity(arg1, arg2, 3.402823E+38f);
    }

    public static void computeCurrentVelocity(VelocityTracker arg0, int arg1, float arg2) {
        arg0.computeCurrentVelocity(arg1, arg2);
        VelocityTrackerFallback v0 = VelocityTrackerCompat.getFallbackTrackerOrNull(arg0);
        if(v0 != null) {
            v0.computeCurrentVelocity(arg1, arg2);
        }
    }

    public static float getAxisVelocity(VelocityTracker arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(arg2, arg3);
        }

        if(arg3 == 0) {
            return arg2.getXVelocity();
        }

        if(arg3 == 1) {
            return arg2.getYVelocity();
        }

        VelocityTrackerFallback v2 = VelocityTrackerCompat.getFallbackTrackerOrNull(arg2);
        if(v2 != null) {
            return v2.getAxisVelocity(arg3);
        }

        return 0;
    }

    public static float getAxisVelocity(VelocityTracker arg2, int arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(arg2, arg3, arg4);
        }

        if(arg3 == 0) {
            return arg2.getXVelocity(arg4);
        }

        if(arg3 == 1) {
            return arg2.getYVelocity(arg4);
        }

        return 0;
    }

    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker arg1) {
        return VelocityTrackerCompat.sFallbackTrackers.get(arg1);
    }

    @ReplaceWith(expression="tracker.getXVelocity(pointerId)") @Deprecated public static float getXVelocity(VelocityTracker arg0, int arg1) {
        return arg0.getXVelocity(arg1);
    }

    @ReplaceWith(expression="tracker.getYVelocity(pointerId)") @Deprecated public static float getYVelocity(VelocityTracker arg0, int arg1) {
        return arg0.getYVelocity(arg1);
    }

    public static boolean isAxisSupported(VelocityTracker arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api34Impl.isAxisSupported(arg2, arg3);
        }

        if(arg3 != 26 && arg3 != 0) {
            if(arg3 == 1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static void recycle(VelocityTracker arg0) {
        arg0.recycle();
        VelocityTrackerCompat.removeFallbackForTracker(arg0);
    }

    private static void removeFallbackForTracker(VelocityTracker arg1) {
        VelocityTrackerCompat.sFallbackTrackers.remove(arg1);
    }
}

