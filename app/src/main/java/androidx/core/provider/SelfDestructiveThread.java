package androidx.core.provider;

import android.os.Handler$Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated public class SelfDestructiveThread {
    class androidx.core.provider.SelfDestructiveThread$1 implements Handler$Callback {
        androidx.core.provider.SelfDestructiveThread$1(SelfDestructiveThread arg1) {
            SelfDestructiveThread.this = arg1;
            super();
        }

        public boolean handleMessage(Message arg3) {
            int v0 = arg3.what;
            if(v0 != 0) {
                if(v0 != 1) {
                    return 1;
                }

                SelfDestructiveThread.this.onInvokeRunnable(arg3.obj);
                return 1;
            }

            SelfDestructiveThread.this.onDestruction();
            return 1;
        }
    }

    public interface ReplyCallback {
        void onReply(Object arg1);
    }

    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler$Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration;
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public SelfDestructiveThread(String arg2, int arg3, int arg4) {
        super();
        this.mLock = new Object();
        this.mCallback = new androidx.core.provider.SelfDestructiveThread$1(this);
        this.mThreadName = arg2;
        this.mPriority = arg3;
        this.mDestructAfterMillisec = arg4;
        this.mGeneration = 0;
    }

    public int getGeneration() {
        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.mGeneration;
        label_6:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_6;
        }

        throw v1;
    }

    public boolean isRunning() {
        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            boolean v1_1 = this.mThread != null ? true : false;
            __monitor_exit(v0);
            return v1_1;
        label_10:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_10;
        }

        throw v1;
    }

    void onDestruction() {
        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            if(this.mHandler.hasMessages(1)) {
                __monitor_exit(v0);
                return;
            }

            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
            __monitor_exit(v0);
            return;
        label_16:
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            goto label_16;
        }

        throw v3;
    }

    void onInvokeRunnable(Runnable arg5) {
        arg5.run();
        Object v5 = this.mLock;
        __monitor_enter(v5);
        try {
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), ((long)this.mDestructAfterMillisec));
            __monitor_exit(v5);
            return;
        label_14:
            __monitor_exit(v5);
        }
        catch(Throwable v4) {
            goto label_14;
        }

        throw v4;
    }

    private void post(Runnable arg6) {
        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            if(this.mThread == null) {
                HandlerThread v1 = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread = v1;
                v1.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                ++this.mGeneration;
            }

            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, arg6));
            __monitor_exit(v0);
            return;
        label_29:
            __monitor_exit(v0);
        }
        catch(Throwable v5) {
            goto label_29;
        }

        throw v5;
    }

    public void postAndReply(Callable arg3, ReplyCallback arg4) {
        this.post(new Runnable(arg3, CalleeHandler.create(), arg4) {
            public void run() {
                Object v0;
                try {
                    v0 = this.val$callable.call();
                }
                catch(Exception ) {
                    v0 = null;
                }

                this.val$calleeHandler.post(new Runnable(v0) {
                    public void run() {
                        this.this$1.val$reply.onReply(this.val$result);
                    }
                });
            }
        });
    }

    public Object postAndWait(Callable arg8, int arg9) throws InterruptedException {
        Object v7;
        ReentrantLock v4 = new ReentrantLock();
        Condition v6 = v4.newCondition();
        AtomicReference v2 = new AtomicReference();
        AtomicBoolean v5 = new AtomicBoolean(true);
        this.post(new Runnable(v2, arg8, v4, v5, v6) {
            public void run() {
                try {
                    this.val$holder.set(this.val$callable.call());
                    goto label_4;
                }
                catch(Exception ) {
                label_4:
                    this.val$lock.lock();
                    try {
                        this.val$running.set(false);
                        this.val$cond.signal();
                    }
                    catch(Throwable v0) {
                        this.val$lock.unlock();
                        throw v0;
                    }

                    this.val$lock.unlock();
                    return;
                }
            }
        });
        v4.lock();
        try {
            if(v5.get()) {
                goto label_19;
            }

            v7 = v2.get();
        }
        catch(Throwable v0) {
            goto label_37;
        }

        v4.unlock();
        return v7;
        try {
        label_19:
            long v7_1 = TimeUnit.MILLISECONDS.toNanos(((long)arg9));
            try {
                while(true) {
                label_22:
                    v7_1 = v6.awaitNanos(v7_1);
                    goto label_23;
                }
            }
            catch(InterruptedException ) {
            label_23:
                if(!v5.get()) {
                    v7 = v2.get();
                    v4.unlock();
                    return v7;
                }

                if(v7_1 > 0) {
                    goto label_22;
                }

                try {
                    throw new InterruptedException("timeout");
                }
                catch(Throwable v0) {
                label_37:
                    v4.unlock();
                    throw v0;
                }
            }
        }
        catch(Throwable v0) {
            goto label_37;
        }
    }
}

