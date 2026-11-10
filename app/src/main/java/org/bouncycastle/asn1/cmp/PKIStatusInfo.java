package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class PKIStatusInfo extends ASN1Object {
    ASN1BitString failInfo;
    ASN1Integer status;
    PKIFreeText statusString;

    private PKIStatusInfo(ASN1Sequence arg4) {
        super();
        this.status = ASN1Integer.getInstance(arg4.getObjectAt(0));
        this.statusString = null;
        this.failInfo = null;
        int v2 = 2;
        if(arg4.size() > v2) {
            this.statusString = PKIFreeText.getInstance(arg4.getObjectAt(1));
            this.failInfo = ASN1BitString.getInstance(arg4.getObjectAt(v2));
            return;
        }

        if(arg4.size() > 1) {
            ASN1Encodable v4 = arg4.getObjectAt(1);
            if((v4 instanceof ASN1BitString)) {
                this.failInfo = ASN1BitString.getInstance(v4);
                return;
            }
            else {
                this.statusString = PKIFreeText.getInstance(v4);
            }
        }
    }

    public PKIStatusInfo(PKIStatus arg1) {
        super();
        this.status = ASN1Integer.getInstance(arg1.toASN1Primitive());
    }

    public PKIStatusInfo(PKIStatus arg1, PKIFreeText arg2) {
        super();
        this.status = ASN1Integer.getInstance(arg1.toASN1Primitive());
        this.statusString = arg2;
    }

    public PKIStatusInfo(PKIStatus arg1, PKIFreeText arg2, PKIFailureInfo arg3) {
        super();
        this.status = ASN1Integer.getInstance(arg1.toASN1Primitive());
        this.statusString = arg2;
        this.failInfo = ((ASN1BitString)arg3);
    }

    public ASN1BitString getFailInfo() {
        return this.failInfo;
    }

    public static PKIStatusInfo getInstance(Object arg1) {
        if((arg1 instanceof PKIStatusInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new PKIStatusInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public static PKIStatusInfo getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return PKIStatusInfo.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public BigInteger getStatus() {
        return this.status.getValue();
    }

    public ASN1Integer getStatusObject() {
        return this.status;
    }

    public PKIFreeText getStatusString() {
        return this.statusString;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(3);
        v0.add(this.status);
        PKIFreeText v1 = this.statusString;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        ASN1BitString v2 = this.failInfo;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

