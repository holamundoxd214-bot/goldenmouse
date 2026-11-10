package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

class DEROutputStream extends DLOutputStream {
    DEROutputStream(OutputStream arg1) {
        super(arg1);
    }

    DEROutputStream getDERSubStream() {
        return this;
    }

    void writeElements(ASN1Encodable[] arg5) throws IOException {
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5[v1].toASN1Primitive().toDERObject().encode(((ASN1OutputStream)this), true);
        }
    }

    void writePrimitive(ASN1Primitive arg1, boolean arg2) throws IOException {
        arg1.toDERObject().encode(((ASN1OutputStream)this), arg2);
    }

    void writePrimitives(ASN1Primitive[] arg5) throws IOException {
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5[v1].toDERObject().encode(((ASN1OutputStream)this), true);
        }
    }
}

