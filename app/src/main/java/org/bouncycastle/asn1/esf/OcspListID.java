package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OcspListID extends ASN1Object {
    private ASN1Sequence ocspResponses;

    private OcspListID(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 1) {
            ASN1Encodable v3 = arg3.getObjectAt(0);
            this.ocspResponses = ((ASN1Sequence)v3);
            Enumeration v2 = ((ASN1Sequence)v3).getObjects();
            while(v2.hasMoreElements()) {
                OcspResponsesID.getInstance(v2.nextElement());
            }

            return;
        }

        throw new IllegalArgumentException("Bad sequence size: " + arg3.size());
    }

    public OcspListID(OcspResponsesID[] arg2) {
        super();
        this.ocspResponses = new DERSequence(((ASN1Encodable[])arg2));
    }

    public static OcspListID getInstance(Object arg1) {
        if((arg1 instanceof OcspListID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OcspListID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OcspResponsesID[] getOcspResponses() {
        int v0 = this.ocspResponses.size();
        OcspResponsesID[] v1 = new OcspResponsesID[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = OcspResponsesID.getInstance(this.ocspResponses.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.ocspResponses);
    }
}

