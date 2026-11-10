package org.bouncycastle.asn1.cms;

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
    private SignerIdentifier sid;
    private ASN1Set unauthenticatedAttributes;
    private ASN1Integer version;

    private SignerInfo(ASN1Sequence arg5) {
        super();
        Enumeration v5 = arg5.getObjects();
        this.version = v5.nextElement();
        this.sid = SignerIdentifier.getInstance(v5.nextElement());
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

    public SignerInfo(SignerIdentifier arg4, AlgorithmIdentifier arg5, ASN1Set arg6, AlgorithmIdentifier arg7, ASN1OctetString arg8, ASN1Set arg9) {
        super();
        ASN1Integer v0 = arg4.isTagged() ? new ASN1Integer(3) : new ASN1Integer(1);
        this.version = v0;
        this.sid = arg4;
        this.digAlgorithm = arg5;
        this.authenticatedAttributes = arg6;
        this.digEncryptionAlgorithm = arg7;
        this.encryptedDigest = arg8;
        this.unauthenticatedAttributes = arg9;
    }

    public SignerInfo(SignerIdentifier arg4, AlgorithmIdentifier arg5, Attributes arg6, AlgorithmIdentifier arg7, ASN1OctetString arg8, Attributes arg9) {
        super();
        ASN1Integer v0 = arg4.isTagged() ? new ASN1Integer(3) : new ASN1Integer(1);
        this.version = v0;
        this.sid = arg4;
        this.digAlgorithm = arg5;
        this.authenticatedAttributes = ASN1Set.getInstance(arg6);
        this.digEncryptionAlgorithm = arg7;
        this.encryptedDigest = arg8;
        this.unauthenticatedAttributes = ASN1Set.getInstance(arg9);
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

    public static SignerInfo getInstance(Object arg1) throws IllegalArgumentException {
        if((arg1 instanceof SignerInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SignerInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public SignerIdentifier getSID() {
        return this.sid;
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
        v0.add(this.sid);
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

