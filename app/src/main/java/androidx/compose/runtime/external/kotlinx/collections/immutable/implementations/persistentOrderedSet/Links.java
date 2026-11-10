package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\u00002\b\u0010\f\u001A\u0004\u0018\u00010\u0001J\u0010\u0010\r\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u000F\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "", "previous", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "()V", "(Ljava/lang/Object;)V", "getPrevious", "()Ljava/lang/Object;", "getNext", "withNext", "newNext", "withPrevious", "newPrevious", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Links {
    public static final int $stable = 8;
    private final Object next;
    private final Object previous;

    static {
    }

    public Links() {
        this(EndOfChain.INSTANCE, EndOfChain.INSTANCE);
    }

    public Links(Object arg1, Object arg2) {
        super();
        this.previous = arg1;
        this.next = arg2;
    }

    public Links(Object arg2) {
        this(arg2, EndOfChain.INSTANCE);
    }

    public final boolean getHasNext() {
        if(this.next != EndOfChain.INSTANCE) {
            return 1;
        }

        return 0;
    }

    public final boolean getHasPrevious() {
        if(this.previous != EndOfChain.INSTANCE) {
            return 1;
        }

        return 0;
    }

    public final Object getNext() {
        return this.next;
    }

    public final Object getPrevious() {
        return this.previous;
    }

    public final Links withNext(Object arg2) {
        return new Links(this.previous, arg2);
    }

    public final Links withPrevious(Object arg2) {
        return new Links(arg2, this.next);
    }
}

