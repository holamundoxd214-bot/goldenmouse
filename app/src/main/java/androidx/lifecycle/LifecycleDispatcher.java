package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/lifecycle/LifecycleDispatcher;", "", "<init>", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "context", "Landroid/content/Context;", "DispatcherActivityCallback", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LifecycleDispatcher {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2={"Landroidx/lifecycle/LifecycleDispatcher$DispatcherActivityCallback;", "Landroidx/lifecycle/EmptyActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "lifecycle-process"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        public DispatcherActivityCallback() {
            super();
        }

        public void onActivityCreated(Activity arg1, Bundle arg2) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
            ReportFragment.Companion.injectIfNeededIn(arg1);
        }
    }

    public static final LifecycleDispatcher INSTANCE;
    private static final AtomicBoolean initialized;

    static {
        LifecycleDispatcher.INSTANCE = new LifecycleDispatcher();
        LifecycleDispatcher.initialized = new AtomicBoolean(false);
    }

    private LifecycleDispatcher() {
        super();
    }

    @JvmStatic public static final void init(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        if(LifecycleDispatcher.initialized.getAndSet(true)) {
            return;
        }

        arg2 = arg2.getApplicationContext();
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type android.app.Application");
        ((Application)arg2).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }
}

