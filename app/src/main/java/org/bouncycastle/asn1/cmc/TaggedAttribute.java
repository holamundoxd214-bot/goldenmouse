package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;

public class TaggedAttribute extends ASN1Object {
    private final ASN1ObjectIdentifier attrType;
    private final ASN1Set attrValues;
    private final BodyPartID bodyPartID;

    private TaggedAttribute(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.bodyPartID = BodyPartID.getInstance(arg3.getObjectAt(0));
            this.attrType = ASN1ObjectIdentifier.getInstance(arg3.getObjectAt(1));
            this.attrValues = ASN1Set.getInstance(arg3.getObjectAt(2));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public TaggedAttribute(BodyPartID arg1, ASN1ObjectIdentifier arg2, ASN1Set arg3) {
        super();
        this.bodyPartID = arg1;
        this.attrType = arg2;
        this.attrValues = arg3;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.attrType;
    }

    public ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public static TaggedAttribute getInstance(Object arg1) {
        if((arg1 instanceof TaggedAttribute)) {
            return arg1;
        }

        if(arg1 != null) {
            return new TaggedAttribute(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.bodyPartID, this.attrType, this.attrValues});
    }
}

