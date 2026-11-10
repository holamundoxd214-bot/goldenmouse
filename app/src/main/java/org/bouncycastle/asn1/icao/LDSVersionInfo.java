package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;

public class LDSVersionInfo extends ASN1Object {
    private ASN1PrintableString ldsVersion;
    private ASN1PrintableString unicodeVersion;

    public LDSVersionInfo(String arg2, String arg3) {
        super();
        this.ldsVersion = new DERPrintableString(arg2);
        this.unicodeVersion = new DERPrintableString(arg3);
    }

    private LDSVersionInfo(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.ldsVersion = ASN1PrintableString.getInstance(arg3.getObjectAt(0));
            this.unicodeVersion = ASN1PrintableString.getInstance(arg3.getObjectAt(1));
            return;
        }

        throw new IllegalArgumentException("sequence wrong size for LDSVersionInfo");
    }

    public static LDSVersionInfo getInstance(Object arg1) {
        if((arg1 instanceof LDSVersionInfo)) {
            return arg1;
        }

        if(arg1 != null) {
            return new LDSVersionInfo(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public String getLdsVersion() {
        return this.ldsVersion.getString();
    }

    public String getUnicodeVersion() {
        return this.unicodeVersion.getString();
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.ldsVersion, this.unicodeVersion);
    }
}

