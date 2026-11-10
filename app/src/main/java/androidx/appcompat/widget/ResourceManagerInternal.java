package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourceManagerInternal {
    class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
            super();
        }

        public Drawable createFromXmlInner(Context arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(arg1, arg1.getResources(), arg2, arg3, arg4);
            }
            catch(Exception v0) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", ((Throwable)v0));
                return null;
            }
        }
    }

    class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
            super();
        }

        public Drawable createFromXmlInner(Context arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(arg1, arg1.getResources(), arg2, arg3, arg4);
            }
            catch(Exception v0) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", ((Throwable)v0));
                return null;
            }
        }
    }

    class ColorFilterLruCache extends LruCache {
        public ColorFilterLruCache(int arg1) {
            super(arg1);
        }

        private static int generateCacheKey(int arg1, PorterDuff$Mode arg2) {
            return (arg1 + 0x1F) * 0x1F + arg2.hashCode();
        }

        PorterDuffColorFilter get(int arg1, PorterDuff$Mode arg2) {
            return this.get(Integer.valueOf(ColorFilterLruCache.generateCacheKey(arg1, arg2)));
        }

        PorterDuffColorFilter put(int arg1, PorterDuff$Mode arg2, PorterDuffColorFilter arg3) {
            return this.put(Integer.valueOf(ColorFilterLruCache.generateCacheKey(arg1, arg2)), arg3);
        }
    }

    class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
            super();
        }

        public Drawable createFromXmlInner(Context arg4, XmlPullParser arg5, AttributeSet arg6, Resources$Theme arg7) {
            String v3 = arg6.getClassAttribute();
            Drawable v0 = null;
            if(v3 != null) {
                try {
                    Object v3_2 = DrawableDelegate.class.getClassLoader().loadClass(v3).asSubclass(Drawable.class).getDeclaredConstructor().newInstance();
                    Api21Impl.inflate(((Drawable)v3_2), arg4.getResources(), arg5, arg6, arg7);
                    return ((Drawable)v3_2);
                }
                catch(Exception v3_1) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", ((Throwable)v3_1));
                }
            }

            return v0;
        }
    }

    interface InflateDelegate {
        Drawable createFromXmlInner(Context arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4);
    }

    public interface ResourceManagerHooks {
        Drawable createDrawableFor(ResourceManagerInternal arg1, Context arg2, int arg3);

        ColorStateList getTintListForDrawableRes(Context arg1, int arg2);

        PorterDuff$Mode getTintModeForDrawableRes(int arg1);

        boolean tintDrawable(Context arg1, int arg2, Drawable arg3);

        boolean tintDrawableUsingColorFilter(Context arg1, int arg2, Drawable arg3);
    }

    class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
            super();
        }

        public Drawable createFromXmlInner(Context arg1, XmlPullParser arg2, AttributeSet arg3, Resources$Theme arg4) {
            try {
                return VectorDrawableCompat.createFromXmlInner(arg1.getResources(), arg2, arg3, arg4);
            }
            catch(Exception v0) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", ((Throwable)v0));
                return null;
            }
        }
    }

    private static final ColorFilterLruCache COLOR_FILTER_CACHE = null;
    private static final boolean DEBUG = false;
    private static final PorterDuff$Mode DEFAULT_MODE = null;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap mDelegates;
    private final WeakHashMap mDrawableCaches;
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat mKnownDrawableIdTags;
    private WeakHashMap mTintLists;
    private TypedValue mTypedValue;

    static {
        ResourceManagerInternal.DEFAULT_MODE = PorterDuff$Mode.SRC_IN;
        ResourceManagerInternal.COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    public ResourceManagerInternal() {
        super();
        this.mDrawableCaches = new WeakHashMap(0);
    }

    private void addDelegate(String arg2, InflateDelegate arg3) {
        SimpleArrayMap v0 = this.mDelegates;
        if(v0 == null) {
            v0 = new SimpleArrayMap();
            this.mDelegates = v0;
        }

        v0.put(arg2, arg3);
    }

    private boolean addDrawableToCache(Context arg3, long arg4, Drawable arg6) {
        __monitor_enter(this);
        try {
            Drawable$ConstantState v6 = arg6.getConstantState();
            if(v6 == null) {
                goto label_16;
            }

            Object v0 = this.mDrawableCaches.get(arg3);
            if(v0 == null) {
                LongSparseArray v0_1 = new LongSparseArray();
                this.mDrawableCaches.put(arg3, v0_1);
            }

            ((LongSparseArray)v0).put(arg4, new WeakReference(v6));
        }
        catch(Throwable v3) {
            try {
            label_20:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_20;
            }

            throw v3;
        }

        __monitor_exit(this);
        return 1;
    label_16:
        __monitor_exit(this);
        return 0;
    }

    private void addTintListToCache(Context arg2, int arg3, ColorStateList arg4) {
        WeakHashMap v0 = this.mTintLists;
        if(v0 == null) {
            v0 = new WeakHashMap();
            this.mTintLists = v0;
        }

        Object v0_1 = v0.get(arg2);
        if(v0_1 == null) {
            SparseArrayCompat v0_2 = new SparseArrayCompat();
            this.mTintLists.put(arg2, v0_2);
        }

        ((SparseArrayCompat)v0_1).append(arg3, arg4);
    }

    private void checkVectorDrawableSetup(Context arg2) {
        if(this.mHasCheckedVectorDrawableSetup) {
        }
        else {
            this.mHasCheckedVectorDrawableSetup = true;
            Drawable v2 = this.getDrawable(arg2, drawable.abc_vector_test);
            if(v2 != null && (ResourceManagerInternal.isVectorDrawable(v2))) {
                return;
            }

            goto label_11;
        }

        return;
    label_11:
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private static long createCacheKey(TypedValue arg4) {
        return (((long)arg4.assetCookie)) << 0x20 | (((long)arg4.data));
    }

    private Drawable createDrawableIfNeeded(Context arg5, int arg6) {
        TypedValue v0 = this.mTypedValue;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mTypedValue = v0;
        }

        arg5.getResources().getValue(arg6, v0, true);
        long v1 = ResourceManagerInternal.createCacheKey(v0);
        Drawable v3 = this.getCachedDrawable(arg5, v1);
        if(v3 != null) {
            return v3;
        }

        ResourceManagerHooks v3_1 = this.mHooks;
        Drawable v6 = v3_1 == null ? null : v3_1.createDrawableFor(this, arg5, arg6);
        if(v6 != null) {
            v6.setChangingConfigurations(v0.changingConfigurations);
            this.addDrawableToCache(arg5, v1, v6);
        }

        return v6;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList arg1, PorterDuff$Mode arg2, int[] arg3) {
        if(arg1 != null) {
            if(arg2 == null) {
            }
            else {
                return ResourceManagerInternal.getPorterDuffColorFilter(arg1.getColorForState(arg3, 0), arg2);
            }
        }

        return null;
    }

    public static ResourceManagerInternal get() {
        ResourceManagerInternal v1_1;
        Class v0 = ResourceManagerInternal.class;
        __monitor_enter(v0);
        try {
            if(ResourceManagerInternal.INSTANCE == null) {
                v1_1 = new ResourceManagerInternal();
                ResourceManagerInternal.INSTANCE = v1_1;
                ResourceManagerInternal.installDefaultInflateDelegates(v1_1);
            }

            v1_1 = ResourceManagerInternal.INSTANCE;
        }
        catch(Throwable v1) {
            try {
            label_12:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_12;
            }

            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    private Drawable getCachedDrawable(Context arg4, long arg5) {
        Drawable v4_1;
        Drawable v1;
        Object v0;
        __monitor_enter(this);
        try {
            v0 = this.mDrawableCaches.get(arg4);
            v1 = null;
            if(v0 != null) {
                goto label_7;
            }
        }
        catch(Throwable v4) {
            goto label_19;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_7:
            Object v2 = ((LongSparseArray)v0).get(arg5);
            if(v2 != null) {
                v2 = ((WeakReference)v2).get();
                if(v2 != null) {
                    v4_1 = ((Drawable$ConstantState)v2).newDrawable(arg4.getResources());
                    goto label_13;
                }
                else {
                    goto label_15;
                }
            }

            goto label_16;
        }
        catch(Throwable v4) {
            goto label_19;
        }

    label_13:
        __monitor_exit(this);
        return v4_1;
        try {
        label_15:
            ((LongSparseArray)v0).remove(arg5);
        }
        catch(Throwable v4) {
            try {
            label_19:
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                goto label_19;
            }

            throw v4;
        }

    label_16:
        __monitor_exit(this);
        return v1;
    }

    public Drawable getDrawable(Context arg2, int arg3) {
        Drawable v2_1;
        __monitor_enter(this);
        try {
            v2_1 = this.getDrawable(arg2, arg3, false);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    Drawable getDrawable(Context arg2, int arg3, boolean arg4) {
        Drawable v0;
        __monitor_enter(this);
        try {
            this.checkVectorDrawableSetup(arg2);
            v0 = this.loadDrawableFromDelegates(arg2, arg3);
            if(v0 == null) {
                v0 = this.createDrawableIfNeeded(arg2, arg3);
            }

            if(v0 == null) {
                v0 = ContextCompat.getDrawable(arg2, arg3);
            }

            if(v0 != null) {
                v0 = this.tintDrawable(arg2, arg3, arg4, v0);
            }

            if(v0 != null) {
                DrawableUtils.fixDrawable(v0);
            }
        }
        catch(Throwable v2) {
            try {
            label_14:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_14;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v0;
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int arg3, PorterDuff$Mode arg4) {
        PorterDuffColorFilter v2;
        Class v0 = ResourceManagerInternal.class;
        __monitor_enter(v0);
        try {
            ColorFilterLruCache v1 = ResourceManagerInternal.COLOR_FILTER_CACHE;
            v2 = v1.get(arg3, arg4);
            if(v2 == null) {
                v2 = new PorterDuffColorFilter(arg3, arg4);
                v1.put(arg3, arg4, v2);
            }
        }
        catch(Throwable v3) {
            try {
            label_11:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_11;
            }

            throw v3;
        }

        __monitor_exit(v0);
        return v2;
    }

    ColorStateList getTintList(Context arg2, int arg3) {
        ColorStateList v0;
        __monitor_enter(this);
        try {
            v0 = this.getTintListFromCache(arg2, arg3);
            if(v0 == null) {
                ResourceManagerHooks v0_1 = this.mHooks;
                v0 = v0_1 == null ? null : v0_1.getTintListForDrawableRes(arg2, arg3);
                if(v0 == null) {
                    goto label_10;
                }

                this.addTintListToCache(arg2, arg3, v0);
            }
        }
        catch(Throwable v2) {
            try {
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_13;
            }

            throw v2;
        }

    label_10:
        __monitor_exit(this);
        return v0;
    }

    private ColorStateList getTintListFromCache(Context arg2, int arg3) {
        WeakHashMap v1 = this.mTintLists;
        ColorStateList v0 = null;
        if(v1 != null) {
            Object v1_1 = v1.get(arg2);
            if(v1_1 != null) {
                return ((SparseArrayCompat)v1_1).get(arg3);
            }
        }

        return v0;
    }

    PorterDuff$Mode getTintMode(int arg1) {
        ResourceManagerHooks v0 = this.mHooks;
        if(v0 == null) {
            return null;
        }

        return v0.getTintModeForDrawableRes(arg1);
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal arg0) {
    }

    private static boolean isVectorDrawable(Drawable arg1) {
        if(!(arg1 instanceof VectorDrawableCompat)) {
            if("android.graphics.drawable.VectorDrawable".equals(arg1.getClass().getName())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private Drawable loadDrawableFromDelegates(Context arg11, int arg12) {
        SimpleArrayMap v0 = this.mDelegates;
        Drawable v1 = null;
        if(v0 != null && !v0.isEmpty()) {
            SparseArrayCompat v0_1 = this.mKnownDrawableIdTags;
            String v2 = "appcompat_skip_skip";
            if(v0_1 != null) {
                Object v0_2 = v0_1.get(arg12);
                if(!v2.equals(v0_2)) {
                    if(v0_2 == null) {
                    }
                    else if(this.mDelegates.get(v0_2) == null) {
                        return v1;
                    }

                    goto label_19;
                }

                return v1;
            }
            else {
                this.mKnownDrawableIdTags = new SparseArrayCompat();
            }

        label_19:
            TypedValue v0_3 = this.mTypedValue;
            if(v0_3 == null) {
                v0_3 = new TypedValue();
                this.mTypedValue = v0_3;
            }

            Resources v1_1 = arg11.getResources();
            v1_1.getValue(arg12, v0_3, true);
            long v4 = ResourceManagerInternal.createCacheKey(v0_3);
            Drawable v6 = this.getCachedDrawable(arg11, v4);
            if(v6 != null) {
                return v6;
            }

            if(v0_3.string != null && (v0_3.string.toString().endsWith(".xml"))) {
                try {
                    XmlResourceParser v1_2 = v1_1.getXml(arg12);
                    AttributeSet v7 = Xml.asAttributeSet(((XmlPullParser)v1_2));
                    while(true) {
                        int v8 = ((XmlPullParser)v1_2).next();
                        int v9 = 2;
                        if(v8 != v9 && v8 != 1) {
                            continue;
                        }

                        break;
                    }

                    if(v8 == v9) {
                        String v3 = ((XmlPullParser)v1_2).getName();
                        this.mKnownDrawableIdTags.append(arg12, v3);
                        Object v3_1 = this.mDelegates.get(v3);
                        if(v3_1 != null) {
                            v6 = ((InflateDelegate)v3_1).createFromXmlInner(arg11, ((XmlPullParser)v1_2), v7, arg11.getTheme());
                        }

                        if(v6 == null) {
                            goto label_68;
                        }

                        v6.setChangingConfigurations(v0_3.changingConfigurations);
                        this.addDrawableToCache(arg11, v4, v6);
                        goto label_68;
                    }

                    throw new XmlPullParserException("No start tag found");
                }
                catch(Exception v11) {
                    Log.e("ResourceManagerInternal", "Exception while inflating drawable", ((Throwable)v11));
                }
            }

        label_68:
            if(v6 == null) {
                this.mKnownDrawableIdTags.append(arg12, v2);
            }

            return v6;
        }

        return v1;
    }

    public void onConfigurationChanged(Context arg2) {
        __monitor_enter(this);
        try {
            Object v2_1 = this.mDrawableCaches.get(arg2);
            if(v2_1 != null) {
                ((LongSparseArray)v2_1).clear();
            }
        }
        catch(Throwable v2) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_8;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    Drawable onDrawableLoadedFromResources(Context arg2, VectorEnabledTintResources arg3, int arg4) {
        Drawable v2_1;
        __monitor_enter(this);
        try {
            Drawable v0 = this.loadDrawableFromDelegates(arg2, arg4);
            if(v0 == null) {
                v0 = arg3.getDrawableCanonical(arg4);
            }

            if(v0 == null) {
                goto label_9;
            }

            v2_1 = this.tintDrawable(arg2, arg4, false, v0);
        }
        catch(Throwable v2) {
            try {
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_13;
            }

            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    label_9:
        __monitor_exit(this);
        return null;
    }

    public void setHooks(ResourceManagerHooks arg1) {
        __monitor_enter(this);
        try {
            this.mHooks = arg1;
        }
        catch(Throwable v1) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_5;
            }

            throw v1;
        }

        __monitor_exit(this);
    }

    static void tintDrawable(Drawable arg2, TintInfo arg3, int[] arg4) {
        int[] v0 = arg2.getState();
        if(DrawableUtils.canSafelyMutateDrawable(arg2)) {
            if(arg2.mutate() == arg2) {
            }
            else {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }

        if(((arg2 instanceof LayerDrawable)) && (arg2.isStateful())) {
            arg2.setState(new int[0]);
            arg2.setState(v0);
        }

        if((arg3.mHasTintList) || (arg3.mHasTintMode)) {
            ColorStateList v0_1 = arg3.mHasTintList ? arg3.mTintList : null;
            PorterDuff$Mode v3 = arg3.mHasTintMode ? arg3.mTintMode : ResourceManagerInternal.DEFAULT_MODE;
            arg2.setColorFilter(ResourceManagerInternal.createTintFilter(v0_1, v3, arg4));
        }
        else {
            arg2.clearColorFilter();
        }
    }

    private Drawable tintDrawable(Context arg2, int arg3, boolean arg4, Drawable arg5) {
        ColorStateList v0 = this.getTintList(arg2, arg3);
        if(v0 != null) {
            if(DrawableUtils.canSafelyMutateDrawable(arg5)) {
                arg5 = arg5.mutate();
            }

            Drawable v2 = DrawableCompat.wrap(arg5);
            DrawableCompat.setTintList(v2, v0);
            PorterDuff$Mode v1 = this.getTintMode(arg3);
            if(v1 != null) {
                DrawableCompat.setTintMode(v2, v1);
            }

            return v2;
        }

        ResourceManagerHooks v0_1 = this.mHooks;
        if(v0_1 != null && (v0_1.tintDrawable(arg2, arg3, arg5))) {
        }
        else if(!this.tintDrawableUsingColorFilter(arg2, arg3, arg5) && (arg4)) {
            return null;
        }

        return arg5;
    }

    boolean tintDrawableUsingColorFilter(Context arg1, int arg2, Drawable arg3) {
        ResourceManagerHooks v0 = this.mHooks;
        if(v0 != null && (v0.tintDrawableUsingColorFilter(arg1, arg2, arg3))) {
            return 1;
        }

        return 0;
    }
}

