package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PKIData extends ASN1Object {
    private final TaggedContentInfo[] cmsSequence;
    private final TaggedAttribute[] controlSequence;
    private final OtherMsg[] otherMsgSequence;
    private final TaggedRequest[] reqSequence;

    private PKIData(ASN1Sequence arg6) {
        super();
        if(arg6.size() == 4) {
            int v0 = 0;
            ASN1Encodable v1 = arg6.getObjectAt(0);
            this.controlSequence = new TaggedAttribute[((ASN1Sequence)v1).size()];
            int v2;
            for(v2 = 0; true; ++v2) {
                TaggedAttribute[] v3 = this.controlSequence;
                if(v2 >= v3.length) {
                    break;
                }

                v3[v2] = TaggedAttribute.getInstance(((ASN1Sequence)v1).getObjectAt(v2));
            }

            v1 = arg6.getObjectAt(1);
            this.reqSequence = new TaggedRequest[((ASN1Sequence)v1).size()];
            for(v2 = 0; true; ++v2) {
                TaggedRequest[] v3_1 = this.reqSequence;
                if(v2 >= v3_1.length) {
                    break;
                }

                v3_1[v2] = TaggedRequest.getInstance(((ASN1Sequence)v1).getObjectAt(v2));
            }

            v1 = arg6.getObjectAt(2);
            this.cmsSequence = new TaggedContentInfo[((ASN1Sequence)v1).size()];
            for(v2 = 0; true; ++v2) {
                TaggedContentInfo[] v3_2 = this.cmsSequence;
                if(v2 >= v3_2.length) {
                    break;
                }

                v3_2[v2] = TaggedContentInfo.getInstance(((ASN1Sequence)v1).getObjectAt(v2));
            }

            ASN1Encodable v6 = arg6.getObjectAt(3);
            this.otherMsgSequence = new OtherMsg[((ASN1Sequence)v6).size()];
            while(true) {
                OtherMsg[] v1_1 = this.otherMsgSequence;
                if(v0 >= v1_1.length) {
                    return;
                }

                v1_1[v0] = OtherMsg.getInstance(((ASN1Sequence)v6).getObjectAt(v0));
                ++v0;
            }

            return;
        }

        throw new IllegalArgumentException("Sequence not 4 elements.");
    }

    public PKIData(TaggedAttribute[] arg1, TaggedRequest[] arg2, TaggedContentInfo[] arg3, OtherMsg[] arg4) {
        super();
        this.controlSequence = this.copy(arg1);
        this.reqSequence = this.copy(arg2);
        this.cmsSequence = this.copy(arg3);
        this.otherMsgSequence = this.copy(arg4);
    }

    private TaggedAttribute[] copy(TaggedAttribute[] arg3) {
        int v2 = arg3.length;
        TaggedAttribute[] v0 = new TaggedAttribute[v2];
        System.arraycopy(arg3, 0, v0, 0, v2);
        return v0;
    }

    private TaggedRequest[] copy(TaggedRequest[] arg3) {
        int v2 = arg3.length;
        TaggedRequest[] v0 = new TaggedRequest[v2];
        System.arraycopy(arg3, 0, v0, 0, v2);
        return v0;
    }

    private TaggedContentInfo[] copy(TaggedContentInfo[] arg3) {
        int v2 = arg3.length;
        TaggedContentInfo[] v0 = new TaggedContentInfo[v2];
        System.arraycopy(arg3, 0, v0, 0, v2);
        return v0;
    }

    private OtherMsg[] copy(OtherMsg[] arg3) {
        int v2 = arg3.length;
        OtherMsg[] v0 = new OtherMsg[v2];
        System.arraycopy(arg3, 0, v0, 0, v2);
        return v0;
    }

    public TaggedContentInfo[] getCmsSequence() {
        return this.copy(this.cmsSequence);
    }

    public TaggedAttribute[] getControlSequence() {
        return this.copy(this.controlSequence);
    }

    public static PKIData getInstance(Object arg1) {
        if((arg1 instanceof PKIData)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIData(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OtherMsg[] getOtherMsgSequence() {
        return this.copy(this.otherMsgSequence);
    }

    public TaggedRequest[] getReqSequence() {
        return this.copy(this.reqSequence);
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{new DERSequence(this.controlSequence), new DERSequence(this.reqSequence), new DERSequence(this.cmsSequence), new DERSequence(this.otherMsgSequence)});
    }
}

