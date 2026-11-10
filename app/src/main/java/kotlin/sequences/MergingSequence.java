package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B?\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00020\fH\u0096\u0082\u0004R\u0015\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R!\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lkotlin/sequences/MergingSequence;", "T1", "T2", "V", "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class MergingSequence implements Sequence {
    private final Sequence sequence1;
    private final Sequence sequence2;
    private final Function2 transform;

    public MergingSequence(Sequence arg2, Sequence arg3, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "sequence1");
        Intrinsics.checkNotNullParameter(arg3, "sequence2");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        super();
        this.sequence1 = arg2;
        this.sequence2 = arg3;
        this.transform = arg4;
    }

    public static final Sequence access$getSequence1$p(MergingSequence arg0) {
        return arg0.sequence1;
    }

    public static final Sequence access$getSequence2$p(MergingSequence arg0) {
        return arg0.sequence2;
    }

    public static final Function2 access$getTransform$p(MergingSequence arg0) {
        return arg0.transform;
    }

    public Iterator iterator() {
        return new MergingSequence$iterator$1(this);
    }
}

