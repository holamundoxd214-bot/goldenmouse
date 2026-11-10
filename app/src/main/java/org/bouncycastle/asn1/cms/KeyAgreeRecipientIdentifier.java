package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERTaggedObject;

public class KeyAgreeRecipientIdentifier extends ASN1Object implements ASN1Choice {
    private IssuerAndSerialNumber issuerSerial;
    private RecipientKeyIdentifier rKeyID;

    public KeyAgreeRecipientIdentifier(IssuerAndSerialNumber arg1) {
        super();
        this.issuerSerial = arg1;
        this.rKeyID = null;
    }

    public KeyAgreeRecipientIdentifier(RecipientKeyIdentifier arg2) {
        super();
        this.issuerSerial = null;
        this.rKeyID = arg2;
    }

    public static KeyAgreeRecipientIdentifier getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof KeyAgreeRecipientIdentifier)) {
            }
            else if(!(arg3 instanceof ASN1TaggedObject)) {
                return new KeyAgreeRecipientIdentifier(IssuerAndSerialNumber.getInstance(arg3));
            }
            else if(((ASN1TaggedObject)arg3).hasContextTag(0)) {
                return new KeyAgreeRecipientIdentifier(RecipientKeyIdentifier.getInstance(((ASN1TaggedObject)arg3), false));
            }
            else {
                throw new IllegalArgumentException("Invalid KeyAgreeRecipientIdentifier tag: " + ASN1Util.getTagText(((ASN1TaggedObject)arg3)));
            }
        }

        return arg3;
    }

    public static KeyAgreeRecipientIdentifier getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg1) {
            return KeyAgreeRecipientIdentifier.getInstance(arg0.getExplicitBaseObject());
        }

        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return this.issuerSerial;
    }

    public RecipientKeyIdentifier getRKeyID() {
        return this.rKeyID;
    }

    public ASN1Primitive toASN1Primitive() {
        IssuerAndSerialNumber v0 = this.issuerSerial;
        if(v0 != null) {
            return v0.toASN1Primitive();
        }

        return new DERTaggedObject(false, 0, this.rKeyID);
    }
}

