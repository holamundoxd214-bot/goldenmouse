package org.bouncycastle.asn1.cmp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.Certificate;

public class OOBCert extends CMPCertificate {
    public OOBCert(int arg1, ASN1Object arg2) {
        super(arg1, arg2);
    }

    public OOBCert(AttributeCertificate arg2) {
        super(1, ((ASN1Object)arg2));
    }

    public OOBCert(Certificate arg1) {
        super(arg1);
    }

    public static OOBCert getInstance(Object arg3) {
        ASN1Primitive v3_1;
        if(arg3 != null) {
            if((arg3 instanceof OOBCert)) {
            }
            else if((arg3 instanceof CMPCertificate)) {
                try {
                    return OOBCert.getInstance(((CMPCertificate)arg3).getEncoded());
                }
                catch(IOException v3) {
                    throw new IllegalArgumentException(v3.getMessage(), ((Throwable)v3));
                }
            }
            else {
                if((arg3 instanceof byte[])) {
                    try {
                        v3_1 = ASN1Primitive.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException ) {
                        throw new IllegalArgumentException("Invalid encoding in OOBCert");
                    }
                }

                if((v3_1 instanceof ASN1Sequence)) {
                    return new OOBCert(Certificate.getInstance(v3_1));
                }

                if((v3_1 instanceof ASN1TaggedObject)) {
                    ASN1TaggedObject v3_2 = ASN1TaggedObject.getInstance(v3_1, 0x80);
                    return new OOBCert(v3_2.getTagNo(), v3_2.getExplicitBaseObject());
                }

                throw new IllegalArgumentException("Invalid object: " + v3_1.getClass().getName());
            }
        }

        return arg3;
    }

    public static OOBCert getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg0 != null) {
            if(arg1) {
                return OOBCert.getInstance(arg0.getExplicitBaseObject());
            }

            throw new IllegalArgumentException("tag must be explicit");
        }

        return null;
    }
}

