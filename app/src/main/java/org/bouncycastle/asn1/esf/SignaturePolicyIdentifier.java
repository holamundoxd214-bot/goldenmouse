package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;

public class SignaturePolicyIdentifier extends ASN1Object {
    private boolean isSignaturePolicyImplied;
    private SignaturePolicyId signaturePolicyId;

    public SignaturePolicyIdentifier() {
        super();
        this.isSignaturePolicyImplied = true;
    }

    public SignaturePolicyIdentifier(SignaturePolicyId arg1) {
        super();
        this.signaturePolicyId = arg1;
        this.isSignaturePolicyImplied = false;
    }

    public static SignaturePolicyIdentifier getInstance(Object arg1) {
        if((arg1 instanceof SignaturePolicyIdentifier)) {
            return arg1;
        }

        if(!(arg1 instanceof ASN1Null)) {
            if(SignaturePolicyIdentifier.hasEncodedTagValue(arg1, 5)) {
            }
            else if(arg1 != null) {
                return new SignaturePolicyIdentifier(SignaturePolicyId.getInstance(arg1));
            }
            else {
                return null;
            }
        }

        return new SignaturePolicyIdentifier();
    }

    public SignaturePolicyId getSignaturePolicyId() {
        return this.signaturePolicyId;
    }

    public boolean isSignaturePolicyImplied() {
        return this.isSignaturePolicyImplied;
    }

    public ASN1Primitive toASN1Primitive() {
        if(this.isSignaturePolicyImplied) {
            return DERNull.INSTANCE;
        }

        return this.signaturePolicyId.toASN1Primitive();
    }
}

