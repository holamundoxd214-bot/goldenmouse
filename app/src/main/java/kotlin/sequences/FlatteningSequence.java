package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\fBE\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001A\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0082\u0004R\u0015\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001B\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R!\u0010\b\u001A\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "State", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FlatteningSequence implements Sequence {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lkotlin/sequences/FlatteningSequence$State;", "", "<init>", "()V", "UNDEFINED", "", "READY", "DONE", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class State {
        public static final int DONE = 2;
        public static final State INSTANCE = null;
        public static final int READY = 1;
        public static final int UNDEFINED;

        static {
            State.INSTANCE = new State();
        }

        private State() {
            super();
        }
    }

    private final Function1 iterator;
    private final Sequence sequence;
    private final Function1 transformer;

    public FlatteningSequence(Sequence arg2, Function1 arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        Intrinsics.checkNotNullParameter(arg3, "transformer");
        Intrinsics.checkNotNullParameter(arg4, "iterator");
        super();
        this.sequence = arg2;
        this.transformer = arg3;
        this.iterator = arg4;
    }

    public static final Function1 access$getIterator$p(FlatteningSequence arg0) {
        return arg0.iterator;
    }

    public static final Sequence access$getSequence$p(FlatteningSequence arg0) {
        return arg0.sequence;
    }

    public static final Function1 access$getTransformer$p(FlatteningSequence arg0) {
        return arg0.transformer;
    }

    public Iterator iterator() {
        return new FlatteningSequence$iterator$1(this);
    }
}

