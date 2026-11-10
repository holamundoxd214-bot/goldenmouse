package androidx.arch.core.executor;

import android.os.Build$VERSION;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTaskExecutor extends TaskExecutor {
    class androidx.arch.core.executor.DefaultTaskExecutor$1 implements ThreadFactory {
        private static final String THREAD_NAME_STEM = "arch_disk_io_";
        private final AtomicInteger mThreadId;

        androidx.arch.core.executor.DefaultTaskExecutor$1(DefaultTaskExecutor arg2) {
            DefaultTaskExecutor.this = arg2;
            super();
            this.mThreadId = new AtomicInteger(0);
        }

        public Thread newThread(Runnable arg3) {
            Thread v0 = new Thread(arg3);
            v0.setName("arch_disk_io_" + this.mThreadId.getAndIncrement());
            return v0;
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        public static Handler createAsync(Looper arg0) {
            return Handler.createAsync(arg0);
        }
    }

    private final ExecutorService mDiskIO;
    private final Object mLock;
    private volatile Handler mMainHandler;

    public DefaultTaskExecutor() {
        super();
        this.mLock = new Object();
        this.mDiskIO = Executors.newFixedThreadPool(4, new androidx.arch.core.executor.DefaultTaskExecutor$1(this));
    }

    private static Handler createAsync(Looper arg5) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(arg5);
        }

        try {
            return Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(arg5, null, Boolean.valueOf(true));
        }
        catch(InvocationTargetException ) {
            return new Handler(arg5);
        }
        catch(NoSuchMethodException ) {
            return new Handler(arg5);
        }
    }

    public void executeOnDiskIO(Runnable arg1) {
        this.mDiskIO.execute(arg1);
    }

    public boolean isMainThread() {
        if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return 1;
        }

        return 0;
    }

    public void postToMainThread(Runnable arg3) {
        if(this.mMainHandler == null) {
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                if(this.mMainHandler == null) {
                    this.mMainHandler = DefaultTaskExecutor.createAsync(Looper.getMainLooper());
                }

                __monitor_exit(v0);
                goto label_14;
            label_12:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_12;
            }

            throw v2;
        }

    label_14:
        this.mMainHandler.post(arg3);
    }
}

