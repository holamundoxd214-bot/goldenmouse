package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.util.Property;

class PropertyValuesHolderUtils {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static PropertyValuesHolder ofObject(Property arg1, Path arg2) {
            return PropertyValuesHolder.ofObject(arg1, null, arg2);
        }
    }

    private PropertyValuesHolderUtils() {
        super();
    }

    static PropertyValuesHolder ofPointF(Property arg0, Path arg1) {
        return Api21Impl.ofObject(arg0, arg1);
    }
}

