package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;

public class CertReqTemplateContent extends ASN1Object {
    private final CertTemplate certTemplate;
    private final ASN1Sequence keySpec;

    private CertReqTemplateContent(ASN1Sequence arg4) {
        super();
        if(arg4.size() != 1) {
            if(arg4.size() == 2) {
            }
            else {
                throw new IllegalArgumentException("expected sequence size of 1 or 2");
            }
        }

        this.certTemplate = CertTemplate.getInstance(arg4.getObjectAt(0));
        arg4 = arg4.size() > 1 ? ASN1Sequence.getInstance(arg4.getObjectAt(1)) : null;
        this.keySpec = arg4;
    }

    public CertReqTemplateContent(CertTemplate arg1, ASN1Sequence arg2) {
        super();
        this.certTemplate = arg1;
        this.keySpec = arg2;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public static CertReqTemplateContent getInstance(Object arg1) {
        if((arg1 instanceof CertReqTemplateContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertReqTemplateContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Sequence getKeySpec() {
        return this.keySpec;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.certTemplate);
        ASN1Sequence v2 = this.keySpec;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

