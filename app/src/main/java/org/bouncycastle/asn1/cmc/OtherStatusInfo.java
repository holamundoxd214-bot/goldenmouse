package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class OtherStatusInfo extends ASN1Object implements ASN1Choice {
    private final ExtendedFailInfo extendedFailInfo;
    private final CMCFailInfo failInfo;
    private final PendInfo pendInfo;

    OtherStatusInfo(CMCFailInfo arg2) {
        this(arg2, null, null);
    }

    OtherStatusInfo(ExtendedFailInfo arg2) {
        this(null, null, arg2);
    }

    OtherStatusInfo(PendInfo arg2) {
        this(null, arg2, null);
    }

    private OtherStatusInfo(CMCFailInfo arg1, PendInfo arg2, ExtendedFailInfo arg3) {
        super();
        this.failInfo = arg1;
        this.pendInfo = arg2;
        this.extendedFailInfo = arg3;
    }

    public static OtherStatusInfo getInstance(Object arg3) {
        if((arg3 instanceof OtherStatusInfo)) {
            return arg3;
        }

        if((arg3 instanceof ASN1Encodable)) {
            ASN1Primitive v0 = arg3.toASN1Primitive();
            if((v0 instanceof ASN1Integer)) {
                return new OtherStatusInfo(CMCFailInfo.getInstance(v0));
            }
            else if((v0 instanceof ASN1Sequence)) {
                if((v0.getObjectAt(0) instanceof ASN1ObjectIdentifier)) {
                    return new OtherStatusInfo(ExtendedFailInfo.getInstance(v0));
                }
                else {
                    return new OtherStatusInfo(PendInfo.getInstance(v0));
                }
            }
        }
        else if((arg3 instanceof byte[])) {
            try {
                return OtherStatusInfo.getInstance(ASN1Primitive.fromByteArray(((byte[])arg3)));
            }
            catch(IOException v3) {
                throw new IllegalArgumentException("parsing error: " + v3.getMessage());
            }
        }

        throw new IllegalArgumentException("unknown object in getInstance(): " + arg3.getClass().getName());
    }

    public boolean isExtendedFailInfo() {
        if(this.extendedFailInfo != null) {
            return 1;
        }

        return 0;
    }

    public boolean isFailInfo() {
        if(this.failInfo != null) {
            return 1;
        }

        return 0;
    }

    public boolean isPendingInfo() {
        if(this.pendInfo != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        PendInfo v0 = this.pendInfo;
        if(v0 != null) {
            return v0.toASN1Primitive();
        }

        CMCFailInfo v0_1 = this.failInfo;
        if(v0_1 != null) {
            return v0_1.toASN1Primitive();
        }

        return this.extendedFailInfo.toASN1Primitive();
    }
}

