package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001A\u00020\tH\u0007J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\tH\u0007J\u0010\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\rH\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000B\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0007¨\u0006\u0016"}, d2={"Lokio/SegmentPool;", "", "<init>", "()V", "MAX_SIZE", "", "getMAX_SIZE", "()I", "LOCK", "Lokio/Segment;", "HASH_BUCKET_COUNT", "hashBuckets", "", "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "byteCount", "getByteCount", "take", "recycle", "", "segment", "firstRef", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    public static final SegmentPool INSTANCE;
    private static final Segment LOCK;
    private static final int MAX_SIZE;
    private static final AtomicReference[] hashBuckets;

    static {
        SegmentPool.INSTANCE = new SegmentPool();
        SegmentPool.MAX_SIZE = 0x10000;
        int v0 = 0;
        SegmentPool.LOCK = new Segment(new byte[0], 0, 0, false, false);
        int v1 = Integer.highestOneBit(Runtime.getRuntime().availableProcessors() * 2 - 1);
        SegmentPool.HASH_BUCKET_COUNT = v1;
        AtomicReference[] v2 = new AtomicReference[v1];
        while(v0 < v1) {
            v2[v0] = new AtomicReference();
            ++v0;
        }

        SegmentPool.hashBuckets = v2;
    }

    private SegmentPool() {
        super();
    }

    private final AtomicReference firstRef() {
        return SegmentPool.hashBuckets[((int)(Thread.currentThread().getId() & (((long)SegmentPool.HASH_BUCKET_COUNT)) - 1))];
    }

    public final int getByteCount() {
        Object v0 = this.firstRef().get();
        if(v0 == null) {
            return 0;
        }

        return ((Segment)v0).limit;
    }

    public final int getMAX_SIZE() {
        return SegmentPool.MAX_SIZE;
    }

    @JvmStatic public static final void recycle(Segment arg5) {
        Object v2;
        AtomicReference v0;
        Intrinsics.checkNotNullParameter(arg5, "segment");
        if(arg5.next == null && arg5.prev == null) {
            if(arg5.shared) {
            }
            else {
                v0 = SegmentPool.INSTANCE.firstRef();
                Segment v1 = SegmentPool.LOCK;
                v2 = v0.getAndSet(v1);
                if((((Segment)v2)) == v1) {
                    return;
                }

                goto label_15;
            }

            return;
        label_15:
            int v3 = v2 != null ? ((Segment)v2).limit : 0;
            if(v3 >= SegmentPool.MAX_SIZE) {
                v0.set(v2);
                return;
            }

            arg5.next = ((Segment)v2);
            arg5.pos = 0;
            arg5.limit = v3 + 0x2000;
            v0.set(arg5);
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @JvmStatic public static final Segment take() {
        AtomicReference v0 = SegmentPool.INSTANCE.firstRef();
        Segment v1 = SegmentPool.LOCK;
        Object v2 = v0.getAndSet(v1);
        if((((Segment)v2)) == v1) {
            return new Segment();
        }

        Object v1_1 = null;
        if(v2 == null) {
            v0.set(v1_1);
            return new Segment();
        }

        v0.set(((Segment)v2).next);
        ((Segment)v2).next = ((Segment)v1_1);
        ((Segment)v2).limit = 0;
        return ((Segment)v2);
    }
}

