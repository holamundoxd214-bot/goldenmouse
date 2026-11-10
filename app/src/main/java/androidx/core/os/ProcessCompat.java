package androidx.core.os;

import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

public final class ProcessCompat {
    class Api19Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock;

        static {
            Api19Impl.sResolvedLock = new Object();
        }

        private Api19Impl() {
            super();
        }

        static boolean isApplicationUid(int arg7) {
            Object v1;
            try {
                v1 = Api19Impl.sResolvedLock;
                __monitor_enter(v1);
            }
            catch(Exception v7) {
                goto label_31;
            }

            try {
                if(!Api19Impl.sResolved) {
                    Api19Impl.sResolved = true;
                    Api19Impl.sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                }

                __monitor_exit(v1);
                goto label_15;
            }
            catch(Throwable v7_1) {
                try {
                label_28:
                    __monitor_exit(v1);
                }
                catch(Throwable v7_1) {
                    goto label_28;
                }

                try {
                    throw v7_1;
                label_15:
                    Method v1_1 = Api19Impl.sMethodUserHandleIsAppMethod;
                    if(v1_1 == null) {
                        return 1;
                    }

                    Object v7_2 = v1_1.invoke(null, Integer.valueOf(arg7));
                    if(v7_2 != null) {
                        return ((Boolean)v7_2).booleanValue();
                    }

                    throw new NullPointerException();
                }
                catch(Exception v7) {
                label_31:
                    v7.printStackTrace();
                }
            }

            return 1;
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static boolean isApplicationUid(int arg0) {
            return Process.isApplicationUid(arg0);
        }
    }

    private ProcessCompat() {
        super();
    }

    public static boolean isApplicationUid(int arg0) {
        return Api24Impl.isApplicationUid(arg0);
    }
}

