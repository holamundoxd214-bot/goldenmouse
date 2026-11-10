package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.-SegmentedByteString;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;

@Metadata(d1={"\u0000h\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001D\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\r\u0010\u0006\u001A\u00020\u0007*\u00020\u0002H\u0080\b\u001A\u0015\u0010\b\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010\n\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\r\u0010\u000B\u001A\u00020\f*\u00020\u0002H\u0080\b\u001A\r\u0010\r\u001A\u00020\u000E*\u00020\u0002H\u0080\b\u001A\u0015\u0010\r\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010\u000F\u001A\u00020\u0010*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0012H\u0080\b\u001A\r\u0010\u0013\u001A\u00020\u0014*\u00020\u0002H\u0080\b\u001A\u0015\u0010\u0013\u001A\u00020\u0014*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010\u0015\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0014H\u0080\b\u001A%\u0010\u0000\u001A\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u0010H\u0080\b\u001A\u001D\u0010\u0015\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\u0015\u0010\u0017\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0018H\u0080\b\u001A\r\u0010\u0019\u001A\u00020\u001A*\u00020\u0002H\u0080\b\u001A\u0015\u0010\u0019\u001A\u00020\u001A*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A\u000F\u0010\u001B\u001A\u0004\u0018\u00010\u001A*\u00020\u0002H\u0080\b\u001A\u0015\u0010\u001C\u001A\u00020\u001A*\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u0001H\u0080\b\u001A\r\u0010\u001E\u001A\u00020\u0010*\u00020\u0002H\u0080\b\u001A\r\u0010\u001F\u001A\u00020 *\u00020\u0002H\u0080\b\u001A\r\u0010!\u001A\u00020 *\u00020\u0002H\u0080\b\u001A\r\u0010\"\u001A\u00020\u0010*\u00020\u0002H\u0080\b\u001A\r\u0010#\u001A\u00020\u0010*\u00020\u0002H\u0080\b\u001A\r\u0010$\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010%\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010&\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\r\u0010\'\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\u0015\u0010(\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0080\b\u001A%\u0010)\u001A\u00020\u0001*\u00020\u00022\u0006\u0010*\u001A\u00020\f2\u0006\u0010+\u001A\u00020\u00012\u0006\u0010,\u001A\u00020\u0001H\u0080\b\u001A:\u0010)\u001A\u00020\u0001*\u00020\u00022\u0006\u0010-\u001A\u00020\u000E2\b\b\u0002\u0010.\u001A\u00020\u00102\b\b\u0002\u0010\u0005\u001A\u00020\u00102\u0006\u0010+\u001A\u00020\u00012\b\b\u0002\u0010,\u001A\u00020\u0001H\u0000\u001A4\u0010/\u001A\u00020\u0007*\u00020\u00042\u0006\u0010-\u001A\u00020\u000E2\u0006\u0010.\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00102\u0006\u0010+\u001A\u00020\u00012\u0006\u0010,\u001A\u00020\u0001H\u0002\u001A\u001D\u00100\u001A\u00020\u0001*\u00020\u00022\u0006\u00101\u001A\u00020\u000E2\u0006\u0010+\u001A\u00020\u0001H\u0080\b\u001A-\u00102\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00012\u0006\u0010-\u001A\u00020\u000E2\u0006\u0010.\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u0010H\u0080\b\u001A\r\u00103\u001A\u000204*\u00020\u0002H\u0080\b\u001A\r\u00105\u001A\u00020\t*\u00020\u0002H\u0080\b\u001A\r\u00106\u001A\u000207*\u00020\u0002H\u0080\b\u001A\r\u00108\u001A\u00020\u001A*\u00020\u0002H\u0080\b¨\u00069"}, d2={"commonRead", "", "Lokio/RealBufferedSource;", "sink", "Lokio/Buffer;", "byteCount", "commonExhausted", "", "commonRequire", "", "commonRequest", "commonReadByte", "", "commonReadByteString", "Lokio/ByteString;", "commonSelect", "", "options", "Lokio/Options;", "commonReadByteArray", "", "commonReadFully", "offset", "commonReadAll", "Lokio/Sink;", "commonReadUtf8", "", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonReadUtf8CodePoint", "commonReadShort", "", "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", "commonIndexOf", "b", "fromIndex", "toIndex", "bytes", "bytesOffset", "isMatchPossibleByExpandingBuffer", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonPeek", "Lokio/BufferedSource;", "commonClose", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -RealBufferedSource {
    public static final void commonClose(RealBufferedSource arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.closed) {
            return;
        }

        arg1.closed = true;
        arg1.source.close();
        arg1.bufferField.clear();
    }

    public static final boolean commonExhausted(RealBufferedSource arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(!arg4.closed) {
            if((arg4.bufferField.exhausted()) && arg4.source.read(arg4.bufferField, 0x2000) == -1) {
                return 1;
            }

            return 0;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource arg16, ByteString arg17, int arg18, int arg19, long arg20, long arg22) {
        long v1_1;
        RealBufferedSource v0 = arg16;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        ByteString v3 = arg17;
        Intrinsics.checkNotNullParameter(v3, "bytes");
        int v1 = arg18;
        long v8 = ((long)arg19);
        -SegmentedByteString.checkOffsetAndCount(((long)v3.size()), ((long)v1), v8);
        long v10 = v8;
        if(!v0.closed) {
            long v4 = arg20;
            while(true) {
                v1_1 = -Buffer.commonIndexOf(v0.bufferField, v3, v4, arg22, v1, arg19);
                long v12 = -1;
                if(v1_1 != v12) {
                    return v1_1;
                }

                long v14 = v0.bufferField.size() - v10 + 1;
                if(v14 >= arg22) {
                    return v12;
                }

                long v6 = v4;
                v4 = v6;
                if(!-RealBufferedSource.isMatchPossibleByExpandingBuffer(v0.bufferField, arg17, arg18, arg19, v6, arg22)) {
                    return v12;
                }

                if(v0.source.read(v0.bufferField, 0x2000) == v12) {
                    return v12;
                }

                v4 = Math.max(v4, v14);
                v3 = arg17;
                v1 = arg18;
            }

            return v1_1;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource arg9, byte arg10, long arg11, long arg13) {
        long v7;
        Intrinsics.checkNotNullParameter(arg9, "<this>");
        if(!arg9.closed) {
            if(0 <= arg11 && arg11 <= arg13) {
                long v3 = arg11;
                while(true) {
                    v7 = -1;
                    if(Long.compare(v3, arg13) < 0) {
                        byte v2 = arg10;
                        long v5 = arg13;
                        long v10 = arg9.bufferField.indexOf(v2, v3, v5);
                        if(v10 != v7) {
                            return v10;
                        }
                        else {
                            v10 = arg9.bufferField.size();
                            if(v10 < v5) {
                                if(arg9.source.read(arg9.bufferField, 0x2000) == v7) {
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

    public static long commonIndexOf$default(RealBufferedSource arg8, ByteString arg9, int arg10, int arg11, long arg12, long arg14, int arg16, Object arg17) {
        if((arg16 & 4) != 0) {
            arg11 = arg9.size();
        }

        int v3 = arg11;
        long v6 = (arg16 & 16) != 0 ? 0x7FFFFFFFFFFFFFFFL : arg14;
        return -RealBufferedSource.commonIndexOf(arg8, arg9, 0, v3, arg12, v6);
    }

    public static final long commonIndexOfElement(RealBufferedSource arg8, ByteString arg9, long arg10) {
        long v0;
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "targetBytes");
        if(!arg8.closed) {
            while(true) {
                v0 = arg8.bufferField.indexOfElement(arg9, arg10);
                long v2 = -1;
                if(v0 != v2) {
                    return v0;
                }

                v0 = arg8.bufferField.size();
                if(arg8.source.read(arg8.bufferField, 0x2000) == v2) {
                    return v2;
                }

                arg10 = Math.max(arg10, v0);
            }

            return v0;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSource commonPeek(RealBufferedSource arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Okio.buffer(new PeekSource(((BufferedSource)arg1)));
    }

    public static final boolean commonRangeEquals(RealBufferedSource arg10, long arg11, ByteString arg13, int arg14, int arg15) {
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        Intrinsics.checkNotNullParameter(arg13, "bytes");
        if(!arg10.closed) {
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
                else if(-RealBufferedSource.commonIndexOf(arg10, arg13, arg14, arg15, arg11, arg11 + 1) != -1) {
                    return 1;
                }
            }

            return 0;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final int commonRead(RealBufferedSource arg7, byte[] arg8, int arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "sink");
        long v5 = ((long)arg10);
        -SegmentedByteString.checkOffsetAndCount(((long)arg8.length), ((long)arg9), v5);
        if(arg7.bufferField.size() == 0) {
            if(arg10 == 0) {
                return 0;
            }
            else if(arg7.source.read(arg7.bufferField, 0x2000) == -1) {
                return -1;
            }
        }

        return arg7.bufferField.read(arg8, arg9, ((int)Math.min(v5, arg7.bufferField.size())));
    }

    public static final long commonRead(RealBufferedSource arg5, Buffer arg6, long arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "sink");
        long v0 = 0;
        int v2 = Long.compare(arg7, v0);
        if(v2 >= 0) {
            if(!arg5.closed) {
                if(arg5.bufferField.size() == v0) {
                    if(v2 == 0) {
                        return v0;
                    }
                    else {
                        long v2_1 = -1;
                        if(arg5.source.read(arg5.bufferField, 0x2000) == v2_1) {
                            return v2_1;
                        }
                    }
                }

                return arg5.bufferField.read(arg6, Math.min(arg7, arg5.bufferField.size()));
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg7.toString());
    }

    public static final long commonReadAll(RealBufferedSource arg8, Sink arg9) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "sink");
        long v0 = 0;
        long v2 = v0;
        while(arg8.source.read(arg8.bufferField, 0x2000) != -1) {
            long v4 = arg8.bufferField.completeSegmentByteCount();
            if(v4 <= v0) {
                continue;
            }

            v2 += v4;
            arg9.write(arg8.bufferField, v4);
        }

        if(arg8.bufferField.size() > v0) {
            v2 += arg8.bufferField.size();
            arg9.write(arg8.bufferField, arg8.bufferField.size());
        }

        return v2;
    }

    public static final byte commonReadByte(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(1);
        return arg2.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.bufferField.writeAll(arg2.source);
        return arg2.bufferField.readByteArray();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.require(arg2);
        return arg1.bufferField.readByteArray(arg2);
    }

    public static final ByteString commonReadByteString(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.bufferField.writeAll(arg2.source);
        return arg2.bufferField.readByteString();
    }

    public static final ByteString commonReadByteString(RealBufferedSource arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.require(arg2);
        return arg1.bufferField.readByteString(arg2);
    }

    public static final long commonReadDecimalLong(RealBufferedSource arg10) {
        int v8;
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        long v0 = 1;
        arg10.require(v0);
        long v2 = 0;
        long v4 = v2;
        while(true) {
            long v6 = v4 + v0;
            if(arg10.request(v6)) {
                v8 = arg10.bufferField.getByte(v4);
                if(v8 < 0x30 || v8 > 57) {
                    int v4_1 = Long.compare(v4, v2);
                    if(v4_1 == 0) {
                        if(v8 != 45) {
                        }
                        else {
                            goto label_20;
                        }
                    }

                    break;
                }

            label_20:
                v4 = v6;
                continue;
            }

            goto label_37;
        }

        if(v4_1 != 0) {
        }
        else {
            StringBuilder v0_1 = new StringBuilder("Expected a digit or \'-\' but was 0x");
            String v1 = Integer.toString(v8, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
            throw new NumberFormatException(v0_1.append(v1).toString());
        }

    label_37:
        return arg10.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(RealBufferedSource arg1, Buffer arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "sink");
        try {
            arg1.require(arg3);
        }
        catch(EOFException v3) {
            arg2.writeAll(arg1.bufferField);
            throw v3;
        }

        arg1.bufferField.readFully(arg2, arg3);
    }

    public static final void commonReadFully(RealBufferedSource arg6, byte[] arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "sink");
        try {
            arg6.require(((long)arg7.length));
        }
        catch(EOFException v0) {
            int v1;
            for(v1 = 0; true; v1 += v2) {
                if(arg6.bufferField.size() <= 0) {
                    goto label_28;
                }

                int v2 = arg6.bufferField.read(arg7, v1, ((int)arg6.bufferField.size()));
                if(v2 == -1) {
                    break;
                }
            }

            throw new AssertionError();
        label_28:
            throw v0;
        }

        arg6.bufferField.readFully(arg7);
    }

    public static final long commonReadHexadecimalUnsignedLong(RealBufferedSource arg5) {
        int v2;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        arg5.require(1);
        int v0 = 0;
        while(true) {
            int v1 = v0 + 1;
            if(arg5.request(((long)v1))) {
                v2 = arg5.bufferField.getByte(((long)v0));
                if((v2 < 0x30 || v2 > 57) && (v2 < 97 || v2 > 102)) {
                    if(v2 >= 65) {
                        if(v2 > 70) {
                        }
                        else {
                            goto label_25;
                        }
                    }

                    break;
                }

            label_25:
                v0 = v1;
                continue;
            }

            goto label_42;
        }

        if(v0 != 0) {
        }
        else {
            StringBuilder v0_1 = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
            String v1_1 = Integer.toString(v2, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(v1_1, "toString(...)");
            throw new NumberFormatException(v0_1.append(v1_1).toString());
        }

    label_42:
        return arg5.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(4);
        return arg2.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(4);
        return arg2.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(8);
        return arg2.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(8);
        return arg2.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(2);
        return arg2.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.require(2);
        return arg2.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        arg2.bufferField.writeAll(arg2.source);
        return arg2.bufferField.readUtf8();
    }

    public static final String commonReadUtf8(RealBufferedSource arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.require(arg2);
        return arg1.bufferField.readUtf8(arg2);
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        arg3.require(1);
        int v0 = arg3.bufferField.getByte(0);
        if((v0 & 0xE0) == 0xC0) {
            arg3.require(2);
        }
        else if((v0 & 0xF0) == 0xE0) {
            arg3.require(3);
        }
        else if((v0 & 0xF8) == 0xF0) {
            arg3.require(4);
        }

        return arg3.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        long v0 = arg4.indexOf(10);
        if(v0 == -1) {
            if(arg4.bufferField.size() != 0) {
                return arg4.readUtf8(arg4.bufferField.size());
            }

            return null;
        }

        return -Buffer.readUtf8Line(arg4.bufferField, v0);
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource arg13, long arg14) {
        Intrinsics.checkNotNullParameter(arg13, "<this>");
        if(arg14 >= 0) {
            long v0 = 0x7FFFFFFFFFFFFFFFL;
            long v3 = 1;
            long v11 = Long.compare(arg14, v0) == 0 ? v0 : arg14 + v3;
            RealBufferedSource v7 = arg13;
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

    public static final boolean commonRequest(RealBufferedSource arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg5 >= 0) {
            if(!arg4.closed) {
                do {
                    if(arg4.bufferField.size() >= arg5) {
                        return 1;
                    }
                }
                while(arg4.source.read(arg4.bufferField, 0x2000) != -1);

                return 0;
            }

            throw new IllegalStateException("closed".toString());
        }

        throw new IllegalArgumentException("byteCount < 0: " + arg5.toString());
    }

    public static final void commonRequire(RealBufferedSource arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.request(arg2)) {
            return;
        }

        throw new EOFException();
    }

    public static final int commonSelect(RealBufferedSource arg5, Options arg6) {
        int v2;
        int v0;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "options");
        if(arg5.closed) {
            goto label_28;
        }

        do {
            v0 = -Buffer.selectPrefix(arg5.bufferField, arg6, true);
            v2 = -1;
            if(v0 != -2) {
                goto label_12;
            }
        }
        while(arg5.source.read(arg5.bufferField, 0x2000) != -1);

        return v2;
    label_12:
        if(v0 != v2) {
            arg5.bufferField.skip(((long)arg6.getByteStrings$okio()[v0].size()));
            return v0;
        }

        return v2;
    label_28:
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonSkip(RealBufferedSource arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(!arg4.closed) {
            while(true) {
                long v0 = 0;
                if(arg5 <= v0) {
                    return;
                }

                if(arg4.bufferField.size() == v0) {
                    if(arg4.source.read(arg4.bufferField, 0x2000) != -1) {
                    }
                    else {
                        throw new EOFException();
                    }
                }

                v0 = Math.min(arg5, arg4.bufferField.size());
                arg4.bufferField.skip(v0);
                arg5 -= v0;
            }

            return;
        }

        throw new IllegalStateException("closed".toString());
    }

    public static final Timeout commonTimeout(RealBufferedSource arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.source.timeout();
    }

    public static final String commonToString(RealBufferedSource arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return "buffer(" + arg2.source + ')';
    }

    private static final boolean isMatchPossibleByExpandingBuffer(Buffer arg8, ByteString arg9, int arg10, int arg11, long arg12, long arg14) {
        if(Long.compare(arg8.size(), arg14) < 0) {
            return 1;
        }

        int v0 = ((int)Math.max(1, arg8.size() - arg14 + 1));
        arg11 = (((int)Math.min(((long)arg11), arg8.size() - arg12 + 1))) - 1;
        if(v0 <= arg11) {
            int v7 = arg11;
            while(true) {
                Buffer v2 = arg8;
                ByteString v5 = arg9;
                int v6 = arg10;
                if(v2.rangeEquals(arg8.size() - (((long)v7)), v5, v6, v7)) {
                    return 1;
                }
                else if(v7 != v0) {
                    --v7;
                    arg8 = v2;
                    arg9 = v5;
                    arg10 = v6;
                    continue;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }
}

