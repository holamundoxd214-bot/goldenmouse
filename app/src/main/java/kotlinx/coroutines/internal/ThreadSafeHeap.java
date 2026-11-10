package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0017\u001A\u0004\u0018\u00018\u00002!\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0010\u001CJ\r\u0010\u001D\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001EJ\r\u0010\u001F\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001EJ$\u0010 \u001A\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b¢\u0006\u0002\u0010\u001CJ\u0013\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00028\u0000¢\u0006\u0002\u0010$J,\u0010%\u001A\u00020\u00152\u0006\u0010#\u001A\u00028\u00002\u0014\u0010&\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b¢\u0006\u0002\u0010\'J\u0013\u0010(\u001A\u00020\u00152\u0006\u0010#\u001A\u00028\u0000¢\u0006\u0002\u0010)J\u000F\u0010*\u001A\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001EJ\u0015\u0010+\u001A\u00028\u00002\u0006\u0010,\u001A\u00020\u000EH\u0001¢\u0006\u0002\u0010-J\u0015\u0010.\u001A\u00020\"2\u0006\u0010#\u001A\u00028\u0000H\u0001¢\u0006\u0002\u0010$J\u0011\u0010/\u001A\u00020\"2\u0006\u00100\u001A\u00020\u000EH\u0082\u0010J\u0011\u00101\u001A\u00020\"2\u0006\u00100\u001A\u00020\u000EH\u0082\u0010J\u0015\u00102\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tH\u0002¢\u0006\u0002\u00103J\u0018\u00104\u001A\u00020\"2\u0006\u00100\u001A\u00020\u000E2\u0006\u00105\u001A\u00020\u000EH\u0002R\u001A\u0010\b\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\nR\t\u0010\u000B\u001A\u00020\fX\u0082\u0004R$\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E8F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0016¨\u00066"}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "_size", "Lkotlinx/atomicfu/AtomicInt;", "value", "", "size", "getSize", "()I", "setSize", "(I)V", "isEmpty", "", "()Z", "find", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "removeFirstIf", "addLast", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLastIf", "cond", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "siftUpFrom", "i", "siftDownFrom", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "swap", "j", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class ThreadSafeHeap {
    private ThreadSafeHeapNode[] a;

    static {
        ThreadSafeHeap._size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    }

    public ThreadSafeHeap() {
        super();
    }

    public final void addImpl(ThreadSafeHeapNode arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg4.getHeap() == null) {
            }
            else {
                throw new AssertionError();
            }
        }

        arg4.setHeap(this);
        ThreadSafeHeapNode[] v0 = this.realloc();
        int v1 = this.getSize();
        this.setSize(v1 + 1);
        v0[v1] = arg4;
        arg4.setIndex(v1);
        this.siftUpFrom(v1);
    }

    public final void addLast(ThreadSafeHeapNode arg1) {
        __monitor_enter(this);
        try {
            this.addImpl(arg1);
        }
        catch(Throwable v1) {
            __monitor_exit(this);
            throw v1;
        }

        __monitor_exit(this);
    }

    public final boolean addLastIf(ThreadSafeHeapNode arg2, Function1 arg3) {
        boolean v2_1;
        __monitor_enter(this);
        try {
            if(arg3.invoke(this.firstImpl()).booleanValue()) {
                this.addImpl(arg2);
                v2_1 = true;
            }
            else {
                goto label_8;
            }

            goto label_9;
        }
        catch(Throwable v2) {
            __monitor_exit(this);
            throw v2;
        }

    label_8:
        v2_1 = false;
    label_9:
        __monitor_exit(this);
        return v2_1;
    }

    public final ThreadSafeHeapNode find(Function1 arg5) {
        Object v2;
        int v1;
        __monitor_enter(this);
        try {
            int v0 = this.getSize();
            v1 = 0;
            while(true) {
            label_3:
                v2 = null;
                if(v1 < v0) {
                    ThreadSafeHeapNode[] v3 = this.a;
                    if(v3 != null) {
                        ThreadSafeHeapNode v2_1 = v3[v1];
                    }

                    Intrinsics.checkNotNull(v2);
                    if(!arg5.invoke(v2).booleanValue()) {
                        goto label_13;
                    }

                    break;
                }

                goto label_15;
            }
        }
        catch(Throwable v5) {
            goto label_18;
        }

        goto label_15;
    label_13:
        ++v1;
        goto label_3;
    label_15:
        __monitor_exit(this);
        return ((ThreadSafeHeapNode)v2);
    label_18:
        __monitor_exit(this);
        throw v5;
    }

    public final ThreadSafeHeapNode firstImpl() {
        ThreadSafeHeapNode[] v1 = this.a;
        if(v1 != null) {
            return v1[0];
        }

        return null;
    }

    public final int getSize() {
        return ThreadSafeHeap.get_size$volatile$FU().get(this);
    }

    private final int get_size$volatile() {
        return this._size$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_size$volatile$FU() {
        return ThreadSafeHeap._size$volatile$FU;
    }

    public final boolean isEmpty() {
        if(this.getSize() == 0) {
            return 1;
        }

        return 0;
    }

    public final ThreadSafeHeapNode peek() {
        ThreadSafeHeapNode v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.firstImpl();
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    private final ThreadSafeHeapNode[] realloc() {
        ThreadSafeHeapNode[] v0 = this.a;
        if(v0 == null) {
            v0 = new ThreadSafeHeapNode[4];
            this.a = v0;
            return v0;
        }

        if(this.getSize() >= v0.length) {
            Object[] v0_1 = Arrays.copyOf(((Object[])v0), this.getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(v0_1, "copyOf(...)");
            this.a = ((ThreadSafeHeapNode[])v0_1);
        }

        return v0;
    }

    public final boolean remove(ThreadSafeHeapNode arg2) {
        boolean v2_1;
        __monitor_enter(this);
        try {
            if(arg2.getHeap() == null) {
                v2_1 = false;
            }
            else {
                int v2_2 = arg2.getIndex();
                if(DebugKt.getASSERTIONS_ENABLED()) {
                    if(v2_2 >= 0) {
                    }
                    else {
                        throw new AssertionError();
                    }
                }

                this.removeAtImpl(v2_2);
                v2_1 = true;
            }
        }
        catch(Throwable v2) {
            __monitor_exit(this);
            throw v2;
        }

        __monitor_exit(this);
        return v2_1;
    }

    public final ThreadSafeHeapNode removeAtImpl(int arg6) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getSize() > 0) {
            }
            else {
                throw new AssertionError();
            }
        }

        ThreadSafeHeapNode[] v0 = this.a;
        Intrinsics.checkNotNull(v0);
        int v2 = -1;
        this.setSize(this.getSize() + v2);
        if(arg6 < this.getSize()) {
            this.swap(arg6, this.getSize());
            int v1 = (arg6 - 1) / 2;
            if(arg6 > 0) {
                ThreadSafeHeapNode v3 = v0[arg6];
                Intrinsics.checkNotNull(v3);
                ThreadSafeHeapNode v4 = v0[v1];
                Intrinsics.checkNotNull(v4);
                if(((Comparable)v3).compareTo(v4) < 0) {
                    this.swap(arg6, v1);
                    this.siftUpFrom(v1);
                    goto label_31;
                }
            }

            this.siftDownFrom(arg6);
        }

    label_31:
        ThreadSafeHeapNode v6 = v0[this.getSize()];
        Intrinsics.checkNotNull(v6);
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(v6.getHeap() == this) {
            }
            else {
                throw new AssertionError();
            }
        }

        v6.setHeap(null);
        v6.setIndex(v2);
        v0[this.getSize()] = null;
        return v6;
    }

    public final ThreadSafeHeapNode removeFirstIf(Function1 arg3) {
        ThreadSafeHeapNode v1;
        __monitor_enter(this);
        try {
            ThreadSafeHeapNode v0 = this.firstImpl();
            v1 = null;
            if(v0 != null) {
                goto label_6;
            }
        }
        catch(Throwable v3) {
            goto label_14;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_6:
            if(arg3.invoke(v0).booleanValue()) {
                v1 = this.removeAtImpl(0);
            }
        }
        catch(Throwable v3) {
        label_14:
            __monitor_exit(this);
            throw v3;
        }

        __monitor_exit(this);
        return v1;
    }

    public final ThreadSafeHeapNode removeFirstOrNull() {
        ThreadSafeHeapNode v0_1;
        __monitor_enter(this);
        try {
            if(this.getSize() > 0) {
                v0_1 = this.removeAtImpl(0);
            }
            else {
                goto label_6;
            }

            goto label_7;
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

    label_6:
        v0_1 = null;
    label_7:
        __monitor_exit(this);
        return v0_1;
    }

    private final void setSize(int arg2) {
        ThreadSafeHeap.get_size$volatile$FU().set(this, arg2);
    }

    private final void set_size$volatile(int arg1) {
        this._size$volatile = arg1;
    }

    private final void siftDownFrom(int arg6) {
        while(true) {
            int v0 = arg6 * 2;
            int v1 = v0 + 1;
            if(v1 >= this.getSize()) {
                return;
            }

            ThreadSafeHeapNode[] v2 = this.a;
            Intrinsics.checkNotNull(v2);
            v0 += 2;
            if(v0 < this.getSize()) {
                ThreadSafeHeapNode v3 = v2[v0];
                Intrinsics.checkNotNull(v3);
                ThreadSafeHeapNode v4 = v2[v1];
                Intrinsics.checkNotNull(v4);
                if(((Comparable)v3).compareTo(v4) < 0) {
                }
                else {
                    goto label_17;
                }
            }
            else {
            label_17:
                v0 = v1;
            }

            ThreadSafeHeapNode v1_1 = v2[arg6];
            Intrinsics.checkNotNull(v1_1);
            ThreadSafeHeapNode v2_1 = v2[v0];
            Intrinsics.checkNotNull(v2_1);
            if(((Comparable)v1_1).compareTo(v2_1) <= 0) {
                return;
            }

            this.swap(arg6, v0);
            arg6 = v0;
        }
    }

    private final void siftUpFrom(int arg4) {
        while(true) {
            if(arg4 > 0) {
                ThreadSafeHeapNode[] v0 = this.a;
                Intrinsics.checkNotNull(v0);
                int v1 = (arg4 - 1) / 2;
                ThreadSafeHeapNode v2 = v0[v1];
                Intrinsics.checkNotNull(v2);
                ThreadSafeHeapNode v0_1 = v0[arg4];
                Intrinsics.checkNotNull(v0_1);
                if(((Comparable)v2).compareTo(v0_1) > 0) {
                    this.swap(arg4, v1);
                    arg4 = v1;
                    continue;
                }
            }
            else {
            }

            return;
        }
    }

    private final void swap(int arg3, int arg4) {
        ThreadSafeHeapNode[] v2 = this.a;
        Intrinsics.checkNotNull(v2);
        ThreadSafeHeapNode v0 = v2[arg4];
        Intrinsics.checkNotNull(v0);
        ThreadSafeHeapNode v1 = v2[arg3];
        Intrinsics.checkNotNull(v1);
        v2[arg3] = v0;
        v2[arg4] = v1;
        v0.setIndex(arg3);
        v1.setIndex(arg4);
    }
}

