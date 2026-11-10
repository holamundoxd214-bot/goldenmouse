package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.CertificateList;

public class CRLAnnContent extends ASN1Object {
    private final ASN1Sequence content;

    private CRLAnnContent(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public CRLAnnContent(CertificateList arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable)arg2));
    }

    public CertificateList[] getCertificateLists() {
        int v0 = this.content.size();
        CertificateList[] v1 = new CertificateList[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = CertificateList.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }

    public static CRLAnnContent getInstance(Object arg1) {
        if((arg1 instanceof CRLAnnContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CRLAnnContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }
}

