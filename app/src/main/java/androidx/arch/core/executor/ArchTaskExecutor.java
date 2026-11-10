package androidx.arch.core.executor;

import java.util.concurrent.Executor;

public class ArchTaskExecutor extends TaskExecutor {
    private final TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;
    private static final Executor sIOThreadExecutor;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor;

    static {
        ArchTaskExecutor.sMainThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda0();
        ArchTaskExecutor.sIOThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda1();
    }

    private ArchTaskExecutor() {
        super();
        DefaultTaskExecutor v0 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = ((TaskExecutor)v0);
        this.mDelegate = ((TaskExecutor)v0);
    }

    public void executeOnDiskIO(Runnable arg1) {
        this.mDelegate.executeOnDiskIO(arg1);
    }

    public static Executor getIOThreadExecutor() {
        return ArchTaskExecutor.sIOThreadExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if(ArchTaskExecutor.sInstance != null) {
            return ArchTaskExecutor.sInstance;
        }

        Class v0 = ArchTaskExecutor.class;
        __monitor_enter(v0);
        try {
            if(ArchTaskExecutor.sInstance == null) {
                ArchTaskExecutor.sInstance = new ArchTaskExecutor();
            }

            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            try {
            label_15:
                __monitor_exit(v0);
            }
            catch(Throwable v1) {
                goto label_15;
            }

            throw v1;
        }

        return ArchTaskExecutor.sInstance;
    }

    public static Executor getMainThreadExecutor() {
        return ArchTaskExecutor.sMainThreadExecutor;
    }

    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    static void lambda$static$0(Runnable arg1) {
        ArchTaskExecutor.getInstance().postToMainThread(arg1);
    }

    static void lambda$static$1(Runnable arg1) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(arg1);
    }

    public void postToMainThread(Runnable arg1) {
        this.mDelegate.postToMainThread(arg1);
    }

    public void setDelegate(TaskExecutor arg1) {
        if(arg1 == null) {
            arg1 = this.mDefaultTaskExecutor;
        }

        this.mDelegate = arg1;
    }
}

