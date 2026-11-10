package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.internal.-Buffer;
import okio.internal.-RealBufferedSource;

@Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001A\u00020\u0007H\u0016J\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\b\u0010\u0013\u001A\u00020\tH\u0016J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\u0010\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\u0010\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0016J\'\u0010\u001B\u001A\u0004\u0018\u0001H\u001F\"\b\b\u0000\u0010\u001F*\u00020 2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u001F0!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001A\u00020$H\u0016J\u0010\u0010#\u001A\u00020$2\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\u0010\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u0011\u001A\u00020$H\u0016J\u0010\u0010%\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020$H\u0016J \u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u0011\u001A\u00020$2\u0006\u0010&\u001A\u00020\u001C2\u0006\u0010\u0012\u001A\u00020\u001CH\u0016J\u0010\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u0011\u001A\u00020\'H\u0016J\u0018\u0010%\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\u0010\u0010(\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020)H\u0016J\b\u0010*\u001A\u00020+H\u0016J\u0010\u0010*\u001A\u00020+2\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\u0010\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020.H\u0016J\u0018\u0010,\u001A\u00020+2\u0006\u0010\u0012\u001A\u00020\u00102\u0006\u0010-\u001A\u00020.H\u0016J\n\u0010/\u001A\u0004\u0018\u00010+H\u0016J\b\u00100\u001A\u00020+H\u0016J\u0010\u00100\u001A\u00020+2\u0006\u00101\u001A\u00020\u0010H\u0016J\b\u00102\u001A\u00020\u001CH\u0016J\b\u00103\u001A\u000204H\u0016J\b\u00105\u001A\u000204H\u0016J\b\u00106\u001A\u00020\u001CH\u0016J\b\u00107\u001A\u00020\u001CH\u0016J\b\u00108\u001A\u00020\u0010H\u0016J\b\u00109\u001A\u00020\u0010H\u0016J\b\u0010:\u001A\u00020\u0010H\u0016J\b\u0010;\u001A\u00020\u0010H\u0016J\u0010\u0010<\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00020\u0010H\u0016J\u0010\u0010=\u001A\u00020\u00102\u0006\u0010>\u001A\u00020\u0018H\u0016J\u0018\u0010=\u001A\u00020\u00102\u0006\u0010>\u001A\u00020\u00182\u0006\u0010?\u001A\u00020\u0010H\u0016J \u0010=\u001A\u00020\u00102\u0006\u0010>\u001A\u00020\u00182\u0006\u0010?\u001A\u00020\u00102\u0006\u0010@\u001A\u00020\u0010H\u0016J\u0010\u0010=\u001A\u00020\u00102\u0006\u0010A\u001A\u00020\u001AH\u0016J\u0018\u0010=\u001A\u00020\u00102\u0006\u0010A\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020\u0010H\u0016J \u0010=\u001A\u00020\u00102\u0006\u0010A\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020\u00102\u0006\u0010@\u001A\u00020\u0010H\u0016J\u0010\u0010B\u001A\u00020\u00102\u0006\u0010C\u001A\u00020\u001AH\u0016J\u0018\u0010B\u001A\u00020\u00102\u0006\u0010C\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020\u0010H\u0016J\u0018\u0010D\u001A\u00020\t2\u0006\u0010&\u001A\u00020\u00102\u0006\u0010A\u001A\u00020\u001AH\u0016J(\u0010D\u001A\u00020\t2\u0006\u0010&\u001A\u00020\u00102\u0006\u0010A\u001A\u00020\u001A2\u0006\u0010E\u001A\u00020\u001C2\u0006\u0010\u0012\u001A\u00020\u001CH\u0016J\b\u0010F\u001A\u00020\u0001H\u0016J\b\u0010G\u001A\u00020HH\u0016J\b\u0010I\u001A\u00020\tH\u0016J\b\u0010J\u001A\u00020\u0015H\u0016J\b\u0010K\u001A\u00020LH\u0016J\b\u0010M\u001A\u00020+H\u0016R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\n\u001A\u00020\u00078Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006N"}, d2={"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "<init>", "(Lokio/Source;)V", "bufferField", "Lokio/Buffer;", "closed", "", "buffer", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "read", "", "sink", "byteCount", "exhausted", "require", "", "request", "readByte", "", "readByteString", "Lokio/ByteString;", "select", "", "options", "Lokio/Options;", "T", "", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "readByteArray", "", "readFully", "offset", "Ljava/nio/ByteBuffer;", "readAll", "Lokio/Sink;", "readUtf8", "", "readString", "charset", "Ljava/nio/charset/Charset;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "readShort", "", "readShortLe", "readInt", "readIntLe", "readLong", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "rangeEquals", "bytesOffset", "peek", "inputStream", "Ljava/io/InputStream;", "isOpen", "close", "timeout", "Lokio/Timeout;", "toString", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source arg2) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        super();
        this.source = arg2;
        this.bufferField = new Buffer();
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if(!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    public boolean exhausted() {
        if(!this.closed) {
            if((this.bufferField.exhausted()) && this.source.read(this.bufferField, 0x2000) == -1) {
                return 1;
            }

            return 0;
        }

        throw new IllegalStateException("closed".toString());
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public static void getBuffer$annotations() {
    }

    public long indexOf(byte arg7) {
        return this.indexOf(arg7, 0, 0x7FFFFFFFFFFFFFFFL);
    }

    public long indexOf(byte arg10, long arg11, long arg13) {
        long v7;
        if(!this.closed) {
            if(0 <= arg11 && arg11 <= arg13) {
                long v3 = arg11;
                while(true) {
                    v7 = -1;
                    if(Long.compare(v3, arg13) < 0) {
                        byte v2 = arg10;
                        long v5 = arg13;
                        long v10 = this.bufferField.indexOf(v2, v3, v5);
                        if(v10 != v7) {
                            return v10;
                        }
                        else {
                            v10 = this.bufferField.size();
                            if(v10 < v5) {
                                if(this.source.read(this.bufferField, 0x2000) == v7) {
                                }
                                else {
                                    v3 = Math.max(v3, v10);
                                    arg10 = v2;
                                    arg13 = v5;
                                    continue;
                                }
                            }
                        }
                    }

                    return v7;
                }

                return v7;
            }

            throw new IllegalArgumentException("fromIndex=" + arg11 + " toIndex=" + arg13.toString());
        }

        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(byte arg7, long arg8) {
        return this.indexOf(arg7, arg8, 0x7FFFFFFFFFFFFFFFL);
    }

    public long indexOf(ByteString arg3) {
        Intrinsics.checkNotNullParameter(arg3, "bytes");
        return this.indexOf(arg3, 0);
    }

    public long indexOf(ByteString arg8, long arg9) {
        Intrinsics.checkNotNullParameter(arg8, "bytes");
        return this.indexOf(arg8, arg9, 0x7FFFFFFFFFFFFFFFL);
    }

    public long indexOf(ByteString arg12, long arg13, long arg15) {
        Intrinsics.checkNotNullParameter(arg12, "bytes");
        return -RealBufferedSource.commonIndexOf$default(this, arg12, 0, 0, arg13, arg15, 6, null);
    }

    public long indexOfElement(ByteString arg3) {
        Intrinsics.checkNotNullParameter(arg3, "targetBytes");
        return this.indexOfElement(arg3, 0);
    }

    public long indexOfElement(ByteString arg9, long arg10) {
        long v0;
        Intrinsics.checkNotNullParameter(arg9, "targetBytes");
        if(!this.closed) {
            while(true) {
                v0 = this.bufferField.indexOfElement(arg9, arg10);
                long v2 = -1;
                if(v0 != v2) {
                    return v0;
                }

                v0 = this.bufferField.size();
                if(this.source.read(this.bufferField, 0x2000) == v2) {
                    return v2;
                }

                arg10 = Math.max(arg10, v0);
            }

            return v0;
        }

        throw new IllegalStateException("closed".toString());
    }

    public InputStream inputStream() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public boolean isOpen() {
        return this.closed ^ 1;
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
        if(!this.closed) {
            if(arg15 < 0) {
                return 0;
            }

            if(arg11 < 0) {
                return 0;
            }

            if(arg14 >= 0) {
                if(arg14 + arg15 > arg13.size()) {
                }
                else if(arg15 == 0) {
                    return 1;
                }
                else if(-RealBufferedSource.commonIndexOf(this, arg13, arg14, arg15, arg11, arg11 + 1) != -1) {
                    return 1;
                }
            }

            return 0;
        }

        throw new IllegalStateException("closed".toString());
    }

    public int read(ByteBuffer arg5) {
        Intrinsics.checkNotNullParameter(arg5, "sink");
        if(this.bufferField.size() == 0 && this.source.read(this.bufferField, 0x2000) == -1) {
            return -1;
        }

        return this.bufferField.read(arg5);
    }

    public int read(byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "sink");
        return this.read(arg3, 0, arg3.length);
    }

    public int read(byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "sink");
        long v5 = ((long)arg10);
        -SegmentedByteString.checkOffsetAndCount(((long)arg8.length), ((long)arg9), v5);
        if(this.bufferField.size() == 0) {
            if(arg10 == 0) {
                return 0;
            }
            else if(this.source.read(this.bufferField, 0x2000) == -1) {
                return -1;
            }
        }

        return this.bufferField.read(arg8, arg9, ((int)Math.min(v5, this.bufferField.size())));
    }

    public long read(Buffer arg6, long arg7) {
        Intrinsics.checkNotNullParameter(arg6, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg7, v0);
        if(v2 >= 0) {
            if(!this.closed) {
                if(this.bufferField.size() == v0) {
                    if(v2 == 0) {
                        return v0;
                    }
                    else {
                        long v2_1 = -1;
                        if(this.source.read(this.bufferField, 0x2000) == v2_1) {
                            return v2_1;
                        }
                    }
                }

                return this.bufferField.read(arg6, Math.min(arg7, this.bufferField.size()));
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg7.toString());
    }

    public long readAll(Sink arg9) {
        Intrinsics.checkNotNullParameter(arg9, "sink");
        long v0 = 0;
        long v2 = v0;
        while(true) {
            int v4 = Long.compare(this.source.read(this.bufferField, 0x2000), -1);
            Buffer v5 = this.bufferField;
            if(v4 == 0) {
                break;
            }

            long v4_1 = v5.completeSegmentByteCount();
            if(v4_1 <= v0) {
                continue;
            }

            v2 += v4_1;
            arg9.write(this.bufferField, v4_1);
        }

        if(v5.size() > v0) {
            v2 += this.bufferField.size();
            arg9.write(this.bufferField, this.bufferField.size());
        }

        return v2;
    }

    public byte readByte() {
        this.require(1);
        return this.bufferField.readByte();
    }

    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    public byte[] readByteArray(long arg1) {
        this.require(arg1);
        return this.bufferField.readByteArray(arg1);
    }

    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public ByteString readByteString(long arg1) {
        this.require(arg1);
        return this.bufferField.readByteString(arg1);
    }

    public long readDecimalLong() {
        int v8;
        long v0 = 1;
        this.require(v0);
        long v2 = 0;
        long v4 = v2;
        while(true) {
            long v6 = v4 + v0;
            if(this.request(v6)) {
                v8 = this.bufferField.getByte(v4);
                if(v8 < 0x30 || v8 > 57) {
                    int v4_1 = Long.compare(v4, v2);
                    if(v4_1 == 0) {
                        if(v8 != 45) {
                        }
                        else {
                            goto label_18;
                        }
                    }

                    break;
                }

            label_18:
                v4 = v6;
                continue;
            }

            goto label_35;
        }

        if(v4_1 != 0) {
        }
        else {
            StringBuilder v0_1 = new StringBuilder("Expected a digit or \'-\' but was 0x");
            String v1 = Integer.toString(v8, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
            throw new NumberFormatException(v0_1.append(v1).toString());
        }

    label_35:
        return this.bufferField.readDecimalLong();
    }

    public void readFully(Buffer arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sink");
        try {
            this.require(arg3);
        }
        catch(EOFException v3) {
            arg2.writeAll(this.bufferField);
            throw v3;
        }

        this.bufferField.readFully(arg2, arg3);
    }

    public void readFully(byte[] arg7) {
        Intrinsics.checkNotNullParameter(arg7, "sink");
        try {
            this.require(((long)arg7.length));
        }
        catch(EOFException v0) {
            int v1;
            for(v1 = 0; true; v1 += v2) {
                if(this.bufferField.size() <= 0) {
                    goto label_25;
                }

                int v2 = this.bufferField.read(arg7, v1, ((int)this.bufferField.size()));
                if(v2 == -1) {
                    break;
                }
            }

            throw new AssertionError();
        label_25:
            throw v0;
        }

        this.bufferField.readFully(arg7);
    }

    public long readHexadecimalUnsignedLong() {
        int v2;
        this.require(1);
        int v0 = 0;
        while(true) {
            int v1 = v0 + 1;
            if(this.request(((long)v1))) {
                v2 = this.bufferField.getByte(((long)v0));
                if((v2 < 0x30 || v2 > 57) && (v2 < 97 || v2 > 102)) {
                    if(v2 >= 65) {
                        if(v2 > 70) {
                        }
                        else {
                            goto label_23;
                        }
                    }

                    break;
                }

            label_23:
                v0 = v1;
                continue;
            }

            goto label_40;
        }

        if(v0 != 0) {
        }
        else {
            StringBuilder v0_1 = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
            String v1_1 = Integer.toString(v2, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(v1_1, "toString(...)");
            throw new NumberFormatException(v0_1.append(v1_1).toString());
        }

    label_40:
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        this.require(4);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        this.require(4);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        this.require(8);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        this.require(8);
        return this.bufferField.readLongLe();
    }

    public short readShort() {
        this.require(2);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        this.require(2);
        return this.bufferField.readShortLe();
    }

    public String readString(long arg2, Charset arg4) {
        Intrinsics.checkNotNullParameter(arg4, "charset");
        this.require(arg2);
        return this.bufferField.readString(arg2, arg4);
    }

    public String readString(Charset arg3) {
        Intrinsics.checkNotNullParameter(arg3, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(arg3);
    }

    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public String readUtf8(long arg1) {
        this.require(arg1);
        return this.bufferField.readUtf8(arg1);
    }

    public int readUtf8CodePoint() {
        this.require(1);
        int v0 = this.bufferField.getByte(0);
        if((v0 & 0xE0) == 0xC0) {
            this.require(2);
        }
        else if((v0 & 0xF0) == 0xE0) {
            this.require(3);
        }
        else if((v0 & 0xF8) == 0xF0) {
            this.require(4);
        }

        return this.bufferField.readUtf8CodePoint();
    }

    public String readUtf8Line() {
        long v0 = this.indexOf(10);
        int v2 = Long.compare(v0, -1);
        Buffer v3 = this.bufferField;
        if(v2 == 0) {
            if(v3.size() != 0) {
                return this.readUtf8(this.bufferField.size());
            }

            return null;
        }

        return -Buffer.readUtf8Line(v3, v0);
    }

    public String readUtf8LineStrict() {
        return this.readUtf8LineStrict(0x7FFFFFFFFFFFFFFFL);
    }

    public String readUtf8LineStrict(long arg14) {
        if(arg14 >= 0) {
            long v0 = 0x7FFFFFFFFFFFFFFFL;
            long v3 = 1;
            long v11 = Long.compare(arg14, v0) == 0 ? v0 : arg14 + v3;
            RealBufferedSource v7 = this;
            long v5 = v7.indexOf(10, 0, v11);
            if(v5 != -1) {
                return -Buffer.readUtf8Line(v7.bufferField, v5);
            }

            if(v11 < v0 && (v7.request(v11)) && v7.bufferField.getByte(v11 - v3) == 13 && (v7.request(v11 + v3)) && v7.bufferField.getByte(v11) == 10) {
                return -Buffer.readUtf8Line(v7.bufferField, v11);
            }

            Buffer v1 = new Buffer();
            v7.bufferField.copyTo(v1, 0, Math.min(0x20, v7.bufferField.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(v7.bufferField.size(), arg14) + " content=" + v1.readByteString().hex() + '…');
        }

        throw new IllegalArgumentException("limit < 0: " + arg14.toString());
    }

    public boolean request(long arg5) {
        if(arg5 >= 0) {
            if(!this.closed) {
                do {
                    if(this.bufferField.size() >= arg5) {
                        return 1;
                    }
                }
                while(this.source.read(this.bufferField, 0x2000) != -1);

                return 0;
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg5.toString());
    }

    public void require(long arg1) {
        if(this.request(arg1)) {
            return;
        }

        throw new EOFException();
    }

    public int select(Options arg6) {
        int v2;
        int v0;
        Intrinsics.checkNotNullParameter(arg6, "options");
        if(this.closed) {
            goto label_26;
        }

        do {
            v0 = -Buffer.selectPrefix(this.bufferField, arg6, true);
            v2 = -1;
            if(v0 != -2) {
                goto label_10;
            }
        }
        while(this.source.read(this.bufferField, 0x2000) != -1);

        return v2;
    label_10:
        if(v0 != v2) {
            this.bufferField.skip(((long)arg6.getByteStrings$okio()[v0].size()));
            return v0;
        }

        return v2;
    label_26:
        throw new IllegalStateException("closed".toString());
    }

    public Object select(TypedOptions arg2) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        int v1 = ((BufferedSource)this).select(arg2.getOptions$okio());
        if(v1 == -1) {
            return null;
        }

        return arg2.get(v1);
    }

    public void skip(long arg5) {
        if(!this.closed) {
            while(true) {
                long v0 = 0;
                if(arg5 <= v0) {
                    return;
                }

                if(this.bufferField.size() == v0) {
                    if(this.source.read(this.bufferField, 0x2000) != -1) {
                    }
                    else {
                        throw new EOFException();
                    }
                }

                v0 = Math.min(arg5, this.bufferField.size());
                this.bufferField.skip(v0);
                arg5 -= v0;
            }

            return;
        }

        throw new IllegalStateException("closed".toString());
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }
}

