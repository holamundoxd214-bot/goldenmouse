package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OriginatorPublicKey extends ASN1Object {
    private AlgorithmIdentifier algorithm;
    private ASN1BitString publicKey;

    private OriginatorPublicKey(ASN1Sequence arg2) {
        super();
        this.algorithm = AlgorithmIdentifier.getInstance(arg2.getObjectAt(0));
        this.publicKey = arg2.getObjectAt(1);
    }

    public OriginatorPublicKey(AlgorithmIdentifier arg1, ASN1BitString arg2) {
        super();
        this.algorithm = arg1;
        this.publicKey = arg2;
    }

    public OriginatorPublicKey(AlgorithmIdentifier arg1, byte[] arg2) {
        super();
        this.algorithm = arg1;
        this.publicKey = new DERBitString(arg2);
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public static OriginatorPublicKey getInstance(ASN1TaggedObject arg1, boolean arg2) {
        return new OriginatorPublicKey(ASN1Sequence.getInstance(arg1, arg2));
    }

    public static OriginatorPublicKey getInstance(Object arg1) {
        if((arg1 instanceof OriginatorPublicKey)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OriginatorPublicKey(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public DERBitString getPublicKey() {
        return DERBitString.convert(this.publicKey);
    }

    public ASN1BitString getPublicKeyData() {
        return this.publicKey;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.algorithm, this.publicKey);
    }
}

