package org.bouncycastle.asn1;

import java.io.IOException;

public class BERSet extends ASN1Set {
    public BERSet() {
        super();
    }

    public BERSet(ASN1EncodableVector arg2) {
        super(arg2, false);
    }

    BERSet(boolean arg1, ASN1Encodable[] arg2) {
        super(arg1, arg2);
    }

    public BERSet(ASN1Encodable arg1) {
        super(arg1);
    }

    public BERSet(ASN1Encodable[] arg2) {
        super(arg2, false);
    }

    void encode(ASN1OutputStream arg2, boolean arg3) throws IOException {
        arg2.writeEncodingIL(arg3, 49, this.elements);
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
}

