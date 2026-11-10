package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class SignerInfo extends ASN1Object {
    private ASN1Set authenticatedAttributes;
    private AlgorithmIdentifier digAlgorithm;
    private AlgorithmIdentifier digEncryptionAlgorithm;
    private ASN1OctetString encryptedDigest;
    private IssuerAndSerialNumber issuerAndSerialNumber;
    private ASN1Set unauthenticatedAttributes;
    private ASN1Integer version;

    public SignerInfo(ASN1Integer arg1, IssuerAndSerialNumber arg2, AlgorithmIdentifier arg3, ASN1Set arg4, AlgorithmIdentifier arg5, ASN1OctetString arg6, ASN1Set arg7) {
        super();
        this.version = arg1;
        this.issuerAndSerialNumber = arg2;
        this.digAlgorithm = arg3;
        this.authenticatedAttributes = arg4;
        this.digEncryptionAlgorithm = arg5;
        this.encryptedDigest = arg6;
        this.unauthenticatedAttributes = arg7;
    }

    public SignerInfo(ASN1Sequence arg5) {
        super();
        Enumeration v5 = arg5.getObjects();
        this.version = v5.nextElement();
        this.issuerAndSerialNumber = IssuerAndSerialNumber.getInstance(v5.nextElement());
        this.digAlgorithm = AlgorithmIdentifier.getInstance(v5.nextElement());
        Object v0 = v5.nextElement();
        ASN1Set v3 = null;
        if((v0 instanceof ASN1TaggedObject)) {
            this.authenticatedAttributes = ASN1Set.getInstance(((ASN1TaggedObject)v0), false);
            v0 = v5.nextElement();
        }
        else {
            this.authenticatedAttributes = v3;
        }

        this.digEncryptionAlgorithm = AlgorithmIdentifier.getInstance(v0);
        this.encryptedDigest = DEROctetString.getInstance(v5.nextElement());
        if(v5.hasMoreElements()) {
            this.unauthenticatedAttributes = ASN1Set.getInstance(v5.nextElement(), false);
            return;
        }

        this.unauthenticatedAttributes = v3;
    }

    public ASN1Set getAuthenticatedAttributes() {
        return this.authenticatedAttributes;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digAlgorithm;
    }

    public AlgorithmIdentifier getDigestEncryptionAlgorithm() {
        return this.digEncryptionAlgorithm;
    }

    public ASN1OctetString getEncryptedDigest() {
        return this.encryptedDigest;
    }

    public static SignerInfo getInstance(Object arg3) {
        if((arg3 instanceof SignerInfo)) {
            return arg3;
        }

        if((arg3 instanceof ASN1Sequence)) {
            return new SignerInfo(((ASN1Sequence)arg3));
        }

        throw new IllegalArgumentException("unknown object in factory: " + arg3.getClass().getName());
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerAndSerialNumber;
    }

    public ASN1Set getUnauthenticatedAttributes() {
        return this.unauthenticatedAttributes;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(7);
        v0.add(this.version);
        v0.add(this.issuerAndSerialNumber);
        v0.add(this.digAlgorithm);
        if(this.authenticatedAttributes != null) {
            v0.add(new DERTaggedObject(false, 0, this.authenticatedAttributes));
        }

        v0.add(this.digEncryptionAlgorithm);
        v0.add(this.encryptedDigest);
        if(this.unauthenticatedAttributes != null) {
            v0.add(new DERTaggedObject(false, 1, this.unauthenticatedAttributes));
        }

        return new DERSequence(v0);
    }
}

