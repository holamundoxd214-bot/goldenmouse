package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Null extends ASN1Primitive {
    class org.bouncycastle.asn1.ASN1Null$1 extends ASN1UniversalType {
        org.bouncycastle.asn1.ASN1Null$1(Class arg1, int arg2) {
            super(arg1, arg2);
        }

        ASN1Primitive fromImplicitPrimitive(DEROctetString arg1) {
            ASN1Null.checkContentsLength(arg1.getOctetsLength());
            return ASN1Null.createPrimitive();
        }
    }

    static final ASN1UniversalType TYPE;

    static {
        ASN1Null.TYPE = new org.bouncycastle.asn1.ASN1Null$1(ASN1Null.class, 5);
    }

    ASN1Null() {
        super();
    }

    boolean asn1Equals(ASN1Primitive arg1) {
        if(!(arg1 instanceof ASN1Null)) {
            return 0;
        }

        return 1;
    }

    static void checkContentsLength(int arg1) {
        if(arg1 == 0) {
            return;
        }

        throw new IllegalStateException("malformed NULL encoding encountered");
    }

    static ASN1Null createPrimitive() {
        return DERNull.INSTANCE;
    }

    public static ASN1Null getInstance(Object arg3) {
        if((arg3 instanceof ASN1Null)) {
            return arg3;
        }

        if(arg3 != null) {
            try {
                return ASN1Null.TYPE.fromByteArray(((byte[])arg3));
            }
            catch(IOException v3) {
                throw new IllegalArgumentException("failed to construct NULL from byte[]: " + v3.getMessage());
            }
        }

        return null;
    }

    public static ASN1Null getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Null.TYPE.getContextTagged(arg1, arg2);
    }

    public static ASN1Null getTagged(ASN1TaggedObject arg1, boolean arg2) {
        return ASN1Null.TYPE.getTagged(arg1, arg2);
    }

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}

