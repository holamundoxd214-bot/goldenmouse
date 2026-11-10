package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GhostViewPlatform implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private final View mGhostView;
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;

    private GhostViewPlatform(View arg1) {
        super();
        this.mGhostView = arg1;
    }

    static GhostView addGhost(View arg3, ViewGroup arg4, Matrix arg5) {
        GhostViewPlatform.fetchAddGhostMethod();
        Method v0 = GhostViewPlatform.sAddGhostMethod;
        Object v1 = null;
        if(v0 == null) {
            goto label_14;
        }

        try {
            return new GhostViewPlatform(v0.invoke(v1, arg3, arg4, arg5));
        }
        catch(IllegalAccessException ) {
        label_14:
            return ((GhostView)v1);
        }
        catch(InvocationTargetException v3) {
            throw new RuntimeException(v3.getCause());
        }
    }

    private static void fetchAddGhostMethod() {
        if(!GhostViewPlatform.sAddGhostMethodFetched) {
            try {
                GhostViewPlatform.fetchGhostViewClass();
                Method v1_1 = GhostViewPlatform.sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                GhostViewPlatform.sAddGhostMethod = v1_1;
                v1_1.setAccessible(true);
            }
            catch(NoSuchMethodException v1) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", ((Throwable)v1));
            }

            GhostViewPlatform.sAddGhostMethodFetched = true;
        }
    }

    private static void fetchGhostViewClass() {
        if(!GhostViewPlatform.sGhostViewClassFetched) {
            try {
                GhostViewPlatform.sGhostViewClass = Class.forName("android.view.GhostView");
            }
            catch(ClassNotFoundException v0) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", ((Throwable)v0));
            }

            GhostViewPlatform.sGhostViewClassFetched = true;
        }
    }

    private static void fetchRemoveGhostMethod() {
        if(!GhostViewPlatform.sRemoveGhostMethodFetched) {
            try {
                GhostViewPlatform.fetchGhostViewClass();
                Method v1_1 = GhostViewPlatform.sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
                GhostViewPlatform.sRemoveGhostMethod = v1_1;
                v1_1.setAccessible(true);
            }
            catch(NoSuchMethodException v1) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", ((Throwable)v1));
            }

            GhostViewPlatform.sRemoveGhostMethodFetched = true;
        }
    }

    static void removeGhost(View arg2) {
        GhostViewPlatform.fetchRemoveGhostMethod();
        Method v0 = GhostViewPlatform.sRemoveGhostMethod;
        if(v0 == null) {
            return;
        }

        try {
            v0.invoke(null, arg2);
            return;
        }
        catch(IllegalAccessException ) {
            return;
        }
        catch(InvocationTargetException v2) {
            throw new RuntimeException(v2.getCause());
        }
    }

    public void reserveEndViewTransition(ViewGroup arg1, View arg2) {
    }

    public void setVisibility(int arg1) {
        this.mGhostView.setVisibility(arg1);
    }
}

