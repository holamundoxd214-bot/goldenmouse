package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
    private static final Object CACHE_LOCK;
    private final Resources mResources;
    private final Resources$Theme mTheme;
    private static ArrayList sCache;

    static {
        TintContextWrapper.CACHE_LOCK = new Object();
    }

    private TintContextWrapper(Context arg3) {
        super(arg3);
        if(VectorEnabledTintResources.shouldBeUsed()) {
            VectorEnabledTintResources v0 = new VectorEnabledTintResources(((Context)this), arg3.getResources());
            this.mResources = ((Resources)v0);
            Resources$Theme v0_1 = ((Resources)v0).newTheme();
            this.mTheme = v0_1;
            v0_1.setTo(arg3.getTheme());
            return;
        }

        this.mResources = new TintResources(((Context)this), arg3.getResources());
        this.mTheme = null;
    }

    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    public Resources getResources() {
        return this.mResources;
    }

    public Resources$Theme getTheme() {
        Resources$Theme v0 = this.mTheme;
        if(v0 == null) {
            return super.getTheme();
        }

        return v0;
    }

    public void setTheme(int arg2) {
        Resources$Theme v0 = this.mTheme;
        if(v0 == null) {
            super.setTheme(arg2);
            return;
        }

        v0.applyStyle(arg2, true);
    }

    private static boolean shouldWrap(Context arg2) {
        if(!(arg2 instanceof TintContextWrapper) && !(arg2.getResources() instanceof TintResources)) {
            if((arg2.getResources() instanceof VectorEnabledTintResources)) {
            }
            else if(VectorEnabledTintResources.shouldBeUsed()) {
                return 1;
            }
        }

        return 0;
    }

    public static Context wrap(Context arg4) {
        Object v2;
        if(TintContextWrapper.shouldWrap(arg4)) {
            Object v0 = TintContextWrapper.CACHE_LOCK;
            __monitor_enter(v0);
            try {
                ArrayList v1 = TintContextWrapper.sCache;
                if(v1 == null) {
                    TintContextWrapper.sCache = new ArrayList();
                }
                else {
                    int v1_1;
                    for(v1_1 = v1.size() - 1; v1_1 >= 0; --v1_1) {
                        v2 = TintContextWrapper.sCache.get(v1_1);
                        if(v2 == null || ((WeakReference)v2).get() == null) {
                            TintContextWrapper.sCache.remove(v1_1);
                        }
                    }

                    for(v1_1 = TintContextWrapper.sCache.size() - 1; v1_1 >= 0; --v1_1) {
                        v2 = TintContextWrapper.sCache.get(v1_1);
                        v2 = v2 != null ? ((WeakReference)v2).get() : null;
                        if(v2 != null && ((TintContextWrapper)v2).getBaseContext() == arg4) {
                            __monitor_exit(v0);
                            return ((Context)v2);
                        }
                    }
                }

                TintContextWrapper v1_2 = new TintContextWrapper(arg4);
                TintContextWrapper.sCache.add(new WeakReference(v1_2));
                __monitor_exit(v0);
                return ((Context)v1_2);
            label_48:
                __monitor_exit(v0);
            }
            catch(Throwable v4) {
                goto label_48;
            }

            throw v4;
        }

        return arg4;
    }
}

