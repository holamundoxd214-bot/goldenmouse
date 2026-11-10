package org.bouncycastle.asn1.isismtt.ocsp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.util.Arrays;

public class RequestedCertificate extends ASN1Object implements ASN1Choice {
    private byte[] attributeCert;
    public static final int attributeCertificate = 1;
    private Certificate cert;
    public static final int certificate = -1;
    private byte[] publicKeyCert;
    public static final int publicKeyCertificate;

    public RequestedCertificate(int arg3, byte[] arg4) {
        this(new DERTaggedObject(arg3, new DEROctetString(arg4)));
    }

    private RequestedCertificate(ASN1TaggedObject arg3) {
        super();
        if(arg3.getTagNo() == 0) {
            this.publicKeyCert = ASN1OctetString.getInstance(arg3, true).getOctets();
            return;
        }

        if(arg3.getTagNo() == 1) {
            this.attributeCert = ASN1OctetString.getInstance(arg3, true).getOctets();
            return;
        }

        throw new IllegalArgumentException("unknown tag number: " + arg3.getTagNo());
    }

    public RequestedCertificate(Certificate arg1) {
        super();
        this.cert = arg1;
    }

    public byte[] getCertificateBytes() {
        Certificate v0 = this.cert;
        if(v0 != null) {
            try {
                return v0.getEncoded();
            }
            catch(IOException v3) {
                throw new IllegalStateException("can\'t decode certificate: " + v3);
            }
        }

        byte[] v0_1 = this.publicKeyCert;
        if(v0_1 != null) {
            return Arrays.clone(v0_1);
        }

        return Arrays.clone(this.attributeCert);
    }

    public static RequestedCertificate getInstance(Object arg3) {
        if(arg3 != null) {
            if((arg3 instanceof RequestedCertificate)) {
            }
            else if((arg3 instanceof ASN1Sequence)) {
                return new RequestedCertificate(Certificate.getInstance(arg3));
            }
            else if((arg3 instanceof ASN1TaggedObject)) {
                return new RequestedCertificate(((ASN1TaggedObject)arg3));
            }
            else {
                throw new IllegalArgumentException("illegal object in getInstance: " + arg3.getClass().getName());
            }
        }

        return arg3;
    }

    public static RequestedCertificate getInstance(ASN1TaggedObject arg0, boolean arg1) {
        if(arg1) {
            return RequestedCertificate.getInstance(arg0.getExplicitBaseObject());
        }

        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }

    public int getType() {
        if(this.cert != null) {
            return -1;
        }

        if(this.publicKeyCert != null) {
            return 0;
        }

        return 1;
    }

    public ASN1Primitive toASN1Primitive() {
        if(this.publicKeyCert != null) {
            return new DERTaggedObject(0, new DEROctetString(this.publicKeyCert));
        }

        if(this.attributeCert != null) {
            return new DERTaggedObject(1, new DEROctetString(this.attributeCert));
        }

        return this.cert.toASN1Primitive();
    }
}

