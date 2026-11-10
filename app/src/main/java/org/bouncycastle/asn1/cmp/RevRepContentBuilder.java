package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.CertificateList;

public class RevRepContentBuilder {
    private final ASN1EncodableVector crls;
    private final ASN1EncodableVector revCerts;
    private final ASN1EncodableVector status;

    public RevRepContentBuilder() {
        super();
        this.status = new ASN1EncodableVector();
        this.revCerts = new ASN1EncodableVector();
        this.crls = new ASN1EncodableVector();
    }

    public RevRepContentBuilder add(PKIStatusInfo arg2) {
        this.status.add(((ASN1Encodable)arg2));
        return this;
    }

    public RevRepContentBuilder add(PKIStatusInfo arg3, CertId arg4) {
        if(this.status.size() == this.revCerts.size()) {
            this.status.add(((ASN1Encodable)arg3));
            this.revCerts.add(((ASN1Encodable)arg4));
            return this;
        }

        throw new IllegalStateException("status and revCerts sequence must be in common order");
    }

    public RevRepContentBuilder addCrl(CertificateList arg2) {
        this.crls.add(((ASN1Encodable)arg2));
        return this;
    }

    public RevRepContent build() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(new DERSequence(this.status));
        if(this.revCerts.size() != 0) {
            v0.add(new DERTaggedObject(true, 0, new DERSequence(this.revCerts)));
        }

        if(this.crls.size() != 0) {
            v0.add(new DERTaggedObject(true, 1, new DERSequence(this.crls)));
        }

        return RevRepContent.getInstance(new DERSequence(v0));
    }
}

