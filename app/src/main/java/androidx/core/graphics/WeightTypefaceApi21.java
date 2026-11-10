package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor sConstructor;
    private static final Method sNativeCreateFromTypeface;
    private static final Method sNativeCreateWeightAlias;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray sWeightTypefaceCache;

    static {
        Constructor v0_2;
        Method v3;
        Method v2;
        Field v1;
        try {
            Class v0_1 = Typeface.class;
            v1 = v0_1.getDeclaredField("native_instance");
            v2 = v0_1.getDeclaredMethod("nativeCreateFromTypeface", Long.TYPE, Integer.TYPE);
            v2.setAccessible(true);
            v3 = v0_1.getDeclaredMethod("nativeCreateWeightAlias", Long.TYPE, Integer.TYPE);
            v3.setAccessible(true);
            v0_2 = v0_1.getDeclaredConstructor(Long.TYPE);
            v0_2.setAccessible(true);
        }
        catch(NoSuchMethodException v0) {
            Log.e("WeightTypeface", v0.getClass().getName(), ((Throwable)v0));
            v1 = null;
            v0_2 = ((Constructor)v1);
            v2 = ((Method)v0_2);
            v3 = v2;
        }

        WeightTypefaceApi21.sNativeInstance = v1;
        WeightTypefaceApi21.sNativeCreateFromTypeface = v2;
        WeightTypefaceApi21.sNativeCreateWeightAlias = v3;
        WeightTypefaceApi21.sConstructor = v0_2;
        WeightTypefaceApi21.sWeightTypefaceCache = new LongSparseArray(3);
        WeightTypefaceApi21.sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi21() {
        super();
    }

    private static Typeface create(long arg2) {
        Typeface v0 = null;
        try {
            return WeightTypefaceApi21.sConstructor.newInstance(Long.valueOf(arg2));
        }
        catch(InvocationTargetException ) {
            return v0;
        }
    }

    static Typeface createWeightStyle(Typeface arg7, int arg8, boolean arg9) {
        SparseArray v5_1;
        if(!WeightTypefaceApi21.isPrivateApiAvailable()) {
            return null;
        }

        int v0 = arg8 << 1 | (((int)arg9));
        Object v1 = WeightTypefaceApi21.sWeightCacheLock;
        __monitor_enter(v1);
        try {
            long v2 = WeightTypefaceApi21.getNativeInstance(arg7);
            LongSparseArray v4 = WeightTypefaceApi21.sWeightTypefaceCache;
            Object v5 = v4.get(v2);
            if(v5 == null) {
                v5_1 = new SparseArray(4);
                v4.put(v2, v5_1);
            }
            else {
                Object v4_1 = ((SparseArray)v5).get(v0);
                if(v4_1 != null) {
                    __monitor_exit(v1);
                    return ((Typeface)v4_1);
                }
            }

            arg7 = arg9 == arg7.isItalic() ? WeightTypefaceApi21.create(WeightTypefaceApi21.nativeCreateWeightAlias(v2, arg8)) : WeightTypefaceApi21.create(WeightTypefaceApi21.nativeCreateFromTypefaceWithExactStyle(v2, arg8, arg9));
            v5_1.put(v0, arg7);
            __monitor_exit(v1);
            return arg7;
        label_32:
            __monitor_exit(v1);
        }
        catch(Throwable v7) {
            goto label_32;
        }

        throw v7;
    }

    private static long getNativeInstance(Typeface arg2) {
        try {
            return WeightTypefaceApi21.sNativeInstance.getLong(arg2);
        }
        catch(IllegalAccessException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
    }

    private static boolean isPrivateApiAvailable() {
        if(WeightTypefaceApi21.sNativeInstance != null) {
            return 1;
        }

        return 0;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long arg2, int arg4, boolean arg5) {
        int v5 = arg5 ? 2 : 0;
        try {
            return WeightTypefaceApi21.sNativeCreateWeightAlias.invoke(null, Long.valueOf(WeightTypefaceApi21.sNativeCreateFromTypeface.invoke(null, Long.valueOf(arg2), Integer.valueOf(v5)).longValue()), Integer.valueOf(arg4)).longValue();
        }
        catch(InvocationTargetException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
        catch(IllegalAccessException v2_1) {
            throw new RuntimeException(((Throwable)v2_1));
        }
    }

    private static long nativeCreateWeightAlias(long arg1, int arg3) {
        try {
            return WeightTypefaceApi21.sNativeCreateWeightAlias.invoke(null, Long.valueOf(arg1), Integer.valueOf(arg3)).longValue();
        }
        catch(InvocationTargetException v1) {
            throw new RuntimeException(((Throwable)v1));
        }
        catch(IllegalAccessException v1_1) {
            throw new RuntimeException(((Throwable)v1_1));
        }
    }
}

