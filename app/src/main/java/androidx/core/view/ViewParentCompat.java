package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
        super();
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] v0 = ViewParentCompat.sTempNestedScrollConsumed;
        if(v0 == null) {
            v0 = new int[2];
            ViewParentCompat.sTempNestedScrollConsumed = v0;
            return v0;
        }

        v0[0] = 0;
        v0[1] = 0;
        return v0;
    }

    @ReplaceWith(expression="parent.notifySubtreeAccessibilityStateChanged(child, source, changeType)") @Deprecated public static void notifySubtreeAccessibilityStateChanged(ViewParent arg0, View arg1, View arg2, int arg3) {
        arg0.notifySubtreeAccessibilityStateChanged(arg1, arg2, arg3);
    }

    public static boolean onNestedFling(ViewParent arg0, View arg1, float arg2, float arg3, boolean arg4) {
        boolean v0;
        try {
            v0 = arg0.onNestedFling(arg1, arg2, arg3, arg4);
            return v0;
        }
        catch(AbstractMethodError v1) {
            Log.e("ViewParentCompat", "ViewParent " + v0 + " does not implement interface method onNestedFling", ((Throwable)v1));
            return 0;
        }
    }

    public static boolean onNestedPreFling(ViewParent arg0, View arg1, float arg2, float arg3) {
        boolean v0;
        try {
            v0 = arg0.onNestedPreFling(arg1, arg2, arg3);
            return v0;
        }
        catch(AbstractMethodError v1) {
            Log.e("ViewParentCompat", "ViewParent " + v0 + " does not implement interface method onNestedPreFling", ((Throwable)v1));
            return 0;
        }
    }

    public static void onNestedPreScroll(ViewParent arg1, View arg2, int arg3, int arg4, int[] arg5, int arg6) {
        if((arg1 instanceof NestedScrollingParent2)) {
            ((NestedScrollingParent2)arg1).onNestedPreScroll(arg2, arg3, arg4, arg5, arg6);
            return;
        }

        if(arg6 == 0) {
            try {
                arg1.onNestedPreScroll(arg2, arg3, arg4, arg5);
                return;
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + arg1 + " does not implement interface method onNestedPreScroll", v0);
            }
        }
    }

    public static void onNestedPreScroll(ViewParent arg6, View arg7, int arg8, int arg9, int[] arg10) {
        ViewParentCompat.onNestedPreScroll(arg6, arg7, arg8, arg9, arg10, 0);
    }

    public static void onNestedScroll(ViewParent arg3, View arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int[] arg10) {
        if((arg3 instanceof NestedScrollingParent3)) {
            ((NestedScrollingParent3)arg3).onNestedScroll(arg4, arg5, arg6, arg7, arg8, arg9, arg10);
            return;
        }

        int v2 = arg5;
        View v5 = arg4;
        int[] v4 = arg10;
        int v10 = arg9;
        arg9 = arg8;
        arg8 = arg7;
        arg7 = arg6;
        arg6 = v2;
        v4[0] += arg8;
        v4[1] += arg9;
        if((arg3 instanceof NestedScrollingParent2)) {
            arg3.onNestedScroll(v5, arg6, arg7, arg8, arg9, v10);
            return;
        }

        if(v10 == 0) {
            ViewParent v4_1 = arg3;
            try {
                v4_1.onNestedScroll(v5, arg6, arg7, arg8, arg9);
                return;
            }
            catch(AbstractMethodError v0) {
                Log.e("ViewParentCompat", "ViewParent " + v4_1 + " does not implement interface method onNestedScroll", v0);
            }
        }
    }

    public static void onNestedScroll(ViewParent arg8, View arg9, int arg10, int arg11, int arg12, int arg13) {
        ViewParentCompat.onNestedScroll(arg8, arg9, arg10, arg11, arg12, arg13, 0, ViewParentCompat.getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent arg8, View arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
        ViewParentCompat.onNestedScroll(arg8, arg9, arg10, arg11, arg12, arg13, arg14, ViewParentCompat.getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(ViewParent arg1, View arg2, View arg3, int arg4, int arg5) {
        if((arg1 instanceof NestedScrollingParent2)) {
            ((NestedScrollingParent2)arg1).onNestedScrollAccepted(arg2, arg3, arg4, arg5);
            return;
        }

        if(arg5 == 0) {
            try {
                arg1.onNestedScrollAccepted(arg2, arg3, arg4);
                return;
            }
            catch(AbstractMethodError v2) {
                Log.e("ViewParentCompat", "ViewParent " + arg1 + " does not implement interface method onNestedScrollAccepted", ((Throwable)v2));
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent arg1, View arg2, View arg3, int arg4) {
        ViewParentCompat.onNestedScrollAccepted(arg1, arg2, arg3, arg4, 0);
    }

    public static boolean onStartNestedScroll(ViewParent arg1, View arg2, View arg3, int arg4, int arg5) {
        boolean v1;
        if((arg1 instanceof NestedScrollingParent2)) {
            return ((NestedScrollingParent2)arg1).onStartNestedScroll(arg2, arg3, arg4, arg5);
        }

        if(arg5 == 0) {
            try {
                v1 = arg1.onStartNestedScroll(arg2, arg3, arg4);
                return v1;
            }
            catch(AbstractMethodError v2) {
                Log.e("ViewParentCompat", "ViewParent " + v1 + " does not implement interface method onStartNestedScroll", ((Throwable)v2));
            }
        }

        return 0;
    }

    public static boolean onStartNestedScroll(ViewParent arg1, View arg2, View arg3, int arg4) {
        return ViewParentCompat.onStartNestedScroll(arg1, arg2, arg3, arg4, 0);
    }

    public static void onStopNestedScroll(ViewParent arg1, View arg2, int arg3) {
        if((arg1 instanceof NestedScrollingParent2)) {
            ((NestedScrollingParent2)arg1).onStopNestedScroll(arg2, arg3);
            return;
        }

        if(arg3 == 0) {
            try {
                arg1.onStopNestedScroll(arg2);
                return;
            }
            catch(AbstractMethodError v2) {
                Log.e("ViewParentCompat", "ViewParent " + arg1 + " does not implement interface method onStopNestedScroll", ((Throwable)v2));
            }
        }
    }

    public static void onStopNestedScroll(ViewParent arg1, View arg2) {
        ViewParentCompat.onStopNestedScroll(arg1, arg2, 0);
    }

    @ReplaceWith(expression="parent.requestSendAccessibilityEvent(child, event)") @Deprecated public static boolean requestSendAccessibilityEvent(ViewParent arg0, View arg1, AccessibilityEvent arg2) {
        return arg0.requestSendAccessibilityEvent(arg1, arg2);
    }
}

