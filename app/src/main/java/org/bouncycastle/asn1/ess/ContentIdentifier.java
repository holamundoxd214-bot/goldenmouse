package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

public class ContentIdentifier extends ASN1Object {
    ASN1OctetString value;

    private ContentIdentifier(ASN1OctetString arg1) {
        super();
        this.value = arg1;
    }

    public ContentIdentifier(byte[] arg2) {
        this(new DEROctetString(arg2));
    }

    public static ContentIdentifier getInstance(Object arg1) {
        if((arg1 instanceof ContentIdentifier)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ContentIdentifier(ASN1OctetString.getInstance(arg1));
        }

        return null;
    }

    public ASN1OctetString getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}

