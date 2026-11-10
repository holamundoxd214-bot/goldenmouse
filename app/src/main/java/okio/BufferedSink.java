package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001A\u00020\u0004H\'J\u0010\u0010\u0007\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\tH&J \u0010\u0007\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH&J\u0010\u0010\u0007\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EH&J \u0010\u0007\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH&J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u0011H&J\u0018\u0010\u0007\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u0010H&J\u0010\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u0014H&J \u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u000BH&J\u0010\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u000BH&J\u0018\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u001BH&J(\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u001BH&J\u0010\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u000BH&J\u0010\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u000BH&J\u0010\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u000BH&J\u0010\u0010!\u001A\u00020\u00002\u0006\u0010\"\u001A\u00020\u000BH&J\u0010\u0010#\u001A\u00020\u00002\u0006\u0010\"\u001A\u00020\u000BH&J\u0010\u0010$\u001A\u00020\u00002\u0006\u0010%\u001A\u00020\u0010H&J\u0010\u0010&\u001A\u00020\u00002\u0006\u0010%\u001A\u00020\u0010H&J\u0010\u0010\'\u001A\u00020\u00002\u0006\u0010%\u001A\u00020\u0010H&J\u0010\u0010(\u001A\u00020\u00002\u0006\u0010%\u001A\u00020\u0010H&J\b\u0010)\u001A\u00020*H&J\b\u0010+\u001A\u00020\u0000H&J\b\u0010,\u001A\u00020\u0000H&J\b\u0010-\u001A\u00020.H&R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0004/ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, d2={"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "write", "byteString", "Lokio/ByteString;", "offset", "", "byteCount", "source", "", "writeAll", "", "Lokio/Source;", "writeUtf8", "string", "", "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "charset", "Ljava/nio/charset/Charset;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "flush", "", "emit", "emitCompleteSegments", "outputStream", "Ljava/io/OutputStream;", "Lokio/RealBufferedSink;", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public interface BufferedSink extends WritableByteChannel, Sink {
    @Deprecated(level=DeprecationLevel.WARNING, message="moved to val: use getBuffer() instead", replaceWith="<_subannotation>") Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    void flush() throws IOException;

    Buffer getBuffer();

    OutputStream outputStream();

    BufferedSink write(byte[] arg1) throws IOException;

    BufferedSink write(byte[] arg1, int arg2, int arg3) throws IOException;

    BufferedSink write(ByteString arg1) throws IOException;

    BufferedSink write(ByteString arg1, int arg2, int arg3) throws IOException;

    BufferedSink write(Source arg1, long arg2) throws IOException;

    long writeAll(Source arg1) throws IOException;

    BufferedSink writeByte(int arg1) throws IOException;

    BufferedSink writeDecimalLong(long arg1) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long arg1) throws IOException;

    BufferedSink writeInt(int arg1) throws IOException;

    BufferedSink writeIntLe(int arg1) throws IOException;

    BufferedSink writeLong(long arg1) throws IOException;

    BufferedSink writeLongLe(long arg1) throws IOException;

    BufferedSink writeShort(int arg1) throws IOException;

    BufferedSink writeShortLe(int arg1) throws IOException;

    BufferedSink writeString(String arg1, Charset arg2) throws IOException;

    BufferedSink writeString(String arg1, int arg2, int arg3, Charset arg4) throws IOException;

    BufferedSink writeUtf8(String arg1) throws IOException;

    BufferedSink writeUtf8(String arg1, int arg2, int arg3) throws IOException;

    BufferedSink writeUtf8CodePoint(int arg1) throws IOException;
}

