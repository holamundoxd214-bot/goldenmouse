package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class RecipientIdentifier extends ASN1Object implements ASN1Choice {
    private ASN1Encodable id;

    public RecipientIdentifier(ASN1OctetString arg3) {
        super();
        this.id = new DERTaggedObject(false, 0, ((ASN1Encodable)arg3));
    }

    public RecipientIdentifier(ASN1Primitive arg1) {
        super();
        this.id = ((ASN1Encodable)arg1);
    }

    public RecipientIdentifier(IssuerAndSerialNumber arg1) {
        super();
        this.id = ((ASN1Encodable)arg1);
    }

    public ASN1Encodable getId() {
        ASN1Encodable v1 = this.id;
        if((v1 instanceof ASN1TaggedObject)) {
            return ASN1OctetString.getInstance(((ASN1TaggedObject)v1), false);
        }

        return IssuerAndSerialNumber.getInstance(v1);
    }

    public static RecipientIdentifier getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof RecipientIdentifier)) {
            }
            else if((arg3 instanceof IssuerAndSerialNumber)) {
                return new RecipientIdentifier(((IssuerAndSerialNumber)arg3));
            }
            else if((arg3 instanceof ASN1OctetString)) {
                return new RecipientIdentifier(((ASN1OctetString)arg3));
            }
            else if((arg3 instanceof ASN1Primitive)) {
                return new RecipientIdentifier(((ASN1Primitive)arg3));
            }
            else {
                throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public boolean isTagged() {
        return this.id instanceof ASN1TaggedObject;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.id.toASN1Primitive();
    }
}

