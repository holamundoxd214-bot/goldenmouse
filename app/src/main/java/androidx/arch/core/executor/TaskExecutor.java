package androidx.arch.core.executor;

public abstract class TaskExecutor {
    public TaskExecutor() {
        super();
    }

    public abstract void executeOnDiskIO(Runnable arg1);

    public void executeOnMainThread(Runnable arg2) {
        if(this.isMainThread()) {
            arg2.run();
            return;
        }

        this.postToMainThread(arg2);
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(Runnable arg1);
}

