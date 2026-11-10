package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OCSPRequest extends ASN1Object {
    Signature optionalSignature;
    TBSRequest tbsRequest;

    private OCSPRequest(ASN1Sequence arg3) {
        super();
        this.tbsRequest = TBSRequest.getInstance(arg3.getObjectAt(0));
        if(arg3.size() == 2) {
            this.optionalSignature = Signature.getInstance(arg3.getObjectAt(1), true);
        }
    }

    public OCSPRequest(TBSRequest arg1, Signature arg2) {
        super();
        this.tbsRequest = arg1;
        this.optionalSignature = arg2;
    }

    public static OCSPRequest getInstance(Object arg1) {
        if((arg1 instanceof OCSPRequest)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OCSPRequest(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static OCSPRequest getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return OCSPRequest.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public Signature getOptionalSignature() {
        return this.optionalSignature;
    }

    public TBSRequest getTbsRequest() {
        return this.tbsRequest;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.tbsRequest);
        if(this.optionalSignature != null) {
            v0.add(new DERTaggedObject(true, 0, this.optionalSignature));
        }

        return new DERSequence(v0);
    }
}

