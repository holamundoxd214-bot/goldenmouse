package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001A\u00020\tH\u0096\u0082\u0004J\n\u0010\n\u001A\u00020\u000BH\u0096\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlin/jvm/internal/ArrayByteIterator;", "Lkotlin/collections/ByteIterator;", "array", "", "<init>", "([B)V", "index", "", "hasNext", "", "nextByte", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ArrayByteIterator extends ByteIterator {
    private final byte[] array;
    private int index;

    public ArrayByteIterator(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        super();
        this.array = arg2;
    }

    public boolean hasNext() {
        if(this.index < this.array.length) {
            return 1;
        }

        return 0;
    }

    public byte nextByte() {
        byte v3;
        try {
            byte[] v0_1 = this.array;
            int v1 = this.index;
            this.index = v1 + 1;
            v3 = v0_1[v1];
            return v3;
        }
        catch(ArrayIndexOutOfBoundsException v0) {
            --((ArrayByteIterator)v3).index;
            throw new NoSuchElementException(v0.getMessage());
        }
    }
}

