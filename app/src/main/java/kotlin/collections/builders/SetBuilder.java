package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0004\b\u0000\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001(B\u001B\b@\u0012\u0010\u0010\u0006\u001A\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\b\u0010\tB\t\bV¢\u0006\u0004\b\b\u0010\nB\u0011\bV\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\b\u0010\rJ\u0010\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000FH\u0086\u0080\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0082\u0080\u0004J\u0012\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0082\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004J\u0017\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u001DJ\n\u0010\u001E\u001A\u00020\u0013H\u0096\u0080\u0004J\u0017\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u001DJ\u0017\u0010 \u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u001DJ\u0010\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"H\u0096\u0082\u0004J\u0018\u0010#\u001A\u00020\u001A2\f\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0080\bJ\u0018\u0010&\u001A\u00020\u001A2\f\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0080\bJ\u0018\u0010\'\u001A\u00020\u001A2\f\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0080\bR\u0019\u0010\u0006\u001A\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0016\u001A\u00020\f8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2={"Lkotlin/collections/builders/SetBuilder;", "E", "", "Lkotlin/collections/AbstractMutableSet;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "()V", "initialCapacity", "", "(I)V", "build", "", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "size", "getSize", "()I", "isEmpty", "", "contains", "element", "(Ljava/lang/Object;)Z", "clear", "add", "remove", "iterator", "", "addAll", "elements", "", "removeAll", "retainAll", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class SetBuilder extends AbstractMutableSet implements Serializable, Set, KMutableSet {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lkotlin/collections/builders/SetBuilder$Companion;", "", "<init>", "()V", "Empty", "Lkotlin/collections/builders/SetBuilder;", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion;
    private static final SetBuilder Empty;
    private final MapBuilder backing;

    static {
        SetBuilder.Companion = new Companion(null);
        SetBuilder.Empty = new SetBuilder(MapBuilder.Companion.getEmpty$kotlin_stdlib());
    }

    public SetBuilder() {
        this(new MapBuilder());
    }

    public SetBuilder(int arg2) {
        this(new MapBuilder(arg2));
    }

    public SetBuilder(MapBuilder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backing");
        super();
        this.backing = arg2;
    }

    public boolean add(Object arg1) {
        if(this.backing.addKey$kotlin_stdlib(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean addAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.addAll(arg2);
    }

    public final Set build() {
        this.backing.build();
        if(this.size() > 0) {
            return this;
        }

        return SetBuilder.Empty;
    }

    public void clear() {
        this.backing.clear();
    }

    public boolean contains(Object arg1) {
        return this.backing.containsKey(arg1);
    }

    public int getSize() {
        return this.backing.size();
    }

    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    public Iterator iterator() {
        return this.backing.keysIterator$kotlin_stdlib();
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public boolean remove(Object arg1) {
        return this.backing.removeKey$kotlin_stdlib(arg1);
    }

    public boolean removeAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(arg2);
    }

    public boolean retainAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(arg2);
    }

    private final Object writeReplace() {
        if(this.backing.isReadOnly$kotlin_stdlib()) {
            return new SerializedCollection(((Collection)this), 1);
        }

        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }
}

