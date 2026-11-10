package androidx.transition;

import android.graphics.Canvas;
import android.os.Build$VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void disableZ(Canvas arg0) {
            arg0.disableZ();
        }

        static void enableZ(Canvas arg0) {
            arg0.enableZ();
        }
    }

    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    private CanvasUtils() {
        super();
    }

    static void enableZ(Canvas arg5, boolean arg6) {
        if(Build$VERSION.SDK_INT >= 29) {
            if(arg6) {
                Api29Impl.enableZ(arg5);
                return;
            }

            Api29Impl.disableZ(arg5);
            return;
        }

        if(Build$VERSION.SDK_INT != 28) {
            if(!CanvasUtils.sOrderMethodsFetched) {
                try {
                    Class v2 = Canvas.class;
                    Method v3 = v2.getDeclaredMethod("insertReorderBarrier");
                    CanvasUtils.sReorderBarrierMethod = v3;
                    v3.setAccessible(true);
                    Method v2_1 = v2.getDeclaredMethod("insertInorderBarrier");
                    CanvasUtils.sInorderBarrierMethod = v2_1;
                    v2_1.setAccessible(true);
                    goto label_26;
                }
                catch(NoSuchMethodException ) {
                label_26:
                    CanvasUtils.sOrderMethodsFetched = true;
                }
            }

            if(arg6) {
                try {
                    Method v0 = CanvasUtils.sReorderBarrierMethod;
                    if(v0 != null) {
                        v0.invoke(arg5);
                    }

                label_32:
                    if(!arg6) {
                        Method v6 = CanvasUtils.sInorderBarrierMethod;
                        if(v6 != null) {
                            v6.invoke(arg5);
                        }
                    }

                    return;
                }
                catch(IllegalAccessException ) {
                    return;
                }
                catch(InvocationTargetException v5) {
                    throw new RuntimeException(v5.getCause());
                }
            }

            goto label_32;
        }

        throw new IllegalStateException("This method doesn\'t work on Pie!");
    }
}

