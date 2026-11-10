package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.CRLReason;

public class RevokedInfo extends ASN1Object {
    private CRLReason revocationReason;
    private ASN1GeneralizedTime revocationTime;

    public RevokedInfo(ASN1GeneralizedTime arg2) {
        this(arg2, null);
    }

    public RevokedInfo(ASN1GeneralizedTime arg1, CRLReason arg2) {
        super();
        this.revocationTime = arg1;
        this.revocationReason = arg2;
    }

    private RevokedInfo(ASN1Sequence arg3) {
        super();
        this.revocationTime = ASN1GeneralizedTime.getInstance(arg3.getObjectAt(0));
        if(arg3.size() > 1) {
            this.revocationReason = CRLReason.getInstance(ASN1Enumerated.getInstance(arg3.getObjectAt(1), true));
        }
    }

    public static RevokedInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return RevokedInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static RevokedInfo getInstance(Object arg1) {
        if((arg1 instanceof RevokedInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevokedInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CRLReason getRevocationReason() {
        return this.revocationReason;
    }

    public ASN1GeneralizedTime getRevocationTime() {
        return this.revocationTime;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.revocationTime);
        if(this.revocationReason != null) {
            v0.add(new DERTaggedObject(true, 0, this.revocationReason));
        }

        return new DERSequence(v0);
    }
}

