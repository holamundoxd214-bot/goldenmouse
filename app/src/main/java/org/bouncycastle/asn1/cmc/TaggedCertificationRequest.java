package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class TaggedCertificationRequest extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final CertificationRequest certificationRequest;

    private TaggedCertificationRequest(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.bodyPartID = BodyPartID.getInstance(arg3.getObjectAt(0));
            this.certificationRequest = CertificationRequest.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public TaggedCertificationRequest(BodyPartID arg1, CertificationRequest arg2) {
        super();
        this.bodyPartID = arg1;
        this.certificationRequest = arg2;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public CertificationRequest getCertificationRequest() {
        return this.certificationRequest;
    }

    public static TaggedCertificationRequest getInstance(Object arg1) {
        if((arg1 instanceof TaggedCertificationRequest)) {
            return arg1;
        }

        if(arg1 != null) {
            return new TaggedCertificationRequest(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static TaggedCertificationRequest getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return TaggedCertificationRequest.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartID, this.certificationRequest);
    }
}

