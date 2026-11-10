package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import java.lang.reflect.Field;

final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray sWeightTypefaceCache;

    static {
        Field v0_1;
        try {
            v0_1 = Typeface.class.getDeclaredField("native_instance");
            v0_1.setAccessible(true);
        }
        catch(Exception v0) {
            Log.e("WeightTypeface", v0.getClass().getName(), ((Throwable)v0));
            v0_1 = null;
        }

        WeightTypefaceApi14.sNativeInstance = v0_1;
        WeightTypefaceApi14.sWeightTypefaceCache = new LongSparseArray(3);
        WeightTypefaceApi14.sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi14() {
        super();
    }

    static Typeface createWeightStyle(TypefaceCompatBaseImpl arg7, Context arg8, Typeface arg9, int arg10, boolean arg11) {
        SparseArray v5_1;
        if(!WeightTypefaceApi14.isPrivateApiAvailable()) {
            return null;
        }

        int v0 = arg10 << 1 | (((int)arg11));
        Object v1 = WeightTypefaceApi14.sWeightCacheLock;
        __monitor_enter(v1);
        try {
            long v2 = WeightTypefaceApi14.getNativeInstance(arg9);
            LongSparseArray v4 = WeightTypefaceApi14.sWeightTypefaceCache;
            Object v5 = v4.get(v2);
            if(v5 == null) {
                v5_1 = new SparseArray(4);
                v4.put(v2, v5_1);
            }
            else {
                Object v2_1 = ((SparseArray)v5).get(v0);
                if(v2_1 != null) {
                    __monitor_exit(v1);
                    return ((Typeface)v2_1);
                }
            }

            Typeface v7_1 = WeightTypefaceApi14.getBestFontFromFamily(arg7, arg8, arg9, arg10, arg11);
            if(v7_1 == null) {
                v7_1 = WeightTypefaceApi14.platformTypefaceCreate(arg9, arg10, arg11);
            }

            v5_1.put(v0, v7_1);
            __monitor_exit(v1);
            return v7_1;
        label_28:
            __monitor_exit(v1);
        }
        catch(Throwable v7) {
            goto label_28;
        }

        throw v7;
    }

    private static Typeface getBestFontFromFamily(TypefaceCompatBaseImpl arg6, Context arg7, Typeface arg8, int arg9, boolean arg10) {
        FontFamilyFilesResourceEntry v2 = arg6.getFontFamily(arg8);
        if(v2 == null) {
            return null;
        }

        return arg6.createFromFontFamilyFilesResourceEntry(arg7, v2, arg7.getResources(), arg9, arg10);
    }

    private static long getNativeInstance(Typeface arg2) {
        try {
            return WeightTypefaceApi14.sNativeInstance.get(arg2).longValue();
        }
        catch(IllegalAccessException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
    }

    private static boolean isPrivateApiAvailable() {
        if(WeightTypefaceApi14.sNativeInstance != null) {
            return 1;
        }

        return 0;
    }

    private static Typeface platformTypefaceCreate(Typeface arg3, int arg4, boolean arg5) {
        int v1 = 1;
        arg4 = arg4 >= 600 ? 1 : 0;
        if(arg4 == 0 && !arg5) {
            v1 = 0;
        }
        else if(arg4 == 0) {
            v1 = 2;
        }
        else if(!arg5) {
        }
        else {
            v1 = 3;
        }

        return Typeface.create(arg3, v1);
    }
}

