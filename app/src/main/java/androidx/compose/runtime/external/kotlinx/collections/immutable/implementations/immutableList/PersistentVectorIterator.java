package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B=\u0012\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u000E\u0010\u0010\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "tail", "index", "", "size", "trieHeight", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;III)V", "[Ljava/lang/Object;", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "next", "()Ljava/lang/Object;", "previous", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentVectorIterator extends AbstractListIterator {
    public static final int $stable = 8;
    private final Object[] tail;
    private final TrieIterator trieIterator;

    static {
    }

    public PersistentVectorIterator(Object[] arg1, Object[] arg2, int arg3, int arg4, int arg5) {
        super(arg3, arg4);
        this.tail = arg2;
        int v2 = UtilsKt.rootSize(arg4);
        this.trieIterator = new TrieIterator(arg1, RangesKt.coerceAtMost(arg3, v2), v2, arg5);
    }

    public Object next() {
        this.checkHasNext$runtime();
        if(this.trieIterator.hasNext()) {
            this.setIndex(this.getIndex() + 1);
            return this.trieIterator.next();
        }

        Object[] v0 = this.tail;
        int v1 = this.getIndex();
        this.setIndex(v1 + 1);
        return v0[v1 - this.trieIterator.getSize()];
    }

    public Object previous() {
        this.checkHasPrevious$runtime();
        if(this.getIndex() > this.trieIterator.getSize()) {
            Object[] v0 = this.tail;
            this.setIndex(this.getIndex() - 1);
            return v0[this.getIndex() - this.trieIterator.getSize()];
        }

        this.setIndex(this.getIndex() - 1);
        return this.trieIterator.previous();
    }
}

