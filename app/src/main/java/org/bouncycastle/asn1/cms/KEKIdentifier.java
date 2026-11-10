package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class KEKIdentifier extends ASN1Object {
    private ASN1GeneralizedTime date;
    private ASN1OctetString keyIdentifier;
    private OtherKeyAttribute other;

    private KEKIdentifier(ASN1Sequence arg5) {
        super();
        this.keyIdentifier = arg5.getObjectAt(0);
        int v0 = arg5.size();
        if(v0 != 1) {
            int v2 = 2;
            if(v0 == v2) {
                boolean v0_1 = arg5.getObjectAt(1) instanceof ASN1GeneralizedTime;
                ASN1Encodable v5 = arg5.getObjectAt(1);
                if(v0_1) {
                    this.date = ((ASN1GeneralizedTime)v5);
                    return;
                }
                else {
                    this.other = OtherKeyAttribute.getInstance(v5);
                }
            }
            else if(v0 == 3) {
                this.date = arg5.getObjectAt(1);
                this.other = OtherKeyAttribute.getInstance(arg5.getObjectAt(v2));
                return;
            }
            else {
                throw new IllegalArgumentException("Invalid KEKIdentifier");
            }
        }
    }

    public KEKIdentifier(byte[] arg2, ASN1GeneralizedTime arg3, OtherKeyAttribute arg4) {
        super();
        this.keyIdentifier = new DEROctetString(arg2);
        this.date = arg3;
        this.other = arg4;
    }

    public ASN1GeneralizedTime getDate() {
        return this.date;
    }

    public static KEKIdentifier getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof KEKIdentifier)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new KEKIdentifier(((ASN1Sequence)arg3));
            }
            else {
                throw new IllegalArgumentException("Invalid KEKIdentifier: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static KEKIdentifier getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return KEKIdentifier.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public OtherKeyAttribute getOther() {
        return this.other;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.keyIdentifier);
        ASN1GeneralizedTime v1 = this.date;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        OtherKeyAttribute v2 = this.other;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

