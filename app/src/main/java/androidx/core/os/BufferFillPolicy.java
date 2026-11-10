package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \b2\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u000B\f¨\u0006\r"}, d2={"Landroidx/core/os/BufferFillPolicy;", "", "value", "", "<init>", "(I)V", "getValue$core", "()I", "Companion", "Discard", "RingBuffer", "Landroidx/core/os/BufferFillPolicy$Discard;", "Landroidx/core/os/BufferFillPolicy$RingBuffer;", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class BufferFillPolicy {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/core/os/BufferFillPolicy$Companion;", "", "<init>", "()V", "DISCARD", "Landroidx/core/os/BufferFillPolicy;", "RING_BUFFER", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/core/os/BufferFillPolicy$Discard;", "Landroidx/core/os/BufferFillPolicy;", "<init>", "()V", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Discard extends BufferFillPolicy {
        public Discard() {
            super(1, null);
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/core/os/BufferFillPolicy$RingBuffer;", "Landroidx/core/os/BufferFillPolicy;", "<init>", "()V", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class RingBuffer extends BufferFillPolicy {
        public RingBuffer() {
            super(2, null);
        }
    }

    public static final Companion Companion;
    public static final BufferFillPolicy DISCARD;
    public static final BufferFillPolicy RING_BUFFER;
    private final int value;

    static {
        BufferFillPolicy.Companion = new Companion(null);
        BufferFillPolicy.DISCARD = new Discard();
        BufferFillPolicy.RING_BUFFER = new RingBuffer();
    }

    private BufferFillPolicy(int arg1) {
        super();
        this.value = arg1;
    }

    public BufferFillPolicy(int arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public final int getValue$core() {
        return this.value;
    }
}

