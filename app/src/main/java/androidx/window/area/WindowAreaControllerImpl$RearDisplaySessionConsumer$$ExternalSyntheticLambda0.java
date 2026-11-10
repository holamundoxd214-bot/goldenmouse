package androidx.window.area;

public final class WindowAreaControllerImpl$RearDisplaySessionConsumer$$ExternalSyntheticLambda0 implements Runnable {
    public WindowAreaControllerImpl$RearDisplaySessionConsumer$$ExternalSyntheticLambda0(RearDisplaySessionConsumer arg1, WindowAreaSession arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        RearDisplaySessionConsumer.onSessionStarted$lambda$1$lambda$0(this.f$0, this.f$1);
    }
}

