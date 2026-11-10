package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class ASN1Enumerated extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1Enumerated$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1Enumerated$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1Enumerated.createPrimitive(arg1.getOctets(), false);
        }
    }

    static final ASN1UniversalType TYPE;
    private static final ASN1Enumerated[] cache;
    private final byte[] contents;
    private final int start;

    static {
        ASN1Enumerated.TYPE = new org.bouncycastle.asn1.ASN1Enumerated$1(ASN1Enumerated.class, 10);
        ASN1Enumerated.cache = new ASN1Enumerated[12];
    }

    public ASN1Enumerated(int arg3) {
        super();
        if(arg3 >= 0) {
            this.contents = BigInteger.valueOf(((long)arg3)).toByteArray();
            this.start = 0;
            return;
        }

        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(BigInteger arg2) {
        super();
        if(arg2.signum() >= 0) {
            this.contents = arg2.toByteArray();
            this.start = 0;
            return;
        }

        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public ASN1Enumerated(byte[] arg2) {
        this(arg2, true);
    }

    ASN1Enumerated(byte[] arg2, boolean arg3) {
        super();
        if(!ASN1Integer.isMalformed(arg2)) {
            if((arg2[0] & 0x80) == 0) {
                byte[] v3 = arg3 ? Arrays.clone(arg2) : arg2;
                this.contents = v3;
                this.start = ASN1Integer.signBytesToSkip(arg2);
                return;
            }

            throw new IllegalArgumentException("enumerated must be non-negative");
        }

        throw new IllegalArgumentException("malformed enumerated");
    }

    boolean asn1Equals(ASN1Primitive arg2) {
        if(!(arg2 instanceof ASN1Enumerated)) {
            return 0;
        }

        return Arrays.areEqual(this.contents, ((ASN1Enumerated)arg2).contents);
    }

    static ASN1Enumerated createPrimitive(byte[] arg3, boolean arg4) {
        if(arg3.length > 1) {
            return new ASN1Enumerated(arg3, arg4);
        }

        if(arg3.length != 0) {
            int v0 = arg3[0] & 0xFF;
            ASN1Enumerated[] v1 = ASN1Enumerated.cache;
            if(v0 >= v1.length) {
                return new ASN1Enumerated(arg3, arg4);
            }

            ASN1Enumerated v2 = v1[v0];
            if(v2 == null) {
                v2 = new ASN1Enumerated(arg3, arg4);
                v1[v0] = v2;
            }

            return v2;
        }

        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 10, this.contents);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    public static ASN1Enumerated getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1Enumerated)) {
            }
            else if((arg3 instanceof byte[])) {
                try {
                    return ASN1Enumerated.TYPE.fromByteArray(((byte[])arg3));
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

    public static ASN1Enumerated getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Enumerated.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1Enumerated getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Enumerated.TYPE.getTagged(arg1, arg2);
    }

    public BigInteger getValue() {
        return new BigInteger(this.contents);
    }

    public boolean hasValue(int arg4) {
        byte[] v0 = this.contents;
        int v1 = v0.length;
        int v3 = this.start;
        if(v1 - v3 <= 4 && ASN1Integer.intValue(v0, v3, -1) == arg4) {
            return 1;
        }

        return 0;
    }

    public boolean hasValue(BigInteger arg4) {
        if(arg4 != null && ASN1Integer.intValue(this.contents, this.start, -1) == arg4.intValue() && (this.getValue().equals(arg4))) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public int intValueExact() {
        byte[] v0 = this.contents;
        int v1 = v0.length;
        int v3 = this.start;
        if(v1 - v3 <= 4) {
            return ASN1Integer.intValue(v0, v3, -1);
        }

        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }
}

