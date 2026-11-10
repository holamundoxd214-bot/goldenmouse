package cafe.cryptography.curve25519;

import cafe.cryptography.subtle.ConstantTime;
import java.util.Arrays;

class FieldElement {
    class SqrtRatioM1Result {
        FieldElement result;
        int wasSquare;

        SqrtRatioM1Result(int arg1, FieldElement arg2) {
            super();
            this.wasSquare = arg1;
            this.result = arg2;
        }
    }

    public static final FieldElement MINUS_ONE;
    public static final FieldElement ONE;
    public static final FieldElement ZERO;
    private static final byte[] ZERO_BYTES;
    private final int[] t;

    static {
        FieldElement v0 = new FieldElement(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        FieldElement.ZERO = v0;
        FieldElement v2 = new FieldElement(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        FieldElement.ONE = v2;
        FieldElement.MINUS_ONE = v0.subtract(v2);
        FieldElement.ZERO_BYTES = new byte[0x20];
    }

    public FieldElement(int[] arg3) {
        super();
        if(arg3.length == 10) {
            this.t = arg3;
            return;
        }

        throw new IllegalArgumentException("Invalid radix-2^25.5 representation");
    }

    public FieldElement add(FieldElement arg6) {
        int[] v6 = arg6.t;
        int v0 = 10;
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.t[v2] + v6[v2];
        }

        return new FieldElement(v1);
    }

    FieldElement ctAbs() {
        return this.ctSelect(this.negate(), this.isNegative());
    }

    public int ctEquals(FieldElement arg1) {
        return ConstantTime.equal(this.toByteArray(), arg1.toByteArray());
    }

    public FieldElement ctSelect(FieldElement arg7, int arg8) {
        arg8 = -arg8;
        int v0 = 10;
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            int[] v3 = this.t;
            int v4 = v3[v2];
            v1[v2] = v4;
            v1[v2] = (v3[v2] ^ arg7.t[v2]) & arg8 ^ v4;
        }

        return new FieldElement(v1);
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof FieldElement)) {
            return 0;
        }

        if(this.ctEquals(((FieldElement)arg3)) == 1) {
            return 1;
        }

        return 0;
    }

    public static FieldElement fromByteArray(byte[] arg35) {
        long v1 = FieldElement.load_4(arg35, 0);
        long v4 = ((long)(FieldElement.load_3(arg35, 4) << 6));
        long v7 = ((long)(FieldElement.load_3(arg35, 7) << 5));
        long v9 = ((long)(FieldElement.load_3(arg35, 10) << 3));
        long v11 = ((long)(FieldElement.load_3(arg35, 13) << 2));
        long v13 = FieldElement.load_4(arg35, 16);
        long v16 = v4;
        long v3 = ((long)(FieldElement.load_3(arg35, 20) << 7));
        long v5 = ((long)(FieldElement.load_3(arg35, 23) << 5));
        long v18 = v1;
        long v21 = ((long)(FieldElement.load_3(arg35, 26) << 4));
        long v0 = ((long)((FieldElement.load_3(arg35, 29) & 0x7FFFFF) << 2));
        long v25 = v0 + 0x1000000 >> 25;
        v18 += 19 * v25;
        v0 -= v25 << 25;
        v25 = v16 + 0x1000000 >> 25;
        v7 += v25;
        long v15 = v16 - (v25 << 25);
        v25 = v9 + 0x1000000 >> 25;
        v11 += v25;
        v9 -= v25 << 25;
        v25 = v13 + 0x1000000 >> 25;
        v3 += v25;
        v13 -= v25 << 25;
        long v23 = v5 + 0x1000000 >> 25;
        v21 += v23;
        v25 = v18 + 0x2000000 >> 26;
        long v27 = v0;
        v0 = v15 + v25;
        v15 = v25 << 26;
        v25 = v3;
        long v2 = v18 - v15;
        v15 = v7 + 0x2000000 >> 26;
        v9 += v15;
        v7 -= v15 << 26;
        v15 = v11 + 0x2000000 >> 26;
        v13 += v15;
        v11 -= v15 << 26;
        v15 = v25 + 0x2000000 >> 26;
        long v17 = v5 - (v23 << 25) + v15;
        v4 = v25 - (v15 << 26);
        v15 = v21 + 0x2000000 >> 26;
        return new FieldElement(new int[]{((int)v2), ((int)v0), ((int)v7), ((int)v9), ((int)v11), ((int)v13), ((int)v4), ((int)v17), ((int)(v21 - (v15 << 26))), ((int)(v27 + v15))});
    }

    public int hashCode() {
        return Arrays.hashCode(this.toByteArray());
    }

    public FieldElement invert() {
        int v5;
        FieldElement v0 = this.square();
        this = this.multiply(v0.square().square());
        v0 = v0.multiply(this);
        this = this.multiply(v0.square());
        FieldElement v1 = this.square();
        int v2 = 1;
        int v3;
        for(v3 = 1; true; ++v3) {
            int v4 = 5;
            if(v3 >= v4) {
                break;
            }

            v1 = v1.square();
        }

        this = v1.multiply(this);
        v1 = this.square();
        for(v3 = 1; true; ++v3) {
            v5 = 10;
            if(v3 >= v5) {
                break;
            }

            v1 = v1.square();
        }

        v1 = v1.multiply(this);
        FieldElement v3_1 = v1.square();
        int v6;
        for(v6 = 1; v6 < 20; ++v6) {
            v3_1 = v3_1.square();
        }

        v1 = v3_1.multiply(v1).square();
        for(v3 = 1; v3 < v5; ++v3) {
            v1 = v1.square();
        }

        this = v1.multiply(this);
        v1 = this.square();
        for(v3 = 1; true; ++v3) {
            v5 = 50;
            if(v3 >= v5) {
                break;
            }

            v1 = v1.square();
        }

        v1 = v1.multiply(this);
        v3_1 = v1.square();
        for(v6 = 1; v6 < 100; ++v6) {
            v3_1 = v3_1.square();
        }

        v1 = v3_1.multiply(v1).square();
        for(v3 = 1; v3 < v5; ++v3) {
            v1 = v1.square();
        }

        this = v1.multiply(this).square();
        while(v2 < v4) {
            this = this.square();
            ++v2;
        }

        return this.multiply(v0);
    }

    int isNegative() {
        return this.toByteArray()[0] & 1;
    }

    int isZero() {
        return ConstantTime.equal(this.toByteArray(), FieldElement.ZERO_BYTES);
    }

    static int load_3(byte[] arg2, int arg3) {
        return (arg2[arg3 + 2] & 0xFF) << 16 | ((arg2[arg3 + 1] & 0xFF) << 8 | arg2[arg3] & 0xFF);
    }

    static long load_4(byte[] arg3, int arg4) {
        return (((long)(arg3[arg4 + 3] << 24 | ((arg3[arg4 + 1] & 0xFF) << 8 | arg3[arg4] & 0xFF | (arg3[arg4 + 2] & 0xFF) << 16)))) & 0xFFFFFFFFL;
    }

    public FieldElement multiply(FieldElement arg209) {
        int[] v0 = arg209.t;
        int v2 = v0[1];
        int v5 = v0[2];
        int v8 = v0[3];
        int v11 = v0[4];
        int v14 = v0[5];
        int v1 = v0[6];
        int v7 = v0[7];
        int v13 = v0[8];
        int[] v23 = v0;
        int v0_1 = v13 * 19;
        int v25 = v2 * 19;
        int v3 = v23[9];
        int v26 = v5 * 19;
        int v6 = v3 * 19;
        int[] v208 = this.t;
        int v9 = v208[1];
        int v28 = v14 * 19;
        int v15 = v208[3];
        int v19 = v1 * 19;
        int v29 = v7 * 19;
        int v22 = v208[5];
        int v30 = v22 * 2;
        int v18 = v208[7];
        int v24 = v208[9];
        int v10 = v208[0];
        int v34 = v3;
        v3 = v23[0];
        int v4 = v13;
        long v36 = (((long)v3)) * (((long)v10));
        long v38 = (((long)v2)) * (((long)v10));
        long v40 = (((long)v5)) * (((long)v10));
        long v42 = (((long)v8)) * (((long)v10));
        long v44 = (((long)v11)) * (((long)v10));
        long v46 = (((long)v14)) * (((long)v10));
        long v48 = (((long)v1)) * (((long)v10));
        long v50 = (((long)v7)) * (((long)v10));
        long v52 = (((long)v4)) * (((long)v10));
        long v54 = (((long)v34)) * (((long)v10));
        long v56 = (((long)v3)) * (((long)v9));
        long v58 = ((long)(v9 * 2));
        long v60 = (((long)v2)) * v58;
        long v62 = (((long)v5)) * (((long)v9));
        long v64 = (((long)v8)) * v58;
        long v66 = (((long)v11)) * (((long)v9));
        long v68 = (((long)v14)) * v58;
        long v70 = (((long)v1)) * (((long)v9));
        long v12 = (((long)v7)) * v58;
        long v72 = (((long)v4)) * (((long)v9));
        long v9_1 = ((long)v6);
        v58 *= v9_1;
        long v74 = v9_1;
        long v76 = (((long)v3)) * (((long)v208[2]));
        long v78 = (((long)v2)) * (((long)v208[2]));
        long v80 = (((long)v5)) * (((long)v208[2]));
        long v82 = (((long)v8)) * (((long)v208[2]));
        long v84 = (((long)v11)) * (((long)v208[2]));
        long v86 = (((long)v14)) * (((long)v208[2]));
        long v88 = (((long)v1)) * (((long)v208[2]));
        v9_1 = (((long)v208[2])) * (((long)v7));
        long v6_1 = ((long)v0_1);
        long v90 = (((long)v208[2])) * v6_1;
        long v92 = v6_1;
        long v94 = (((long)v208[2])) * v74;
        long v34_1 = (((long)v3)) * (((long)v15));
        long v96 = ((long)(v15 * 2));
        long v98 = (((long)v2)) * v96;
        long v100 = (((long)v5)) * (((long)v15));
        long v102 = (((long)v8)) * v96;
        long v104 = (((long)v11)) * (((long)v15));
        long v106 = (((long)v14)) * v96;
        v6_1 = (((long)v15)) * (((long)v1));
        long v0_2 = ((long)v29);
        long v108 = v96 * v0_2;
        long v110 = v0_2;
        long v112 = (((long)v15)) * v92;
        long v114 = (((long)v3)) * (((long)v208[4]));
        long v116 = (((long)v2)) * (((long)v208[4]));
        long v118 = (((long)v5)) * (((long)v208[4]));
        long v120 = (((long)v8)) * (((long)v208[4]));
        long v122 = (((long)v11)) * (((long)v208[4]));
        long v124 = (((long)v208[4])) * (((long)v14));
        v0_2 = ((long)v19);
        long v14_1 = (((long)v208[4])) * v0_2;
        long v19_1 = v0_2;
        long v126 = (((long)v208[4])) * v110;
        long v128 = (((long)v208[4])) * v92;
        v4 = v22;
        long v22_1 = (((long)v208[4])) * v74;
        long v130 = (((long)v3)) * (((long)v4));
        long v29_1 = ((long)v30);
        long v132 = (((long)v2)) * v29_1;
        long v134 = (((long)v5)) * (((long)v4));
        long v136 = (((long)v8)) * v29_1;
        long v138 = (((long)v11)) * (((long)v4));
        v0_2 = ((long)v28);
        long v140 = v29_1 * v0_2;
        long v142 = v0_2;
        long v144 = v29_1 * v110;
        long v146 = (((long)v4)) * v19_1;
        long v28_1 = v29_1 * v74;
        long v16 = (((long)v4)) * v92;
        long v148 = (((long)v3)) * (((long)v208[6]));
        long v150 = (((long)v2)) * (((long)v208[6]));
        long v152 = (((long)v5)) * (((long)v208[6]));
        long v154 = (((long)v8)) * (((long)v208[6]));
        v0_2 = ((long)(v11 * 19));
        long v156 = (((long)v208[6])) * v0_2;
        long v158 = v0_2;
        long v160 = (((long)v208[6])) * v142;
        long v162 = (((long)v208[6])) * v19_1;
        long v164 = (((long)v208[6])) * v110;
        long v166 = (((long)v208[6])) * v92;
        long v168 = (((long)v208[6])) * v74;
        long v30_1 = (((long)v3)) * (((long)v18));
        long v170 = ((long)(v18 * 2));
        long v172 = (((long)v2)) * v170;
        long v174 = (((long)v5)) * (((long)v18));
        v0_2 = ((long)(v8 * 19));
        long v176 = v170 * v0_2;
        long v178 = v0_2;
        long v180 = v170 * v142;
        long v182 = (((long)v18)) * v158;
        long v4_1 = (((long)v18)) * v92;
        v8 = v208[8];
        long v208_1 = (((long)v18)) * v19_1;
        long v186 = (((long)v3)) * (((long)v8));
        long v188 = (((long)v2)) * (((long)v8));
        v0_2 = ((long)v26);
        long v26_1 = (((long)v8)) * v0_2;
        long v192 = (((long)v8)) * v178;
        long v194 = (((long)v8)) * v158;
        long v196 = (((long)v8)) * v142;
        long v198 = (((long)v8)) * v19_1;
        v2 = v24;
        long v32 = (((long)v3)) * (((long)v2));
        v3 = v25;
        long v24_1 = ((long)(v24 * 2));
        v178 *= v24_1;
        long v190 = (((long)v2)) * v0_2;
        v142 *= v24_1;
        v0_2 = (((long)v2)) * v19_1;
        long v18_1 = v24_1 * v110;
        long v20 = v24_1 * v74;
        v24_1 = v36 + v58 + v90 + v108 + v14_1 + v140 + v156 + v176 + v26_1 + (((long)v3)) * v24_1;
        v36 = v42 + v62 + v78 + v34_1 + v22_1 + v16 + v164 + v208_1 + v196 + (((long)v2)) * v158;
        v16 = v44 + v64 + v80 + v98 + v114 + v28_1 + v166 + v170 * v110 + v198 + v142;
        v22_1 = v46 + v66 + v82 + v100 + v116 + v130 + v168 + v4_1 + (((long)v8)) * v110 + v0_2;
        v0_2 = v48 + v68 + v84 + v102 + v118 + v132 + v148 + v170 * v74 + (((long)v8)) * v92 + v18_1;
        v4_1 = v50 + v70 + v86 + v104 + v120 + v134 + v150 + v30_1 + (((long)v8)) * v74 + (((long)v2)) * v92;
        long v2_1 = v54 + v72 + v9_1 + v6_1 + v124 + v138 + v154 + v174 + v188 + v32;
        long v8_1 = v24_1 + 0x2000000 >> 26;
        v14_1 = v38 + v56 + v94 + v112 + v126 + v146 + v160 + v182 + v192 + v190 + v8_1;
        v24_1 -= v8_1 << 26;
        v8_1 = v16 + 0x2000000 >> 26;
        v22_1 += v8_1;
        v18_1 = v14_1 + 0x1000000 >> 25;
        v26_1 = v40 + v60 + v76 + v96 * v74 + v128 + v144 + v162 + v180 + v194 + v178 + v18_1;
        v14_1 -= v18_1 << 25;
        v18_1 = v22_1 + 0x1000000 >> 25;
        v0_2 += v18_1;
        v22_1 -= v18_1 << 25;
        v18_1 = v26_1 + 0x2000000 >> 26;
        v36 += v18_1;
        v6_1 = v26_1 - (v18_1 << 26);
        v18_1 = v0_2 + 0x2000000 >> 26;
        v4_1 += v18_1;
        v0_2 -= v18_1 << 26;
        v18_1 = v36 + 0x1000000 >> 25;
        v16 = v16 - (v8_1 << 26) + v18_1;
        v8_1 = v36 - (v18_1 << 25);
        v18_1 = v4_1 + 0x1000000 >> 25;
        v12 = v52 + v12 + v88 + v106 + v122 + v136 + v152 + v172 + v186 + v20 + v18_1;
        v4_1 -= v18_1 << 25;
        v18_1 = v16 + 0x2000000 >> 26;
        long v10_1 = v22_1 + v18_1;
        v22_1 = v2_1;
        v2_1 = v16 - (v18_1 << 26);
        v16 = v12 + 0x2000000 >> 26;
        v18_1 = v22_1 + v16;
        v12 -= v16 << 26;
        v16 = v18_1 + 0x1000000 >> 25;
        v24_1 += 19 * v16;
        v20 = v14_1;
        v14_1 = v18_1 - (v16 << 25);
        v16 = v24_1 + 0x2000000 >> 26;
        return new FieldElement(new int[]{((int)(v24_1 - (v16 << 26))), ((int)(v20 + v16)), ((int)v6_1), ((int)v8_1), ((int)v2_1), ((int)v10_1), ((int)v0_2), ((int)v4_1), ((int)v12), ((int)v14_1)});
    }

    public FieldElement negate() {
        int v0 = 10;
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = -this.t[v2];
        }

        return new FieldElement(v1);
    }

    FieldElement powP58() {
        int v4;
        FieldElement v0 = this.square();
        FieldElement v1 = this.multiply(v0.square().square());
        v0 = v1.multiply(v0.multiply(v1).square());
        v1 = v0.square();
        int v2 = 1;
        int v3;
        for(v3 = 1; v3 < 5; ++v3) {
            v1 = v1.square();
        }

        v0 = v1.multiply(v0);
        v1 = v0.square();
        for(v3 = 1; true; ++v3) {
            v4 = 10;
            if(v3 >= v4) {
                break;
            }

            v1 = v1.square();
        }

        v1 = v1.multiply(v0);
        FieldElement v3_1 = v1.square();
        int v5;
        for(v5 = 1; v5 < 20; ++v5) {
            v3_1 = v3_1.square();
        }

        v1 = v3_1.multiply(v1).square();
        for(v3 = 1; v3 < v4; ++v3) {
            v1 = v1.square();
        }

        v0 = v1.multiply(v0);
        v1 = v0.square();
        for(v3 = 1; true; ++v3) {
            v4 = 50;
            if(v3 >= v4) {
                break;
            }

            v1 = v1.square();
        }

        v1 = v1.multiply(v0);
        v3_1 = v1.square();
        for(v5 = 1; v5 < 100; ++v5) {
            v3_1 = v3_1.square();
        }

        v1 = v3_1.multiply(v1).square();
        while(v2 < v4) {
            v1 = v1.square();
            ++v2;
        }

        return this.multiply(v1.multiply(v0).square().square());
    }

    String printInternalRepresentation() {
        String v0 = "FieldElement([";
        int v1;
        for(v1 = 0; v1 < this.t.length; ++v1) {
            if(v1 > 0) {
                v0 = v0 + ", ";
            }

            v0 = v0 + this.t[v1];
        }

        return v0 + "])";
    }

    static SqrtRatioM1Result sqrtRatioM1(FieldElement arg4, FieldElement arg5) {
        FieldElement v0 = arg5.square().multiply(arg5);
        v0 = arg4.multiply(v0).multiply(arg4.multiply(v0.square().multiply(arg5)).powP58());
        arg5 = arg5.multiply(v0.square());
        FieldElement v1 = arg4.negate();
        int v4 = arg5.ctEquals(arg4);
        int v2 = arg5.ctEquals(v1);
        return new SqrtRatioM1Result(v4 | v2, v0.ctSelect(v0.multiply(Constants.SQRT_M1), arg5.ctEquals(v1.multiply(Constants.SQRT_M1)) | v2).ctAbs());
    }

    public FieldElement square() {
        int[] v0 = this.t;
        int v1 = v0[0];
        int v2 = v0[1];
        int v3 = v0[2];
        int v4 = v0[3];
        int v5 = v0[4];
        int v6 = v0[5];
        int v7 = v0[6];
        int v8 = v0[7];
        int v9 = v0[8];
        int v11 = v2 * 2;
        int v13 = v4 * 2;
        int v116 = v5 * 2;
        int v16 = v7 * 2;
        int v17 = v3 * 2;
        int v18 = v6 * 38;
        int v19 = v7 * 19;
        int v20 = v8 * 38;
        int v21 = v9 * 19;
        int v12 = v0[9] * 38;
        int v23 = v8 * 2;
        int v22 = v6 * 2;
        long v14 = ((long)v1);
        long v24 = v14 * v14;
        v14 = ((long)(v1 * 2));
        long v1_1 = ((long)v2);
        long v26 = v14 * v1_1;
        long v28 = v1_1;
        v1_1 = ((long)v3);
        long v30 = v14 * v1_1;
        long v3_1 = ((long)v4);
        long v32 = v14 * v3_1;
        long v34 = v1_1;
        v1_1 = ((long)v5);
        long v36 = v14 * v1_1;
        long v5_1 = ((long)v6);
        long v38 = v14 * v5_1;
        long v40 = v1_1;
        v1_1 = ((long)v7);
        long v42 = v14 * v1_1;
        long v7_1 = ((long)v8);
        long v44 = v14 * v7_1;
        long v9_1 = ((long)v9);
        long v46 = v14 * v9_1;
        long v48 = v1_1;
        long v0_1 = ((long)v0[9]);
        v14 *= v0_1;
        long v50 = v0_1;
        v0_1 = ((long)v11);
        v28 *= v0_1;
        long v52 = v0_1 * v34;
        long v54 = v0_1;
        v0_1 = ((long)v13);
        long v56 = v54 * v0_1;
        long v60 = v0_1;
        v0_1 = ((long)v22);
        long v62 = v54 * v0_1;
        v2 = v23;
        long v22_1 = v0_1;
        v0_1 = ((long)v2);
        long v66 = v54 * v0_1;
        long v68 = v54 * v9_1;
        long v11_1 = ((long)v12);
        long v72 = v0_1;
        v0_1 = ((long)v17);
        long v74 = v0_1 * v3_1;
        long v76 = v0_1 * v40;
        long v78 = v0_1 * v5_1;
        long v80 = v0_1 * v48;
        long v82 = v0_1 * v7_1;
        long v84 = v0_1;
        v0_1 = ((long)v21);
        v84 *= v0_1;
        long v2_1 = v60 * v3_1;
        v4 = v20;
        long v20_1 = v0_1;
        v0_1 = ((long)v4);
        long v92 = v60 * v0_1;
        long v98 = v0_1;
        v0_1 = ((long)v116);
        long v100 = v0_1 * v5_1;
        long v102 = v0_1;
        v0_1 = ((long)v19);
        v24 = v24 + v54 * v11_1 + v84 + v92 + v102 * v0_1 + v5_1 * (((long)v18));
        v36 = v36 + v56 + v34 * v34 + v22_1 * v11_1 + (((long)v16)) * v20_1 + v7_1 * v98;
        v42 = v42 + v62 + v76 + v2_1 + v72 * v11_1 + v9_1 * v20_1;
        v44 = v44 + v54 * v48 + v78 + v60 * v40 + v9_1 * v11_1;
        v46 = v46 + v66 + v80 + v60 * v22_1 + v40 * v40 + v11_1 * v50;
        v2_1 = v24 + 0x2000000 >> 26;
        v26 = v26 + v34 * v11_1 + v60 * v20_1 + v40 * v98 + v22_1 * v0_1 + v2_1;
        v24 -= v2_1 << 26;
        v2_1 = v36 + 0x2000000 >> 26;
        v38 = v38 + v54 * v40 + v74 + v48 * v11_1 + v72 * v20_1 + v2_1;
        v5_1 = v26 + 0x1000000 >> 25;
        v30 = v30 + v28 + v60 * v11_1 + v102 * v20_1 + v22_1 * v98 + v0_1 * v48 + v5_1;
        v26 -= v5_1 << 25;
        v5_1 = v38 + 0x1000000 >> 25;
        v42 += v5_1;
        v38 -= v5_1 << 25;
        v5_1 = v30 + 0x2000000 >> 26;
        v32 = v32 + v52 + v40 * v11_1 + v22_1 * v20_1 + v48 * v98 + v5_1;
        long v8_1 = v42 + 0x2000000 >> 26;
        v44 += v8_1;
        long v10 = v32 + 0x1000000 >> 25;
        v36 = v36 - (v2_1 << 26) + v10;
        long v12_1 = v44 + 0x1000000 >> 25;
        v46 += v12_1;
        long v16_1 = v36 + 0x2000000 >> 26;
        v0_1 = v38 + v16_1;
        v2_1 = v36 - (v16_1 << 26);
        v16_1 = v46 + 0x2000000 >> 26;
        v14 = v14 + v68 + v82 + v60 * v48 + v100 + v16_1;
        v22_1 = v42 - (v8_1 << 26);
        v7_1 = v46 - (v16_1 << 26);
        v16_1 = v14 + 0x1000000 >> 25;
        v24 += 19 * v16_1;
        v14 -= v16_1 << 25;
        v16_1 = v24 + 0x2000000 >> 26;
        return new FieldElement(new int[]{((int)(v24 - (v16_1 << 26))), ((int)(v26 + v16_1)), ((int)(v30 - (v5_1 << 26))), ((int)(v32 - (v10 << 25))), ((int)v2_1), ((int)v0_1), ((int)v22_1), ((int)(v44 - (v12_1 << 25))), ((int)v7_1), ((int)v14)});
    }

    public FieldElement squareAndDouble() {
        int[] v0 = this.t;
        int v1 = v0[0];
        int v2 = v0[1];
        int v3 = v0[2];
        int v4 = v0[3];
        int v5 = v0[4];
        int v6 = v0[5];
        int v7 = v0[6];
        int v8 = v0[7];
        int v9 = v0[8];
        int v11 = v2 * 2;
        int v13 = v4 * 2;
        int v116 = v5 * 2;
        int v16 = v7 * 2;
        int v17 = v3 * 2;
        int v18 = v6 * 38;
        int v19 = v7 * 19;
        int v20 = v8 * 38;
        int v21 = v9 * 19;
        int v12 = v0[9] * 38;
        int v23 = v8 * 2;
        int v22 = v6 * 2;
        long v14 = ((long)v1);
        long v24 = v14 * v14;
        v14 = ((long)(v1 * 2));
        long v1_1 = ((long)v2);
        long v26 = v14 * v1_1;
        long v28 = v1_1;
        v1_1 = ((long)v3);
        long v30 = v14 * v1_1;
        long v3_1 = ((long)v4);
        long v32 = v14 * v3_1;
        long v34 = v1_1;
        v1_1 = ((long)v5);
        long v36 = v14 * v1_1;
        long v5_1 = ((long)v6);
        long v38 = v14 * v5_1;
        long v40 = v1_1;
        v1_1 = ((long)v7);
        long v42 = v14 * v1_1;
        long v7_1 = ((long)v8);
        long v44 = v14 * v7_1;
        long v9_1 = ((long)v9);
        long v46 = v14 * v9_1;
        long v48 = v1_1;
        long v0_1 = ((long)v0[9]);
        v14 *= v0_1;
        long v50 = v0_1;
        v0_1 = ((long)v11);
        v28 *= v0_1;
        long v52 = v0_1 * v34;
        long v54 = v0_1;
        v0_1 = ((long)v13);
        long v56 = v54 * v0_1;
        long v60 = v0_1;
        v0_1 = ((long)v22);
        long v62 = v54 * v0_1;
        v2 = v23;
        long v22_1 = v0_1;
        v0_1 = ((long)v2);
        long v66 = v54 * v0_1;
        long v11_1 = ((long)v12);
        long v72 = v0_1;
        v0_1 = ((long)v17);
        long v74 = v0_1 * v3_1;
        long v76 = v0_1 * v40;
        long v78 = v0_1 * v5_1;
        long v80 = v0_1 * v48;
        long v82 = v0_1 * v7_1;
        long v84 = v0_1;
        v0_1 = ((long)v21);
        v84 *= v0_1;
        long v2_1 = v60 * v3_1;
        v4 = v20;
        long v20_1 = v0_1;
        v0_1 = ((long)v4);
        long v92 = v60 * v0_1;
        long v98 = v0_1;
        v0_1 = ((long)v116);
        long v100 = v0_1 * v5_1;
        long v102 = v0_1;
        v0_1 = ((long)v19);
        v24 = v24 + v54 * v11_1 + v84 + v92 + v102 * v0_1 + v5_1 * (((long)v18));
        v26 = v26 + v34 * v11_1 + v60 * v20_1 + v40 * v98 + v22_1 * v0_1;
        v30 = v30 + v28 + v60 * v11_1 + v102 * v20_1 + v22_1 * v98 + v0_1 * v48;
        v32 = v32 + v52 + v40 * v11_1 + v22_1 * v20_1 + v48 * v98;
        v36 = v36 + v56 + v34 * v34 + v22_1 * v11_1 + (((long)v16)) * v20_1 + v7_1 * v98;
        v38 = v38 + v54 * v40 + v74 + v48 * v11_1 + v72 * v20_1;
        v42 = v42 + v62 + v76 + v2_1 + v72 * v11_1 + v9_1 * v20_1;
        v44 = v44 + v54 * v48 + v78 + v60 * v40 + v9_1 * v11_1;
        v46 = v46 + v66 + v80 + v60 * v22_1 + v40 * v40 + v11_1 * v50;
        v14 = v14 + v54 * v9_1 + v82 + v60 * v48 + v100;
        v24 += v24;
        v36 += v36;
        v2_1 = v24 + 0x2000000 >> 26;
        v26 = v26 + v26 + v2_1;
        v24 -= v2_1 << 26;
        v2_1 = v36 + 0x2000000 >> 26;
        v38 = v38 + v38 + v2_1;
        v5_1 = v26 + 0x1000000 >> 25;
        v30 = v30 + v30 + v5_1;
        v26 -= v5_1 << 25;
        v5_1 = v38 + 0x1000000 >> 25;
        v42 = v42 + v42 + v5_1;
        v38 -= v5_1 << 25;
        v5_1 = v30 + 0x2000000 >> 26;
        v32 = v32 + v32 + v5_1;
        long v8_1 = v42 + 0x2000000 >> 26;
        v44 = v44 + v44 + v8_1;
        long v10 = v32 + 0x1000000 >> 25;
        v36 = v36 - (v2_1 << 26) + v10;
        long v12_1 = v44 + 0x1000000 >> 25;
        v46 = v46 + v46 + v12_1;
        long v16_1 = v36 + 0x2000000 >> 26;
        v0_1 = v38 + v16_1;
        v2_1 = v36 - (v16_1 << 26);
        v16_1 = v46 + 0x2000000 >> 26;
        v14 = v14 + v14 + v16_1;
        v22_1 = v42 - (v8_1 << 26);
        v7_1 = v46 - (v16_1 << 26);
        v16_1 = v14 + 0x1000000 >> 25;
        v24 += 19 * v16_1;
        v14 -= v16_1 << 25;
        v16_1 = v24 + 0x2000000 >> 26;
        return new FieldElement(new int[]{((int)(v24 - (v16_1 << 26))), ((int)(v26 + v16_1)), ((int)(v30 - (v5_1 << 26))), ((int)(v32 - (v10 << 25))), ((int)v2_1), ((int)v0_1), ((int)v22_1), ((int)(v44 - (v12_1 << 25))), ((int)v7_1), ((int)v14)});
    }

    public FieldElement subtract(FieldElement arg6) {
        int[] v6 = arg6.t;
        int v0 = 10;
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.t[v2] - v6[v2];
        }

        return new FieldElement(v1);
    }

    byte[] toByteArray() {
        int[] v0 = this.t;
        int v2 = v0[0];
        int v4 = v0[1];
        int v6 = v0[2];
        int v8 = v0[3];
        int v10 = v0[4];
        int v12 = v0[5];
        int v14 = v0[6];
        int v16 = v0[7];
        int v18 = v0[8];
        v2 += (v0[9] + (v18 + (v16 + (v14 + (v12 + (v10 + (v8 + (v6 + (v4 + (v2 + (v0[9] * 19 + 0x1000000 >> 25) >> 26) >> 25) >> 26) >> 25) >> 26) >> 25) >> 26) >> 25) >> 26) >> 25) * 19;
        int v20 = v2 >> 26;
        v4 += v20;
        v2 -= v20 << 26;
        v20 = v4 >> 25;
        v6 += v20;
        v4 -= v20 << 25;
        v20 = v6 >> 26;
        v8 += v20;
        v6 -= v20 << 26;
        v20 = v8 >> 25;
        v10 += v20;
        v8 -= v20 << 25;
        v20 = v10 >> 26;
        v12 += v20;
        v10 -= v20 << 26;
        v20 = v12 >> 25;
        v14 += v20;
        v12 -= v20 << 25;
        v20 = v14 >> 26;
        v16 += v20;
        v14 -= v20 << 26;
        v20 = v16 >> 25;
        v18 += v20;
        v16 -= v20 << 25;
        v20 = v18 >> 26;
        int v0_1 = v0[9] + v20;
        v18 -= v20 << 26;
        int v33 = v0_1 - (v0_1 >> 25 << 25);
        return new byte[]{((byte)v2), ((byte)(v2 >> 8)), ((byte)(v2 >> 16)), ((byte)(v2 >> 24 | v4 << 2)), ((byte)(v4 >> 6)), ((byte)(v4 >> 14)), ((byte)(v4 >> 22 | v6 << 3)), ((byte)(v6 >> 5)), ((byte)(v6 >> 13)), ((byte)(v6 >> 21 | v8 << 5)), ((byte)(v8 >> 3)), ((byte)(v8 >> 11)), ((byte)(v8 >> 19 | v10 << 6)), ((byte)(v10 >> 2)), ((byte)(v10 >> 10)), ((byte)(v10 >> 18)), ((byte)v12), ((byte)(v12 >> 8)), ((byte)(v12 >> 16)), ((byte)(v12 >> 24 | v14 << 1)), ((byte)(v14 >> 7)), ((byte)(v14 >> 15)), ((byte)(v14 >> 23 | v16 << 3)), ((byte)(v16 >> 5)), ((byte)(v16 >> 13)), ((byte)(v16 >> 21 | v18 << 4)), ((byte)(v18 >> 4)), ((byte)(v18 >> 12)), ((byte)(v18 >> 20 | v33 << 6)), ((byte)(v33 >> 2)), ((byte)(v33 >> 10)), ((byte)(v33 >> 18))};
    }
}

