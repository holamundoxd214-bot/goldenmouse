package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B1\bF\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\u000BH\u0096\u0082\u0004R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R!\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlin/sequences/TransformingIndexedSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function2;", "", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TransformingIndexedSequence implements Sequence {
    private final Sequence sequence;
    private final Function2 transformer;

    public TransformingIndexedSequence(Sequence arg2, Function2 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        Intrinsics.checkNotNullParameter(arg3, "transformer");
        super();
        this.sequence = arg2;
        this.transformer = arg3;
    }

    public static final Sequence access$getSequence$p(TransformingIndexedSequence arg0) {
        return arg0.sequence;
    }

    public static final Function2 access$getTransformer$p(TransformingIndexedSequence arg0) {
        return arg0.transformer;
    }

    public Iterator iterator() {
        return new TransformingIndexedSequence$iterator$1(this);
    }
}

