package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$style;
import java.util.Map;

class ResourcesLoaderColorResourcesOverride implements ColorResourcesOverride {
    class com.google.android.material.color.ResourcesLoaderColorResourcesOverride$1 {
    }

    class ResourcesLoaderColorResourcesOverrideSingleton {
        private static final ResourcesLoaderColorResourcesOverride INSTANCE;

        static {
            ResourcesLoaderColorResourcesOverrideSingleton.INSTANCE = new ResourcesLoaderColorResourcesOverride(null);
        }

        private ResourcesLoaderColorResourcesOverrideSingleton() {
            super();
        }

        static ResourcesLoaderColorResourcesOverride access$000() {
            return ResourcesLoaderColorResourcesOverrideSingleton.INSTANCE;
        }
    }

    private ResourcesLoaderColorResourcesOverride() {
        super();
    }

    ResourcesLoaderColorResourcesOverride(com.google.android.material.color.ResourcesLoaderColorResourcesOverride$1 arg1) {
        this();
    }

    public boolean applyIfPossible(Context arg1, Map arg2) {
        if(ResourcesLoaderUtils.addResourcesLoaderToContext(arg1, arg2)) {
            ThemeUtils.applyThemeOverlay(arg1, style.ThemeOverlay_Material3_PersonalizedColors);
            return 1;
        }

        return 0;
    }

    static ColorResourcesOverride getInstance() {
        return ResourcesLoaderColorResourcesOverrideSingleton.access$000();
    }

    public Context wrapContextIfPossible(Context arg2, Map arg3) {
        ContextThemeWrapper v1 = new ContextThemeWrapper(arg2, style.ThemeOverlay_Material3_PersonalizedColors);
        v1.applyOverrideConfiguration(new Configuration());
        if(ResourcesLoaderUtils.addResourcesLoaderToContext(((Context)v1), arg3)) {
            return ((Context)v1);
        }

        return arg2;
    }
}

