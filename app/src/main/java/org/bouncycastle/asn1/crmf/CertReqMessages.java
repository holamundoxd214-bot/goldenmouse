package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CertReqMessages extends ASN1Object {
    private ASN1Sequence content;

    private CertReqMessages(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public CertReqMessages(CertReqMsg arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable)arg2));
    }

    public CertReqMessages(CertReqMsg[] arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable[])arg2));
    }

    public static CertReqMessages getInstance(Object arg1) {
        if((arg1 instanceof CertReqMessages)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertReqMessages(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public CertReqMsg[] toCertReqMsgArray() {
        int v0 = this.content.size();
        CertReqMsg[] v1 = new CertReqMsg[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = CertReqMsg.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }
}

