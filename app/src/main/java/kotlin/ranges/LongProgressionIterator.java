package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000B\u001A\u00020\fH\u0096\u0082\u0004J\n\u0010\u000E\u001A\u00020\u0003H\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000F\u0010\n\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\fX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\u0003X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "<init>", "(JJJ)V", "getStep", "()J", "finalElement", "hasNext", "", "next", "nextLong", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class LongProgressionIterator extends LongIterator {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public LongProgressionIterator(long arg3, long arg5, long arg7) {
        super();
        this.step = arg7;
        this.finalElement = arg5;
        int v7 = Long.compare(arg7, 0);
        boolean v8 = true;
        if(v7 > 0) {
            if(arg3 <= arg5) {
            }
            else {
                goto label_12;
            }
        }
        else if(arg3 >= arg5) {
        }
        else {
        label_12:
            v8 = false;
        }

        this.hasNext = v8;
        if(v8) {
        }
        else {
            arg3 = arg5;
        }

        this.next = arg3;
    }

    public final long getStep() {
        return this.step;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public long nextLong() {
        long v0 = this.next;
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

