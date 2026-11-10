package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.util.Property;

class ObjectAnimatorUtils {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static ObjectAnimator ofObject(Object arg1, Property arg2, Path arg3) {
            return ObjectAnimator.ofObject(arg1, arg2, null, arg3);
        }
    }

    private ObjectAnimatorUtils() {
        super();
    }

    static ObjectAnimator ofPointF(Object arg0, Property arg1, Path arg2) {
        return Api21Impl.ofObject(arg0, arg1, arg2);
    }
}

