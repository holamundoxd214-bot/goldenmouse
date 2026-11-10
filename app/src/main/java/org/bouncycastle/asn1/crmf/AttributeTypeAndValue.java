package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Object {
    private ASN1ObjectIdentifier type;
    private ASN1Encodable value;

    public AttributeTypeAndValue(String arg2, ASN1Encodable arg3) {
        this(new ASN1ObjectIdentifier(arg2), arg3);
    }

    public AttributeTypeAndValue(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.type = arg1;
        this.value = arg2;
    }

    private AttributeTypeAndValue(ASN1Sequence arg2) {
        super();
        this.type = arg2.getObjectAt(0);
        this.value = arg2.getObjectAt(1);
    }

    public static AttributeTypeAndValue getInstance(Object arg1) {
        if((arg1 instanceof AttributeTypeAndValue)) {
            return arg1;
        }

        if(arg1 != null) {
            return new AttributeTypeAndValue(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1ObjectIdentifier getType() {
        return this.type;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.type, this.value);
    }
}

