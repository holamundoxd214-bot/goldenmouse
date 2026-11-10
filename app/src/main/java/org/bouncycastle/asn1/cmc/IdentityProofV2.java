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

public class IdentityProofV2 extends ASN1Object {
    private final AlgorithmIdentifier macAlgId;
    private final AlgorithmIdentifier proofAlgID;
    private final byte[] witness;

    private IdentityProofV2(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.proofAlgID = AlgorithmIdentifier.getInstance(arg3.getObjectAt(0));
            this.macAlgId = AlgorithmIdentifier.getInstance(arg3.getObjectAt(1));
            this.witness = Arrays.clone(ASN1OctetString.getInstance(arg3.getObjectAt(2)).getOctets());
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public IdentityProofV2(AlgorithmIdentifier arg1, AlgorithmIdentifier arg2, byte[] arg3) {
        super();
        this.proofAlgID = arg1;
        this.macAlgId = arg2;
        this.witness = Arrays.clone(arg3);
    }

    public static IdentityProofV2 getInstance(Object arg1) {
        if((arg1 instanceof IdentityProofV2)) {
            return arg1;
        }

        if(arg1 != null) {
            return new IdentityProofV2(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public AlgorithmIdentifier getMacAlgId() {
        return this.macAlgId;
    }

    public AlgorithmIdentifier getProofAlgID() {
        return this.proofAlgID;
    }

    public byte[] getWitness() {
        return Arrays.clone(this.witness);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.proofAlgID);
        v0.add(this.macAlgId);
        v0.add(new DEROctetString(this.getWitness()));
        return new DERSequence(v0);
    }
}

