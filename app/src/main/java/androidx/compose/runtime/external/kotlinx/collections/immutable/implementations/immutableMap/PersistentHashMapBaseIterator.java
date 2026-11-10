package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u001E\u0010\u0007\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u0010H\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0002J\r\u0010\u001B\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001CJ\t\u0010\u0015\u001A\u00020\u0016H\u0096\u0002J\u000E\u0010\u001D\u001A\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u001CJ\b\u0010\u001E\u001A\u00020\u001AH\u0002R.\u0010\u0007\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\bX\u0084\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000F\u001A\u00020\u0010X\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001A\u00020\u00168\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", "V", "T", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "getPath", "()[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "hasNext", "", "moveToNextNodeWithData", "pathIndex", "ensureNextEntryIsReady", "", "currentKey", "()Ljava/lang/Object;", "next", "checkHasNext", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class PersistentHashMapBaseIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private boolean hasNext;
    private final TrieNodeBaseIterator[] path;
    private int pathLastIndex;

    static {
    }

    public PersistentHashMapBaseIterator(TrieNode arg3, TrieNodeBaseIterator[] arg4) {
        super();
        this.path = arg4;
        this.hasNext = true;
        arg4[0].reset(arg3.getBuffer$runtime(), arg3.entryCount$runtime() * 2);
        this.pathLastIndex = 0;
        this.ensureNextEntryIsReady();
    }

    private final void checkHasNext() {
        if(this.hasNext()) {
            return;
        }

        throw new NoSuchElementException();
    }

    protected final Object currentKey() {
        this.checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    private final void ensureNextEntryIsReady() {
        if(this.path[this.pathLastIndex].hasNextKey()) {
            return;
        }

        int v0;
        for(v0 = this.pathLastIndex; true; --v0) {
            int v2 = -1;
            if(v2 >= v0) {
                break;
            }

            int v3 = this.moveToNextNodeWithData(v0);
            if(v3 == v2 && (this.path[v0].hasNextNode())) {
                this.path[v0].moveToNextNode();
                v3 = this.moveToNextNodeWithData(v0);
            }

            if(v3 != v2) {
                this.pathLastIndex = v3;
                return;
            }

            if(v0 > 0) {
                this.path[v0 - 1].moveToNextNode();
            }

            this.path[v0].reset(TrieNode.Companion.getEMPTY$runtime().getBuffer$runtime(), 0);
        }

        this.hasNext = false;
    }

    protected final TrieNodeBaseIterator[] getPath() {
        return this.path;
    }

    protected final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    private final int moveToNextNodeWithData(int arg4) {
        if(this.path[arg4].hasNextKey()) {
            return arg4;
        }

        if(this.path[arg4].hasNextNode()) {
            TrieNode v0 = this.path[arg4].currentNode();
            TrieNodeBaseIterator[] v1 = this.path;
            if(arg4 == 6) {
                v1[arg4 + 1].reset(v0.getBuffer$runtime(), v0.getBuffer$runtime().length);
            }
            else {
                v1[arg4 + 1].reset(v0.getBuffer$runtime(), v0.entryCount$runtime() * 2);
            }

            return this.moveToNextNodeWithData(arg4 + 1);
        }

        return -1;
    }

    public Object next() {
        this.checkHasNext();
        Object v0 = this.path[this.pathLastIndex].next();
        this.ensureNextEntryIsReady();
        return v0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setPathLastIndex(int arg1) {
        this.pathLastIndex = arg1;
    }
}

