package androidx.core.content.res;

import android.content.res.Resources;

public final class ConfigurationHelper {
    private ConfigurationHelper() {
        super();
    }

    public static int getDensityDpi(Resources arg0) {
        return arg0.getConfiguration().densityDpi;
    }
}

