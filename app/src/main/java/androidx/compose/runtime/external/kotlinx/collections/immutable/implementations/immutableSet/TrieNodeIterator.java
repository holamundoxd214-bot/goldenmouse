package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001A\u00020\u000B2\u000E\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001A\u00020\u000EJ\u0006\u0010\u000F\u001A\u00020\u000BJ\u0006\u0010\u0010\u001A\u00020\u000EJ\u000B\u0010\u0011\u001A\u00028\u0000¢\u0006\u0002\u0010\u0012J\u000B\u0010\u0013\u001A\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001A\u00020\u000EJ\u000E\u0010\u0015\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016R\u0018\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", "E", "", "<init>", "()V", "buffer", "", "[Ljava/lang/Object;", "index", "", "reset", "", "([Ljava/lang/Object;I)V", "hasNextCell", "", "moveToNextCell", "hasNextElement", "currentElement", "()Ljava/lang/Object;", "nextElement", "hasNextNode", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TrieNodeIterator {
    public static final int $stable = 8;
    private Object[] buffer;
    private int index;

    static {
    }

    public TrieNodeIterator() {
        super();
        this.buffer = TrieNode.Companion.getEMPTY$runtime().getBuffer();
    }

    public final Object currentElement() {
        CommonFunctionsKt.assert(this.hasNextElement());
        return this.buffer[this.index];
    }

    public final TrieNode currentNode() {
        CommonFunctionsKt.assert(this.hasNextNode());
        Object v1 = this.buffer[this.index];
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
        return ((TrieNode)v1);
    }

    public final boolean hasNextCell() {
        if(this.index < this.buffer.length) {
            return 1;
        }

        return 0;
    }

    public final boolean hasNextElement() {
        if((this.hasNextCell()) && !(this.buffer[this.index] instanceof TrieNode)) {
            return 1;
        }

        return 0;
    }

    public final boolean hasNextNode() {
        if((this.hasNextCell()) && ((this.buffer[this.index] instanceof TrieNode))) {
            return 1;
        }

        return 0;
    }

    public final void moveToNextCell() {
        CommonFunctionsKt.assert(this.hasNextCell());
        ++this.index;
    }

    public final Object nextElement() {
        CommonFunctionsKt.assert(this.hasNextElement());
        Object[] v0 = this.buffer;
        int v1 = this.index;
        this.index = v1 + 1;
        return v0[v1];
    }

    public final void reset(Object[] arg1, int arg2) {
        this.buffer = arg1;
        this.index = arg2;
    }

    public static void reset$default(TrieNodeIterator arg0, Object[] arg1, int arg2, int arg3, Object arg4) {
        arg0.reset(arg1, 0);
    }
}

