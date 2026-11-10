package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001A\u0010\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u001A?\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00050\tH\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\"\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_SUCCESS", "", "TRY_LOCK_FAILED", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "HOLDS_LOCK_UNLOCKED", "HOLDS_LOCK_YES", "HOLDS_LOCK_ANOTHER_OWNER", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MutexKt {
    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final Symbol NO_OWNER = null;
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = null;
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS;

    static {
        MutexKt.NO_OWNER = new Symbol("NO_OWNER");
        MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    }

    public static final Mutex Mutex(boolean arg1) {
        return new MutexImpl(arg1);
    }

    public static Mutex Mutex$default(boolean arg0, int arg1, Object arg2) {
        return MutexKt.Mutex(false);
    }

    public static final Symbol access$getNO_OWNER$p() {
        return MutexKt.NO_OWNER;
    }

    public static final Symbol access$getON_LOCK_ALREADY_LOCKED_BY_OWNER$p() {
        return MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER;
    }

    public static final Object withLock(Mutex arg4, Object arg5, Function0 arg6, Continuation arg7) {
        Object v4;
        Object v6;
        int v2;
        Continuation v0;
        if((arg7 instanceof MutexKt$withLock$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((MutexKt$withLock$1)v0).label & v2) != 0) {
                ((MutexKt$withLock$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            MutexKt$withLock$1 v0_1 = new MutexKt$withLock$1(arg7);
        }

        Object v7 = ((MutexKt$withLock$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((MutexKt$withLock$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            ((MutexKt$withLock$1)v0).L$0 = arg4;
            ((MutexKt$withLock$1)v0).L$1 = arg5;
            ((MutexKt$withLock$1)v0).L$2 = arg6;
            ((MutexKt$withLock$1)v0).label = 1;
            if(arg4.lock(arg5, v0) == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            v6 = ((MutexKt$withLock$1)v0).L$2;
            arg5 = ((MutexKt$withLock$1)v0).L$1;
            v4 = ((MutexKt$withLock$1)v0).L$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            v6 = ((Function0)v6).invoke();
        }
        catch(Throwable v6_1) {
            ((Mutex)v4).unlock(arg5);
            throw v6_1;
        }

        ((Mutex)v4).unlock(arg5);
        return v6;
    }

    private static final Object withLock$$forInline(Mutex arg0, Object arg1, Function0 arg2, Continuation arg3) {
        Object v2_1;
        arg0.lock(arg1, arg3);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            arg0.unlock(arg1);
            throw v2;
        }

        arg0.unlock(arg1);
        return v2_1;
    }

    public static Object withLock$default(Mutex arg0, Object arg1, Function0 arg2, Continuation arg3, int arg4, Object arg5) {
        Object v2_1;
        if((arg4 & 1) != 0) {
            arg1 = null;
        }

        arg0.lock(arg1, arg3);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            arg0.unlock(arg1);
            throw v2;
        }

        arg0.unlock(arg1);
        return v2_1;
    }
}

