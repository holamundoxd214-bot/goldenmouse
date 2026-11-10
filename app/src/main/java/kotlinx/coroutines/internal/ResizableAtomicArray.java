package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\t\u001A\u00020\u0004J\u0018\u0010\n\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u000B\u001A\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010\fJ\u001D\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lkotlinx/coroutines/internal/ResizableAtomicArray;", "T", "", "initialLength", "", "<init>", "(I)V", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "currentLength", "get", "index", "(I)Ljava/lang/Object;", "setSynchronized", "", "value", "(ILjava/lang/Object;)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ResizableAtomicArray {
    private volatile AtomicReferenceArray array;

    public ResizableAtomicArray(int arg2) {
        super();
        this.array = new AtomicReferenceArray(arg2);
    }

    public final int currentLength() {
        return this.array.length();
    }

    public final Object get(int arg2) {
        AtomicReferenceArray v1 = this.array;
        if(arg2 < v1.length()) {
            return v1.get(arg2);
        }

        return null;
    }

    public final void setSynchronized(int arg6, Object arg7) {
        AtomicReferenceArray v0 = this.array;
        int v1 = v0.length();
        if(arg6 < v1) {
            v0.set(arg6, arg7);
            return;
        }

        AtomicReferenceArray v2 = new AtomicReferenceArray(RangesKt.coerceAtLeast(arg6 + 1, v1 * 2));
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v2.set(v3, v0.get(v3));
        }

        v2.set(arg6, arg7);
        this.array = v2;
    }
}

