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

public class DecryptedPOP extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final byte[] thePOP;
    private final AlgorithmIdentifier thePOPAlgID;

    private DecryptedPOP(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.bodyPartID = BodyPartID.getInstance(arg3.getObjectAt(0));
            this.thePOPAlgID = AlgorithmIdentifier.getInstance(arg3.getObjectAt(1));
            this.thePOP = Arrays.clone(ASN1OctetString.getInstance(arg3.getObjectAt(2)).getOctets());
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public DecryptedPOP(BodyPartID arg1, AlgorithmIdentifier arg2, byte[] arg3) {
        super();
        this.bodyPartID = arg1;
        this.thePOPAlgID = arg2;
        this.thePOP = Arrays.clone(arg3);
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public static DecryptedPOP getInstance(Object arg1) {
        if((arg1 instanceof DecryptedPOP)) {
            return arg1;
        }

        if(arg1 != null) {
            return new DecryptedPOP(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public byte[] getThePOP() {
        return Arrays.clone(this.thePOP);
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.thePOPAlgID;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.bodyPartID);
        v0.add(this.thePOPAlgID);
        v0.add(new DEROctetString(this.thePOP));
        return new DERSequence(v0);
    }
}

