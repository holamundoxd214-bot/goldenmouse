package androidx.core.os;

@Deprecated public final class CancellationSignal {
    public interface OnCancelListener {
        void onCancel();
    }

    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public CancellationSignal() {
        super();
    }

    public void cancel() {
        Object v1;
        OnCancelListener v0_1;
        __monitor_enter(this);
        try {
            if(this.mIsCanceled) {
                __monitor_exit(this);
                return;
            }

            this.mIsCanceled = true;
            this.mCancelInProgress = true;
            v0_1 = this.mOnCancelListener;
            v1 = this.mCancellationSignalObj;
            __monitor_exit(this);
            if(v0_1 == null) {
                goto label_17;
            }
        }
        catch(Throwable v0) {
            try {
            label_37:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_37;
            }

            throw v0;
        }

        try {
            v0_1.onCancel();
        label_17:
            if(v1 != null) {
                ((android.os.CancellationSignal)v1).cancel();
                goto label_28;
            label_16:
                goto label_20;
            }

            goto label_28;
        }
        catch(Throwable v0) {
            goto label_16;
        }

    label_20:
        __monitor_enter(this);
        try {
            this.mCancelInProgress = false;
            this.notifyAll();
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_26;
        }

        throw v0;
        try {
        label_26:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_26;
        }

        throw v0;
    label_28:
        __monitor_enter(this);
        try {
            this.mCancelInProgress = false;
            this.notifyAll();
            __monitor_exit(this);
            return;
        label_34:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_34;
        }

        throw v0;
    }

    public Object getCancellationSignalObject() {
        __monitor_enter(this);
        try {
            if(this.mCancellationSignalObj == null) {
                android.os.CancellationSignal v0_1 = new android.os.CancellationSignal();
                this.mCancellationSignalObj = v0_1;
                if(this.mIsCanceled) {
                    v0_1.cancel();
                }
            }

            __monitor_exit(this);
            return this.mCancellationSignalObj;
        label_14:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_14;
        }

        throw v0;
    }

    public boolean isCanceled() {
        __monitor_enter(this);
        try {
            __monitor_exit(this);
            return this.mIsCanceled;
        label_5:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_5;
        }

        throw v0;
    }

    public void setOnCancelListener(OnCancelListener arg2) {
        __monitor_enter(this);
        try {
            this.waitForCancelFinishedLocked();
            if(this.mOnCancelListener == arg2) {
                __monitor_exit(this);
                return;
            }

            this.mOnCancelListener = arg2;
            if(this.mIsCanceled) {
                if(arg2 == null) {
                }
                else {
                    __monitor_exit(this);
                    goto label_12;
                }
            }

            goto label_14;
        }
        catch(Throwable v2) {
            goto label_17;
        }

    label_12:
        arg2.onCancel();
        return;
        try {
        label_14:
            __monitor_exit(this);
            return;
        label_17:
            __monitor_exit(this);
        }
        catch(Throwable v2) {
            goto label_17;
        }

        throw v2;
    }

    public void throwIfCanceled() {
        if(!this.isCanceled()) {
            return;
        }

        throw new OperationCanceledException();
    }

    private void waitForCancelFinishedLocked() {
        while(this.mCancelInProgress) {
            try {
                this.wait();
            }
            catch(InterruptedException ) {
            }
        }
    }
}

