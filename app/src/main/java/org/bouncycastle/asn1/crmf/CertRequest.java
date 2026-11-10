package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CertRequest extends ASN1Object {
    private ASN1Integer certReqId;
    private CertTemplate certTemplate;
    private Controls controls;

    public CertRequest(int arg4, CertTemplate arg5, Controls arg6) {
        this(new ASN1Integer(((long)arg4)), arg5, arg6);
    }

    public CertRequest(ASN1Integer arg1, CertTemplate arg2, Controls arg3) {
        super();
        this.certReqId = arg1;
        this.certTemplate = arg2;
        this.controls = arg3;
    }

    private CertRequest(ASN1Sequence arg3) {
        super();
        this.certReqId = new ASN1Integer(ASN1Integer.getInstance(arg3.getObjectAt(0)).getValue());
        this.certTemplate = CertTemplate.getInstance(arg3.getObjectAt(1));
        int v1 = 2;
        if(arg3.size() > v1) {
            this.controls = Controls.getInstance(arg3.getObjectAt(v1));
        }
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public Controls getControls() {
        return this.controls;
    }

    public static CertRequest getInstance(Object arg1) {
        if((arg1 instanceof CertRequest)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertRequest(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.certReqId);
        v0.add(this.certTemplate);
        Controls v2 = this.controls;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

