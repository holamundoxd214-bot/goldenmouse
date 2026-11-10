package org.bouncycastle.asn1;

import java.io.IOException;

public class DLTaggedObject extends ASN1TaggedObject {
    DLTaggedObject(int arg1, int arg2, int arg3, ASN1Encodable arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    public DLTaggedObject(boolean arg1, int arg2, ASN1Encodable arg3) {
        super(arg1, arg2, arg3);
    }

    public DLTaggedObject(int arg2, int arg3, ASN1Encodable arg4) {
        super(true, arg2, arg3, arg4);
    }

    public DLTaggedObject(int arg2, ASN1Encodable arg3) {
        super(true, arg2, arg3);
    }

    public DLTaggedObject(boolean arg1, int arg2, int arg3, ASN1Encodable arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    void encode(ASN1OutputStream arg5, boolean arg6) throws IOException {
        ASN1Primitive v0 = this.obj.toASN1Primitive().toDLObject();
        boolean v1 = this.isExplicit();
        if(arg6) {
            int v6 = this.tagClass;
            if((v1) || (v0.encodeConstructed())) {
                v6 |= 0x20;
            }

            arg5.writeIdentifier(true, v6, this.tagNo);
        }

        if(v1) {
            arg5.writeDL(v0.encodedLength(true));
        }

        v0.encode(arg5.getDLSubStream(), v1);
    }

    boolean encodeConstructed() {
        if(!this.isExplicit()) {
            if(this.obj.toASN1Primitive().toDLObject().encodeConstructed()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    int encodedLength(boolean arg3) throws IOException {
        ASN1Primitive v0 = this.obj.toASN1Primitive().toDLObject();
        boolean v1 = this.isExplicit();
        int v0_1 = v0.encodedLength(v1);
        if(v1) {
            v0_1 += ASN1OutputStream.getLengthOfDL(v0_1);
        }

        int v2 = arg3 ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0;
        return v0_1 + v2;
    }

    ASN1Sequence rebuildConstructed(ASN1Primitive arg1) {
        return new DLSequence(((ASN1Encodable)arg1));
    }

    ASN1TaggedObject replaceTag(int arg3, int arg4) {
        return new DLTaggedObject(this.explicitness, arg3, arg4, this.obj);
    }

    ASN1Primitive toDLObject() {
        return this;
    }
}

