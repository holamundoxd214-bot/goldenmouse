package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class POPOSigningKeyInput extends ASN1Object {
    private SubjectPublicKeyInfo publicKey;
    private PKMACValue publicKeyMAC;
    private GeneralName sender;

    private POPOSigningKeyInput(ASN1Sequence arg4) {
        super();
        ASN1Encodable v1 = arg4.getObjectAt(0);
        if((v1 instanceof ASN1TaggedObject)) {
            this.sender = GeneralName.getInstance(ASN1Util.getExplicitContextBaseObject(((ASN1TaggedObject)v1), 0));
        }
        else {
            this.publicKeyMAC = PKMACValue.getInstance(v1);
        }

        this.publicKey = SubjectPublicKeyInfo.getInstance(arg4.getObjectAt(1));
    }

    public POPOSigningKeyInput(PKMACValue arg1, SubjectPublicKeyInfo arg2) {
        super();
        this.publicKeyMAC = arg1;
        this.publicKey = arg2;
    }

    public POPOSigningKeyInput(GeneralName arg1, SubjectPublicKeyInfo arg2) {
        super();
        this.sender = arg1;
        this.publicKey = arg2;
    }

    public static POPOSigningKeyInput getInstance(Object arg1) {
        if((arg1 instanceof POPOSigningKeyInput)) {
            return arg1;
        }

        if(arg1 != null) {
            return new POPOSigningKeyInput(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.publicKey;
    }

    public PKMACValue getPublicKeyMAC() {
        return this.publicKeyMAC;
    }

    public GeneralName getSender() {
        return this.sender;
    }

    public ASN1Primitive toASN1Primitive() {
        DERTaggedObject v1;
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        if(this.sender != null) {
            v1 = new DERTaggedObject(false, 0, this.sender);
        }
        else {
            PKMACValue v1_1 = this.publicKeyMAC;
        }

        v0.add(((ASN1Encodable)v1));
        v0.add(this.publicKey);
        return new DERSequence(v0);
    }
}

