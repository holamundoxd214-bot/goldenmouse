package org.bouncycastle.asn1;

public class DERIA5String extends ASN1IA5String {
    DERIA5String(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERIA5String(String arg2) {
        this(arg2, false);
    }

    public DERIA5String(String arg1, boolean arg2) {
        super(arg1, arg2);
    }
}

