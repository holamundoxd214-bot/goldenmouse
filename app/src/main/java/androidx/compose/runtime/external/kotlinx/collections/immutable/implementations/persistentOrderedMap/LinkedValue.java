package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0006\u0010\bB\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0019\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001A\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001A\u0004\u0018\u00010\u0002R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u0016\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0019¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "V", "", "value", "previous", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPrevious", "getNext", "withValue", "newValue", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "withPrevious", "newPrevious", "withNext", "newNext", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LinkedValue {
    public static final int $stable = 8;
    private final Object next;
    private final Object previous;
    private final Object value;

    static {
    }

    public LinkedValue(Object arg3) {
        this(arg3, EndOfChain.INSTANCE, EndOfChain.INSTANCE);
    }

    public LinkedValue(Object arg1, Object arg2, Object arg3) {
        super();
        this.value = arg1;
        this.previous = arg2;
        this.next = arg3;
    }

    public LinkedValue(Object arg2, Object arg3) {
        this(arg2, arg3, EndOfChain.INSTANCE);
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

    public final Object getValue() {
        return this.value;
    }

    public final LinkedValue withNext(Object arg3) {
        return new LinkedValue(this.value, this.previous, arg3);
    }

    public final LinkedValue withPrevious(Object arg3) {
        return new LinkedValue(this.value, arg3, this.next);
    }

    public final LinkedValue withValue(Object arg3) {
        return new LinkedValue(arg3, this.previous, this.next);
    }
}

