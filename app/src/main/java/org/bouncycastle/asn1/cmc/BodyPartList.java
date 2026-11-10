package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class BodyPartList extends ASN1Object {
    private final BodyPartID[] bodyPartIDs;

    private BodyPartList(ASN1Sequence arg1) {
        super();
        this.bodyPartIDs = Utils.toBodyPartIDArray(arg1);
    }

    public BodyPartList(BodyPartID arg3) {
        super();
        this.bodyPartIDs = new BodyPartID[]{arg3};
    }

    public BodyPartList(BodyPartID[] arg1) {
        super();
        this.bodyPartIDs = Utils.clone(arg1);
    }

    public BodyPartID[] getBodyPartIDs() {
        return Utils.clone(this.bodyPartIDs);
    }

    public static BodyPartList getInstance(Object arg1) {
        if((arg1 instanceof BodyPartList)) {
            return arg1;
        }

        if(arg1 != null) {
            return new BodyPartList(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static BodyPartList getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return BodyPartList.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartIDs);
    }
}

