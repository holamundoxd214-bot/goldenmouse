package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1Util;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertStatus extends ASN1Object {
    private final ASN1OctetString certHash;
    private final ASN1Integer certReqId;
    private final AlgorithmIdentifier hashAlg;
    private final PKIStatusInfo statusInfo;

    private CertStatus(ASN1Sequence arg8) {
        AlgorithmIdentifier v2;
        super();
        this.certHash = ASN1OctetString.getInstance(arg8.getObjectAt(0));
        this.certReqId = ASN1Integer.getInstance(arg8.getObjectAt(1));
        PKIStatusInfo v3 = null;
        int v4 = 2;
        if(arg8.size() > v4) {
            v2 = ((AlgorithmIdentifier)v3);
            while(v4 < arg8.size()) {
                ASN1Primitive v5 = arg8.getObjectAt(v4).toASN1Primitive();
                if((v5 instanceof ASN1Sequence)) {
                    v3 = PKIStatusInfo.getInstance(v5);
                }

                if((v5 instanceof ASN1TaggedObject)) {
                    if(((ASN1TaggedObject)v5).hasContextTag(0)) {
                        v2 = AlgorithmIdentifier.getInstance(((ASN1TaggedObject)v5), true);
                    }
                    else {
                        throw new IllegalArgumentException("unknown tag " + ASN1Util.getTagText(((ASN1TaggedObject)v5)));
                    }
                }

                ++v4;
            }
        }
        else {
            v2 = ((AlgorithmIdentifier)v3);
        }

        this.statusInfo = v3;
        this.hashAlg = v2;
    }

    public CertStatus(byte[] arg2, BigInteger arg3) {
        this(arg2, new ASN1Integer(arg3));
    }

    public CertStatus(byte[] arg2, ASN1Integer arg3) {
        super();
        this.certHash = new DEROctetString(arg2);
        this.certReqId = arg3;
        this.statusInfo = null;
        this.hashAlg = null;
    }

    public CertStatus(byte[] arg2, BigInteger arg3, PKIStatusInfo arg4) {
        super();
        this.certHash = new DEROctetString(arg2);
        this.certReqId = new ASN1Integer(arg3);
        this.statusInfo = arg4;
        this.hashAlg = null;
    }

    public CertStatus(byte[] arg2, BigInteger arg3, PKIStatusInfo arg4, AlgorithmIdentifier arg5) {
        super();
        this.certHash = new DEROctetString(arg2);
        this.certReqId = new ASN1Integer(arg3);
        this.statusInfo = arg4;
        this.hashAlg = arg5;
    }

    public ASN1OctetString getCertHash() {
        return this.certHash;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public AlgorithmIdentifier getHashAlg() {
        return this.hashAlg;
    }

    public static CertStatus getInstance(Object arg1) {
        if((arg1 instanceof CertStatus)) {
            return arg1;
        }

        if(arg1 != null) {
            return new CertStatus(ASN1Sequence.getInstance(arg1));
        }

        return null;
    }

    public PKIStatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v0 = new ASN1EncodableVector(4);
        v0.add(this.certHash);
        v0.add(this.certReqId);
        PKIStatusInfo v1 = this.statusInfo;
        if(v1 != null) {
            v0.add(((ASN1Encodable)v1));
        }

        if(this.hashAlg != null) {
            v0.add(new DERTaggedObject(true, 0, this.hashAlg));
        }

        return new DERSequence(v0);
    }
}

