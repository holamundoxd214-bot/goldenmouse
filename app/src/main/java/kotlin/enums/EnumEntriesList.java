package kotlin.enums;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u00062\u00060\u0007j\u0002`\bB\u0017\bF\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u000FH\u0096\u0082\u0004¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001AJ\n\u0010\u001C\u001A\u00020\u001DH\u0082\u0080\u0004J\u001B\u0010\u001E\u001A\u00020\u001F2\n\u0010 \u001A\u00060!j\u0002`\"H\u0082\u0080\u0004¢\u0006\u0002\u0010#R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\rR\u0015\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2={"Lkotlin/enums/EnumEntriesList;", "T", "", "Lkotlin/enums/EnumEntries;", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "entries", "", "<init>", "([Ljava/lang/Enum;)V", "[Ljava/lang/Enum;", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Enum;", "contains", "", "element", "(Ljava/lang/Enum;)Z", "indexOf", "(Ljava/lang/Enum;)I", "lastIndexOf", "writeReplace", "", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class EnumEntriesList extends AbstractList implements Serializable, RandomAccess, EnumEntries {
    private final Enum[] entries;

    public EnumEntriesList(Enum[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "entries");
        super();
        this.entries = arg2;
    }

    public boolean contains(Enum arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        if(ArraysKt.getOrNull(this.entries, arg2.ordinal()) == arg2) {
            return 1;
        }

        return 0;
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Enum)) {
            return 0;
        }

        return this.contains(((Enum)arg2));
    }

    public Enum get(int arg3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(arg3, this.entries.length);
        return this.entries[arg3];
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public int getSize() {
        return this.entries.length;
    }

    public int indexOf(Enum arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        int v0 = arg2.ordinal();
        if(ArraysKt.getOrNull(this.entries, v0) == arg2) {
            return v0;
        }

        return -1;
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof Enum)) {
            return -1;
        }

        return this.indexOf(((Enum)arg2));
    }

    public int lastIndexOf(Enum arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        return this.indexOf(arg2);
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof Enum)) {
            return -1;
        }

        return this.lastIndexOf(((Enum)arg2));
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }
}

