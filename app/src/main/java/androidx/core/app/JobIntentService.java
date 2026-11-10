package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo$Builder;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager$WakeLock;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated public abstract class JobIntentService extends Service {
    final class CommandProcessor extends AsyncTask {
        CommandProcessor(JobIntentService arg1) {
            JobIntentService.this = arg1;
            super();
        }

        protected Object doInBackground(Object[] arg1) {
            return this.doInBackground(((Void[])arg1));
        }

        protected Void doInBackground(Void[] arg3) {
            while(true) {
                GenericWorkItem v3 = JobIntentService.this.dequeueWork();
                if(v3 == null) {
                    return null;
                }

                JobIntentService.this.onHandleWork(v3.getIntent());
                v3.complete();
            }

            return null;
        }

        protected void onCancelled(Object arg1) {
            this.onCancelled(((Void)arg1));
        }

        protected void onCancelled(Void arg1) {
            JobIntentService.this.processorFinished();
        }

        protected void onPostExecute(Object arg1) {
            this.onPostExecute(((Void)arg1));
        }

        protected void onPostExecute(Void arg1) {
            JobIntentService.this.processorFinished();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager$WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager$WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context arg4, ComponentName arg5) {
            super(arg5);
            this.mContext = arg4.getApplicationContext();
            Object v4 = arg4.getSystemService("power");
            PowerManager$WakeLock v0 = ((PowerManager)v4).newWakeLock(1, arg5.getClassName() + ":launch");
            this.mLaunchWakeLock = v0;
            v0.setReferenceCounted(false);
            PowerManager$WakeLock v4_1 = ((PowerManager)v4).newWakeLock(1, arg5.getClassName() + ":run");
            this.mRunWakeLock = v4_1;
            v4_1.setReferenceCounted(false);
        }

        void enqueueWork(Intent arg3) {
            Intent v0 = new Intent(arg3);
            v0.setComponent(this.mComponentName);
            if(this.mContext.startService(v0) != null) {
                __monitor_enter(this);
                try {
                    if(!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if(!this.mServiceProcessing) {
                            this.mLaunchWakeLock.acquire(60000);
                        }
                    }

                    __monitor_exit(this);
                    return;
                label_20:
                    __monitor_exit(this);
                }
                catch(Throwable v3) {
                    goto label_20;
                }

                throw v3;
            }
        }

        public void serviceProcessingFinished() {
            __monitor_enter(this);
            try {
                if(this.mServiceProcessing) {
                    if(this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000);
                    }

                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }

                __monitor_exit(this);
                return;
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_15;
            }

            throw v0;
        }

        public void serviceProcessingStarted() {
            __monitor_enter(this);
            try {
                if(!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000);
                    this.mLaunchWakeLock.release();
                }

                __monitor_exit(this);
                return;
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_13;
            }

            throw v0;
        }

        public void serviceStartReceived() {
            __monitor_enter(this);
            try {
                this.mLaunchingService = false;
                __monitor_exit(this);
                return;
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(JobIntentService arg1, Intent arg2, int arg3) {
            JobIntentService.this = arg1;
            super();
            this.mIntent = arg2;
            this.mStartId = arg3;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }

        public Intent getIntent() {
            return this.mIntent;
        }
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobServiceEngineImpl arg1, JobWorkItem arg2) {
                JobServiceEngineImpl.this = arg1;
                super();
                this.mJobWork = arg2;
            }

            public void complete() {
                Object v0 = JobServiceEngineImpl.this.mLock;
                __monitor_enter(v0);
                try {
                    if(JobServiceEngineImpl.this.mParams != null) {
                        JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                    }

                    __monitor_exit(v0);
                    return;
                label_13:
                    __monitor_exit(v0);
                }
                catch(Throwable v2) {
                    goto label_13;
                }

                throw v2;
            }

            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        JobServiceEngineImpl(JobIntentService arg2) {
            super(((Service)arg2));
            this.mLock = new Object();
            this.mService = arg2;
        }

        public IBinder compatGetBinder() {
            return this.getBinder();
        }

        public GenericWorkItem dequeueWork() {
            JobWorkItem v1_1;
            Object v0 = this.mLock;
            __monitor_enter(v0);
            try {
                JobParameters v1 = this.mParams;
                GenericWorkItem v2 = null;
                if(v1 == null) {
                    __monitor_exit(v0);
                    return v2;
                }

                v1_1 = v1.dequeueWork();
                __monitor_exit(v0);
                if(v1_1 == null) {
                    return v2;
                }
            }
            catch(Throwable v3) {
                try {
                label_19:
                    __monitor_exit(v0);
                }
                catch(Throwable v3) {
                    goto label_19;
                }

                throw v3;
            }

            v1_1.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new WrapperWorkItem(this, v1_1);
        }

        public boolean onStartJob(JobParameters arg1) {
            this.mParams = arg1;
            this.mService.ensureProcessorRunningLocked(false);
            return 1;
        }

        public boolean onStopJob(JobParameters arg3) {
            boolean v3 = this.mService.doStopCurrentWork();
            Object v0 = this.mLock;
            __monitor_enter(v0);
            JobParameters v1 = null;
            try {
                this.mParams = v1;
                __monitor_exit(v0);
                return v3;
            label_9:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_9;
            }

            throw v2;
        }
    }

    final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context arg3, ComponentName arg4, int arg5) {
            super(arg4);
            this.ensureJobId(arg5);
            this.mJobInfo = new JobInfo$Builder(arg5, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = arg3.getApplicationContext().getSystemService("jobscheduler");
        }

        void enqueueWork(Intent arg3) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(arg3));
        }
    }

    abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(ComponentName arg1) {
            super();
            this.mComponentName = arg1;
        }

        abstract void enqueueWork(Intent arg1);

        void ensureJobId(int arg4) {
            if(!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = arg4;
                return;
            }

            if(this.mJobId == arg4) {
                return;
            }

            throw new IllegalArgumentException("Given job ID " + arg4 + " is different than previous " + this.mJobId);
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    final ArrayList mCompatQueue;
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed;
    boolean mInterruptIfStopped;
    CompatJobEngine mJobImpl;
    boolean mStopped;
    static final HashMap sClassWorkEnqueuer;
    static final Object sLock;

    static {
        JobIntentService.sLock = new Object();
        JobIntentService.sClassWorkEnqueuer = new HashMap();
    }

    public JobIntentService() {
        super();
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        this.mCompatQueue = null;
    }

    GenericWorkItem dequeueWork() {
        CompatJobEngine v0 = this.mJobImpl;
        if(v0 != null) {
            return v0.dequeueWork();
        }

        ArrayList v0_1 = this.mCompatQueue;
        __monitor_enter(v0_1);
        try {
            if(this.mCompatQueue.size() > 0) {
                __monitor_exit(v0_1);
                return this.mCompatQueue.remove(0);
            }

            __monitor_exit(v0_1);
            return null;
        label_18:
            __monitor_exit(v0_1);
        }
        catch(Throwable v2) {
            goto label_18;
        }

        throw v2;
    }

    boolean doStopCurrentWork() {
        CommandProcessor v0 = this.mCurProcessor;
        if(v0 != null) {
            v0.cancel(this.mInterruptIfStopped);
        }

        this.mStopped = true;
        return this.onStopCurrentWork();
    }

    public static void enqueueWork(Context arg2, ComponentName arg3, int arg4, Intent arg5) {
        if(arg5 != null) {
            Object v0 = JobIntentService.sLock;
            __monitor_enter(v0);
            try {
                WorkEnqueuer v2_1 = JobIntentService.getWorkEnqueuer(arg2, arg3, true, arg4);
                v2_1.ensureJobId(arg4);
                v2_1.enqueueWork(arg5);
                __monitor_exit(v0);
                return;
            label_10:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_10;
            }

            throw v2;
        }

        throw new IllegalArgumentException("work must not be null");
    }

    public static void enqueueWork(Context arg1, Class arg2, int arg3, Intent arg4) {
        JobIntentService.enqueueWork(arg1, new ComponentName(arg1, arg2), arg3, arg4);
    }

    void ensureProcessorRunningLocked(boolean arg2) {
        if(this.mCurProcessor == null) {
            this.mCurProcessor = new CommandProcessor(this);
            WorkEnqueuer v0 = this.mCompatWorkEnqueuer;
            if(v0 != null && (arg2)) {
                v0.serviceProcessingStarted();
            }

            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    static WorkEnqueuer getWorkEnqueuer(Context arg2, ComponentName arg3, boolean arg4, int arg5) {
        HashMap v0 = JobIntentService.sClassWorkEnqueuer;
        Object v1 = v0.get(arg3);
        if(v1 == null) {
            if(arg4) {
                JobWorkEnqueuer v4 = new JobWorkEnqueuer(arg2, arg3, arg5);
                v0.put(arg3, v4);
                return ((WorkEnqueuer)v4);
            }

            throw new IllegalArgumentException("Can\'t be here without a job id");
        }

        return ((WorkEnqueuer)v1);
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public IBinder onBind(Intent arg1) {
        CompatJobEngine v0 = this.mJobImpl;
        if(v0 != null) {
            return v0.compatGetBinder();
        }

        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList v0 = this.mCompatQueue;
        if(v0 != null) {
            __monitor_enter(v0);
            try {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
                __monitor_exit(v0);
                return;
            label_11:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_11;
            }

            throw v2;
        }
    }

    protected abstract void onHandleWork(Intent arg1);

    public int onStartCommand(Intent arg3, int arg4, int arg5) {
        if(this.mCompatQueue != null) {
            this.mCompatWorkEnqueuer.serviceStartReceived();
            ArrayList v4 = this.mCompatQueue;
            __monitor_enter(v4);
            try {
                ArrayList v0 = this.mCompatQueue;
                if(arg3 != null) {
                }
                else {
                    arg3 = new Intent();
                }

                v0.add(new CompatWorkItem(this, arg3, arg5));
                this.ensureProcessorRunningLocked(true);
                __monitor_exit(v4);
                return 3;
            label_20:
                __monitor_exit(v4);
            }
            catch(Throwable v2) {
                goto label_20;
            }

            throw v2;
        }

        return 2;
    }

    public boolean onStopCurrentWork() {
        return 1;
    }

    void processorFinished() {
        ArrayList v0 = this.mCompatQueue;
        if(v0 != null) {
            __monitor_enter(v0);
            CommandProcessor v1 = null;
            try {
                this.mCurProcessor = v1;
                ArrayList v1_1 = this.mCompatQueue;
                if(v1_1 != null && v1_1.size() > 0) {
                    this.ensureProcessorRunningLocked(false);
                }
                else if(!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.serviceProcessingFinished();
                }

                __monitor_exit(v0);
                return;
            label_19:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_19;
            }

            throw v2;
        }
    }

    public void setInterruptIfStopped(boolean arg1) {
        this.mInterruptIfStopped = arg1;
    }
}

