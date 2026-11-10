package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapEntriesIterator;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentHashMapEntriesIterator extends PersistentHashMapBaseIterator {
    public static final int $stable = 8;

    static {
    }

    public PersistentHashMapEntriesIterator(TrieNode arg5) {
        int v0 = 8;
        TrieNodeBaseIterator[] v1 = new TrieNodeBaseIterator[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = new TrieNodeEntriesIterator();
        }

        super(arg5, v1);
    }
}

