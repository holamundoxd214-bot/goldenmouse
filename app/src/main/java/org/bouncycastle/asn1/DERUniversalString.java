package org.bouncycastle.asn1;

public class DERUniversalString extends ASN1UniversalString {
    DERUniversalString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERUniversalString(byte[] arg2) {
        this(arg2, true);
    }
}

