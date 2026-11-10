package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CommitmentTypeQualifier extends ASN1Object {
    private ASN1ObjectIdentifier commitmentTypeIdentifier;
    private ASN1Encodable qualifier;

    public CommitmentTypeQualifier(ASN1ObjectIdentifier arg2) {
        this(arg2, null);
    }

    public CommitmentTypeQualifier(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.commitmentTypeIdentifier = arg1;
        this.qualifier = arg2;
    }

    private CommitmentTypeQualifier(ASN1Sequence arg3) {
        super();
        this.commitmentTypeIdentifier = arg3.getObjectAt(0);
        if(arg3.size() > 1) {
            this.qualifier = arg3.getObjectAt(1);
        }
    }

    public ASN1ObjectIdentifier getCommitmentTypeIdentifier() {
        return this.commitmentTypeIdentifier;
    }

    public static CommitmentTypeQualifier getInstance(Object arg1) {
        if((arg1 instanceof CommitmentTypeQualifier)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CommitmentTypeQualifier(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Encodable getQualifier() {
        return this.qualifier;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.commitmentTypeIdentifier);
        ASN1Encodable v2 = this.qualifier;
        if(v2 != null) {
            v0.add(v2);
        }

        return new DERSequence(v0);
    }
}

