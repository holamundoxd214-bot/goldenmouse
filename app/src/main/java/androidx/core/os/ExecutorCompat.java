package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorCompat {
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

    private ExecutorCompat() {
        super();
    }

    public static Executor create(Handler arg1) {
        return new HandlerExecutor(arg1);
    }
}

