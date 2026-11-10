package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion {
    public PathMotion() {
        super();
    }

    public PathMotion(Context arg1, AttributeSet arg2) {
        super();
    }

    public abstract Path getPath(float arg1, float arg2, float arg3, float arg4);
}

