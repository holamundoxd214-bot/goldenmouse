package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extensions;

public class CertTemplateBuilder {
    private Extensions extensions;
    private X500Name issuer;
    private DERBitString issuerUID;
    private SubjectPublicKeyInfo publicKey;
    private ASN1Integer serialNumber;
    private AlgorithmIdentifier signingAlg;
    private X500Name subject;
    private DERBitString subjectUID;
    private OptionalValidity validity;
    private ASN1Integer version;

    public CertTemplateBuilder() {
        super();
    }

    private void addOptional(ASN1EncodableVector arg1, int arg2, boolean arg3, ASN1Encodable arg4) {
        if(arg4 != null) {
            arg1.add(new DERTaggedObject(arg3, arg2, arg4));
        }
    }

    public CertTemplate build() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(10);
        this.addOptional(v0, 0, false, this.version);
        this.addOptional(v0, 1, false, this.serialNumber);
        this.addOptional(v0, 2, false, this.signingAlg);
        this.addOptional(v0, 3, true, this.issuer);
        this.addOptional(v0, 4, false, this.validity);
        this.addOptional(v0, 5, true, this.subject);
        this.addOptional(v0, 6, false, this.publicKey);
        this.addOptional(v0, 7, false, this.issuerUID);
        this.addOptional(v0, 8, false, this.subjectUID);
        this.addOptional(v0, 9, false, this.extensions);
        return CertTemplate.getInstance(new DERSequence(v0));
    }

    public CertTemplateBuilder setExtensions(Extensions arg1) {
        this.extensions = arg1;
        return this;
    }

    public CertTemplateBuilder setExtensions(X509Extensions arg1) {
        return this.setExtensions(Extensions.getInstance(arg1));
    }

    public CertTemplateBuilder setIssuer(X500Name arg1) {
        this.issuer = arg1;
        return this;
    }

    public CertTemplateBuilder setIssuerUID(DERBitString arg1) {
        this.issuerUID = arg1;
        return this;
    }

    public CertTemplateBuilder setPublicKey(SubjectPublicKeyInfo arg1) {
        this.publicKey = arg1;
        return this;
    }

    public CertTemplateBuilder setSerialNumber(ASN1Integer arg1) {
        this.serialNumber = arg1;
        return this;
    }

    public CertTemplateBuilder setSigningAlg(AlgorithmIdentifier arg1) {
        this.signingAlg = arg1;
        return this;
    }

    public CertTemplateBuilder setSubject(X500Name arg1) {
        this.subject = arg1;
        return this;
    }

    public CertTemplateBuilder setSubjectUID(DERBitString arg1) {
        this.subjectUID = arg1;
        return this;
    }

    public CertTemplateBuilder setValidity(OptionalValidity arg1) {
        this.validity = arg1;
        return this;
    }

    public CertTemplateBuilder setVersion(int arg4) {
        this.version = new ASN1Integer(((long)arg4));
        return this;
    }
}

