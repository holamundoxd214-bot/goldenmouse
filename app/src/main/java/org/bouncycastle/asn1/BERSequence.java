package org.bouncycastle.asn1;

import java.io.IOException;

public class BERSequence extends ASN1Sequence {
    public BERSequence() {
        super();
    }

    public BERSequence(ASN1EncodableVector arg1) {
        super(arg1);
    }

    public BERSequence(ASN1Encodable arg1) {
        super(arg1);
    }

    public BERSequence(ASN1Encodable arg1, ASN1Encodable arg2) {
        super(arg1, arg2);
    }

    public BERSequence(ASN1Encodable[] arg1) {
        super(arg1);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingIL(arg3, 0x30, this.elements);
    }

    int encodedLength(boolean arg5) throws IOException {
        int v5 = arg5 ? 4 : 3;
        int v0 = this.elements.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            v5 += this.elements[v1].toASN1Primitive().encodedLength(true);
        }

        return v5;
    }

    ASN1BitString toASN1BitString() {
        return new BERBitString(this.getConstructedBitStrings());
    }

    ASN1External toASN1External() {
        return this.toDLObject().toASN1External();
    }

    ASN1OctetString toASN1OctetString() {
        return new BEROctetString(this.getConstructedOctetStrings());
    }

    ASN1Set toASN1Set() {
        return new BERSet(false, this.toArrayInternal());
    }
}

