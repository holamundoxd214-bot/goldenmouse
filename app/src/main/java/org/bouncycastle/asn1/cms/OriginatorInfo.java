package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OriginatorInfo extends ASN1Object {
    private ASN1Set certs;
    private ASN1Set crls;

    private OriginatorInfo(ASN1Sequence arg5) {
        super();
        int v0 = arg5.size();
        if(v0 != 0) {
            if(v0 == 1) {
                ASN1Encodable v5 = arg5.getObjectAt(0);
                v0 = ((ASN1TaggedObject)v5).getTagNo();
                if(v0 == 0) {
                    this.certs = ASN1Set.getInstance(((ASN1TaggedObject)v5), false);
                }
                else if(v0 == 1) {
                    this.crls = ASN1Set.getInstance(((ASN1TaggedObject)v5), false);
                    return;
                }
                else {
                    throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + ((ASN1TaggedObject)v5).getTagNo());
                }
            }
            else if(v0 == 2) {
                this.certs = ASN1Set.getInstance(arg5.getObjectAt(0), false);
                this.crls = ASN1Set.getInstance(arg5.getObjectAt(1), false);
                return;
            }
            else {
                throw new IllegalArgumentException("OriginatorInfo too big");
            }
        }
    }

    public OriginatorInfo(ASN1Set arg1, ASN1Set arg2) {
        super();
        this.certs = arg1;
        this.crls = arg2;
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getCertificates() {
        return this.certs;
    }

    public static OriginatorInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return OriginatorInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static OriginatorInfo getInstance(Object arg1) {
        if((arg1 instanceof OriginatorInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OriginatorInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        if(this.certs != null) {
            v0.add(new DERTaggedObject(false, 0, this.certs));
        }

        if(this.crls != null) {
            v0.add(new DERTaggedObject(false, 1, this.crls));
        }

        return new DERSequence(v0);
    }
}

