package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B;\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u001E\u0010\b\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\t¢\u0006\u0004\b\u000B\u0010\fJ\u000E\u0010\u0013\u001A\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\u001B\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00028\u0001¢\u0006\u0002\u0010\u001AJ5\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00122\u000E\u0010\u001D\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001E2\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020\u0012H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001A\u00020\u0016H\u0002J\b\u0010\"\u001A\u00020\u0016H\u0002R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", "V", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", "next", "()Ljava/lang/Object;", "remove", "", "setValue", "key", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "resetPath", "keyHash", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;I)V", "checkNextWasInvoked", "checkForComodification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentHashMapBuilderBaseIterator extends PersistentHashMapBaseIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentHashMapBuilder builder;
    private int expectedModCount;
    private Object lastIteratedKey;
    private boolean nextWasInvoked;

    static {
    }

    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder arg2, TrieNodeBaseIterator[] arg3) {
        super(arg2.getNode$runtime(), arg3);
        this.builder = arg2;
        this.expectedModCount = arg2.getModCount$runtime();
    }

    private final void checkForComodification() {
        if(this.builder.getModCount$runtime() == this.expectedModCount) {
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
        this.lastIteratedKey = this.currentKey();
        this.nextWasInvoked = true;
        return super.next();
    }

    public void remove() {
        this.checkNextWasInvoked();
        if(this.hasNext()) {
            Object v0 = this.currentKey();
            TypeIntrinsics.asMutableMap(this.builder).remove(this.lastIteratedKey);
            int v2 = v0 != null ? v0.hashCode() : 0;
            this.resetPath(v2, this.builder.getNode$runtime(), v0, 0);
        }
        else {
            TypeIntrinsics.asMutableMap(this.builder).remove(this.lastIteratedKey);
        }

        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime();
    }

    private final void resetPath(int arg6, TrieNode arg7, Object arg8, int arg9) {
        int v0 = arg9 * 5;
        if(v0 > 30) {
            this.getPath()[arg9].reset(arg7.getBuffer$runtime(), arg7.getBuffer$runtime().length, 0);
            while(!Intrinsics.areEqual(this.getPath()[arg9].currentKey(), arg8)) {
                this.getPath()[arg9].moveToNextKey();
            }

            this.setPathLastIndex(arg9);
            return;
        }

        v0 = 1 << TrieNodeKt.indexSegment(arg6, v0);
        if(arg7.hasEntryAt$runtime(v0)) {
            this.getPath()[arg9].reset(arg7.getBuffer$runtime(), arg7.entryCount$runtime() * 2, arg7.entryKeyIndex$runtime(v0));
            this.setPathLastIndex(arg9);
            return;
        }

        v0 = arg7.nodeIndex$runtime(v0);
        TrieNode v2 = arg7.nodeAtIndex$runtime(v0);
        this.getPath()[arg9].reset(arg7.getBuffer$runtime(), arg7.entryCount$runtime() * 2, v0);
        this.resetPath(arg6, v2, arg8, arg9 + 1);
    }

    public final void setValue(Object arg3, Object arg4) {
        if(!this.builder.containsKey(arg3)) {
            return;
        }

        if(this.hasNext()) {
            Object v0 = this.currentKey();
            this.builder.put(arg3, arg4);
            int v4 = v0 != null ? v0.hashCode() : 0;
            this.resetPath(v4, this.builder.getNode$runtime(), v0, 0);
        }
        else {
            this.builder.put(arg3, arg4);
        }

        this.expectedModCount = this.builder.getModCount$runtime();
    }
}

