package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002-.B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0016\u001A\u00020\u0006J\u0013\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00028\u0000¢\u0006\u0002\u0010\u0019J1\u0010\u001A\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f2\u0006\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001CJ\b\u0010\u001D\u001A\u0004\u0018\u00010\u0002J,\u0010\u001E\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f2\u0006\u0010\u001F\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\u0004H\u0002J\f\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010\"\u001A\u00020#H\u0002J \u0010$\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\f2\u0006\u0010%\u001A\u00020#H\u0002J \u0010&\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\f2\u0006\u0010%\u001A\u00020#H\u0002J&\u0010\'\u001A\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0001\u0010)2\u0012\u0010*\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+J\u0006\u0010,\u001A\u00020\u0006R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\n\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f0\u000BX\u0082\u0004R\t\u0010\r\u001A\u00020\u000EX\u0082\u0004R\u0011\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010X\u0082\u0004R\u0011\u0010\u0011\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006/"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "<init>", "(IZ)V", "mask", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "size", "getSize", "()I", "close", "addLast", "element", "(Ljava/lang/Object;)I", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "next", "markFrozen", "", "allocateOrGetNextCopy", "state", "allocateNextCopy", "map", "", "R", "transform", "Lkotlin/Function1;", "isClosed", "Placeholder", "Companion", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LockFreeTaskQueueCore {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0017\u001A\u00020\n*\u00020\n2\u0006\u0010\u0018\u001A\u00020\nH\u0086\u0004J\u0012\u0010\u0019\u001A\u00020\n*\u00020\n2\u0006\u0010\u001A\u001A\u00020\u0005J\u0012\u0010\u001B\u001A\u00020\n*\u00020\n2\u0006\u0010\u001C\u001A\u00020\u0005JP\u0010\u001D\u001A\u0002H\u001E\"\u0004\b\u0001\u0010\u001E*\u00020\n26\u0010\u001F\u001A2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u001E0 H\u0086\b¢\u0006\u0002\u0010%J\n\u0010&\u001A\u00020\u0005*\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "<init>", "()V", "INITIAL_CAPACITY", "", "CAPACITY_BITS", "MAX_CAPACITY_MASK", "HEAD_SHIFT", "HEAD_MASK", "", "TAIL_SHIFT", "TAIL_MASK", "FROZEN_SHIFT", "FROZEN_MASK", "CLOSED_SHIFT", "CLOSED_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "ADD_SUCCESS", "ADD_FROZEN", "ADD_CLOSED", "wo", "other", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "addFailReason", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int addFailReason(long arg3) {
            if((arg3 & 0x2000000000000000L) != 0) {
                return 2;
            }

            return 1;
        }

        public final long updateHead(long arg3, int arg5) {
            return this.wo(arg3, 0x3FFFFFFF) | (((long)arg5));
        }

        public final long updateTail(long arg3, int arg5) {
            return this.wo(arg3, 0xFFFFFFFC0000000L) | (((long)arg5)) << 30;
        }

        public final Object withState(long arg3, Function2 arg5) {
            return arg5.invoke(Integer.valueOf(((int)(0x3FFFFFFF & arg3))), Integer.valueOf(((int)((arg3 & 0xFFFFFFFC0000000L) >> 30))));
        }

        public final long wo(long arg1, long arg3) {
            return arg1 & ~arg3;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "<init>", "(I)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Placeholder {
        public final int index;

        public Placeholder(int arg1) {
            super();
            this.index = arg1;
        }
    }

    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 0x2000000000000000L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = null;
    public static final long FROZEN_MASK = 0x1000000000000000L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 0x3FFFFFFF;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 0x3FFFFFFF;
    public static final int MIN_ADD_SPIN_CAPACITY = 0x400;
    public static final Symbol REMOVE_FROZEN = null;
    public static final long TAIL_MASK = 0xFFFFFFFC0000000L;
    public static final int TAIL_SHIFT = 30;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    static {
        LockFreeTaskQueueCore.Companion = new Companion(null);
        Class v0 = Object.class;
        Class v2 = LockFreeTaskQueueCore.class;
        LockFreeTaskQueueCore._next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_next$volatile");
        LockFreeTaskQueueCore._state$volatile$FU = AtomicLongFieldUpdater.newUpdater(v2, "_state$volatile");
        LockFreeTaskQueueCore.REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    }

    public LockFreeTaskQueueCore(int arg2, boolean arg3) {
        super();
        this.capacity = arg2;
        this.singleConsumer = arg3;
        int v3 = arg2 - 1;
        this.mask = v3;
        this.array = new AtomicReferenceArray(arg2);
        String v0 = "Check failed.";
        if(v3 <= 0x3FFFFFFF) {
            if((arg2 & v3) == 0) {
                return;
            }

            throw new IllegalStateException(v0);
        }

        throw new IllegalStateException(v0);
    }

    public final int addLast(Object arg14) {
        int v9;
        long v3;
        AtomicLongFieldUpdater v0 = LockFreeTaskQueueCore.get_state$volatile$FU();
        while(true) {
            v3 = v0.get(this);
            long v7 = 0;
            if((0x3000000000000000L & v3) != v7) {
                break;
            }

            Companion v1 = LockFreeTaskQueueCore.Companion;
            int v2 = ((int)(0x3FFFFFFF & v3));
            v9 = ((int)((0xFFFFFFFC0000000L & v3) >> 30));
            int v10 = this.mask;
            if((v9 + 2 & v10) == (v2 & v10)) {
                return 1;
            }

            int v6 = 0x3FFFFFFF;
            if(!this.singleConsumer && this.getArray().get(v9 & v10) != null) {
                int v1_1 = this.capacity;
                if(v1_1 >= 0x400 && (v9 - v2 & v6) <= v1_1 >> 1) {
                    continue;
                }

                return 1;
            }

            LockFreeTaskQueueCore v2_1 = this;
            if(LockFreeTaskQueueCore.get_state$volatile$FU().compareAndSet(v2_1, v3, v1.updateTail(v3, v9 + 1 & v6))) {
                v2_1.getArray().set(v9 & v10, arg14);
                this = v2_1;
                goto label_52;
            }

            this = v2_1;
        }

        return LockFreeTaskQueueCore.Companion.addFailReason(v3);
        do {
        label_52:
            if((LockFreeTaskQueueCore.get_state$volatile$FU().get(this) & 0x1000000000000000L) == v7) {
                return 0;
            }

            this = this.next().fillPlaceholder(v9, arg14);
        }
        while(this != null);

        return 0;
    }

    private final LockFreeTaskQueueCore allocateNextCopy(long arg7) {
        Placeholder v3_1;
        LockFreeTaskQueueCore v0 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
        int v1 = ((int)(0x3FFFFFFF & arg7));
        int v2 = ((int)((0xFFFFFFFC0000000L & arg7) >> 30));
        while((v1 & this.mask) != (this.mask & v2)) {
            Object v3 = this.getArray().get(this.mask & v1);
            if(v3 == null) {
                v3_1 = new Placeholder(v1);
            }

            v0.getArray().set(v0.mask & v1, v3_1);
            ++v1;
        }

        LockFreeTaskQueueCore.get_state$volatile$FU().set(v0, LockFreeTaskQueueCore.Companion.wo(arg7, 0x1000000000000000L));
        return v0;
    }

    private final LockFreeTaskQueueCore allocateOrGetNextCopy(long arg5) {
        Object v1;
        AtomicReferenceFieldUpdater v0 = LockFreeTaskQueueCore.get_next$volatile$FU();
        while(true) {
            v1 = v0.get(this);
            if(v1 != null) {
                break;
            }

            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueueCore.get_next$volatile$FU(), this, null, this.allocateNextCopy(arg5));
        }

        return ((LockFreeTaskQueueCore)v1);
    }

    public final boolean close() {
        AtomicLongFieldUpdater v0 = LockFreeTaskQueueCore.get_state$volatile$FU();
        while(true) {
            long v2 = v0.get(this);
            long v4 = 0x2000000000000000L;
            long v8 = 0;
            if(Long.compare(v2 & v4, v8) != 0) {
                return 1;
            }

            if((0x1000000000000000L & v2) != v8) {
                return 0;
            }

            LockFreeTaskQueueCore v1 = this;
            if(v0.compareAndSet(v1, v2, v4 | v2)) {
                return 1;
            }

            this = v1;
        }

        return 1;
    }

    private final LockFreeTaskQueueCore fillPlaceholder(int arg3, Object arg4) {
        Object v0 = this.getArray().get(this.mask & arg3);
        if(((v0 instanceof Placeholder)) && ((Placeholder)v0).index == arg3) {
            this.getArray().set(arg3 & this.mask, arg4);
            return this;
        }

        return null;
    }

    private final AtomicReferenceArray getArray() {
        return this.array;
    }

    public final int getSize() {
        long v0 = LockFreeTaskQueueCore.get_state$volatile$FU().get(this);
        return 0x3FFFFFFF & (((int)((v0 & 0xFFFFFFFC0000000L) >> 30))) - (((int)(0x3FFFFFFF & v0)));
    }

    private final Object get_next$volatile() {
        return this._next$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_next$volatile$FU() {
        return LockFreeTaskQueueCore._next$volatile$FU;
    }

    private final long get_state$volatile() {
        return this._state$volatile;
    }

    private static final AtomicLongFieldUpdater get_state$volatile$FU() {
        return LockFreeTaskQueueCore._state$volatile$FU;
    }

    public final boolean isClosed() {
        if((LockFreeTaskQueueCore.get_state$volatile$FU().get(this) & 0x2000000000000000L) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isEmpty() {
        long v0 = LockFreeTaskQueueCore.get_state$volatile$FU().get(this);
        if((((int)(0x3FFFFFFF & v0))) == (((int)((v0 & 0xFFFFFFFC0000000L) >> 30)))) {
            return 1;
        }

        return 0;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater arg3, Object arg4, Function1 arg5) {
        while(true) {
            arg5.invoke(Long.valueOf(arg3.get(arg4)));
        }
    }

    public final List map(Function1 arg7) {
        ArrayList v0 = new ArrayList(this.capacity);
        long v1 = LockFreeTaskQueueCore.get_state$volatile$FU().get(this);
        int v3 = ((int)(0x3FFFFFFF & v1));
        int v1_1 = ((int)((v1 & 0xFFFFFFFC0000000L) >> 30));
        while((v3 & this.mask) != (this.mask & v1_1)) {
            Object v2 = this.getArray().get(this.mask & v3);
            if(v2 != null && !(v2 instanceof Placeholder)) {
                v0.add(arg7.invoke(v2));
            }

            ++v3;
        }

        return ((List)v0);
    }

    private final long markFrozen() {
        long v2;
        AtomicLongFieldUpdater v0 = LockFreeTaskQueueCore.get_state$volatile$FU();
        while(true) {
            v2 = v0.get(this);
            long v4 = 0x1000000000000000L;
            if((v2 & v4) != 0) {
                return v2;
            }

            v4 |= v2;
            LockFreeTaskQueueCore v1 = this;
            if(v0.compareAndSet(v1, v2, v4)) {
                return v4;
            }

            this = v1;
        }

        return v2;
    }

    public final LockFreeTaskQueueCore next() {
        return this.allocateOrGetNextCopy(this.markFrozen());
    }

    public final Object removeFirstOrNull() {
        int v10;
        Object v9;
        int v7;
        AtomicLongFieldUpdater v0 = LockFreeTaskQueueCore.get_state$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            if((0x1000000000000000L & v3) != 0) {
                break;
            }

            Companion v1 = LockFreeTaskQueueCore.Companion;
            v7 = ((int)(0x3FFFFFFF & v3));
            Object v8 = null;
            if(((((int)((0xFFFFFFFC0000000L & v3) >> 30))) & this.mask) == (this.mask & v7)) {
                return v8;
            }

            v9 = this.getArray().get(this.mask & v7);
            if(v9 == null) {
                if(!this.singleConsumer) {
                    continue;
                }

                return v8;
            }

            if((v9 instanceof Placeholder)) {
                return v8;
            }

            v10 = v7 + 1 & 0x3FFFFFFF;
            Companion v2 = v1;
            AtomicLongFieldUpdater v1_1 = LockFreeTaskQueueCore.get_state$volatile$FU();
            long v5 = v2.updateHead(v3, v10);
            LockFreeTaskQueueCore v2_1 = this;
            if(v1_1.compareAndSet(v2_1, v3, v5)) {
                v2_1.getArray().set(v2_1.mask & v7, v8);
                return v9;
            }

            if(v2_1.singleConsumer) {
                this = v2_1;
                goto label_51;
            }

            this = v2_1;
        }

        return LockFreeTaskQueueCore.REMOVE_FROZEN;
        do {
        label_51:
            this = this.removeSlowPath(v7, v10);
        }
        while(this != null);

        return v9;
    }

    private final LockFreeTaskQueueCore removeSlowPath(int arg11, int arg12) {
        AtomicLongFieldUpdater v0 = LockFreeTaskQueueCore.get_state$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            Companion v1 = LockFreeTaskQueueCore.Companion;
            int v7 = ((int)(0x3FFFFFFF & v3));
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(v7 == arg11) {
                }
                else {
                    throw new AssertionError();
                }
            }

            if((0x1000000000000000L & v3) != 0) {
                return this.next();
            }

            Companion v2 = v1;
            AtomicLongFieldUpdater v1_1 = LockFreeTaskQueueCore.get_state$volatile$FU();
            long v5 = v2.updateHead(v3, arg12);
            LockFreeTaskQueueCore v2_1 = this;
            if(v1_1.compareAndSet(v2_1, v3, v5)) {
                v2_1.getArray().set(v2_1.mask & v7, null);
                return null;
            }

            this = v2_1;
        }
    }

    private final void set_next$volatile(Object arg1) {
        this._next$volatile = arg1;
    }

    private final void set_state$volatile(long arg1) {
        this._state$volatile = arg1;
    }

    private final void update$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater arg7, Object arg8, Function1 arg9) {
        while(true) {
            long v2 = arg7.get(arg8);
            AtomicLongFieldUpdater v0 = arg7;
            Object v1 = arg8;
            if(v0.compareAndSet(v1, v2, arg9.invoke(Long.valueOf(v2)).longValue())) {
                return;
            }

            arg7 = v0;
            arg8 = v1;
        }
    }

    private final long updateAndGet$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater arg7, Object arg8, Function1 arg9) {
        Object v6;
        while(true) {
            long v2 = arg7.get(arg8);
            v6 = arg9.invoke(Long.valueOf(v2));
            AtomicLongFieldUpdater v0 = arg7;
            Object v1 = arg8;
            if(v0.compareAndSet(v1, v2, ((Number)v6).longValue())) {
                break;
            }

            arg7 = v0;
            arg8 = v1;
        }

        return ((Number)v6).longValue();
    }
}

