package org.bouncycastle.asn1;

import java.io.IOException;

public class BERTaggedObject extends ASN1TaggedObject {
    BERTaggedObject(int arg1, int arg2, int arg3, ASN1Encodable arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public BERTaggedObject(int arg2, int arg3, ASN1Encodable arg4) {
        super(true, arg2, arg3, arg4);
    }

    public BERTaggedObject(int arg2, ASN1Encodable arg3) {
        super(true, arg2, arg3);
    }

    public BERTaggedObject(boolean arg1, int arg2, int arg3, ASN1Encodable arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public BERTaggedObject(boolean arg1, int arg2, ASN1Encodable arg3) {
        super(arg1, arg2, arg3);
    }

    void encode(ASN1OutputStream arg5, boolean arg6) throws IOException {
        ASN1Primitive v0 = this.obj.toASN1Primitive();
        boolean v1 = this.isExplicit();
        if(arg6) {
            int v6 = this.tagClass;
            if((v1) || (v0.encodeConstructed())) {
                v6 |= 0x20;
            }

            arg5.writeIdentifier(true, v6, this.tagNo);
        }

        if(v1) {
            arg5.write(0x80);
            v0.encode(arg5, true);
            arg5.write(0);
            arg5.write(0);
            return;
        }

        v0.encode(arg5, false);
    }

    boolean encodeConstructed() {
        if(!this.isExplicit()) {
            if(this.obj.toASN1Primitive().encodeConstructed()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    int encodedLength(boolean arg3) throws IOException {
        ASN1Primitive v0 = this.obj.toASN1Primitive();
        boolean v1 = this.isExplicit();
        int v0_1 = v0.encodedLength(v1);
        if(v1) {
            v0_1 += 3;
        }

        int v2 = arg3 ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0;
        return v0_1 + v2;
    }

    ASN1Sequence rebuildConstructed(ASN1Primitive arg1) {
        return new BERSequence(((ASN1Encodable)arg1));
    }

    ASN1TaggedObject replaceTag(int arg3, int arg4) {
        return new BERTaggedObject(this.explicitness, arg3, arg4, this.obj);
    }
}

