package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B+\bF\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00010\nH\u0096\u0082\u0004J5\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\f0\u0003\"\u0004\b\u0002\u0010\f2\u0018\u0010\t\u001A\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u0006H\u0080\u0080\u0004¢\u0006\u0002\b\rR\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001B\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "flatten", "E", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TransformingSequence implements Sequence {
    private final Sequence sequence;
    private final Function1 transformer;

    public TransformingSequence(Sequence arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        Intrinsics.checkNotNullParameter(arg3, "transformer");
        super();
        this.sequence = arg2;
        this.transformer = arg3;
    }

    public static final Sequence access$getSequence$p(TransformingSequence arg0) {
        return arg0.sequence;
    }

    public static final Function1 access$getTransformer$p(TransformingSequence arg0) {
        return arg0.transformer;
    }

    public final Sequence flatten$kotlin_stdlib(Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "iterator");
        return new FlatteningSequence(this.sequence, this.transformer, arg3);
    }

    public Iterator iterator() {
        return new TransformingSequence$iterator$1(this);
    }
}

