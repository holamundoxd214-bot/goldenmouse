package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHashAlgAndValue extends ASN1Object {
    private AlgorithmIdentifier hashAlgorithm;
    private ASN1OctetString hashValue;

    private OtherHashAlgAndValue(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.hashAlgorithm = AlgorithmIdentifier.getInstance(arg3.getObjectAt(0));
            this.hashValue = ASN1OctetString.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg3.size());
    }

    public OtherHashAlgAndValue(AlgorithmIdentifier arg1, ASN1OctetString arg2) {
        super();
        this.hashAlgorithm = arg1;
        this.hashValue = arg2;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ASN1OctetString getHashValue() {
        return this.hashValue;
    }

    public static OtherHashAlgAndValue getInstance(Object arg1) {
        if((arg1 instanceof OtherHashAlgAndValue)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherHashAlgAndValue(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.hashAlgorithm);
        v0.add(this.hashValue);
        return new DERSequence(v0);
    }
}

