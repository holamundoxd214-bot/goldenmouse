package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class Signature extends ASN1Object {
    ASN1Sequence certs;
    DERBitString signature;
    AlgorithmIdentifier signatureAlgorithm;

    private Signature(ASN1Sequence arg4) {
        super();
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(arg4.getObjectAt(0));
        this.signature = arg4.getObjectAt(1);
        if(arg4.size() == 3) {
            this.certs = ASN1Sequence.getInstance(arg4.getObjectAt(2), true);
        }
    }

    public Signature(AlgorithmIdentifier arg1, DERBitString arg2) {
        super();
        this.signatureAlgorithm = arg1;
        this.signature = arg2;
    }

    public Signature(AlgorithmIdentifier arg1, DERBitString arg2, ASN1Sequence arg3) {
        super();
        this.signatureAlgorithm = arg1;
        this.signature = arg2;
        this.certs = arg3;
    }

    public ASN1Sequence getCerts() {
        return this.certs;
    }

    public static Signature getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return Signature.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static Signature getInstance(Object arg1) {
        if((arg1 instanceof Signature)) {
            return arg1;
        }

        if(arg1 != null) {
            return new Signature(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public DERBitString getSignature() {
        return this.signature;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.signatureAlgorithm);
        v0.add(this.signature);
        if(this.certs != null) {
            v0.add(new DERTaggedObject(true, 0, this.certs));
        }

        return new DERSequence(v0);
    }
}

