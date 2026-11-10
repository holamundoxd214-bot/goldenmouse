package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.ResponderID;

public class OcspIdentifier extends ASN1Object {
    private ResponderID ocspResponderID;
    private ASN1GeneralizedTime producedAt;

    private OcspIdentifier(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.ocspResponderID = ResponderID.getInstance(arg3.getObjectAt(0));
            this.producedAt = arg3.getObjectAt(1);
            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg3.size());
    }

    public OcspIdentifier(ResponderID arg1, ASN1GeneralizedTime arg2) {
        super();
        this.ocspResponderID = arg1;
        this.producedAt = arg2;
    }

    public static OcspIdentifier getInstance(Object arg1) {
        if((arg1 instanceof OcspIdentifier)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OcspIdentifier(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ResponderID getOcspResponderID() {
        return this.ocspResponderID;
    }

    public ASN1GeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.ocspResponderID, this.producedAt);
    }
}

