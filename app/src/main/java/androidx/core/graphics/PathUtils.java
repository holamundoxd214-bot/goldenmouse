package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class PathUtils {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static float[] approximate(Path arg0, float arg1) {
            return arg0.approximate(arg1);
        }
    }

    private PathUtils() {
        super();
    }

    public static Collection flatten(Path arg10, float arg11) {
        float[] v10 = Api26Impl.approximate(arg10, arg11);
        int v11 = v10.length / 3;
        ArrayList v0 = new ArrayList(v11);
        int v1;
        for(v1 = 1; v1 < v11; ++v1) {
            int v2 = v1 * 3;
            int v3 = (v1 - 1) * 3;
            float v4 = v10[v2];
            float v5 = v10[v2 + 1];
            float v2_1 = v10[v2 + 2];
            float v6 = v10[v3];
            float v7 = v10[v3 + 1];
            float v3_1 = v10[v3 + 2];
            if(v4 != v6 && (v5 != v7 || v2_1 != v3_1)) {
                ((List)v0).add(new PathSegment(new PointF(v7, v3_1), v6, new PointF(v5, v2_1), v4));
            }
        }

        return ((Collection)v0);
    }

    public static Collection flatten(Path arg1) {
        return PathUtils.flatten(arg1, 0.5f);
    }
}

