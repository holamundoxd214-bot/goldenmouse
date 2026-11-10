package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WindowUtils {
    class Api14Impl {
        private Api14Impl() {
            super();
        }

        static Rect getCurrentWindowBounds(WindowManager arg3) {
            Display v3 = arg3.getDefaultDisplay();
            Point v0 = Api14Impl.getRealSizeForDisplay(v3);
            Rect v1 = new Rect();
            if(v0.x != 0) {
                if(v0.y == 0) {
                }
                else {
                    v1.right = v0.x;
                    v1.bottom = v0.y;
                    return v1;
                }
            }

            v3.getRectSize(v1);
            return v1;
        }

        private static Point getRealSizeForDisplay(Display arg7) {
            Point v0 = new Point();
            try {
                Method v1 = Display.class.getDeclaredMethod("getRealSize", Point.class);
                v1.setAccessible(true);
                v1.invoke(arg7, v0);
                return v0;
            }
            catch(InvocationTargetException v7) {
                Log.w(WindowUtils.TAG, ((Throwable)v7));
            }
            catch(IllegalAccessException v7_1) {
                Log.w(WindowUtils.TAG, ((Throwable)v7_1));
            }
            catch(NoSuchMethodException v7_2) {
                Log.w(WindowUtils.TAG, ((Throwable)v7_2));
            }

            return v0;
        }
    }

    class Api17Impl {
        private Api17Impl() {
            super();
        }

        static Rect getCurrentWindowBounds(WindowManager arg2) {
            Display v2 = arg2.getDefaultDisplay();
            Point v0 = new Point();
            v2.getRealSize(v0);
            Rect v2_1 = new Rect();
            v2_1.right = v0.x;
            v2_1.bottom = v0.y;
            return v2_1;
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static Rect getCurrentWindowBounds(WindowManager arg0) {
            return arg0.getCurrentWindowMetrics().getBounds();
        }
    }

    private static final String TAG = "WindowUtils";

    static {
    }

    private WindowUtils() {
        super();
    }

    static String access$000() {
        return WindowUtils.TAG;
    }

    public static Rect getCurrentWindowBounds(Context arg2) {
        Object v2 = arg2.getSystemService("window");
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getCurrentWindowBounds(((WindowManager)v2));
        }

        return Api17Impl.getCurrentWindowBounds(((WindowManager)v2));
    }
}

