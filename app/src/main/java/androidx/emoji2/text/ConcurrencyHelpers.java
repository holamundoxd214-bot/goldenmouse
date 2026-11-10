package androidx.emoji2.text;

import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ConcurrencyHelpers {
    class Handler28Impl {
        private Handler28Impl() {
            super();
        }

        public static Handler createAsync(Looper arg0) {
            return Handler.createAsync(arg0);
        }
    }

    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    public static boolean $r8$lambda$mCEi04OcFi8gu0FD463twzV2nG8(Handler arg0, Runnable arg1) {
        return arg0.post(arg1);
    }

    private ConcurrencyHelpers() {
        super();
    }

    @Deprecated static Executor convertHandlerToExecutor(Handler arg1) {
        Objects.requireNonNull(arg1);
        return new ConcurrencyHelpers$$ExternalSyntheticLambda0(arg1);
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(String arg8) {
        ThreadPoolExecutor v0 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda1(arg8));
        v0.allowCoreThreadTimeOut(true);
        return v0;
    }

    static Thread lambda$createBackgroundPriorityExecutor$0(String arg1, Runnable arg2) {
        Thread v0 = new Thread(arg2, arg1);
        v0.setPriority(10);
        return v0;
    }

    static Handler mainHandlerAsync() {
        if(Build$VERSION.SDK_INT >= 28) {
            return Handler28Impl.createAsync(Looper.getMainLooper());
        }

        return new Handler(Looper.getMainLooper());
    }
}

