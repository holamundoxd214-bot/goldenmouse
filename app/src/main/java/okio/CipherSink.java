package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0018\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0013H\u0002J\b\u0010\u0016\u001A\u00020\u000FH\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u000FH\u0016J\n\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", "", "closed", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "update", "remaining", "flush", "timeout", "Lokio/Timeout;", "close", "doFinal", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink arg2, Cipher arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        Intrinsics.checkNotNullParameter(arg3, "cipher");
        super();
        this.sink = arg2;
        this.cipher = arg3;
        int v2 = arg3.getBlockSize();
        this.blockSize = v2;
        if(v2 > 0) {
            return;
        }

        throw new IllegalArgumentException("Block cipher required " + arg3.toString());
    }

    public void close() throws IOException {
        if(this.closed) {
            return;
        }

        this.closed = true;
        Throwable v0 = this.doFinal();
        try {
            this.sink.close();
        }
        catch(Throwable v1) {
            if(v0 != null) {
                goto label_12;
            }

            v0 = v1;
        }

    label_12:
        if(v0 == null) {
            return;
        }

        throw v0;
    }

    private final Throwable doFinal() {
        int v0 = this.cipher.getOutputSize(0);
        Throwable v1 = null;
        if(v0 == 0) {
            return v1;
        }

        BufferedSink v2 = this.sink;
        if(v0 > 0x2000) {
            try {
                byte[] v7_1 = this.cipher.doFinal();
                Intrinsics.checkNotNullExpressionValue(v7_1, "doFinal(...)");
                v2.write(v7_1);
                return v1;
            }
            catch(Throwable v7) {
                return v7;
            }
        }

        Buffer v2_1 = v2.getBuffer();
        Segment v0_1 = v2_1.writableSegment$okio(v0);
        try {
            int v7_2 = this.cipher.doFinal(v0_1.data, v0_1.limit);
            v0_1.limit += v7_2;
            v2_1.setSize$okio(v2_1.size() + (((long)v7_2)));
        }
        catch(Throwable v7) {
            v1 = v7;
        }

        if(v0_1.pos == v0_1.limit) {
            v2_1.head = v0_1.pop();
            SegmentPool.recycle(v0_1);
        }

        return v1;
    }

    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    private final int update(Buffer arg11, long arg12) {
        Segment v0 = arg11.head;
        Intrinsics.checkNotNull(v0);
        int v1 = ((int)Math.min(arg12, ((long)(v0.limit - v0.pos))));
        Buffer v2 = this.sink.getBuffer();
        int v3 = this.cipher.getOutputSize(v1);
        int v7 = v1;
        while(v3 > 0x2000) {
            v1 = this.blockSize;
            if(v7 <= v1) {
                BufferedSink v0_1 = this.sink;
                byte[] v10 = this.cipher.update(arg11.readByteArray(arg12));
                Intrinsics.checkNotNullExpressionValue(v10, "update(...)");
                v0_1.write(v10);
                return ((int)arg12);
            }

            v7 -= v1;
            v3 = this.cipher.getOutputSize(v7);
        }

        Segment v12 = v2.writableSegment$okio(v3);
        int v13 = this.cipher.update(v0.data, v0.pos, v7, v12.data, v12.limit);
        v12.limit += v13;
        v2.setSize$okio(v2.size() + (((long)v13)));
        if(v12.pos == v12.limit) {
            v2.head = v12.pop();
            SegmentPool.recycle(v12);
        }

        this.sink.emitCompleteSegments();
        arg11.setSize$okio(arg11.size() - (((long)v7)));
        v0.pos += v7;
        if(v0.pos == v0.limit) {
            arg11.head = v0.pop();
            SegmentPool.recycle(v0);
        }

        return v7;
    }

    public void write(Buffer arg8, long arg9) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "source");
        long v5 = arg9;
        -SegmentedByteString.checkOffsetAndCount(arg8.size(), 0, v5);
        if(!this.closed) {
            for(arg9 = v5; arg9 > 0; arg9 -= ((long)this.update(arg8, arg9))) {
            }

            return;
        }

        throw new IllegalStateException("closed".toString());
    }
}

