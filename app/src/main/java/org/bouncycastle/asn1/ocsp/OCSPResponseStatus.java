package org.bouncycastle.asn1.ocsp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class OCSPResponseStatus extends ASN1Object {
    public static final int INTERNAL_ERROR = 2;
    public static final int MALFORMED_REQUEST = 1;
    public static final int SIG_REQUIRED = 5;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_LATER = 3;
    public static final int UNAUTHORIZED = 6;
    private ASN1Enumerated value;

    public OCSPResponseStatus(int arg2) {
        this(new ASN1Enumerated(arg2));
    }

    private OCSPResponseStatus(ASN1Enumerated arg1) {
        super();
        this.value = arg1;
    }

    public static OCSPResponseStatus getInstance(Object arg1) {
        if((arg1 instanceof OCSPResponseStatus)) {
            return arg1;
        }

        if(arg1 != null) {
            return new OCSPResponseStatus(ASN1Enumerated.getInstance(arg1));
        }

        return null;
    }

    public int getIntValue() {
        return this.value.intValueExact();
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }
}

