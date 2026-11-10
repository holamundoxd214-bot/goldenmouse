package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001F\bF\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001A\u00020\u0006H\u0096\u0080\u0004J\u0018\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001A\u00020\u0006H\u0096\u0080\u0004J\u0010\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0082\u0004R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/sequences/TakeSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "<init>", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "take", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TakeSequence implements DropTakeSequence, Sequence {
    private final int count;
    private final Sequence sequence;

    public TakeSequence(Sequence arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        super();
        this.sequence = arg2;
        this.count = arg3;
        if(arg3 >= 0) {
            return;
        }

        throw new IllegalArgumentException("count must be non-negative, but was " + arg3 + '.'.toString());
    }

    public static final int access$getCount$p(TakeSequence arg0) {
        return arg0.count;
    }

    public static final Sequence access$getSequence$p(TakeSequence arg0) {
        return arg0.sequence;
    }

    public Sequence drop(int arg3) {
        if(arg3 >= this.count) {
            return SequencesKt.emptySequence();
        }

        return new SubSequence(this.sequence, arg3, this.count);
    }

    public Iterator iterator() {
        return new TakeSequence$iterator$1(this);
    }

    public Sequence take(int arg2) {
        if(arg2 >= this.count) {
            return this;
        }

        return new TakeSequence(this.sequence, arg2);
    }
}

