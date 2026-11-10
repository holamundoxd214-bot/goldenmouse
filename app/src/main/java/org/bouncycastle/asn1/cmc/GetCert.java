package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

public class GetCert extends ASN1Object {
    private final GeneralName issuerName;
    private final BigInteger serialNumber;

    private GetCert(ASN1Sequence arg3) {
        super();
        if(arg3.size() == 2) {
            this.issuerName = GeneralName.getInstance(arg3.getObjectAt(0));
            this.serialNumber = ASN1Integer.getInstance(arg3.getObjectAt(1)).getValue();
            return;
        }

        throw new IllegalArgumentException("incorrect sequence size");
    }

    public GetCert(GeneralName arg1, BigInteger arg2) {
        super();
        this.issuerName = arg1;
        this.serialNumber = arg2;
    }

    public static GetCert getInstance(Object arg1) {
        if((arg1 instanceof GetCert)) {
            return arg1;
        }

        if(arg1 != null) {
            return new GetCert(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public GeneralName getIssuerName() {
        return this.issuerName;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.issuerName, new ASN1Integer(this.serialNumber));
    }
}

