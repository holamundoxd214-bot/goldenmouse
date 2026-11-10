package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Property;
import android.view.View;

class ViewUtils {
    class androidx.transition.ViewUtils$1 extends Property {
        androidx.transition.ViewUtils$1(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(View arg1) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(arg1));
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg1, Float arg2) {
            ViewUtils.setTransitionAlpha(arg1, arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((Float)arg2));
        }
    }

    class androidx.transition.ViewUtils$2 extends Property {
        androidx.transition.ViewUtils$2(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Rect get(View arg1) {
            return arg1.getClipBounds();
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg1, Rect arg2) {
            arg1.setClipBounds(arg2);
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((Rect)arg2));
        }
    }

    static final Property CLIP_BOUNDS = null;
    private static final ViewUtilsApi19 IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property TRANSITION_ALPHA;

    static {
        ViewUtils.IMPL = Build$VERSION.SDK_INT >= 29 ? new ViewUtilsApi29() : new ViewUtilsApi23();
        ViewUtils.TRANSITION_ALPHA = new androidx.transition.ViewUtils$1(Float.class, "translationAlpha");
        ViewUtils.CLIP_BOUNDS = new androidx.transition.ViewUtils$2(Rect.class, "clipBounds");
    }

    private ViewUtils() {
        super();
    }

    static void clearNonTransitionAlpha(View arg1) {
        ViewUtils.IMPL.clearNonTransitionAlpha(arg1);
    }

    static float getTransitionAlpha(View arg1) {
        return ViewUtils.IMPL.getTransitionAlpha(arg1);
    }

    static void saveNonTransitionAlpha(View arg1) {
        ViewUtils.IMPL.saveNonTransitionAlpha(arg1);
    }

    static void setAnimationMatrix(View arg1, Matrix arg2) {
        ViewUtils.IMPL.setAnimationMatrix(arg1, arg2);
    }

    static void setLeftTopRightBottom(View arg6, int arg7, int arg8, int arg9, int arg10) {
        ViewUtils.IMPL.setLeftTopRightBottom(arg6, arg7, arg8, arg9, arg10);
    }

    static void setTransitionAlpha(View arg1, float arg2) {
        ViewUtils.IMPL.setTransitionAlpha(arg1, arg2);
    }

    static void setTransitionVisibility(View arg1, int arg2) {
        ViewUtils.IMPL.setTransitionVisibility(arg1, arg2);
    }

    static void transformMatrixToGlobal(View arg1, Matrix arg2) {
        ViewUtils.IMPL.transformMatrixToGlobal(arg1, arg2);
    }

    static void transformMatrixToLocal(View arg1, Matrix arg2) {
        ViewUtils.IMPL.transformMatrixToLocal(arg1, arg2);
    }
}

