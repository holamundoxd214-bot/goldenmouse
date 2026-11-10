package androidx.core.content;

public final class PackageManagerCompat$$ExternalSyntheticLambda0 implements Runnable {
    public PackageManagerCompat$$ExternalSyntheticLambda0(UnusedAppRestrictionsBackportServiceConnection arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        this.f$0.disconnectFromService();
    }
}

