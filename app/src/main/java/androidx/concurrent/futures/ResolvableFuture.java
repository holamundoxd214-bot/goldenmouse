package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;

public final class ResolvableFuture extends AbstractResolvableFuture {
    private ResolvableFuture() {
        super();
    }

    public static ResolvableFuture create() {
        return new ResolvableFuture();
    }

    public boolean set(Object arg1) {
        return super.set(arg1);
    }

    public boolean setException(Throwable arg1) {
        return super.setException(arg1);
    }

    public boolean setFuture(ListenableFuture arg1) {
        return super.setFuture(arg1);
    }
}

