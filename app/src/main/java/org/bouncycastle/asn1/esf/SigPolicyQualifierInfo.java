package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SigPolicyQualifierInfo extends ASN1Object {
    private ASN1ObjectIdentifier sigPolicyQualifierId;
    private ASN1Encodable sigQualifier;

    public SigPolicyQualifierInfo(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.sigPolicyQualifierId = arg1;
        this.sigQualifier = arg2;
    }

    private SigPolicyQualifierInfo(ASN1Sequence arg2) {
        super();
        this.sigPolicyQualifierId = ASN1ObjectIdentifier.getInstance(arg2.getObjectAt(0));
        this.sigQualifier = arg2.getObjectAt(1);
    }

    public static SigPolicyQualifierInfo getInstance(Object arg1) {
        if((arg1 instanceof SigPolicyQualifierInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SigPolicyQualifierInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1ObjectIdentifier getSigPolicyQualifierId() {
        return new ASN1ObjectIdentifier(this.sigPolicyQualifierId.getId());
    }

    public ASN1Encodable getSigQualifier() {
        return this.sigQualifier;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.sigPolicyQualifierId);
        v0.add(this.sigQualifier);
        return new DERSequence(v0);
    }
}

