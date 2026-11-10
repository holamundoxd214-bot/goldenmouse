package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask {
    final class androidx.loader.content.ModernAsyncTask$1 implements ThreadFactory {
        private final AtomicInteger mCount;

        androidx.loader.content.ModernAsyncTask$1() {
            super();
            this.mCount = new AtomicInteger(1);
        }

        public Thread newThread(Runnable arg4) {
            return new Thread(arg4, "ModernAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    class androidx.loader.content.ModernAsyncTask$4 {
        static {
            int[] v0 = new int[Status.values().length];
            androidx.loader.content.ModernAsyncTask$4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status = v0;
            try {
                v0[Status.RUNNING.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.loader.content.ModernAsyncTask$4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;
                    return;
                }
                catch(NoSuchFieldError ) {
                    return;
                }
            }
        }
    }

    class AsyncTaskResult {
        final Object[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask arg1, Object[] arg2) {
            super();
            this.mTask = arg1;
            this.mData = arg2;
        }
    }

    class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message arg2) {
            Object v1 = arg2.obj;
            int v2 = arg2.what;
            if(v2 != 1) {
                if(v2 != 2) {
                    return;
                }

                ((AsyncTaskResult)v1).mTask.onProgressUpdate(((AsyncTaskResult)v1).mData);
                return;
            }

            ((AsyncTaskResult)v1).mTask.finish(((AsyncTaskResult)v1).mData[0]);
        }
    }

    public enum Status {
        public static final enum Status FINISHED;
        public static final enum Status PENDING;
        public static final enum Status RUNNING;

        static {
            Status v0 = new Status("PENDING", 0);
            Status.PENDING = v0;
            Status v1 = new Status("RUNNING", 1);
            Status.RUNNING = v1;
            Status v2 = new Status("FINISHED", 2);
            Status.FINISHED = v2;
            Status.$VALUES = new Status[]{v0, v1, v2};
        }

        private Status(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Status valueOf(String arg1) {
            return Enum.valueOf(Status.class, arg1);
        }

        public static Status[] values() {
            return Status.$VALUES.clone();
        }
    }

    abstract class WorkerRunnable implements Callable {
        Object[] mParams;

        WorkerRunnable() {
            super();
        }
    }

    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 0x80;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR;
    final AtomicBoolean mCancelled;
    private final FutureTask mFuture;
    private volatile Status mStatus;
    final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable mWorker;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;

    static {
        androidx.loader.content.ModernAsyncTask$1 v7 = new androidx.loader.content.ModernAsyncTask$1();
        ModernAsyncTask.sThreadFactory = ((ThreadFactory)v7);
        LinkedBlockingQueue v6 = new LinkedBlockingQueue(10);
        ModernAsyncTask.sPoolWorkQueue = ((BlockingQueue)v6);
        ThreadPoolExecutor v0 = new ThreadPoolExecutor(5, 0x80, 1, TimeUnit.SECONDS, ((BlockingQueue)v6), ((ThreadFactory)v7));
        ModernAsyncTask.THREAD_POOL_EXECUTOR = ((Executor)v0);
        ModernAsyncTask.sDefaultExecutor = ((Executor)v0);
    }

    ModernAsyncTask() {
        super();
        this.mStatus = Status.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        androidx.loader.content.ModernAsyncTask$2 v0 = new WorkerRunnable() {
            public Object call() throws Exception {
                Object v2;
                ModernAsyncTask.this.mTaskInvoked.set(true);
                int v0 = 10;
                try {
                    Process.setThreadPriority(v0);
                    v2 = ModernAsyncTask.this.doInBackground(this.mParams);
                    Binder.flushPendingCommands();
                }
                catch(Throwable v0_1) {
                    try {
                        ModernAsyncTask.this.mCancelled.set(true);
                        throw v0_1;
                    }
                    catch(Throwable v0_1) {
                        ModernAsyncTask.this.postResult(v2);
                        throw v0_1;
                    }
                }

                ModernAsyncTask.this.postResult(v2);
                return v2;
            }
        };
        this.mWorker = ((WorkerRunnable)v0);
        this.mFuture = new FutureTask(((Callable)v0)) {
            protected void done() {
                String v0 = "An error occurred while executing doInBackground()";
                try {
                    ModernAsyncTask.this.postResultIfNotInvoked(this.get());
                    return;
                }
                catch(Throwable v3) {
                    throw new RuntimeException(v0, v3);
                }
                catch(CancellationException ) {
                    ModernAsyncTask.this.postResultIfNotInvoked(null);
                    return;
                }
                catch(ExecutionException v3_1) {
                    throw new RuntimeException(v0, v3_1.getCause());
                }
                catch(InterruptedException v3_2) {
                    Log.w("AsyncTask", ((Throwable)v3_2));
                    return;
                }
            }
        };
    }

    public final boolean cancel(boolean arg3) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(arg3);
    }

    protected abstract Object doInBackground(Object[] arg1);

    public static void execute(Runnable arg1) {
        ModernAsyncTask.sDefaultExecutor.execute(arg1);
    }

    public final ModernAsyncTask execute(Object[] arg2) {
        return this.executeOnExecutor(ModernAsyncTask.sDefaultExecutor, arg2);
    }

    public final ModernAsyncTask executeOnExecutor(Executor arg3, Object[] arg4) {
        if(this.mStatus != Status.PENDING) {
            int v2 = androidx.loader.content.ModernAsyncTask$4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
            if(v2 != 1) {
                if(v2 != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }

                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }

            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }

        this.mStatus = Status.RUNNING;
        this.onPreExecute();
        this.mWorker.mParams = arg4;
        arg3.execute(this.mFuture);
        return this;
    }

    void finish(Object arg2) {
        if(this.isCancelled()) {
            this.onCancelled(arg2);
        }
        else {
            this.onPostExecute(arg2);
        }

        this.mStatus = Status.FINISHED;
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Object get(long arg1, TimeUnit arg3) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(arg1, arg3);
    }

    private static Handler getHandler() {
        Class v0 = ModernAsyncTask.class;
        __monitor_enter(v0);
        try {
            InternalHandler v1_1 = ModernAsyncTask.sHandler;
            if(v1_1 == null) {
                v1_1 = new InternalHandler();
                ModernAsyncTask.sHandler = v1_1;
            }

            __monitor_exit(v0);
            return ((Handler)v1_1);
        label_10:
            __monitor_exit(v0);
        }
        catch(Throwable v1) {
            goto label_10;
        }

        throw v1;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled(Object arg1) {
        this.onCancelled();
    }

    protected void onCancelled() {
    }

    protected void onPostExecute(Object arg1) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Object[] arg1) {
    }

    Object postResult(Object arg4) {
        ModernAsyncTask.getHandler().obtainMessage(1, new AsyncTaskResult(this, new Object[]{arg4})).sendToTarget();
        return arg4;
    }

    void postResultIfNotInvoked(Object arg2) {
        if(!this.mTaskInvoked.get()) {
            this.postResult(arg2);
        }
    }

    protected final void publishProgress(Object[] arg3) {
        if(!this.isCancelled()) {
            ModernAsyncTask.getHandler().obtainMessage(2, new AsyncTaskResult(this, arg3)).sendToTarget();
        }
    }

    public static void setDefaultExecutor(Executor arg0) {
        ModernAsyncTask.sDefaultExecutor = arg0;
    }
}

