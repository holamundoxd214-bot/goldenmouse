package org.bouncycastle.asn1;

public class DERGeneralString extends ASN1GeneralString {
    DERGeneralString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERGeneralString(String arg1) {
        super(arg1);
    }
}

