package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class OtherMsg extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final ASN1ObjectIdentifier otherMsgType;
    private final ASN1Encodable otherMsgValue;

    private OtherMsg(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 3) {
            this.bodyPartID = BodyPartID.getInstance(arg3.getObjectAt(0));
            this.otherMsgType = ASN1ObjectIdentifier.getInstance(arg3.getObjectAt(1));
            this.otherMsgValue = arg3.getObjectAt(2);
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public OtherMsg(BodyPartID arg1, ASN1ObjectIdentifier arg2, ASN1Encodable arg3) {
        super();
        this.bodyPartID = arg1;
        this.otherMsgType = arg2;
        this.otherMsgValue = arg3;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public static OtherMsg getInstance(Object arg1) {
        if((arg1 instanceof OtherMsg)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherMsg(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static OtherMsg getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return OtherMsg.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1ObjectIdentifier getOtherMsgType() {
        return this.otherMsgType;
    }

    public ASN1Encodable getOtherMsgValue() {
        return this.otherMsgValue;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.bodyPartID);
        v0.add(this.otherMsgType);
        v0.add(this.otherMsgValue);
        return new DERSequence(v0);
    }
}

