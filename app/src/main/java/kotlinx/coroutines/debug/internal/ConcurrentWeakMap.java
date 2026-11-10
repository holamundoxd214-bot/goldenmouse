package kotlinx.coroutines.debug.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0003)*+B\u0011\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u0015\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u001F\u0010\u0018\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001AJ\u0017\u0010\u001B\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J!\u0010\u001C\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001A\u00028\u00002\b\u0010\u0019\u001A\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0002\u0010\u001AJ\b\u0010$\u001A\u00020\u0014H\u0016J\u0006\u0010%\u001A\u00020\u0014J\u0014\u0010&\u001A\u00020\u00142\n\u0010\'\u001A\u0006\u0012\u0002\b\u00030(H\u0002R\t\u0010\t\u001A\u00020\nX\u0082\u0004R\u001F\u0010\u000B\u001A\u0018\u0012\u0014\u0012\u00120\rR\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\fX\u0082\u0004R\u0016\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R&\u0010!\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"0\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010 ¨\u0006,"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "K", "", "V", "Lkotlin/collections/AbstractMutableMap;", "weakRefQueue", "", "<init>", "(Z)V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "core", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "Ljava/lang/ref/ReferenceQueue;", "size", "", "getSize", "()I", "decrementSize", "", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "putSynchronized", "keys", "", "getKeys", "()Ljava/util/Set;", "entries", "", "getEntries", "clear", "runWeakRefQueueCleaningLoopUntilInterrupted", "cleanWeakRef", "w", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ConcurrentWeakMap extends AbstractMutableMap {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H\u0002J\u0015\u0010\u0010\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001A\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000E\u001A\u00020\u0003H\u0002J1\u0010\u0015\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001A\u00028\u00002\b\u0010\u0016\u001A\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0017\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001A\u00120\u0000R\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001AJ\u0012\u0010\u001B\u001A\u00020\u00142\n\u0010\u001C\u001A\u0006\u0012\u0002\b\u00030\fJ,\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u001F0\u001E\"\u0004\b\u0002\u0010\u001F2\u0018\u0010 \u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u001F0!R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\b\u001A\u00020\tX\u0082\u0004R\u0017\u0010\n\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000BX\u0082\u0004R\u0011\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000BX\u0082\u0004¨\u0006#"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "shift", "threshold", "load", "Lkotlinx/atomicfu/AtomicInt;", "keys", "Lkotlinx/atomicfu/AtomicArray;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "values", "index", "hash", "getImpl", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "removeCleanedAt", "", "putImpl", "value", "weakKey0", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "rehash", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "cleanWeakRef", "weakRef", "keyValueIterator", "", "E", "factory", "Lkotlin/Function2;", "KeyValueIterator", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Core {
        @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0018\u0010\u0003\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001A\u00020\rH\u0002J\t\u0010\u000E\u001A\u00020\u000FH\u0096\u0002J\u000E\u0010\u0010\u001A\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0013H\u0016R \u0010\u0003\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000B\u001A\u00028\u0001X\u0082.¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0014"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "factory", "Lkotlin/Function2;", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", "", "key", "Ljava/lang/Object;", "value", "findNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class KeyValueIterator implements Iterator, KMutableIterator {
            private final Function2 factory;
            private int index;
            private Object key;
            private Object value;

            public KeyValueIterator(Core arg1, Function2 arg2) {
                Core.this = arg1;
                super();
                this.factory = arg2;
                this.index = -1;
                this.findNext();
            }

            private final void findNext() {
                Object v0_1;
                do {
                    int v0 = this.index + 1;
                    this.index = v0;
                    if(v0 < Core.this.allocated) {
                        v0_1 = Core.this.getKeys().get(this.index);
                        if(v0_1 == null) {
                            continue;
                        }

                        v0_1 = ((HashedWeakRef)v0_1).get();
                        if(v0_1 == null) {
                            continue;
                        }
                        else {
                            this.key = v0_1;
                            v0_1 = Core.this.getValues().get(this.index);
                            if((v0_1 instanceof Marked)) {
                                v0_1 = ((Marked)v0_1).ref;
                            }

                            if(v0_1 == null) {
                                continue;
                            }

                            break;
                        }
                    }

                    return;
                }
                while(true);

                this.value = v0_1;
            }

            public boolean hasNext() {
                if(this.index < Core.this.allocated) {
                    return 1;
                }

                return 0;
            }

            public Object next() {
                if(this.index < Core.this.allocated) {
                    Function2 v0 = this.factory;
                    Object v1 = this.key;
                    if(v1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("key");
                        Unit v1_1 = Unit.INSTANCE;
                    }

                    Object v2 = this.value;
                    if(v2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("value");
                        Unit v2_1 = Unit.INSTANCE;
                    }

                    Object v0_1 = v0.invoke(v1, v2);
                    this.findNext();
                    return v0_1;
                }

                throw new NoSuchElementException();
            }

            public Void remove() {
                ConcurrentWeakMapKt.access$noImpl();
                throw new KotlinNothingValueException();
            }

            public void remove() {
                this.remove();
            }
        }

        private final int allocated;
        private final int shift;
        private final int threshold;

        static {
            Core.load$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load$volatile");
        }

        public Core(ConcurrentWeakMap arg1, int arg2) {
            ConcurrentWeakMap.this = arg1;
            super();
            this.allocated = arg2;
            this.shift = Integer.numberOfLeadingZeros(arg2) + 1;
            this.threshold = arg2 * 2 / 3;
            this.keys = new AtomicReferenceArray(arg2);
            this.values = new AtomicReferenceArray(arg2);
        }

        public static final int access$getAllocated$p(Core arg0) {
            return arg0.allocated;
        }

        public static final AtomicReferenceArray access$getKeys(Core arg0) {
            return arg0.getKeys();
        }

        public static final AtomicReferenceArray access$getValues(Core arg0) {
            return arg0.getValues();
        }

        public final void cleanWeakRef(HashedWeakRef arg3) {
            int v0;
            for(v0 = this.index(arg3.hash); true; --v0) {
                Object v1 = this.getKeys().get(v0);
                if(v1 == null) {
                    return;
                }

                if((((HashedWeakRef)v1)) == arg3) {
                    this.removeCleanedAt(v0);
                    return;
                }

                if(v0 == 0) {
                    v0 = this.allocated;
                }
            }
        }

        public final Object getImpl(Object arg4) {
            int v0;
            for(v0 = this.index(arg4.hashCode()); true; --v0) {
                Object v1 = this.getKeys().get(v0);
                if(v1 == null) {
                    return null;
                }

                v1 = ((HashedWeakRef)v1).get();
                if(Intrinsics.areEqual(arg4, v1)) {
                    Object v3 = this.getValues().get(v0);
                    if((v3 instanceof Marked)) {
                        v3 = ((Marked)v3).ref;
                    }

                    return v3;
                }

                if(v1 == null) {
                    this.removeCleanedAt(v0);
                }

                if(v0 == 0) {
                    v0 = this.allocated;
                }
            }

            return null;
        }

        private final AtomicReferenceArray getKeys() {
            return this.keys;
        }

        private final int getLoad$volatile() {
            return this.load$volatile;
        }

        private static final AtomicIntegerFieldUpdater getLoad$volatile$FU() {
            return Core.load$volatile$FU;
        }

        private final AtomicReferenceArray getValues() {
            return this.values;
        }

        private final int index(int arg2) {
            return arg2 * -1640531527 >>> this.shift;
        }

        public final Iterator keyValueIterator(Function2 arg2) {
            return new KeyValueIterator(this, arg2);
        }

        public final Object putImpl(Object arg6, Object arg7, HashedWeakRef arg8) {
            Object v2;
            int v0 = this.index(arg6.hashCode());
            int v1 = 0;
            while(true) {
            label_3:
                v2 = this.getKeys().get(v0);
                if(v2 != null) {
                    v2 = ((HashedWeakRef)v2).get();
                    if(!Intrinsics.areEqual(arg6, v2)) {
                        if(v2 == null) {
                            this.removeCleanedAt(v0);
                        }

                        if(v0 == 0) {
                            v0 = this.allocated;
                        }

                        --v0;
                        continue;
                    }
                    else if(v1 != 0) {
                        Core.getLoad$volatile$FU().decrementAndGet(this);
                    }
                }
                else {
                    break;
                }

                goto label_35;
            }

            v2 = null;
            if(arg7 == null) {
                return v2;
            }

            if(v1 == 0) {
                AtomicIntegerFieldUpdater v3 = Core.getLoad$volatile$FU();
                do {
                    v1 = v3.get(this);
                    if(v1 < this.threshold) {
                        if(!v3.compareAndSet(this, v1, v1 + 1)) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_14;
                    }
                }
                while(true);

                v1 = 1;
                goto label_20;
            label_14:
                return ConcurrentWeakMapKt.access$getREHASH$p();
            }

        label_20:
            if(arg8 == null) {
                arg8 = new HashedWeakRef(arg6, ConcurrentWeakMap.this.weakRefQueue);
            }

            if(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.getKeys(), v0, v2, arg8)) {
                goto label_3;
            }

            do {
            label_35:
                arg6 = this.getValues().get(v0);
                if((arg6 instanceof Marked)) {
                    goto label_39;
                }
            }
            while(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.getValues(), v0, arg6, arg7));

            return arg6;
        label_39:
            return ConcurrentWeakMapKt.access$getREHASH$p();
        }

        public static Object putImpl$default(Core arg0, Object arg1, Object arg2, HashedWeakRef arg3, int arg4, Object arg5) {
            if((arg4 & 4) != 0) {
                arg3 = null;
            }

            return arg0.putImpl(arg1, arg2, arg3);
        }

        public final Core rehash() {
            Object v5;
            int v2;
            Core v1;
            do {
            label_0:
                v1 = new Core(ConcurrentWeakMap.this, Integer.highestOneBit(RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4)) * 4);
                int v0 = this.allocated;
                v2 = 0;
                while(true) {
                label_11:
                    if(v2 >= v0) {
                        return v1;
                    }

                    Object v3 = this.getKeys().get(v2);
                    Object v4 = v3 != null ? ((HashedWeakRef)v3).get() : null;
                    if(v3 != null && v4 == null) {
                        this.removeCleanedAt(v2);
                    }

                    do {
                        v5 = this.getValues().get(v2);
                        if((v5 instanceof Marked)) {
                            break;
                        }
                        else if(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.getValues(), v2, v5, ConcurrentWeakMapKt.access$mark(v5))) {
                            continue;
                        }

                        goto label_31;
                    }
                    while(true);

                    v5 = ((Marked)v5).ref;
                label_31:
                    if(v4 != null && v5 != null && v1.putImpl(v4, v5, ((HashedWeakRef)v3)) == ConcurrentWeakMapKt.access$getREHASH$p()) {
                        goto label_0;
                    }

                    break;
                }
            }
            while(true);

            ++v2;
            goto label_11;
            return v1;
        }

        private final void removeCleanedAt(int arg4) {
            do {
                Object v0 = this.getValues().get(arg4);
                if(v0 == null) {
                }
                else if(!(v0 instanceof Marked)) {
                    if(!AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.getValues(), arg4, v0, null)) {
                        continue;
                    }

                    break;
                }

                return;
            }
            while(true);

            ConcurrentWeakMap.this.decrementSize();
        }

        private final void setLoad$volatile(int arg1) {
            this.load$volatile = arg1;
        }

        private final void update$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg2, Object arg3, Function1 arg4) {
            do {
                int v1 = arg2.get(arg3);
            }
            while(!arg2.compareAndSet(arg3, v1, arg4.invoke(Integer.valueOf(v1)).intValue()));
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\'\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00028\u0002\u0012\u0006\u0010\u0005\u001A\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001A\u00028\u00032\u0006\u0010\r\u001A\u00028\u0003H\u0016¢\u0006\u0002\u0010\u000ER\u0016\u0010\u0004\u001A\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001A\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Entry implements Map$Entry, kotlin.jvm.internal.markers.KMutableMap$Entry {
        private final Object key;
        private final Object value;

        public Entry(Object arg1, Object arg2) {
            super();
            this.key = arg1;
            this.value = arg2;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public Object setValue(Object arg1) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\u0018\u0010\u0003\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0002H\u0016¢\u0006\u0002\u0010\u000EJ\u000F\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00020\u0010H\u0096\u0002R \u0010\u0003\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u0011"}, d2={"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class KeyValueSet extends AbstractMutableSet {
        private final Function2 factory;

        public KeyValueSet(ConcurrentWeakMap arg1, Function2 arg2) {
            ConcurrentWeakMap.this = arg1;
            super();
            this.factory = arg2;
        }

        public boolean add(Object arg1) {
            ConcurrentWeakMapKt.access$noImpl();
            throw new KotlinNothingValueException();
        }

        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        public Iterator iterator() {
            return ConcurrentWeakMap.getCore$volatile$FU().get(ConcurrentWeakMap.this).keyValueIterator(this.factory);
        }
    }

    private final ReferenceQueue weakRefQueue;

    static {
        Class v1 = ConcurrentWeakMap.class;
        ConcurrentWeakMap._size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v1, "_size$volatile");
        ConcurrentWeakMap.core$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, Object.class, "core$volatile");
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public ConcurrentWeakMap(boolean arg1, int arg2, DefaultConstructorMarker arg3) {
        this(false);
    }

    public ConcurrentWeakMap(boolean arg3) {
        super();
        this.core$volatile = new Core(this, 16);
        ReferenceQueue v3 = arg3 ? new ReferenceQueue() : null;
        this.weakRefQueue = v3;
    }

    static final Map$Entry _get_entries_$lambda$1(Object arg1, Object arg2) {
        return new Entry(arg1, arg2);
    }

    static final Object _get_keys_$lambda$0(Object arg0, Object arg1) {
        return arg0;
    }

    public static final void access$decrementSize(ConcurrentWeakMap arg0) {
        arg0.decrementSize();
    }

    public static final AtomicReferenceFieldUpdater access$getCore$volatile$FU() {
        return ConcurrentWeakMap.getCore$volatile$FU();
    }

    public static final ReferenceQueue access$getWeakRefQueue$p(ConcurrentWeakMap arg0) {
        return arg0.weakRefQueue;
    }

    private final void cleanWeakRef(HashedWeakRef arg2) {
        ConcurrentWeakMap.getCore$volatile$FU().get(this).cleanWeakRef(arg2);
    }

    public void clear() {
        Iterator v0 = this.keySet().iterator();
        while(v0.hasNext()) {
            this.remove(v0.next());
        }
    }

    private final void decrementSize() {
        ConcurrentWeakMap.get_size$volatile$FU().decrementAndGet(this);
    }

    public Object get(Object arg2) {
        if(arg2 == null) {
            return null;
        }

        return ConcurrentWeakMap.getCore$volatile$FU().get(this).getImpl(arg2);
    }

    private final Object getCore$volatile() {
        return this.core$volatile;
    }

    private static final AtomicReferenceFieldUpdater getCore$volatile$FU() {
        return ConcurrentWeakMap.core$volatile$FU;
    }

    public Set getEntries() {
        return new KeyValueSet(this, new ConcurrentWeakMap$$ExternalSyntheticLambda1());
    }

    public Set getKeys() {
        return new KeyValueSet(this, new ConcurrentWeakMap$$ExternalSyntheticLambda0());
    }

    public int getSize() {
        return ConcurrentWeakMap.get_size$volatile$FU().get(this);
    }

    private final int get_size$volatile() {
        return this._size$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_size$volatile$FU() {
        return ConcurrentWeakMap._size$volatile$FU;
    }

    public Object put(Object arg8, Object arg9) {
        Object v2 = arg8;
        Object v3 = arg9;
        arg8 = Core.putImpl$default(ConcurrentWeakMap.getCore$volatile$FU().get(this), v2, v3, null, 4, null);
        if(arg8 == ConcurrentWeakMapKt.access$getREHASH$p()) {
            arg8 = this.putSynchronized(v2, v3);
        }

        if(arg8 == null) {
            ConcurrentWeakMap.get_size$volatile$FU().incrementAndGet(this);
        }

        return arg8;
    }

    private final Object putSynchronized(Object arg8, Object arg9) {
        Throwable v8;
        __monitor_enter(this);
        try {
            Object v1 = ConcurrentWeakMap.getCore$volatile$FU().get(this);
            while(true) {
                Object v2 = arg8;
                Object v3 = arg9;
                arg8 = Core.putImpl$default(((Core)v1), v2, v3, null, 4, null);
                if(arg8 != ConcurrentWeakMapKt.access$getREHASH$p()) {
                    break;
                }

                Core v1_1 = ((Core)v1).rehash();
                ConcurrentWeakMap.getCore$volatile$FU().set(this, v1_1);
                arg8 = v2;
                arg9 = v3;
            }
        }
        catch(Throwable v0) {
            goto label_21;
        }

        __monitor_exit(this);
        return arg8;
        try {
        label_21:
            v8 = v0;
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_21;
        }

        throw v8;
    }

    public Object remove(Object arg9) {
        Object v0 = null;
        if(arg9 == null) {
            return v0;
        }

        Object v3 = arg9;
        arg9 = Core.putImpl$default(ConcurrentWeakMap.getCore$volatile$FU().get(this), v3, null, null, 4, null);
        if(arg9 == ConcurrentWeakMapKt.access$getREHASH$p()) {
            arg9 = this.putSynchronized(v3, v0);
        }

        if(arg9 != null) {
            ConcurrentWeakMap.get_size$volatile$FU().decrementAndGet(this);
        }

        return arg9;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        if(this.weakRefQueue != null) {
            try {
                while(true) {
                    Reference v0 = this.weakRefQueue.remove();
                    Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    this.cleanWeakRef(((HashedWeakRef)v0));
                }
            }
            catch(InterruptedException ) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    }

    private final void setCore$volatile(Object arg1) {
        this.core$volatile = arg1;
    }

    private final void set_size$volatile(int arg1) {
        this._size$volatile = arg1;
    }
}

