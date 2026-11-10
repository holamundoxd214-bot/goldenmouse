package androidx.lifecycle;

public final class ComputableLiveData$$ExternalSyntheticLambda1 implements Runnable {
    public ComputableLiveData$$ExternalSyntheticLambda1(ComputableLiveData arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        ComputableLiveData.invalidationRunnable$lambda$0(this.f$0);
    }
}

