package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;

public class OriginatorIdentifierOrKey extends ASN1Object implements ASN1Choice {
    private ASN1Encodable id;

    public OriginatorIdentifierOrKey(ASN1OctetString arg2) {
        this(new SubjectKeyIdentifier(arg2.getOctets()));
    }

    public OriginatorIdentifierOrKey(SubjectKeyIdentifier arg3) {
        super();
        this.id = new DERTaggedObject(false, 0, ((ASN1Encodable)arg3));
    }

    public OriginatorIdentifierOrKey(ASN1Primitive arg1) {
        super();
        this.id = ((ASN1Encodable)arg1);
    }

    public OriginatorIdentifierOrKey(IssuerAndSerialNumber arg1) {
        super();
        this.id = ((ASN1Encodable)arg1);
    }

    public OriginatorIdentifierOrKey(OriginatorPublicKey arg4) {
        super();
        this.id = new DERTaggedObject(false, 1, ((ASN1Encodable)arg4));
    }

    public ASN1Encodable getId() {
        return this.id;
    }

    public static OriginatorIdentifierOrKey getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg1) {
            return OriginatorIdentifierOrKey.getInstance(arg0.getExplicitBaseObject());
        }

        throw new IllegalArgumentException("Can\'t implicitly tag OriginatorIdentifierOrKey");
    }

    public static OriginatorIdentifierOrKey getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof OriginatorIdentifierOrKey)) {
            }
            else if((arg3 instanceof IssuerAndSerialNumber)) {
                return new OriginatorIdentifierOrKey(((IssuerAndSerialNumber)arg3));
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new OriginatorIdentifierOrKey(IssuerAndSerialNumber.getInstance(arg3));
            }
            else {
                if((arg3 instanceof ASN1TaggedObject)) {
                    Object v0 = arg3;
                    if(((ASN1TaggedObject)v0).hasContextTag(0)) {
                        return new OriginatorIdentifierOrKey(SubjectKeyIdentifier.getInstance(((ASN1TaggedObject)v0), false));
                    }
                    else if(((ASN1TaggedObject)v0).hasContextTag(1)) {
                        return new OriginatorIdentifierOrKey(OriginatorPublicKey.getInstance(((ASN1TaggedObject)v0), false));
                    }
                }

                throw new IllegalArgumentException("Invalid OriginatorIdentifierOrKey: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        ASN1Encodable v1 = this.id;
        if((v1 instanceof IssuerAndSerialNumber)) {
            return ((IssuerAndSerialNumber)v1);
        }

        return null;
    }

    public OriginatorPublicKey getOriginatorKey() {
        ASN1Encodable v1 = this.id;
        if(((v1 instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)v1).hasContextTag(1))) {
            return OriginatorPublicKey.getInstance(((ASN1TaggedObject)v1), false);
        }

        return null;
    }

    public SubjectKeyIdentifier getSubjectKeyIdentifier() {
        ASN1Encodable v2 = this.id;
        if(((v2 instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)v2).hasContextTag(0))) {
            return SubjectKeyIdentifier.getInstance(((ASN1TaggedObject)v2), false);
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.id.toASN1Primitive();
    }
}

