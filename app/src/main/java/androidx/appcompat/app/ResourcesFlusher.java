package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build$VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher {
    class Api16Impl {
        private Api16Impl() {
            super();
        }

        static void clear(LongSparseArray arg0) {
            arg0.clear();
        }
    }

    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    private ResourcesFlusher() {
        super();
    }

    static void flush(Resources arg2) {
        if(Build$VERSION.SDK_INT >= 28) {
            return;
        }

        ResourcesFlusher.flushNougats(arg2);
    }

    private static void flushLollipops(Resources arg4) {
        Object v4_1;
        String v1 = "ResourcesFlusher";
        if(!ResourcesFlusher.sDrawableCacheFieldFetched) {
            try {
                Field v2_1 = Resources.class.getDeclaredField("mDrawableCache");
                ResourcesFlusher.sDrawableCacheField = v2_1;
                v2_1.setAccessible(true);
            }
            catch(NoSuchFieldException v2) {
                Log.e(v1, "Could not retrieve Resources#mDrawableCache field", ((Throwable)v2));
            }

            ResourcesFlusher.sDrawableCacheFieldFetched = true;
        }

        Field v0 = ResourcesFlusher.sDrawableCacheField;
        if(v0 != null) {
            try {
                v4_1 = v0.get(arg4);
            }
            catch(IllegalAccessException v4) {
                Log.e(v1, "Could not retrieve value from Resources#mDrawableCache", ((Throwable)v4));
                v4_1 = null;
            }

            if(v4_1 == null) {
                return;
            }

            ((Map)v4_1).clear();
        }
    }

    private static void flushMarshmallows(Resources arg4) {
        Object v4_1;
        String v1 = "ResourcesFlusher";
        if(!ResourcesFlusher.sDrawableCacheFieldFetched) {
            try {
                Field v2_1 = Resources.class.getDeclaredField("mDrawableCache");
                ResourcesFlusher.sDrawableCacheField = v2_1;
                v2_1.setAccessible(true);
            }
            catch(NoSuchFieldException v2) {
                Log.e(v1, "Could not retrieve Resources#mDrawableCache field", ((Throwable)v2));
            }

            ResourcesFlusher.sDrawableCacheFieldFetched = true;
        }

        Field v0 = ResourcesFlusher.sDrawableCacheField;
        if(v0 != null) {
            try {
                v4_1 = v0.get(arg4);
                goto label_22;
            }
            catch(IllegalAccessException v4) {
                Log.e(v1, "Could not retrieve value from Resources#mDrawableCache", ((Throwable)v4));
            }
        }

        v4_1 = null;
    label_22:
        if(v4_1 == null) {
            return;
        }

        ResourcesFlusher.flushThemedResourcesCache(v4_1);
    }

    private static void flushNougats(Resources arg5) {
        Object v5_1;
        Field v0_1;
        String v2 = "ResourcesFlusher";
        if(!ResourcesFlusher.sResourcesImplFieldFetched) {
            try {
                v0_1 = Resources.class.getDeclaredField("mResourcesImpl");
                ResourcesFlusher.sResourcesImplField = v0_1;
                v0_1.setAccessible(true);
            }
            catch(NoSuchFieldException v0) {
                Log.e(v2, "Could not retrieve Resources#mResourcesImpl field", ((Throwable)v0));
            }

            ResourcesFlusher.sResourcesImplFieldFetched = true;
        }

        v0_1 = ResourcesFlusher.sResourcesImplField;
        if(v0_1 != null) {
            Object v3 = null;
            try {
                v5_1 = v0_1.get(arg5);
            }
            catch(IllegalAccessException v5) {
                Log.e(v2, "Could not retrieve value from Resources#mResourcesImpl", ((Throwable)v5));
                v5_1 = v3;
            }

            if(v5_1 == null) {
                return;
            }

            if(!ResourcesFlusher.sDrawableCacheFieldFetched) {
                try {
                    v0_1 = v5_1.getClass().getDeclaredField("mDrawableCache");
                    ResourcesFlusher.sDrawableCacheField = v0_1;
                    v0_1.setAccessible(true);
                }
                catch(NoSuchFieldException v0) {
                    Log.e(v2, "Could not retrieve ResourcesImpl#mDrawableCache field", ((Throwable)v0));
                }

                ResourcesFlusher.sDrawableCacheFieldFetched = true;
            }

            v0_1 = ResourcesFlusher.sDrawableCacheField;
            if(v0_1 != null) {
                try {
                    v3 = v0_1.get(v5_1);
                }
                catch(IllegalAccessException v5) {
                    Log.e(v2, "Could not retrieve value from ResourcesImpl#mDrawableCache", ((Throwable)v5));
                }
            }

            if(v3 != null) {
                ResourcesFlusher.flushThemedResourcesCache(v3);
            }
        }
    }

    private static void flushThemedResourcesCache(Object arg4) {
        Field v0_3;
        String v2 = "ResourcesFlusher";
        if(!ResourcesFlusher.sThemedResourceCacheClazzFetched) {
            try {
                ResourcesFlusher.sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            }
            catch(ClassNotFoundException v0) {
                Log.e(v2, "Could not find ThemedResourceCache class", ((Throwable)v0));
            }

            ResourcesFlusher.sThemedResourceCacheClazzFetched = true;
        }

        Class v0_1 = ResourcesFlusher.sThemedResourceCacheClazz;
        if(v0_1 != null) {
            if(!ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesFieldFetched) {
                try {
                    v0_3 = v0_1.getDeclaredField("mUnthemedEntries");
                    ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField = v0_3;
                    v0_3.setAccessible(true);
                }
                catch(NoSuchFieldException v0_2) {
                    Log.e(v2, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", ((Throwable)v0_2));
                }

                ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
            }

            v0_3 = ResourcesFlusher.sThemedResourceCache_mUnthemedEntriesField;
            if(v0_3 == null) {
                return;
            }

            try {
                arg4 = v0_3.get(arg4);
            }
            catch(IllegalAccessException v4) {
                Log.e(v2, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", ((Throwable)v4));
                arg4 = null;
            }

            if(arg4 != null) {
                Api16Impl.clear(((LongSparseArray)arg4));
            }
        }
    }
}

