package kotlin.uuid;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\bV¢\u0006\u0004\b\u0005\u0010\u0007J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\n\u0010\u0015\u001A\u00020\u0016H\u0082\u0080\u0004R\u001B\u0010\u0002\u001A\u00020\u0003X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001B\u0010\u0004\u001A\u00020\u0003X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000B¨\u0006\u0018"}, d2={"Lkotlin/uuid/UuidSerialized;", "Ljava/io/Externalizable;", "mostSignificantBits", "", "leastSignificantBits", "<init>", "(JJ)V", "()V", "getMostSignificantBits", "()J", "setMostSignificantBits", "(J)V", "getLeastSignificantBits", "setLeastSignificantBits", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class UuidSerialized implements Externalizable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/uuid/UuidSerialized$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    private long leastSignificantBits;
    private long mostSignificantBits;
    private static final long serialVersionUID;

    static {
        UuidSerialized.Companion = new Companion(null);
    }

    public UuidSerialized(long arg1, long arg3) {
        super();
        this.mostSignificantBits = arg1;
        this.leastSignificantBits = arg3;
    }

    public UuidSerialized() {
        this(0, 0);
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public void readExternal(ObjectInput arg3) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        this.mostSignificantBits = arg3.readLong();
        this.leastSignificantBits = arg3.readLong();
    }

    private final Object readResolve() {
        return Uuid.Companion.fromLongs(this.mostSignificantBits, this.leastSignificantBits);
    }

    public final void setLeastSignificantBits(long arg1) {
        this.leastSignificantBits = arg1;
    }

    public final void setMostSignificantBits(long arg1) {
        this.mostSignificantBits = arg1;
    }

    public void writeExternal(ObjectOutput arg3) {
        Intrinsics.checkNotNullParameter(arg3, "output");
        arg3.writeLong(this.mostSignificantBits);
        arg3.writeLong(this.leastSignificantBits);
    }
}

