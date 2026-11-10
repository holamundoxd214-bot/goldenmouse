package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B5\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BH\u0096\u0082\u0004R\u0015\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001B\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "<init>", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FilteringSequence implements Sequence {
    private final Function1 predicate;
    private final boolean sendWhen;
    private final Sequence sequence;

    public FilteringSequence(Sequence arg2, boolean arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        super();
        this.sequence = arg2;
        this.sendWhen = arg3;
        this.predicate = arg4;
    }

    public FilteringSequence(Sequence arg1, boolean arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, true, arg3);
    }

    public static final Function1 access$getPredicate$p(FilteringSequence arg0) {
        return arg0.predicate;
    }

    public static final boolean access$getSendWhen$p(FilteringSequence arg0) {
        return arg0.sendWhen;
    }

    public static final Sequence access$getSequence$p(FilteringSequence arg0) {
        return arg0.sequence;
    }

    public Iterator iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}

