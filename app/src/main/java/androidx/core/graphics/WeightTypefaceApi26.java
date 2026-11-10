package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class WeightTypefaceApi26 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD = "nativeCreateFromTypefaceWithExactStyle";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor sConstructor;
    private static final Method sNativeCreateFromTypefaceWithExactStyle;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray sWeightTypefaceCache;

    static {
        Constructor v1_3;
        Method v3;
        Field v2;
        int v0 = 3;
        try {
            Class v1_2 = Typeface.class;
            v2 = v1_2.getDeclaredField("native_instance");
            v3 = v1_2.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", Long.TYPE, Integer.TYPE, Boolean.TYPE);
            v3.setAccessible(true);
            v1_3 = v1_2.getDeclaredConstructor(Long.TYPE);
            v1_3.setAccessible(true);
            goto label_33;
        }
        catch(NoSuchMethodException v1) {
        }
        catch(NoSuchFieldException v1_1) {
        }

        Log.e("WeightTypeface", v1_1.getClass().getName(), ((Throwable)v1_1));
        v2 = null;
        v1_3 = ((Constructor)v2);
        v3 = ((Method)v1_3);
    label_33:
        WeightTypefaceApi26.sNativeInstance = v2;
        WeightTypefaceApi26.sNativeCreateFromTypefaceWithExactStyle = v3;
        WeightTypefaceApi26.sConstructor = v1_3;
        WeightTypefaceApi26.sWeightTypefaceCache = new LongSparseArray(v0);
        WeightTypefaceApi26.sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi26() {
        super();
    }

    private static Typeface create(long arg2) {
        Typeface v0 = null;
        try {
            return WeightTypefaceApi26.sConstructor.newInstance(Long.valueOf(arg2));
        }
        catch(InvocationTargetException ) {
            return v0;
        }
    }

    static Typeface createWeightStyle(Typeface arg6, int arg7, boolean arg8) {
        SparseArray v4_1;
        if(!WeightTypefaceApi26.isPrivateApiAvailable()) {
            return null;
        }

        int v0 = arg7 << 1 | (((int)arg8));
        Object v1 = WeightTypefaceApi26.sWeightCacheLock;
        __monitor_enter(v1);
        try {
            long v2 = WeightTypefaceApi26.getNativeInstance(arg6);
            LongSparseArray v6_1 = WeightTypefaceApi26.sWeightTypefaceCache;
            Object v4 = v6_1.get(v2);
            if(v4 == null) {
                v4_1 = new SparseArray(4);
                v6_1.put(v2, v4_1);
            }
            else {
                Object v6_2 = ((SparseArray)v4).get(v0);
                if(v6_2 != null) {
                    __monitor_exit(v1);
                    return ((Typeface)v6_2);
                }
            }

            arg6 = WeightTypefaceApi26.create(WeightTypefaceApi26.nativeCreateFromTypefaceWithExactStyle(v2, arg7, arg8));
            v4_1.put(v0, arg6);
            __monitor_exit(v1);
            return arg6;
        label_27:
            __monitor_exit(v1);
        }
        catch(Throwable v6) {
            goto label_27;
        }

        throw v6;
    }

    private static long getNativeInstance(Typeface arg2) {
        try {
            return WeightTypefaceApi26.sNativeInstance.getLong(arg2);
        }
        catch(IllegalAccessException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
    }

    private static boolean isPrivateApiAvailable() {
        if(WeightTypefaceApi26.sNativeInstance != null) {
            return 1;
        }

        return 0;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long arg1, int arg3, boolean arg4) {
        try {
            return WeightTypefaceApi26.sNativeCreateFromTypefaceWithExactStyle.invoke(null, Long.valueOf(arg1), Integer.valueOf(arg3), Boolean.valueOf(arg4)).longValue();
        }
        catch(InvocationTargetException v1) {
            throw new RuntimeException(((Throwable)v1));
        }
        catch(IllegalAccessException v1_1) {
            throw new RuntimeException(((Throwable)v1_1));
        }
    }
}

