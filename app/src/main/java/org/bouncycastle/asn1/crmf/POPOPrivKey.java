package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

public class POPOPrivKey extends ASN1Object implements ASN1Choice {
    public static final int agreeMAC = 3;
    public static final int dhMAC = 2;
    public static final int encryptedKey = 4;
    private ASN1Encodable obj;
    public static final int subsequentMessage = 1;
    private int tagNo;
    public static final int thisMessage;

    private POPOPrivKey(ASN1TaggedObject arg4) {
        EnvelopedData v4;
        super();
        int v0 = arg4.getTagNo();
        this.tagNo = v0;
        if(v0 == 0 || v0 == 2) {
            ASN1BitString v4_3 = ASN1BitString.getInstance(arg4, false);
        }
        else if(v0 == 1) {
            SubsequentMessage v4_2 = SubsequentMessage.valueOf(ASN1Integer.getInstance(arg4, false).intValueExact());
        }
        else if(v0 == 3) {
            PKMACValue v4_1 = PKMACValue.getInstance(arg4, false);
        }
        else if(v0 == 4) {
            v4 = EnvelopedData.getInstance(arg4, false);
        }
        else {
            throw new IllegalArgumentException("unknown tag in POPOPrivKey");
        }

        this.obj = ((ASN1Encodable)v4);
    }

    public POPOPrivKey(PKMACValue arg2) {
        super();
        this.tagNo = 3;
        this.obj = ((ASN1Encodable)arg2);
    }

    public POPOPrivKey(SubsequentMessage arg2) {
        super();
        this.tagNo = 1;
        this.obj = ((ASN1Encodable)arg2);
    }

    public static POPOPrivKey getInstance(Object arg1) {
        if((arg1 instanceof POPOPrivKey)) {
            return arg1;
        }

        if(arg1 != null) {
            return new POPOPrivKey(ASN1TaggedObject.getInstance(arg1));
        }

        return null;
    }

    public static POPOPrivKey getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return POPOPrivKey.getInstance(ASN1TaggedObject.getInstance(arg0, true));
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.obj;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}

