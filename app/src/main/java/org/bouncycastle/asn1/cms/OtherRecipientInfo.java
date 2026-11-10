package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class OtherRecipientInfo extends ASN1Object {
    private ASN1ObjectIdentifier oriType;
    private ASN1Encodable oriValue;

    public OtherRecipientInfo(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.oriType = arg1;
        this.oriValue = arg2;
    }

    private OtherRecipientInfo(ASN1Sequence arg2) {
        super();
        this.oriType = ASN1ObjectIdentifier.getInstance(arg2.getObjectAt(0));
        this.oriValue = arg2.getObjectAt(1);
    }

    public static OtherRecipientInfo getInstance(Object arg1) {
        if((arg1 instanceof OtherRecipientInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherRecipientInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static OtherRecipientInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return OtherRecipientInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1ObjectIdentifier getType() {
        return this.oriType;
    }

    public ASN1Encodable getValue() {
        return this.oriValue;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.oriType, this.oriValue);
    }
}

