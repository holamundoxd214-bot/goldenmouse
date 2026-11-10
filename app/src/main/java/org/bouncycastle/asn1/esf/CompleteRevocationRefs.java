package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CompleteRevocationRefs extends ASN1Object {
    private ASN1Sequence crlOcspRefs;

    private CompleteRevocationRefs(ASN1Sequence arg3) {
        super();
        Enumeration v0 = arg3.getObjects();
        while(v0.hasMoreElements()) {
            CrlOcspRef.getInstance(v0.nextElement());
        }

        this.crlOcspRefs = arg3;
    }

    public CompleteRevocationRefs(CrlOcspRef[] arg2) {
        super();
        this.crlOcspRefs = new DERSequence(((ASN1Encodable[])arg2));
    }

    public CrlOcspRef[] getCrlOcspRefs() {
        int v0 = this.crlOcspRefs.size();
        CrlOcspRef[] v1 = new CrlOcspRef[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = CrlOcspRef.getInstance(this.crlOcspRefs.getObjectAt(v2));
        }

        return v1;
    }

    public static CompleteRevocationRefs getInstance(Object arg1) {
        if((arg1 instanceof CompleteRevocationRefs)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CompleteRevocationRefs(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.crlOcspRefs;
    }
}

