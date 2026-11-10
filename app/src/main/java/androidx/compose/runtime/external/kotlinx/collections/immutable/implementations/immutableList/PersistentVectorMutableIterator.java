package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001D\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000FJ\u000E\u0010\u0010\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000FJ\b\u0010\u0011\u001A\u00020\u0012H\u0002J\b\u0010\u0013\u001A\u00020\u0012H\u0002J\u0015\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0012H\u0016J\u0015\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0019\u001A\u00020\u0012H\u0002J\b\u0010\u001A\u001A\u00020\u0012H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorMutableIterator;", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "index", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;I)V", "expectedModCount", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "lastIteratedIndex", "previous", "()Ljava/lang/Object;", "next", "reset", "", "setupTrieIterator", "add", "element", "(Ljava/lang/Object;)V", "remove", "set", "checkForComodification", "checkHasIterated", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentVectorMutableIterator extends AbstractListIterator implements ListIterator, KMutableListIterator {
    public static final int $stable = 8;
    private final PersistentVectorBuilder builder;
    private int expectedModCount;
    private int lastIteratedIndex;
    private TrieIterator trieIterator;

    static {
    }

    public PersistentVectorMutableIterator(PersistentVectorBuilder arg2, int arg3) {
        super(arg3, arg2.size());
        this.builder = arg2;
        this.expectedModCount = arg2.getModCount$runtime();
        this.lastIteratedIndex = -1;
        this.setupTrieIterator();
    }

    public void add(Object arg3) {
        this.checkForComodification();
        this.builder.add(this.getIndex(), arg3);
        this.setIndex(this.getIndex() + 1);
        this.reset();
    }

    private final void checkForComodification() {
        if(this.expectedModCount == this.builder.getModCount$runtime()) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    private final void checkHasIterated() {
        if(this.lastIteratedIndex != -1) {
            return;
        }

        throw new IllegalStateException();
    }

    public Object next() {
        this.checkForComodification();
        this.checkHasNext$runtime();
        this.lastIteratedIndex = this.getIndex();
        TrieIterator v0 = this.trieIterator;
        if(v0 == null) {
            Object[] v0_1 = this.builder.getTail$runtime();
            int v1 = this.getIndex();
            this.setIndex(v1 + 1);
            return v0_1[v1];
        }

        if(v0.hasNext()) {
            this.setIndex(this.getIndex() + 1);
            return v0.next();
        }

        Object[] v1_1 = this.builder.getTail$runtime();
        int v2 = this.getIndex();
        this.setIndex(v2 + 1);
        return v1_1[v2 - v0.getSize()];
    }

    public Object previous() {
        this.checkForComodification();
        this.checkHasPrevious$runtime();
        this.lastIteratedIndex = this.getIndex() - 1;
        TrieIterator v0 = this.trieIterator;
        if(v0 == null) {
            Object[] v0_1 = this.builder.getTail$runtime();
            this.setIndex(this.getIndex() - 1);
            return v0_1[this.getIndex()];
        }

        if(this.getIndex() > v0.getSize()) {
            Object[] v1 = this.builder.getTail$runtime();
            this.setIndex(this.getIndex() - 1);
            return v1[this.getIndex() - v0.getSize()];
        }

        this.setIndex(this.getIndex() - 1);
        return v0.previous();
    }

    public void remove() {
        this.checkForComodification();
        this.checkHasIterated();
        this.builder.remove(this.lastIteratedIndex);
        if(this.lastIteratedIndex < this.getIndex()) {
            this.setIndex(this.lastIteratedIndex);
        }

        this.reset();
    }

    private final void reset() {
        this.setSize(this.builder.size());
        this.expectedModCount = this.builder.getModCount$runtime();
        this.lastIteratedIndex = -1;
        this.setupTrieIterator();
    }

    public void set(Object arg3) {
        this.checkForComodification();
        this.checkHasIterated();
        this.builder.set(this.lastIteratedIndex, arg3);
        this.expectedModCount = this.builder.getModCount$runtime();
        this.setupTrieIterator();
    }

    private final void setupTrieIterator() {
        Object[] v0 = this.builder.getRoot$runtime();
        if(v0 == null) {
            this.trieIterator = null;
            return;
        }

        int v1 = UtilsKt.rootSize(this.builder.size());
        int v2 = RangesKt.coerceAtMost(this.getIndex(), v1);
        int v3 = this.builder.getRootShift$runtime() / 5 + 1;
        TrieIterator v4 = this.trieIterator;
        if(v4 == null) {
            this.trieIterator = new TrieIterator(v0, v2, v1, v3);
            return;
        }

        Intrinsics.checkNotNull(v4);
        v4.reset$runtime(v0, v2, v1, v3);
    }
}

