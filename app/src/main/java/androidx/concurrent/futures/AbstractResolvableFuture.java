package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractResolvableFuture implements ListenableFuture {
    class androidx.concurrent.futures.AbstractResolvableFuture$1 {
    }

    abstract class AtomicHelper {
        private AtomicHelper() {
            super();
        }

        AtomicHelper(androidx.concurrent.futures.AbstractResolvableFuture$1 arg1) {
            this();
        }

        abstract boolean casListeners(AbstractResolvableFuture arg1, Listener arg2, Listener arg3);

        abstract boolean casValue(AbstractResolvableFuture arg1, Object arg2, Object arg3);

        abstract boolean casWaiters(AbstractResolvableFuture arg1, Waiter arg2, Waiter arg3);

        abstract void putNext(Waiter arg1, Waiter arg2);

        abstract void putThread(Waiter arg1, Thread arg2);
    }

    final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED;
        static final Cancellation CAUSELESS_INTERRUPTED;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            Cancellation v1 = null;
            if(AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                Cancellation.CAUSELESS_CANCELLED = v1;
                Cancellation.CAUSELESS_INTERRUPTED = v1;
                return;
            }

            Cancellation.CAUSELESS_CANCELLED = new Cancellation(false, ((Throwable)v1));
            Cancellation.CAUSELESS_INTERRUPTED = new Cancellation(true, ((Throwable)v1));
        }

        Cancellation(boolean arg1, Throwable arg2) {
            super();
            this.wasInterrupted = arg1;
            this.cause = arg2;
        }
    }

    final class Failure {
        class androidx.concurrent.futures.AbstractResolvableFuture$Failure$1 extends Throwable {
            androidx.concurrent.futures.AbstractResolvableFuture$Failure$1(String arg1) {
                super(arg1);
            }

            public Throwable fillInStackTrace() {
                __monitor_enter(this);
                __monitor_exit(this);
                return this;
            }
        }

        static final Failure FALLBACK_INSTANCE;
        final Throwable exception;

        static {
            Failure.FALLBACK_INSTANCE = new Failure(new androidx.concurrent.futures.AbstractResolvableFuture$Failure$1("Failure occurred while trying to finish a future."));
        }

        Failure(Throwable arg1) {
            super();
            this.exception = AbstractResolvableFuture.checkNotNull(arg1);
        }
    }

    final class Listener {
        static final Listener TOMBSTONE;
        final Executor executor;
        Listener next;
        final Runnable task;

        static {
            Listener.TOMBSTONE = new Listener(null, null);
        }

        Listener(Runnable arg1, Executor arg2) {
            super();
            this.task = arg1;
            this.executor = arg2;
        }
    }

    final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater listenersUpdater;
        final AtomicReferenceFieldUpdater valueUpdater;
        final AtomicReferenceFieldUpdater waiterNextUpdater;
        final AtomicReferenceFieldUpdater waiterThreadUpdater;
        final AtomicReferenceFieldUpdater waitersUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater arg2, AtomicReferenceFieldUpdater arg3, AtomicReferenceFieldUpdater arg4, AtomicReferenceFieldUpdater arg5, AtomicReferenceFieldUpdater arg6) {
            super(null);
            this.waiterThreadUpdater = arg2;
            this.waiterNextUpdater = arg3;
            this.waitersUpdater = arg4;
            this.listenersUpdater = arg5;
            this.valueUpdater = arg6;
        }

        boolean casListeners(AbstractResolvableFuture arg1, Listener arg2, Listener arg3) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.listenersUpdater, arg1, arg2, arg3);
        }

        boolean casValue(AbstractResolvableFuture arg1, Object arg2, Object arg3) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.valueUpdater, arg1, arg2, arg3);
        }

        boolean casWaiters(AbstractResolvableFuture arg1, Waiter arg2, Waiter arg3) {
            return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.waitersUpdater, arg1, arg2, arg3);
        }

        void putNext(Waiter arg1, Waiter arg2) {
            this.waiterNextUpdater.lazySet(arg1, arg2);
        }

        void putThread(Waiter arg1, Thread arg2) {
            this.waiterThreadUpdater.lazySet(arg1, arg2);
        }
    }

    final class SetFuture implements Runnable {
        final ListenableFuture future;
        final AbstractResolvableFuture owner;

        SetFuture(AbstractResolvableFuture arg1, ListenableFuture arg2) {
            super();
            this.owner = arg1;
            this.future = arg2;
        }

        public void run() {
            if(this.owner.value != this) {
            }
            else if(AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractResolvableFuture.getFutureValue(this.future))) {
                AbstractResolvableFuture.complete(this.owner);
            }
        }
    }

    final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super(null);
        }

        boolean casListeners(AbstractResolvableFuture arg1, Listener arg2, Listener arg3) {
            __monitor_enter(arg1);
            try {
                if(arg1.listeners == arg2) {
                    arg1.listeners = arg3;
                    __monitor_exit(arg1);
                    return 1;
                }

                __monitor_exit(arg1);
                return 0;
            label_11:
                __monitor_exit(arg1);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        boolean casValue(AbstractResolvableFuture arg1, Object arg2, Object arg3) {
            __monitor_enter(arg1);
            try {
                if(arg1.value == arg2) {
                    arg1.value = arg3;
                    __monitor_exit(arg1);
                    return 1;
                }

                __monitor_exit(arg1);
                return 0;
            label_11:
                __monitor_exit(arg1);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        boolean casWaiters(AbstractResolvableFuture arg1, Waiter arg2, Waiter arg3) {
            __monitor_enter(arg1);
            try {
                if(arg1.waiters == arg2) {
                    arg1.waiters = arg3;
                    __monitor_exit(arg1);
                    return 1;
                }

                __monitor_exit(arg1);
                return 0;
            label_11:
                __monitor_exit(arg1);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        void putNext(Waiter arg1, Waiter arg2) {
            arg1.next = arg2;
        }

        void putThread(Waiter arg1, Thread arg2) {
            arg1.thread = arg2;
        }
    }

    final class Waiter {
        static final Waiter TOMBSTONE;
        volatile Waiter next;
        volatile Thread thread;

        static {
            Waiter.TOMBSTONE = new Waiter(false);
        }

        Waiter() {
            super();
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        Waiter(boolean arg1) {
            super();
        }

        void setNext(Waiter arg2) {
            AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, arg2);
        }

        void unpark() {
            Thread v0 = this.thread;
            if(v0 != null) {
                this.thread = null;
                LockSupport.unpark(v0);
            }
        }
    }

    static final AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    volatile Listener listeners;
    private static final Logger log;
    volatile Object value;
    volatile Waiter waiters;

    static {
        SynchronizedHelper v2_1;
        AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        Class v0 = AbstractResolvableFuture.class;
        AbstractResolvableFuture.log = Logger.getLogger(v0.getName());
        try {
            SafeAtomicHelper v2 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(v0, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(v0, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(v0, Object.class, "value"));
            v0_1 = null;
        }
        catch(Throwable v0_1) {
            v2_1 = new SynchronizedHelper();
        }

        AbstractResolvableFuture.ATOMIC_HELPER = ((AtomicHelper)v2_1);
        if(v0_1 != null) {
            AbstractResolvableFuture.log.log(Level.SEVERE, "SafeAtomicHelper is broken!", v0_1);
        }

        AbstractResolvableFuture.NULL = new Object();
    }

    protected AbstractResolvableFuture() {
        super();
    }

    private void addDoneString(StringBuilder arg4) {
        String v0 = "]";
        try {
            arg4.append("SUCCESS, result=[").append(this.userObjectToString(AbstractResolvableFuture.getUninterruptibly(((Future)this)))).append(v0);
            return;
        }
        catch(RuntimeException v3) {
            arg4.append("UNKNOWN, cause=[").append(v3.getClass()).append(" thrown from get()]");
        }
        catch(CancellationException ) {
            arg4.append("CANCELLED");
        }
        catch(ExecutionException v3_1) {
            arg4.append("FAILURE, cause=[").append(v3_1.getCause()).append(v0);
        }
    }

    public final void addListener(Runnable arg4, Executor arg5) {
        AbstractResolvableFuture.checkNotNull(arg4);
        AbstractResolvableFuture.checkNotNull(arg5);
        Listener v0 = this.listeners;
        if(v0 != Listener.TOMBSTONE) {
            Listener v1 = new Listener(arg4, arg5);
            do {
                v1.next = v0;
                if(!AbstractResolvableFuture.ATOMIC_HELPER.casListeners(this, v0, v1)) {
                    v0 = this.listeners;
                    if(v0 != Listener.TOMBSTONE) {
                        continue;
                    }
                }
                else {
                    return;
                }

                goto label_15;
            }
            while(true);

            return;
        }

    label_15:
        AbstractResolvableFuture.executeListener(arg4, arg5);
    }

    protected void afterDone() {
    }

    public final boolean cancel(boolean arg7) {
        ListenableFuture v6;
        Cancellation v3_1;
        Object v0 = this.value;
        int v3 = v0 == null ? 1 : 0;
        if((v3 | v0 instanceof SetFuture) != 0) {
            if(AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                v3_1 = new Cancellation(arg7, new CancellationException("Future.cancel() was called."));
            }
            else if(arg7) {
                v3_1 = Cancellation.CAUSELESS_INTERRUPTED;
            }
            else {
                v3_1 = Cancellation.CAUSELESS_CANCELLED;
            }

            boolean v4 = false;
            do {
            label_23:
                if(AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, v0, v3_1)) {
                    if(arg7) {
                        this.interruptTask();
                    }

                    AbstractResolvableFuture.complete(this);
                    if((v0 instanceof SetFuture)) {
                        v6 = ((SetFuture)v0).future;
                        if((v6 instanceof AbstractResolvableFuture)) {
                            v0 = ((AbstractResolvableFuture)v6).value;
                            int v4_1 = v0 == null ? 1 : 0;
                            if((v4_1 | v0 instanceof SetFuture) == 0) {
                                return 1;
                            }

                            v4 = true;
                            goto label_23;
                        }
                        else {
                            v6.cancel(arg7);
                        }
                    }

                    return 1;
                }

                v0 = ((AbstractResolvableFuture)v6).value;
            }
            while((v0 instanceof SetFuture));

            return v4;
        }

        return 0;
    }

    private static CancellationException cancellationExceptionWithCause(String arg1, Throwable arg2) {
        CancellationException v0 = new CancellationException(arg1);
        v0.initCause(arg2);
        return v0;
    }

    static Object checkNotNull(Object arg0) {
        arg0.getClass();
        return arg0;
    }

    private Listener clearListeners(Listener arg4) {
        Listener v3;
        Listener v0;
        do {
            v0 = this.listeners;
        }
        while(!AbstractResolvableFuture.ATOMIC_HELPER.casListeners(this, v0, Listener.TOMBSTONE));

        while(true) {
            v3 = arg4;
            arg4 = v0;
            if(arg4 == null) {
                return v3;
            }

            v0 = arg4.next;
            arg4.next = v3;
        }

        return v3;
    }

    static void complete(AbstractResolvableFuture arg4) {
        Runnable v1;
        Listener v4;
        Listener v0 = null;
        while(true) {
        label_1:
            arg4.releaseWaiters();
            arg4.afterDone();
            v4 = arg4.clearListeners(v0);
            while(true) {
            label_4:
                if(v4 == null) {
                    return;
                }

                v0 = v4.next;
                v1 = v4.task;
                if((v1 instanceof SetFuture)) {
                    arg4 = ((SetFuture)v1).owner;
                    if(arg4.value == v1 && (AbstractResolvableFuture.ATOMIC_HELPER.casValue(arg4, v1, AbstractResolvableFuture.getFutureValue(((SetFuture)v1).future)))) {
                        goto label_1;
                    }
                }
                else {
                    break;
                }

                goto label_20;
            }
        }

        AbstractResolvableFuture.executeListener(v1, v4.executor);
    label_20:
        v4 = v0;
        goto label_4;
    }

    private static void executeListener(Runnable arg5, Executor arg6) {
        try {
            arg6.execute(arg5);
            return;
        }
        catch(RuntimeException v0) {
            AbstractResolvableFuture.log.log(Level.SEVERE, "RuntimeException while executing runnable " + arg5 + " with executor " + arg6, ((Throwable)v0));
            return;
        }
    }

    public final Object get() throws InterruptedException, ExecutionException {
        if(!Thread.interrupted()) {
            Object v0 = this.value;
            int v3 = v0 != null ? 1 : 0;
            if((v3 & (v0 instanceof SetFuture ^ 1)) != 0) {
                return this.getDoneValue(v0);
            }

            Waiter v0_1 = this.waiters;
            if(v0_1 != Waiter.TOMBSTONE) {
                Waiter v3_1 = new Waiter();
                do {
                    v3_1.setNext(v0_1);
                    if(AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(this, v0_1, v3_1)) {
                        break;
                    }

                    v0_1 = this.waiters;
                    if(v0_1 != Waiter.TOMBSTONE) {
                        continue;
                    }

                    goto label_45;
                }
                while(true);

                do {
                    LockSupport.park(this);
                    if(Thread.interrupted()) {
                        goto label_38;
                    }

                    v0 = this.value;
                    int v4 = v0 != null ? 1 : 0;
                }
                while((v4 & (v0 instanceof SetFuture ^ 1)) == 0);

                return this.getDoneValue(v0);
            label_38:
                this.removeWaiter(v3_1);
                throw new InterruptedException();
            }

        label_45:
            return this.getDoneValue(this.value);
        }

        throw new InterruptedException();
    }

    public final Object get(long arg20, TimeUnit arg22) throws InterruptedException, TimeoutException, ExecutionException {
        int v5;
        Object v4_1;
        AbstractResolvableFuture v0 = this;
        long v1 = arg20;
        TimeUnit v3 = arg22;
        long v4 = v3.toNanos(v1);
        if(Thread.interrupted()) {
            goto label_174;
        }

        Object v6 = v0.value;
        int v9 = v6 != null ? 1 : 0;
        if((v9 & (v6 instanceof SetFuture ^ 1)) != 0) {
            return v0.getDoneValue(v6);
        }

        long v9_1 = 0;
        long v11 = v4 > v9_1 ? System.nanoTime() + v4 : v9_1;
        long v13 = 1000;
        if(v4 >= v13) {
            Waiter v6_1 = v0.waiters;
            if(v6_1 != Waiter.TOMBSTONE) {
                Waiter v15 = new Waiter();
                do {
                    v15.setNext(v6_1);
                    if(AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(v0, v6_1, v15)) {
                        break;
                    }

                    v6_1 = v0.waiters;
                    if(v6_1 != Waiter.TOMBSTONE) {
                        continue;
                    }

                    goto label_61;
                }
                while(true);

                do {
                    LockSupport.parkNanos(v0, v4);
                    if(Thread.interrupted()) {
                        goto label_54;
                    }

                    v4_1 = v0.value;
                    v5 = v4_1 != null ? 1 : 0;
                    if((v5 & (v4_1 instanceof SetFuture ^ 1)) != 0) {
                        return v0.getDoneValue(v4_1);
                    }

                    v4 = v11 - System.nanoTime();
                }
                while(v4 >= v13);

                v0.removeWaiter(v15);
                goto label_64;
            label_54:
                v0.removeWaiter(v15);
                throw new InterruptedException();
            }

        label_61:
            return v0.getDoneValue(v0.value);
        }

        while(true) {
        label_64:
            if(v4 <= v9_1) {
                goto label_84;
            }

            v4_1 = v0.value;
            v5 = v4_1 != null ? 1 : 0;
            if((v5 & (v4_1 instanceof SetFuture ^ 1)) != 0) {
                return v0.getDoneValue(v4_1);
            }

            if(Thread.interrupted()) {
                break;
            }

            v4 = v11 - System.nanoTime();
        }

        throw new InterruptedException();
    label_84:
        String v6_2 = v0.toString();
        String v7 = v3.toString().toLowerCase(Locale.ROOT);
        StringBuilder v1_1 = new StringBuilder("Waited ").append(v1);
        String v2 = " ";
        String v1_2 = v1_1.append(v2).append(v3.toString().toLowerCase(Locale.ROOT)).toString();
        if(v4 + v13 < v9_1) {
            v1_2 = v1_2 + " (plus ";
            v4 = -v4;
            v11 = v3.convert(v4, TimeUnit.NANOSECONDS);
            v4 -= v3.toNanos(v11);
            int v3_1 = Long.compare(v11, v9_1);
            int v16 = v3_1 == 0 || v4 > v13 ? 1 : 0;
            if(v3_1 > 0) {
                v1_2 = v1_2 + v11 + v2 + v7;
                if(v16 != 0) {
                    v1_2 = v1_2 + ",";
                }

                v1_2 = v1_2 + v2;
            }

            if(v16 != 0) {
                v1_2 = v1_2 + v4 + " nanoseconds ";
            }

            v1_2 = v1_2 + "delay)";
        }

        if(v0.isDone()) {
            throw new TimeoutException(v1_2 + " but future completed as timeout expired");
        }

        throw new TimeoutException(v1_2 + " for " + v6_2);
    label_174:
        throw new InterruptedException();
    }

    private Object getDoneValue(Object arg1) throws ExecutionException {
        if(!(arg1 instanceof Cancellation)) {
            if(!(arg1 instanceof Failure)) {
                if(arg1 == AbstractResolvableFuture.NULL) {
                    return null;
                }

                return arg1;
            }

            throw new ExecutionException(((Failure)arg1).exception);
        }

        throw AbstractResolvableFuture.cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)arg1).cause);
    }

    static Object getFutureValue(ListenableFuture arg5) {
        Object v2_1;
        Object v5;
        if((arg5 instanceof AbstractResolvableFuture)) {
            v5 = ((AbstractResolvableFuture)arg5).value;
            if((v5 instanceof Cancellation)) {
                Object v0 = v5;
                if(((Cancellation)v0).wasInterrupted) {
                    if(((Cancellation)v0).cause != null) {
                        return new Cancellation(false, ((Cancellation)v0).cause);
                    }
                    else {
                        Cancellation v5_1 = Cancellation.CAUSELESS_CANCELLED;
                    }
                }
            }

            return v5;
        }

        boolean v0_1 = arg5.isCancelled();
        if(((AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES ^ 1) & (((int)v0_1))) != 0) {
            return Cancellation.CAUSELESS_CANCELLED;
        }

        try {
            v2_1 = AbstractResolvableFuture.getUninterruptibly(((Future)arg5));
            if(v2_1 != null) {
                return v2_1;
            }

            return AbstractResolvableFuture.NULL;
        }
        catch(Throwable v5_2) {
            return new Failure(v5_2);
        }
        catch(CancellationException v2) {
            if(!v0_1) {
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + v5, ((Throwable)v2)));
            }

            return new Cancellation(false, ((Throwable)v2));
        }
        catch(ExecutionException v5_3) {
            return new Failure(v5_3.getCause());
        }

        return v2_1;
    }

    static Object getUninterruptibly(Future arg1) throws ExecutionException {
        // Method was not decompiled
    }

    protected void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    public final boolean isDone() {
        Object v2 = this.value;
        int v1 = v2 != null ? 1 : 0;
        return (v2 instanceof SetFuture ^ 1) & v1;
    }

    final void maybePropagateCancellationTo(Future arg3) {
        int v0 = arg3 != null ? 1 : 0;
        if((v0 & this.isCancelled()) != 0) {
            arg3.cancel(this.wasInterrupted());
        }
    }

    protected String pendingToString() {
        Object v0 = this.value;
        if((v0 instanceof SetFuture)) {
            return "setFuture=[" + this.userObjectToString(((SetFuture)v0).future) + "]";
        }

        if((this instanceof ScheduledFuture)) {
            return "remaining delay=[" + ((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }

        return null;
    }

    private void releaseWaiters() {
        Waiter v0;
        do {
            v0 = this.waiters;
        }
        while(!AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(this, v0, Waiter.TOMBSTONE));

        while(v0 != null) {
            v0.unpark();
            v0 = v0.next;
        }
    }

    private void removeWaiter(Waiter arg5) {
        Waiter v2;
        Thread v0 = null;
        arg5.thread = v0;
        while(true) {
        label_2:
            arg5 = this.waiters;
            if(arg5 != Waiter.TOMBSTONE) {
                Waiter v1 = ((Waiter)v0);
                while(true) {
                label_7:
                    if(arg5 != null) {
                        v2 = arg5.next;
                        if(arg5.thread != null) {
                            v1 = arg5;
                        }
                        else if(v1 != null) {
                            v1.next = v2;
                            if(v1.thread == null) {
                                goto label_2;
                            }
                        }
                        else if(!AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(this, arg5, v2)) {
                            goto label_2;
                        }

                        goto label_22;
                    }

                    return;
                }
            }
            else {
            }

            return;
        }

    label_22:
        arg5 = v2;
        goto label_7;
    }

    protected boolean set(Object arg3) {
        if(arg3 == null) {
            arg3 = AbstractResolvableFuture.NULL;
        }

        if(AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, null, arg3)) {
            AbstractResolvableFuture.complete(this);
            return 1;
        }

        return 0;
    }

    protected boolean setException(Throwable arg3) {
        if(AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, null, new Failure(AbstractResolvableFuture.checkNotNull(arg3)))) {
            AbstractResolvableFuture.complete(this);
            return 1;
        }

        return 0;
    }

    protected boolean setFuture(ListenableFuture arg6) {
        Failure v1;
        AbstractResolvableFuture.checkNotNull(arg6);
        Object v0 = this.value;
        if(v0 == null) {
            Object v3 = null;
            if(!arg6.isDone()) {
                SetFuture v0_1 = new SetFuture(this, arg6);
                if(AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, v3, v0_1)) {
                    try {
                        arg6.addListener(((Runnable)v0_1), DirectExecutor.INSTANCE);
                    }
                    catch(Throwable v6) {
                        try {
                            v1 = new Failure(v6);
                        }
                        catch(Throwable ) {
                            v1 = Failure.FALLBACK_INSTANCE;
                        }

                        AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, v0_1, v1);
                    }

                    return 1;
                }
                else {
                    v0 = this.value;
                }
            }
            else if(AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, v3, AbstractResolvableFuture.getFutureValue(arg6))) {
                AbstractResolvableFuture.complete(this);
                return 1;
            }
            else {
                return 0;
            }
        }

        if((v0 instanceof Cancellation)) {
            arg6.cancel(((Cancellation)v0).wasInterrupted);
        }

        return 0;
    }

    public String toString() {
        String v1_1;
        StringBuilder v0 = new StringBuilder().append(super.toString()).append("[status=");
        String v2 = "]";
        if(this.isCancelled()) {
            v0.append("CANCELLED");
            goto label_39;
        }

        if(this.isDone()) {
            this.addDoneString(v0);
            goto label_39;
        }

        try {
            v1_1 = this.pendingToString();
        }
        catch(RuntimeException v1) {
            v1_1 = "Exception thrown from implementation: " + v1.getClass();
        }

        if(v1_1 != null && !v1_1.isEmpty()) {
            v0.append("PENDING, info=[").append(v1_1).append(v2);
            goto label_39;
        }

        if(this.isDone()) {
            this.addDoneString(v0);
        }
        else {
            v0.append("PENDING");
        }

    label_39:
        return v0.append(v2).toString();
    }

    private String userObjectToString(Object arg1) {
        if((((AbstractResolvableFuture)arg1)) == this) {
            return "this future";
        }

        return String.valueOf(arg1);
    }

    protected final boolean wasInterrupted() {
        Object v1 = this.value;
        if(((v1 instanceof Cancellation)) && (((Cancellation)v1).wasInterrupted)) {
            return 1;
        }

        return 0;
    }
}

