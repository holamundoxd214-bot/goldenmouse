package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\f\u001A\u00020\rH\u0096\u0082\u0004J\n\u0010\u000F\u001A\u00020\u0003H\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000F\u0010\u000B\u001A\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\rX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000E\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "<init>", "(CCI)V", "getStep", "()I", "finalElement", "hasNext", "", "next", "nextChar", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class CharProgressionIterator extends CharIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public CharProgressionIterator(char arg3, char arg4, int arg5) {
        int v3;
        super();
        this.step = arg5;
        this.finalElement = arg4;
        boolean v0 = true;
        if(arg5 > 0) {
            if(Intrinsics.compare(arg3, arg4) <= 0) {
            }
            else {
                goto label_12;
            }
        }
        else if(Intrinsics.compare(arg3, arg4) >= 0) {
        }
        else {
        label_12:
            v0 = false;
        }

        this.hasNext = v0;
        if(v0) {
        }
        else {
            v3 = arg4;
        }

        this.next = v3;
    }

    public final int getStep() {
        return this.step;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public char nextChar() {
        int v0 = this.next;
        if(v0 != this.finalElement) {
            this.next = this.step + v0;
        }
        else if(this.hasNext) {
            this.hasNext = false;
        }
        else {
            throw new NoSuchElementException();
        }

        return ((char)v0);
    }
}

