package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

public class ASN1Integer extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1Integer$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1Integer$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1Integer.createPrimitive(arg1.getOctets());
        }
    }

    static final int SIGN_EXT_SIGNED = -1;
    static final int SIGN_EXT_UNSIGNED = 0xFF;
    static final ASN1UniversalType TYPE;
    private final byte[] bytes;
    private final int start;

    static {
        ASN1Integer.TYPE = new org.bouncycastle.asn1.ASN1Integer$1(ASN1Integer.class, 2);
    }

    public ASN1Integer(long arg1) {
        super();
        this.bytes = BigInteger.valueOf(arg1).toByteArray();
        this.start = 0;
    }

    public ASN1Integer(BigInteger arg1) {
        super();
        this.bytes = arg1.toByteArray();
        this.start = 0;
    }

    public ASN1Integer(byte[] arg2) {
        this(arg2, true);
    }

    ASN1Integer(byte[] arg2, boolean arg3) {
        super();
        if(!ASN1Integer.isMalformed(arg2)) {
            byte[] v3 = arg3 ? Arrays.clone(arg2) : arg2;
            this.bytes = v3;
            this.start = ASN1Integer.signBytesToSkip(arg2);
            return;
        }

        throw new IllegalArgumentException("malformed integer");
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1Integer)) {
            return 0;
        }

        return Arrays.areEqual(this.bytes, ((ASN1Integer)arg2).bytes);
    }

    static ASN1Integer createPrimitive(byte[] arg2) {
        return new ASN1Integer(arg2, false);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 2, this.bytes);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.bytes.length);
    }

    public static ASN1Integer getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1Integer)) {
            }
            else if((arg3 instanceof byte[])) {
                try {
                    return ASN1Integer.TYPE.fromByteArray(((byte[])arg3));
                }
                catch(Exception v3) {
                    throw new IllegalArgumentException("encoding error in getInstance: " + v3.toString());
                }
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1Integer getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Integer.TYPE.getContextTagged(arg1, arg2);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public static ASN1Integer getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Integer.TYPE.getTagged(arg1, arg2);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(int arg4) {
        byte[] v0 = this.bytes;
        int v1 = v0.length;
        int v3 = this.start;
        if(v1 - v3 <= 4 && ASN1Integer.intValue(v0, v3, -1) == arg4) {
            return 1;
        }

        return 0;
    }

    public boolean hasValue(long arg4) {
        byte[] v0 = this.bytes;
        int v1 = v0.length;
        int v3 = this.start;
        if(v1 - v3 <= 8 && ASN1Integer.longValue(v0, v3, -1) == arg4) {
            return 1;
        }

        return 0;
    }

    public boolean hasValue(BigInteger arg4) {
        if(arg4 != null && ASN1Integer.intValue(this.bytes, this.start, -1) == arg4.intValue() && (this.getValue().equals(arg4))) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intPositiveValueExact() {
        byte[] v0 = this.bytes;
        int v1 = v0.length;
        int v3 = this.start;
        v1 -= v3;
        int v2 = 4;
        if(v1 <= v2 && (v1 != v2 || (v0[v3] & 0x80) == 0)) {
            return ASN1Integer.intValue(v0, v3, 0xFF);
        }

        throw new ArithmeticException("ASN.1 Integer out of positive int range");
    }

    static int intValue(byte[] arg2, int arg3, int arg4) {
        int v0 = arg2.length;
        arg3 = Math.max(arg3, v0 - 4);
        arg4 &= arg2[arg3];
        while(true) {
            ++arg3;
            if(arg3 >= v0) {
                return arg4;
            }

            arg4 = arg4 << 8 | arg2[arg3] & 0xFF;
        }

        return arg4;
    }

    public int intValueExact() {
        byte[] v0 = this.bytes;
        int v1 = v0.length;
        int v3 = this.start;
        if(v1 - v3 <= 4) {
            return ASN1Integer.intValue(v0, v3, -1);
        }

        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    static boolean isMalformed(byte[] arg3) {
        int v0 = arg3.length;
        if(v0 != 0) {
            if(v0 != 1 && arg3[0] == arg3[1] >> 7 && !Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer")) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    static long longValue(byte[] arg5, int arg6, int arg7) {
        int v0 = arg5.length;
        arg6 = Math.max(arg6, v0 - 8);
        long v1;
        for(v1 = ((long)(arg7 & arg5[arg6])); true; v1 = v1 << 8 | (((long)(arg5[arg6] & 0xFF)))) {
            ++arg6;
            if(arg6 >= v0) {
                return v1;
            }
        }

        return v1;
    }

    public long longValueExact() {
        byte[] v0 = this.bytes;
        int v1 = v0.length;
        int v3 = this.start;
        if(v1 - v3 <= 8) {
            return ASN1Integer.longValue(v0, v3, -1);
        }

        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    static int signBytesToSkip(byte[] arg5) {
        int v0 = arg5.length - 1;
        int v1;
        for(v1 = 0; v1 < v0; v1 = v3) {
            int v3 = v1 + 1;
            if(arg5[v1] != arg5[v3] >> 7) {
                return v1;
            }
        }

        return v1;
    }

    public String toString() {
        return this.getValue().toString();
    }
}

