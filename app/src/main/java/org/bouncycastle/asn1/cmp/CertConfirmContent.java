package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class CertConfirmContent extends ASN1Object {
    private final ASN1Sequence content;

    private CertConfirmContent(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public static CertConfirmContent getInstance(Object arg1) {
        if((arg1 instanceof CertConfirmContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertConfirmContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public CertStatus[] toCertStatusArray() {
        int v0 = this.content.size();
        CertStatus[] v1 = new CertStatus[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = CertStatus.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }
}

