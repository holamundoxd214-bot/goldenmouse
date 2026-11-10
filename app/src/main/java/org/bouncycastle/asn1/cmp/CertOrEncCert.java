package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.EncryptedValue;

public class CertOrEncCert extends ASN1Object implements ASN1Choice {
    private CMPCertificate certificate;
    private EncryptedKey encryptedCert;

    private CertOrEncCert(ASN1TaggedObject arg3) {
        super();
        if(arg3.hasContextTag(0)) {
            this.certificate = CMPCertificate.getInstance(arg3.getExplicitBaseObject());
            return;
        }

        if(arg3.hasContextTag(1)) {
            this.encryptedCert = EncryptedKey.getInstance(arg3.getExplicitBaseObject());
            return;
        }

        throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(arg3));
    }

    public CertOrEncCert(CMPCertificate arg1) {
        super();
        if(arg1 != null) {
            this.certificate = arg1;
            return;
        }

        throw new IllegalArgumentException("\'certificate\' cannot be null");
    }

    public CertOrEncCert(EncryptedKey arg1) {
        super();
        if(arg1 != null) {
            this.encryptedCert = arg1;
            return;
        }

        throw new IllegalArgumentException("\'encryptedCert\' cannot be null");
    }

    public CertOrEncCert(EncryptedValue arg2) {
        super();
        if(arg2 != null) {
            this.encryptedCert = new EncryptedKey(arg2);
            return;
        }

        throw new IllegalArgumentException("\'encryptedCert\' cannot be null");
    }

    public CMPCertificate getCertificate() {
        return this.certificate;
    }

    public EncryptedKey getEncryptedCert() {
        return this.encryptedCert;
    }

    public static CertOrEncCert getInstance(Object arg2) {
        if((arg2 instanceof CertOrEncCert)) {
            return arg2;
        }

        if((arg2 instanceof ASN1TaggedObject)) {
            return new CertOrEncCert(ASN1TaggedObject.getInstance(arg2, 0x80));
        }

        return null;
    }

    public boolean hasEncryptedCertificate() {
        if(this.encryptedCert != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        if(this.certificate != null) {
            return new DERTaggedObject(true, 0, this.certificate);
        }

        return new DERTaggedObject(true, 1, this.encryptedCert);
    }
}

