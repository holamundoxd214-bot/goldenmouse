package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CrlListID extends ASN1Object {
    private ASN1Sequence crls;

    private CrlListID(ASN1Sequence arg2) {
        super();
        ASN1Encodable v2 = arg2.getObjectAt(0);
        this.crls = ((ASN1Sequence)v2);
        Enumeration v1 = ((ASN1Sequence)v2).getObjects();
        while(v1.hasMoreElements()) {
            CrlValidatedID.getInstance(v1.nextElement());
        }
    }

    public CrlListID(CrlValidatedID[] arg2) {
        super();
        this.crls = new DERSequence(((ASN1Encodable[])arg2));
    }

    public CrlValidatedID[] getCrls() {
        int v0 = this.crls.size();
        CrlValidatedID[] v1 = new CrlValidatedID[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = CrlValidatedID.getInstance(this.crls.getObjectAt(v2));
        }

        return v1;
    }

    public static CrlListID getInstance(Object arg1) {
        if((arg1 instanceof CrlListID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CrlListID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.crls);
    }
}

