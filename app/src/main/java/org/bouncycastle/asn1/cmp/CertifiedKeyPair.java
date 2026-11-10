package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.EncryptedValue;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;

public class CertifiedKeyPair extends ASN1Object {
    private final CertOrEncCert certOrEncCert;
    private EncryptedKey privateKey;
    private PKIPublicationInfo publicationInfo;

    private CertifiedKeyPair(ASN1Sequence arg5) {
        super();
        this.certOrEncCert = CertOrEncCert.getInstance(arg5.getObjectAt(0));
        int v1 = 2;
        if(arg5.size() >= v1) {
            int v3 = 0x80;
            if(arg5.size() == v1) {
                ASN1TaggedObject v5 = ASN1TaggedObject.getInstance(arg5.getObjectAt(1), v3);
                int v0 = v5.getTagNo();
                ASN1Object v5_1 = v5.getExplicitBaseObject();
                if(v0 == 0) {
                    this.privateKey = EncryptedKey.getInstance(v5_1);
                    return;
                }
                else {
                    this.publicationInfo = PKIPublicationInfo.getInstance(v5_1);
                    return;
                }
            }
            else {
                this.privateKey = EncryptedKey.getInstance(ASN1TaggedObject.getInstance(arg5.getObjectAt(1), v3).getExplicitBaseObject());
                this.publicationInfo = PKIPublicationInfo.getInstance(ASN1TaggedObject.getInstance(arg5.getObjectAt(v1), v3).getExplicitBaseObject());
            }
        }
    }

    public CertifiedKeyPair(CertOrEncCert arg3) {
        this(arg3, null, null);
    }

    public CertifiedKeyPair(CertOrEncCert arg1, EncryptedKey arg2, PKIPublicationInfo arg3) {
        super();
        if(arg1 != null) {
            this.certOrEncCert = arg1;
            this.privateKey = arg2;
            this.publicationInfo = arg3;
            return;
        }

        throw new IllegalArgumentException("\'certOrEncCert\' cannot be null");
    }

    public CertifiedKeyPair(CertOrEncCert arg1, EncryptedValue arg2, PKIPublicationInfo arg3) {
        super();
        if(arg1 != null) {
            this.certOrEncCert = arg1;
            EncryptedKey v1 = arg2 != null ? new EncryptedKey(arg2) : null;
            this.privateKey = v1;
            this.publicationInfo = arg3;
            return;
        }

        throw new IllegalArgumentException("\'certOrEncCert\' cannot be null");
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.certOrEncCert;
    }

    public static CertifiedKeyPair getInstance(Object arg1) {
        if((arg1 instanceof CertifiedKeyPair)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertifiedKeyPair(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public EncryptedKey getPrivateKey() {
        return this.privateKey;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.publicationInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.certOrEncCert);
        if(this.privateKey != null) {
            v0.add(new DERTaggedObject(true, 0, this.privateKey));
        }

        if(this.publicationInfo != null) {
            v0.add(new DERTaggedObject(true, 1, this.publicationInfo));
        }

        return new DERSequence(v0);
    }
}

