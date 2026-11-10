package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001A\u00020\u0004H\u0082\bJ\r\u0010\u000E\u001A\u00020\u000F*\u00020\u0004H\u0082\bJ\u0006\u0010\u0010\u001A\u00020\u000FJ\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012J\r\u0010\u0013\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\u0014H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\t\u001A\u00020\nX\u0082\u0004R\u0011\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fX\u0082\u0004¨\u0006\u0017"}, d2={"Lkotlinx/coroutines/internal/OnDemandAllocatingPool;", "T", "", "maxCapacity", "", "create", "Lkotlin/Function1;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "controlState", "Lkotlinx/atomicfu/AtomicInt;", "elements", "Lkotlinx/atomicfu/AtomicArray;", "tryForbidNewElements", "isClosed", "", "allocate", "close", "", "stateRepresentation", "", "stateRepresentation$kotlinx_coroutines_core", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OnDemandAllocatingPool {
    private final Function1 create;
    private final int maxCapacity;

    static {
        OnDemandAllocatingPool.controlState$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState$volatile");
    }

    public OnDemandAllocatingPool(int arg1, Function1 arg2) {
        super();
        this.maxCapacity = arg1;
        this.create = arg2;
        this.elements = new AtomicReferenceArray(arg1);
    }

    public final boolean allocate() {
        int v1;
        AtomicIntegerFieldUpdater v0 = OnDemandAllocatingPool.getControlState$volatile$FU();
        do {
            v1 = v0.get(this);
            if((0x80000000 & v1) != 0) {
                return 0;
            }

            if(v1 >= this.maxCapacity) {
                return 1;
            }
        }
        while(!OnDemandAllocatingPool.getControlState$volatile$FU().compareAndSet(this, v1, v1 + 1));

        this.getElements().set(v1, this.create.invoke(Integer.valueOf(v1)));
        return 1;
    }

    public final List close() {
        Object v3;
        int v2;
        int v1;
        AtomicIntegerFieldUpdater v0 = OnDemandAllocatingPool.getControlState$volatile$FU();
        do {
            v1 = v0.get(this);
            v2 = 0x80000000;
            if((v1 & v2) != 0) {
                break;
            }
            else if(!OnDemandAllocatingPool.getControlState$volatile$FU().compareAndSet(this, v1, v2 | v1)) {
                continue;
            }

            goto label_12;
        }
        while(true);

        v1 = 0;
    label_12:
        IntRange v0_1 = RangesKt.until(0, v1);
        ArrayList v1_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_1), 10));
        Iterator v0_2 = ((Iterable)v0_1).iterator();
        while(v0_2.hasNext()) {
            v2 = v0_2.nextInt();
            do {
                v3 = this.getElements().getAndSet(v2, null);
            }
            while(v3 == null);

            ((Collection)v1_1).add(v3);
        }

        return ((List)v1_1);
    }

    private final int getControlState$volatile() {
        return this.controlState$volatile;
    }

    private static final AtomicIntegerFieldUpdater getControlState$volatile$FU() {
        return OnDemandAllocatingPool.controlState$volatile$FU;
    }

    private final AtomicReferenceArray getElements() {
        return this.elements;
    }

    private final boolean isClosed(int arg1) {
        if((0x80000000 & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(Integer.valueOf(arg1.get(arg2)));
        }
    }

    private final void setControlState$volatile(int arg1) {
        this.controlState$volatile = arg1;
    }

    public final String stateRepresentation$kotlinx_coroutines_core() {
        int v0 = OnDemandAllocatingPool.getControlState$volatile$FU().get(this);
        IntRange v1 = RangesKt.until(0, 0x7FFFFFFF & v0);
        ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1), 10));
        Iterator v1_1 = ((Iterable)v1).iterator();
        while(v1_1.hasNext()) {
            ((Collection)v2).add(this.getElements().get(v1_1.nextInt()));
        }

        String v5 = v2.toString();
        String v0_1 = (v0 & 0x80000000) != 0 ? "[closed]" : "";
        return v5 + v0_1;
    }

    public String toString() {
        return "OnDemandAllocatingPool(" + this.stateRepresentation$kotlinx_coroutines_core() + ')';
    }

    private final int tryForbidNewElements() {
        int v1;
        AtomicIntegerFieldUpdater v0 = OnDemandAllocatingPool.getControlState$volatile$FU();
        do {
            v1 = v0.get(this);
            int v2 = 0x80000000;
            if((v1 & v2) != 0) {
                return 0;
            }
        }
        while(!OnDemandAllocatingPool.getControlState$volatile$FU().compareAndSet(this, v1, v2 | v1));

        return v1;
    }
}

