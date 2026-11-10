package org.bouncycastle.asn1;

public class DERNumericString extends ASN1NumericString {
    DERNumericString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERNumericString(String arg2) {
        this(arg2, false);
    }

    public DERNumericString(String arg1, boolean arg2) {
        super(arg1, arg2);
    }
}

