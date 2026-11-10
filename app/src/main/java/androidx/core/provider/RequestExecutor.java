package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {
    class DefaultThreadFactory implements ThreadFactory {
        class ProcessPriorityThread extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable arg1, String arg2, int arg3) {
                super(arg1, arg2);
                this.mPriority = arg3;
            }

            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        private int mPriority;
        private String mThreadName;

        DefaultThreadFactory(String arg1, int arg2) {
            super();
            this.mThreadName = arg1;
            this.mPriority = arg2;
        }

        public Thread newThread(Runnable arg3) {
            return new ProcessPriorityThread(arg3, this.mThreadName, this.mPriority);
        }
    }

    class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(Handler arg1) {
            super();
            this.mHandler = Preconditions.checkNotNull(arg1);
        }

        public void execute(Runnable arg2) {
            if(this.mHandler.post(Preconditions.checkNotNull(arg2))) {
                return;
            }

            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    class ReplyRunnable implements Runnable {
        private Callable mCallable;
        private Consumer mConsumer;
        private Handler mHandler;

        ReplyRunnable(Handler arg1, Callable arg2, Consumer arg3) {
            super();
            this.mCallable = arg2;
            this.mConsumer = arg3;
            this.mHandler = arg1;
        }

        public void run() {
            Object v0;
            try {
                v0 = this.mCallable.call();
            }
            catch(Exception ) {
                v0 = null;
            }

            this.mHandler.post(new Runnable(this.mConsumer, v0) {
                public void run() {
                    this.val$consumer.accept(this.val$result);
                }
            });
        }
    }

    private RequestExecutor() {
        super();
    }

    static ThreadPoolExecutor createDefaultExecutor(String arg8, int arg9, int arg10) {
        ThreadPoolExecutor v0 = new ThreadPoolExecutor(0, 1, ((long)arg10), TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(arg8, arg9));
        v0.allowCoreThreadTimeOut(true);
        return v0;
    }

    static Executor createHandlerExecutor(Handler arg1) {
        return new HandlerExecutor(arg1);
    }

    static void execute(Executor arg2, Callable arg3, Consumer arg4) {
        arg2.execute(new ReplyRunnable(CalleeHandler.create(), arg3, arg4));
    }

    static Object submit(ExecutorService arg1, Callable arg2, int arg3) throws InterruptedException {
        Future v1 = arg1.submit(arg2);
        long v2 = ((long)arg3);
        try {
            return v1.get(v2, TimeUnit.MILLISECONDS);
        }
        catch(TimeoutException ) {
            throw new InterruptedException("timeout");
        }
        catch(InterruptedException v1_1) {
            throw v1_1;
        }
        catch(ExecutionException v1_2) {
            throw new RuntimeException(((Throwable)v1_2));
        }
    }
}

