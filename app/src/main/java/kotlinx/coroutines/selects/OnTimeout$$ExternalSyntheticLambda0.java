package kotlinx.coroutines.selects;

public final class OnTimeout$$ExternalSyntheticLambda0 implements Runnable {
    public OnTimeout$$ExternalSyntheticLambda0(SelectInstance arg1, OnTimeout arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        OnTimeout.register$lambda$0(this.f$0, this.f$1);
    }
}

