package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SignaturePolicyId extends ASN1Object {
    private OtherHashAlgAndValue sigPolicyHash;
    private ASN1ObjectIdentifier sigPolicyId;
    private SigPolicyQualifiers sigPolicyQualifiers;

    public SignaturePolicyId(ASN1ObjectIdentifier arg2, OtherHashAlgAndValue arg3) {
        this(arg2, arg3, null);
    }

    public SignaturePolicyId(ASN1ObjectIdentifier arg1, OtherHashAlgAndValue arg2, SigPolicyQualifiers arg3) {
        super();
        this.sigPolicyId = arg1;
        this.sigPolicyHash = arg2;
        this.sigPolicyQualifiers = arg3;
    }

    private SignaturePolicyId(ASN1Sequence arg4) {
        super();
        int v1 = 3;
        int v2 = 2;
        if(arg4.size() != v2) {
            if(arg4.size() == v1) {
            }
            else {
                throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
            }
        }

        this.sigPolicyId = ASN1ObjectIdentifier.getInstance(arg4.getObjectAt(0));
        this.sigPolicyHash = OtherHashAlgAndValue.getInstance(arg4.getObjectAt(1));
        if(arg4.size() == v1) {
            this.sigPolicyQualifiers = SigPolicyQualifiers.getInstance(arg4.getObjectAt(v2));
        }
    }

    public static SignaturePolicyId getInstance(Object arg1) {
        if((arg1 instanceof SignaturePolicyId)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SignaturePolicyId(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OtherHashAlgAndValue getSigPolicyHash() {
        return this.sigPolicyHash;
    }

    public ASN1ObjectIdentifier getSigPolicyId() {
        return new ASN1ObjectIdentifier(this.sigPolicyId.getId());
    }

    public SigPolicyQualifiers getSigPolicyQualifiers() {
        return this.sigPolicyQualifiers;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.sigPolicyId);
        v0.add(this.sigPolicyHash);
        SigPolicyQualifiers v2 = this.sigPolicyQualifiers;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

