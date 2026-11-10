package okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.internal.-Buffer;

@Metadata(d1={"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001A\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0094\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000F\u001A\u00020\u0000H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\b\u0010\u0014\u001A\u00020\u0000H\u0016J\b\u0010\u0015\u001A\u00020\u0000H\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001A\u001A\u00020\nH\u0016J\b\u0010\u001C\u001A\u00020\u0001H\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016J$\u0010\u001F\u001A\u00020\u00002\u0006\u0010 \u001A\u00020\u00132\b\b\u0002\u0010!\u001A\u00020\n2\b\b\u0002\u0010\u001A\u001A\u00020\nH\u0007J \u0010\u001F\u001A\u00020\u00002\u0006\u0010 \u001A\u00020\u00002\b\b\u0002\u0010!\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\nJ\u0018\u0010\u001F\u001A\u00020\u00002\u0006\u0010 \u001A\u00020\u00002\b\b\u0002\u0010!\u001A\u00020\nJ\u001A\u0010\"\u001A\u00020\u00002\u0006\u0010 \u001A\u00020\u00132\b\b\u0002\u0010\u001A\u001A\u00020\nH\u0007J\u000E\u0010#\u001A\u00020\u00002\u0006\u0010$\u001A\u00020\u001EJ\u0016\u0010#\u001A\u00020\u00002\u0006\u0010$\u001A\u00020\u001E2\u0006\u0010\u001A\u001A\u00020\nJ \u0010#\u001A\u00020\u00192\u0006\u0010$\u001A\u00020\u001E2\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010%\u001A\u00020\u0017H\u0002J\u0006\u0010&\u001A\u00020\nJ\b\u0010\'\u001A\u00020(H\u0016J\u0016\u0010)\u001A\u00020(2\u0006\u0010*\u001A\u00020\nH\u0087\u0002¢\u0006\u0002\b+J\b\u0010,\u001A\u00020-H\u0016J\b\u0010.\u001A\u00020/H\u0016J\b\u00100\u001A\u00020\nH\u0016J\b\u00101\u001A\u00020-H\u0016J\b\u00102\u001A\u00020/H\u0016J\b\u00103\u001A\u00020\nH\u0016J\b\u00104\u001A\u00020\nH\u0016J\b\u00105\u001A\u00020\nH\u0016J\b\u00106\u001A\u000207H\u0016J\u0010\u00106\u001A\u0002072\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u00108\u001A\u00020/2\u0006\u00109\u001A\u00020:H\u0016J\'\u00108\u001A\u0004\u0018\u0001H;\"\b\b\u0000\u0010;*\u00020<2\f\u00109\u001A\b\u0012\u0004\u0012\u0002H;0=H\u0016¢\u0006\u0002\u0010>J\u0018\u0010?\u001A\u00020\u00192\u0006\u0010@\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010A\u001A\u00020\n2\u0006\u0010@\u001A\u00020BH\u0016J\b\u0010C\u001A\u00020DH\u0016J\u0010\u0010C\u001A\u00020D2\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010E\u001A\u00020D2\u0006\u0010F\u001A\u00020GH\u0016J\u0018\u0010E\u001A\u00020D2\u0006\u0010\u001A\u001A\u00020\n2\u0006\u0010F\u001A\u00020GH\u0016J\n\u0010H\u001A\u0004\u0018\u00010DH\u0016J\b\u0010I\u001A\u00020DH\u0016J\u0010\u0010I\u001A\u00020D2\u0006\u0010J\u001A\u00020\nH\u0016J\b\u0010K\u001A\u00020/H\u0016J\b\u0010L\u001A\u00020MH\u0016J\u0010\u0010L\u001A\u00020M2\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010N\u001A\u00020/2\u0006\u0010@\u001A\u00020MH\u0016J\u0010\u0010?\u001A\u00020\u00192\u0006\u0010@\u001A\u00020MH\u0016J \u0010N\u001A\u00020/2\u0006\u0010@\u001A\u00020M2\u0006\u0010!\u001A\u00020/2\u0006\u0010\u001A\u001A\u00020/H\u0016J\u0010\u0010N\u001A\u00020/2\u0006\u0010@\u001A\u00020OH\u0016J\u0006\u0010P\u001A\u00020\u0019J\u0010\u0010Q\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010R\u001A\u00020\u00002\u0006\u0010S\u001A\u000207H\u0016J \u0010R\u001A\u00020\u00002\u0006\u0010S\u001A\u0002072\u0006\u0010!\u001A\u00020/2\u0006\u0010\u001A\u001A\u00020/H\u0016J\u0010\u0010T\u001A\u00020\u00002\u0006\u0010U\u001A\u00020DH\u0016J \u0010T\u001A\u00020\u00002\u0006\u0010U\u001A\u00020D2\u0006\u0010V\u001A\u00020/2\u0006\u0010W\u001A\u00020/H\u0016J\u0010\u0010X\u001A\u00020\u00002\u0006\u0010Y\u001A\u00020/H\u0016J\u0018\u0010Z\u001A\u00020\u00002\u0006\u0010U\u001A\u00020D2\u0006\u0010F\u001A\u00020GH\u0016J(\u0010Z\u001A\u00020\u00002\u0006\u0010U\u001A\u00020D2\u0006\u0010V\u001A\u00020/2\u0006\u0010W\u001A\u00020/2\u0006\u0010F\u001A\u00020GH\u0016J\u0010\u0010R\u001A\u00020\u00002\u0006\u0010[\u001A\u00020MH\u0016J \u0010R\u001A\u00020\u00002\u0006\u0010[\u001A\u00020M2\u0006\u0010!\u001A\u00020/2\u0006\u0010\u001A\u001A\u00020/H\u0016J\u0010\u0010R\u001A\u00020/2\u0006\u0010[\u001A\u00020OH\u0016J\u0010\u0010\\\u001A\u00020\n2\u0006\u0010[\u001A\u00020]H\u0016J\u0018\u0010R\u001A\u00020\u00002\u0006\u0010[\u001A\u00020]2\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010^\u001A\u00020\u00002\u0006\u0010_\u001A\u00020/H\u0016J\u0010\u0010`\u001A\u00020\u00002\u0006\u0010a\u001A\u00020/H\u0016J\u0010\u0010b\u001A\u00020\u00002\u0006\u0010a\u001A\u00020/H\u0016J\u0010\u0010c\u001A\u00020\u00002\u0006\u0010d\u001A\u00020/H\u0016J\u0010\u0010e\u001A\u00020\u00002\u0006\u0010d\u001A\u00020/H\u0016J\u0010\u0010f\u001A\u00020\u00002\u0006\u0010g\u001A\u00020\nH\u0016J\u0010\u0010h\u001A\u00020\u00002\u0006\u0010g\u001A\u00020\nH\u0016J\u0010\u0010i\u001A\u00020\u00002\u0006\u0010g\u001A\u00020\nH\u0016J\u0010\u0010j\u001A\u00020\u00002\u0006\u0010g\u001A\u00020\nH\u0016J\u0015\u0010k\u001A\u00020\b2\u0006\u0010l\u001A\u00020/H\u0000¢\u0006\u0002\bmJ\u0018\u0010R\u001A\u00020\u00192\u0006\u0010[\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0018\u0010N\u001A\u00020\n2\u0006\u0010@\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\nH\u0016J\u0010\u0010n\u001A\u00020\n2\u0006\u0010_\u001A\u00020(H\u0016J\u0018\u0010n\u001A\u00020\n2\u0006\u0010_\u001A\u00020(2\u0006\u0010o\u001A\u00020\nH\u0016J \u0010n\u001A\u00020\n2\u0006\u0010_\u001A\u00020(2\u0006\u0010o\u001A\u00020\n2\u0006\u0010p\u001A\u00020\nH\u0016J\u0010\u0010n\u001A\u00020\n2\u0006\u0010q\u001A\u000207H\u0016J\u0018\u0010n\u001A\u00020\n2\u0006\u0010q\u001A\u0002072\u0006\u0010o\u001A\u00020\nH\u0016J \u0010n\u001A\u00020\n2\u0006\u0010q\u001A\u0002072\u0006\u0010o\u001A\u00020\n2\u0006\u0010p\u001A\u00020\nH\u0016J\u0010\u0010r\u001A\u00020\n2\u0006\u0010s\u001A\u000207H\u0016J\u0018\u0010r\u001A\u00020\n2\u0006\u0010s\u001A\u0002072\u0006\u0010o\u001A\u00020\nH\u0016J\u0018\u0010t\u001A\u00020\u00172\u0006\u0010!\u001A\u00020\n2\u0006\u0010q\u001A\u000207H\u0016J(\u0010t\u001A\u00020\u00172\u0006\u0010!\u001A\u00020\n2\u0006\u0010q\u001A\u0002072\u0006\u0010u\u001A\u00020/2\u0006\u0010\u001A\u001A\u00020/H\u0016J\b\u0010v\u001A\u00020\u0019H\u0016J\b\u0010w\u001A\u00020\u0017H\u0016J\b\u0010x\u001A\u00020\u0019H\u0016J\b\u0010y\u001A\u00020zH\u0016J\u0006\u0010{\u001A\u000207J\u0006\u0010|\u001A\u000207J\u0006\u0010}\u001A\u000207J\u0006\u0010~\u001A\u000207J\u0011\u0010\u007F\u001A\u0002072\u0007\u0010\u0080\u0001\u001A\u00020DH\u0002J\u0010\u0010\u0081\u0001\u001A\u0002072\u0007\u0010\u0082\u0001\u001A\u000207J\u0010\u0010\u0083\u0001\u001A\u0002072\u0007\u0010\u0082\u0001\u001A\u000207J\u0010\u0010\u0084\u0001\u001A\u0002072\u0007\u0010\u0082\u0001\u001A\u000207J\u001B\u0010\u0085\u0001\u001A\u0002072\u0007\u0010\u0080\u0001\u001A\u00020D2\u0007\u0010\u0082\u0001\u001A\u000207H\u0002J\u0015\u0010\u0086\u0001\u001A\u00020\u00172\t\u0010\u0087\u0001\u001A\u0004\u0018\u00010<H\u0096\u0002J\t\u0010\u0088\u0001\u001A\u00020/H\u0016J\t\u0010\u0089\u0001\u001A\u00020DH\u0016J\u0007\u0010\u008A\u0001\u001A\u00020\u0000J\t\u0010\u008B\u0001\u001A\u00020\u0000H\u0016J\u0007\u0010\u008C\u0001\u001A\u000207J\u000F\u0010\u008C\u0001\u001A\u0002072\u0006\u0010\u001A\u001A\u00020/J\u0016\u0010\u008D\u0001\u001A\u00030\u008E\u00012\n\b\u0002\u0010\u008F\u0001\u001A\u00030\u008E\u0001H\u0007J\u0016\u0010\u0090\u0001\u001A\u00030\u008E\u00012\n\b\u0002\u0010\u008F\u0001\u001A\u00030\u008E\u0001H\u0007J\u0017\u0010+\u001A\u00020(2\u0007\u0010\u0091\u0001\u001A\u00020\nH\u0007¢\u0006\u0003\b\u0092\u0001J\u000E\u0010\u000B\u001A\u00020\nH\u0007¢\u0006\u0003\b\u0093\u0001R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\b8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R&\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8\u0007@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0095\u0001"}, d2={"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "head", "Lokio/Segment;", "value", "", "size", "()J", "setSize$okio", "(J)V", "buffer", "getBuffer", "()Lokio/Buffer;", "outputStream", "Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "exhausted", "", "require", "", "byteCount", "request", "peek", "inputStream", "Ljava/io/InputStream;", "copyTo", "out", "offset", "writeTo", "readFrom", "input", "forever", "completeSegmentByteCount", "readByte", "", "get", "pos", "getByte", "readShort", "", "readInt", "", "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "readByteString", "Lokio/ByteString;", "select", "options", "Lokio/Options;", "T", "", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readFully", "sink", "readAll", "Lokio/Sink;", "readUtf8", "", "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readByteArray", "", "read", "Ljava/nio/ByteBuffer;", "clear", "skip", "write", "byteString", "writeUtf8", "string", "beginIndex", "endIndex", "writeUtf8CodePoint", "codePoint", "writeString", "source", "writeAll", "Lokio/Source;", "writeByte", "b", "writeShort", "s", "writeShortLe", "writeInt", "i", "writeIntLe", "writeLong", "v", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "writableSegment", "minimumCapacity", "writableSegment$okio", "indexOf", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "flush", "isOpen", "close", "timeout", "Lokio/Timeout;", "md5", "sha1", "sha256", "sha512", "digest", "algorithm", "hmacSha1", "key", "hmacSha256", "hmacSha512", "hmac", "equals", "other", "hashCode", "toString", "copy", "clone", "snapshot", "readUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readAndWriteUnsafe", "index", "-deprecated_getByte", "-deprecated_size", "UnsafeCursor", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001A\u00020\u0013J\u000E\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u000FJ\u000E\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u000FJ\u000E\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u0013J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000F8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001A\u00020\u00138\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001A\u00020\u00138\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "<init>", "()V", "buffer", "Lokio/Buffer;", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "offset", "", "data", "", "start", "", "end", "next", "seek", "resizeBuffer", "newSize", "expandBuffer", "minByteCount", "close", "", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end;
        public long offset;
        public boolean readWrite;
        private Segment segment;
        public int start;

        public UnsafeCursor() {
            super();
            this.offset = -1;
            this.start = -1;
            this.end = -1;
        }

        public void close() {
            if(this.buffer != null) {
                this.buffer = null;
                this.setSegment$okio(null);
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }

            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int arg10) {
            if(arg10 > 0) {
                int v0 = 0x2000;
                if(arg10 <= v0) {
                    Buffer v1 = this.buffer;
                    if(v1 != null) {
                        if(this.readWrite) {
                            long v2 = v1.size();
                            Segment v10 = v1.writableSegment$okio(arg10);
                            int v4 = 0x2000 - v10.limit;
                            v10.limit = v0;
                            long v5 = ((long)v4);
                            v1.setSize$okio(v2 + v5);
                            this.setSegment$okio(v10);
                            this.offset = v2;
                            this.data = v10.data;
                            this.start = 0x2000 - v4;
                            this.end = v0;
                            return v5;
                        }

                        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                    }

                    throw new IllegalStateException("not attached to a buffer".toString());
                }

                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + arg10.toString());
            }

            throw new IllegalArgumentException("minByteCount <= 0: " + arg10.toString());
        }

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long v0 = this.offset;
            Buffer v2 = this.buffer;
            Intrinsics.checkNotNull(v2);
            if(v0 != v2.size()) {
                v0 = this.offset;
                if(v0 == -1) {
                    v0 = 0;
                }
                else {
                    v0 += ((long)(this.end - this.start));
                }

                return this.seek(v0);
            }

            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long arg14) {
            Segment v3_1;
            long v6;
            Buffer v0 = this.buffer;
            if(v0 != null) {
                if(this.readWrite) {
                    long v1 = v0.size();
                    int v3 = Long.compare(arg14, v1);
                    long v4 = 0;
                    if(v3 > 0) {
                        if(v3 <= 0) {
                            goto label_74;
                        }

                        v6 = arg14 - v1;
                        int v8_1;
                        for(v8_1 = 1; v6 > v4; v8_1 = 0) {
                            Segment v9 = v0.writableSegment$okio(1);
                            int v10 = ((int)Math.min(v6, ((long)(0x2000 - v9.limit))));
                            v9.limit += v10;
                            v6 -= ((long)v10);
                            if(v8_1 == 0) {
                                continue;
                            }

                            this.setSegment$okio(v9);
                            this.offset = v1;
                            this.data = v9.data;
                            this.start = v9.limit - v10;
                            this.end = v9.limit;
                        }
                    }
                    else if(arg14 >= v4) {
                        v6 = v1 - arg14;
                        while(true) {
                            if(v6 > v4) {
                                v3_1 = v0.head;
                                Intrinsics.checkNotNull(v3_1);
                                v3_1 = v3_1.prev;
                                Intrinsics.checkNotNull(v3_1);
                                long v8 = ((long)(v3_1.limit - v3_1.pos));
                                if(v8 <= v6) {
                                    v0.head = v3_1.pop();
                                    SegmentPool.recycle(v3_1);
                                    v6 -= v8;
                                    continue;
                                }
                                else {
                                    break;
                                }
                            }

                            goto label_29;
                        }

                        v3_1.limit -= ((int)v6);
                    label_29:
                        this.setSegment$okio(null);
                        this.offset = arg14;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    }
                    else {
                        throw new IllegalArgumentException("newSize < 0: " + arg14.toString());
                    }

                label_74:
                    v0.setSize$okio(arg14);
                    return v1;
                }

                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }

            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int seek(long arg13) {
            Buffer v0 = this.buffer;
            if(v0 != null) {
                int v1 = Long.compare(arg13, -1);
                if(v1 >= 0 && arg13 <= v0.size()) {
                    if(v1 != 0) {
                        if(arg13 == v0.size()) {
                        }
                        else {
                            long v1_1 = v0.size();
                            Segment v3 = v0.head;
                            Segment v4 = v0.head;
                            long v6 = 0;
                            if(this.getSegment$okio() != null) {
                                long v8 = this.offset;
                                int v5 = this.start;
                                Segment v10 = this.getSegment$okio();
                                Intrinsics.checkNotNull(v10);
                                v8 -= ((long)(v5 - v10.pos));
                                if(v8 > arg13) {
                                    v4 = this.getSegment$okio();
                                    v1_1 = v8;
                                }
                                else {
                                    v3 = this.getSegment$okio();
                                    v6 = v8;
                                }
                            }

                            if(v1_1 - arg13 > arg13 - v6) {
                                while(true) {
                                    Intrinsics.checkNotNull(v3);
                                    if(arg13 >= (((long)(v3.limit - v3.pos))) + v6) {
                                        v6 += ((long)(v3.limit - v3.pos));
                                        v3 = v3.next;
                                        continue;
                                    }

                                    break;
                                }
                            }
                            else {
                                while(v1_1 > arg13) {
                                    Intrinsics.checkNotNull(v4);
                                    v4 = v4.prev;
                                    Intrinsics.checkNotNull(v4);
                                    v1_1 -= ((long)(v4.limit - v4.pos));
                                }

                                v6 = v1_1;
                                v3 = v4;
                            }

                            if(this.readWrite) {
                                Intrinsics.checkNotNull(v3);
                                if(v3.shared) {
                                    Segment v1_2 = v3.unsharedCopy();
                                    if(v0.head == v3) {
                                        v0.head = v1_2;
                                    }

                                    v3 = v3.push(v1_2);
                                    Segment v0_1 = v3.prev;
                                    Intrinsics.checkNotNull(v0_1);
                                    v0_1.pop();
                                }
                            }

                            this.setSegment$okio(v3);
                            this.offset = arg13;
                            Intrinsics.checkNotNull(v3);
                            this.data = v3.data;
                            this.start = v3.pos + (((int)(arg13 - v6)));
                            int v13 = v3.limit;
                            this.end = v13;
                            return v13 - this.start;
                        }
                    }

                    this.setSegment$okio(null);
                    this.offset = arg13;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                }

                throw new ArrayIndexOutOfBoundsException("offset=" + arg13 + " > size=" + v0.size());
            }

            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final void setSegment$okio(Segment arg1) {
            this.segment = arg1;
        }
    }

    public Segment head;
    private long size;

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith="<_subannotation>") public final byte -deprecated_getByte(long arg1) {
        return this.getByte(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith="<_subannotation>") public final long -deprecated_size() {
        return this.size;
    }

    public Buffer() {
        super();
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        this.skip(this.size());
    }

    public Object clone() {
        return this.clone();
    }

    public Buffer clone() {
        return this.copy();
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long v0 = this.size();
        long v2 = 0;
        if(v0 == v2) {
            return v2;
        }

        Segment v5 = this.head;
        Intrinsics.checkNotNull(v5);
        v5 = v5.prev;
        Intrinsics.checkNotNull(v5);
        if(v5.limit < 0x2000 && (v5.owner)) {
            v0 -= ((long)(v5.limit - v5.pos));
        }

        return v0;
    }

    public final Buffer copy() {
        Buffer v0 = new Buffer();
        if(this.size() == 0) {
            return v0;
        }

        Segment v1 = this.head;
        Intrinsics.checkNotNull(v1);
        Segment v2 = v1.sharedCopy();
        v0.head = v2;
        v2.prev = v2;
        v2.next = v2.prev;
        Segment v3;
        for(v3 = v1.next; v3 != v1; v3 = v3.next) {
            Segment v4 = v2.prev;
            Intrinsics.checkNotNull(v4);
            Intrinsics.checkNotNull(v3);
            v4.push(v3.sharedCopy());
        }

        v0.setSize$okio(this.size());
        return v0;
    }

    public final Buffer copyTo(OutputStream arg8, long arg9, long arg11) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "out");
        long v3 = arg9;
        long v5 = arg11;
        -SegmentedByteString.checkOffsetAndCount(this.size, v3, v5);
        arg9 = 0;
        if(v5 == arg9) {
        }
        else {
            Segment v11;
            for(v11 = this.head; true; v11 = v11.next) {
                Intrinsics.checkNotNull(v11);
                if(v3 < (((long)(v11.limit - v11.pos)))) {
                    break;
                }

                v3 -= ((long)(v11.limit - v11.pos));
            }

            Segment v0 = v11;
            arg11 = v5;
            while(arg11 > arg9) {
                Intrinsics.checkNotNull(v0);
                int v1 = ((int)((((long)v0.pos)) + v3));
                int v2 = ((int)Math.min(((long)(v0.limit - v1)), arg11));
                arg8.write(v0.data, v1, v2);
                arg11 -= ((long)v2);
                v0 = v0.next;
                v3 = arg9;
            }
        }

        return this;
    }

    public final Buffer copyTo(Buffer arg9, long arg10) {
        Intrinsics.checkNotNullParameter(arg9, "out");
        return this.copyTo(arg9, arg10, this.size - arg10);
    }

    public final Buffer copyTo(Buffer arg8, long arg9, long arg11) {
        Intrinsics.checkNotNullParameter(arg8, "out");
        long v3 = arg9;
        long v5 = arg11;
        -SegmentedByteString.checkOffsetAndCount(this.size(), v3, v5);
        arg9 = 0;
        if(v5 == arg9) {
        }
        else {
            arg8.setSize$okio(arg8.size() + v5);
            Segment v11;
            for(v11 = this.head; true; v11 = v11.next) {
                Intrinsics.checkNotNull(v11);
                if(v3 < (((long)(v11.limit - v11.pos)))) {
                    break;
                }

                v3 -= ((long)(v11.limit - v11.pos));
            }

            Segment v0 = v11;
            arg11 = v5;
            while(arg11 > arg9) {
                Intrinsics.checkNotNull(v0);
                Segment v1 = v0.sharedCopy();
                v1.pos += ((int)v3);
                v1.limit = Math.min(v1.pos + (((int)arg11)), v1.limit);
                Segment v2 = arg8.head;
                if(v2 == null) {
                    v1.prev = v1;
                    v1.next = v1.prev;
                    arg8.head = v1.next;
                }
                else {
                    Intrinsics.checkNotNull(v2);
                    v2 = v2.prev;
                    Intrinsics.checkNotNull(v2);
                    v2.push(v1);
                }

                arg11 -= ((long)(v1.limit - v1.pos));
                v0 = v0.next;
                v3 = arg9;
            }
        }

        return this;
    }

    public final Buffer copyTo(OutputStream arg10) throws IOException {
        Intrinsics.checkNotNullParameter(arg10, "out");
        return Buffer.copyTo$default(this, arg10, 0, 0, 6, null);
    }

    public final Buffer copyTo(OutputStream arg10, long arg11) throws IOException {
        Intrinsics.checkNotNullParameter(arg10, "out");
        return Buffer.copyTo$default(this, arg10, arg11, 0, 4, null);
    }

    public static Buffer copyTo$default(Buffer arg6, OutputStream arg7, long arg8, long arg10, int arg12, Object arg13) throws IOException {
        if((arg12 & 2) != 0) {
            arg8 = 0;
        }

        long v2 = arg8;
        if((arg12 & 4) != 0) {
            arg10 = arg6.size - v2;
        }

        return arg6.copyTo(arg7, v2, arg10);
    }

    public static Buffer copyTo$default(Buffer arg0, Buffer arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = 0;
        }

        return arg0.copyTo(arg1, arg2);
    }

    public static Buffer copyTo$default(Buffer arg6, Buffer arg7, long arg8, long arg10, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg8 = 0;
        }

        return arg6.copyTo(arg7, arg8, arg10);
    }

    private final ByteString digest(String arg6) {
        MessageDigest v6 = MessageDigest.getInstance(arg6);
        Segment v5 = this.head;
        if(v5 != null) {
            v6.update(v5.data, v5.pos, v5.limit - v5.pos);
            Segment v0 = v5.next;
            Intrinsics.checkNotNull(v0);
            while(v0 != v5) {
                v6.update(v0.data, v0.pos, v0.limit - v0.pos);
                v0 = v0.next;
                Intrinsics.checkNotNull(v0);
            }
        }

        byte[] v6_1 = v6.digest();
        Intrinsics.checkNotNullExpressionValue(v6_1, "digest(...)");
        return new ByteString(v6_1);
    }

    public Buffer emit() {
        return this;
    }

    public BufferedSink emit() {
        return this.emit();
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public BufferedSink emitCompleteSegments() {
        return this.emitCompleteSegments();
    }

    public boolean equals(Object arg19) {
        Buffer v0 = this;
        Object v1 = arg19;
        if(v0 == (((Buffer)v1))) {
            return 1;
        }

        if(!(v1 instanceof Buffer)) {
            return 0;
        }

        if(v0.size() != ((Buffer)v1).size()) {
            return 0;
        }

        long v7 = 0;
        if(v0.size() == v7) {
            return 1;
        }

        Segment v3 = v0.head;
        Intrinsics.checkNotNull(v3);
        Segment v1_1 = ((Buffer)v1).head;
        Intrinsics.checkNotNull(v1_1);
        int v5 = v3.pos;
        int v6 = v1_1.pos;
        long v9;
        for(v9 = v7; v9 < v0.size(); v9 += v11) {
            long v11 = ((long)Math.min(v3.limit - v5, v1_1.limit - v6));
            long v13 = v7;
            while(v13 < v11) {
                int v16 = v5 + 1;
                int v17 = v6 + 1;
                if(v3.data[v5] != v1_1.data[v6]) {
                    return 0;
                }

                ++v13;
                v5 = v16;
                v6 = v17;
            }

            if(v5 == v3.limit) {
                v3 = v3.next;
                Intrinsics.checkNotNull(v3);
                v5 = v3.pos;
            }

            if(v6 == v1_1.limit) {
                v1_1 = v1_1.next;
                Intrinsics.checkNotNull(v1_1);
                v6 = v1_1.pos;
            }
        }

        return 1;
    }

    public boolean exhausted() {
        if(this.size == 0) {
            return 1;
        }

        return 0;
    }

    public void flush() {
    }

    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long arg7) {
        long v2 = arg7;
        -SegmentedByteString.checkOffsetAndCount(this.size(), v2, 1);
        Segment v7 = this.head;
        if(v7 != null) {
            if(this.size() - v2 < v2) {
                long v0;
                for(v0 = this.size(); v0 > v2; v0 -= ((long)(v7.limit - v7.pos))) {
                    v7 = v7.prev;
                    Intrinsics.checkNotNull(v7);
                }

                Intrinsics.checkNotNull(v7);
                return v7.data[((int)((((long)v7.pos)) + v2 - v0))];
            }

            for(v0 = 0; true; v0 = v4) {
                long v4 = (((long)(v7.limit - v7.pos))) + v0;
                if(v4 > v2) {
                    break;
                }

                v7 = v7.next;
                Intrinsics.checkNotNull(v7);
            }

            Intrinsics.checkNotNull(v7);
            return v7.data[((int)((((long)v7.pos)) + v2 - v0))];
        }

        Intrinsics.checkNotNull(null);
        throw null;
    }

    public int hashCode() {
        Segment v0 = this.head;
        if(v0 == null) {
            return 0;
        }

        int v1 = 1;
        do {
            int v2 = v0.pos;
            int v3 = v0.limit;
            while(v2 < v3) {
                v1 = v1 * 0x1F + v0.data[v2];
                ++v2;
            }

            v0 = v0.next;
            Intrinsics.checkNotNull(v0);
        }
        while(v0 != this.head);

        return v1;
    }

    private final ByteString hmac(String arg5, ByteString arg6) {
        try {
            Mac v0 = Mac.getInstance(arg5);
            v0.init(new SecretKeySpec(arg6.internalArray$okio(), arg5));
            Segment v4_1 = this.head;
            if(v4_1 != null) {
                v0.update(v4_1.data, v4_1.pos, v4_1.limit - v4_1.pos);
                Segment v5 = v4_1.next;
                Intrinsics.checkNotNull(v5);
                while(v5 != v4_1) {
                    v0.update(v5.data, v5.pos, v5.limit - v5.pos);
                    v5 = v5.next;
                    Intrinsics.checkNotNull(v5);
                }
            }

            byte[] v5_1 = v0.doFinal();
            Intrinsics.checkNotNullExpressionValue(v5_1, "doFinal(...)");
            return new ByteString(v5_1);
        }
        catch(InvalidKeyException v4) {
            throw new IllegalArgumentException(((Throwable)v4));
        }
    }

    public final ByteString hmacSha1(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.hmac("HmacSHA1", arg2);
    }

    public final ByteString hmacSha256(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.hmac("HmacSHA256", arg2);
    }

    public final ByteString hmacSha512(ByteString arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.hmac("HmacSHA512", arg2);
    }

    public long indexOf(byte arg7) {
        return this.indexOf(arg7, 0, 0x7FFFFFFFFFFFFFFFL);
    }

    public long indexOf(byte arg10, long arg11, long arg13) {
        int v5;
        byte[] v9;
        long v0 = 0;
        if(v0 <= arg11 && arg11 <= arg13) {
            if(arg13 > this.size()) {
                arg13 = this.size();
            }

            long v3 = -1;
            if(Long.compare(arg11, arg13) == 0) {
                return v3;
            }

            Segment v2 = this.head;
            if(v2 == null) {
                return v3;
            }

            if(this.size() - arg11 < arg11) {
                for(v0 = this.size(); v0 > arg11; v0 -= ((long)(v2.limit - v2.pos))) {
                    v2 = v2.prev;
                    Intrinsics.checkNotNull(v2);
                }

                if(v2 == null) {
                    return v3;
                }

                while(v0 < arg13) {
                    v9 = v2.data;
                    v5 = ((int)Math.min(((long)v2.limit), (((long)v2.pos)) + arg13 - v0));
                    int v11;
                    for(v11 = ((int)((((long)v2.pos)) + arg11 - v0)); v11 < v5; ++v11) {
                        if(v9[v11] == arg10) {
                            goto label_46;
                        }
                    }

                    v0 += ((long)(v2.limit - v2.pos));
                    v2 = v2.next;
                    Intrinsics.checkNotNull(v2);
                    arg11 = v0;
                }

                return v3;
            }
            else {
                while(true) {
                    long v5_1 = (((long)(v2.limit - v2.pos))) + v0;
                    if(v5_1 > arg11) {
                        break;
                    }

                    v2 = v2.next;
                    Intrinsics.checkNotNull(v2);
                    v0 = v5_1;
                }

                if(v2 == null) {
                    return v3;
                }

                while(v0 < arg13) {
                    v9 = v2.data;
                    v5 = ((int)Math.min(((long)v2.limit), (((long)v2.pos)) + arg13 - v0));
                    for(v11 = ((int)((((long)v2.pos)) + arg11 - v0)); v11 < v5; ++v11) {
                        if(v9[v11] == arg10) {
                            goto label_46;
                        }
                    }

                    v0 += ((long)(v2.limit - v2.pos));
                    v2 = v2.next;
                    Intrinsics.checkNotNull(v2);
                    arg11 = v0;
                }

                return v3;
            }

        label_46:
            return (((long)(v11 - v2.pos))) + v0;
        }

        throw new IllegalArgumentException("size=" + this.size() + " fromIndex=" + arg11 + " toIndex=" + arg13.toString());
    }

    public long indexOf(byte arg7, long arg8) {
        return this.indexOf(arg7, arg8, 0x7FFFFFFFFFFFFFFFL);
    }

    public long indexOf(ByteString arg3) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "bytes");
        return this.indexOf(arg3, 0);
    }

    public long indexOf(ByteString arg8, long arg9) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "bytes");
        return this.indexOf(arg8, arg9, 0x7FFFFFFFFFFFFFFFL);
    }

    public long indexOf(ByteString arg12, long arg13, long arg15) throws IOException {
        Intrinsics.checkNotNullParameter(arg12, "bytes");
        return -Buffer.commonIndexOf$default(this, arg12, arg13, arg15, 0, 0, 24, null);
    }

    public long indexOfElement(ByteString arg3) {
        Intrinsics.checkNotNullParameter(arg3, "targetBytes");
        return this.indexOfElement(arg3, 0);
    }

    public long indexOfElement(ByteString arg12, long arg13) {
        int v11;
        int v7;
        byte[] v6_1;
        int v9;
        int v8;
        int v14;
        int v13;
        byte[] v5_1;
        byte[] v12_1;
        int v12;
        int v5;
        Intrinsics.checkNotNullParameter(arg12, "targetBytes");
        long v0 = 0;
        if(arg13 >= v0) {
            Segment v2 = this.head;
            long v3 = -1;
            if(v2 == null) {
                return v3;
            }

            int v6 = 2;
            if(Long.compare(this.size() - arg13, arg13) < 0) {
                for(v0 = this.size(); v0 > arg13; v0 -= ((long)(v2.limit - v2.pos))) {
                    v2 = v2.prev;
                    Intrinsics.checkNotNull(v2);
                }

                if(v2 == null) {
                    return v3;
                }
                else {
                    if(arg12.size() == v6) {
                        v5 = arg12.getByte(0);
                        v12 = arg12.getByte(1);
                        goto label_31;
                    }
                    else {
                        v12_1 = arg12.internalArray$okio();
                        while(true) {
                            if(v0 < this.size()) {
                                v5_1 = v2.data;
                                v13 = ((int)((((long)v2.pos)) + arg13 - v0));
                                v14 = v2.limit;
                                while(v13 < v14) {
                                    v6 = v5_1[v13];
                                    v8 = v12_1.length;
                                    v9 = 0;
                                    while(true) {
                                        if(v9 >= v8) {
                                            break;
                                        }
                                        else if(v6 != v12_1[v9]) {
                                            ++v9;
                                            continue;
                                        }
                                        else {
                                            goto label_78;
                                        }
                                    }

                                    ++v13;
                                }

                                v0 += ((long)(v2.limit - v2.pos));
                                v2 = v2.next;
                                Intrinsics.checkNotNull(v2);
                                arg13 = v0;
                                continue;
                            }

                            return v3;
                        }

                    label_31:
                        while(v0 < this.size()) {
                            v6_1 = v2.data;
                            v13 = ((int)((((long)v2.pos)) + arg13 - v0));
                            v14 = v2.limit;
                            while(true) {
                                if(v13 < v14) {
                                    v7 = v6_1[v13];
                                    if(v7 == v5) {
                                        goto label_47;
                                    }
                                    else if(v7 == v12) {
                                        goto label_47;
                                    }
                                    else {
                                        ++v13;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                return v3;
                            }

                            v0 += ((long)(v2.limit - v2.pos));
                            v2 = v2.next;
                            Intrinsics.checkNotNull(v2);
                            arg13 = v0;
                        }
                    }

                    return v3;
                }
            }
            else {
                while(true) {
                    long v9_1 = (((long)(v2.limit - v2.pos))) + v0;
                    if(v9_1 > arg13) {
                        break;
                    }

                    v2 = v2.next;
                    Intrinsics.checkNotNull(v2);
                    v0 = v9_1;
                }

                if(v2 == null) {
                    return v3;
                }

                if(arg12.size() == v6) {
                    v5 = arg12.getByte(0);
                    v12 = arg12.getByte(1);
                    goto label_110;
                }
                else {
                    v12_1 = arg12.internalArray$okio();
                    while(true) {
                        if(v0 < this.size()) {
                            v5_1 = v2.data;
                            v13 = ((int)((((long)v2.pos)) + arg13 - v0));
                            v14 = v2.limit;
                            while(v13 < v14) {
                                v6 = v5_1[v13];
                                v8 = v12_1.length;
                                v9 = 0;
                                while(true) {
                                    if(v9 >= v8) {
                                        break;
                                    }
                                    else if(v6 == v12_1[v9]) {
                                        goto label_78;
                                    }
                                    else {
                                        ++v9;
                                        continue;
                                    }
                                }

                                ++v13;
                            }

                            v0 += ((long)(v2.limit - v2.pos));
                            v2 = v2.next;
                            Intrinsics.checkNotNull(v2);
                            arg13 = v0;
                            continue;
                        }

                        return v3;
                    }

                label_78:
                    v11 = v2.pos;
                    goto label_48;
                    while(true) {
                    label_110:
                        if(v0 < this.size()) {
                            v6_1 = v2.data;
                            v13 = ((int)((((long)v2.pos)) + arg13 - v0));
                            v14 = v2.limit;
                            while(true) {
                                if(v13 < v14) {
                                    v7 = v6_1[v13];
                                    if(v7 == v5) {
                                        goto label_47;
                                    }
                                    else if(v7 == v12) {
                                        goto label_47;
                                    }
                                    else {
                                        ++v13;
                                        continue;
                                    }
                                }
                                else {
                                    break;
                                }

                                return v3;
                            }

                            v0 += ((long)(v2.limit - v2.pos));
                            v2 = v2.next;
                            Intrinsics.checkNotNull(v2);
                            arg13 = v0;
                            continue;
                        }

                        return v3;
                    }

                label_47:
                    v11 = v2.pos;
                }
            }

        label_48:
            return (((long)(v13 - v11))) + v0;
        }

        throw new IllegalArgumentException("fromIndex < 0: " + arg13.toString());
    }

    public InputStream inputStream() {
        return new Buffer$inputStream$1(this);
    }

    public boolean isOpen() {
        return 1;
    }

    public final ByteString md5() {
        return this.digest("MD5");
    }

    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(((BufferedSource)this)));
    }

    public boolean rangeEquals(long arg8, ByteString arg10) {
        Intrinsics.checkNotNullParameter(arg10, "bytes");
        return this.rangeEquals(arg8, arg10, 0, arg10.size());
    }

    public boolean rangeEquals(long arg11, ByteString arg13, int arg14, int arg15) {
        Intrinsics.checkNotNullParameter(arg13, "bytes");
        if(arg15 < 0) {
            return 0;
        }

        if(arg11 >= 0) {
            if((((long)arg15)) + arg11 > this.size()) {
            }
            else if(arg14 >= 0) {
                if(arg14 + arg15 > arg13.size()) {
                }
                else if(arg15 == 0) {
                    return 1;
                }
                else if(-Buffer.commonIndexOf(this, arg13, arg11, arg11 + 1, arg14, arg15) != -1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public int read(ByteBuffer arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg7, "sink");
        Segment v0 = this.head;
        if(v0 == null) {
            return -1;
        }

        int v1 = Math.min(arg7.remaining(), v0.limit - v0.pos);
        arg7.put(v0.data, v0.pos, v1);
        v0.pos += v1;
        this.size -= ((long)v1);
        if(v0.pos == v0.limit) {
            this.head = v0.pop();
            SegmentPool.recycle(v0);
        }

        return v1;
    }

    public int read(byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "sink");
        return this.read(arg3, 0, arg3.length);
    }

    public int read(byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "sink");
        -SegmentedByteString.checkOffsetAndCount(((long)arg8.length), ((long)arg9), ((long)arg10));
        Segment v0 = this.head;
        if(v0 == null) {
            return -1;
        }

        arg10 = Math.min(arg10, v0.limit - v0.pos);
        ArraysKt.copyInto(v0.data, arg8, arg9, v0.pos, v0.pos + arg10);
        v0.pos += arg10;
        this.setSize$okio(this.size() - (((long)arg10)));
        if(v0.pos == v0.limit) {
            this.head = v0.pop();
            SegmentPool.recycle(v0);
        }

        return arg10;
    }

    public long read(Buffer arg5, long arg6) {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        long v0 = 0;
        if(arg6 >= v0) {
            if(this.size() == v0) {
                return -1;
            }

            if(arg6 > this.size()) {
                arg6 = this.size();
            }

            arg5.write(this, arg6);
            return arg6;
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg6.toString());
    }

    public long readAll(Sink arg5) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        long v0 = this.size();
        if(v0 > 0) {
            arg5.write(this, v0);
        }

        return v0;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "unsafeCursor");
        return -Buffer.commonReadAndWriteUnsafe(this, arg2);
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return Buffer.readAndWriteUnsafe$default(this, null, 1, null);
    }

    public static UnsafeCursor readAndWriteUnsafe$default(Buffer arg0, UnsafeCursor arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new UnsafeCursor();
        }

        return arg0.readAndWriteUnsafe(arg1);
    }

    public byte readByte() throws EOFException {
        if(this.size() != 0) {
            Segment v0 = this.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v2 = v0.limit;
            int v4 = v1 + 1;
            byte v1_1 = v0.data[v1];
            this.setSize$okio(this.size() - 1);
            if(v4 == v2) {
                this.head = v0.pop();
                SegmentPool.recycle(v0);
                return v1_1;
            }

            v0.pos = v4;
            return v1_1;
        }

        throw new EOFException();
    }

    public byte[] readByteArray(long arg3) throws EOFException {
        if(arg3 >= 0 && arg3 <= 0x7FFFFFFF) {
            if(this.size() >= arg3) {
                byte[] v3 = new byte[((int)arg3)];
                this.readFully(v3);
                return v3;
            }
            else {
                throw new EOFException();
            }
        }

        throw new IllegalArgumentException("byteCount: " + arg3.toString());
    }

    public byte[] readByteArray() {
        return this.readByteArray(this.size());
    }

    public ByteString readByteString() {
        return this.readByteString(this.size());
    }

    public ByteString readByteString(long arg3) throws EOFException {
        if(arg3 >= 0 && arg3 <= 0x7FFFFFFF) {
            if(this.size() < arg3) {
                throw new EOFException();
            }
            else if(arg3 >= 0x1000) {
                ByteString v0 = this.snapshot(((int)arg3));
                this.skip(arg3);
                return v0;
            }
            else {
                return new ByteString(this.readByteArray(arg3));
            }
        }

        throw new IllegalArgumentException("byteCount: " + arg3.toString());
    }

    public long readDecimalLong() throws EOFException {
        long v17;
        int v14;
        Buffer v0 = this;
        long v3 = 0;
        if(v0.size() != v3) {
            int v1 = 0;
            int v2 = 0;
            long v8 = v3;
            long v6 = -7;
            int v5 = 0;
            while(true) {
                Segment v10 = v0.head;
                Intrinsics.checkNotNull(v10);
                byte[] v11 = v10.data;
                int v12 = v10.pos;
                int v13 = v10.limit;
                while(true) {
                    if(v12 < v13) {
                        int v15 = v11[v12];
                        if(v15 < 0x30 || v15 > 57) {
                            v17 = v3;
                            if(v15 == 45 && v1 == 0) {
                                --v6;
                                v2 = 1;
                                goto label_57;
                            }

                            break;
                        }
                        else {
                            v14 = 0x30 - v15;
                            int v16 = Long.compare(v8, -922337203685477580L);
                            if(v16 >= 0) {
                                v17 = v3;
                                if(v16 == 0 && (((long)v14)) < v6) {
                                    goto label_35;
                                }

                                v8 = v8 * 10 + (((long)v14));
                                goto label_57;
                            }

                        label_35:
                            v0 = new Buffer().writeDecimalLong(v8).writeByte(v15);
                            if(v2 == 0) {
                                v0.readByte();
                            }

                            throw new NumberFormatException("Number too large: " + v0.readUtf8());
                        }

                    label_57:
                        ++v12;
                        ++v1;
                        v3 = v17;
                        continue;
                    }
                    else {
                        goto label_63;
                    }
                }

                v5 = 1;
                goto label_64;
            label_63:
                v17 = v3;
            label_64:
                if(v12 == v13) {
                    v0.head = v10.pop();
                    SegmentPool.recycle(v10);
                }
                else {
                    v10.pos = v12;
                }

                if(v5 == 0) {
                    if(v0.head == null) {
                    }
                    else {
                        v3 = v17;
                        continue;
                    }
                }

                break;
            }

            v0.setSize$okio(v0.size() - (((long)v1)));
            v14 = v2 != 0 ? 2 : 1;
            if(v1 < v14) {
                if(v0.size() != v17) {
                    String v1_1 = v2 != 0 ? "Expected a digit" : "Expected a digit or \'-\'";
                    throw new NumberFormatException(v1_1 + " but was 0x" + -SegmentedByteString.toHexString(v0.getByte(v17)));
                }

                throw new EOFException();
            }

            if(v2 != 0) {
                return v8;
            }

            return -v8;
        }

        throw new EOFException();
    }

    private final void readFrom(InputStream arg5, long arg6, boolean arg8) throws IOException {
        int v1;
        Segment v0;
        while(true) {
            if(arg6 > 0 || (arg8)) {
                v0 = this.writableSegment$okio(1);
                v1 = arg5.read(v0.data, v0.limit, ((int)Math.min(arg6, ((long)(0x2000 - v0.limit)))));
                if(v1 == -1) {
                    if(v0.pos == v0.limit) {
                        this.head = v0.pop();
                        SegmentPool.recycle(v0);
                    }

                    if(!arg8) {
                        goto label_23;
                    }
                }
                else {
                    goto label_26;
                }
            }

            return;
        label_23:
            throw new EOFException();
        label_26:
            v0.limit += v1;
            long v0_1 = ((long)v1);
            this.size += v0_1;
            arg6 -= v0_1;
        }
    }

    public final Buffer readFrom(InputStream arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg4, "input");
        this.readFrom(arg4, 0x7FFFFFFFFFFFFFFFL, true);
        return this;
    }

    public final Buffer readFrom(InputStream arg3, long arg4) throws IOException {
        Intrinsics.checkNotNullParameter(arg3, "input");
        if(arg4 >= 0) {
            this.readFrom(arg3, arg4, false);
            return this;
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg4.toString());
    }

    public void readFully(byte[] arg4) throws EOFException {
        Intrinsics.checkNotNullParameter(arg4, "sink");
        int v0;
        for(v0 = 0; true; v0 += v1) {
            if(v0 >= arg4.length) {
                return;
            }

            int v1 = this.read(arg4, v0, arg4.length - v0);
            if(v1 == -1) {
                break;
            }
        }

        throw new EOFException();
    }

    public void readFully(Buffer arg3, long arg4) throws EOFException {
        Intrinsics.checkNotNullParameter(arg3, "sink");
        if(this.size() >= arg4) {
            arg3.write(this, arg4);
            return;
        }

        arg3.write(this, this.size());
        throw new EOFException();
    }

    public long readHexadecimalUnsignedLong() throws EOFException {
        int v11;
        byte v10;
        long v2 = 0;
        if(this.size() != v2) {
            int v0 = 0;
            int v1 = 0;
            long v4 = v2;
            do {
                Segment v6 = this.head;
                Intrinsics.checkNotNull(v6);
                byte[] v7 = v6.data;
                int v8 = v6.pos;
                int v9 = v6.limit;
                while(true) {
                    if(v8 < v9) {
                        v10 = v7[v8];
                        if(v10 < 0x30 || v10 > 57) {
                            if(v10 >= 97 && v10 <= 102) {
                                v11 = v10 - 87;
                                goto label_30;
                            }

                            if(v10 >= 65 && v10 <= 70) {
                                v11 = v10 - 55;
                                goto label_30;
                            }

                            goto label_53;
                        }
                        else {
                            v11 = v10 - 0x30;
                        }

                    label_30:
                        if((-1152921504606846976L & v4) == v2) {
                            v4 = v4 << 4 | (((long)v11));
                            ++v8;
                            ++v0;
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    goto label_65;
                }

                throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(v4).writeByte(v10).readUtf8());
            label_53:
                if(v0 != 0) {
                    v1 = 1;
                }
                else {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + -SegmentedByteString.toHexString(v10));
                }

            label_65:
                if(v8 == v9) {
                    this.head = v6.pop();
                    SegmentPool.recycle(v6);
                }
                else {
                    v6.pos = v8;
                }

                if(v1 != 0) {
                    break;
                }
            }
            while(this.head != null);

            this.setSize$okio(this.size() - (((long)v0)));
            return v4;
        }

        throw new EOFException();
    }

    public int readInt() throws EOFException {
        long v2 = 4;
        if(this.size() >= v2) {
            Segment v0 = this.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v4 = v0.limit;
            if((((long)(v4 - v1))) < v2) {
                return this.readByte() & 0xFF | ((this.readByte() & 0xFF) << 24 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 8);
            }

            byte[] v5 = v0.data;
            int v7 = v1 + 3;
            int v6 = (v5[v1 + 1] & 0xFF) << 16 | (v5[v1] & 0xFF) << 24 | (v5[v1 + 2] & 0xFF) << 8;
            v1 += 4;
            int v5_1 = v5[v7] & 0xFF | v6;
            this.setSize$okio(this.size() - v2);
            if(v1 == v4) {
                this.head = v0.pop();
                SegmentPool.recycle(v0);
                return v5_1;
            }

            v0.pos = v1;
            return v5_1;
        }

        throw new EOFException();
    }

    public int readIntLe() throws EOFException {
        return -SegmentedByteString.reverseBytes(this.readInt());
    }

    public long readLong() throws EOFException {
        long v2 = 8;
        if(this.size() >= v2) {
            Segment v0 = this.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v4 = v0.limit;
            int v6 = 0x20;
            if(Long.compare(((long)(v4 - v1)), v2) < 0) {
                return ((((long)this.readInt())) & 0xFFFFFFFFL) << v6 | 0xFFFFFFFFL & (((long)this.readInt()));
            }

            byte[] v5 = v0.data;
            int v8 = v1 + 7;
            long v6_1 = ((((long)v5[v1])) & 0xFF) << 56 | ((((long)v5[v1 + 1])) & 0xFF) << 0x30 | ((((long)v5[v1 + 2])) & 0xFF) << 40 | ((((long)v5[v1 + 3])) & 0xFF) << v6 | ((((long)v5[v1 + 4])) & 0xFF) << 24 | ((((long)v5[v1 + 5])) & 0xFF) << 16 | ((((long)v5[v1 + 6])) & 0xFF) << 8;
            v1 += 8;
            long v5_1 = v6_1 | (((long)v5[v8])) & 0xFF;
            this.setSize$okio(this.size() - v2);
            if(v1 == v4) {
                this.head = v0.pop();
                SegmentPool.recycle(v0);
                return v5_1;
            }

            v0.pos = v1;
            return v5_1;
        }

        throw new EOFException();
    }

    public long readLongLe() throws EOFException {
        return -SegmentedByteString.reverseBytes(this.readLong());
    }

    public short readShort() throws EOFException {
        long v2 = 2;
        if(this.size() >= v2) {
            Segment v0 = this.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v4 = v0.limit;
            int v6 = 2;
            if(v4 - v1 < v6) {
                return ((short)(this.readByte() & 0xFF | (this.readByte() & 0xFF) << 8));
            }

            byte[] v5 = v0.data;
            int v7 = v1 + 1;
            int v8 = (v5[v1] & 0xFF) << 8;
            v1 += v6;
            int v5_1 = v5[v7] & 0xFF | v8;
            this.setSize$okio(this.size() - v2);
            if(v1 == v4) {
                this.head = v0.pop();
                SegmentPool.recycle(v0);
            }
            else {
                v0.pos = v1;
            }

            return ((short)v5_1);
        }

        throw new EOFException();
    }

    public short readShortLe() throws EOFException {
        return -SegmentedByteString.reverseBytes(this.readShort());
    }

    public String readString(Charset arg3) {
        Intrinsics.checkNotNullParameter(arg3, "charset");
        return this.readString(this.size, arg3);
    }

    public String readString(long arg6, Charset arg8) throws EOFException {
        Intrinsics.checkNotNullParameter(arg8, "charset");
        int v0 = Long.compare(arg6, 0);
        if(v0 >= 0 && arg6 <= 0x7FFFFFFF) {
            if(this.size < arg6) {
                throw new EOFException();
            }
            else if(v0 == 0) {
                return "";
            }
            else {
                Segment v0_1 = this.head;
                Intrinsics.checkNotNull(v0_1);
                if((((long)v0_1.pos)) + arg6 > (((long)v0_1.limit))) {
                    return new String(this.readByteArray(arg6), arg8);
                }
                else {
                    int v4 = ((int)arg6);
                    String v1 = new String(v0_1.data, v0_1.pos, v4, arg8);
                    v0_1.pos += v4;
                    this.size -= arg6;
                    if(v0_1.pos == v0_1.limit) {
                        this.head = v0_1.pop();
                        SegmentPool.recycle(v0_1);
                    }

                    return v1;
                }
            }
        }

        throw new IllegalArgumentException("byteCount: " + arg6.toString());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "unsafeCursor");
        return -Buffer.commonReadUnsafe(this, arg2);
    }

    public final UnsafeCursor readUnsafe() {
        return Buffer.readUnsafe$default(this, null, 1, null);
    }

    public static UnsafeCursor readUnsafe$default(Buffer arg0, UnsafeCursor arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = new UnsafeCursor();
        }

        return arg0.readUnsafe(arg1);
    }

    public String readUtf8() {
        return this.readString(this.size, Charsets.UTF_8);
    }

    public String readUtf8(long arg2) throws EOFException {
        return this.readString(arg2, Charsets.UTF_8);
    }

    public int readUtf8CodePoint() throws EOFException {
        long v7;
        int v5;
        int v6;
        int v1;
        long v2 = 0;
        if(this.size() == v2) {
            goto label_82;
        }

        byte v0 = this.getByte(v2);
        int v2_1 = 1;
        int v3 = 0x80;
        int v4 = 0xFFFD;
        if((v0 & 0x80) == 0) {
            v1 = v0 & 0x7F;
            v6 = 0;
            v5 = 1;
        }
        else if((v0 & 0xE0) == 0xC0) {
            v1 = v0 & 0x1F;
            v5 = 2;
            v6 = v3;
        }
        else if((v0 & 0xF0) == 0xE0) {
            v1 = v0 & 15;
            v5 = 3;
            v6 = 0x800;
        }
        else if((v0 & 0xF8) == 0xF0) {
            v1 = v0 & 7;
            v5 = 4;
            v6 = 0x10000;
        }
        else {
            goto label_79;
        }

        long v9 = ((long)v5);
        if(this.size() < v9) {
            goto label_61;
        }

        while(true) {
            if(v2_1 >= v5) {
                goto label_49;
            }

            v7 = ((long)v2_1);
            int v0_1 = this.getByte(v7);
            if((v0_1 & 0xC0) != v3) {
                break;
            }

            v1 = v1 << 6 | v0_1 & 0x3F;
            ++v2_1;
        }

        this.skip(v7);
        return v4;
    label_49:
        this.skip(v9);
        if(v1 > 0x10FFFF) {
            return v4;
        }

        if(0xD800 <= v1 && v1 < 0xE000) {
            return v4;
        }

        if(v1 < v6) {
            return v4;
        }

        return v1;
    label_61:
        throw new EOFException("size < " + v5 + ": " + this.size() + " (to read code point prefixed 0x" + -SegmentedByteString.toHexString(v0) + ')');
    label_79:
        this.skip(1);
        return v4;
    label_82:
        throw new EOFException();
    }

    public String readUtf8Line() throws EOFException {
        long v0 = this.indexOf(10);
        if(v0 != -1) {
            return -Buffer.readUtf8Line(this, v0);
        }

        if(this.size() != 0) {
            return this.readUtf8(this.size());
        }

        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return this.readUtf8LineStrict(0x7FFFFFFFFFFFFFFFL);
    }

    public String readUtf8LineStrict(long arg11) throws EOFException {
        if(arg11 >= 0) {
            long v0 = 0x7FFFFFFFFFFFFFFFL;
            long v6 = 1;
            if(Long.compare(arg11, v0) == 0) {
            }
            else {
                v0 = arg11 + v6;
            }

            long v4 = v0;
            long v1 = this.indexOf(10, 0, v4);
            if(v1 != -1) {
                return -Buffer.readUtf8Line(this, v1);
            }

            if(v4 < this.size() && this.getByte(v4 - v6) == 13 && this.getByte(v4) == 10) {
                return -Buffer.readUtf8Line(this, v4);
            }

            Buffer v1_1 = new Buffer();
            this.copyTo(v1_1, 0, Math.min(0x20, this.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.size(), arg11) + " content=" + v1_1.readByteString().hex() + '…');
        }

        throw new IllegalArgumentException("limit < 0: " + arg11.toString());
    }

    public boolean request(long arg3) {
        if(this.size >= arg3) {
            return 1;
        }

        return 0;
    }

    public void require(long arg3) throws EOFException {
        if(this.size >= arg3) {
            return;
        }

        throw new EOFException();
    }

    public int select(Options arg4) {
        Intrinsics.checkNotNullParameter(arg4, "options");
        int v0 = -Buffer.selectPrefix$default(this, arg4, false, 2, null);
        int v1 = -1;
        if(v0 == v1) {
            return v1;
        }

        this.skip(((long)arg4.getByteStrings$okio()[v0].size()));
        return v0;
    }

    public Object select(TypedOptions arg2) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        int v1 = ((BufferedSource)this).select(arg2.getOptions$okio());
        if(v1 == -1) {
            return null;
        }

        return arg2.get(v1);
    }

    public final void setSize$okio(long arg1) {
        this.size = arg1;
    }

    public final ByteString sha1() {
        return this.digest("SHA-1");
    }

    public final ByteString sha256() {
        return this.digest("SHA-256");
    }

    public final ByteString sha512() {
        return this.digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long arg7) throws EOFException {
        while(true) {
            if(arg7 <= 0) {
                return;
            }

            Segment v0 = this.head;
            if(v0 == null) {
                break;
            }

            int v1 = ((int)Math.min(arg7, ((long)(v0.limit - v0.pos))));
            long v4 = ((long)v1);
            this.setSize$okio(this.size() - v4);
            arg7 -= v4;
            v0.pos += v1;
            if(v0.pos != v0.limit) {
                continue;
            }

            this.head = v0.pop();
            SegmentPool.recycle(v0);
        }

        throw new EOFException();
    }

    public final ByteString snapshot(int arg7) {
        if(arg7 == 0) {
            return ByteString.EMPTY;
        }

        -SegmentedByteString.checkOffsetAndCount(this.size(), 0, ((long)arg7));
        Segment v0 = this.head;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(true) {
            if(v2 >= arg7) {
                goto label_27;
            }

            Intrinsics.checkNotNull(v0);
            if(v0.limit == v0.pos) {
                break;
            }

            v2 += v0.limit - v0.pos;
            ++v3;
            v0 = v0.next;
        }

        throw new AssertionError("s.limit == s.pos");
    label_27:
        byte[][] v0_1 = new byte[v3][];
        int[] v2_1 = new int[v3 * 2];
        Segment v6 = this.head;
        v3 = 0;
        while(v1 < arg7) {
            Intrinsics.checkNotNull(v6);
            v0_1[v3] = v6.data;
            v1 += v6.limit - v6.pos;
            v2_1[v3] = Math.min(v1, arg7);
            v2_1[v0_1.length + v3] = v6.pos;
            v6.shared = true;
            ++v3;
            v6 = v6.next;
        }

        return new SegmentedByteString(v0_1, v2_1);
    }

    public final ByteString snapshot() {
        if(this.size() <= 0x7FFFFFFF) {
            return this.snapshot(((int)this.size()));
        }

        throw new IllegalStateException("size > Int.MAX_VALUE: " + this.size().toString());
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return this.snapshot().toString();
    }

    public final Segment writableSegment$okio(int arg3) {
        if(arg3 >= 1) {
            int v0 = 0x2000;
            if(arg3 <= v0) {
                Segment v1 = this.head;
                if(v1 == null) {
                    Segment v3 = SegmentPool.take();
                    this.head = v3;
                    v3.prev = v3;
                    v3.next = v3;
                    return v3;
                }
                else {
                    Intrinsics.checkNotNull(v1);
                    Segment v2 = v1.prev;
                    Intrinsics.checkNotNull(v2);
                    if(v2.limit + arg3 <= v0) {
                        if(!v2.owner) {
                        }
                        else {
                            return v2;
                        }
                    }

                    return v2.push(SegmentPool.take());
                }
            }
        }

        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public Buffer write(byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        return this.write(arg3, 0, arg3.length);
    }

    public Buffer write(byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "source");
        long v5 = ((long)arg10);
        -SegmentedByteString.checkOffsetAndCount(((long)arg8.length), ((long)arg9), v5);
        arg10 += arg9;
        while(arg9 < arg10) {
            Segment v0 = this.writableSegment$okio(1);
            int v1 = Math.min(arg10 - arg9, 0x2000 - v0.limit);
            int v4 = arg9 + v1;
            ArraysKt.copyInto(arg8, v0.data, v0.limit, arg9, v4);
            v0.limit += v1;
            arg9 = v4;
        }

        this.setSize$okio(this.size() + v5);
        return this;
    }

    public void write(Buffer arg8, long arg9) {
        long v1_1;
        Intrinsics.checkNotNullParameter(arg8, "source");
        if(arg8 != this) {
            -SegmentedByteString.checkOffsetAndCount(arg8.size(), 0, arg9);
            while(arg9 > 0) {
                Segment v0 = arg8.head;
                Intrinsics.checkNotNull(v0);
                int v0_1 = v0.limit;
                Segment v1 = arg8.head;
                Intrinsics.checkNotNull(v1);
                if(arg9 < (((long)(v0_1 - v1.pos)))) {
                    v0 = this.head;
                    if(v0 != null) {
                        Intrinsics.checkNotNull(v0);
                        v0 = v0.prev;
                    }
                    else {
                        v0 = null;
                    }

                    if(v0 != null && (v0.owner)) {
                        v1_1 = (((long)v0.limit)) + arg9;
                        int v3 = v0.shared ? 0 : v0.pos;
                        if(v1_1 - (((long)v3)) > 0x2000) {
                            goto label_50;
                        }

                        v1 = arg8.head;
                        Intrinsics.checkNotNull(v1);
                        v1.writeTo(v0, ((int)arg9));
                        arg8.setSize$okio(arg8.size() - arg9);
                        this.setSize$okio(this.size() + arg9);
                        return;
                    }

                label_50:
                    v0 = arg8.head;
                    Intrinsics.checkNotNull(v0);
                    arg8.head = v0.split(((int)arg9));
                }

                v0 = arg8.head;
                Intrinsics.checkNotNull(v0);
                v1_1 = ((long)(v0.limit - v0.pos));
                arg8.head = v0.pop();
                Segment v3_1 = this.head;
                if(v3_1 == null) {
                    this.head = v0;
                    v0.prev = v0;
                    v0.next = v0.prev;
                }
                else {
                    Intrinsics.checkNotNull(v3_1);
                    v3_1 = v3_1.prev;
                    Intrinsics.checkNotNull(v3_1);
                    v3_1.push(v0).compact();
                }

                arg8.setSize$okio(arg8.size() - v1_1);
                this.setSize$okio(this.size() + v1_1);
                arg9 -= v1_1;
            }

            return;
        }

        throw new IllegalArgumentException("source == this".toString());
    }

    public int write(ByteBuffer arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg7, "source");
        int v0 = arg7.remaining();
        int v1 = v0;
        while(v1 > 0) {
            Segment v2 = this.writableSegment$okio(1);
            int v3 = Math.min(v1, 0x2000 - v2.limit);
            arg7.get(v2.data, v2.limit, v3);
            v1 -= v3;
            v2.limit += v3;
        }

        this.size += ((long)v0);
        return v0;
    }

    public Buffer write(ByteString arg3) {
        Intrinsics.checkNotNullParameter(arg3, "byteString");
        arg3.write$okio(this, 0, arg3.size());
        return this;
    }

    public Buffer write(ByteString arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "byteString");
        arg2.write$okio(this, arg3, arg4);
        return this;
    }

    public Buffer write(Source arg5, long arg6) throws IOException {
        Intrinsics.checkNotNullParameter(arg5, "source");
        while(true) {
            if(arg6 <= 0) {
                return this;
            }

            long v0 = arg5.read(this, arg6);
            if(v0 == -1) {
                break;
            }

            arg6 -= v0;
        }

        throw new EOFException();
        return this;
    }

    public BufferedSink write(ByteString arg1) {
        return this.write(arg1);
    }

    public BufferedSink write(ByteString arg1, int arg2, int arg3) {
        return this.write(arg1, arg2, arg3);
    }

    public BufferedSink write(Source arg1, long arg2) {
        return this.write(arg1, arg2);
    }

    public BufferedSink write(byte[] arg1) {
        return this.write(arg1);
    }

    public BufferedSink write(byte[] arg1, int arg2, int arg3) {
        return this.write(arg1, arg2, arg3);
    }

    public long writeAll(Source arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg7, "source");
        long v0;
        for(v0 = 0; true; v0 += v2) {
            long v2 = arg7.read(this, 0x2000);
            if(v2 == -1) {
                return v0;
            }
        }

        return v0;
    }

    public Buffer writeByte(int arg5) {
        Segment v0 = this.writableSegment$okio(1);
        byte[] v1 = v0.data;
        int v2 = v0.limit;
        v0.limit = v2 + 1;
        v1[v2] = ((byte)arg5);
        this.setSize$okio(this.size() + 1);
        return this;
    }

    public BufferedSink writeByte(int arg1) {
        return this.writeByte(arg1);
    }

    public Buffer writeDecimalLong(long arg12) {
        long v0 = 0;
        int v2 = Long.compare(arg12, v0);
        if(v2 == 0) {
            return this.writeByte(0x30);
        }

        if(v2 < 0) {
            arg12 = -arg12;
            if(arg12 < v0) {
                return this.writeUtf8("-9223372036854775808");
            }
            else {
                v2 = 1;
            }
        }
        else {
            v2 = 0;
        }

        int v3 = -Buffer.access$countDigitsIn(arg12);
        if(v2 != 0) {
            ++v3;
        }

        Segment v4 = this.writableSegment$okio(v3);
        byte[] v5 = v4.data;
        int v6 = v4.limit + v3;
        while(arg12 != v0) {
            --v6;
            v5[v6] = -Buffer.getHEX_DIGIT_BYTES()[((int)(arg12 % 10))];
            arg12 /= 10;
        }

        if(v2 != 0) {
            v5[v6 - 1] = 45;
        }

        v4.limit += v3;
        this.setSize$okio(this.size() + (((long)v3)));
        return this;
    }

    public BufferedSink writeDecimalLong(long arg1) {
        return this.writeDecimalLong(arg1);
    }

    public Buffer writeHexadecimalUnsignedLong(long arg13) {
        if(arg13 == 0) {
            return this.writeByte(0x30);
        }

        long v1 = arg13 >>> 1 | arg13;
        v1 |= v1 >>> 2;
        int v4 = 4;
        v1 |= v1 >>> v4;
        v1 |= v1 >>> 8;
        v1 |= v1 >>> 16;
        v1 |= v1 >>> 0x20;
        v1 -= v1 >>> 1 & 0x5555555555555555L;
        long v8 = (v1 >>> 2 & 0x3333333333333333L) + (v1 & 0x3333333333333333L);
        v1 = (v8 >>> v4) + v8 & 0xF0F0F0F0F0F0F0FL;
        v1 += v1 >>> 8;
        v1 += v1 >>> 16;
        int v1_1 = ((int)(((v1 & 0x3F) + (v1 >>> 0x20 & 0x3F) + 3) / 4));
        Segment v2 = this.writableSegment$okio(v1_1);
        byte[] v3 = v2.data;
        int v5 = v2.limit + v1_1 - 1;
        int v0 = v2.limit;
        while(v5 >= v0) {
            v3[v5] = -Buffer.getHEX_DIGIT_BYTES()[((int)(15 & arg13))];
            arg13 >>>= v4;
            --v5;
        }

        v2.limit += v1_1;
        this.setSize$okio(this.size() + (((long)v1_1)));
        return this;
    }

    public BufferedSink writeHexadecimalUnsignedLong(long arg1) {
        return this.writeHexadecimalUnsignedLong(arg1);
    }

    public Buffer writeInt(int arg8) {
        Segment v1 = this.writableSegment$okio(4);
        byte[] v2 = v1.data;
        int v3 = v1.limit;
        v2[v3] = ((byte)(arg8 >>> 24 & 0xFF));
        v2[v3 + 1] = ((byte)(arg8 >>> 16 & 0xFF));
        v2[v3 + 2] = ((byte)(arg8 >>> 8 & 0xFF));
        v2[v3 + 3] = ((byte)(arg8 & 0xFF));
        v1.limit = v3 + 4;
        this.setSize$okio(this.size() + 4);
        return this;
    }

    public BufferedSink writeInt(int arg1) {
        return this.writeInt(arg1);
    }

    public Buffer writeIntLe(int arg1) {
        return this.writeInt(-SegmentedByteString.reverseBytes(arg1));
    }

    public BufferedSink writeIntLe(int arg1) {
        return this.writeIntLe(arg1);
    }

    public Buffer writeLong(long arg12) {
        Segment v1 = this.writableSegment$okio(8);
        byte[] v2 = v1.data;
        int v3 = v1.limit;
        v2[v3] = ((byte)(((int)(arg12 >>> 56 & 0xFF))));
        v2[v3 + 1] = ((byte)(((int)(arg12 >>> 0x30 & 0xFF))));
        v2[v3 + 2] = ((byte)(((int)(arg12 >>> 40 & 0xFF))));
        v2[v3 + 3] = ((byte)(((int)(arg12 >>> 0x20 & 0xFF))));
        v2[v3 + 4] = ((byte)(((int)(arg12 >>> 24 & 0xFF))));
        v2[v3 + 5] = ((byte)(((int)(arg12 >>> 16 & 0xFF))));
        v2[v3 + 6] = ((byte)(((int)(arg12 >>> 8 & 0xFF))));
        v2[v3 + 7] = ((byte)(((int)(arg12 & 0xFF))));
        v1.limit = v3 + 8;
        this.setSize$okio(this.size() + 8);
        return this;
    }

    public BufferedSink writeLong(long arg1) {
        return this.writeLong(arg1);
    }

    public Buffer writeLongLe(long arg1) {
        return this.writeLong(-SegmentedByteString.reverseBytes(arg1));
    }

    public BufferedSink writeLongLe(long arg1) {
        return this.writeLongLe(arg1);
    }

    public Buffer writeShort(int arg7) {
        Segment v1 = this.writableSegment$okio(2);
        byte[] v2 = v1.data;
        int v3 = v1.limit;
        v2[v3] = ((byte)(arg7 >>> 8 & 0xFF));
        v2[v3 + 1] = ((byte)(arg7 & 0xFF));
        v1.limit = v3 + 2;
        this.setSize$okio(this.size() + 2);
        return this;
    }

    public BufferedSink writeShort(int arg1) {
        return this.writeShort(arg1);
    }

    public Buffer writeShortLe(int arg1) {
        return this.writeShort(-SegmentedByteString.reverseBytes(((short)arg1)));
    }

    public BufferedSink writeShortLe(int arg1) {
        return this.writeShortLe(arg1);
    }

    public Buffer writeString(String arg2, int arg3, int arg4, Charset arg5) {
        Intrinsics.checkNotNullParameter(arg2, "string");
        Intrinsics.checkNotNullParameter(arg5, "charset");
        if(arg3 >= 0) {
            if(arg4 >= arg3) {
                if(arg4 <= arg2.length()) {
                    if(Intrinsics.areEqual(arg5, Charsets.UTF_8)) {
                        return this.writeUtf8(arg2, arg3, arg4);
                    }

                    arg2 = arg2.substring(arg3, arg4);
                    Intrinsics.checkNotNullExpressionValue(arg2, "substring(...)");
                    byte[] v2 = arg2.getBytes(arg5);
                    Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
                    return this.write(v2, 0, v2.length);
                }

                throw new IllegalArgumentException("endIndex > string.length: " + arg4 + " > " + arg2.length().toString());
            }

            throw new IllegalArgumentException("endIndex < beginIndex: " + arg4 + " < " + arg3.toString());
        }

        throw new IllegalArgumentException("beginIndex < 0: " + arg3.toString());
    }

    public Buffer writeString(String arg3, Charset arg4) {
        Intrinsics.checkNotNullParameter(arg3, "string");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        return this.writeString(arg3, 0, arg3.length(), arg4);
    }

    public BufferedSink writeString(String arg1, int arg2, int arg3, Charset arg4) {
        return this.writeString(arg1, arg2, arg3, arg4);
    }

    public BufferedSink writeString(String arg1, Charset arg2) {
        return this.writeString(arg1, arg2);
    }

    public final Buffer writeTo(OutputStream arg8, long arg9) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "out");
        -SegmentedByteString.checkOffsetAndCount(this.size, 0, arg9);
        Segment v0 = this.head;
        arg9 = arg9;
        while(arg9 > 0) {
            Intrinsics.checkNotNull(v0);
            int v1 = ((int)Math.min(arg9, ((long)(v0.limit - v0.pos))));
            arg8.write(v0.data, v0.pos, v1);
            v0.pos += v1;
            long v4 = ((long)v1);
            this.size -= v4;
            arg9 -= v4;
            if(v0.pos != v0.limit) {
                continue;
            }

            Segment v1_1 = v0.pop();
            this.head = v1_1;
            SegmentPool.recycle(v0);
            v0 = v1_1;
        }

        return this;
    }

    public final Buffer writeTo(OutputStream arg8) throws IOException {
        Intrinsics.checkNotNullParameter(arg8, "out");
        return Buffer.writeTo$default(this, arg8, 0, 2, null);
    }

    public static Buffer writeTo$default(Buffer arg0, OutputStream arg1, long arg2, int arg4, Object arg5) throws IOException {
        if((arg4 & 2) != 0) {
            arg2 = arg0.size;
        }

        return arg0.writeTo(arg1, arg2);
    }

    public Buffer writeUtf8(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "string");
        return this.writeUtf8(arg3, 0, arg3.length());
    }

    public Buffer writeUtf8(String arg12, int arg13, int arg14) {
        Segment v3_1;
        int v6;
        int v5;
        int v4;
        byte[] v3;
        Segment v2;
        int v0;
        Intrinsics.checkNotNullParameter(arg12, "string");
        if(arg13 < 0) {
            goto label_190;
        }

        if(arg14 < arg13) {
            goto label_178;
        }

        if(arg14 > arg12.length()) {
            goto label_165;
        }

    label_6:
        while(arg13 < arg14) {
            v0 = arg12.charAt(arg13);
            int v1 = 0x80;
            if(v0 < v1) {
                v2 = this.writableSegment$okio(1);
                v3 = v2.data;
                v4 = v2.limit - arg13;
                v5 = Math.min(arg14, 0x2000 - v4);
                v6 = arg13 + 1;
                v3[arg13 + v4] = ((byte)v0);
                goto label_21;
            }

            v4 = 2;
            if(v0 < 0x800) {
                v3_1 = this.writableSegment$okio(v4);
                v3_1.data[v3_1.limit] = ((byte)(v0 >> 6 | 0xC0));
                v3_1.data[v3_1.limit + 1] = ((byte)(v0 & 0x3F | v1));
                v3_1.limit += v4;
                this.setSize$okio(this.size() + 2);
            }
            else {
                v5 = 3;
                v6 = 0x3F;
                if(v0 >= 0xD800) {
                    if(v0 > 0xDFFF) {
                    }
                    else {
                        int v3_2 = arg13 + 1;
                        int v7 = v3_2 < arg14 ? arg12.charAt(v3_2) : 0;
                        if(v0 <= 0xDBFF && 0xDC00 <= v7 && v7 < 0xE000) {
                            v0 = ((v0 & 0x3FF) << 10 | v7 & 0x3FF) + 0x10000;
                            Segment v7_1 = this.writableSegment$okio(4);
                            v7_1.data[v7_1.limit] = ((byte)(v0 >> 18 | 0xF0));
                            v7_1.data[v7_1.limit + 1] = ((byte)(v0 >> 12 & v6 | v1));
                            v7_1.data[v7_1.limit + v4] = ((byte)(v0 >> 6 & v6 | v1));
                            v7_1.data[v7_1.limit + v5] = ((byte)(v0 & v6 | v1));
                            v7_1.limit += 4;
                            this.setSize$okio(this.size() + 4);
                            arg13 += 2;
                            continue;
                        }

                        this.writeByte(v6);
                        arg13 = v3_2;
                        continue;
                    }
                }

                v3_1 = this.writableSegment$okio(v5);
                v3_1.data[v3_1.limit] = ((byte)(v0 >> 12 | 0xE0));
                v3_1.data[v3_1.limit + 1] = ((byte)(v0 >> 6 & v6 | v1));
                v3_1.data[v3_1.limit + v4] = ((byte)(v0 & 0x3F | v1));
                v3_1.limit += v5;
                this.setSize$okio(this.size() + 3);
            }

            ++arg13;
        }

        return this;
        while(true) {
        label_21:
            arg13 = v6;
            if(arg13 < v5) {
                v0 = arg12.charAt(arg13);
                if(v0 < v1) {
                    v6 = arg13 + 1;
                    v3[arg13 + v4] = ((byte)v0);
                    continue;
                }
            }

            break;
        }

        v4 = v4 + arg13 - v2.limit;
        v2.limit += v4;
        this.setSize$okio(this.size() + (((long)v4)));
        goto label_6;
    label_165:
        throw new IllegalArgumentException("endIndex > string.length: " + arg14 + " > " + arg12.length().toString());
    label_178:
        throw new IllegalArgumentException("endIndex < beginIndex: " + arg14 + " < " + arg13.toString());
    label_190:
        throw new IllegalArgumentException("beginIndex < 0: " + arg13.toString());
    }

    public BufferedSink writeUtf8(String arg1) {
        return this.writeUtf8(arg1);
    }

    public BufferedSink writeUtf8(String arg1, int arg2, int arg3) {
        return this.writeUtf8(arg1, arg2, arg3);
    }

    public Buffer writeUtf8CodePoint(int arg10) {
        Segment v1;
        int v0 = 0x80;
        if(arg10 < v0) {
            this.writeByte(arg10);
            return this;
        }

        int v2 = 2;
        int v3 = 0x3F;
        if(arg10 < 0x800) {
            v1 = this.writableSegment$okio(v2);
            v1.data[v1.limit] = ((byte)(arg10 >> 6 | 0xC0));
            v1.data[v1.limit + 1] = ((byte)(arg10 & v3 | v0));
            v1.limit += v2;
            this.setSize$okio(this.size() + 2);
            return this;
        }

        if(0xD800 <= arg10 && arg10 < 0xE000) {
            this.writeByte(v3);
            return this;
        }

        int v4 = 3;
        if(arg10 < 0x10000) {
            v1 = this.writableSegment$okio(v4);
            v1.data[v1.limit] = ((byte)(arg10 >> 12 | 0xE0));
            v1.data[v1.limit + 1] = ((byte)(arg10 >> 6 & v3 | v0));
            v1.data[v1.limit + v2] = ((byte)(arg10 & v3 | v0));
            v1.limit += v4;
            this.setSize$okio(this.size() + 3);
            return this;
        }

        if(arg10 <= 0x10FFFF) {
            Segment v5 = this.writableSegment$okio(4);
            v5.data[v5.limit] = ((byte)(arg10 >> 18 | 0xF0));
            v5.data[v5.limit + 1] = ((byte)(arg10 >> 12 & v3 | v0));
            v5.data[v5.limit + v2] = ((byte)(arg10 >> 6 & v3 | v0));
            v5.data[v5.limit + v4] = ((byte)(arg10 & v3 | v0));
            v5.limit += 4;
            this.setSize$okio(this.size() + 4);
            return this;
        }

        throw new IllegalArgumentException("Unexpected code point: 0x" + -SegmentedByteString.toHexString(arg10));
    }

    public BufferedSink writeUtf8CodePoint(int arg1) {
        return this.writeUtf8CodePoint(arg1);
    }
}

