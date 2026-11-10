package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\bF\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u000E\u001A\u00020\u000FH\u0094\u0080\u0004R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001B\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R!\u0010\n\u001A\u0012\u0012\u0004\u0012\u00028\u00010\u000Bj\b\u0012\u0004\u0012\u00028\u0001`\fX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0010"}, d2={"Lkotlin/sequences/DistinctIterator;", "T", "K", "Lkotlin/collections/AbstractIterator;", "source", "", "keySelector", "Lkotlin/Function1;", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "observed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "computeNext", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class DistinctIterator extends AbstractIterator {
    private final Function1 keySelector;
    private final HashSet observed;
    private final Iterator source;

    public DistinctIterator(Iterator arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "keySelector");
        super();
        this.source = arg2;
        this.keySelector = arg3;
        this.observed = new HashSet();
    }

    protected void computeNext() {
        Object v0;
        do {
            if(!this.source.hasNext()) {
                goto label_12;
            }

            v0 = this.source.next();
        }
        while(!this.observed.add(this.keySelector.invoke(v0)));

        this.setNext(v0);
        return;
    label_12:
        this.done();
    }
}

