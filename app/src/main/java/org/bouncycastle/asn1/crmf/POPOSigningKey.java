package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class POPOSigningKey extends ASN1Object {
    private AlgorithmIdentifier algorithmIdentifier;
    private POPOSigningKeyInput poposkInput;
    private ASN1BitString signature;

    private POPOSigningKey(ASN1Sequence arg4) {
        super();
        int v0 = 0;
        if((arg4.getObjectAt(0) instanceof ASN1TaggedObject)) {
            this.poposkInput = POPOSigningKeyInput.getInstance(ASN1Util.getContextBaseUniversal(arg4.getObjectAt(0), 0, false, 16));
            v0 = 1;
        }

        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(arg4.getObjectAt(v0));
        this.signature = ASN1BitString.getInstance(arg4.getObjectAt(v0 + 1));
    }

    public POPOSigningKey(POPOSigningKeyInput arg1, AlgorithmIdentifier arg2, ASN1BitString arg3) {
        super();
        this.poposkInput = arg1;
        this.algorithmIdentifier = arg2;
        this.signature = arg3;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    public static POPOSigningKey getInstance(Object arg1) {
        if((arg1 instanceof POPOSigningKey)) {
            return arg1;
        }

        if(arg1 != null) {
            return new POPOSigningKey(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static POPOSigningKey getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return POPOSigningKey.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public POPOSigningKeyInput getPoposkInput() {
        return this.poposkInput;
    }

    public ASN1BitString getSignature() {
        return this.signature;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        if(this.poposkInput != null) {
            v0.add(new DERTaggedObject(false, 0, this.poposkInput));
        }

        v0.add(this.algorithmIdentifier);
        v0.add(this.signature);
        return new DERSequence(v0);
    }
}

