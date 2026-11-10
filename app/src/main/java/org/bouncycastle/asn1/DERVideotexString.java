package org.bouncycastle.asn1;

public class DERVideotexString extends ASN1VideotexString {
    DERVideotexString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERVideotexString(byte[] arg2) {
        this(arg2, true);
    }
}

