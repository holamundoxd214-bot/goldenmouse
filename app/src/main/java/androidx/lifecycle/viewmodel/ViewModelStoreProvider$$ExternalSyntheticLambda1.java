package androidx.lifecycle.viewmodel;

public final class ViewModelStoreProvider$$ExternalSyntheticLambda1 implements ReferenceToken {
    public ViewModelStoreProvider$$ExternalSyntheticLambda1(Entry arg1, ViewModelStoreProvider arg2, Object arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void close() {
        ViewModelStoreProvider.acquireToken$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

