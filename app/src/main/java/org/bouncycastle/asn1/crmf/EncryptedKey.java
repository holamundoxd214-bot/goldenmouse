package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

public class EncryptedKey extends ASN1Object implements ASN1Choice {
    private EncryptedValue encryptedValue;
    private EnvelopedData envelopedData;

    public EncryptedKey(EncryptedValue arg1) {
        super();
        this.encryptedValue = arg1;
    }

    public EncryptedKey(EnvelopedData arg1) {
        super();
        this.envelopedData = arg1;
    }

    public static EncryptedKey getInstance(Object arg2) {
        if((arg2 instanceof EncryptedKey)) {
            return arg2;
        }

        if((arg2 instanceof ASN1TaggedObject)) {
            return new EncryptedKey(EnvelopedData.getInstance(((ASN1TaggedObject)arg2), false));
        }

        return new EncryptedKey(EncryptedValue.getInstance(arg2));
    }

    public ASN1Encodable getValue() {
        EncryptedValue v0 = this.encryptedValue;
        if(v0 != null) {
            return ((ASN1Encodable)v0);
        }

        return this.envelopedData;
    }

    public boolean isEncryptedValue() {
        if(this.encryptedValue != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        EncryptedValue v0 = this.encryptedValue;
        if(v0 != null) {
            return v0.toASN1Primitive();
        }

        return new DERTaggedObject(false, 0, this.envelopedData);
    }
}

