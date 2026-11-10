package org.bouncycastle.asn1;

import java.io.IOException;

public class DLBitString extends ASN1BitString {
    DLBitString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DLBitString(byte arg1, int arg2) {
        super(arg1, arg2);
    }

    public DLBitString(int arg2) {
        super(DLBitString.getBytes(arg2), DLBitString.getPadBits(arg2));
    }

    public DLBitString(ASN1Encodable arg2) throws IOException {
        super(arg2.toASN1Primitive().getEncoded("DER"), 0);
    }

    public DLBitString(byte[] arg2) {
        this(arg2, 0);
    }

    public DLBitString(byte[] arg1, int arg2) {
        super(arg1, arg2);
    }

    static void encode(ASN1OutputStream arg6, boolean arg7, byte[] arg8, int arg9, int arg10) throws IOException {
        arg6.writeEncodingDL(arg7, 3, arg8, arg9, arg10);
    }

    static void encode(ASN1OutputStream arg7, boolean arg8, byte arg9, byte[] arg10, int arg11, int arg12) throws IOException {
        arg7.writeEncodingDL(arg8, 3, arg9, arg10, arg11, arg12);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingDL(arg3, 3, this.contents);
    }

    boolean encodeConstructed() {
        return 0;
    }

    static int encodedLength(boolean arg0, int arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg0, arg1);
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

