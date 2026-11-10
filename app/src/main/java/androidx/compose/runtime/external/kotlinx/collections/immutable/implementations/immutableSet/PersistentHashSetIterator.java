package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\rH\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0002J\t\u0010\u0012\u001A\u00020\u0013H\u0096\u0002J\u000E\u0010\u0018\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\r\u0010\u001A\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0019R \u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\rX\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001A\u00020\u00138\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "E", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;)V", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", "getPath", "()Ljava/util/List;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "hasNext", "", "moveToNextNodeWithData", "pathIndex", "ensureNextElementIsReady", "", "next", "()Ljava/lang/Object;", "currentElement", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentHashSetIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private boolean hasNext;
    private final List path;
    private int pathLastIndex;

    static {
    }

    public PersistentHashSetIterator(TrieNode arg5) {
        super();
        List v1 = CollectionsKt.mutableListOf(new TrieNodeIterator[]{new TrieNodeIterator()});
        this.path = v1;
        this.hasNext = true;
        TrieNodeIterator.reset$default(v1.get(0), arg5.getBuffer(), 0, 2, null);
        this.pathLastIndex = 0;
        this.ensureNextElementIsReady();
    }

    protected final Object currentElement() {
        CommonFunctionsKt.assert(this.hasNext());
        return this.path.get(this.pathLastIndex).currentElement();
    }

    private final void ensureNextElementIsReady() {
        if(this.path.get(this.pathLastIndex).hasNextElement()) {
            return;
        }

        int v0;
        for(v0 = this.pathLastIndex; true; --v0) {
            int v2 = -1;
            if(v2 >= v0) {
                break;
            }

            int v3 = this.moveToNextNodeWithData(v0);
            if(v3 == v2 && (this.path.get(v0).hasNextCell())) {
                this.path.get(v0).moveToNextCell();
                v3 = this.moveToNextNodeWithData(v0);
            }

            if(v3 != v2) {
                this.pathLastIndex = v3;
                return;
            }

            if(v0 > 0) {
                this.path.get(v0 - 1).moveToNextCell();
            }

            this.path.get(v0).reset(TrieNode.Companion.getEMPTY$runtime().getBuffer(), 0);
        }

        this.hasNext = false;
    }

    protected final List getPath() {
        return this.path;
    }

    protected final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    private final int moveToNextNodeWithData(int arg6) {
        if(this.path.get(arg6).hasNextElement()) {
            return arg6;
        }

        if(this.path.get(arg6).hasNextNode()) {
            TrieNode v0 = this.path.get(arg6).currentNode();
            ++arg6;
            if(arg6 == this.path.size()) {
                this.path.add(new TrieNodeIterator());
            }

            TrieNodeIterator.reset$default(this.path.get(arg6), v0.getBuffer(), 0, 2, null);
            return this.moveToNextNodeWithData(arg6);
        }

        return -1;
    }

    public Object next() {
        if(this.hasNext) {
            Object v0 = this.path.get(this.pathLastIndex).nextElement();
            this.ensureNextElementIsReady();
            return v0;
        }

        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setPathLastIndex(int arg1) {
        this.pathLastIndex = arg1;
    }
}

