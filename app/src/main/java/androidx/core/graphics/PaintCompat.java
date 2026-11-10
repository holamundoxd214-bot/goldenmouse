package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build$VERSION;

public final class PaintCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void setBlendMode(Paint arg0, Object arg1) {
            arg0.setBlendMode(((BlendMode)arg1));
        }
    }

    private PaintCompat() {
        super();
    }

    public static boolean hasGlyph(Paint arg0, String arg1) {
        return arg0.hasGlyph(arg1);
    }

    public static boolean setBlendMode(Paint arg4, BlendModeCompat arg5) {
        PorterDuffXfermode v3_1;
        Object v3 = null;
        if(Build$VERSION.SDK_INT >= 29) {
            if(arg5 != null) {
                v3 = androidx.core.graphics.BlendModeUtils$Api29Impl.obtainBlendModeFromCompat(arg5);
            }

            Api29Impl.setBlendMode(arg4, v3);
            return 1;
        }

        if(arg5 != null) {
            PorterDuff$Mode v5 = BlendModeUtils.obtainPorterDuffFromCompat(arg5);
            if(v5 != null) {
                v3_1 = new PorterDuffXfermode(v5);
            }

            arg4.setXfermode(((Xfermode)v3_1));
            if(v5 != null) {
                return 1;
            }

            return 0;
        }

        arg4.setXfermode(((Xfermode)v3));
        return 1;
    }
}

