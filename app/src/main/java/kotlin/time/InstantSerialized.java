package kotlin.time;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\bV¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0010\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\n\u0010\u0018\u001A\u00020\u0019H\u0082\u0080\u0004R\u001B\u0010\u0002\u001A\u00020\u0003X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001B\u0010\u0004\u001A\u00020\u0005X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Lkotlin/time/InstantSerialized;", "Ljava/io/Externalizable;", "epochSeconds", "", "nanosecondsOfSecond", "", "<init>", "(JI)V", "()V", "getEpochSeconds", "()J", "setEpochSeconds", "(J)V", "getNanosecondsOfSecond", "()I", "setNanosecondsOfSecond", "(I)V", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class InstantSerialized implements Externalizable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/time/InstantSerialized$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    private long epochSeconds;
    private int nanosecondsOfSecond;
    private static final long serialVersionUID;

    static {
        InstantSerialized.Companion = new Companion(null);
    }

    public InstantSerialized(long arg1, int arg3) {
        super();
        this.epochSeconds = arg1;
        this.nanosecondsOfSecond = arg3;
    }

    public InstantSerialized() {
        this(0, 0);
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public void readExternal(ObjectInput arg3) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        this.epochSeconds = arg3.readLong();
        this.nanosecondsOfSecond = arg3.readInt();
    }

    private final Object readResolve() {
        return Instant.Companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
    }

    public final void setEpochSeconds(long arg1) {
        this.epochSeconds = arg1;
    }

    public final void setNanosecondsOfSecond(int arg1) {
        this.nanosecondsOfSecond = arg1;
    }

    public void writeExternal(ObjectOutput arg3) {
        Intrinsics.checkNotNullParameter(arg3, "output");
        arg3.writeLong(this.epochSeconds);
        arg3.writeInt(this.nanosecondsOfSecond);
    }
}

