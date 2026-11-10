package okio;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001A\u00020\u0007H\u0016J\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0010\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u0015H\u0016J \u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001AH\u0016J \u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u0017H\u0016J\u0010\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u0017H\u0016J\u0018\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020!H\u0016J(\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u00172\u0006\u0010 \u001A\u00020!H\u0016J\u0010\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\"H\u0016J \u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\"2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u0017H\u0016J\u0010\u0010\u000F\u001A\u00020\u00172\u0006\u0010\u0011\u001A\u00020#H\u0016J\u0010\u0010$\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020%H\u0016J\u0018\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020%2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0010\u0010&\u001A\u00020\u00012\u0006\u0010\'\u001A\u00020\u0017H\u0016J\u0010\u0010(\u001A\u00020\u00012\u0006\u0010)\u001A\u00020\u0017H\u0016J\u0010\u0010*\u001A\u00020\u00012\u0006\u0010)\u001A\u00020\u0017H\u0016J\u0010\u0010+\u001A\u00020\u00012\u0006\u0010,\u001A\u00020\u0017H\u0016J\u0010\u0010-\u001A\u00020\u00012\u0006\u0010,\u001A\u00020\u0017H\u0016J\u0010\u0010.\u001A\u00020\u00012\u0006\u0010/\u001A\u00020\u0013H\u0016J\u0010\u00100\u001A\u00020\u00012\u0006\u0010/\u001A\u00020\u0013H\u0016J\u0010\u00101\u001A\u00020\u00012\u0006\u0010/\u001A\u00020\u0013H\u0016J\u0010\u00102\u001A\u00020\u00012\u0006\u0010/\u001A\u00020\u0013H\u0016J\b\u00103\u001A\u00020\u0001H\u0016J\b\u00104\u001A\u00020\u0001H\u0016J\b\u00105\u001A\u000206H\u0016J\b\u00107\u001A\u00020\u0010H\u0016J\b\u00108\u001A\u00020\tH\u0016J\b\u00109\u001A\u00020\u0010H\u0016J\b\u0010:\u001A\u00020;H\u0016J\b\u0010<\u001A\u00020\u001AH\u0016R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\n\u001A\u00020\u00078Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006="}, d2={"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "<init>", "(Lokio/Sink;)V", "bufferField", "Lokio/Buffer;", "closed", "", "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "write", "", "source", "byteCount", "", "byteString", "Lokio/ByteString;", "offset", "", "writeUtf8", "string", "", "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "charset", "Ljava/nio/charset/Charset;", "", "Ljava/nio/ByteBuffer;", "writeAll", "Lokio/Source;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "emit", "outputStream", "Ljava/io/OutputStream;", "flush", "isOpen", "close", "timeout", "Lokio/Timeout;", "toString", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        super();
        this.sink = arg2;
        this.bufferField = new Buffer();
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if(!this.closed) {
            try {
                if(this.bufferField.size() > 0) {
                    this.sink.write(this.bufferField, this.bufferField.size());
                }
            }
            catch(Throwable v0) {
                goto label_13;
            }

            v0 = null;
            try {
            label_13:
                this.sink.close();
            }
            catch(Throwable v1) {
                if(v0 != null) {
                    goto label_19;
                }

                v0 = v1;
            }

        label_19:
            this.closed = true;
            if(v0 == null) {
            }
            else {
                throw v0;
            }
        }
    }

    public BufferedSink emit() {
        if(!this.closed) {
            long v0 = this.bufferField.size();
            if(v0 > 0) {
                this.sink.write(this.bufferField, v0);
            }

            return this;
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink emitCompleteSegments() {
        if(!this.closed) {
            long v0 = this.bufferField.completeSegmentByteCount();
            if(v0 > 0) {
                this.sink.write(this.bufferField, v0);
            }

            return this;
        }

        throw new IllegalStateException("closed".toString());
    }

    public void flush() {
        if(!this.closed) {
            if(this.bufferField.size() > 0) {
                this.sink.write(this.bufferField, this.bufferField.size());
            }

            this.sink.flush();
            return;
        }

        throw new IllegalStateException("closed".toString());
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public static void getBuffer$annotations() {
    }

    public boolean isOpen() {
        return this.closed ^ 1;
    }

    public OutputStream outputStream() {
        return new RealBufferedSink$outputStream$1(this);
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    public int write(ByteBuffer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!this.closed) {
            int v2 = this.bufferField.write(arg2);
            this.emitCompleteSegments();
            return v2;
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "byteString");
        if(!this.closed) {
            this.bufferField.write(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(ByteString arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "byteString");
        if(!this.closed) {
            this.bufferField.write(arg2, arg3, arg4);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(Source arg5, long arg6) {
        Intrinsics.checkNotNullParameter(arg5, "source");
        while(true) {
            if(arg6 <= 0) {
                return this;
            }

            long v0 = arg5.read(this.bufferField, arg6);
            if(v0 == -1) {
                break;
            }

            arg6 -= v0;
            this.emitCompleteSegments();
        }

        throw new EOFException();
        return this;
    }

    public BufferedSink write(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!this.closed) {
            this.bufferField.write(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink write(byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!this.closed) {
            this.bufferField.write(arg2, arg3, arg4);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public void write(Buffer arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!this.closed) {
            this.bufferField.write(arg2, arg3);
            this.emitCompleteSegments();
            return;
        }

        throw new IllegalStateException("closed".toString());
    }

    public long writeAll(Source arg7) {
        Intrinsics.checkNotNullParameter(arg7, "source");
        long v0 = 0;
        while(true) {
            long v2 = arg7.read(this.bufferField, 0x2000);
            if(v2 == -1) {
                return v0;
            }

            v0 += v2;
            this.emitCompleteSegments();
        }

        return v0;
    }

    public BufferedSink writeByte(int arg2) {
        if(!this.closed) {
            this.bufferField.writeByte(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeDecimalLong(long arg2) {
        if(!this.closed) {
            this.bufferField.writeDecimalLong(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeHexadecimalUnsignedLong(long arg2) {
        if(!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeInt(int arg2) {
        if(!this.closed) {
            this.bufferField.writeInt(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeIntLe(int arg2) {
        if(!this.closed) {
            this.bufferField.writeIntLe(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeLong(long arg2) {
        if(!this.closed) {
            this.bufferField.writeLong(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeLongLe(long arg2) {
        if(!this.closed) {
            this.bufferField.writeLongLe(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeShort(int arg2) {
        if(!this.closed) {
            this.bufferField.writeShort(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeShortLe(int arg2) {
        if(!this.closed) {
            this.bufferField.writeShortLe(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeString(String arg2, int arg3, int arg4, Charset arg5) {
        Intrinsics.checkNotNullParameter(arg2, "string");
        Intrinsics.checkNotNullParameter(arg5, "charset");
        if(!this.closed) {
            this.bufferField.writeString(arg2, arg3, arg4, arg5);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeString(String arg2, Charset arg3) {
        Intrinsics.checkNotNullParameter(arg2, "string");
        Intrinsics.checkNotNullParameter(arg3, "charset");
        if(!this.closed) {
            this.bufferField.writeString(arg2, arg3);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeUtf8(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "string");
        if(!this.closed) {
            this.bufferField.writeUtf8(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeUtf8(String arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "string");
        if(!this.closed) {
            this.bufferField.writeUtf8(arg2, arg3, arg4);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public BufferedSink writeUtf8CodePoint(int arg2) {
        if(!this.closed) {
            this.bufferField.writeUtf8CodePoint(arg2);
            return this.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }
}

