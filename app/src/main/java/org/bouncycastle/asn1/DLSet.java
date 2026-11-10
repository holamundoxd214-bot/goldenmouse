package org.bouncycastle.asn1;

import java.io.IOException;

public class DLSet extends ASN1Set {
    private int contentsLength;

    DLSet(ASN1Encodable[] arg1, ASN1Encodable[] arg2) {
        super(arg1, arg2);
        this.contentsLength = -1;
    }

    DLSet(boolean arg1, ASN1Encodable[] arg2) {
        super(arg1, arg2);
        this.contentsLength = -1;
    }

    public DLSet() {
        super();
        this.contentsLength = -1;
    }

    public DLSet(ASN1EncodableVector arg2) {
        super(arg2, false);
        this.contentsLength = -1;
    }

    public DLSet(ASN1Encodable arg1) {
        super(arg1);
        this.contentsLength = -1;
    }

    public DLSet(ASN1Encodable[] arg2) {
        super(arg2, false);
        this.contentsLength = -1;
    }

    void encode(ASN1OutputStream arg8, boolean arg9) throws IOException {
        arg8.writeIdentifier(arg9, 49);
        DLOutputStream v9 = arg8.getDLSubStream();
        int v0 = this.elements.length;
        int v2 = 0;
        if(this.contentsLength >= 0 || v0 > 16) {
            arg8.writeDL(this.getContentsLength());
            while(v2 < v0) {
                ((ASN1OutputStream)v9).writePrimitive(this.elements[v2].toASN1Primitive(), true);
                ++v2;
            }
        }
        else {
            ASN1Primitive[] v1 = new ASN1Primitive[v0];
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                ASN1Primitive v6 = this.elements[v4].toASN1Primitive().toDLObject();
                v1[v4] = v6;
                v5 += v6.encodedLength(true);
                ++v4;
            }

            this.contentsLength = v5;
            arg8.writeDL(v5);
            while(v2 < v0) {
                ((ASN1OutputStream)v9).writePrimitive(v1[v2], true);
                ++v2;
            }
        }
    }

    int encodedLength(boolean arg1) throws IOException {
        return ASN1OutputStream.getLengthOfEncodingDL(arg1, this.getContentsLength());
    }

    private int getContentsLength() throws IOException {
        int v0 = this.contentsLength;
        if(v0 < 0) {
            v0 = this.elements.length;
            int v1 = 0;
            int v2 = 0;
            while(v1 < v0) {
                v2 += this.elements[v1].toASN1Primitive().toDLObject().encodedLength(true);
                ++v1;
            }

            this.contentsLength = v2;
            return v2;
        }

        return v0;
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

