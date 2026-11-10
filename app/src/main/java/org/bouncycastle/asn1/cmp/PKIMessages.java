package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PKIMessages extends ASN1Object {
    private final ASN1Sequence content;

    protected PKIMessages(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public PKIMessages(PKIMessage arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable)arg2));
    }

    public PKIMessages(PKIMessage[] arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable[])arg2));
    }

    public static PKIMessages getInstance(Object arg1) {
        if((arg1 instanceof PKIMessages)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIMessages(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public PKIMessage[] toPKIMessageArray() {
        int v0 = this.content.size();
        PKIMessage[] v1 = new PKIMessage[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = PKIMessage.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }
}

