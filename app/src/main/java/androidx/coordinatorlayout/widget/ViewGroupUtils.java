package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewGroupUtils {
    private static final ThreadLocal sMatrix;
    private static final ThreadLocal sRectF;

    static {
        ViewGroupUtils.sMatrix = new ThreadLocal();
        ViewGroupUtils.sRectF = new ThreadLocal();
    }

    private ViewGroupUtils() {
        super();
    }

    public static void getDescendantRect(ViewGroup arg3, View arg4, Rect arg5) {
        arg5.set(0, 0, arg4.getWidth(), arg4.getHeight());
        ViewGroupUtils.offsetDescendantRect(arg3, arg4, arg5);
    }

    private static void offsetDescendantMatrix(ViewParent arg2, View arg3, Matrix arg4) {
        ViewParent v0 = arg3.getParent();
        if(((v0 instanceof View)) && v0 != arg2) {
            ViewGroupUtils.offsetDescendantMatrix(arg2, ((View)v0), arg4);
            arg4.preTranslate(((float)(-((View)v0).getScrollX())), ((float)(-((View)v0).getScrollY())));
        }

        arg4.preTranslate(((float)arg3.getLeft()), ((float)arg3.getTop()));
        if(!arg3.getMatrix().isIdentity()) {
            arg4.preConcat(arg3.getMatrix());
        }
    }

    static void offsetDescendantRect(ViewGroup arg3, View arg4, Rect arg5) {
        ThreadLocal v0 = ViewGroupUtils.sMatrix;
        Object v1 = v0.get();
        if(v1 == null) {
            Matrix v1_1 = new Matrix();
            v0.set(v1_1);
        }
        else {
            ((Matrix)v1).reset();
        }

        ViewGroupUtils.offsetDescendantMatrix(((ViewParent)arg3), arg4, ((Matrix)v1));
        ThreadLocal v3 = ViewGroupUtils.sRectF;
        Object v4 = v3.get();
        if(v4 == null) {
            RectF v4_1 = new RectF();
            v3.set(v4_1);
        }

        ((RectF)v4).set(arg5);
        ((Matrix)v1).mapRect(((RectF)v4));
        arg5.set(((int)(((RectF)v4).left + 0.5f)), ((int)(((RectF)v4).top + 0.5f)), ((int)(((RectF)v4).right + 0.5f)), ((int)(((RectF)v4).bottom + 0.5f)));
    }
}

