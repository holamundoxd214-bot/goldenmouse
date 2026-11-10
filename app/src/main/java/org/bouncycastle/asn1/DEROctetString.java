package org.bouncycastle.asn1;

import java.io.IOException;

public class DEROctetString extends ASN1OctetString {
    public DEROctetString(byte[] arg1) {
        super(arg1);
    }

    public DEROctetString(ASN1Encodable arg2) throws IOException {
        super(arg2.toASN1Primitive().getEncoded("DER"));
    }

    static void encode(ASN1OutputStream arg6, boolean arg7, byte[] arg8, int arg9, int arg10) throws IOException {
        arg6.writeEncodingDL(arg7, 4, arg8, arg9, arg10);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 4, this.string);
    }

    boolean encodeConstructed() {
        return 0;
    }

    static int encodedLength(boolean arg0, int arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg0, arg1);
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.string.length);
    }

    ASN1Primitive toDERObject() {
        return this;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

