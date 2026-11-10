package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0082\u0004R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "<init>", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class LinesSequence implements Sequence {
    private final BufferedReader reader;

    public LinesSequence(BufferedReader arg2) {
        Intrinsics.checkNotNullParameter(arg2, "reader");
        super();
        this.reader = arg2;
    }

    public static final BufferedReader access$getReader$p(LinesSequence arg0) {
        return arg0.reader;
    }

    public Iterator iterator() {
        return new LinesSequence$iterator$1(this);
    }
}

