package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class PKIResponse extends ASN1Object {
    public static final TaggedContentInfo[] EMPTY_CMS_SEQUENCE;
    public static final OtherMsg[] EMPTY_OTHER_MSG;
    private final ASN1Sequence cmsSequence;
    private final ASN1Sequence controlSequence;
    private final ASN1Sequence otherMsgSequence;

    static {
        PKIResponse.EMPTY_CMS_SEQUENCE = new TaggedContentInfo[0];
        PKIResponse.EMPTY_OTHER_MSG = new OtherMsg[0];
    }

    private PKIResponse(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.controlSequence = ASN1Sequence.getInstance(arg3.getObjectAt(0));
            this.cmsSequence = ASN1Sequence.getInstance(arg3.getObjectAt(1));
            this.otherMsgSequence = ASN1Sequence.getInstance(arg3.getObjectAt(2));
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public PKIResponse(TaggedAttribute arg2) {
        super();
        this.controlSequence = new DERSequence(((ASN1Encodable)arg2));
        this.cmsSequence = new DERSequence();
        this.otherMsgSequence = new DERSequence();
    }

    public PKIResponse(TaggedAttribute[] arg2, TaggedContentInfo[] arg3, OtherMsg[] arg4) {
        super();
        this.controlSequence = new DERSequence(((ASN1Encodable[])arg2));
        this.cmsSequence = new DERSequence(((ASN1Encodable[])arg3));
        this.otherMsgSequence = new DERSequence(((ASN1Encodable[])arg4));
    }

    public ASN1Sequence getCmsSequence() {
        return this.cmsSequence;
    }

    public ASN1Sequence getControlSequence() {
        return this.controlSequence;
    }

    public static PKIResponse getInstance(Object arg1) {
        if((arg1 instanceof PKIResponse)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIResponse(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static PKIResponse getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return PKIResponse.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Sequence getOtherMsgSequence() {
        return this.otherMsgSequence;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.controlSequence);
        v0.add(this.cmsSequence);
        v0.add(this.otherMsgSequence);
        return new DERSequence(v0);
    }
}

