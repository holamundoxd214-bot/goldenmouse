package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OCSPResponse extends ASN1Object {
    ResponseBytes responseBytes;
    OCSPResponseStatus responseStatus;

    private OCSPResponse(ASN1Sequence arg3) {
        super();
        this.responseStatus = OCSPResponseStatus.getInstance(arg3.getObjectAt(0));
        if(arg3.size() == 2) {
            this.responseBytes = ResponseBytes.getInstance(arg3.getObjectAt(1), true);
        }
    }

    public OCSPResponse(OCSPResponseStatus arg1, ResponseBytes arg2) {
        super();
        this.responseStatus = arg1;
        this.responseBytes = arg2;
    }

    public static OCSPResponse getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return OCSPResponse.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static OCSPResponse getInstance(Object arg1) {
        if((arg1 instanceof OCSPResponse)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OCSPResponse(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ResponseBytes getResponseBytes() {
        return this.responseBytes;
    }

    public OCSPResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.responseStatus);
        if(this.responseBytes != null) {
            v0.add(new DERTaggedObject(true, 0, this.responseBytes));
        }

        return new DERSequence(v0);
    }
}

