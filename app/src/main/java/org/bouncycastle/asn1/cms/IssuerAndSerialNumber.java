package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Name;

public class IssuerAndSerialNumber extends ASN1Object {
    private X500Name name;
    private ASN1Integer serialNumber;

    public IssuerAndSerialNumber(ASN1Sequence arg2) {
        super();
        this.name = X500Name.getInstance(arg2.getObjectAt(0));
        this.serialNumber = arg2.getObjectAt(1);
    }

    public IssuerAndSerialNumber(X500Name arg1, BigInteger arg2) {
        super();
        this.name = arg1;
        this.serialNumber = new ASN1Integer(arg2);
    }

    public IssuerAndSerialNumber(Certificate arg2) {
        super();
        this.name = arg2.getIssuer();
        this.serialNumber = arg2.getSerialNumber();
    }

    public IssuerAndSerialNumber(X509CertificateStructure arg2) {
        super();
        this.name = arg2.getIssuer();
        this.serialNumber = arg2.getSerialNumber();
    }

    public IssuerAndSerialNumber(X509Name arg1, BigInteger arg2) {
        super();
        this.name = X500Name.getInstance(arg1);
        this.serialNumber = new ASN1Integer(arg2);
    }

    public IssuerAndSerialNumber(X509Name arg1, ASN1Integer arg2) {
        super();
        this.name = X500Name.getInstance(arg1);
        this.serialNumber = arg2;
    }

    public static IssuerAndSerialNumber getInstance(Object arg1) {
        if((arg1 instanceof IssuerAndSerialNumber)) {
            return arg1;
        }

        if(arg1 != null) {
            return new IssuerAndSerialNumber(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public X500Name getName() {
        return this.name;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.name, this.serialNumber);
    }
}

