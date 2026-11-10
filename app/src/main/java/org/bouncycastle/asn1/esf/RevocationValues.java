package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.x509.CertificateList;

public class RevocationValues extends ASN1Object {
    private ASN1Sequence crlVals;
    private ASN1Sequence ocspVals;
    private OtherRevVals otherRevVals;

    private RevocationValues(ASN1Sequence arg4) {
        ASN1TaggedObject v0;
        super();
        if(arg4.size() > 3) {
            goto label_48;
        }

        Enumeration v4 = arg4.getObjects();
        while(true) {
        label_5:
            if(!v4.hasMoreElements()) {
                return;
            }

            v0 = ASN1TaggedObject.getInstance(v4.nextElement(), 0x80);
            int v1 = v0.getTagNo();
            if(v1 == 0) {
                goto label_38;
            }

            if(v1 == 1) {
                goto label_29;
            }

            if(v1 != 2) {
                break;
            }

            this.otherRevVals = OtherRevVals.getInstance(v0.getExplicitBaseObject());
        }

        throw new IllegalArgumentException("invalid tag: " + v0.getTagNo());
    label_29:
        ASN1Object v0_1 = v0.getExplicitBaseObject();
        Enumeration v1_1 = ((ASN1Sequence)v0_1).getObjects();
        goto label_31;
    label_38:
        v0_1 = v0.getExplicitBaseObject();
        v1_1 = ((ASN1Sequence)v0_1).getObjects();
        goto label_40;
        return;
    label_40:
        while(v1_1.hasMoreElements()) {
            CertificateList.getInstance(v1_1.nextElement());
        }

        this.crlVals = ((ASN1Sequence)v0_1);
        goto label_5;
    label_31:
        while(v1_1.hasMoreElements()) {
            BasicOCSPResponse.getInstance(v1_1.nextElement());
        }

        this.ocspVals = ((ASN1Sequence)v0_1);
        goto label_5;
    label_48:
        throw new IllegalArgumentException("Bad sequence size: " + arg4.size());
    }

    public RevocationValues(CertificateList[] arg2, BasicOCSPResponse[] arg3, OtherRevVals arg4) {
        super();
        if(arg2 != null) {
            this.crlVals = new DERSequence(((ASN1Encodable[])arg2));
        }

        if(arg3 != null) {
            this.ocspVals = new DERSequence(((ASN1Encodable[])arg3));
        }

        this.otherRevVals = arg4;
    }

    public CertificateList[] getCrlVals() {
        ASN1Sequence v0 = this.crlVals;
        int v1 = 0;
        if(v0 == null) {
            return new CertificateList[0];
        }

        int v0_1 = v0.size();
        CertificateList[] v2 = new CertificateList[v0_1];
        while(v1 < v0_1) {
            v2[v1] = CertificateList.getInstance(this.crlVals.getObjectAt(v1));
            ++v1;
        }

        return v2;
    }

    public static RevocationValues getInstance(Object arg1) {
        if((arg1 instanceof RevocationValues)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevocationValues(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public BasicOCSPResponse[] getOcspVals() {
        ASN1Sequence v0 = this.ocspVals;
        int v1 = 0;
        if(v0 == null) {
            return new BasicOCSPResponse[0];
        }

        int v0_1 = v0.size();
        BasicOCSPResponse[] v2 = new BasicOCSPResponse[v0_1];
        while(v1 < v0_1) {
            v2[v1] = BasicOCSPResponse.getInstance(this.ocspVals.getObjectAt(v1));
            ++v1;
        }

        return v2;
    }

    public OtherRevVals getOtherRevVals() {
        return this.otherRevVals;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        if(this.crlVals != null) {
            v0.add(new DERTaggedObject(true, 0, this.crlVals));
        }

        if(this.ocspVals != null) {
            v0.add(new DERTaggedObject(true, 1, this.ocspVals));
        }

        if(this.otherRevVals != null) {
            v0.add(new DERTaggedObject(true, 2, this.otherRevVals.toASN1Primitive()));
        }

        return new DERSequence(v0);
    }
}

