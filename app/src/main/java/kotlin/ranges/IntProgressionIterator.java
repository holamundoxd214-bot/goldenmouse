package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000B\u001A\u00020\fH\u0096\u0082\u0004J\n\u0010\u000E\u001A\u00020\u0003H\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000F\u0010\n\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\fX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\u0003X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "<init>", "(III)V", "getStep", "()I", "finalElement", "hasNext", "", "next", "nextInt", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class IntProgressionIterator extends IntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public IntProgressionIterator(int arg3, int arg4, int arg5) {
        super();
        this.step = arg5;
        this.finalElement = arg4;
        boolean v0 = true;
        if(arg5 > 0) {
            if(arg3 <= arg4) {
            }
            else {
                goto label_10;
            }
        }
        else if(arg3 >= arg4) {
        }
        else {
        label_10:
            v0 = false;
        }

        this.hasNext = v0;
        if(v0) {
        }
        else {
            arg3 = arg4;
        }

        this.next = arg3;
    }

    public final int getStep() {
        return this.step;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public int nextInt() {
        int v0 = this.next;
        if(v0 == this.finalElement) {
            if(this.hasNext) {
                this.hasNext = false;
                return v0;
            }

            throw new NoSuchElementException();
        }

        this.next = this.step + v0;
        return v0;
    }
}

