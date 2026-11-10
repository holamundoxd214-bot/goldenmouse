package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Integer;

public class SubsequentMessage extends ASN1Integer {
    public static final SubsequentMessage challengeResp;
    public static final SubsequentMessage encrCert;

    static {
        SubsequentMessage.encrCert = new SubsequentMessage(0);
        SubsequentMessage.challengeResp = new SubsequentMessage(1);
    }

    private SubsequentMessage(int arg3) {
        super(((long)arg3));
    }

    public static SubsequentMessage valueOf(int arg3) {
        if(arg3 == 0) {
            return SubsequentMessage.encrCert;
        }

        if(arg3 == 1) {
            return SubsequentMessage.challengeResp;
        }

        throw new IllegalArgumentException("unknown value: " + arg3);
    }
}

