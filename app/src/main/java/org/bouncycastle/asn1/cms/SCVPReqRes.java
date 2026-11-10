package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class SCVPReqRes extends ASN1Object {
    private final ContentInfo request;
    private final ContentInfo response;

    private SCVPReqRes(ASN1Sequence arg3) {
        ASN1Encodable v3;
        super();
        if((arg3.getObjectAt(0) instanceof ASN1TaggedObject)) {
            this.request = ContentInfo.getInstance(ASN1TaggedObject.getInstance(arg3.getObjectAt(0)), true);
            v3 = arg3.getObjectAt(1);
        }
        else {
            this.request = null;
            v3 = arg3.getObjectAt(0);
        }

        this.response = ContentInfo.getInstance(v3);
    }

    public SCVPReqRes(ContentInfo arg2) {
        super();
        this.request = null;
        this.response = arg2;
    }

    public SCVPReqRes(ContentInfo arg1, ContentInfo arg2) {
        super();
        this.request = arg1;
        this.response = arg2;
    }

    public static SCVPReqRes getInstance(Object arg1) {
        if((arg1 instanceof SCVPReqRes)) {
            return arg1;
        }

        if(arg1 != null) {
            return new SCVPReqRes(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ContentInfo getRequest() {
        return this.request;
    }

    public ContentInfo getResponse() {
        return this.response;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        if(this.request != null) {
            v0.add(new DERTaggedObject(true, 0, this.request));
        }

        v0.add(this.response);
        return new DERSequence(v0);
    }
}

