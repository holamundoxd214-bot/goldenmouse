package org.bouncycastle.asn1;

import java.io.IOException;

public class DERBitString extends ASN1BitString {
    DERBitString(byte[] arg1, boolean arg2) {
        super(arg1, arg2);
    }

    public DERBitString(byte arg1, int arg2) {
        super(arg1, arg2);
    }

    public DERBitString(int arg2) {
        super(DERBitString.getBytes(arg2), DERBitString.getPadBits(arg2));
    }

    public DERBitString(ASN1Encodable arg2) throws IOException {
        super(arg2.toASN1Primitive().getEncoded("DER"), 0);
    }

    public DERBitString(byte[] arg2) {
        this(arg2, 0);
    }

    public DERBitString(byte[] arg1, int arg2) {
        super(arg1, arg2);
    }

    public static DERBitString convert(ASN1BitString arg0) {
        return arg0.toDERObject();
    }

    void encode(ASN1OutputStream arg11, boolean arg12) throws IOException {
        int v0 = this.contents[0] & 0xFF;
        int v8 = this.contents.length - 1;
        int v2 = this.contents[v8];
        byte v9 = ((byte)(0xFF << v0 & this.contents[v8]));
        if(v2 == v9) {
            arg11.writeEncodingDL(arg12, 3, this.contents);
            return;
        }

        arg11.writeEncodingDL(arg12, 3, this.contents, 0, v8, v9);
    }

    boolean encodeConstructed() {
        return 0;
    }

    int encodedLength(boolean arg1) {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.contents.length);
    }

    static DERBitString fromOctetString(ASN1OctetString arg2) {
        return new DERBitString(arg2.getOctets(), true);
    }

    ASN1Primitive toDERObject() {
        return this;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

