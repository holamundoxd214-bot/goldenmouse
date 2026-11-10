package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SigPolicyQualifiers extends ASN1Object {
    ASN1Sequence qualifiers;

    private SigPolicyQualifiers(ASN1Sequence arg1) {
        super();
        this.qualifiers = arg1;
    }

    public SigPolicyQualifiers(SigPolicyQualifierInfo[] arg2) {
        super();
        this.qualifiers = new DERSequence(((ASN1Encodable[])arg2));
    }

    public SigPolicyQualifierInfo getInfoAt(int arg1) {
        return SigPolicyQualifierInfo.getInstance(this.qualifiers.getObjectAt(arg1));
    }

    public static SigPolicyQualifiers getInstance(Object arg1) {
        if((arg1 instanceof SigPolicyQualifiers)) {
            return arg1;
        }

        if((arg1 instanceof ASN1Sequence)) {
            return new SigPolicyQualifiers(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public int size() {
        return this.qualifiers.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.qualifiers;
    }
}

