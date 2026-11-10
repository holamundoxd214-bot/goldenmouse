package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OcspResponsesID extends ASN1Object {
    private OcspIdentifier ocspIdentifier;
    private OtherHash ocspRepHash;

    private OcspResponsesID(ASN1Sequence arg4) {
        super();
        if(arg4.size() >= 1 && arg4.size() <= 2) {
            this.ocspIdentifier = OcspIdentifier.getInstance(arg4.getObjectAt(0));
            if(arg4.size() > 1) {
                this.ocspRepHash = OtherHash.getInstance(arg4.getObjectAt(1));
            }

            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
    }

    public OcspResponsesID(OcspIdentifier arg2) {
        this(arg2, null);
    }

    public OcspResponsesID(OcspIdentifier arg1, OtherHash arg2) {
        super();
        this.ocspIdentifier = arg1;
        this.ocspRepHash = arg2;
    }

    public static OcspResponsesID getInstance(Object arg1) {
        if((arg1 instanceof OcspResponsesID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OcspResponsesID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OcspIdentifier getOcspIdentifier() {
        return this.ocspIdentifier;
    }

    public OtherHash getOcspRepHash() {
        return this.ocspRepHash;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.ocspIdentifier);
        OtherHash v2 = this.ocspRepHash;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

