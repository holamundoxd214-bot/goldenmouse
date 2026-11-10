package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.DirectoryString;

public class AdditionalInformationSyntax extends ASN1Object {
    private DirectoryString information;

    public AdditionalInformationSyntax(String arg2) {
        this(new DirectoryString(arg2));
    }

    private AdditionalInformationSyntax(DirectoryString arg1) {
        super();
        this.information = arg1;
    }

    public DirectoryString getInformation() {
        return this.information;
    }

    public static AdditionalInformationSyntax getInstance(Object arg1) {
        if((arg1 instanceof AdditionalInformationSyntax)) {
            return arg1;
        }

        if(arg1 != null) {
            return new AdditionalInformationSyntax(DirectoryString.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.information.toASN1Primitive();
    }
}

