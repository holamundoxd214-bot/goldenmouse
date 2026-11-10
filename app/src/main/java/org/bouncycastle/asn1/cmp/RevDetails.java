package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class RevDetails extends ASN1Object {
    private final CertTemplate certDetails;
    private Extensions crlEntryDetails;

    private RevDetails(ASN1Sequence arg3) {
        super();
        this.certDetails = CertTemplate.getInstance(arg3.getObjectAt(0));
        if(arg3.size() > 1) {
            this.crlEntryDetails = Extensions.getInstance(arg3.getObjectAt(1));
        }
    }

    public RevDetails(CertTemplate arg1) {
        super();
        this.certDetails = arg1;
    }

    public RevDetails(CertTemplate arg1, Extensions arg2) {
        super();
        this.certDetails = arg1;
        this.crlEntryDetails = arg2;
    }

    public RevDetails(CertTemplate arg1, X509Extensions arg2) {
        super();
        this.certDetails = arg1;
        this.crlEntryDetails = Extensions.getInstance(arg2.toASN1Primitive());
    }

    public CertTemplate getCertDetails() {
        return this.certDetails;
    }

    public Extensions getCrlEntryDetails() {
        return this.crlEntryDetails;
    }

    public static RevDetails getInstance(Object arg1) {
        if((arg1 instanceof RevDetails)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevDetails(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.certDetails);
        Extensions v2 = this.crlEntryDetails;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

