package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001F\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u000FH\u0016J\b\u0010\u0013\u001A\u00020\u000FH\u0016J\b\u0010\u0014\u001A\u00020\u0001H\u0016J\b\u0010\u0015\u001A\u00020\u0001H\u0016J\u0015\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u000FH\u0010¢\u0006\u0002\b\u0018J\u001D\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u0001H\u0010¢\u0006\u0002\b\u001BJ\b\u0010\u001C\u001A\u00020\u000FH\u0016J\u001C\u0010\u001D\u001A\u00020\u00012\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020\u001FH\u0016J\u0015\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u001FH\u0010¢\u0006\u0002\b$J\r\u0010%\u001A\u00020\u001FH\u0010¢\u0006\u0002\b&J\b\u0010\'\u001A\u00020\u0004H\u0016J\b\u0010(\u001A\u00020)H\u0016J\u0010\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-H\u0016J%\u0010*\u001A\u00020+2\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020\u001F2\u0006\u00101\u001A\u00020\u001FH\u0010¢\u0006\u0002\b2J(\u00103\u001A\u0002042\u0006\u00100\u001A\u00020\u001F2\u0006\u00105\u001A\u00020\u00012\u0006\u00106\u001A\u00020\u001F2\u0006\u00101\u001A\u00020\u001FH\u0016J(\u00103\u001A\u0002042\u0006\u00100\u001A\u00020\u001F2\u0006\u00105\u001A\u00020\u00042\u0006\u00106\u001A\u00020\u001F2\u0006\u00101\u001A\u00020\u001FH\u0016J,\u00107\u001A\u00020+2\b\b\u0002\u00100\u001A\u00020\u001F2\u0006\u00108\u001A\u00020\u00042\b\b\u0002\u00109\u001A\u00020\u001F2\u0006\u00101\u001A\u00020\u001FH\u0016J\u001A\u0010:\u001A\u00020\u001F2\u0006\u00105\u001A\u00020\u00042\b\b\u0002\u0010;\u001A\u00020\u001FH\u0016J\u001A\u0010<\u001A\u00020\u001F2\u0006\u00105\u001A\u00020\u00042\b\b\u0002\u0010;\u001A\u00020\u001FH\u0016J\b\u0010=\u001A\u00020\u0001H\u0002J\r\u0010>\u001A\u00020\u0004H\u0010¢\u0006\u0002\b?J\u0013\u0010@\u001A\u0002042\b\u00105\u001A\u0004\u0018\u00010AH\u0096\u0002J\b\u0010B\u001A\u00020\u001FH\u0016J\b\u0010C\u001A\u00020\u000FH\u0016J\b\u0010D\u001A\u00020EH\u0002R\u001C\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001A\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006F"}, d2={"Lokio/SegmentedByteString;", "Lokio/ByteString;", "segments", "", "", "directory", "", "<init>", "([[B[I)V", "getSegments$okio", "()[[B", "[[B", "getDirectory$okio", "()[I", "string", "", "charset", "Ljava/nio/charset/Charset;", "base64", "hex", "toAsciiLowercase", "toAsciiUppercase", "digest", "algorithm", "digest$okio", "hmac", "key", "hmac$okio", "base64Url", "substring", "beginIndex", "", "endIndex", "internalGet", "", "pos", "internalGet$okio", "getSize", "getSize$okio", "toByteArray", "asByteBuffer", "Ljava/nio/ByteBuffer;", "write", "", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "offset", "byteCount", "write$okio", "rangeEquals", "", "other", "otherOffset", "copyInto", "target", "targetOffset", "indexOf", "fromIndex", "lastIndexOf", "toByteString", "internalArray", "internalArray$okio", "equals", "", "hashCode", "toString", "writeReplace", "Ljava/lang/Object;", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public SegmentedByteString(byte[][] arg2, int[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "segments");
        Intrinsics.checkNotNullParameter(arg3, "directory");
        super(ByteString.EMPTY.getData$okio());
        this.segments = arg2;
        this.directory = arg3;
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer v1 = ByteBuffer.wrap(this.toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(v1, "asReadOnlyBuffer(...)");
        return v1;
    }

    public String base64() {
        return this.toByteString().base64();
    }

    public String base64Url() {
        return this.toByteString().base64Url();
    }

    public void copyInto(int arg12, byte[] arg13, int arg14, int arg15) {
        Intrinsics.checkNotNullParameter(arg13, "target");
        long v5 = ((long)arg15);
        -SegmentedByteString.checkOffsetAndCount(((long)this.size()), ((long)arg12), v5);
        -SegmentedByteString.checkOffsetAndCount(((long)arg13.length), ((long)arg14), v5);
        arg15 += arg12;
        int v0;
        for(v0 = okio.internal.-SegmentedByteString.segment(this, arg12); arg12 < arg15; ++v0) {
            int v1 = v0 == 0 ? 0 : this.getDirectory$okio()[v0 - 1];
            int v2 = this.getDirectory$okio()[v0] - v1;
            int v3 = this.getDirectory$okio()[this.getSegments$okio().length + v0];
            v2 = Math.min(arg15, v2 + v1) - arg12;
            v3 += arg12 - v1;
            ArraysKt.copyInto(this.getSegments$okio()[v0], arg13, arg14, v3, v3 + v2);
            arg14 += v2;
            arg12 += v2;
        }
    }

    public ByteString digest$okio(String arg7) {
        Intrinsics.checkNotNullParameter(arg7, "algorithm");
        MessageDigest v7 = MessageDigest.getInstance(arg7);
        int v0 = this.getSegments$okio().length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v4) {
            int v3 = this.getDirectory$okio()[v0 + v1];
            int v4 = this.getDirectory$okio()[v1];
            v7.update(this.getSegments$okio()[v1], v3, v4 - v2);
            ++v1;
        }

        byte[] v6 = v7.digest();
        Intrinsics.checkNotNull(v6);
        return new ByteString(v6);
    }

    public boolean equals(Object arg5) {
        if((((SegmentedByteString)arg5)) == this) {
            return 1;
        }

        if(((arg5 instanceof ByteString)) && ((ByteString)arg5).size() == this.size() && (this.rangeEquals(0, ((ByteString)arg5), 0, this.size()))) {
            return 1;
        }

        return 0;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public int getSize$okio() {
        return this.getDirectory$okio()[this.getSegments$okio().length - 1];
    }

    public int hashCode() {
        int v0 = this.getHashCode$okio();
        if(v0 != 0) {
            return v0;
        }

        v0 = this.getSegments$okio().length;
        int v1 = 0;
        int v3 = 1;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v5) {
            int v4 = this.getDirectory$okio()[v0 + v1];
            int v5 = this.getDirectory$okio()[v1];
            byte[] v6 = this.getSegments$okio()[v1];
            v2 = v5 - v2 + v4;
            while(v4 < v2) {
                v3 = v3 * 0x1F + v6[v4];
                ++v4;
            }

            ++v1;
        }

        this.setHashCode$okio(v3);
        return v3;
    }

    public String hex() {
        return this.toByteString().hex();
    }

    public ByteString hmac$okio(String arg6, ByteString arg7) {
        Intrinsics.checkNotNullParameter(arg6, "algorithm");
        Intrinsics.checkNotNullParameter(arg7, "key");
        try {
            Mac v0 = Mac.getInstance(arg6);
            v0.init(new SecretKeySpec(arg7.toByteArray(), arg6));
            int v6 = this.getSegments$okio().length;
            int v7 = 0;
            int v1;
            for(v1 = 0; v7 < v6; v1 = v3) {
                int v2 = this.getDirectory$okio()[v6 + v7];
                int v3 = this.getDirectory$okio()[v7];
                v0.update(this.getSegments$okio()[v7], v2, v3 - v1);
                ++v7;
            }

            byte[] v6_1 = v0.doFinal();
            Intrinsics.checkNotNullExpressionValue(v6_1, "doFinal(...)");
            return new ByteString(v6_1);
        }
        catch(InvalidKeyException v5) {
            throw new IllegalArgumentException(((Throwable)v5));
        }
    }

    public int indexOf(byte[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.toByteString().indexOf(arg2, arg3);
    }

    public byte[] internalArray$okio() {
        return this.toByteArray();
    }

    public byte internalGet$okio(int arg8) {
        -SegmentedByteString.checkOffsetAndCount(((long)this.getDirectory$okio()[this.getSegments$okio().length - 1]), ((long)arg8), 1);
        int v0 = okio.internal.-SegmentedByteString.segment(this, arg8);
        int v1 = v0 == 0 ? 0 : this.getDirectory$okio()[v0 - 1];
        return this.getSegments$okio()[v0][arg8 - v1 + this.getDirectory$okio()[this.getSegments$okio().length + v0]];
    }

    public int lastIndexOf(byte[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return this.toByteString().lastIndexOf(arg2, arg3);
    }

    public boolean rangeEquals(int arg7, ByteString arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "other");
        if(arg7 >= 0) {
            if(arg7 > this.size() - arg10) {
            }
            else {
                arg10 += arg7;
                int v1;
                for(v1 = okio.internal.-SegmentedByteString.segment(this, arg7); arg7 < arg10; ++v1) {
                    int v2 = v1 == 0 ? 0 : this.getDirectory$okio()[v1 - 1];
                    int v3 = this.getDirectory$okio()[v1] - v2;
                    int v4 = this.getDirectory$okio()[this.getSegments$okio().length + v1];
                    v3 = Math.min(arg10, v3 + v2) - arg7;
                    if(!arg8.rangeEquals(arg9, this.getSegments$okio()[v1], v4 + (arg7 - v2), v3)) {
                        return 0;
                    }

                    arg9 += v3;
                    arg7 += v3;
                }

                return 1;
            }
        }

        return 0;
    }

    public boolean rangeEquals(int arg7, byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg8, "other");
        if(arg7 >= 0 && arg7 <= this.size() - arg10 && arg9 >= 0) {
            if(arg9 > arg8.length - arg10) {
            }
            else {
                arg10 += arg7;
                int v1;
                for(v1 = okio.internal.-SegmentedByteString.segment(this, arg7); arg7 < arg10; ++v1) {
                    int v2 = v1 == 0 ? 0 : this.getDirectory$okio()[v1 - 1];
                    int v3 = this.getDirectory$okio()[v1] - v2;
                    int v4 = this.getDirectory$okio()[this.getSegments$okio().length + v1];
                    v3 = Math.min(arg10, v3 + v2) - arg7;
                    if(!-SegmentedByteString.arrayRangeEquals(this.getSegments$okio()[v1], v4 + (arg7 - v2), arg8, arg9, v3)) {
                        return 0;
                    }

                    arg9 += v3;
                    arg7 += v3;
                }

                return 1;
            }
        }

        return 0;
    }

    public String string(Charset arg2) {
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return this.toByteString().string(arg2);
    }

    public ByteString substring(int arg12, int arg13) {
        if(arg12 >= 0) {
            String v1 = "endIndex=";
            if(arg13 <= this.size()) {
                int v0 = arg13 - arg12;
                if(v0 >= 0) {
                    if(arg12 == 0 && arg13 == this.size()) {
                        return this;
                    }

                    if(arg12 == arg13) {
                        return ByteString.EMPTY;
                    }

                    int v1_1 = okio.internal.-SegmentedByteString.segment(this, arg12);
                    arg13 = okio.internal.-SegmentedByteString.segment(this, arg13 - 1);
                    Object[] v2 = ArraysKt.copyOfRange(this.getSegments$okio(), v1_1, arg13 + 1);
                    Object[] v3 = v2;
                    int[] v4 = new int[v3.length * 2];
                    int v5 = 0;
                    if(v1_1 <= arg13) {
                        int v7 = v1_1;
                        int v6 = 0;
                        while(true) {
                            v4[v6] = Math.min(this.getDirectory$okio()[v7] - arg12, v0);
                            int v8 = v6 + 1;
                            v4[v6 + v3.length] = this.getDirectory$okio()[this.getSegments$okio().length + v7];
                            if(v7 != arg13) {
                                ++v7;
                                v6 = v8;
                                continue;
                            }

                            break;
                        }
                    }

                    if(v1_1 == 0) {
                    }
                    else {
                        v5 = this.getDirectory$okio()[v1_1 - 1];
                    }

                    v4[v3.length] += arg12 - v5;
                    return new SegmentedByteString(((byte[][])v2), v4);
                }

                throw new IllegalArgumentException(v1 + arg13 + " < beginIndex=" + arg12.toString());
            }

            throw new IllegalArgumentException(v1 + arg13 + " > length(" + this.size() + ')'.toString());
        }

        throw new IllegalArgumentException("beginIndex=" + arg12 + " < 0".toString());
    }

    public ByteString toAsciiLowercase() {
        return this.toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return this.toByteString().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        byte[] v0 = new byte[this.size()];
        int v1 = this.getSegments$okio().length;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(v2 < v1) {
            int v5 = this.getDirectory$okio()[v1 + v2];
            int v6 = this.getDirectory$okio()[v2];
            v3 = v6 - v3;
            ArraysKt.copyInto(this.getSegments$okio()[v2], v0, v4, v5, v5 + v3);
            v4 += v3;
            ++v2;
            v3 = v6;
        }

        return v0;
    }

    private final ByteString toByteString() {
        return new ByteString(this.toByteArray());
    }

    public String toString() {
        return this.toByteString().toString();
    }

    public void write(OutputStream arg7) throws IOException {
        Intrinsics.checkNotNullParameter(arg7, "out");
        int v0 = this.getSegments$okio().length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v4) {
            int v3 = this.getDirectory$okio()[v0 + v1];
            int v4 = this.getDirectory$okio()[v1];
            arg7.write(this.getSegments$okio()[v1], v3, v4 - v2);
            ++v1;
        }
    }

    public void write$okio(Buffer arg12, int arg13, int arg14) {
        Intrinsics.checkNotNullParameter(arg12, "buffer");
        int v0 = arg13 + arg14;
        int v1;
        for(v1 = okio.internal.-SegmentedByteString.segment(this, arg13); arg13 < v0; ++v1) {
            int v2 = v1 == 0 ? 0 : this.getDirectory$okio()[v1 - 1];
            int v3 = this.getDirectory$okio()[v1] - v2;
            int v4 = this.getDirectory$okio()[this.getSegments$okio().length + v1];
            v3 = Math.min(v0, v3 + v2) - arg13;
            int v7 = v4 + (arg13 - v2);
            Segment v5 = new Segment(this.getSegments$okio()[v1], v7, v7 + v3, true, false);
            if(arg12.head == null) {
                v5.prev = v5;
                v5.next = v5.prev;
                arg12.head = v5.next;
            }
            else {
                Segment v2_1 = arg12.head;
                Intrinsics.checkNotNull(v2_1);
                v2_1 = v2_1.prev;
                Intrinsics.checkNotNull(v2_1);
                v2_1.push(v5);
            }

            arg13 += v3;
        }

        arg12.setSize$okio(arg12.size() + (((long)arg14)));
    }

    private final Object writeReplace() {
        ByteString v1 = this.toByteString();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Object");
        return v1;
    }
}

