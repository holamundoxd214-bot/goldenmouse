package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u0012H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0002J\b\u0010\u0017\u001A\u00020\u0016H\u0002J\b\u0010\u0018\u001A\u00020\u0016H\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", "", "buffer", "Lokio/Buffer;", "final", "", "closed", "read", "", "sink", "byteCount", "refill", "", "update", "doFinal", "timeout", "Lokio/Timeout;", "close", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;
    private boolean final;
    private final BufferedSource source;

    public CipherSource(BufferedSource arg2, Cipher arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "cipher");
        super();
        this.source = arg2;
        this.cipher = arg3;
        int v2 = arg3.getBlockSize();
        this.blockSize = v2;
        this.buffer = new Buffer();
        if(v2 > 0) {
            return;
        }

        throw new IllegalArgumentException("Block cipher required " + arg3.toString());
    }

    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    private final void doFinal() {
        int v0 = this.cipher.getOutputSize(0);
        if(v0 == 0) {
        }
        else {
            Segment v0_1 = this.buffer.writableSegment$okio(v0);
            int v1 = this.cipher.doFinal(v0_1.data, v0_1.pos);
            ((Segment)v0).limit += v1;
            this.buffer.setSize$okio(this.buffer.size() + (((long)v1)));
            if(v0_1.pos == v0_1.limit) {
                this.buffer.head = v0_1.pop();
                SegmentPool.recycle(v0_1);
            }
        }
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public long read(Buffer arg5, long arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg6, v0);
        if(v2 >= 0) {
            if(!this.closed) {
                if(v2 == 0) {
                    return v0;
                }

                this.refill();
                return this.buffer.read(arg5, arg6);
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg6.toString());
    }

    private final void refill() {
        while(this.buffer.size() == 0) {
            if(this.final) {
                return;
            }

            if(this.source.exhausted()) {
                this.final = true;
                this.doFinal();
                return;
            }
            else {
                this.update();
                continue;
            }

            return;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    private final void update() {
        Segment v0 = this.source.getBuffer().head;
        Intrinsics.checkNotNull(v0);
        int v1 = v0.limit - v0.pos;
        int v2 = this.cipher.getOutputSize(v1);
        int v6 = v1;
        while(v2 > 0x2000) {
            v1 = this.blockSize;
            if(v6 <= v1) {
                this.final = true;
                Buffer v0_1 = this.buffer;
                byte[] v9 = this.cipher.doFinal(this.source.readByteArray());
                Intrinsics.checkNotNullExpressionValue(v9, "doFinal(...)");
                v0_1.write(v9);
                return;
            }

            v6 -= v1;
            v2 = this.cipher.getOutputSize(v6);
        }

        Segment v1_1 = this.buffer.writableSegment$okio(v2);
        int v0_2 = this.cipher.update(v0.data, v0.pos, v6, v1_1.data, v1_1.pos);
        this.source.skip(((long)v6));
        ((Segment)v1).limit += v0_2;
        this.buffer.setSize$okio(this.buffer.size() + (((long)v0_2)));
        if(v1_1.pos == v1_1.limit) {
            this.buffer.head = v1_1.pop();
            SegmentPool.recycle(v1_1);
        }
    }
}

