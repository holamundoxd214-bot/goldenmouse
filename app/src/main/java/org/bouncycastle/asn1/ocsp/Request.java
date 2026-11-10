package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;

public class Request extends ASN1Object {
    CertID reqCert;
    Extensions singleRequestExtensions;

    private Request(ASN1Sequence arg3) {
        super();
        this.reqCert = CertID.getInstance(arg3.getObjectAt(0));
        if(arg3.size() == 2) {
            this.singleRequestExtensions = Extensions.getInstance(arg3.getObjectAt(1), true);
        }
    }

    public Request(CertID arg1, Extensions arg2) {
        super();
        this.reqCert = arg1;
        this.singleRequestExtensions = arg2;
    }

    public static Request getInstance(Object arg1) {
        if((arg1 instanceof Request)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Request(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static Request getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return Request.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public CertID getReqCert() {
        return this.reqCert;
    }

    public Extensions getSingleRequestExtensions() {
        return this.singleRequestExtensions;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.reqCert);
        if(this.singleRequestExtensions != null) {
            v0.add(new DERTaggedObject(true, 0, this.singleRequestExtensions));
        }

        return new DERSequence(v0);
    }
}

