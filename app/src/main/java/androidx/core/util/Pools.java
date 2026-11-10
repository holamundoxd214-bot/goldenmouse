package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2={"Landroidx/core/util/Pools;", "", "<init>", "()V", "Pool", "SimplePool", "SynchronizedPool", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Pools {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u000F\u0010\u0003\u001A\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00028\u0000H&¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/core/util/Pools$Pool;", "T", "", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface Pool {
        Object acquire();

        boolean release(Object arg1);
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\f\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0015\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011R\u0018\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000E\u0010\u000B\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/core/util/Pools$SimplePool;", "T", "", "Landroidx/core/util/Pools$Pool;", "maxPoolSize", "", "<init>", "(I)V", "pool", "", "[Ljava/lang/Object;", "poolSize", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "isInPool", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public class SimplePool implements Pool {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(int arg1) {
            super();
            if(arg1 > 0) {
                this.pool = new Object[arg1];
                return;
            }

            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }

        public Object acquire() {
            int v0 = this.poolSize;
            Object v1 = null;
            if(v0 > 0) {
                --v0;
                Object v2 = this.pool[v0];
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                this.pool[v0] = v1;
                --this.poolSize;
                return v2;
            }

            return v1;
        }

        private final boolean isInPool(Object arg5) {
            int v0 = this.poolSize;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                if(this.pool[v2] == arg5) {
                    return 1;
                }
            }

            return 0;
        }

        public boolean release(Object arg4) {
            Intrinsics.checkNotNullParameter(arg4, "instance");
            if(!this.isInPool(arg4)) {
                int v0 = this.poolSize;
                Object[] v1 = this.pool;
                if(v0 < v1.length) {
                    v1[v0] = arg4;
                    this.poolSize = v0 + 1;
                    return 1;
                }

                return 0;
            }

            throw new IllegalStateException("Already in the pool!".toString());
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000ER\u000E\u0010\b\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/core/util/Pools$SynchronizedPool;", "T", "", "Landroidx/core/util/Pools$SimplePool;", "maxPoolSize", "", "<init>", "(I)V", "lock", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public class SynchronizedPool extends SimplePool {
        private final Object lock;

        public SynchronizedPool(int arg1) {
            super(arg1);
            this.lock = new Object();
        }

        public Object acquire() {
            Object v1_1;
            Object v0 = this.lock;
            __monitor_enter(v0);
            try {
                v1_1 = super.acquire();
            }
            catch(Throwable v1) {
                __monitor_exit(v0);
                throw v1;
            }

            __monitor_exit(v0);
            return v1_1;
        }

        public boolean release(Object arg2) {
            boolean v1_1;
            Intrinsics.checkNotNullParameter(arg2, "instance");
            Object v0 = this.lock;
            __monitor_enter(v0);
            try {
                v1_1 = super.release(arg2);
            }
            catch(Throwable v1) {
                __monitor_exit(v0);
                throw v1;
            }

            __monitor_exit(v0);
            return v1_1;
        }
    }

    private Pools() {
        super();
    }
}

