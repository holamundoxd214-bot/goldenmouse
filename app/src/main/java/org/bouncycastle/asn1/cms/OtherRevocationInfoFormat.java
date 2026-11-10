package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class OtherRevocationInfoFormat extends ASN1Object {
    private ASN1Encodable otherRevInfo;
    private ASN1ObjectIdentifier otherRevInfoFormat;

    public OtherRevocationInfoFormat(ASN1ObjectIdentifier arg1, ASN1Encodable arg2) {
        super();
        this.otherRevInfoFormat = arg1;
        this.otherRevInfo = arg2;
    }

    private OtherRevocationInfoFormat(ASN1Sequence arg2) {
        super();
        this.otherRevInfoFormat = ASN1ObjectIdentifier.getInstance(arg2.getObjectAt(0));
        this.otherRevInfo = arg2.getObjectAt(1);
    }

    public ASN1Encodable getInfo() {
        return this.otherRevInfo;
    }

    public ASN1ObjectIdentifier getInfoFormat() {
        return this.otherRevInfoFormat;
    }

    public static OtherRevocationInfoFormat getInstance(Object arg1) {
        if((arg1 instanceof OtherRevocationInfoFormat)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OtherRevocationInfoFormat(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static OtherRevocationInfoFormat getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return OtherRevocationInfoFormat.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.otherRevInfoFormat, this.otherRevInfo);
    }
}

