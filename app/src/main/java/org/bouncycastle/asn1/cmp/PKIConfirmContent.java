package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;

public class PKIConfirmContent extends ASN1Object {
    private final ASN1Null val;

    public PKIConfirmContent() {
        super();
        this.val = DERNull.INSTANCE;
    }

    private PKIConfirmContent(ASN1Null arg1) {
        super();
        this.val = arg1;
    }

    public static PKIConfirmContent getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof PKIConfirmContent)) {
            }
            else if((arg3 instanceof ASN1Null)) {
                return new PKIConfirmContent(((ASN1Null)arg3));
            }
            else {
                throw new IllegalArgumentException("Invalid object: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.val;
    }
}

