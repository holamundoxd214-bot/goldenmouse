package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader extends Loader {
    final class LoadTask extends ModernAsyncTask implements Runnable {
        private final CountDownLatch mDone;
        boolean waiting;

        LoadTask(AsyncTaskLoader arg2) {
            AsyncTaskLoader.this = arg2;
            super();
            this.mDone = new CountDownLatch(1);
        }

        protected Object doInBackground(Object[] arg1) {
            return this.doInBackground(((Void[])arg1));
        }

        protected Object doInBackground(Void[] arg1) {
            try {
                Object v0 = AsyncTaskLoader.this.onLoadInBackground();
                return v0;
            }
            catch(OperationCanceledException v1) {
                if(((LoadTask)v0).isCancelled()) {
                    return null;
                }

                throw v1;
            }
        }

        protected void onCancelled(Object arg2) {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, arg2);
            }
            catch(Throwable v2) {
                this.mDone.countDown();
                throw v2;
            }

            this.mDone.countDown();
        }

        protected void onPostExecute(Object arg2) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, arg2);
            }
            catch(Throwable v2) {
                this.mDone.countDown();
                throw v2;
            }

            this.mDone.countDown();
        }

        public void run() {
            this.waiting = false;
            AsyncTaskLoader.this.executePendingTask();
        }

        public void waitForLoader() {
            try {
                this.mDone.await();
                return;
            }
            catch(InterruptedException ) {
                return;
            }
        }
    }

    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile LoadTask mTask;
    long mUpdateThrottle;

    public AsyncTaskLoader(Context arg2) {
        this(arg2, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(Context arg3, Executor arg4) {
        super(arg3);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = arg4;
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(LoadTask arg1, Object arg2) {
        this.onCanceled(arg2);
        if(this.mCancellingTask == arg1) {
            this.rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            this.deliverCancellation();
            this.executePendingTask();
        }
    }

    void dispatchOnLoadComplete(LoadTask arg3, Object arg4) {
        if(this.mTask != arg3) {
            this.dispatchOnCancelled(arg3, arg4);
            return;
        }

        if(this.isAbandoned()) {
            this.onCanceled(arg4);
            return;
        }

        this.commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        this.deliverResult(arg4);
    }

    @Deprecated public void dump(String arg5, FileDescriptor arg6, PrintWriter arg7, String[] arg8) {
        super.dump(arg5, arg6, arg7, arg8);
        String v8 = " waiting=";
        if(this.mTask != null) {
            arg7.print(arg5);
            arg7.print("mTask=");
            arg7.print(this.mTask);
            arg7.print(v8);
            arg7.println(this.mTask.waiting);
        }

        if(this.mCancellingTask != null) {
            arg7.print(arg5);
            arg7.print("mCancellingTask=");
            arg7.print(this.mCancellingTask);
            arg7.print(v8);
            arg7.println(this.mCancellingTask.waiting);
        }

        if(this.mUpdateThrottle != 0) {
            arg7.print(arg5);
            arg7.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, arg7);
            arg7.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), arg7);
            arg7.println();
        }
    }

    void executePendingTask() {
        if(this.mCancellingTask == null && this.mTask != null) {
            if(this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
            }

            if(this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.waiting = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                return;
            }

            this.mTask.executeOnExecutor(this.mExecutor, null);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        if(this.mCancellingTask != null) {
            return 1;
        }

        return 0;
    }

    public abstract Object loadInBackground();

    protected boolean onCancelLoad() {
        if(this.mTask != null) {
            if(!this.mStarted) {
                this.mContentChanged = true;
            }

            LoadTask v0 = this.mCancellingTask;
            LoadTask v2 = this.mTask;
            LoadTask v3 = null;
            if(v0 != null) {
                if(v2.waiting) {
                    this.mTask.waiting = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }

                this.mTask = v3;
                return 0;
            }

            boolean v0_1 = v2.waiting;
            v2 = this.mTask;
            if(v0_1) {
                v2.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = v3;
                return 0;
            }

            v0_1 = v2.cancel(false);
            if(v0_1) {
                this.mCancellingTask = this.mTask;
                this.cancelLoadInBackground();
            }

            this.mTask = v3;
            return v0_1;
        }

        return 0;
    }

    public void onCanceled(Object arg1) {
    }

    protected void onForceLoad() {
        super.onForceLoad();
        this.cancelLoad();
        this.mTask = new LoadTask(this);
        this.executePendingTask();
    }

    protected Object onLoadInBackground() {
        return this.loadInBackground();
    }

    public void setUpdateThrottle(long arg3) {
        this.mUpdateThrottle = arg3;
        if(arg3 != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        LoadTask v0 = this.mTask;
        if(v0 != null) {
            v0.waitForLoader();
        }
    }
}

