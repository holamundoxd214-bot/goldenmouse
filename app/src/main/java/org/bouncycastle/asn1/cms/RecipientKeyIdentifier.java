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

public class RecipientKeyIdentifier extends ASN1Object {
    private ASN1GeneralizedTime date;
    private OtherKeyAttribute other;
    private ASN1OctetString subjectKeyIdentifier;

    public RecipientKeyIdentifier(ASN1OctetString arg1, ASN1GeneralizedTime arg2, OtherKeyAttribute arg3) {
        super();
        this.subjectKeyIdentifier = arg1;
        this.date = arg2;
        this.other = arg3;
    }

    private RecipientKeyIdentifier(ASN1Sequence arg5) {
        super();
        this.subjectKeyIdentifier = ASN1OctetString.getInstance(arg5.getObjectAt(0));
        int v0 = arg5.size();
        if(v0 != 1) {
            int v2 = 2;
            if(v0 != v2) {
                if(v0 == 3) {
                    this.date = ASN1GeneralizedTime.getInstance(arg5.getObjectAt(1));
                    this.other = OtherKeyAttribute.getInstance(arg5.getObjectAt(v2));
                    return;
                }
                else {
                    throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
                }
            }
            else if((arg5.getObjectAt(1) instanceof ASN1GeneralizedTime)) {
                this.date = ASN1GeneralizedTime.getInstance(arg5.getObjectAt(1));
                return;
            }
            else {
                this.other = OtherKeyAttribute.getInstance(arg5.getObjectAt(v2));
            }
        }
    }

    public RecipientKeyIdentifier(byte[] arg2) {
        this(arg2, null, null);
    }

    public RecipientKeyIdentifier(byte[] arg2, ASN1GeneralizedTime arg3, OtherKeyAttribute arg4) {
        super();
        this.subjectKeyIdentifier = new DEROctetString(arg2);
        this.date = arg3;
        this.other = arg4;
    }

    public ASN1GeneralizedTime getDate() {
        return this.date;
    }

    public static RecipientKeyIdentifier getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return RecipientKeyIdentifier.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static RecipientKeyIdentifier getInstance(Object arg1) {
        if((arg1 instanceof RecipientKeyIdentifier)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RecipientKeyIdentifier(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OtherKeyAttribute getOtherKeyAttribute() {
        return this.other;
    }

    public ASN1OctetString getSubjectKeyIdentifier() {
        return this.subjectKeyIdentifier;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.subjectKeyIdentifier);
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

