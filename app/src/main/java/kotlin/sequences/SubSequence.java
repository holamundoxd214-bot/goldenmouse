package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\'\bF\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000E\u001A\u00020\u0006H\u0096\u0080\u0004J\u0018\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000E\u001A\u00020\u0006H\u0096\u0080\u0004J\u0010\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096\u0082\u0004R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\n\u001A\u00020\u00068BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0012"}, d2={"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "take", "iterator", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class SubSequence implements DropTakeSequence, Sequence {
    private final int endIndex;
    private final Sequence sequence;
    private final int startIndex;

    public SubSequence(Sequence arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "sequence");
        super();
        this.sequence = arg2;
        this.startIndex = arg3;
        this.endIndex = arg4;
        if(arg3 >= 0) {
            if(arg4 >= 0) {
                if(arg4 >= arg3) {
                    return;
                }

                throw new IllegalArgumentException("endIndex should be not less than startIndex, but was " + arg4 + " < " + arg3.toString());
            }

            throw new IllegalArgumentException("endIndex should be non-negative, but is " + arg4.toString());
        }

        throw new IllegalArgumentException("startIndex should be non-negative, but is " + arg3.toString());
    }

    public static final int access$getEndIndex$p(SubSequence arg0) {
        return arg0.endIndex;
    }

    public static final Sequence access$getSequence$p(SubSequence arg0) {
        return arg0.sequence;
    }

    public static final int access$getStartIndex$p(SubSequence arg0) {
        return arg0.startIndex;
    }

    public Sequence drop(int arg4) {
        if(arg4 >= this.getCount()) {
            return SequencesKt.emptySequence();
        }

        return new SubSequence(this.sequence, this.startIndex + arg4, this.endIndex);
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    public Iterator iterator() {
        return new SubSequence$iterator$1(this);
    }

    public Sequence take(int arg3) {
        if(arg3 >= this.getCount()) {
            return this;
        }

        return new SubSequence(this.sequence, this.startIndex, arg3 + this.startIndex);
    }
}

