package org.bouncycastle.asn1;

import java.util.Date;

public class DERUTCTime extends ASN1UTCTime {
    public DERUTCTime(String arg1) {
        super(arg1);
    }

    public DERUTCTime(Date arg1) {
        super(arg1);
    }

    DERUTCTime(byte[] arg1) {
        super(arg1);
    }
}

