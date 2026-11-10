package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static float getFloat(Resources arg0, int arg1) {
            return arg0.getFloat(arg1);
        }
    }

    class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(ColorStateList arg1, Configuration arg2, Resources$Theme arg3) {
            super();
            this.mValue = arg1;
            this.mConfiguration = arg2;
            int v1 = arg3 == null ? 0 : arg3.hashCode();
            this.mThemeHash = v1;
        }
    }

    final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources$Theme mTheme;

        ColorStateListCacheKey(Resources arg1, Resources$Theme arg2) {
            super();
            this.mResources = arg1;
            this.mTheme = arg2;
        }

        public boolean equals(Object arg5) {
            if(this == (((ColorStateListCacheKey)arg5))) {
                return 1;
            }

            if(arg5 != null) {
                if(this.getClass() != arg5.getClass()) {
                }
                else if((this.mResources.equals(((ColorStateListCacheKey)arg5).mResources)) && (ObjectsCompat.equals(this.mTheme, ((ColorStateListCacheKey)arg5).mTheme))) {
                    return 1;
                }
            }

            return 0;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mResources, this.mTheme});
        }
    }

    public abstract class FontCallback {
        public FontCallback() {
            super();
        }

        public final void callbackFailAsync(int arg2, Handler arg3) {
            FontCallback.getHandler(arg3).post(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(this, arg2));
        }

        public final void callbackSuccessAsync(Typeface arg2, Handler arg3) {
            FontCallback.getHandler(arg3).post(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(this, arg2));
        }

        public static Handler getHandler(Handler arg1) {
            if(arg1 == null) {
                arg1 = new Handler(Looper.getMainLooper());
            }

            return arg1;
        }

        void lambda$callbackFailAsync$1$androidx-core-content-res-ResourcesCompat$FontCallback(int arg1) {
            this.onFontRetrievalFailed(arg1);
        }

        void lambda$callbackSuccessAsync$0$androidx-core-content-res-ResourcesCompat$FontCallback(Typeface arg1) {
            this.onFontRetrieved(arg1);
        }

        public abstract void onFontRetrievalFailed(int arg1);

        public abstract void onFontRetrieved(Typeface arg1);
    }

    public final class ThemeCompat {
        class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock;

            static {
                Api23Impl.sRebaseMethodLock = new Object();
            }

            private Api23Impl() {
                super();
            }

            static void rebase(Resources$Theme arg6) {
                Object v0 = Api23Impl.sRebaseMethodLock;
                __monitor_enter(v0);
                try {
                    if(Api23Impl.sRebaseMethodFetched) {
                        goto label_18;
                    }
                }
                catch(Throwable v6) {
                    goto label_34;
                }

                try {
                    Method v3_1 = Resources$Theme.class.getDeclaredMethod("rebase");
                    Api23Impl.sRebaseMethod = v3_1;
                    v3_1.setAccessible(true);
                    goto label_17;
                }
                catch(Throwable v6) {
                label_35:
                    throw v6;
                }
                catch(NoSuchMethodException v3) {
                    try {
                        Log.i("ResourcesCompat", "Failed to retrieve rebase() method", ((Throwable)v3));
                    label_17:
                        Api23Impl.sRebaseMethodFetched = true;
                    label_18:
                        Method v1 = Api23Impl.sRebaseMethod;
                        if(v1 == null) {
                            goto label_31;
                        }

                        try {
                            v1.invoke(arg6);
                            goto label_31;
                        }
                        catch(InvocationTargetException v6_1) {
                        }
                        catch(IllegalAccessException v6_2) {
                        }
                    }
                    catch(Throwable v6) {
                        goto label_34;
                    }

                    try {
                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", ((Throwable)v6_2));
                        Api23Impl.sRebaseMethod = null;
                    label_31:
                        __monitor_exit(v0);
                        return;
                    label_34:
                        __monitor_exit(v0);
                        goto label_35;
                    }
                    catch(Throwable v6) {
                        goto label_34;
                    }
                }
            }
        }

        class androidx.core.content.res.ResourcesCompat$ThemeCompat$Api29Impl {
            private androidx.core.content.res.ResourcesCompat$ThemeCompat$Api29Impl() {
                super();
            }

            static void rebase(Resources$Theme arg0) {
                arg0.rebase();
            }
        }

        private ThemeCompat() {
            super();
        }

        public static void rebase(Resources$Theme arg2) {
            if(Build$VERSION.SDK_INT >= 29) {
                androidx.core.content.res.ResourcesCompat$ThemeCompat$Api29Impl.rebase(arg2);
                return;
            }

            Api23Impl.rebase(arg2);
        }
    }

    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap sColorStateCaches;
    private static final ThreadLocal sTempTypedValue;

    static {
        ResourcesCompat.sTempTypedValue = new ThreadLocal();
        ResourcesCompat.sColorStateCaches = new WeakHashMap(0);
        ResourcesCompat.sColorStateCacheLock = new Object();
    }

    private ResourcesCompat() {
        super();
    }

    private static void addColorStateListToCache(ColorStateListCacheKey arg3, int arg4, ColorStateList arg5, Resources$Theme arg6) {
        Object v0 = ResourcesCompat.sColorStateCacheLock;
        __monitor_enter(v0);
        try {
            WeakHashMap v1 = ResourcesCompat.sColorStateCaches;
            Object v2 = v1.get(arg3);
            if(v2 == null) {
                SparseArray v2_1 = new SparseArray();
                v1.put(arg3, v2_1);
            }

            ((SparseArray)v2).append(arg4, new ColorStateListCacheEntry(arg5, arg3.mResources.getConfiguration(), arg6));
            __monitor_exit(v0);
            return;
        label_16:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_16;
        }

        throw v3;
    }

    public static void clearCachesForTheme(Resources$Theme arg3) {
        Object v0 = ResourcesCompat.sColorStateCacheLock;
        __monitor_enter(v0);
        try {
            Iterator v1 = ResourcesCompat.sColorStateCaches.keySet().iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                if(v2 == null) {
                    continue;
                }

                if(!arg3.equals(((ColorStateListCacheKey)v2).mTheme)) {
                    continue;
                }

                v1.remove();
            }

            __monitor_exit(v0);
            return;
        label_17:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_17;
        }

        throw v3;
    }

    private static ColorStateList getCachedColorStateList(ColorStateListCacheKey arg5, int arg6) {
        Object v0 = ResourcesCompat.sColorStateCacheLock;
        __monitor_enter(v0);
        try {
            Object v1 = ResourcesCompat.sColorStateCaches.get(arg5);
            if(v1 != null && ((SparseArray)v1).size() > 0) {
                Object v2 = ((SparseArray)v1).get(arg6);
                if(v2 != null) {
                    if(((ColorStateListCacheEntry)v2).mConfiguration.equals(arg5.mResources.getConfiguration())) {
                        if(arg5.mTheme != null || ((ColorStateListCacheEntry)v2).mThemeHash != 0) {
                            if(arg5.mTheme == null) {
                            }
                            else if(((ColorStateListCacheEntry)v2).mThemeHash == arg5.mTheme.hashCode()) {
                                goto label_24;
                            }

                            goto label_27;
                        }

                    label_24:
                        __monitor_exit(v0);
                        return ((ColorStateListCacheEntry)v2).mValue;
                    }

                label_27:
                    ((SparseArray)v1).remove(arg6);
                }
            }

            __monitor_exit(v0);
            return null;
        label_32:
            __monitor_exit(v0);
        }
        catch(Throwable v5) {
            goto label_32;
        }

        throw v5;
    }

    public static Typeface getCachedFont(Context arg8, int arg9) throws Resources$NotFoundException {
        if(arg8.isRestricted()) {
            return null;
        }

        return ResourcesCompat.loadFont(arg8, arg9, new TypedValue(), 0, null, null, false, true);
    }

    public static int getColor(Resources arg0, int arg1, Resources$Theme arg2) throws Resources$NotFoundException {
        return arg0.getColor(arg1, arg2);
    }

    public static ColorStateList getColorStateList(Resources arg2, int arg3, Resources$Theme arg4) throws Resources$NotFoundException {
        ColorStateListCacheKey v0 = new ColorStateListCacheKey(arg2, arg4);
        ColorStateList v1 = ResourcesCompat.getCachedColorStateList(v0, arg3);
        if(v1 != null) {
            return v1;
        }

        v1 = ResourcesCompat.inflateColorStateList(arg2, arg3, arg4);
        if(v1 != null) {
            ResourcesCompat.addColorStateListToCache(v0, arg3, v1, arg4);
            return v1;
        }

        return arg2.getColorStateList(arg3, arg4);
    }

    public static Drawable getDrawable(Resources arg0, int arg1, Resources$Theme arg2) throws Resources$NotFoundException {
        return arg0.getDrawable(arg1, arg2);
    }

    public static Drawable getDrawableForDensity(Resources arg0, int arg1, int arg2, Resources$Theme arg3) throws Resources$NotFoundException {
        return arg0.getDrawableForDensity(arg1, arg2, arg3);
    }

    public static float getFloat(Resources arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.getFloat(arg3, arg4);
        }

        TypedValue v0 = ResourcesCompat.getTypedValue();
        arg3.getValue(arg4, v0, true);
        if(v0.type == 4) {
            return v0.getFloat();
        }

        throw new Resources$NotFoundException("Resource ID #0x" + Integer.toHexString(arg4) + " type #0x" + Integer.toHexString(v0.type) + " is not valid");
    }

    public static Typeface getFont(Context arg8, int arg9, TypedValue arg10, int arg11, FontCallback arg12) throws Resources$NotFoundException {
        if(arg8.isRestricted()) {
            return null;
        }

        return ResourcesCompat.loadFont(arg8, arg9, arg10, arg11, arg12, null, true, false);
    }

    public static Typeface getFont(Context arg8, int arg9) throws Resources$NotFoundException {
        if(arg8.isRestricted()) {
            return null;
        }

        return ResourcesCompat.loadFont(arg8, arg9, new TypedValue(), 0, null, null, false, false);
    }

    public static void getFont(Context arg8, int arg9, FontCallback arg10, Handler arg11) throws Resources$NotFoundException {
        Preconditions.checkNotNull(arg10);
        if(arg8.isRestricted()) {
            arg10.callbackFailAsync(-4, arg11);
            return;
        }

        ResourcesCompat.loadFont(arg8, arg9, new TypedValue(), 0, arg10, arg11, false, false);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal v0 = ResourcesCompat.sTempTypedValue;
        Object v1 = v0.get();
        if(v1 == null) {
            TypedValue v1_1 = new TypedValue();
            v0.set(v1_1);
        }

        return ((TypedValue)v1);
    }

    private static ColorStateList inflateColorStateList(Resources arg2, int arg3, Resources$Theme arg4) {
        ColorStateList v1 = null;
        if(ResourcesCompat.isColorInt(arg2, arg3)) {
            return v1;
        }

        XmlResourceParser v3 = arg2.getXml(arg3);
        try {
            return ColorStateListInflaterCompat.createFromXml(arg2, ((XmlPullParser)v3), arg4);
        }
        catch(Exception v2) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", ((Throwable)v2));
            return v1;
        }
    }

    private static boolean isColorInt(Resources arg2, int arg3) {
        TypedValue v0 = ResourcesCompat.getTypedValue();
        arg2.getValue(arg3, v0, true);
        if(v0.type >= 28 && v0.type <= 0x1F) {
            return 1;
        }

        return 0;
    }

    private static Typeface loadFont(Context arg9, int arg10, TypedValue arg11, int arg12, FontCallback arg13, Handler arg14, boolean arg15, boolean arg16) {
        Resources v1 = arg9.getResources();
        v1.getValue(arg10, arg11, true);
        Typeface v9 = ResourcesCompat.loadFont(arg9, v1, arg11, arg10, arg12, arg13, arg14, arg15, arg16);
        if(v9 == null && arg13 == null) {
            if(arg16) {
            }
            else {
                throw new Resources$NotFoundException("Font resource ID #0x" + Integer.toHexString(arg10) + " could not be retrieved.");
            }
        }

        return v9;
    }

    private static Typeface loadFont(Context arg13, Resources arg14, TypedValue arg15, int arg16, int arg17, FontCallback arg18, Handler arg19, boolean arg20, boolean arg21) {
        Resources v2_1;
        int v3_1;
        String v4;
        boolean v9;
        int v6;
        Context v0_3;
        int v5;
        FamilyResourceEntry v1;
        int v2 = arg16;
        FontCallback v7 = arg18;
        Handler v8 = arg19;
        String v10 = "ResourcesCompat";
        if(arg15.string != null) {
            String v3 = arg15.string.toString();
            int v11 = -3;
            Typeface v12 = null;
            if(!v3.startsWith("res/")) {
                if(v7 != null) {
                    v7.callbackFailAsync(v11, v8);
                }

                return v12;
            }

            Typeface v0 = TypefaceCompat.findFromCache(arg14, v2, v3, arg15.assetCookie, arg17);
            if(v0 != null) {
                if(v7 != null) {
                    v7.callbackSuccessAsync(v0, v8);
                }

                return v0;
            }

            if(arg21) {
                return v12;
            }

            try {
                if(!v3.toLowerCase().endsWith(".xml")) {
                    goto label_52;
                }

                v1 = FontResourcesParserCompat.parse(arg14.getXml(v2), arg14);
                if(v1 == null) {
                    Log.e(v10, "Failed to find font-family tag");
                    if(v7 != null) {
                        v7.callbackFailAsync(v11, v8);
                    }

                    return v12;
                }

                v5 = arg15.assetCookie;
                v0_3 = arg13;
                v6 = arg17;
                v9 = arg20;
                v4 = v3;
                v3_1 = v2;
                v2_1 = arg14;
            }
            catch(IOException v0_1) {
                goto label_65;
            }
            catch(XmlPullParserException v0_2) {
                goto label_74;
            }

            try {
                return TypefaceCompat.createFromResourcesFamilyXml(v0_3, v1, v2_1, v3_1, v4, v5, v6, v7, v8, v9);
            }
            catch(IOException v0_1) {
                v3 = v4;
                goto label_65;
            }
            catch(XmlPullParserException v0_2) {
                v3 = v4;
                goto label_74;
            }

            try {
            label_52:
                Typeface v13 = TypefaceCompat.createFromResourcesFontFile(arg13, arg14, arg16, v3, arg15.assetCookie, arg17);
                if(v7 != null) {
                    if(v13 != null) {
                        v7.callbackSuccessAsync(v13, v8);
                        return v13;
                    }
                    else {
                        v7.callbackFailAsync(v11, v8);
                    }
                }

                return v13;
            }
            catch(IOException v0_1) {
            }
            catch(XmlPullParserException v0_2) {
            label_74:
                Log.e(v10, "Failed to parse xml resource " + (((String)v3_1)), v0_2);
                goto label_81;
            }

        label_65:
            Log.e(v10, "Failed to read xml resource " + (((String)v3_1)), v0_1);
        label_81:
            if(v7 != null) {
                v7.callbackFailAsync(v11, v8);
            }

            return v12;
        }

        throw new Resources$NotFoundException("Resource \"" + arg14.getResourceName(v2) + "\" (" + Integer.toHexString(v2) + ") is not a Font: " + arg15);
    }
}

