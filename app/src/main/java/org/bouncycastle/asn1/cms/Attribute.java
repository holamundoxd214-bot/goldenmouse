package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;

public class Attribute extends ASN1Object {
    private ASN1ObjectIdentifier attrType;
    private ASN1Set attrValues;

    public Attribute(ASN1ObjectIdentifier arg1, ASN1Set arg2) {
        super();
        this.attrType = arg1;
        this.attrValues = arg2;
    }

    private Attribute(ASN1Sequence arg2) {
        super();
        this.attrType = arg2.getObjectAt(0);
        this.attrValues = arg2.getObjectAt(1);
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.attrType;
    }

    public ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public ASN1Encodable[] getAttributeValues() {
        return this.attrValues.toArray();
    }

    public static Attribute getInstance(Object arg1) {
        if((arg1 instanceof Attribute)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Attribute(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.attrType, this.attrValues);
    }
}

