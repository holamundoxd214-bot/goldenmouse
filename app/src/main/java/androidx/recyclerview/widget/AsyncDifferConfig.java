package androidx.recyclerview.widget;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig {
    public final class Builder {
        private Executor mBackgroundThreadExecutor;
        private final ItemCallback mDiffCallback;
        private Executor mMainThreadExecutor;
        private static Executor sDiffExecutor;
        private static final Object sExecutorLock;

        static {
            Builder.sExecutorLock = new Object();
        }

        public Builder(ItemCallback arg1) {
            super();
            this.mDiffCallback = arg1;
        }

        public AsyncDifferConfig build() {
            if(this.mBackgroundThreadExecutor == null) {
                Object v0 = Builder.sExecutorLock;
                __monitor_enter(v0);
                try {
                    if(Builder.sDiffExecutor == null) {
                        Builder.sDiffExecutor = Executors.newFixedThreadPool(2);
                    }

                    __monitor_exit(v0);
                }
                catch(Throwable v3) {
                    try {
                    label_14:
                        __monitor_exit(v0);
                    }
                    catch(Throwable v3) {
                        goto label_14;
                    }

                    throw v3;
                }

                this.mBackgroundThreadExecutor = Builder.sDiffExecutor;
            }

            return new AsyncDifferConfig(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        }

        public Builder setBackgroundThreadExecutor(Executor arg1) {
            this.mBackgroundThreadExecutor = arg1;
            return this;
        }

        public Builder setMainThreadExecutor(Executor arg1) {
            this.mMainThreadExecutor = arg1;
            return this;
        }
    }

    private final Executor mBackgroundThreadExecutor;
    private final ItemCallback mDiffCallback;
    private final Executor mMainThreadExecutor;

    AsyncDifferConfig(Executor arg1, Executor arg2, ItemCallback arg3) {
        super();
        this.mMainThreadExecutor = arg1;
        this.mBackgroundThreadExecutor = arg2;
        this.mDiffCallback = arg3;
    }

    public Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    public ItemCallback getDiffCallback() {
        return this.mDiffCallback;
    }

    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }
}

