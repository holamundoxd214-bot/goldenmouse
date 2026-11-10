package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class Controls extends ASN1Object {
    private ASN1Sequence content;

    private Controls(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public Controls(AttributeTypeAndValue arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable)arg2));
    }

    public Controls(AttributeTypeAndValue[] arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable[])arg2));
    }

    public static Controls getInstance(Object arg1) {
        if((arg1 instanceof Controls)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Controls(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public AttributeTypeAndValue[] toAttributeTypeAndValueArray() {
        int v0 = this.content.size();
        AttributeTypeAndValue[] v1 = new AttributeTypeAndValue[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = AttributeTypeAndValue.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }
}

