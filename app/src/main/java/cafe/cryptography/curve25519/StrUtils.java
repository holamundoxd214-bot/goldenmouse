package cafe.cryptography.curve25519;

class StrUtils {
    StrUtils() {
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
            v0.append(Character.forDigit((arg6[v2] & 0xF0) >> 4, 16)).append(Character.forDigit(arg6[v2] & 15, 16));
        }

        return v0.toString();
    }
}

