package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.-SegmentedByteString;
import okio.Buffer$UnsafeCursor;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio._JvmPlatformKt;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001A0\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u0005H\u0000\u001A\u0014\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0000\u001A?\u0010\u0013\u001A\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00122\u001A\u0010\u0016\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u00140\u0017H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001A\u001E\u0010\u0019\u001A\u00020\u0005*\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u0007H\u0000\u001A%\u0010\u001D\u001A\u00020\u0010*\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\r\u0010!\u001A\u00020\u0012*\u00020\u0010H\u0080\b\u001A\r\u0010\"\u001A\u00020#*\u00020\u0010H\u0080\b\u001A\r\u0010$\u001A\u00020%*\u00020\u0010H\u0080\b\u001A\r\u0010&\u001A\u00020\u0005*\u00020\u0010H\u0080\b\u001A\r\u0010\'\u001A\u00020\u0012*\u00020\u0010H\u0080\b\u001A\u0015\u0010(\u001A\u00020#*\u00020\u00102\u0006\u0010)\u001A\u00020\u0012H\u0080\b\u001A\r\u0010*\u001A\u00020+*\u00020\u0010H\u0080\b\u001A\u0015\u0010,\u001A\u00020+*\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A)\u0010-\u001A\u00020\u0010*\u00020\u00102\u0006\u0010.\u001A\u00020/2\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\u0005H\u0080\b\u001A\u0015\u00100\u001A\u00020\u0010*\u00020\u00102\u0006\u00101\u001A\u00020\u0012H\u0080\b\u001A\u0010\u00102\u001A\u00020\u00052\u0006\u00101\u001A\u00020\u0012H\u0002\u001A\u0015\u00105\u001A\u00020\u0010*\u00020\u00102\u0006\u00101\u001A\u00020\u0012H\u0080\b\u001A\u0015\u00106\u001A\u00020\t*\u00020\u00102\u0006\u00107\u001A\u00020\u0005H\u0080\b\u001A\u0015\u0010-\u001A\u00020\u0010*\u00020\u00102\u0006\u00108\u001A\u00020\u0001H\u0080\b\u001A%\u0010-\u001A\u00020\u0010*\u00020\u00102\u0006\u00108\u001A\u00020\u00012\u0006\u0010\u001F\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u0005H\u0080\b\u001A\r\u00109\u001A\u00020\u0001*\u00020\u0010H\u0080\b\u001A\u0015\u00109\u001A\u00020\u0001*\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\u0015\u0010:\u001A\u00020\u0005*\u00020\u00102\u0006\u0010;\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010<\u001A\u00020+*\u00020\u00102\u0006\u0010;\u001A\u00020\u0001H\u0080\b\u001A%\u0010:\u001A\u00020\u0005*\u00020\u00102\u0006\u0010;\u001A\u00020\u00012\u0006\u0010\u001F\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u0005H\u0080\b\u001A\r\u0010?\u001A\u00020\u0012*\u00020\u0010H\u0080\b\u001A\r\u0010@\u001A\u00020\u0012*\u00020\u0010H\u0080\b\u001A\r\u0010A\u001A\u00020/*\u00020\u0010H\u0080\b\u001A\u0015\u0010A\u001A\u00020/*\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\u0015\u0010B\u001A\u00020\u0005*\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u001BH\u0080\b\u001A\u001D\u0010<\u001A\u00020+*\u00020\u00102\u0006\u0010;\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\u0015\u0010C\u001A\u00020\u0012*\u00020\u00102\u0006\u0010;\u001A\u00020DH\u0080\b\u001A\u0015\u0010E\u001A\u00020\u000F*\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\u000F\u0010F\u001A\u0004\u0018\u00010\u000F*\u00020\u0010H\u0080\b\u001A\u0015\u0010G\u001A\u00020\u000F*\u00020\u00102\u0006\u0010H\u001A\u00020\u0012H\u0080\b\u001A\r\u0010I\u001A\u00020\u0005*\u00020\u0010H\u0080\b\u001A%\u0010J\u001A\u00020\u0010*\u00020\u00102\u0006\u0010K\u001A\u00020\u000F2\u0006\u0010L\u001A\u00020\u00052\u0006\u0010M\u001A\u00020\u0005H\u0080\b\u001A\u0015\u0010N\u001A\u00020\u0010*\u00020\u00102\u0006\u0010O\u001A\u00020\u0005H\u0080\b\u001A\u0015\u0010P\u001A\u00020\u0012*\u00020\u00102\u0006\u00108\u001A\u00020QH\u0080\b\u001A\u001D\u0010-\u001A\u00020\u0010*\u00020\u00102\u0006\u00108\u001A\u00020Q2\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\u0015\u0010R\u001A\u00020\u0010*\u00020\u00102\u0006\u0010S\u001A\u00020\u0005H\u0080\b\u001A\u0015\u0010T\u001A\u00020\u0010*\u00020\u00102\u0006\u0010U\u001A\u00020\u0005H\u0080\b\u001A\u0015\u0010V\u001A\u00020\u0010*\u00020\u00102\u0006\u0010W\u001A\u00020\u0005H\u0080\b\u001A\u0015\u0010X\u001A\u00020\u0010*\u00020\u00102\u0006\u00101\u001A\u00020\u0012H\u0080\b\u001A\u001D\u0010-\u001A\u00020+*\u00020\u00102\u0006\u00108\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A\u001D\u0010:\u001A\u00020\u0012*\u00020\u00102\u0006\u0010;\u001A\u00020\u00102\u0006\u0010 \u001A\u00020\u0012H\u0080\b\u001A%\u0010Y\u001A\u00020\u0012*\u00020\u00102\u0006\u0010S\u001A\u00020#2\u0006\u0010\u0015\u001A\u00020\u00122\u0006\u0010Z\u001A\u00020\u0012H\u0080\b\u001A:\u0010Y\u001A\u00020\u0012*\u00020\u00102\u0006\u0010\u000B\u001A\u00020/2\u0006\u0010\u0015\u001A\u00020\u00122\b\b\u0002\u0010Z\u001A\u00020\u00122\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\u0005H\u0000\u001A\u001D\u0010[\u001A\u00020\u0012*\u00020\u00102\u0006\u0010\\\u001A\u00020/2\u0006\u0010\u0015\u001A\u00020\u0012H\u0080\b\u001A-\u0010]\u001A\u00020\u0007*\u00020\u00102\u0006\u0010\u001F\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020/2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u0005H\u0080\b\u001A\u0017\u0010^\u001A\u00020\u0007*\u00020\u00102\b\u0010_\u001A\u0004\u0018\u00010`H\u0080\b\u001A\r\u0010a\u001A\u00020\u0005*\u00020\u0010H\u0080\b\u001A\r\u0010b\u001A\u00020\u0010*\u00020\u0010H\u0080\b\u001A\r\u0010c\u001A\u00020/*\u00020\u0010H\u0080\b\u001A\u0015\u0010c\u001A\u00020/*\u00020\u00102\u0006\u0010 \u001A\u00020\u0005H\u0080\b\u001A\u0014\u0010d\u001A\u00020e*\u00020\u00102\u0006\u0010f\u001A\u00020eH\u0000\u001A\u0014\u0010g\u001A\u00020e*\u00020\u00102\u0006\u0010f\u001A\u00020eH\u0000\u001A\r\u0010h\u001A\u00020\u0005*\u00020eH\u0080\b\u001A\u0015\u0010i\u001A\u00020\u0005*\u00020e2\u0006\u0010\u001F\u001A\u00020\u0012H\u0080\b\u001A\u0015\u0010j\u001A\u00020\u0012*\u00020e2\u0006\u0010k\u001A\u00020\u0012H\u0080\b\u001A\u0015\u0010l\u001A\u00020\u0012*\u00020e2\u0006\u0010m\u001A\u00020\u0005H\u0080\b\u001A\r\u0010n\u001A\u00020+*\u00020eH\u0080\b\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u00103\u001A\u000204X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010=\u001A\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010>\u001A\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006o"}, d2={"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES", "()[B", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "readUtf8Line", "", "Lokio/Buffer;", "newline", "", "seek", "T", "fromIndex", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "options", "Lokio/Options;", "selectTruncated", "commonCopyTo", "out", "offset", "byteCount", "commonCompleteSegmentByteCount", "commonReadByte", "", "commonReadShort", "", "commonReadInt", "commonReadLong", "commonGet", "pos", "commonClear", "", "commonSkip", "commonWrite", "byteString", "Lokio/ByteString;", "commonWriteDecimalLong", "v", "countDigitsIn", "DigitCountToLargestValue", "", "commonWriteHexadecimalUnsignedLong", "commonWritableSegment", "minimumCapacity", "source", "commonReadByteArray", "commonRead", "sink", "commonReadFully", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "commonSelect", "commonReadAll", "Lokio/Sink;", "commonReadUtf8", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "commonWriteAll", "Lokio/Source;", "commonWriteByte", "b", "commonWriteShort", "s", "commonWriteInt", "i", "commonWriteLong", "commonIndexOf", "toIndex", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonEquals", "other", "", "commonHashCode", "commonCopy", "commonSnapshot", "commonReadUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "commonReadAndWriteUnsafe", "commonNext", "commonSeek", "commonResizeBuffer", "newSize", "commonExpandBuffer", "minByteCount", "commonClose", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -Buffer {
    private static final long[] DigitCountToLargestValue = null;
    private static final byte[] HEX_DIGIT_BYTES = null;
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 0x1000;

    static {
        -Buffer.HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
        -Buffer.DigitCountToLargestValue = new long[]{-1, 9, 99, 999, 0x270F, 0x1869F, 0xF423F, 0x98967F, 0x5F5E0FF, 0x3B9AC9FF, 0x2540BE3FFL, 0x174876E7FFL, 0xE8D4A50FFFL, 0x9184E729FFFL, 0x5AF3107A3FFFL, 0x38D7EA4C67FFFL, 0x2386F26FC0FFFFL, 0x16345785D89FFFFL, 0xDE0B6B3A763FFFFL, 0x7FFFFFFFFFFFFFFFL};
    }

    public static final int access$countDigitsIn(long arg0) {
        return -Buffer.countDigitsIn(arg0);
    }

    public static final void commonClear(Buffer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.skip(arg2.size());
    }

    public static final void commonClose(UnsafeCursor arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(arg3.buffer != null) {
            arg3.buffer = null;
            arg3.setSegment$okio(null);
            arg3.offset = -1;
            arg3.data = null;
            arg3.start = -1;
            arg3.end = -1;
            return;
        }

        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonCompleteSegmentByteCount(Buffer arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        long v0 = arg5.size();
        long v2 = 0;
        if(v0 == v2) {
            return v2;
        }

        Segment v5 = arg5.head;
        Intrinsics.checkNotNull(v5);
        v5 = v5.prev;
        Intrinsics.checkNotNull(v5);
        if(v5.limit < 0x2000 && (v5.owner)) {
            v0 -= ((long)(v5.limit - v5.pos));
        }

        return v0;
    }

    public static final Buffer commonCopy(Buffer arg6) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Buffer v0 = new Buffer();
        if(arg6.size() == 0) {
            return v0;
        }

        Segment v1 = arg6.head;
        Intrinsics.checkNotNull(v1);
        Segment v2 = v1.sharedCopy();
        v0.head = v2;
        v2.prev = v0.head;
        v2.next = v2.prev;
        Segment v3;
        for(v3 = v1.next; v3 != v1; v3 = v3.next) {
            Segment v4 = v2.prev;
            Intrinsics.checkNotNull(v4);
            Intrinsics.checkNotNull(v3);
            v4.push(v3.sharedCopy());
        }

        v0.setSize$okio(arg6.size());
        return v0;
    }

    public static final Buffer commonCopyTo(Buffer arg7, Buffer arg8, long arg9, long arg11) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "out");
        long v3 = arg9;
        long v5 = arg11;
        -SegmentedByteString.checkOffsetAndCount(arg7.size(), v3, v5);
        arg9 = 0;
        if(v5 == arg9) {
        }
        else {
            arg8.setSize$okio(arg8.size() + v5);
            Segment v11;
            for(v11 = arg7.head; true; v11 = v11.next) {
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
                if(arg8.head == null) {
                    v1.prev = v1;
                    v1.next = v1.prev;
                    arg8.head = v1.next;
                }
                else {
                    Segment v2 = arg8.head;
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

        return arg7;
    }

    public static final boolean commonEquals(Buffer arg18, Object arg19) {
        Buffer v0 = arg18;
        Object v1 = arg19;
        Intrinsics.checkNotNullParameter(v0, "<this>");
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

    public static final long commonExpandBuffer(UnsafeCursor arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(arg10 > 0) {
            int v0 = 0x2000;
            if(arg10 <= v0) {
                Buffer v1 = arg9.buffer;
                if(v1 != null) {
                    if(arg9.readWrite) {
                        long v2 = v1.size();
                        Segment v10 = v1.writableSegment$okio(arg10);
                        int v4 = 0x2000 - v10.limit;
                        v10.limit = v0;
                        long v5 = ((long)v4);
                        v1.setSize$okio(v2 + v5);
                        arg9.setSegment$okio(v10);
                        arg9.offset = v2;
                        arg9.data = v10.data;
                        arg9.start = 0x2000 - v4;
                        arg9.end = v0;
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

    public static final byte commonGet(Buffer arg7, long arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        long v3 = arg8;
        -SegmentedByteString.checkOffsetAndCount(arg7.size(), v3, 1);
        Segment v8 = arg7.head;
        if(v8 != null) {
            if(arg7.size() - v3 < v3) {
                long v0;
                for(v0 = arg7.size(); v0 > v3; v0 -= ((long)(v8.limit - v8.pos))) {
                    v8 = v8.prev;
                    Intrinsics.checkNotNull(v8);
                }

                Intrinsics.checkNotNull(v8);
                return v8.data[((int)((((long)v8.pos)) + v3 - v0))];
            }

            for(v0 = 0; true; v0 = v5) {
                long v5 = (((long)(v8.limit - v8.pos))) + v0;
                if(v5 > v3) {
                    break;
                }

                v8 = v8.next;
                Intrinsics.checkNotNull(v8);
            }

            Intrinsics.checkNotNull(v8);
            return v8.data[((int)((((long)v8.pos)) + v3 - v0))];
        }

        Intrinsics.checkNotNull(null);
        throw null;
    }

    public static final int commonHashCode(Buffer arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Segment v0 = arg5.head;
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
        while(v0 != arg5.head);

        return v1;
    }

    public static final long commonIndexOf(Buffer arg20, ByteString arg21, long arg22, long arg24, int arg26, int arg27) {
        int v0_1;
        byte[] v2;
        long v20;
        int v11_1;
        byte[] v8_1;
        Buffer v0 = arg20;
        long v1 = arg22;
        long v3 = arg24;
        int v5 = arg26;
        int v6 = arg27;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        ByteString v8 = arg21;
        Intrinsics.checkNotNullParameter(v8, "bytes");
        long v13 = ((long)v6);
        -SegmentedByteString.checkOffsetAndCount(((long)v8.size()), ((long)v5), v13);
        if(v6 > 0) {
            long v9 = 0;
            if(v1 >= v9) {
                if(v1 <= v3) {
                    if(v3 > v0.size()) {
                        v3 = v0.size();
                    }

                    long v11 = -1;
                    if(Long.compare(v1, v3) == 0) {
                        return v11;
                    }

                    Segment v7 = v0.head;
                    if(v7 == null) {
                        return v11;
                    }

                    long v16 = 1;
                    if(Long.compare(v0.size() - v1, v1) < 0) {
                        v9 = v0.size();
                        while(v9 > v1) {
                            v7 = v7.prev;
                            Intrinsics.checkNotNull(v7);
                            v9 -= ((long)(v7.limit - v7.pos));
                            v11 = v11;
                        }

                        arg24 = v11;
                        if(v7 == null) {
                            return arg24;
                        }
                        else {
                            v8_1 = v8.internalArray$okio();
                            v11_1 = v8_1[v5];
                            v3 = Math.min(v3, v0.size() - v13 + v16);
                            while(v9 < v3) {
                                v20 = v1;
                                v2 = v7.data;
                                v0_1 = ((int)Math.min(((long)v7.limit), (((long)v7.pos)) + v3 - v9));
                                int v1_1;
                                for(v1_1 = ((int)((((long)v7.pos)) + v20 - v9)); v1_1 < v0_1; ++v1_1) {
                                    if(v2[v1_1] == v11_1 && (-Buffer.rangeEquals(v7, v1_1 + 1, v8_1, v5 + 1, v6))) {
                                        goto label_79;
                                    }
                                }

                                v9 += ((long)(v7.limit - v7.pos));
                                v7 = v7.next;
                                Intrinsics.checkNotNull(v7);
                                v1 = v9;
                            }

                            return arg24;
                        }
                    }
                    else {
                        arg24 = v11;
                        while(true) {
                            v11 = (((long)(v7.limit - v7.pos))) + v9;
                            if(v11 > v1) {
                                break;
                            }

                            v7 = v7.next;
                            Intrinsics.checkNotNull(v7);
                            v9 = v11;
                        }

                        if(v7 == null) {
                            return arg24;
                        }

                        v8_1 = v8.internalArray$okio();
                        v11_1 = v8_1[v5];
                        v3 = Math.min(v3, v0.size() - v13 + v16);
                        while(v9 < v3) {
                            v20 = v1;
                            v2 = v7.data;
                            v0_1 = ((int)Math.min(((long)v7.limit), (((long)v7.pos)) + v3 - v9));
                            for(v1_1 = ((int)((((long)v7.pos)) + v20 - v9)); v1_1 < v0_1; ++v1_1) {
                                if(v2[v1_1] == v11_1 && (-Buffer.rangeEquals(v7, v1_1 + 1, v8_1, v5 + 1, v6))) {
                                    goto label_79;
                                }
                            }

                            v9 += ((long)(v7.limit - v7.pos));
                            v7 = v7.next;
                            Intrinsics.checkNotNull(v7);
                            v1 = v9;
                        }

                        return arg24;
                    }

                label_79:
                    return (((long)(v1_1 - v7.pos))) + v9;
                }

                throw new IllegalArgumentException("fromIndex > toIndex: " + v1 + " > " + v3.toString());
            }

            throw new IllegalArgumentException("fromIndex < 0: " + v1.toString());
        }

        throw new IllegalArgumentException("byteCount == 0".toString());
    }

    public static final long commonIndexOf(Buffer arg9, byte arg10, long arg11, long arg13) {
        int v5;
        byte[] v9;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        long v0 = 0;
        if(v0 <= arg11 && arg11 <= arg13) {
            if(arg13 > arg9.size()) {
                arg13 = arg9.size();
            }

            long v3 = -1;
            if(Long.compare(arg11, arg13) == 0) {
                return v3;
            }

            Segment v2 = arg9.head;
            if(v2 == null) {
                return v3;
            }

            if(arg9.size() - arg11 < arg11) {
                for(v0 = arg9.size(); v0 > arg11; v0 -= ((long)(v2.limit - v2.pos))) {
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
                            goto label_48;
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
                            goto label_48;
                        }
                    }

                    v0 += ((long)(v2.limit - v2.pos));
                    v2 = v2.next;
                    Intrinsics.checkNotNull(v2);
                    arg11 = v0;
                }

                return v3;
            }

        label_48:
            return (((long)(v11 - v2.pos))) + v0;
        }

        throw new IllegalArgumentException("size=" + arg9.size() + " fromIndex=" + arg11 + " toIndex=" + arg13.toString());
    }

    public static long commonIndexOf$default(Buffer arg8, ByteString arg9, long arg10, long arg12, int arg14, int arg15, int arg16, Object arg17) {
        if((arg16 & 4) != 0) {
            arg12 = 0x7FFFFFFFFFFFFFFFL;
        }

        long v4 = arg12;
        int v6 = (arg16 & 8) != 0 ? 0 : arg14;
        int v7 = (arg16 & 16) != 0 ? arg9.size() : arg15;
        return -Buffer.commonIndexOf(arg8, arg9, arg10, v4, v6, v7);
    }

    public static final long commonIndexOfElement(Buffer arg11, ByteString arg12, long arg13) {
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
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg12, "targetBytes");
        long v0 = 0;
        if(arg13 >= v0) {
            Segment v2 = arg11.head;
            long v3 = -1;
            if(v2 == null) {
                return v3;
            }

            int v6 = 2;
            if(Long.compare(arg11.size() - arg13, arg13) < 0) {
                for(v0 = arg11.size(); v0 > arg13; v0 -= ((long)(v2.limit - v2.pos))) {
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
                        goto label_33;
                    }
                    else {
                        v12_1 = arg12.internalArray$okio();
                        while(true) {
                            if(v0 < arg11.size()) {
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
                                            goto label_80;
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

                    label_33:
                        while(v0 < arg11.size()) {
                            v6_1 = v2.data;
                            v13 = ((int)((((long)v2.pos)) + arg13 - v0));
                            v14 = v2.limit;
                            while(true) {
                                if(v13 < v14) {
                                    v7 = v6_1[v13];
                                    if(v7 == v5) {
                                        goto label_49;
                                    }
                                    else if(v7 == v12) {
                                        goto label_49;
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
                    goto label_112;
                }
                else {
                    v12_1 = arg12.internalArray$okio();
                    while(true) {
                        if(v0 < arg11.size()) {
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
                                        goto label_80;
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

                label_80:
                    v11 = v2.pos;
                    goto label_50;
                    while(true) {
                    label_112:
                        if(v0 < arg11.size()) {
                            v6_1 = v2.data;
                            v13 = ((int)((((long)v2.pos)) + arg13 - v0));
                            v14 = v2.limit;
                            while(true) {
                                if(v13 < v14) {
                                    v7 = v6_1[v13];
                                    if(v7 == v5) {
                                        goto label_49;
                                    }
                                    else if(v7 == v12) {
                                        goto label_49;
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

                label_49:
                    v11 = v2.pos;
                }
            }

        label_50:
            return (((long)(v13 - v11))) + v0;
        }

        throw new IllegalArgumentException("fromIndex < 0: " + arg13.toString());
    }

    public static final int commonNext(UnsafeCursor arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        long v0 = arg4.offset;
        Buffer v2 = arg4.buffer;
        Intrinsics.checkNotNull(v2);
        if(v0 != v2.size()) {
            v0 = arg4.offset == -1 ? 0 : arg4.offset + (((long)(arg4.end - arg4.start)));
            return arg4.seek(v0);
        }

        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(Buffer arg10, long arg11, ByteString arg13, int arg14, int arg15) {
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        Intrinsics.checkNotNullParameter(arg13, "bytes");
        if(arg15 < 0) {
            return 0;
        }

        if(arg11 >= 0) {
            if((((long)arg15)) + arg11 > arg10.size()) {
            }
            else if(arg14 >= 0) {
                if(arg14 + arg15 > arg13.size()) {
                }
                else if(arg15 == 0) {
                    return 1;
                }
                else if(-Buffer.commonIndexOf(arg10, arg13, arg11, arg11 + 1, arg14, arg15) != -1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static final int commonRead(Buffer arg2, byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "sink");
        return arg2.read(arg3, 0, arg3.length);
    }

    public static final int commonRead(Buffer arg7, byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "sink");
        -SegmentedByteString.checkOffsetAndCount(((long)arg8.length), ((long)arg9), ((long)arg10));
        Segment v0 = arg7.head;
        if(v0 == null) {
            return -1;
        }

        arg10 = Math.min(arg10, v0.limit - v0.pos);
        ArraysKt.copyInto(v0.data, arg8, arg9, v0.pos, v0.pos + arg10);
        v0.pos += arg10;
        arg7.setSize$okio(arg7.size() - (((long)arg10)));
        if(v0.pos == v0.limit) {
            arg7.head = v0.pop();
            SegmentPool.recycle(v0);
        }

        return arg10;
    }

    public static final long commonRead(Buffer arg4, Buffer arg5, long arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "sink");
        long v0 = 0;
        if(arg6 >= v0) {
            if(arg4.size() == v0) {
                return -1;
            }

            if(arg6 > arg4.size()) {
                arg6 = arg4.size();
            }

            arg5.write(arg4, arg6);
            return arg6;
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg6.toString());
    }

    public static final long commonReadAll(Buffer arg4, Sink arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "sink");
        long v0 = arg4.size();
        if(v0 > 0) {
            arg5.write(arg4, v0);
        }

        return v0;
    }

    public static final UnsafeCursor commonReadAndWriteUnsafe(Buffer arg1, UnsafeCursor arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "unsafeCursor");
        if(arg2.buffer == null) {
            arg2.buffer = arg1;
            arg2.readWrite = true;
            return arg2;
        }

        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(Buffer arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(arg9.size() != 0) {
            Segment v0 = arg9.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v2 = v0.limit;
            int v4 = v1 + 1;
            byte v1_1 = v0.data[v1];
            arg9.setSize$okio(arg9.size() - 1);
            if(v4 == v2) {
                arg9.head = v0.pop();
                SegmentPool.recycle(v0);
                return v1_1;
            }

            v0.pos = v4;
            return v1_1;
        }

        throw new EOFException();
    }

    public static final byte[] commonReadByteArray(Buffer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.readByteArray(arg2.size());
    }

    public static final byte[] commonReadByteArray(Buffer arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg3 >= 0 && arg3 <= 0x7FFFFFFF) {
            if(arg2.size() >= arg3) {
                byte[] v3 = new byte[((int)arg3)];
                arg2.readFully(v3);
                return v3;
            }
            else {
                throw new EOFException();
            }
        }

        throw new IllegalArgumentException("byteCount: " + arg3.toString());
    }

    public static final ByteString commonReadByteString(Buffer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.readByteString(arg2.size());
    }

    public static final ByteString commonReadByteString(Buffer arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg3 >= 0 && arg3 <= 0x7FFFFFFF) {
            if(arg2.size() < arg3) {
                throw new EOFException();
            }
            else if(arg3 >= 0x1000) {
                ByteString v0 = arg2.snapshot(((int)arg3));
                arg2.skip(arg3);
                return v0;
            }
            else {
                return new ByteString(arg2.readByteArray(arg3));
            }
        }

        throw new IllegalArgumentException("byteCount: " + arg3.toString());
    }

    public static final long commonReadDecimalLong(Buffer arg19) {
        long v17;
        int v14;
        Buffer v0 = arg19;
        Intrinsics.checkNotNullParameter(v0, "<this>");
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
                                goto label_59;
                            }

                            break;
                        }
                        else {
                            v14 = 0x30 - v15;
                            int v16 = Long.compare(v8, -922337203685477580L);
                            if(v16 >= 0) {
                                v17 = v3;
                                if(v16 == 0 && (((long)v14)) < v6) {
                                    goto label_37;
                                }

                                v8 = v8 * 10 + (((long)v14));
                                goto label_59;
                            }

                        label_37:
                            v0 = new Buffer().writeDecimalLong(v8).writeByte(v15);
                            if(v2 == 0) {
                                v0.readByte();
                            }

                            throw new NumberFormatException("Number too large: " + v0.readUtf8());
                        }

                    label_59:
                        ++v12;
                        ++v1;
                        v3 = v17;
                        continue;
                    }
                    else {
                        goto label_65;
                    }
                }

                v5 = 1;
                goto label_66;
            label_65:
                v17 = v3;
            label_66:
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

    public static final void commonReadFully(Buffer arg2, Buffer arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "sink");
        if(arg2.size() >= arg4) {
            arg3.write(arg2, arg4);
            return;
        }

        arg3.write(arg2, arg2.size());
        throw new EOFException();
    }

    public static final void commonReadFully(Buffer arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "sink");
        int v0;
        for(v0 = 0; true; v0 += v1) {
            if(v0 >= arg4.length) {
                return;
            }

            int v1 = arg3.read(arg4, v0, arg4.length - v0);
            if(v1 == -1) {
                break;
            }
        }

        throw new EOFException();
    }

    public static final long commonReadHexadecimalUnsignedLong(Buffer arg14) {
        int v11;
        byte v10;
        Intrinsics.checkNotNullParameter(arg14, "<this>");
        long v2 = 0;
        if(arg14.size() != v2) {
            int v0 = 0;
            int v1 = 0;
            long v4 = v2;
            do {
                Segment v6 = arg14.head;
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
                                goto label_32;
                            }

                            if(v10 >= 65 && v10 <= 70) {
                                v11 = v10 - 55;
                                goto label_32;
                            }

                            goto label_55;
                        }
                        else {
                            v11 = v10 - 0x30;
                        }

                    label_32:
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

                    goto label_67;
                }

                throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(v4).writeByte(v10).readUtf8());
            label_55:
                if(v0 != 0) {
                    v1 = 1;
                }
                else {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + -SegmentedByteString.toHexString(v10));
                }

            label_67:
                if(v8 == v9) {
                    arg14.head = v6.pop();
                    SegmentPool.recycle(v6);
                }
                else {
                    v6.pos = v8;
                }

                if(v1 != 0) {
                    break;
                }
            }
            while(arg14.head != null);

            arg14.setSize$okio(arg14.size() - (((long)v0)));
            return v4;
        }

        throw new EOFException();
    }

    public static final int commonReadInt(Buffer arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        long v2 = 4;
        if(arg9.size() >= v2) {
            Segment v0 = arg9.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v4 = v0.limit;
            if((((long)(v4 - v1))) < v2) {
                return arg9.readByte() & 0xFF | ((arg9.readByte() & 0xFF) << 24 | (arg9.readByte() & 0xFF) << 16 | (arg9.readByte() & 0xFF) << 8);
            }

            byte[] v5 = v0.data;
            int v7 = v1 + 3;
            int v6 = (v5[v1 + 1] & 0xFF) << 16 | (v5[v1] & 0xFF) << 24 | (v5[v1 + 2] & 0xFF) << 8;
            v1 += 4;
            int v5_1 = v5[v7] & 0xFF | v6;
            arg9.setSize$okio(arg9.size() - v2);
            if(v1 == v4) {
                arg9.head = v0.pop();
                SegmentPool.recycle(v0);
                return v5_1;
            }

            v0.pos = v1;
            return v5_1;
        }

        throw new EOFException();
    }

    public static final long commonReadLong(Buffer arg15) {
        Intrinsics.checkNotNullParameter(arg15, "<this>");
        long v2 = 8;
        if(arg15.size() >= v2) {
            Segment v0 = arg15.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v4 = v0.limit;
            int v6 = 0x20;
            if(Long.compare(((long)(v4 - v1)), v2) < 0) {
                return ((((long)arg15.readInt())) & 0xFFFFFFFFL) << v6 | 0xFFFFFFFFL & (((long)arg15.readInt()));
            }

            byte[] v5 = v0.data;
            int v8 = v1 + 7;
            long v6_1 = ((((long)v5[v1])) & 0xFF) << 56 | ((((long)v5[v1 + 1])) & 0xFF) << 0x30 | ((((long)v5[v1 + 2])) & 0xFF) << 40 | ((((long)v5[v1 + 3])) & 0xFF) << v6 | ((((long)v5[v1 + 4])) & 0xFF) << 24 | ((((long)v5[v1 + 5])) & 0xFF) << 16 | ((((long)v5[v1 + 6])) & 0xFF) << 8;
            v1 += 8;
            long v5_1 = v6_1 | (((long)v5[v8])) & 0xFF;
            arg15.setSize$okio(arg15.size() - v2);
            if(v1 == v4) {
                arg15.head = v0.pop();
                SegmentPool.recycle(v0);
                return v5_1;
            }

            v0.pos = v1;
            return v5_1;
        }

        throw new EOFException();
    }

    public static final short commonReadShort(Buffer arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        long v2 = 2;
        if(arg9.size() >= v2) {
            Segment v0 = arg9.head;
            Intrinsics.checkNotNull(v0);
            int v1 = v0.pos;
            int v4 = v0.limit;
            int v6 = 2;
            if(v4 - v1 < v6) {
                return ((short)(arg9.readByte() & 0xFF | (arg9.readByte() & 0xFF) << 8));
            }

            byte[] v5 = v0.data;
            int v7 = v1 + 1;
            int v8 = (v5[v1] & 0xFF) << 8;
            v1 += v6;
            int v5_1 = v5[v7] & 0xFF | v8;
            arg9.setSize$okio(arg9.size() - v2);
            if(v1 == v4) {
                arg9.head = v0.pop();
                SegmentPool.recycle(v0);
            }
            else {
                v0.pos = v1;
            }

            return ((short)v5_1);
        }

        throw new EOFException();
    }

    public static final UnsafeCursor commonReadUnsafe(Buffer arg1, UnsafeCursor arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "unsafeCursor");
        if(arg2.buffer == null) {
            arg2.buffer = arg1;
            arg2.readWrite = false;
            return arg2;
        }

        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final String commonReadUtf8(Buffer arg5, long arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0 = Long.compare(arg6, 0);
        if(v0 >= 0 && arg6 <= 0x7FFFFFFF) {
            if(arg5.size() < arg6) {
                throw new EOFException();
            }
            else if(v0 == 0) {
                return "";
            }
            else {
                Segment v0_1 = arg5.head;
                Intrinsics.checkNotNull(v0_1);
                if((((long)v0_1.pos)) + arg6 > (((long)v0_1.limit))) {
                    return _Utf8Kt.commonToUtf8String$default(arg5.readByteArray(arg6), 0, 0, 3, null);
                }
                else {
                    int v4 = ((int)arg6);
                    String v1 = _Utf8Kt.commonToUtf8String(v0_1.data, v0_1.pos, v0_1.pos + v4);
                    v0_1.pos += v4;
                    arg5.setSize$okio(arg5.size() - arg6);
                    if(v0_1.pos == v0_1.limit) {
                        arg5.head = v0_1.pop();
                        SegmentPool.recycle(v0_1);
                    }

                    return v1;
                }
            }
        }

        throw new IllegalArgumentException("byteCount: " + arg6.toString());
    }

    public static final int commonReadUtf8CodePoint(Buffer arg12) {
        long v7;
        int v5;
        int v6;
        int v1;
        Intrinsics.checkNotNullParameter(arg12, "<this>");
        long v2 = 0;
        if(arg12.size() == v2) {
            goto label_84;
        }

        byte v0 = arg12.getByte(v2);
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
            goto label_81;
        }

        long v9 = ((long)v5);
        if(arg12.size() < v9) {
            goto label_63;
        }

        while(true) {
            if(v2_1 >= v5) {
                goto label_51;
            }

            v7 = ((long)v2_1);
            int v0_1 = arg12.getByte(v7);
            if((v0_1 & 0xC0) != v3) {
                break;
            }

            v1 = v1 << 6 | v0_1 & 0x3F;
            ++v2_1;
        }

        arg12.skip(v7);
        return v4;
    label_51:
        arg12.skip(v9);
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
    label_63:
        throw new EOFException("size < " + v5 + ": " + arg12.size() + " (to read code point prefixed 0x" + -SegmentedByteString.toHexString(v0) + ')');
    label_81:
        arg12.skip(1);
        return v4;
    label_84:
        throw new EOFException();
    }

    public static final String commonReadUtf8Line(Buffer arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        long v0 = arg4.indexOf(10);
        if(v0 != -1) {
            return -Buffer.readUtf8Line(arg4, v0);
        }

        if(arg4.size() != 0) {
            return arg4.readUtf8(arg4.size());
        }

        return null;
    }

    public static final String commonReadUtf8LineStrict(Buffer arg10, long arg11) {
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        if(arg11 >= 0) {
            long v1 = 0x7FFFFFFFFFFFFFFFL;
            long v6 = 1;
            if(Long.compare(arg11, v1) == 0) {
            }
            else {
                v1 = arg11 + v6;
            }

            long v4 = v1;
            v1 = arg10.indexOf(10, 0, v4);
            if(v1 != -1) {
                return -Buffer.readUtf8Line(arg10, v1);
            }

            if(v4 < arg10.size() && arg10.getByte(v4 - v6) == 13 && arg10.getByte(v4) == 10) {
                return -Buffer.readUtf8Line(arg10, v4);
            }

            Buffer v1_1 = new Buffer();
            arg10.copyTo(v1_1, 0, Math.min(0x20, arg10.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(arg10.size(), arg11) + " content=" + v1_1.readByteString().hex() + '…');
        }

        throw new IllegalArgumentException("limit < 0: " + arg11.toString());
    }

    public static final long commonResizeBuffer(UnsafeCursor arg13, long arg14) {
        Segment v3_1;
        long v6;
        Intrinsics.checkNotNullParameter(arg13, "<this>");
        Buffer v0 = arg13.buffer;
        if(v0 != null) {
            if(arg13.readWrite) {
                long v1 = v0.size();
                int v3 = Long.compare(arg14, v1);
                long v4 = 0;
                if(v3 > 0) {
                    if(v3 <= 0) {
                        goto label_76;
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

                        arg13.setSegment$okio(v9);
                        arg13.offset = v1;
                        arg13.data = v9.data;
                        arg13.start = v9.limit - v10;
                        arg13.end = v9.limit;
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

                        goto label_31;
                    }

                    v3_1.limit -= ((int)v6);
                label_31:
                    arg13.setSegment$okio(null);
                    arg13.offset = arg14;
                    arg13.data = null;
                    arg13.start = -1;
                    arg13.end = -1;
                }
                else {
                    throw new IllegalArgumentException("newSize < 0: " + arg14.toString());
                }

            label_76:
                v0.setSize$okio(arg14);
                return v1;
            }

            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }

        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final int commonSeek(UnsafeCursor arg12, long arg13) {
        Intrinsics.checkNotNullParameter(arg12, "<this>");
        Buffer v0 = arg12.buffer;
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
                        if(arg12.getSegment$okio() != null) {
                            long v8 = arg12.offset;
                            int v5 = arg12.start;
                            Segment v10 = arg12.getSegment$okio();
                            Intrinsics.checkNotNull(v10);
                            v8 -= ((long)(v5 - v10.pos));
                            if(v8 > arg13) {
                                v4 = arg12.getSegment$okio();
                                v1_1 = v8;
                            }
                            else {
                                v3 = arg12.getSegment$okio();
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

                        if(arg12.readWrite) {
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

                        arg12.setSegment$okio(v3);
                        arg12.offset = arg13;
                        Intrinsics.checkNotNull(v3);
                        arg12.data = v3.data;
                        arg12.start = v3.pos + (((int)(arg13 - v6)));
                        arg12.end = v3.limit;
                        return arg12.end - arg12.start;
                    }
                }

                arg12.setSegment$okio(null);
                arg12.offset = arg13;
                arg12.data = null;
                arg12.start = -1;
                arg12.end = -1;
                return -1;
            }

            throw new ArrayIndexOutOfBoundsException("offset=" + arg13 + " > size=" + v0.size());
        }

        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final int commonSelect(Buffer arg3, Options arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "options");
        int v0 = -Buffer.selectPrefix$default(arg3, arg4, false, 2, null);
        int v1 = -1;
        if(v0 == v1) {
            return v1;
        }

        arg3.skip(((long)arg4.getByteStrings$okio()[v0].size()));
        return v0;
    }

    public static final void commonSkip(Buffer arg6, long arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        while(true) {
            if(arg7 <= 0) {
                return;
            }

            Segment v0 = arg6.head;
            if(v0 == null) {
                break;
            }

            int v1 = ((int)Math.min(arg7, ((long)(v0.limit - v0.pos))));
            long v4 = ((long)v1);
            arg6.setSize$okio(arg6.size() - v4);
            arg7 -= v4;
            v0.pos += v1;
            if(v0.pos != v0.limit) {
                continue;
            }

            arg6.head = v0.pop();
            SegmentPool.recycle(v0);
        }

        throw new EOFException();
    }

    public static final ByteString commonSnapshot(Buffer arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.size() <= 0x7FFFFFFF) {
            return arg4.snapshot(((int)arg4.size()));
        }

        throw new IllegalStateException("size > Int.MAX_VALUE: " + arg4.size().toString());
    }

    public static final ByteString commonSnapshot(Buffer arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        if(arg7 == 0) {
            return ByteString.EMPTY;
        }

        -SegmentedByteString.checkOffsetAndCount(arg6.size(), 0, ((long)arg7));
        Segment v0 = arg6.head;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(true) {
            if(v2 >= arg7) {
                goto label_29;
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
    label_29:
        byte[][] v0_1 = new byte[v3][];
        int[] v2_1 = new int[v3 * 2];
        Segment v6 = arg6.head;
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

    public static final Segment commonWritableSegment(Buffer arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg3 >= 1) {
            int v0 = 0x2000;
            if(arg3 <= v0) {
                if(arg2.head == null) {
                    Segment v3 = SegmentPool.take();
                    arg2.head = v3;
                    v3.prev = v3;
                    v3.next = v3;
                    return v3;
                }
                else {
                    Segment v2 = arg2.head;
                    Intrinsics.checkNotNull(v2);
                    v2 = v2.prev;
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

    public static final Buffer commonWrite(Buffer arg1, ByteString arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "byteString");
        arg2.write$okio(arg1, arg3, arg4);
        return arg1;
    }

    public static final Buffer commonWrite(Buffer arg4, Source arg5, long arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "source");
        while(true) {
            if(arg6 <= 0) {
                return arg4;
            }

            long v0 = arg5.read(arg4, arg6);
            if(v0 == -1) {
                break;
            }

            arg6 -= v0;
        }

        throw new EOFException();
        return arg4;
    }

    public static final Buffer commonWrite(Buffer arg2, byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "source");
        return arg2.write(arg3, 0, arg3.length);
    }

    public static final Buffer commonWrite(Buffer arg7, byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "source");
        long v5 = ((long)arg10);
        -SegmentedByteString.checkOffsetAndCount(((long)arg8.length), ((long)arg9), v5);
        arg10 += arg9;
        while(arg9 < arg10) {
            Segment v0 = arg7.writableSegment$okio(1);
            int v1 = Math.min(arg10 - arg9, 0x2000 - v0.limit);
            int v4 = arg9 + v1;
            ArraysKt.copyInto(arg8, v0.data, v0.limit, arg9, v4);
            v0.limit += v1;
            arg9 = v4;
        }

        arg7.setSize$okio(arg7.size() + v5);
        return arg7;
    }

    public static final void commonWrite(Buffer arg7, Buffer arg8, long arg9) {
        long v1_1;
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "source");
        if(arg8 != arg7) {
            -SegmentedByteString.checkOffsetAndCount(arg8.size(), 0, arg9);
            while(arg9 > 0) {
                Segment v0 = arg8.head;
                Intrinsics.checkNotNull(v0);
                int v0_1 = v0.limit;
                Segment v1 = arg8.head;
                Intrinsics.checkNotNull(v1);
                if(arg9 < (((long)(v0_1 - v1.pos)))) {
                    if(arg7.head != null) {
                        v0 = arg7.head;
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
                            goto label_53;
                        }

                        v1 = arg8.head;
                        Intrinsics.checkNotNull(v1);
                        v1.writeTo(v0, ((int)arg9));
                        arg8.setSize$okio(arg8.size() - arg9);
                        arg7.setSize$okio(arg7.size() + arg9);
                        return;
                    }

                label_53:
                    v0 = arg8.head;
                    Intrinsics.checkNotNull(v0);
                    arg8.head = v0.split(((int)arg9));
                }

                v0 = arg8.head;
                Intrinsics.checkNotNull(v0);
                v1_1 = ((long)(v0.limit - v0.pos));
                arg8.head = v0.pop();
                if(arg7.head == null) {
                    arg7.head = v0;
                    v0.prev = v0;
                    v0.next = v0.prev;
                }
                else {
                    Segment v3_1 = arg7.head;
                    Intrinsics.checkNotNull(v3_1);
                    v3_1 = v3_1.prev;
                    Intrinsics.checkNotNull(v3_1);
                    v3_1.push(v0).compact();
                }

                arg8.setSize$okio(arg8.size() - v1_1);
                arg7.setSize$okio(arg7.size() + v1_1);
                arg9 -= v1_1;
            }

            return;
        }

        throw new IllegalArgumentException("source == this".toString());
    }

    public static Buffer commonWrite$default(Buffer arg0, ByteString arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg1.size();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "byteString");
        arg1.write$okio(arg0, 0, arg3);
        return arg0;
    }

    public static final long commonWriteAll(Buffer arg6, Source arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "source");
        long v0;
        for(v0 = 0; true; v0 += v2) {
            long v2 = arg7.read(arg6, 0x2000);
            if(v2 == -1) {
                return v0;
            }
        }

        return v0;
    }

    public static final Buffer commonWriteByte(Buffer arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Segment v0 = arg4.writableSegment$okio(1);
        byte[] v1 = v0.data;
        int v2 = v0.limit;
        v0.limit = v2 + 1;
        v1[v2] = ((byte)arg5);
        arg4.setSize$okio(arg4.size() + 1);
        return arg4;
    }

    public static final Buffer commonWriteDecimalLong(Buffer arg11, long arg12) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        long v0 = 0;
        int v2 = Long.compare(arg12, v0);
        if(v2 == 0) {
            return arg11.writeByte(0x30);
        }

        if(v2 < 0) {
            arg12 = -arg12;
            if(arg12 < v0) {
                return arg11.writeUtf8("-9223372036854775808");
            }
            else {
                v2 = 1;
            }
        }
        else {
            v2 = 0;
        }

        int v3 = -Buffer.countDigitsIn(arg12);
        if(v2 != 0) {
            ++v3;
        }

        Segment v4 = arg11.writableSegment$okio(v3);
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
        arg11.setSize$okio(arg11.size() + (((long)v3)));
        return arg11;
    }

    public static final Buffer commonWriteHexadecimalUnsignedLong(Buffer arg12, long arg13) {
        Intrinsics.checkNotNullParameter(arg12, "<this>");
        if(arg13 == 0) {
            return arg12.writeByte(0x30);
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
        Segment v2 = arg12.writableSegment$okio(v1_1);
        byte[] v3 = v2.data;
        int v5 = v2.limit + v1_1 - 1;
        int v0 = v2.limit;
        while(v5 >= v0) {
            v3[v5] = -Buffer.getHEX_DIGIT_BYTES()[((int)(15 & arg13))];
            arg13 >>>= v4;
            --v5;
        }

        v2.limit += v1_1;
        arg12.setSize$okio(arg12.size() + (((long)v1_1)));
        return arg12;
    }

    public static final Buffer commonWriteInt(Buffer arg7, int arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Segment v1 = arg7.writableSegment$okio(4);
        byte[] v2 = v1.data;
        int v3 = v1.limit;
        v2[v3] = ((byte)(arg8 >>> 24 & 0xFF));
        v2[v3 + 1] = ((byte)(arg8 >>> 16 & 0xFF));
        v2[v3 + 2] = ((byte)(arg8 >>> 8 & 0xFF));
        v2[v3 + 3] = ((byte)(arg8 & 0xFF));
        v1.limit = v3 + 4;
        arg7.setSize$okio(arg7.size() + 4);
        return arg7;
    }

    public static final Buffer commonWriteLong(Buffer arg11, long arg12) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Segment v1 = arg11.writableSegment$okio(8);
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
        arg11.setSize$okio(arg11.size() + 8);
        return arg11;
    }

    public static final Buffer commonWriteShort(Buffer arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Segment v1 = arg6.writableSegment$okio(2);
        byte[] v2 = v1.data;
        int v3 = v1.limit;
        v2[v3] = ((byte)(arg7 >>> 8 & 0xFF));
        v2[v3 + 1] = ((byte)(arg7 & 0xFF));
        v1.limit = v3 + 2;
        arg6.setSize$okio(arg6.size() + 2);
        return arg6;
    }

    public static final Buffer commonWriteUtf8(Buffer arg11, String arg12, int arg13, int arg14) {
        Segment v3_1;
        int v6;
        int v5;
        int v4;
        byte[] v3;
        Segment v2;
        int v0;
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg12, "string");
        if(arg13 < 0) {
            goto label_192;
        }

        if(arg14 < arg13) {
            goto label_180;
        }

        if(arg14 > arg12.length()) {
            goto label_167;
        }

    label_8:
        while(arg13 < arg14) {
            v0 = arg12.charAt(arg13);
            int v1 = 0x80;
            if(v0 < v1) {
                v2 = arg11.writableSegment$okio(1);
                v3 = v2.data;
                v4 = v2.limit - arg13;
                v5 = Math.min(arg14, 0x2000 - v4);
                v6 = arg13 + 1;
                v3[arg13 + v4] = ((byte)v0);
                goto label_23;
            }

            v4 = 2;
            if(v0 < 0x800) {
                v3_1 = arg11.writableSegment$okio(v4);
                v3_1.data[v3_1.limit] = ((byte)(v0 >> 6 | 0xC0));
                v3_1.data[v3_1.limit + 1] = ((byte)(v0 & 0x3F | v1));
                v3_1.limit += v4;
                arg11.setSize$okio(arg11.size() + 2);
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
                            Segment v7_1 = arg11.writableSegment$okio(4);
                            v7_1.data[v7_1.limit] = ((byte)(v0 >> 18 | 0xF0));
                            v7_1.data[v7_1.limit + 1] = ((byte)(v0 >> 12 & v6 | v1));
                            v7_1.data[v7_1.limit + v4] = ((byte)(v0 >> 6 & v6 | v1));
                            v7_1.data[v7_1.limit + v5] = ((byte)(v0 & v6 | v1));
                            v7_1.limit += 4;
                            arg11.setSize$okio(arg11.size() + 4);
                            arg13 += 2;
                            continue;
                        }

                        arg11.writeByte(v6);
                        arg13 = v3_2;
                        continue;
                    }
                }

                v3_1 = arg11.writableSegment$okio(v5);
                v3_1.data[v3_1.limit] = ((byte)(v0 >> 12 | 0xE0));
                v3_1.data[v3_1.limit + 1] = ((byte)(v0 >> 6 & v6 | v1));
                v3_1.data[v3_1.limit + v4] = ((byte)(v0 & 0x3F | v1));
                v3_1.limit += v5;
                arg11.setSize$okio(arg11.size() + 3);
            }

            ++arg13;
        }

        return arg11;
        while(true) {
        label_23:
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
        arg11.setSize$okio(arg11.size() + (((long)v4)));
        goto label_8;
    label_167:
        throw new IllegalArgumentException("endIndex > string.length: " + arg14 + " > " + arg12.length().toString());
    label_180:
        throw new IllegalArgumentException("endIndex < beginIndex: " + arg14 + " < " + arg13.toString());
    label_192:
        throw new IllegalArgumentException("beginIndex < 0: " + arg13.toString());
    }

    public static final Buffer commonWriteUtf8CodePoint(Buffer arg9, int arg10) {
        Segment v1;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        int v0 = 0x80;
        if(arg10 < v0) {
            arg9.writeByte(arg10);
            return arg9;
        }

        int v2 = 2;
        int v3 = 0x3F;
        if(arg10 < 0x800) {
            v1 = arg9.writableSegment$okio(v2);
            v1.data[v1.limit] = ((byte)(arg10 >> 6 | 0xC0));
            v1.data[v1.limit + 1] = ((byte)(arg10 & v3 | v0));
            v1.limit += v2;
            arg9.setSize$okio(arg9.size() + 2);
            return arg9;
        }

        if(0xD800 <= arg10 && arg10 < 0xE000) {
            arg9.writeByte(v3);
            return arg9;
        }

        int v4 = 3;
        if(arg10 < 0x10000) {
            v1 = arg9.writableSegment$okio(v4);
            v1.data[v1.limit] = ((byte)(arg10 >> 12 | 0xE0));
            v1.data[v1.limit + 1] = ((byte)(arg10 >> 6 & v3 | v0));
            v1.data[v1.limit + v2] = ((byte)(arg10 & v3 | v0));
            v1.limit += v4;
            arg9.setSize$okio(arg9.size() + 3);
            return arg9;
        }

        if(arg10 <= 0x10FFFF) {
            Segment v5 = arg9.writableSegment$okio(4);
            v5.data[v5.limit] = ((byte)(arg10 >> 18 | 0xF0));
            v5.data[v5.limit + 1] = ((byte)(arg10 >> 12 & v3 | v0));
            v5.data[v5.limit + v2] = ((byte)(arg10 >> 6 & v3 | v0));
            v5.data[v5.limit + v4] = ((byte)(arg10 & v3 | v0));
            v5.limit += 4;
            arg9.setSize$okio(arg9.size() + 4);
            return arg9;
        }

        throw new IllegalArgumentException("Unexpected code point: 0x" + -SegmentedByteString.toHexString(arg10));
    }

    private static final int countDigitsIn(long arg4) {
        int v0 = (0x40 - Long.numberOfLeadingZeros(arg4)) * 10 >>> 5;
        int v4 = arg4 > -Buffer.DigitCountToLargestValue[v0] ? 1 : 0;
        return v0 + v4;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return -Buffer.HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment arg5, int arg6, byte[] arg7, int arg8, int arg9) {
        Intrinsics.checkNotNullParameter(arg5, "segment");
        Intrinsics.checkNotNullParameter(arg7, "bytes");
        int v0 = arg5.limit;
        byte[] v1 = arg5.data;
        while(arg8 < arg9) {
            if(arg6 == v0) {
                arg5 = arg5.next;
                Intrinsics.checkNotNull(arg5);
                v1 = arg5.data;
                arg6 = arg5.pos;
                v0 = arg5.limit;
            }

            if(v1[arg6] != arg7[arg8]) {
                return 0;
            }

            ++arg6;
            ++arg8;
        }

        return 1;
    }

    public static final String readUtf8Line(Buffer arg6, long arg7) {
        String v7;
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        long v1 = 1;
        if(Long.compare(arg7, 0) > 0) {
            long v3 = arg7 - v1;
            if(arg6.getByte(v3) == 13) {
                v7 = arg6.readUtf8(v3);
                arg6.skip(2);
                return v7;
            }
        }

        v7 = arg6.readUtf8(arg7);
        arg6.skip(v1);
        return v7;
    }

    public static final Object seek(Buffer arg5, long arg6, Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "lambda");
        Segment v0 = arg5.head;
        if(v0 == null) {
            return arg8.invoke(null, Long.valueOf(-1));
        }

        if(arg5.size() - arg6 < arg6) {
            long v1;
            for(v1 = arg5.size(); v1 > arg6; v1 -= ((long)(v0.limit - v0.pos))) {
                v0 = v0.prev;
                Intrinsics.checkNotNull(v0);
            }

            return arg8.invoke(v0, Long.valueOf(v1));
        }

        for(v1 = 0; true; v1 = v3) {
            long v3 = (((long)(v0.limit - v0.pos))) + v1;
            if(v3 > arg6) {
                break;
            }

            v0 = v0.next;
            Intrinsics.checkNotNull(v0);
        }

        return arg8.invoke(v0, Long.valueOf(v1));
    }

    public static final int selectPrefix(Buffer arg17, Options arg18, boolean arg19) {
        Segment v8_2;
        int v9_1;
        int v14;
        int v13;
        Intrinsics.checkNotNullParameter(arg17, "<this>");
        Options v2 = arg18;
        Intrinsics.checkNotNullParameter(v2, "options");
        Segment v0 = arg17.head;
        int v1 = -2;
        int v3 = -1;
        if(v0 == null) {
            if(arg19) {
                return v1;
            }

            return v3;
        }

        byte[] v4 = v0.data;
        int v5 = v0.pos;
        int v6 = v0.limit;
        int[] v2_1 = v2.getTrie$okio();
        Segment v9 = v0;
        int v10 = v3;
        int v8 = 0;
        while(true) {
            int v11 = v8 + 1;
            int v12 = v2_1[v8];
            v8 += 2;
            v11 = v2_1[v11];
            if(v11 != v3) {
                v10 = v11;
            }

            if(v9 == null) {
                goto label_56;
            }
            else {
                Segment v11_1 = null;
                if(v12 < 0) {
                    v13 = v8 + v12 * -1;
                    while(true) {
                        v12 = v5 + 1;
                        v14 = v8 + 1;
                        if((v4[v5] & 0xFF) != v2_1[v8]) {
                            return v10;
                        }

                        v5 = v14 == v13 ? 1 : 0;
                        if(v12 == v6) {
                            Intrinsics.checkNotNull(v9);
                            Segment v4_1 = v9.next;
                            Intrinsics.checkNotNull(v4_1);
                            v6 = v4_1.pos;
                            byte[] v8_1 = v4_1.data;
                            v9_1 = v4_1.limit;
                            if(v4_1 != v0) {
                                byte[] v16 = v8_1;
                                v8_2 = v4_1;
                                v4 = v16;
                            }
                            else if(v5 != 0) {
                                v4 = v8_1;
                                v8_2 = v11_1;
                            }
                            else {
                                goto label_56;
                            }
                        }
                        else {
                            v8_2 = v9;
                            v9_1 = v6;
                            v6 = v12;
                        }

                        if(v5 != 0) {
                            v5 = v2_1[v14];
                            v13 = v6;
                            v6 = v9_1;
                            v9 = v8_2;
                            goto label_97;
                        }

                        v5 = v6;
                        v6 = v9_1;
                        v9 = v8_2;
                        v8 = v14;
                    }

                    return v10;
                label_56:
                    if(!arg19) {
                        return v10;
                    }

                    return v1;
                }
                else {
                    v13 = v5 + 1;
                    v5 = v4[v5] & 0xFF;
                    v14 = v8 + v12;
                    while(true) {
                        if(v8 == v14) {
                            return v10;
                        }

                        if(v5 == v2_1[v8]) {
                            v5 = v2_1[v8 + v12];
                            if(v13 != v6) {
                                break;
                            }

                            v9 = v9.next;
                            Intrinsics.checkNotNull(v9);
                            v13 = v9.pos;
                            v4 = v9.data;
                            v6 = v9.limit;
                            if(v9 != v0) {
                                break;
                            }

                            v9 = v11_1;
                            break;
                        }

                        ++v8;
                    }
                }

            label_97:
                if(v5 >= 0) {
                    return v5;
                }

                v8 = -v5;
                v5 = v13;
                continue;
            }
        }

        return v10;
    }

    public static int selectPrefix$default(Buffer arg0, Options arg1, boolean arg2, int arg3, Object arg4) {
        return -Buffer.selectPrefix(arg0, arg1, false);
    }
}

