package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CommitmentTypeIndication extends ASN1Object {
    private ASN1ObjectIdentifier commitmentTypeId;
    private ASN1Sequence commitmentTypeQualifier;

    public CommitmentTypeIndication(ASN1ObjectIdentifier arg1) {
        super();
        this.commitmentTypeId = arg1;
    }

    public CommitmentTypeIndication(ASN1ObjectIdentifier arg1, ASN1Sequence arg2) {
        super();
        this.commitmentTypeId = arg1;
        this.commitmentTypeQualifier = arg2;
    }

    private CommitmentTypeIndication(ASN1Sequence arg3) {
        super();
        this.commitmentTypeId = arg3.getObjectAt(0);
        if(arg3.size() > 1) {
            this.commitmentTypeQualifier = arg3.getObjectAt(1);
        }
    }

    public ASN1ObjectIdentifier getCommitmentTypeId() {
        return this.commitmentTypeId;
    }

    public ASN1Sequence getCommitmentTypeQualifier() {
        return this.commitmentTypeQualifier;
    }

    public static CommitmentTypeIndication getInstance(Object arg1) {
        if(arg1 != null) {
            if((arg1 instanceof CommitmentTypeIndication)) {
            }
            else {
                return new CommitmentTypeIndication(ASN1Sequence.getInstance(arg1));
            }
        }

        return arg1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.commitmentTypeId);
        ASN1Sequence v2 = this.commitmentTypeQualifier;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

