package org.bouncycastle.asn1.eac;

import java.io.UnsupportedEncodingException;

public class CertificateHolderReference {
    private static final String ReferenceEncoding = "ISO-8859-1";
    private String countryCode;
    private String holderMnemonic;
    private String sequenceNumber;

    CertificateHolderReference(byte[] arg3) {
        super();
        try {
            String v0 = new String(arg3, "ISO-8859-1");
            this.countryCode = v0.substring(0, 2);
            this.holderMnemonic = v0.substring(2, v0.length() - 5);
            this.sequenceNumber = v0.substring(v0.length() - 5);
            return;
        }
        catch(UnsupportedEncodingException v2) {
            throw new IllegalStateException(v2.toString());
        }
    }

    public CertificateHolderReference(String arg1, String arg2, String arg3) {
        super();
        this.countryCode = arg1;
        this.holderMnemonic = arg2;
        this.sequenceNumber = arg3;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public byte[] getEncoded() {
        String v2 = this.countryCode + this.holderMnemonic + this.sequenceNumber;
        try {
            return v2.getBytes("ISO-8859-1");
        }
        catch(UnsupportedEncodingException v2_1) {
            throw new IllegalStateException(v2_1.toString());
        }
    }

    public String getHolderMnemonic() {
        return this.holderMnemonic;
    }

    public String getSequenceNumber() {
        return this.sequenceNumber;
    }
}

