package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001D\bF\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\bV¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\n\u0010\u0010\u001A\u00020\u0011H\u0082\u0080\u0004R\u0013\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "collection", "", "tag", "", "<init>", "(Ljava/util/Collection;I)V", "()V", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class SerializedCollection implements Externalizable {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0007X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0007X\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "<init>", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    private Collection collection;
    private static final long serialVersionUID = 0;
    private final int tag;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    static {
        SerializedCollection.Companion = new Companion(null);
    }

    public SerializedCollection(Collection arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "collection");
        super();
        this.collection = arg2;
        this.tag = arg3;
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    public void readExternal(ObjectInput arg6) {
        List v6_1;
        Intrinsics.checkNotNullParameter(arg6, "input");
        int v0 = arg6.readByte();
        int v1 = v0 & 1;
        char v3 = '.';
        if((v0 & -2) == 0) {
            v0 = arg6.readInt();
            if(v0 >= 0) {
                int v2 = 0;
                if(v1 == 0) {
                    List v1_2 = CollectionsKt.createListBuilder(v0);
                    while(v2 < v0) {
                        v1_2.add(arg6.readObject());
                        ++v2;
                    }

                    v6_1 = CollectionsKt.build(v1_2);
                }
                else if(v1 == 1) {
                    Set v1_1 = SetsKt.createSetBuilder(v0);
                    while(v2 < v0) {
                        v1_1.add(arg6.readObject());
                        ++v2;
                    }

                    Set v6 = SetsKt.build(v1_1);
                }
                else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + v1 + v3);
                }

                this.collection = ((Collection)v6_1);
                return;
            }

            throw new InvalidObjectException("Illegal size value: " + v0 + v3);
        }

        throw new InvalidObjectException("Unsupported flags value: " + v0 + v3);
    }

    private final Object readResolve() {
        return this.collection;
    }

    public void writeExternal(ObjectOutput arg2) {
        Intrinsics.checkNotNullParameter(arg2, "output");
        arg2.writeByte(this.tag);
        arg2.writeInt(this.collection.size());
        Iterator v1 = this.collection.iterator();
        while(v1.hasNext()) {
            arg2.writeObject(v1.next());
        }
    }
}

