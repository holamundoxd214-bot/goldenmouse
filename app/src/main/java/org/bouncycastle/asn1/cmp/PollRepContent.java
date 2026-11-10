package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PollRepContent extends ASN1Object {
    private final ASN1Integer[] certReqId;
    private final ASN1Integer[] checkAfter;
    private final PKIFreeText[] reason;

    public PollRepContent(ASN1Integer arg2, ASN1Integer arg3) {
        this(arg2, arg3, null);
    }

    public PollRepContent(ASN1Integer arg4, ASN1Integer arg5, PKIFreeText arg6) {
        super();
        ASN1Integer[] v1 = new ASN1Integer[1];
        this.certReqId = v1;
        ASN1Integer[] v2 = new ASN1Integer[1];
        this.checkAfter = v2;
        PKIFreeText[] v0 = new PKIFreeText[1];
        this.reason = v0;
        v1[0] = arg4;
        v2[0] = arg5;
        v0[0] = arg6;
    }

    private PollRepContent(ASN1Sequence arg6) {
        super();
        this.certReqId = new ASN1Integer[arg6.size()];
        this.checkAfter = new ASN1Integer[arg6.size()];
        this.reason = new PKIFreeText[arg6.size()];
        int v1;
        for(v1 = 0; v1 != arg6.size(); ++v1) {
            ASN1Sequence v2 = ASN1Sequence.getInstance(arg6.getObjectAt(v1));
            this.certReqId[v1] = ASN1Integer.getInstance(v2.getObjectAt(0));
            this.checkAfter[v1] = ASN1Integer.getInstance(v2.getObjectAt(1));
            int v4 = 2;
            if(v2.size() > v4) {
                this.reason[v1] = PKIFreeText.getInstance(v2.getObjectAt(v4));
            }
        }
    }

    public ASN1Integer getCertReqId(int arg1) {
        return this.certReqId[arg1];
    }

    public ASN1Integer getCheckAfter(int arg1) {
        return this.checkAfter[arg1];
    }

    public static PollRepContent getInstance(Object arg1) {
        if((arg1 instanceof PollRepContent)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PollRepContent(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public PKIFreeText getReason(int arg1) {
        return this.reason[arg1];
    }

    public int size() {
        return this.certReqId.length;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(this.certReqId.length);
        int v1;
        for(v1 = 0; v1 != this.certReqId.length; ++v1) {
            ASN1EncodableVector v2 = new ASN1EncodableVector(3);
            v2.add(this.certReqId[v1]);
            v2.add(this.checkAfter[v1]);
            PKIFreeText v3 = this.reason[v1];
            if(v3 != null) {
                v2.add(((ASN1Encodable)v3));
            }

            v0.add(new DERSequence(v2));
        }

        return new DERSequence(v0);
    }
}

