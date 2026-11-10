package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.ReasonFlags;

public class GetCRL extends ASN1Object {
    private GeneralName cRLName;
    private final X500Name issuerName;
    private ReasonFlags reasons;
    private ASN1GeneralizedTime time;

    private GetCRL(ASN1Sequence arg4) {
        super();
        int v1 = 1;
        if(arg4.size() >= 1 && arg4.size() <= 4) {
            this.issuerName = X500Name.getInstance(arg4.getObjectAt(0));
            if(arg4.size() > 1 && ((arg4.getObjectAt(1).toASN1Primitive() instanceof ASN1TaggedObject))) {
                this.cRLName = GeneralName.getInstance(arg4.getObjectAt(1));
                v1 = 2;
            }

            if(arg4.size() > v1 && ((arg4.getObjectAt(v1).toASN1Primitive() instanceof ASN1GeneralizedTime))) {
                this.time = ASN1GeneralizedTime.getInstance(arg4.getObjectAt(v1));
                ++v1;
            }

            if(arg4.size() > v1 && ((arg4.getObjectAt(v1).toASN1Primitive() instanceof ASN1BitString))) {
                this.reasons = new ReasonFlags(ASN1BitString.getInstance(arg4.getObjectAt(v1)));
            }

            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public GetCRL(X500Name arg1, GeneralName arg2, ASN1GeneralizedTime arg3, ReasonFlags arg4) {
        super();
        this.issuerName = arg1;
        this.cRLName = arg2;
        this.time = arg3;
        this.reasons = arg4;
    }

    public static GetCRL getInstance(Object arg1) {
        if((arg1 instanceof GetCRL)) {
            return arg1;
        }

        if(arg1 != null) {
            return new GetCRL(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public X500Name getIssuerName() {
        return this.issuerName;
    }

    public ReasonFlags getReasons() {
        return this.reasons;
    }

    public ASN1GeneralizedTime getTime() {
        return this.time;
    }

    public GeneralName getcRLName() {
        return this.cRLName;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.issuerName);
        GeneralName v1 = this.cRLName;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        ASN1GeneralizedTime v1_1 = this.time;
        if(v1_1 != null) {
            v0.add(((ASN1Encodable)v1_1));
        }

        ReasonFlags v2 = this.reasons;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

