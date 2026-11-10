package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B1\b\u0002\u0012&\u0010\u0003\u001A\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ]\u0010\u000E\u001A\u0002H\u000F\"\u0004\b\u0001\u0010\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000\u001121\u0010\u0013\u001A-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000F0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H\u0086@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R0\u0010\u0003\u001A\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0013\u0010\u000B\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0088\u0001\u0003\u0092\u0001\"\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00050\u0004j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0005`\u0006¨\u0006#"}, d2={"Landroidx/compose/ui/SessionMutex;", "T", "", "currentSessionHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/SessionMutex$Session;", "Landroidx/compose/ui/AtomicReference;", "constructor-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "()Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "currentSession", "getCurrentSession-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "withSessionCancellingPrevious", "R", "sessionInitializer", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "session", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "Lkotlin/coroutines/Continuation;", "withSessionCancellingPrevious-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "Session", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class SessionMutex {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001A\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2={"Landroidx/compose/ui/SessionMutex$Session;", "T", "", "job", "Lkotlinx/coroutines/Job;", "value", "<init>", "(Lkotlinx/coroutines/Job;Ljava/lang/Object;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Session {
        private final Job job;
        private final Object value;

        public Session(Job arg1, Object arg2) {
            super();
            this.job = arg1;
            this.value = arg2;
        }

        public final Job getJob() {
            return this.job;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    private final AtomicReference currentSessionHolder;

    private SessionMutex(AtomicReference arg1) {
        super();
        this.currentSessionHolder = arg1;
    }

    public static final SessionMutex box-impl(AtomicReference arg1) {
        return new SessionMutex(arg1);
    }

    public static AtomicReference constructor-impl() {
        return SessionMutex.constructor-impl(new AtomicReference(null));
    }

    private static AtomicReference constructor-impl(AtomicReference arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return SessionMutex.equals-impl(this.currentSessionHolder, arg1);
    }

    public static boolean equals-impl(AtomicReference arg2, Object arg3) {
        if(!(arg3 instanceof SessionMutex)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((SessionMutex)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(AtomicReference arg0, AtomicReference arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final Object getCurrentSession-impl(AtomicReference arg0) {
        Object v0 = arg0.get();
        if(v0 != null) {
            return ((Session)v0).getValue();
        }

        return null;
    }

    public int hashCode() {
        return SessionMutex.hashCode-impl(this.currentSessionHolder);
    }

    public static int hashCode-impl(AtomicReference arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return SessionMutex.toString-impl(this.currentSessionHolder);
    }

    public static String toString-impl(AtomicReference arg2) {
        return "SessionMutex(currentSessionHolder=" + arg2 + ')';
    }

    public final AtomicReference unbox-impl() {
        return this.currentSessionHolder;
    }

    public static final Object withSessionCancellingPrevious-impl(AtomicReference arg2, Function1 arg3, Function2 arg4, Continuation arg5) {
        return CoroutineScopeKt.coroutineScope(new SessionMutex$withSessionCancellingPrevious$2(arg3, arg2, arg4, null), arg5);
    }
}

