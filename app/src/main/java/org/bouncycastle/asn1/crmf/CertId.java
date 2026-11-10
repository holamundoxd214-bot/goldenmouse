package org.bouncycastle.asn1.crmf;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class CertId extends ASN1Object {
    private GeneralName issuer;
    private ASN1Integer serialNumber;

    private CertId(ASN1Sequence arg2) {
        super();
        this.issuer = GeneralName.getInstance(arg2.getObjectAt(0));
        this.serialNumber = ASN1Integer.getInstance(arg2.getObjectAt(1));
    }

    public CertId(GeneralName arg2, BigInteger arg3) {
        this(arg2, new ASN1Integer(arg3));
    }

    public CertId(GeneralName arg1, ASN1Integer arg2) {
        super();
        this.issuer = arg1;
        this.serialNumber = arg2;
    }

    public static CertId getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return CertId.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static CertId getInstance(Object arg1) {
        if((arg1 instanceof CertId)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertId(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public GeneralName getIssuer() {
        return this.issuer;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.issuer, this.serialNumber);
    }
}

