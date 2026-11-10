package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

public class ResponderID extends ASN1Object implements ASN1Choice {
    private ASN1Encodable value;

    public ResponderID(ASN1OctetString arg1) {
        super();
        this.value = ((ASN1Encodable)arg1);
    }

    public ResponderID(X500Name arg1) {
        super();
        this.value = ((ASN1Encodable)arg1);
    }

    public static ResponderID getInstance(Object arg2) {
        if((arg2 instanceof ResponderID)) {
            return arg2;
        }

        if((arg2 instanceof DEROctetString)) {
            return new ResponderID(((ASN1OctetString)arg2));
        }

        if((arg2 instanceof ASN1TaggedObject)) {
            if(((ASN1TaggedObject)arg2).getTagNo() == 1) {
                return new ResponderID(X500Name.getInstance(((ASN1TaggedObject)arg2), true));
            }

            return new ResponderID(ASN1OctetString.getInstance(((ASN1TaggedObject)arg2), true));
        }

        return new ResponderID(X500Name.getInstance(arg2));
    }

    public static ResponderID getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg1) {
            return ResponderID.getInstance(arg0.getExplicitBaseObject());
        }

        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public byte[] getKeyHash() {
        ASN1Encodable v1 = this.value;
        if((v1 instanceof ASN1OctetString)) {
            return ((ASN1OctetString)v1).getOctets();
        }

        return null;
    }

    public X500Name getName() {
        ASN1Encodable v1 = this.value;
        if((v1 instanceof ASN1OctetString)) {
            return null;
        }

        return X500Name.getInstance(v1);
    }

    public ASN1Primitive toASN1Primitive() {
        if((this.value instanceof ASN1OctetString)) {
            return new DERTaggedObject(true, 2, this.value);
        }

        return new DERTaggedObject(true, 1, this.value);
    }
}

