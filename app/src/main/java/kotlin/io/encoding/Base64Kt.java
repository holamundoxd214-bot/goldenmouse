package kotlin.io.encoding;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\u001A\u0012\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0081\u0080\u0004\"\u000F\u0010\u0000\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0004\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0005\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"base64EncodeMap", "", "base64DecodeMap", "", "base64UrlEncodeMap", "base64UrlDecodeMap", "isInMimeAlphabet", "", "symbol", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class Base64Kt {
    private static final int[] base64DecodeMap;
    private static final byte[] base64EncodeMap;
    private static final int[] base64UrlDecodeMap;
    private static final byte[] base64UrlEncodeMap;

    static {
        byte[] v0 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 0x2F};
        Base64Kt.base64EncodeMap = v0;
        int[] v2 = new int[0x100];
        ArraysKt.fill$default(v2, -1, 0, 0, 6, null);
        v2[61] = -2;
        int v1 = v0.length;
        int v3 = 0;
        int v4 = 0;
        int v5;
        for(v5 = 0; v4 < v1; ++v5) {
            v2[v0[v4]] = v5;
            ++v4;
        }

        Base64Kt.base64DecodeMap = v2;
        v0 = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 0x5F};
        Base64Kt.base64UrlEncodeMap = v0;
        int[] v4_1 = new int[0x100];
        ArraysKt.fill$default(v4_1, -1, 0, 0, 6, null);
        v4_1[61] = -2;
        v1 = v0.length;
        int v2_1;
        for(v2_1 = 0; v3 < v1; ++v2_1) {
            v4_1[v0[v3]] = v2_1;
            ++v3;
        }

        Base64Kt.base64UrlDecodeMap = v4_1;
    }

    public static final int[] access$getBase64DecodeMap$p() {
        return Base64Kt.base64DecodeMap;
    }

    public static final byte[] access$getBase64EncodeMap$p() {
        return Base64Kt.base64EncodeMap;
    }

    public static final int[] access$getBase64UrlDecodeMap$p() {
        return Base64Kt.base64UrlDecodeMap;
    }

    public static final byte[] access$getBase64UrlEncodeMap$p() {
        return Base64Kt.base64UrlEncodeMap;
    }

    public static final boolean isInMimeAlphabet(int arg2) {
        if(arg2 >= 0) {
            int[] v0 = Base64Kt.base64DecodeMap;
            if(arg2 < v0.length && v0[arg2] != -1) {
                return 1;
            }
        }

        return 0;
    }
}

