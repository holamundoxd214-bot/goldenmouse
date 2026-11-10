package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ProtectedPart extends ASN1Object {
    private final PKIBody body;
    private final PKIHeader header;

    private ProtectedPart(ASN1Sequence arg2) {
        super();
        this.header = PKIHeader.getInstance(arg2.getObjectAt(0));
        this.body = PKIBody.getInstance(arg2.getObjectAt(1));
    }

    public ProtectedPart(PKIHeader arg1, PKIBody arg2) {
        super();
        this.header = arg1;
        this.body = arg2;
    }

    public PKIBody getBody() {
        return this.body;
    }

    public PKIHeader getHeader() {
        return this.header;
    }

    public static ProtectedPart getInstance(Object arg1) {
        if((arg1 instanceof ProtectedPart)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ProtectedPart(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.header, this.body);
    }
}

