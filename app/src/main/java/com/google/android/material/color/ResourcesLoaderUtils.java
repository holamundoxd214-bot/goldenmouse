package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import java.util.Map;

final class ResourcesLoaderUtils {
    private ResourcesLoaderUtils() {
        super();
    }

    static boolean addResourcesLoaderToContext(Context arg3, Map arg4) {
        ResourcesLoader v4 = ColorResourcesLoaderCreator.create(arg3, arg4);
        if(v4 != null) {
            arg3.getResources().addLoaders(new ResourcesLoader[]{v4});
            return 1;
        }

        return 0;
    }

    static boolean isColorResource(int arg1) {
        if(28 <= arg1 && arg1 <= 0x1F) {
            return 1;
        }

        return 0;
    }
}

