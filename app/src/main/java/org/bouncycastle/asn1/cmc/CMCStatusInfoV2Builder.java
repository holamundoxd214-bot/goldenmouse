package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfoV2Builder {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private OtherStatusInfo otherInfo;
    private ASN1UTF8String statusString;

    public CMCStatusInfoV2Builder(CMCStatus arg1, BodyPartID arg2) {
        super();
        this.cMCStatus = arg1;
        this.bodyList = new DERSequence(((ASN1Encodable)arg2));
    }

    public CMCStatusInfoV2Builder(CMCStatus arg1, BodyPartID[] arg2) {
        super();
        this.cMCStatus = arg1;
        this.bodyList = new DERSequence(((ASN1Encodable[])arg2));
    }

    public CMCStatusInfoV2 build() {
        return new CMCStatusInfoV2(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
    }

    public CMCStatusInfoV2Builder setOtherInfo(CMCFailInfo arg2) {
        this.otherInfo = new OtherStatusInfo(arg2);
        return this;
    }

    public CMCStatusInfoV2Builder setOtherInfo(ExtendedFailInfo arg2) {
        this.otherInfo = new OtherStatusInfo(arg2);
        return this;
    }

    public CMCStatusInfoV2Builder setOtherInfo(PendInfo arg2) {
        this.otherInfo = new OtherStatusInfo(arg2);
        return this;
    }

    public CMCStatusInfoV2Builder setStatusString(String arg2) {
        this.statusString = new DERUTF8String(arg2);
        return this;
    }
}

