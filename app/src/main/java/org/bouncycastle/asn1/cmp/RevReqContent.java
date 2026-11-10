package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class RevReqContent extends ASN1Object {
    private final ASN1Sequence content;

    private RevReqContent(ASN1Sequence arg1) {
        super();
        this.content = arg1;
    }

    public RevReqContent(RevDetails arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable)arg2));
    }

    public RevReqContent(RevDetails[] arg2) {
        super();
        this.content = new DERSequence(((ASN1Encodable[])arg2));
    }

    public static RevReqContent getInstance(Object arg1) {
        if((arg1 instanceof RevReqContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new RevReqContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public RevDetails[] toRevDetailsArray() {
        int v0 = this.content.size();
        RevDetails[] v1 = new RevDetails[v0];
        int v2;
        for(v2 = 0; v2 != v0; ++v2) {
            v1[v2] = RevDetails.getInstance(this.content.getObjectAt(v2));
        }

        return v1;
    }
}

