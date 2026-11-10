package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ValueHolder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode$ModificationResult;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001A2\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0002\u0019\u001AB3\u0012\"\u0010\u0006\u001A\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\"\u0010\u0011\u001A\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00120\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001A\u00020\u00052\u000E\u0010\u0013\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R6\u0010\f\u001A$\u0012 \u0012\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u000E0\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "get", "T", "key", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "putValue", "value", "builder", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Builder", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentCompositionLocalHashMap extends PersistentHashMap implements PersistentCompositionLocalMap {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005B\u000F\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001A\u00020\u0007H\u0016R\u001A\u0010\u0006\u001A\u00020\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\t¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "map", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "<init>", "(Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;)V", "getMap$runtime", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "setMap$runtime", "build", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Builder extends PersistentHashMapBuilder implements androidx.compose.runtime.PersistentCompositionLocalMap$Builder {
        public static final int $stable = 8;
        private PersistentCompositionLocalHashMap map;

        static {
        }

        public Builder(PersistentCompositionLocalHashMap arg2) {
            super(arg2);
            this.map = arg2;
        }

        public PersistentCompositionLocalMap build() {
            return this.build();
        }

        public PersistentCompositionLocalHashMap build() {
            PersistentCompositionLocalHashMap v0;
            if(this.getNode$runtime() == this.map.getNode$runtime()) {
                v0 = this.map;
            }
            else {
                this.setOwnership(new MutabilityOwnership());
                v0 = new PersistentCompositionLocalHashMap(this.getNode$runtime(), this.size());
            }

            this.map = v0;
            return v0;
        }

        public PersistentMap build() {
            return this.build();
        }

        public PersistentHashMap build() {
            return this.build();
        }

        public boolean containsKey(CompositionLocal arg1) {
            return super.containsKey(arg1);
        }

        public final boolean containsKey(Object arg2) {
            if(!(arg2 instanceof CompositionLocal)) {
                return 0;
            }

            return this.containsKey(((CompositionLocal)arg2));
        }

        public boolean containsValue(ValueHolder arg1) {
            return super.containsValue(arg1);
        }

        public final boolean containsValue(Object arg2) {
            if(!(arg2 instanceof ValueHolder)) {
                return 0;
            }

            return this.containsValue(((ValueHolder)arg2));
        }

        public ValueHolder get(CompositionLocal arg1) {
            return super.get(arg1);
        }

        public final ValueHolder get(Object arg2) {
            if(!(arg2 instanceof CompositionLocal)) {
                return null;
            }

            return this.get(((CompositionLocal)arg2));
        }

        public final Object get(Object arg2) {
            if(!(arg2 instanceof CompositionLocal)) {
                return null;
            }

            return this.get(((CompositionLocal)arg2));
        }

        public final PersistentCompositionLocalHashMap getMap$runtime() {
            return this.map;
        }

        public ValueHolder getOrDefault(CompositionLocal arg1, ValueHolder arg2) {
            return super.getOrDefault(arg1, arg2);
        }

        public final ValueHolder getOrDefault(Object arg2, ValueHolder arg3) {
            if(!(arg2 instanceof CompositionLocal)) {
                return arg3;
            }

            return this.getOrDefault(((CompositionLocal)arg2), arg3);
        }

        public final Object getOrDefault(Object arg2, Object arg3) {
            if(!(arg2 instanceof CompositionLocal)) {
                return arg3;
            }

            return this.getOrDefault(((CompositionLocal)arg2), ((ValueHolder)arg3));
        }

        public ValueHolder remove(CompositionLocal arg1) {
            return super.remove(arg1);
        }

        public final ValueHolder remove(Object arg2) {
            if(!(arg2 instanceof CompositionLocal)) {
                return null;
            }

            return this.remove(((CompositionLocal)arg2));
        }

        public final Object remove(Object arg2) {
            if(!(arg2 instanceof CompositionLocal)) {
                return null;
            }

            return this.remove(((CompositionLocal)arg2));
        }

        public final void setMap$runtime(PersistentCompositionLocalHashMap arg1) {
            this.map = arg1;
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001A\u00020\u0005¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty$annotations", "getEmpty", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.Empty;
        }

        public static void getEmpty$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PersistentCompositionLocalHashMap Empty;

    static {
        PersistentCompositionLocalHashMap.Companion = new Companion(null);
        PersistentCompositionLocalHashMap.$stable = 8;
        TrieNode v1 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        PersistentCompositionLocalHashMap.Empty = new PersistentCompositionLocalHashMap(v1, 0);
    }

    public PersistentCompositionLocalHashMap(TrieNode arg1, int arg2) {
        super(arg1, arg2);
    }

    public static final PersistentCompositionLocalHashMap access$getEmpty$cp() {
        return PersistentCompositionLocalHashMap.Empty;
    }

    public Builder builder() {
        return new Builder(this);
    }

    public androidx.compose.runtime.PersistentCompositionLocalMap$Builder builder() {
        return this.builder();
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder builder() {
        return this.builder();
    }

    public PersistentHashMapBuilder builder() {
        return this.builder();
    }

    public boolean containsKey(CompositionLocal arg1) {
        return super.containsKey(arg1);
    }

    public final boolean containsKey(Object arg2) {
        if(!(arg2 instanceof CompositionLocal)) {
            return 0;
        }

        return this.containsKey(((CompositionLocal)arg2));
    }

    public boolean containsValue(ValueHolder arg1) {
        return super.containsValue(arg1);
    }

    public final boolean containsValue(Object arg2) {
        if(!(arg2 instanceof ValueHolder)) {
            return 0;
        }

        return this.containsValue(((ValueHolder)arg2));
    }

    public ValueHolder get(CompositionLocal arg1) {
        return super.get(arg1);
    }

    public final ValueHolder get(Object arg2) {
        if(!(arg2 instanceof CompositionLocal)) {
            return null;
        }

        return this.get(((CompositionLocal)arg2));
    }

    public Object get(CompositionLocal arg1) {
        return CompositionLocalMapKt.read(((PersistentCompositionLocalMap)this), arg1);
    }

    public final Object get(Object arg2) {
        if(!(arg2 instanceof CompositionLocal)) {
            return null;
        }

        return this.get(((CompositionLocal)arg2));
    }

    public ImmutableSet getEntries() {
        return super.getEntries();
    }

    public ValueHolder getOrDefault(CompositionLocal arg1, ValueHolder arg2) {
        return super.getOrDefault(arg1, arg2);
    }

    public final ValueHolder getOrDefault(Object arg2, ValueHolder arg3) {
        if(!(arg2 instanceof CompositionLocal)) {
            return arg3;
        }

        return this.getOrDefault(((CompositionLocal)arg2), arg3);
    }

    public final Object getOrDefault(Object arg2, Object arg3) {
        if(!(arg2 instanceof CompositionLocal)) {
            return arg3;
        }

        return this.getOrDefault(((CompositionLocal)arg2), ((ValueHolder)arg3));
    }

    public PersistentCompositionLocalMap putValue(CompositionLocal arg4, ValueHolder arg5) {
        ModificationResult v4 = this.getNode$runtime().put(arg4.hashCode(), arg4, arg5, 0);
        if(v4 == null) {
            return this;
        }

        return new PersistentCompositionLocalHashMap(v4.getNode(), this.size() + v4.getSizeDelta());
    }
}

