package androidx.transition;

import android.graphics.Matrix;
import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils {
    private GhostViewUtils() {
        super();
    }

    static GhostView addGhost(View arg2, ViewGroup arg3, Matrix arg4) {
        if(Build$VERSION.SDK_INT == 28) {
            return GhostViewPlatform.addGhost(arg2, arg3, arg4);
        }

        return GhostViewPort.addGhost(arg2, arg3, arg4);
    }

    static void removeGhost(View arg2) {
        if(Build$VERSION.SDK_INT == 28) {
            GhostViewPlatform.removeGhost(arg2);
            return;
        }

        GhostViewPort.removeGhost(arg2);
    }
}

