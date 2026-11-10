package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
        super();
    }

    public static Interpolator create(float arg1, float arg2) {
        return new PathInterpolator(arg1, arg2);
    }

    public static Interpolator create(float arg1, float arg2, float arg3, float arg4) {
        return new PathInterpolator(arg1, arg2, arg3, arg4);
    }

    public static Interpolator create(Path arg1) {
        return new PathInterpolator(arg1);
    }
}

