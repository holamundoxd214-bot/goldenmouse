package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b@¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00028\u0000H¦À\u0004¢\u0006\u0002\u0010\bJ\u001D\u0010\t\u001A\u00020\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BH¦À\u0004¢\u0006\u0002\u0010\fJ\u001D\u0010\t\u001A\u00020\u00062\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0086À\u0004¢\u0006\u0002\u0010\u000FJ\u001D\u0010\t\u001A\u00020\u00062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086À\u0004¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2={"Lkotlin/sequences/SequenceScope;", "T", "", "<init>", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elements", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class SequenceScope {
    public SequenceScope() {
        super();
    }

    public abstract Object yield(Object arg1, Continuation arg2);

    public final Object yieldAll(Iterable arg2, Continuation arg3) {
        if(((arg2 instanceof Collection)) && (arg2.isEmpty())) {
            return Unit.INSTANCE;
        }

        Object v1 = this.yieldAll(arg2.iterator(), arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    public abstract Object yieldAll(Iterator arg1, Continuation arg2);

    public final Object yieldAll(Sequence arg1, Continuation arg2) {
        Object v0 = this.yieldAll(arg1.iterator(), arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

