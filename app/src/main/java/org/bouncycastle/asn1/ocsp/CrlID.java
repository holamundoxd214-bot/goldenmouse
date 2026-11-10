package org.bouncycastle.asn1.ocsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1IA5String;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CrlID extends ASN1Object {
    private ASN1Integer crlNum;
    private ASN1GeneralizedTime crlTime;
    private ASN1IA5String crlUrl;

    private CrlID(ASN1Sequence arg5) {
        super();
        Enumeration v5 = arg5.getObjects();
        while(v5.hasMoreElements()) {
            Object v0 = v5.nextElement();
            int v1 = ((ASN1TaggedObject)v0).getTagNo();
            if(v1 != 0) {
                if(v1 != 1) {
                    if(v1 == 2) {
                        this.crlTime = ASN1GeneralizedTime.getInstance(((ASN1TaggedObject)v0), true);
                        continue;
                    }

                    throw new IllegalArgumentException("unknown tag number: " + ((ASN1TaggedObject)v0).getTagNo());
                }

                this.crlNum = ASN1Integer.getInstance(((ASN1TaggedObject)v0), true);
                continue;
            }

            this.crlUrl = ASN1IA5String.getInstance(((ASN1TaggedObject)v0), true);
        }
    }

    public ASN1Integer getCrlNum() {
        return this.crlNum;
    }

    public ASN1GeneralizedTime getCrlTime() {
        return this.crlTime;
    }

    public DERIA5String getCrlUrl() {
        ASN1IA5String v0 = this.crlUrl;
        if(v0 != null) {
            if((v0 instanceof DERIA5String)) {
            }
            else {
                return new DERIA5String(this.crlUrl.getString(), false);
            }
        }

        return ((DERIA5String)v0);
    }

    public ASN1IA5String getCrlUrlIA5() {
        return this.crlUrl;
    }

    public static CrlID getInstance(Object arg1) {
        if((arg1 instanceof CrlID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CrlID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        if(this.crlUrl != null) {
            v0.add(new DERTaggedObject(true, 0, this.crlUrl));
        }

        if(this.crlNum != null) {
            v0.add(new DERTaggedObject(true, 1, this.crlNum));
        }

        if(this.crlTime != null) {
            v0.add(new DERTaggedObject(true, 2, this.crlTime));
        }

        return new DERSequence(v0);
    }
}

