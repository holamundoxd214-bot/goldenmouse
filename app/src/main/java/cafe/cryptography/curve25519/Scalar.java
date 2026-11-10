package cafe.cryptography.curve25519;

import cafe.cryptography.subtle.ConstantTime;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

public class Scalar implements Serializable {
    public static final Scalar ONE = null;
    public static final Scalar ZERO = null;
    private transient byte[] s;
    private static final long serialVersionUID = 1;

    static {
        Scalar.ZERO = new Scalar(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Scalar.ONE = new Scalar(new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    Scalar(byte[] arg3) {
        super();
        if(arg3.length == 0x20 && (arg3[0x1F] >> 7 & 1) == 0) {
            this.s = Arrays.copyOf(arg3, arg3.length);
            return;
        }

        throw new IllegalArgumentException("Invalid scalar representation");
    }

    public Scalar add(Scalar arg2) {
        return new Scalar(UnpackedScalar.fromByteArray(this.s).add(UnpackedScalar.fromByteArray(arg2.s)).toByteArray());
    }

    public int ctEquals(Scalar arg1) {
        return ConstantTime.equal(this.s, arg1.s);
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof Scalar)) {
            return 0;
        }

        if(this.ctEquals(((Scalar)arg3)) == 1) {
            return 1;
        }

        return 0;
    }

    public static Scalar fromBits(byte[] arg2) {
        arg2[0x1F] = ((byte)(arg2[0x1F] & 0x7F));
        return new Scalar(arg2);
    }

    public static Scalar fromBytesModOrder(byte[] arg2) {
        if(arg2.length == 0x20) {
            return Scalar.reduce(arg2);
        }

        throw new IllegalArgumentException("Input must by 32 bytes");
    }

    public static Scalar fromBytesModOrderWide(byte[] arg76) {
        byte[] v0 = arg76;
        if(v0.length == 0x40) {
            long v3 = ((long)(FieldElement.load_3(v0, 0) & 0x1FFFFF));
            long v5 = FieldElement.load_4(v0, 2) >> 5 & 0x1FFFFF;
            long v10 = ((long)(FieldElement.load_3(v0, 5) >> 2 & 0x1FFFFF));
            long v13 = FieldElement.load_4(v0, 7) >> 7 & 0x1FFFFF;
            long v16 = FieldElement.load_4(v0, 10) >> 4 & 0x1FFFFF;
            long v23 = v3;
            long v2 = ((long)(FieldElement.load_3(v0, 13) >> 1 & 0x1FFFFF));
            long v25 = FieldElement.load_4(v0, 15) >> 6 & 0x1FFFFF;
            long v31 = v5;
            long v4 = ((long)(FieldElement.load_3(v0, 18) >> 3 & 0x1FFFFF));
            long v6 = ((long)(FieldElement.load_3(v0, 21) & 0x1FFFFF));
            long v35 = FieldElement.load_4(v0, 23) >> 5 & 0x1FFFFF;
            long v8 = ((long)(FieldElement.load_3(v0, 26) >> 2 & 0x1FFFFF));
            long v39 = FieldElement.load_4(v0, 28) >> 7 & 0x1FFFFF;
            long v41 = FieldElement.load_4(v0, 0x1F) >> 4 & 0x1FFFFF;
            long v44 = v13;
            long v12 = ((long)(FieldElement.load_3(v0, 34) >> 1 & 0x1FFFFF));
            long v46 = FieldElement.load_4(v0, 36) >> 6 & 0x1FFFFF;
            long v48 = v2;
            long v50 = ((long)(FieldElement.load_3(v0, 39) >> 3 & 0x1FFFFF));
            long v1 = ((long)(FieldElement.load_3(v0, 42) & 0x1FFFFF));
            long v52 = FieldElement.load_4(v0, 44) >> 5 & 0x1FFFFF;
            long v54 = v1;
            v1 = ((long)(FieldElement.load_3(v0, 0x2F) >> 2 & 0x1FFFFF));
            long v56 = FieldElement.load_4(v0, 49) >> 7 & 0x1FFFFF;
            long v58 = FieldElement.load_4(v0, 52) >> 4 & 0x1FFFFF;
            long v60 = v1;
            v1 = ((long)(FieldElement.load_3(v0, 55) >> 1 & 0x1FFFFF));
            long v37 = FieldElement.load_4(v0, 57) >> 6 & 0x1FFFFF;
            long v62 = FieldElement.load_4(v0, 60) >> 3;
            v54 -= v62 * 0xA6F7D;
            v12 = v12 + v62 * 0x9FB67 - v37 * 0xF39AD + v1 * 0x215D1;
            v46 = v46 - v62 * 0xF39AD + v37 * 0x215D1 - v1 * 0xA6F7D;
            v35 = v35 + v1 * 0xA2C13 + v58 * 470296 + v56 * 0x9FB67;
            v39 = v39 + v62 * 0xA2C13 + v37 * 470296 + v1 * 0x9FB67 - v58 * 0xF39AD + v56 * 0x215D1;
            v41 = v41 + v62 * 470296 + v37 * 0x9FB67 - v1 * 0xF39AD + v58 * 0x215D1 - v56 * 0xA6F7D;
            v25 += v60 * 0xA2C13;
            v6 = v6 + v58 * 0xA2C13 + v56 * 470296 + v60 * 0x9FB67;
            v8 = v8 + v37 * 0xA2C13 + v1 * 470296 + v58 * 0x9FB67 - v56 * 0xF39AD + v60 * 0x215D1;
            v2 = v25 + 0x100000 >> 21;
            v4 = v4 + v56 * 0xA2C13 + v60 * 470296 + v2;
            v25 -= v2 << 21;
            v2 = v6 + 0x100000 >> 21;
            v35 = v35 - v60 * 0xF39AD + v2;
            v6 -= v2 << 21;
            v2 = v8 + 0x100000 >> 21;
            v39 = v39 - v60 * 0xA6F7D + v2;
            v8 -= v2 << 21;
            v2 = v41 + 0x100000 >> 21;
            v12 = v12 - v58 * 0xA6F7D + v2;
            v41 -= v2 << 21;
            v2 = v46 + 0x100000 >> 21;
            v50 = v50 + v62 * 0x215D1 - v37 * 0xA6F7D + v2;
            v46 -= v2 << 21;
            v2 = v54 + 0x100000 >> 21;
            v52 += v2;
            v54 -= v2 << 21;
            v2 = v4 + 0x100000 >> 21;
            v6 += v2;
            v4 -= v2 << 21;
            v2 = v35 + 0x100000 >> 21;
            v8 += v2;
            v35 -= v2 << 21;
            v2 = v39 + 0x100000 >> 21;
            v41 += v2;
            v39 -= v2 << 21;
            v2 = v12 + 0x100000 >> 21;
            v46 += v2;
            v12 -= v2 << 21;
            v2 = v50 + 0x100000 >> 21;
            v54 += v2;
            v50 -= v2 << 21;
            v8 -= v52 * 0xA6F7D;
            v6 = v6 - v52 * 0xF39AD + v54 * 0x215D1 - v50 * 0xA6F7D;
            v31 += v12 * 0xA2C13;
            v10 = v10 + v46 * 0xA2C13 + v12 * 470296;
            v37 = v44 + v50 * 0xA2C13 + v46 * 470296 + v12 * 0x9FB67;
            v16 = v16 + v54 * 0xA2C13 + v50 * 470296 + v46 * 0x9FB67 - v12 * 0xF39AD;
            v2 = v48 + v52 * 0xA2C13 + v54 * 470296 + v50 * 0x9FB67 - v46 * 0xF39AD + v12 * 0x215D1;
            v25 = v25 + v52 * 470296 + v54 * 0x9FB67 - v50 * 0xF39AD + v46 * 0x215D1 - v12 * 0xA6F7D;
            v12 = v23 + v41 * 0xA2C13;
            v10 += v41 * 0x9FB67;
            v16 += v41 * 0x215D1;
            v23 = v12 + 0x100000 >> 21;
            v31 = v31 + v41 * 470296 + v23;
            v12 -= v23 << 21;
            v23 = v10 + 0x100000 >> 21;
            v37 = v37 - v41 * 0xF39AD + v23;
            v10 -= v23 << 21;
            v23 = v16 + 0x100000 >> 21;
            v2 = v2 - v41 * 0xA6F7D + v23;
            v16 -= v23 << 21;
            v23 = v25 + 0x100000 >> 21;
            v4 = v4 + v52 * 0x9FB67 - v54 * 0xF39AD + v50 * 0x215D1 - v46 * 0xA6F7D + v23;
            v25 -= v23 << 21;
            v23 = v6 + 0x100000 >> 21;
            v35 = v35 + v52 * 0x215D1 - v54 * 0xA6F7D + v23;
            v6 -= v23 << 21;
            v23 = v8 + 0x100000 >> 21;
            v39 += v23;
            v8 -= v23 << 21;
            v23 = v31 + 0x100000 >> 21;
            v10 += v23;
            v31 -= v23 << 21;
            v23 = v37 + 0x100000 >> 21;
            v16 += v23;
            v37 -= v23 << 21;
            v23 = v2 + 0x100000 >> 21;
            v25 += v23;
            v2 -= v23 << 21;
            v23 = v4 + 0x100000 >> 21;
            v6 += v23;
            v4 -= v23 << 21;
            v23 = v35 + 0x100000 >> 21;
            long v0_1 = v39 + 0x100000 >> 21;
            v39 -= v0_1 << 21;
            v12 += v0_1 * 0xA2C13;
            v31 += v0_1 * 470296;
            v10 += v0_1 * 0x9FB67;
            v37 -= v0_1 * 0xF39AD;
            v16 += v0_1 * 0x215D1;
            v2 -= v0_1 * 0xA6F7D;
            v0_1 = v12 >> 21;
            v31 += v0_1;
            v12 -= v0_1 << 21;
            v0_1 = v31 >> 21;
            v10 += v0_1;
            v31 -= v0_1 << 21;
            v0_1 = v10 >> 21;
            v37 += v0_1;
            v10 -= v0_1 << 21;
            v0_1 = v37 >> 21;
            v16 += v0_1;
            v37 -= v0_1 << 21;
            v0_1 = v16 >> 21;
            v2 += v0_1;
            v16 -= v0_1 << 21;
            v0_1 = v2 >> 21;
            v25 += v0_1;
            v2 -= v0_1 << 21;
            v0_1 = v25 >> 21;
            v4 += v0_1;
            v25 -= v0_1 << 21;
            v0_1 = v4 >> 21;
            v6 += v0_1;
            v4 -= v0_1 << 21;
            v0_1 = v6 >> 21;
            v35 = v35 - (v23 << 21) + v0_1;
            v6 -= v0_1 << 21;
            v0_1 = v35 >> 21;
            v8 = v8 + v23 + v0_1;
            v35 -= v0_1 << 21;
            v0_1 = v8 >> 21;
            v39 += v0_1;
            v8 -= v0_1 << 21;
            v0_1 = v39 >> 21;
            v39 -= v0_1 << 21;
            v12 += 0xA2C13 * v0_1;
            v31 += 470296 * v0_1;
            v10 += 0x9FB67 * v0_1;
            v37 -= 0xF39AD * v0_1;
            v16 += 0x215D1 * v0_1;
            v2 -= v0_1 * 0xA6F7D;
            v0_1 = v12 >> 21;
            v31 += v0_1;
            v12 -= v0_1 << 21;
            v0_1 = v31 >> 21;
            v10 += v0_1;
            v31 -= v0_1 << 21;
            v0_1 = v10 >> 21;
            v37 += v0_1;
            v10 -= v0_1 << 21;
            v0_1 = v37 >> 21;
            v16 += v0_1;
            v37 -= v0_1 << 21;
            v0_1 = v16 >> 21;
            v2 += v0_1;
            v16 -= v0_1 << 21;
            v0_1 = v2 >> 21;
            v25 += v0_1;
            v2 -= v0_1 << 21;
            v0_1 = v25 >> 21;
            v4 += v0_1;
            v25 -= v0_1 << 21;
            v0_1 = v4 >> 21;
            v6 += v0_1;
            v4 -= v0_1 << 21;
            v0_1 = v6 >> 21;
            v35 += v0_1;
            v6 -= v0_1 << 21;
            v0_1 = v35 >> 21;
            v8 += v0_1;
            v35 -= v0_1 << 21;
            v0_1 = v8 >> 21;
            v39 += v0_1;
            v8 -= v0_1 << 21;
            return new Scalar(new byte[]{((byte)(((int)v12))), ((byte)(((int)(v12 >> 8)))), ((byte)(((int)(v12 >> 16 | v31 << 5)))), ((byte)(((int)(v31 >> 3)))), ((byte)(((int)(v31 >> 11)))), ((byte)(((int)(v31 >> 19 | v10 << 2)))), ((byte)(((int)(v10 >> 6)))), ((byte)(((int)(v10 >> 14 | v37 << 7)))), ((byte)(((int)(v37 >> 1)))), ((byte)(((int)(v37 >> 9)))), ((byte)(((int)(v37 >> 17 | v16 << 4)))), ((byte)(((int)(v16 >> 4)))), ((byte)(((int)(v16 >> 12)))), ((byte)(((int)(v16 >> 20 | v2 << 1)))), ((byte)(((int)(v2 >> 7)))), ((byte)(((int)(v2 >> 15 | v25 << 6)))), ((byte)(((int)(v25 >> 2)))), ((byte)(((int)(v25 >> 10)))), ((byte)(((int)(v25 >> 18 | v4 << 3)))), ((byte)(((int)(v4 >> 5)))), ((byte)(((int)(v4 >> 13)))), ((byte)(((int)v6))), ((byte)(((int)(v6 >> 8)))), ((byte)(((int)(v6 >> 16 | v35 << 5)))), ((byte)(((int)(v35 >> 3)))), ((byte)(((int)(v35 >> 11)))), ((byte)(((int)(v35 >> 19 | v8 << 2)))), ((byte)(((int)(v8 >> 6)))), ((byte)(((int)(v8 >> 14 | v39 << 7)))), ((byte)(((int)(v39 >> 1)))), ((byte)(((int)(v39 >> 9)))), ((byte)(((int)(v39 >> 17))))});
        }

        throw new IllegalArgumentException("Input must by 64 bytes");
    }

    public static Scalar fromCanonicalBytes(byte[] arg1) {
        Scalar v0 = new Scalar(arg1);
        if(v0.isCanonical()) {
            return v0;
        }

        throw new IllegalArgumentException("Non-canonical scalar representation");
    }

    public int hashCode() {
        return Arrays.hashCode(this.s);
    }

    boolean isCanonical() {
        if(this.ctEquals(Scalar.reduce(this.s)) == 1) {
            return 1;
        }

        return 0;
    }

    public Scalar multiply(Scalar arg2) {
        return this.multiplyAndAdd(arg2, Scalar.ZERO);
    }

    public Scalar multiplyAndAdd(Scalar arg89, Scalar arg90) {
        long v6 = ((long)(FieldElement.load_3(this.s, 0) & 0x1FFFFF));
        long v9 = FieldElement.load_4(this.s, 2) >> 5 & 0x1FFFFF;
        long v13 = ((long)(FieldElement.load_3(this.s, 5) >> 2 & 0x1FFFFF));
        long v17 = FieldElement.load_4(this.s, 7) >> 7 & 0x1FFFFF;
        long v21 = FieldElement.load_4(this.s, 10) >> 4 & 0x1FFFFF;
        long v25 = v13;
        long v12 = ((long)(FieldElement.load_3(this.s, 13) >> 1 & 0x1FFFFF));
        long v28 = FieldElement.load_4(this.s, 15) >> 6 & 0x1FFFFF;
        long v14 = ((long)(FieldElement.load_3(this.s, 18) >> 3 & 0x1FFFFF));
        long v36 = v6;
        long v5 = ((long)(FieldElement.load_3(this.s, 21) & 0x1FFFFF));
        long v38 = FieldElement.load_4(this.s, 23) >> 5 & 0x1FFFFF;
        long v40 = v9;
        long v8 = ((long)(FieldElement.load_3(this.s, 26) >> 2 & 0x1FFFFF));
        long v42 = FieldElement.load_4(this.s, 28) >> 7;
        long v44 = v12;
        long v11 = ((long)(FieldElement.load_3(arg89.s, 0) & 0x1FFFFF));
        long v46 = FieldElement.load_4(arg89.s, 2) >> 5 & 0x1FFFFF;
        long v48 = v11;
        long v10 = ((long)(FieldElement.load_3(arg89.s, 5) >> 2 & 0x1FFFFF));
        v12 = FieldElement.load_4(arg89.s, 7) >> 7 & 0x1FFFFF;
        long v50 = FieldElement.load_4(arg89.s, 10) >> 4 & 0x1FFFFF;
        long v3 = ((long)(FieldElement.load_3(arg89.s, 13) >> 1 & 0x1FFFFF));
        long v54 = FieldElement.load_4(arg89.s, 15) >> 6 & 0x1FFFFF;
        long v56 = v3;
        v3 = ((long)(FieldElement.load_3(arg89.s, 18) >> 3 & 0x1FFFFF));
        long v58 = v8;
        long v7 = ((long)(FieldElement.load_3(arg89.s, 21) & 0x1FFFFF));
        long v60 = FieldElement.load_4(arg89.s, 23) >> 5 & 0x1FFFFF;
        long v62 = v10;
        v9 = ((long)(FieldElement.load_3(arg89.s, 26) >> 2 & 0x1FFFFF));
        long v64 = FieldElement.load_4(arg89.s, 28) >> 7;
        long v66 = (((long)(FieldElement.load_3(arg90.s, 0) & 0x1FFFFF))) + v36 * v48;
        long v68 = (FieldElement.load_4(arg90.s, 2) >> 5 & 0x1FFFFF) + v36 * v46 + v40 * v48;
        long v70 = (((long)(FieldElement.load_3(arg90.s, 5) >> 2 & 0x1FFFFF))) + v36 * v62 + v40 * v46 + v25 * v48;
        long v72 = (FieldElement.load_4(arg90.s, 7) >> 7 & 0x1FFFFF) + v36 * v12 + v40 * v62 + v25 * v46 + v17 * v48;
        long v74 = (FieldElement.load_4(arg90.s, 10) >> 4 & 0x1FFFFF) + v36 * v50 + v40 * v12 + v25 * v62 + v17 * v46 + v21 * v48;
        long v76 = (((long)(FieldElement.load_3(arg90.s, 13) >> 1 & 0x1FFFFF))) + v36 * v56 + v40 * v50 + v25 * v12 + v17 * v62 + v21 * v46 + v44 * v48;
        long v78 = (FieldElement.load_4(arg90.s, 15) >> 6 & 0x1FFFFF) + v36 * v54 + v40 * v56 + v25 * v50 + v17 * v12 + v21 * v62 + v44 * v46 + v28 * v48;
        long v80 = (((long)(FieldElement.load_3(arg90.s, 18) >> 3 & 0x1FFFFF))) + v36 * v3 + v40 * v54 + v25 * v56 + v17 * v50 + v21 * v12 + v44 * v62 + v28 * v46 + v14 * v48;
        long v82 = (((long)(FieldElement.load_3(arg90.s, 21) & 0x1FFFFF))) + v36 * v7 + v40 * v3 + v25 * v54 + v17 * v56 + v21 * v50 + v44 * v12 + v28 * v62 + v14 * v46 + v5 * v48;
        long v19 = (FieldElement.load_4(arg90.s, 23) >> 5 & 0x1FFFFF) + v36 * v60 + v40 * v7 + v25 * v3 + v17 * v54 + v21 * v56 + v44 * v50 + v28 * v12 + v14 * v62 + v5 * v46 + v38 * v48;
        long v0 = (((long)(FieldElement.load_3(arg90.s, 26) >> 2 & 0x1FFFFF))) + v36 * v9 + v40 * v60 + v25 * v7 + v17 * v3 + v21 * v54 + v44 * v56 + v28 * v50 + v14 * v12 + v5 * v62 + v38 * v46 + v58 * v48;
        long v84 = (FieldElement.load_4(arg90.s, 28) >> 7) + v36 * v64 + v40 * v9 + v25 * v60 + v17 * v7 + v21 * v3 + v44 * v54 + v28 * v56 + v14 * v50 + v5 * v12 + v38 * v62 + v58 * v46 + v42 * v48;
        v36 = v40 * v64 + v25 * v9 + v17 * v60 + v21 * v7 + v44 * v3 + v28 * v54 + v14 * v56 + v5 * v50 + v38 * v12 + v58 * v62 + v46 * v42;
        v25 = v25 * v64 + v17 * v9 + v21 * v60 + v44 * v7 + v28 * v3 + v14 * v54 + v5 * v56 + v38 * v50 + v58 * v12 + v42 * v62;
        v17 = v17 * v64 + v21 * v9 + v44 * v60 + v28 * v7 + v14 * v3 + v5 * v54 + v38 * v56 + v58 * v50 + v12 * v42;
        v21 = v21 * v64 + v44 * v9 + v28 * v60 + v14 * v7 + v5 * v3 + v38 * v54 + v58 * v56 + v50 * v42;
        v12 = v44 * v64 + v28 * v9 + v14 * v60 + v5 * v7 + v38 * v3 + v58 * v54 + v42 * v56;
        v28 = v28 * v64 + v14 * v9 + v5 * v60 + v38 * v7 + v58 * v3 + v54 * v42;
        v14 = v14 * v64 + v5 * v9 + v38 * v60 + v58 * v7 + v3 * v42;
        v5 = v5 * v64 + v38 * v9 + v58 * v60 + v7 * v42;
        v38 = v38 * v64 + v58 * v9 + v60 * v42;
        long v2 = v58 * v64 + v9 * v42;
        v42 *= v64;
        v10 = v66 + 0x100000 >> 21;
        v68 += v10;
        v66 -= v10 << 21;
        v10 = v70 + 0x100000 >> 21;
        v72 += v10;
        v70 -= v10 << 21;
        v10 = v74 + 0x100000 >> 21;
        v76 += v10;
        v74 -= v10 << 21;
        v10 = v78 + 0x100000 >> 21;
        v80 += v10;
        v78 -= v10 << 21;
        v10 = v82 + 0x100000 >> 21;
        v19 += v10;
        v82 -= v10 << 21;
        v10 = v0 + 0x100000 >> 21;
        v84 += v10;
        v0 -= v10 << 21;
        v10 = v36 + 0x100000 >> 21;
        v25 += v10;
        v36 -= v10 << 21;
        v10 = v17 + 0x100000 >> 21;
        v21 += v10;
        v17 -= v10 << 21;
        v10 = v12 + 0x100000 >> 21;
        v28 += v10;
        v12 -= v10 << 21;
        v10 = v14 + 0x100000 >> 21;
        v5 += v10;
        v14 -= v10 << 21;
        v10 = v38 + 0x100000 >> 21;
        v2 += v10;
        v38 -= v10 << 21;
        v10 = v42 + 0x100000 >> 21;
        v40 = v68 + 0x100000 >> 21;
        v70 += v40;
        v68 -= v40 << 21;
        v40 = v72 + 0x100000 >> 21;
        v74 += v40;
        v72 -= v40 << 21;
        v40 = v76 + 0x100000 >> 21;
        v78 += v40;
        v76 -= v40 << 21;
        v40 = v80 + 0x100000 >> 21;
        v82 += v40;
        v80 -= v40 << 21;
        v40 = v19 + 0x100000 >> 21;
        v0 += v40;
        v19 -= v40 << 21;
        v40 = v84 + 0x100000 >> 21;
        v36 += v40;
        v84 -= v40 << 21;
        v40 = v25 + 0x100000 >> 21;
        v17 += v40;
        v25 -= v40 << 21;
        v40 = v21 + 0x100000 >> 21;
        v12 += v40;
        v21 -= v40 << 21;
        v40 = v28 + 0x100000 >> 21;
        v14 += v40;
        v28 -= v40 << 21;
        v40 = v5 + 0x100000 >> 21;
        v38 += v40;
        v5 -= v40 << 21;
        v40 = v2 + 0x100000 >> 21;
        v42 = v42 - (v10 << 21) + v40;
        v2 -= v40 << 21;
        v12 -= v10 * 0xA6F7D;
        v25 = v25 + v10 * 0x9FB67 - v42 * 0xF39AD + v2 * 0x215D1;
        v17 = v17 - v10 * 0xF39AD + v42 * 0x215D1 - v2 * 0xA6F7D;
        v84 = v84 + v10 * 0xA2C13 + v42 * 470296 + v2 * 0x9FB67 - v38 * 0xF39AD + v5 * 0x215D1;
        v36 = v36 + v10 * 470296 + v42 * 0x9FB67 - v2 * 0xF39AD + v38 * 0x215D1 - v5 * 0xA6F7D;
        v78 += v14 * 0xA2C13;
        v82 = v82 + v38 * 0xA2C13 + v5 * 470296 + v14 * 0x9FB67;
        v19 = v19 + v2 * 0xA2C13 + v38 * 470296 + v5 * 0x9FB67 - v14 * 0xF39AD;
        v0 = v0 + v42 * 0xA2C13 + v2 * 470296 + v38 * 0x9FB67 - v5 * 0xF39AD + v14 * 0x215D1;
        v2 = v78 + 0x100000 >> 21;
        v80 = v80 + v5 * 0xA2C13 + v14 * 470296 + v2;
        v78 -= v2 << 21;
        v2 = v82 + 0x100000 >> 21;
        v19 += v2;
        v82 -= v2 << 21;
        v2 = v0 + 0x100000 >> 21;
        v84 = v84 - v14 * 0xA6F7D + v2;
        v0 -= v2 << 21;
        v2 = v36 + 0x100000 >> 21;
        v25 = v25 - v38 * 0xA6F7D + v2;
        v36 -= v2 << 21;
        v2 = v17 + 0x100000 >> 21;
        v21 = v21 + v10 * 0x215D1 - v42 * 0xA6F7D + v2;
        v17 -= v2 << 21;
        v2 = v12 + 0x100000 >> 21;
        v28 += v2;
        v12 -= v2 << 21;
        v2 = v80 + 0x100000 >> 21;
        v82 += v2;
        v80 -= v2 << 21;
        v2 = v19 + 0x100000 >> 21;
        v0 += v2;
        v19 -= v2 << 21;
        v2 = v84 + 0x100000 >> 21;
        v36 += v2;
        v84 -= v2 << 21;
        v2 = v25 + 0x100000 >> 21;
        v17 += v2;
        v25 -= v2 << 21;
        v2 = v21 + 0x100000 >> 21;
        v12 += v2;
        v21 -= v2 << 21;
        v0 -= v28 * 0xA6F7D;
        v82 = v82 - v28 * 0xF39AD + v12 * 0x215D1 - v21 * 0xA6F7D;
        v78 = v78 + v28 * 470296 + v12 * 0x9FB67 - v21 * 0xF39AD + v17 * 0x215D1 - v25 * 0xA6F7D;
        v66 += v36 * 0xA2C13;
        v70 = v70 + v17 * 0xA2C13 + v25 * 470296 + v36 * 0x9FB67;
        v74 = v74 + v12 * 0xA2C13 + v21 * 470296 + v17 * 0x9FB67 - v25 * 0xF39AD + v36 * 0x215D1;
        v2 = v66 + 0x100000 >> 21;
        v68 = v68 + v25 * 0xA2C13 + v36 * 470296 + v2;
        v66 -= v2 << 21;
        v2 = v70 + 0x100000 >> 21;
        v72 = v72 + v21 * 0xA2C13 + v17 * 470296 + v25 * 0x9FB67 - v36 * 0xF39AD + v2;
        v70 -= v2 << 21;
        v2 = v74 + 0x100000 >> 21;
        v76 = v76 + v28 * 0xA2C13 + v12 * 470296 + v21 * 0x9FB67 - v17 * 0xF39AD + v25 * 0x215D1 - v36 * 0xA6F7D + v2;
        v74 -= v2 << 21;
        v2 = v78 + 0x100000 >> 21;
        v80 = v80 + v28 * 0x9FB67 - v12 * 0xF39AD + v21 * 0x215D1 - v17 * 0xA6F7D + v2;
        v78 -= v2 << 21;
        v2 = v82 + 0x100000 >> 21;
        v19 = v19 + v28 * 0x215D1 - v12 * 0xA6F7D + v2;
        v82 -= v2 << 21;
        v2 = v0 + 0x100000 >> 21;
        v84 += v2;
        v0 -= v2 << 21;
        v2 = v68 + 0x100000 >> 21;
        v70 += v2;
        v68 -= v2 << 21;
        v2 = v72 + 0x100000 >> 21;
        v74 += v2;
        v72 -= v2 << 21;
        v2 = v76 + 0x100000 >> 21;
        v78 += v2;
        v76 -= v2 << 21;
        v2 = v80 + 0x100000 >> 21;
        v82 += v2;
        v80 -= v2 << 21;
        v2 = v19 + 0x100000 >> 21;
        v0 += v2;
        v19 -= v2 << 21;
        v2 = v84 + 0x100000 >> 21;
        v84 -= v2 << 21;
        v66 += v2 * 0xA2C13;
        v68 += v2 * 470296;
        v70 += v2 * 0x9FB67;
        v72 -= v2 * 0xF39AD;
        v74 += v2 * 0x215D1;
        v76 -= v2 * 0xA6F7D;
        v2 = v66 >> 21;
        v68 += v2;
        v66 -= v2 << 21;
        v2 = v68 >> 21;
        v70 += v2;
        v68 -= v2 << 21;
        v2 = v70 >> 21;
        v72 += v2;
        v70 -= v2 << 21;
        v2 = v72 >> 21;
        v74 += v2;
        v72 -= v2 << 21;
        v2 = v74 >> 21;
        v76 += v2;
        v74 -= v2 << 21;
        v2 = v76 >> 21;
        v78 += v2;
        v76 -= v2 << 21;
        v2 = v78 >> 21;
        v80 += v2;
        v78 -= v2 << 21;
        v2 = v80 >> 21;
        v82 += v2;
        v80 -= v2 << 21;
        v2 = v82 >> 21;
        v19 += v2;
        v82 -= v2 << 21;
        v2 = v19 >> 21;
        v0 += v2;
        v19 -= v2 << 21;
        v2 = v0 >> 21;
        v84 += v2;
        v0 -= v2 << 21;
        v2 = v84 >> 21;
        v84 -= v2 << 21;
        v66 += 0xA2C13 * v2;
        v68 += 470296 * v2;
        v70 += 0x9FB67 * v2;
        v72 -= 0xF39AD * v2;
        v74 += 0x215D1 * v2;
        v76 -= v2 * 0xA6F7D;
        v2 = v66 >> 21;
        v68 += v2;
        v2 = v66 - (v2 << 21);
        long v4 = v68 >> 21;
        v70 += v4;
        v68 -= v4 << 21;
        v4 = v70 >> 21;
        v72 += v4;
        v70 -= v4 << 21;
        v4 = v72 >> 21;
        v74 += v4;
        v72 -= v4 << 21;
        v4 = v74 >> 21;
        v76 += v4;
        v74 -= v4 << 21;
        v4 = v76 >> 21;
        v78 += v4;
        v76 -= v4 << 21;
        v4 = v78 >> 21;
        v80 += v4;
        v78 -= v4 << 21;
        v4 = v80 >> 21;
        v82 += v4;
        v80 -= v4 << 21;
        v4 = v82 >> 21;
        v19 += v4;
        v4 = v82 - (v4 << 21);
        v8 = v19 >> 21;
        v0 += v8;
        v19 -= v8 << 21;
        v8 = v0 >> 21;
        v84 += v8;
        long v89 = v0 - (v8 << 21);
        return new Scalar(new byte[]{((byte)(((int)v2))), ((byte)(((int)(v2 >> 8)))), ((byte)(((int)(v2 >> 16 | v68 << 5)))), ((byte)(((int)(v68 >> 3)))), ((byte)(((int)(v68 >> 11)))), ((byte)(((int)(v68 >> 19 | v70 << 2)))), ((byte)(((int)(v70 >> 6)))), ((byte)(((int)(v70 >> 14 | v72 << 7)))), ((byte)(((int)(v72 >> 1)))), ((byte)(((int)(v72 >> 9)))), ((byte)(((int)(v72 >> 17 | v74 << 4)))), ((byte)(((int)(v74 >> 4)))), ((byte)(((int)(v74 >> 12)))), ((byte)(((int)(v74 >> 20 | v76 << 1)))), ((byte)(((int)(v76 >> 7)))), ((byte)(((int)(v76 >> 15 | v78 << 6)))), ((byte)(((int)(v78 >> 2)))), ((byte)(((int)(v78 >> 10)))), ((byte)(((int)(v78 >> 18 | v80 << 3)))), ((byte)(((int)(v80 >> 5)))), ((byte)(((int)(v80 >> 13)))), ((byte)(((int)v4))), ((byte)(((int)(v4 >> 8)))), ((byte)(((int)(v4 >> 16 | v19 << 5)))), ((byte)(((int)(v19 >> 3)))), ((byte)(((int)(v19 >> 11)))), ((byte)(((int)(v19 >> 19 | v89 << 2)))), ((byte)(((int)(v89 >> 6)))), ((byte)(((int)(v89 >> 14 | v84 << 7)))), ((byte)(((int)(v84 >> 1)))), ((byte)(((int)(v84 >> 9)))), ((byte)(((int)(v84 >> 17))))});
    }

    byte[] nonAdjacentForm() {
        int v0 = 0x100;
        byte[] v1 = new byte[v0];
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = ((byte)(1 & this.s[v3 >> 3] >> (v3 & 7)));
        }

        int v10;
        for(v10 = 0; v10 < v0; ++v10) {
            if(v1[v10] != 0) {
                for(v3 = 1; v3 <= 6; ++v3) {
                    int v5 = v10 + v3;
                    if(v5 >= v0) {
                        break;
                    }

                    int v6 = v1[v5];
                    if(v6 != 0) {
                        int v7 = v1[v10];
                        if((v6 << v3) + v7 <= 15) {
                            v1[v10] = ((byte)(v7 + (v6 << v3)));
                            v1[v5] = 0;
                        }
                        else if(v7 - (v6 << v3) >= -15) {
                            v1[v10] = ((byte)(v7 - (v6 << v3)));
                            while(v5 < v0) {
                                if(v1[v5] == 0) {
                                    v1[v5] = 1;
                                }
                                else {
                                    v1[v5] = 0;
                                    ++v5;
                                    continue;
                                }

                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }

        return v1;
    }

    private void readObject(ObjectInputStream arg2) throws IOException, ClassNotFoundException {
        byte[] v0 = new byte[0x20];
        arg2.readFully(v0);
        if((v0[0x1F] >> 7 & 1) == 0) {
            this.s = v0;
            return;
        }

        throw new InvalidObjectException("Invalid scalar representation");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Cannot deserialize Scalar from no data");
    }

    static Scalar reduce(byte[] arg1) {
        return new Scalar(UnpackedScalar.montgomeryReduce(UnpackedScalar.fromByteArray(arg1).mulInternal(Constants.R)).toByteArray());
    }

    public Scalar reduce() {
        return Scalar.reduce(this.s);
    }

    public Scalar subtract(Scalar arg2) {
        return new Scalar(UnpackedScalar.fromByteArray(this.s).subtract(UnpackedScalar.fromByteArray(arg2.s)).toByteArray());
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(this.s, this.s.length);
    }

    byte[] toRadix16() {
        byte[] v0 = new byte[0x40];
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < 0x20; ++v2) {
            int v3 = v2 * 2;
            byte[] v4 = this.s;
            v0[v3] = ((byte)(v4[v2] & 15));
            v0[v3 + 1] = ((byte)(v4[v2] >> 4 & 15));
        }

        int v6;
        for(v6 = 0; true; v6 = v2) {
            v2 = 0x3F;
            if(v1 >= v2) {
                break;
            }

            byte v6_1 = ((byte)(v0[v1] + v6));
            v0[v1] = v6_1;
            v2 = v6_1 + 8 >> 4;
            v0[v1] = ((byte)(v6_1 - (v2 << 4)));
            ++v1;
        }

        v0[v2] = ((byte)(v0[v2] + v6));
        return v0;
    }

    public String toString() {
        return "Scalar(" + StrUtils.bytesToHex(this.s) + ")";
    }

    private void writeObject(ObjectOutputStream arg1) throws IOException {
        arg1.write(this.toByteArray());
    }
}

