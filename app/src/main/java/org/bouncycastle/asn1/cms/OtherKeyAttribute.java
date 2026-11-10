package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OtherKeyAttribute extends ASN1Object {
    private ASN1Encodable keyAttr;
    private ASN1ObjectIdentifier keyAttrId;

    public OtherKeyAttribute(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.keyAttrId = arg1;
        this.keyAttr = arg2;
    }

    private OtherKeyAttribute(ASN1Sequence arg3) {
        super();
        this.keyAttrId = arg3.getObjectAt(0);
        if(arg3.size() > 1) {
            this.keyAttr = arg3.getObjectAt(1);
        }
    }

    public static OtherKeyAttribute getInstance(Object arg1) {
        if((arg1 instanceof OtherKeyAttribute)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherKeyAttribute(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Encodable getKeyAttr() {
        return this.keyAttr;
    }

    public ASN1ObjectIdentifier getKeyAttrId() {
        return this.keyAttrId;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.keyAttrId);
        ASN1Encodable v2 = this.keyAttr;
        if(v2 != null) {
            v0.add(v2);
        }

        return new DERSequence(v0);
    }
}

