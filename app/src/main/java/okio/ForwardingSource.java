package okio;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0007H\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016J\r\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0002\b\u0011R\u0013\u0010\u0002\u001A\u00020\u00018\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0005¨\u0006\u0012"}, d2={"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "()Lokio/Source;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "close", "", "toString", "", "-deprecated_delegate", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ForwardingSource implements Source {
    private final Source delegate;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final Source -deprecated_delegate() {
        return this.delegate;
    }

    public ForwardingSource(Source arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        super();
        this.delegate = arg2;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long read(Buffer arg2, long arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        return this.delegate.read(arg2, arg3);
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return this.getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}

