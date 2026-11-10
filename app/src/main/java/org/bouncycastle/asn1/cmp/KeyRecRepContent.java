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

public class KeyRecRepContent extends ASN1Object {
    private ASN1Sequence caCerts;
    private ASN1Sequence keyPairHist;
    private CMPCertificate newSigCert;
    private final PKIStatusInfo status;

    private KeyRecRepContent(ASN1Sequence arg4) {
        super();
        Enumeration v4 = arg4.getObjects();
        this.status = PKIStatusInfo.getInstance(v4.nextElement());
        while(v4.hasMoreElements()) {
            ASN1TaggedObject v0 = ASN1TaggedObject.getInstance(v4.nextElement(), 0x80);
            int v1 = v0.getTagNo();
            if(v1 != 0) {
                if(v1 != 1) {
                    if(v1 == 2) {
                        this.keyPairHist = ASN1Sequence.getInstance(v0.getExplicitBaseObject());
                        continue;
                    }

                    throw new IllegalArgumentException("unknown tag number: " + v0.getTagNo());
                }

                this.caCerts = ASN1Sequence.getInstance(v0.getExplicitBaseObject());
                continue;
            }

            this.newSigCert = CMPCertificate.getInstance(v0.getExplicitBaseObject());
        }
    }

    private void addOptional(ASN1EncodableVector arg2, int arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg2.add(new DERTaggedObject(true, arg3, arg4));
        }
    }

    public CMPCertificate[] getCaCerts() {
        ASN1Sequence v0 = this.caCerts;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        CMPCertificate[] v1 = new CMPCertificate[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = CMPCertificate.getInstance(this.caCerts.getObjectAt(v2));
        }

        return v1;
    }

    public static KeyRecRepContent getInstance(Object arg1) {
        if((arg1 instanceof KeyRecRepContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new KeyRecRepContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public CertifiedKeyPair[] getKeyPairHist() {
        ASN1Sequence v0 = this.keyPairHist;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        CertifiedKeyPair[] v1 = new CertifiedKeyPair[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = CertifiedKeyPair.getInstance(this.keyPairHist.getObjectAt(v2));
        }

        return v1;
    }

    public CMPCertificate getNewSigCert() {
        return this.newSigCert;
    }

    public PKIStatusInfo getStatus() {
        return this.status;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.status);
        this.addOptional(v0, 0, this.newSigCert);
        this.addOptional(v0, 1, this.caCerts);
        this.addOptional(v0, 2, this.keyPairHist);
        return new DERSequence(v0);
    }
}

