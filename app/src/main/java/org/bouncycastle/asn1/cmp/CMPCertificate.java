package org.bouncycastle.asn1.cmp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.Certificate;

public class CMPCertificate extends ASN1Object implements ASN1Choice {
    private ASN1Object otherCert;
    private int otherTagValue;
    private Certificate x509v3PKCert;

    public CMPCertificate(int arg1, ASN1Object arg2) {
        super();
        this.otherTagValue = arg1;
        this.otherCert = arg2;
    }

    public CMPCertificate(AttributeCertificate arg2) {
        this(1, ((ASN1Object)arg2));
    }

    public CMPCertificate(Certificate arg3) {
        super();
        if(arg3.getVersionNumber() == 3) {
            this.x509v3PKCert = arg3;
            return;
        }

        throw new IllegalArgumentException("only version 3 certificates allowed");
    }

    public static CMPCertificate getInstance(Object arg3) {
        ASN1Primitive v3;
        if(arg3 != null) {
            if((arg3 instanceof CMPCertificate)) {
            }
            else {
                if((arg3 instanceof byte[])) {
                    try {
                        v3 = ASN1Primitive.fromByteArray(((byte[])arg3));
                    }
                    catch(IOException ) {
                        throw new IllegalArgumentException("Invalid encoding in CMPCertificate");
                    }
                }

                if((v3 instanceof ASN1Sequence)) {
                    return new CMPCertificate(Certificate.getInstance(v3));
                }

                if((v3 instanceof ASN1TaggedObject)) {
                    ASN1TaggedObject v3_1 = ASN1TaggedObject.getInstance(v3, 0x80);
                    return new CMPCertificate(v3_1.getTagNo(), v3_1.getBaseObject());
                }

                throw new IllegalArgumentException("Invalid object: " + v3.getClass().getName());
            }
        }

        return arg3;
    }

    public static CMPCertificate getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg0 != null) {
            if(arg1) {
                return CMPCertificate.getInstance(arg0.getExplicitBaseObject());
            }

            throw new IllegalArgumentException("tag must be explicit");
        }

        return null;
    }

    public ASN1Object getOtherCert() {
        return this.otherCert;
    }

    public int getOtherCertTag() {
        return this.otherTagValue;
    }

    public AttributeCertificate getX509v2AttrCert() {
        return AttributeCertificate.getInstance(this.otherCert);
    }

    public Certificate getX509v3PKCert() {
        return this.x509v3PKCert;
    }

    public boolean isX509v3PKCert() {
        if(this.x509v3PKCert != null) {
            return 1;
        }

        return 0;
    }

    public ASN1Primitive toASN1Primitive() {
        if(this.otherCert != null) {
            return new DERTaggedObject(true, this.otherTagValue, this.otherCert);
        }

        return this.x509v3PKCert.toASN1Primitive();
    }
}

