package org.bouncycastle.asn1.crmf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PKIPublicationInfo extends ASN1Object {
    private ASN1Integer action;
    public static final ASN1Integer dontPublish;
    public static final ASN1Integer pleasePublish;
    private ASN1Sequence pubInfos;

    static {
        PKIPublicationInfo.dontPublish = new ASN1Integer(0);
        PKIPublicationInfo.pleasePublish = new ASN1Integer(1);
    }

    public PKIPublicationInfo(BigInteger arg2) {
        this(new ASN1Integer(arg2));
    }

    public PKIPublicationInfo(ASN1Integer arg1) {
        super();
        this.action = arg1;
    }

    private PKIPublicationInfo(ASN1Sequence arg3) {
        super();
        this.action = ASN1Integer.getInstance(arg3.getObjectAt(0));
        if(arg3.size() > 1) {
            this.pubInfos = ASN1Sequence.getInstance(arg3.getObjectAt(1));
        }
    }

    public PKIPublicationInfo(SinglePubInfo arg3) {
        SinglePubInfo[] v0 = arg3 != null ? new SinglePubInfo[]{arg3} : null;
        this(v0);
    }

    public PKIPublicationInfo(SinglePubInfo[] arg2) {
        super();
        this.action = PKIPublicationInfo.pleasePublish;
        if(arg2 != null) {
            this.pubInfos = new DERSequence(((ASN1Encodable[])arg2));
            return;
        }

        this.pubInfos = null;
    }

    public ASN1Integer getAction() {
        return this.action;
    }

    public static PKIPublicationInfo getInstance(Object arg1) {
        if((arg1 instanceof PKIPublicationInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIPublicationInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public SinglePubInfo[] getPubInfos() {
        ASN1Sequence v0 = this.pubInfos;
        if(v0 == null) {
            return null;
        }

        int v0_1 = v0.size();
        SinglePubInfo[] v1 = new SinglePubInfo[v0_1];
        int v2;
        for(v2 = 0; v2 != v0_1; ++v2) {
            v1[v2] = SinglePubInfo.getInstance(this.pubInfos.getObjectAt(v2));
        }

        return v1;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        v0.add(this.action);
        ASN1Sequence v2 = this.pubInfos;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

