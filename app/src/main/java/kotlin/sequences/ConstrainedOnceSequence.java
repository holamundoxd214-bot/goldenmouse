package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0082\u0004R)\u0010\u0006\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \b*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "<init>", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ConstrainedOnceSequence implements Sequence {
    private final AtomicReference sequenceRef;

    public ConstrainedOnceSequence(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        super();
        this.sequenceRef = new AtomicReference(arg2);
    }

    public Iterator iterator() {
        Object v1 = this.sequenceRef.getAndSet(null);
        if(v1 != null) {
            return ((Sequence)v1).iterator();
        }

        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}

