package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build$VERSION;

public class BlendModeColorFilterCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static ColorFilter createBlendModeColorFilter(int arg1, Object arg2) {
            return new BlendModeColorFilter(arg1, ((BlendMode)arg2));
        }
    }

    private BlendModeColorFilterCompat() {
        super();
    }

    public static ColorFilter createBlendModeColorFilterCompat(int arg3, BlendModeCompat arg4) {
        ColorFilter v2 = null;
        if(Build$VERSION.SDK_INT >= 29) {
            Object v4 = androidx.core.graphics.BlendModeUtils$Api29Impl.obtainBlendModeFromCompat(arg4);
            if(v4 != null) {
                return Api29Impl.createBlendModeColorFilter(arg3, v4);
            }

            return v2;
        }

        PorterDuff$Mode v4_1 = BlendModeUtils.obtainPorterDuffFromCompat(arg4);
        if(v4_1 != null) {
            return new PorterDuffColorFilter(arg3, v4_1);
        }

        return v2;
    }
}

