package kotlinx.coroutines.internal;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001Ag\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001A\u00020\u000526\u0010\u0006\u001A2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000B\u001A+\u0010\f\u001A\u00020\r\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000E2\u0006\u0010\u000F\u001A\u0002H\u0002H\u0080\b\u001As\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u0002H\u000228\b\b\u0010\u0006\u001A2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00020\u0007H\u0080\b\u001A!\u0010\u0012\u001A\u0002H\u0013\"\u000E\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u0013H\u0000¢\u0006\u0002\u0010\u0015\u001A8\u0010\u0016\u001A\u00020\r*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192!\u0010\u001A\u001A\u001D\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001C\u0012\u0004\u0012\u00020\r0\u001BH\u0082\b\"\u000E\u0010\u001D\u001A\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"findSegmentInternal", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "id", "", "createNewSegment", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "", "Lkotlinx/atomicfu/AtomicRef;", "to", "findSegmentAndMoveForward", "startFrom", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "addConditionally", "Lkotlinx/atomicfu/AtomicInt;", "delta", "", "condition", "Lkotlin/Function1;", "cur", "POINTERS_SHIFT", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = null;
    private static final int POINTERS_SHIFT = 16;

    static {
        ConcurrentLinkedListKt.CLOSED = new Symbol("CLOSED");
    }

    public static final Symbol access$getCLOSED$p() {
        return ConcurrentLinkedListKt.CLOSED;
    }

    private static final boolean addConditionally$atomicfu$ATOMIC_ARRAY$Int(AtomicIntegerArray arg2, int arg3, int arg4, Function1 arg5) {
        do {
            int v0 = arg2.get(arg3);
            if(!arg5.invoke(Integer.valueOf(v0)).booleanValue()) {
                return 0;
            }
        }
        while(!arg2.compareAndSet(arg3, v0, v0 + arg4));

        return 1;
    }

    private static final boolean addConditionally$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg2, Object arg3, int arg4, Function1 arg5) {
        do {
            int v0 = arg2.get(arg3);
            if(!arg5.invoke(Integer.valueOf(v0)).booleanValue()) {
                return 0;
            }
        }
        while(!arg2.compareAndSet(arg3, v0, v0 + arg4));

        return 1;
    }

    private static final boolean addConditionally$atomicfu$BOXED_ATOMIC$Int(AtomicInteger arg2, int arg3, Function1 arg4) {
        do {
            int v0 = arg2.get();
            if(!arg4.invoke(Integer.valueOf(v0)).booleanValue()) {
                return 0;
            }
        }
        while(!arg2.compareAndSet(v0, v0 + arg3));

        return 1;
    }

    public static final ConcurrentLinkedListNode close(ConcurrentLinkedListNode arg2) {
        Object v2;
        while(true) {
            Object v0 = arg2.getNextOrClosed();
            if(v0 == ConcurrentLinkedListKt.CLOSED) {
                break;
            }

            if(v0 == null) {
                if(!arg2.markAsClosed()) {
                    continue;
                }

                return arg2;
            }

            v2 = v0;
        }

        return ((ConcurrentLinkedListNode)v2);
    }

    public static final Object findSegmentAndMoveForward$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray arg7, int arg8, long arg9, Segment arg11, Function2 arg12) {
        Object v2;
        Segment v1;
        Object v0;
        while(true) {
        label_0:
            v0 = ConcurrentLinkedListKt.findSegmentInternal(arg11, arg9, arg12);
            if(SegmentOrClosed.isClosed-impl(v0)) {
                return v0;
            }

            v1 = SegmentOrClosed.getSegment-impl(v0);
            while(true) {
            label_4:
                v2 = arg7.get(arg8);
                if(((Segment)v2).id >= v1.id) {
                    return v0;
                }

                if(v1.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }

                goto label_0;
            }
        }

        if(AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(arg7, arg8, v2, v1)) {
            if(((Segment)v2).decPointers$kotlinx_coroutines_core()) {
                ((Segment)v2).remove();
            }

            return v0;
        }

        if(!v1.decPointers$kotlinx_coroutines_core()) {
            goto label_4;
        }

        v1.remove();
        goto label_4;
        return v0;
    }

    public static final Object findSegmentAndMoveForward$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg7, Object arg8, long arg9, Segment arg11, Function2 arg12) {
        Object v2;
        Segment v1;
        Object v0;
        while(true) {
        label_0:
            v0 = ConcurrentLinkedListKt.findSegmentInternal(arg11, arg9, arg12);
            if(SegmentOrClosed.isClosed-impl(v0)) {
                return v0;
            }

            v1 = SegmentOrClosed.getSegment-impl(v0);
            while(true) {
            label_4:
                v2 = arg7.get(arg8);
                if(((Segment)v2).id >= v1.id) {
                    return v0;
                }

                if(v1.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }

                goto label_0;
            }
        }

        if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(arg7, arg8, v2, v1)) {
            if(((Segment)v2).decPointers$kotlinx_coroutines_core()) {
                ((Segment)v2).remove();
            }

            return v0;
        }

        if(!v1.decPointers$kotlinx_coroutines_core()) {
            goto label_4;
        }

        v1.remove();
        goto label_4;
        return v0;
    }

    public static final Object findSegmentAndMoveForward$atomicfu$BOXED_ATOMIC$Any(AtomicReference arg7, long arg8, Segment arg10, Function2 arg11) {
        Object v2;
        Segment v1;
        Object v0;
        while(true) {
        label_0:
            v0 = ConcurrentLinkedListKt.findSegmentInternal(arg10, arg8, arg11);
            if(SegmentOrClosed.isClosed-impl(v0)) {
                return v0;
            }

            v1 = SegmentOrClosed.getSegment-impl(v0);
            while(true) {
            label_4:
                v2 = arg7.get();
                if(((Segment)v2).id >= v1.id) {
                    return v0;
                }

                if(v1.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }

                goto label_0;
            }
        }

        if(MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(arg7, v2, v1)) {
            if(((Segment)v2).decPointers$kotlinx_coroutines_core()) {
                ((Segment)v2).remove();
            }

            return v0;
        }

        if(!v1.decPointers$kotlinx_coroutines_core()) {
            goto label_4;
        }

        v1.remove();
        goto label_4;
        return v0;
    }

    public static final Object findSegmentInternal(Segment arg4, long arg5, Function2 arg7) {
        while(true) {
            if(arg4.id >= arg5) {
                if(arg4.isRemoved()) {
                }
                else {
                    return SegmentOrClosed.constructor-impl(arg4);
                }
            }

            Object v0 = arg4.getNextOrClosed();
            if(v0 == ConcurrentLinkedListKt.CLOSED) {
                return SegmentOrClosed.constructor-impl(ConcurrentLinkedListKt.CLOSED);
            }

            if(v0 == null) {
                v0 = arg7.invoke(Long.valueOf(arg4.id + 1), arg4);
                if(!arg4.trySetNext(v0)) {
                    continue;
                }

                if(arg4.isRemoved()) {
                    arg4.remove();
                }
            }

            Object v4 = v0;
        }
    }

    private static final void loop$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray arg1, int arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    private static final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    private static final void loop$atomicfu$BOXED_ATOMIC$Any(AtomicReference arg1, Function1 arg2) {
        while(true) {
            arg2.invoke(arg1.get());
        }
    }

    public static final boolean moveForward$atomicfu$ATOMIC_ARRAY$Any(AtomicReferenceArray arg5, int arg6, Segment arg7) {
        while(true) {
            Object v0 = arg5.get(arg6);
            if(Long.compare(((Segment)v0).id, arg7.id) >= 0) {
                return 1;
            }

            if(!arg7.tryIncPointers$kotlinx_coroutines_core()) {
                return 0;
            }

            if(AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(arg5, arg6, v0, arg7)) {
                if(((Segment)v0).decPointers$kotlinx_coroutines_core()) {
                    ((Segment)v0).remove();
                }

                return 1;
            }

            if(!arg7.decPointers$kotlinx_coroutines_core()) {
                continue;
            }

            arg7.remove();
        }

        return 1;
    }

    public static final boolean moveForward$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg5, Object arg6, Segment arg7) {
        while(true) {
            Object v0 = arg5.get(arg6);
            if(Long.compare(((Segment)v0).id, arg7.id) >= 0) {
                return 1;
            }

            if(!arg7.tryIncPointers$kotlinx_coroutines_core()) {
                return 0;
            }

            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(arg5, arg6, v0, arg7)) {
                if(((Segment)v0).decPointers$kotlinx_coroutines_core()) {
                    ((Segment)v0).remove();
                }

                return 1;
            }

            if(!arg7.decPointers$kotlinx_coroutines_core()) {
                continue;
            }

            arg7.remove();
        }

        return 1;
    }

    public static final boolean moveForward$atomicfu$BOXED_ATOMIC$Any(AtomicReference arg5, Segment arg6) {
        while(true) {
            Object v0 = arg5.get();
            if(Long.compare(((Segment)v0).id, arg6.id) >= 0) {
                return 1;
            }

            if(!arg6.tryIncPointers$kotlinx_coroutines_core()) {
                return 0;
            }

            if(MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(arg5, v0, arg6)) {
                if(((Segment)v0).decPointers$kotlinx_coroutines_core()) {
                    ((Segment)v0).remove();
                }

                return 1;
            }

            if(!arg6.decPointers$kotlinx_coroutines_core()) {
                continue;
            }

            arg6.remove();
        }

        return 1;
    }
}

