package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class POPODecKeyRespContent extends ASN1Object {
    private final ASN1Sequence content;

    private POPODecKeyRespContent(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public static POPODecKeyRespContent getInstance(Object arg1) {
        if((arg1 instanceof POPODecKeyRespContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new POPODecKeyRespContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Integer[] toASN1IntegerArray() {
        int v0 = this.content.size();
        ASN1Integer[] v1 = new ASN1Integer[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = ASN1Integer.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }
}

