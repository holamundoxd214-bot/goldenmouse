package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertStatus extends ASN1Object implements ASN1Choice {
    private int tagNo;
    private ASN1Encodable value;

    public CertStatus() {
        super();
        this.tagNo = 0;
        this.value = DERNull.INSTANCE;
    }

    public CertStatus(int arg1, ASN1Encodable arg2) {
        super();
        this.tagNo = arg1;
        this.value = arg2;
    }

    private CertStatus(ASN1TaggedObject arg4) {
        RevokedInfo v4;
        super();
        int v0 = arg4.getTagNo();
        if(v0 == 0 || v0 == 2) {
            ASN1Null v4_1 = ASN1Null.getInstance(arg4, false);
        }
        else if(v0 == 1) {
            v4 = RevokedInfo.getInstance(arg4, false);
        }
        else {
            throw new IllegalArgumentException("Unknown tag encountered: " + ASN1Util.getTagText(arg4));
        }

        this.value = ((ASN1Encodable)v4);
        this.tagNo = v0;
    }

    public CertStatus(RevokedInfo arg2) {
        super();
        this.tagNo = 1;
        this.value = ((ASN1Encodable)arg2);
    }

    public static CertStatus getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof CertStatus)) {
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new CertStatus(((ASN1TaggedObject)arg3));
            }
            else {
                throw new IllegalArgumentException("unknown object in factory: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static CertStatus getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return CertStatus.getInstance(arg0.getExplicitBaseTagged());
    }

    public ASN1Encodable getStatus() {
        return this.value;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.value);
    }
}

