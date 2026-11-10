package cafe.cryptography.curve25519;

class UnpackedScalar {
    static final int MASK_24_BITS = 0xFFFFFF;
    static final int MASK_29_BITS = 0x1FFFFFFF;
    static final UnpackedScalar ZERO;
    final int[] s;

    static {
        UnpackedScalar.ZERO = new UnpackedScalar(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    UnpackedScalar(int[] arg3) {
        super();
        if(arg3.length == 9) {
            this.s = arg3;
            return;
        }

        throw new IllegalArgumentException("Invalid radix-2^29 representation");
    }

    UnpackedScalar add(UnpackedScalar arg7) {
        int v0 = 9;
        int[] v1 = new int[v0];
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            v3 = (v3 >> 29) + (this.s[v2] + arg7.s[v2]);
            v1[v2] = 0x1FFFFFFF & v3;
            ++v2;
        }

        return new UnpackedScalar(v1).subtract(Constants.L);
    }

    static UnpackedScalar fromByteArray(byte[] arg14) {
        int v4;
        if(arg14.length == 0x20) {
            int v0 = 8;
            int[] v1 = new int[v0];
            int v3;
            for(v3 = 0; true; ++v3) {
                v4 = 4;
                if(v3 >= v0) {
                    break;
                }

                int v5;
                for(v5 = 0; v5 < v4; ++v5) {
                    v1[v3] |= (arg14[v3 * 4 + v5] & 0xFF) << v5 * 8;
                }
            }

            return new UnpackedScalar(new int[]{v1[0] & 0x1FFFFFFF, (v1[0] >>> 29 | v1[1] << 3) & 0x1FFFFFFF, (v1[1] >>> 26 | v1[2] << 6) & 0x1FFFFFFF, (v1[2] >>> 23 | v1[3] << 9) & 0x1FFFFFFF, (v1[3] >>> 20 | v1[v4] << 12) & 0x1FFFFFFF, (v1[v4] >>> 17 | v1[5] << 15) & 0x1FFFFFFF, (v1[5] >>> 14 | v1[6] << 18) & 0x1FFFFFFF, (v1[6] >>> 11 | v1[7] << 21) & 0x1FFFFFFF, v1[7] >>> 8 & 0xFFFFFF});
        }

        throw new IllegalArgumentException("Input must by 32 bytes");
    }

    static long m(int arg2, int arg3) {
        return (((long)arg2)) * (((long)arg3));
    }

    static UnpackedScalar montgomeryReduce(long[] arg33) {
        int[] v0 = Constants.L.s;
        int v6 = ((int)(arg33[0] * 307527195 & 0x1FFFFFFF));
        long v2 = (arg33[0] + UnpackedScalar.m(v6, v0[0]) >>> 29) + arg33[1] + UnpackedScalar.m(v6, v0[1]);
        int v11 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v11, v0[0]) >>> 29) + arg33[2] + UnpackedScalar.m(v6, v0[2]) + UnpackedScalar.m(v11, v0[1]);
        int v13 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v13, v0[0]) >>> 29) + arg33[3] + UnpackedScalar.m(v6, v0[3]) + UnpackedScalar.m(v11, v0[2]) + UnpackedScalar.m(v13, v0[1]);
        int v1 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v1, v0[0]) >>> 29) + arg33[4] + UnpackedScalar.m(v6, v0[4]) + UnpackedScalar.m(v11, v0[3]) + UnpackedScalar.m(v13, v0[2]) + UnpackedScalar.m(v1, v0[1]);
        int v4 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v4, v0[0]) >>> 29) + arg33[5] + UnpackedScalar.m(v11, v0[4]) + UnpackedScalar.m(v13, v0[3]) + UnpackedScalar.m(v1, v0[2]) + UnpackedScalar.m(v4, v0[1]);
        int v7 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v7, v0[0]) >>> 29) + arg33[6] + UnpackedScalar.m(v13, v0[4]) + UnpackedScalar.m(v1, v0[3]) + UnpackedScalar.m(v4, v0[2]) + UnpackedScalar.m(v7, v0[1]);
        int v8 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v8, v0[0]) >>> 29) + arg33[7] + UnpackedScalar.m(v1, v0[4]) + UnpackedScalar.m(v4, v0[3]) + UnpackedScalar.m(v7, v0[2]) + UnpackedScalar.m(v8, v0[1]);
        int v14 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v14, v0[0]) >>> 29) + arg33[8] + UnpackedScalar.m(v6, v0[8]) + UnpackedScalar.m(v4, v0[4]) + UnpackedScalar.m(v7, v0[3]) + UnpackedScalar.m(v8, v0[2]) + UnpackedScalar.m(v14, v0[1]);
        int v5 = ((int)(v2 * 307527195 & 0x1FFFFFFF));
        v2 = (v2 + UnpackedScalar.m(v5, v0[0]) >>> 29) + arg33[9] + UnpackedScalar.m(v11, v0[8]) + UnpackedScalar.m(v7, v0[4]) + UnpackedScalar.m(v8, v0[3]) + UnpackedScalar.m(v14, v0[2]) + UnpackedScalar.m(v5, v0[1]);
        v6 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[10] + UnpackedScalar.m(v13, v0[8]) + UnpackedScalar.m(v8, v0[4]) + UnpackedScalar.m(v14, v0[3]) + UnpackedScalar.m(v5, v0[2]);
        int v10 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[11] + UnpackedScalar.m(v1, v0[8]) + UnpackedScalar.m(v14, v0[4]) + UnpackedScalar.m(v5, v0[3]);
        v1 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[12] + UnpackedScalar.m(v4, v0[8]) + UnpackedScalar.m(v5, v0[4]);
        v4 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[13] + UnpackedScalar.m(v7, v0[8]);
        v7 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[14] + UnpackedScalar.m(v8, v0[8]);
        v8 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[15] + UnpackedScalar.m(v14, v0[8]);
        int v9 = ((int)(v2 & 0x1FFFFFFF));
        v2 = (v2 >>> 29) + arg33[16] + UnpackedScalar.m(v5, v0[8]);
        return new UnpackedScalar(new int[]{v6, v10, v1, v4, v7, v8, v9, ((int)(v2 & 0x1FFFFFFF)), ((int)(v2 >>> 29))}).subtract(Constants.L);
    }

    long[] mulInternal(UnpackedScalar arg28) {
        int[] v0 = this.s;
        int[] v1 = arg28.s;
        long[] v2 = new long[17];
        v2[0] = UnpackedScalar.m(v0[0], v1[0]);
        v2[1] = UnpackedScalar.m(v0[0], v1[1]) + UnpackedScalar.m(v0[1], v1[0]);
        v2[2] = UnpackedScalar.m(v0[0], v1[2]) + UnpackedScalar.m(v0[1], v1[1]) + UnpackedScalar.m(v0[2], v1[0]);
        v2[3] = UnpackedScalar.m(v0[0], v1[3]) + UnpackedScalar.m(v0[1], v1[2]) + UnpackedScalar.m(v0[2], v1[1]) + UnpackedScalar.m(v0[3], v1[0]);
        v2[4] = UnpackedScalar.m(v0[0], v1[4]) + UnpackedScalar.m(v0[1], v1[3]) + UnpackedScalar.m(v0[2], v1[2]) + UnpackedScalar.m(v0[3], v1[1]) + UnpackedScalar.m(v0[4], v1[0]);
        v2[5] = UnpackedScalar.m(v0[1], v1[4]) + UnpackedScalar.m(v0[2], v1[3]) + UnpackedScalar.m(v0[3], v1[2]) + UnpackedScalar.m(v0[4], v1[1]);
        v2[6] = UnpackedScalar.m(v0[2], v1[4]) + UnpackedScalar.m(v0[3], v1[3]) + UnpackedScalar.m(v0[4], v1[2]);
        v2[7] = UnpackedScalar.m(v0[3], v1[4]) + UnpackedScalar.m(v0[4], v1[3]);
        v2[8] = UnpackedScalar.m(v0[4], v1[4]) - v2[3];
        v2[10] = v2[5] - UnpackedScalar.m(v0[5], v1[5]);
        v2[11] = v2[6] - (UnpackedScalar.m(v0[5], v1[6]) + UnpackedScalar.m(v0[6], v1[5]));
        v2[12] = v2[7] - (UnpackedScalar.m(v0[5], v1[7]) + UnpackedScalar.m(v0[6], v1[6]) + UnpackedScalar.m(v0[7], v1[5]));
        v2[13] = UnpackedScalar.m(v0[5], v1[8]) + UnpackedScalar.m(v0[6], v1[7]) + UnpackedScalar.m(v0[7], v1[6]) + UnpackedScalar.m(v0[8], v1[5]);
        v2[14] = UnpackedScalar.m(v0[6], v1[8]) + UnpackedScalar.m(v0[7], v1[7]) + UnpackedScalar.m(v0[8], v1[6]);
        v2[15] = UnpackedScalar.m(v0[7], v1[8]) + UnpackedScalar.m(v0[8], v1[7]);
        long v9 = UnpackedScalar.m(v0[8], v1[8]);
        v2[16] = v9;
        long v19 = v2[10];
        v2[5] = v19 - v2[0];
        long v21 = v2[11];
        v2[6] = v21 - v2[1];
        v2[7] = v2[12] - v2[2];
        v2[8] -= v2[13];
        v2[9] = v2[14] + v2[4];
        v2[10] = v2[15] + v19;
        v2[11] = v9 + v21;
        int v3 = v0[0] + v0[5];
        int v9_1 = v0[1] + v0[6];
        int v10 = v0[2] + v0[7];
        int v15 = v0[3] + v0[8];
        int v4 = v1[0] + v1[5];
        int v5 = v1[1] + v1[6];
        int v6 = v1[2] + v1[7];
        int v7 = v1[3] + v1[8];
        v2[5] = UnpackedScalar.m(v3, v4) + v2[5];
        v2[6] = UnpackedScalar.m(v3, v5) + UnpackedScalar.m(v9_1, v4) + v2[6];
        v2[7] = UnpackedScalar.m(v3, v6) + UnpackedScalar.m(v9_1, v5) + UnpackedScalar.m(v10, v4) + v2[7];
        v2[8] = UnpackedScalar.m(v3, v7) + UnpackedScalar.m(v9_1, v6) + UnpackedScalar.m(v10, v5) + UnpackedScalar.m(v15, v4) + v2[8];
        v2[9] = UnpackedScalar.m(v3, v1[4]) + UnpackedScalar.m(v9_1, v7) + UnpackedScalar.m(v10, v6) + UnpackedScalar.m(v15, v5) + UnpackedScalar.m(v0[4], v4) - v2[9];
        v2[10] = UnpackedScalar.m(v9_1, v1[4]) + UnpackedScalar.m(v10, v7) + UnpackedScalar.m(v15, v6) + UnpackedScalar.m(v0[4], v5) - v2[10];
        v2[11] = UnpackedScalar.m(v10, v1[4]) + UnpackedScalar.m(v15, v7) + UnpackedScalar.m(v0[4], v6) - v2[11];
        v2[12] = UnpackedScalar.m(v15, v1[4]) + UnpackedScalar.m(v0[4], v7) - v2[12];
        return v2;
    }

    UnpackedScalar multiply(UnpackedScalar arg1) {
        return UnpackedScalar.montgomeryReduce(UnpackedScalar.montgomeryReduce(this.mulInternal(arg1)).mulInternal(Constants.RR));
    }

    UnpackedScalar subtract(UnpackedScalar arg9) {
        int v5;
        int v0 = 9;
        int[] v1 = new int[v0];
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(true) {
            v5 = 0x1FFFFFFF;
            if(v3 >= v0) {
                break;
            }

            v4 = this.s[v3] - (arg9.s[v3] + (v4 >>> 0x1F));
            v1[v3] = v5 & v4;
            ++v3;
        }

        int v8 = (v4 >>> 0x1F ^ 1) - 1;
        int v9 = 0;
        while(v2 < v0) {
            v9 = (v9 >>> 29) + v1[v2] + (Constants.L.s[v2] & v8);
            v1[v2] = v9 & v5;
            ++v2;
        }

        return new UnpackedScalar(v1);
    }

    byte[] toByteArray() {
        // Method was not decompiled
    }
}

