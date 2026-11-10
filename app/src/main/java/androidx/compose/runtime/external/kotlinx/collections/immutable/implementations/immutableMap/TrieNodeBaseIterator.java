package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u0015\u001A\u00020\u00162\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0002\u0010\u0017J#\u0010\u0015\u001A\u00020\u00162\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001A\u00020\u001AJ\u000B\u0010\u001B\u001A\u00028\u0000¢\u0006\u0002\u0010\u001CJ\u0006\u0010\u001D\u001A\u00020\u0016J\u0006\u0010\u001E\u001A\u00020\u001AJ\u0016\u0010\u001F\u001A\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010 J\u0006\u0010!\u001A\u00020\u0016J\t\u0010\"\u001A\u00020\u001AH\u0096\u0002R0\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b@BX\u0084\u000E¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u00020\u000FX\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "K", "V", "T", "", "<init>", "()V", "value", "", "", "buffer", "getBuffer", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "dataSize", "", "index", "getIndex", "()I", "setIndex", "(I)V", "reset", "", "([Ljava/lang/Object;II)V", "([Ljava/lang/Object;I)V", "hasNextKey", "", "currentKey", "()Ljava/lang/Object;", "moveToNextKey", "hasNextNode", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveToNextNode", "hasNext", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class TrieNodeBaseIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private Object[] buffer;
    private int dataSize;
    private int index;

    static {
    }

    public TrieNodeBaseIterator() {
        super();
        this.buffer = TrieNode.Companion.getEMPTY$runtime().getBuffer$runtime();
    }

    public final Object currentKey() {
        CommonFunctionsKt.assert(this.hasNextKey());
        return this.buffer[this.index];
    }

    public final TrieNode currentNode() {
        CommonFunctionsKt.assert(this.hasNextNode());
        Object v1 = this.buffer[this.index];
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return ((TrieNode)v1);
    }

    protected final Object[] getBuffer() {
        return this.buffer;
    }

    protected final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.hasNextKey();
    }

    public final boolean hasNextKey() {
        if(this.index < this.dataSize) {
            return 1;
        }

        return 0;
    }

    public final boolean hasNextNode() {
        boolean v0 = this.index >= this.dataSize ? true : false;
        CommonFunctionsKt.assert(v0);
        if(this.index < this.buffer.length) {
            return 1;
        }

        return 0;
    }

    public final void moveToNextKey() {
        CommonFunctionsKt.assert(this.hasNextKey());
        this.index += 2;
    }

    public final void moveToNextNode() {
        CommonFunctionsKt.assert(this.hasNextNode());
        ++this.index;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void reset(Object[] arg2, int arg3) {
        this.reset(arg2, arg3, 0);
    }

    public final void reset(Object[] arg1, int arg2, int arg3) {
        this.buffer = arg1;
        this.dataSize = arg2;
        this.index = arg3;
    }

    protected final void setIndex(int arg1) {
        this.index = arg1;
    }
}

