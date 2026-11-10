package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0007\b\'\u0018\u0000 **\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001*B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\tJ!\u0010\f\u001A\u00020\u00072\u0010\u0010\r\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000EH\u0080\u0080\u0004¢\u0006\u0002\b\u000FJ\u0014\u0010\u0010\u001A\u00020\u00072\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\u0019\u0010\u0013\u001A\u0004\u0018\u00018\u00012\u0006\u0010\b\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0014J\n\u0010\u0015\u001A\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001A\u00020\u0007H\u0096\u0080\u0004J\n\u0010 \u001A\u00020!H\u0096\u0080\u0004J\u001E\u0010 \u001A\u00020!2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000EH\u0082\u0080\u0004J\u0014\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0012H\u0082\u0080\u0004J%\u0010(\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000E2\u0006\u0010\b\u001A\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010)R\u0015\u0010\u0018\u001A\u00020\u00168VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u001B\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001C8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0017\u0010\u001F\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001CX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001B\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010$8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b%\u0010&R\u0017\u0010\'\u001A\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010$X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006+"}, d2={"Lkotlin/collections/AbstractMap;", "K", "V", "", "<init>", "()V", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "", "isEmpty", "size", "getSize", "()I", "keys", "", "getKeys", "()Ljava/util/Set;", "_keys", "toString", "", "o", "values", "", "getValues", "()Ljava/util/Collection;", "_values", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractMap implements Map, KMappedMarker {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u000E\u0010\u0006\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\bJ\u001F\u0010\t\u001A\u00020\n2\u000E\u0010\u0006\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u000BJ)\u0010\f\u001A\u00020\r2\u000E\u0010\u0006\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0080\u0080\u0004¢\u0006\u0002\b\u000F¨\u0006\u0010"}, d2={"Lkotlin/collections/AbstractMap$Companion;", "", "<init>", "()V", "entryHashCode", "", "e", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "entryEquals", "", "other", "entryEquals$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean entryEquals$kotlin_stdlib(Map$Entry arg3, Object arg4) {
            Intrinsics.checkNotNullParameter(arg3, "e");
            if(!(arg4 instanceof Map$Entry)) {
                return 0;
            }

            if((Intrinsics.areEqual(arg3.getKey(), ((Map$Entry)arg4).getKey())) && (Intrinsics.areEqual(arg3.getValue(), ((Map$Entry)arg4).getValue()))) {
                return 1;
            }

            return 0;
        }

        public final int entryHashCode$kotlin_stdlib(Map$Entry arg2) {
            Intrinsics.checkNotNullParameter(arg2, "e");
            Object v1 = arg2.getKey();
            int v0 = 0;
            int v1_1 = v1 != null ? v1.hashCode() : 0;
            Object v2 = arg2.getValue();
            if(v2 != null) {
                v0 = v2.hashCode();
            }

            return v1_1 ^ v0;
        }

        public final String entryToString$kotlin_stdlib(Map$Entry arg2) {
            Intrinsics.checkNotNullParameter(arg2, "e");
            return arg2.getKey() + '=' + arg2.getValue();
        }
    }

    public static final Companion Companion;
    private volatile Set _keys;
    private volatile Collection _values;

    static {
        AbstractMap.Companion = new Companion(null);
    }

    protected AbstractMap() {
        super();
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsEntry$kotlin_stdlib(Map$Entry arg4) {
        if(arg4 == null) {
            return 0;
        }

        Object v1 = arg4.getKey();
        Object v4 = arg4.getValue();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Object v2 = ((Map)this).get(v1);
        if(!Intrinsics.areEqual(v4, v2)) {
            return 0;
        }

        if(v2 == null) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
            if(!((Map)this).containsKey(v1)) {
                return 0;
            }
        }

        return 1;
    }

    public boolean containsKey(Object arg1) {
        if(this.implFindEntry(arg1) != null) {
            return 1;
        }

        return 0;
    }

    public boolean containsValue(Object arg3) {
        Set v2 = this.entrySet();
        if(((v2 instanceof Collection)) && (v2.isEmpty())) {
            return 0;
        }

        Iterator v2_1 = ((Iterable)v2).iterator();
        do {
            if(!v2_1.hasNext()) {
                return 0;
            }
        }
        while(!Intrinsics.areEqual(v2_1.next().getValue(), arg3));

        return 1;
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public boolean equals(Object arg5) {
        if((((AbstractMap)arg5)) == this) {
            return 1;
        }

        if(!(arg5 instanceof Map)) {
            return 0;
        }

        if(this.size() != ((Map)arg5).size()) {
            return 0;
        }

        Set v5 = ((Map)arg5).entrySet();
        if(((v5 instanceof Collection)) && (v5.isEmpty())) {
            return 1;
        }

        Iterator v5_1 = ((Iterable)v5).iterator();
        do {
            if(!v5_1.hasNext()) {
                return 1;
            }
        }
        while(this.containsEntry$kotlin_stdlib(v5_1.next()));

        return 0;
    }

    public Object get(Object arg1) {
        Map$Entry v0 = this.implFindEntry(arg1);
        if(v0 != null) {
            return v0.getValue();
        }

        return null;
    }

    public abstract Set getEntries();

    public Set getKeys() {
        if(this._keys == null) {
            this._keys = new AbstractMap$keys$1(this);
        }

        Set v1 = this._keys;
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    public int getSize() {
        return this.entrySet().size();
    }

    public Collection getValues() {
        if(this._values == null) {
            this._values = new AbstractMap$values$1(this);
        }

        Collection v1 = this._values;
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    public int hashCode() {
        return this.entrySet().hashCode();
    }

    private final Map$Entry implFindEntry(Object arg3) {
        Object v0;
        Iterator v2 = this.entrySet().iterator();
        do {
            if(v2.hasNext()) {
                v0 = v2.next();
                if(!Intrinsics.areEqual(v0.getKey(), arg3)) {
                    continue;
                }

                break;
            }
            else {
                goto label_10;
            }
        }
        while(true);

        goto label_11;
    label_10:
        Map$Entry v0_1 = null;
    label_11:
        return ((Map$Entry)v0);
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public final Set keySet() {
        return this.getKeys();
    }

    public Object put(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    private final String toString(Object arg1) {
        if((((AbstractMap)arg1)) == this) {
            return "(this Map)";
        }

        return String.valueOf(arg1);
    }

    private final String toString(Map$Entry arg3) {
        return this.toString(arg3.getKey()) + '=' + this.toString(arg3.getValue());
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.entrySet(), ", ", "{", "}", 0, null, new AbstractMap$$ExternalSyntheticLambda0(this), 24, null);
    }

    static final CharSequence toString$lambda$0(AbstractMap arg1, Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg1.toString(arg2);
    }

    public final Collection values() {
        return this.getValues();
    }
}

