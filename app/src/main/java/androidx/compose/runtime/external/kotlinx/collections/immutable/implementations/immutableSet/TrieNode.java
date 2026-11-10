package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 `*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001`B)\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0004\b\t\u0010\u000BJ\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0004H\u0002J\u0015\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u0004H\u0000¢\u0006\u0002\b\u001DJ\u0015\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\u0016\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001F\u001A\u00020\u0004H\u0002J#\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001B\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010$J+\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001B\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u00002\u0006\u0010&\u001A\u00020\bH\u0002¢\u0006\u0002\u0010\'J$\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001A\u00020\u00042\f\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J,\u0010+\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001A\u00020\u00042\f\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010&\u001A\u00020\bH\u0002J=\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010-\u001A\u00020\u00042\u0006\u0010.\u001A\u00020\u00042\u0006\u0010/\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u00042\b\u0010&\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00101J3\u00102\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010-\u001A\u00020\u00042\u0006\u0010.\u001A\u00020\u00042\u0006\u0010/\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u0004H\u0002¢\u0006\u0002\u00103J;\u00104\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010-\u001A\u00020\u00042\u0006\u0010.\u001A\u00020\u00042\u0006\u0010/\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\bH\u0002¢\u0006\u0002\u00101JE\u00105\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001A\u00020\u00042\u0006\u00107\u001A\u00028\u00002\u0006\u00108\u001A\u00020\u00042\u0006\u00109\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u00042\b\u0010&\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010:J\u001E\u0010;\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u0004H\u0002J&\u0010=\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\bH\u0002J\u0016\u0010>\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001A\u00020\u0004H\u0002J\u001E\u0010@\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\bH\u0002J\u0015\u0010A\u001A\u00020\u001A2\u0006\u0010#\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010BJ\u001B\u0010C\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010DJ\'\u0010E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001A\u00028\u00002\n\u0010F\u001A\u0006\u0012\u0002\b\u00030GH\u0002¢\u0006\u0002\u0010HJ\u001B\u0010I\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010DJ\'\u0010J\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001A\u00028\u00002\n\u0010F\u001A\u0006\u0012\u0002\b\u00030GH\u0002¢\u0006\u0002\u0010HJ,\u0010K\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001A\u00020N2\u0006\u0010&\u001A\u00020\bH\u0002J(\u0010O\u001A\u0004\u0018\u00010\u00022\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001A\u00020N2\u0006\u0010&\u001A\u00020\bH\u0002J(\u0010P\u001A\u0004\u0018\u00010\u00022\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001A\u00020N2\u0006\u0010&\u001A\u00020\bH\u0002J\b\u0010Q\u001A\u00020\u0004H\u0002J\u0016\u0010R\u001A\u00020\u001A2\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J#\u0010S\u001A\u00020\u001A2\u0006\u0010T\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u0004¢\u0006\u0002\u0010UJ6\u0010V\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001A\u00020\u00042\u0006\u0010M\u001A\u00020N2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030GJ2\u0010W\u001A\u0004\u0018\u00010\u00022\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001A\u00020\u00042\u0006\u0010M\u001A\u00020N2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030GJ2\u0010X\u001A\u0004\u0018\u00010\u00022\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001A\u00020\u00042\u0006\u0010M\u001A\u00020N2\n\u0010F\u001A\u0006\u0012\u0002\b\u00030GJ\u001C\u0010Y\u001A\u00020\u001A2\f\u0010L\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001A\u00020\u0004J)\u0010Z\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u0004¢\u0006\u0002\u0010[J5\u0010\\\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u00042\n\u0010F\u001A\u0006\u0012\u0002\b\u00030G¢\u0006\u0002\u0010]J)\u0010^\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u0004¢\u0006\u0002\u0010[J5\u0010_\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001A\u00020\u00042\u0006\u0010#\u001A\u00028\u00002\u0006\u00100\u001A\u00020\u00042\n\u0010F\u001A\u0006\u0012\u0002\b\u00030G¢\u0006\u0002\u0010]R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR$\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0014\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006a"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", "bitmap", "", "buffer", "", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<init>", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "(I[Ljava/lang/Object;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "hasNoCellAt", "", "positionMask", "indexOfCellAt", "indexOfCellAt$runtime", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "nodeAtIndex", "addElementAt", "element", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddElementAt", "owner", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "updateNodeAtIndex", "nodeIndex", "newNode", "mutableUpdateNodeAtIndex", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "shift", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableMoveElementToNode", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "removeCellAtIndex", "cellIndex", "mutableRemoveCellAtIndex", "collisionRemoveElementAtIndex", "i", "mutableCollisionRemoveElementAtIndex", "collisionContainsElement", "(Ljava/lang/Object;)Z", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionRemove", "mutableCollisionRemove", "mutableCollisionAddAll", "otherNode", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRetainAll", "mutableCollisionRemoveAll", "calculateSize", "elementsIdentityEquals", "contains", "elementHash", "(ILjava/lang/Object;I)Z", "mutableAddAll", "mutableRetainAll", "mutableRemoveAll", "containsAll", "add", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "remove", "mutableRemove", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TrieNode {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TrieNode getEMPTY$runtime() {
            return TrieNode.EMPTY;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TrieNode EMPTY;
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    static {
        TrieNode.Companion = new Companion(null);
        TrieNode.$stable = 8;
        TrieNode.EMPTY = new TrieNode(0, new Object[0]);
    }

    public TrieNode(int arg2, Object[] arg3) {
        this(arg2, arg3, null);
    }

    public TrieNode(int arg1, Object[] arg2, MutabilityOwnership arg3) {
        super();
        this.bitmap = arg1;
        this.buffer = arg2;
        this.ownedBy = arg3;
    }

    public static final TrieNode access$getEMPTY$cp() {
        return TrieNode.EMPTY;
    }

    public final TrieNode add(int arg4, Object arg5, int arg6) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg4, arg6);
        if(this.hasNoCellAt(v0)) {
            return this.addElementAt(v0, arg5);
        }

        v0 = this.indexOfCellAt$runtime(v0);
        Object v1 = this.buffer[v0];
        if((v1 instanceof TrieNode)) {
            TrieNode v1_1 = this.nodeAtIndex(v0);
            TrieNode v4 = arg6 == 30 ? v1_1.collisionAdd(arg5) : v1_1.add(arg4, arg5, arg6 + 5);
            if(v1_1 == v4) {
                return this;
            }

            return this.updateNodeAtIndex(v0, v4);
        }
        else if(!Intrinsics.areEqual(arg5, v1)) {
            goto label_26;
        }

        return this;
    label_26:
        return this.moveElementToNode(v0, arg4, arg5, arg6);
    }

    private final TrieNode addElementAt(int arg3, Object arg4) {
        return new TrieNode(this.bitmap | arg3, TrieNodeKt.access$addElementAtIndex(this.buffer, this.indexOfCellAt$runtime(arg3), arg4));
    }

    private final int calculateSize() {
        int v0 = this.bitmap;
        Object[] v5 = this.buffer;
        if(v0 == 0) {
            return v5.length;
        }

        v0 = v5.length;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            Object v3 = v5[v1];
            int v3_1 = (v3 instanceof TrieNode) ? ((TrieNode)v3).calculateSize() : 1;
            v2 += v3_1;
            ++v1;
        }

        return v2;
    }

    private final TrieNode collisionAdd(Object arg2) {
        if(this.collisionContainsElement(arg2)) {
            return this;
        }

        return new TrieNode(0, TrieNodeKt.access$addElementAtIndex(this.buffer, 0, arg2));
    }

    private final boolean collisionContainsElement(Object arg1) {
        return ArraysKt.contains(this.buffer, arg1);
    }

    private final TrieNode collisionRemove(Object arg2) {
        int v2 = ArraysKt.indexOf(this.buffer, arg2);
        if(v2 != -1) {
            this = this.collisionRemoveElementAtIndex(v2);
        }

        return this;
    }

    private final TrieNode collisionRemoveElementAtIndex(int arg2) {
        return new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, arg2));
    }

    public final boolean contains(int arg4, Object arg5, int arg6) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg4, arg6);
        if(this.hasNoCellAt(v0)) {
            return 0;
        }

        v0 = this.indexOfCellAt$runtime(v0);
        Object v1 = this.buffer[v0];
        if((v1 instanceof TrieNode)) {
            this = this.nodeAtIndex(v0);
            if(arg6 == 30) {
                return this.collisionContainsElement(arg5);
            }

            return this.contains(arg4, arg5, arg6 + 5);
        }

        return Intrinsics.areEqual(arg5, v1);
    }

    public final boolean containsAll(TrieNode arg10, int arg11) {
        if(this == arg10) {
            return 1;
        }

        if(arg11 > 30) {
            Object[] v10 = arg10.buffer;
            arg11 = v10.length;
            int v1;
            for(v1 = 0; v1 < arg11; ++v1) {
                if(!ArraysKt.contains(this.buffer, v10[v1])) {
                    return 0;
                }
            }

            return 1;
        }

        v1 = this.bitmap & arg10.bitmap;
        if(v1 != arg10.bitmap) {
            return 0;
        }

        while(v1 != 0) {
            int v3 = Integer.lowestOneBit(v1);
            int v4 = this.indexOfCellAt$runtime(v3);
            int v5 = arg10.indexOfCellAt$runtime(v3);
            Object v4_1 = this.buffer[v4];
            Object v5_1 = arg10.buffer[v5];
            boolean v6 = v4_1 instanceof TrieNode;
            boolean v7 = v5_1 instanceof TrieNode;
            String v8 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>";
            if((v6) && (v7)) {
                Intrinsics.checkNotNull(v4_1, v8);
                Intrinsics.checkNotNull(v5_1, v8);
                if(!((TrieNode)v4_1).containsAll(((TrieNode)v5_1), arg11 + 5)) {
                    return 0;
                }
            }
            else if(v6) {
                Intrinsics.checkNotNull(v4_1, v8);
                int v6_1 = v5_1 != null ? v5_1.hashCode() : 0;
                if(((TrieNode)v4_1).contains(v6_1, v5_1, arg11 + 5)) {
                    goto label_57;
                }

                return 0;
            }
            else {
                if(v7) {
                    return 0;
                }

                if(Intrinsics.areEqual(v4_1, v5_1)) {
                    goto label_57;
                }

                return 0;
            }

        label_57:
            v1 ^= v3;
        }

        return 1;
    }

    private final Object elementAtIndex(int arg1) {
        return this.buffer[arg1];
    }

    private final boolean elementsIdentityEquals(TrieNode arg7) {
        if(this == arg7) {
            return 1;
        }

        if(this.bitmap != arg7.bitmap) {
            return 0;
        }

        int v1 = this.buffer.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(this.buffer[v2] != arg7.buffer[v2]) {
                return 0;
            }
        }

        return 1;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    private final boolean hasNoCellAt(int arg1) {
        if((this.bitmap & arg1) == 0) {
            return 1;
        }

        return 0;
    }

    public final int indexOfCellAt$runtime(int arg1) {
        return Integer.bitCount(this.bitmap & arg1 - 1);
    }

    private final TrieNode makeNode(int arg10, Object arg11, int arg12, Object arg13, int arg14, MutabilityOwnership arg15) {
        Object[] v9_1;
        if(arg14 > 30) {
            return new TrieNode(0, new Object[]{arg11, arg13}, arg15);
        }

        int v7 = TrieNodeKt.indexSegment(arg10, arg14);
        int v0 = TrieNodeKt.indexSegment(arg12, arg14);
        if(v7 != v0) {
            int v9 = 2;
            if(v7 < v0) {
                v9_1 = new Object[v9];
                v9_1[0] = arg11;
                v9_1[1] = arg13;
            }
            else {
                v9_1 = new Object[v9];
                v9_1[0] = arg13;
                v9_1[1] = arg11;
            }

            return new TrieNode(1 << v7 | 1 << v0, v9_1, arg15);
        }

        return new TrieNode(1 << v7, new Object[]{this.makeNode(arg10, arg11, arg12, arg13, arg14 + 5, arg15)}, arg15);
    }

    private final TrieNode makeNodeAtIndex(int arg8, int arg9, Object arg10, int arg11, MutabilityOwnership arg12) {
        Object v2 = this.elementAtIndex(arg8);
        arg8 = v2 != null ? v2.hashCode() : 0;
        return this.makeNode(arg8, v2, arg9, arg10, arg11 + 5, arg12);
    }

    private final TrieNode moveElementToNode(int arg9, int arg10, Object arg11, int arg12) {
        Object[] v0 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        v0[arg9] = this.makeNodeAtIndex(arg9, arg10, arg11, arg12, null);
        return new TrieNode(this.bitmap, v0);
    }

    public final TrieNode mutableAdd(int arg7, Object arg8, int arg9, PersistentHashSetBuilder arg10) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg7, arg9);
        if(this.hasNoCellAt(v0)) {
            arg10.setSize(arg10.size() + 1);
            return this.mutableAddElementAt(v0, arg8, arg10.getOwnership$runtime());
        }

        v0 = this.indexOfCellAt$runtime(v0);
        Object v2 = this.buffer[v0];
        if((v2 instanceof TrieNode)) {
            TrieNode v1 = this.nodeAtIndex(v0);
            TrieNode v7 = arg9 == 30 ? v1.mutableCollisionAdd(arg8, arg10) : v1.mutableAdd(arg7, arg8, arg9 + 5, arg10);
            if(v1 == v7) {
                return this;
            }

            return this.mutableUpdateNodeAtIndex(v0, v7, arg10.getOwnership$runtime());
        }
        else if(!Intrinsics.areEqual(arg8, v2)) {
            goto label_31;
        }

        return this;
    label_31:
        arg10.setSize(arg10.size() + 1);
        return this.mutableMoveElementToNode(v0, arg7, arg8, arg9, arg10.getOwnership$runtime());
    }

    public final TrieNode mutableAddAll(TrieNode arg19, int arg20, DeltaCounter arg21, PersistentHashSetBuilder arg22) {
        Object[] v16;
        int v5_2;
        TrieNode v1_2;
        Object v1_1;
        TrieNode v0 = this;
        TrieNode v7 = arg19;
        int v8 = arg20;
        DeltaCounter v9 = arg21;
        PersistentHashSetBuilder v10 = arg22;
        if(v0 == v7) {
            v9.setCount(v9.getCount() + v0.calculateSize());
            return v0;
        }

        if(v8 > 30) {
            return v0.mutableCollisionAddAll(v7, v9, v10.getOwnership$runtime());
        }

        int v1 = v0.bitmap;
        int v2 = v7.bitmap | v1;
        TrieNode v11 = v2 != v1 || !Intrinsics.areEqual(v0.ownedBy, v10.getOwnership$runtime()) ? new TrieNode(v2, new Object[Integer.bitCount(v2)], v10.getOwnership$runtime()) : v0;
        int v13 = v2;
        int v14 = 0;
        while(v13 != 0) {
            int v15 = Integer.lowestOneBit(v13);
            v1 = v0.indexOfCellAt$runtime(v15);
            v2 = v7.indexOfCellAt$runtime(v15);
            Object[] v3 = v11.buffer;
            if(v0.hasNoCellAt(v15)) {
                v1_1 = v7.buffer[v2];
                goto label_44;
            }
            else {
                boolean v4 = v7.hasNoCellAt(v15);
                Object[] v5 = v0.buffer;
                if(v4) {
                    v1_1 = v5[v1];
                    goto label_44;
                }
                else {
                    v1_1 = v5[v1];
                    Object v4_1 = v7.buffer[v2];
                    boolean v2_1 = v1_1 instanceof TrieNode;
                    boolean v5_1 = v4_1 instanceof TrieNode;
                    String v6 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>";
                    if((v2_1) && (v5_1)) {
                        Intrinsics.checkNotNull(v1_1, v6);
                        Intrinsics.checkNotNull(v4_1, v6);
                        v1_2 = ((TrieNode)v1_1).mutableAddAll(((TrieNode)v4_1), v8 + 5, v9, v10);
                        goto label_44;
                    }

                    if(v2_1) {
                        Intrinsics.checkNotNull(v1_1, v6);
                        v2 = v10.size();
                        v5_2 = v4_1 != null ? v4_1.hashCode() : 0;
                        v1_2 = ((TrieNode)v1_1).mutableAdd(v5_2, v4_1, v8 + 5, v10);
                        if(v10.size() != v2) {
                            goto label_44;
                        }

                        v9.setCount(v9.getCount() + 1);
                        goto label_44;
                    }

                    if(v5_1) {
                        Intrinsics.checkNotNull(v4_1, v6);
                        v2 = v10.size();
                        v5_2 = v1_1 != null ? v1_1.hashCode() : 0;
                        v1_2 = ((TrieNode)v4_1).mutableAdd(v5_2, v1_1, v8 + 5, v10);
                        if(v10.size() != v2) {
                            goto label_44;
                        }

                        v9.setCount(v9.getCount() + 1);
                        goto label_44;
                    }

                    if(Intrinsics.areEqual(v1_1, v4_1)) {
                        v9.setCount(v9.getCount() + 1);
                    label_44:
                        v16 = v3;
                        goto label_120;
                    }

                    v2 = v1_1 != null ? v1_1.hashCode() : 0;
                    v5_2 = v4_1 != null ? v4_1.hashCode() : 0;
                    v16 = v3;
                    v1_2 = v0.makeNode(v2, v1_1, v5_2, v4_1, v8 + 5, v10.getOwnership$runtime());
                }
            }

        label_120:
            v16[v14] = v1_1;
            ++v14;
            v13 ^= v15;
        }

        if(v0.elementsIdentityEquals(v11)) {
            return v0;
        }

        if(v7.elementsIdentityEquals(v11)) {
            return v7;
        }

        return v11;
    }

    private final TrieNode mutableAddElementAt(int arg4, Object arg5, MutabilityOwnership arg6) {
        int v0 = this.indexOfCellAt$runtime(arg4);
        MutabilityOwnership v1 = this.ownedBy;
        Object[] v2 = this.buffer;
        if(v1 == arg6) {
            this.buffer = TrieNodeKt.access$addElementAtIndex(v2, v0, arg5);
            this.bitmap |= arg4;
            return this;
        }

        return new TrieNode(this.bitmap | arg4, TrieNodeKt.access$addElementAtIndex(v2, v0, arg5), arg6);
    }

    private final TrieNode mutableCollisionAdd(Object arg5, PersistentHashSetBuilder arg6) {
        if(this.collisionContainsElement(arg5)) {
            return this;
        }

        arg6.setSize(arg6.size() + 1);
        MutabilityOwnership v0 = this.ownedBy;
        MutabilityOwnership v1 = arg6.getOwnership$runtime();
        Object[] v2 = this.buffer;
        if(v0 == v1) {
            this.buffer = TrieNodeKt.access$addElementAtIndex(v2, 0, arg5);
            return this;
        }

        return new TrieNode(0, TrieNodeKt.access$addElementAtIndex(v2, 0, arg5), arg6.getOwnership$runtime());
    }

    private final TrieNode mutableCollisionAddAll(TrieNode arg11, DeltaCounter arg12, MutabilityOwnership arg13) {
        Object[] v0 = this.buffer;
        if(this == arg11) {
            arg12.plusAssign(v0.length);
            return this;
        }

        v0 = Arrays.copyOf(v0, v0.length + arg11.buffer.length);
        String v1 = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(v0, v1);
        Object[] v2 = arg11.buffer;
        int v3 = this.buffer.length;
        int v5 = 0;
        int v6 = 0;
        while(v5 < v2.length) {
            boolean v7 = true;
            boolean v8 = v6 <= v5 ? true : false;
            CommonFunctionsKt.assert(v8);
            if(!this.collisionContainsElement(v2[v5])) {
                v0[v3 + v6] = v2[v5];
                ++v6;
                if(v3 + v6 <= v0.length) {
                }
                else {
                    v7 = false;
                }

                CommonFunctionsKt.assert(v7);
            }

            ++v5;
        }

        v6 += this.buffer.length;
        arg12.plusAssign(v0.length - v6);
        if(v6 == this.buffer.length) {
            return this;
        }

        if(v6 == arg11.buffer.length) {
            return arg11;
        }

        if(v6 == v0.length) {
        }
        else {
            v0 = Arrays.copyOf(v0, v6);
            Intrinsics.checkNotNullExpressionValue(v0, v1);
        }

        if(Intrinsics.areEqual(this.ownedBy, arg13)) {
            this.buffer = v0;
            return this;
        }

        return new TrieNode(0, v0, arg13);
    }

    private final TrieNode mutableCollisionRemove(Object arg3, PersistentHashSetBuilder arg4) {
        int v3 = ArraysKt.indexOf(this.buffer, arg3);
        int v0 = -1;
        if(v3 != v0) {
            arg4.setSize(arg4.size() + v0);
            this = this.mutableCollisionRemoveElementAtIndex(v3, arg4.getOwnership$runtime());
        }

        return this;
    }

    private final Object mutableCollisionRemoveAll(TrieNode arg8, DeltaCounter arg9, MutabilityOwnership arg10) {
        if(this == arg8) {
            arg9.plusAssign(this.buffer.length);
            return TrieNode.EMPTY;
        }

        boolean v0 = Intrinsics.areEqual(arg10, this.ownedBy);
        Object[] v1 = this.buffer;
        Object[] v0_1 = v0 ? v1 : new Object[v1.length];
        int v3 = 0;
        int v4 = 0;
        while(true) {
            boolean v6 = true;
            if(v3 >= v1.length) {
                break;
            }

            boolean v5 = v4 <= v3 ? true : false;
            CommonFunctionsKt.assert(v5);
            if(!arg8.collisionContainsElement(v1[v3])) {
                v0_1[v4] = v1[v3];
                ++v4;
                if(v4 <= v0_1.length) {
                }
                else {
                    v6 = false;
                }

                CommonFunctionsKt.assert(v6);
            }

            ++v3;
        }

        arg9.plusAssign(this.buffer.length - v4);
        if(v4 == 0) {
            return TrieNode.EMPTY;
        }

        if(v4 == 1) {
            return v0_1[0];
        }

        if(v4 == this.buffer.length) {
            return this;
        }

        if(v4 == v0_1.length) {
            return new TrieNode(0, v0_1, arg10);
        }

        Object[] v8 = Arrays.copyOf(v0_1, v4);
        Intrinsics.checkNotNullExpressionValue(v8, "copyOf(...)");
        return new TrieNode(0, v8, arg10);
    }

    private final TrieNode mutableCollisionRemoveElementAtIndex(int arg3, MutabilityOwnership arg4) {
        MutabilityOwnership v0 = this.ownedBy;
        Object[] v1 = this.buffer;
        if(v0 == arg4) {
            this.buffer = TrieNodeKt.access$removeCellAtIndex(v1, arg3);
            return this;
        }

        return new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(v1, arg3), arg4);
    }

    private final Object mutableCollisionRetainAll(TrieNode arg8, DeltaCounter arg9, MutabilityOwnership arg10) {
        if(this == arg8) {
            arg9.plusAssign(this.buffer.length);
            return this;
        }

        boolean v0 = Intrinsics.areEqual(arg10, this.ownedBy);
        Object[] v1 = this.buffer;
        if(v0) {
        }
        else {
            v1 = new Object[Math.min(v1.length, arg8.buffer.length)];
        }

        Object[] v0_1 = this.buffer;
        int v3 = 0;
        int v4 = 0;
        while(true) {
            boolean v6 = true;
            if(v3 >= v0_1.length) {
                break;
            }

            boolean v5 = v4 <= v3 ? true : false;
            CommonFunctionsKt.assert(v5);
            if(arg8.collisionContainsElement(v0_1[v3])) {
                v1[v4] = v0_1[v3];
                ++v4;
                if(v4 <= v1.length) {
                }
                else {
                    v6 = false;
                }

                CommonFunctionsKt.assert(v6);
            }

            ++v3;
        }

        arg9.plusAssign(v4);
        if(v4 == 0) {
            return TrieNode.EMPTY;
        }

        if(v4 == 1) {
            return v1[0];
        }

        if(v4 == this.buffer.length) {
            return this;
        }

        if(v4 == arg8.buffer.length) {
            return arg8;
        }

        if(v4 == v1.length) {
            return new TrieNode(0, v1, arg10);
        }

        Object[] v8 = Arrays.copyOf(v1, v4);
        Intrinsics.checkNotNullExpressionValue(v8, "copyOf(...)");
        return new TrieNode(0, v8, arg10);
    }

    private final TrieNode mutableMoveElementToNode(int arg3, int arg4, Object arg5, int arg6, MutabilityOwnership arg7) {
        MutabilityOwnership v0 = this.ownedBy;
        Object[] v1 = this.buffer;
        if(v0 == arg7) {
            v1[arg3] = this.makeNodeAtIndex(arg3, arg4, arg5, arg6, arg7);
            return this;
        }

        Object[] v0_1 = Arrays.copyOf(v1, v1.length);
        Intrinsics.checkNotNullExpressionValue(v0_1, "copyOf(...)");
        v0_1[arg3] = this.makeNodeAtIndex(arg3, arg4, arg5, arg6, arg7);
        return new TrieNode(this.bitmap, v0_1, arg7);
    }

    public final TrieNode mutableRemove(int arg5, Object arg6, int arg7, PersistentHashSetBuilder arg8) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg5, arg7);
        if(this.hasNoCellAt(v0)) {
        }
        else {
            int v1 = this.indexOfCellAt$runtime(v0);
            Object v2 = this.buffer[v1];
            if((v2 instanceof TrieNode)) {
                TrieNode v0_1 = this.nodeAtIndex(v1);
                TrieNode v5 = arg7 == 30 ? v0_1.mutableCollisionRemove(arg6, arg8) : v0_1.mutableRemove(arg5, arg6, arg7 + 5, arg8);
                if(this.ownedBy != arg8.getOwnership$runtime() && v0_1 == v5) {
                    return this;
                }

                return this.mutableUpdateNodeAtIndex(v1, v5, arg8.getOwnership$runtime());
            }
            else {
                if(!Intrinsics.areEqual(arg6, v2)) {
                    return this;
                }

                arg8.setSize(arg8.size() - 1);
                this = this.mutableRemoveCellAtIndex(v1, v0, arg8.getOwnership$runtime());
            }
        }

        return this;
    }

    public final Object mutableRemoveAll(TrieNode arg18, int arg19, DeltaCounter arg20, PersistentHashSetBuilder arg21) {
        TrieNode v13_1;
        int v7;
        TrieNode v6;
        TrieNode v0 = this;
        TrieNode v1 = arg18;
        int v2 = arg19;
        DeltaCounter v3 = arg20;
        PersistentHashSetBuilder v4 = arg21;
        if(v0 == v1) {
            v3.plusAssign(v0.calculateSize());
            return TrieNode.EMPTY;
        }

        if(v2 > 30) {
            return v0.mutableCollisionRemoveAll(v1, v3, v4.getOwnership$runtime());
        }

        int v5 = v0.bitmap & v1.bitmap;
        if(v5 == 0) {
        }
        else {
            if(Intrinsics.areEqual(v0.ownedBy, v4.getOwnership$runtime())) {
                v6 = v0;
            }
            else {
                v7 = v0.bitmap;
                Object[] v8 = Arrays.copyOf(v0.buffer, v0.buffer.length);
                Intrinsics.checkNotNullExpressionValue(v8, "copyOf(...)");
                v6 = new TrieNode(v7, v8, v4.getOwnership$runtime());
            }

            v7 = v0.bitmap;
            while(v5 != 0) {
                int v10 = Integer.lowestOneBit(v5);
                int v11 = v0.indexOfCellAt$runtime(v10);
                int v12 = v1.indexOfCellAt$runtime(v10);
                Object v13 = v0.buffer[v11];
                Object v12_1 = v1.buffer[v12];
                boolean v14 = v13 instanceof TrieNode;
                boolean v15 = v12_1 instanceof TrieNode;
                String v8_1 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>";
                if((v14) && (v15)) {
                    Intrinsics.checkNotNull(v13, v8_1);
                    Intrinsics.checkNotNull(v12_1, v8_1);
                    v13 = ((TrieNode)v13).mutableRemoveAll(((TrieNode)v12_1), v2 + 5, v3, v4);
                }
                else if(v14) {
                    Intrinsics.checkNotNull(v13, v8_1);
                    Object v8_2 = v13;
                    int v14_1 = v4.size();
                    int v15_1 = v12_1 != null ? v12_1.hashCode() : 0;
                    TrieNode v8_3 = ((TrieNode)v8_2).mutableRemove(v15_1, v12_1, v2 + 5, v4);
                    if(v14_1 == v4.size()) {
                        goto label_97;
                    }

                    v3.plusAssign(1);
                    Object[] v12_2 = v8_3.buffer;
                    if(v12_2.length == 1) {
                        v13 = v12_2[0];
                        if(!(v13 instanceof TrieNode)) {
                            goto label_97;
                        }
                    }

                    v13_1 = v8_3;
                }
                else {
                    if(v15) {
                        Intrinsics.checkNotNull(v12_1, v8_1);
                        int v8_4 = v13 != null ? v13.hashCode() : 0;
                        if(!((TrieNode)v12_1).contains(v8_4, v13, v2 + 5)) {
                            goto label_97;
                        }

                        v3.plusAssign(1);
                        v13_1 = TrieNode.EMPTY;
                        goto label_97;
                    }

                    if(!Intrinsics.areEqual(v13, v12_1)) {
                        goto label_97;
                    }

                    v3.plusAssign(1);
                    v13_1 = TrieNode.EMPTY;
                }

            label_97:
                if(v13_1 == TrieNode.EMPTY) {
                    v7 ^= v10;
                }

                v6.buffer[v11] = v13_1;
                v5 ^= v10;
            }

            int v1_1 = Integer.bitCount(v7);
            if(v7 == 0) {
                return TrieNode.EMPTY;
            }

            if(v7 == v0.bitmap) {
                if(v6.elementsIdentityEquals(v0)) {
                    return v0;
                }

                return v6;
            }

            if(v1_1 == 1 && v2 != 0) {
                Object v0_1 = v6.buffer[v6.indexOfCellAt$runtime(v7)];
                if((v0_1 instanceof TrieNode)) {
                    return new TrieNode(v7, new Object[]{v0_1}, v4.getOwnership$runtime());
                }
                else {
                    return v0_1;
                }
            }

            Object[] v0_2 = new Object[v1_1];
            Object[] v2_1 = v6.buffer;
            int v3_1 = 0;
            v5 = 0;
            while(v3_1 < v2_1.length) {
                boolean v6_1 = v5 <= v3_1 ? true : false;
                CommonFunctionsKt.assert(v6_1);
                if(v2_1[v3_1] != TrieNode.Companion.getEMPTY$runtime()) {
                    v0_2[v5] = v2_1[v3_1];
                    ++v5;
                    v6_1 = v5 <= v1_1 ? true : false;
                    CommonFunctionsKt.assert(v6_1);
                }

                ++v3_1;
            }

            return new TrieNode(v7, v0_2, v4.getOwnership$runtime());
        }

        return v0;
    }

    private final TrieNode mutableRemoveCellAtIndex(int arg3, int arg4, MutabilityOwnership arg5) {
        MutabilityOwnership v0 = this.ownedBy;
        Object[] v1 = this.buffer;
        if(v0 == arg5) {
            this.buffer = TrieNodeKt.access$removeCellAtIndex(v1, arg3);
            this.bitmap ^= arg4;
            return this;
        }

        return new TrieNode(this.bitmap ^ arg4, TrieNodeKt.access$removeCellAtIndex(v1, arg3), arg5);
    }

    public final Object mutableRetainAll(TrieNode arg17, int arg18, DeltaCounter arg19, PersistentHashSetBuilder arg20) {
        TrieNode v12_2;
        int v6_1;
        TrieNode v0 = this;
        TrieNode v1 = arg17;
        int v2 = arg18;
        DeltaCounter v3 = arg19;
        if(v0 == v1) {
            v3.plusAssign(v0.calculateSize());
            return v0;
        }

        if(v2 > 30) {
            return v0.mutableCollisionRetainAll(v1, v3, arg20.getOwnership$runtime());
        }

        int v4 = v0.bitmap & v1.bitmap;
        if(v4 == 0) {
            return TrieNode.EMPTY;
        }

        TrieNode v5 = !Intrinsics.areEqual(v0.ownedBy, arg20.getOwnership$runtime()) || v4 != v0.bitmap ? new TrieNode(v4, new Object[Integer.bitCount(v4)], arg20.getOwnership$runtime()) : v0;
        int v7 = v4;
        int v8 = 0;
        int v9 = 0;
        while(v7 != 0) {
            int v11 = Integer.lowestOneBit(v7);
            int v12 = v0.indexOfCellAt$runtime(v11);
            int v13 = v1.indexOfCellAt$runtime(v11);
            Object v12_1 = v0.buffer[v12];
            Object v13_1 = v1.buffer[v13];
            boolean v14 = v12_1 instanceof TrieNode;
            boolean v15 = v13_1 instanceof TrieNode;
            String v6 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>";
            if((v14) && (v15)) {
                Intrinsics.checkNotNull(v12_1, v6);
                Intrinsics.checkNotNull(v13_1, v6);
                v12_1 = ((TrieNode)v12_1).mutableRetainAll(((TrieNode)v13_1), v2 + 5, v3, arg20);
            }
            else if(v14) {
                Intrinsics.checkNotNull(v12_1, v6);
                v6_1 = v13_1 != null ? v13_1.hashCode() : 0;
                if(((TrieNode)v12_1).contains(v6_1, v13_1, v2 + 5)) {
                    v3.plusAssign(1);
                    v12_1 = v13_1;
                    goto label_88;
                }

                v12_2 = TrieNode.EMPTY;
            }
            else {
                if(v15) {
                    Intrinsics.checkNotNull(v13_1, v6);
                    v6_1 = v12_1 != null ? v12_1.hashCode() : 0;
                    if(((TrieNode)v13_1).contains(v6_1, v12_1, v2 + 5)) {
                        v3.plusAssign(1);
                        goto label_88;
                    }

                    v12_2 = TrieNode.EMPTY;
                    goto label_88;
                }

                if(Intrinsics.areEqual(v12_1, v13_1)) {
                    v3.plusAssign(1);
                    goto label_88;
                }

                v12_2 = TrieNode.EMPTY;
            }

        label_88:
            if(v12_2 != TrieNode.EMPTY) {
                v8 |= v11;
            }

            v5.buffer[v9] = v12_2;
            ++v9;
            v7 ^= v11;
        }

        int v3_1 = Integer.bitCount(v8);
        if(v8 == 0) {
            return TrieNode.EMPTY;
        }

        if(v8 == v4) {
            if(v5.elementsIdentityEquals(v0)) {
                return v0;
            }

            if(v5.elementsIdentityEquals(v1)) {
                return v1;
            }

            return v5;
        }

        if(v3_1 == 1 && v2 != 0) {
            Object v0_1 = v5.buffer[v5.indexOfCellAt$runtime(v8)];
            if((v0_1 instanceof TrieNode)) {
                return new TrieNode(v8, new Object[]{v0_1}, arg20.getOwnership$runtime());
            }
            else {
                return v0_1;
            }
        }

        Object[] v0_2 = new Object[v3_1];
        Object[] v1_1 = v5.buffer;
        v2 = 0;
        v4 = 0;
        while(v2 < v1_1.length) {
            boolean v5_1 = v4 <= v2 ? true : false;
            CommonFunctionsKt.assert(v5_1);
            if(v1_1[v2] != TrieNode.Companion.getEMPTY$runtime()) {
                v0_2[v4] = v1_1[v2];
                ++v4;
                v5_1 = v4 <= v3_1 ? true : false;
                CommonFunctionsKt.assert(v5_1);
            }

            ++v2;
        }

        return new TrieNode(v8, v0_2, arg20.getOwnership$runtime());
    }

    private final TrieNode mutableUpdateNodeAtIndex(int arg4, TrieNode arg5, MutabilityOwnership arg6) {
        Object v5;
        Object[] v0 = arg5.buffer;
        if(v0.length == 1) {
            Object v0_1 = v0[0];
            if(!(v0_1 instanceof TrieNode)) {
                if(this.buffer.length == 1) {
                    arg5.bitmap = this.bitmap;
                    return arg5;
                }
                else {
                    v5 = v0_1;
                }
            }
        }

        MutabilityOwnership v0_2 = this.ownedBy;
        Object[] v1 = this.buffer;
        if(v0_2 == arg6) {
            v1[arg4] = ((TrieNode)v5);
            return this;
        }

        v0 = Arrays.copyOf(v1, v1.length);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        v0[arg4] = ((TrieNode)v5);
        return new TrieNode(this.bitmap, v0, arg6);
    }

    private final TrieNode nodeAtIndex(int arg1) {
        Object v0 = this.buffer[arg1];
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return ((TrieNode)v0);
    }

    public final TrieNode remove(int arg5, Object arg6, int arg7) {
        int v0 = 1 << TrieNodeKt.indexSegment(arg5, arg7);
        if(this.hasNoCellAt(v0)) {
        }
        else {
            int v1 = this.indexOfCellAt$runtime(v0);
            Object v2 = this.buffer[v1];
            if((v2 instanceof TrieNode)) {
                TrieNode v0_1 = this.nodeAtIndex(v1);
                TrieNode v5 = arg7 == 30 ? v0_1.collisionRemove(arg6) : v0_1.remove(arg5, arg6, arg7 + 5);
                if(v0_1 == v5) {
                    return this;
                }

                return this.updateNodeAtIndex(v1, v5);
            }
            else {
                if(!Intrinsics.areEqual(arg6, v2)) {
                    return this;
                }

                this = this.removeCellAtIndex(v1, v0);
            }
        }

        return this;
    }

    private final TrieNode removeCellAtIndex(int arg2, int arg3) {
        return new TrieNode(this.bitmap ^ arg3, TrieNodeKt.access$removeCellAtIndex(this.buffer, arg2));
    }

    public final void setBitmap(int arg1) {
        this.bitmap = arg1;
    }

    public final void setBuffer(Object[] arg1) {
        this.buffer = arg1;
    }

    public final void setOwnedBy(MutabilityOwnership arg1) {
        this.ownedBy = arg1;
    }

    private final TrieNode updateNodeAtIndex(int arg4, TrieNode arg5) {
        Object v5;
        Object[] v0 = arg5.buffer;
        if(v0.length == 1) {
            Object v0_1 = v0[0];
            if(!(v0_1 instanceof TrieNode)) {
                if(this.buffer.length == 1) {
                    arg5.bitmap = this.bitmap;
                    return arg5;
                }
                else {
                    v5 = v0_1;
                }
            }
        }

        v0 = Arrays.copyOf(this.buffer, this.buffer.length);
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        v0[arg4] = ((TrieNode)v5);
        return new TrieNode(this.bitmap, v0);
    }
}

