package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u000B\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fJ\r\u0010\r\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/BufferIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "buffer", "", "index", "", "size", "<init>", "([Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BufferIterator extends AbstractListIterator {
    public static final int $stable = 8;
    private final Object[] buffer;

    static {
    }

    public BufferIterator(Object[] arg1, int arg2, int arg3) {
        super(arg2, arg3);
        this.buffer = arg1;
    }

    public Object next() {
        if(this.hasNext()) {
            Object[] v0 = this.buffer;
            int v1 = this.getIndex();
            this.setIndex(v1 + 1);
            return v0[v1];
        }

        throw new NoSuchElementException();
    }

    public Object previous() {
        if(this.hasPrevious()) {
            Object[] v0 = this.buffer;
            this.setIndex(this.getIndex() - 1);
            return v0[this.getIndex()];
        }

        throw new NoSuchElementException();
    }
}

