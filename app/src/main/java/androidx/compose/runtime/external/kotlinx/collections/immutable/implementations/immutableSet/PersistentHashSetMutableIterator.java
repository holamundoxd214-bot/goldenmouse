package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u000E\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000FJ\b\u0010\u0010\u001A\u00020\u0011H\u0016J1\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\r2\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00020\rH\u0002¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001A\u00020\u000B2\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u0015H\u0002J\b\u0010\u001A\u001A\u00020\u0011H\u0002J\b\u0010\u001B\u001A\u00020\u0011H\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetMutableIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)V", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", "next", "()Ljava/lang/Object;", "remove", "", "resetPath", "hashCode", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "element", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;Ljava/lang/Object;I)V", "isCollision", "checkNextWasInvoked", "checkForComodification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentHashSetMutableIterator extends PersistentHashSetIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentHashSetBuilder builder;
    private int expectedModCount;
    private Object lastIteratedElement;
    private boolean nextWasInvoked;

    static {
    }

    public PersistentHashSetMutableIterator(PersistentHashSetBuilder arg2) {
        super(arg2.getNode$runtime());
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

    private final boolean isCollision(TrieNode arg1) {
        if(arg1.getBitmap() == 0) {
            return 1;
        }

        return 0;
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
        if(this.hasNext()) {
            Object v0 = this.currentElement();
            TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
            int v2 = v0 != null ? v0.hashCode() : 0;
            this.resetPath(v2, this.builder.getNode$runtime(), v0, 0);
        }
        else {
            TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
        }

        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime();
    }

    private final void resetPath(int arg5, TrieNode arg6, Object arg7, int arg8) {
        boolean v1 = true;
        if(this.isCollision(arg6)) {
            arg5 = ArraysKt.indexOf(arg6.getBuffer(), arg7);
            if(arg5 != -1) {
            }
            else {
                v1 = false;
            }

            CommonFunctionsKt.assert(v1);
            this.getPath().get(arg8).reset(arg6.getBuffer(), arg5);
            this.setPathLastIndex(arg8);
            return;
        }

        int v0 = arg6.indexOfCellAt$runtime(1 << TrieNodeKt.indexSegment(arg5, arg8 * 5));
        this.getPath().get(arg8).reset(arg6.getBuffer(), v0);
        Object v6 = arg6.getBuffer()[v0];
        if((v6 instanceof TrieNode)) {
            this.resetPath(arg5, ((TrieNode)v6), arg7, arg8 + 1);
            return;
        }

        this.setPathLastIndex(arg8);
    }
}

