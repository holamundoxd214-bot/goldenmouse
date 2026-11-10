package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ResponseBytes extends ASN1Object {
    ASN1OctetString response;
    ASN1ObjectIdentifier responseType;

    public ResponseBytes(ASN1ObjectIdentifier arg1, ASN1OctetString arg2) {
        super();
        this.responseType = arg1;
        this.response = arg2;
    }

    private ResponseBytes(ASN1Sequence arg2) {
        super();
        this.responseType = arg2.getObjectAt(0);
        this.response = arg2.getObjectAt(1);
    }

    public static ResponseBytes getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return ResponseBytes.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static ResponseBytes getInstance(Object arg1) {
        if((arg1 instanceof ResponseBytes)) {
            return arg1;
        }

        if(arg1 != null) {
            return new ResponseBytes(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1OctetString getResponse() {
        return this.response;
    }

    public ASN1ObjectIdentifier getResponseType() {
        return this.responseType;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.responseType, this.response);
    }
}

