package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CrlValidatedID extends ASN1Object {
    private OtherHash crlHash;
    private CrlIdentifier crlIdentifier;

    private CrlValidatedID(ASN1Sequence arg4) {
        super();
        if(arg4.size() >= 1 && arg4.size() <= 2) {
            this.crlHash = OtherHash.getInstance(arg4.getObjectAt(0));
            if(arg4.size() > 1) {
                this.crlIdentifier = CrlIdentifier.getInstance(arg4.getObjectAt(1));
            }

            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
    }

    public CrlValidatedID(OtherHash arg2) {
        this(arg2, null);
    }

    public CrlValidatedID(OtherHash arg1, CrlIdentifier arg2) {
        super();
        this.crlHash = arg1;
        this.crlIdentifier = arg2;
    }

    public OtherHash getCrlHash() {
        return this.crlHash;
    }

    public CrlIdentifier getCrlIdentifier() {
        return this.crlIdentifier;
    }

    public static CrlValidatedID getInstance(Object arg1) {
        if((arg1 instanceof CrlValidatedID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CrlValidatedID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.crlHash.toASN1Primitive());
        CrlIdentifier v2 = this.crlIdentifier;
        if(v2 != null) {
            v0.add(v2.toASN1Primitive());
        }

        return new DERSequence(v0);
    }
}

