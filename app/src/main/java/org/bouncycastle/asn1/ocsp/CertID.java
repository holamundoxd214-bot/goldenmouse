package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertID extends ASN1Object {
    AlgorithmIdentifier hashAlgorithm;
    ASN1OctetString issuerKeyHash;
    ASN1OctetString issuerNameHash;
    ASN1Integer serialNumber;

    private CertID(ASN1Sequence arg2) {
        super();
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(arg2.getObjectAt(0));
        this.issuerNameHash = arg2.getObjectAt(1);
        this.issuerKeyHash = arg2.getObjectAt(2);
        this.serialNumber = arg2.getObjectAt(3);
    }

    public CertID(AlgorithmIdentifier arg1, ASN1OctetString arg2, ASN1OctetString arg3, ASN1Integer arg4) {
        super();
        this.hashAlgorithm = arg1;
        this.issuerNameHash = arg2;
        this.issuerKeyHash = arg3;
        this.serialNumber = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((CertID)arg5))) {
            return 1;
        }

        if((arg5 instanceof ASN1Encodable)) {
            try {
                CertID v5 = CertID.getInstance(arg5);
                if(!this.hashAlgorithm.getAlgorithm().equals(v5.hashAlgorithm.getAlgorithm())) {
                    return 0;
                }
                else if(!this.isEqual(this.hashAlgorithm.getParameters(), v5.hashAlgorithm.getParameters())) {
                    return 0;
                }
                else if((this.issuerNameHash.equals(v5.issuerNameHash)) && (this.issuerKeyHash.equals(v5.issuerKeyHash)) && (this.serialNumber.equals(v5.serialNumber))) {
                    return 1;
                }
            }
            catch(Exception ) {
            }

            return 0;
        }

        return 0;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public static CertID getInstance(ASN1TaggedObject arg0, boolean arg1) {
        return CertID.getInstance(ASN1Sequence.getInstance(arg0, arg1));
    }

    public static CertID getInstance(Object arg1) {
        if((arg1 instanceof CertID)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertID(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public ASN1OctetString getIssuerKeyHash() {
        return this.issuerKeyHash;
    }

    public ASN1OctetString getIssuerNameHash() {
        return this.issuerNameHash;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public int hashCode() {
        ASN1Encodable v0 = this.hashAlgorithm.getParameters();
        int v0_1 = v0 == null || (DERNull.INSTANCE.equals(v0)) ? 0 : v0.hashCode();
        return v0_1 + (this.hashAlgorithm.getAlgorithm().hashCode() + (this.issuerNameHash.hashCode() + (this.issuerKeyHash.hashCode() + this.serialNumber.hashCode() * 7) * 7) * 7) * 7;
    }

    private boolean isEqual(ASN1Encodable arg2, ASN1Encodable arg3) {
        if(arg2 == arg3) {
            return 1;
        }

        if(arg2 == null) {
            return DERNull.INSTANCE.equals(arg3);
        }

        if((DERNull.INSTANCE.equals(arg2)) && arg3 == null) {
            return 1;
        }

        return arg2.equals(arg3);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.hashAlgorithm);
        v0.add(this.issuerNameHash);
        v0.add(this.issuerKeyHash);
        v0.add(this.serialNumber);
        return new DERSequence(v0);
    }
}

