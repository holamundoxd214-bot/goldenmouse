package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0082\u0004J\u0012\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0096\u0080\u0004J\u0012\u0010\u000B\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nH\u0096\u0080\u0004¨\u0006\f"}, d2={"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "<init>", "()V", "iterator", "", "drop", "n", "", "take", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class EmptySequence implements DropTakeSequence, Sequence {
    public static final EmptySequence INSTANCE;

    static {
        EmptySequence.INSTANCE = new EmptySequence();
    }

    private EmptySequence() {
        super();
    }

    public EmptySequence drop(int arg1) {
        return EmptySequence.INSTANCE;
    }

    public Sequence drop(int arg1) {
        return this.drop(arg1);
    }

    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    public EmptySequence take(int arg1) {
        return EmptySequence.INSTANCE;
    }

    public Sequence take(int arg1) {
        return this.take(arg1);
    }
}

