package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.CertificateList;

public class RevRepContent extends ASN1Object {
    private ASN1Sequence crls;
    private ASN1Sequence revCerts;
    private final ASN1Sequence status;

    private RevRepContent(ASN1Sequence arg4) {
        super();
        Enumeration v4 = arg4.getObjects();
        this.status = ASN1Sequence.getInstance(v4.nextElement());
        while(v4.hasMoreElements()) {
            ASN1TaggedObject v0 = ASN1TaggedObject.getInstance(v4.nextElement());
            if(v0.hasContextTag(0)) {
                this.revCerts = ASN1Sequence.getInstance(v0, true);
                continue;
            }

            if(!v0.hasContextTag(1)) {
                continue;
            }

            this.crls = ASN1Sequence.getInstance(v0, true);
        }
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public CertificateList[] getCrls() {
        ASN1Sequence v0 = this.crls;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        CertificateList[] v1 = new CertificateList[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = CertificateList.getInstance(this.crls.getObjectAt(v2));
        }

        return v1;
    }

    public static RevRepContent getInstance(Object arg1) {
        if((arg1 instanceof RevRepContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevRepContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CertId[] getRevCerts() {
        ASN1Sequence v0 = this.revCerts;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        CertId[] v1 = new CertId[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = CertId.getInstance(this.revCerts.getObjectAt(v2));
        }

        return v1;
    }

    public PKIStatusInfo[] getStatus() {
        int v0 = this.status.size();
        PKIStatusInfo[] v1 = new PKIStatusInfo[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = PKIStatusInfo.getInstance(this.status.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.status);
        this.addOptional(v0, 0, this.revCerts);
        this.addOptional(v0, 1, this.crls);
        return new DERSequence(v0);
    }
}

