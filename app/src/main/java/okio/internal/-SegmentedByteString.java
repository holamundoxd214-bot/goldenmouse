package okio.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0000\u001A\u0014\u0010\u0006\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0000\u001A]\u0010\t\u001A\u00020\n*\u00020\u00072K\u0010\u000B\u001AG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0080\bø\u0001\u0000\u001Aj\u0010\t\u001A\u00020\n*\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00012K\u0010\u000B\u001AG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0082\b\u001A\u001D\u0010\u0015\u001A\u00020\u0016*\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010\u0017\u001A\u00020\u0018*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0080\b\u001A\r\u0010\u0019\u001A\u00020\u0001*\u00020\u0007H\u0080\b\u001A\r\u0010\u001A\u001A\u00020\r*\u00020\u0007H\u0080\b\u001A%\u0010\u001B\u001A\u00020\n*\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0080\b\u001A-\u0010\u001E\u001A\u00020\u001F*\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u00162\u0006\u0010!\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0080\b\u001A-\u0010\u001E\u001A\u00020\u001F*\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0080\b\u001A-\u0010\"\u001A\u00020\n*\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\r2\u0006\u0010$\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0080\b\u001A\u0017\u0010%\u001A\u00020\u001F*\u00020\u00072\b\u0010 \u001A\u0004\u0018\u00010&H\u0080\b\u001A\r\u0010\'\u001A\u00020\u0001*\u00020\u0007H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2={"binarySearch", "", "", "value", "fromIndex", "toIndex", "segment", "Lokio/SegmentedByteString;", "pos", "forEachSegment", "", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", "offset", "byteCount", "beginIndex", "endIndex", "commonSubstring", "Lokio/ByteString;", "commonInternalGet", "", "commonGetSize", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "commonRangeEquals", "", "other", "otherOffset", "commonCopyInto", "target", "targetOffset", "commonEquals", "", "commonHashCode", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -SegmentedByteString {
    public static final int binarySearch(int[] arg2, int arg3, int arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        --arg5;
        while(true) {
            if(arg4 > arg5) {
                goto label_14;
            }

            v0 = arg4 + arg5 >>> 1;
            int v1 = arg2[v0];
            if(v1 < arg3) {
                arg4 = v0 + 1;
                continue;
            }

            if(v1 <= arg3) {
                return v0;
            }

            arg5 = v0 - 1;
        }

        return v0;
    label_14:
        return -arg4 - 1;
    }

    public static final void commonCopyInto(SegmentedByteString arg11, int arg12, byte[] arg13, int arg14, int arg15) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg13, "target");
        long v5 = ((long)arg15);
        okio.-SegmentedByteString.checkOffsetAndCount(((long)arg11.size()), ((long)arg12), v5);
        okio.-SegmentedByteString.checkOffsetAndCount(((long)arg13.length), ((long)arg14), v5);
        arg15 += arg12;
        int v0;
        for(v0 = -SegmentedByteString.segment(arg11, arg12); arg12 < arg15; ++v0) {
            int v1 = v0 == 0 ? 0 : arg11.getDirectory$okio()[v0 - 1];
            int v2 = arg11.getDirectory$okio()[v0] - v1;
            int v3 = arg11.getDirectory$okio()[arg11.getSegments$okio().length + v0];
            v2 = Math.min(arg15, v2 + v1) - arg12;
            v3 += arg12 - v1;
            ArraysKt.copyInto(arg11.getSegments$okio()[v0], arg13, arg14, v3, v3 + v2);
            arg14 += v2;
            arg12 += v2;
        }
    }

    public static final boolean commonEquals(SegmentedByteString arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if((((SegmentedByteString)arg5)) == arg4) {
            return 1;
        }

        if(((arg5 instanceof ByteString)) && ((ByteString)arg5).size() == arg4.size() && (arg4.rangeEquals(0, ((ByteString)arg5), 0, arg4.size()))) {
            return 1;
        }

        return 0;
    }

    public static final int commonGetSize(SegmentedByteString arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getDirectory$okio()[arg1.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString arg8) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        int v0 = arg8.getHashCode$okio();
        if(v0 != 0) {
            return v0;
        }

        v0 = arg8.getSegments$okio().length;
        int v1 = 0;
        int v3 = 1;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v5) {
            int v4 = arg8.getDirectory$okio()[v0 + v1];
            int v5 = arg8.getDirectory$okio()[v1];
            byte[] v6 = arg8.getSegments$okio()[v1];
            v2 = v5 - v2 + v4;
            while(v4 < v2) {
                v3 = v3 * 0x1F + v6[v4];
                ++v4;
            }

            ++v1;
        }

        arg8.setHashCode$okio(v3);
        return v3;
    }

    public static final byte commonInternalGet(SegmentedByteString arg7, int arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        okio.-SegmentedByteString.checkOffsetAndCount(((long)arg7.getDirectory$okio()[arg7.getSegments$okio().length - 1]), ((long)arg8), 1);
        int v0 = -SegmentedByteString.segment(arg7, arg8);
        int v1 = v0 == 0 ? 0 : arg7.getDirectory$okio()[v0 - 1];
        return arg7.getSegments$okio()[v0][arg8 - v1 + arg7.getDirectory$okio()[arg7.getSegments$okio().length + v0]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString arg6, int arg7, ByteString arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "other");
        if(arg7 >= 0) {
            if(arg7 > arg6.size() - arg10) {
            }
            else {
                arg10 += arg7;
                int v1;
                for(v1 = -SegmentedByteString.segment(arg6, arg7); arg7 < arg10; ++v1) {
                    int v2 = v1 == 0 ? 0 : arg6.getDirectory$okio()[v1 - 1];
                    int v3 = arg6.getDirectory$okio()[v1] - v2;
                    int v4 = arg6.getDirectory$okio()[arg6.getSegments$okio().length + v1];
                    v3 = Math.min(arg10, v3 + v2) - arg7;
                    if(!arg8.rangeEquals(arg9, arg6.getSegments$okio()[v1], v4 + (arg7 - v2), v3)) {
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

    public static final boolean commonRangeEquals(SegmentedByteString arg6, int arg7, byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "other");
        if(arg7 >= 0 && arg7 <= arg6.size() - arg10 && arg9 >= 0) {
            if(arg9 > arg8.length - arg10) {
            }
            else {
                arg10 += arg7;
                int v1;
                for(v1 = -SegmentedByteString.segment(arg6, arg7); arg7 < arg10; ++v1) {
                    int v2 = v1 == 0 ? 0 : arg6.getDirectory$okio()[v1 - 1];
                    int v3 = arg6.getDirectory$okio()[v1] - v2;
                    int v4 = arg6.getDirectory$okio()[arg6.getSegments$okio().length + v1];
                    v3 = Math.min(arg10, v3 + v2) - arg7;
                    if(!okio.-SegmentedByteString.arrayRangeEquals(arg6.getSegments$okio()[v1], v4 + (arg7 - v2), arg8, arg9, v3)) {
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

    public static final ByteString commonSubstring(SegmentedByteString arg11, int arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        if(arg12 >= 0) {
            String v1 = "endIndex=";
            if(arg13 <= arg11.size()) {
                int v0 = arg13 - arg12;
                if(v0 >= 0) {
                    if(arg12 == 0 && arg13 == arg11.size()) {
                        return arg11;
                    }

                    if(arg12 == arg13) {
                        return ByteString.EMPTY;
                    }

                    int v1_1 = -SegmentedByteString.segment(arg11, arg12);
                    arg13 = -SegmentedByteString.segment(arg11, arg13 - 1);
                    Object[] v2 = ArraysKt.copyOfRange(arg11.getSegments$okio(), v1_1, arg13 + 1);
                    Object[] v3 = v2;
                    int[] v4 = new int[v3.length * 2];
                    int v5 = 0;
                    if(v1_1 <= arg13) {
                        int v7 = v1_1;
                        int v6 = 0;
                        while(true) {
                            v4[v6] = Math.min(arg11.getDirectory$okio()[v7] - arg12, v0);
                            int v8 = v6 + 1;
                            v4[v6 + v3.length] = arg11.getDirectory$okio()[arg11.getSegments$okio().length + v7];
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
                        v5 = arg11.getDirectory$okio()[v1_1 - 1];
                    }

                    v4[v3.length] += arg12 - v5;
                    return new SegmentedByteString(((byte[][])v2), v4);
                }

                throw new IllegalArgumentException(v1 + arg13 + " < beginIndex=" + arg12.toString());
            }

            throw new IllegalArgumentException(v1 + arg13 + " > length(" + arg11.size() + ')'.toString());
        }

        throw new IllegalArgumentException("beginIndex=" + arg12 + " < 0".toString());
    }

    public static final byte[] commonToByteArray(SegmentedByteString arg9) {
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        byte[] v0 = new byte[arg9.size()];
        int v1 = arg9.getSegments$okio().length;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(v2 < v1) {
            int v5 = arg9.getDirectory$okio()[v1 + v2];
            int v6 = arg9.getDirectory$okio()[v2];
            v3 = v6 - v3;
            ArraysKt.copyInto(arg9.getSegments$okio()[v2], v0, v4, v5, v5 + v3);
            v4 += v3;
            ++v2;
            v3 = v6;
        }

        return v0;
    }

    public static final void commonWrite(SegmentedByteString arg11, Buffer arg12, int arg13, int arg14) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg12, "buffer");
        int v0 = arg13 + arg14;
        int v1;
        for(v1 = -SegmentedByteString.segment(arg11, arg13); arg13 < v0; ++v1) {
            int v2 = v1 == 0 ? 0 : arg11.getDirectory$okio()[v1 - 1];
            int v3 = arg11.getDirectory$okio()[v1] - v2;
            int v4 = arg11.getDirectory$okio()[arg11.getSegments$okio().length + v1];
            v3 = Math.min(v0, v3 + v2) - arg13;
            int v7 = v4 + (arg13 - v2);
            Segment v5 = new Segment(arg11.getSegments$okio()[v1], v7, v7 + v3, true, false);
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

    private static final void forEachSegment(SegmentedByteString arg5, int arg6, int arg7, Function3 arg8) {
        int v0;
        for(v0 = -SegmentedByteString.segment(arg5, arg6); arg6 < arg7; ++v0) {
            int v1 = v0 == 0 ? 0 : arg5.getDirectory$okio()[v0 - 1];
            int v2 = arg5.getDirectory$okio()[v0] - v1;
            int v3 = arg5.getDirectory$okio()[arg5.getSegments$okio().length + v0];
            v2 = Math.min(arg7, v2 + v1) - arg6;
            arg8.invoke(arg5.getSegments$okio()[v0], Integer.valueOf(v3 + (arg6 - v1)), Integer.valueOf(v2));
            arg6 += v2;
        }
    }

    public static final void forEachSegment(SegmentedByteString arg6, Function3 arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "action");
        int v0 = arg6.getSegments$okio().length;
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < v0; v2 = v4) {
            int v3 = arg6.getDirectory$okio()[v0 + v1];
            int v4 = arg6.getDirectory$okio()[v1];
            arg7.invoke(arg6.getSegments$okio()[v1], Integer.valueOf(v3), Integer.valueOf(v4 - v2));
            ++v1;
        }
    }

    public static final int segment(SegmentedByteString arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v2 = -SegmentedByteString.binarySearch(arg2.getDirectory$okio(), arg3 + 1, 0, arg2.getSegments$okio().length);
        if(v2 >= 0) {
            return v2;
        }

        return ~v2;
    }
}

