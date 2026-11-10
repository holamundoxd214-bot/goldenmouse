package com.google.android.material.color;

import android.content.Context;
import android.os.Build$VERSION;
import java.util.Map;

public interface ColorResourcesOverride {
    boolean applyIfPossible(Context arg1, Map arg2);

    static ColorResourcesOverride getInstance() {
        if(30 <= Build$VERSION.SDK_INT && Build$VERSION.SDK_INT <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }

        if(Build$VERSION.SDK_INT >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }

        return null;
    }

    Context wrapContextIfPossible(Context arg1, Map arg2);
}

