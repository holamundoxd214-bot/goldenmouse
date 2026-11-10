package kotlinx.coroutines.internal;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\nj\u0002`\u000B2\u000E\u0010\r\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0006\u001A(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\nj\u0002`\u000B0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "<init>", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "key", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class WeakMapCtorCache extends CtorCache {
    public static final WeakMapCtorCache INSTANCE;
    private static final ReentrantReadWriteLock cacheLock;
    private static final WeakHashMap exceptionCtors;

    static {
        WeakMapCtorCache.INSTANCE = new WeakMapCtorCache();
        WeakMapCtorCache.cacheLock = new ReentrantReadWriteLock();
        WeakMapCtorCache.exceptionCtors = new WeakHashMap();
    }

    private WeakMapCtorCache() {
        super();
    }

    public Function1 get(Class arg6) {
        Function1 v4_1;
        Object v4;
        Object v1;
        ReentrantReadWriteLock v5 = WeakMapCtorCache.cacheLock;
        ReentrantReadWriteLock$ReadLock v0 = v5.readLock();
        v0.lock();
        try {
            v1 = WeakMapCtorCache.exceptionCtors.get(arg6);
            v0.unlock();
            if(v1 == null) {
                goto label_8;
            }
        }
        catch(Throwable v5_1) {
            v0.unlock();
            throw v5_1;
        }

        return ((Function1)v1);
    label_8:
        v0 = v5.readLock();
        int v2 = 0;
        int v1_1 = v5.getWriteHoldCount() == 0 ? v5.getReadHoldCount() : 0;
        int v3;
        for(v3 = 0; v3 < v1_1; ++v3) {
            v0.unlock();
        }

        ReentrantReadWriteLock$WriteLock v5_2 = v5.writeLock();
        v5_2.lock();
        try {
            WeakHashMap v3_1 = WeakMapCtorCache.exceptionCtors;
            v4 = v3_1.get(arg6);
            if(v4 == null) {
                v4_1 = ExceptionsConstructorKt.createConstructor(arg6);
                ((Map)v3_1).put(arg6, v4_1);
                goto label_33;
            }

            goto label_25;
        }
        catch(Throwable v6) {
            while(v2 < v1_1) {
                v0.lock();
                ++v2;
            }

            v5_2.unlock();
            throw v6;
        }

    label_33:
        while(v2 < v1_1) {
            v0.lock();
            ++v2;
        }

        v5_2.unlock();
        return v4_1;
    label_25:
        while(v2 < v1_1) {
            v0.lock();
            ++v2;
        }

        v5_2.unlock();
        return ((Function1)v4);
    }
}

