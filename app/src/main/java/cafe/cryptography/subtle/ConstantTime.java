package cafe.cryptography.subtle;

public final class ConstantTime {
    public ConstantTime() {
        super();
    }

    public static int bit(byte[] arg1, int arg2) {
        return arg1[arg2 >> 3] >> (arg2 & 7) & 1;
    }

    public static int equal(int arg2, int arg3) {
        arg2 ^= arg3;
        arg3 = 0;
        int v0 = 0;
        while(arg3 < 8) {
            v0 |= arg2 >> arg3;
            ++arg3;
        }

        return (v0 ^ 1) & 1;
    }

    public static int equal(byte[] arg5, byte[] arg6) {
        if(arg5.length != arg6.length) {
            return 0;
        }

        int v0 = 0;
        int v1 = 0;
        while(v0 < arg5.length) {
            v1 |= arg5[v0] ^ arg6[v0];
            ++v0;
        }

        return ConstantTime.equal(v1, 0);
    }

    public static int isNegative(int arg0) {
        return arg0 >> 8 & 1;
    }
}

