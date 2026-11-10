package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.-ByteString;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H\u0000\u001A\f\u0010\u0006\u001A\u00020\u0007*\u00020\u0007H\u0000\u001A\f\u0010\u0006\u001A\u00020\b*\u00020\bH\u0000\u001A\f\u0010\u0006\u001A\u00020\u0003*\u00020\u0003H\u0000\u001A\u0015\u0010\t\u001A\u00020\b*\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0080\f\u001A\u0015\u0010\u000B\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001A\u00020\bH\u0080\f\u001A\u0015\u0010\f\u001A\u00020\b*\u00020\r2\u0006\u0010\u000E\u001A\u00020\bH\u0080\f\u001A\u0015\u0010\u000F\u001A\u00020\b*\u00020\r2\u0006\u0010\u000E\u001A\u00020\bH\u0080\f\u001A\u0015\u0010\u0010\u001A\u00020\b*\u00020\r2\u0006\u0010\u000E\u001A\u00020\bH\u0080\f\u001A\u0015\u0010\u0010\u001A\u00020\u0003*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0003H\u0080\f\u001A\u0015\u0010\u0011\u001A\u00020\r*\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0080\f\u001A\u0015\u0010\u0010\u001A\u00020\u0003*\u00020\b2\u0006\u0010\u000E\u001A\u00020\u0003H\u0080\f\u001A\u0019\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\bH\u0080\b\u001A\u0019\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u0003H\u0080\b\u001A0\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\bH\u0000\u001A\f\u0010\u001A\u001A\u00020\u001B*\u00020\rH\u0000\u001A\f\u0010\u001A\u001A\u00020\u001B*\u00020\bH\u0000\u001A\f\u0010\u001A\u001A\u00020\u001B*\u00020\u0003H\u0000¨\u0006\u001C"}, d2={"checkOffsetAndCount", "", "size", "", "offset", "byteCount", "reverseBytes", "", "", "leftRotate", "bitCount", "rightRotate", "shr", "", "other", "shl", "and", "xor", "minOf", "a", "b", "arrayRangeEquals", "", "", "aOffset", "bOffset", "toHexString", "", "okio"}, k=2, mv={2, 1, 0}, xi=0x30) public final class -SegmentedByteString {
    public static final int and(byte arg0, int arg1) {
        return arg0 & arg1;
    }

    public static final long and(byte arg2, long arg3) {
        return (((long)arg2)) & arg3;
    }

    public static final long and(int arg2, long arg3) {
        return (((long)arg2)) & arg3;
    }

    public static final boolean arrayRangeEquals(byte[] arg4, int arg5, byte[] arg6, int arg7, int arg8) {
        Intrinsics.checkNotNullParameter(arg4, "a");
        Intrinsics.checkNotNullParameter(arg6, "b");
        int v1;
        for(v1 = 0; v1 < arg8; ++v1) {
            if(arg4[v1 + arg5] != arg6[v1 + arg7]) {
                return 0;
            }
        }

        return 1;
    }

    public static final void checkOffsetAndCount(long arg4, long arg6, long arg8) {
        if((arg6 | arg8) >= 0 && arg6 <= arg4 && arg4 - arg6 >= arg8) {
            return;
        }

        throw new ArrayIndexOutOfBoundsException("size=" + arg4 + " offset=" + arg6 + " byteCount=" + arg8);
    }

    public static final int leftRotate(int arg1, int arg2) {
        return arg1 >>> 0x20 - arg2 | arg1 << arg2;
    }

    public static final long minOf(int arg2, long arg3) {
        return Math.min(((long)arg2), arg3);
    }

    public static final long minOf(long arg2, int arg4) {
        return Math.min(arg2, ((long)arg4));
    }

    public static final int reverseBytes(int arg2) {
        return (arg2 & 0xFF) << 24 | ((0xFF000000 & arg2) >>> 24 | (0xFF0000 & arg2) >>> 8 | (0xFF00 & arg2) << 8);
    }

    public static final long reverseBytes(long arg8) {
        return (arg8 & 0xFF) << 56 | ((-72057594037927936L & arg8) >>> 56 | (0xFF000000000000L & arg8) >>> 40 | (0xFF0000000000L & arg8) >>> 24 | (0xFF00000000L & arg8) >>> 8 | (0xFF000000L & arg8) << 8 | (0xFF0000 & arg8) << 24 | (0xFF00 & arg8) << 40);
    }

    public static final short reverseBytes(short arg1) {
        return ((short)((arg1 & 0xFF) << 8 | (0xFF00 & arg1) >>> 8));
    }

    public static final long rightRotate(long arg2, int arg4) {
        return arg2 << 0x40 - arg4 | arg2 >>> arg4;
    }

    public static final int shl(byte arg0, int arg1) {
        return arg0 << arg1;
    }

    public static final int shr(byte arg0, int arg1) {
        return arg0 >> arg1;
    }

    public static final String toHexString(byte arg3) {
        return StringsKt.concatToString(new char[]{-ByteString.getHEX_DIGIT_CHARS()[arg3 >> 4 & 15], -ByteString.getHEX_DIGIT_CHARS()[arg3 & 15]});
    }

    public static final String toHexString(int arg10) {
        if(arg10 == 0) {
            return "0";
        }

        char v0 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 28 & 15];
        char v1 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 24 & 15];
        char v2 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 20 & 15];
        char v3 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 16 & 15];
        char v4 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 12 & 15];
        char v5 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 8 & 15];
        char v6 = -ByteString.getHEX_DIGIT_CHARS()[arg10 >> 4 & 15];
        char v10 = -ByteString.getHEX_DIGIT_CHARS()[arg10 & 15];
        int v7 = 8;
        char[] v8 = new char[v7];
        int v9 = 0;
        v8[0] = v0;
        v8[1] = v1;
        v8[2] = v2;
        v8[3] = v3;
        v8[4] = v4;
        v8[5] = v5;
        v8[6] = v6;
        v8[7] = v10;
        while(v9 < v7) {
            if(v8[v9] != 0x30) {
                break;
            }

            ++v9;
        }

        return StringsKt.concatToString(v8, v9, v7);
    }

    public static final String toHexString(long arg25) {
        if(arg25 == 0) {
            return "0";
        }

        char v0 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 60 & 15))];
        char v1 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 56 & 15))];
        char v2 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 52 & 15))];
        char v5 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 0x30 & 15))];
        char v7 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 44 & 15))];
        char v8 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 40 & 15))];
        char v9 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 36 & 15))];
        char v10 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 0x20 & 15))];
        char v11 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 28 & 15))];
        char v12 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 24 & 15))];
        char v13 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 20 & 15))];
        char v3 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 16 & 15))];
        char v20 = v7;
        char v4 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 12 & 15))];
        char v21 = v8;
        char v6 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 8 & 15))];
        v7 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 >> 4 & 15))];
        v8 = -ByteString.getHEX_DIGIT_CHARS()[((int)(arg25 & 15))];
        char[] v14 = new char[16];
        int v15 = 0;
        v14[0] = v0;
        v14[1] = v1;
        v14[2] = v2;
        v14[3] = v5;
        v14[4] = v20;
        v14[5] = v21;
        v14[6] = v9;
        v14[7] = v10;
        v14[8] = v11;
        v14[9] = v12;
        v14[10] = v13;
        v14[11] = v3;
        v14[12] = v4;
        v14[13] = v6;
        v14[14] = v7;
        v14[15] = v8;
        int v9_1 = 16;
        while(v15 < v9_1) {
            if(v14[v15] != 0x30) {
                break;
            }

            ++v15;
        }

        return StringsKt.concatToString(v14, v15, v9_1);
    }

    public static final byte xor(byte arg0, byte arg1) {
        return ((byte)(arg0 ^ arg1));
    }
}

