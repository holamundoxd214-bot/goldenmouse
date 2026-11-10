package org.bouncycastle.asn1;

public class DERGraphicString extends ASN1GraphicString {
    DERGraphicString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERGraphicString(byte[] arg2) {
        this(arg2, true);
    }
}

