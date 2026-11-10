package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfo extends ASN1Object {
    public class OtherInfo extends ASN1Object implements ASN1Choice {
        private final CMCFailInfo failInfo;
        private final PendInfo pendInfo;

        OtherInfo(CMCFailInfo arg2) {
            this(arg2, null);
        }

        private OtherInfo(CMCFailInfo arg1, PendInfo arg2) {
            super();
            this.failInfo = arg1;
            this.pendInfo = arg2;
        }

        OtherInfo(PendInfo arg2) {
            this(null, arg2);
        }

        static OtherInfo access$000(Object arg0) {
            return OtherInfo.getInstance(arg0);
        }

        private static OtherInfo getInstance(Object arg3) {
            if((arg3 instanceof OtherInfo)) {
                return arg3;
            }

            if((arg3 instanceof ASN1Encodable)) {
                ASN1Primitive v0 = arg3.toASN1Primitive();
                if((v0 instanceof ASN1Integer)) {
                    return new OtherInfo(CMCFailInfo.getInstance(v0));
                }
                else if((v0 instanceof ASN1Sequence)) {
                    return new OtherInfo(PendInfo.getInstance(v0));
                }
            }

            throw new IllegalArgumentException("unknown object in getInstance(): " + arg3.getClass().getName());
        }

        public boolean isFailInfo() {
            if(this.failInfo != null) {
                return 1;
            }

            return 0;
        }

        public ASN1Primitive toASN1Primitive() {
            PendInfo v0 = this.pendInfo;
            if(v0 != null) {
                return v0.toASN1Primitive();
            }

            return this.failInfo.toASN1Primitive();
        }
    }

    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private final OtherInfo otherInfo;
    private final ASN1UTF8String statusString;

    private CMCStatusInfo(ASN1Sequence arg4) {
        super();
        int v1 = 2;
        if(arg4.size() >= v1 && arg4.size() <= 4) {
            this.cMCStatus = CMCStatus.getInstance(arg4.getObjectAt(0));
            this.bodyList = ASN1Sequence.getInstance(arg4.getObjectAt(1));
            int v2 = 3;
            if(arg4.size() > v2) {
                this.statusString = ASN1UTF8String.getInstance(arg4.getObjectAt(v1));
                this.otherInfo = OtherInfo.access$000(arg4.getObjectAt(v2));
                return;
            }
            else {
                OtherInfo v2_1 = null;
                if(arg4.size() <= v1) {
                    this.statusString = ((ASN1UTF8String)v2_1);
                    this.otherInfo = v2_1;
                    return;
                }
                else if((arg4.getObjectAt(v1) instanceof ASN1UTF8String)) {
                    this.statusString = ASN1UTF8String.getInstance(arg4.getObjectAt(v1));
                    this.otherInfo = v2_1;
                    return;
                }
                else {
                    this.statusString = ((ASN1UTF8String)v2_1);
                    this.otherInfo = OtherInfo.access$000(arg4.getObjectAt(v1));
                    return;
                }
            }
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    CMCStatusInfo(CMCStatus arg1, ASN1Sequence arg2, ASN1UTF8String arg3, OtherInfo arg4) {
        super();
        this.cMCStatus = arg1;
        this.bodyList = arg2;
        this.statusString = arg3;
        this.otherInfo = arg4;
    }

    public BodyPartID[] getBodyList() {
        return Utils.toBodyPartIDArray(this.bodyList);
    }

    public CMCStatus getCMCStatus() {
        return this.cMCStatus;
    }

    public static CMCStatusInfo getInstance(Object arg1) {
        if((arg1 instanceof CMCStatusInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CMCStatusInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OtherInfo getOtherInfo() {
        return this.otherInfo;
    }

    public DERUTF8String getStatusString() {
        ASN1UTF8String v0 = this.statusString;
        if(v0 != null) {
            if((v0 instanceof DERUTF8String)) {
            }
            else {
                return new DERUTF8String(this.statusString.getString());
            }
        }

        return ((DERUTF8String)v0);
    }

    public ASN1UTF8String getStatusStringUTF8() {
        return this.statusString;
    }

    public boolean hasOtherInfo() {
        if(this.otherInfo != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.cMCStatus);
        v0.add(this.bodyList);
        ASN1UTF8String v1 = this.statusString;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        OtherInfo v2 = this.otherInfo;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

