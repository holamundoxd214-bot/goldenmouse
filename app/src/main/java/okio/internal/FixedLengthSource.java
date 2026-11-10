package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0005H\u0016J\u0014\u0010\u000F\u001A\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0005H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "size", "", "truncate", "", "<init>", "(Lokio/Source;JZ)V", "bytesReceived", "read", "sink", "Lokio/Buffer;", "byteCount", "truncateToSize", "", "newSize", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    public FixedLengthSource(Source arg2, long arg3, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        super(arg2);
        this.size = arg3;
        this.truncate = arg5;
    }

    public long read(Buffer arg10, long arg11) {
        Intrinsics.checkNotNullParameter(arg10, "sink");
        long v0 = this.bytesReceived;
        long v2 = this.size;
        long v5 = -1;
        long v7 = 0;
        if(Long.compare(v0, v2) > 0) {
            arg11 = v7;
        }
        else if(this.truncate) {
            v2 -= v0;
            if(v2 == v7) {
                return v5;
            }
            else {
                arg11 = Math.min(arg11, v2);
            }
        }

        arg11 = super.read(arg10, arg11);
        int v0_1 = Long.compare(arg11, v5);
        if(v0_1 != 0) {
            this.bytesReceived += arg11;
        }

        long v1 = this.bytesReceived;
        long v3 = this.size;
        if(v1 < v3 && v0_1 == 0 || v1 > v3) {
            if(arg11 > v7 && v1 > v3) {
                this.truncateToSize(arg10, arg10.size() - (this.bytesReceived - this.size));
            }

            throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
        }

        return arg11;
    }

    private final void truncateToSize(Buffer arg2, long arg3) {
        Buffer v1 = new Buffer();
        v1.writeAll(arg2);
        arg2.write(v1, arg3);
        v1.clear();
    }
}

