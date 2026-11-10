package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class CMCStatusInfoBuilder {
    private final ASN1Sequence bodyList;
    private final CMCStatus cMCStatus;
    private OtherInfo otherInfo;
    private ASN1UTF8String statusString;

    public CMCStatusInfoBuilder(CMCStatus arg1, BodyPartID arg2) {
        super();
        this.cMCStatus = arg1;
        this.bodyList = new DERSequence(((ASN1Encodable)arg2));
    }

    public CMCStatusInfoBuilder(CMCStatus arg1, BodyPartID[] arg2) {
        super();
        this.cMCStatus = arg1;
        this.bodyList = new DERSequence(((ASN1Encodable[])arg2));
    }

    public CMCStatusInfo build() {
        return new CMCStatusInfo(this.cMCStatus, this.bodyList, this.statusString, this.otherInfo);
    }

    public CMCStatusInfoBuilder setOtherInfo(CMCFailInfo arg2) {
        this.otherInfo = new OtherInfo(arg2);
        return this;
    }

    public CMCStatusInfoBuilder setOtherInfo(PendInfo arg2) {
        this.otherInfo = new OtherInfo(arg2);
        return this;
    }

    public CMCStatusInfoBuilder setStatusString(String arg2) {
        this.statusString = new DERUTF8String(arg2);
        return this;
    }
}

