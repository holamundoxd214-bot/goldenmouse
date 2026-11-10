package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AL\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tH\u0087\u0080\u0004¢\u0006\u0002\u0010\n\u001AL\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001A)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tH\u0087\u0080\u0004¢\u0006\u0002\u0010\r\"\u0013\u0010\u0010\u001A\u00060\u000Fj\u0002`\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001A\u00060\u000Fj\u0002`\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0013\u001A\u00060\u000Fj\u0002`\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0014\u001A\u00060\u000Fj\u0002`\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0015\u001A\u00060\u000Fj\u0002`\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001A\u00060\u000Fj\u0002`\u0011X\u0082Ô\b¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u000E\"\u00020\u000F2\u00020\u000F¨\u0006\u0017"}, d2={"sequence", "Lkotlin/sequences/Sequence;", "T", "block", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", "", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "State", "", "State_NotReady", "Lkotlin/sequences/State;", "State_ManyNotReady", "State_ManyReady", "State_Ready", "State_Done", "State_Failed", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/sequences/SequencesKt") class SequencesKt__SequenceBuilderKt {
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_NotReady = 0;
    private static final int State_Ready = 3;

    public SequencesKt__SequenceBuilderKt() {
        super();
    }

    public static final Iterator iterator(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "block");
        SequenceBuilderIterator v0 = new SequenceBuilderIterator();
        v0.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(arg2, v0, v0));
        return ((Iterator)v0);
    }

    public static final Sequence sequence(Function2 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "block");
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(arg1);
    }
}

