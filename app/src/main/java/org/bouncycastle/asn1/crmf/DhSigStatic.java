package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.util.Arrays;

public class DhSigStatic extends ASN1Object {
    private final ASN1OctetString hashValue;
    private final IssuerAndSerialNumber issuerAndSerial;

    private DhSigStatic(ASN1Sequence arg5) {
        ASN1Encodable v5;
        super();
        if(arg5.size() == 1) {
            this.issuerAndSerial = null;
            v5 = arg5.getObjectAt(0);
        }
        else if(arg5.size() == 2) {
            this.issuerAndSerial = IssuerAndSerialNumber.getInstance(arg5.getObjectAt(0));
            v5 = arg5.getObjectAt(1);
        }
        else {
            goto label_19;
        }

        this.hashValue = ASN1OctetString.getInstance(v5);
        return;
    label_19:
        throw new IllegalArgumentException("sequence wrong length for DhSigStatic");
    }

    public DhSigStatic(IssuerAndSerialNumber arg1, byte[] arg2) {
        super();
        this.issuerAndSerial = arg1;
        this.hashValue = new DEROctetString(Arrays.clone(arg2));
    }

    public DhSigStatic(byte[] arg2) {
        this(null, arg2);
    }

    public byte[] getHashValue() {
        return Arrays.clone(this.hashValue.getOctets());
    }

    public static DhSigStatic getInstance(Object arg1) {
        if((arg1 instanceof DhSigStatic)) {
            return arg1;
        }

        if(arg1 != null) {
            return new DhSigStatic(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public IssuerAndSerialNumber getIssuerAndSerial() {
        return this.issuerAndSerial;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(2);
        IssuerAndSerialNumber v1 = this.issuerAndSerial;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        v0.add(this.hashValue);
        return new DERSequence(v0);
    }
}

