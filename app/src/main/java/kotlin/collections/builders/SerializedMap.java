package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\bF\u0012\u000E\u0010\u0002\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\bV¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\u0010\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\rH\u0016J\n\u0010\u000E\u001A\u00020\u000FH\u0082\u0080\u0004R\u0017\u0010\u0002\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "map", "", "<init>", "(Ljava/util/Map;)V", "()V", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SerializedMap implements Externalizable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/collections/builders/SerializedMap$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    private Map map;
    private static final long serialVersionUID;

    static {
        SerializedMap.Companion = new Companion(null);
    }

    public SerializedMap(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "map");
        super();
        this.map = arg2;
    }

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    public void readExternal(ObjectInput arg6) {
        Intrinsics.checkNotNullParameter(arg6, "input");
        int v0 = arg6.readByte();
        if(v0 == 0) {
            v0 = arg6.readInt();
            if(v0 >= 0) {
                Map v1 = MapsKt.createMapBuilder(v0);
                int v2;
                for(v2 = 0; v2 < v0; ++v2) {
                    v1.put(arg6.readObject(), arg6.readObject());
                }

                this.map = MapsKt.build(v1);
                return;
            }

            throw new InvalidObjectException("Illegal size value: " + v0 + '.');
        }

        throw new InvalidObjectException("Unsupported flags value: " + v0);
    }

    private final Object readResolve() {
        return this.map;
    }

    public void writeExternal(ObjectOutput arg3) {
        Intrinsics.checkNotNullParameter(arg3, "output");
        arg3.writeByte(0);
        arg3.writeInt(this.map.size());
        Iterator v2 = this.map.entrySet().iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            arg3.writeObject(((Map$Entry)v0).getKey());
            arg3.writeObject(((Map$Entry)v0).getValue());
        }
    }
}

