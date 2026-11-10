package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class PopLinkWitnessV2 extends ASN1Object {
    private final AlgorithmIdentifier keyGenAlgorithm;
    private final AlgorithmIdentifier macAlgorithm;
    private final byte[] witness;

    private PopLinkWitnessV2(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.keyGenAlgorithm = AlgorithmIdentifier.getInstance(arg3.getObjectAt(0));
            this.macAlgorithm = AlgorithmIdentifier.getInstance(arg3.getObjectAt(1));
            this.witness = Arrays.clone(ASN1OctetString.getInstance(arg3.getObjectAt(2)).getOctets());
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public PopLinkWitnessV2(AlgorithmIdentifier arg1, AlgorithmIdentifier arg2, byte[] arg3) {
        super();
        this.keyGenAlgorithm = arg1;
        this.macAlgorithm = arg2;
        this.witness = Arrays.clone(arg3);
    }

    public static PopLinkWitnessV2 getInstance(Object arg1) {
        if((arg1 instanceof PopLinkWitnessV2)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PopLinkWitnessV2(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getKeyGenAlgorithm() {
        return this.keyGenAlgorithm;
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.keyGenAlgorithm);
        v0.add(this.macAlgorithm);
        v0.add(new DEROctetString(this.getWitness()));
        return new DERSequence(v0);
    }
}

