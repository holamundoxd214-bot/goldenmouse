package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A7\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001A7\u0010\u0006\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001A7\u0010\t\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2={"withLock", "T", "Ljava/util/concurrent/locks/Lock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "read", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class LocksKt {
    @IgnorableReturnValue private static final Object read(ReentrantReadWriteLock arg1, Function0 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        ReentrantReadWriteLock$ReadLock v1 = arg1.readLock();
        v1.lock();
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            v1.unlock();
            throw v2;
        }

        v1.unlock();
        return v2_1;
    }

    @IgnorableReturnValue private static final Object withLock(Lock arg1, Function0 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        arg1.lock();
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            arg1.unlock();
            throw v2;
        }

        arg1.unlock();
        return v2_1;
    }

    @IgnorableReturnValue private static final Object write(ReentrantReadWriteLock arg4, Function0 arg5) {
        Object v5_1;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        ReentrantReadWriteLock$ReadLock v0 = arg4.readLock();
        int v2 = 0;
        int v1 = arg4.getWriteHoldCount() == 0 ? arg4.getReadHoldCount() : 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v0.unlock();
        }

        ReentrantReadWriteLock$WriteLock v4 = arg4.writeLock();
        v4.lock();
        try {
            v5_1 = arg5.invoke();
        }
        catch(Throwable v5) {
            while(v2 < v1) {
                v0.lock();
                ++v2;
            }

            v4.unlock();
            throw v5;
        }

        while(v2 < v1) {
            v0.lock();
            ++v2;
        }

        v4.unlock();
        return v5_1;
    }
}

