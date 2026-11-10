package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u000E\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000FJ\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0011H\u0002J\b\u0010\u0013\u001A\u00020\u0011H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetMutableIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetIterator;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;)V", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", "next", "()Ljava/lang/Object;", "remove", "", "checkNextWasInvoked", "checkForComodification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedSetMutableIterator extends PersistentOrderedSetIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentOrderedSetBuilder builder;
    private int expectedModCount;
    private Object lastIteratedElement;
    private boolean nextWasInvoked;

    static {
    }

    public PersistentOrderedSetMutableIterator(PersistentOrderedSetBuilder arg3) {
        super(arg3.getFirstElement$runtime(), arg3.getHashMapBuilder$runtime());
        this.builder = arg3;
        this.expectedModCount = arg3.getHashMapBuilder$runtime().getModCount$runtime();
    }

    private final void checkForComodification() {
        if(this.builder.getHashMapBuilder$runtime().getModCount$runtime() == this.expectedModCount) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    private final void checkNextWasInvoked() {
        if(this.nextWasInvoked) {
            return;
        }

        throw new IllegalStateException();
    }

    public Object next() {
        this.checkForComodification();
        Object v0 = super.next();
        this.lastIteratedElement = v0;
        this.nextWasInvoked = true;
        return v0;
    }

    public void remove() {
        this.checkNextWasInvoked();
        TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime().getModCount$runtime();
        this.setIndex$runtime(this.getIndex$runtime() - 1);
    }
}

