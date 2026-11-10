package org.bouncycastle.asn1;

public class DERPrintableString extends ASN1PrintableString {
    DERPrintableString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERPrintableString(String arg2) {
        this(arg2, false);
    }

    public DERPrintableString(String arg1, boolean arg2) {
        super(arg1, arg2);
    }
}

