package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.widget.ImageView;
import java.lang.reflect.Field;

class ImageViewUtils {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void animateTransform(ImageView arg0, Matrix arg1) {
            arg0.animateTransform(arg1);
        }
    }

    private static Field sDrawMatrixField = null;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    static {
    }

    private ImageViewUtils() {
        super();
    }

    static void animateTransform(ImageView arg3, Matrix arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.animateTransform(arg3, arg4);
            return;
        }

        if(arg4 == null) {
            Drawable v4 = arg3.getDrawable();
            if(v4 != null) {
                v4.setBounds(0, 0, arg3.getWidth() - arg3.getPaddingLeft() - arg3.getPaddingRight(), arg3.getHeight() - arg3.getPaddingTop() - arg3.getPaddingBottom());
                arg3.invalidate();
            }

            return;
        }

        ImageViewUtils.hiddenAnimateTransform(arg3, arg4);
    }

    private static void fetchDrawMatrixField() {
        if(!ImageViewUtils.sDrawMatrixFieldFetched) {
            try {
                Field v1 = ImageView.class.getDeclaredField("mDrawMatrix");
                ImageViewUtils.sDrawMatrixField = v1;
                v1.setAccessible(true);
                goto label_8;
            }
            catch(NoSuchFieldException ) {
            label_8:
                ImageViewUtils.sDrawMatrixFieldFetched = true;
            }
        }
    }

    private static void hiddenAnimateTransform(ImageView arg1, Matrix arg2) {
        if(ImageViewUtils.sTryHiddenAnimateTransform) {
            try {
                Api29Impl.animateTransform(arg1, arg2);
                return;
            }
            catch(NoSuchMethodError ) {
                ImageViewUtils.sTryHiddenAnimateTransform = false;
            }
        }
    }
}

