package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Boolean extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1Boolean$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1Boolean$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            return ASN1Boolean.createPrimitive(arg1.getOctets());
        }
    }

    public static final ASN1Boolean FALSE = null;
    private static final byte FALSE_VALUE = 0;
    public static final ASN1Boolean TRUE = null;
    private static final byte TRUE_VALUE = -1;
    static final ASN1UniversalType TYPE;
    private final byte value;

    static {
        ASN1Boolean.TYPE = new org.bouncycastle.asn1.ASN1Boolean$1(ASN1Boolean.class, 1);
        ASN1Boolean.FALSE = new ASN1Boolean(0);
        ASN1Boolean.TRUE = new ASN1Boolean(-1);
    }

    private ASN1Boolean(byte arg1) {
        super();
        this.value = arg1;
    }

    boolean asn1Equals(ASN1Primitive arg3) {
        if(!(arg3 instanceof ASN1Boolean)) {
            return 0;
        }

        if(this.isTrue() == ((ASN1Boolean)arg3).isTrue()) {
            return 1;
        }

        return 0;
    }

    static ASN1Boolean createPrimitive(byte[] arg2) {
        if(arg2.length == 1) {
            byte v2 = arg2[0];
            if(v2 != -1) {
                if(v2 != 0) {
                    return new ASN1Boolean(v2);
                }

                return ASN1Boolean.FALSE;
            }

            return ASN1Boolean.TRUE;
        }

        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 1, this.value);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, 1);
    }

    public static ASN1Boolean getInstance(int arg0) {
        if(arg0 != 0) {
            return ASN1Boolean.TRUE;
        }

        return ASN1Boolean.FALSE;
    }

    public static ASN1Boolean getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof ASN1Boolean)) {
            }
            else if((arg3 instanceof byte[])) {
                try {
                    return ASN1Boolean.TYPE.fromByteArray(((byte[])arg3));
                }
                catch(IOException v3) {
                    throw new IllegalArgumentException("failed to construct boolean from byte[]: " + v3.getMessage());
                }
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Boolean.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1Boolean getInstance(boolean arg0) {
        if(arg0) {
            return ASN1Boolean.TRUE;
        }

        return ASN1Boolean.FALSE;
    }

    public static ASN1Boolean getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Boolean.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return this.isTrue();
    }

    public boolean isTrue() {
        if(this.value != 0) {
            return 1;
        }

        return 0;
    }

    ASN1Primitive toDERObject() {
        if(this.isTrue()) {
            return ASN1Boolean.TRUE;
        }

        return ASN1Boolean.FALSE;
    }

    public String toString() {
        if(this.isTrue()) {
            return "TRUE";
        }

        return "FALSE";
    }
}

