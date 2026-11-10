package com.flyfish233.crypto.spake2;

final class HexUtils {
    private HexUtils() {
        super();
    }

    static String bytesToHex(byte[] arg6) {
        if(arg6 == null) {
            return null;
        }

        StringBuilder v0 = new StringBuilder(arg6.length * 2);
        int v1 = arg6.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            int v3 = arg6[v2];
            v0.append(Character.forDigit(v3 >>> 4 & 15, 16));
            v0.append(Character.forDigit(v3 & 15, 16));
        }

        return v0.toString();
    }

    static byte[] hexToBytes(String arg6) {
        if(arg6 == null) {
            goto label_34;
        }

        if((arg6.length() & 1) != 0) {
            goto label_30;
        }

        int v0 = arg6.length();
        byte[] v1 = new byte[v0 / 2];
        int v2 = 0;
        while(true) {
            if(v2 >= v0) {
                return v1;
            }

            int v3 = Character.digit(arg6.charAt(v2), 16);
            int v4 = Character.digit(arg6.charAt(v2 + 1), 16);
            int v5 = -1;
            if(v3 != v5 && v4 != v5) {
                v1[v2 / 2] = ((byte)(v3 << 4 | v4));
                v2 += 2;
                continue;
            }

            break;
        }

        throw new IllegalArgumentException("invalid hexadecimal character");
        return v1;
    label_30:
        throw new IllegalArgumentException("hex string must have even length");
    label_34:
        throw new IllegalArgumentException("hex string must not be null");
    }
}

