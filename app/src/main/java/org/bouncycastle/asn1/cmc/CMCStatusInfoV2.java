package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfoV2 extends ASN1Object {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private final OtherStatusInfo otherStatusInfo;
    private final ASN1UTF8String statusString;

    private CMCStatusInfoV2(ASN1Sequence arg5) {
        super();
        int v1 = 2;
        if(arg5.size() >= v1) {
            int v2 = 4;
            if(arg5.size() <= v2) {
                this.cMCStatus = CMCStatus.getInstance(arg5.getObjectAt(0));
                this.bodyList = ASN1Sequence.getInstance(arg5.getObjectAt(1));
                OtherStatusInfo v3 = null;
                if(arg5.size() <= v1) {
                    this.statusString = ((ASN1UTF8String)v3);
                    this.otherStatusInfo = v3;
                    return;
                }
                else if(arg5.size() == v2) {
                    this.statusString = ASN1UTF8String.getInstance(arg5.getObjectAt(v1));
                    this.otherStatusInfo = OtherStatusInfo.getInstance(arg5.getObjectAt(3));
                    return;
                }
                else if((arg5.getObjectAt(v1) instanceof ASN1UTF8String)) {
                    this.statusString = ASN1UTF8String.getInstance(arg5.getObjectAt(v1));
                    this.otherStatusInfo = v3;
                    return;
                }
                else {
                    this.statusString = ((ASN1UTF8String)v3);
                    this.otherStatusInfo = OtherStatusInfo.getInstance(arg5.getObjectAt(v1));
                    return;
                }
            }
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    CMCStatusInfoV2(CMCStatus arg1, ASN1Sequence arg2, ASN1UTF8String arg3, OtherStatusInfo arg4) {
        super();
        this.cMCStatus = arg1;
        this.bodyList = arg2;
        this.statusString = arg3;
        this.otherStatusInfo = arg4;
    }

    public BodyPartID[] getBodyList() {
        return Utils.toBodyPartIDArray(this.bodyList);
    }

    public CMCStatus getCMCStatus() {
        return this.cMCStatus;
    }

    public static CMCStatusInfoV2 getInstance(Object arg1) {
        if((arg1 instanceof CMCStatusInfoV2)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CMCStatusInfoV2(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public OtherStatusInfo getOtherStatusInfo() {
        return this.otherStatusInfo;
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

    public CMCStatus getcMCStatus() {
        return this.cMCStatus;
    }

    public boolean hasOtherInfo() {
        if(this.otherStatusInfo != null) {
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

        OtherStatusInfo v2 = this.otherStatusInfo;
        if(v2 != null) {
            v0.add(((ASN1Encodable)v2));
        }

        return new DERSequence(v0);
    }
}

