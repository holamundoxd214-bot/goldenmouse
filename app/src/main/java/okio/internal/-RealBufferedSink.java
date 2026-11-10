package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0080\b\u001A\u0015\u0010\u0000\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001A\u00020\tH\u0080\b\u001A%\u0010\u0000\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\f\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\r\u001A\u00020\u000EH\u0080\b\u001A%\u0010\f\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u0011\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u0000\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0013H\u0080\b\u001A%\u0010\u0000\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u0014\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0015H\u0080\b\u001A\u001D\u0010\u0000\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00152\u0006\u0010\u0005\u001A\u00020\u0006H\u0080\b\u001A\u0015\u0010\u0016\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u0018\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u001A\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u001B\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u001D\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u001C\u001A\u00020\u000BH\u0080\b\u001A\u0015\u0010\u001E\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u0006H\u0080\b\u001A\u0015\u0010 \u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u0006H\u0080\b\u001A\u0015\u0010!\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u0006H\u0080\b\u001A\u0015\u0010\"\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u0006H\u0080\b\u001A\r\u0010#\u001A\u00020\u0007*\u00020\u0002H\u0080\b\u001A\r\u0010$\u001A\u00020\u0007*\u00020\u0002H\u0080\b\u001A\r\u0010%\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010&\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010\'\u001A\u00020(*\u00020\u0002H\u0080\b\u001A\r\u0010)\u001A\u00020\u000E*\u00020\u0002H\u0080\b¨\u0006*"}, d2={"commonWrite", "", "Lokio/RealBufferedSink;", "source", "Lokio/Buffer;", "byteCount", "", "Lokio/BufferedSink;", "byteString", "Lokio/ByteString;", "offset", "", "commonWriteUtf8", "string", "", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "", "commonWriteAll", "Lokio/Source;", "commonWriteByte", "b", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "v", "commonWriteLongLe", "commonWriteDecimalLong", "commonWriteHexadecimalUnsignedLong", "commonEmitCompleteSegments", "commonEmit", "commonFlush", "commonClose", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -RealBufferedSink {
    public static final void commonClose(RealBufferedSink arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.closed) {
            return;
        }

        try {
            if(arg4.bufferField.size() > 0) {
                arg4.sink.write(arg4.bufferField, arg4.bufferField.size());
            }
        }
        catch(Throwable v0) {
            goto label_17;
        }

        v0 = null;
        try {
        label_17:
            arg4.sink.close();
        }
        catch(Throwable v1) {
            if(v0 != null) {
                goto label_23;
            }

            v0 = v1;
        }

    label_23:
        arg4.closed = true;
        if(v0 == null) {
            return;
        }

        throw v0;
    }

    public static final BufferedSink commonEmit(RealBufferedSink arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(!arg4.closed) {
            long v0 = arg4.bufferField.size();
            if(v0 > 0) {
                arg4.sink.write(arg4.bufferField, v0);
            }

            return arg4;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(!arg4.closed) {
            long v0 = arg4.bufferField.completeSegmentByteCount();
            if(v0 > 0) {
                arg4.sink.write(arg4.bufferField, v0);
            }

            return arg4;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(RealBufferedSink arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(!arg4.closed) {
            if(arg4.bufferField.size() > 0) {
                arg4.sink.write(arg4.bufferField, arg4.bufferField.size());
            }

            arg4.sink.flush();
            return;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final Timeout commonTimeout(RealBufferedSink arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return "buffer(" + arg2.sink + ')';
    }

    public static final BufferedSink commonWrite(RealBufferedSink arg1, ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "byteString");
        if(!arg1.closed) {
            arg1.bufferField.write(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink arg1, ByteString arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "byteString");
        if(!arg1.closed) {
            arg1.bufferField.write(arg2, arg3, arg4);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink arg4, Source arg5, long arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "source");
        while(true) {
            if(arg6 <= 0) {
                return arg4;
            }

            long v0 = arg5.read(arg4.bufferField, arg6);
            if(v0 == -1) {
                break;
            }

            arg6 -= v0;
            arg4.emitCompleteSegments();
        }

        throw new EOFException();
        return arg4;
    }

    public static final BufferedSink commonWrite(RealBufferedSink arg1, byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!arg1.closed) {
            arg1.bufferField.write(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink arg1, byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!arg1.closed) {
            arg1.bufferField.write(arg2, arg3, arg4);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final void commonWrite(RealBufferedSink arg1, Buffer arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "source");
        if(!arg1.closed) {
            arg1.bufferField.write(arg2, arg3);
            arg1.emitCompleteSegments();
            return;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final long commonWriteAll(RealBufferedSink arg6, Source arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "source");
        long v0 = 0;
        while(true) {
            long v2 = arg7.read(arg6.bufferField, 0x2000);
            if(v2 == -1) {
                return v0;
            }

            v0 += v2;
            arg6.emitCompleteSegments();
        }

        return v0;
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeByte(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeDecimalLong(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeHexadecimalUnsignedLong(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeInt(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeIntLe(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeLong(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeLongLe(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeShort(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeShortLe(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "string");
        if(!arg1.closed) {
            arg1.bufferField.writeUtf8(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink arg1, String arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "string");
        if(!arg1.closed) {
            arg1.bufferField.writeUtf8(arg2, arg3, arg4);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(!arg1.closed) {
            arg1.bufferField.writeUtf8CodePoint(arg2);
            return arg1.emitCompleteSegments();
        }

        throw new IllegalStateException("closed".toString());
    }
}

