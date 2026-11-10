package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\bF\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BH\u0096\u0082\u0004R\u0017\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001D\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class GeneratorSequence implements Sequence {
    private final Function0 getInitialValue;
    private final Function1 getNextValue;

    public GeneratorSequence(Function0 arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "getInitialValue");
        Intrinsics.checkNotNullParameter(arg3, "getNextValue");
        super();
        this.getInitialValue = arg2;
        this.getNextValue = arg3;
    }

    public static final Function0 access$getGetInitialValue$p(GeneratorSequence arg0) {
        return arg0.getInitialValue;
    }

    public static final Function1 access$getGetNextValue$p(GeneratorSequence arg0) {
        return arg0.getNextValue;
    }

    public Iterator iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}

