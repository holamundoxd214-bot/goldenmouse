package org.bouncycastle.asn1.icao;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DataGroupHash extends ASN1Object {
    ASN1OctetString dataGroupHashValue;
    ASN1Integer dataGroupNumber;

    public DataGroupHash(int arg4, ASN1OctetString arg5) {
        super();
        this.dataGroupNumber = new ASN1Integer(((long)arg4));
        this.dataGroupHashValue = arg5;
    }

    private DataGroupHash(ASN1Sequence arg2) {
        super();
        Enumeration v2 = arg2.getObjects();
        this.dataGroupNumber = ASN1Integer.getInstance(v2.nextElement());
        this.dataGroupHashValue = ASN1OctetString.getInstance(v2.nextElement());
    }

    public ASN1OctetString getDataGroupHashValue() {
        return this.dataGroupHashValue;
    }

    public int getDataGroupNumber() {
        return this.dataGroupNumber.intValueExact();
    }

    public static DataGroupHash getInstance(Object arg1) {
        if((arg1 instanceof DataGroupHash)) {
            return arg1;
        }

        if(arg1 != null) {
            return new DataGroupHash(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.dataGroupNumber, this.dataGroupHashValue);
    }
}

