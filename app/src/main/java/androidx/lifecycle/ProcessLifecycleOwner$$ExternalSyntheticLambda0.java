package androidx.lifecycle;

public final class ProcessLifecycleOwner$$ExternalSyntheticLambda0 implements Runnable {
    public ProcessLifecycleOwner$$ExternalSyntheticLambda0(ProcessLifecycleOwner arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f$0);
    }
}

