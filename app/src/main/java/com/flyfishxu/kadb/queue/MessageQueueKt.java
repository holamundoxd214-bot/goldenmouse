package com.flyfishxu.kadb.queue;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A!\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0082\b\u001A)\u0010\u0006\u001A\u00020\u0001*\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¨\u0006\b"}, d2={"lock", "", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "body", "Lkotlin/Function0;", "tryLock", "elseBody", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class MessageQueueKt {
    private static final void lock(ReentrantLock arg1, Function0 arg2) {
        arg1.lock();
        try {
            arg2.invoke();
        }
        catch(Throwable v2) {
            if(arg1.isHeldByCurrentThread()) {
                arg1.unlock();
            }

            throw v2;
        }

        if(arg1.isHeldByCurrentThread()) {
            arg1.unlock();
        }
    }

    private static final void tryLock(ReentrantLock arg1, Function0 arg2, Function0 arg3) {
        if(arg1.tryLock()) {
            try {
                arg2.invoke();
            }
            catch(Throwable v2) {
                if(arg1.isHeldByCurrentThread()) {
                    arg1.unlock();
                }

                throw v2;
            }

            if(arg1.isHeldByCurrentThread()) {
                arg1.unlock();
            }

            return;
        }

        arg3.invoke();
    }
}

