package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0015\u001A\u00020\u0006J\u0006\u0010\u0016\u001A\u00020\u0006J\u0014\u0010\u0017\u001A\u00020\u00062\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u0019\u001A\u00020\u00062\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\u001A\u001A\u00020\u0006H\u0007J\b\u0010\u001B\u001A\u00020\u0006H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00020\u000B8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u00020\r8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u00020\r8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00128\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/activity/FullyDrawnReporter;", "", "executor", "Ljava/util/concurrent/Executor;", "reportFullyDrawn", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "lock", "reporterCount", "", "reportPosted", "", "reportedFullyDrawn", "isFullyDrawnReported", "()Z", "onReportCallbacks", "", "reportRunnable", "Ljava/lang/Runnable;", "addReporter", "removeReporter", "addOnReportDrawnListener", "callback", "removeOnReportDrawnListener", "fullyDrawnReported", "postWhenReportersAreDone", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock;
    private final List onReportCallbacks;
    private final Function0 reportFullyDrawn;
    private boolean reportPosted;
    private final Runnable reportRunnable;
    private boolean reportedFullyDrawn;
    private int reporterCount;

    public FullyDrawnReporter(Executor arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "executor");
        Intrinsics.checkNotNullParameter(arg3, "reportFullyDrawn");
        super();
        this.executor = arg2;
        this.reportFullyDrawn = arg3;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new FullyDrawnReporter$$ExternalSyntheticLambda0(this);
    }

    public final void addOnReportDrawnListener(Function0 arg3) {
        int v2_1;
        Intrinsics.checkNotNullParameter(arg3, "callback");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.reportedFullyDrawn) {
                v2_1 = 1;
            }
            else {
                this.onReportCallbacks.add(arg3);
                v2_1 = 0;
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        if(v2_1 != 0) {
            arg3.invoke();
        }
    }

    public final void addReporter() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.reportedFullyDrawn) {
                ++this.reporterCount;
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final void fullyDrawnReported() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.reportedFullyDrawn = true;
            Iterator v1 = this.onReportCallbacks.iterator();
            while(v1.hasNext()) {
                v1.next().invoke();
            }

            this.onReportCallbacks.clear();
        }
        catch(Throwable v3) {
            goto label_17;
        }

        __monitor_exit(v0);
        return;
    label_17:
        __monitor_exit(v0);
        throw v3;
    }

    public final boolean isFullyDrawnReported() {
        boolean v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.reportedFullyDrawn;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    private final void postWhenReportersAreDone() {
        if(!this.reportPosted && this.reporterCount == 0) {
            this.reportPosted = true;
            this.executor.execute(this.reportRunnable);
        }
    }

    public final void removeOnReportDrawnListener(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.onReportCallbacks.remove(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    public final void removeReporter() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.reportedFullyDrawn) {
                int v1 = this.reporterCount;
                if(v1 > 0) {
                    this.reporterCount = v1 - 1;
                    this.postWhenReportersAreDone();
                }
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    static final void reportRunnable$lambda$0(FullyDrawnReporter arg2) {
        Object v0 = arg2.lock;
        __monitor_enter(v0);
        try {
            arg2.reportPosted = false;
            if(arg2.reporterCount == 0 && !arg2.reportedFullyDrawn) {
                arg2.reportFullyDrawn.invoke();
                arg2.fullyDrawnReported();
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }
}

