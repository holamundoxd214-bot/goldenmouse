package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B%\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001B\u001A\u00020\u0013H\u0096\u0002J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\b\u0010\u001F\u001A\u00020\u001EH\u0002J\b\u0010 \u001A\u00020\u001EH\u0002J\b\u0010!\u001A\u00020\u001EH\u0002R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001C\u0010\r\u001A\u0004\u0018\u00010\u0006X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0016\u001A\u00020\u0015X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderLinksIterator;", "K", "V", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "nextKey", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "getBuilder$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "lastIteratedKey", "getLastIteratedKey$runtime", "()Ljava/lang/Object;", "setLastIteratedKey$runtime", "(Ljava/lang/Object;)V", "nextWasInvoked", "", "expectedModCount", "", "index", "getIndex$runtime", "()I", "setIndex$runtime", "(I)V", "hasNext", "next", "remove", "", "checkHasNext", "checkNextWasInvoked", "checkForComodification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentOrderedMapBuilderLinksIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilder builder;
    private int expectedModCount;
    private int index;
    private Object lastIteratedKey;
    private Object nextKey;
    private boolean nextWasInvoked;

    static {
    }

    public PersistentOrderedMapBuilderLinksIterator(Object arg1, PersistentOrderedMapBuilder arg2) {
        super();
        this.nextKey = arg1;
        this.builder = arg2;
        this.lastIteratedKey = EndOfChain.INSTANCE;
        this.expectedModCount = arg2.getHashMapBuilder$runtime().getModCount$runtime();
    }

    private final void checkForComodification() {
        if(this.builder.getHashMapBuilder$runtime().getModCount$runtime() == this.expectedModCount) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    private final void checkHasNext() {
        if(this.hasNext()) {
            return;
        }

        throw new NoSuchElementException();
    }

    private final void checkNextWasInvoked() {
        if(this.nextWasInvoked) {
            return;
        }

        throw new IllegalStateException();
    }

    public final PersistentOrderedMapBuilder getBuilder$runtime() {
        return this.builder;
    }

    public final int getIndex$runtime() {
        return this.index;
    }

    public final Object getLastIteratedKey$runtime() {
        return this.lastIteratedKey;
    }

    public boolean hasNext() {
        if(this.index < this.builder.size()) {
            return 1;
        }

        return 0;
    }

    public LinkedValue next() {
        this.checkForComodification();
        this.checkHasNext();
        this.lastIteratedKey = this.nextKey;
        this.nextWasInvoked = true;
        ++this.index;
        Object v0 = this.builder.getHashMapBuilder$runtime().get(this.nextKey);
        if(v0 != null) {
            this.nextKey = ((LinkedValue)v0).getNext();
            return ((LinkedValue)v0);
        }

        throw new ConcurrentModificationException("Hash code of a key (" + this.nextKey + ") has changed after it was added to the persistent map.");
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        this.checkNextWasInvoked();
        TypeIntrinsics.asMutableMap(this.builder).remove(this.lastIteratedKey);
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime().getModCount$runtime();
        --this.index;
    }

    public final void setIndex$runtime(int arg1) {
        this.index = arg1;
    }

    public final void setLastIteratedKey$runtime(Object arg1) {
        this.lastIteratedKey = arg1;
    }
}

