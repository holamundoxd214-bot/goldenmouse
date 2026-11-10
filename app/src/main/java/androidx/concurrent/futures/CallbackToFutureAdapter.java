package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {
    public final class Completer {
        private boolean attemptedSetting;
        private ResolvableFuture cancellationFuture;
        SafeFuture future;
        Object tag;

        Completer() {
            super();
            this.cancellationFuture = ResolvableFuture.create();
        }

        public void addCancellationListener(Runnable arg1, Executor arg2) {
            ResolvableFuture v0 = this.cancellationFuture;
            if(v0 != null) {
                ((ListenableFuture)v0).addListener(arg1, arg2);
            }
        }

        protected void finalize() {
            SafeFuture v0 = this.future;
            if(v0 != null && !v0.isDone()) {
                v0.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
            }

            if(!this.attemptedSetting) {
                ResolvableFuture v4 = this.cancellationFuture;
                if(v4 != null) {
                    v4.set(null);
                }
            }
        }

        void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        public boolean set(Object arg3) {
            boolean v0 = true;
            this.attemptedSetting = true;
            SafeFuture v1 = this.future;
            if(v1 == null || !v1.set(arg3)) {
                v0 = false;
            }
            else {
            }

            if(v0) {
                this.setCompletedNormally();
            }

            return v0;
        }

        public boolean setCancelled() {
            boolean v0 = true;
            this.attemptedSetting = true;
            SafeFuture v1 = this.future;
            if(v1 == null || !v1.cancelWithoutNotifyingCompleter(true)) {
                v0 = false;
            }
            else {
            }

            if(v0) {
                this.setCompletedNormally();
            }

            return v0;
        }

        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        public boolean setException(Throwable arg3) {
            boolean v0 = true;
            this.attemptedSetting = true;
            SafeFuture v1 = this.future;
            if(v1 == null || !v1.setException(arg3)) {
                v0 = false;
            }
            else {
            }

            if(v0) {
                this.setCompletedNormally();
            }

            return v0;
        }
    }

    final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String arg1) {
            super(arg1);
        }

        public Throwable fillInStackTrace() {
            __monitor_enter(this);
            __monitor_exit(this);
            return this;
        }
    }

    public interface Resolver {
        Object attachCompleter(Completer arg1) throws Exception;
    }

    final class SafeFuture implements ListenableFuture {
        class androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture$1 extends AbstractResolvableFuture {
            androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture$1(SafeFuture arg1) {
                SafeFuture.this = arg1;
                super();
            }

            protected String pendingToString() {
                Object v2 = SafeFuture.this.completerWeakReference.get();
                if(v2 == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }

                return "tag=[" + ((Completer)v2).tag + "]";
            }
        }

        final WeakReference completerWeakReference;
        private final AbstractResolvableFuture delegate;

        SafeFuture(Completer arg2) {
            super();
            this.delegate = new androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture$1(this);
            this.completerWeakReference = new WeakReference(arg2);
        }

        public void addListener(Runnable arg1, Executor arg2) {
            this.delegate.addListener(arg1, arg2);
        }

        public boolean cancel(boolean arg2) {
            Object v0 = this.completerWeakReference.get();
            boolean v1 = this.delegate.cancel(arg2);
            if((v1) && v0 != null) {
                ((Completer)v0).fireCancellationListeners();
            }

            return v1;
        }

        boolean cancelWithoutNotifyingCompleter(boolean arg1) {
            return this.delegate.cancel(arg1);
        }

        public Object get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        public Object get(long arg1, TimeUnit arg3) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(arg1, arg3);
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        public boolean isDone() {
            return this.delegate.isDone();
        }

        boolean set(Object arg1) {
            return this.delegate.set(arg1);
        }

        boolean setException(Throwable arg1) {
            return this.delegate.setException(arg1);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private CallbackToFutureAdapter() {
        super();
    }

    public static ListenableFuture getFuture(Resolver arg3) {
        Completer v0 = new Completer();
        SafeFuture v1 = new SafeFuture(v0);
        v0.future = v1;
        v0.tag = arg3.getClass();
        try {
            Object v3_1 = arg3.attachCompleter(v0);
            if(v3_1 != null) {
                v0.tag = v3_1;
            }
        }
        catch(Exception v3) {
            v1.setException(((Throwable)v3));
            return ((ListenableFuture)v1);
        }

        return ((ListenableFuture)v1);
    }
}

