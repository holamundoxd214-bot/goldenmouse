package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class BodyPartID extends ASN1Object {
    public static final long bodyIdMax = 0xFFFFFFFFL;
    private final long id;

    public BodyPartID(long arg3) {
        super();
        if(arg3 >= 0 && arg3 <= 0xFFFFFFFFL) {
            this.id = arg3;
            return;
        }

        throw new IllegalArgumentException("id out of range");
    }

    private BodyPartID(ASN1Integer arg3) {
        this(BodyPartID.convert(arg3.getValue()));
    }

    private static long convert(BigInteger arg2) {
        if(arg2.bitLength() <= 0x20) {
            return arg2.longValue();
        }

        throw new IllegalArgumentException("id out of range");
    }

    public long getID() {
        return this.id;
    }

    public static BodyPartID getInstance(Object arg1) {
        if((arg1 instanceof BodyPartID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new BodyPartID(ASN1Integer.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.id);
    }
}

