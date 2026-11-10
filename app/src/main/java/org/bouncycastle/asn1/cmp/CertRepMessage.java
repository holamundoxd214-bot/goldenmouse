package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertRepMessage extends ASN1Object {
    private final ASN1Sequence caPubs;
    private final ASN1Sequence response;

    private CertRepMessage(ASN1Sequence arg4) {
        super();
        int v1 = 0;
        if(arg4.size() > 1) {
            this.caPubs = ASN1Sequence.getInstance(arg4.getObjectAt(0), true);
            v1 = 1;
        }
        else {
            this.caPubs = null;
        }

        this.response = ASN1Sequence.getInstance(arg4.getObjectAt(v1));
    }

    public CertRepMessage(CMPCertificate[] arg2, CertResponse[] arg3) {
        super();
        if(arg3 != null) {
            this.caPubs = arg2 == null || arg2.length == 0 ? null : new DERSequence(((ASN1Encodable[])arg2));
            this.response = new DERSequence(((ASN1Encodable[])arg3));
            return;
        }

        throw new IllegalArgumentException("\'response\' cannot be null");
    }

    public CMPCertificate[] getCaPubs() {
        ASN1Sequence v0 = this.caPubs;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        CMPCertificate[] v1 = new CMPCertificate[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = CMPCertificate.getInstance(this.caPubs.getObjectAt(v2));
        }

        return v1;
    }

    public static CertRepMessage getInstance(Object arg1) {
        if((arg1 instanceof CertRepMessage)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertRepMessage(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CertResponse[] getResponse() {
        int v0 = this.response.size();
        CertResponse[] v1 = new CertResponse[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = CertResponse.getInstance(this.response.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        if(this.caPubs != null) {
            v0.add(new DERTaggedObject(true, 1, this.caPubs));
        }

        v0.add(this.response);
        return new DERSequence(v0);
    }
}

